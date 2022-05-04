package me.taylan.mooncore.animations;

import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;

import me.taylan.mooncore.MoonCore;

public class SwingAnimation extends BukkitRunnable {
	private MoonCore plugin;

	private static final double TOP = 7d / 6 * Math.PI;
	private static final double BOTTOM = 7d / 4 * Math.PI;
	private final ArmorStand stand;
	private double rot;
	private Motion motion;
	private final double rotChangesPerTick;

	public SwingAnimation(ArmorStand stand, double cycleTime,MoonCore plugin) {
		this.stand = stand;
		this.plugin = plugin;
		stand.setArms(true);
		ItemStack axe = new ItemStack(Material.IRON_AXE);
		ItemMeta meta = axe.getItemMeta();
		meta.setDisplayName("hammer");
		axe.setItemMeta(meta);
		stand.setItemInHand(axe);
		// start the animation with the axe at the top
		rot = TOP;
		stand.setRightArmPose(new EulerAngle(TOP, 0, 0));
		motion = Motion.DOWN;
		rotChangesPerTick = Math.abs(TOP - BOTTOM) / (cycleTime / 2);

		runTaskTimer(plugin, 0L, 1L);
	}

	@Override
	public void run() {
		switch (motion) {
		case DOWN:
			rot += rotChangesPerTick;
			break;
		case UP:
			rot -= rotChangesPerTick;
			break;
		}
		if (rot <= TOP) {
			motion = Motion.DOWN;
		}
		if (rot >= BOTTOM) {
			motion = Motion.UP;
		}
		stand.setRightArmPose(new EulerAngle(rot, 0, 0));
	}

	private enum Motion {
		DOWN, UP
	}
}