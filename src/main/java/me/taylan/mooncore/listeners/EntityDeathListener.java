package me.taylan.mooncore.listeners;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.ItemDrop;
import me.taylan.mooncore.utils.ItemHandler;
import me.taylan.mooncore.utils.Painter;
import me.taylan.mooncore.utils.StatsManager;
import org.bukkit.*;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.concurrent.ThreadLocalRandom;

public class EntityDeathListener implements Listener {

    private MoonCore plugin;
    private ItemHandler itemHandler;
    private StatsManager stats;
    private ItemDrop itemDrop;

    public EntityDeathListener(MoonCore plugin) {
        this.plugin = plugin;
        this.stats = plugin.getStatsManager();
        this.itemDrop = plugin.getItemDrop();
        this.itemHandler = plugin.getItemHandler();
        Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void entitykillevent(EntityDeathEvent event) {
        Entity entity = event.getEntity();
        World world = entity.getWorld();
        String name = entity.getName();
        Entity entitykiller = event.getEntity().getKiller();
        if (!(entitykiller instanceof Player)) return;
        Player player = (Player) entitykiller;
        if (stats.getTilsim(player.getUniqueId()).contains("Fitil")) {
            world.playSound(entity.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1F, 0.2F);
            for (Entity entity2 : entity.getNearbyEntities(3, 3, 3)) {
                if (entity2 == player) continue;
                if (entity2 instanceof Damageable) {
                    ((Damageable) entity2).damage(10, player);
                    player.spawnParticle(Particle.EXPLOSION_LARGE, entity2.getLocation().add(0, 1, 0), 0, 0, 0, 0,
                            0);
                }
            }
        }
        if (name.contains("İnek")) {

            int chance = ThreadLocalRandom.current().nextInt(10);
            int chanceamount2 = ThreadLocalRandom.current().nextInt(1) + 1;
            if (chance < 3) {
                ItemStack item = itemHandler.cowleather;
                item.setAmount(chanceamount2);
                if (player.getInventory().firstEmpty() == -1) {
                    world.dropItemNaturally(entity.getLocation(), item);

                } else {
                    player.getInventory().addItem(item);
                }
            }
            if (player.getInventory().firstEmpty() == -1) {
                world.dropItemNaturally(entity.getLocation(), itemHandler.rawbeef);

            } else {
                player.getInventory().addItem(itemHandler.rawbeef);
            }
        } else if (name.contains("Yaban Domuzu")) {

            int chance2 = ThreadLocalRandom.current().nextInt(15);
            if (chance2 < 3) {
                if (player.getInventory().firstEmpty() == -1) {
                    world.dropItemNaturally(entity.getLocation(), itemHandler.pigleather);

                } else {
                    player.getInventory().addItem(itemHandler.pigleather);
                }
            }
            if (player.getInventory().firstEmpty() == -1) {
                world.dropItemNaturally(entity.getLocation(), itemHandler.rawpork);

            } else {
                player.getInventory().addItem(itemHandler.rawpork);
            }

        } else if (name.contains("Merinos")) {

            int chance3 = ThreadLocalRandom.current().nextInt(6);
            int chanceamount = ThreadLocalRandom.current().nextInt(1) + 1;
            if (chance3 < 3) {
                ItemStack item = itemHandler.wool;
                item.setAmount(chanceamount);
                if (player.getInventory().firstEmpty() == -1) {
                    world.dropItemNaturally(entity.getLocation(), item);

                } else {
                    player.getInventory().addItem(item);
                }
            }
            if (player.getInventory().firstEmpty() == -1) {
                world.dropItemNaturally(entity.getLocation(), itemHandler.rawmutton);

            } else {
                player.getInventory().addItem(itemHandler.rawmutton);
            }
        } else if (name.contains("Kurt")) {

            int chance4 = ThreadLocalRandom.current().nextInt(15);
            int chanceamount3 = ThreadLocalRandom.current().nextInt(1) + 1;
            if (chance4 < 3) {
                ItemStack item = itemHandler.wolfleather;
                item.setAmount(chanceamount3);
                if (player.getInventory().firstEmpty() == -1) {
                    world.dropItemNaturally(entity.getLocation(), item);

                } else {
                    player.getInventory().addItem(item);
                }
            } else if (chance4 == 6) {
                ItemStack item = itemHandler.wolfteeth.clone();
                item.setAmount(chanceamount3);
                if (player.getInventory().firstEmpty() == -1) {
                    world.dropItemNaturally(entity.getLocation(), item);

                } else {
                    player.getInventory().addItem(item);
                }
            }
        } else if (name.contains("Kararmış Madenci")) {

            int chanceminer = ThreadLocalRandom.current().nextInt(50);
            if (chanceminer == 3) {
                ItemStack item = itemHandler.createArmorItem("Miğfer", new ItemStack(Material.CHAINMAIL_HELMET), "&7Madenci Kasketi", 2, 4, 5, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 400);
                itemDrop.itemDrop(player,entity, item, EquipmentSlot.HEAD);
            } else if (chanceminer == 6) {
                ItemStack item = itemHandler.createToolItem(new ItemStack(Material.IRON_PICKAXE), "&7Paslanmış Demir Kazma", 1, 5, true, 1, 10, "Kazma", 200);
                itemDrop.itemDrop(player,entity, item, EquipmentSlot.HAND);
            }
            if (player.getInventory().firstEmpty() == -1) {
                world.dropItemNaturally(entity.getLocation(), itemHandler.blackbone);

            } else {
                player.getInventory().addItem(itemHandler.blackbone);
            }
        } else if (name.contains("Bizon")) {

            int chance5 = ThreadLocalRandom.current().nextInt(15);
            int chanceamount4 = ThreadLocalRandom.current().nextInt(1) + 1;
            if (chance5 < 3) {
                ItemStack item = itemHandler.bizoneleather;
                item.setAmount(chanceamount4);
                if (player.getInventory().firstEmpty() == -1) {
                    world.dropItemNaturally(entity.getLocation(), item);

                } else {
                    player.getInventory().addItem(item);
                }
            }
            if (player.getInventory().firstEmpty() == -1) {
                world.dropItemNaturally(entity.getLocation(), itemHandler.rawbeef);

            } else {
                player.getInventory().addItem(itemHandler.rawbeef);
            }
        } else if (name.contains("Örümcek")) {

            int chancespider = ThreadLocalRandom.current().nextInt(30);
            int chanceamountspider = ThreadLocalRandom.current().nextInt(1) + 1;
            if (chancespider < 20) {
                ItemStack item = itemHandler.spidereye;
                item.setAmount(chanceamountspider);
                if (player.getInventory().firstEmpty() == -1) {
                    world.dropItemNaturally(entity.getLocation(), item);

                } else {
                    player.getInventory().addItem(item);
                }
            }
            if (chancespider < 3) {
                ItemStack item = itemHandler.cursedstring;
                item.setAmount(chanceamountspider);
                if (player.getInventory().firstEmpty() == -1) {
                    world.dropItemNaturally(entity.getLocation(), item);

                } else {
                    player.getInventory().addItem(item);
                }
            }
            world.dropItemNaturally(entity.getLocation(), itemHandler.string);
        } else if (name.contains("Tilki")) {

            int chance6 = ThreadLocalRandom.current().nextInt(15);
            int chanceamount5 = ThreadLocalRandom.current().nextInt(1) + 1;
            if (chance6 < 3) {
                ItemStack item = itemHandler.foxleather;
                item.setAmount(chanceamount5);
                if (player.getInventory().firstEmpty() == -1) {
                    world.dropItemNaturally(entity.getLocation(), item);

                } else {
                    player.getInventory().addItem(item);
                }
            }
        } else if (name.contains("Ölü Bombacı")) {

            int chance6 = ThreadLocalRandom.current().nextInt(200);
            int chanceamount5 = ThreadLocalRandom.current().nextInt(1) + 1;
            if (chance6 < 2) {
                ItemStack item = itemHandler.createAccessoryItem("Tılsım", new ItemStack(Material.GRAY_DYE), "&cFitil Kesesi", 1, 2, 1, 2, 0, 0, 0, 0, 0, 2, 0, 2000, "<color:#4a320a><i:false>[<color:#c48c2b><i:false>Ekipman Özelliği<color:#4a320a><i:false>]", "<color:#ad7617><i:false>Kullanıcının öldürdüğü rakipler patlayarak", "<color:#ad7617><i:false>yakındaki birimlere hasar verir.");
                setUnstackable(item, "akse");
                player.sendMessage(Painter.paint("&e(✯Nadir Ganimet✯) &cFitil Kesesi"));
                itemDrop.itemDrop(player,entity, item, EquipmentSlot.HAND);
            }
            if (player.getInventory().firstEmpty() == -1) {
                world.dropItemNaturally(entity.getLocation(), itemHandler.bone);

            } else {
                player.getInventory().addItem(itemHandler.bone);
            }
        } else if (name.contains("Karartı")) {

            int chance6 = ThreadLocalRandom.current().nextInt(100);
            if (chance6 < 1) {

                if (player.getInventory().firstEmpty() == -1) {
                    ItemStack item = itemHandler.blackdust;
                    player.sendMessage(Painter.paint("&e(✯Nadir Ganimet✯) &0Kara Toz"));
                    world.dropItemNaturally(entity.getLocation(), item);

                } else {
                    ItemStack item = itemHandler.blackdust;
                    player.sendMessage(Painter.paint("&e(✯Nadir Ganimet✯) &0Kara Toz"));
                    player.getInventory().addItem(item);
                }
            }
            if (player.getInventory().firstEmpty() == -1) {
                world.dropItemNaturally(entity.getLocation(), itemHandler.blackbone);

            } else {
                player.getInventory().addItem(itemHandler.blackbone);
            }
        } else if (name.contains("Mistik Gezgin")) {
            if (player.getInventory().firstEmpty() == -1) {
                world.dropItemNaturally(entity.getLocation(), itemHandler.shinyenderpearl);

            } else {
                player.getInventory().addItem(itemHandler.shinyenderpearl);
            }
        } else if (name.contains("Hiçlik Gezgini")) {
            int chanceamount7 = ThreadLocalRandom.current().nextInt(1) + 1;
            int chance6 = ThreadLocalRandom.current().nextInt(6);
            if (chance6 < 3) {
                ItemStack item = itemHandler.enderpearl;
                item.setAmount(chanceamount7);
                if (player.getInventory().firstEmpty() == -1) {
                    world.dropItemNaturally(entity.getLocation(), item);

                } else {
                    player.getInventory().addItem(item);
                }
            }
        } else if (name.contains("Yüzsüz")) {

            int chanceminer = ThreadLocalRandom.current().nextInt(40);
            int chanceamountminer = ThreadLocalRandom.current().nextInt(1) + 1;
            if (chanceminer == 3) {
                ItemStack item = itemHandler.createAccessoryItem("Tılsım", new ItemStack(Material.BLACK_DYE), "&8Kararmış Tılsım", 1, 2, 0, 2, 0, 6, 0, 0, 0, 0, 3, 2000);
                setUnstackable(item, "akse");
                player.sendMessage(Painter.paint("&e(✯Nadir Ganimet✯) &8Kararmış Tılsım"));
                itemDrop.itemDrop(player,entity, item, EquipmentSlot.HAND);
            }
            if (player.getInventory().firstEmpty() == -1) {
                world.dropItemNaturally(entity.getLocation(), itemHandler.blackbone);

            } else {
                player.getInventory().addItem(itemHandler.blackbone);
            }

        } else if (name.contains("Creeper")) {
            int chanceamountspider = ThreadLocalRandom.current().nextInt(2) + 1;
            ItemStack item = itemHandler.gunpowder;
            item.setAmount(chanceamountspider);
            if (player.getInventory().firstEmpty() == -1) {
                world.dropItemNaturally(entity.getLocation(), item);

            } else {
                player.getInventory().addItem(item);
            }
        } else if (name.contains("İskelet")) {
            int chanceamountspider = ThreadLocalRandom.current().nextInt(1) + 1;
            ItemStack item = itemHandler.bone;
            item.setAmount(chanceamountspider);
            if (player.getInventory().firstEmpty() == -1) {
                world.dropItemNaturally(entity.getLocation(), item);

            } else {
                player.getInventory().addItem(item);
            }
        } else if (name.contains("Hortlak")) {
            int chanceamountspider = ThreadLocalRandom.current().nextInt(1) + 1;
            ItemStack item = itemHandler.rotten;
            item.setAmount(chanceamountspider);
            if (player.getInventory().firstEmpty() == -1) {
                world.dropItemNaturally(entity.getLocation(), item);

            } else {
                player.getInventory().addItem(item);
            }
        } else if (name.contains("Haydut")) {
            int chanceamountspider = ThreadLocalRandom.current().nextInt(1) + 1;
            int chanceminer = ThreadLocalRandom.current().nextInt(70);
            if (chanceminer < 20) {
                ItemStack item = itemHandler.goldingot;
                item.setAmount(chanceamountspider);
                if (player.getInventory().firstEmpty() == -1) {
                    world.dropItemNaturally(entity.getLocation(), item);

                } else {
                    player.getInventory().addItem(item);
                }
            }
            if (chanceminer < 5) {
                ItemStack item = itemHandler.cookedpork;
                item.setAmount(chanceamountspider);
                if (player.getInventory().firstEmpty() == -1) {
                    world.dropItemNaturally(entity.getLocation(), item);

                } else {
                    player.getInventory().addItem(item);
                }
            }
            if (chanceminer == 2) {
                ItemStack item = itemHandler.createWeaponItem(new ItemStack(Material.SHEARS), "&7Paslanmış Bakır Hançer", 2, 5, 13, 10, 1, false, 3, 10, 4, "Düşük", 2, "Hançer", 150);
                player.sendMessage(Painter.paint("&e(✯Nadir Ganimet✯) &7Paslanmış Bakır Hançer"));
                itemDrop.itemDrop(player,entity, item, EquipmentSlot.HAND);
            }
        }
        if (name.contains("Haydut Şef")) {
            int chanceamountspider = ThreadLocalRandom.current().nextInt(1) + 1;
            int chanceminer = ThreadLocalRandom.current().nextInt(55);
            if (chanceminer < 30) {
                ItemStack item = itemHandler.silveringot;
                item.setAmount(chanceamountspider);
                if (player.getInventory().firstEmpty() == -1) {
                    world.dropItemNaturally(entity.getLocation(), item);

                } else {
                    player.getInventory().addItem(item);
                }
            }
            if (chanceminer == 2) {
                ItemStack item = itemHandler.createWeaponItem(new ItemStack(Material.WOODEN_SHOVEL), "&7Kertilmiş Demir Topuz", 4, 10, 13, 20, 0, false, 2, 24, 0, "Orta", 2, "Hançer", 400);
                player.sendMessage(Painter.paint("&e(✯Nadir Ganimet✯) &7Kertilmiş Demir Topuz"));
                itemDrop.itemDrop(player,entity, item, EquipmentSlot.HAND);
            } else if (chanceminer == 3) {
                ItemStack item = itemHandler.createAccessoryItem("Eldiven", new ItemStack(Material.NAUTILUS_SHELL), "&cKadife Eldiven", 1, 1, 4, 6, 0, 3, 0, 0, 0, 2, 0, 200);
                setUnstackable(item, "akse");
                player.sendMessage(Painter.paint("&e(✯Nadir Ganimet✯) &cKadife Eldiven"));
                itemDrop.itemDrop(player,entity, item, EquipmentSlot.HAND);
            } else if (chanceminer == 4) {
                ItemStack item = itemHandler.createArmorItem("Pantolon", new ItemStack(Material.CHAINMAIL_LEGGINGS), "&7Kullanılmamış Esir Pantolonu", 2, 2, 3, 4, 4, 0, 4, 0, 0, 0, 14, 0, 2, 2, 300);
                player.sendMessage(Painter.paint("&e(✯Nadir Ganimet✯) &7Kullanılmamış Esir Pantolonu"));
                itemDrop.itemDrop(player,entity, item, EquipmentSlot.LEGS);
            } else if (chanceminer == 5) {
                ItemStack item = itemHandler.createArmorItem("Göğüslük", new ItemStack(Material.CHAINMAIL_CHESTPLATE), "&7Kullanılmamış Esir Göğüslüğü", 3, 3, 3, 5, 5, 0, 2, 0, 0, 0, 14, 0, 2, 2, 300);
                player.sendMessage(Painter.paint("&e(✯Nadir Ganimet✯) &7Kullanılmamış Esir Göğüslüğü"));
                itemDrop.itemDrop(player,entity, item, EquipmentSlot.CHEST);
            }
        } else if (name.contains("Tavuk")) {

            int chance4 = ThreadLocalRandom.current().nextInt(15);
            int chanceamount3 = ThreadLocalRandom.current().nextInt(1) + 1;
            if (player.getInventory().firstEmpty() == -1) {
                world.dropItemNaturally(entity.getLocation(), itemHandler.rawchicken);

            } else {
                player.getInventory().addItem(itemHandler.rawchicken);
            }
            if (chance4 < 3) {
                ItemStack item = itemHandler.feather;
                item.setAmount(chanceamount3);
                if (player.getInventory().firstEmpty() == -1) {
                    world.dropItemNaturally(entity.getLocation(), item);

                } else {
                    player.getInventory().addItem(item);
                }
            }
        } else if (name.contains("Dev")) {

            int chance4 = ThreadLocalRandom.current().nextInt(30);
            int chanceamount3 = ThreadLocalRandom.current().nextInt(1) + 1;
            if (player.getInventory().firstEmpty() == -1) {
                world.dropItemNaturally(entity.getLocation(), itemHandler.gianttoe);

            } else {
                player.getInventory().addItem(itemHandler.gianttoe);
            }
            if (chance4 < 3) {
                ItemStack item = itemHandler.gianteye;
                item.setAmount(chanceamount3);
                if (player.getInventory().firstEmpty() == -1) {
                    world.dropItemNaturally(entity.getLocation(), item);

                } else {
                    player.getInventory().addItem(item);
                }
            }
        } else if (name.contains("Kararmış Şövalye")) {
            int chanceamountspider = ThreadLocalRandom.current().nextInt(1) + 1;
            int chanceminer = ThreadLocalRandom.current().nextInt(50);
            if (chanceminer < 30) {
                ItemStack item = itemHandler.blackdust;
                item.setAmount(chanceamountspider);
                if (player.getInventory().firstEmpty() == -1) {
                    world.dropItemNaturally(entity.getLocation(), item);

                } else {
                    player.getInventory().addItem(item);
                }
            }
            if (chanceminer == 2) {
                ItemStack item = itemHandler.createWeaponItem(new ItemStack(Material.DIAMOND_SWORD), "&7Paslanmış Ağır Demir Kılıç", 3, 10, 12, 10, 0, false, 1, 32, 0, "Yüksek", 2, "Kılıç", 500);
                itemDrop.itemDrop(player,entity, item, EquipmentSlot.HAND);
            } else if (chanceminer == 4) {
                ItemStack item = itemHandler.createArmorItem("Miğfer", new ItemStack(Material.GOLDEN_HELMET), "&7Ağır Gardiyan Miğferi", 3, 5, 3, 4, 4, 0, 2, 0, 0, 0, 14, 0, 2, 2, 400);
                itemDrop.itemDrop(player,entity, item, EquipmentSlot.HEAD);
            } else if (chanceminer == 5) {
                ItemStack item = itemHandler.createArmorItem("Botlar", new ItemStack(Material.GOLDEN_LEGGINGS), "&7Ağır Gardiyan Botları", 3, 4, 3, 7, 4, 2, 2, 0, 0, 0, 14, 5, 2, 2, 400);
                itemDrop.itemDrop(player,entity, item, EquipmentSlot.FEET);
            }
            ItemStack item = itemHandler.blackbone;
            item.setAmount(chanceamountspider);
            if (player.getInventory().firstEmpty() == -1) {
                world.dropItemNaturally(entity.getLocation(), item);

            } else {
                player.getInventory().addItem(item);
            }
        }

    }


    public void setUnstackable(ItemStack item, String key) {
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.values());
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, key), PersistentDataType.DOUBLE, Math.random());
        item.setItemMeta(meta);
    }

}
