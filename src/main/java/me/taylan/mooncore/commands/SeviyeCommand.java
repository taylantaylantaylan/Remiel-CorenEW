package me.taylan.mooncore.commands;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.Painter;
import me.taylan.mooncore.utils.StatsManager;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.title.Title;

public class SeviyeCommand implements CommandExecutor {
	private MoonCore plugin;
	private StatsManager stats;
	private HashMap<ArmorStand, Integer> timer = new HashMap<ArmorStand, Integer>();
	public static double getRandomOffset() {
		double random = Math.random();
		if (Math.random() > 0.4)
			random *= -1;
		return random;
	}

	public static double getRandomOffset2() {
		double random = Math.random();
		if (Math.random() > 0.5)
			random *= -1;
		return random;
	}
	
	public SeviyeCommand(MoonCore plugin) {
		this.plugin = plugin;
		this.stats = plugin.getStatsManager();

		plugin.getCommand("seviye").setExecutor(this);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player)) {
			return true;
		}

		Player p = (Player) sender;

		if (p.hasPermission("mooncore.seviye")) {

			if (args.length <= 0) {
				p.sendMessage(Painter.paint("&cYanlış Kullanım!"));
			} else if (args.length > 0) {
				switch (args[0].toString()) {
				case "ekle":
					int seviye = Integer.valueOf(args[1]);
					seviyeAtlat(p, seviye);
					Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
					Team isim = scoreboard.getTeam(p.getName());
					if (isim.hasEntry(p.getName())) {
						isim.setPrefix(Painter.paint("&7[&fSvy. " + stats.getLevel(p.getUniqueId()) + "&7] &f"));
						isim.setSuffix(Painter.paint(" &6[" + (int) p.getHealth() + "❤]"));
					} else {
						isim.addEntry(p.getName());
						isim.setPrefix(Painter.paint("&7[&fSvy. " + stats.getLevel(p.getUniqueId()) + "&7] &f"));
						isim.setSuffix(Painter.paint(" &6[" + (int) p.getHealth() + "❤]"));
					}
					break;

				}

			}

		}

		return false;
	}

	public void seviyeAtlat(Player p, int seviye) {
		int offset2 = 2;
		int offset = 2;
		int xOff = ThreadLocalRandom.current().nextInt(-offset, offset);
		int zOff = ThreadLocalRandom.current().nextInt(-offset2, offset2);

		int seviye2 = stats.getLevel(p.getUniqueId()) - seviye;

		Location loc = p.getLocation().clone().add(getRandomOffset(), 1.3, zOff);
		Location loc2 = p.getLocation().clone().add(xOff, 1.1, getRandomOffset2());
		Location loc3 = p.getLocation().clone().add(getRandomOffset2(), 1.2, zOff);
		Location loc4 = p.getLocation().clone().add(xOff, 1.0, getRandomOffset());

		p.playSound(p.getLocation(), Sound.ENTITY_ILLUSIONER_PREPARE_MIRROR, 100, 0.6f);

		p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100, 0.8f);
		p.showTitle(

				Title.title(MiniMessage.get().parse("<green>-=[</green><aqua>Seviye Atladın!</aqua><green>]=-</green>"),
						MiniMessage.get().parse("<yellow>(</yellow><green>" + seviye2 + " <yellow>-></yellow> <green> "
								+ stats.getLevel(p.getUniqueId()) + "<yellow>)")));
		p.spawnParticle(Particle.VILLAGER_HAPPY, p.getLocation().add(0, 1, 0), 40, 0.4, 0.3, 0.4, 0);
		p.spawnParticle(Particle.SPELL_INSTANT, p.getLocation(), 50, 0.4, 0.3, 0.4, 0);
		p.spawnParticle(Particle.ENCHANTMENT_TABLE, p.getLocation().add(0, 2, 0), 30, 1.2, 0.6, 1.2, 0);
		p.playSound(p.getLocation(), Sound.ENTITY_ILLUSIONER_PREPARE_MIRROR, 100, 0.2f);
		World world = Bukkit.getServer().getWorld("world");

		world.spawn(loc.add(1, 0, 0), ArmorStand.class, armorStand -> {
			armorStand.setMarker(true);
			armorStand.setVisible(false);
			armorStand.setGravity(false);
			armorStand.setSmall(true);
			armorStand.setCustomNameVisible(true);
			armorStand.customName(MiniMessage.get().parse("<white>⬆<gold>❤"));
			timer.put(armorStand, 0);
			new BukkitRunnable() {

				@Override
				public void run() {
					Location loci = armorStand.getLocation().add(0, 0.02, 0);
					armorStand.teleport(loci);
					Integer timer2 = timer.get(armorStand);
					timer2++;
					timer.put(armorStand, timer2);
					if (timer2 >= 40) {
						timer2 = 0;
						timer.remove(armorStand);
						armorStand.remove();
						cancel();
					}
				}
			}.runTaskTimer(plugin, 0L, 2L);
		});
		world.spawn(loc2, ArmorStand.class, armorStand -> {
			armorStand.setMarker(true);
			armorStand.setVisible(false);
			armorStand.setGravity(false);
			armorStand.setSmall(true);
			armorStand.setCustomNameVisible(true);
			armorStand.customName(MiniMessage.get().parse("<green>⬆<gold>❤"));
			timer.put(armorStand, 0);
			new BukkitRunnable() {

				@Override
				public void run() {
					Location loci = armorStand.getLocation().add(0, 0.01, 0);
					armorStand.teleport(loci);
					Integer timer2 = timer.get(armorStand);
					timer2++;
					timer.put(armorStand, timer2);
					if (timer2 >= 40) {
						timer2 = 0;
						timer.remove(armorStand);
						armorStand.remove();
						cancel();
					}
				}
			}.runTaskTimer(plugin, 0L, 2L);
		});
		world.spawn(loc2.add(-1, 0, -1), ArmorStand.class, armorStand -> {
			armorStand.setMarker(true);
			armorStand.setVisible(false);
			armorStand.setGravity(false);
			armorStand.setSmall(true);
			armorStand.setCustomNameVisible(true);
			armorStand.customName(MiniMessage.get().parse("<yellow>⬆<red>⚔"));
			timer.put(armorStand, 0);
			new BukkitRunnable() {

				@Override
				public void run() {
					Location loci = armorStand.getLocation().add(0, 0.01, 0);
					armorStand.teleport(loci);
					Integer timer2 = timer.get(armorStand);
					timer2++;
					timer.put(armorStand, timer2);
					if (timer2 >= 40) {
						timer2 = 0;
						timer.remove(armorStand);
						armorStand.remove();
						cancel();
					}
				}
			}.runTaskTimer(plugin, 0L, 2L);
		});
		world.spawn(loc.add(0, 1, -1), ArmorStand.class, armorStand -> {
			armorStand.setMarker(true);
			armorStand.setVisible(false);
			armorStand.setGravity(false);
			armorStand.setSmall(true);
			armorStand.setCustomNameVisible(true);
			armorStand.customName(MiniMessage.get().parse("<white>⬆<white>🌊"));
			timer.put(armorStand, 0);
			new BukkitRunnable() {

				@Override
				public void run() {
					Location loci = armorStand.getLocation().add(0, 0.01, 0);
					armorStand.teleport(loci);
					Integer timer2 = timer.get(armorStand);
					timer2++;
					timer.put(armorStand, timer2);
					if (timer2 >= 40) {
						timer2 = 0;
						timer.remove(armorStand);
						armorStand.remove();
						cancel();
					}
				}
			}.runTaskTimer(plugin, 0L, 2L);
		});
		world.spawn(loc4, ArmorStand.class, armorStand -> {
			armorStand.setMarker(true);
			armorStand.setVisible(false);
			armorStand.setGravity(false);
			armorStand.setSmall(true);
			armorStand.setCustomNameVisible(true);
			armorStand.customName(MiniMessage.get().parse("<red>⬆<white>🌊"));
			timer.put(armorStand, 0);
			new BukkitRunnable() {

				@Override
				public void run() {
					Location loci = armorStand.getLocation().add(0, 0.01, 0);
					armorStand.teleport(loci);
					Integer timer2 = timer.get(armorStand);
					timer2++;
					timer.put(armorStand, timer2);
					if (timer2 >= 40) {
						timer2 = 0;
						timer.remove(armorStand);
						armorStand.remove();
						cancel();
					}
				}
			}.runTaskTimer(plugin, 0L, 2L);
		});
		world.spawn(loc3, ArmorStand.class, armorStand -> {
			armorStand.setMarker(true);
			armorStand.setVisible(false);
			armorStand.setGravity(false);
			armorStand.setSmall(true);
			armorStand.setCustomNameVisible(true);
			armorStand.customName(MiniMessage.get().parse("<white>⬆<red>⚔"));
			timer.put(armorStand, 0);
			new BukkitRunnable() {

				@Override
				public void run() {
					Location loci = armorStand.getLocation().add(0, 0.03, 0);
					armorStand.teleport(loci);
					Integer timer2 = timer.get(armorStand);
					timer2++;
					timer.put(armorStand, timer2);
					if (timer2 >= 40) {
						timer2 = 0;
						timer.remove(armorStand);
						armorStand.remove();
						cancel();
					}
				}
			}.runTaskTimer(plugin, 0L, 2L);
		});
		world.spawn(loc2, ArmorStand.class, armorStand -> {
			armorStand.setMarker(true);
			armorStand.setVisible(false);
			armorStand.setGravity(false);
			armorStand.setSmall(true);
			armorStand.setCustomNameVisible(true);
			armorStand.customName(MiniMessage.get().parse("<white>⬆<yellow>❂"));
			timer.put(armorStand, 0);
			new BukkitRunnable() {

				@Override
				public void run() {
					Location loci = armorStand.getLocation().add(0, 0.01, 0);
					armorStand.teleport(loci);
					Integer timer2 = timer.get(armorStand);
					timer2++;
					timer.put(armorStand, timer2);
					if (timer2 >= 40) {
						timer2 = 0;
						timer.remove(armorStand);
						armorStand.remove();
						cancel();
					}
				}
			}.runTaskTimer(plugin, 0L, 2L);
		});
		world.spawn(loc4.add(-2, 0, 1), ArmorStand.class, armorStand -> {
			armorStand.setMarker(true);
			armorStand.setVisible(false);
			armorStand.setGravity(false);
			armorStand.setSmall(true);
			armorStand.setCustomNameVisible(true);
			armorStand.customName(MiniMessage.get().parse("<white>⬆<yellow>❂"));
			timer.put(armorStand, 0);
			new BukkitRunnable() {

				@Override
				public void run() {
					Location loci = armorStand.getLocation().add(0, 0.01, 0);
					armorStand.teleport(loci);
					Integer timer2 = timer.get(armorStand);
					timer2++;
					timer.put(armorStand, timer2);
					if (timer2 >= 40) {
						timer2 = 0;
						timer.remove(armorStand);
						armorStand.remove();
						cancel();
					}
				}
			}.runTaskTimer(plugin, 0L, 2L);
		});
		world.spawn(loc3, ArmorStand.class, armorStand -> {
			armorStand.setMarker(true);
			armorStand.setVisible(false);
			armorStand.setGravity(false);
			armorStand.setSmall(true);
			armorStand.setCustomNameVisible(true);
			armorStand.customName(MiniMessage.get().parse("<white>⬆<dark_aqua>※"));
			timer.put(armorStand, 0);
			new BukkitRunnable() {

				@Override
				public void run() {
					Location loci = armorStand.getLocation().add(0, 0.01, 0);
					armorStand.teleport(loci);
					Integer timer2 = timer.get(armorStand);
					timer2++;
					timer.put(armorStand, timer2);
					if (timer2 >= 40) {
						timer2 = 0;
						timer.remove(armorStand);
						armorStand.remove();
						cancel();
					}
				}
			}.runTaskTimer(plugin, 0L, 2L);
		});
		world.spawn(loc2, ArmorStand.class, armorStand -> {
			armorStand.setMarker(true);
			armorStand.setVisible(false);
			armorStand.setGravity(false);
			armorStand.setSmall(true);
			armorStand.setCustomNameVisible(true);
			armorStand.customName(MiniMessage.get().parse("<gray>⬆<dark_aqua>※"));
			timer.put(armorStand, 0);
			new BukkitRunnable() {

				@Override
				public void run() {
					Location loci = armorStand.getLocation().add(0, 0.05, 0);
					armorStand.teleport(loci);
					Integer timer2 = timer.get(armorStand);
					timer2++;
					timer.put(armorStand, timer2);
					if (timer2 >= 40) {
						timer2 = 0;
						timer.remove(armorStand);
						armorStand.remove();
						cancel();
					}
				}
			}.runTaskTimer(plugin, 0L, 2L);
		});

		stats.setLevel(p.getUniqueId(), seviye);
		p.sendMessage(Painter.paint(
				" &6+3" + " &cNitelik Puanı &7 kazandın! /nitelik yazarak bu nitelik puanlarını kullanabilirsin!"));
		stats.setNP(p.getUniqueId(), 3);

	}

}
