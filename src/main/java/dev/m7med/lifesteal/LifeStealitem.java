package dev.m7med.lifesteal;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.List;

public class LifeStealitem {
    ConfigManger config = LifeSteal.getInstance().getConfigManger();


    public ItemStack build(){
        ItemStack item =new ItemStack(config.getMaterial());
        ItemMeta meta = item.getItemMeta();
        meta.displayName(config.getDisplayName());
        meta.lore(config.getLoreList());
        meta.getPersistentDataContainer().set(LifeSteal.getInstance().key, PersistentDataType.BOOLEAN,true);
        if(config.isEnchanted()){
            List<String> enchantments = config.getEnchantments();
            for (String enchantLine : enchantments) {
                String[] parts = enchantLine.split(":");
                if (parts.length == 2) {
                    String enchantName = parts[0].toUpperCase();
                    int level= Integer.parseInt(parts[1]);
                    Enchantment enchant = Enchantment.getByName(enchantName);
                    if (enchant != null) {
                        meta.addEnchant(enchant, level, true);
                    }
                }

            }}
        item.setItemMeta(meta);
        return item;
    }
}
