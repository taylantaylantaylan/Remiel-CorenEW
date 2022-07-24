package me.taylan.mooncore.listeners;

import com.destroystokyo.paper.MaterialTags;
import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.level.ExpList;
import me.taylan.mooncore.level.Levels;
import me.taylan.mooncore.utils.ItemHandler;
import me.taylan.mooncore.utils.Painter;
import me.taylan.mooncore.utils.StatsManager;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;

import javax.sound.midi.MetaEventListener;
import java.util.concurrent.ThreadLocalRandom;

public class BlockRegenListener implements Listener {
    private MoonCore plugin;
    private ItemHandler itemHandler;
    private StatsManager statsManager;
    private Levels levels;


    public BlockRegenListener(MoonCore plugin) {
        this.plugin = plugin;
        this.itemHandler = plugin.getItemHandler();
        this.levels = plugin.getLevels();
        this.statsManager = plugin.getStatsManager();
        plugin.getServer().getPluginManager().registerEvents(this, plugin);

    }

    @EventHandler
    public void blockbreak(BlockBreakEvent event) {
        Player player = event.getPlayer();

        if (!player.hasPermission("mooncore.break")) {
            Material blocktype = event.getBlock().getType();
            World world = player.getWorld();
            ItemStack item = player.getInventory().getItemInMainHand();
            if (player.getWorld().getName().equals("world") || player.getWorld().getName().equals("dungeonworld") || player.getWorld().getName().equals("remielsurvival")) {
                if (!(Tag.LOGS.isTagged(blocktype) || (Tag.COAL_ORES.isTagged(blocktype) ||
                        (Tag.IRON_ORES.isTagged(blocktype)) || (Tag.DIAMOND_ORES.isTagged(blocktype)) || (Tag.LAPIS_ORES.isTagged(blocktype)) ||
                        (Tag.REDSTONE_ORES.isTagged(blocktype)) || (Tag.COPPER_ORES.isTagged(blocktype)) || (Tag.GOLD_ORES.isTagged(blocktype)) || blocktype == Material.OBSIDIAN || blocktype == Material.CLAY || blocktype == Material.RAW_COPPER_BLOCK || blocktype == Material.RAW_IRON_BLOCK || blocktype == Material.GRAVEL
                ))) {
                    event.setCancelled(true);
                }

                switch (blocktype) {
                    case RAW_IRON_BLOCK:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            NamespacedKey digpower = new NamespacedKey(plugin, "aletGucu");
                            int aletgucu = item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 5) {
                                event.setDropItems(false);
                                event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                                event.setCancelled(true);
                                ItemStack silver = itemHandler.silverore;
                                silver.setAmount(1);
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(),silver);

                                } else {
                                    player.getInventory().addItem(silver);
                                }
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        event.getBlock().setType(Material.RAW_IRON_BLOCK);
                                    }
                                }.runTaskLater(plugin, 200);
                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu maden için gereken minimum alet gücü: 6"));
                            }
                        }

                        break;
                    case COPPER_ORE:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            NamespacedKey digpower = new NamespacedKey(plugin, "aletGucu");
                            int aletgucu = item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 1) {
                                event.setDropItems(false);
                                event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                                event.setCancelled(true);
                                ItemStack silver = itemHandler.copperore;
                                silver.setAmount(1);
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), silver);

                                } else {
                                    player.getInventory().addItem(silver);
                                }
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        event.getBlock().setType(Material.COPPER_ORE);
                                    }
                                }.runTaskLater(plugin, 200);
                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu maden için gereken minimum alet gücü: 2"));
                            }
                        }

                        break;
                    case SHROOMLIGHT:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.BEDROCK);
                        event.setCancelled(true);
                        ItemStack silver1 = itemHandler.glowstone;
                        silver1.setAmount(1);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), silver1);

                        } else {
                            player.getInventory().addItem(silver1);
                        }
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                event.getBlock().setType(Material.SHROOMLIGHT);
                            }
                        }.runTaskLater(plugin, 200);
                        break;
                    case CACTUS:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.AIR);
                        event.setCancelled(true);
                        ItemStack silver2 = itemHandler.cactus;
                        silver2.setAmount(1);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), silver2);

                        } else {
                            player.getInventory().addItem(silver2);
                        }
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                event.getBlock().setType(Material.CACTUS);
                            }
                        }.runTaskLater(plugin, 250);
                        break;
                    case TERRACOTTA:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.BEDROCK);
                        event.setCancelled(true);
                        ItemStack silver3 = itemHandler.terracotta;
                        silver3.setAmount(1);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), silver3);

                        } else {
                            player.getInventory().addItem(itemHandler.terracotta);
                        }
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                event.getBlock().setType(Material.TERRACOTTA);
                            }
                        }.runTaskLater(plugin, 200);
                        break;
                    case LARGE_FERN:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.AIR);
                        event.setCancelled(true);
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                event.getBlock().setType(Material.LARGE_FERN);
                            }
                        }.runTaskLater(plugin, 800);
                        break;
                    case FERN:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.AIR);
                        event.setCancelled(true);
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                event.getBlock().setType(Material.FERN);
                            }
                        }.runTaskLater(plugin, 800);
                        break;
                    case GRASS:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.AIR);
                        event.setCancelled(true);
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                event.getBlock().setType(Material.GRASS);
                            }
                        }.runTaskLater(plugin, 800);
                        break;
                    case TALL_GRASS:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.AIR);
                        event.setCancelled(true);
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                event.getBlock().setType(Material.TALL_GRASS);
                            }
                        }.runTaskLater(plugin, 800);
                        break;
                    case WHITE_TERRACOTTA:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.BEDROCK);
                        event.setCancelled(true);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.whiteterracotta);

                        } else {
                            player.getInventory().addItem(itemHandler.whiteterracotta);
                        }
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                event.getBlock().setType(Material.WHITE_TERRACOTTA);
                            }
                        }.runTaskLater(plugin, 200);
                        break;
                    case YELLOW_TERRACOTTA:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.BEDROCK);
                        event.setCancelled(true);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.yellowterracotta);

                        } else {
                            player.getInventory().addItem(itemHandler.yellowterracotta);
                        }
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                event.getBlock().setType(Material.YELLOW_TERRACOTTA);
                            }
                        }.runTaskLater(plugin, 200);
                        break;
                    case ORANGE_TERRACOTTA:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.BEDROCK);
                        event.setCancelled(true);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.orangeterracotta);

                        } else {
                            player.getInventory().addItem(itemHandler.orangeterracotta);
                        }
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                event.getBlock().setType(Material.ORANGE_TERRACOTTA);
                            }
                        }.runTaskLater(plugin, 200);
                        break;
                    case LIGHT_GRAY_TERRACOTTA:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.BEDROCK);
                        event.setCancelled(true);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.grayterracotta);

                        } else {
                            player.getInventory().addItem(itemHandler.grayterracotta);
                        }
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                event.getBlock().setType(Material.LIGHT_GRAY_TERRACOTTA);
                            }
                        }.runTaskLater(plugin, 200);
                        break;
                    case SAND:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.BEDROCK);
                        event.setCancelled(true);
                        ItemStack silver4 = itemHandler.sand;
                        silver4.setAmount(1);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), silver4);

                        } else {
                            player.getInventory().addItem(silver4);
                        }
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                event.getBlock().setType(Material.SAND);
                            }
                        }.runTaskLater(plugin, 200);
                        break;
                    case RED_SAND:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.BEDROCK);
                        event.setCancelled(true);
                        ItemStack silver5 = itemHandler.redsand;
                        silver5.setAmount(1);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), silver5);

                        } else {
                            player.getInventory().addItem(silver5);
                        }
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                event.getBlock().setType(Material.RED_SAND);
                            }
                        }.runTaskLater(plugin, 200);
                        break;
                    case GOLD_ORE:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            NamespacedKey digpower = new NamespacedKey(plugin, "aletGucu");
                            int aletgucu = item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 4) {
                                event.setDropItems(false);
                                event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                                event.setCancelled(true);
                                ItemStack silver6 = itemHandler.goldore;
                                silver6.setAmount(1);
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), silver6);

                                } else {
                                    player.getInventory().addItem(silver6);
                                }
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        event.getBlock().setType(Material.GOLD_ORE);
                                    }
                                }.runTaskLater(plugin, 200);
                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu maden için gereken minimum alet gücü: 5"));
                            }
                        }
                        break;
                    case DEEPSLATE_DIAMOND_ORE:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            NamespacedKey digpower = new NamespacedKey(plugin, "aletGucu");
                            int aletgucu = item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 8) {
                                event.setDropItems(false);
                                event.getBlock().setType(Material.BEDROCK);
                                event.setCancelled(true);
                                ItemStack silver7 = itemHandler.adamantiumore;
                                silver7.setAmount(1);
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), silver7);

                                } else {
                                    player.getInventory().addItem(silver7);
                                }
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        event.getBlock().setType(Material.DEEPSLATE_DIAMOND_ORE);
                                    }
                                }.runTaskLater(plugin, 200);
                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu maden için gereken minimum alet gücü: 9"));
                            }
                        }
                        break;
                    case DEEPSLATE_REDSTONE_ORE:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            NamespacedKey digpower = new NamespacedKey(plugin, "aletGucu");
                            int aletgucu = item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 7) {
                                event.setDropItems(false);
                                event.getBlock().setType(Material.BEDROCK);
                                event.setCancelled(true);
                                ItemStack silver12 = itemHandler.crimsonore;
                                silver12.setAmount(1);
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), silver12);

                                } else {
                                    player.getInventory().addItem(silver12);
                                }
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        event.getBlock().setType(Material.DEEPSLATE_REDSTONE_ORE);
                                    }
                                }.runTaskLater(plugin, 200);
                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu maden için gereken minimum alet gücü: 8"));
                            }
                        }
                        break;

                    case RAW_COPPER_BLOCK:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            NamespacedKey digpower = new NamespacedKey(plugin, "aletGucu");
                            int aletgucu = item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 2) {
                                event.setDropItems(false);
                                event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                                event.setCancelled(true);
                                ItemStack silver9 = itemHandler.nikelore;
                                silver9.setAmount(1);
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), silver9);

                                } else {
                                    player.getInventory().addItem(silver9);
                                }
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        event.getBlock().setType(Material.RAW_COPPER_BLOCK);
                                    }
                                }.runTaskLater(plugin, 200);
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
                        ItemStack stone = itemHandler.cobblestone;
                        stone.setAmount(1);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), stone);

                        } else {
                            player.getInventory().addItem(stone);
                        }
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                event.getBlock().setType(Material.COBBLESTONE);
                            }
                        }.runTaskLater(plugin, 200);
                        break;

                    case TUFF:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                        event.setCancelled(true);
                        ItemStack stone2 = itemHandler.cobblestone;
                        stone2.setAmount(1);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), stone2);

                        } else {
                            player.getInventory().addItem(stone2);
                        }
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                event.getBlock().setType(Material.TUFF);
                            }
                        }.runTaskLater(plugin, 200);
                        break;

                    case STONE:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                        event.setCancelled(true);
                        ItemStack stone1 = itemHandler.cobblestone;
                        stone1.setAmount(1);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), stone1);

                        } else {
                            player.getInventory().addItem(stone1);
                        }
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                event.getBlock().setType(Material.STONE);
                            }
                        }.runTaskLater(plugin, 200);
                        break;

                    case REDSTONE_ORE:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                        event.setCancelled(true);
                        event.setExpToDrop(2);
                        ItemStack stoneRED = itemHandler.redstone;
                        stoneRED.setAmount(1);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), stoneRED);

                        } else {
                            player.getInventory().addItem(stoneRED);
                        }
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                event.getBlock().setType(Material.REDSTONE_ORE);
                            }
                        }.runTaskLater(plugin, 200);
                        break;
                    case LAPIS_ORE:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            NamespacedKey digpower = new NamespacedKey(plugin, "aletGucu");
                            int aletgucu = item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 2) {
                                event.setDropItems(false);
                                event.setExpToDrop(1);
                                event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                                event.setCancelled(true);
                                int chanceamount3 = ThreadLocalRandom.current().nextInt(4) + 1;
                                ItemStack cooal = itemHandler.lapis;
                                cooal.setAmount(chanceamount3);
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(player.getLocation(), cooal);

                                } else {
                                    player.getInventory().addItem(cooal);
                                }


                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        event.getBlock().setType(Material.LAPIS_ORE);
                                    }
                                }.runTaskLater(plugin, 200);
                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu maden için gereken minimum alet gücü: 2"));
                            }
                        }
                        break;
                    case OBSIDIAN:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            NamespacedKey digpower = new NamespacedKey(plugin, "aletGucu");
                            int aletgucu = item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 5) {
                                event.setDropItems(false);
                                event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                                event.setCancelled(true);
                                ItemStack obsidianore2 = itemHandler.obsidianore;
                                obsidianore2.setAmount(1);
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), obsidianore2);

                                } else {
                                    player.getInventory().addItem(obsidianore2);
                                }
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        event.getBlock().setType(Material.OBSIDIAN);
                                    }
                                }.runTaskLater(plugin, 200);
                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu maden için gereken minimum alet gücü: 3"));
                            }
                        }
                        break;
                    case GRAVEL:
                        event.setDropItems(false);
                        int chance = ThreadLocalRandom.current().nextInt(10);
                        event.setCancelled(true);
                        event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                        if (chance < 2) {
                            if (player.getInventory().firstEmpty() == -1) {
                                world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.gravel);

                            } else {
                                player.getInventory().addItem(itemHandler.gravel);
                            }
                        } else {

                            if (player.getInventory().firstEmpty() == -1) {
                                world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.gravelblock);

                            } else {
                                player.getInventory().addItem(itemHandler.gravelblock);
                            }
                        }
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                event.getBlock().setType(Material.GRAVEL);
                            }
                        }.runTaskLater(plugin, 200);
                        break;
                    case OAK_LEAVES:
                        event.setDropItems(false);
                        int chance2 = ThreadLocalRandom.current().nextInt(20);
                        event.setCancelled(true);
                        event.getBlock().setType(Material.AIR);
                        if (chance2 < 2) {
                            if (player.getInventory().firstEmpty() == -1) {
                                ItemStack aple = itemHandler.apple;
                                aple.setAmount(1);
                                world.dropItemNaturally(event.getBlock().getLocation(), aple);
                               levels.giveFarmingExp(player,aple);

                            } else {
                                ItemStack aple2 = itemHandler.apple;
                                aple2.setAmount(1);
                                player.getInventory().addItem(aple2);
                                levels.giveFarmingExp(player,aple2);
                            }
                        }
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                event.getBlock().setType(Material.OAK_LEAVES);
                            }
                        }.runTaskLater(plugin, 200);
                        break;
                    case CLAY:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                        event.setCancelled(true);
                        if (player.getInventory().firstEmpty() == -1) {
                            ItemStack clay = itemHandler.clay;
                            clay.setAmount(1);
                            world.dropItemNaturally(event.getBlock().getLocation(), clay);

                        } else {
                            ItemStack clay = itemHandler.clay;
                            clay.setAmount(1);
                            player.getInventory().addItem(clay);
                        }
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                event.getBlock().setType(Material.CLAY);
                            }
                        }.runTaskLater(plugin, 200);
                        break;
                    case DIAMOND_ORE:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            NamespacedKey digpower = new NamespacedKey(plugin, "aletGucu");
                            int aletgucu = item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 3) {
                                event.setDropItems(false);
                                event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                                event.setCancelled(true);
                                ItemStack diamond = itemHandler.diamond;
                                diamond.setAmount(1);
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), diamond);

                                } else {
                                    player.getInventory().addItem(diamond);
                                }
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        event.getBlock().setType(Material.DIAMOND_ORE);
                                    }
                                }.runTaskLater(plugin, 200);
                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu maden için gereken minimum alet gücü: 4"));
                            }
                        }
                        break;
                    case IRON_ORE:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            NamespacedKey digpower = new NamespacedKey(plugin, "aletGucu");
                            int aletgucu = item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 3) {
                                event.setDropItems(false);
                                event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                                event.setCancelled(true);
                                ItemStack ironore = itemHandler.ironore;
                                ironore.setAmount(1);
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), ironore);

                                } else {
                                    player.getInventory().addItem(ironore);
                                }
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        event.getBlock().setType(Material.IRON_ORE);
                                    }
                                }.runTaskLater(plugin, 200);
                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu maden için gereken minimum alet gücü: 4"));
                            }
                        }
                        break;
                    case COAL_ORE:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            NamespacedKey digpower = new NamespacedKey(plugin, "aletGucu");
                            int aletgucu = item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 1) {
                                event.setDropItems(false);
                                event.setExpToDrop(1);
                                event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                                event.setCancelled(true);
                                int chanceamount3 = ThreadLocalRandom.current().nextInt(1) + 2;
                                ItemStack cooal = itemHandler.coal;
                                cooal.setAmount(chanceamount3);
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(player.getLocation(), cooal);

                                } else {
                                    player.getInventory().addItem(cooal);
                                }


                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        event.getBlock().setType(Material.COAL_ORE);
                                    }
                                }.runTaskLater(plugin, 200);
                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu maden için gereken minimum alet gücü: 2"));
                            }
                        }
                        break;
                    case ALLIUM:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.AIR);
                        event.setCancelled(true);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.kezicicek);

                        } else {
                            player.getInventory().addItem(itemHandler.kezicicek);
                        }
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                event.getBlock().setType(Material.ALLIUM);
                            }
                        }.runTaskLater(plugin, 200);
                        break;
                    case STRIPPED_DARK_OAK_WOOD:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            NamespacedKey digpower = new NamespacedKey(plugin, "aletGucu");
                            int aletgucu = item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 5) {
                                event.setDropItems(false);
                                event.getBlock().setType(Material.AIR);
                                event.setCancelled(true);
                                ItemStack silver = itemHandler.oldoakwood;
                                silver.setAmount(1);
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(),silver);

                                } else {
                                    player.getInventory().addItem(silver);
                                }
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        event.getBlock().setType(Material.STRIPPED_DARK_OAK_WOOD);
                                    }
                                }.runTaskLater(plugin, 400);
                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu maden için gereken minimum alet gücü: 6"));
                            }
                        }

                        break;

                    case SPRUCE_WOOD:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            NamespacedKey digpower = new NamespacedKey(plugin, "aletGucu");
                            int aletgucu = item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 4) {
                                event.setDropItems(false);
                                event.getBlock().setType(Material.AIR);
                                event.setCancelled(true);
                                ItemStack silver = itemHandler.sprucewood;
                                silver.setAmount(1);
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(),silver);

                                } else {
                                    player.getInventory().addItem(silver);
                                }
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        event.getBlock().setType(Material.SPRUCE_WOOD);
                                    }
                                }.runTaskLater(plugin, 200);
                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu maden için gereken minimum alet gücü: 5"));
                            }
                        }

                        break;
                    case ACACIA_WOOD:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            NamespacedKey digpower = new NamespacedKey(plugin, "aletGucu");
                            int aletgucu = item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 6) {
                                event.setDropItems(false);
                                event.getBlock().setType(Material.AIR);
                                event.setCancelled(true);
                                ItemStack silver = itemHandler.acaciawood;
                                silver.setAmount(1);
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(),silver);

                                } else {
                                    player.getInventory().addItem(silver);
                                }
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        event.getBlock().setType(Material.ACACIA_WOOD);
                                    }
                                }.runTaskLater(plugin, 200);
                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu maden için gereken minimum alet gücü: 7"));
                            }
                        }

                        break;

                    case OAK_LOG:
                        event.setDropItems(false);
                        event.setCancelled(true);
                        break;
                    case SPRUCE_LOG:
                        event.setDropItems(false);
                        event.setCancelled(true);
                        break;
                    case DARK_OAK_LOG:
                        event.setDropItems(false);
                        event.setCancelled(true);
                        break;
                    case BIRCH_LOG:
                        event.setDropItems(false);
                        event.setCancelled(true);
                        break;
                    case JUNGLE_LOG:
                        event.setDropItems(false);
                        event.setCancelled(true);
                        break;
                    case CRIMSON_HYPHAE:
                        event.setDropItems(false);
                        event.setCancelled(true);
                        break;
                    case ACACIA_LOG:
                        event.setDropItems(false);
                        event.setCancelled(true);
                        break;
                    case JUNGLE_WOOD:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            NamespacedKey digpower = new NamespacedKey(plugin, "aletGucu");
                            int aletgucu = item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 9) {
                                event.setDropItems(false);
                                event.setExpToDrop(1);
                                event.getBlock().setType(Material.AIR);
                                event.setCancelled(true);
                                ItemStack godwood = itemHandler.godwood;
                                godwood.setAmount(1);
                                if (statsManager.getMeslek(player.getUniqueId()).equals("Oduncu")) {
                                    int logchance = ThreadLocalRandom.current().nextInt(30);
                                    if(logchance<5) {
                                        player.sendMessage(Painter.paint("&6Ekstra Odun Düşürdün!"));
                                        if (player.getInventory().firstEmpty() == -1) {
                                            world.dropItemNaturally(event.getBlock().getLocation(), godwood);

                                        } else {
                                            player.getInventory().addItem(godwood);

                                        }
                                    }
                                }
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(player.getLocation(), godwood);

                                } else {
                                    player.getInventory().addItem(godwood);
                                }


                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        event.getBlock().setType(Material.JUNGLE_WOOD);
                                    }
                                }.runTaskLater(plugin, 250);
                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu odun için gereken minimum alet gücü: 10"));
                            }
                        }
                        break;

                    case DARK_OAK_WOOD:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            NamespacedKey digpower = new NamespacedKey(plugin, "aletGucu");
                            int aletgucu = item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 8) {
                                event.setDropItems(false);
                                event.getBlock().setType(Material.AIR);
                                event.setCancelled(true);
                                ItemStack darkoakwood = itemHandler.darkoakwood;
                                darkoakwood.setAmount(1);
                                if (statsManager.getMeslek(player.getUniqueId()).equals("Oduncu")) {
                                    int logchance = ThreadLocalRandom.current().nextInt(30);
                                    if(logchance<5) {
                                        player.sendMessage(Painter.paint("&6Ekstra Odun Düşürdün!"));
                                        if (player.getInventory().firstEmpty() == -1) {
                                            world.dropItemNaturally(event.getBlock().getLocation(), darkoakwood);

                                        } else {
                                            player.getInventory().addItem(darkoakwood);

                                        }
                                    }
                                }
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(player.getLocation(), darkoakwood);

                                } else {
                                    player.getInventory().addItem(darkoakwood);
                                }


                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        event.getBlock().setType(Material.DARK_OAK_WOOD);
                                    }
                                }.runTaskLater(plugin, 250);
                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu odun için gereken minimum alet gücü: 9"));
                            }
                        }
                        break;

                    case ANCIENT_DEBRIS:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            if (MaterialTags.AXES.isTagged(item)) {
                                NamespacedKey digpower = new NamespacedKey(plugin, "aletGucu");
                                int aletgucu = item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                                if (aletgucu > 5) {
                                    event.setDropItems(false);
                                    event.getBlock().setType(Material.BEDROCK);
                                    event.setCancelled(true);
                                    ItemStack heavywood = itemHandler.heavywood;
                                    heavywood.setAmount(1);
                                    if (player.getInventory().firstEmpty() == -1) {
                                        world.dropItemNaturally(event.getBlock().getLocation(), heavywood);

                                    } else {
                                        player.getInventory().addItem(heavywood);
                                    }
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            event.getBlock().setType(Material.ANCIENT_DEBRIS);
                                        }
                                    }.runTaskLater(plugin, 200);
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
                        ItemStack oakwood = itemHandler.oakwood;
                        oakwood.setAmount(1);
                        if (statsManager.getMeslek(player.getUniqueId()).equals("Oduncu")) {
                            int logchance = ThreadLocalRandom.current().nextInt(30);
                            if(logchance<5) {
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
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                event.getBlock().setType(Material.OAK_WOOD);
                            }
                        }.runTaskLater(plugin, 200);
                        break;
                    case CALCITE:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                        event.setCancelled(true);
                        event.setExpToDrop(1);
                        ItemStack salt = itemHandler.salt;
                        salt.setAmount(1);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(),salt);

                        } else {
                            player.getInventory().addItem(salt);
                        }
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                event.getBlock().setType(Material.CALCITE);
                            }
                        }.runTaskLater(plugin, 200);
                        break;
                }

            } else {
                switch (blocktype) {
                    case RAW_IRON_BLOCK:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            NamespacedKey digpower = new NamespacedKey(plugin, "aletGucu");
                            int aletgucu = item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 5) {
                                event.setDropItems(false);
                                event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                                event.setCancelled(true);
                                ItemStack silver = itemHandler.silverore;
                                silver.setAmount(1);
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(),silver);

                                } else {
                                    player.getInventory().addItem(silver);
                                }

                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu maden için gereken minimum alet gücü: 6"));
                            }
                        }

                        break;
                    case COPPER_ORE:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            NamespacedKey digpower = new NamespacedKey(plugin, "aletGucu");
                            int aletgucu = item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 1) {
                                event.setDropItems(false);
                                event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                                event.setCancelled(true);
                                ItemStack silver = itemHandler.copperore;
                                silver.setAmount(1);
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), silver);

                                } else {
                                    player.getInventory().addItem(silver);
                                }

                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu maden için gereken minimum alet gücü: 2"));
                            }
                        }

                        break;
                    case SHROOMLIGHT:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.BEDROCK);
                        event.setCancelled(true);
                        ItemStack silver1 = itemHandler.glowstone;
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
                        ItemStack silver2 = itemHandler.cactus;
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
                        ItemStack silver3 = itemHandler.terracotta;
                        silver3.setAmount(1);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), silver3);

                        } else {
                            player.getInventory().addItem(itemHandler.terracotta);
                        }
                        break;
                    case LARGE_FERN:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.AIR);
                        event.setCancelled(true);
                        break;
                    case FERN:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.AIR);
                        event.setCancelled(true);

                        break;
                    case GRASS:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.AIR);
                        event.setCancelled(true);

                        break;
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
                            world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.whiteterracotta);

                        } else {
                            player.getInventory().addItem(itemHandler.whiteterracotta);
                        }

                        break;
                    case YELLOW_TERRACOTTA:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.BEDROCK);
                        event.setCancelled(true);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.yellowterracotta);

                        } else {
                            player.getInventory().addItem(itemHandler.yellowterracotta);
                        }

                        break;
                    case ORANGE_TERRACOTTA:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.BEDROCK);
                        event.setCancelled(true);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.orangeterracotta);

                        } else {
                            player.getInventory().addItem(itemHandler.orangeterracotta);
                        }

                        break;
                    case LIGHT_GRAY_TERRACOTTA:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.BEDROCK);
                        event.setCancelled(true);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.grayterracotta);

                        } else {
                            player.getInventory().addItem(itemHandler.grayterracotta);
                        }

                        break;
                    case SAND:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.BEDROCK);
                        event.setCancelled(true);
                        ItemStack silver4 = itemHandler.sand;
                        silver4.setAmount(1);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), silver4);

                        } else {
                            player.getInventory().addItem(silver4);
                        }
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                event.getBlock().setType(Material.SAND);
                            }
                        }.runTaskLater(plugin, 200);
                        break;
                    case RED_SAND:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.BEDROCK);
                        event.setCancelled(true);
                        ItemStack silver5 = itemHandler.redsand;
                        silver5.setAmount(1);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), silver5);

                        } else {
                            player.getInventory().addItem(silver5);
                        }
                        break;
                    case GOLD_ORE:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            NamespacedKey digpower = new NamespacedKey(plugin, "aletGucu");
                            int aletgucu = item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 4) {
                                event.setDropItems(false);
                                event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                                event.setCancelled(true);
                                ItemStack silver6 = itemHandler.goldore;
                                silver6.setAmount(1);
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), silver6);

                                } else {
                                    player.getInventory().addItem(silver6);
                                }
                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu maden için gereken minimum alet gücü: 5"));
                            }
                        }
                        break;
                    case DEEPSLATE_DIAMOND_ORE:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            NamespacedKey digpower = new NamespacedKey(plugin, "aletGucu");
                            int aletgucu = item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 8) {
                                event.setDropItems(false);
                                event.getBlock().setType(Material.BEDROCK);
                                event.setCancelled(true);
                                ItemStack silver7 = itemHandler.adamantiumore;
                                silver7.setAmount(1);
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), silver7);

                                } else {
                                    player.getInventory().addItem(silver7);
                                }

                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu maden için gereken minimum alet gücü: 9"));
                            }
                        }
                        break;
                    case DEEPSLATE_REDSTONE_ORE:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            NamespacedKey digpower = new NamespacedKey(plugin, "aletGucu");
                            int aletgucu = item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 7) {
                                event.setDropItems(false);
                                event.getBlock().setType(Material.BEDROCK);
                                event.setCancelled(true);
                                ItemStack silver12 = itemHandler.crimsonore;
                                silver12.setAmount(1);
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), silver12);

                                } else {
                                    player.getInventory().addItem(silver12);
                                }
                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu maden için gereken minimum alet gücü: 8"));
                            }
                        }
                        break;

                    case RAW_COPPER_BLOCK:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            NamespacedKey digpower = new NamespacedKey(plugin, "aletGucu");
                            int aletgucu = item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 2) {
                                event.setDropItems(false);
                                event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                                event.setCancelled(true);
                                ItemStack silver9 = itemHandler.nikelore;
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
                        ItemStack stone = itemHandler.cobblestone;
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
                        ItemStack stone2 = itemHandler.cobblestone;
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
                        ItemStack stone1 = itemHandler.cobblestone;
                        stone1.setAmount(1);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), stone1);

                        } else {
                            player.getInventory().addItem(stone1);
                        }

                        break;

                    case REDSTONE_ORE:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                        event.setCancelled(true);
                        event.setExpToDrop(2);
                        ItemStack stoneRED = itemHandler.redstone;
                        stoneRED.setAmount(1);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), stoneRED);

                        } else {
                            player.getInventory().addItem(stoneRED);
                        }

                        break;
                    case LAPIS_ORE:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            NamespacedKey digpower = new NamespacedKey(plugin, "aletGucu");
                            int aletgucu = item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 2) {
                                event.setDropItems(false);
                                event.setExpToDrop(1);
                                event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                                event.setCancelled(true);
                                int chanceamount3 = ThreadLocalRandom.current().nextInt(4) + 1;
                                ItemStack cooal = itemHandler.lapis;
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
                        break;
                    case OBSIDIAN:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            NamespacedKey digpower = new NamespacedKey(plugin, "aletGucu");
                            int aletgucu = item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 5) {
                                event.setDropItems(false);
                                event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                                event.setCancelled(true);
                                ItemStack obsidianore2 = itemHandler.obsidianore;
                                obsidianore2.setAmount(1);
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), obsidianore2);

                                } else {
                                    player.getInventory().addItem(obsidianore2);
                                }

                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu maden için gereken minimum alet gücü: 3"));
                            }
                        }
                        break;
                    case GRAVEL:
                        event.setDropItems(false);
                        int chance = ThreadLocalRandom.current().nextInt(10);
                        event.setCancelled(true);
                        event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                        if (chance < 2) {
                            if (player.getInventory().firstEmpty() == -1) {
                                world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.gravel);

                            } else {
                                player.getInventory().addItem(itemHandler.gravel);
                            }
                        } else {

                            if (player.getInventory().firstEmpty() == -1) {
                                world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.gravelblock);

                            } else {
                                player.getInventory().addItem(itemHandler.gravelblock);
                            }
                        }

                        break;
                    case OAK_LEAVES:
                        event.setDropItems(false);
                        int chance2 = ThreadLocalRandom.current().nextInt(20);
                        event.setCancelled(true);
                        event.getBlock().setType(Material.AIR);
                        if (chance2 < 2) {
                            if (player.getInventory().firstEmpty() == -1) {
                                ItemStack aple = itemHandler.apple;
                                aple.setAmount(1);
                                world.dropItemNaturally(event.getBlock().getLocation(), aple);
                                levels.giveFarmingExp(player,aple);

                            } else {
                                ItemStack aple2 = itemHandler.apple;
                                aple2.setAmount(1);
                                player.getInventory().addItem(aple2);
                                levels.giveFarmingExp(player,aple2);
                            }
                        }

                        break;
                    case CLAY:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                        event.setCancelled(true);
                        if (player.getInventory().firstEmpty() == -1) {
                            ItemStack clay = itemHandler.clay;
                            clay.setAmount(1);
                            world.dropItemNaturally(event.getBlock().getLocation(), clay);

                        } else {
                            ItemStack clay = itemHandler.clay;
                            clay.setAmount(1);
                            player.getInventory().addItem(clay);
                        }
                        break;
                    case DIAMOND_ORE:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            NamespacedKey digpower = new NamespacedKey(plugin, "aletGucu");
                            int aletgucu = item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 3) {
                                event.setDropItems(false);
                                event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                                event.setCancelled(true);
                                ItemStack diamond = itemHandler.diamond;
                                diamond.setAmount(1);
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), diamond);

                                } else {
                                    player.getInventory().addItem(diamond);
                                }
                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu maden için gereken minimum alet gücü: 4"));
                            }
                        }
                        break;
                    case IRON_ORE:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            NamespacedKey digpower = new NamespacedKey(plugin, "aletGucu");
                            int aletgucu = item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 3) {
                                event.setDropItems(false);
                                event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                                event.setCancelled(true);
                                ItemStack ironore = itemHandler.ironore;
                                ironore.setAmount(1);
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), ironore);

                                } else {
                                    player.getInventory().addItem(ironore);
                                }

                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu maden için gereken minimum alet gücü: 4"));
                            }
                        }
                        break;
                    case COAL_ORE:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            NamespacedKey digpower = new NamespacedKey(plugin, "aletGucu");
                            int aletgucu = item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 1) {
                                event.setDropItems(false);
                                event.setExpToDrop(1);
                                event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                                event.setCancelled(true);
                                int chanceamount3 = ThreadLocalRandom.current().nextInt(1) + 2;
                                ItemStack cooal = itemHandler.coal;
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
                        break;
                    case ALLIUM:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.AIR);
                        event.setCancelled(true);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.kezicicek);

                        } else {
                            player.getInventory().addItem(itemHandler.kezicicek);
                        }
                        break;
                    case SPRUCE_WOOD:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            NamespacedKey digpower = new NamespacedKey(plugin, "aletGucu");
                            int aletgucu = item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 4) {
                                event.setDropItems(false);
                                event.setExpToDrop(1);
                                event.getBlock().setType(Material.AIR);
                                event.setCancelled(true);
                                ItemStack sprucewood = itemHandler.sprucewood;
                                sprucewood.setAmount(1);
                                if (statsManager.getMeslek(player.getUniqueId()).equals("Oduncu")) {
                                    int logchance = ThreadLocalRandom.current().nextInt(30);
                                    if(logchance<5) {
                                        player.sendMessage(Painter.paint("&6Ekstra Odun Düşürdün!"));
                                        if (player.getInventory().firstEmpty() == -1) {
                                            world.dropItemNaturally(event.getBlock().getLocation(),sprucewood);

                                        } else {
                                            player.getInventory().addItem(sprucewood);

                                        }
                                    }
                                }
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(player.getLocation(),sprucewood);

                                } else {
                                    player.getInventory().addItem(sprucewood);
                                }


                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu odun için gereken minimum alet gücü: 5"));
                            }
                        }
                        break;
                    case BIRCH_WOOD:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            NamespacedKey digpower = new NamespacedKey(plugin, "aletGucu");
                            int aletgucu = item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 3) {
                                event.setDropItems(false);
                                event.setExpToDrop(1);
                                event.getBlock().setType(Material.AIR);
                                event.setCancelled(true);
                                ItemStack birchwood = itemHandler.birchwood;
                                birchwood.setAmount(1);
                                if (statsManager.getMeslek(player.getUniqueId()).equals("Oduncu")) {
                                    int logchance = ThreadLocalRandom.current().nextInt(30);
                                    if(logchance<5) {
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


                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu odun için gereken minimum alet gücü: 4"));
                            }
                        }
                        break;
                    case ACACIA_WOOD:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            NamespacedKey digpower = new NamespacedKey(plugin, "aletGucu");
                            int aletgucu = item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 6) {
                                event.setDropItems(false);
                                event.setExpToDrop(1);
                                event.getBlock().setType(Material.AIR);
                                event.setCancelled(true);
                                ItemStack acaciawood = itemHandler.acaciawood;
                                acaciawood.setAmount(1);
                                if (statsManager.getMeslek(player.getUniqueId()).equals("Oduncu")) {
                                    int logchance = ThreadLocalRandom.current().nextInt(30);
                                    if(logchance<5) {
                                        player.sendMessage(Painter.paint("&6Ekstra Odun Düşürdün!"));
                                        if (player.getInventory().firstEmpty() == -1) {
                                            world.dropItemNaturally(event.getBlock().getLocation(), acaciawood);

                                        } else {
                                            player.getInventory().addItem(acaciawood);

                                        }
                                    }
                                }
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(player.getLocation(), acaciawood);

                                } else {
                                    player.getInventory().addItem(acaciawood);
                                }

                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu odun için gereken minimum alet gücü: 7"));
                            }
                        }
                        break;
                    case STRIPPED_DARK_OAK_WOOD:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            NamespacedKey digpower = new NamespacedKey(plugin, "aletGucu");
                            int aletgucu = item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 7) {
                                event.setDropItems(false);
                                event.setExpToDrop(1);
                                event.getBlock().setType(Material.AIR);
                                event.setCancelled(true);
                                ItemStack oldoakwood = itemHandler.oldoakwood;
                                oldoakwood.setAmount(1);
                                if (statsManager.getMeslek(player.getUniqueId()).equals("Oduncu")) {
                                    int logchance = ThreadLocalRandom.current().nextInt(30);
                                    if(logchance<5) {
                                        player.sendMessage(Painter.paint("&6Ekstra Odun Düşürdün!"));
                                        if (player.getInventory().firstEmpty() == -1) {
                                            world.dropItemNaturally(event.getBlock().getLocation(), oldoakwood);

                                        } else {
                                            player.getInventory().addItem(oldoakwood);

                                        }
                                    }
                                }
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(player.getLocation(),oldoakwood);

                                } else {
                                    player.getInventory().addItem(oldoakwood);
                                }



                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu odun için gereken minimum alet gücü: 8"));
                            }
                        }
                        break;

                    case OAK_LOG:
                        event.setDropItems(false);
                        event.setCancelled(true);
                        break;
                    case SPRUCE_LOG:
                        event.setDropItems(false);
                        event.setCancelled(true);
                        break;
                    case STRIPPED_BIRCH_WOOD:
                        event.setDropItems(false);
                        event.setCancelled(true);
                        break;
                    case STRIPPED_BIRCH_LOG:
                        event.setDropItems(false);
                        event.setCancelled(true);
                        break;
                    case DARK_OAK_LOG:
                        event.setDropItems(false);
                        event.setCancelled(true);
                        break;
                    case BIRCH_LOG:
                        event.setDropItems(false);
                        event.setCancelled(true);
                        break;
                    case JUNGLE_LOG:
                        event.setDropItems(false);
                        event.setCancelled(true);
                        break;
                    case CRIMSON_HYPHAE:
                        event.setDropItems(false);
                        event.setCancelled(true);
                        break;
                    case ACACIA_LOG:
                        event.setDropItems(false);
                        event.setCancelled(true);
                        break;
                    case JUNGLE_WOOD:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            NamespacedKey digpower = new NamespacedKey(plugin, "aletGucu");
                            int aletgucu = item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 9) {
                                event.setDropItems(false);
                                event.setExpToDrop(1);
                                event.getBlock().setType(Material.AIR);
                                event.setCancelled(true);
                                ItemStack godwood = itemHandler.godwood;
                                godwood.setAmount(1);
                                if (statsManager.getMeslek(player.getUniqueId()).equals("Oduncu")) {
                                    int logchance = ThreadLocalRandom.current().nextInt(30);
                                    if(logchance<5) {
                                        player.sendMessage(Painter.paint("&6Ekstra Odun Düşürdün!"));
                                        if (player.getInventory().firstEmpty() == -1) {
                                            world.dropItemNaturally(event.getBlock().getLocation(), godwood);

                                        } else {
                                            player.getInventory().addItem(godwood);

                                        }
                                    }
                                }
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(player.getLocation(), godwood);

                                } else {
                                    player.getInventory().addItem(godwood);
                                }



                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu odun için gereken minimum alet gücü: 10"));
                            }
                        }
                        break;

                    case DARK_OAK_WOOD:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            NamespacedKey digpower = new NamespacedKey(plugin, "aletGucu");
                            int aletgucu = item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 8) {
                                event.setDropItems(false);
                                event.getBlock().setType(Material.AIR);
                                event.setCancelled(true);
                                ItemStack darkoakwood = itemHandler.darkoakwood;
                                darkoakwood.setAmount(1);
                                if (statsManager.getMeslek(player.getUniqueId()).equals("Oduncu")) {
                                    int logchance = ThreadLocalRandom.current().nextInt(30);
                                    if(logchance<5) {
                                        player.sendMessage(Painter.paint("&6Ekstra Odun Düşürdün!"));
                                        if (player.getInventory().firstEmpty() == -1) {
                                            world.dropItemNaturally(event.getBlock().getLocation(), darkoakwood);

                                        } else {
                                            player.getInventory().addItem(darkoakwood);

                                        }
                                    }
                                }
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(player.getLocation(), darkoakwood);

                                } else {
                                    player.getInventory().addItem(darkoakwood);
                                }


                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu odun için gereken minimum alet gücü: 9"));
                            }
                        }
                        break;

                    case ANCIENT_DEBRIS:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            if (MaterialTags.AXES.isTagged(item)) {
                                NamespacedKey digpower = new NamespacedKey(plugin, "aletGucu");
                                int aletgucu = item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                                if (aletgucu > 5) {
                                    event.setDropItems(false);
                                    event.getBlock().setType(Material.BEDROCK);
                                    event.setCancelled(true);
                                    ItemStack heavywood = itemHandler.heavywood;
                                    heavywood.setAmount(1);
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
                        ItemStack oakwood = itemHandler.oakwood;
                        oakwood.setAmount(1);
                        if (statsManager.getMeslek(player.getUniqueId()).equals("Oduncu")) {
                            int logchance = ThreadLocalRandom.current().nextInt(30);
                            if(logchance<5) {
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
                        ItemStack salt = itemHandler.salt;
                        salt.setAmount(1);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(),salt);

                        } else {
                            player.getInventory().addItem(salt);
                        }
                        break;
                }
            }



        }
    }


    @EventHandler
    public void blockplace(HangingBreakByEntityEvent event) {
        Entity entity = event.getEntity();
        if (!(entity instanceof Player)) return;
        Player player = (Player) entity;
        if (!(player.isOp())) {
            if (player.getWorld().getName().equalsIgnoreCase("world") || player.getWorld().getName().equalsIgnoreCase("dungeonworld")) {
                event.setCancelled(true);
            }
        }

    }

}
