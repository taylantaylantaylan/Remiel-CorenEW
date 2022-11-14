package me.taylan.mooncore.listeners;

import com.manya.pdc.DataTypes;
import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.Painter;
import me.taylan.mooncore.utils.StatsManager;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;

import java.util.*;

public class PlayerAttackListener implements Listener {
    private final PersistentDataType<?, HashMap<String, Integer>> Enchants = DataTypes.hashMap(PersistentDataType.STRING,
            PersistentDataType.INTEGER);

    private final MoonCore plugin;
    private final StatsManager statsManager;
    private final Map<UUID, Boolean> drawing = new HashMap<UUID, Boolean>();
    private final Map<UUID, Integer> hancerstack = new HashMap<UUID, Integer>();
    private final Map<UUID, Integer> tirpanstack = new HashMap<UUID, Integer>();
    private final Map<UUID, Integer> mizrakstack = new HashMap<UUID, Integer>();
    private final Map<UUID, Integer> topuzStack = new HashMap<UUID, Integer>();
    private final Map<UUID, Integer> sword = new HashMap<UUID, Integer>();
    private final Map<UUID, Integer> axeStack = new HashMap<UUID, Integer>();
    private final Map<UUID, Integer> bowStack = new HashMap<UUID, Integer>();
    private final Map<UUID, Integer> bleed = new HashMap<UUID, Integer>();
    private static final Map<UUID, Integer> wand = new HashMap<UUID, Integer>();

    public static Map<UUID, Integer> getWand() {
        return wand;
    }

