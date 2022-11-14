package me.taylan.mooncore.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.Painter;
import me.taylan.mooncore.utils.StatsManager;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class StatsCommand implements CommandExecutor {
    private final MoonCore plugin;
	private final StatsManager stats;

	public StatsCommand(MoonCore plugin) {
		this.plugin = plugin;
		this.stats = plugin.getStatsManager();
		Objects.requireNonNull(plugin.getCommand("statekle")).setExecutor(this);
	}

	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

		if (!(sender instanceof Player)) {
			return true;
		}

		Player p = (Player) sender;

		if (p.hasPermission("mooncore.stat")) {

			if (args.length <= 0) {
				p.sendMessage(Painter.paint("&cYanlış Kullanım!"));
			} else if (args.length > 0) {
				if(args.length == 2) {
					switch (args[0].toString()) {
						case "guc" -> {
							int guc = Integer.valueOf(args[1]);
							stats.setGuc(p.getUniqueId(), guc);
							p.sendMessage(Painter.paint("&a+" + guc + " Güç"));
						}
						case "can" -> {
							int can = Integer.valueOf(args[1]);
							stats.setCan(p, p.getUniqueId(), can);
							p.sendMessage(Painter.paint("&a+" + can + " Can"));
						}
						case "direnc" -> {
							int direnc = Integer.valueOf(args[1]);
							stats.setDirenc(p.getUniqueId(), direnc);
							p.sendMessage(Painter.paint("&a+" + direnc + " Direnç"));
						}
						case "saldirihizi" -> {
							int saldirihizi = Integer.valueOf(args[1]);
							stats.setSaldiriHizi(p.getUniqueId(), saldirihizi);
							p.sendMessage(Painter.paint("&a+" + saldirihizi + " Saldırı Hızı"));
						}
						case "kritikhasari" -> {
							int kritikhasari = Integer.valueOf(args[1]);
							stats.setKritikHasari(p.getUniqueId(), kritikhasari);
							p.sendMessage(Painter.paint("&a+" + kritikhasari + " Kritik Hasarı"));
						}
						case "kritiksansi" -> {
							int kritiksansi = Integer.valueOf(args[1]);
							stats.setKritikSansi(p.getUniqueId(), kritiksansi);
							p.sendMessage(Painter.paint("&a+" + kritiksansi + " Kritik Şansı"));
						}
						case "sogukdirenci" -> {
							int sogukdirenci = Integer.valueOf(args[1]);
							stats.setSogukDirenci(p.getUniqueId(), sogukdirenci);
							p.sendMessage(Painter.paint("&a+" + sogukdirenci + " Soğuk Direnci"));
						}
						case "sicakdirenci" -> {
							int sicakdirenci = Integer.valueOf(args[1]);
							stats.setSicakDirenci(p.getUniqueId(), sicakdirenci);
							p.sendMessage(Painter.paint("&a+" + sicakdirenci + " Sıcak Direnci"));
						}
						case "hiclikdirenci" -> {
							int hiclikdirenci = Integer.valueOf(args[1]);
							stats.setHiclikDirenci(p.getUniqueId(), hiclikdirenci);
							p.sendMessage(Painter.paint("&a+" + hiclikdirenci + " Hiçlik Direnci"));
						}
						case "canyenileme" -> {
							int canyenileme = Integer.valueOf(args[1]);
							stats.setCanYenileme(p, p.getUniqueId(), canyenileme);
							p.sendMessage(Painter.paint("&a+" + canyenileme + " Can Yenileme"));
						}
						case "doygunluk" -> {
							int doygunluk = Integer.valueOf(args[1]);
							stats.setDoygunluk(p, p.getUniqueId(), doygunluk);
							p.sendMessage(Painter.paint("&a+" + doygunluk + " Doygunluk"));
						}
						case "hiz" -> {
							int hiz = Integer.valueOf(args[1]);
							stats.setHiz(p, p.getUniqueId(), hiz);
							p.sendMessage(Painter.paint("&a+" + hiz + " Hız"));
						}
					}
				} else if(args.length == 3) {
					Player statplayer = Bukkit.getPlayer(args[2]);
					switch (args[0].toString()) {
						case "guc" -> {
							int guc = Integer.valueOf(args[1]);
							stats.setGuc(statplayer.getUniqueId(), guc);
							p.sendMessage(Painter.paint("&a+" + guc + " Güç"));
						}
						case "can" -> {
							int can = Integer.valueOf(args[1]);
							stats.setCan(statplayer, statplayer.getUniqueId(), can);
							p.sendMessage(Painter.paint("&a+" + can + " Can"));
						}
						case "direnc" -> {
							int direnc = Integer.valueOf(args[1]);
							stats.setDirenc(statplayer.getUniqueId(), direnc);
							p.sendMessage(Painter.paint("&a+" + direnc + " Direnç"));
						}
						case "saldirihizi" -> {
							int saldirihizi = Integer.valueOf(args[1]);
							stats.setSaldiriHizi(statplayer.getUniqueId(), saldirihizi);
							p.sendMessage(Painter.paint("&a+" + saldirihizi + " Saldırı Hızı"));
						}
						case "kritikhasari" -> {
							int kritikhasari = Integer.valueOf(args[1]);
							stats.setKritikHasari(statplayer.getUniqueId(), kritikhasari);
							p.sendMessage(Painter.paint("&a+" + kritikhasari + " Kritik Hasarı"));
						}
						case "kritiksansi" -> {
							int kritiksansi = Integer.valueOf(args[1]);
							stats.setKritikSansi(statplayer.getUniqueId(), kritiksansi);
							p.sendMessage(Painter.paint("&a+" + kritiksansi + " Kritik Şansı"));
						}
						case "sogukdirenci" -> {
							int sogukdirenci = Integer.valueOf(args[1]);
							stats.setSogukDirenci(statplayer.getUniqueId(), sogukdirenci);
							p.sendMessage(Painter.paint("&a+" + sogukdirenci + " Soğuk Direnci"));
						}
						case "sicakdirenci" -> {
							int sicakdirenci = Integer.valueOf(args[1]);
							stats.setSicakDirenci(statplayer.getUniqueId(), sicakdirenci);
							p.sendMessage(Painter.paint("&a+" + sicakdirenci + " Sıcak Direnci"));
						}
						case "hiclikdirenci" -> {
							int hiclikdirenci = Integer.valueOf(args[1]);
							stats.setHiclikDirenci(statplayer.getUniqueId(), hiclikdirenci);
							p.sendMessage(Painter.paint("&a+" + hiclikdirenci + " Hiçlik Direnci"));
						}
						case "canyenileme" -> {
							int canyenileme = Integer.valueOf(args[1]);
							stats.setCanYenileme(statplayer, statplayer.getUniqueId(), canyenileme);
							p.sendMessage(Painter.paint("&a+" + canyenileme + " Can Yenileme"));
						}
						case "doygunluk" -> {
							int doygunluk = Integer.valueOf(args[1]);
							stats.setDoygunluk(statplayer, statplayer.getUniqueId(), doygunluk);
							p.sendMessage(Painter.paint("&a+" + doygunluk + " Doygunluk"));
						}
						case "hiz" -> {
							int hiz = Integer.valueOf(args[1]);
							stats.setHiz(statplayer, statplayer.getUniqueId(), hiz);
							p.sendMessage(Painter.paint("&a+" + hiz + " Hız"));
						}
					}
				}
			}

		}

		return false;
	}

}
