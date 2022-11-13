package me.taylan.mooncore.commands;

import io.lumine.mythic.bukkit.adapters.BukkitPlayer;
import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.ItemHandler;
import me.taylan.mooncore.utils.Painter;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ItemHandlerCommand implements CommandExecutor, TabCompleter {

    private MoonCore plugin;
    private ItemHandler itemHandler;

    public ItemHandlerCommand(MoonCore plugin) {
        this.plugin = plugin;
        this.itemHandler = plugin.getItemHandler();
        plugin.getCommand("adminitem").setExecutor(this);
        plugin.getCommand("adminitem").setTabCompleter(this);
    }

    @SuppressWarnings("deprecation")
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length <= 0) {

                String name = String.join(", ", itemHandler.getItemStackMap().keySet());
                p.sendMessage(name);
            } else if (args.length == 2) {
                String item = args[0];
                if (itemHandler.getItemStackMap().containsKey(item.toLowerCase())) {
                    ItemStack giveitem = itemHandler.getItemStackMap().get(item.toLowerCase());
                    giveitem.setAmount(Integer.parseInt(args[1]));
                    p.getInventory().addItem(giveitem);

                }

            }


        } else {
            if (args.length == 3) {
                Player itemplayer = Bukkit.getPlayer(args[0]);
                String item = args[1];
                if (itemHandler.getItemStackMap().containsKey(item.toLowerCase())) {
                    ItemStack giveitem = itemHandler.getItemStackMap().get(item.toLowerCase());
                    giveitem.setAmount(Integer.parseInt(args[2]));
                    itemplayer.getInventory().addItem(giveitem);

                }
            } else {
                Bukkit.getServer().sendMessage(MiniMessage.miniMessage().deserialize("<red><i:false> Yanlış Kullanım Hacı."));
            }
        }
        return false;
    }
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        final String[] COMMANDS = itemHandler.getItemStackMap().keySet().toArray(new String[0]);
        List<String> commandlist = new ArrayList<>();
        for(String string: COMMANDS) {
            commandlist.add(string);
        }
        final List<String> completions = new ArrayList<>();

        StringUtil.copyPartialMatches(args[0], commandlist, completions);

        Collections.sort(completions);
        return completions;
    }
}
