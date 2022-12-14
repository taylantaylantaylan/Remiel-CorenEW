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

public class RealFurnaceAnim {
    public final MoonCore plugin;
    private final Levels Levels;
    private final StatsManager stats;

    public RealFurnaceAnim(MoonCore plugin) {
        this.plugin = plugin;
        this.Levels = plugin.getLevels();
        this.stats = plugin.getStatsManager();
    }

    public void furnaceAgaAnimation(final Player p, final int cookTime, final ItemStack result) {
        if (((Inventory) JoinListener.getRealfurnacemenu().get(p.getUniqueId())).firstEmpty() != -1) {
            int amount = this.stats.getRealFurnaceAmount(p.getUniqueId());
            this.stats.setRealFurnaceAmount(p.getUniqueId(), cookTime);
            (new BukkitRunnable() {
                public void run() {
                    Block block = (Block) InventoryClickListener.getRealFurnaceBlock().get(p.getUniqueId());
                    Location loc = block.getLocation().add(0.5, 1.0, 0.5);
                    Location loc2 = block.getLocation().add(0.5, 1.2, 0.5);
                    World world = Bukkit.getWorld("world");
                    Objects.requireNonNull(world).spawn(loc2, ArmorStand.class, (armorStand2) -> {
                        armorStand2.setMarker(true);
                        armorStand2.setVisible(false);
                        armorStand2.setGravity(false);
                        armorStand2.setSmall(true);
                        armorStand2.setCustomNameVisible(true);
                        armorStand2.setCustomName(ChatColor.YELLOW + "Pi??iriliyor...");
                        Iterator var7 = Bukkit.getOnlinePlayers().iterator();

                        while (true) {
                            Player player2;
                            do {
                                if (!var7.hasNext()) {
                                    RealFurnaceAnim.this.plugin.getIndicators2().put(armorStand2, 100);
                                    world.spawn(loc, ArmorStand.class, (armorStand) -> {
                                        armorStand.setMarker(true);
                                        armorStand.setVisible(false);
                                        armorStand.setGravity(false);
                                        armorStand.setSmall(true);
                                        armorStand.setCustomNameVisible(true);
                                        armorStand.setCustomName("");
                                        Iterator var8 = Bukkit.getOnlinePlayers().iterator();

                                        while (true) {
                                            Player player3;
                                            do {
                                                if (!var8.hasNext()) {
                                                    RealFurnaceAnim.this.plugin.getIndicators2().put(armorStand, 100);
                                                    (new BukkitRunnable() {
                                                        public void run() {
                                                            int timer = RealFurnaceAnim.this.stats.getRealFurnaceProduction(p.getUniqueId());
                                                            RealFurnaceAnim.this.stats.setRealFurnaceProduction(p.getUniqueId(), 1);
                                                            int remain = cookTime - timer;
                                                            armorStand.setCustomName(ChatColor.GOLD + "Malzemenin Haz??r Olmas??na: " + ChatColor.WHITE + remain + " Saniye");
                                                            if (timer >= cookTime) {
                                                                armorStand.setCustomName(ChatColor.GREEN + "???");
                                                                RealFurnaceAnim.this.stats.setRealFurnaceAmount(p.getUniqueId(), -cookTime);
                                                                result.setAmount(1);
                                                                ((Inventory) JoinListener.getRealfurnacemenu().get(p.getUniqueId())).addItem(new ItemStack[]{result});
                                                                (new BukkitRunnable() {
                                                                    public void run() {
                                                                        armorStand.remove();
                                                                    }
                                                                }).runTaskLater(RealFurnaceAnim.this.plugin, 20L);
                                                                world.playSound(loc, Sound.BLOCK_BLASTFURNACE_FIRE_CRACKLE, 3.0F, 0.2F);
                                                                armorStand2.remove();
                                                                RealFurnaceAnim.this.stats.setRealFurnaceProduction(p.getUniqueId(), -timer - 1);
                                                                p.giveExp(1);
                                                                RealFurnaceAnim.this.stats.setExp(p.getUniqueId(), 1);
                                                                this.cancel();
                                                            }

                                                        }
                                                    }).runTaskTimer(RealFurnaceAnim.this.plugin, 0L, 20L);
                                                    return;
                                                }

                                                player3 = (Player) var8.next();
                                            } while (!p.getWorld().getName().equals("dungeonworld") && !p.getWorld().getName().equals("world"));

                                            if (player3 != p) {
                                                player3.hideEntity(RealFurnaceAnim.this.plugin, armorStand);
                                            }
                                        }
                                    });
                                    return;
                                }

                                player2 = (Player) var7.next();
                            } while (!p.getWorld().getName().equals("dungeonworld") && !p.getWorld().getName().equals("world"));

                            if (player2 != p) {
                                player2.hideEntity(RealFurnaceAnim.this.plugin, armorStand2);
                            }
                        }
                    });
                }
            }).runTaskLater(this.plugin, (long) (amount * 20L));
        } else {
            p.sendMessage(Painter.paint("&c&lBir malzeme ??s??tabilmek i??in &6&lF??r??n Deponu &c&lBo??alt!"));
        }

    }
}
