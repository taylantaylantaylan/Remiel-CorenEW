package me.taylan.mooncore.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.listeners.PlayerDeathListener;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class BackCommand implements CommandExecutor {

    private final MoonCore plugin;
	private final PlayerDeathListener deathListener;
	
	public BackCommand(MoonCore plugin) {
		this.plugin = plugin;
		this.deathListener = plugin.getDeathListener();
		Objects.requireNonNull(plugin.getCommand("back")).setExecutor(this);
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
		if (sender instanceof Player p) {
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
