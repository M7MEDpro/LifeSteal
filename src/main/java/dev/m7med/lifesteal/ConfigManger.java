package dev.m7med.lifesteal;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;
import java.util.Map;

public class ConfigManger {
    private final FileConfiguration config = LifeSteal.getInstance().getConfig();
    private final MiniMessage mini = MiniMessage.miniMessage();

    private final Material material = Material.getMaterial(config.getString("Material", "DIAMOND_SWORD"));
    private final Component displayName = mini.deserialize(config.getString("Display-Name", "<light_purple>LifeSteal"));

    private final boolean isEnchanted = config.getBoolean("isEnchanted");
    private final List<String> enchantments = config.getStringList("Enchantments");
    private final double lifeStealPercent = config.getDouble("lifeStealPercent", 15);

    private final List<Component> loreList = config.getStringList("Lore").stream()
            .map(line -> line.replace("{lifeStealPercent}", String.valueOf(getLifeStealPercent()*100)))
            .map(mini::deserialize)
            .toList();

    public Material getMaterial() {
        return material;
    }

    public Component getDisplayName() {
        return displayName;
    }

    public List<Component> getLoreList() {
        return loreList;
    }



    public boolean isEnchanted() {
        return isEnchanted;
    }

    public List<String> getEnchantments() {
        return enchantments;
    }

   public double getLifeStealPercent() {
        return lifeStealPercent/100;
   }
    public Component get(String key, Map<String, String> placeholders, String defaultMessage) {

        String raw = config.getString("messages." + key, defaultMessage);

        for(Map.Entry<String, String> entry : placeholders.entrySet()) {
            raw = raw.replace("%" + (String)entry.getKey() + "%", (CharSequence)entry.getValue());
        }

        return MiniMessage.miniMessage().deserialize(raw);
    }
}

