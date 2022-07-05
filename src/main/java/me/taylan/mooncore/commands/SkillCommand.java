package me.taylan.mooncore.commands;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.GuiHandler;
import me.taylan.mooncore.utils.ItemHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SkillCommand implements CommandExecutor {

	private MoonCore plugin;
	private GuiHandler guiHandler;
	private ItemHandler itemHandler;

	public SkillCommand(MoonCore plugin) {
		this.plugin = plugin;
		this.guiHandler = plugin.getGuiHandler();
		this.itemHandler = plugin.getItemHandler();
		plugin.getCommand("ustalık").setExecutor(this);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player)) {
			return true;
		}

		Player p = (Player) sender;


			p.openInventory(guiHandler.skillGui(p));


		return false;
	}

}
