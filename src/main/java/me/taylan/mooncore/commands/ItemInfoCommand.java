package me.taylan.mooncore.commands;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.ItemHandler;
import me.taylan.mooncore.utils.Painter;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class ItemInfoCommand implements CommandExecutor {

	private final MoonCore plugin;
private final ItemHandler itemHandler;


	public ItemInfoCommand(MoonCore plugin) {
		this.plugin = plugin;
		this.itemHandler = plugin.getItemHandler();

		Objects.requireNonNull(plugin.getCommand("iteminfo")).setExecutor(this);
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
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