package dev.m7med.lifesteal;

import dev.velix.imperat.BukkitImperat;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

public final class LifeSteal extends JavaPlugin {
    private static LifeSteal instance;
    private ConfigManger configManger;
    private LifeStealitem customItem;
    public NamespacedKey key ;
    private BukkitImperat imperat;

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        instance = this;
        configManger = new ConfigManger();
        customItem = new LifeStealitem();
        key = new NamespacedKey(LifeSteal.getInstance(), "lifeStealitem");
        imperat = BukkitImperat.builder(this).build();
        imperat.registerCommand(new GiveCommand());
        Bukkit.getPluginManager().registerEvents(new DamageListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public static LifeSteal getInstance() {
        return instance;
    }
    public ConfigManger getConfigManger() {
        return configManger;
    }
    public LifeStealitem getCustomItem() {
        return customItem;
    }
}
