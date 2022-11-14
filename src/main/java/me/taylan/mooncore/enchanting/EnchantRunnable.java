package me.taylan.mooncore.enchanting;

import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

import me.taylan.mooncore.commands.SeviyeCommand;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
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
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.listeners.EnchantListener;
import me.taylan.mooncore.utils.StatsManager;

public class EnchantRunnable extends BukkitRunnable {
	private final StatsManager stats;
	private final EnchantListener enchantListener;
	private final MoonCore plugin;
	private static final HashMap<UUID, Entity> creeper = new HashMap<UUID, Entity>();
	private final SeviyeCommand seviyeCommand;
	public static HashMap<UUID, Entity> getCreeper() {
		return creeper;
	}

	private final HashMap<UUID, Long> beklemeCreep = new HashMap<UUID, Long>();
	private double alpha = 0;

	public EnchantRunnable(MoonCore plugin) {
		this.plugin = plugin;
		this.enchantListener = plugin.getEnchantListener();
		this.stats = plugin.getStatsManager();
		this.seviyeCommand = plugin.getSeviyeCommand();
	}

	@Override
	public void run() {
		alpha += Math.PI / 32;

		for (Player player : plugin.getServer().getOnlinePlayers()) {
			if (player.getInventory().getLeggings() == null) {
				if (creeper.get(player.getUniqueId()) != null) {
					creeper.get(player.getUniqueId()).remove();
					creeper.remove(player.getUniqueId());
				}
			}//200
			if(stats.getKritikSansi(player.getUniqueId()) >100) {
				stats.setKritikSansiCap(player.getUniqueId());
			}
			int Exp = stats.getExp(player.getUniqueId());
			int RequiredExp = stats.getRequiredExp(player.getUniqueId());
			if (Exp >= RequiredExp) {
				seviyeCommand.seviyeAtlat(player, 1);
				stats.setRequiredExp(player.getUniqueId(), RequiredExp);
				stats.setExp0(player.getUniqueId(), 0);
				int seviye2 = stats.getLevel(player.getUniqueId()) - 2;
				if (seviye2 + 1 == 2) {
					player.discoverRecipe(NamespacedKey.minecraft("farmer_hoe"));
					player.discoverRecipe(NamespacedKey.minecraft("bone_helmet"));
					player.discoverRecipe(NamespacedKey.minecraft("wither_rose_talisman"));
				} else if (seviye2 + 1 == 3) {
					player.discoverRecipe(NamespacedKey.minecraft("brew_gaunlet"));
					player.discoverRecipe(NamespacedKey.minecraft("wolf_gaunlet"));
					player.discoverRecipe(NamespacedKey.minecraft("bone_sword"));
				} else if (seviye2 + 1 == 4) {
					player.discoverRecipe(NamespacedKey.minecraft("spider_bow"));
					player.discoverRecipe(NamespacedKey.minecraft("black_helmet"));
					player.discoverRecipe(NamespacedKey.minecraft("oksidat_pant"));
				}else if (seviye2 + 1 == 5) {
					player.discoverRecipe(NamespacedKey.minecraft("king_killer"));
					player.discoverRecipe(NamespacedKey.minecraft("experience_bottle_lapis"));
					player.discoverRecipe(NamespacedKey.minecraft("ancient_silver_spear"));
				} else if (seviye2 + 1 == 6) {
					player.discoverRecipe(NamespacedKey.minecraft("hellfire_dagger"));
					player.discoverRecipe(NamespacedKey.minecraft("mistik_bow"));
					player.discoverRecipe(NamespacedKey.minecraft("silver_block"));
				} else if (seviye2 + 1 == 7) {
					player.discoverRecipe(NamespacedKey.minecraft("magma_sword"));
					player.discoverRecipe(NamespacedKey.minecraft("golem_gaunlet"));
					player.discoverRecipe(NamespacedKey.minecraft("golem_chestplate"));
				}
			}
			if(player.getInventory().getItemInMainHand() != null && player.getInventory().getItemInMainHand().hasItemMeta() && player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer() != null) {
				if(player.getInventory().getItemInMainHand().getType() == Material.WOODEN_SHOVEL || player.getInventory().getItemInMainHand().getType() == Material.WOODEN_HOE|| player.getInventory().getItemInMainHand().getType() == Material.DIAMOND_SWORD || player.getInventory().getItemInMainHand().getType() == Material.STICK) {
					PotionEffect effect = new PotionEffect(PotionEffectType.SLOW_DIGGING, 60,
							1,false,false,false);
					PotionEffect effect2 = player.getPotionEffect(PotionEffectType.SLOW_DIGGING);
					if (effect2 == null) {
						player.addPotionEffect(effect);
					}
				} else if(player.getInventory().getItemInMainHand().getType() == Material.GOLDEN_AXE|| player.getInventory().getItemInMainHand().getType() == Material.GOLDEN_HOE ||player.getInventory().getItemInMainHand().getType() == Material.GOLDEN_SHOVEL  ) {
					PotionEffect effect = new PotionEffect(PotionEffectType.SLOW_DIGGING, 60,
							0, false, false, false);
					PotionEffect effect2 = player.getPotionEffect(PotionEffectType.SLOW_DIGGING);
					if (effect2 == null) {
						player.addPotionEffect(effect);
					}
				}
			}
			if (stats.getHepsi(player.getUniqueId()).get(1).hasItemMeta() && stats.getHepsi(player.getUniqueId()).get(1).getItemMeta().getDisplayName().contains("Madenci")) {
				PotionEffect effect = new PotionEffect(PotionEffectType.FAST_DIGGING, 60,
						1, false, false, false);
				PotionEffect effect2 = player.getPotionEffect(PotionEffectType.FAST_DIGGING);
				if (effect2 == null) {
					player.addPotionEffect(effect);
				}
			}
			if(stats.getCan(player.getUniqueId()) <=0) {
				stats.setCan1(player.getUniqueId());
			}
			if(stats.getDirenc(player.getUniqueId()) <=0) {
				stats.setDirenc1(player.getUniqueId());
			}
			if(stats.getKritikSansi(player.getUniqueId()) >100) {
				stats.setKritikSansiCap(player.getUniqueId());
			}
			Location loc2 = player.getLocation().add(0, -1, 0);
			Block block = loc2.getBlock().getRelative(BlockFace.DOWN);
			if(block.getType() == Material.DIRT_PATH) {
				PotionEffect effect = new PotionEffect(PotionEffectType.SPEED, 120,
						0, false, false, false);
				PotionEffect effect2 = player.getPotionEffect(PotionEffectType.SPEED);
				if (effect2 == null) {
					player.addPotionEffect(effect);
				}
			}

			if(stats.getHiz(player.getUniqueId()) >81) {
				stats.setSpeedCap(player.getUniqueId());
			}
			switch (stats.getHiz(player.getUniqueId())) {
				case -10 -> player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.05);
				case 0 -> player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.1);
				case 20 -> player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.15);
				case 40 -> player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.2);
				case 60 -> player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.25);
				case 80 -> player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.30);
			}
			/*if(stats.getFurnaceAmount(player.getUniqueId()) ==0) {
				InventoryClickListener.getFurnaceBlock().remove(player.getUniqueId());
			}
			if(stats.getCookAmount(player.getUniqueId()) ==0) {
				InventoryClickListener.getCookBlock().remove(player.getUniqueId());
			}*/
			if(stats.getKritikSansi(player.getUniqueId()) >100) {
				stats.setKritikSansiCap(player.getUniqueId());
			}
			if(stats.getSaldiriHizi(player.getUniqueId()) >100) {
				stats.setSaldiriHiziCap(player.getUniqueId());
			}
			if (player.getInventory().getLeggings() != null
					&& player.getInventory().getLeggings().getItemMeta() != null) {
				ItemMeta meta = player.getInventory().getLeggings().getItemMeta();
				NamespacedKey key = new NamespacedKey(plugin, "Enchants");
				if (meta.getPersistentDataContainer() != null) {

					PersistentDataContainer container = meta.getPersistentDataContainer();
					if (container.has(key, EnchantConstructor.getEnchants())) {

						if (Objects.requireNonNull(container.get(key, EnchantConstructor.getEnchants())).containsKey("soul")) {
							int level = Objects.requireNonNull(container.get(key, EnchantConstructor.getEnchants())).get("soul");

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

							if (Objects.requireNonNull(container.get(key, EnchantConstructor.getEnchants())).containsKey("yenilen")) {
								int level = Objects.requireNonNull(container.get(key, EnchantConstructor.getEnchants())).get("yenilen");
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

							if (Objects.requireNonNull(container.get(key, EnchantConstructor.getEnchants())).containsKey("fireres")) {
								int level = Objects.requireNonNull(container.get(key, EnchantConstructor.getEnchants())).get("fireres");
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

							if (Objects.requireNonNull(container3.get(key, EnchantConstructor.getEnchants())).containsKey("luck")) {
								int level = Objects.requireNonNull(container3.get(key, EnchantConstructor.getEnchants())).get("luck");
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
