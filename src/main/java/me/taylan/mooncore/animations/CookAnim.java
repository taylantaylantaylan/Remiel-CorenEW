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

public class CookAnim {
    public final MoonCore plugin;
    private final Levels Levels;
    private final StatsManager stats;

    public CookAnim(MoonCore plugin) {
        this.plugin = plugin;
        this.Levels = plugin.getLevels();
        this.stats = plugin.getStatsManager();
    }

    public void cookAnimation(final Player p, final int cookTime, final ItemStack result, int exp) {
        if (((Inventory)JoinListener.getFurnacemenu().get(p.getUniqueId())).firstEmpty() != -1) {
            int timer = this.stats.getCookProduction(p.getUniqueId());
            int amount = this.stats.getCookAmount(p.getUniqueId());
            this.stats.setCookAmount(p.getUniqueId(), cookTime);
            (new BukkitRunnable() {
                public void run() {
                    Block block = (Block)InventoryClickListener.getCookBlock().get(p.getUniqueId());
                    Location loc = block.getLocation().add(0.5, 1.0, 0.5);
                    Location loc2 = block.getLocation().add(0.5, 1.2, 0.5);
                    World world = Bukkit.getWorld("world");
                    Objects.requireNonNull(world).spawn(loc2, ArmorStand.class, (armorStand2) -> {
                        armorStand2.setMarker(true);
                        armorStand2.setVisible(false);
                        armorStand2.setGravity(false);
                        armorStand2.setSmall(true);
                        armorStand2.setCustomNameVisible(true);
                        armorStand2.setCustomName(ChatColor.YELLOW + "Pişiriliyor...");
                        Iterator var7 = Bukkit.getOnlinePlayers().iterator();

                        while(true) {
                            Player player2;
                            do {
                                if (!var7.hasNext()) {
                                    CookAnim.this.plugin.getIndicators2().put(armorStand2, 100);
                                    world.spawn(loc, ArmorStand.class, (armorStand) -> {
                                        armorStand.setMarker(true);
                                        armorStand.setVisible(false);
                                        armorStand.setGravity(false);
                                        armorStand.setSmall(true);
                                        armorStand.setCustomNameVisible(true);
                                        armorStand.setCustomName("");
                                        Iterator var8 = Bukkit.getOnlinePlayers().iterator();

                                        while(true) {
                                            Player player3;
                                            do {
                                                if (!var8.hasNext()) {
                                                    CookAnim.this.plugin.getIndicators2().put(armorStand, 100);
                                                    (new BukkitRunnable() {
                                                        public void run() {
                                                            int timer = CookAnim.this.stats.getCookProduction(p.getUniqueId());
                                                            CookAnim.this.stats.setCookProduction(p.getUniqueId(), 1);
                                                            int remain = cookTime - timer;
                                                            armorStand.setCustomName(ChatColor.GOLD + "Yemeğin Hazır Olmasına: " + ChatColor.WHITE + remain + " Saniye");
                                                            if (timer >= cookTime) {
                                                                CookAnim.this.Levels.giveCookLevel(p, result);
                                                                armorStand.setCustomName(ChatColor.GREEN + "✔");
                                                                CookAnim.this.stats.setCookAmount(p.getUniqueId(), -cookTime);
                                                                result.setAmount(1);
                                                                ((Inventory)JoinListener.getOcakMenu().get(p.getUniqueId())).addItem(new ItemStack[]{result});
                                                                (new BukkitRunnable() {
                                                                    public void run() {
                                                                        armorStand.remove();
                                                                    }
                                                                }).runTaskLater(CookAnim.this.plugin, 20L);
                                                                world.playSound(loc, Sound.BLOCK_SMOKER_SMOKE, 3.0F, 0.2F);
                                                                armorStand2.remove();
                                                                p.giveExp(1);
                                                                CookAnim.this.stats.setExp(p.getUniqueId(), 1);
                                                                CookAnim.this.stats.setCookProduction(p.getUniqueId(), -timer - 1);
                                                                this.cancel();
                                                            }

                                                        }
                                                    }).runTaskTimer(CookAnim.this.plugin, 0L, 20L);
                                                    return;
                                                }

                                                player3 = (Player)var8.next();
                                            } while(!p.getWorld().getName().equals("dungeonworld") && !p.getWorld().getName().equals("world"));

                                            if (player3 != p) {
                                                player3.hideEntity(CookAnim.this.plugin, armorStand);
                                            }
                                        }
                                    });
                                    return;
                                }

                                player2 = (Player)var7.next();
                            } while(!p.getWorld().getName().equals("dungeonworld") && !p.getWorld().getName().equals("world"));

                            if (player2 != p) {
                                player2.hideEntity(CookAnim.this.plugin, armorStand2);
                            }
                        }
                    });
                }
            }).runTaskLater(this.plugin, (long)(amount * 20L));
        } else {
            p.sendMessage(Painter.paint("&c&lBir yemeği pişirebilmek için için &6&lOcak Deponu &c&lBoşalt!"));
        }

    }
}
