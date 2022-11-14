//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package me.taylan.mooncore.listeners;

import com.destroystokyo.paper.MaterialTags;
import java.util.concurrent.ThreadLocalRandom;
import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.level.Levels;
import me.taylan.mooncore.utils.ItemHandler;
import me.taylan.mooncore.utils.Painter;
import me.taylan.mooncore.utils.StatsManager;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Tag;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;

public class BlockRegenListener implements Listener {
    private final MoonCore plugin;
    private final ItemHandler itemHandler;
    private final StatsManager statsManager;
    private final Levels levels;

    public BlockRegenListener(MoonCore plugin) {
        this.plugin = plugin;
        this.itemHandler = plugin.getItemHandler();
        this.levels = plugin.getLevels();
        this.statsManager = plugin.getStatsManager();
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void blockbreak(final BlockBreakEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPermission("mooncore.break")) {
            Material blocktype = event.getBlock().getType();
            World world = player.getWorld();
            ItemStack item = player.getInventory().getItemInMainHand();
            ItemStack silver1;
            ItemStack silver2;
            ItemStack birchwood;
            ItemStack silver4;
            ItemStack silver5;
            ItemStack stone;
            ItemStack stone2;
            ItemStack silver9;
            ItemStack stoneRED;
            int chance;
            int aletgucu;
            ItemStack oakwood;
            ItemStack cooal;
            ItemStack heavywood;
            int logchance;
            NamespacedKey digpower;



            int chanceamount3;
            if (player.getWorld().getName().equals("world")) {
                switch (blocktype) {
                    case RAW_IRON_BLOCK:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            digpower = new NamespacedKey(this.plugin, "aletGucu");
                            aletgucu = (Integer)item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 5) {
                                event.setDropItems(false);
                                event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                                event.setCancelled(true);
                                birchwood = this.itemHandler.silverore;
                                birchwood.setAmount(1);
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), birchwood);
                                } else {
                                    player.getInventory().addItem(birchwood);
                                }
                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu maden için gereken minimum alet gücü: 6"));
                            }
                        }
                        break;
                    case COPPER_ORE:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            digpower = new NamespacedKey(this.plugin, "aletGucu");
                            aletgucu = (Integer)item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 1) {
                                event.setDropItems(false);
                                event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                                event.setCancelled(true);
                                birchwood = this.itemHandler.copperore;
                                birchwood.setAmount(1);
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), birchwood);
                                } else {
                                    player.getInventory().addItem(birchwood);
                                }
                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu maden için gereken minimum alet gücü: 2"));
                            }
                        }
                        break;
                    case BIRCH_WOOD:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            digpower = new NamespacedKey(this.plugin, "aletGucu");
                            aletgucu = (Integer)item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 3) {
                                event.setDropItems(false);
                                event.setExpToDrop(1);
                                event.getBlock().setType(Material.AIR);
                                event.setCancelled(true);
                                heavywood = this.itemHandler.birchwood;
                                heavywood.setAmount(1);
                                this.levels.giveOduncuExp(player, event.getBlock());
                                if (this.statsManager.getMeslek(player.getUniqueId()).equals("Oduncu")) {
                                    logchance = ThreadLocalRandom.current().nextInt(30);
                                    if (logchance < 5) {
                                        player.sendMessage(Painter.paint("&6Ekstra Odun Düşürdün!"));
                                        if (player.getInventory().firstEmpty() == -1) {
                                            world.dropItemNaturally(event.getBlock().getLocation(), heavywood);
                                        } else {
                                            player.getInventory().addItem(heavywood);
                                        }
                                    }
                                }

                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(player.getLocation(), heavywood);
                                } else {
                                    player.getInventory().addItem(heavywood);
                                }
                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu odun için gereken minimum alet gücü: 4"));
                            }
                        }
                        break;
                    case SHROOMLIGHT:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.BEDROCK);
                        event.setCancelled(true);
                        silver1 = this.itemHandler.glowstone;
                        silver1.setAmount(1);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), silver1);
                        } else {
                            player.getInventory().addItem(silver1);
                        }
                        break;
                    case CACTUS:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.AIR);
                        event.setCancelled(true);
                        silver2 = this.itemHandler.cactus;
                        silver2.setAmount(1);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), silver2);
                        } else {
                            player.getInventory().addItem(silver2);
                        }
                        break;
                    case TERRACOTTA:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.BEDROCK);
                        event.setCancelled(true);
                        birchwood = this.itemHandler.terracotta;
                        birchwood.setAmount(1);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), birchwood);
                        } else {
                            player.getInventory().addItem(this.itemHandler.terracotta);
                        }
                        break;
                    case LARGE_FERN:
                    case FERN:
                    case GRASS:
                    case TALL_GRASS:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.AIR);
                        event.setCancelled(true);
                        break;
                    case WHITE_TERRACOTTA:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.BEDROCK);
                        event.setCancelled(true);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), this.itemHandler.whiteterracotta);
                        } else {
                            player.getInventory().addItem(this.itemHandler.whiteterracotta);
                        }
                        break;
                    case YELLOW_TERRACOTTA:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.BEDROCK);
                        event.setCancelled(true);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), this.itemHandler.yellowterracotta);
                        } else {
                            player.getInventory().addItem(this.itemHandler.yellowterracotta);
                        }
                        break;
                    case ORANGE_TERRACOTTA:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.BEDROCK);
                        event.setCancelled(true);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), this.itemHandler.orangeterracotta);
                        } else {
                            player.getInventory().addItem(this.itemHandler.orangeterracotta);
                        }
                        break;
                    case LIGHT_GRAY_TERRACOTTA:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.BEDROCK);
                        event.setCancelled(true);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), this.itemHandler.grayterracotta);
                        } else {
                            player.getInventory().addItem(this.itemHandler.grayterracotta);
                        }
                        break;
                    case SAND:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.BEDROCK);
                        event.setCancelled(true);
                        silver4 = this.itemHandler.sand;
                        silver4.setAmount(1);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), silver4);
                        } else {
                            player.getInventory().addItem(silver4);
                        }

                        (new BukkitRunnable() {
                            public void run() {
                                event.getBlock().setType(Material.SAND);
                            }
                        }).runTaskLater(this.plugin, 200L);
                        break;
                    case RED_SAND:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.BEDROCK);
                        event.setCancelled(true);
                        silver5 = this.itemHandler.redsand;
                        silver5.setAmount(1);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), silver5);
                        } else {
                            player.getInventory().addItem(silver5);
                        }
                        break;
                    case GOLD_ORE:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            digpower = new NamespacedKey(this.plugin, "aletGucu");
                            aletgucu = (Integer)item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 4) {
                                event.setDropItems(false);
                                event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                                event.setCancelled(true);
                                silver9 = this.itemHandler.goldore;
                                silver9.setAmount(1);
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), silver9);
                                } else {
                                    player.getInventory().addItem(silver9);
                                }
                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu maden için gereken minimum alet gücü: 5"));
                            }
                        }
                        break;
                    case DEEPSLATE_DIAMOND_ORE:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            digpower = new NamespacedKey(this.plugin, "aletGucu");
                            aletgucu = (Integer)item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 8) {
                                event.setDropItems(false);
                                event.getBlock().setType(Material.BEDROCK);
                                event.setCancelled(true);
                                silver9 = this.itemHandler.adamantiumore;
                                silver9.setAmount(1);
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), silver9);
                                } else {
                                    player.getInventory().addItem(silver9);
                                }
                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu maden için gereken minimum alet gücü: 9"));
                            }
                        }
                        break;
                    case DEEPSLATE_REDSTONE_ORE:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            digpower = new NamespacedKey(this.plugin, "aletGucu");
                            aletgucu = (Integer)item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 7) {
                                event.setDropItems(false);
                                event.getBlock().setType(Material.BEDROCK);
                                event.setCancelled(true);
                                silver9 = this.itemHandler.crimsonore;
                                silver9.setAmount(1);
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), silver9);
                                } else {
                                    player.getInventory().addItem(silver9);
                                }
                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu maden için gereken minimum alet gücü: 8"));
                            }
                        }
                        break;
                    case RAW_COPPER_BLOCK:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            digpower = new NamespacedKey(this.plugin, "aletGucu");
                            aletgucu = (Integer)item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 2) {
                                event.setDropItems(false);
                                event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                                event.setCancelled(true);
                                silver9 = this.itemHandler.nikelore;
                                silver9.setAmount(1);
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), silver9);
                                } else {
                                    player.getInventory().addItem(silver9);
                                }
                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu maden için gereken minimum alet gücü: 3"));
                            }
                        }
                        break;
                    case COBBLESTONE:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                        event.setCancelled(true);
                        stone = this.itemHandler.cobblestone;
                        stone.setAmount(1);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), stone);
                        } else {
                            player.getInventory().addItem(stone);
                        }
                        break;
                    case TUFF:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                        event.setCancelled(true);
                        stone2 = this.itemHandler.cobblestone;
                        stone2.setAmount(1);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), stone2);
                        } else {
                            player.getInventory().addItem(stone2);
                        }
                        break;
                    case STONE:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                        event.setCancelled(true);
                        silver9 = this.itemHandler.cobblestone;
                        silver9.setAmount(1);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), silver9);
                        } else {
                            player.getInventory().addItem(silver9);
                        }
                        break;
                    case REDSTONE_ORE:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                        event.setCancelled(true);
                        event.setExpToDrop(2);
                        stoneRED = this.itemHandler.redstone;
                        stoneRED.setAmount(1);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), stoneRED);
                        } else {
                            player.getInventory().addItem(stoneRED);
                        }
                        break;
                    case LAPIS_ORE:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            digpower = new NamespacedKey(this.plugin, "aletGucu");
                            aletgucu = (Integer)item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 2) {
                                event.setDropItems(false);
                                event.setExpToDrop(1);
                                event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                                event.setCancelled(true);
                                chanceamount3 = ThreadLocalRandom.current().nextInt(4) + 1;
                                cooal = this.itemHandler.lapis;
                                cooal.setAmount(chanceamount3);
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(player.getLocation(), cooal);
                                } else {
                                    player.getInventory().addItem(cooal);
                                }
                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu maden için gereken minimum alet gücü: 3"));
                            }
                        }
                        break;
                    case OBSIDIAN:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            digpower = new NamespacedKey(this.plugin, "aletGucu");
                            aletgucu = (Integer)item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 5) {
                                event.setDropItems(false);
                                event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                                event.setCancelled(true);
                                oakwood = this.itemHandler.obsidianore;
                                oakwood.setAmount(1);
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), oakwood);
                                } else {
                                    player.getInventory().addItem(oakwood);
                                }
                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu maden için gereken minimum alet gücü: 3"));
                            }
                        }
                        break;
                    case GRAVEL:
                        event.setDropItems(false);
                        chance = ThreadLocalRandom.current().nextInt(10);
                        event.setCancelled(true);
                        event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                        if (chance < 2) {
                            if (player.getInventory().firstEmpty() == -1) {
                                world.dropItemNaturally(event.getBlock().getLocation(), this.itemHandler.gravel);
                            } else {
                                player.getInventory().addItem(this.itemHandler.gravel);
                            }
                        } else if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), this.itemHandler.gravelblock);
                        } else {
                            player.getInventory().addItem(this.itemHandler.gravelblock);
                        }
                        break;
                    case OAK_LEAVES:
                        event.setDropItems(false);
                        aletgucu = ThreadLocalRandom.current().nextInt(20);
                        event.setCancelled(true);
                        event.getBlock().setType(Material.AIR);
                        if (aletgucu < 2) {
                            if (player.getInventory().firstEmpty() == -1) {
                                oakwood = this.itemHandler.apple;
                                oakwood.setAmount(1);
                                world.dropItemNaturally(event.getBlock().getLocation(), oakwood);
                                this.levels.giveFarmingExp(player, oakwood);
                            } else {
                                oakwood = this.itemHandler.apple;
                                oakwood.setAmount(1);
                                player.getInventory().addItem(oakwood);
                                this.levels.giveFarmingExp(player, oakwood);
                            }
                        }
                        break;
                    case CLAY:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                        event.setCancelled(true);
                        if (player.getInventory().firstEmpty() == -1) {
                            oakwood = this.itemHandler.clay;
                            oakwood.setAmount(1);
                            world.dropItemNaturally(event.getBlock().getLocation(), oakwood);
                        } else {
                            oakwood = this.itemHandler.clay;
                            oakwood.setAmount(1);
                            player.getInventory().addItem(oakwood);
                        }
                        break;
                    case DIAMOND_ORE:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            digpower = new NamespacedKey(this.plugin, "aletGucu");
                            aletgucu = (Integer)item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 3) {
                                event.setDropItems(false);
                                event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                                event.setCancelled(true);
                                heavywood = this.itemHandler.diamond;
                                heavywood.setAmount(1);
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), heavywood);
                                } else {
                                    player.getInventory().addItem(heavywood);
                                }
                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu maden için gereken minimum alet gücü: 4"));
                            }
                        }
                        break;
                    case IRON_ORE:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            digpower = new NamespacedKey(this.plugin, "aletGucu");
                            aletgucu = (Integer)item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 3) {
                                event.setDropItems(false);
                                event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                                event.setCancelled(true);
                                heavywood = this.itemHandler.ironore;
                                heavywood.setAmount(1);
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), heavywood);
                                } else {
                                    player.getInventory().addItem(heavywood);
                                }
                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu maden için gereken minimum alet gücü: 4"));
                            }
                        }
                        break;
                    case COAL_ORE:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            digpower = new NamespacedKey(this.plugin, "aletGucu");
                            aletgucu = (Integer)item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 1) {
                                event.setDropItems(false);
                                event.setExpToDrop(1);
                                event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                                event.setCancelled(true);
                                chanceamount3 = ThreadLocalRandom.current().nextInt(1) + 2;
                                cooal = this.itemHandler.coal;
                                cooal.setAmount(chanceamount3);
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(player.getLocation(), cooal);
                                } else {
                                    player.getInventory().addItem(cooal);
                                }
                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu maden için gereken minimum alet gücü: 2"));
                            }
                        }
                    case SUGAR_CANE:
                    case STRIPPED_OAK_WOOD:
                    case STRIPPED_ACACIA_WOOD:
                    default:
                        break;
                    case ALLIUM:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.AIR);
                        event.setCancelled(true);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), this.itemHandler.kezicicek);
                        } else {
                            player.getInventory().addItem(this.itemHandler.kezicicek);
                        }
                        break;
                    case STRIPPED_DARK_OAK_WOOD:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            digpower = new NamespacedKey(this.plugin, "aletGucu");
                            aletgucu = (Integer)item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 7) {
                                event.setDropItems(false);
                                event.setExpToDrop(1);
                                event.getBlock().setType(Material.AIR);
                                event.setCancelled(true);
                                heavywood = this.itemHandler.oldoakwood;
                                heavywood.setAmount(1);
                                this.levels.giveOduncuExp(player, event.getBlock());
                                if (this.statsManager.getMeslek(player.getUniqueId()).equals("Oduncu")) {
                                    logchance = ThreadLocalRandom.current().nextInt(30);
                                    if (logchance < 5) {
                                        player.sendMessage(Painter.paint("&6Ekstra Odun Düşürdün!"));
                                        if (player.getInventory().firstEmpty() == -1) {
                                            world.dropItemNaturally(event.getBlock().getLocation(), heavywood);
                                        } else {
                                            player.getInventory().addItem(heavywood);
                                        }
                                    }
                                }

                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(player.getLocation(), heavywood);
                                } else {
                                    player.getInventory().addItem(heavywood);
                                }
                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu odun için gereken minimum alet gücü: 8"));
                            }
                        }
                        break;
                    case SPRUCE_WOOD:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            digpower = new NamespacedKey(this.plugin, "aletGucu");
                            aletgucu = (Integer)item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 4) {
                                event.setDropItems(false);
                                event.setExpToDrop(1);
                                event.getBlock().setType(Material.AIR);
                                event.setCancelled(true);
                                heavywood = this.itemHandler.sprucewood;
                                heavywood.setAmount(1);
                                this.levels.giveOduncuExp(player, event.getBlock());
                                if (this.statsManager.getMeslek(player.getUniqueId()).equals("Oduncu")) {
                                    logchance = ThreadLocalRandom.current().nextInt(30);
                                    if (logchance < 5) {
                                        player.sendMessage(Painter.paint("&6Ekstra Odun Düşürdün!"));
                                        if (player.getInventory().firstEmpty() == -1) {
                                            world.dropItemNaturally(event.getBlock().getLocation(), heavywood);
                                        } else {
                                            player.getInventory().addItem(heavywood);
                                        }
                                    }
                                }

                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(player.getLocation(), heavywood);
                                } else {
                                    player.getInventory().addItem(heavywood);
                                }
                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu odun için gereken minimum alet gücü: 5"));
                            }
                        }
                        break;
                    case ACACIA_WOOD:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            digpower = new NamespacedKey(this.plugin, "aletGucu");
                            aletgucu = (Integer)item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 6) {
                                event.setDropItems(false);
                                event.setExpToDrop(1);
                                event.getBlock().setType(Material.AIR);
                                event.setCancelled(true);
                                heavywood = this.itemHandler.acaciawood;
                                heavywood.setAmount(1);
                                this.levels.giveOduncuExp(player, event.getBlock());
                                if (this.statsManager.getMeslek(player.getUniqueId()).equals("Oduncu")) {
                                    logchance = ThreadLocalRandom.current().nextInt(30);
                                    if (logchance < 5) {
                                        player.sendMessage(Painter.paint("&6Ekstra Odun Düşürdün!"));
                                        if (player.getInventory().firstEmpty() == -1) {
                                            world.dropItemNaturally(event.getBlock().getLocation(), heavywood);
                                        } else {
                                            player.getInventory().addItem(heavywood);
                                        }
                                    }
                                }

                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(player.getLocation(), heavywood);
                                } else {
                                    player.getInventory().addItem(heavywood);
                                }
                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu odun için gereken minimum alet gücü: 7"));
                            }
                        }
                        break;
                    case OAK_LOG:
                    case SPRUCE_LOG:
                    case DARK_OAK_LOG:
                    case JUNGLE_LOG:
                    case CRIMSON_HYPHAE:
                    case ACACIA_LOG:
                    case STRIPPED_BIRCH_WOOD:
                    case STRIPPED_BIRCH_LOG:
                    case BIRCH_LOG:
                        event.setDropItems(false);
                        event.setCancelled(true);
                        break;
                    case JUNGLE_WOOD:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            digpower = new NamespacedKey(this.plugin, "aletGucu");
                            aletgucu = (Integer)item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 9) {
                                event.setDropItems(false);
                                event.setExpToDrop(1);
                                event.getBlock().setType(Material.AIR);
                                event.setCancelled(true);
                                heavywood = this.itemHandler.godwood;
                                heavywood.setAmount(1);
                                this.levels.giveOduncuExp(player, event.getBlock());
                                if (this.statsManager.getMeslek(player.getUniqueId()).equals("Oduncu")) {
                                    logchance = ThreadLocalRandom.current().nextInt(30);
                                    if (logchance < 5) {
                                        player.sendMessage(Painter.paint("&6Ekstra Odun Düşürdün!"));
                                        if (player.getInventory().firstEmpty() == -1) {
                                            world.dropItemNaturally(event.getBlock().getLocation(), heavywood);
                                        } else {
                                            player.getInventory().addItem(heavywood);
                                        }
                                    }
                                }

                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(player.getLocation(), heavywood);
                                } else {
                                    player.getInventory().addItem(heavywood);
                                }
                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu odun için gereken minimum alet gücü: 10"));
                            }
                        }
                        break;
                    case DARK_OAK_WOOD:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            digpower = new NamespacedKey(this.plugin, "aletGucu");
                            aletgucu = (Integer)item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 8) {
                                event.setDropItems(false);
                                event.getBlock().setType(Material.AIR);
                                event.setCancelled(true);
                                heavywood = this.itemHandler.darkoakwood;
                                heavywood.setAmount(1);
                                this.levels.giveOduncuExp(player, event.getBlock());
                                if (this.statsManager.getMeslek(player.getUniqueId()).equals("Oduncu")) {
                                    logchance = ThreadLocalRandom.current().nextInt(30);
                                    if (logchance < 5) {
                                        player.sendMessage(Painter.paint("&6Ekstra Odun Düşürdün!"));
                                        if (player.getInventory().firstEmpty() == -1) {
                                            world.dropItemNaturally(event.getBlock().getLocation(), heavywood);
                                        } else {
                                            player.getInventory().addItem(heavywood);
                                        }
                                    }
                                }

                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(player.getLocation(), heavywood);
                                } else {
                                    player.getInventory().addItem(heavywood);
                                }
                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu odun için gereken minimum alet gücü: 9"));
                            }
                        }
                        break;
                    case WARPED_HYPHAE:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            if (MaterialTags.AXES.isTagged(item)) {
                                digpower = new NamespacedKey(this.plugin, "aletGucu");
                                aletgucu = (Integer)item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                                if (aletgucu > 5) {
                                    event.setDropItems(false);
                                    event.getBlock().setType(Material.AIR);
                                    event.setCancelled(true);
                                    heavywood = this.itemHandler.heavywood;
                                    heavywood.setAmount(1);
                                    this.levels.giveOduncuExp(player, event.getBlock());
                                    if (player.getInventory().firstEmpty() == -1) {
                                        world.dropItemNaturally(event.getBlock().getLocation(), heavywood);
                                    } else {
                                        player.getInventory().addItem(heavywood);
                                    }
                                } else {
                                    event.setCancelled(true);
                                    player.sendMessage(Painter.paint("&6Bu maden için gereken minimum alet gücü: 6"));
                                }
                            }
                        } else {
                            event.setCancelled(true);
                        }
                        break;
                    case OAK_WOOD:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.OAK_PLANKS);
                        event.setCancelled(true);
                        oakwood = this.itemHandler.oakwood;
                        oakwood.setAmount(1);
                        this.levels.giveOduncuExp(player, event.getBlock());
                        if (this.statsManager.getMeslek(player.getUniqueId()).equals("Oduncu")) {
                            aletgucu = ThreadLocalRandom.current().nextInt(30);
                            if (aletgucu < 5) {
                                player.sendMessage(Painter.paint("&6Ekstra Odun Düşürdün!"));
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), oakwood);
                                } else {
                                    player.getInventory().addItem(oakwood);
                                }
                            }
                        }

                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), oakwood);
                        } else {
                            player.getInventory().addItem(oakwood);
                        }
                        break;
                    case CALCITE:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                        event.setCancelled(true);
                        event.setExpToDrop(1);
                        cooal = this.itemHandler.salt;
                        cooal.setAmount(1);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), cooal);
                        } else {
                            player.getInventory().addItem(cooal);
                        }
                        break;
                }
            } else {
                if (!Tag.LOGS.isTagged(blocktype) && !Tag.COAL_ORES.isTagged(blocktype) && !Tag.IRON_ORES.isTagged(blocktype) && !Tag.DIAMOND_ORES.isTagged(blocktype) && !Tag.LAPIS_ORES.isTagged(blocktype) && !Tag.REDSTONE_ORES.isTagged(blocktype) && !Tag.COPPER_ORES.isTagged(blocktype) && !Tag.GOLD_ORES.isTagged(blocktype) && blocktype != Material.OBSIDIAN && blocktype != Material.CLAY && blocktype != Material.RAW_COPPER_BLOCK && blocktype != Material.RAW_IRON_BLOCK && blocktype != Material.GRAVEL) {
                    event.setCancelled(true);
                }

                switch (blocktype) {
                    case RAW_IRON_BLOCK:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            digpower = new NamespacedKey(this.plugin, "aletGucu");
                            aletgucu = (Integer)item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 5) {
                                this.levels.giveMiningExp(player, event.getBlock());
                                event.setDropItems(false);
                                event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                                event.setCancelled(true);
                                birchwood = this.itemHandler.silverore;
                                birchwood.setAmount(1);
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), birchwood);
                                } else {
                                    player.getInventory().addItem(birchwood);
                                }

                                (new BukkitRunnable() {
                                    public void run() {
                                        event.getBlock().setType(Material.RAW_IRON_BLOCK);
                                    }
                                }).runTaskLater(this.plugin, 200L);
                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu maden için gereken minimum alet gücü: 6"));
                            }
                        }
                        break;
                    case COPPER_ORE:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            digpower = new NamespacedKey(this.plugin, "aletGucu");
                            aletgucu = (Integer)item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 1) {
                                this.levels.giveMiningExp(player, event.getBlock());
                                event.setDropItems(false);
                                event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                                event.setCancelled(true);
                                birchwood = this.itemHandler.copperore;
                                birchwood.setAmount(1);
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), birchwood);
                                } else {
                                    player.getInventory().addItem(birchwood);
                                }

                                (new BukkitRunnable() {
                                    public void run() {
                                        event.getBlock().setType(Material.COPPER_ORE);
                                    }
                                }).runTaskLater(this.plugin, 200L);
                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu maden için gereken minimum alet gücü: 2"));
                            }
                        }
                        break;
                    case BIRCH_WOOD:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            digpower = new NamespacedKey(this.plugin, "aletGucu");
                            aletgucu = (Integer)item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 3) {
                                this.levels.giveOduncuExp(player, event.getBlock());
                                event.setDropItems(false);
                                event.setExpToDrop(1);
                                event.getBlock().setType(Material.BIRCH_PLANKS);
                                event.setCancelled(true);
                                birchwood = this.itemHandler.birchwood;
                                birchwood.setAmount(1);
                                if (this.statsManager.getMeslek(player.getUniqueId()).equals("Oduncu")) {
                                    logchance = ThreadLocalRandom.current().nextInt(30);
                                    if (logchance < 5) {
                                        player.sendMessage(Painter.paint("&6Ekstra Odun Düşürdün!"));
                                        if (player.getInventory().firstEmpty() == -1) {
                                            world.dropItemNaturally(event.getBlock().getLocation(), birchwood);
                                        } else {
                                            player.getInventory().addItem(birchwood);
                                        }
                                    }
                                }

                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(player.getLocation(), birchwood);
                                } else {
                                    player.getInventory().addItem(birchwood);
                                }

                                (new BukkitRunnable() {
                                    public void run() {
                                        event.getBlock().setType(Material.BIRCH_WOOD);
                                    }
                                }).runTaskLater(this.plugin, 200L);
                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu odun için gereken minimum alet gücü: 4"));
                            }
                        }
                        break;
                    case SHROOMLIGHT:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.BEDROCK);
                        event.setCancelled(true);
                        silver1 = this.itemHandler.glowstone;
                        silver1.setAmount(1);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), silver1);
                        } else {
                            player.getInventory().addItem(silver1);
                        }

                        (new BukkitRunnable() {
                            public void run() {
                                event.getBlock().setType(Material.SHROOMLIGHT);
                            }
                        }).runTaskLater(this.plugin, 200L);
                        break;
                    case CACTUS:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.AIR);
                        event.setCancelled(true);
                        silver2 = this.itemHandler.cactus;
                        silver2.setAmount(1);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), silver2);
                        } else {
                            player.getInventory().addItem(silver2);
                        }

                        (new BukkitRunnable() {
                            public void run() {
                                event.getBlock().setType(Material.CACTUS);
                            }
                        }).runTaskLater(this.plugin, 250L);
                        break;
                    case TERRACOTTA:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.BEDROCK);
                        event.setCancelled(true);
                        birchwood = this.itemHandler.terracotta;
                        birchwood.setAmount(1);
                        this.levels.giveMiningExp(player, event.getBlock());
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), birchwood);
                        } else {
                            player.getInventory().addItem(this.itemHandler.terracotta);
                        }

                        (new BukkitRunnable() {
                            public void run() {
                                event.getBlock().setType(Material.TERRACOTTA);
                            }
                        }).runTaskLater(this.plugin, 200L);
                        break;
                    case LARGE_FERN:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.AIR);
                        event.setCancelled(true);
                        (new BukkitRunnable() {
                            public void run() {
                                event.getBlock().setType(Material.LARGE_FERN);
                            }
                        }).runTaskLater(this.plugin, 800L);
                        break;
                    case FERN:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.AIR);
                        event.setCancelled(true);
                        (new BukkitRunnable() {
                            public void run() {
                                event.getBlock().setType(Material.FERN);
                            }
                        }).runTaskLater(this.plugin, 800L);
                        break;
                    case GRASS:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.AIR);
                        event.setCancelled(true);
                        (new BukkitRunnable() {
                            public void run() {
                                event.getBlock().setType(Material.GRASS);
                            }
                        }).runTaskLater(this.plugin, 800L);
                        break;
                    case TALL_GRASS:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.AIR);
                        event.setCancelled(true);
                        (new BukkitRunnable() {
                            public void run() {
                                event.getBlock().setType(Material.TALL_GRASS);
                            }
                        }).runTaskLater(this.plugin, 800L);
                        break;
                    case WHITE_TERRACOTTA:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.BEDROCK);
                        event.setCancelled(true);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), this.itemHandler.whiteterracotta);
                        } else {
                            player.getInventory().addItem(this.itemHandler.whiteterracotta);
                        }

                        (new BukkitRunnable() {
                            public void run() {
                                event.getBlock().setType(Material.WHITE_TERRACOTTA);
                            }
                        }).runTaskLater(this.plugin, 200L);
                        break;
                    case YELLOW_TERRACOTTA:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.BEDROCK);
                        event.setCancelled(true);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), this.itemHandler.yellowterracotta);
                        } else {
                            player.getInventory().addItem(this.itemHandler.yellowterracotta);
                        }

                        (new BukkitRunnable() {
                            public void run() {
                                event.getBlock().setType(Material.YELLOW_TERRACOTTA);
                            }
                        }).runTaskLater(this.plugin, 200L);
                        break;
                    case ORANGE_TERRACOTTA:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.BEDROCK);
                        event.setCancelled(true);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), this.itemHandler.orangeterracotta);
                        } else {
                            player.getInventory().addItem(this.itemHandler.orangeterracotta);
                        }

                        (new BukkitRunnable() {
                            public void run() {
                                event.getBlock().setType(Material.ORANGE_TERRACOTTA);
                            }
                        }).runTaskLater(this.plugin, 200L);
                        break;
                    case LIGHT_GRAY_TERRACOTTA:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.BEDROCK);
                        event.setCancelled(true);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), this.itemHandler.grayterracotta);
                        } else {
                            player.getInventory().addItem(this.itemHandler.grayterracotta);
                        }

                        (new BukkitRunnable() {
                            public void run() {
                                event.getBlock().setType(Material.LIGHT_GRAY_TERRACOTTA);
                            }
                        }).runTaskLater(this.plugin, 200L);
                        break;
                    case SAND:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.BEDROCK);
                        event.setCancelled(true);
                        silver4 = this.itemHandler.sand;
                        silver4.setAmount(1);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), silver4);
                        } else {
                            player.getInventory().addItem(silver4);
                        }

                        (new BukkitRunnable() {
                            public void run() {
                                event.getBlock().setType(Material.SAND);
                            }
                        }).runTaskLater(this.plugin, 200L);
                        break;
                    case RED_SAND:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.BEDROCK);
                        event.setCancelled(true);
                        silver5 = this.itemHandler.redsand;
                        silver5.setAmount(1);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), silver5);
                        } else {
                            player.getInventory().addItem(silver5);
                        }

                        (new BukkitRunnable() {
                            public void run() {
                                event.getBlock().setType(Material.RED_SAND);
                            }
                        }).runTaskLater(this.plugin, 200L);
                        break;
                    case GOLD_ORE:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            digpower = new NamespacedKey(this.plugin, "aletGucu");
                            aletgucu = (Integer)item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 4) {
                                this.levels.giveMiningExp(player, event.getBlock());
                                event.setDropItems(false);
                                event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                                event.setCancelled(true);
                                silver9 = this.itemHandler.goldore;
                                silver9.setAmount(1);
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), silver9);
                                } else {
                                    player.getInventory().addItem(silver9);
                                }

                                (new BukkitRunnable() {
                                    public void run() {
                                        event.getBlock().setType(Material.GOLD_ORE);
                                    }
                                }).runTaskLater(this.plugin, 200L);
                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu maden için gereken minimum alet gücü: 5"));
                            }
                        }
                        break;
                    case DEEPSLATE_DIAMOND_ORE:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            digpower = new NamespacedKey(this.plugin, "aletGucu");
                            aletgucu = (Integer)item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 8) {
                                this.levels.giveMiningExp(player, event.getBlock());
                                event.setDropItems(false);
                                event.getBlock().setType(Material.BEDROCK);
                                event.setCancelled(true);
                                silver9 = this.itemHandler.adamantiumore;
                                silver9.setAmount(1);
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), silver9);
                                } else {
                                    player.getInventory().addItem(silver9);
                                }

                                (new BukkitRunnable() {
                                    public void run() {
                                        event.getBlock().setType(Material.DEEPSLATE_DIAMOND_ORE);
                                    }
                                }).runTaskLater(this.plugin, 200L);
                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu maden için gereken minimum alet gücü: 9"));
                            }
                        }
                        break;
                    case DEEPSLATE_REDSTONE_ORE:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            digpower = new NamespacedKey(this.plugin, "aletGucu");
                            aletgucu = (Integer)item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 7) {
                                this.levels.giveMiningExp(player, event.getBlock());
                                event.setDropItems(false);
                                event.getBlock().setType(Material.BEDROCK);
                                event.setCancelled(true);
                                silver9 = this.itemHandler.crimsonore;
                                silver9.setAmount(1);
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), silver9);
                                } else {
                                    player.getInventory().addItem(silver9);
                                }

                                (new BukkitRunnable() {
                                    public void run() {
                                        event.getBlock().setType(Material.DEEPSLATE_REDSTONE_ORE);
                                    }
                                }).runTaskLater(this.plugin, 200L);
                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu maden için gereken minimum alet gücü: 8"));
                            }
                        }
                        break;
                    case RAW_COPPER_BLOCK:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            digpower = new NamespacedKey(this.plugin, "aletGucu");
                            aletgucu = (Integer)item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 2) {
                                this.levels.giveMiningExp(player, event.getBlock());
                                event.setDropItems(false);
                                event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                                event.setCancelled(true);
                                silver9 = this.itemHandler.nikelore;
                                silver9.setAmount(1);
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), silver9);
                                } else {
                                    player.getInventory().addItem(silver9);
                                }

                                (new BukkitRunnable() {
                                    public void run() {
                                        event.getBlock().setType(Material.RAW_COPPER_BLOCK);
                                    }
                                }).runTaskLater(this.plugin, 200L);
                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu maden için gereken minimum alet gücü: 3"));
                            }
                        }
                        break;
                    case COBBLESTONE:
                        this.levels.giveMiningExp(player, event.getBlock());
                        event.setDropItems(false);
                        event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                        event.setCancelled(true);
                        stone = this.itemHandler.cobblestone;
                        stone.setAmount(1);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), stone);
                        } else {
                            player.getInventory().addItem(stone);
                        }

                        (new BukkitRunnable() {
                            public void run() {
                                event.getBlock().setType(Material.COBBLESTONE);
                            }
                        }).runTaskLater(this.plugin, 200L);
                        break;
                    case TUFF:
                        this.levels.giveMiningExp(player, event.getBlock());
                        event.setDropItems(false);
                        event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                        event.setCancelled(true);
                        stone2 = this.itemHandler.cobblestone;
                        stone2.setAmount(1);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), stone2);
                        } else {
                            player.getInventory().addItem(stone2);
                        }

                        (new BukkitRunnable() {
                            public void run() {
                                event.getBlock().setType(Material.TUFF);
                            }
                        }).runTaskLater(this.plugin, 200L);
                        break;
                    case STONE:
                        this.levels.giveMiningExp(player, event.getBlock());
                        event.setDropItems(false);
                        event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                        event.setCancelled(true);
                        silver9 = this.itemHandler.cobblestone;
                        silver9.setAmount(1);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), silver9);
                        } else {
                            player.getInventory().addItem(silver9);
                        }

                        (new BukkitRunnable() {
                            public void run() {
                                event.getBlock().setType(Material.STONE);
                            }
                        }).runTaskLater(this.plugin, 200L);
                        break;
                    case REDSTONE_ORE:
                        this.levels.giveMiningExp(player, event.getBlock());
                        event.setDropItems(false);
                        event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                        event.setCancelled(true);
                        event.setExpToDrop(2);
                        stoneRED = this.itemHandler.redstone;
                        stoneRED.setAmount(1);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), stoneRED);
                        } else {
                            player.getInventory().addItem(stoneRED);
                        }

                        (new BukkitRunnable() {
                            public void run() {
                                event.getBlock().setType(Material.REDSTONE_ORE);
                            }
                        }).runTaskLater(this.plugin, 200L);
                        break;
                    case LAPIS_ORE:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            digpower = new NamespacedKey(this.plugin, "aletGucu");
                            aletgucu = (Integer)item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 2) {
                                this.levels.giveMiningExp(player, event.getBlock());
                                event.setDropItems(false);
                                event.setExpToDrop(1);
                                event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                                event.setCancelled(true);
                                chanceamount3 = ThreadLocalRandom.current().nextInt(4) + 1;
                                cooal = this.itemHandler.lapis;
                                cooal.setAmount(chanceamount3);
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(player.getLocation(), cooal);
                                } else {
                                    player.getInventory().addItem(cooal);
                                }

                                (new BukkitRunnable() {
                                    public void run() {
                                        event.getBlock().setType(Material.LAPIS_ORE);
                                    }
                                }).runTaskLater(this.plugin, 200L);
                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu maden için gereken minimum alet gücü: 2"));
                            }
                        }
                        break;
                    case OBSIDIAN:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            digpower = new NamespacedKey(this.plugin, "aletGucu");
                            aletgucu = (Integer)item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 5) {
                                this.levels.giveMiningExp(player, event.getBlock());
                                event.setDropItems(false);
                                event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                                event.setCancelled(true);
                                oakwood = this.itemHandler.obsidianore;
                                oakwood.setAmount(1);
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), oakwood);
                                } else {
                                    player.getInventory().addItem(oakwood);
                                }

                                (new BukkitRunnable() {
                                    public void run() {
                                        event.getBlock().setType(Material.OBSIDIAN);
                                    }
                                }).runTaskLater(this.plugin, 200L);
                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu maden için gereken minimum alet gücü: 3"));
                            }
                        }
                        break;
                    case GRAVEL:
                        event.setDropItems(false);
                        chance = ThreadLocalRandom.current().nextInt(10);
                        event.setCancelled(true);
                        event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                        ItemStack gravel;
                        if (chance < 2) {
                            gravel = this.itemHandler.gravel;
                            gravel.setAmount(1);
                            if (player.getInventory().firstEmpty() == -1) {
                                world.dropItemNaturally(event.getBlock().getLocation(), gravel);
                            } else {
                                player.getInventory().addItem(gravel);
                            }
                        } else {
                            gravel = this.itemHandler.gravelblock;
                            gravel.setAmount(1);
                            if (player.getInventory().firstEmpty() == -1) {
                                world.dropItemNaturally(event.getBlock().getLocation(), gravel);
                            } else {
                                player.getInventory().addItem(gravel);
                            }
                        }

                        (new BukkitRunnable() {
                            public void run() {
                                event.getBlock().setType(Material.GRAVEL);
                            }
                        }).runTaskLater(this.plugin, 200L);
                        break;
                    case OAK_LEAVES:
                        event.setDropItems(false);
                        aletgucu = ThreadLocalRandom.current().nextInt(20);
                        event.setCancelled(true);
                        event.getBlock().setType(Material.AIR);
                        if (aletgucu < 2) {
                            if (player.getInventory().firstEmpty() == -1) {
                                oakwood = this.itemHandler.apple;
                                oakwood.setAmount(1);
                                world.dropItemNaturally(event.getBlock().getLocation(), oakwood);
                                this.levels.giveFarmingExp(player, oakwood);
                            } else {
                                oakwood = this.itemHandler.apple;
                                oakwood.setAmount(1);
                                player.getInventory().addItem(oakwood);
                                this.levels.giveFarmingExp(player, oakwood);
                            }
                        }

                        (new BukkitRunnable() {
                            public void run() {
                                event.getBlock().setType(Material.OAK_LEAVES);
                            }
                        }).runTaskLater(this.plugin, 200L);
                        break;
                    case CLAY:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                        event.setCancelled(true);
                        if (player.getInventory().firstEmpty() == -1) {
                            oakwood = this.itemHandler.clay;
                            oakwood.setAmount(1);
                            world.dropItemNaturally(event.getBlock().getLocation(), oakwood);
                        } else {
                            oakwood = this.itemHandler.clay;
                            oakwood.setAmount(1);
                            player.getInventory().addItem(oakwood);
                        }

                        (new BukkitRunnable() {
                            public void run() {
                                event.getBlock().setType(Material.CLAY);
                            }
                        }).runTaskLater(this.plugin, 200L);
                        break;
                    case DIAMOND_ORE:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            digpower = new NamespacedKey(this.plugin, "aletGucu");
                            aletgucu = (Integer)item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 3) {
                                this.levels.giveMiningExp(player, event.getBlock());
                                event.setDropItems(false);
                                event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                                event.setCancelled(true);
                                heavywood = this.itemHandler.diamond;
                                heavywood.setAmount(1);
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), heavywood);
                                } else {
                                    player.getInventory().addItem(heavywood);
                                }

                                (new BukkitRunnable() {
                                    public void run() {
                                        event.getBlock().setType(Material.DIAMOND_ORE);
                                    }
                                }).runTaskLater(this.plugin, 200L);
                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu maden için gereken minimum alet gücü: 4"));
                            }
                        }
                        break;
                    case IRON_ORE:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            digpower = new NamespacedKey(this.plugin, "aletGucu");
                            aletgucu = (Integer)item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 3) {
                                this.levels.giveMiningExp(player, event.getBlock());
                                event.setDropItems(false);
                                event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                                event.setCancelled(true);
                                heavywood = this.itemHandler.ironore;
                                heavywood.setAmount(1);
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), heavywood);
                                } else {
                                    player.getInventory().addItem(heavywood);
                                }

                                (new BukkitRunnable() {
                                    public void run() {
                                        event.getBlock().setType(Material.IRON_ORE);
                                    }
                                }).runTaskLater(this.plugin, 200L);
                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu maden için gereken minimum alet gücü: 4"));
                            }
                        }
                        break;
                    case COAL_ORE:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            digpower = new NamespacedKey(this.plugin, "aletGucu");
                            aletgucu = (Integer)item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 1) {
                                this.levels.giveMiningExp(player, event.getBlock());
                                event.setDropItems(false);
                                event.setExpToDrop(1);
                                event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                                event.setCancelled(true);
                                chanceamount3 = ThreadLocalRandom.current().nextInt(1) + 2;
                                cooal = this.itemHandler.coal;
                                cooal.setAmount(chanceamount3);
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(player.getLocation(), cooal);
                                } else {
                                    player.getInventory().addItem(cooal);
                                }

                                (new BukkitRunnable() {
                                    public void run() {
                                        event.getBlock().setType(Material.COAL_ORE);
                                    }
                                }).runTaskLater(this.plugin, 200L);
                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu maden için gereken minimum alet gücü: 2"));
                            }
                        }
                        break;
                    case SUGAR_CANE:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.AIR);
                        event.setCancelled(true);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), this.itemHandler.sugarcane);
                        } else {
                            player.getInventory().addItem(this.itemHandler.sugarcane);
                        }

                        (new BukkitRunnable() {
                            public void run() {
                                event.getBlock().setType(Material.SUGAR_CANE);
                            }
                        }).runTaskLater(this.plugin, 200L);
                        break;
                    case ALLIUM:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.AIR);
                        event.setCancelled(true);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), this.itemHandler.kezicicek);
                        } else {
                            player.getInventory().addItem(this.itemHandler.kezicicek);
                        }

                        (new BukkitRunnable() {
                            public void run() {
                                event.getBlock().setType(Material.ALLIUM);
                            }
                        }).runTaskLater(this.plugin, 200L);
                        break;
                    case STRIPPED_DARK_OAK_WOOD:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            digpower = new NamespacedKey(this.plugin, "aletGucu");
                            aletgucu = (Integer)item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 5) {
                                this.levels.giveOduncuExp(player, event.getBlock());
                                event.setDropItems(false);
                                event.getBlock().setType(Material.DARK_OAK_PLANKS);
                                event.setCancelled(true);
                                heavywood = this.itemHandler.oldoakwood;
                                heavywood.setAmount(1);
                                if (this.statsManager.getMeslek(player.getUniqueId()).equals("Oduncu")) {
                                    logchance = ThreadLocalRandom.current().nextInt(30);
                                    if (logchance < 5) {
                                        player.sendMessage(Painter.paint("&6Ekstra Odun Düşürdün!"));
                                        if (player.getInventory().firstEmpty() == -1) {
                                            world.dropItemNaturally(event.getBlock().getLocation(), heavywood);
                                        } else {
                                            player.getInventory().addItem(heavywood);
                                        }
                                    }
                                }

                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), heavywood);
                                } else {
                                    player.getInventory().addItem(heavywood);
                                }

                                (new BukkitRunnable() {
                                    public void run() {
                                        event.getBlock().setType(Material.STRIPPED_DARK_OAK_WOOD);
                                    }
                                }).runTaskLater(this.plugin, 400L);
                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu maden için gereken minimum alet gücü: 6"));
                            }
                        }
                        break;
                    case SPRUCE_WOOD:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            digpower = new NamespacedKey(this.plugin, "aletGucu");
                            aletgucu = (Integer)item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 4) {
                                this.levels.giveOduncuExp(player, event.getBlock());
                                event.setDropItems(false);
                                event.getBlock().setType(Material.SPRUCE_PLANKS);
                                event.setCancelled(true);
                                heavywood = this.itemHandler.sprucewood;
                                heavywood.setAmount(1);
                                if (this.statsManager.getMeslek(player.getUniqueId()).equals("Oduncu")) {
                                    logchance = ThreadLocalRandom.current().nextInt(30);
                                    if (logchance < 5) {
                                        player.sendMessage(Painter.paint("&6Ekstra Odun Düşürdün!"));
                                        if (player.getInventory().firstEmpty() == -1) {
                                            world.dropItemNaturally(event.getBlock().getLocation(), heavywood);
                                        } else {
                                            player.getInventory().addItem(heavywood);
                                        }
                                    }
                                }

                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), heavywood);
                                } else {
                                    player.getInventory().addItem(heavywood);
                                }

                                (new BukkitRunnable() {
                                    public void run() {
                                        event.getBlock().setType(Material.SPRUCE_WOOD);
                                    }
                                }).runTaskLater(this.plugin, 200L);
                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu maden için gereken minimum alet gücü: 5"));
                            }
                        }
                        break;
                    case ACACIA_WOOD:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            digpower = new NamespacedKey(this.plugin, "aletGucu");
                            aletgucu = (Integer)item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 6) {
                                this.levels.giveOduncuExp(player, event.getBlock());
                                event.setDropItems(false);
                                event.getBlock().setType(Material.ACACIA_PLANKS);
                                event.setCancelled(true);
                                heavywood = this.itemHandler.acaciawood;
                                heavywood.setAmount(1);
                                if (this.statsManager.getMeslek(player.getUniqueId()).equals("Oduncu")) {
                                    logchance = ThreadLocalRandom.current().nextInt(30);
                                    if (logchance < 5) {
                                        player.sendMessage(Painter.paint("&6Ekstra Odun Düşürdün!"));
                                        if (player.getInventory().firstEmpty() == -1) {
                                            world.dropItemNaturally(event.getBlock().getLocation(), heavywood);
                                        } else {
                                            player.getInventory().addItem(heavywood);
                                        }
                                    }
                                }

                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), heavywood);
                                } else {
                                    player.getInventory().addItem(heavywood);
                                }

                                (new BukkitRunnable() {
                                    public void run() {
                                        event.getBlock().setType(Material.ACACIA_WOOD);
                                    }
                                }).runTaskLater(this.plugin, 200L);
                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu maden için gereken minimum alet gücü: 7"));
                            }
                        }
                        break;
                    case OAK_LOG:
                    case STRIPPED_OAK_WOOD:
                    case JUNGLE_LOG:
                    case CRIMSON_HYPHAE:
                    case ACACIA_LOG:
                    case STRIPPED_ACACIA_WOOD:
                    case BIRCH_LOG:
                    case DARK_OAK_LOG:
                    case SPRUCE_LOG:
                        event.setDropItems(false);
                        event.setCancelled(true);
                        break;
                    case JUNGLE_WOOD:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            digpower = new NamespacedKey(this.plugin, "aletGucu");
                            aletgucu = (Integer)item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 9) {
                                this.levels.giveOduncuExp(player, event.getBlock());
                                event.setDropItems(false);
                                event.setExpToDrop(1);
                                event.getBlock().setType(Material.JUNGLE_PLANKS);
                                event.setCancelled(true);
                                heavywood = this.itemHandler.godwood;
                                heavywood.setAmount(1);
                                if (this.statsManager.getMeslek(player.getUniqueId()).equals("Oduncu")) {
                                    logchance = ThreadLocalRandom.current().nextInt(30);
                                    if (logchance < 5) {
                                        player.sendMessage(Painter.paint("&6Ekstra Odun Düşürdün!"));
                                        if (player.getInventory().firstEmpty() == -1) {
                                            world.dropItemNaturally(event.getBlock().getLocation(), heavywood);
                                        } else {
                                            player.getInventory().addItem(heavywood);
                                        }
                                    }
                                }

                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(player.getLocation(), heavywood);
                                } else {
                                    player.getInventory().addItem(heavywood);
                                }

                                (new BukkitRunnable() {
                                    public void run() {
                                        event.getBlock().setType(Material.JUNGLE_WOOD);
                                    }
                                }).runTaskLater(this.plugin, 250L);
                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu odun için gereken minimum alet gücü: 10"));
                            }
                        }
                        break;
                    case DARK_OAK_WOOD:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            digpower = new NamespacedKey(this.plugin, "aletGucu");
                            aletgucu = (Integer)item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 8) {
                                this.levels.giveOduncuExp(player, event.getBlock());
                                event.setDropItems(false);
                                event.getBlock().setType(Material.DARK_OAK_PLANKS);
                                event.setCancelled(true);
                                heavywood = this.itemHandler.darkoakwood;
                                heavywood.setAmount(1);
                                if (this.statsManager.getMeslek(player.getUniqueId()).equals("Oduncu")) {
                                    logchance = ThreadLocalRandom.current().nextInt(30);
                                    if (logchance < 5) {
                                        player.sendMessage(Painter.paint("&6Ekstra Odun Düşürdün!"));
                                        if (player.getInventory().firstEmpty() == -1) {
                                            world.dropItemNaturally(event.getBlock().getLocation(), heavywood);
                                        } else {
                                            player.getInventory().addItem(heavywood);
                                        }
                                    }
                                }

                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(player.getLocation(), heavywood);
                                } else {
                                    player.getInventory().addItem(heavywood);
                                }

                                (new BukkitRunnable() {
                                    public void run() {
                                        event.getBlock().setType(Material.DARK_OAK_WOOD);
                                    }
                                }).runTaskLater(this.plugin, 250L);
                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu odun için gereken minimum alet gücü: 9"));
                            }
                        }
                        break;
                    case WARPED_HYPHAE:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            if (MaterialTags.AXES.isTagged(item)) {
                                digpower = new NamespacedKey(this.plugin, "aletGucu");
                                aletgucu = (Integer)item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                                if (aletgucu > 5) {
                                    this.levels.giveOduncuExp(player, event.getBlock());
                                    event.setDropItems(false);
                                    event.getBlock().setType(Material.WARPED_PLANKS);
                                    event.setCancelled(true);
                                    heavywood = this.itemHandler.heavywood;
                                    heavywood.setAmount(1);
                                    if (this.statsManager.getMeslek(player.getUniqueId()).equals("Oduncu")) {
                                        logchance = ThreadLocalRandom.current().nextInt(30);
                                        if (logchance < 5) {
                                            player.sendMessage(Painter.paint("&6Ekstra Odun Düşürdün!"));
                                            if (player.getInventory().firstEmpty() == -1) {
                                                world.dropItemNaturally(event.getBlock().getLocation(), heavywood);
                                            } else {
                                                player.getInventory().addItem(heavywood);
                                            }
                                        }
                                    }

                                    if (player.getInventory().firstEmpty() == -1) {
                                        world.dropItemNaturally(event.getBlock().getLocation(), heavywood);
                                    } else {
                                        player.getInventory().addItem(heavywood);
                                    }

                                    (new BukkitRunnable() {
                                        public void run() {
                                            event.getBlock().setType(Material.WARPED_HYPHAE);
                                        }
                                    }).runTaskLater(this.plugin, 200L);
                                } else {
                                    event.setCancelled(true);
                                    player.sendMessage(Painter.paint("&6Bu maden için gereken minimum alet gücü: 6"));
                                }
                            }
                        } else {
                            event.setCancelled(true);
                        }
                        break;
                    case OAK_WOOD:
                        this.levels.giveOduncuExp(player, event.getBlock());
                        event.setDropItems(false);
                        event.getBlock().setType(Material.OAK_PLANKS);
                        event.setCancelled(true);
                        oakwood = this.itemHandler.oakwood;
                        oakwood.setAmount(1);
                        if (this.statsManager.getMeslek(player.getUniqueId()).equals("Oduncu")) {
                            aletgucu = ThreadLocalRandom.current().nextInt(30);
                            if (aletgucu < 5) {
                                player.sendMessage(Painter.paint("&6Ekstra Odun Düşürdün!"));
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), oakwood);
                                } else {
                                    player.getInventory().addItem(oakwood);
                                }
                            }
                        }

                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), oakwood);
                        } else {
                            player.getInventory().addItem(oakwood);
                        }

                        (new BukkitRunnable() {
                            public void run() {
                                event.getBlock().setType(Material.OAK_WOOD);
                            }
                        }).runTaskLater(this.plugin, 200L);
                        break;
                    case CALCITE:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                        event.setCancelled(true);
                        event.setExpToDrop(1);
                        cooal = this.itemHandler.salt;
                        cooal.setAmount(1);
                        this.levels.giveMiningExp(player, event.getBlock());
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), cooal);
                        } else {
                            player.getInventory().addItem(cooal);
                        }

                        (new BukkitRunnable() {
                            public void run() {
                                event.getBlock().setType(Material.CALCITE);
                            }
                        }).runTaskLater(this.plugin, 200L);
                }
            }
        }

    }

    @EventHandler
    public void blockplace(HangingBreakByEntityEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof Player player) {
            if (!player.isOp() && (player.getWorld().getName().equalsIgnoreCase("world") || player.getWorld().getName().equalsIgnoreCase("dungeonworld"))) {
                event.setCancelled(true);
            }

        }
    }
}
