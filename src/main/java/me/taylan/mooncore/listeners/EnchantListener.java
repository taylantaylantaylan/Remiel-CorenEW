package me.taylan.mooncore.listeners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Giant;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerFishEvent.State;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;
import org.bukkit.util.Vector;

import com.manya.pdc.DataTypes;

import io.papermc.paper.event.entity.EntityMoveEvent;
import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.Painter;
import me.taylan.mooncore.utils.StatsManager;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class EnchantListener implements Listener {
	private PersistentDataType<?, HashMap<String, Integer>> Enchants = DataTypes.hashMap(PersistentDataType.STRING,
			PersistentDataType.INTEGER);
	private MoonCore plugin;
	private StatsManager stats;
	private int beklemetime = 10;
	private HashMap<UUID, Long> bekleme2 = new HashMap<UUID, Long>();
	private HashMap<UUID, Long> bekleme3 = new HashMap<UUID, Long>();
	private HashMap<UUID, Long> bekleme4 = new HashMap<UUID, Long>();
	private HashMap<UUID, Long> bekleme5 = new HashMap<UUID, Long>();
	private HashMap<UUID, Long> bekleme6 = new HashMap<UUID, Long>();
	private HashMap<UUID, Long> bekleme7 = new HashMap<UUID, Long>();
	private HashMap<UUID, Long> bekleme8 = new HashMap<UUID, Long>();
	private HashMap<UUID, Long> bekleme9 = new HashMap<UUID, Long>();
	private HashMap<UUID, Long> bekleme10 = new HashMap<UUID, Long>();
	private HashMap<UUID, Long> bekleme11 = new HashMap<UUID, Long>();
	public HashMap<UUID, String> parry = new HashMap<UUID, String>();
	public HashMap<UUID, Long> bekleme12 = new HashMap<UUID, Long>();
	public HashMap<UUID, Giant> giant = new HashMap<UUID, Giant>();
	public HashMap<String, Entity> kalista = new HashMap<String, Entity>();
	public HashMap<UUID, Integer> bleed = new HashMap<UUID, Integer>();
	public HashMap<UUID, Integer> ofke = new HashMap<UUID, Integer>();
	public HashMap<UUID, Integer> kazık = new HashMap<UUID, Integer>();
	public HashMap<UUID, Integer> vayne = new HashMap<UUID, Integer>();
	public HashMap<UUID, Integer> quick = new HashMap<UUID, Integer>();
	public HashMap<UUID, List<ItemStack>> armorsave = new HashMap<UUID, List<ItemStack>>();

	public EnchantListener(MoonCore plugin) {
		this.stats = plugin.getStatsManager();
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void zehir(EntityDamageByEntityEvent event) {

		if (!(event.getEntity() instanceof LivingEntity && event.getDamager() instanceof Player))
			return;

		LivingEntity defender = (LivingEntity) event.getEntity();
		Player player = (Player) event.getDamager();
		ItemStack item = player.getInventory().getItemInMainHand();
		if (item == null) {
			return;
		}

		if (player.getInventory().getItemInMainHand().getItemMeta() != null
				&& player.getInventory().getItemInMainHand().getItemMeta().displayName() != null) {
			ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
			NamespacedKey key = new NamespacedKey(plugin, "Enchants");
			if (meta.getPersistentDataContainer() == null)
				return;
			;
			PersistentDataContainer container = meta.getPersistentDataContainer();
			if (!container.has(key, Enchants))
				return;
			if (container.get(key, Enchants).containsKey("zehir")) {
				int level = container.get(key, Enchants).get("zehir");
				PotionEffect effect2 = defender.getPotionEffect(PotionEffectType.POISON);
				PotionEffect effect = new PotionEffect(PotionEffectType.POISON, 40 * level, 2);
				if (effect2 == null) {
					defender.addPotionEffect(effect);
					World world = defender.getWorld();
					Location loc = defender.getLocation().add(1, 0.3, 0);
					world.spawn(loc, ArmorStand.class, armorStand -> {
						armorStand.setMarker(true);
						armorStand.setVisible(false);
						armorStand.setGravity(false);
						armorStand.setSmall(true);
						armorStand.setInvulnerable(true);
						armorStand.setCustomNameVisible(true);
						armorStand.customName(MiniMessage.get().parse("<green>☣"));
						plugin.getIndicators().put(armorStand, 0);
						new BukkitRunnable() {

							@Override
							public void run() {
								Location loci = armorStand.getLocation().add(0, 0.1, 0);
								armorStand.teleport(loci);
								Integer timer2 = plugin.getIndicators().get(armorStand);
								timer2++;
								plugin.getIndicators().put(armorStand, timer2);
								if (timer2 >= 30) {
									timer2 = 0;
									plugin.getIndicators().remove(armorStand);
									armorStand.remove();
									cancel();
								}
							}
						}.runTaskTimer(plugin, 0L, 2L);

					});
				}
			}
		}

	}

	@EventHandler
	public void shovelknight(EntityDamageByEntityEvent event) {

		if (!(event.getEntity() instanceof LivingEntity && event.getDamager() instanceof Player))
			return;

		LivingEntity defender = (LivingEntity) event.getEntity();
		Player player = (Player) event.getDamager();
		ItemStack item = player.getInventory().getItemInMainHand();
		if (item == null) {
			return;
		}

		if (player.getInventory().getItemInMainHand().getItemMeta() != null
				&& player.getInventory().getItemInMainHand().getItemMeta().displayName() != null) {
			ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
			NamespacedKey key = new NamespacedKey(plugin, "Enchants");
			if (meta.getPersistentDataContainer() == null)
				return;
			;
			PersistentDataContainer container = meta.getPersistentDataContainer();
			if (!container.has(key, Enchants))
				return;
			if (container.get(key, Enchants).containsKey("shovelknight")) {
				int level = container.get(key, Enchants).get("shovelknight");
				event.setDamage(event.getDamage() + level * +5);

			}
		}

	}

	@EventHandler
	public void absolutezero(EntityDamageByEntityEvent event) {

		if (!(event.getEntity() instanceof Player && event.getDamager() instanceof LivingEntity))
			return;

		Player player = (Player) event.getEntity();
		LivingEntity attacker = (LivingEntity) event.getDamager();
		ItemStack item = player.getInventory().getLeggings();
		if (item == null) {
			return;
		}

		if (player.getInventory().getLeggings() != null && player.getInventory().getLeggings().getItemMeta() != null) {
			ItemMeta meta = player.getInventory().getLeggings().getItemMeta();
			NamespacedKey key = new NamespacedKey(plugin, "Enchants");
			if (meta.getPersistentDataContainer() == null)
				return;
			;
			PersistentDataContainer container = meta.getPersistentDataContainer();
			if (!container.has(key, Enchants))
				return;
			if (container.get(key, Enchants).containsKey("ice")) {
				int level = container.get(key, Enchants).get("ice");
				PotionEffect effect2 = attacker.getPotionEffect(PotionEffectType.SLOW_DIGGING);
				PotionEffect effect = new PotionEffect(PotionEffectType.SLOW_DIGGING, 200 * level, 1);
				PotionEffect effect3 = new PotionEffect(PotionEffectType.SLOW, 200 * level, 1);
				if (effect2 == null) {
					attacker.addPotionEffect(effect);
					attacker.addPotionEffect(effect3);
					World world = attacker.getWorld();
					Location loc = attacker.getLocation().add(0, 0.3, 0);
					world.spawn(loc, ArmorStand.class, armorStand -> {
						armorStand.setMarker(true);
						armorStand.setVisible(false);
						armorStand.setGravity(false);
						armorStand.setSmall(true);
						armorStand.setInvulnerable(true);
						armorStand.setCustomNameVisible(true);
						armorStand.customName(MiniMessage.get().parse("<aqua>❆"));
						plugin.getIndicators().put(armorStand, 0);
						new BukkitRunnable() {

							@Override
							public void run() {
								Location loci = armorStand.getLocation().add(0, 0.1, 0);
								armorStand.teleport(loci);
								Integer timer2 = plugin.getIndicators().get(armorStand);
								timer2++;
								plugin.getIndicators().put(armorStand, timer2);
								if (timer2 >= 20) {
									timer2 = 0;
									plugin.getIndicators().remove(armorStand);
									armorStand.remove();
									cancel();
								}
							}
						}.runTaskTimer(plugin, 0L, 2L);

					});
				}
			}
		}

	}

	@EventHandler
	public void ofkecheck(EntityDamageByEntityEvent event) {

		if (!(event.getEntity() instanceof Player && event.getDamager() instanceof LivingEntity))
			return;

		Player player = (Player) event.getEntity();
		LivingEntity attacker = (LivingEntity) event.getDamager();
		ItemStack item = player.getInventory().getItemInMainHand();
		if (item == null) {
			return;
		}

		if (player.getInventory().getItemInMainHand() != null
				&& player.getInventory().getItemInMainHand().getItemMeta() != null) {
			ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
			NamespacedKey key = new NamespacedKey(plugin, "Enchants");
			if (meta.getPersistentDataContainer() == null)
				return;
			;
			PersistentDataContainer container = meta.getPersistentDataContainer();
			if (!container.has(key, Enchants))
				return;
			if (container.get(key, Enchants).containsKey("ofke")) {
				if (ofke.containsKey(player.getUniqueId())) {
					ofke.remove(player.getUniqueId());
					player.sendMessage(Painter.paint("&cÖfken Sona Erdi!"));

				}
			}
		}

	}

	@EventHandler
	public void sabotage(EntityDamageByEntityEvent event) {

		if (!(event.getEntity() instanceof Player && event.getDamager() instanceof LivingEntity))
			return;

		Player player = (Player) event.getEntity();
		LivingEntity attacker = (LivingEntity) event.getDamager();
		ItemStack item = player.getInventory().getChestplate();
		if (item == null) {
			return;
		}

		if (player.getInventory().getChestplate() != null
				&& player.getInventory().getChestplate().getItemMeta() != null) {
			ItemMeta meta = player.getInventory().getChestplate().getItemMeta();
			NamespacedKey key = new NamespacedKey(plugin, "Enchants");
			if (meta.getPersistentDataContainer() == null)
				return;
			;
			PersistentDataContainer container = meta.getPersistentDataContainer();
			if (!container.has(key, Enchants))
				return;
			if (container.get(key, Enchants).containsKey("sabotage")) {
				int level = container.get(key, Enchants).get("sabotage");
				Random rand = new Random();
				int chance = rand.nextInt(120 / level);
				if (chance <= 10) {
					PotionEffect effect2 = attacker.getPotionEffect(PotionEffectType.SLOW_DIGGING);
					PotionEffect effect = new PotionEffect(PotionEffectType.WEAKNESS, 40 * level, 1);
					PotionEffect effect3 = new PotionEffect(PotionEffectType.BLINDNESS, 40 * level, 1);
					if (effect2 == null) {
						attacker.addPotionEffect(effect);
						attacker.addPotionEffect(effect3);
						World world = attacker.getWorld();
						Location loc = attacker.getLocation().add(1, 0.3, 0);
						world.spawn(loc, ArmorStand.class, armorStand -> {
							armorStand.setMarker(true);
							armorStand.setVisible(false);
							armorStand.setGravity(false);
							armorStand.setSmall(true);
							armorStand.setInvulnerable(true);
							armorStand.setCustomNameVisible(true);
							armorStand.customName(MiniMessage.get().parse("<#446A58>SABOTAJ"));
							plugin.getIndicators().put(armorStand, 0);
							new BukkitRunnable() {

								@Override
								public void run() {
									Location loci = armorStand.getLocation().add(0, 0.1, 0);
									armorStand.teleport(loci);
									Integer timer2 = plugin.getIndicators().get(armorStand);
									timer2++;
									plugin.getIndicators().put(armorStand, timer2);
									if (timer2 >= 30) {
										timer2 = 0;
										plugin.getIndicators().remove(armorStand);
										armorStand.remove();
										cancel();
									}
								}
							}.runTaskTimer(plugin, 0L, 2L);

						});

					}
				}
			}
		}

	}

	@EventHandler
	public void revenge(PlayerDeathEvent event) {

		Player player = event.getPlayer();

		ItemStack item = player.getInventory().getChestplate();
		if (item == null) {
			return;
		}

		if (player.getInventory().getChestplate() != null
				&& player.getInventory().getChestplate().getItemMeta() != null) {
			ItemMeta meta = player.getInventory().getChestplate().getItemMeta();
			NamespacedKey key = new NamespacedKey(plugin, "Enchants");
			if (meta.getPersistentDataContainer() == null)
				return;

			PersistentDataContainer container = meta.getPersistentDataContainer();
			if (!container.has(key, Enchants))
				return;
			if (container.get(key, Enchants).containsKey("revenge")) {
				int level = container.get(key, Enchants).get("revenge");
				Random rand = new Random();
				int chance = rand.nextInt(120 / level);
				if (chance <= 10) {
					event.setCancelled(true);
					player.getWorld().spawnParticle(Particle.VILLAGER_ANGRY, player.getLocation().add(0, 1, 0), 20, 0.1,
							0.1, 0.1, 0.1);
					player.getWorld().playSound(player, Sound.ENTITY_WITHER_SPAWN, 2, 0.4f);
					player.sendMessage(Painter.paint("&c***İntikam büyüsü tetiklendi!***"));

				}
			}
		}

	}

	@EventHandler
	public void guard(EntityDamageByEntityEvent event) {

		if (!(event.getEntity() instanceof LivingEntity && event.getDamager() instanceof Player))
			return;
		LivingEntity defender = (LivingEntity) event.getEntity();
		Player player = (Player) event.getDamager();
		ItemStack item = player.getInventory().getLeggings();
		if (item == null) {
			return;
		}

		if (player.getInventory().getLeggings().getItemMeta() != null
				&& player.getInventory().getLeggings().getItemMeta().displayName() != null) {
			ItemMeta meta = player.getInventory().getLeggings().getItemMeta();
			NamespacedKey key = new NamespacedKey(plugin, "Enchants");
			if (meta.getPersistentDataContainer() == null)
				return;
			;
			PersistentDataContainer container = meta.getPersistentDataContainer();
			if (!container.has(key, Enchants))
				return;
			if (container.get(key, Enchants).containsKey("guard")) {
				int level = container.get(key, Enchants).get("guard");
				if (player.getHealth() < 4) {
					event.setDamage(event.getDamage() + level + 2);
				}

			}
		}

	}

	@EventHandler
	public void barbarian(EntityDamageByEntityEvent event) {

		if (!(event.getEntity() instanceof LivingEntity && event.getDamager() instanceof Player)) {
			return;
		}
		LivingEntity defender = (LivingEntity) event.getEntity();
		Player player = (Player) event.getDamager();
		ItemStack item = player.getInventory().getHelmet();
		if (item == null) {
			return;
		}

		if (player.getInventory().getHelmet().getItemMeta() != null) {
			ItemMeta meta = player.getInventory().getHelmet().getItemMeta();
			NamespacedKey key = new NamespacedKey(plugin, "Enchants");
			if (meta.getPersistentDataContainer() == null)
				return;
			;
			PersistentDataContainer container = meta.getPersistentDataContainer();
			if (!container.has(key, Enchants))
				return;
			if (container.get(key, Enchants).containsKey("barbarian")) {
				int level = container.get(key, Enchants).get("barbarian");
				event.setDamage(level + event.getDamage() * 2);

			}
		}

	}

	@EventHandler
	public void ofke(EntityDamageByEntityEvent event) {

		if (!(event.getEntity() instanceof LivingEntity && event.getDamager() instanceof Player)) {
			return;
		}
		LivingEntity defender = (LivingEntity) event.getEntity();
		Player player = (Player) event.getDamager();
		ItemStack item = player.getInventory().getItemInMainHand();
		if (item == null) {
			return;
		}

		if (player.getInventory().getItemInMainHand().getItemMeta() != null) {
			ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
			NamespacedKey key = new NamespacedKey(plugin, "Enchants");
			if (meta.getPersistentDataContainer() == null)
				return;
			;
			PersistentDataContainer container = meta.getPersistentDataContainer();
			if (!container.has(key, Enchants))
				return;
			if (container.get(key, Enchants).containsKey("ofke")) {
				int level = container.get(key, Enchants).get("ofke");
				if (ofke.containsKey(player.getUniqueId())) {
					int rageamount = ofke.get(player.getUniqueId());
					if (rageamount <= level + 2) {
						rageamount += 3;
						ofke.put(player.getUniqueId(), rageamount);
						event.setDamage(event.getFinalDamage() * rageamount / 9);
						player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
								new TextComponent(Painter.paint("&cÖfke Hasarı &e+ " + rageamount / 9 + "&ex")));
					} else {
						event.setDamage(event.getFinalDamage() * rageamount / 9);
						player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
								new TextComponent(Painter.paint("&cÖfke Hasarı &e+ " + rageamount / 9 + "&ex")));
					}
				} else {
					ofke.put(player.getUniqueId(), 0);
				}

			}
		}

	}

	@EventHandler
	public void souldamager(EntityDamageByEntityEvent event) {

		if (!(event.getEntity() instanceof LivingEntity && event.getDamager() instanceof Player)) {
			return;
		}
		LivingEntity defender = (LivingEntity) event.getEntity();
		Player player = (Player) event.getDamager();
		ItemStack item = player.getInventory().getItemInMainHand();
		if (item == null) {
			return;
		}

		if (player.getInventory().getItemInMainHand().getItemMeta() != null) {
			ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
			NamespacedKey key = new NamespacedKey(plugin, "Enchants");
			NamespacedKey soul = new NamespacedKey(plugin, "soul");
			if (meta.getPersistentDataContainer() == null)
				return;
			;
			PersistentDataContainer container = meta.getPersistentDataContainer();
			if (!container.has(key, Enchants))
				return;
			if (container.get(key, Enchants).containsKey("souleater")) {
				int level = container.get(key, Enchants).get("souleater");
				event.setDamage(event.getDamage() + container.get(soul, PersistentDataType.INTEGER) + 2 / 10);

			}
		}

	}

	@EventHandler
	public void souleater(EntityDeathEvent event) {

		if (!(event.getEntity() instanceof LivingEntity && event.getEntity().getKiller() instanceof Player)) {
			return;
		}
		LivingEntity defender = (LivingEntity) event.getEntity();
		Player player = (Player) defender.getKiller();
		ItemStack item = player.getInventory().getItemInMainHand();
		if (item == null) {
			return;
		}

		if (player.getInventory().getItemInMainHand().getItemMeta() != null) {
			ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
			NamespacedKey key = new NamespacedKey(plugin, "Enchants");
			NamespacedKey soul = new NamespacedKey(plugin, "soul");
			if (meta.getPersistentDataContainer() == null)
				return;
			;
			PersistentDataContainer container = meta.getPersistentDataContainer();
			if (!container.has(key, Enchants))
				return;
			if (container.get(key, Enchants).containsKey("souleater")) {
				int level = container.get(key, Enchants).get("souleater");

				int soulamount = container.get(soul, PersistentDataType.INTEGER);
				soulamount += 1;
				container.set(soul, PersistentDataType.INTEGER, soulamount);
				List<String> itemLore = item.getItemMeta().getLore();
				for (int i = 0; i < itemLore.size(); i++) {
					String lValue = itemLore.get(i);
					if (lValue.contains(Painter.paint("&3Toplanan Ruhlar:"))) {
						itemLore.set(i, Painter.paint("&3Toplanan Ruhlar: &b" + soulamount));
						break;
					}

				}
				ItemStack soulitem = item.clone();
				ItemMeta soulmeta = soulitem.getItemMeta();
				soulmeta.setLore(itemLore);
				soulitem.setItemMeta(soulmeta);
				player.getInventory().remove(item);
				player.getInventory().addItem(soulitem);

			}
		}

	}

	@EventHandler
	public void experience(BlockBreakEvent event) {
		if (event.getPlayer() == null) {
			return;
		}
		Player player = event.getPlayer();
		Block block = event.getBlock();
		ItemStack item = player.getInventory().getItemInMainHand();
		if (item == null) {
			return;
		}

		if (player.getInventory().getItemInMainHand().getItemMeta() != null) {
			ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
			NamespacedKey key = new NamespacedKey(plugin, "Enchants");
			if (meta.getPersistentDataContainer() == null)
				return;
			;
			PersistentDataContainer container = meta.getPersistentDataContainer();
			if (!container.has(key, Enchants))
				return;
			if (container.get(key, Enchants).containsKey("xp")) {
				int level = container.get(key, Enchants).get("xp");
				if (block.getType() == Material.COAL_ORE || block.getType() == Material.REDSTONE_ORE
						|| block.getType() == Material.LAPIS_ORE

						|| block.getType() == Material.DIAMOND_ORE || block.getType() == Material.NETHER_QUARTZ_ORE) {
					event.setExpToDrop(event.getExpToDrop() + level * 3);
				}
			}
		}
	}

	@EventHandler
	public void playerfish(PlayerFishEvent event) {
		Player player = event.getPlayer();
		ItemStack item = player.getInventory().getItemInMainHand();
		if (item == null) {
			return;
		}

		if (player.getInventory().getItemInMainHand().getItemMeta() != null) {
			ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
			NamespacedKey key = new NamespacedKey(plugin, "Enchants");
			if (meta.getPersistentDataContainer() == null)
				return;
			;
			PersistentDataContainer container = meta.getPersistentDataContainer();
			if (!container.has(key, Enchants))
				return;
			if (container.get(key, Enchants).containsKey("siftah")) {
				int level = container.get(key, Enchants).get("siftah");
				Random rand = new Random();
				int chance = rand.nextInt(120 / level);
				if (chance <= 10) {
					if (event.getState() == State.CAUGHT_FISH) {
						Item item2 = (Item) event.getCaught();
						ItemStack loot = item2.getItemStack();
						player.getInventory().addItem(loot);
					}
				}
			}
		}
	}

	@EventHandler
	public void fishingrodattack(PlayerFishEvent event) {
		Player player = event.getPlayer();
		if (event.getState() == State.CAUGHT_ENTITY) {
			if (event.getCaught() != null) {
				if (!(event.getCaught() instanceof LivingEntity)) {
					return;
				}
				ItemStack item = player.getInventory().getItemInMainHand();
				if (item == null) {
					return;
				}

				if (player.getInventory().getItemInMainHand().getItemMeta() != null) {
					ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
					NamespacedKey key = new NamespacedKey(plugin, "Enchants");
					if (meta.getPersistentDataContainer() == null)
						return;
					;
					PersistentDataContainer container = meta.getPersistentDataContainer();
					if (!container.has(key, Enchants))
						return;
					if (container.get(key, Enchants).containsKey("keskinkanca")) {
						int level = container.get(key, Enchants).get("keskinkanca");
						LivingEntity entity = (LivingEntity) event.getCaught();
						entity.damage(stats.getGuc(player.getUniqueId()) + level + 1, player);
						event.getHook().remove();
					} else {
						LivingEntity entity = (LivingEntity) event.getCaught();
						entity.damage(stats.getGuc(player.getUniqueId()) + 1, player);
						event.getHook().remove();
					}
				}

			}
		}
	}

	@EventHandler
	public void hazine(BlockBreakEvent event) {
		if (event.getPlayer() == null) {
			return;
		}
		Player player = event.getPlayer();
		Block block = event.getBlock();
		ItemStack item = player.getInventory().getItemInMainHand();
		if (item == null) {
			return;
		}

		if (player.getInventory().getItemInMainHand().getItemMeta() != null) {
			ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
			NamespacedKey key = new NamespacedKey(plugin, "Enchants");
			if (meta.getPersistentDataContainer() == null)
				return;
			;
			PersistentDataContainer container = meta.getPersistentDataContainer();
			if (!container.has(key, Enchants))
				return;
			if (container.get(key, Enchants).containsKey("hazine")) {
				int level = container.get(key, Enchants).get("hazine");
				if (block.getType() == Material.DIRT || block.getType() == Material.SAND
						|| block.getType() == Material.GRASS_BLOCK || block.getType() == Material.COARSE_DIRT

						|| block.getType() == Material.PODZOL || block.getType() == Material.GRAVEL) {
					Random rand = new Random();
					int chance = rand.nextInt(240 / level);
					if (chance == 4) {
						player.getInventory().addItem(new ItemStack(Material.DIAMOND));
						player.sendMessage(Painter.paint("&eHazine Avcısı: &aKazı yaparken bir elmas buldun!"));
					}
					if (chance == 3) {
						player.getInventory().addItem(new ItemStack(Material.BONE));
						player.sendMessage(Painter.paint("&eHazine Avcısı: &aKazı yaparken bir kemik buldun!"));
					}
					if (chance == 2) {
						player.getInventory().addItem(new ItemStack(Material.GOLD_NUGGET));
						player.sendMessage(Painter.paint("&eHazine Avcısı: &aKazı yaparken bir altın parçası buldun!"));
					}
					if (chance == 1) {
						player.getInventory().addItem(new ItemStack(Material.GLASS_BOTTLE));
						player.sendMessage(Painter.paint("&eHazine Avcısı: &aKazı yaparken bir şişe buldun!"));
					}
					if (chance == 5) {
						player.getInventory().addItem(new ItemStack(Material.RAW_COPPER));
						player.sendMessage(Painter.paint("&eHazine Avcısı: &aKazı yaparken bir bakır madeni buldun!"));
					}
					if (chance == 6) {
						player.getInventory().addItem(new ItemStack(Material.IRON_NUGGET));
						player.sendMessage(Painter.paint("&eHazine Avcısı: &aKazı yaparken bir demir parçası buldun!"));
					}
				}
			}
		}
	}

	@EventHandler
	public void slayer(EntityDamageByEntityEvent event) {

		if (!(event.getEntity() instanceof LivingEntity && event.getDamager() instanceof Player)) {
			return;
		}
		LivingEntity defender = (LivingEntity) event.getEntity();
		Player player = (Player) event.getDamager();
		ItemStack item = player.getInventory().getHelmet();
		if (item == null) {
			return;
		}

		if (player.getInventory().getHelmet().getItemMeta() != null) {
			ItemMeta meta = player.getInventory().getHelmet().getItemMeta();
			NamespacedKey key = new NamespacedKey(plugin, "Enchants");
			if (meta.getPersistentDataContainer() == null)
				return;
			;
			PersistentDataContainer container = meta.getPersistentDataContainer();
			if (!container.has(key, Enchants))
				return;
			if (container.get(key, Enchants).containsKey("slayer")) {
				int level = container.get(key, Enchants).get("slayer");
				if (defender.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() > player
						.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue())
					event.setDamage(level + event.getDamage() + 2);

			}
		}

	}

	@EventHandler
	public void wisdom(EntityDeathEvent event) {

		if (!(event.getEntity() instanceof LivingEntity && event.getEntity().getKiller() instanceof LivingEntity)) {
			return;
		}
		LivingEntity defender = (LivingEntity) event.getEntity();
		Player player = (Player) event.getEntity().getKiller();
		ItemStack item = player.getInventory().getHelmet();
		if (item == null) {
			return;
		}

		if (player.getInventory().getHelmet().getItemMeta() != null) {
			ItemMeta meta = player.getInventory().getHelmet().getItemMeta();
			NamespacedKey key = new NamespacedKey(plugin, "Enchants");
			if (meta.getPersistentDataContainer() == null)
				return;
			;
			PersistentDataContainer container = meta.getPersistentDataContainer();
			if (!container.has(key, Enchants))
				return;
			if (container.get(key, Enchants).containsKey("wisdom")) {
				int level = container.get(key, Enchants).get("wisdom");
				event.setDroppedExp(event.getDroppedExp() + level * 100);

			}
		}

	}

	@EventHandler
	public void archerhead(EntityDamageByEntityEvent event) {

		if (!(event.getEntity() instanceof LivingEntity && event.getDamager() instanceof Arrow))
			return;
		LivingEntity defender = (LivingEntity) event.getEntity();
		Arrow arrow = (Arrow) event.getDamager();
		if (!(arrow.getShooter() instanceof Player)) {
			return;
		}
		Player player = (Player) arrow.getShooter();
		ItemStack item = player.getInventory().getHelmet();
		if (item == null) {
			return;
		}

		if (player.getInventory().getHelmet().getItemMeta() != null) {
			ItemMeta meta = player.getInventory().getHelmet().getItemMeta();
			NamespacedKey key = new NamespacedKey(plugin, "Enchants");
			if (meta.getPersistentDataContainer() == null)
				return;
			;
			PersistentDataContainer container = meta.getPersistentDataContainer();
			if (!container.has(key, Enchants))
				return;
			if (container.get(key, Enchants).containsKey("archerhead")) {
				int level = container.get(key, Enchants).get("archerhead");
				event.setDamage(level + event.getDamage() * 2);

			}
		}

	}

	@EventHandler
	public void yenilen(EntityDamageByEntityEvent event) {

		if (!(event.getEntity() instanceof Player && event.getDamager() instanceof LivingEntity))
			return;
		Player player = (Player) event.getEntity();
		LivingEntity attacker = (LivingEntity) event.getDamager();
		ItemStack item = player.getInventory().getChestplate();
		if (item == null) {
			return;
		}

		if (item.getItemMeta() != null) {
			ItemMeta metaleg = item.getItemMeta();
			NamespacedKey key = new NamespacedKey(plugin, "Enchants");
			if (metaleg.getPersistentDataContainer() == null)
				return;
			;
			PersistentDataContainer container = metaleg.getPersistentDataContainer();
			if (!container.has(key, Enchants))
				return;
			if (container.get(key, Enchants).containsKey("yenilen")) {
				int level = container.get(key, Enchants).get("yenilen");
				if (bekleme12.containsKey(player.getUniqueId())) {
					long kalansaniye = ((bekleme12.get(player.getUniqueId()) / 1000) + beklemetime)
							- (System.currentTimeMillis() / 1000);
				} else {
					new BukkitRunnable() {

						@Override
						public void run() {
							long kalansaniye = ((bekleme12.get(player.getUniqueId()) / 1000) + beklemetime)
									- (System.currentTimeMillis() / 1000);
							if (kalansaniye < 1) {

								bekleme12.remove(player.getUniqueId());
								cancel();
							}
						}
					}.runTaskTimer(plugin, 0, 20);
					bekleme12.put(player.getUniqueId(), System.currentTimeMillis());

				}

			}
		}

	}

	@EventHandler
	public void kutsal(EntityDamageByEntityEvent event) {

		if (!(event.getEntity() instanceof Player && event.getDamager() instanceof LivingEntity))
			return;
		Player player = (Player) event.getEntity();
		LivingEntity attacker = (LivingEntity) event.getDamager();
		ItemStack item = player.getInventory().getChestplate();
		if (item == null) {
			return;
		}

		if (item.getItemMeta() != null) {
			ItemMeta metaleg = item.getItemMeta();
			NamespacedKey key = new NamespacedKey(plugin, "Enchants");
			if (metaleg.getPersistentDataContainer() == null)
				return;
			;
			PersistentDataContainer container = metaleg.getPersistentDataContainer();
			if (!container.has(key, Enchants))
				return;
			if (container.get(key, Enchants).containsKey("kutsal")) {
				int level = container.get(key, Enchants).get("kutsal");
				PotionEffect effect2 = player.getPotionEffect(PotionEffectType.BLINDNESS);
				PotionEffect effect3 = player.getPotionEffect(PotionEffectType.SLOW);
				if (effect2 != null) {
					player.removePotionEffect(PotionEffectType.BLINDNESS);
					player.getWorld().spawnParticle(Particle.SPELL_INSTANT, player.getLocation().add(0, 1, 0), 20, 0.3,
							0.5, 0.3, 0.2);

				}
				if (effect3 != null) {
					player.removePotionEffect(PotionEffectType.SLOW);
					player.getWorld().spawnParticle(Particle.SPELL_INSTANT, player.getLocation().add(0, 1, 0), 20, 0.3,
							0.5, 0.3, 0.2);
				}

			}
		}

	}

	@EventHandler
	public void lanet(EntityDamageByEntityEvent event) {

		if (!(event.getEntity() instanceof LivingEntity && event.getDamager() instanceof Player))
			return;

		LivingEntity defender = (LivingEntity) event.getEntity();
		Player player = (Player) event.getDamager();
		ItemStack item = player.getInventory().getItemInMainHand();
		if (item == null) {
			return;
		}

		if (player.getInventory().getItemInMainHand().getItemMeta() != null
				&& player.getInventory().getItemInMainHand().getItemMeta().displayName() != null) {
			ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
			NamespacedKey key = new NamespacedKey(plugin, "Enchants");
			if (meta.getPersistentDataContainer() == null)
				return;
			;
			PersistentDataContainer container = meta.getPersistentDataContainer();
			if (!container.has(key, Enchants))
				return;
			if (container.get(key, Enchants).containsKey("lanet")) {
				int level = container.get(key, Enchants).get("lanet");
				PotionEffect effect2 = defender.getPotionEffect(PotionEffectType.SPEED);
				PotionEffect effect = new PotionEffect(PotionEffectType.WITHER, 40 * level, 2);
				if (effect2 == null) {
					defender.addPotionEffect(effect);
					World world = defender.getWorld();
					Location loc = defender.getLocation().add(1, 0.3, 0);
					world.spawn(loc, ArmorStand.class, armorStand -> {
						armorStand.setMarker(true);
						armorStand.setVisible(false);
						armorStand.setGravity(false);
						armorStand.setSmall(true);
						armorStand.setInvulnerable(true);
						armorStand.setCustomNameVisible(true);
						armorStand.customName(MiniMessage.get().parse("<gray>✦"));
						plugin.getIndicators().put(armorStand, 0);
						new BukkitRunnable() {

							@Override
							public void run() {
								Location loci = armorStand.getLocation().add(0, 0.1, 0);
								armorStand.teleport(loci);
								Integer timer2 = plugin.getIndicators().get(armorStand);
								timer2++;
								plugin.getIndicators().put(armorStand, timer2);
								if (timer2 >= 30) {
									timer2 = 0;
									plugin.getIndicators().remove(armorStand);
									armorStand.remove();
									cancel();
								}
							}
						}.runTaskTimer(plugin, 0L, 2L);

					});
				}
			}
		}

	}

	@EventHandler
	public void kazık(EntityDamageByEntityEvent event) {

		if (!(event.getEntity() instanceof LivingEntity && event.getDamager() instanceof Arrow))
			return;
		if (!(event.getCause() == DamageCause.PROJECTILE)) {
			return;
		}
		if (!(event.getDamager() instanceof Arrow)) {
			return;
		}
		Arrow arrow = (Arrow) event.getDamager();
		if (!(arrow.getShooter() instanceof Player)) {
			return;
		}
		Player player = (Player) arrow.getShooter();
		LivingEntity defender = (LivingEntity) event.getEntity();
		ItemStack item = player.getInventory().getItemInMainHand();
		if (item == null) {
			return;
		}
		if (defender == null) {
			return;
		}
		if (player.getInventory().getItemInMainHand().getItemMeta() != null
				&& player.getInventory().getItemInMainHand().getItemMeta().displayName() != null) {
			ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
			NamespacedKey key = new NamespacedKey(plugin, "Enchants");
			if (meta.getPersistentDataContainer() == null)
				return;
			;
			PersistentDataContainer container = meta.getPersistentDataContainer();
			if (!container.has(key, Enchants))
				return;
			if (container.get(key, Enchants).containsKey("kazık")) {
				int level = container.get(key, Enchants).get("kazık");
				if (bekleme6.containsKey(player.getUniqueId())) {
					long kalansaniye = ((bekleme6.get(player.getUniqueId()) / 1000) + beklemetime * 2)
							- (System.currentTimeMillis() / 1000);
					if (kalansaniye < 1) {

						bekleme6.remove(player.getUniqueId());
					}

				} else {
					bekleme6.put(player.getUniqueId(), System.currentTimeMillis());
					kazık.put(defender.getUniqueId(), 0);
					if (kazık.get(defender.getUniqueId()) <= 0) {
						World world = player.getWorld();
						Location loc = defender.getLocation().add(0, 0.4, 0);
						Location location = defender.getLocation();
						world.spawn(loc, ArmorStand.class, armorStand -> {
							new BukkitRunnable() {

								@Override
								public void run() {
									long kalansaniye = ((bekleme6.get(player.getUniqueId()) / 1000) + beklemetime * 2)
											- (System.currentTimeMillis() / 1000);
									player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
											new TextComponent(Painter.paint("&eKazıkatar: &c" + kalansaniye)));
									if (kalansaniye < 1) {
										player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
												new TextComponent(Painter.paint("&eKazıkatar: Hazır!")));
										cancel();
									}
								}
							}.runTaskTimer(plugin, 0, 20);
							armorStand.setMarker(true);
							armorStand.setVisible(false);
							armorStand.setGravity(false);
							armorStand.setSmall(true);
							armorStand.setInvulnerable(true);
							armorStand.setCustomNameVisible(true);
							armorStand.customName(MiniMessage.get().parse("<red>✖"));
							plugin.getIndicators().put(armorStand, 0);
							new BukkitRunnable() {

								@Override
								public void run() {
									Location loci = armorStand.getLocation().add(0, 0.1, 0);
									armorStand.teleport(loci);
									Integer timer2 = plugin.getIndicators().get(armorStand);
									timer2++;
									plugin.getIndicators().put(armorStand, timer2);
									if (timer2 >= 20) {
										timer2 = 0;
										plugin.getIndicators().remove(armorStand);
										armorStand.remove();
										cancel();
									}
								}
							}.runTaskTimer(plugin, 0L, 2L);

						});
						new BukkitRunnable() {

							@Override
							public void run() {
								if (!(defender.isDead())) {

									location.getWorld().spawnParticle(Particle.BLOCK_CRACK, location.add(0, 0, 0), 30,
											0.1, 0.1, 0.1, 0, defender.getLocation().add(0, -1, 0).getBlock().getType()
													.createBlockData());
								}
								int timer = kazık.get(defender.getUniqueId());
								timer++;
								kazık.put(defender.getUniqueId(), timer);
								if (kazık.get(defender.getUniqueId()) == level * 5) {
									kazık.remove(defender.getUniqueId());
									cancel();
								}

							}

						}.runTaskTimer(plugin, 0, 20L);
					}
				}
			}

		}

	}

	@EventHandler
	public void kazık2(EntityMoveEvent event) {
		Entity entity = event.getEntity();
		if (kazık.containsKey(entity.getUniqueId())) {
			event.setCancelled(true);
			final Vector vec = new Vector();
			entity.setVelocity(vec);
		}
	}

	@EventHandler
	public void giant(EntityDamageByEntityEvent event) {

		if (!(event.getEntity() instanceof LivingEntity && event.getDamager() instanceof Player))
			return;

		LivingEntity defender = (LivingEntity) event.getEntity();
		Player player = (Player) event.getDamager();
		ItemStack item = player.getInventory().getItemInMainHand();
		if (item == null) {
			return;
		}

		if (player.getInventory().getItemInMainHand().getItemMeta() != null
				&& player.getInventory().getItemInMainHand().getItemMeta().displayName() != null) {
			ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
			NamespacedKey key = new NamespacedKey(plugin, "Enchants");
			if (meta.getPersistentDataContainer() == null)
				return;
			;
			PersistentDataContainer container = meta.getPersistentDataContainer();
			if (!container.has(key, Enchants))
				return;
			if (container.get(key, Enchants).containsKey("giant2")) {
				int level = container.get(key, Enchants).get("giant2");
				double health = defender.getHealth();
				if (health < level + 1) {
					defender.damage(99999);
					World world = defender.getWorld();
					Location loc = defender.getLocation().add(0, 1, 0);
					world.spawn(loc, ArmorStand.class, armorStand -> {
						armorStand.setMarker(true);
						armorStand.setVisible(false);
						armorStand.setGravity(false);
						armorStand.setSmall(true);
						armorStand.setInvulnerable(true);
						armorStand.setCustomNameVisible(true);
						armorStand.customName(MiniMessage.get().parse("<dark_aqua><bold>İNFAZ"));
						plugin.getIndicators().put(armorStand, 0);
						new BukkitRunnable() {

							@Override
							public void run() {
								Location loci = armorStand.getLocation().add(0, 0.1, 0);
								armorStand.teleport(loci);
								Integer timer2 = plugin.getIndicators().get(armorStand);
								timer2++;
								plugin.getIndicators().put(armorStand, timer2);
								if (timer2 >= 30) {
									timer2 = 0;
									plugin.getIndicators().remove(armorStand);
									armorStand.remove();
									cancel();
								}
							}
						}.runTaskTimer(plugin, 0L, 2L);

					});
				}

			}
		}

	}

	@EventHandler
	public void bleed(EntityDamageByEntityEvent event) {

		if (!(event.getEntity() instanceof LivingEntity && event.getDamager() instanceof Player))
			return;
		Player player = (Player) event.getDamager();
		LivingEntity defender = (LivingEntity) event.getEntity();
		ItemStack item = player.getInventory().getItemInMainHand();
		if (item == null) {
			return;
		}
		if (defender == null) {
			return;
		}
		if (player.getInventory().getItemInMainHand().getItemMeta() != null
				&& player.getInventory().getItemInMainHand().getItemMeta().displayName() != null) {
			ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
			NamespacedKey key = new NamespacedKey(plugin, "Enchants");
			if (meta.getPersistentDataContainer() == null)
				return;
			;
			PersistentDataContainer container = meta.getPersistentDataContainer();
			if (!container.has(key, Enchants))
				return;
			if (container.get(key, Enchants).containsKey("kanama")) {
				int level = container.get(key, Enchants).get("kanama");
				if (bekleme7.containsKey(player.getUniqueId())) {
					long kalansaniye = ((bekleme7.get(player.getUniqueId()) / 1000) + beklemetime)
							- (System.currentTimeMillis() / 1000);

				} else {
					new BukkitRunnable() {

						@Override
						public void run() {
							long kalansaniye = ((bekleme7.get(player.getUniqueId()) / 1000) + beklemetime)
									- (System.currentTimeMillis() / 1000);
							player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
									new TextComponent(Painter.paint("&eAğır Yara: &c" + kalansaniye)));
							if (kalansaniye < 1) {
								player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
										new TextComponent(Painter.paint("&eAğır Yara Hazır.")));
								bekleme7.remove(player.getUniqueId());
								cancel();
							}
						}
					}.runTaskTimer(plugin, 0, 20);
					;
					Location location = defender.getLocation();
					location.getWorld().playSound(location, Sound.ENTITY_WITHER_BREAK_BLOCK, 1, 2f);
					bekleme7.put(player.getUniqueId(), System.currentTimeMillis());
					bleed.put(defender.getUniqueId(), 0);
					if (bleed.get(defender.getUniqueId()) <= 0) {
						World world = player.getWorld();
						Location loc = defender.getLocation().add(0, 0.4, 0);

						world.spawn(loc, ArmorStand.class, armorStand -> {
							new BukkitRunnable() {

								@Override
								public void run() {
									long kalansaniye = ((bekleme7.get(player.getUniqueId()) / 1000) + beklemetime)
											- (System.currentTimeMillis() / 1000);
									player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
											new TextComponent(Painter.paint("&eAğır Yara: &c" + kalansaniye)));
									if (kalansaniye < 1) {
										player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
												new TextComponent(Painter.paint("&eAğır Yara: Hazır!")));
										cancel();
									}
								}
							}.runTaskTimer(plugin, 0, 20);
							armorStand.setMarker(true);
							armorStand.setVisible(false);
							armorStand.setGravity(false);
							armorStand.setSmall(true);
							armorStand.setInvulnerable(true);
							armorStand.setCustomNameVisible(true);
							armorStand.customName(MiniMessage.get().parse("<red>⑊"));
							plugin.getIndicators().put(armorStand, 0);

							new BukkitRunnable() {

								@Override
								public void run() {
									Location loci = armorStand.getLocation().add(0, 0.1, 0);
									armorStand.teleport(loci);
									Integer timer2 = plugin.getIndicators().get(armorStand);
									timer2++;
									plugin.getIndicators().put(armorStand, timer2);
									if (timer2 >= 20) {
										timer2 = 0;
										plugin.getIndicators().remove(armorStand);
										armorStand.remove();
										cancel();
									}
								}
							}.runTaskTimer(plugin, 0L, 2L);

						});
						new BukkitRunnable() {

							@Override
							public void run() {
								if (!(defender.isDead())) {
									Location location2 = defender.getLocation();
									location2.getWorld().spawnParticle(Particle.BLOCK_CRACK, location2.add(0, 1, 0), 30,
											0.1, 0.1, 0.1, 0, Material.REDSTONE_BLOCK.createBlockData());
									defender.damage(level, player);

								}
								int timer = bleed.get(defender.getUniqueId());
								timer++;
								bleed.put(defender.getUniqueId(), timer);
								if (bleed.get(defender.getUniqueId()) == level * 5) {
									bleed.remove(defender.getUniqueId());
									cancel();
								}

							}
						}.runTaskTimer(plugin, 0, 20L);
					}
				}
			}

		}

	}

	private Vector rotateAroundAxisY(Vector v, double angle) {
		angle = -angle;
		angle = Math.toRadians(angle);
		double x, z, cos, sin;
		cos = Math.cos(angle);
		sin = Math.sin(angle);
		x = v.getX() * cos + v.getZ() * sin;
		z = v.getX() * -sin + v.getZ() * cos;
		return v.setX(x).setZ(z);
	}

	@EventHandler
	public void cancekme(EntityDamageByEntityEvent event) {

		if (!(event.getEntity() instanceof LivingEntity && event.getDamager() instanceof Player))
			return;
		LivingEntity defender = (LivingEntity) event.getEntity();
		Player player = (Player) event.getDamager();
		ItemStack item = player.getInventory().getItemInMainHand();
		if (item == null) {
			return;
		}

		if (player.getInventory().getItemInMainHand().getItemMeta() != null
				&& player.getInventory().getItemInMainHand().getItemMeta().displayName() != null) {
			ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
			NamespacedKey key = new NamespacedKey(plugin, "Enchants");
			if (meta.getPersistentDataContainer() == null)
				return;
			;
			PersistentDataContainer container = meta.getPersistentDataContainer();
			if (!container.has(key, Enchants))
				return;
			if (container.get(key, Enchants).containsKey("cancekme")) {
				int level = container.get(key, Enchants).get("cancekme");
				PotionEffect effect2 = new PotionEffect(PotionEffectType.HEAL, 1 * level, 0, false);
				player.addPotionEffect(effect2);

			}
		}

	}

	@EventHandler
	public void creeper(PlayerDeathEvent event) {

		Player player = event.getPlayer();
		ItemStack item = player.getInventory().getLeggings();
		if (item == null) {
			return;
		}

		if (player.getInventory().getLeggings() != null && player.getInventory().getLeggings().getItemMeta() != null) {
			ItemMeta meta = player.getInventory().getLeggings().getItemMeta();
			NamespacedKey key = new NamespacedKey(plugin, "Enchants");
			if (meta.getPersistentDataContainer() == null)
				return;
			;
			PersistentDataContainer container = meta.getPersistentDataContainer();
			if (!container.has(key, Enchants))
				return;
			if (container.get(key, Enchants).containsKey("creeper")) {
				int level = container.get(key, Enchants).get("creeper");
				Location location = player.getLocation();
				for (int i = 0; i < level + 1; i++) {
					Creeper as = (Creeper) player.getWorld().spawnEntity(location, EntityType.CREEPER);
					as.setPowered(true);
				}
			}
		}

	}

	@EventHandler
	public void arrow(EntityDamageByEntityEvent event) {

		if (!(event.getEntity() instanceof LivingEntity && event.getDamager() instanceof Arrow))
			return;
		LivingEntity defender = (LivingEntity) event.getEntity();
		Arrow arrow = (Arrow) event.getDamager();
		if (!(arrow.getShooter() instanceof Player)) {
			return;
		}
		Player player = (Player) arrow.getShooter();
		ItemStack item = player.getInventory().getItemInMainHand();
		if (item == null) {
			return;
		}

		if (player.getInventory().getItemInMainHand().getItemMeta() != null
				&& player.getInventory().getItemInMainHand().getItemMeta().displayName() != null) {
			ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
			NamespacedKey key = new NamespacedKey(plugin, "Enchants");
			if (meta.getPersistentDataContainer() == null)
				return;
			;
			PersistentDataContainer container = meta.getPersistentDataContainer();
			if (!container.has(key, Enchants))
				return;
			if (container.get(key, Enchants).containsKey("isabet")) {
				int level = container.get(key, Enchants).get("isabet");
				if (player.isSneaking()) {
					event.setDamage(event.getDamage() + level);
					player.getWorld().spawnParticle(Particle.BLOCK_CRACK, defender.getLocation().add(0, 1, 0), 40, 0.4,
							0.4, 0.4, 0, Material.REDSTONE_BLOCK.createBlockData());
				}

			}
		}

	}

	@EventHandler
	public void kalista(EntityDamageByEntityEvent event) {

		if (!(event.getEntity() instanceof LivingEntity && event.getDamager() instanceof Arrow))
			return;
		Arrow arrow = (Arrow) event.getDamager();
		LivingEntity defender = (LivingEntity) event.getEntity();
		if (!(arrow.getShooter() instanceof Player)) {
			return;
		}
		Player player = (Player) arrow.getShooter();
		ItemStack item = player.getInventory().getItemInMainHand();
		if (item == null) {
			return;
		}

		if (player.getInventory().getItemInMainHand().getItemMeta() != null
				&& player.getInventory().getItemInMainHand().getItemMeta().displayName() != null) {
			ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
			NamespacedKey key = new NamespacedKey(plugin, "Enchants");
			if (meta.getPersistentDataContainer() == null)
				return;
			;
			PersistentDataContainer container = meta.getPersistentDataContainer();
			if (!container.has(key, Enchants))
				return;
			if (container.get(key, Enchants).containsKey("kalista")) {
				int level = container.get(key, Enchants).get("kalista");
				kalista.put("dolu", defender);

			}
		}

	}

	@EventHandler
	public void parry3(EntityDamageByEntityEvent event) {

		if (!(event.getEntity() instanceof Player && event.getDamager() instanceof LivingEntity))
			return;
		Player player = (Player) event.getEntity();
		LivingEntity attacker = (LivingEntity) event.getDamager();
		ItemStack item = player.getInventory().getItemInMainHand();
		if (item == null) {
			return;
		}

		if (player.getInventory().getItemInMainHand().getItemMeta() != null
				&& player.getInventory().getItemInMainHand().getItemMeta().displayName() != null) {
			ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
			NamespacedKey key = new NamespacedKey(plugin, "Enchants");
			if (meta.getPersistentDataContainer() == null)
				return;
			;
			PersistentDataContainer container = meta.getPersistentDataContainer();
			if (!container.has(key, Enchants))
				return;
			if (container.get(key, Enchants).containsKey("parry")) {
				int level = container.get(key, Enchants).get("parry");
				if (parry.containsKey(player.getUniqueId())) {
					World world = player.getWorld();
					Location loc = player.getLocation().add(0, 0.4, 0);
					world.spawn(loc, ArmorStand.class, armorStand -> {
						armorStand.setMarker(true);
						armorStand.setVisible(false);
						armorStand.setGravity(false);
						armorStand.setSmall(true);
						armorStand.setInvulnerable(true);
						armorStand.setCustomNameVisible(true);
						armorStand.customName(MiniMessage.get().parse("<gold>❂"));
						plugin.getIndicators().put(armorStand, 0);
						new BukkitRunnable() {

							@Override
							public void run() {
								Location loci = armorStand.getLocation().add(0, 0.1, 0);
								armorStand.teleport(loci);
								Integer timer2 = plugin.getIndicators().get(armorStand);
								timer2++;
								plugin.getIndicators().put(armorStand, timer2);
								if (timer2 >= 30) {
									timer2 = 0;
									plugin.getIndicators().remove(armorStand);
									armorStand.remove();
									cancel();
								}
							}
						}.runTaskTimer(plugin, 0L, 2L);

					});

					PotionEffect effect2 = new PotionEffect(PotionEffectType.SLOW, 40 * level, 0, false);

					event.setCancelled(true);
					parry.remove(player.getUniqueId());
					double damage = event.getDamage();
					attacker.damage(damage / 3, player);

					attacker.setVelocity(attacker.getLocation().getDirection().multiply(-1.5).setY(0.3));
					attacker.addPotionEffect(effect2);
					Location location2 = player.getLocation();
					player.playSound(location2, Sound.ITEM_AXE_WAX_OFF, 3, 0.2f);
					player.getWorld().spawnParticle(Particle.BLOCK_CRACK, attacker.getLocation().add(0, 1, 0), 40, 0.4,
							0.4, 0.4, 0, Material.IRON_BLOCK.createBlockData());
					player.getWorld().spawnParticle(Particle.CRIT, attacker.getLocation().add(0, 1, 0), 12, 0.3, 0.3,
							0.3, 0.1);
					player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
							new TextComponent(Painter.paint("&6Saldırı bloklandı!")));
					if (attacker instanceof Player) {
						Location location = attacker.getLocation();
						((Player) attacker).playSound(location, Sound.ITEM_AXE_WAX_OFF, 3, 0.2f);
					}
				}

			}
		}

	}

	@EventHandler
	public void shield(EntityDamageByEntityEvent event) {

		if (!(event.getEntity() instanceof Player && event.getDamager() instanceof LivingEntity))
			return;
		Player player = (Player) event.getEntity();
		LivingEntity entity = (LivingEntity) event.getDamager();
		ItemStack item = player.getInventory().getLeggings();
		if (item == null) {
			return;
		}

		if (player.getInventory().getLeggings() != null && player.getInventory().getLeggings().getItemMeta() != null) {
			ItemMeta meta = player.getInventory().getLeggings().getItemMeta();
			NamespacedKey key = new NamespacedKey(plugin, "Enchants");
			if (meta.getPersistentDataContainer() == null)
				return;
			;
			PersistentDataContainer container = meta.getPersistentDataContainer();
			if (!container.has(key, Enchants))
				return;
			if (container.get(key, Enchants).containsKey("shield")) {
				int level = container.get(key, Enchants).get("shield");
				if (bekleme10.containsKey(player.getUniqueId())) {
					long kalansaniye = ((bekleme10.get(player.getUniqueId()) / 1000) + beklemetime)
							- (System.currentTimeMillis() / 1000);
				} else {
					player.getWorld().spawnParticle(Particle.EXPLOSION_LARGE, player.getLocation().add(0, 1, 0), 10,
							0.1, 0.1, 0.1, 0);
					player.getWorld().playSound(player.getLocation(), Sound.ENTITY_IRON_GOLEM_DEATH, 1, 0.1f);
					new BukkitRunnable() {

						@Override
						public void run() {
							long kalansaniye = ((bekleme10.get(player.getUniqueId()) / 1000) + beklemetime)
									- (System.currentTimeMillis() / 1000);
							player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
									new TextComponent(Painter.paint("&eKalkan Darbesi: &c" + kalansaniye)));
							if (kalansaniye < 1) {
								player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
										new TextComponent(Painter.paint("&eKalkan Darbesi Hazır.")));
								bekleme10.remove(player.getUniqueId());
								cancel();
							}
						}
					}.runTaskTimer(plugin, 0, 20);
					;
					for (Entity target : player.getNearbyEntities(4, 4, 4)) {
						if (!(target instanceof LivingEntity)) {
							return;
						}
						if (target == player || target instanceof ArmorStand) {
							continue;
						}
						if (target instanceof Damageable) {
							target.setVelocity(target.getLocation().getDirection().multiply(-2).setY(1));

							((LivingEntity) target).damage(level + 1, player);

						}
					}

					bekleme10.put(player.getUniqueId(), System.currentTimeMillis());

				}

			}
		}

	}

	@EventHandler
	public void twice(EntityDamageByEntityEvent event) {

		if (!(event.getEntity() instanceof LivingEntity && event.getDamager() instanceof Player))
			return;
		LivingEntity defender = (LivingEntity) event.getEntity();
		Player player = (Player) event.getDamager();
		ItemStack item = player.getInventory().getItemInMainHand();
		if (item == null) {
			return;
		}

		if (player.getInventory().getItemInMainHand().getItemMeta() != null
				&& player.getInventory().getItemInMainHand().getItemMeta().displayName() != null) {
			ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
			NamespacedKey key = new NamespacedKey(plugin, "Enchants");
			if (meta.getPersistentDataContainer() == null)
				return;
			;
			PersistentDataContainer container = meta.getPersistentDataContainer();
			if (!container.has(key, Enchants))
				return;
			if (container.get(key, Enchants).containsKey("twice")) {
				int level = container.get(key, Enchants).get("twice");
				if (bekleme2.containsKey(player.getUniqueId())) {
					long kalansaniye = ((bekleme2.get(player.getUniqueId()) / 1000) + beklemetime)
							- (System.currentTimeMillis() / 1000);
					if (kalansaniye > 0) {
						player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
								new TextComponent(Painter.paint("&eÇifte Vuruş: &c" + kalansaniye)));
					}

					if (kalansaniye < 1) {
						bekleme2.remove(player.getUniqueId());
					}

				} else {
					player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
							new TextComponent(Painter.paint("&eÇifte Vuruş Hazır.")));
					defender.damage(event.getDamage() * level * 20 / 40);
					defender.damage(event.getDamage() * level * 20 / 40);

					bekleme2.put(player.getUniqueId(), System.currentTimeMillis());

				}

			}
		}

	}

	@EventHandler
	public void parry(PlayerInteractEvent e) {

		Player player = e.getPlayer();

		ItemStack item = player.getInventory().getItemInMainHand();
		if (item == null) {
			return;
		}
		if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (player.getInventory().getItemInMainHand().getItemMeta() != null
					&& player.getInventory().getItemInMainHand().getItemMeta().displayName() != null) {
				ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
				NamespacedKey key = new NamespacedKey(plugin, "Enchants");
				if (meta.getPersistentDataContainer() == null)
					return;
				;
				PersistentDataContainer container = meta.getPersistentDataContainer();
				if (!container.has(key, Enchants))
					return;
				if (container.get(key, Enchants).containsKey("parry")) {
					int level = container.get(key, Enchants).get("parry");
					if (bekleme5.containsKey(player.getUniqueId())) {
						long kalansaniye = ((bekleme5.get(player.getUniqueId()) / 1000) + beklemetime)
								- (System.currentTimeMillis() / 1000);
						if (kalansaniye > 0) {
							player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
									new TextComponent(Painter.paint("&eKarşılama: &c" + kalansaniye)));

						}
						if (kalansaniye < 1) {

							bekleme5.remove(player.getUniqueId());
							player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
									new TextComponent(Painter.paint("&eKarşılama Hazır!")));
						}
					} else {

						parry.put(player.getUniqueId(), "dolu");
						player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
								new TextComponent(Painter.paint("&eBir sonraki saldırıyı karşılayacaksın.")));
						new BukkitRunnable() {

							@Override
							public void run() {
								if (parry.containsKey(player.getUniqueId())) {
									player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
											new TextComponent(Painter.paint("&eKarşılama Hazırlığın sona erdi.")));
									parry.remove(player.getUniqueId());
								}

							}
						}.runTaskLater(plugin, level * 100);
						bekleme5.put(player.getUniqueId(), System.currentTimeMillis());

					}

				}
			}
		}
	}

	@EventHandler
	public void vayne(PlayerInteractEvent e) {

		Player player = e.getPlayer();

		ItemStack item = player.getInventory().getItemInMainHand();
		if (item == null) {
			return;
		}
		if (e.getAction() == Action.LEFT_CLICK_BLOCK || e.getAction() == Action.LEFT_CLICK_AIR) {
			if (player.getInventory().getItemInMainHand().getItemMeta() != null
					&& player.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
				ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
				NamespacedKey key = new NamespacedKey(plugin, "Enchants");
				if (meta.getPersistentDataContainer() == null)
					return;
				;
				PersistentDataContainer container = meta.getPersistentDataContainer();
				if (!container.has(key, Enchants))
					return;
				if (container.get(key, Enchants).containsKey("vayne")) {
					int level = container.get(key, Enchants).get("vayne");
					if (bekleme4.containsKey(player.getUniqueId())) {
						long kalansaniye = ((bekleme4.get(player.getUniqueId()) / 1000) + beklemetime * 2)
								- (System.currentTimeMillis() / 1000);
						if (kalansaniye > 0) {
							player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
									new TextComponent(Painter.paint("&eKamuflaj: &c" + kalansaniye)));

						}
						if (kalansaniye < 1) {

							bekleme4.remove(player.getUniqueId());
							player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
									new TextComponent(Painter.paint("&eKamuflaj Hazır!")));
						}
					} else {

						new BukkitRunnable() {

							@Override
							public void run() {
								if (vayne.containsKey(player.getUniqueId())) {
									player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
											new TextComponent(Painter.paint("&eKamuflaj sona erdi.")));
									vayne.remove(player.getUniqueId());
									player.removePotionEffect(PotionEffectType.INVISIBILITY);
									player.getInventory().setArmorContents(
											armorsave.get(player.getUniqueId()).toArray(new ItemStack[0]));
									stats.setVayne(player.getUniqueId(), null);
									for (Player online : Bukkit.getOnlinePlayers()) {
										online.showPlayer(plugin, player);
									}
								}

							}
						}.runTaskLater(plugin, level * 200);

						World world = player.getWorld();
						Location loc = player.getLocation().add(0, 0.3, 0);
						player.getWorld().spawnParticle(Particle.CAMPFIRE_COSY_SMOKE, loc, 40, 0.1, 0.2, 0.1, 0.1);
						player.getWorld().spawnParticle(Particle.SMOKE_LARGE, loc.add(0, 0.4, 0), 40, 0.2, 0.2, 0.2, 0);
						vayne.put(player.getUniqueId(), level);
						bekleme4.put(player.getUniqueId(), System.currentTimeMillis());
						PotionEffect effect = new PotionEffect(PotionEffectType.INVISIBILITY, 20000, 0, true);
						player.addPotionEffect(effect);
						if (player.getInventory().getArmorContents() != null) {
							List<ItemStack> armorlist = new ArrayList<ItemStack>();
							for (ItemStack armor : player.getInventory().getArmorContents()) {
								armorlist.add(armor);
							}
							armorsave.put(player.getUniqueId(), armorlist);
						}
						player.getInventory().setArmorContents(null);
						for (Player online : Bukkit.getOnlinePlayers()) {
							online.hidePlayer(plugin, player);
						}

					}

				}
			}
		}
	}

	/*
	 * @EventHandler public void tozedici(PlayerInteractEvent e) {
	 * 
	 * Player player = e.getPlayer();
	 * 
	 * ItemStack item = player.getInventory().getItemInMainHand(); if (item == null)
	 * { return; } if (e.getAction() == Action.LEFT_CLICK_BLOCK || e.getAction() ==
	 * Action.LEFT_CLICK_AIR) { if
	 * (player.getInventory().getItemInMainHand().getItemMeta() != null &&
	 * player.getInventory().getItemInMainHand().getItemMeta().getDisplayName() !=
	 * null) { ItemMeta meta =
	 * player.getInventory().getItemInMainHand().getItemMeta(); NamespacedKey key =
	 * new NamespacedKey(plugin, "star"); if (meta.getPersistentDataContainer() ==
	 * null) return; ; PersistentDataContainer container =
	 * meta.getPersistentDataContainer(); if (!container.has(key,
	 * PersistentDataType.STRING)) return; if (container.get(key,
	 * PersistentDataType.STRING).equals("wand")) { if
	 * (bekleme11.containsKey(player.getUniqueId())) { long kalansaniye =
	 * ((bekleme11.get(player.getUniqueId()) / 1000) + beklemetime * 2) -
	 * (System.currentTimeMillis() / 1000); if (kalansaniye > 0) {
	 * player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new
	 * TextComponent(Painter.paint("&eToz Edici: &c" + kalansaniye)));
	 * 
	 * } if (kalansaniye < 1) {
	 * 
	 * bekleme11.remove(player.getUniqueId());
	 * player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new
	 * TextComponent(Painter.paint("&eToz Edici Hazır!"))); } } else {
	 * 
	 * new BukkitRunnable() {
	 * 
	 * @Override public void run() {
	 * 
	 * player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new
	 * TextComponent(Painter.paint("&eToz Edici sona erdi.")));
	 * 
	 * } }.runTaskLater(plugin, 200);
	 * 
	 * World world = player.getWorld(); Location loc = player.getLocation();
	 * player.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, loc, 40, 0.1, 0.2,
	 * 0.1, 0.1); player.getWorld().spawnParticle(Particle.CLOUD, loc, 30, 0.1, 0.2,
	 * 0.1, 0.1); new BukkitRunnable() {
	 * 
	 * @Override public void run() {
	 * 
	 * 
	 * } }.runTaskTimer(plugin, 0, 1L);
	 * 
	 * 
	 * 
	 * bekleme11.put(player.getUniqueId(), System.currentTimeMillis());
	 * 
	 * }
	 * 
	 * } } } }
	 */

	@EventHandler
	public void kalista2(PlayerInteractEvent e) {

		Player player = e.getPlayer();

		ItemStack item = player.getInventory().getItemInMainHand();
		if (item == null) {
			return;
		}
		if (e.getAction() == Action.LEFT_CLICK_BLOCK || e.getAction() == Action.LEFT_CLICK_AIR) {
			if (player.getInventory().getItemInMainHand().getItemMeta() != null
					&& player.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
				ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
				NamespacedKey key = new NamespacedKey(plugin, "Enchants");
				if (meta.getPersistentDataContainer() == null)
					return;
				;
				PersistentDataContainer container = meta.getPersistentDataContainer();
				if (!container.has(key, Enchants))
					return;
				if (container.get(key, Enchants).containsKey("kalista")) {
					int level = container.get(key, Enchants).get("kalista");
					LivingEntity entity = (LivingEntity) kalista.get("dolu");
					if (entity != null) {
						if (!(entity.isDead())) {
							if (bekleme9.containsKey(player.getUniqueId())) {
								long kalansaniye = ((bekleme9.get(player.getUniqueId()) / 1000) + beklemetime)
										- (System.currentTimeMillis() / 1000);
								if (kalansaniye > 0) {
									player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
											new TextComponent(Painter.paint("&eRuh Prangası: &c" + kalansaniye)));

								}
								if (kalansaniye < 1) {

									bekleme9.remove(player.getUniqueId());
									player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
											new TextComponent(Painter.paint("&eRuh Prangası Hazır!")));
								}
							} else {
								bekleme9.put(player.getUniqueId(), System.currentTimeMillis());
								player.getWorld().playSound(player.getLocation(),
										Sound.ENTITY_SKELETON_CONVERTED_TO_STRAY, 3, 0.8f);
								if (kalista.containsKey("dolu")) {

									entity.damage(entity.getArrowsInBody(), player);
									entity.getLocation().getWorld().spawnParticle(Particle.BLOCK_CRACK,
											entity.getLocation().add(0, 1, 0), 30, 0.1, 0.1, 0.1, 0,
											Material.REDSTONE_BLOCK.createBlockData());

									Arrow as = (Arrow) player.getWorld().spawnEntity(entity.getLocation().add(0, 2, 0),
											EntityType.ARROW);
									as.setVelocity(player.getLocation().getDirection().multiply(-2));
									as.setDamage(0.001);
									as.setKnockbackStrength(0);
									new BukkitRunnable() {

										@Override
										public void run() {
											as.getLocation().getWorld().spawnParticle(Particle.SMOKE_NORMAL,
													as.getLocation(), 10, 0, 0, 0, 0);
											as.getLocation().getWorld().spawnParticle(Particle.SOUL, as.getLocation(),
													10, 0.2, 0.2, 0.2, 0);
											double speed = as.getVelocity().length();
											if ((as.isOnGround()) || (as.isDead()) || (as.isDead())
													|| (as.getLocation().distanceSquared(player.getLocation()) <= 2)) {
												player.getLocation().getWorld().spawnParticle(Particle.SOUL,
														player.getLocation().add(0, 1.3, 0), 20, 0.2, 0.3, 0.2, 0.1);
												kalista.remove("dolu");
												player.setHealth(
														player.getHealth() + entity.getArrowsInBody() * 2 / 10);
												as.remove();
												cancel();
												return;
											}
											Vector toTarget = player.getLocation().clone()
													.add(new Vector(0.0D, 0.5D, 0.0D)).subtract(as.getLocation())
													.toVector();

											Vector dirVelocity = as.getVelocity().clone().normalize();
											Vector dirToTarget = toTarget.clone().normalize();
											double angle = dirVelocity.angle(dirToTarget);

											double newSpeed = 0.6D * speed + 0.14D;
											if (((player instanceof Player))
													&& (as.getLocation().distance(player.getLocation()) < 8.0D)) {
												if (player.isBlocking()) {
													newSpeed = speed * 0.6D;
												}
											}
											Vector newVelocity;

											if (angle < 0.12D) {
												newVelocity = dirVelocity.clone().multiply(newSpeed);
											} else {
												Vector newDir = dirVelocity.clone().multiply((angle - 0.12D) / angle)
														.add(dirToTarget.clone().multiply(0.12D / angle));
												newDir.normalize();
												newVelocity = newDir.clone().multiply(newSpeed);
											}
											as.setVelocity(newVelocity.add(new Vector(0.0D, 0.03D, 0.0D)));
										}
									}.runTaskTimer(plugin, 0, 1l);
								}
							}
						}
					}

				}
			}
		}
	}

	@EventHandler
	public void escape(PlayerInteractEvent e) {

		Player player = e.getPlayer();

		ItemStack item = player.getInventory().getItemInMainHand();
		if (item == null) {
			return;
		}
		if (e.getAction() == Action.LEFT_CLICK_BLOCK || e.getAction() == Action.LEFT_CLICK_AIR) {
			if (player.getInventory().getItemInMainHand().getItemMeta() != null
					&& player.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
				ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
				NamespacedKey key = new NamespacedKey(plugin, "Enchants");
				if (meta.getPersistentDataContainer() == null)
					return;
				;
				PersistentDataContainer container = meta.getPersistentDataContainer();
				if (!container.has(key, Enchants))
					return;
				if (container.get(key, Enchants).containsKey("escape")) {
					int level = container.get(key, Enchants).get("escape");
					if (bekleme8.containsKey(player.getUniqueId())) {
						long kalansaniye = ((bekleme8.get(player.getUniqueId()) / 1000) + beklemetime)
								- (System.currentTimeMillis() / 1000);
						if (kalansaniye > 0) {
							player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
									new TextComponent(Painter.paint("&eKaçış: &c" + kalansaniye)));

						}
						if (kalansaniye < 1) {

							bekleme8.remove(player.getUniqueId());
							player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
									new TextComponent(Painter.paint("&eKaçış Hazır!")));
						}
					} else {
						World world = player.getWorld();
						Location loc = player.getLocation().add(1, 0.3, 0);
						player.setVelocity(player.getLocation().getDirection().multiply(-2.5).setY(1));
						player.getWorld().spawnParticle(Particle.CLOUD, loc, 40, 0.1, 0.2, 0.1, 0.1);
						player.getWorld().spawnParticle(Particle.ENCHANTMENT_TABLE, loc.add(0, 0.4, 0), 40, 0.2, 0.2,
								0.2, 0.1);
						bekleme8.put(player.getUniqueId(), System.currentTimeMillis());

					}

				}
			}
		}
	}

	@EventHandler
	public void quick(PlayerInteractEvent e) {

		Player player = e.getPlayer();

		ItemStack item = player.getInventory().getItemInMainHand();
		if (item == null) {
			return;
		}
		ItemStack quiver = new ItemStack(Material.ARROW);
		quiver.setAmount(1);
		if (player.getInventory().containsAtLeast(quiver, 1)) {

			if (e.getAction() == Action.LEFT_CLICK_BLOCK || e.getAction() == Action.LEFT_CLICK_AIR) {
				if (quick.get(player.getUniqueId()) != null) {
					Integer fire = quick.get(player.getUniqueId());
					if (fire == 0) {
						if (player.getInventory().getItemInMainHand().getItemMeta() != null
								&& player.getInventory().getItemInMainHand().getItemMeta().displayName() != null) {
							ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
							NamespacedKey key = new NamespacedKey(plugin, "Enchants");
							if (meta.getPersistentDataContainer() == null)
								return;
							;
							PersistentDataContainer container = meta.getPersistentDataContainer();
							if (!container.has(key, Enchants))
								return;
							if (container.get(key, Enchants).containsKey("quick")) {
								int level = container.get(key, Enchants).get("quick");
								Vector playerDirection = player.getLocation().getDirection().normalize().multiply(2);
								Arrow arrow = player.launchProjectile(Arrow.class, playerDirection);
								player.playSound(player.getLocation(), Sound.ENTITY_ARROW_SHOOT, 100, 1.2f);
								if (meta.hasEnchant(Enchantment.ARROW_FIRE)) {
									arrow.setVisualFire(true);
									arrow.setFireTicks(-1);
									arrow.setBounce(false);
								}
								if (meta.hasEnchant(Enchantment.ARROW_DAMAGE)) {
									int powerlevel = meta.getEnchantLevel(Enchantment.ARROW_DAMAGE);
									arrow.setDamage(arrow.getDamage() + level + powerlevel * 2);
								} else {
									arrow.setDamage(arrow.getDamage() + level * 2);
								}
								player.getInventory().removeItem(quiver);
								fire = 1;
								quick.put(player.getUniqueId(), fire);
								new BukkitRunnable() {

									@Override
									public void run() {

										quick.put(player.getUniqueId(), 0);

									}
								}.runTaskLater(plugin, 40 / level - stats.getSaldiriHizi(player.getUniqueId()));

							}
						}
					}
				} else {
					quick.put(player.getUniqueId(), 0);
				}
			}
		}
	}

	@EventHandler
	public void quickShot(PlayerInteractEvent event) {
		Player player = event.getPlayer();

		if (player.getInventory().getItemInMainHand().getItemMeta() != null
				&& player.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
			ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
			NamespacedKey key = new NamespacedKey(plugin, "Enchants");
			if (meta.getPersistentDataContainer() == null)
				return;
			;
			PersistentDataContainer container = meta.getPersistentDataContainer();
			if (!container.has(key, Enchants))
				return;
			if (container.get(key, Enchants).containsKey("quick")) {
				int level = container.get(key, Enchants).get("quick");
				if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
					event.setCancelled(true);
				}

			}
		}
	}

	@EventHandler
	public void noSee(EntityTargetEvent event) {
		if (event.getTarget() instanceof Player) {
			Player target = (Player) event.getTarget();
			if (vayne.containsKey(target.getUniqueId())) {
				event.setCancelled(true);

			}
		}
	}

	@EventHandler
	public void vayneCrossbow(ProjectileLaunchEvent event) {
		Entity entity = event.getEntity();
		if (!(entity instanceof Arrow)) {
			return;
		}
		Arrow arrow = (Arrow) entity;
		if (!(arrow.getShooter() instanceof Player)) {
			return;
		}
		Player player = (Player) arrow.getShooter();
		if (vayne.containsKey(player.getUniqueId())) {
			arrow.setDamage(arrow.getDamage() + vayne.get(player.getUniqueId()) * 2);
		}
	}

	@EventHandler
	public void throw2(PlayerInteractEvent e) {

		Player player = e.getPlayer();

		ItemStack item = player.getInventory().getItemInMainHand();
		if (item == null) {
			return;
		}
		if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (player.getInventory().getItemInMainHand().getItemMeta() != null
					&& player.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
				ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
				NamespacedKey key = new NamespacedKey(plugin, "Enchants");
				if (meta.getPersistentDataContainer() == null)
					return;
				;
				PersistentDataContainer container = meta.getPersistentDataContainer();
				if (!container.has(key, Enchants))
					return;
				if (container.get(key, Enchants).containsKey("throw")) {
					int level = container.get(key, Enchants).get("throw");
					if (bekleme3.containsKey(player.getUniqueId())) {
						long kalansaniye = ((bekleme3.get(player.getUniqueId()) / 1000) + beklemetime)
								- (System.currentTimeMillis() / 1000);
						if (kalansaniye > 0) {
							player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
									new TextComponent(Painter.paint("&eLanetli Balta: &c" + kalansaniye)));

						}
						if (kalansaniye < 1) {

							bekleme3.remove(player.getUniqueId());
							player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
									new TextComponent(Painter.paint("&eLanetli Balta Hazır!")));
						}
					} else {
						ArmorStand as = (ArmorStand) player.getWorld().spawnEntity(player.getLocation().add(0, 0.5, 0),
								EntityType.ARMOR_STAND);

						as.setArms(true);
						as.setGravity(false);
						as.setVisible(false);
						as.setMarker(true);
						as.setItemInHand(new ItemStack(player.getInventory().getItemInMainHand()));
						as.setRightArmPose(new EulerAngle(Math.toRadians(90), Math.toRadians(0), Math.toRadians(0)));

						Location dest = player.getLocation().add(player.getLocation().getDirection().multiply(5));
						Vector vector = dest.subtract(player.getLocation()).toVector();

						new BukkitRunnable() {
							int distance = 30;
							int i = 0;

							public void run() {

								EulerAngle rot = as.getRightArmPose();
								EulerAngle rotnew = rot.add(20, 0, 0);
								as.setRightArmPose(rotnew);

								as.teleport(as.getLocation().add(vector.normalize()));

								for (Entity entity : as.getLocation().getChunk().getEntities()) {
									if (!as.isDead()) {
										if (as.getLocation().distanceSquared(entity.getLocation()) <= 1) {
											if (entity != player && entity != as) {
												if (entity instanceof LivingEntity) {
													LivingEntity livingentity = (LivingEntity) entity;
													livingentity.damage(level * 5, player);
													PotionEffect effect2 = new PotionEffect(PotionEffectType.SLOW,
															20 * level, 1);

													livingentity.addPotionEffect(effect2);
													as.remove();
													cancel();
												}
											}
										}
									}
								}

								if (i > distance) {
									if (!as.isDead()) {
										as.remove();
										cancel();
									}
								}
								i++;
							}
						}.runTaskTimer(plugin, 0L, 1L);

						e.setCancelled(true);

						bekleme3.put(player.getUniqueId(), System.currentTimeMillis());

					}

				}
			}
		}
	}

	@EventHandler
	public void armorp(EntityDamageByEntityEvent event) {

		if (!(event.getEntity() instanceof LivingEntity && event.getDamager() instanceof Player))
			return;
		LivingEntity defender = (LivingEntity) event.getEntity();
		Player player = (Player) event.getDamager();
		ItemStack item = player.getInventory().getItemInMainHand();
		if (item == null) {
			return;
		}

		if (player.getInventory().getItemInMainHand().getItemMeta() != null
				&& player.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null) {
			ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
			NamespacedKey key = new NamespacedKey(plugin, "Enchants");
			if (meta.getPersistentDataContainer() == null)
				return;
			;
			PersistentDataContainer container = meta.getPersistentDataContainer();
			if (!container.has(key, Enchants))
				return;
			if (container.get(key, Enchants).containsKey("armorp")) {
				int level = container.get(key, Enchants).get("armorp");
				ItemStack boots = defender.getEquipment().getBoots();
				ItemStack helmet = defender.getEquipment().getHelmet();
				ItemStack leggs = defender.getEquipment().getLeggings();
				ItemStack chestplate = defender.getEquipment().getChestplate();
				AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(),
						Attribute.GENERIC_ARMOR.getKey().getKey(), -level, AttributeModifier.Operation.ADD_NUMBER,
						EquipmentSlot.HEAD);
				AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(),
						Attribute.GENERIC_ARMOR.getKey().getKey(), -level, AttributeModifier.Operation.ADD_NUMBER,
						EquipmentSlot.CHEST);
				AttributeModifier modifier3 = new AttributeModifier(UUID.randomUUID(),
						Attribute.GENERIC_ARMOR.getKey().getKey(), -level, AttributeModifier.Operation.ADD_NUMBER,
						EquipmentSlot.LEGS);
				AttributeModifier modifier4 = new AttributeModifier(UUID.randomUUID(),
						Attribute.GENERIC_ARMOR.getKey().getKey(), -level, AttributeModifier.Operation.ADD_NUMBER,
						EquipmentSlot.FEET);
				AttributeModifier mmodifier = new AttributeModifier(UUID.randomUUID(),
						Attribute.GENERIC_ARMOR.getKey().getKey(), -level, AttributeModifier.Operation.ADD_NUMBER,
						EquipmentSlot.HEAD);
				AttributeModifier mmodifier2 = new AttributeModifier(UUID.randomUUID(),
						Attribute.GENERIC_ARMOR.getKey().getKey(), -level, AttributeModifier.Operation.ADD_NUMBER,
						EquipmentSlot.CHEST);
				AttributeModifier mmodifier3 = new AttributeModifier(UUID.randomUUID(),
						Attribute.GENERIC_ARMOR.getKey().getKey(), -level, AttributeModifier.Operation.ADD_NUMBER,
						EquipmentSlot.LEGS);
				AttributeModifier mmodifier4 = new AttributeModifier(UUID.randomUUID(),
						Attribute.GENERIC_ARMOR.getKey().getKey(), -level, AttributeModifier.Operation.ADD_NUMBER,
						EquipmentSlot.FEET);

				if (boots != null) {
					if (boots.getItemMeta() != null) {
						ItemMeta meta2 = boots.getItemMeta();
						meta2.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier4);
						boots.setItemMeta(meta2);
						defender.getEquipment().setBoots(boots);

					}
				}
				if (helmet != null) {
					if (helmet.getItemMeta() != null) {
						ItemMeta meta3 = helmet.getItemMeta();
						meta3.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier);
						helmet.setItemMeta(meta3);
						defender.getEquipment().setHelmet(helmet);

					}
				}
				if (chestplate != null) {
					if (chestplate.getItemMeta() != null) {
						ItemMeta meta4 = chestplate.getItemMeta();
						meta4.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier2);
						chestplate.setItemMeta(meta4);
						defender.getEquipment().setChestplate(chestplate);

					}
				}
				if (leggs != null) {
					if (leggs.getItemMeta() != null) {
						ItemMeta meta5 = leggs.getItemMeta();
						meta5.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier3);
						leggs.setItemMeta(meta5);
						defender.getEquipment().setLeggings(leggs);
					}
				}
				new BukkitRunnable() {

					@Override
					public void run() {
						if (boots != null) {
							if (boots.getItemMeta() != null) {
								ItemMeta meta2 = boots.getItemMeta();
								meta2.addAttributeModifier(Attribute.GENERIC_ARMOR, mmodifier4);
								boots.setItemMeta(meta2);
								defender.getEquipment().setBoots(boots);

							}
						}
						if (helmet != null) {
							if (helmet.getItemMeta() != null) {
								ItemMeta meta3 = helmet.getItemMeta();
								meta3.addAttributeModifier(Attribute.GENERIC_ARMOR, mmodifier);
								helmet.setItemMeta(meta3);
								defender.getEquipment().setHelmet(helmet);

							}
						}
						if (chestplate != null) {
							if (chestplate.getItemMeta() != null) {
								ItemMeta meta4 = chestplate.getItemMeta();
								meta4.addAttributeModifier(Attribute.GENERIC_ARMOR, mmodifier2);
								chestplate.setItemMeta(meta4);
								defender.getEquipment().setChestplate(chestplate);

							}
						}
						if (leggs != null) {
							if (leggs.getItemMeta() != null) {
								ItemMeta meta5 = leggs.getItemMeta();
								meta5.addAttributeModifier(Attribute.GENERIC_ARMOR, mmodifier3);
								leggs.setItemMeta(meta5);
								defender.getEquipment().setLeggings(leggs);
							}
						}
					}
				}.runTaskLater(plugin, 200L);

			}

		}

	}

}
