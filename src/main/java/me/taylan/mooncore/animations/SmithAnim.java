//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package me.taylan.mooncore.animations;

import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;
import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.level.Levels;
import me.taylan.mooncore.listeners.InventoryClickListener;
import me.taylan.mooncore.listeners.JoinListener;
import me.taylan.mooncore.listeners.entitydamage.SpawnArmorStand;
import me.taylan.mooncore.utils.Painter;
import me.taylan.mooncore.utils.StatsManager;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class SmithAnim {
    private final MoonCore plugin;
    private final StatsManager stats;
    private final Levels levels;

    public SmithAnim(MoonCore plugin) {
        this.plugin = plugin;
        this.levels = plugin.getLevels();
        this.stats = plugin.getStatsManager();
    }

    public void smithAnimation(final Player p, final int smithTime, final ItemStack result, final int exp) {
        if (((Inventory)JoinListener.getMenu().get(p.getUniqueId())).firstEmpty() != -1) {
            int timer = this.stats.getProduction(p.getUniqueId());
            int timerlvl10 = this.stats.getProduction1(p.getUniqueId());
            if (timer > 0 && timerlvl10 > 0) {
                p.sendMessage(Painter.paint("&cZaten bir ekipman işliyorsun! 2. Bir ekipmanı işlemeye koymak için 10. seviye ve üzeri Demircilikte ustalık gerekir."));
            }

            if (timer <= 0 && timerlvl10 <= 0) {
                Block block = (Block)InventoryClickListener.getSmithBlock().get(p.getUniqueId());
                Location loc3 = block.getLocation().add(0.1, -0.2, 1.4);
                loc3.setYaw(-180.0F);
                final Location loc = block.getLocation().add(0.5, 1.0, 0.5);
                Location loc2 = block.getLocation().add(0.5, 1.2, 0.5);
                final ArmorStand armorStand2 = SpawnArmorStand.spawnArmorStand(loc2, "<yellow>İşleniyor...");
                Iterator var12 = Bukkit.getOnlinePlayers().iterator();

                while(true) {
                    Player player2;
                    do {
                        if (!var12.hasNext()) {
                            this.plugin.getIndicators2().put(armorStand2, 100);
                            final ArmorStand armorStand22 = SpawnArmorStand.spawnArmorStand(loc3, "");
                            Iterator var17 = Bukkit.getOnlinePlayers().iterator();

                            while(true) {
                                do {
                                    if (!var17.hasNext()) {
                                        this.plugin.getIndicators2().put(armorStand22, 100);
                                        new SwingAnimation(armorStand22, 40.0, this.plugin);
                                        final ArmorStand armorStand = SpawnArmorStand.spawnArmorStand(loc, "");
                                        Iterator var19 = Bukkit.getOnlinePlayers().iterator();

                                        while(true) {
                                            do {
                                                if (!var19.hasNext()) {
                                                    this.plugin.getIndicators2().put(armorStand, 100);
                                                    (new BukkitRunnable() {
                                                        public void run() {
                                                            int timer = SmithAnim.this.stats.getProduction(p.getUniqueId());
                                                            SmithAnim.this.stats.setProduction(p.getUniqueId(), 1);
                                                            int remain = smithTime - timer;
                                                            p.playSound(loc, Sound.BLOCK_ANVIL_PLACE, 2.0F, 1.4F);
                                                            ItemStack itemData = new ItemStack(Material.NETHERITE_AXE);
                                                            loc.getWorld().spawnParticle(Particle.ITEM_CRACK, loc, 5, 0.3, 0.5, 0.3, 0.0, itemData);
                                                            armorStand.setCustomName(ChatColor.GOLD + "Ekipmanın Hazır Olmasına: " + ChatColor.WHITE + remain + " Saniye");
                                                            if (timer >= smithTime) {
                                                                SmithAnim.this.levels.giveSmithLevel(p, exp);
                                                                if (SmithAnim.this.stats.getMeslek(p.getUniqueId()).contains("Demirci")) {
                                                                    int random = ThreadLocalRandom.current().nextInt(10);
                                                                    if (random < 4) {
                                                                        SmithAnim.this.levels.giveSmithLevel(p, 10);
                                                                        p.sendMessage(Painter.paint("Ekstra Demircilik Ustalığı Tecrübe Puanı Kazandın!"));
                                                                    } else {
                                                                        p.giveExp(50);
                                                                        p.sendMessage(Painter.paint("Ekstra Tecrübe Puanı Kazandın!"));
                                                                    }
                                                                }

                                                                armorStand.setCustomName(ChatColor.GREEN + "✔");
                                                                result.setAmount(1);
                                                                ((Inventory)JoinListener.getMenu().get(p.getUniqueId())).addItem(new ItemStack[]{result});
                                                                (new BukkitRunnable() {
                                                                    public void run() {
                                                                        armorStand.remove();
                                                                    }
                                                                }).runTaskLater(SmithAnim.this.plugin, 40L);
                                                                armorStand2.remove();
                                                                armorStand22.remove();
                                                                SmithAnim.this.stats.setProduction(p.getUniqueId(), -timer - 1);
                                                                InventoryClickListener.getSmithBlock().clear();
                                                                p.playSound(loc, Sound.ENTITY_VILLAGER_WORK_TOOLSMITH, 3.0F, 0.2F);
                                                                this.cancel();
                                                            }

                                                        }
                                                    }).runTaskTimer(this.plugin, 0L, 20L);
                                                    return;
                                                }

                                                player2 = (Player)var19.next();
                                            } while(!p.getWorld().getName().equals("dungeonworld") && !p.getWorld().getName().equals("world"));

                                            if (player2 != p) {
                                                player2.hideEntity(this.plugin, armorStand);
                                            }
                                        }
                                    }

                                    player2 = (Player)var17.next();
                                } while(!p.getWorld().getName().equals("dungeonworld") && !p.getWorld().getName().equals("world"));

                                if (player2 != p) {
                                    player2.hideEntity(this.plugin, armorStand22);
                                }
                            }
                        }

                        player2 = (Player)var12.next();
                    } while(!p.getWorld().getName().equals("dungeonworld") && !p.getWorld().getName().equals("world"));

                    if (player2 != p) {
                        player2.hideEntity(this.plugin, armorStand2);
                    }
                }
            }
        } else {
            p.sendMessage(Painter.paint("&c&lBir malzeme üretebilmek için &6&lDemirci Masası Deponu &c&lBoşalt!"));
        }

    }
}
