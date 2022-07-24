package me.taylan.mooncore.listeners;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.Painter;
import me.taylan.mooncore.utils.StatsManager;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

public class RequirementListener implements Listener {

    private MoonCore main;
    private StatsManager statsManager;

    public RequirementListener(MoonCore main) {
        this.main = main;
        this.statsManager = main.getStatsManager();
        Bukkit.getServer().getPluginManager().registerEvents(this, main);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void levellisten(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        NamespacedKey lvlrequirement = new NamespacedKey(main, "lvlrequirement");
        ItemStack item = event.getItem();
        if(item != null && item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
            if(item.getItemMeta().getPersistentDataContainer().has(lvlrequirement)) {
                if(!(statsManager.getLevel(player.getUniqueId()) >= item.getItemMeta().getPersistentDataContainer().get(lvlrequirement, PersistentDataType.INTEGER))) {

                    event.setCancelled(true);
                    player.sendMessage(Painter.paint("&cSeviyen ekipmanı kullanmak için gereken seviyeden düşük!"));

                }
            }
        }

    }
    @EventHandler(priority = EventPriority.LOWEST)
    public void levellisten(BlockBreakEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getPlayer().getInventory().getItemInMainHand();
        NamespacedKey lvlrequirement = new NamespacedKey(main, "lvlrequirement");
        if(item != null && item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
            if(item.getItemMeta().getPersistentDataContainer().has(lvlrequirement)) {
                if(!(statsManager.getLevel(player.getUniqueId()) >= item.getItemMeta().getPersistentDataContainer().get(lvlrequirement, PersistentDataType.INTEGER))) {

                    event.setCancelled(true);
                    player.sendMessage(Painter.paint("&cSeviyen ekipmanı kullanmak için gereken seviyeden düşük!"));

                }
            }
        }

    }

}
