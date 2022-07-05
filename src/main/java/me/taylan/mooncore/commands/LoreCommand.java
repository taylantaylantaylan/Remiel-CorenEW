package me.taylan.mooncore.commands;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.Painter;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class LoreCommand implements CommandExecutor {

	private MoonCore plugin;
	private List<Component> lore = new ArrayList<>();
	public LoreCommand(MoonCore plugin) {
		this.plugin = plugin;
		plugin.getCommand("lore").setExecutor(this);
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String... args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (p.hasPermission("mooncore.lore")) {
				if (args.length <= 0) {
					p.sendMessage(Painter.paint("&cYanlış Kullanım! Doğrusu /lore <string>"));
				} else if (args.length > 0) {

					ItemStack hand = p.getInventory().getItemInMainHand();
					ItemMeta meta = hand.getItemMeta();
					for(String s:args) {
						lore.add(MiniMessage.miniMessage()
								.deserialize(s));
					}
					meta.lore(lore);
					hand.setItemMeta(meta);
					lore.clear();
					p.sendMessage(Painter.paint("&6Item'ın lore'u değiştirildi."));
					
				}
			}
		}
		return false;
	}

}
