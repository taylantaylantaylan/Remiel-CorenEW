package me.taylan.mooncore.listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.inventory.ItemStack;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.StatsManager;

public class ItemPickupListener implements Listener {
private final MoonCore plugin;
private final StatsManager stats;

	public ItemPickupListener(MoonCore plugin) {
		this.plugin = plugin;
		this.stats = plugin.getStatsManager();
		plugin.getServer().getPluginManager().registerEvents(this, plugin);

	}

	@EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
	public void ItemPick(EntityPickupItemEvent event) {
		Entity entity = event.getEntity();
		if (!(entity instanceof Player)) {
			return;
		}
		Player player = (Player) entity;
		ItemStack item = event.getItem().getItemStack();

	}
}
