package me.taylan.mooncore.commands;

import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.Painter;

public class PlaytimeCommand implements CommandExecutor {

	private MoonCore plugin;
	
	public PlaytimeCommand(MoonCore plugin) {
		this.plugin = plugin;
		plugin.getCommand("oynanansure").setExecutor(this);
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (p.hasPermission("mooncore.playtime")) {
				int secondsPlayed = p.getStatistic(Statistic.PLAY_ONE_MINUTE) / 20;
				p.sendMessage(Painter.paint("&bŞu ana kadar oyunda kaldığın süre: &f"+secondsPlayed));
			}
		}
		return false;
	}

}
