package me.taylan.mooncore.commands;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.Painter;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class BroadcastCommand implements CommandExecutor {

    private MoonCore plugin;

    public BroadcastCommand(MoonCore plugin) {
        this.plugin = plugin;
        plugin.getCommand("bc").setExecutor(this);
    }

    @SuppressWarnings("deprecation")
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {

        } else {
            if(args.length==2) {
                Player player = Bukkit.getPlayer(args[0]);
                int bint = Integer.parseInt(args[1]);
                switch (bint){
                    case 1:
                        Bukkit.getServer().broadcast(MiniMessage.miniMessage().deserialize("<dark_gray>[<aqua>MoonNetwork<dark_gray>] <gold>"+player.getName()+" <gray>isimli oyuncu <yellow><bold>Premium+ <bold:false><gray>satın alarak sunucumuza destek çıktı!"));
                        for(Player soundpl: Bukkit.getOnlinePlayers()) {
                            soundpl.playSound(soundpl, Sound.UI_TOAST_CHALLENGE_COMPLETE,5F,0.1F);
                        }
                        break;
                    case 2:
                        Bukkit.getServer().broadcast(MiniMessage.miniMessage().deserialize("<dark_gray>[<aqua>MoonNetwork<dark_gray>] <gold>"+player.getName()+" <gray>isimli oyuncu <yellow><bold>Premium <bold:false><gray>satın alarak sunucumuza destek çıktı!"));
                        for(Player soundpl: Bukkit.getOnlinePlayers()) {
                            soundpl.playSound(soundpl, Sound.UI_TOAST_CHALLENGE_COMPLETE,5F,0.1F);
                        }
                        break;
                    case 3:
                        Bukkit.getServer().broadcast(MiniMessage.miniMessage().deserialize("<dark_gray>[<aqua>MoonNetwork<dark_gray>] <gold>"+player.getName()+" <gray>isimli oyuncu <gold><bold>Süper Destekçi <bold:false><gray>olarak sunucumuza destek çıktı!"));
                        for(Player soundpl: Bukkit.getOnlinePlayers()) {
                            soundpl.playSound(soundpl, Sound.UI_TOAST_CHALLENGE_COMPLETE,5F,0.1F);
                        }
                        break;
                }
            }
        }
        return false;
    }

}
