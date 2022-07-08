package me.taylan.mooncore.commands;

import com.sk89q.worldedit.function.factory.ApplyLayer;
import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.ItemHandler;
import me.taylan.mooncore.utils.Painter;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;

public class ItemInfoCommand implements CommandExecutor {

	private MoonCore plugin;
	private ItemHandler itemHandler;


	public ItemInfoCommand(MoonCore plugin) {
		this.plugin = plugin;
		this.itemHandler = plugin.getItemHandler();

		plugin.getCommand("iteminfo").setExecutor(this);
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (p.hasPermission("mooncore.iteminfo")) {
				ItemStack item = p.getInventory().getItemInMainHand();
				NamespacedKey dura = new NamespacedKey(plugin, "durability");
				p.sendMessage(Painter.paint("&cDurability: &f"+item.getItemMeta().getPersistentDataContainer().get(dura,PersistentDataType.INTEGER)));
			}
		}
		return false;
	}
}