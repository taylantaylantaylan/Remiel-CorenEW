package me.taylan.mooncore.listeners;

import org.bukkit.event.Listener;

import me.taylan.mooncore.MoonCore;

public class ChunkJoinListener implements Listener {
	private MoonCore plugin;

	public ChunkJoinListener(MoonCore plugin) {
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}



}
