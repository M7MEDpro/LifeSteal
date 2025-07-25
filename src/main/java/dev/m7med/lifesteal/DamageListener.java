package dev.m7med.lifesteal;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DamageListener implements Listener {
    @EventHandler
    public void damgeEvent(EntityDamageByEntityEvent event) {
        Entity damager = event.getDamager();
        if(!(damager instanceof Player)) return;
        ItemStack item = ((Player) damager).getItemInHand();
        if (item == null || item.getType() == Material.AIR || !item.hasItemMeta()) return;
        PersistentDataContainer container = item.getItemMeta().getPersistentDataContainer();
        if(container.has(LifeSteal.getInstance().key, PersistentDataType.BOOLEAN)){
            if(LifeStealChance()){
               Player player = ((Player)damager);
                int damageamount = (int)event.getDamage();
                double health = player.getHealth();
                player.setHealth(Math.min(player.getMaxHealth(), health-damageamount));
                Map<String, String> placeholders = new HashMap<>();
                placeholders.put("damager", event.getDamager().getName());
                placeholders.put("amount", String.valueOf(damageamount));
                placeholders.put("damaged", event.getEntity().getName());
                placeholders.put("oldhealth", String.valueOf(health));

                player.sendActionBar(LifeSteal.getInstance().getConfigManger()
                        .get("heal-alert",placeholders,"<green>You were healed by <red>%amount% <green>hearts!")

                );
            }


        }

    }
    public boolean LifeStealChance(){
        Random random = new Random();
        return random.nextDouble() < LifeSteal.getInstance().getConfigManger().getLifeStealPercent();
    }
}

