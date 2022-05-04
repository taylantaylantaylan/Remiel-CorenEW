package me.taylan.mooncore.listeners;

import org.bukkit.ChunkSnapshot;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.LeaveChunk;

public class ChunkLoadListener implements Listener {
	private MoonCore plugin;
	

	public ChunkLoadListener(MoonCore plugin) {
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onChunkPampa(ChunkLoadEvent event) {

		ChunkSnapshot snapshot = event.getChunk().getChunkSnapshot();
		new LeaveChunk(snapshot, plugin).runTaskAsynchronously(plugin);

	}
}
