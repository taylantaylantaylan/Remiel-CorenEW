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
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class FurnaceResetCommand implements CommandExecutor {

private final MoonCore plugin;
    private final StatsManager stats;
private final JoinListener joinListener;

    public FurnaceResetCommand(MoonCore plugin) {
        this.plugin = plugin;
        this.stats = plugin.getStatsManager();
        this.joinListener = plugin.getJoinListener();
        Objects.requireNonNull(plugin.getCommand("furnacereset")).setExecutor(this);
    }

    @SuppressWarnings("deprecation")
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
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
