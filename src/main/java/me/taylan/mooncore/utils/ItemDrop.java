package me.taylan.mooncore.utils;

import me.taylan.mooncore.MoonCore;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ItemDrop {
    private MoonCore plugin;


    private Map<ArmorStand, UUID> dropmap = new HashMap<ArmorStand, UUID>();
    public Map<ArmorStand, UUID> getDropmap() {
        return dropmap;
    }

    public ItemDrop(MoonCore plugin) {
        this.plugin = plugin;
    }
    public void itemDrop(Player player, Location loc2, ItemStack item, EquipmentSlot equip) {
        World world = player.getWorld();
        world.spawn(loc2, ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setSmall(false);
            armorStand.setInvulnerable(true);
            armorStand.setItem(equip, item);
            armorStand.customName(item.getItemMeta().displayName());
            armorStand.setCustomNameVisible(true);
            plugin.getIndicators().put(armorStand,180);
            for (Player player2 : Bukkit.getOnlinePlayers()) {
                if (world.getName().equals("dungeonworld") || world.getName().equals("world")) {
                    if (player2 == player) continue;
                    player2.hideEntity(plugin, armorStand);
                }
            }
            dropmap.put(armorStand, player.getUniqueId());
            new BukkitRunnable() {

                @Override
                public void run() {
                    if(armorStand.isDead()) {
                        dropmap.remove(armorStand);
                        Bukkit.getPlayer(dropmap.get(armorStand)).sendMessage("aga");
                        this.cancel();
                    }
                    Location location = armorStand.getLocation();
                    location.setYaw(location.getYaw() - 1);
                    armorStand.teleportAsync(location);
                    for (Entity entity : armorStand.getNearbyEntities(0.1, 0.1, 0.1)) {
                        if (entity.getUniqueId().equals(dropmap.get(armorStand))) {
                            Player playerdrop = Bukkit.getPlayer(dropmap.get(armorStand));
                            if(playerdrop.getInventory().firstEmpty() == -1) {
                                player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
                                        new TextComponent(Painter.paint("&cEnvanterin Dolu!")));
                            } else {
                                playerdrop.getInventory().addItem(item);
                                playerdrop.sendMessage(
                                        Painter.paint("&7Yerden bir eşya alındı: " + item.getItemMeta().getDisplayName()));
                                playerdrop.playSound(playerdrop, Sound.ENTITY_ITEM_PICKUP, 0.5F, 1.3F);
                                armorStand.remove();
                                this.cancel();
                            }
                        }
                    }

                }
            }.runTaskTimer(plugin, 0, 1L);
        });
    }
    public void itemDrop(Player player, Entity entity, ItemStack item, EquipmentSlot equip) {
        World world = player.getWorld();
        Location loc = entity.getLocation();
        world.spawn(loc, ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setSmall(false);
            armorStand.setInvulnerable(true);
            armorStand.setItem(equip, item);
            armorStand.customName(item.getItemMeta().displayName());
            armorStand.setCustomNameVisible(true);
            plugin.getIndicators().put(armorStand,180);
            for (Player player2 : Bukkit.getOnlinePlayers()) {
                if (world.getName().equals("dungeonworld") || world.getName().equals("world")) {
                    if (player2 == player) continue;
                    player2.hideEntity(plugin, armorStand);
                }
            }
            dropmap.put(armorStand, player.getUniqueId());
            new BukkitRunnable() {

                @Override
                public void run() {
                    if(armorStand.isDead()) {
                        dropmap.remove(armorStand);
                        Bukkit.getPlayer(dropmap.get(armorStand)).sendMessage("aga");
                        this.cancel();
                    }
                    Location location = armorStand.getLocation();
                    location.setYaw(location.getYaw() - 1);
                    armorStand.teleportAsync(location);
                    for (Entity entity : armorStand.getNearbyEntities(0.1, 0.1, 0.1)) {
                        if (entity.getUniqueId().equals(dropmap.get(armorStand))) {
                            Player playerdrop = Bukkit.getPlayer(dropmap.get(armorStand));
                            if(playerdrop.getInventory().firstEmpty() == -1) {
                                player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
                                        new TextComponent(Painter.paint("&cEnvanterin Dolu!")));
                            } else {
                                playerdrop.getInventory().addItem(item);
                                playerdrop.sendMessage(
                                        Painter.paint("&7Yerden bir eşya alındı: " + item.getItemMeta().getDisplayName()));
                                playerdrop.playSound(playerdrop, Sound.ENTITY_ITEM_PICKUP, 0.5F, 1.3F);
                                armorStand.remove();
                                this.cancel();
                            }
                        }
                    }

                }
            }.runTaskTimer(plugin, 0, 1L);
        });
    }
}
