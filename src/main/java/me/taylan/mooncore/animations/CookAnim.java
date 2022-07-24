package me.taylan.mooncore.animations;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.level.Levels;
import me.taylan.mooncore.listeners.InventoryClickListener;
import me.taylan.mooncore.listeners.JoinListener;
import me.taylan.mooncore.utils.Painter;
import me.taylan.mooncore.utils.StatsManager;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Smoker;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Lightable;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class CookAnim {
    public MoonCore plugin;
    private Levels Levels;


    private StatsManager stats;

    public CookAnim(MoonCore plugin) {
        this.plugin = plugin;
        this.Levels = plugin.getLevels();
        this.stats = plugin.getStatsManager();
    }

    public void cookAnimation(Player p, int cookTime, ItemStack result, int exp) {
        if (JoinListener.getFurnacemenu().get(p.getUniqueId()).firstEmpty() != -1) {
            int timer = stats.getCookProduction(p.getUniqueId());
            int amount = stats.getCookAmount(p.getUniqueId());
            stats.setCookAmount(p.getUniqueId(), cookTime);
            new BukkitRunnable() {
                @Override
                public void run() {
                    Block block = InventoryClickListener.getCookBlock().get(p.getUniqueId());
                    Location loc = block.getLocation().add(0.5, 1, 0.5);
                    Location loc2 = block.getLocation().add(0.5, 1.2, 0.5);
                    World world = Bukkit.getWorld("world");
                    BlockState state = block.getState();

                    BlockData data = block.getState().getBlockData();
                    Lightable lit = (Lightable) data;
                    new BukkitRunnable() {

                        @Override
                        public void run() {
                            Material type = block.getType();
                            BlockState state = block.getState();
                            Smoker smok = (Smoker) state;
                            BlockData data = block.getState().getBlockData();
                            Lightable lit = (Lightable) data;
                            lit.setLit(true);
                            state.setBlockData((BlockData) data);
                            state.update();

                        }

                    }.runTaskLater(plugin, 1L);
                    world.spawn(loc2, ArmorStand.class, armorStand2 -> {
                        armorStand2.setMarker(true);
                        armorStand2.setVisible(false);
                        armorStand2.setGravity(false);
                        armorStand2.setSmall(true);
                        armorStand2.setCustomNameVisible(true);
                        armorStand2.setCustomName(ChatColor.YELLOW + "Pişiriliyor...");
                        for (Player player2 : Bukkit.getOnlinePlayers()) {
                            if (p.getWorld().getName().equals("dungeonworld") || p.getWorld().getName().equals("world")) {
                                if (player2 == p) continue;
                                player2.hideEntity(plugin, armorStand2);
                            }
                        }
                        plugin.getIndicators2().put(armorStand2, 100);
                        world.spawn(loc, ArmorStand.class, armorStand -> {
                            armorStand.setMarker(true);
                            armorStand.setVisible(false);
                            armorStand.setGravity(false);
                            armorStand.setSmall(true);
                            armorStand.setCustomNameVisible(true);
                            armorStand.setCustomName("");
                            for (Player player2 : Bukkit.getOnlinePlayers()) {
                                if (p.getWorld().getName().equals("dungeonworld") || p.getWorld().getName().equals("world")) {
                                    if (player2 == p) continue;
                                    player2.hideEntity(plugin, armorStand);
                                }
                            }
                            plugin.getIndicators2().put(armorStand, 100);
                            new BukkitRunnable() {

                                @Override
                                public void run() {
                                    int timer = stats.getCookProduction(p.getUniqueId());
                                    stats.setCookProduction(p.getUniqueId(), 1);
                                    int remain = cookTime - timer;
                                    armorStand.setCustomName(
                                            ChatColor.GOLD + "Yemeğin Hazır Olmasına: " + ChatColor.WHITE + remain + " Saniye");
                                    if (timer >= cookTime) {
                                        Levels.giveCookLevel(p, result);

                                        armorStand.setCustomName(ChatColor.GREEN + "✔");
                                        lit.setLit(false);
                                        state.setBlockData((BlockData) data);
                                        state.update();
                                        stats.setCookAmount(p.getUniqueId(), -cookTime);
                                        JoinListener.getOcakMenu().get(p.getUniqueId()).addItem(result);
                                        new BukkitRunnable() {

                                            @Override
                                            public void run() {
                                                armorStand.remove();

                                            }
                                        }.runTaskLater(plugin, 20L);
                                        world.playSound(loc, Sound.BLOCK_SMOKER_SMOKE, 3f, 0.2f);
                                        armorStand2.remove();
                                        p.giveExp(1);
                                        stats.setExp(p.getUniqueId(), 1);
                                        stats.setCookProduction(p.getUniqueId(), -timer - 1);
                                        cancel();
                                    }

                                }
                            }.runTaskTimer(plugin, 0L, 20L);
                        });
                    });

                }
            }.runTaskLater(plugin, amount * 20);

        } else {
            p.sendMessage(Painter.paint("&c&lBir yemeği pişirebilmek için için &6&lOcak Deponu &c&lBoşalt!"));
        }
    }


}
