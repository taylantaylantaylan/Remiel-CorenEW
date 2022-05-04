package me.taylan.mooncore.listeners.entitydamage;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.Painter;
import me.taylan.mooncore.utils.StatsManager;

public class AttackDamage implements Listener {
	private static HashMap<UUID, String> crit = new HashMap<UUID, String>();
	private MoonCore plugin;
	private StatsManager stats;

	public AttackDamage(MoonCore plugin) {
		this.plugin = plugin;
		this.stats = plugin.getStatsManager();
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	public static HashMap<UUID, String> getCrit() {
		return crit;
	}

	@EventHandler
	public void onDamage(EntityDamageByEntityEvent event) {
		if (event.isCancelled()) {
			return;
		}

		Entity entity = event.getDamager();
		LivingEntity damaged = (LivingEntity) event.getEntity();
		if (damaged instanceof Player) {
			Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
			Player player = (Player) damaged;
			Team isim = scoreboard.getTeam(player.getName());
			if (isim.hasEntry(player.getName())) {
				isim.setPrefix(Painter.paint("&7[&fSvy. " + stats.getLevel(player.getUniqueId()) + "&7] &f"));
				isim.setSuffix(Painter.paint(" &6[" + (int) player.getHealth() + "❤]"));
			} else {
				isim.addEntry(player.getName());
				isim.setPrefix(Painter.paint("&7[&fSvy. " + stats.getLevel(player.getUniqueId()) + "&7] &f"));
				isim.setSuffix(Painter.paint(" &6[" + (int) player.getHealth() + "❤]"));
			}

		}
		if (entity instanceof Player) {
			Random rand = new Random();

			Player player = (Player) entity;
			int chance = rand.nextInt(102 - stats.getKritikSansi(player.getUniqueId()));
			if (chance <= 4) {
				crit.put(player.getUniqueId(), "crit");

				event.setDamage(stats.getKritikHasari(player.getUniqueId()) / 100 + 2 * event.getDamage()
						+ 5 * stats.getGuc(player.getUniqueId()) / 100 + 1);
				player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 100, 0.8f);
				damaged.getLocation().getWorld().spawnParticle(Particle.CRIT,
						damaged.getLocation().add(0, 1.2, 0), 12, 0.7, 0.7, 0.7, 0.1);

			} else {
				event.setDamage(event.getDamage() + 5 * stats.getGuc(player.getUniqueId()) / 100 + 1);

			}
		} else if (entity instanceof Arrow) {
			Random rand = new Random();

			Arrow arrow = (Arrow) entity;
			Player player = (Player) arrow.getShooter();

			int chance = rand.nextInt(102 - stats.getKritikSansi(player.getUniqueId()));
			if (chance <= 4) {
				crit.put(arrow.getUniqueId(), "crit");
				arrow.setCritical(true);
				event.setDamage(
						stats.getKritikHasari(player.getUniqueId()) / 100 + 2 * event.getDamage() + 5 * 5 / 100 + 1);
				player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 100, 0.8f);
				damaged.getLocation().getWorld().spawnParticle(Particle.CRIT,
						damaged.getLocation().add(0, 1.2, 0), 12, 0.7, 0.7, 0.7, 0.1);

			} else {
				event.setDamage(event.getDamage() + 5 * 5 / 100 + 1);

			}
		}
	}
}
