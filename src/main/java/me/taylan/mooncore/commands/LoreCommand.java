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
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LoreCommand implements CommandExecutor {

private final MoonCore plugin;
	private final List<Component> lore = new ArrayList<>();
	public LoreCommand(MoonCore plugin) {
		this.plugin = plugin;
		Objects.requireNonNull(plugin.getCommand("lore")).setExecutor(this);
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String... args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (p.hasPermission("mooncore.lore")) {
				if (args.length <= 0) {
					p.sendMessage(Painter.paint("&cYanlış Kullanım! Doğrusu /lore <string>"));
				} else if (args.length > 0) {

					ItemStack hand = p.getInventory().getItemInMainHand();
					ItemMeta meta = hand.getItemMeta();
					for(String s:args) {
						lore.add(MiniMessage.builder().build()
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
