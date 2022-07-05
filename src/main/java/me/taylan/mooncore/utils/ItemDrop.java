package me.taylan.mooncore.utils;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import me.taylan.mooncore.MoonCore;
import net.kyori.adventure.text.minimessage.MiniMessage;

public class ItemDrop {
	private MoonCore plugin;

	public ItemDrop(MoonCore plugin) {
		this.plugin = plugin;
	}

	public void itemDrop(LivingEntity entity, ItemStack item, EquipmentSlot equip) {
		World world = entity.getWorld();
		Location loc = entity.getLocation();
		world.spawn(loc, ArmorStand.class, armorStand -> {
			armorStand.setVisible(false);
			armorStand.setGravity(false);
			armorStand.setSmall(false);
			armorStand.setInvulnerable(true);
			armorStand.setItem(equip, item);
			armorStand.customName(MiniMessage.miniMessage().deserialize("<gradient:yellow:gold>Çelik Kaplamalı Zırh <dark_aqua>[<aqua>T3<dark_aqua>]"));
			armorStand.setCustomNameVisible(true);
			new BukkitRunnable() {

				@Override
				public void run() {
					Location location = armorStand.getLocation();
					location.setYaw(location.getYaw() - 1);
					armorStand.teleportAsync(location);
					for (Entity entity : armorStand.getNearbyEntities(0.1, 0.1, 0.1)) {
						if (entity instanceof Player) {
							Player player = (Player) entity;
							((Player) entity).getInventory().addItem(item);
							player.sendMessage(
									Painter.paint("&7Yerden bir eşya alındı: " + item.getItemMeta().getDisplayName()));
							armorStand.remove();
							this.cancel();
						}
					}

				}
			}.runTaskTimer(plugin, 0, 1L);
		});
	}
}
