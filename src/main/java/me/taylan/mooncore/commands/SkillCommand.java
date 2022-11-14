package me.taylan.mooncore.commands;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.GuiHandler;
import me.taylan.mooncore.utils.ItemHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class SkillCommand implements CommandExecutor {

private final MoonCore plugin;
	private final GuiHandler guiHandler;
private final ItemHandler itemHandler;

	public SkillCommand(MoonCore plugin) {
		this.plugin = plugin;
		this.guiHandler = plugin.getGuiHandler();
		this.itemHandler = plugin.getItemHandler();
		Objects.requireNonNull(plugin.getCommand("ustalık")).setExecutor(this);
	}

	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

		if (!(sender instanceof Player)) {
			return true;
		}

		Player p = (Player) sender;


			p.openInventory(guiHandler.skillGui(p));


		return false;
	}

}
