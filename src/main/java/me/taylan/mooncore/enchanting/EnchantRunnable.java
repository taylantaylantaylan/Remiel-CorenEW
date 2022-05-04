package me.taylan.mooncore.enchanting;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.listeners.EnchantListener;
import me.taylan.mooncore.utils.Painter;
import me.taylan.mooncore.utils.StatsManager;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class EnchantRunnable extends BukkitRunnable {
	private StatsManager stats;
	private EnchantListener enchantListener;
	private MoonCore plugin;
	private static HashMap<UUID, Entity> creeper = new HashMap<UUID, Entity>();
	public static HashMap<UUID, Entity> getCreeper() {
		return creeper;
	}

	private HashMap<UUID, Long> beklemeCreep = new HashMap<UUID, Long>();
	private double alpha = 0;

	public EnchantRunnable(MoonCore plugin) {
		this.plugin = plugin;
		this.enchantListener = plugin.getEnchantListener();
		this.stats = plugin.getStatsManager();
	}

	@Override
	public void run() {
		alpha += Math.PI / 32;

		for (Player player : plugin.getServer().getOnlinePlayers()) {
			int agirlik = stats.getAgirlik(player.getUniqueId());
			int maxagirlik = stats.getMaxAgirlik(player.getUniqueId());
			if (agirlik > maxagirlik) {

				player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
						new TextComponent(Painter.paint("&cYük kapasiteni aşıyorsun!")));
				player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 2, 5));
			}
			if (player.getInventory().getLeggings() == null) {
				if (creeper.get(player.getUniqueId()) != null) {
					creeper.get(player.getUniqueId()).remove();
					creeper.remove(player.getUniqueId());
				}
			}
			if (player.getInventory().getLeggings() != null
					&& player.getInventory().getLeggings().getItemMeta() != null) {
				ItemMeta meta = player.getInventory().getLeggings().getItemMeta();
				NamespacedKey key = new NamespacedKey(plugin, "Enchants");
				if (meta.getPersistentDataContainer() != null) {

					PersistentDataContainer container = meta.getPersistentDataContainer();
					if (container.has(key, EnchantConstructor.getEnchants())) {

						if (container.get(key, EnchantConstructor.getEnchants()).containsKey("soul")) {
							int level = container.get(key, EnchantConstructor.getEnchants()).get("soul");

							Location loc = player.getLocation();
							Location secondLocation = loc.clone().add(Math.cos(alpha), 0, Math.sin(alpha));
							if (!(creeper.containsKey(player.getUniqueId()))) {
								Creeper as = (Creeper) player.getWorld().spawnEntity(secondLocation,
										EntityType.CREEPER);
								as.setInvisible(true);
								as.setPowered(true);
								as.setSilent(true);
								as.setAI(false);
								as.setInvulnerable(true);
								as.setCollidable(false);
								as.setLootTable(null);
								creeper.put(player.getUniqueId(), as);
							}
							creeper.get(player.getUniqueId()).teleport(secondLocation);
							for (Entity entity : creeper.get(player.getUniqueId()).getNearbyEntities(1, 1, 1)) {
								if (!(entity instanceof LivingEntity)) {
									return;
								}
								if (entity == player || entity instanceof ArmorStand) {
									continue;
								}
								if (entity instanceof Damageable) {
									if (beklemeCreep.containsKey(player.getUniqueId())) {
										long kalansaniye = ((beklemeCreep.get(player.getUniqueId()) / 1000) + 2)
												- (System.currentTimeMillis() / 1000);
										if (kalansaniye < 1) {

											beklemeCreep.remove(player.getUniqueId());
										}

									} else {
										((LivingEntity) entity).damage(level + 1, player);
										entity.getWorld().playSound(entity.getLocation(), Sound.ENTITY_VEX_HURT, 1,
												0.1f);
										beklemeCreep.put(player.getUniqueId(), System.currentTimeMillis());
									}
								}
							}
						} else {
							if (creeper.get(player.getUniqueId()) != null) {
								creeper.get(player.getUniqueId()).remove();
								creeper.remove(player.getUniqueId());
							}
						}
					}
				}
			}

			ItemStack item2 = player.getInventory().getChestplate();
			if (item2 != null) {

				if (player.getInventory().getChestplate().getItemMeta() != null
						&& player.getInventory().getChestplate().getItemMeta().displayName() != null) {
					ItemMeta meta = player.getInventory().getChestplate().getItemMeta();
					NamespacedKey key = new NamespacedKey(plugin, "Enchants");
					if (meta.getPersistentDataContainer() != null) {

						PersistentDataContainer container = meta.getPersistentDataContainer();
						if (container.has(key, EnchantConstructor.getEnchants())) {

							if (container.get(key, EnchantConstructor.getEnchants()).containsKey("yenilen")) {
								int level = container.get(key, EnchantConstructor.getEnchants()).get("yenilen");
								if (!(enchantListener.bekleme12.containsKey(player.getUniqueId()))) {
									PotionEffect effect = new PotionEffect(PotionEffectType.REGENERATION, 60,
											level - 1);
									PotionEffect effect2 = player.getPotionEffect(PotionEffectType.REGENERATION);
									if (effect2 == null) {
										player.addPotionEffect(effect);
									}
								}
							}
						}
					}
				}
			}

			ItemStack item = player.getInventory().getChestplate();
			if (item != null) {

				if (item.getItemMeta() != null) {
					ItemMeta metaleg = item.getItemMeta();
					NamespacedKey key = new NamespacedKey(plugin, "Enchants");
					if (metaleg.getPersistentDataContainer() != null) {

						PersistentDataContainer container = metaleg.getPersistentDataContainer();
						if (container.has(key, EnchantConstructor.getEnchants())) {

							if (container.get(key, EnchantConstructor.getEnchants()).containsKey("fireres")) {
								int level = container.get(key, EnchantConstructor.getEnchants()).get("fireres");
								PotionEffect effect = new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 30, 1);
								player.addPotionEffect(effect);
							}
						}
					}
				}
			}
			ItemStack itemluck = player.getInventory().getItemInMainHand();
			if (itemluck != null) {

				if (itemluck.getItemMeta() != null) {
					ItemMeta metaleg2 = itemluck.getItemMeta();
					NamespacedKey key = new NamespacedKey(plugin, "Enchants");
					if (metaleg2.getPersistentDataContainer() != null) {

						PersistentDataContainer container3 = metaleg2.getPersistentDataContainer();
						if (container3.has(key, EnchantConstructor.getEnchants())) {

							if (container3.get(key, EnchantConstructor.getEnchants()).containsKey("luck")) {
								int level = container3.get(key, EnchantConstructor.getEnchants()).get("luck");
								PotionEffect effect = new PotionEffect(PotionEffectType.LUCK, 30, level - 1);
								player.addPotionEffect(effect);
							}
						}
					}

				}
			}

		}

	}

}
