package me.taylan.mooncore.listeners;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.BrewEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.alchemy.BlockPosition;
import me.taylan.mooncore.alchemy.BrewingStandData;
import me.taylan.mooncore.level.Levels;

public class BrewListener implements Listener {
	private MoonCore plugin;
	private Levels Levels;
	private Map<BlockPosition, BrewingStandData> brewingStands;

	public BrewListener(MoonCore plugin) {
		this.Levels = plugin.getLevels();
		this.plugin = plugin;
		this.brewingStands = new HashMap<>();
		Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onBrew(BrewEvent event) {
		if (event.getBlock().hasMetadata("skillsBrewingStandOwner")) {
			OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(UUID.fromString(
					((MetadataValue) event.getBlock().getMetadata("skillsBrewingStandOwner").get(0)).asString()));
			if (offlinePlayer.isOnline() && event.getContents().getIngredient() != null) {
				Player player = offlinePlayer.getPlayer();
				if (player != null) {
					Levels.giveBrewEXP(player, event.getContents().getIngredient().getType());
				}
			}
		}
	}

	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event) {
		if (event.getBlock().getType().equals(Material.BREWING_STAND))
			event.getBlock().setMetadata("skillsBrewingStandOwner",
					(MetadataValue) new FixedMetadataValue(plugin, event.getPlayer().getUniqueId()));
	}

	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		if (event.getBlock().getType().equals(Material.BREWING_STAND)) {
			if (event.getBlock().hasMetadata("skillsBrewingStandOwner"))
				event.getBlock().removeMetadata("skillsBrewingStandOwner", plugin);
			this.brewingStands.remove(BlockPosition.fromBlock(event.getBlock()));
		}
	}

	@EventHandler
	public void onInventoryOpen(InventoryOpenEvent event) {
		if (event.getInventory().getType().equals(InventoryType.BREWING) && event.getInventory().getHolder() != null
				&& event.getInventory().getLocation() != null) {
			Block block = event.getInventory().getLocation().getBlock();
			if (!block.hasMetadata("skillsBrewingStandOwner"))
				block.setMetadata("skillsBrewingStandOwner",
						(MetadataValue) new FixedMetadataValue(plugin, event.getPlayer().getUniqueId()));

		}
	}

}
