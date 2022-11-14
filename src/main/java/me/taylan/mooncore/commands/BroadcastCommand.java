package me.taylan.mooncore.commands;

import me.taylan.mooncore.MoonCore;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class BroadcastCommand implements CommandExecutor {

    private final MoonCore plugin;

    public BroadcastCommand(MoonCore plugin) {
        this.plugin = plugin;
        Objects.requireNonNull(plugin.getCommand("bc")).setExecutor(this);
    }

    @SuppressWarnings("deprecation")
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {

        } else {
            if(args.length==2) {
                Player player = Bukkit.getPlayer(args[0]);
                int bint = Integer.parseInt(args[1]);
                switch (bint) {
                    case 1 -> {
                        Bukkit.getServer().broadcast(MiniMessage.miniMessage().deserialize("<dark_gray>[<aqua>MoonNetwork<dark_gray>] <gold>" + player.getName() + " <gray>isimli oyuncu <yellow><bold>Premium+ <bold:false><gray>satın alarak sunucumuza destek çıktı!"));
                        for (Player soundpl : Bukkit.getOnlinePlayers()) {
                            soundpl.playSound(soundpl, Sound.UI_TOAST_CHALLENGE_COMPLETE, 5F, 0.1F);
                        }
                    }
                    case 2 -> {
                        Bukkit.getServer().broadcast(MiniMessage.miniMessage().deserialize("<dark_gray>[<aqua>MoonNetwork<dark_gray>] <gold>" + player.getName() + " <gray>isimli oyuncu <yellow><bold>Premium <bold:false><gray>satın alarak sunucumuza destek çıktı!"));
                        for (Player soundpl : Bukkit.getOnlinePlayers()) {
                            soundpl.playSound(soundpl, Sound.UI_TOAST_CHALLENGE_COMPLETE, 5F, 0.1F);
                        }
                    }
                    case 3 -> {
                        Bukkit.getServer().broadcast(MiniMessage.miniMessage().deserialize("<dark_gray>[<aqua>MoonNetwork<dark_gray>] <gold>" + player.getName() + " <gray>isimli oyuncu <gold><bold>Süper Destekçi <bold:false><gray>olarak sunucumuza destek çıktı!"));
                        for (Player soundpl : Bukkit.getOnlinePlayers()) {
                            soundpl.playSound(soundpl, Sound.UI_TOAST_CHALLENGE_COMPLETE, 5F, 0.1F);
                        }
                    }
                }
            }
        }
        return false;
    }

}
