package me.taylan.mooncore.commands;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.eco.Ekonomi;
import me.taylan.mooncore.listeners.entitydamage.SpawnArmorStand;
import me.taylan.mooncore.utils.Painter;
import me.taylan.mooncore.utils.StatsManager;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Villager.Profession;

public class EconomyCommand implements CommandExecutor {

    private MoonCore plugin;
    private Ekonomi ekonomi;

    public EconomyCommand(MoonCore plugin) {
        this.plugin = plugin;
        this.ekonomi = plugin.getEkonomi();
        plugin.getCommand("dirhem").setExecutor(this);
    }

    @SuppressWarnings("deprecation")
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("mooncore.economy")) {
                if (args.length <= 0) {
                    double para = ekonomi.getBalance(p);
                    p.sendMessage(Painter.paint("&6Kesendeki Dirhem Sayısı: &c" +para));
                }
                if (args[0].equalsIgnoreCase("ver")) {
                    if (args.length == 3) {
                        try {
                            Player player = Bukkit.getPlayer(args[1]);
                            double depositAmount = Integer.parseInt(args[2]);
                            ekonomi.depositPlayer(player, depositAmount);
                            player.sendMessage(Painter.paint(player.getName() + " &6Adlı kişiye &c" + depositAmount + " &6Dinar verdin."));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else if (args[0].equalsIgnoreCase("al")) {
                    try {
                        Player player = Bukkit.getPlayer(args[1]);
                        double depositAmount = Integer.parseInt(args[2]);
                        ekonomi.depositPlayer(player, -depositAmount);
                        player.sendMessage(Painter.paint(player.getName() + " &6Adlı kişiden &c" + depositAmount + " &6Dinar aldın."));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return false;
    }

}
