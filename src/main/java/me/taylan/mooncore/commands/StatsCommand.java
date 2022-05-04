package me.taylan.mooncore.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.Painter;
import me.taylan.mooncore.utils.StatsManager;

public class StatsCommand implements CommandExecutor {
	private MoonCore plugin;
	private StatsManager stats;

	public StatsCommand(MoonCore plugin) {
		this.plugin = plugin;
		this.stats = plugin.getStatsManager();
		plugin.getCommand("statekle").setExecutor(this);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player)) {
			return true;
		}

		Player p = (Player) sender;

		if (p.hasPermission("mooncore.stat")) {

			if (args.length <= 0) {
				p.sendMessage(Painter.paint("&cYanlış Kullanım!"));
			} else if (args.length > 0) {
				switch (args[0].toString()) {
				case "guc":
					int guc = Integer.valueOf(args[1]);
					stats.setGuc(p.getUniqueId(), guc);
					p.sendMessage(Painter.paint("&a+" + guc + " Güç"));
					break;
				case "can":
					int can = Integer.valueOf(args[1]);
					stats.setCan(p, p.getUniqueId(), can);
					p.sendMessage(Painter.paint("&a+" + can + " Can"));
					break;
				case "zirh":
					int zirh = Integer.valueOf(args[1]);
					stats.setZirh(p, p.getUniqueId(), zirh);
					p.sendMessage(Painter.paint("&a+" + zirh + " Zırh"));
					break;
				case "saldirihizi":
					int saldirihizi = Integer.valueOf(args[1]);
					stats.setSaldiriHizi(p.getUniqueId(), saldirihizi);
					p.sendMessage(Painter.paint("&a+" + saldirihizi + " Saldırı Hızı"));
					break;
				case "kritikhasari":
					int kritikhasari = Integer.valueOf(args[1]);
					stats.setKritikHasari(p.getUniqueId(), kritikhasari);
					p.sendMessage(Painter.paint("&a+" + kritikhasari + " Kritik Hasarı"));
					break;
				case "kritiksansi":
					int kritiksansi = Integer.valueOf(args[1]);
					stats.setKritikSansi(p.getUniqueId(), kritiksansi);
					p.sendMessage(Painter.paint("&a+" + kritiksansi + " Kritik Şansı"));
					break;
				case "sogukdirenci":
					int sogukdirenci = Integer.valueOf(args[1]);
					stats.setSogukDirenci(p.getUniqueId(), sogukdirenci);
					p.sendMessage(Painter.paint("&a+" + sogukdirenci + " Soğuk Direnci"));
					break;
				case "sicakdirenci":
					int sicakdirenci = Integer.valueOf(args[1]);
					stats.setSicakDirenci(p.getUniqueId(), sicakdirenci);
					p.sendMessage(Painter.paint("&a+" + sicakdirenci + " Sıcak Direnci"));
					break;
				case "hiclikdirenci":
					int hiclikdirenci = Integer.valueOf(args[1]);
					stats.setHiclikDirenci(p.getUniqueId(), hiclikdirenci);
					p.sendMessage(Painter.paint("&a+" + hiclikdirenci + " Hiçlik Direnci"));
					break;

				case "canyenileme":
					int canyenileme = Integer.valueOf(args[1]);
					stats.setCanYenileme(p, p.getUniqueId(), canyenileme);
					p.sendMessage(Painter.paint("&a+" + canyenileme + " Can Yenileme"));

					break;

				case "doygunluk":
					int doygunluk = Integer.valueOf(args[1]);
					stats.setDoygunluk(p, p.getUniqueId(), doygunluk);
					p.sendMessage(Painter.paint("&a+" + doygunluk + " Doygunluk"));

					break;
				case "hiz":
					int hiz = Integer.valueOf(args[1]);
					stats.setHiz(p, p.getUniqueId(), hiz);

					p.sendMessage(Painter.paint("&a+" + hiz + " Hız"));
					break;
				}

			}

		}

		return false;
	}

}
