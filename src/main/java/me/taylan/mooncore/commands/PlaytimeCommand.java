package me.taylan.mooncore.commands;

import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.Painter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class PlaytimeCommand implements CommandExecutor {

private final MoonCore plugin;
	
	public PlaytimeCommand(MoonCore plugin) {
		this.plugin = plugin;
		Objects.requireNonNull(plugin.getCommand("oynanansure")).setExecutor(this);
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;

				int secondsPlayed = p.getStatistic(Statistic.PLAY_ONE_MINUTE) / 20;
				p.sendMessage(Painter.paint("&bŞu ana kadar oyunda kaldığın süre: &f"+secondsPlayed/60));

		}
		return false;
	}

}
