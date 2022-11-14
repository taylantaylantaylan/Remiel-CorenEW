package me.taylan.mooncore.listeners.entitydamage;

import com.destroystokyo.paper.MaterialTags;
import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.listeners.PlayerAttackListener;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SpawnArmorStand implements Listener {

    private final MoonCore plugin;
    private final PlayerAttackListener attackListener;
    private final DecimalFormat formatter = new DecimalFormat("#");
    private final BukkitRunnable r;

    public SpawnArmorStand(MoonCore plugin) {

        this.plugin = plugin;
        this.attackListener = plugin.getAttackListener();
        r = new BukkitRunnable() {
            final Set<Entity> stands = plugin.getIndicators().keySet();

            final List<Entity> removal = new ArrayList<>();

            @Override
            public void run() {
                for (Entity stand : stands) {
                    int ticksLeft = plugin.getIndicators().get(stand);
                    if (ticksLeft == 0) {

                        stand.remove();
                        removal.add(stand);
                        continue;
                    }
                    ticksLeft--;
                    plugin.getIndicators().put(stand, ticksLeft);
                }
                removal.forEach(stands::remove);
            }
        };
        r.runTaskTimer(plugin, 0, 20);
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        // asynce
    }

    public double getRandomOffset() {
        double random = Math.random();
        if (Math.random() > 0.5)
            random *= -1;
        return random;
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onEntityDamage(EntityDamageByEntityEvent event) {

        Entity rawEntity = event.getEntity();
        if (!(rawEntity instanceof LivingEntity) || rawEntity instanceof Villager) {
            return;
        }

        LivingEntity entity = (LivingEntity) rawEntity;
        Entity damager = event.getDamager();
        if (!(damager instanceof Player)) {
            if (damager instanceof Arrow) {
                if (AttackDamage.getCrit().containsKey(damager.getUniqueId())) {
                    AttackDamage.getCrit().remove(damager.getUniqueId());
                    double damage = event.getFinalDamage(), health = entity.getHealth() + entity.getAbsorptionAmount();

                    Location loc = entity.getLocation().add(getRandomOffset(), 1.5, getRandomOffset());
                    ArmorStand armorStand = spawnArmorStand(loc,
                            "<gradient:yellow:gold>-" + formatter.format(damage) + "🏹");
                    plugin.getIndicators().put(armorStand, 1);

                } else {
                    double damage = event.getFinalDamage(), health = entity.getHealth() + entity.getAbsorptionAmount();

                    Location loc = entity.getLocation().add(getRandomOffset(), 1.5, getRandomOffset());
                    ArmorStand armorStand = spawnArmorStand(loc, "<gray>-" + formatter.format(damage) + "🏹");
                    plugin.getIndicators().put(armorStand, 1);

                    if (Dodge.getDodge().containsKey(entity.getUniqueId())) {
                        Dodge.getDodge().remove(entity.getUniqueId());
                        ArmorStand armorStand1 = spawnArmorStand(loc, "<yellow><bold>ISKA");
                        plugin.getIndicators().put(armorStand1, 1);

                    }

                }
            } else {

                if (AttackDamage.getCrit().containsKey(damager.getUniqueId())) {
                    AttackDamage.getCrit().remove(damager.getUniqueId());
                    double damage = event.getFinalDamage(), health = entity.getHealth() + entity.getAbsorptionAmount();

                    Location loc = entity.getLocation().add(getRandomOffset(), 1.5, getRandomOffset());
                    ArmorStand armorStand = spawnArmorStand(loc,
                            "<gradient:yellow:gold>-" + formatter.format(damage) + "🗡");
                    plugin.getIndicators().put(armorStand, 1);

                } else {
                    double damage = event.getFinalDamage(), health = entity.getHealth() + entity.getAbsorptionAmount();

                    Location loc = entity.getLocation().add(getRandomOffset(), 1.5, getRandomOffset());
                    ArmorStand armorStand = spawnArmorStand(loc, "<gray>-" + formatter.format(damage) + "🗡");
                    plugin.getIndicators().put(armorStand, 1);

                    if (Dodge.getDodge().containsKey(entity.getUniqueId())) {
                        Dodge.getDodge().remove(entity.getUniqueId());
                        ArmorStand armorStand1 = spawnArmorStand(loc, "<yellow><bold>ISKA");
                        plugin.getIndicators().put(armorStand1, 1);

                    }

                }
            }
        } else {
            Player player = (Player) damager;
            ItemStack item = player.getInventory().getItemInMainHand();
            if (MaterialTags.BOWS.isTagged(item)) {
                return;
            }
            if (PlayerAttackListener.getWand().containsKey(player.getUniqueId())) {
                PlayerAttackListener.getWand().remove(player.getUniqueId());
                if (!(player.hasCooldown(item.getType())) || item.getType() == Material.BLAZE_ROD) {
                    if (AttackDamage.getCrit().containsKey(damager.getUniqueId())) {
                        AttackDamage.getCrit().remove(damager.getUniqueId());
                        double damage = event.getFinalDamage(),
                                health = entity.getHealth() + entity.getAbsorptionAmount();

                        Location loc = entity.getLocation().add(getRandomOffset(), 1.5, getRandomOffset());
                        ArmorStand armorStand = spawnArmorStand(loc,
                                "<gradient:aqua:dark_aqua>-" + formatter.format(damage) + "☄");
                        plugin.getIndicators().put(armorStand, 1);

                    } else {
                        double damage = event.getFinalDamage(),
                                health = entity.getHealth() + entity.getAbsorptionAmount();

                        Location loc = entity.getLocation().clone().add(getRandomOffset(), 1.5, getRandomOffset());
                        ArmorStand armorStand = spawnArmorStand(loc, "<gray>-" + formatter.format(damage) + "☄");
                        plugin.getIndicators().put(armorStand, 1);

                        if (Dodge.getDodge().containsKey(entity.getUniqueId())) {
                            Dodge.getDodge().remove(entity.getUniqueId());
                            ArmorStand armorStand1 = spawnArmorStand(loc, "<yellow><bold>ISKA");
                            plugin.getIndicators().put(armorStand1, 1);

                        }

                    }
                }
            } else {
                if (!(player.hasCooldown(item.getType())) || item.getType() == Material.BLAZE_ROD) {
                    if (AttackDamage.getCrit().containsKey(damager.getUniqueId())) {
                        AttackDamage.getCrit().remove(damager.getUniqueId());
                        double damage = event.getFinalDamage(),
                                health = entity.getHealth() + entity.getAbsorptionAmount();

                        Location loc = entity.getLocation().add(getRandomOffset(), 1.5, getRandomOffset());
                        ArmorStand armorStand = spawnArmorStand(loc,
                                "<gradient:yellow:gold>-" + formatter.format(damage) + "🗡");
                        plugin.getIndicators().put(armorStand, 1);

                    } else {
                        double damage = event.getFinalDamage(),
                                health = entity.getHealth() + entity.getAbsorptionAmount();

                        Location loc = entity.getLocation().clone().add(getRandomOffset(), 1.5, getRandomOffset());
                        ArmorStand armorStand = spawnArmorStand(loc, "<gray>-" + formatter.format(damage) + "🗡");
                        plugin.getIndicators().put(armorStand, 1);

                        if (Dodge.getDodge().containsKey(entity.getUniqueId())) {
                            Dodge.getDodge().remove(entity.getUniqueId());
                            ArmorStand armorStand1 = spawnArmorStand(loc, "<yellow><bold>ISKA");
                            plugin.getIndicators().put(armorStand1, 1);

                        }

                    }
                }
            }
        }
    }

    public static ArmorStand spawnArmorStand(Location loc, String name) {
        return loc.getWorld().spawn(loc, ArmorStand.class, armorStand -> {
            armorStand.setMarker(true);
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setSmall(false);
            armorStand.setInvulnerable(true);
            armorStand.setCustomNameVisible(true);
            armorStand.customName(MiniMessage.miniMessage().deserialize(name));
            Location rotateloc = new Location(armorStand.getWorld(), armorStand.getLocation().getX(), armorStand.getLocation().getY(), armorStand.getLocation().getZ(), armorStand.getLocation().getYaw(), 1);

        });
    }

}
