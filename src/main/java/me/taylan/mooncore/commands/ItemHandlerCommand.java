//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package me.taylan.mooncore.commands;

import java.util.*;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.ItemHandler;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;

public class ItemHandlerCommand implements CommandExecutor, TabCompleter {
 private final MoonCore plugin;
    private final ItemHandler itemHandler;

    public ItemHandlerCommand(MoonCore plugin) {
        this.plugin = plugin;
        this.itemHandler = plugin.getItemHandler();
        Objects.requireNonNull(plugin.getCommand("adminitem")).setExecutor(this);
        Objects.requireNonNull(plugin.getCommand("adminitem")).setTabCompleter(this);
    }

    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        String item;
        ItemStack giveitem;
        if (sender instanceof Player p) {
            if (args.length <= 0) {
                item = String.join(", ", this.itemHandler.getItemStackMap().keySet());
                p.sendMessage(item);
            } else if (args.length == 2) {
                item = args[0];
                if (this.itemHandler.getItemStackMap().containsKey(item.toLowerCase())) {
                    giveitem = (ItemStack)this.itemHandler.getItemStackMap().get(item.toLowerCase());
                    giveitem.setAmount(Integer.parseInt(args[1]));
                    p.getInventory().addItem(new ItemStack[]{giveitem});
                }
            }
        } else if (args.length == 3) {
            Player p = Bukkit.getPlayer(args[0]);
            item = args[1];
            if (this.itemHandler.getItemStackMap().containsKey(item.toLowerCase())) {
                giveitem = (ItemStack)this.itemHandler.getItemStackMap().get(item.toLowerCase());
                giveitem.setAmount(Integer.parseInt(args[2]));
                Objects.requireNonNull(p).getInventory().addItem(new ItemStack[]{giveitem});
            }
        } else {
            Bukkit.getServer().sendMessage(MiniMessage.miniMessage().deserialize("<red><i:false> Yanlış Kullanım Hacı."));
        }

        return false;
    }

    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        String[] COMMANDS = (String[])this.itemHandler.getItemStackMap().keySet().toArray(new String[0]);
        List<String> commandlist = new ArrayList<>();
        String[] var7 = COMMANDS;
        int var8 = COMMANDS.length;

        commandlist.addAll(Arrays.asList(var7).subList(0, var8));

        List<String> completions = new ArrayList<>();
        StringUtil.copyPartialMatches(args[0], commandlist, completions);
        Collections.sort(completions);
        return completions;
    }
}
