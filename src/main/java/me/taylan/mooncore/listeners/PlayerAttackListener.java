package me.taylan.mooncore.listeners;

import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import com.destroystokyo.paper.MaterialTags;

import me.taylan.mooncore.MoonCore;

public class PlayerAttackListener implements Listener{

	private MoonCore plugin;
	
	public PlayerAttackListener(MoonCore plugin) {
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void attackmanager(EntityDamageByEntityEvent event) {
		Entity entity = event.getDamager();
		Entity damaged = event.getEntity();
		if(!(entity instanceof Player && damaged instanceof LivingEntity)) {
			return;
		}
	    Player player = (Player) event.getDamager();
	    World world = player.getWorld();
	    ItemStack item = player.getInventory().getItemInMainHand();
	    if(MaterialTags.HOES.isTagged(item)) {

	    	world.spawnParticle(Particle.SWEEP_ATTACK,damaged.getLocation().add(0,1.2,0) , 1, 2, 1, 2, 1);

	    	
	    }
	}
}
