package me.taylan.mooncore.animations;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.level.Levels;
import me.taylan.mooncore.listeners.InventoryClickListener;
import me.taylan.mooncore.listeners.JoinListener;
import me.taylan.mooncore.listeners.entitydamage.SpawnArmorStand;
import me.taylan.mooncore.utils.Painter;
import me.taylan.mooncore.utils.StatsManager;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class WorkAnim {
	private MoonCore plugin;
	private StatsManager stats;
	private Levels levels;

	public WorkAnim(MoonCore plugin) {
		this.plugin = plugin;
		this.levels = plugin.getLevels();
		this.stats = plugin.getStatsManager();

	}

	public void workAnimation(Player p, int smithTime, ItemStack result, int exp) {
		int timer = stats.getWorkProduction(p.getUniqueId());
		if (timer > 0) {
			p.sendMessage(Painter.paint(
					"&cZaten bir ekipman işliyorsun! 2. Bir ekipmanı işlemeye koymak için 10. seviye ve üzeri Demircilikte ustalık gerekir."));
		}
		if (timer <= 0) {

			Block block = InventoryClickListener.getElSanatBlock().get(p.getUniqueId());
			Location loc3 = block.getLocation().add(0.1, -0.2, 1.4);
			loc3.setYaw(-180);
			Location loc = block.getLocation().add(0.5, 1, 0.5);
			Location loc2 = block.getLocation().add(0.5, 1.2, 0.5);
			ArmorStand armorStand2 = SpawnArmorStand.spawnArmorStand(loc2, "<yellow>Yapılıyor...");
			ArmorStand armorStand = SpawnArmorStand.spawnArmorStand(loc, "");
			for (Player player2 : Bukkit.getOnlinePlayers()) {
				if (p.getWorld().getName().equals("dungeonworld") ||p.getWorld().getName().equals("world")) {
					if (player2 == p) continue;
					player2.hideEntity(plugin, armorStand);
				}
			}
			for (Player player2 : Bukkit.getOnlinePlayers()) {
				if (p.getWorld().getName().equals("dungeonworld") ||p.getWorld().getName().equals("world")) {
					if (player2 == p) continue;
					player2.hideEntity(plugin, armorStand2);
				}
			}
			new BukkitRunnable() {

				@Override
				public void run() {
					int timer = stats.getWorkProduction(p.getUniqueId());
					stats.setWorkProduction(p.getUniqueId(), 1);
					int remain = smithTime - timer;
					p.playSound(loc, Sound.BLOCK_ANVIL_PLACE, 2f, 1.4f);
					ItemStack itemData = new ItemStack(Material.OAK_WOOD);
					loc.getWorld().spawnParticle(Particle.ITEM_CRACK, loc, 5, 0.3, 0.5, 0.3, 0, itemData);

					armorStand.setCustomName(
							ChatColor.GOLD + "Ekipmanın Hazır Olmasına: " + ChatColor.WHITE + remain + " Saniye");
					if (timer >= smithTime) {
						levels.giveWorkLevel(p, result);

						armorStand.setCustomName(ChatColor.GREEN + "✔");

						JoinListener.getElsanatmenu().get(p.getUniqueId()).addItem(result);
						new BukkitRunnable() {

							@Override
							public void run() {
								armorStand.remove();

							}
						}.runTaskLater(plugin, 40L);
						armorStand2.remove();
						stats.setWorkProduction(p.getUniqueId(), -timer - 1);
						InventoryClickListener.getElSanatBlock().clear();
						p.playSound(loc, Sound.ENTITY_VILLAGER_WORK_FLETCHER, 0.1f, 1.2f);

						cancel();
					}

				}
			}.runTaskTimer(plugin, 0L, 20L);

		}

	}
}
