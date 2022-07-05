package me.taylan.mooncore.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.Painter;

public class RenameCommand implements CommandExecutor {

	private MoonCore plugin;

	public RenameCommand(MoonCore plugin) {
		this.plugin = plugin;
		plugin.getCommand("isim").setExecutor(this);
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (p.hasPermission("mooncore.rename")) {
				if (args.length <= 0) {
					p.sendMessage(Painter.paint("&cYanlış Kullanım! Doğrusu /isim <itemismi>"));
				} else if (args.length > 0) {
					ItemStack hand = p.getInventory().getItemInMainHand();
					String name = String.join(" ", args);
					rename(hand, name);
					p.sendMessage(Painter.paint("&6Item'ın ismi &e"+name+" &6olarak değiştirildi."));
					
				}
			}
		}
		return false;
	}
	public void rename(ItemStack item, String s) {
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(Painter.paint(s));
		item.setItemMeta(meta);
	}
}
