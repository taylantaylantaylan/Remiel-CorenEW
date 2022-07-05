package me.taylan.mooncore.listeners;

import me.taylan.mooncore.MoonCore;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemDamageEvent;

public class ItemDamageListener implements Listener {

    private MoonCore plugin;

    public ItemDamageListener(MoonCore plugin) {
        this.plugin = plugin;
        Bukkit.getServer().getPluginManager().registerEvents(this,plugin);
    }
   @EventHandler
    public void itemdamage(PlayerItemDamageEvent event) {
        Player player = event.getPlayer();
        if(event.getItem().hasItemMeta() && event.getItem().getItemMeta().getDisplayName().contains("[T1]")) {

        }
    }
}