    public PlayerAttackListener(MoonCore plugin) {
        this.plugin = plugin;
        this.statsManager = plugin.getStatsManager();
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void attackmanager(EntityDamageByEntityEvent event) {
        Entity entity = event.getDamager();
        Entity damaged = event.getEntity();
        if (!(entity instanceof Player && damaged instanceof LivingEntity)) {
            return;
        }

        Player player = (Player) event.getDamager();

        World world = player.getWorld();
        NamespacedKey saldirihizi2 = new NamespacedKey(plugin, "attackspeed");
        if (player.getInventory().getItemInMainHand() != null && player.getInventory().getItemInMainHand().hasItemMeta()
                && player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer() != null
                && player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer()
                .has(saldirihizi2)) {
            ItemStack item = player.getInventory().getItemInMainHand();
            NamespacedKey lvlrequirement = new NamespacedKey(plugin, "lvlrequirement");
            if (item != null && item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                if (item.getItemMeta().getPersistentDataContainer().has(lvlrequirement)) {
                    if (!(statsManager.getLevel(player.getUniqueId()) >= item.getItemMeta().getPersistentDataContainer().get(lvlrequirement, PersistentDataType.INTEGER))) {

                        event.setCancelled(true);
                        player.sendMessage(Painter.paint("&cSeviyen ekipmanı kullanmak için gereken seviyeden düşük!"));

                    }
                }
            }
            int realhiz = item.getItemMeta().getPersistentDataContainer().get(saldirihizi2, PersistentDataType.INTEGER);
            int saldirihizi = statsManager.getSaldiriHizi(player.getUniqueId()) / 10 + realhiz;
            NamespacedKey dura = new NamespacedKey(plugin, "durability");
            ItemMeta meta = item.getItemMeta();
            if ((item.getType() == Material.WOODEN_HOE)) {
                if (!(player.hasCooldown(item.getType()))) {
                    if (damaged instanceof LivingEntity) {
                        for (Entity alan : damaged.getNearbyEntities(3, 2, 3)) {
                            if (!(alan instanceof LivingEntity) || alan == player) {
                                continue;
                            }

                            LivingEntity lentity = (LivingEntity) alan;
                            lentity.damage(event.getDamage());

                        }
                        if (tirpanstack.containsKey(player.getUniqueId())) {
                            int tirpanstacklendi = tirpanstack.get(player.getUniqueId());
                            if (tirpanstacklendi <= 5) {
                                tirpanstack.put(player.getUniqueId(), tirpanstacklendi + 1);
                            } else {
                                LivingEntity ldamaged = (LivingEntity) damaged;
                                if (ldamaged.isDead()) {
                                    tirpanstack.remove(player.getUniqueId());
                                }
                                tirpanstack.remove(player.getUniqueId());
                                for (Entity alan : damaged.getNearbyEntities(8, 3, 8)) {
                                    if (!(alan instanceof LivingEntity) || alan == player) {
                                        continue;
                                    }

                                    LivingEntity lentity = (LivingEntity) alan;
                                    lentity.damage(event.getDamage());

                                }
                                ovalparticles2(Particle.SWEEP_ATTACK, player, 3);
                                player.playSound(player, Sound.ENTITY_WITHER_SHOOT, 0.1f, 2f);

                            }

                        } else {
                            int tirpanstacklendi = 0;
                            tirpanstack.put(player.getUniqueId(), tirpanstacklendi);
                        }
                    }

                    player.setCooldown(item.getType(), (int) 30 - saldirihizi);
                    player.playSound(player, Sound.ITEM_TRIDENT_THROW, 0.25f, 0.1f);
                    player.spawnParticle(Particle.SWEEP_ATTACK, damaged.getLocation().add(0, 1.2, 0), 5, 0.1, 0.1, 0.1,
                            1);

                } else {

                    player.playSound(player, Sound.ITEM_SHIELD_BREAK, 0.2f, 1.1f);

                }
            }
            if (item.hasItemMeta() && item.getItemMeta().hasDisplayName() && item.getItemMeta().getDisplayName().contains("Kral Katili")) {
                if (!(player.hasCooldown(item.getType()))) {

                    Vector pDir = player.getLocation().getDirection();
                    Vector eDir = damaged.getLocation().getDirection();
                    double xv = pDir.getX() * eDir.getZ() - pDir.getZ() * eDir.getX();
                    double zv = pDir.getX() * eDir.getX() + pDir.getZ() * eDir.getZ();
                    double angle = Math.atan2(xv, zv); // Value between -π and +π
                    double angleInDegrees = (angle * 180) / Math.PI;

                    if (angleInDegrees <= 60 && angleInDegrees >= -32) {
                        ((LivingEntity) damaged).damage(4);
                        spawnArmorStandaGA(damaged.getLocation().add(0, 2, 1), "<red>-4🗡");

                    }
                }
            }

            if (item.getType() == Material.DIAMOND_SWORD) {
                if (!(player.hasCooldown(item.getType()))) {
                    player.setCooldown(item.getType(), 45);
                    player.playSound(player, Sound.ITEM_TRIDENT_THROW, 0.25f, 1f);
                } else {
                    /*
                     * ProtocolLibrary.getProtocolManager().addPacketListener( new
                     * PacketAdapter(plugin, ListenerPriority.NORMAL,
                     * PacketType.Play.Server.NAMED_SOUND_EFFECT) {
                     *
                     * @Override public void onPacketSending(PacketEvent event) { if
                     * (event.getPacketType() == PacketType.Play.Server.NAMED_SOUND_EFFECT) { if
                     * (event.getPacket().getStrings().read(0)
                     * .equalsIgnoreCase("entity.player.attack.strong")) { event.setCancelled(true);
                     * // The sound will no longer be played } } } });
                     */
                    player.playSound(player, Sound.ITEM_SHIELD_BREAK, 0.2f, 1.1f);

                }
            }
            if (item.getType() == Material.WOODEN_SWORD) {
                if (!(player.hasCooldown(item.getType()))) {

                    player.setCooldown(item.getType(), (int) 35 - saldirihizi);
                    player.playSound(player, Sound.ITEM_TRIDENT_THROW, 0.25f, 0);
                    if (damaged instanceof LivingEntity) {
                        if (sword.containsKey(player.getUniqueId())) {
                            int axestacklendi = sword.get(player.getUniqueId());
                            if (axestacklendi <= 5) {
                                sword.put(player.getUniqueId(), axestacklendi + 1);
                            } else {
                                LivingEntity ldamaged = (LivingEntity) damaged;
                                if (ldamaged.isDead()) {
                                    sword.remove(player.getUniqueId());
                                }
                                sword.remove(player.getUniqueId());
                                world.playSound(player, Sound.ENTITY_WITHER_BREAK_BLOCK, 1f, 1.7f);
                                ((Player) entity).damage(4, player);

                            }

                        } else {
                            int axestacklendi = 0;
                            sword.put(player.getUniqueId(), axestacklendi);
                        }

                    }
                } else {
                    /*
                     * ProtocolLibrary.getProtocolManager().addPacketListener( new
                     * PacketAdapter(plugin, ListenerPriority.NORMAL,
                     * PacketType.Play.Server.NAMED_SOUND_EFFECT) {
                     *
                     * @Override public void onPacketSending(PacketEvent event) { if
                     * (event.getPacketType() == PacketType.Play.Server.NAMED_SOUND_EFFECT) { if
                     * (event.getPacket().getStrings().read(0)
                     * .equalsIgnoreCase("entity.player.attack.strong")) { event.setCancelled(true);
                     * // The sound will no longer be played } } } });
                     */
                    player.playSound(player, Sound.ITEM_SHIELD_BREAK, 0.2f, 1.1f);

                }
            }
            if (item.getType() == Material.BOW) {
                event.setCancelled(true);
            }
            if (item.getType() == Material.GOLDEN_PICKAXE) {
                if (!(player.hasCooldown(item.getType()))) {
                    player.setCooldown(item.getType(), (int) 60);
                    player.playSound(player, Sound.ITEM_TRIDENT_THROW, 0.25f, 1f);
                } else {

                    player.playSound(player, Sound.ITEM_SHIELD_BREAK, 0.2f, 1.1f);

                }
            }
            if (item.getType() == Material.WOODEN_AXE) {
                if (!(player.hasCooldown(item.getType()))) {

                    player.setCooldown(item.getType(), (int) 35 - saldirihizi);
                    player.playSound(player, Sound.ITEM_TRIDENT_THROW, 0.25f, 0);
                    if (damaged instanceof LivingEntity) {
                        if (!(bleed.containsKey(player.getUniqueId()))) {
                            if (axeStack.containsKey(player.getUniqueId())) {
                                int axestacklendi = axeStack.get(player.getUniqueId());
                                if (axestacklendi <= 5) {
                                    axeStack.put(player.getUniqueId(), axestacklendi + 1);
                                } else {
                                    LivingEntity ldamaged = (LivingEntity) damaged;
                                    if (ldamaged.isDead()) {
                                        axeStack.remove(player.getUniqueId());
                                    }
                                    axeStack.remove(player.getUniqueId());
                                    world.playSound(player, Sound.ENTITY_WITHER_BREAK_BLOCK, 1f, 1.2f);
                                    new BukkitRunnable() {

                                        @Override
                                        public void run() {
                                            if (!(ldamaged.isDead())) {
                                                Location location2 = ldamaged.getLocation();
                                                location2.getWorld().spawnParticle(Particle.BLOCK_CRACK,
                                                        location2.add(0, 1, 0), 30, 0.1, 0.1, 0.1, 0,
                                                        Material.REDSTONE_BLOCK.createBlockData());
                                                ldamaged.damage(event.getDamage());
                                                player.setCooldown(item.getType(), 0);

                                            } else {
                                                cancel();
                                                bleed.remove(player.getUniqueId());
                                            }
                                            if ((bleed.containsKey(player.getUniqueId()))) {
                                                int timer = bleed.get(player.getUniqueId());
                                                timer++;
                                                bleed.put(player.getUniqueId(), timer);
                                                if (bleed.get(player.getUniqueId()) >= 4) {
                                                    bleed.remove(player.getUniqueId());
                                                    cancel();
                                                }
                                            } else {
                                                bleed.put(player.getUniqueId(), 0);
                                            }
                                        }
                                    }.runTaskTimer(plugin, 0, 25L);

                                }

                            } else {
                                int axestacklendi = 0;
                                axeStack.put(player.getUniqueId(), axestacklendi);
                            }
                        }
                    }
                } else {

                    player.playSound(player, Sound.ITEM_SHIELD_BREAK, 0.2f, 1.1f);

                }
            }


            if (item.getType() == Material.STICK) {
                if (!(player.hasCooldown(item.getType()))) {
                    world.playSound(player, Sound.ITEM_TRIDENT_THROW, 0.25f, 1.1f);
                    player.setCooldown(item.getType(), (int) 40 - saldirihizi);

                    if (damaged instanceof LivingEntity) {

                        if (mizrakstack.containsKey(player.getUniqueId())) {
                            int mizrakstacklendi = mizrakstack.get(player.getUniqueId());
                            if (mizrakstacklendi <= 8) {
                                mizrakstack.put(player.getUniqueId(), mizrakstacklendi + 1);
                            }
                            if (mizrakstacklendi == 8) {
                                mizrakstack.remove(player.getUniqueId());
                                for (Entity alan : damaged.getNearbyEntities(3, 3, 3)) {
                                    if (!(alan instanceof LivingEntity) || alan == player) {
                                        continue;
                                    }

                                    LivingEntity lentity = (LivingEntity) alan;
                                    lentity.damage(event.getDamage());

                                }
                                player.playSound(player, Sound.ENTITY_WITCH_THROW, 0.2f, 1.2f);
                                ovalparticles3(Particle.CRIT, damaged, 2);

                            } else if (mizrakstacklendi == 4) {
                                LivingEntity ldamaged = (LivingEntity) damaged;
                                if (ldamaged.isDead()) {
                                    mizrakstack.remove(player.getUniqueId());
                                }
                                particleslash2(player);
                                ldamaged.damage(event.getDamage());
                                ldamaged.setVelocity(new Vector(0, 0.7, 0));
                                player.playSound(player, Sound.ENTITY_WITHER_SHOOT, 0.1f, 2f);
                                world.spawnParticle(Particle.SWEEP_ATTACK, ldamaged.getLocation().add(0, 1.2, 0), 7,
                                        0.3, 0.3, 0.3, 1);

                            }

                        } else {
                            int mizrakstacklendi = 0;
                            mizrakstack.put(player.getUniqueId(), mizrakstacklendi);
                        }
                    }
                } else {
                    /*
                     * ProtocolLibrary.getProtocolManager().addPacketListener( new
                     * PacketAdapter(plugin, ListenerPriority.NORMAL,
                     * PacketType.Play.Server.NAMED_SOUND_EFFECT) {
                     *
                     * @Override public void onPacketSending(PacketEvent event) { if
                     * (event.getPacketType() == PacketType.Play.Server.NAMED_SOUND_EFFECT) { if
                     * (event.getPacket().getStrings().read(0)
                     * .equalsIgnoreCase("entity.player.attack.strong")) { event.setCancelled(true);
                     * } } } });
                     */
                    player.playSound(player, Sound.ITEM_SHIELD_BREAK, 0.2f, 1.1f);

                }
            }
            if (item.getType() == Material.WOODEN_SHOVEL) {
                if (!(player.hasCooldown(item.getType()))) {
                    world.playSound(player, Sound.ITEM_TRIDENT_THROW, 0.25f, 1.1f);
                    player.setCooldown(item.getType(), (int) 50 - saldirihizi);
                    if (damaged instanceof LivingEntity) {
                        if (topuzStack.containsKey(player.getUniqueId())) {
                            int topuzstacklendi = topuzStack.get(player.getUniqueId());
                            if (topuzstacklendi <= 8) {
                                topuzStack.put(player.getUniqueId(), topuzstacklendi + 1);
                            }
                            if (topuzstacklendi == 8) {
                                PotionEffect effect = new PotionEffect(PotionEffectType.SLOW, 100, 255, true);
                                PotionEffect effect2 = new PotionEffect(PotionEffectType.SLOW_DIGGING, 100, 0, true);
                                if (!(((LivingEntity) damaged).hasPotionEffect(effect.getType()))
                                        && !(((LivingEntity) damaged).hasPotionEffect(effect2.getType()))) {
                                    ((LivingEntity) damaged).addPotionEffect(effect2);
                                    ((LivingEntity) damaged).addPotionEffect(effect);
                                    world.playSound(player, Sound.ITEM_AXE_SCRAPE, 0.25f, 0.1f);
                                    topuzStack.remove(player.getUniqueId());
                                    new BukkitRunnable() {
                                        int timer = 0;

                                        @Override
                                        public void run() {
                                            if (timer < 50) {
                                                Location loc = damaged.getLocation();
                                                loc.setYaw(loc.getYaw() + 10);
                                                damaged.teleport(loc);
                                                timer++;
                                            } else {
                                                cancel();
                                            }

                                        }
                                    }.runTaskTimer(plugin, 0, 2);
                                }
                            } else if (topuzstacklendi == 4) {
                                LivingEntity ldamaged = (LivingEntity) damaged;
                                if (ldamaged.isDead()) {
                                    topuzStack.remove(player.getUniqueId());
                                }

                                Location loc = damaged.getLocation();
                                loc.setPitch(-90);
                                damaged.teleport(loc);
                                for (Entity alan : damaged.getNearbyEntities(4, 3, 4)) {
                                    if (!(alan instanceof LivingEntity) || alan == player) {
                                        continue;
                                    }

                                    LivingEntity lentity = (LivingEntity) alan;
                                    lentity.damage(event.getDamage());
                                    lentity.attack(player);

                                }
                                damaged.setVelocity(damaged.getVelocity()
                                        .add(player.getLocation().getDirection().normalize().multiply(0.5)));

                            }

                        } else {
                            int topuzstacklendi = 0;
                            topuzStack.put(player.getUniqueId(), topuzstacklendi);
                        }

                    }
                } else {

                    player.playSound(player, Sound.ITEM_SHIELD_BREAK, 0.2f, 1.1f);

                }
            }

            if (item.getType() == Material.SHEARS) {
                if (!(player.hasCooldown(item.getType()))) {
                    Damageable itemmeta = (Damageable) item.getItemMeta();
                    itemmeta.setDamage(itemmeta.getDamage() - 1);
                    item.setItemMeta((ItemMeta) itemmeta);
                    if (item != null && item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null && item.getItemMeta().getPersistentDataContainer().has(dura)) {

                        int durabilt = meta.getPersistentDataContainer().get(dura, PersistentDataType.INTEGER);
                        meta.getPersistentDataContainer().set(dura, PersistentDataType.INTEGER, durabilt - 1);
                        item.setItemMeta(meta);
                        Damageable damagemeta = (Damageable) meta;
                        if (durabilt < item.getType().getMaxDurability()) {
                            damagemeta.setDamage(damagemeta.getDamage() + 1);
                            item.setItemMeta(damagemeta);
                            if (durabilt < 0) {
                                player.getInventory().remove(item);
                                player.playSound(player, Sound.ITEM_SHIELD_BREAK, 0.5F, 1.3F);
                            }
                        } else {
                            damagemeta.setDamage(0);
                            item.setItemMeta(damagemeta);
                        }
                    }
                    if (!(player.hasCooldown(item.getType()))) {
                        if (damaged instanceof LivingEntity) {
                            if (hancerstack.containsKey(player.getUniqueId())) {
                                int hancerstacklendi = hancerstack.get(player.getUniqueId());
                                if (hancerstacklendi <= 5) {
                                    hancerstack.put(player.getUniqueId(), hancerstacklendi + 1);
                                } else if (hancerstacklendi < 7) {
                                    new BukkitRunnable() {
                                        int hancer = 0;

                                        @Override
                                        public void run() {
                                            LivingEntity ldamaged = (LivingEntity) damaged;
                                            if (hancer >= 4 || ldamaged.isDead()) {
                                                hancerstack.remove(player.getUniqueId());
                                                this.cancel();
                                            }
                                            hancer += 1;
                                            NamespacedKey key = new NamespacedKey(plugin, "Enchants");
                                            if (meta.getPersistentDataContainer() == null)
                                                return;

                                            PersistentDataContainer container = meta.getPersistentDataContainer();
                                            if (container.has(key, Enchants)) {

                                                if (Objects.requireNonNull(container.get(key, Enchants)).containsKey("akuapunktur")) {
                                                    int level = Objects.requireNonNull(container.get(key, Enchants)).get("akuapunktur");
                                                    ldamaged.damage(5+level);
                                                    ldamaged.setNoDamageTicks(0);
                                                    player.playSound(player, Sound.ENTITY_WITHER_SHOOT, 0.1f, 2f);
                                                    particleslash(player);

                                                } else {
                                                    ldamaged.damage(3);
                                                    ldamaged.setNoDamageTicks(0);
                                                    player.playSound(player, Sound.ENTITY_WITHER_SHOOT, 0.1f, 2f);
                                                    particleslash(player);
                                                }

                                            } else {
                                                ldamaged.damage(3);
                                                ldamaged.setNoDamageTicks(0);
                                                player.playSound(player, Sound.ENTITY_WITHER_SHOOT, 0.1f, 2f);
                                                particleslash(player);
                                            }

                                        }
                                    }.runTaskTimer(plugin, 0, 5);
                                }

                            } else {
                                int hancerstacklendi = 0;
                                hancerstack.put(player.getUniqueId(), hancerstacklendi);
                            }
                        }
                    }

                    player.setCooldown(item.getType(), (int) 20 - saldirihizi);
                    player.playSound(player, Sound.ITEM_TRIDENT_THROW, 0.25f, 1.9f);

                } else {

                    player.playSound(player, Sound.ITEM_SHIELD_BREAK, 0.2f, 1.1f);

                }
            }
        } else {
            ItemStack item = player.getInventory().getItemInMainHand();
            NamespacedKey lvlrequirement = new NamespacedKey(plugin, "lvlrequirement");
            if (item != null && item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                if (item.getItemMeta().getPersistentDataContainer().has(lvlrequirement)) {
                    if (!(statsManager.getLevel(player.getUniqueId()) >= item.getItemMeta().getPersistentDataContainer().get(lvlrequirement, PersistentDataType.INTEGER))) {

                        event.setCancelled(true);
                        player.sendMessage(Painter.paint("&cSeviyen ekipmanı kullanmak için gereken seviyeden düşük!"));

                    }
                }
            }
            if (item.getType() == Material.GOLDEN_HOE) {
                if (!(player.hasCooldown(item.getType()))) {
                    player.setCooldown(item.getType(), 45);

                    player.playSound(player, Sound.ITEM_TRIDENT_THROW, 0.25f, 0.2f);
                } else {
                    player.playSound(player, Sound.ITEM_SHIELD_BREAK, 0.2f, 1.1f);

                }
            }
            if (item.getType() == Material.GOLDEN_AXE) {
                if (!(player.hasCooldown(item.getType()))) {
                    player.setCooldown(item.getType(), 45);
                    player.playSound(player, Sound.ITEM_TRIDENT_THROW, 0.25f, 1.2f);
                } else {

                    player.playSound(player, Sound.ITEM_SHIELD_BREAK, 0.2f, 1.1f);

                }
            }

            if (item.getType() == Material.GOLDEN_SHOVEL) {
                if (!(player.hasCooldown(item.getType()))) {
                    player.setCooldown(item.getType(),  25);
                    player.playSound(player, Sound.ITEM_TRIDENT_THROW, 0.25f, 1.2f);

                } else {

                    player.playSound(player, Sound.ITEM_SHIELD_BREAK, 0.2f, 1.1f);

                }
            }
        }

    }

    @EventHandler
    public void playerswing(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        NamespacedKey lvlrequirement = new NamespacedKey(plugin, "lvlrequirement");

        World world = player.getWorld();
        if (event.getAction() == Action.LEFT_CLICK_AIR) {
            NamespacedKey saldirihizi2 = new NamespacedKey(plugin, "attackspeed");
            if (player.getInventory().getItemInMainHand() != null
                    && player.getInventory().getItemInMainHand().hasItemMeta()
                    && player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer() != null
                    && player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer()
                    .has(saldirihizi2)) {
                int realhiz = player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer()
                        .get(saldirihizi2, PersistentDataType.INTEGER);
                int saldirihizi = statsManager.getSaldiriHizi(player.getUniqueId()) / 10 + realhiz;
                ItemStack item = player.getInventory().getItemInMainHand();
                if (item != null && item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                    if (item.getItemMeta().getPersistentDataContainer().has(lvlrequirement)) {
                        if (!(statsManager.getLevel(player.getUniqueId()) >= item.getItemMeta().getPersistentDataContainer().get(lvlrequirement, PersistentDataType.INTEGER))) {

                            event.setCancelled(true);
                            player.sendMessage(Painter.paint("&cSeviyen ekipmanı kullanmak için gereken seviyeden düşük!"));

                        }
                    }
                }
                if (item.getType() == Material.WOODEN_HOE) {
                    if (!(player.hasCooldown(item.getType()))) {
                        world.playSound(player, Sound.ITEM_TRIDENT_THROW, 0.25f, 0.1f);
                        player.setCooldown(item.getType(), (int) 45 - saldirihizi);
                    }
                }
                if (item.getType() == Material.GOLDEN_HOE) {
                    if (!(player.hasCooldown(item.getType()))) {
                        world.playSound(player, Sound.ITEM_TRIDENT_THROW, 0.25f, 0.1f);
                        player.setCooldown(item.getType(), (int) 55);
                    }
                }
                if (item.getType() == Material.DIAMOND_SWORD) {
                    if (!(player.hasCooldown(item.getType()))) {
                        world.playSound(player, Sound.ITEM_TRIDENT_THROW, 0.25f, 0.2f);
                        player.setCooldown(item.getType(), (int) 60 - saldirihizi);
                    }
                }
                if (item.getType() == Material.WOODEN_SWORD) {
                    if (!(player.hasCooldown(item.getType()))) {
                        world.playSound(player, Sound.ITEM_TRIDENT_THROW, 0.25f, 0.9f);
                        player.setCooldown(item.getType(), (int) 30 - saldirihizi);
                    }
                }
                if (item.getType() == Material.WOODEN_SHOVEL) {
                    if (!(player.hasCooldown(item.getType()))) {
                        world.playSound(player, Sound.ITEM_TRIDENT_THROW, 0.25f, 0.1f);
                        world.playSound(player, Sound.ITEM_AXE_SCRAPE, 0.25f, 0.8f);
                        player.setCooldown(item.getType(), (int) 50 - saldirihizi);
                    }
                }
                if (item.getType() == Material.GOLDEN_PICKAXE) {
                    if (!(player.hasCooldown(item.getType()))) {
                        world.playSound(player, Sound.ITEM_TRIDENT_THROW, 0.25f, 0.1f);
                        world.playSound(player, Sound.ITEM_AXE_SCRAPE, 0.25f, 0.8f);
                        player.setCooldown(item.getType(), (int) 50);
                    }
                }
                if (item.getType() == Material.GOLDEN_AXE) {
                    if (!(player.hasCooldown(item.getType()))) {
                        world.playSound(player, Sound.ITEM_TRIDENT_THROW, 0.25f, 0.1f);
                        world.playSound(player, Sound.ITEM_AXE_SCRAPE, 0.25f, 0.8f);
                        player.setCooldown(item.getType(), 45);
                    }
                }
                if (item.getType() == Material.GOLDEN_SHOVEL) {
                    if (!(player.hasCooldown(item.getType()))) {
                        world.playSound(player, Sound.ITEM_TRIDENT_THROW, 0.25f, 0.1f);
                        world.playSound(player, Sound.ITEM_AXE_SCRAPE, 0.25f, 0.8f);
                        player.setCooldown(item.getType(), 40);
                    }
                }
                if (item.getType() == Material.STICK) {
                    if (!(player.hasCooldown(item.getType()))) {
                        if (player.isSneaking()) {
                            spearThrow(player);
                            player.setCooldown(item.getType(), (int) 60 - saldirihizi);
                            world.playSound(player, Sound.ITEM_TRIDENT_THROW, 0.25f, 1.1f);
                        }
                        world.playSound(player, Sound.ITEM_TRIDENT_THROW, 0.25f, 1.1f);

                        final Location eyeLocation = player.getEyeLocation();
                        final Set<EntityType> SKIPPED_TYPES = EnumSet.of(EntityType.ARMOR_STAND, EntityType.ITEM_FRAME,
                                EntityType.GLOW_ITEM_FRAME, EntityType.VILLAGER);
                        Vector vec = player.getEyeLocation().getDirection();
                        final RayTraceResult ray = player.getWorld().rayTraceEntities(player.getEyeLocation(), vec, 6, 0, (e) -> e != player);
                        if (ray == null) {
                            return;
                        }
                        final RayTraceResult result = player.getWorld().rayTraceBlocks(player.getEyeLocation(), vec, player.getLocation().distance(Objects.requireNonNull(ray.getHitEntity()).getLocation()));

                        if (result == null && ray.getHitEntity() != null && !SKIPPED_TYPES.contains(ray.getHitEntity().getType())) {
                            if (ray.getHitEntity() instanceof LivingEntity) {
                                ((LivingEntity) ray.getHitEntity()).damage(4, player);
                                NamespacedKey dura = new NamespacedKey(plugin, "durability");
                                ItemMeta meta = item.getItemMeta();
                                int durabilt = meta.getPersistentDataContainer().get(dura, PersistentDataType.INTEGER);
                                meta.getPersistentDataContainer().set(dura, PersistentDataType.INTEGER, durabilt - 1);
                                item.setItemMeta(meta);

                                if (durabilt < 0) {
                                    player.getInventory().remove(item);
                                    player.playSound(player, Sound.ITEM_SHIELD_BREAK, 0.5F, 1.3F);

                                }
                                player.setCooldown(item.getType(), (int) 40 - saldirihizi);

                            }
                        } else {
                            player.setCooldown(item.getType(), (int) 40 - saldirihizi);
                        }

                    }
                }
                if (item.getType() == Material.BLAZE_ROD) {
                    if (!(player.hasCooldown(item.getType()))) {
                        world.playSound(player, Sound.BLOCK_BEACON_DEACTIVATE, 0.25f, 1.2f);
                        player.setCooldown(item.getType(), (int) 45 - saldirihizi);
                        for (ItemStack item2 : player.getInventory().getContents()) {
                            if (item2 != null) {
                                if (item2 == item) continue;
                                if (item2 != null && item2.hasItemMeta() && item2.getItemMeta().hasLore()) {
                                    if (Objects.requireNonNull(item2.getLore()).contains("Kılıç") || item2.getLore().contains("Hançer") || item2.getLore().contains("Balta") || item2.getLore().contains("Yay") || item2.getLore().contains("Arbalet") || item2.getLore().contains("Asa") || item2.getLore().contains("Topuz") || item2.getLore().contains("Kitabı") || item2.getLore().contains("Mızrak") || item2.getLore().contains("Tırpan")) {
                                        player.setCooldown(item2.getType(), (int) 999);
                                    }
                                }
                            }
                        }
                        particleBeam(player);
                        NamespacedKey dura = new NamespacedKey(plugin, "durability");
                        ItemMeta meta = item.getItemMeta();
                        int durabilt = meta.getPersistentDataContainer().get(dura, PersistentDataType.INTEGER);
                        meta.getPersistentDataContainer().set(dura, PersistentDataType.INTEGER, durabilt - 1);
                        item.setItemMeta(meta);

                        if (durabilt < 0) {
                            player.getInventory().remove(item);
                            player.playSound(player, Sound.ITEM_SHIELD_BREAK, 0.5F, 1.3F);
                        }
                        wand.put(player.getUniqueId(), 0);

                    }
                }
                if (item.getType() == Material.WOODEN_AXE) {
                    if (!(player.hasCooldown(item.getType()))) {
                        world.playSound(player, Sound.ITEM_TRIDENT_THROW, 0.25f, 0);
                        player.setCooldown(item.getType(), (int) 40 - saldirihizi);

                    }
                }

                if (item.getType() == Material.SHEARS) {
                    if (!(player.hasCooldown(item.getType()))) {
                        world.playSound(player, Sound.ITEM_TRIDENT_THROW, 0.25f, 1.9f);
                        player.setCooldown(item.getType(), (int) 20 - saldirihizi);

                    }
                }
                ItemStack quiver = new ItemStack(Material.ARROW);
                quiver.setAmount(1);
                if (player.getInventory().containsAtLeast(quiver, 1) && item.getType() == Material.BOW) {

                    if (!(player.hasCooldown(item.getType()))) {
                        if (item.hasItemMeta() && item.getItemMeta().hasDisplayName() && item.getItemMeta().getDisplayName().contains("Mistik")) {

                            if (bowStack.containsKey(player.getUniqueId())) {
                                int axestacklendi = bowStack.get(player.getUniqueId());
                                if (axestacklendi <= 5) {
                                    bowStack.put(player.getUniqueId(), axestacklendi + 1);
                                } else {
                                    bowStack.remove(player.getUniqueId());
                                    particleBeam(player);

                                }

                            } else {
                                int axestacklendi = 0;
                                bowStack.put(player.getUniqueId(), axestacklendi);
                            }

                        }
                        player.getInventory().removeItem(quiver);
                        ovalparticles(Particle.CRIT, player, 1);
                        player.setCooldown(item.getType(), (int) 40 - saldirihizi);
                        player.updateInventory();
                        ItemMeta meta = item.getItemMeta();
                        Vector playerDirection = player.getLocation().getDirection().normalize().multiply(2);
                        Arrow arrow = player.launchProjectile(Arrow.class, playerDirection);
                        player.playSound(player, Sound.ENTITY_ARROW_SHOOT, 0.14f, 1.3f);
                        NamespacedKey dura = new NamespacedKey(plugin, "durability");
                        int durabilt = meta.getPersistentDataContainer().get(dura, PersistentDataType.INTEGER);
                        meta.getPersistentDataContainer().set(dura, PersistentDataType.INTEGER, durabilt - 1);
                        item.setItemMeta(meta);
                        Damageable damagemeta = (Damageable) meta;
                        if (durabilt < item.getType().getMaxDurability()) {
                            damagemeta.setDamage(damagemeta.getDamage() + 1);
                            item.setItemMeta(damagemeta);
                            if (durabilt < 0) {
                                player.getInventory().remove(item);
                                player.playSound(player, Sound.ITEM_SHIELD_BREAK, 0.5F, 1.3F);
                            }
                        } else {
                            damagemeta.setDamage(0);
                            item.setItemMeta(damagemeta);
                        }
                        if (meta.hasEnchant(Enchantment.ARROW_FIRE)) {
                            arrow.setVisualFire(true);
                            arrow.setFireTicks(-1);

                        }
                        if (meta.hasEnchant(Enchantment.ARROW_DAMAGE)) {
                            arrow.setDamage(6+meta.getEnchantLevel(Enchantment.ARROW_DAMAGE));
                        } else {
                            arrow.setDamage(3);
                        }

                    }
                }
            }
        } else if (event.getAction() == Action.RIGHT_CLICK_AIR) {
            NamespacedKey saldirihizi2 = new NamespacedKey(plugin, "attackspeed");
            if (player.getInventory().getItemInMainHand() != null
                    && player.getInventory().getItemInMainHand().hasItemMeta()
                    && player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer() != null
                    && player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer()
                    .has(saldirihizi2)) {
                int realhiz = player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer()
                        .get(saldirihizi2, PersistentDataType.INTEGER);
                int saldirihizi = statsManager.getSaldiriHizi(player.getUniqueId()) / 10 + realhiz;
                ItemStack item = player.getInventory().getItemInMainHand();
                if (item.getType() == Material.BLAZE_ROD) {
                    if (!(player.hasCooldown(item.getType()))) {
                        wand.put(player.getUniqueId(), 0);
                        world.playSound(player, Sound.ENTITY_ENDER_DRAGON_HURT, 0.15f, 1.4f);
                        player.setCooldown(item.getType(), (int) 45 - saldirihizi);

                        particleTutorial(player);

                    }
                }
            }
        }
    }

    @EventHandler
    public void onDraw(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if (e.getItem() == null) {
            return;
        }
        if (!(player.hasCooldown(e.getItem().getType()))) {
            if (e.getItem() != null && e.getItem().getType() == Material.BOW) {
                if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                    drawing.put(player.getUniqueId(), true);
                }
            }
        } else {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onShoot(EntityShootBowEvent e) {
        if (e.getEntity() instanceof Player) {
            Player shooter = (Player) e.getEntity();
            if (!(e.getProjectile() instanceof Arrow)) {
                return;
            }
            NamespacedKey saldirihizi2 = new NamespacedKey(plugin, "attackspeed");
            if (shooter.getInventory().getItemInMainHand() != null
                    && shooter.getInventory().getItemInMainHand().hasItemMeta()
                    && shooter.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer() != null
                    && shooter.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer()
                    .has(saldirihizi2)) {
                ItemStack item = shooter.getInventory().getItemInMainHand();
                int realhiz = item.getItemMeta().getPersistentDataContainer().get(saldirihizi2,
                        PersistentDataType.INTEGER);
                int saldirihizi = statsManager.getSaldiriHizi(shooter.getUniqueId()) / 10 + realhiz;
                Arrow arrow = (Arrow) e.getProjectile();
                if (drawing.containsKey(shooter.getUniqueId())) {

                    arrow.setDamage(arrow.getDamage() + 10);
                    ovalparticles(Particle.SMOKE_NORMAL, shooter, 2);
                    ovalparticles(Particle.CRIT, shooter, 1);
                    shooter.setCooldown(item.getType(), (int) 70 - saldirihizi);
                    if (item.hasItemMeta() && item.getItemMeta().hasDisplayName() && item.getItemMeta().getDisplayName().contains("Mistik")) {

                        if (bowStack.containsKey(shooter.getUniqueId())) {
                            int axestacklendi = bowStack.get(shooter.getUniqueId());
                            if (axestacklendi <= 5) {
                                bowStack.put(shooter.getUniqueId(), axestacklendi + 1);
                            } else {
                                bowStack.remove(shooter.getUniqueId());
                                particleBeam(shooter);

                            }

                        } else {
                            int axestacklendi = 0;
                            bowStack.put(shooter.getUniqueId(), axestacklendi);
                        }

                    }
                    shooter.playSound(shooter, Sound.ENTITY_WITHER_SHOOT, 0.25f, 1.9f);
                    shooter.playSound(shooter, Sound.ENTITY_SKELETON_SHOOT, 0.25f, 1.2f);
                    NamespacedKey dura = new NamespacedKey(plugin, "durability");
                    ItemMeta meta = item.getItemMeta();
                    int durabilt = meta.getPersistentDataContainer().get(dura, PersistentDataType.INTEGER);
                    meta.getPersistentDataContainer().set(dura, PersistentDataType.INTEGER, durabilt - 1);
                    item.setItemMeta(meta);
                    Damageable damagemeta = (Damageable) meta;
                    if (durabilt < item.getType().getMaxDurability()) {
                        damagemeta.setDamage(damagemeta.getDamage() + 1);
                        item.setItemMeta(damagemeta);
                        if (durabilt < 0) {
                            shooter.getInventory().remove(item);
                            shooter.playSound(shooter, Sound.ITEM_SHIELD_BREAK, 0.5F, 1.3F);
                        }
                    } else {
                        damagemeta.setDamage(0);
                        item.setItemMeta(damagemeta);
                    }
                    if (meta.hasEnchant(Enchantment.ARROW_DAMAGE)) {
                        arrow.setDamage(10+meta.getEnchantLevel(Enchantment.ARROW_DAMAGE));
                    } else {
                        arrow.setDamage(8);
                    }
                    shooter.spawnParticle(Particle.CLOUD, shooter.getLocation().add(0, 1.2, 0), 5, 0, 0, 0, 1);
                    drawing.remove(shooter.getUniqueId());
                }
            } else {
                return;
            }
        }
    }

    public void particleslash(Player p) {
        Vector dir = p.getLocation().getDirection();

        Vector increment = dir.multiply(0.1);
        // distance between every particle, with direction of where player is facing

        Location lastPoint = p.getLocation().add(0, 1.6, 0).add(dir.multiply(2.4));
        // startlocation is from where it starts, for example the player's feet or eye
        // location
        // it then adds the longer (multiplied) direction vector (a line with a
        // direction and length) to it

        for (int i = 0; i < 15; i++) {
            p.getWorld().spawnParticle(Particle.CRIT, lastPoint, 1, 0, 0, 0, 0);

            lastPoint = lastPoint.add(increment);
        }
    }

    public void particleslash2(Player p) {
        Vector dir = p.getLocation().getDirection();

        Vector increment = dir.multiply(0.1);
        // distance between every particle, with direction of where player is facing

        Location lastPoint = p.getLocation().add(0, 1.6, 0).add(dir.multiply(2.4));
        // startlocation is from where it starts, for example the player's feet or eye
        // location
        // it then adds the longer (multiplied) direction vector (a line with a
        // direction and length) to it

        for (int i = 0; i < 30; i++) {
            p.getWorld().spawnParticle(Particle.CRIT, lastPoint, 0, 0, 0, 0, 0);

            lastPoint = lastPoint.add(increment);
        }
    }

    private Vector rotateAroundAxisX(Vector v, double angle) {
        angle = Math.toRadians(angle);
        double y, z, cos, sin;
        cos = Math.cos(angle);
        sin = Math.sin(angle);
        y = v.getY() * cos - v.getZ() * sin;
        z = v.getY() * sin + v.getZ() * cos;
        return v.setY(y).setZ(z);
    }

    private Vector rotateAroundAxisX1(Vector v, double angle) {
        angle = Math.toRadians(angle);
        double y, z, cos, sin;
        cos = Math.cos(angle);
        sin = Math.sin(angle);
        y = v.getY() * cos - v.getZ() * sin;
        z = v.getY() * sin + v.getZ() * cos;

        y = y * 0.5;

        return v.setY(y).setZ(z);
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

    public void ovalparticles(Particle p, Entity player, double f) {

        double points = f * 20; // amount of points to be generated
        for (int i = 0; i < 360; i += 360 / points) {
            double angle = (i * Math.PI / 180);
            double x = f * Math.cos(angle);
            double z = f * Math.sin(angle);

            Vector v0 = new Vector(x, 0, z);
            rotateAroundAxisX1(v0, 90);
            Vector v01 = new Vector(v0.getX(), v0.getY(), v0.getZ());
            rotateAroundAxisX(v01, -90);

            Vector v = new Vector(v01.getX(), v01.getY(), v01.getZ());
            rotateAroundAxisX(v, player.getLocation().getPitch() - 90);
            Vector v2 = new Vector(v.getX(), v.getY(), v.getZ());
            rotateAroundAxisY(v2, player.getLocation().getYaw());

            Location loc = player.getLocation().add(0, 1.5, 0).add(v2.getX(), v2.getY(), v2.getZ());
            player.getWorld().spawnParticle(p, loc, 1, 0, 0, 0, 0);

        }
    }

    public void ovalparticles2(Particle p, Entity player, double f) {

        double points = f * 20;
        for (int i = 0; i < 360; i += 360 / points) {
            double angle = (i * Math.PI / 180);
            double x = f * Math.cos(angle);
            double z = f * Math.sin(angle);
            Location loc = player.getLocation().add(x, 1.2, z);
            player.getWorld().spawnParticle(p, loc, 1, 0, 0, 0, 0);

        }
    }

    public void ovalparticles3(Particle p, Entity entity, double f) {

        double points = f * 20;
        for (int i = 0; i < 180; i += 360 / points) {
            double angle = (i * Math.PI / 180);
            double x = f * Math.cos(angle);
            double z = f * Math.sin(angle);
            Location loc = entity.getLocation().add(x, 1.2, z);
            loc.setDirection(entity.getLocation().getDirection());
            entity.getWorld().spawnParticle(p, loc, 1, 0, 0, 0, 0);

        }
    }

    public void spearThrow(Player player) {
        // Player's eye location is the starting location for the particle
        Location startLoc = player.getEyeLocation().subtract(0, 0.7, 0);

        // We need to clone() this location, because we will add() to it later.
        Location particleLoc = startLoc.clone();

        World world = startLoc.getWorld(); // We need this later to show the particle

        // dir is the Vector direction (offset from 0,0,0) the player is facing in 3D
        // space
        Vector dir = startLoc.getDirection();

        /*
         * vecOffset is used to determine where the next particle should appear We are
         * taking the direction and multiplying it by 0.5 to make it appear 1/2 block in
         * its continuing Vector direction. NOTE: We have to clone() because multiply()
         * modifies the original variable! For a straight beam, we only need to
         * calculate this once, as the direction does not change.
         */
        Vector vecOffset = dir.clone().multiply(0.7);

        new BukkitRunnable() {
            final int maxBeamLength = 50; // Max beam length
            int beamLength = 0; // Current beam length
            final ArmorStand armorStand2 = startLoc.getWorld().spawn(startLoc, ArmorStand.class, armorStand -> {
                armorStand.setMarker(true);
                armorStand.setVisible(false);
                armorStand.setGravity(false);
                armorStand.setSmall(false);
                armorStand.setInvulnerable(true);
                armorStand.setCustomNameVisible(false);
                armorStand.setItem(EquipmentSlot.HAND, player.getInventory().getItemInMainHand().clone());

            });

            // The run() function runs every X number of ticks - see below
            public void run() {


                // Search for any entities near the particle's current location
                for (Entity entity : world.getNearbyEntities(particleLoc, 5, 5, 5)) {
                    // We only care about living entities. Any others will be ignored.
                    if (entity instanceof LivingEntity) {
                        // Ignore player that initiated the shot
                        if (entity == player) {
                            continue;
                        }

                        /*
                         * Define the bounding box of the particle. We will use 0.25 here, since the
                         * particle is moving 0.5 blocks each time. That means the particle won't miss
                         * very small entities like chickens or bats, as the particle bounding box
                         * covers 1/2 of the movement distance.
                         */
                        Vector particleMinVector = new Vector(particleLoc.getX() - 0.25, particleLoc.getY() - 0.25,
                                particleLoc.getZ() - 0.25);
                        Vector particleMaxVector = new Vector(particleLoc.getX() + 0.25, particleLoc.getY() + 0.25,
                                particleLoc.getZ() + 0.25);

                        // Now use a spigot API call to determine if the particle is inside the entity's
                        // hitbox
                        if (entity.getBoundingBox().overlaps(particleMinVector, particleMaxVector)) {
                            // We have a hit!
                            // Display a flash at the location of the particle
                            // Play an explosion sound at the particle location

                            // Knock-back the entity in the same direction from where the particle is
                            // coming.
                            entity.setVelocity(
                                    entity.getVelocity().add(particleLoc.getDirection().normalize().multiply(0.2)));

                            // Damage the target, using the shooter as the damager
                            ((LivingEntity) entity).damage(3, player);
                            armorStand2.remove();
                            // Cancel the particle beam
                            this.cancel();
                            // We must return here, otherwise the code below will display one more particle.
                            return;
                        }
                    }
                }

                beamLength++; // This is the distance between each particle

                // Kill this task if the beam length is max
                if (beamLength >= maxBeamLength) {
                    this.cancel();
                    return;
                }

                // Now we add the direction vector offset to the particle's current location
                particleLoc.add(vecOffset);

                // Display the particle in the new location


                armorStand2.teleport(particleLoc);
                world.spawnParticle(Particle.CRIT, particleLoc, 1, 0.4, 0.4, 0.4, 0);
            }
        }.runTaskTimer(plugin, 0, 1);
        // 0 is the delay in ticks before starting this task
        // 1 is the how often to repeat the run() function, in ticks (20 ticks are in
        // one second)
    }

    public void particleBeam(Player player) {
        // Player's eye location is the starting location for the particle
        Location startLoc = player.getEyeLocation();

        // We need to clone() this location, because we will add() to it later.
        Location particleLoc = startLoc.clone();

        World world = startLoc.getWorld(); // We need this later to show the particle

        // dir is the Vector direction (offset from 0,0,0) the player is facing in 3D
        // space
        Vector dir = startLoc.getDirection();

        /*
         * vecOffset is used to determine where the next particle should appear We are
         * taking the direction and multiplying it by 0.5 to make it appear 1/2 block in
         * its continuing Vector direction. NOTE: We have to clone() because multiply()
         * modifies the original variable! For a straight beam, we only need to
         * calculate this once, as the direction does not change.
         */
        Vector vecOffset = dir.clone().multiply(0.7);

        new BukkitRunnable() {
            final int maxBeamLength = 30; // Max beam length
            int beamLength = 0; // Current beam length

            // The run() function runs every X number of ticks - see below
            public void run() {
                // Search for any entities near the particle's current location
                for (Entity entity : world.getNearbyEntities(particleLoc, 5, 5, 5)) {
                    // We only care about living entities. Any others will be ignored.
                    if (entity instanceof LivingEntity) {
                        // Ignore player that initiated the shot
                        if (entity == player) {
                            continue;
                        }

                        /*
                         * Define the bounding box of the particle. We will use 0.25 here, since the
                         * particle is moving 0.5 blocks each time. That means the particle won't miss
                         * very small entities like chickens or bats, as the particle bounding box
                         * covers 1/2 of the movement distance.
                         */
                        Vector particleMinVector = new Vector(particleLoc.getX() - 0.25, particleLoc.getY() - 0.25,
                                particleLoc.getZ() - 0.25);
                        Vector particleMaxVector = new Vector(particleLoc.getX() + 0.25, particleLoc.getY() + 0.25,
                                particleLoc.getZ() + 0.25);

                        // Now use a spigot API call to determine if the particle is inside the entity's
                        // hitbox
                        if (entity.getBoundingBox().overlaps(particleMinVector, particleMaxVector)) {
                            // We have a hit!
                            // Display a flash at the location of the particle
                            world.spawnParticle(Particle.FLASH, particleLoc, 0);
                            // Play an explosion sound at the particle location
                            world.playSound(particleLoc, Sound.ENTITY_GENERIC_EXPLODE, 2, 1);

                            // Knock-back the entity in the same direction from where the particle is
                            // coming.
                            entity.setVelocity(
                                    entity.getVelocity().add(particleLoc.getDirection().normalize().multiply(0.2)));

                            // Damage the target, using the shooter as the damager
                            buyuHasari((LivingEntity) entity, player, 4);

                            // Cancel the particle beam
                            this.cancel();
                            // We must return here, otherwise the code below will display one more particle.
                            return;
                        }
                    }
                }

                beamLength++; // This is the distance between each particle

                // Kill this task if the beam length is max
                if (beamLength >= maxBeamLength) {
                    world.spawnParticle(Particle.FLASH, particleLoc, 0);
                    this.cancel();
                    return;
                }

                // Now we add the direction vector offset to the particle's current location
                particleLoc.add(vecOffset);

                // Display the particle in the new location

                Particle.DustOptions dust = new Particle.DustOptions(Color.fromRGB((int) 153, (int) 204, (int) 255), 1);

                world.spawnParticle(Particle.REDSTONE, particleLoc, 0, 0.4, 0.4, 0.4, 0, dust);
            }
        }.runTaskTimer(plugin, 0, 1);
        // 0 is the delay in ticks before starting this task
        // 1 is the how often to repeat the run() function, in ticks (20 ticks are in
        // one second)
    }

    public void particleTutorial(Player player) {
        // Player's eye location is the starting location for the particle
        Location startLoc = player.getEyeLocation();

        // We need to clone() this location, because we will add() to it later.
        Location particleLoc = startLoc.clone();

        World world = startLoc.getWorld(); // We need this later to show the particle

        // dir is the Vector direction (offset from 0,0,0) the player is facing in 3D
        // space
        Vector dir = startLoc.getDirection();

        new BukkitRunnable() {
            final int maxBeamLength = 30; // Max beam length
            int beamLength = 0; // Current beam length
            Entity target = null; // This is the target for the beam
            double targetHeight = 0.0; // Height of the target entity. Used for tracking to the exact center.

            int ticks = 0; // Tick counter
            int ticksPerParticle = 4; // How many ticks per particle

            // The run() function runs every X number of ticks - see below
            public void run() {
                if (!(player.getWorld().equals(particleLoc.getWorld()))) {
                    cancel();
                }
                ticks++;
                if (ticks == ticksPerParticle) {
                    ticks = 0;

                    // Collision detection
                    // Search for any entities near the particle's current location
                    for (Entity entity : world.getNearbyEntities(particleLoc, 5, 5, 5)) {
                        // We only care about living entities. Any others will be ignored.
                        if (entity instanceof LivingEntity) {
                            // Ignore player that initiated the shot
                            if (entity == player) {
                                continue;
                            }

                            /*
                             * Define the bounding box of the particle. We will use 0.25 here, since the
                             * particle is moving 0.5 blocks each time. That means the particle won't miss
                             * very small entities like chickens or bats, as the particle bounding box
                             * covers 1/2 of the movement distance.
                             */
                            Vector particleMinVector = new Vector(particleLoc.getX() - 0.25, particleLoc.getY() - 0.25,
                                    particleLoc.getZ() - 0.25);
                            Vector particleMaxVector = new Vector(particleLoc.getX() + 0.25, particleLoc.getY() + 0.25,
                                    particleLoc.getZ() + 0.25);

                            // Now use a spigot API call to determine if the particle is inside the entity's
                            // hitbox
                            if (entity.getBoundingBox().overlaps(particleMinVector, particleMaxVector)) {
                                // We have a hit!
                                // Display a flash at the location of the particle
                                // Play an explosion sound at the particle location

                                // Knock-back the entity in the same direction from where the particle is
                                // coming.
                                entity.setVelocity(
                                        entity.getVelocity().add(particleLoc.getDirection().normalize().multiply(0.2)));

                                // Damage the target, using the shooter as the damager
                                buyuHasari((LivingEntity) entity, player, 7);

                                // Cancel the particle beam
                                this.cancel();
                                // We must return here, otherwise the code below will display one more particle.
                                return;
                            }
                        }
                    }

                    // vecOffset is used to determine where the next particle should appear
                    Vector vecOffset;

                    // Once the beam has traveled 3 blocks, start homing towards the closest entity
                    if (beamLength >= 6) {

                        // Tracking code. First we only activate if there is no target or the previous
                        // target has died.
                        if (target == null || target.isDead()) {
                            for (Entity entity : world.getNearbyEntities(particleLoc, 5, 5, 5)) {
                                if (entity instanceof LivingEntity) {
                                    // Ignore player that initiated the shot
                                    if (entity instanceof Player && entity == player) {
                                        continue;
                                    }
                                    // Found a target entity. Stop searching
                                    target = entity; // Save/lock the target
                                    targetHeight = target.getHeight(); // We need this to target the exact center
                                    String targetName = "unknown";
                                    if (target instanceof Player) {
                                        targetName = target.getName();
                                    } else {
                                        targetName = target.getType().toString();
                                    }
                                    break;
                                }
                            }
                        }
                    }

                    // We have a target! Adjust vector to point to this entity
                    if (target != null) {
                        // Target the center of the target entity
                        Location targetLoc = target.getLocation().clone().add(0, targetHeight / 2, 0);

                        // Get the current particle trajectory
                        Vector particleDirection = particleLoc.getDirection();
                        // Calc the vector half way between the projectile and the target.
                        Vector inBetween = targetLoc.clone().subtract(particleLoc).toVector().normalize();

                        double accuracy = 0.5;

                        // If the distance between the particle and the target is 5 or less, tighten the
                        // curve towards the target
                        // and speed up the particle slightly
                        double distance = particleLoc.distance(targetLoc);
                        if (distance < 5) {
                            ticksPerParticle = 2;
                            ticks = 0;

                            // Maths FTW! This creates a nice effect where the closer it gets to the target,
                            // the tighter the curve
                            // Returns a nice percentage number between 0.06 and .90 that we then multiply
                            // by 0.5 and add that to 0.5
                            accuracy = accuracy * Math.pow(0.6, distance) + 0.5;

                            // Now adjust the distance between particles to prevent circling of targets
                            double particleDistance = 0.5 - (0.5 * accuracy);
                        }
                        // If the distance is less than three, speed it up even more
                        if (distance < 3) {
                            ticksPerParticle = 1;
                            ticks = 0;
                        }

                        // Add the now multiplied "in between" vector to the projectile's direction
                        // vector and then normalize it
                        inBetween.multiply(accuracy);
                        particleDirection.add(inBetween).normalize();
                        vecOffset = particleDirection.clone();
                        // Need to set the new direction, otherwise direction resumes to before tracking
                        // direction
                        particleLoc.setDirection(particleDirection);
                    } else {
                        // No target. Continue moving in the previous direction
                        double accuracy = 0.5;
                        double particleDistance = 0.5 - (0.5 * accuracy);
                        vecOffset = particleLoc.getDirection().clone().multiply(particleDistance);
                    }

                    beamLength++; // This is the current number of particles in the beam.

                    // Kill this task if the beam length is max
                    if (beamLength >= maxBeamLength) {
                        this.cancel();
                        return;
                    }

                    // Now we add the direction vector offset to the particle's current location
                    particleLoc.add(vecOffset);

                    // Display the particle in the new location
                    world.spawnParticle(Particle.SPELL_INSTANT, particleLoc, 1, 0.1, 0.1, 0.1, 0);
                }
            }
        }.runTaskTimer(plugin, 0, 1);
        // 0 is the delay in ticks before starting this task
        // 1 is the how often to repeat the run() function, in ticks (20 ticks are in
        // one second)
    }

    public void buyuHasari(LivingEntity entity, Player player, int Damage) {
        entity.damage(Damage, player);

    }

    public void spawnArmorStandaGA(Location loc, String name) {
        ArmorStand armorStand2 = loc.getWorld().spawn(loc, ArmorStand.class, armorStand -> {
            armorStand.setMarker(true);
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setSmall(false);
            armorStand.setInvulnerable(true);
            armorStand.setCustomNameVisible(true);
            armorStand.customName(MiniMessage.miniMessage().deserialize(name));
            Location rotateloc = new Location(armorStand.getWorld(), armorStand.getLocation().getX(), armorStand.getLocation().getY(), armorStand.getLocation().getZ(), armorStand.getLocation().getYaw(), 2);
            plugin.getIndicators().put(armorStand, 2);

        });


    }
}
