package me.taylan.mooncore.listeners;

import me.taylan.mooncore.MoonCore;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleDamageEvent;
import org.bukkit.event.vehicle.VehicleEnterEvent;

import java.util.EnumSet;
import java.util.Set;

public class VehicleDamageListener implements Listener {
    private MoonCore plugin;

    public VehicleDamageListener(MoonCore plugin) {
        this.plugin = plugin;
        Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void vagon(VehicleDamageEvent event) {
        Entity entity = event.getAttacker();
        if (!(entity instanceof Player)) return;
        Player player = (Player) entity;
        if (player.getWorld().getName().equals("world")) {
            if (!(player.isOp())) {
                final Set<EntityType> SKIPPED_TYPES = EnumSet.of(EntityType.MINECART, EntityType.MINECART_CHEST,
                        EntityType.MINECART_FURNACE, EntityType.MINECART_FURNACE);
                if (SKIPPED_TYPES.contains(event.getVehicle().getType())) {
                    event.setCancelled(true);
                }
            }
        }
    }
    @EventHandler
    public void vagon(VehicleEnterEvent event) {
        Entity entity = event.getEntered();
        if (!(entity instanceof Player)) {
            event.setCancelled(true);
        }

    }
}
