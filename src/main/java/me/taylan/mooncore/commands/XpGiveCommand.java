package me.taylan.mooncore.commands;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.listeners.JoinListener;
import me.taylan.mooncore.utils.ItemHandler;
import me.taylan.mooncore.utils.Painter;
import me.taylan.mooncore.utils.StatsManager;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class XpGiveCommand implements CommandExecutor {

    private MoonCore plugin;
    private StatsManager stats;
    private JoinListener joinListener;

    public XpGiveCommand(MoonCore plugin) {
        this.plugin = plugin;
        this.stats = plugin.getStatsManager();
        this.joinListener = plugin.getJoinListener();
        plugin.getCommand("xpadd").setExecutor(this);
    }

    @SuppressWarnings("deprecation")
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length <= 0) {
                p.sendMessage("Yanlış kullanım. /xpadd <oyuncuismi> <xpismi> <xpsayisi>");
            } else if (args.length == 2) {
                String xpname = args[0];
                switch (xpname.toString()) {
                    case "demircilik":
                        int guc = Integer.valueOf(args[1]);
                        stats.setSmithExp(p.getUniqueId(), guc);
                        p.sendMessage(Painter.paint("&a+" + guc + " Demircilik Exp"));
                        break;
                    case "ciftcilik":
                        int can = Integer.valueOf(args[1]);
                        stats.setFarmingExp(p.getUniqueId(), can);
                        p.sendMessage(Painter.paint("&a+" + can + " Ciftcilik EXP"));
                        break;
                    case "avcilik":
                        int direnc = Integer.valueOf(args[1]);
                        stats.setCombatExp(p.getUniqueId(), direnc);
                        p.sendMessage(Painter.paint("&a+" + direnc + " Avcılık EXP"));
                        break;
                    case "madencilik":
                        int saldirihizi = Integer.valueOf(args[1]);
                        stats.setMadencilikExp(p.getUniqueId(), saldirihizi);
                        p.sendMessage(Painter.paint("&a+" + saldirihizi + " Madencilik EXP"));
                        break;
                    case "odunculuk":
                        int kritikhasari = Integer.valueOf(args[1]);
                        stats.setOdunculukExp(p.getUniqueId(), kritikhasari);
                        p.sendMessage(Painter.paint("&a+" + kritikhasari + " Odunculuk EXP"));
                        break;
                    case "balikcilik":
                        int kritiksansi = Integer.valueOf(args[1]);
                        stats.setFishingExp(p.getUniqueId(), kritiksansi);
                        p.sendMessage(Painter.paint("&a+" + kritiksansi + " Balıkçılık EXP"));
                        break;
                    case "ascilik":
                        int sogukdirenci = Integer.valueOf(args[1]);
                        stats.setCookExp(p.getUniqueId(), sogukdirenci);
                        p.sendMessage(Painter.paint("&a+" + sogukdirenci + " Aşçılık EXP"));
                        break;
                    case "simyacilik":
                        int sicakdirenci = Integer.valueOf(args[1]);
                        stats.setAlchemyExp(p.getUniqueId(), sicakdirenci);
                        p.sendMessage(Painter.paint("&a+" + sicakdirenci + " Simyacılık EXP"));
                        break;
                    case "buyuculuk":
                        int hiclikdirenci = Integer.valueOf(args[1]);
                        stats.setEnchExp(p.getUniqueId(), hiclikdirenci);
                        p.sendMessage(Painter.paint("&a+" + hiclikdirenci + " Buyuculuk EXP"));
                        break;

                    case "elsanatlari":
                        int canyenileme = Integer.valueOf(args[1]);
                        stats.setWorkExp(p.getUniqueId(), canyenileme);
                        p.sendMessage(Painter.paint("&a+" + canyenileme + " El Sanatları EXP"));

                        break;
                    case "NP":
                        int np = Integer.valueOf(args[1]);
                        stats.setNP(p.getUniqueId(), np);
                        p.sendMessage(Painter.paint("&a+" + np + " Nitelik Puanı"));

                        break;
                    case "exp":
                        int doygunluk = Integer.valueOf(args[1]);
                        stats.setExp(p.getUniqueId(), doygunluk);
                        p.sendMessage(Painter.paint("&a+" + doygunluk + " EXP"));

                        break;
                    case "level":
                        int level = Integer.valueOf(args[2]);
                        stats.setLevel(p.getUniqueId(), level);
                        p.sendMessage(Painter.paint("&a+" + level + " level"));

                        break;
                    case "QP":
                        int qp = Integer.valueOf(args[2]);
                        joinListener.getQuestmap().put(p.getUniqueId(),joinListener.getQuestmap().get(p.getUniqueId())+qp);
                        p.sendMessage(Painter.paint("&a+" + qp + " Quest Puanı"));

                        break;
                }


            } else if(args.length == 3) {
                Player play = Bukkit.getPlayer(args[0]);
                String xpname = args[1];
                switch (xpname.toString()) {
                    case "demircilik":
                        int guc = Integer.valueOf(args[2]);
                        stats.setSmithExp(play.getUniqueId(), guc);
                        p.sendMessage(Painter.paint("&a+" + guc + " Demircilik Exp"));
                        break;
                    case "ciftcilik":
                        int can = Integer.valueOf(args[2]);
                        stats.setFarmingExp(play.getUniqueId(), can);
                        p.sendMessage(Painter.paint("&a+" + can + " Ciftcilik EXP"));
                        break;
                    case "avcilik":
                        int direnc = Integer.valueOf(args[2]);
                        stats.setCombatExp(play.getUniqueId(), direnc);
                        p.sendMessage(Painter.paint("&a+" + direnc + " Avcılık EXP"));
                        break;
                    case "madencilik":
                        int saldirihizi = Integer.valueOf(args[2]);
                        stats.setMadencilikExp(play.getUniqueId(), saldirihizi);
                        p.sendMessage(Painter.paint("&a+" + saldirihizi + " Madencilik EXP"));
                        break;
                    case "odunculuk":
                        int kritikhasari = Integer.valueOf(args[2]);
                        stats.setOdunculukExp(play.getUniqueId(), kritikhasari);
                        p.sendMessage(Painter.paint("&a+" + kritikhasari + " Odunculuk EXP"));
                        break;
                    case "balikcilik":
                        int kritiksansi = Integer.valueOf(args[2]);
                        stats.setFishingExp(play.getUniqueId(), kritiksansi);
                        p.sendMessage(Painter.paint("&a+" + kritiksansi + " Balıkçılık EXP"));
                        break;
                    case "ascilik":
                        int sogukdirenci = Integer.valueOf(args[2]);
                        stats.setCookExp(play.getUniqueId(), sogukdirenci);
                        p.sendMessage(Painter.paint("&a+" + sogukdirenci + " Aşçılık EXP"));
                        break;
                    case "simyacilik":
                        int sicakdirenci = Integer.valueOf(args[2]);
                        stats.setAlchemyExp(play.getUniqueId(), sicakdirenci);
                        p.sendMessage(Painter.paint("&a+" + sicakdirenci + " Simyacılık EXP"));
                        break;
                    case "buyuculuk":
                        int hiclikdirenci = Integer.valueOf(args[2]);
                        stats.setEnchExp(play.getUniqueId(), hiclikdirenci);
                        p.sendMessage(Painter.paint("&a+" + hiclikdirenci + " Buyuculuk EXP"));
                        break;

                    case "elsanatlari":
                        int canyenileme = Integer.valueOf(args[2]);
                        stats.setWorkExp(play.getUniqueId(), canyenileme);
                        p.sendMessage(Painter.paint("&a+" + canyenileme + " El Sanatları EXP"));

                        break;
                    case "NP":
                        int np = Integer.valueOf(args[2]);
                        stats.setNP(play.getUniqueId(), np);
                        p.sendMessage(Painter.paint("&a+" + np + " Nitelik Puanı"));

                        break;
                    case "exp":
                        int doygunluk = Integer.valueOf(args[2]);
                        stats.setExp(play.getUniqueId(), doygunluk);
                        p.sendMessage(Painter.paint("&a+" + doygunluk + " EXP"));

                        break;
                    case "level":
                        int level = Integer.valueOf(args[2]);
                        stats.setLevel(play.getUniqueId(), level);
                        p.sendMessage(Painter.paint("&a+" + level + " level"));

                        break;
                    case "QP":
                        int qp = Integer.valueOf(args[2]);
                        joinListener.getQuestmap().put(p.getUniqueId(),joinListener.getQuestmap().get(p.getUniqueId())+qp);
                        p.sendMessage(Painter.paint("&a+" + qp + " Quest Puanı"));

                        break;
                }

            } else {
                Bukkit.getServer().sendMessage(MiniMessage.miniMessage().deserialize("<red><i:false> Yanlış Kullanım Hacı."));

            }


        } else {
            if (args.length == 3) {
                Player p = Bukkit.getPlayer(args[0]);
                String xpname = args[1];
                switch (xpname.toString()) {
                    case "demircilik":
                        int guc = Integer.valueOf(args[2]);
                        stats.setSmithExp(p.getUniqueId(), guc);
                        p.sendMessage(Painter.paint("&a+" + guc + " Demircilik Exp"));
                        break;
                    case "ciftcilik":
                        int can = Integer.valueOf(args[2]);
                        stats.setFarmingExp(p.getUniqueId(), can);
                        p.sendMessage(Painter.paint("&a+" + can + " Ciftcilik EXP"));
                        break;
                    case "avcilik":
                        int direnc = Integer.valueOf(args[2]);
                        stats.setCombatExp(p.getUniqueId(), direnc);
                        p.sendMessage(Painter.paint("&a+" + direnc + " Avcılık EXP"));
                        break;
                    case "madencilik":
                        int saldirihizi = Integer.valueOf(args[2]);
                        stats.setMadencilikExp(p.getUniqueId(), saldirihizi);
                        p.sendMessage(Painter.paint("&a+" + saldirihizi + " Madencilik EXP"));
                        break;
                    case "odunculuk":
                        int kritikhasari = Integer.valueOf(args[2]);
                        stats.setOdunculukExp(p.getUniqueId(), kritikhasari);
                        p.sendMessage(Painter.paint("&a+" + kritikhasari + " Odunculuk EXP"));
                        break;
                    case "balikcilik":
                        int kritiksansi = Integer.valueOf(args[2]);
                        stats.setFishingExp(p.getUniqueId(), kritiksansi);
                        p.sendMessage(Painter.paint("&a+" + kritiksansi + " Balıkçılık EXP"));
                        break;
                    case "ascilik":
                        int sogukdirenci = Integer.valueOf(args[2]);
                        stats.setCookExp(p.getUniqueId(), sogukdirenci);
                        p.sendMessage(Painter.paint("&a+" + sogukdirenci + " Aşçılık EXP"));
                        break;
                    case "simyacilik":
                        int sicakdirenci = Integer.valueOf(args[2]);
                        stats.setAlchemyExp(p.getUniqueId(), sicakdirenci);
                        p.sendMessage(Painter.paint("&a+" + sicakdirenci + " Simyacılık EXP"));
                        break;
                    case "buyuculuk":
                        int hiclikdirenci = Integer.valueOf(args[2]);
                        stats.setEnchExp(p.getUniqueId(), hiclikdirenci);
                        p.sendMessage(Painter.paint("&a+" + hiclikdirenci + " Buyuculuk EXP"));
                        break;

                    case "elsanatlari":
                        int canyenileme = Integer.valueOf(args[2]);
                        stats.setWorkExp(p.getUniqueId(), canyenileme);
                        p.sendMessage(Painter.paint("&a+" + canyenileme + " El Sanatları EXP"));

                        break;
                    case "NP":
                        int np = Integer.valueOf(args[2]);
                        stats.setNP(p.getUniqueId(), np);
                        p.sendMessage(Painter.paint("&a+" + np + " Nitelik Puanı"));

                        break;
                    case "exp":
                        int doygunluk = Integer.valueOf(args[2]);
                        stats.setExp(p.getUniqueId(), doygunluk);
                        p.sendMessage(Painter.paint("&a+" + doygunluk + " EXP"));

                        break;
                    case "level":
                        int level = Integer.valueOf(args[2]);
                        stats.setLevel(p.getUniqueId(), level);
                        p.sendMessage(Painter.paint("&a+" + level + " level"));

                        break;
                    case "QP":
                        int qp = Integer.valueOf(args[2]);
                        joinListener.getQuestmap().put(p.getUniqueId(),joinListener.getQuestmap().get(p.getUniqueId())+qp);
                        p.sendMessage(Painter.paint("&a+" + qp + " Quest Puanı"));

                        break;
                }

            } else {
                Bukkit.getServer().sendMessage(MiniMessage.miniMessage().deserialize("<red><i:false> Yanlış Kullanım Hacı."));
            }
        }
        return false;
    }

}
