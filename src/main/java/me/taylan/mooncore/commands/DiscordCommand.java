package me.taylan.mooncore.commands;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.Painter;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

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
				p.sendMessage(Painter.paint("&bDiscord Linki &r discord.gg/moonnetwork"));
		}
		return false;
	}

}
