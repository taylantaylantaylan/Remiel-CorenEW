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
		NamespacedKey weightitm = new NamespacedKey(plugin, "weightitm");
		if (item != null && item.hasItemMeta()) {
			if (item.getItemMeta().getPersistentDataContainer() != null) {
				if (item.getItemMeta().getPersistentDataContainer().has(weightitm, PersistentDataType.INTEGER)) {
					int weight = item.getItemMeta().getPersistentDataContainer().get(weightitm,
							PersistentDataType.INTEGER);
					int agirlik = stats.getAgirlik(player.getUniqueId());
					int maxagirlik = stats.getMaxAgirlik(player.getUniqueId());
						stats.setAgirlik(player.getUniqueId(), weight);

						SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
						Date date = new Date(System.currentTimeMillis());
						FastBoard board = new FastBoard(player);

						board.updateTitle(ChatColor.AQUA + "Moon Network");

						board.updateLines(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "     Remiel", "    ",
								ChatColor.GOLD + "Akçe ⛁" + ChatColor.WHITE + 0,
								ChatColor.WHITE + "Ağırlık: " + ChatColor.GRAY + agirlik + "/" + ChatColor.RED
										+ maxagirlik,
								"", ChatColor.GRAY + player.getName(), ChatColor.DARK_GRAY + formatter.format(date),
								ChatColor.AQUA + "mc.moonnw.xyz");
					
				}
			}
		}
	}
}
