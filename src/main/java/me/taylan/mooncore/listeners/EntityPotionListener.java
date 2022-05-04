package me.taylan.mooncore.listeners;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPotionEffectEvent;
import org.bukkit.event.entity.EntityPotionEffectEvent.Action;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.StatsManager;

public class EntityPotionListener implements Listener {

	private MoonCore plugin;
	private StatsManager manager;
	private HashMap<UUID, Integer> potionmap = new HashMap<UUID, Integer>();

	public EntityPotionListener(MoonCore plugin) {
		this.plugin = plugin;
		this.manager = plugin.getStatsManager();
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void potionevent(EntityPotionEffectEvent event) {
		Entity entity = event.getEntity();
		if (!(entity instanceof Player)) {
			return;
		}
		Player player = (Player) entity;
		if (event.getAction() == Action.ADDED) {
			PotionEffect potion = event.getNewEffect();
			if (potion.getType() == PotionEffectType.SLOW_FALLING) {
				int gucpot = potion.getAmplifier() * 40;
				manager.setGuc(player.getUniqueId(), gucpot);
				potionmap.put(player.getUniqueId(), gucpot);
				player.sendMessage("Altarın kanını ictin.");
			}
			if (event.getAction() == Action.CLEARED || event.getAction() == Action.REMOVED) {
				manager.setGuc(player.getUniqueId(), -potionmap.get(player.getUniqueId()));
				potionmap.remove(player.getUniqueId());
				player.sendMessage("Altarın kanı sona erdi.");
			}
		}
	}

}
