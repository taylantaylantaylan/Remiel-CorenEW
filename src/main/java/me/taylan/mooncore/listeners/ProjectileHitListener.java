package me.taylan.mooncore.listeners;

import org.bukkit.entity.Arrow;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

import me.taylan.mooncore.MoonCore;

public class ProjectileHitListener implements Listener {

	private MoonCore plugin;

	public ProjectileHitListener(MoonCore plugin) {
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void baba(ProjectileHitEvent event) {
		if (!(event.getEntity() instanceof Arrow)) {
			return;
		}
		if (event.getHitBlock() != null) {
			Arrow arrow = (Arrow) event.getEntity();
			arrow.remove();

		}
	}

}
