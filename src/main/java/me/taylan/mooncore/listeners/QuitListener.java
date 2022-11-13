package me.taylan.mooncore.listeners;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.BukkitSerialization;
import me.taylan.mooncore.utils.StatsManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.File;
import java.io.IOException;

public class QuitListener implements Listener {
	private MoonCore plugin;
	private StatsManager stats;

	public QuitListener(MoonCore plugin) {
		this.plugin = plugin;
		this.stats = plugin.getStatsManager();
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onplayerquitstat(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		String invToBase64 = BukkitSerialization
				.itemStackArrayToBase64(JoinListener.getMenu().get(player.getUniqueId()).getContents());
		String invToBase64furnace = BukkitSerialization
				.itemStackArrayToBase64(JoinListener.getFurnacemenu().get(player.getUniqueId()).getContents());
		String invToBase64smoker = BukkitSerialization
				.itemStackArrayToBase64(JoinListener.getOcakMenu().get(player.getUniqueId()).getContents());
		String invToBase64work = BukkitSerialization
				.itemStackArrayToBase64(JoinListener.getElsanatmenu().get(player.getUniqueId()).getContents());
		stats.setStorage(player.getUniqueId(), invToBase64);
		stats.setFurnaceStorage(player.getUniqueId(), invToBase64furnace);
		stats.setCookStorage(player.getUniqueId(), invToBase64smoker);
		stats.setWorkStorage(player.getUniqueId(), invToBase64work);
		String name = player.getUniqueId().toString();
		File f = new File("plugins/RemielCore/playerdata", name + ".yml");
		FileConfiguration fc = stats.getStatfile().get(player.getUniqueId());
		if (stats.getStatfile().containsKey(player.getUniqueId())) {
			if (f.exists()) {
				try {
					fc.save(f);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
