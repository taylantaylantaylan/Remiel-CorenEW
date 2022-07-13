package me.taylan.mooncore.commands;

import me.taylan.mooncore.MoonCore;
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

public class SkillGetCommand implements CommandExecutor {

    private MoonCore plugin;
    private StatsManager stats;

    public SkillGetCommand(MoonCore plugin) {
        this.plugin = plugin;
        this.stats = plugin.getStatsManager();
        plugin.getCommand("skillget").setExecutor(this);
    }

    @SuppressWarnings("deprecation")
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length <= 0) {
                p.sendMessage(Painter.paint("&cYanlış kullanım; /skillget <oyuncuismi>"));
            } else if (args.length == 1) {
                Player player = Bukkit.getPlayer(args[0]);
                p.sendMessage(Painter.paint("&6" + player.getName()+" &bAdlı Oyuncunun Ustalıkları;"));
                p.sendMessage(Painter.paint("&bDemircilik: &e" + stats.getSmithLevel(player.getUniqueId())));
                p.sendMessage(Painter.paint("&bAşçılık: &e" + stats.getCookLevel(player.getUniqueId())));
                p.sendMessage(Painter.paint("&bOdunculuk: &e" + stats.getOdunculukLevel(player.getUniqueId())));
                p.sendMessage(Painter.paint("&bMadencilik: &e" + stats.getMadencilikLevel(player.getUniqueId())));
                p.sendMessage(Painter.paint("&bBalıkçılık: &e" + stats.getFishingLevel(player.getUniqueId())));
                p.sendMessage(Painter.paint("&bSimyacılık: &e" + stats.getAlchemyLevel(player.getUniqueId())));
                p.sendMessage(Painter.paint("&bAvcılık: &e" + stats.getCombatLevel(player.getUniqueId())));
                p.sendMessage(Painter.paint("&bEl Sanatları: &e" + stats.getWorkLevel(player.getUniqueId())));
                p.sendMessage(Painter.paint("&bBuyuculuk: &e" + stats.getWorkLevel(player.getUniqueId())));
                p.sendMessage(Painter.paint("&bÇiftcilik: &e" + stats.getFarmingLevel(player.getUniqueId())));
                p.sendMessage(Painter.paint("------------------------------------------"));
                p.sendMessage(Painter.paint("&bFurnaceAmount: &e" + stats.getFurnaceAmount(player.getUniqueId())));
                p.sendMessage(Painter.paint("&bRealFurnaceAmount: &e" + stats.getRealFurnaceAmount(player.getUniqueId())));
                p.sendMessage(Painter.paint("&bFurnaceProdu: &e" + stats.getFurnaceProduction(player.getUniqueId())));
                p.sendMessage(Painter.paint("&bRealFurnaceProdu: &e" + stats.getRealFurnaceProduction(player.getUniqueId())));

            }


        }
        return false;
    }

}
