package me.taylan.mooncore.commands;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.Painter;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class MapCommand implements CommandExecutor {

private final MoonCore plugin;

	public MapCommand(MoonCore plugin) {
		this.plugin = plugin;
		Objects.requireNonNull(plugin.getCommand("map")).setExecutor(this);
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
				p.sendMessage(Painter.paint("&bHarita Linki &r http://45.131.3.32:8123/"));

		}
		return false;
	}

}
