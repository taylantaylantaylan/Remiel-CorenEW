package me.taylan.mooncore.commands;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.listeners.PlayerDeathListener;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class DuraCommand implements CommandExecutor {

	private final MoonCore plugin;
private final PlayerDeathListener deathListener;

	public DuraCommand(MoonCore plugin) {
		this.plugin = plugin;
		this.deathListener = plugin.getDeathListener();
		Objects.requireNonNull(plugin.getCommand("dura")).setExecutor(this);
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (p.hasPermission("mooncore.dura")) {
				ItemStack item = p.getInventory().getItemInMainHand();
				if(item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
					NamespacedKey dura = new NamespacedKey(plugin,"durability");
					if(item.getItemMeta().getPersistentDataContainer().has(dura)) {
						p.sendMessage(item.getItemMeta().getPersistentDataContainer().get(dura, PersistentDataType.INTEGER)+"");
					}
				}
			}
		}
		return false;
	}

}
