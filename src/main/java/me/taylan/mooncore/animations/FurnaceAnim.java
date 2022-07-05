package me.taylan.mooncore.animations;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.level.Levels;
import me.taylan.mooncore.listeners.InventoryClickListener;
import me.taylan.mooncore.listeners.JoinListener;
import me.taylan.mooncore.utils.StatsManager;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.*;
import org.bukkit.block.BlastFurnace;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Lightable;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class FurnaceAnim {
	public MoonCore plugin;
	private Levels Levels;


	private StatsManager stats;

	public FurnaceAnim(MoonCore plugin) {
		this.plugin = plugin;
		this.Levels = plugin.getLevels();
		this.stats = plugin.getStatsManager();
	}

	public void furnaceAnimation(Player p, int cookTime, ItemStack result) {
		int timer = stats.getFurnaceProduction(p.getUniqueId());
		int amount = stats.getFurnaceAmount(p.getUniqueId());
		stats.setFurnaceAmount(p.getUniqueId(),cookTime);
		new BukkitRunnable() {
			@Override
			public void run() {
				Block block = InventoryClickListener.getFurnaceBlock().get(p.getUniqueId());
				Location loc = block.getLocation().add(0.5, 1, 0.5);
				Location loc2 = block.getLocation().add(0.5, 1.2, 0.5);
				World world = Bukkit.getWorld("world");
				Material type = block.getType();
				BlockState state = block.getState();
				BlastFurnace smok = (BlastFurnace) state;
				BlockData data = block.getState().getBlockData();
				Lightable lit = (Lightable) data;
				new BukkitRunnable() {

					@Override
					public void run() {
						Material type = block.getType();
						BlockState state = block.getState();
						BlastFurnace smok = (BlastFurnace) state;
						BlockData data = block.getState().getBlockData();
						Lightable lit = (Lightable) data;
						lit.setLit(true);
						state.setBlockData((BlockData) data);
						state.update();
					}

				}.runTaskLater(plugin, 1L);
				world.spawn(loc2, ArmorStand.class, armorStand2 -> {
					armorStand2.setMarker(true);
					armorStand2.setVisible(false);
					armorStand2.setGravity(false);
					armorStand2.setSmall(true);
					armorStand2.setCustomNameVisible(true);
					armorStand2.setCustomName(ChatColor.YELLOW + "Eritiliyor...");
					for (Player player2 : Bukkit.getOnlinePlayers()) {
						if (p.getWorld().getName().equals("dungeonworld") ||p.getWorld().getName().equals("world")) {
							if (player2 == p) continue;
							player2.hideEntity(plugin, armorStand2);
						}
					}
					world.spawn(loc, ArmorStand.class, armorStand -> {
						armorStand.setMarker(true);
						armorStand.setVisible(false);
						armorStand.setGravity(false);
						armorStand.setSmall(true);
						armorStand.setCustomNameVisible(true);
						armorStand.setCustomName("");
						for (Player player2 : Bukkit.getOnlinePlayers()) {
							if (p.getWorld().getName().equals("dungeonworld") ||p.getWorld().getName().equals("world")) {
								if (player2 == p) continue;
								player2.hideEntity(plugin, armorStand);
							}
						}
						new BukkitRunnable() {

							@Override
							public void run() {
								int timer = stats.getFurnaceProduction(p.getUniqueId());
								stats.setFurnaceProduction(p.getUniqueId(), 1);
								int remain = cookTime - timer;
								armorStand.setCustomName(
										ChatColor.GOLD + "Malzemenin Hazır Olmasına: " + ChatColor.WHITE + remain + " Saniye");
								if (timer >= cookTime) {

									armorStand.setCustomName(ChatColor.GREEN + "✔");
									lit.setLit(false);
									state.setBlockData((BlockData) data);
									state.update();
									stats.setFurnaceAmount(p.getUniqueId(), -cookTime);
									JoinListener.getFurnacemenu().get(p.getUniqueId()).addItem(result);
									new BukkitRunnable() {

										@Override
										public void run() {
											armorStand.remove();

										}
									}.runTaskLater(plugin, 20L);
									world.playSound(loc, Sound.BLOCK_BLASTFURNACE_FIRE_CRACKLE, 3f, 0.2f);
									armorStand2.remove();
									stats.setFurnaceProduction(p.getUniqueId(), -timer - 1);
									cancel();
								}

							}
						}.runTaskTimer(plugin, 0L, 20L);
					});
				});

			}
		}.runTaskLater(plugin,amount*20);

	}



}
