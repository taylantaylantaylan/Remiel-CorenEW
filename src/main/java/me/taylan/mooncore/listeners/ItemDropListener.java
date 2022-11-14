package me.taylan.mooncore.listeners;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.Painter;
import me.taylan.mooncore.utils.StatsManager;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ItemDropListener implements Listener {

    private final MoonCore plugin;
    private final StatsManager stats;

    public ItemDropListener(MoonCore plugin) {
        this.plugin = plugin;
        this.stats = plugin.getStatsManager();
        Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
    }

    public static final List<String> dogrulamaBypass = new ArrayList<>();

    final HashMap<String, ItemStack> confirmCheck = new HashMap<String, ItemStack>();

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void itemDrop(PlayerDropItemEvent e) {
        NamespacedKey canta = new NamespacedKey(plugin, "backpack");
        Player player = e.getPlayer();
        if (dogrulamaBypass.contains(player.getName()))
            return;
        else {

            e.setCancelled(true);
            ItemStack checkMaterial = confirmCheck.get(player.getName());
            ItemStack eldeki = player.getInventory().getItemInMainHand();

            if (!confirmCheck.containsKey(player.getName())
                    && checkMaterial != player.getInventory().getItemInMainHand()) {
                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> confirmCheck.put(player.getName(), player.getInventory().getItemInMainHand()), 1);
                player.sendMessage(Painter.paint("&7Eşyayı atmayı onaylamak için tekrar at!"));
            } else if (checkMaterial.getType() != eldeki.getType()
                    && checkMaterial.getItemMeta() != eldeki.getItemMeta()
                    && checkMaterial.getAmount() != eldeki.getAmount()) {

                confirmCheck.remove(player.getName());
                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                    confirmCheck.put(player.getName(), player.getInventory().getItemInMainHand());
                    player.sendMessage(Painter.paint("&7Eşyayı atmayı onaylamak için tekrar at!"));
                }, 1);
            } else {
                confirmCheck.remove(player.getName());
                e.setCancelled(false);

            }

        }
    }
}
