package me.taylan.mooncore.listeners;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.StatsManager;

public class QuitListener implements Listener {
	private MoonCore plugin;
	private StatsManager stats;

	public QuitListener(MoonCore plugin) {
		this.plugin = plugin;
		this.stats = plugin.getStatsManager();
	}

	@EventHandler
	public void onplayerquitstat(PlayerQuitEvent event) {
		Player player = event.getPlayer();
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
