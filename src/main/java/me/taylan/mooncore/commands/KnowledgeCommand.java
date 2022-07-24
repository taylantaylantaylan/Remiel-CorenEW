package me.taylan.mooncore.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.ItemHandler;
import me.taylan.mooncore.utils.Painter;

public class KnowledgeCommand implements CommandExecutor {

	private MoonCore plugin;
	private ItemHandler itemHandler;
	

	public KnowledgeCommand(MoonCore plugin) {
		this.plugin = plugin;
		this.itemHandler = plugin.getItemHandler();

		plugin.getCommand("bookver").setExecutor(this);
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
				ItemStack star = new ItemStack(Material.KNOWLEDGE_BOOK);
				NamespacedKey key = new NamespacedKey(plugin, "star");
				List<String> lore = new ArrayList<>();
				ItemMeta meta = star.getItemMeta();
				PersistentDataContainer container = meta.getPersistentDataContainer();
				container.set(key, PersistentDataType.STRING, "star");
				meta.setDisplayName(Painter.paint("&bBilgi Kitabın"));
				lore.add(Painter.paint("&8Bu kitap sayesinde bir çok şeye erişebilir"));
				lore.add(Painter.paint("&8ve daha önce karşılaştığınız yaratıklar"));
				lore.add(Painter.paint("&8hakkında Bilgi sahibi olabilirsiniz."));
				lore.add(Painter.paint(""));
				lore.add(Painter.paint("&7Kullanmak için &e&lSağ Tıkla."));
				meta.setLore(lore);
				star.setItemMeta(meta);
				p.getInventory().setItem(8, star);

		}
		return false;
	}
}