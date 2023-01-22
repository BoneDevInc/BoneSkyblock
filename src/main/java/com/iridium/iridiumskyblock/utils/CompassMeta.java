package com.iridium.iridiumskyblock.utils;

import com.iridium.iridiumskyblock.IridiumSkyblock;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.logging.Logger;

public class CompassMeta {
    public void IslandMenuCompass(Player player){

        IridiumSkyblock.getInstance().getLogger().info("PlayerCompassMeta "+ player.getName());

        PlayerInventory inventory = player.getInventory();
        ItemStack compass = new ItemStack(Material.COMPASS);
        ItemMeta meta = compass.getItemMeta();
        meta.setDisplayName("Island Menu");
        meta.addEnchant(Enchantment.ARROW_DAMAGE,1,true);
        meta.setUnbreakable(true);
        compass.setItemMeta(meta);
        inventory.setItem(8, compass);
    }
}
