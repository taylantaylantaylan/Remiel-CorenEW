package me.taylan.mooncore.commands;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.GuiHandler;
import me.taylan.mooncore.utils.StatsManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Objects;

public class ProfileCommand implements CommandExecutor {

	private final GuiHandler gui;
private final MoonCore plugin;
	private final StatsManager stats;

	public ProfileCommand(MoonCore plugin) {
		this.plugin = plugin;
		this.stats = plugin.getStatsManager();
		this.gui = plugin.getGuiHandler();
		Objects.requireNonNull(plugin.getCommand("profil")).setExecutor(this);
	}

	@SuppressWarnings("unchecked")
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;

				if (args.length == 0) {
					p.openInventory(gui.profil(p, p));
					ArrayList<ItemStack> list = (ArrayList<ItemStack>) stats.getHepsi(p.getUniqueId());
					if (p.getInventory().getHelmet() != null) {
						p.getOpenInventory().getTopInventory().setItem(13, p.getInventory().getHelmet());
					}
					if (p.getInventory().getChestplate() != null) {
						p.getOpenInventory().getTopInventory().setItem(22, p.getInventory().getChestplate());
					}
					if (p.getInventory().getLeggings() != null) {
						p.getOpenInventory().getTopInventory().setItem(31, p.getInventory().getLeggings());
					}
					if (p.getInventory().getBoots() != null) {
						p.getOpenInventory().getTopInventory().setItem(40, p.getInventory().getBoots());
					}
					if (p.getInventory().getItemInMainHand() != null) {
						p.getOpenInventory().getTopInventory().setItem(39, p.getInventory().getItemInMainHand());
					}
					if (p.getInventory().getItemInOffHand() != null) {
						p.getOpenInventory().getTopInventory().setItem(41, p.getInventory().getItemInOffHand());
					}
					if (!(stats.getKolye(p.getUniqueId()).equals("Yok.."))) {
						p.getOpenInventory().getTopInventory().setItem(21, list.get(2));
					}
					if (!(stats.getTilsim(p.getUniqueId()).equals("Yok.."))) {
						p.getOpenInventory().getTopInventory().setItem(23, list.get(0));
					}
					if (!(stats.getEldiven(p.getUniqueId()).equals("Yok.."))) {
						p.getOpenInventory().getTopInventory().setItem(30, list.get(1));
					}
					if (!(stats.getYuzuk(p.getUniqueId()).equals("Yok.."))) {
						p.getOpenInventory().getTopInventory().setItem(32, list.get(3));
					}
				} else if (args.length > 0) {
					Player target = Bukkit.getPlayerExact(args[0]);
					p.openInventory(gui.profil(p, Objects.requireNonNull(target)));
					ArrayList<ItemStack> list = (ArrayList<ItemStack>) stats.getHepsi(target.getUniqueId());
					if (target.getInventory().getHelmet() != null) {
						p.getOpenInventory().getTopInventory().setItem(13, target.getInventory().getHelmet());
					}
					if (target.getInventory().getChestplate() != null) {
						p.getOpenInventory().getTopInventory().setItem(22, target.getInventory().getChestplate());
					}
					if (target.getInventory().getLeggings() != null) {
						p.getOpenInventory().getTopInventory().setItem(31, target.getInventory().getLeggings());
					}
					if (target.getInventory().getBoots() != null) {
						p.getOpenInventory().getTopInventory().setItem(40, target.getInventory().getBoots());
					}
					if (target.getInventory().getItemInMainHand() != null) {
						p.getOpenInventory().getTopInventory().setItem(39, target.getInventory().getItemInMainHand());
					}
					if (target.getInventory().getItemInOffHand() != null) {
						p.getOpenInventory().getTopInventory().setItem(41, target.getInventory().getItemInOffHand());
					}
					if (!(stats.getKolye(target.getUniqueId()).equals("Yok.."))) {
						p.getOpenInventory().getTopInventory().setItem(21, list.get(2));
					}
					if (!(stats.getTilsim(target.getUniqueId()).equals("Yok.."))) {
						p.getOpenInventory().getTopInventory().setItem(23, list.get(0));
					}
					if (!(stats.getEldiven(target.getUniqueId()).equals("Yok.."))) {
						p.getOpenInventory().getTopInventory().setItem(30, list.get(1));
					}
					if (!(stats.getYuzuk(target.getUniqueId()).equals("Yok.."))) {
						p.getOpenInventory().getTopInventory().setItem(32, list.get(3));
					}

			}
		}
		return false;
	}
}
