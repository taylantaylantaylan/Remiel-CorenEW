//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package me.taylan.mooncore.animations;

import java.util.Iterator;
import java.util.Objects;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.level.Levels;
import me.taylan.mooncore.listeners.InventoryClickListener;
import me.taylan.mooncore.listeners.JoinListener;
import me.taylan.mooncore.utils.Painter;
import me.taylan.mooncore.utils.StatsManager;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class FurnaceAnim {
    public final MoonCore plugin;
    private final Levels Levels;
    private final StatsManager stats;

    public FurnaceAnim(MoonCore plugin) {
        this.plugin = plugin;
        this.Levels = plugin.getLevels();
        this.stats = plugin.getStatsManager();
    }

    public void furnaceAnimation(final Player p, final int cookTime, final ItemStack result) {
        if (((Inventory) JoinListener.getFurnacemenu().get(p.getUniqueId())).firstEmpty() != -1) {
            int timer = this.stats.getFurnaceProduction(p.getUniqueId());
            int amount = this.stats.getFurnaceAmount(p.getUniqueId());
            this.stats.setFurnaceAmount(p.getUniqueId(), cookTime);
            (new BukkitRunnable() {
                public void run() {
                    Block block = (Block) InventoryClickListener.getFurnaceBlock().get(p.getUniqueId());
                    Location loc = block.getLocation().add(0.5, 1.0, 0.5);
                    Location loc2 = block.getLocation().add(0.5, 1.2, 0.5);
                    World world = Bukkit.getWorld("world");
                    Objects.requireNonNull(world).spawn(loc2, ArmorStand.class, (armorStand2) -> {
                        armorStand2.setMarker(true);
                        armorStand2.setVisible(false);
                        armorStand2.setGravity(false);
                        armorStand2.setSmall(true);
                        armorStand2.setCustomNameVisible(true);
                        armorStand2.setCustomName(ChatColor.YELLOW + "Eritiliyor...");
                        Iterator<? extends Player> var7 = Bukkit.getOnlinePlayers().iterator();

                        while (true) {
                            Player player2;
                            do {
                                if (!var7.hasNext()) {
                                    FurnaceAnim.this.plugin.getIndicators2().put(armorStand2, 100);
                                    world.spawn(loc, ArmorStand.class, (armorStand) -> {
                                        armorStand.setMarker(true);
                                        armorStand.setVisible(false);
                                        armorStand.setGravity(false);
                                        armorStand.setSmall(true);
                                        armorStand.setCustomNameVisible(true);
                                        armorStand.setCustomName("");
                                        Iterator<? extends Player> var8 = Bukkit.getOnlinePlayers().iterator();

                                        while (true) {
                                            Player player3;
                                            do {
                                                if (!var8.hasNext()) {
                                                    FurnaceAnim.this.plugin.getIndicators2().put(armorStand, 100);
                                                    (new BukkitRunnable() {
                                                        public void run() {
                                                            int timer = FurnaceAnim.this.stats.getFurnaceProduction(p.getUniqueId());
                                                            FurnaceAnim.this.stats.setFurnaceProduction(p.getUniqueId(), 1);
                                                            int remain = cookTime - timer;
                                                            armorStand.setCustomName(ChatColor.GOLD + "Malzemenin Hazır Olmasına: " + ChatColor.WHITE + remain + " Saniye");
                                                            if (timer >= cookTime) {
                                                                armorStand.setCustomName(ChatColor.GREEN + "✔");
                                                                FurnaceAnim.this.stats.setFurnaceAmount(p.getUniqueId(), -cookTime);
                                                                result.setAmount(1);
                                                                ((Inventory) JoinListener.getFurnacemenu().get(p.getUniqueId())).addItem(new ItemStack[]{result});
                                                                p.giveExp(1);
                                                                FurnaceAnim.this.stats.setExp(p.getUniqueId(), 1);
                                                                (new BukkitRunnable() {
                                                                    public void run() {
                                                                        armorStand.remove();
                                                                    }
                                                                }).runTaskLater(FurnaceAnim.this.plugin, 20L);
                                                                world.playSound(loc, Sound.BLOCK_BLASTFURNACE_FIRE_CRACKLE, 3.0F, 0.2F);
                                                                armorStand2.remove();
                                                                FurnaceAnim.this.stats.setFurnaceProduction(p.getUniqueId(), -timer - 1);
                                                                this.cancel();
                                                            }

                                                        }
                                                    }).runTaskTimer(FurnaceAnim.this.plugin, 0L, 20L);
                                                    return;
                                                }

                                                player3 = (Player) var8.next();
                                            } while (!p.getWorld().getName().equals("dungeonworld") && !p.getWorld().getName().equals("world"));

                                            if (player3 != p) {
                                                player3.hideEntity(FurnaceAnim.this.plugin, armorStand);
                                            }
                                        }
                                    });
                                    return;
                                }

                                player2 = (Player) var7.next();
                            } while (!p.getWorld().getName().equals("dungeonworld") && !p.getWorld().getName().equals("world"));

                            if (player2 != p) {
                                player2.hideEntity(FurnaceAnim.this.plugin, armorStand2);
                            }
                        }
                    });
                }
            }).runTaskLater(this.plugin, (long) (amount * 20L));
        } else {
            p.sendMessage(Painter.paint("&c&lBir madeni eritebilmek için &6&lMaden Fırını Deponu &c&lBoşalt!"));
        }

    }
}
