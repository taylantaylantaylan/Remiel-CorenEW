package me.taylan.mooncore.listeners;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import fr.mrmicky.fastboard.FastBoard;
import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.Painter;
import me.taylan.mooncore.utils.StatsManager;
import net.md_5.bungee.api.ChatColor;

public class ItemDropListener implements Listener {

	private MoonCore plugin;
	private StatsManager stats;

	public ItemDropListener(MoonCore plugin) {
		this.plugin = plugin;
		this.stats = plugin.getStatsManager();
		Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
	}

	public static List<String> dogrulamaBypass = new ArrayList<>();

	HashMap<String, ItemStack> confirmCheck = new HashMap<String, ItemStack>();

	@EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
	public void itemDrop(PlayerDropItemEvent e) throws SQLException {
		Player player = e.getPlayer();
		if (dogrulamaBypass.contains(player.getName()))
			return;
		else {
			e.setCancelled(true);
			ItemStack checkMaterial = confirmCheck.get(player.getName());
			ItemStack eldeki = player.getInventory().getItemInMainHand();
			if (!confirmCheck.containsKey(player.getName())
					&& checkMaterial != player.getInventory().getItemInMainHand()) {
				Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
					public void run() {
						confirmCheck.put(player.getName(), player.getInventory().getItemInMainHand());
					}
				}, 1);
				player.sendMessage(Painter.paint("&7Eşyayı atmayı onaylamak için tekrar at!"));
			} else if (checkMaterial.getType() != eldeki.getType()
					&& checkMaterial.getItemMeta() != eldeki.getItemMeta()
					&& checkMaterial.getAmount() != eldeki.getAmount()) {

				confirmCheck.remove(player.getName());
				Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
					public void run() {
						confirmCheck.put(player.getName(), player.getInventory().getItemInMainHand());
						player.sendMessage(Painter.paint("&7Eşyayı atmayı onaylamak için tekrar at!"));
					}
				}, 1);
			} else {
				confirmCheck.remove(player.getName());
				e.setCancelled(false);
				NamespacedKey weightitm = new NamespacedKey(plugin, "weightitm");
				ItemStack item = e.getItemDrop().getItemStack();
				if (item != null && item.hasItemMeta()) {
					if (item.getItemMeta().getPersistentDataContainer() != null) {
						if (item.getItemMeta().getPersistentDataContainer().has(weightitm,
								PersistentDataType.INTEGER)) {
							int weight = item.getItemMeta().getPersistentDataContainer().get(weightitm,
									PersistentDataType.INTEGER);
							int agirlik = stats.getAgirlik(player.getUniqueId());
							if (agirlik > 0) {
								stats.setAgirlik(player.getUniqueId(), -weight);
								int maxagirlik = stats.getMaxAgirlik(player.getUniqueId());
								SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
								Date date = new Date(System.currentTimeMillis());
								FastBoard board = new FastBoard(player);

								board.updateTitle(ChatColor.AQUA + "Moon Network");

								board.updateLines(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "     Remiel", "    ",
										ChatColor.GOLD + "Akçe ⛁" + ChatColor.WHITE + 0,
										ChatColor.WHITE + "Ağırlık: " + ChatColor.GRAY + agirlik + "/" + ChatColor.RED
												+ maxagirlik,
										"", ChatColor.GRAY + player.getName(),
										ChatColor.DARK_GRAY + formatter.format(date), ChatColor.AQUA + "mc.moonnw.xyz");
							}
						}
					}
				}
			}

		}
	}
}
