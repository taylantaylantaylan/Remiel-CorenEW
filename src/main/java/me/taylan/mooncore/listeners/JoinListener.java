package me.taylan.mooncore.listeners;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import fr.mrmicky.fastboard.FastBoard;
import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.BukkitSerialization;
import me.taylan.mooncore.utils.Painter;
import me.taylan.mooncore.utils.StatsManager;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.md_5.bungee.api.ChatColor;

public class JoinListener implements Listener {

	private MoonCore plugin;
	private StatsManager stats;
	private static HashMap<UUID, Inventory> menu = new HashMap<UUID, Inventory>();

	public JoinListener(MoonCore plugin) {
		this.plugin = plugin;
		this.stats = plugin.getStatsManager();
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	public static HashMap<UUID, Inventory> getMenu() {
		return menu;
	}

	@SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.LOWEST,ignoreCancelled = true)
	public void onPlayerJoin(PlayerJoinEvent e) {

		Player player = e.getPlayer();
		player.setHealthScale(20);
		e.setJoinMessage(null);
		String name = player.getName();
		String broadcastedMessage = "";
		if (!stats.hasPlayedBefore(player.getUniqueId())) {
			try {
				stats.createFile(player.getUniqueId());
			} catch (IOException ex) {
				plugin.send("&cOyuncu Dosyası oluşturulamadı!");
			}
			broadcastedMessage = Painter.paint(name + " &bRemiel &etopraklarına ilk adımını attı!");
		} else {
			stats.getStatfile().put(player.getUniqueId(), stats.getFile(player.getUniqueId()));
			broadcastedMessage = Painter.paint("&7[&6+&7] " + name);
		}
		for (Player p : plugin.getServer().getOnlinePlayers()) {
			p.sendMessage(broadcastedMessage);
		}
		Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
		if (scoreboard.getTeam(player.getName()) == null) {
			scoreboard.registerNewTeam(player.getName());
		}
		Team isim = scoreboard.getTeam(player.getName());
		
		if (isim.hasEntry(player.getName())) {
			isim.setPrefix(Painter.paint("&7[&fSvy. " + stats.getLevel(player.getUniqueId()) + "&7] &f"));
			isim.setSuffix(Painter.paint(" &6[" + (int) player.getHealth() + "❤]"));
		} else {
			isim.addEntry(player.getName());
			isim.setPrefix(Painter.paint("&7[&fSvy. " + stats.getLevel(player.getUniqueId()) + "&7] &f"));
			isim.setSuffix(Painter.paint(" &6[" + (int) player.getHealth() + "❤]"));
		}
		NamespacedKey weightitm = new NamespacedKey(plugin, "weightitm");
		for (ItemStack item : player.getInventory().getContents()) {

			int totalWeight = 0;
			if (item != null && item.hasItemMeta()) {
				if (item.getItemMeta().getPersistentDataContainer() != null) {
					if (item.getItemMeta().getPersistentDataContainer().has(weightitm, PersistentDataType.INTEGER)) {
						totalWeight += item.getItemMeta().getPersistentDataContainer().get(weightitm,
								PersistentDataType.INTEGER);
						stats.setAgirlik(player.getUniqueId(), totalWeight);

					} else {
						stats.setAgirlik(player.getUniqueId(), 0);

					}
				}
			}
		}

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date(System.currentTimeMillis());
		FastBoard board = new FastBoard(player);
		int agirlik = stats.getAgirlik(player.getUniqueId());
		int maxagirlik = stats.getMaxAgirlik(player.getUniqueId());
		board.updateTitle(ChatColor.AQUA + "Moon Network");

		board.updateLines(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "     Remiel", "    ",
				ChatColor.GOLD + "Akçe ⛁" + ChatColor.WHITE + 0,
				ChatColor.WHITE + "Ağırlık: " + ChatColor.GRAY + agirlik + "/" + ChatColor.RED + maxagirlik, "",
				ChatColor.GRAY + player.getName(), ChatColor.DARK_GRAY + formatter.format(date),
				ChatColor.AQUA + "mc.moonnw.xyz"

		);
		if (!(player.hasPlayedBefore())) {
			ItemStack star = new ItemStack(Material.KNOWLEDGE_BOOK);
			NamespacedKey key = new NamespacedKey(plugin, "star");
			List<String> lore = new ArrayList<>();
			ItemMeta meta = star.getItemMeta();
			PersistentDataContainer container = meta.getPersistentDataContainer();
			container.set(key, PersistentDataType.STRING, "star");
			meta.setDisplayName(Painter.paint("&bOyuncu El Kitabı"));
			lore.add(Painter.paint("&8Bu kitap sayesinde bir çok şeye erişebilir"));
			lore.add(Painter.paint("&8ve daha önce karşılaştığınız yaratıklar"));
			lore.add(Painter.paint("&8hakkında Bilgi sahibi olabilirsiniz."));
			lore.add(Painter.paint(""));
			lore.add(Painter.paint("&7Kullanmak için &e&lSağ Tıkla."));
			meta.setLore(lore);
			star.setItemMeta(meta);
			player.getInventory().setItem(8, star);
		}

		menu.put(player.getUniqueId(), Bukkit.createInventory(player, 9, MiniMessage.get().parse("<dark_gray>Depo")));
		if (!(stats.getStorage(player.getUniqueId()).equals("yok"))) {
			String contents = stats.getStorage(player.getUniqueId());
			try {
				Inventory inv = BukkitSerialization.fromBase64(contents);
				menu.get(player.getUniqueId()).setContents(inv.getContents());
			} catch (IOException ev) {
				plugin.getLogger().warning("Broken");
				ev.printStackTrace();
			}
		}
		if (stats.getVayne(player.getUniqueId()) != null) {
			ItemStack[] content = stats.getVayne(player.getUniqueId()).toArray(new ItemStack[0]);
			player.getInventory().setArmorContents(content);
			stats.setVayne(player.getUniqueId(), null);
		}
	}

}
