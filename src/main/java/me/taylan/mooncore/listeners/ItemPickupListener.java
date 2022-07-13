package me.taylan.mooncore.listeners;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import fr.mrmicky.fastboard.FastBoard;
import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.StatsManager;
import net.md_5.bungee.api.ChatColor;

public class ItemPickupListener implements Listener {
	private MoonCore plugin;
	private StatsManager stats;

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
