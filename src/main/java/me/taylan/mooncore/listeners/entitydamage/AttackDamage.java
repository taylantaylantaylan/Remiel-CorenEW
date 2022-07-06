package me.taylan.mooncore.listeners.entitydamage;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.Painter;
import me.taylan.mooncore.utils.StatsManager;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class AttackDamage implements Listener {
	private static HashMap<UUID, String> crit = new HashMap<UUID, String>();
	private MoonCore plugin;
	private StatsManager stats;

	public AttackDamage(MoonCore plugin) {
		this.plugin = plugin;
		this.stats = plugin.getStatsManager();
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	public static HashMap<UUID, String> getCrit() {
		return crit;
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onDamage(EntityDamageByEntityEvent event) {
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
		damaged.setNoDamageTicks(0);
		if (damaged instanceof Player) {
			Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
			Player player = (Player) damaged;

			int defans = stats.getDirenc(player.getUniqueId()) + 100;
			int damageReduc = defans/ (stats.getDirenc(player.getUniqueId())
					);
			float realDamage = (float) (event.getDamage()*damageReduc);
			event.setDamage(realDamage);
			for(ItemStack item: player.getInventory().getArmorContents()) {
				if (item!= null && item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
					NamespacedKey dura = new NamespacedKey(plugin, "durability");
					ItemMeta meta = item.getItemMeta();
					int durabilt =  meta.getPersistentDataContainer().get(dura,PersistentDataType.INTEGER);
					meta.getPersistentDataContainer().set(dura,PersistentDataType.INTEGER,durabilt-1);
					item.setItemMeta(meta);
					Damageable damagemeta = (Damageable) meta;
					if(durabilt<item.getType().getMaxDurability()) {
						damagemeta.setDamage(damagemeta.getDamage()+1);
						item.setItemMeta(damagemeta);
						if(durabilt<0) {
							player.getInventory().remove(item);
							player.playSound(player, Sound.ITEM_SHIELD_BREAK,0.5F,1.3F);
						}
					} else {
						damagemeta.setDamage(0);
						item.setItemMeta(damagemeta);
					}

				}
			}
			Team isim = scoreboard.getTeam(player.getName());
			if (isim.hasEntry(player.getName())) {
				isim.setPrefix(Painter.paint("&7[&fSvy. " + stats.getLevel(player.getUniqueId()) + "&7] &f"));
				isim.setSuffix(Painter.paint(" &6[" + (int) player.getHealth() + "❤]"));
			} else {
				isim.addEntry(player.getName());
				isim.setPrefix(Painter.paint("&7[&fSvy. " + stats.getLevel(player.getUniqueId()) + "&7] &f"));
				isim.setSuffix(Painter.paint(" &6[" + (int) player.getHealth() + "❤]"));
			}

		}

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
				if (item.getType() == Material.BLAZE_ROD) {
					EntityDamageEvent event2 = new EntityDamageEvent(damaged, DamageCause.VOID, 1);
					player.setLastDamageCause(event2);
					Bukkit.getServer().getPluginManager().callEvent(event2);
				}




				if (!(player.hasCooldown(item.getType())) || item.getType() == Material.BLAZE_ROD) {
					int realDamage = (int) (event.getDamage()
							+ item.getItemMeta().getPersistentDataContainer().get(hasar, PersistentDataType.INTEGER));
					int realStrhg = stats.getGuc(player.getUniqueId())
							+ item.getItemMeta().getPersistentDataContainer().get(guc, PersistentDataType.INTEGER);
					int chance = ThreadLocalRandom.current().nextInt(102 - stats.getKritikSansi(player.getUniqueId()));
					if (chance <= 4) {
						crit.put(player.getUniqueId(), "crit");
						event.setDamage(stats.getKritikHasari(player.getUniqueId()) / 100 + 2 * realDamage
								+ 7 * realStrhg / 100 + 1);
						if (stats.getKritikAyar(player.getUniqueId())) {
							player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 0.2f, 0.8f);
							player.spawnParticle(Particle.EXPLOSION_LARGE, damaged.getLocation().add(0, 1.2, 0), 1, 0,
									0, 0, 1);
						}
					} else {
						event.setDamage(realDamage + 7 * realStrhg / 100 + 1);
					}
				} else {
					event.setCancelled(true);
				}
			} else {

				int chance = ThreadLocalRandom.current().nextInt(102 - stats.getKritikSansi(player.getUniqueId()));
				if (chance <= 4) {
					crit.put(player.getUniqueId(), "crit");
					event.setDamage(stats.getKritikHasari(player.getUniqueId()) / 100 + 2 * event.getDamage()
							+ 7 * stats.getGuc(player.getUniqueId()) / 100 + 1);
					if (stats.getKritikAyar(player.getUniqueId())) {
						player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 0.2f, 0.8f);
						player.spawnParticle(Particle.EXPLOSION_LARGE, damaged.getLocation().add(0, 1.2, 0), 1, 0, 0, 0,
								1);
					}
				} else {
					event.setDamage(event.getDamage() + 7 * stats.getGuc(player.getUniqueId()) / 100 + 1);
				}
			}

		} else if (entity instanceof Arrow) {

			Arrow arrow = (Arrow) entity;
			Player player = (Player) arrow.getShooter();
			NamespacedKey hasar = new NamespacedKey(plugin, "damage");

			ItemStack item = player.getInventory().getItemInMainHand();
			if (player.getInventory().getItemInMainHand() != null
					&& player.getInventory().getItemInMainHand().hasItemMeta()
					&& player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer() != null
					&& player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer()
							.has(hasar)) {
				int realDamage = (int) (event.getDamage()
						+ item.getItemMeta().getPersistentDataContainer().get(hasar, PersistentDataType.INTEGER));
				int chance = ThreadLocalRandom.current().nextInt(102 - stats.getKritikSansi(player.getUniqueId()));
				if (chance <= 4) {
					crit.put(arrow.getUniqueId(), "crit");
					arrow.setCritical(true);
					event.setDamage(
							stats.getKritikHasari(player.getUniqueId()) / 100 + 2 * realDamage + 5 * 5 / 100 + 1);
					if (stats.getKritikAyar(player.getUniqueId())) {
						player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 0.1f, 0.8f);
						player.spawnParticle(Particle.EXPLOSION_LARGE, damaged.getLocation().add(0, 1.2, 0), 1, 0, 0, 0,
								1);
					}
					player.playSound(player, Sound.ENTITY_ARROW_HIT_PLAYER, 0.25f, 1.2f);

				} else {
					event.setDamage(realDamage + 5 * 5 / 100 + 1);
					player.playSound(player, Sound.ENTITY_ARROW_HIT_PLAYER, 0.25f, 1.2f);
				}
			} else {

				int chance = ThreadLocalRandom.current().nextInt(102 - stats.getKritikSansi(player.getUniqueId()));
				if (chance <= 4) {
					crit.put(arrow.getUniqueId(), "crit");
					arrow.setCritical(true);
					event.setDamage(stats.getKritikHasari(player.getUniqueId()) / 100 + 2 * event.getDamage()
							+ 5 * 5 / 100 + 1);
					if (stats.getKritikAyar(player.getUniqueId())) {
					player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 0.2f, 0.8f);
					player.spawnParticle(Particle.EXPLOSION_LARGE, damaged.getLocation().add(0, 1.2, 0), 1, 0, 0, 0, 1);
					}
					player.playSound(player, Sound.ENTITY_ARROW_HIT_PLAYER, 0.25f, 1.2f);

				} else {
					event.setDamage(event.getDamage() + 5 * 5 / 100 + 1);
					player.playSound(player, Sound.ENTITY_ARROW_HIT_PLAYER, 0.25f, 1.2f);

				}
			}
		}
	}

	public Player getDamager(Entity entity) {

		if (entity instanceof Player) {
			return (Player) entity;
		} else if (entity instanceof Projectile) {
			Projectile proj = (Projectile) entity;
			ProjectileSource shooter = proj.getShooter();
			if (shooter instanceof Player) {
				return (Player) shooter;
			}
		} else if (entity instanceof Tameable) {
			Tameable animal = (Tameable) entity;
			return Bukkit.getPlayer(animal.getOwner().getUniqueId());
		}
		return null;
	}
}
