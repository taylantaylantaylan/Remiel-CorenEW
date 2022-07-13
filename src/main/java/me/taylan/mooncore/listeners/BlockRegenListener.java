package me.taylan.mooncore.listeners;

import com.destroystokyo.paper.MaterialTags;
import me.taylan.mooncore.MoonCore;
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


    public BlockRegenListener(MoonCore plugin) {
        this.plugin = plugin;
        this.itemHandler = plugin.getItemHandler();
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
            if (player.getWorld().getName().equals("world") || player.getWorld().getName().equals("dungeonworld")|| player.getWorld().getName().equals("remielsurvival")) {
                if (!(Tag.LOGS.isTagged(blocktype) || (Tag.COAL_ORES.isTagged(blocktype) ||
                        (Tag.IRON_ORES.isTagged(blocktype)) || (Tag.DIAMOND_ORES.isTagged(blocktype)) || (Tag.LAPIS_ORES.isTagged(blocktype)) ||
                        (Tag.REDSTONE_ORES.isTagged(blocktype)) || (Tag.COPPER_ORES.isTagged(blocktype)) || (Tag.GOLD_ORES.isTagged(blocktype)) || blocktype == Material.OBSIDIAN || blocktype == Material.CLAY || blocktype == Material.RAW_COPPER_BLOCK || blocktype == Material.RAW_IRON_BLOCK || blocktype == Material.GRAVEL || blocktype == Material.BASALT
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
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.silverore);

                                } else {
                                    player.getInventory().addItem(itemHandler.silverore);
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
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.copperore);

                                } else {
                                    player.getInventory().addItem(itemHandler.copperore);
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
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.glowstone);

                        } else {
                            player.getInventory().addItem(itemHandler.glowstone);
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
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.glowstone);

                        } else {
                            player.getInventory().addItem(itemHandler.cactus);
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
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.terracotta);

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
                    case RED_SAND:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.BEDROCK);
                        event.setCancelled(true);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.redsand);

                        } else {
                            player.getInventory().addItem(itemHandler.redsand);
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
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.goldore);

                                } else {
                                    player.getInventory().addItem(itemHandler.goldore);
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
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.adamantiumore);

                                } else {
                                    player.getInventory().addItem(itemHandler.adamantiumore);
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
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.crimsonore);

                                } else {
                                    player.getInventory().addItem(itemHandler.crimsonore);
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
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.nikelore);

                                } else {
                                    player.getInventory().addItem(itemHandler.nikelore);
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
                    case STONE:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                        event.setCancelled(true);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.cobblestone);

                        } else {
                            player.getInventory().addItem(itemHandler.cobblestone);
                        }
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                event.getBlock().setType(Material.STONE);
                            }
                        }.runTaskLater(plugin, 200);
                        break;
                    case COBBLESTONE:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                        event.setCancelled(true);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.cobblestone);

                        } else {
                            player.getInventory().addItem(itemHandler.cobblestone);
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
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.cobblestone);

                        } else {
                            player.getInventory().addItem(itemHandler.cobblestone);
                        }
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                event.getBlock().setType(Material.TUFF);
                            }
                        }.runTaskLater(plugin, 200);
                        break;
                    case REDSTONE_ORE:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                        event.setCancelled(true);
                       event.setExpToDrop(2);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.redstone);

                        } else {
                            player.getInventory().addItem(itemHandler.redstone);
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
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.obsidianore);

                                } else {
                                    player.getInventory().addItem(itemHandler.obsidianore);
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
                                world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.apple);

                            } else {
                                player.getInventory().addItem(itemHandler.apple);
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
                            world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.clay);

                        } else {
                            player.getInventory().addItem(itemHandler.clay);
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
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.diamond);

                                } else {
                                    player.getInventory().addItem(itemHandler.diamond);
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
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.ironore);

                                } else {
                                    player.getInventory().addItem(itemHandler.ironore);
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
                    case SPRUCE_WOOD:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.SPRUCE_PLANKS);
                        event.setCancelled(true);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.sprucewood);

                        } else {
                            player.getInventory().addItem(itemHandler.sprucewood);
                        }
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                event.getBlock().setType(Material.SPRUCE_WOOD);
                            }
                        }.runTaskLater(plugin, 200);
                        break;
                    case BIRCH_WOOD:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.BIRCH_PLANKS);
                        event.setCancelled(true);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.birchwood);

                        } else {
                            player.getInventory().addItem(itemHandler.birchwood);
                        }
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                event.getBlock().setType(Material.BIRCH_WOOD);
                            }
                        }.runTaskLater(plugin, 200);
                        break;
                    case ACACIA_WOOD:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.ACACIA_PLANKS);
                        event.setCancelled(true);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.acaciawood);

                        } else {
                            player.getInventory().addItem(itemHandler.acaciawood);
                        }
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                event.getBlock().setType(Material.ACACIA_WOOD);
                            }
                        }.runTaskLater(plugin, 200);
                        break;
                    case STRIPPED_DARK_OAK_WOOD:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.DARK_OAK_PLANKS);
                        event.setCancelled(true);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.oldoakwood);

                        } else {
                            player.getInventory().addItem(itemHandler.oldoakwood);
                        }
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                event.getBlock().setType(Material.STRIPPED_DARK_OAK_WOOD);
                            }
                        }.runTaskLater(plugin, 200);
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
                        event.setDropItems(false);
                        event.getBlock().setType(Material.JUNGLE_PLANKS);
                        event.setCancelled(true);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.godwood);

                        } else {
                            player.getInventory().addItem(itemHandler.godwood);
                        }
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                event.getBlock().setType(Material.JUNGLE_WOOD);
                            }
                        }.runTaskLater(plugin, 200);
                        break;
                    case DARK_OAK_WOOD:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.DARK_OAK_PLANKS);
                        event.setCancelled(true);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.darkoakwood);

                        } else {
                            player.getInventory().addItem(itemHandler.darkoakwood);
                        }
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                event.getBlock().setType(Material.DARK_OAK_WOOD);
                            }
                        }.runTaskLater(plugin, 200);
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
                                    if (player.getInventory().firstEmpty() == -1) {
                                        world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.heavywood);

                                    } else {
                                        player.getInventory().addItem(itemHandler.heavywood);
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
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.oakwood);

                        } else {
                            player.getInventory().addItem(itemHandler.oakwood);
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
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.salt);

                        } else {
                            player.getInventory().addItem(itemHandler.salt);
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
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.silverore);

                                } else {
                                    player.getInventory().addItem(itemHandler.silverore);
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
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.copperore);

                                } else {
                                    player.getInventory().addItem(itemHandler.copperore);
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
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.glowstone);

                        } else {
                            player.getInventory().addItem(itemHandler.glowstone);
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
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.glowstone);

                        } else {
                            player.getInventory().addItem(itemHandler.cactus);
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
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.terracotta);

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
                    case RED_SAND:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.BEDROCK);
                        event.setCancelled(true);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.redsand);

                        } else {
                            player.getInventory().addItem(itemHandler.redsand);
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
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.goldore);

                                } else {
                                    player.getInventory().addItem(itemHandler.goldore);
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
                    case SPRUCE_WOOD:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.SPRUCE_PLANKS);
                        event.setCancelled(true);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.sprucewood);

                        } else {
                            player.getInventory().addItem(itemHandler.sprucewood);
                        }
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                event.getBlock().setType(Material.SPRUCE_WOOD);
                            }
                        }.runTaskLater(plugin, 200);
                        break;
                    case DEEPSLATE_DIAMOND_ORE:
                        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                            NamespacedKey digpower = new NamespacedKey(plugin, "aletGucu");
                            int aletgucu = item.getItemMeta().getPersistentDataContainer().get(digpower, PersistentDataType.INTEGER);
                            if (aletgucu > 8) {
                                event.setDropItems(false);
                                event.getBlock().setType(Material.BEDROCK);
                                event.setCancelled(true);
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.adamantiumore);

                                } else {
                                    player.getInventory().addItem(itemHandler.adamantiumore);
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
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.crimsonore);

                                } else {
                                    player.getInventory().addItem(itemHandler.crimsonore);
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
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.nikelore);

                                } else {
                                    player.getInventory().addItem(itemHandler.nikelore);
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
                    case STONE:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                        event.setCancelled(true);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.cobblestone);

                        } else {
                            player.getInventory().addItem(itemHandler.cobblestone);
                        }
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                event.getBlock().setType(Material.STONE);
                            }
                        }.runTaskLater(plugin, 200);
                        break;
                    case COBBLESTONE:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                        event.setCancelled(true);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.cobblestone);

                        } else {
                            player.getInventory().addItem(itemHandler.cobblestone);
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
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.cobblestone);

                        } else {
                            player.getInventory().addItem(itemHandler.cobblestone);
                        }
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                event.getBlock().setType(Material.TUFF);
                            }
                        }.runTaskLater(plugin, 200);
                        break;
                    case REDSTONE_ORE:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.DEAD_BUBBLE_CORAL_BLOCK);
                        event.setCancelled(true);
                        event.setExpToDrop(2);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.redstone);

                        } else {
                            player.getInventory().addItem(itemHandler.redstone);
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
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.obsidianore);

                                } else {
                                    player.getInventory().addItem(itemHandler.obsidianore);
                                }
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        event.getBlock().setType(Material.OBSIDIAN);
                                    }
                                }.runTaskLater(plugin, 200);
                            } else {
                                event.setCancelled(true);
                                player.sendMessage(Painter.paint("&6Bu maden için gereken minimum alet gücü: 6"));
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
                                world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.apple);

                            } else {
                                player.getInventory().addItem(itemHandler.apple);
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
                            world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.clay);

                        } else {
                            player.getInventory().addItem(itemHandler.clay);
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
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.diamond);

                                } else {
                                    player.getInventory().addItem(itemHandler.diamond);
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
                                if (player.getInventory().firstEmpty() == -1) {
                                    world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.ironore);

                                } else {
                                    player.getInventory().addItem(itemHandler.ironore);
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
                    case BIRCH_WOOD:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.BIRCH_PLANKS);
                        event.setCancelled(true);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.birchwood);

                        } else {
                            player.getInventory().addItem(itemHandler.birchwood);
                        }
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                event.getBlock().setType(Material.BIRCH_WOOD);
                            }
                        }.runTaskLater(plugin, 200);
                        break;
                    case ACACIA_WOOD:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.ACACIA_PLANKS);
                        event.setCancelled(true);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.acaciawood);

                        } else {
                            player.getInventory().addItem(itemHandler.acaciawood);
                        }
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                event.getBlock().setType(Material.ACACIA_WOOD);
                            }
                        }.runTaskLater(plugin, 200);
                        break;
                    case STRIPPED_DARK_OAK_WOOD:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.DARK_OAK_PLANKS);
                        event.setCancelled(true);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.oldoakwood);

                        } else {
                            player.getInventory().addItem(itemHandler.oldoakwood);
                        }
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                event.getBlock().setType(Material.STRIPPED_DARK_OAK_WOOD);
                            }
                        }.runTaskLater(plugin, 200);
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
                    case STRIPPED_SPRUCE_LOG:
                        event.setDropItems(false);
                        event.setCancelled(true);
                        break;
                    case JUNGLE_WOOD:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.JUNGLE_PLANKS);
                        event.setCancelled(true);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.godwood);

                        } else {
                            player.getInventory().addItem(itemHandler.godwood);
                        }
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                event.getBlock().setType(Material.JUNGLE_WOOD);
                            }
                        }.runTaskLater(plugin, 200);
                        break;
                    case DARK_OAK_WOOD:
                        event.setDropItems(false);
                        event.getBlock().setType(Material.DARK_OAK_PLANKS);
                        event.setCancelled(true);
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.darkoakwood);

                        } else {
                            player.getInventory().addItem(itemHandler.darkoakwood);
                        }
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                event.getBlock().setType(Material.DARK_OAK_WOOD);
                            }
                        }.runTaskLater(plugin, 200);
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
                                    if (player.getInventory().firstEmpty() == -1) {
                                        world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.heavywood);

                                    } else {
                                        player.getInventory().addItem(itemHandler.heavywood);
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
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.oakwood);

                        } else {
                            player.getInventory().addItem(itemHandler.oakwood);
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
                        if (player.getInventory().firstEmpty() == -1) {
                            world.dropItemNaturally(event.getBlock().getLocation(), itemHandler.salt);

                        } else {
                            player.getInventory().addItem(itemHandler.salt);
                        }
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                event.getBlock().setType(Material.CALCITE);
                            }
                        }.runTaskLater(plugin, 200);
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
