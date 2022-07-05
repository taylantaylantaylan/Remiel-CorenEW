package me.taylan.mooncore.listeners;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketContainer;
import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.Loots;
import me.taylan.mooncore.utils.Painter;
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
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class LootListener implements Listener {

    private MoonCore plugin;
    private Loots loots;
    private HashMap<Inventory, UUID> lootopen = new HashMap<>();

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
                player.sendActionBar(MiniMessage.miniMessage().deserialize("<red><BOLD>BU SANDIK TUZAKLIYMIŞ!"));
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
                    player.sendActionBar(MiniMessage.miniMessage().deserialize("<red>Bu sandık daha önce yağmalanmış."));
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
                player.sendActionBar(MiniMessage.miniMessage().deserialize("<red><BOLD>BU SANDIK TUZAKLIYMIŞ!"));
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
                    player.sendActionBar(MiniMessage.miniMessage().deserialize("<red>Bu sandık daha önce yağmalanmış."));
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

    public void lootanim2(Location loc1, ItemStack Item) {
        Location loc = loc1.clone().add(getRandomOffset(), 1, getRandomOffset());
        World world = Bukkit.getServer().getWorld("world");
        ProtocolManager protocolManager = ProtocolLibrary.getProtocolManager();
        PacketContainer packet = protocolManager.createPacket(PacketType.Play.Server.SPAWN_ENTITY);

        // Entity ID
        int random = ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE);
        packet.getIntegers().write(0, random);
        // Entity Type
        packet.getEntityTypeModifier().write(0, EntityType.ARMOR_STAND);
        // Set optional velocity (/8000)
        packet.getIntegers().write(1, 0);
        packet.getIntegers().write(2, 0);
        packet.getIntegers().write(3, 0);
        // Set yaw pitch
        packet.getIntegers().write(4, 0);
        packet.getIntegers().write(5, 0);
        // Set object data
        packet.getIntegers().write(7, 0);
        // Set location
        packet.getDoubles().write(0, loc.getX());
        packet.getDoubles().write(1, loc.getY());
        packet.getDoubles().write(2, loc.getZ());
        // Set UUID
        packet.getUUIDs().write(0, UUID.randomUUID());


    }

    public void lootanim(Location loc1, ItemStack Item) {
        Location loc = loc1.clone().add(getRandomOffset(), 1, getRandomOffset());
        World world = Bukkit.getServer().getWorld("world");
        ArmorStand armorStand = (ArmorStand) world.spawnEntity(loc, EntityType.ARMOR_STAND);
        armorStand.setMarker(true);
        armorStand.setVisible(false);
        armorStand.setGravity(false);
        armorStand.setSmall(true);
        armorStand.setCustomNameVisible(true);
        armorStand.customName(MiniMessage.miniMessage().deserialize(Painter.paint(Item.getAmount() + "x " + Item.getItemMeta().getDisplayName())));
        plugin.getIndicators().put(armorStand, 80);


    }


}
