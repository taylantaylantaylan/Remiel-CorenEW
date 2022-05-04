package me.taylan.mooncore.listeners;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import me.taylan.mooncore.MoonCore;

public class PlayerDeathListener implements Listener {
	
	private MoonCore plugin;
	private HashMap<UUID, Location> deathmap = new HashMap<UUID,Location>();
	
	public PlayerDeathListener(MoonCore plugin) {
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void playerdeath(PlayerDeathEvent event) {
		Player player = event.getPlayer();
	    deathmap.put(player.getUniqueId(), player.getLocation());
		
	}

	public HashMap<UUID, Location> getDeathmap() {
		return deathmap;
	}

}
