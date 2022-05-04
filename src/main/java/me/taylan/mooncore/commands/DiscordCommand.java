package me.taylan.mooncore.commands;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.Painter;

public class DiscordCommand implements CommandExecutor {

	private MoonCore plugin;
	
	public DiscordCommand(MoonCore plugin) {
		this.plugin = plugin;
		plugin.getCommand("discord").setExecutor(this);
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (p.hasPermission("mooncore.discord")) {
				p.sendMessage(Painter.paint("&bDiscord Linki &r discord.gg/moonnetwork"));
				ItemStack book = new ItemStack(Material.BOOK);
				ItemMeta meta = book.getItemMeta();
				List<String> lore = new ArrayList<>();
				lore.add(Painter.paint("&8<Boş Büyü Bölmesi>"));
				meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
				meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				meta.setLore(lore);
				book.setItemMeta(meta);
				p.getInventory().addItem(book);
			}
		}
		return false;
	}

}
