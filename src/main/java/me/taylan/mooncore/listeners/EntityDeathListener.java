package me.taylan.mooncore.listeners;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.ItemDrop;
import me.taylan.mooncore.utils.ItemHandler;
import me.taylan.mooncore.utils.Painter;
import me.taylan.mooncore.utils.StatsManager;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.*;
import org.bukkit.entity.*;
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
        if (stats.getMeslek(player.getUniqueId()).equals("Avcı")) {
            int logchance = ThreadLocalRandom.current().nextInt(30);
            if (logchance < 5) {
                player.sendMessage(Painter.paint("&6Ekstra Tecrübe Puanı Düşürdün!"));
                ExperienceOrb armorStand2 = player.getWorld().spawn(player.getLocation(), ExperienceOrb.class, armorStand -> {
                    armorStand.setExperience(10);
                });
            }
        }
        if (name.contains("İnek")) {
            stats.setExp(player.getUniqueId(), 5);
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
            stats.setExp(player.getUniqueId(), 30);
            int chance2 = ThreadLocalRandom.current().nextInt(15);
            if (chance2 < 3) {
                ItemStack pigleather = itemHandler.pigleather;
                pigleather.setAmount(1);
                if (player.getInventory().firstEmpty() == -1) {
                    world.dropItemNaturally(entity.getLocation(), pigleather);

                } else {

                    player.getInventory().addItem(pigleather);
                }
            }
            ItemStack pork = itemHandler.rawpork;
            pork.setAmount(1);
            if (player.getInventory().firstEmpty() == -1) {

                world.dropItemNaturally(entity.getLocation(), pork);

            } else {
                player.getInventory().addItem(pork);
            }

        } else if (name.contains("Merinos")) {
            stats.setExp(player.getUniqueId(), 5);
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
            ItemStack rawmutton = itemHandler.rawmutton;
            rawmutton.setAmount(1);
            if (player.getInventory().firstEmpty() == -1) {

                world.dropItemNaturally(entity.getLocation(), rawmutton);

            } else {
                player.getInventory().addItem(rawmutton);
            }
        } else if (name.contains("Kurt")) {
            stats.setExp(player.getUniqueId(), 60);
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
            stats.setExp(player.getUniqueId(), 50);
            int chanceminer = ThreadLocalRandom.current().nextInt(50);
            if (chanceminer == 3) {
                ItemStack item = itemHandler.createArmorItem("Miğfer", new ItemStack(Material.CHAINMAIL_HELMET), "<gray>Madenci Kasketi", 2, 4, 5, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 400, 3);
                itemDrop.itemDrop(player, entity, item, EquipmentSlot.HEAD);
            } else if (chanceminer == 6) {
                ItemStack item = itemHandler.createToolItem(new ItemStack(Material.IRON_PICKAXE), "<gray>Paslanmış Demir Kazma", 1, 5, true, 1, 10, "Kazma", 200, 3);
                itemDrop.itemDrop(player, entity, item, EquipmentSlot.HAND);
            }
            if (player.getInventory().firstEmpty() == -1) {
                ItemStack blackbone = itemHandler.blackbone;
                blackbone.setAmount(1);
                world.dropItemNaturally(entity.getLocation(), blackbone);

            } else {
                ItemStack blackbone = itemHandler.blackbone;
                blackbone.setAmount(1);
                player.getInventory().addItem(blackbone);
            }
        } else if (name.contains("Bizon")) {
            stats.setExp(player.getUniqueId(), 20);
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
                ItemStack rawbeef = itemHandler.rawbeef;
                rawbeef.setAmount(1);
                world.dropItemNaturally(entity.getLocation(), rawbeef);

            } else {
                ItemStack rawbeef = itemHandler.rawbeef;
                rawbeef.setAmount(1);
                player.getInventory().addItem(rawbeef);
            }
        } else if (name.contains("Ayı")) {
            stats.setExp(player.getUniqueId(), 50);
            int chance5 = ThreadLocalRandom.current().nextInt(15);
            int chanceamount4 = ThreadLocalRandom.current().nextInt(1) + 1;
            if (chance5 < 3) {
                ItemStack item = itemHandler.bearleather;
                item.setAmount(chanceamount4);
                if (player.getInventory().firstEmpty() == -1) {
                    world.dropItemNaturally(entity.getLocation(), item);

                } else {
                    player.getInventory().addItem(item);
                }
            }
            if (player.getInventory().firstEmpty() == -1) {
                ItemStack rawbeef = itemHandler.rawbeef;
                rawbeef.setAmount(1);
                world.dropItemNaturally(entity.getLocation(), rawbeef);

            } else {
                ItemStack rawbeef = itemHandler.rawbeef;
                rawbeef.setAmount(1);
                player.getInventory().addItem(rawbeef);
            }
        } else if (name.contains("Örümcek")) {
            stats.setExp(player.getUniqueId(), 50);
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
            stats.setExp(player.getUniqueId(), 5);
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
            stats.setExp(player.getUniqueId(), 50);
            int chance6 = ThreadLocalRandom.current().nextInt(200);
            int chanceamount5 = ThreadLocalRandom.current().nextInt(1) + 1;
            if (chance6 < 2) {
                ItemStack item = itemHandler.createAccessoryItem("Tılsım", new ItemStack(Material.GRAY_DYE), "<red>Fitil Kesesi", 1, 2, 1, 2, 0, 0, 0, 0, 0, 2, 0, 2000, 5, "<color:#4a320a><i:false>[<color:#c48c2b><i:false>Ekipman Özelliği<color:#4a320a><i:false>]", "<color:#ad7617><i:false>Kullanıcının öldürdüğü rakipler patlayarak", "<color:#ad7617><i:false>yakındaki birimlere hasar verir.");
                setUnstackable(item, "akse");
                player.sendMessage(Painter.paint("&e(✯Nadir Ganimet✯) &cFitil Kesesi"));
                itemDrop.itemDrop(player, entity, item, EquipmentSlot.HAND);
            }
            if (player.getInventory().firstEmpty() == -1) {
                ItemStack bone = itemHandler.bone;
                bone.setAmount(1);
                world.dropItemNaturally(entity.getLocation(), bone);

            } else {
                ItemStack bone = itemHandler.bone;
                bone.setAmount(1);
                player.getInventory().addItem(bone);
            }
        } else if (name.contains("Karartı")) {
            stats.setExp(player.getUniqueId(), 50);
            int chance6 = ThreadLocalRandom.current().nextInt(100);
            if (chance6 < 1) {

                if (player.getInventory().firstEmpty() == -1) {
                    ItemStack item = itemHandler.blackdust;
                    item.setAmount(1);
                    player.sendMessage(Painter.paint("&e(✯Nadir Ganimet✯) &0Kara Toz"));
                    world.dropItemNaturally(entity.getLocation(), item);

                } else {
                    ItemStack item = itemHandler.blackdust;
                    item.setAmount(1);
                    player.sendMessage(Painter.paint("&e(✯Nadir Ganimet✯) &0Kara Toz"));
                    player.getInventory().addItem(item);
                }
            }
            if (player.getInventory().firstEmpty() == -1) {
                ItemStack blackbone = itemHandler.blackbone;
                blackbone.setAmount(1);
                world.dropItemNaturally(entity.getLocation(), blackbone);

            } else {
                ItemStack blackbone = itemHandler.blackbone;
                blackbone.setAmount(1);
                player.getInventory().addItem(blackbone);
            }
        } else if (name.contains("Mistik Gezgin")) {
            stats.setExp(player.getUniqueId(), 150);

            if (player.getInventory().firstEmpty() == -1) {
                world.dropItemNaturally(entity.getLocation(), itemHandler.shinyenderpearl);

            } else {
                player.getInventory().addItem(itemHandler.shinyenderpearl);
            }
        } else if (name.contains("Hiçlik Gezgini")) {
            stats.setExp(player.getUniqueId(), 130);

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
            stats.setExp(player.getUniqueId(), 100);
            int chanceminer = ThreadLocalRandom.current().nextInt(40);
            int chanceamountminer = ThreadLocalRandom.current().nextInt(1) + 1;
            if (chanceminer == 3) {
                ItemStack item = itemHandler.createAccessoryItem("Tılsım", new ItemStack(Material.BLACK_DYE), "<gray>Kararmış Tılsım", 1, 2, 0, 2, 0, 6, 0, 0, 0, 0, 3, 2000, 3);
                setUnstackable(item, "akse");
                player.sendMessage(Painter.paint("&e(✯Nadir Ganimet✯) &8Kararmış Tılsım"));
                itemDrop.itemDrop(player, entity, item, EquipmentSlot.HAND);
            }
            if (player.getInventory().firstEmpty() == -1) {
                ItemStack blackbone = itemHandler.blackbone;
                blackbone.setAmount(1);
                world.dropItemNaturally(entity.getLocation(), blackbone);

            } else {
                ItemStack blackbone = itemHandler.blackbone;
                blackbone.setAmount(1);
                player.getInventory().addItem(blackbone);
            }

        } else if (name.contains("Creeper")) {
            stats.setExp(player.getUniqueId(), 5);
            int chanceamountspider = ThreadLocalRandom.current().nextInt(2) + 1;
            ItemStack item = itemHandler.gunpowder;
            item.setAmount(chanceamountspider);
            if (player.getInventory().firstEmpty() == -1) {
                world.dropItemNaturally(entity.getLocation(), item);

            } else {
                player.getInventory().addItem(item);
            }
        } else if (name.contains("İskelet")) {
            stats.setExp(player.getUniqueId(), 50);
            int chanceamountspider = ThreadLocalRandom.current().nextInt(1) + 1;
            ItemStack item = itemHandler.bone;
            item.setAmount(chanceamountspider);
            if (player.getInventory().firstEmpty() == -1) {
                world.dropItemNaturally(entity.getLocation(), item);

            } else {
                player.getInventory().addItem(item);
            }
        } else if (name.contains("Hortlak")) {
            stats.setExp(player.getUniqueId(), 40);
            int chanceamountspider = ThreadLocalRandom.current().nextInt(1) + 1;
            ItemStack item = itemHandler.rotten;
            item.setAmount(chanceamountspider);
            if (player.getInventory().firstEmpty() == -1) {
                world.dropItemNaturally(entity.getLocation(), item);

            } else {
                player.getInventory().addItem(item);
            }
        } else if (name.contains("Haydut")) {
            stats.setExp(player.getUniqueId(), 60);
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
                ItemStack item = itemHandler.createWeaponItem(new ItemStack(Material.SHEARS), "<gray>Paslanmış Bakır Hançer", 2, 5, 13, 10, 1, false, 3, 10, 4, "Düşük", 2, "Hançer", 150, 3);
                player.sendMessage(Painter.paint("&e(✯Nadir Ganimet✯) &7Paslanmış Bakır Hançer"));
                itemDrop.itemDrop(player, entity, item, EquipmentSlot.HAND);
            }
        }
        if (name.contains("Haydut Şef")) {
            stats.setExp(player.getUniqueId(), 200);
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
                ItemStack item = itemHandler.createWeaponItem(new ItemStack(Material.WOODEN_SHOVEL), "<gray>Kertilmiş Demir Topuz", 4, 10, 13, 20, 0, false, 2, 24, 0, "Orta", 2, "Hançer", 400, 8);
                player.sendMessage(Painter.paint("&e(✯Nadir Ganimet✯) &7Kertilmiş Demir Topuz"));
                itemDrop.itemDrop(player, entity, item, EquipmentSlot.HAND);
            } else if (chanceminer == 3) {
                ItemStack item = itemHandler.createAccessoryItem("Eldiven", new ItemStack(Material.NAUTILUS_SHELL), "<red>Kadife Eldiven", 1, 1, 4, 6, 0, 3, 0, 0, 0, 2, 0, 200, 4);
                setUnstackable(item, "akse");
                player.sendMessage(Painter.paint("&e(✯Nadir Ganimet✯) &cKadife Eldiven"));
                itemDrop.itemDrop(player, entity, item, EquipmentSlot.HAND);
            } else if (chanceminer == 4) {
                ItemStack item = itemHandler.createArmorItem("Pantolon", new ItemStack(Material.CHAINMAIL_LEGGINGS), "<gray>Kullanılmamış Esir Pantolonu", 2, 2, 3, 4, 4, 0, 4, 0, 0, 0, 14, 0, 2, 2, 300, 4);
                player.sendMessage(Painter.paint("&e(✯Nadir Ganimet✯) &7Kullanılmamış Esir Pantolonu"));
                itemDrop.itemDrop(player, entity, item, EquipmentSlot.LEGS);
            } else if (chanceminer == 5) {
                ItemStack item = itemHandler.createArmorItem("Göğüslük", new ItemStack(Material.CHAINMAIL_CHESTPLATE), "<gray>Kullanılmamış Esir Göğüslüğü", 3, 3, 3, 5, 5, 0, 2, 0, 0, 0, 14, 0, 2, 2, 300, 5);
                player.sendMessage(Painter.paint("&e(✯Nadir Ganimet✯) &7Kullanılmamış Esir Göğüslüğü"));
                itemDrop.itemDrop(player, entity, item, EquipmentSlot.CHEST);
            }
        } else if (name.contains("Tavuk")) {
            stats.setExp(player.getUniqueId(), 4);
            int chance4 = ThreadLocalRandom.current().nextInt(15);
            int chanceamount3 = ThreadLocalRandom.current().nextInt(1) + 1;
            if (player.getInventory().firstEmpty() == -1) {
                ItemStack rawchicken = itemHandler.rawchicken;
                rawchicken.setAmount(1);
                world.dropItemNaturally(entity.getLocation(), rawchicken);

            } else {
                ItemStack rawchicken = itemHandler.rawchicken;
                rawchicken.setAmount(1);
                player.getInventory().addItem(rawchicken);
            }

            ItemStack item = itemHandler.feather;
            item.setAmount(chanceamount3);
            if (player.getInventory().firstEmpty() == -1) {
                world.dropItemNaturally(entity.getLocation(), item);

            } else {
                player.getInventory().addItem(item);
            }

        } else if (name.contains("Dev")) {
            stats.setExp(player.getUniqueId(), 40);
            int chance4 = ThreadLocalRandom.current().nextInt(30);
            int chanceamount3 = ThreadLocalRandom.current().nextInt(1) + 1;
            ItemStack gianttoe = itemHandler.gianttoe;
            gianttoe.setAmount(1);
            if (player.getInventory().firstEmpty() == -1) {
                world.dropItemNaturally(entity.getLocation(), gianttoe);

            } else {
                player.getInventory().addItem(gianttoe);
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
            stats.setExp(player.getUniqueId(), 65);
            int chanceamountspider = ThreadLocalRandom.current().nextInt(1) + 1;
            int chanceminer = ThreadLocalRandom.current().nextInt(60);
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
                ItemStack item = itemHandler.password;
                item.setAmount(1);
                item.setAmount(1);
                itemDrop.itemDrop(player, entity, item, EquipmentSlot.HAND);
            } else if (chanceminer == 4) {
                ItemStack item = itemHandler.paskask;
                item.setAmount(1);
                itemDrop.itemDrop(player, entity, item, EquipmentSlot.HEAD);
            } else if (chanceminer == 5) {
                ItemStack item = itemHandler.pasbot;
                item.setAmount(1);
                itemDrop.itemDrop(player, entity, item, EquipmentSlot.FEET);
            } else if (chanceminer == 7) {
                ItemStack item = itemHandler.paschest;
                item.setAmount(1);
                itemDrop.itemDrop(player, entity, item, EquipmentSlot.CHEST);
            } else if (chanceminer == 8) {
                ItemStack item = itemHandler.paspant;
                item.setAmount(1);
                itemDrop.itemDrop(player, entity, item, EquipmentSlot.LEGS);
            } else if (chanceminer == 6) {
                ItemStack item = itemHandler.witherrose;
                item.setAmount(1);
                itemDrop.itemDrop(player, entity, item, EquipmentSlot.HAND);
            }
            ItemStack item = itemHandler.blackbone;
            item.setAmount(chanceamountspider);
            if (player.getInventory().firstEmpty() == -1) {
                world.dropItemNaturally(entity.getLocation(), item);

            } else {
                player.getInventory().addItem(item);
            }
        } else if (name.contains("İskeletor")) {
            stats.setExp(player.getUniqueId(), 60);
            int chanceminer = ThreadLocalRandom.current().nextInt(60);
            if (chanceminer == 2) {
                itemDrop.itemDrop(player, entity, itemHandler.eklemeldiven, EquipmentSlot.HAND);
            } else if (chanceminer == 4) {
                itemDrop.itemDrop(player, entity, itemHandler.kemikgogusluk, EquipmentSlot.CHEST);
            } else if (chanceminer == 5) {
                itemDrop.itemDrop(player, entity, itemHandler.enchbone, EquipmentSlot.HAND);
            } else if (chanceminer == 6) {
                itemDrop.itemDrop(player, entity, itemHandler.kemikcariklar, EquipmentSlot.FEET);
            } else if (chanceminer == 7) {
                itemDrop.itemDrop(player, entity, itemHandler.kivilcimtopuz, EquipmentSlot.HAND);
            }
        } else if (name.contains("İskelet Avcı")) {
            stats.setExp(player.getUniqueId(), 60);
            int chanceminer = ThreadLocalRandom.current().nextInt(60);
            if (chanceminer == 2) {
                itemDrop.itemDrop(player, entity, itemHandler.kemiklesmisyay, EquipmentSlot.HAND);
            } else if (chanceminer == 4) {
                itemDrop.itemDrop(player, entity, itemHandler.kemikdizlik, EquipmentSlot.LEGS);
            } else if (chanceminer == 5) {
                itemDrop.itemDrop(player, entity, itemHandler.enchbone, EquipmentSlot.HAND);
            } else if (chanceminer == 6) {
                itemDrop.itemDrop(player, entity, itemHandler.kemikcariklar, EquipmentSlot.FEET);
            }
        } else if (name.contains("İskelet Esir")) {
            stats.setExp(player.getUniqueId(), 70);
            int chanceminer = ThreadLocalRandom.current().nextInt(60);
            if (chanceminer == 2) {
                itemDrop.itemDrop(player, entity, itemHandler.kemikmigfer, EquipmentSlot.HEAD);
            } else if (chanceminer == 4) {
                itemDrop.itemDrop(player, entity, itemHandler.bonesword, EquipmentSlot.HAND);
            } else if (chanceminer == 5) {
                itemDrop.itemDrop(player, entity, itemHandler.kemikeldiven, EquipmentSlot.HAND);
            } else if (chanceminer == 6) {
                itemDrop.itemDrop(player, entity, itemHandler.enchbone, EquipmentSlot.HAND);
            } else if (chanceminer == 7) {
                itemDrop.itemDrop(player, entity, itemHandler.metanet, EquipmentSlot.HAND);
            }

        } else if (name.contains("Ruh")) {
            stats.setExp(player.getUniqueId(), 70);
            int chanceminer = ThreadLocalRandom.current().nextInt(60);
            if (chanceminer == 2) {
                itemDrop.itemDrop(player, entity, itemHandler.soulesans, EquipmentSlot.HAND);
            } else if (chanceminer == 4) {
                itemDrop.itemDrop(player, entity, itemHandler.blackdust, EquipmentSlot.HAND);
            } else if (chanceminer == 5) {
                itemDrop.itemDrop(player, entity, itemHandler.zulumyuzugu, EquipmentSlot.HAND);
            } else if (chanceminer == 6) {
                itemDrop.itemDrop(player, entity, itemHandler.cokus, EquipmentSlot.HAND);
            }
        } else if (name.contains("Zefir")) {
            stats.setExp(player.getUniqueId(), 90);
            int chance4 = ThreadLocalRandom.current().nextInt(30);
            int chanceamount3 = ThreadLocalRandom.current().nextInt(1) + 1;
            ItemStack zefirleather = itemHandler.zefirleather;
            zefirleather.setAmount(1);
            if (player.getInventory().firstEmpty() == -1) {
                world.dropItemNaturally(entity.getLocation(), zefirleather);

            } else {
                player.getInventory().addItem(zefirleather);
            }
            if (chance4 < 3) {
                ItemStack item = itemHandler.iceesans;
                item.setAmount(chanceamount3);
                if (player.getInventory().firstEmpty() == -1) {
                    world.dropItemNaturally(entity.getLocation(), item);

                } else {
                    player.getInventory().addItem(item);
                }
            }
        } else if (name.contains("Korsan")) {
            stats.setExp(player.getUniqueId(), 60);
            int chance4 = ThreadLocalRandom.current().nextInt(40);
            int chanceamount3 = ThreadLocalRandom.current().nextInt(1) + 1;
            ItemStack silverfish = itemHandler.silverfish;
            silverfish.setAmount(1);
            if (player.getInventory().firstEmpty() == -1) {
                world.dropItemNaturally(entity.getLocation(), silverfish);

            } else {
                player.getInventory().addItem(silverfish);
            }
            if (chance4 == 3) {
                ItemStack item = itemHandler.createWeaponItem(new ItemStack(Material.WOODEN_SWORD), "<gray>Korsan Palası", 3, 9, 7, 6, 8, false, 2, 15, 0, "Orta", 2, "Kılıç", 300, 6);
                player.sendMessage(Painter.paint("&e(✯Nadir Ganimet✯) &6Korsan Palası"));
                itemDrop.itemDrop(player, entity, item, EquipmentSlot.HAND);

            } else if (chance4 == 4) {
                ItemStack gold = itemHandler.goldingot;
                itemDrop.itemDrop(player, entity, gold, EquipmentSlot.HAND);

            }
        } else if (name.contains("Magmav")) {
            stats.setExp(player.getUniqueId(), 110);
            int chance4 = ThreadLocalRandom.current().nextInt(40);
            int chanceamount3 = ThreadLocalRandom.current().nextInt(1) + 1;
            ItemStack magmaball = itemHandler.magmaball;
            magmaball.setAmount(1);
            if (player.getInventory().firstEmpty() == -1) {
                world.dropItemNaturally(entity.getLocation(), magmaball);

            } else {
                player.getInventory().addItem(magmaball);
            }
            if (chance4 == 3) {
                ItemStack item = itemHandler.firestring;
                itemDrop.itemDrop(player, entity, item, EquipmentSlot.HAND);

            } else if (chance4 == 4) {
                ItemStack gold = itemHandler.ash;
                itemDrop.itemDrop(player, entity, gold, EquipmentSlot.HAND);

            }
        } else if (name.contains("Biçimsiz")) {
            stats.setExp(player.getUniqueId(), 110);
            int chance4 = ThreadLocalRandom.current().nextInt(70);
            if (chance4 == 3) {
                ItemStack item = itemHandler.crimsonore;
                itemDrop.itemDrop(player, entity, item, EquipmentSlot.HAND);

            } else if (chance4 == 4) {
                ItemStack gold = itemHandler.eyeofdemon;
                itemDrop.itemDrop(player, entity, gold, EquipmentSlot.HAND);

            }
        } else if (name.contains("Magmaw Ruh")) {
            stats.setExp(player.getUniqueId(), 110);
            int chance4 = ThreadLocalRandom.current().nextInt(70);
            if (chance4 == 4) {
                ItemStack magmacore = itemHandler.magmacore;
                Location loc = entity.getLocation().add(getRandomOffset(), 0, getRandomOffset());
                magmacore.setAmount(1);
                itemDrop.itemDrop(player, loc, magmacore, EquipmentSlot.HEAD);
                Bukkit.getServer().broadcast(MiniMessage.miniMessage().deserialize("&e" + player.getName() + " &7 bir malzeme buldu: " + magmacore.getItemMeta().getDisplayName()));

            }
            for (Entity lootplayer : entity.getNearbyEntities(30, 30, 30)) {
                if (!(lootplayer instanceof Player)) {
                    continue;
                }
                ItemStack lootcanta = itemHandler.magmaloot;
                ItemStack magma2 = itemHandler.fireoz;
                lootcanta.setAmount(1);
                magma2.setAmount(1);
                Location loc = entity.getLocation().add(getRandomOffset(), 1, getRandomOffset());
                itemDrop.itemDrop((Player) lootplayer, loc, magma2, EquipmentSlot.HAND);
                itemDrop.itemDrop((Player) lootplayer, entity, lootcanta, EquipmentSlot.HAND);

            }
        } else if (name.contains("Golem")) {
            stats.setExp(player.getUniqueId(), 300);
            int chance4 = ThreadLocalRandom.current().nextInt(70);
            if (chance4 == 4) {
                ItemStack golemheart = itemHandler.golemheart;
                Location loc = entity.getLocation().add(getRandomOffset(), 0, getRandomOffset());
                golemheart.setAmount(1);
                itemDrop.itemDrop(player, loc, golemheart, EquipmentSlot.HEAD);
                Bukkit.getServer().broadcast(MiniMessage.miniMessage().deserialize("&e" + player.getName() + " &7 bir malzeme buldu: " + golemheart.getItemMeta().getDisplayName()));

            }
            if (chance4 < 10) {
                ItemStack golemhand = itemHandler.golemhand;
                Location loc = entity.getLocation().add(getRandomOffset(), 0, getRandomOffset());
                golemhand.setAmount(1);
                itemDrop.itemDrop(player, loc, golemhand, EquipmentSlot.HEAD);
                Bukkit.getServer().broadcast(MiniMessage.miniMessage().deserialize("&e" + player.getName() + " &7 bir malzeme buldu: " + golemhand.getItemMeta().getDisplayName()));

            }
            for (Entity lootplayer : entity.getNearbyEntities(30, 30, 30)) {
                if (!(lootplayer instanceof Player)) {
                    continue;
                }
                ItemStack ironingot = itemHandler.ironingot;
                ItemStack magma2 = itemHandler.redmushroom;
                ironingot.setAmount(30);
                magma2.setAmount(60);
                stats.setExp(lootplayer.getUniqueId(), 200);
                ((Player) lootplayer).giveExp(700);
                Location loc = entity.getLocation().add(getRandomOffset(), 1, getRandomOffset());
                itemDrop.itemDrop((Player) lootplayer, loc, magma2, EquipmentSlot.HAND);
                itemDrop.itemDrop((Player) lootplayer, entity, ironingot, EquipmentSlot.HAND);

            }
        } else if (name.contains("Lanetli Kırmızı")) {
            stats.setExp(player.getUniqueId(), 120);
            int chance4 = ThreadLocalRandom.current().nextInt(30);
            ItemStack redmushroom = itemHandler.redmushroom;
            redmushroom.setAmount(1);
            if (player.getInventory().firstEmpty() == -1) {
                world.dropItemNaturally(entity.getLocation(), redmushroom);

            } else {
                player.getInventory().addItem(redmushroom);
            }
            if (chance4 == 3) {
                ItemStack item = itemHandler.cursedstring;
                itemDrop.itemDrop(player, entity, item, EquipmentSlot.HAND);

            } else if (chance4 == 4) {
                ItemStack gold = itemHandler.asindirici;
                itemDrop.itemDrop(player, entity, gold, EquipmentSlot.HAND);

            } else if (chance4 == 5) {
                ItemStack item = itemHandler.createAccessoryItem("Tılsım", new ItemStack(Material.RED_MUSHROOM), "<red>Kırmızı Mantar Özü Tılsımı", 2, 2, 0, 0, 0, 8, 0, 0, 0, 10, 3, 2000, 7);

                itemDrop.itemDrop(player, entity, item, EquipmentSlot.HAND);

            }
        } else if (name.contains("Lanetli Kahverengi")) {
            stats.setExp(player.getUniqueId(), 100);
            int chance4 = ThreadLocalRandom.current().nextInt(30);

            ItemStack brownmushroom = itemHandler.brownmushroom;
            brownmushroom.setAmount(1);
            if (player.getInventory().firstEmpty() == -1) {
                world.dropItemNaturally(entity.getLocation(), brownmushroom);

            } else {
                player.getInventory().addItem(brownmushroom);
            }
            if (chance4 == 3) {
                ItemStack item = itemHandler.cursedstring;
                itemDrop.itemDrop(player, entity, item, EquipmentSlot.HAND);

            } else if (chance4 == 4) {
                ItemStack gold = itemHandler.rotten;
                itemDrop.itemDrop(player, entity, gold, EquipmentSlot.HAND);

            } else if (chance4 == 5) {
                ItemStack item = itemHandler.createAccessoryItem("Kolye", new ItemStack(Material.BROWN_MUSHROOM), "<red>Kahverengi Mantar Özü Kolyesi", 2, 0, 6, -3, -2, 5, 0, 0, 0, 0, 4, 2000, 6);

                itemDrop.itemDrop(player, entity, item, EquipmentSlot.HAND);

            }
        }


    }

    public double getRandomOffset() {
        double random = Math.random();
        if (Math.random() > 0.5)
            random *= -2;
        return random;
    }


    public void setUnstackable(ItemStack item, String key) {
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.values());
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, key), PersistentDataType.DOUBLE, Math.random());
        item.setItemMeta(meta);
    }

}
