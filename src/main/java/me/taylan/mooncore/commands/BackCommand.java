package me.taylan.mooncore.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.listeners.PlayerDeathListener;

public class BackCommand implements CommandExecutor {

	private MoonCore plugin;
	private PlayerDeathListener deathListener;
	
	public BackCommand(MoonCore plugin) {
		this.plugin = plugin;
		this.deathListener = plugin.getDeathListener();
		plugin.getCommand("back").setExecutor(this);
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (p.hasPermission("mooncore.back")) {
				if(deathListener.getDeathmap().containsKey(p.getUniqueId())) {
					p.teleport(deathListener.getDeathmap().get(p.getUniqueId()));
					deathListener.getDeathmap().remove(p.getUniqueId());
				}
			}
		}
		return false;
	}

}
