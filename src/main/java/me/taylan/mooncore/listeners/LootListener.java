package me.taylan.mooncore.listeners;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketContainer;
import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.Loots;
import me.taylan.mooncore.utils.Painter;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.*;
import org.bukkit.block.BlockState;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class LootListener implements Listener {

    private final MoonCore plugin;
    private final Loots loots;
    private final HashMap<Inventory, UUID> lootopen = new HashMap<>();


    public HashMap<Inventory, UUID> getLootopen() {
       return lootopen;
    }


    public LootListener(MoonCore plugin) {
        this.plugin = plugin;
        this.loots = plugin.getLoots();
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    public double getRandomOffset() {
        double random = Math.random();
        if (Math.random() > 0.5)
            random *= -1;
        return random;
    }

    @EventHandler
    public void lootopen(InventoryOpenEvent event) {
        Player player = (Player) event.getPlayer();
        InventoryView inv = event.getView();

        if (inv.getTitle().equals(Painter.paint("&8Orman Ganimet Sandığı"))) {
            int trapchance = ThreadLocalRandom.current().nextInt(20);
            if (trapchance < 2) {
                player.sendActionBar(MiniMessage.builder().build().deserialize("<red><BOLD>BU SANDIK TUZAKLIYMIŞ!"));
                PotionEffect effect = new PotionEffect(PotionEffectType.POISON, 300, 1);
                player.addPotionEffect(effect);
                player.damage(10);
                player.playSound(player.getLocation(), Sound.ENTITY_SHULKER_SHOOT, 100, 0.1f);
                player.getLocation().getWorld().spawnParticle(Particle.VILLAGER_HAPPY,
                        player.getLocation().add(0, 1.2, 0), 3, 0.7, 0.6, 0.7, 0.1);
                event.setCancelled(true);
                lootopen.put(event.getInventory(), player.getUniqueId());
                new BukkitRunnable() {

                    @Override
                    public void run() {
                        lootopen.remove(event.getInventory());

                    }
                }.runTaskLater(plugin, 1200);
            } else {
                if (!lootopen.containsKey(event.getInventory())) {
                    generateLoot(event.getInventory(), loots.ormanLoot());
                    lootopen.put(event.getInventory(), player.getUniqueId());

                    new BukkitRunnable() {

                        @Override
                        public void run() {
                            lootopen.remove(event.getInventory());

                        }
                    }.runTaskLater(plugin, 1200);
                } else {
                    player.sendActionBar(MiniMessage.builder().build().deserialize("<red>Bu sandık daha önce yağmalanmış."));
                    event.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void lootopen2(InventoryOpenEvent event) {
        Player player = (Player) event.getPlayer();
        InventoryView inv = event.getView();

        if (inv.getTitle().equals(Painter.paint("&8Zindan Ganimet Sandığı"))) {
            int trapchance = ThreadLocalRandom.current().nextInt(20);
            if (trapchance < 2) {
                player.sendActionBar(MiniMessage.builder().build().deserialize("<red><BOLD>BU SANDIK TUZAKLIYMIŞ!"));
                PotionEffect effect = new PotionEffect(PotionEffectType.POISON, 300, 1);
                player.addPotionEffect(effect);
                player.damage(10);
                player.playSound(player.getLocation(), Sound.ENTITY_SHULKER_SHOOT, 100, 0.1f);
                player.getLocation().getWorld().spawnParticle(Particle.VILLAGER_HAPPY,
                        player.getLocation().add(0, 1.2, 0), 3, 0.7, 0.6, 0.7, 0.1);
                event.setCancelled(true);
                lootopen.put(event.getInventory(), player.getUniqueId());
                new BukkitRunnable() {

                    @Override
                    public void run() {
                        lootopen.remove(event.getInventory());

                    }
                }.runTaskLater(plugin, 1200);
            } else {
                if (!lootopen.containsKey(event.getInventory())) {
                    generateLoot(event.getInventory(), loots.dungeonLoot());
                    lootopen.put(event.getInventory(), player.getUniqueId());

                    new BukkitRunnable() {

                        @Override
                        public void run() {
                            lootopen.remove(event.getInventory());

                        }
                    }.runTaskLater(plugin, 1200);
                } else {
                    player.sendActionBar(MiniMessage.builder().build().deserialize("<red>Bu sandık daha önce yağmalanmış."));
                    event.setCancelled(true);
                }
            }
        }
    }

    public void generateLoot(Inventory inv, List<ItemStack> list) {
        for (ItemStack item : list) {
            int randomnumber = ThreadLocalRandom.current().nextInt(26);
            if (inv.getItem(randomnumber) == null) {
                inv.setItem(randomnumber, item);
            } else {
                return;
            }
        }
    }
    @EventHandler
    public void lootclose2(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();
        InventoryView inv = event.getView();
        Inventory invreal = event.getInventory();
        if (!(invreal.getHolder() instanceof BlockState)) {
            return;
        }
        BlockState chestinv = (BlockState) invreal.getHolder();
        if (inv.getTitle().equals(Painter.paint("&8Zindan Ganimet Sandığı"))) {
            if (player.getInventory().firstEmpty() == -1) {
                for (ItemStack item : event.getInventory().getContents()) {
                    if (item != null) {
                        lootanim(chestinv.getLocation(), item);
                        player.getWorld().dropItem(player.getLocation(), item);
                        event.getInventory().remove(item);
                        // stash yapacaksın pickupstash
                    }
                }
            } else {
                for (ItemStack item : event.getInventory().getContents()) {
                    if (item != null) {
                        lootanim(chestinv.getLocation(), item);
                        player.getInventory().addItem(item);
                        event.getInventory().remove(item);


                    }
                }
            }
        }
    }
    @EventHandler
    public void lootclose(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();
        InventoryView inv = event.getView();
        Inventory invreal = event.getInventory();
        if (!(invreal.getHolder() instanceof BlockState)) {
            return;
        }
        BlockState chestinv = (BlockState) invreal.getHolder();
        if (inv.getTitle().equals(Painter.paint("&8Orman Ganimet Sandığı"))) {
            if (player.getInventory().firstEmpty() == -1) {
                for (ItemStack item : event.getInventory().getContents()) {
                    if (item != null) {
                        lootanim(chestinv.getLocation(), item);
                        player.getWorld().dropItem(player.getLocation(), item);
                        event.getInventory().remove(item);
                        // stash yapacaksın pickupstash
                    }
                }
            } else {
                for (ItemStack item : event.getInventory().getContents()) {
                    if (item != null) {
                        lootanim(chestinv.getLocation(), item);
                        player.getInventory().addItem(item);
                        event.getInventory().remove(item);


                    }
              }
            }
     }
   }



    public void lootanim(Location loc1, ItemStack Item) {
        Location loc = loc1.clone().add(getRandomOffset(), 1, getRandomOffset());
        World world = Bukkit.getServer().getWorld("world");
        ArmorStand armorStand = (ArmorStand) Objects.requireNonNull(world).spawnEntity(loc, EntityType.ARMOR_STAND);
        armorStand.setMarker(true);
        armorStand.setVisible(false);
        armorStand.setGravity(false);
        armorStand.setSmall(true);
        armorStand.setCustomNameVisible(true);
        armorStand.customName(Component.text(Item.getAmount() + " x").append(Objects.requireNonNull(Item.getItemMeta().displayName())));
        plugin.getIndicators().put(armorStand, 80);


    }


}
