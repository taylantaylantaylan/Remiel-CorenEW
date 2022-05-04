package me.taylan.mooncore.listeners.entitydamage;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.scheduler.BukkitRunnable;

import me.taylan.mooncore.MoonCore;
import net.kyori.adventure.text.minimessage.MiniMessage;

public class SpawnArmorStand implements Listener {

	private MoonCore plugin;


	private DecimalFormat formatter = new DecimalFormat("#");
	private BukkitRunnable r;

	public SpawnArmorStand(MoonCore plugin) {
		
		this.plugin = plugin;
		
		r = new BukkitRunnable() {
			Set<Entity> stands = plugin.getIndicators().keySet();
			List<Entity> removal = new ArrayList<>();

			@Override
			public void run() {
				for (Entity stand : stands) {
					int ticksLeft = plugin.getIndicators().get(stand);
					stand.teleportAsync(stand.getLocation().add(0,0.02,0));
					if (ticksLeft == 0) {
				
						stand.remove();
						removal.add(stand);
						continue;
					}
					ticksLeft--;
					plugin.getIndicators().put(stand, ticksLeft);
				}
				stands.removeAll(removal);
			}
		};
		r.runTaskTimer(plugin, 0, 1);
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		//async
	}

	public double getRandomOffset() {
		double random = Math.random();
		if (Math.random() > 0.5)
			random *= -1;
		return random;
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void onEntityDamage(EntityDamageByEntityEvent event) {

		Entity rawEntity = event.getEntity();
		if (!(rawEntity instanceof LivingEntity) || rawEntity instanceof Villager) {
			return;
		}
		LivingEntity entity = (LivingEntity) rawEntity;
		Entity damager = event.getDamager();

		if (AttackDamage.getCrit().containsKey(damager.getUniqueId())) {
			AttackDamage.getCrit().remove(damager.getUniqueId());
			double damage = event.getFinalDamage(), health = entity.getHealth() + entity.getAbsorptionAmount();
			health -= damage;
			Location loc = entity.getLocation().clone().add(getRandomOffset(), 1.5, getRandomOffset());
			World world = Bukkit.getServer().getWorld("world");
			world.spawn(loc, ArmorStand.class, armorStand -> {
				armorStand.setMarker(true);
				armorStand.setVisible(false);
				armorStand.setGravity(false);
				armorStand.setSmall(true);
				armorStand.setCustomNameVisible(true);
				armorStand.customName(
						MiniMessage.get().parse("<gradient:yellow:gold>-" + formatter.format(damage) + "🗡"));
				plugin.getIndicators().put(armorStand, 80);

			});
		} else {
			double damage = event.getFinalDamage(), health = entity.getHealth() + entity.getAbsorptionAmount();
			health -= damage;
			Location loc = entity.getLocation().clone().add(getRandomOffset(), 1.5, getRandomOffset());
			World world = Bukkit.getServer().getWorld("world");
			world.spawn(loc, ArmorStand.class, armorStand -> {
				armorStand.setMarker(true);
				armorStand.setVisible(false);
				armorStand.setGravity(false);
				armorStand.setSmall(true);
				armorStand.setCustomNameVisible(true);
				armorStand.customName(MiniMessage.get().parse("<gray>-" + formatter.format(damage) + "🗡"));
				plugin.getIndicators().put(armorStand, 80);
			});

			if (Dodge.getDodge().containsKey(entity.getUniqueId())) {
				Dodge.getDodge().remove(entity.getUniqueId());
				world.spawn(loc, ArmorStand.class, armorStand -> {
					armorStand.setMarker(true);
					armorStand.setVisible(false);
					armorStand.setGravity(false);
					armorStand.setSmall(true);
					armorStand.setInvulnerable(true);
					armorStand.setCustomNameVisible(true);
					armorStand.customName(MiniMessage.get().parse("<yellow><bold>ISKA"));
					plugin.getIndicators().put(armorStand, 80);
				});
			}

		}
	}

}
