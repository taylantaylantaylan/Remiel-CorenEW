package me.taylan.mooncore.listeners.entitydamage;

import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import me.taylan.mooncore.MoonCore;

public class Dodge implements Listener {
	private final MoonCore plugin;

	public Dodge(MoonCore plugin) {
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	private static final HashMap<UUID, String> dodgeMech = new HashMap<UUID, String>();

	@EventHandler
	public void dodgeMech(EntityDamageByEntityEvent event) {
		Entity rawEntity = event.getEntity();
		Entity entity2 = event.getDamager();
		if (!(rawEntity instanceof Player && entity2 instanceof LivingEntity)) {
			return;
		}
		LivingEntity attacker = (LivingEntity) entity2;
		Player defender = (Player) rawEntity;

		ItemStack boot = defender.getInventory().getBoots();

		NamespacedKey key = new NamespacedKey(plugin, "Enchants");

		if (event.getCause() == DamageCause.POISON || event.getCause() == DamageCause.WITHER
				|| event.getCause() == DamageCause.FIRE_TICK) {
			return;

		}

		if (boot != null) {
			ItemMeta meta2 = boot.getItemMeta();
			PersistentDataContainer container2 = meta2.getPersistentDataContainer();
			if ((boot.getItemMeta().getPersistentDataContainer().getKeys()
					.contains(new NamespacedKey(plugin, "Enchants")))) {
				if (Objects.requireNonNull(container2.get(key, PersistentDataType.STRING)).contains("dodgerate")) {
					if (attacker instanceof Player) {

						Player attacker2 = (Player) attacker;
						ItemStack item = attacker2.getInventory().getItemInMainHand();
						if (item == null) {
							return;
						}
						ItemMeta meta = item.getItemMeta();
						if (meta.getPersistentDataContainer() != null && meta != null) {
							PersistentDataContainer container = meta.getPersistentDataContainer();
							if ((item.getItemMeta().getPersistentDataContainer().getKeys()
									.contains(new NamespacedKey(plugin, "Enchants")))) {
								if (Objects.requireNonNull(container.get(key, PersistentDataType.STRING)).contains("desme")) {
									String[] parts = Objects.requireNonNull(container.get(key, PersistentDataType.STRING)).split(" ");
									int level = Integer.parseInt(parts[1]);
									int chance = ThreadLocalRandom.current().nextInt(20 + level * 2);

									if (chance < 4) {
										event.setCancelled(true);
										dodgeMech.put(defender.getUniqueId(), "dodge");
									}
								} else {
									String[] parts2 = Objects.requireNonNull(container2.get(key, PersistentDataType.STRING)).split(" ");
									int level2 = Integer.parseInt(parts2[1]);
									int chance = ThreadLocalRandom.current().nextInt(20 - level2 * 2);

									if (chance < 4) {
										event.setCancelled(true);
										dodgeMech.put(defender.getUniqueId(), "dodge");
									}
								}

							}
						}

					} else {
						String[] parts2 = Objects.requireNonNull(container2.get(key, PersistentDataType.STRING)).split(" ");
						int level2 = Integer.parseInt(parts2[1]);
						int chance = ThreadLocalRandom.current().nextInt(20 - level2 * 2);

						if (chance < 4) {
							event.setCancelled(true);
							dodgeMech.put(defender.getUniqueId(), "dodge");
						}
					}
				}
			}
		}

	}

	public static HashMap<UUID, String> getDodge() {
		return dodgeMech;
	}
}
