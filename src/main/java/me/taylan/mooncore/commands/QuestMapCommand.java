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

public class QuestMapCommand implements CommandExecutor {

private final MoonCore plugin;
private final StatsManager stats;
    private final JoinListener joinListener;

    public QuestMapCommand(MoonCore plugin) {
        this.plugin = plugin;
        this.stats = plugin.getStatsManager();
        this.joinListener = plugin.getJoinListener();
        Objects.requireNonNull(plugin.getCommand("questget")).setExecutor(this);
    }

    @SuppressWarnings("deprecation")
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length <= 0) {
                p.sendMessage(Painter.paint("&cYanlış kullanım; /questget <oyuncuismi>"));
            } else if (args.length == 1) {
                Player player = Bukkit.getPlayer(args[0]);
                p.sendMessage(Painter.paint("&6" + Objects.requireNonNull(player).getName()+" &bAdlı Oyuncunun Quest Puanı: "+ joinListener.getQuestmap().get(player.getUniqueId())));
                p.sendMessage(Painter.paint("&6"+player.getUniqueId()));
            }


        }
        return false;
    }

}
