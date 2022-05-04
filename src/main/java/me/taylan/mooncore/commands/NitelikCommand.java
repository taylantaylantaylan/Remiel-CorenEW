package me.taylan.mooncore.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.GuiHandler;

public class NitelikCommand implements CommandExecutor {
	private GuiHandler guiHandler;
	private MoonCore plugin;

	public NitelikCommand(MoonCore plugin) {
		this.plugin = plugin;
		this.guiHandler = plugin.getGuiHandler();
		plugin.getCommand("nitelik").setExecutor(this);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (p.hasPermission("mooncore.nitelik")) {
				p.openInventory(guiHandler.nitelik(p));
			
			}
		}
		return false;
	}

	
}
