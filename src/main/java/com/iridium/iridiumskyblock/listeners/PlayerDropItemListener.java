package com.iridium.iridiumskyblock.listeners;

import com.iridium.iridiumcore.utils.StringUtils;
import com.iridium.iridiumskyblock.IridiumSkyblock;
import com.iridium.iridiumskyblock.PermissionType;
import com.iridium.iridiumskyblock.database.Island;
import com.iridium.iridiumskyblock.utils.CompassMeta;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.Optional;

public class PlayerDropItemListener implements Listener {
    CompassMeta compassMeta = new CompassMeta();
    @EventHandler(ignoreCancelled = true)
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        Optional<Island> island = IridiumSkyblock.getInstance().getIslandManager().getIslandViaLocation(event.getItemDrop().getLocation());
        ItemStack item = event.getItemDrop().getItemStack();

        Player player = event.getPlayer();
        IridiumSkyblock.getInstance().getLogger().info("PlayerDropItem "+ player.getName());

        if (item.getType() == Material.COMPASS && item.hasItemMeta() && item.containsEnchantment(Enchantment.ARROW_DAMAGE)) {
            event.setCancelled(true);
        }

        if (!island.isPresent()) return;

        if (IridiumSkyblock.getInstance().getIslandManager().getIslandPermission(island.get(), IridiumSkyblock.getInstance().getUserManager().getUser(event.getPlayer()), PermissionType.DROP_ITEMS)) {
            return;
        }

        event.setCancelled(true);
        event.getPlayer().sendMessage(StringUtils.color(IridiumSkyblock.getInstance().getMessages().cannotDropItems.replace("%prefix%", IridiumSkyblock.getInstance().getConfiguration().prefix)));
    }

}
