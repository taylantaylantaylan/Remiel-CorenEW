package me.taylan.mooncore.listeners.entitydamage;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.StatsManager;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

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

	@EventHandler(priority = EventPriority.LOWEST)
	public void onDamageAttackSpeed(EntityDamageByEntityEvent event) {
		if (event.isCancelled()) {
			return;

		}

		Entity entity = event.getDamager();
		Entity entity2 = event.getEntity();
		final Set<EntityType> SKIPPED_TYPES = EnumSet.of(EntityType.ITEM_FRAME, EntityType.GLOW_ITEM_FRAME,
				EntityType.AREA_EFFECT_CLOUD);
		if (SKIPPED_TYPES.contains(entity2.getType())) {
			return;
		}
		LivingEntity damaged = (LivingEntity) entity2;
		if (entity instanceof Player) {

			Player player = (Player) entity;
			NamespacedKey hasar = new NamespacedKey(plugin, "damage");
			NamespacedKey guc = new NamespacedKey(plugin, "guc");
			if (player.getInventory().getItemInMainHand() != null
					&& player.getInventory().getItemInMainHand().hasItemMeta()
					&& player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer() != null
					&& player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().has(hasar)
					&& player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().has(guc)) {
				ItemStack item = player.getInventory().getItemInMainHand();

				if (!(player.hasCooldown(item.getType()))) {
					int realDamage = (int) (event.getDamage()
							+ item.getItemMeta().getPersistentDataContainer().get(hasar, PersistentDataType.INTEGER));
					int realStrhg = stats.getGuc(player.getUniqueId())
							+ item.getItemMeta().getPersistentDataContainer().get(guc, PersistentDataType.INTEGER);
					if (!damaged.isDead()) {
						int attacksped = ThreadLocalRandom.current()
								.nextInt(105 - stats.getSaldiriHizi(player.getUniqueId()));
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
										damaged.getLocation().add(0, 1.2, 0), 10, 0.5, 0.5, 0.5, 0.1);
								int atak = ThreadLocalRandom.current().nextInt(2);
								for (int i = 0; i < atak + 2; i++) {
									damaged.setNoDamageTicks(0);
									damaged.damage(realDamage + 4 * realStrhg / 100 + 1, player);
									if (stats.getSaldiriHiziAyar(player.getUniqueId())) {
										player.getWorld().playSound(player.getLocation(),
												Sound.ENTITY_SKELETON_CONVERTED_TO_STRAY, 0.5f, 0.8f);
									}
								}

							}

						}
					}
				}

			} else {
				return;
			}
		} else if (entity instanceof Arrow) {
			Arrow arrow = (Arrow) entity;
			arrow.setCritical(true);
			if(!(arrow.getShooter() instanceof Player)) return;
			Player player = (Player) arrow.getShooter();
			NamespacedKey hasar = new NamespacedKey(plugin, "damage");
			NamespacedKey guc = new NamespacedKey(plugin, "guc");
			if (player.getInventory().getItemInMainHand() != null
					&& player.getInventory().getItemInMainHand().hasItemMeta()
					&& player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer() != null
					&& player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().has(hasar)
					&& player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().has(guc)) {
				ItemStack item = player.getInventory().getItemInMainHand();

				if (!(player.hasCooldown(item.getType()))) {
					int realDamage = (int) (event.getDamage()
							+ item.getItemMeta().getPersistentDataContainer().get(hasar, PersistentDataType.INTEGER));
					int realStrhg = stats.getGuc(player.getUniqueId())
							+ item.getItemMeta().getPersistentDataContainer().get(guc, PersistentDataType.INTEGER);
					if (!damaged.isDead()) {
						int attacksped = ThreadLocalRandom.current()
								.nextInt(105 - stats.getSaldiriHizi(player.getUniqueId()));
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
										damaged.getLocation().add(0, 1.2, 0), 11, 0.5, 0.5, 0.5, 0.1);
								int atak = ThreadLocalRandom.current().nextInt(2);
								for (int i = 0; i < atak + 2; i++) {
									damaged.setNoDamageTicks(0);
									damaged.damage(realDamage + 4 * realStrhg / 100 + 1, player);
									if (stats.getSaldiriHiziAyar(player.getUniqueId())) {
										player.getWorld().playSound(player, Sound.ENTITY_SKELETON_CONVERTED_TO_STRAY,
												0.5f, 0.7f);
									}
								}

							}

						}
					}
				}

			} else {
				return;
			}
		}
	}

	public HashMap<UUID, Long> getAtksped() {
		return atksped;
	}
}
