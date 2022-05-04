package me.taylan.mooncore.listeners.entitydamage;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.StatsManager;

public class AttackSpeed implements Listener {
	private HashMap<UUID, Long> atksped = new HashMap<UUID, Long>();
	private MoonCore plugin;
	private StatsManager stats;
	private static int beklemetime = 4;

	public AttackSpeed(MoonCore plugin) {
		this.plugin = plugin;
		this.stats = plugin.getStatsManager();
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onDamageAttackSpeed(EntityDamageByEntityEvent event) {
		if (event.isCancelled()) {
			return;

		}

		Entity entity = event.getDamager();
		LivingEntity damaged = (LivingEntity) event.getEntity();
		if (entity instanceof Player) {
			Random rand = new Random();

			Player player = (Player) entity;
			if (!damaged.isDead()) {
				int attacksped = rand.nextInt(105-stats.getSaldiriHizi(player.getUniqueId()));
				if (attacksped <= 2) {
					if (atksped.containsKey(player.getUniqueId())) {
						long kalansaniye = ((atksped.get(player.getUniqueId()) / 1000) + beklemetime)
								- (System.currentTimeMillis() / 1000);

						if (kalansaniye < 1) {
							atksped.remove(player.getUniqueId());
						}
					} else {
						atksped.put(player.getUniqueId(), System.currentTimeMillis());



						damaged.getLocation().getWorld().spawnParticle(Particle.BLOCK_CRACK,
								damaged.getLocation().add(0, 1.2, 0), 3, 0.5, 0.5, 0.5, 0.1,
								Material.REDSTONE_BLOCK.createBlockData());
						damaged.getLocation().getWorld().spawnParticle(Particle.WAX_ON,
								damaged.getLocation().add(0, 1.2, 0), 7, 0.5, 0.5, 0.5, 0.1);
						int atak = rand.nextInt(2);
						for (int i = 0; i < atak + 2; i++) {
							damaged.setNoDamageTicks(0);
							damaged.damage(event.getDamage() + 4 * stats.getGuc(player.getUniqueId()) / 100 + 1,
									player);
							player.getWorld().playSound(player.getLocation(), Sound.ENTITY_SKELETON_CONVERTED_TO_STRAY,
									3, 0.8f);
						}

					}

				}

			}
		} else if (entity instanceof Arrow) {
			Random rand = new Random();
			Arrow arrow = (Arrow) entity;
			arrow.setCritical(true);
			Player player = (Player) arrow.getShooter();
			if (!damaged.isDead()) {
				int attacksped = rand.nextInt(105-stats.getSaldiriHizi(player.getUniqueId()));
				if (attacksped <= 2) {
					if (atksped.containsKey(player.getUniqueId())) {
						long kalansaniye = ((atksped.get(player.getUniqueId()) / 1000) + beklemetime)
								- (System.currentTimeMillis() / 1000);

						if (kalansaniye < 1) {
							atksped.remove(player.getUniqueId());
						}
					} else {
						atksped.put(player.getUniqueId(), System.currentTimeMillis());

						damaged.getLocation().getWorld().spawnParticle(Particle.BLOCK_CRACK,
								damaged.getLocation().add(0, 1.2, 0), 3, 0.5, 0.5, 0.5, 0.1,
								Material.REDSTONE_BLOCK.createBlockData());
						damaged.getLocation().getWorld().spawnParticle(Particle.WAX_ON,
								damaged.getLocation().add(0, 1.2, 0), 7, 0.5, 0.5, 0.5, 0.1);
						int atak = rand.nextInt(2);
						for (int i = 0; i < atak + 2; i++) {
							damaged.setNoDamageTicks(0);
							damaged.damage(event.getDamage() + 4 * stats.getGuc(player.getUniqueId()) / 100 + 1,
									player);
							player.getWorld().playSound(player.getLocation(), Sound.ENTITY_SKELETON_CONVERTED_TO_STRAY,
									3, 0.8f);
						}

					}

				}

			}
		}
	}

	public HashMap<UUID, Long> getAtksped() {
		return atksped;
	}
}
