package me.taylan.mooncore.listeners;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.AreaEffectCloud;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Cod;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Silverfish;
import org.bukkit.entity.Squid;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.scheduler.BukkitRunnable;

import io.lumine.mythic.bukkit.events.MythicMobSpawnEvent;
import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.Painter;
import net.kyori.adventure.text.minimessage.MiniMessage;

public class MobSpawnListener implements Listener {

	private MoonCore plugin;

	public MobSpawnListener(MoonCore plugin) {
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void mobspawnevent(CreatureSpawnEvent event) {
		LivingEntity entity = event.getEntity();
		if (entity instanceof Player || entity instanceof ArmorStand || entity instanceof Villager
				|| entity instanceof AreaEffectCloud || entity instanceof Cod || entity instanceof Squid) {
			return;
		}
		
		Location loc = entity.getLocation();
		World world = Bukkit.getServer().getWorld("world");
		world.spawn(loc, Silverfish.class, armorStand -> {
			armorStand.setGravity(false);
			armorStand.setInvisible(true);
			armorStand.setAI(false);
			armorStand.setCustomNameVisible(true);
			String string = entity.getCustomName();
			armorStand.customName(MiniMessage.get().parse(string));
			entity.customName(
					MiniMessage.get().parse("<dark_green>[<green>" + (int) entity.getHealth() + "❤<dark_green>]"));
			new BukkitRunnable() {

				@Override
				public void run() {
					entity.customName(
							MiniMessage.get().parse("<dark_green>[<green>" + (int) entity.getHealth() + "❤<dark_green>]"));
					if (entity.isDead()) {
						armorStand.remove();
						this.cancel();
					}

				}
			}.runTaskTimer(plugin, 0, 1);

		});
	}

	@EventHandler
	public void mythicmobspawn(MythicMobSpawnEvent event) {
		Entity entity = event.getEntity();
		Random random = new Random();
		int chance = random.nextInt(50);
		if (chance < 5) {
			Random elit = new Random();
			int elitchance = random.nextInt(6);
			switch (elitchance) {
			case 0:

				break;
			case 1:

				break;
			case 2:

				break;
			case 3:

				break;
			case 4:

				break;
			case 5:

				break;
			case 6:

				break;
			}

		}
	}

	@EventHandler
	public void plantera(BlockBreakEvent event) {
		Player player = event.getPlayer();
		Block block = event.getBlock();
		Location loc = block.getLocation();
		if (block.getType() == Material.CHORUS_FLOWER) {
			player.sendMessage(Painter.paint("&2&lYabani sesler artmaya başladı.."));
			player.getWorld().spawnParticle(Particle.BLOCK_CRACK, loc, 10, 3, 3, 3, 1,
					Material.GREEN_TERRACOTTA.createBlockData());
			new BukkitRunnable() {
				int timer = 0;

				@Override
				public void run() {

					timer += 1;
					player.getWorld().playSound(block.getLocation(), Sound.BLOCK_GRASS_BREAK, 10, 0f);
					player.getWorld().spawnParticle(Particle.SPORE_BLOSSOM_AIR, loc, 20, 3, 3, 3, 0.1);
					if (timer >= 4) {
						this.cancel();
						new BukkitRunnable() {

							@Override
							public void run() {

								player.getWorld().playSound(player.getLocation(), Sound.ENTITY_WITHER_BREAK_BLOCK, 10,
										0.6f);
								player.getWorld().spawnParticle(Particle.BLOCK_CRACK, loc, 20, 2, 2, 2, 0,
										Material.GREEN_TERRACOTTA.createBlockData());
								new BukkitRunnable() {

									@Override
									public void run() {
										block.setType(Material.CHORUS_FLOWER);

									}
								}.runTaskLater(plugin, 2000);
							}
						}.runTaskLater(plugin, 10);

					}

				}
			}.runTaskTimer(plugin, 0, 20);

		}

	}
}
