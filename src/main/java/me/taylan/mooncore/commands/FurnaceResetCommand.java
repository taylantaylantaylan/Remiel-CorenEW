package me.taylan.mooncore.commands;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.listeners.JoinListener;
import me.taylan.mooncore.utils.Painter;
import me.taylan.mooncore.utils.StatsManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FurnaceResetCommand implements CommandExecutor {

    private MoonCore plugin;
    private StatsManager stats;
    private JoinListener joinListener;

    public FurnaceResetCommand(MoonCore plugin) {
        this.plugin = plugin;
        this.stats = plugin.getStatsManager();
        this.joinListener = plugin.getJoinListener();
        plugin.getCommand("furnacereset").setExecutor(this);
    }

    @SuppressWarnings("deprecation")
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            if(sender.hasPermission("mooncore.furnacereset")) {
                Player p = (Player) sender;
                if (args.length <= 0) {
                    p.sendMessage(Painter.paint("&cYanlış kullanım; /furnacereset <oyuncuismi>"));
                } else if (args.length == 1) {
                    Player player = Bukkit.getPlayer(args[0]);
                    stats.setFurnaceAmount(p.getUniqueId(),0);
                    stats.setRealFurnaceAmount(p.getUniqueId(),0);
                    stats.setCookAmount(p.getUniqueId(),0);
                }
            }

        }
        return false;
    }

}
