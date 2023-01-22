package com.iridium.iridiumskyblock.listeners;

import com.iridium.iridiumcore.utils.StringUtils;
import com.iridium.iridiumskyblock.IridiumSkyblock;
import com.iridium.iridiumskyblock.database.User;
import com.iridium.iridiumskyblock.utils.CompassMeta;
import com.iridium.iridiumskyblock.utils.PlayerUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerChangeWorldListener implements Listener {

    CompassMeta compassMeta = new CompassMeta();

    @EventHandler
    public void onChangeWorld(PlayerChangedWorldEvent event) {

        Player player = event.getPlayer();
        IridiumSkyblock.getInstance().getLogger().info("PlayerChangeWorld " + player.getName());

        compassMeta.IslandMenuCompass(player);
    }
}
