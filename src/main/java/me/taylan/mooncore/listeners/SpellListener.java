package me.taylan.mooncore.listeners;

import org.bukkit.event.Listener;

import me.taylan.mooncore.MoonCore;

public class SpellListener implements Listener {
	private MoonCore plugin;

	public SpellListener(MoonCore plugin) {
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);

	}

}
