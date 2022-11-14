package me.taylan.mooncore.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.GuiHandler;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class NitelikCommand implements CommandExecutor {
	private final GuiHandler guiHandler;
private final MoonCore plugin;

	public NitelikCommand(MoonCore plugin) {
		this.plugin = plugin;
		this.guiHandler = plugin.getGuiHandler();
		Objects.requireNonNull(plugin.getCommand("nitelik")).setExecutor(this);
	}

	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;

				p.openInventory(guiHandler.nitelik(p));
			

		}
		return false;
	}

	
}
