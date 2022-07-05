package me.taylan.mooncore.commands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Chest;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Directional;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.Painter;

public class LootCrateCommand implements CommandExecutor {

	private MoonCore plugin;

	public LootCrateCommand(MoonCore plugin) {
		this.plugin = plugin;
		plugin.getCommand("lootolustur").setExecutor(this);
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (p.hasPermission("mooncore.rename")) {
				if (args.length <= 0) {
					p.sendMessage(Painter.paint("&cYanlış Kullanım! Doğrusu /lootolustur <sandikismi>"));
				} else if (args.length > 0) {
					String name = String.join(" ", args);
					World world = p.getWorld();
					Location loc = p.getLocation();
					world.getBlockAt(loc).setType(Material.CHEST);
					p.sendMessage(Painter.paint("&e" + name + " &6Adında Ganimet sandığı oluşturuldu!"));
					new BukkitRunnable() {

						@Override
						public void run() {
							Block chestBlock = world.getBlockAt(loc);
							Chest chestState = (Chest) chestBlock.getState();
							Directional data = (Directional) chestBlock.getBlockData();
							data.setFacing(p.getFacing());
							chestState.setBlockData(data);
							chestState.setCustomName(Painter.paint(name));
							chestState.update();
						}
					}.runTaskLater(plugin, 2);

				}
			}
		}
		return false;
	}
}
