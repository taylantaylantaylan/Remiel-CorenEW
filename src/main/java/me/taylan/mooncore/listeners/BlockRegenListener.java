package me.taylan.mooncore.listeners;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.scheduler.BukkitRunnable;

import me.taylan.mooncore.MoonCore;

public class BlockRegenListener implements Listener {
	private MoonCore plugin;
	private HashMap<Block, Material> blockmap = new HashMap<Block, Material>();

	public BlockRegenListener(MoonCore plugin) {
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);

	}

	@EventHandler
	public void blockbreak(BlockBreakEvent event) {
		Player player = event.getPlayer();
		if (!player.hasPermission("mooncore.break")) {
			if (plugin.getServer().getWorld("world").equals(player.getWorld())) {
				Material blocktype = event.getBlock().getType();
				if (Tag.DIAMOND_ORES.isTagged(blocktype) || Tag.COAL_ORES.isTagged(blocktype)
						|| Tag.IRON_ORES.isTagged(blocktype) || Tag.GOLD_ORES.isTagged(blocktype)
						|| Tag.LAPIS_ORES.isTagged(blocktype) || Tag.COPPER_ORES.isTagged(blocktype)
						|| Tag.REDSTONE_ORES.isTagged(blocktype) || Tag.REDSTONE_ORES.isTagged(blocktype)
						|| Tag.DEEPSLATE_ORE_REPLACEABLES.isTagged(blocktype) || Tag.SAND.isTagged(blocktype)
						|| Tag.BASE_STONE_OVERWORLD.isTagged(blocktype) || Tag.COAL_ORES.isTagged(blocktype)) {
					Block block = event.getBlock();
					block.setType(Material.BEDROCK);
					blockmap.put(block, blocktype);
					new BukkitRunnable() {

						@Override
						public void run() {

							block.setType(blockmap.get(block));
							blockmap.remove(block);
						}
					}.runTaskLater(plugin, 80L);

				} else if (Tag.LOGS.isTagged(blocktype)) {
					Block block = event.getBlock();
					blockmap.put(block, blocktype);
					new BukkitRunnable() {

						@Override
						public void run() {

							block.setType(blockmap.get(block));
							blockmap.remove(block);
						}
					}.runTaskLater(plugin, 80L);

				}
			}
		}
	}

}
