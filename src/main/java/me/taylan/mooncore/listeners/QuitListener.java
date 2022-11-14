//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package me.taylan.mooncore.listeners;

import java.io.File;
import java.io.IOException;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.seasons.CustomDateMethods;
import me.taylan.mooncore.utils.BukkitSerialization;
import me.taylan.mooncore.utils.StatsManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;

public class QuitListener implements Listener {
    private final MoonCore plugin;
    private final StatsManager stats;
    private final CustomDateMethods customDateMethods;

    public QuitListener(MoonCore plugin) {
        this.plugin = plugin;
        this.customDateMethods = plugin.getCustomDateMethods();
        this.stats = plugin.getStatsManager();
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onplayerquitstat(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        this.customDateMethods.setTab(this.customDateMethods.getTab() - 1);
        String invToBase64 = BukkitSerialization.itemStackArrayToBase64(((Inventory) JoinListener.getMenu().get(player.getUniqueId())).getContents());
        String invToBase64furnace = BukkitSerialization.itemStackArrayToBase64(((Inventory) JoinListener.getFurnacemenu().get(player.getUniqueId())).getContents());
        String invToBase64smoker = BukkitSerialization.itemStackArrayToBase64(((Inventory) JoinListener.getOcakMenu().get(player.getUniqueId())).getContents());
        String invToBase64work = BukkitSerialization.itemStackArrayToBase64(((Inventory) JoinListener.getElsanatmenu().get(player.getUniqueId())).getContents());
        this.stats.setStorage(player.getUniqueId(), invToBase64);
        this.stats.setFurnaceStorage(player.getUniqueId(), invToBase64furnace);
        this.stats.setCookStorage(player.getUniqueId(), invToBase64smoker);
        this.stats.setWorkStorage(player.getUniqueId(), invToBase64work);
        String name = player.getUniqueId().toString();
        File f = new File("plugins/RemielCore/playerdata", name + ".yml");
        FileConfiguration fc = (FileConfiguration) this.stats.getStatfile().get(player.getUniqueId());
        if (this.stats.getStatfile().containsKey(player.getUniqueId()) && f.exists()) {
            try {
                fc.save(f);
            } catch (IOException var11) {
                var11.printStackTrace();
            }
        }

    }
}
