package me.taylan.mooncore.utils;

import me.taylan.mooncore.MoonCore;
import org.bukkit.ChunkSnapshot;
import org.bukkit.Location;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class LeaveChunk extends BukkitRunnable {

	private final ChunkSnapshot snapshot;
	private final MoonCore plugin;
	private List<Location> loclist = new ArrayList<>();

	public LeaveChunk(ChunkSnapshot snapshot, MoonCore plugin) {
		this.snapshot = snapshot;
		this.plugin = plugin;
	}
/*
	@Override
	public void run() {
		for (int x = 0; x < 16; x++) {
			for (int z = 0; z < 16; z++) {
				for (int y = 1; y < 256; y++) {
					Material type = snapshot.getBlockType(x, y, z);
					Material type2 = snapshot.getBlockType(x, y - 1, z);
					if (Tag.LEAVES.isTagged(type) && type2 == Material.AIR) {
						Location loc = new Location(Bukkit.getWorld("world"), snapshot.getX() * 16 + x, y,
								snapshot.getZ() * 16 + z);
						loclist.add(loc);

					}
				}
			}
		}
		new BukkitRunnable() {

			@Override
			public void run() {
				World w = Bukkit.getWorld("world");
				if (!(loclist.isEmpty())) {
					for (Location loc : loclist) {
						int chance = ThreadLocalRandom.current().nextInt(50);
						if (chance < 3) {
							w.spawnParticle(Particle.FALLING_SPORE_BLOSSOM, loc, 1, 0, 0, 0, 0);
						}
					}
				}
			}
		}.runTaskTimerAsynchronously(this.plugin, 0, 80);
	}
*/

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
