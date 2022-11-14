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
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class AttackDamage implements Listener {
    private static final HashMap<UUID, String> crit = new HashMap<>();
    private final MoonCore plugin;
    private final StatsManager stats;

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
                EntityType.AREA_EFFECT_CLOUD,EntityType.FIREBALL);
        if (SKIPPED_TYPES.contains(entity2.getType())) {
            return;
        }
        LivingEntity damaged = (LivingEntity) entity2;
        damaged.setNoDamageTicks(0);
        if (damaged instanceof Player) {
            Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
            Player player = (Player) damaged;

            int defans = stats.getDirenc(player.getUniqueId()) + 100;
            int damageReduc = defans / (stats.getDirenc(player.getUniqueId())
            );
            float realDamage = (float) (event.getDamage() * damageReduc);
            event.setDamage(realDamage);
            Team isim = scoreboard.getTeam(player.getName());
            if (Objects.requireNonNull(isim).hasEntry(player.getName())) {
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
                NamespacedKey lvlrequirement = new NamespacedKey(plugin, "lvlrequirement");
                if(item != null && item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                    if(item.getItemMeta().getPersistentDataContainer().has(lvlrequirement)) {
                        if(stats.getLevel(player.getUniqueId()) >= item.getItemMeta().getPersistentDataContainer().get(lvlrequirement, PersistentDataType.INTEGER)) {
                            event.setCancelled(false);
                        } else {
                            event.setCancelled(true);
                            player.sendMessage(Painter.paint("&cSeviyen ekipmanı kullanmak için gereken seviyeden düşük!"));
                        }
                    }
                }
                if (item.getType() == Material.BLAZE_ROD) {
                    EntityDamageEvent event2 = new EntityDamageEvent(damaged, DamageCause.VOID, 1);
                    player.setLastDamageCause(event2);
                    Bukkit.getServer().getPluginManager().callEvent(event2);
                }
                if (item.getType() == Material.BOW) {
                   event.setCancelled(true);
                }


                if (!(player.hasCooldown(item.getType())) || item.getType() == Material.BLAZE_ROD) {
                    int realDamage = (int) (event.getDamage()
                            + item.getItemMeta().getPersistentDataContainer().get(hasar, PersistentDataType.INTEGER));
                    int realStrhg = stats.getGuc(player.getUniqueId())
                            + item.getItemMeta().getPersistentDataContainer().get(guc, PersistentDataType.INTEGER);
                    int chance = ThreadLocalRandom.current().nextInt(102 - stats.getKritikSansi(player.getUniqueId()));
                    NamespacedKey hit = new NamespacedKey(plugin, "bonehit");




                    if (chance <= 4) {

                        crit.put(player.getUniqueId(), "crit");
                        event.setDamage(stats.getKritikHasari(player.getUniqueId()) / 5 + 3 * realDamage
                                + 20 * realStrhg / 100 + 1);
                        if (stats.getKritikAyar(player.getUniqueId())) {
                            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 0.2f, 0.8f);
                            player.spawnParticle(Particle.EXPLOSION_LARGE, damaged.getLocation().add(0, 1.2, 0), 1, 0,
                                    0, 0, 1);
                        }
                    } else {
                        event.setDamage(realDamage + 20 * realStrhg / 100 + 1);
                    }
                } else {
                    event.setCancelled(true);
                }
            } else {

                int chance = ThreadLocalRandom.current().nextInt(102 - stats.getKritikSansi(player.getUniqueId()));
                if (chance <= 4) {
                    crit.put(player.getUniqueId(), "crit");
                    event.setDamage(stats.getKritikHasari(player.getUniqueId()) / 5 + 2 * event.getDamage()
                            + 2 * stats.getGuc(player.getUniqueId()) / 100 + 1);
                    if (stats.getKritikAyar(player.getUniqueId())) {
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 0.2f, 0.8f);
                        player.spawnParticle(Particle.EXPLOSION_LARGE, damaged.getLocation().add(0, 1.2, 0), 1, 0, 0, 0,
                                1);
                    }
                } else {
                    event.setDamage(event.getDamage() + 2 * stats.getGuc(player.getUniqueId()) / 100 + 1);
                }
            }

        } else if (entity instanceof Arrow arrow) {

            if(!(arrow.getShooter() instanceof Player player)) {
                return;
            }

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
                            stats.getKritikHasari(player.getUniqueId()) / 5 + 3 * realDamage + 5 * 5 / 100 + 1);
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
                    event.setDamage(stats.getKritikHasari(player.getUniqueId()) / 5 + 2 * event.getDamage()
                            + 8 * 5 / 100 + 1);
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

// --Commented out by Inspection START (14.11.2022 02:08):
//    public Player getDamager(Entity entity) {
//
//        if (entity instanceof Player) {
//            return (Player) entity;
//        } else if (entity instanceof Projectile) {
//            Projectile proj = (Projectile) entity;
//            ProjectileSource shooter = proj.getShooter();
//            if (shooter instanceof Player) {
//                return (Player) shooter;
//            }
//        } else if (entity instanceof Tameable) {
//            Tameable animal = (Tameable) entity;
//            return Bukkit.getPlayer(animal.getOwner().getUniqueId());
//        }
//        return null;
//    }
// --Commented out by Inspection STOP (14.11.2022 02:08)
}
