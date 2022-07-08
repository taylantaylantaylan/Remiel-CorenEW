package me.taylan.mooncore.listeners;

import com.destroystokyo.paper.MaterialTags;
import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.StatsManager;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.UUID;

public class AccessoryListener implements Listener {
    private MoonCore plugin;
    private StatsManager stats;
    private JoinListener joinListener;

    public AccessoryListener(MoonCore plugin) {
        this.plugin = plugin;
        this.stats = plugin.getStatsManager();
        this.joinListener = plugin.getJoinListener();
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void aksesuar(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        UUID uuid = player.getUniqueId();
        FileConfiguration fc = stats.getStatfile().get(player.getUniqueId());
        if (player.getInventory().getItemInMainHand() == null) {
            return;
        }
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {

            if (event.getClickedBlock() != null && plugin.getConfig().getStringList("blocked").contains(event.getClickedBlock().getType().toString())) {
                return;
            }
            ItemStack item = player.getInventory().getItemInMainHand();
            if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                ItemMeta meta = item.getItemMeta();
                PersistentDataContainer container = meta.getPersistentDataContainer();
                NamespacedKey type = new NamespacedKey(plugin, "type");
                NamespacedKey name = new NamespacedKey(plugin, "name");
                NamespacedKey can = new NamespacedKey(plugin, "can");
                NamespacedKey doygunluk = new NamespacedKey(plugin, "doygunluk");
                NamespacedKey canyenilenmesi = new NamespacedKey(plugin, "canyenilenmesi");
                NamespacedKey saldirihizi = new NamespacedKey(plugin, "attackspeed");
                NamespacedKey guc = new NamespacedKey(plugin, "guc");
                NamespacedKey zirh = new NamespacedKey(plugin, "dayaniklilik");
                NamespacedKey kritiksansi = new NamespacedKey(plugin, "kritiksans");
                NamespacedKey kritikhasari = new NamespacedKey(plugin, "kritik");
                NamespacedKey hiz = new NamespacedKey(plugin, "hiz");
                NamespacedKey sogukdi = new NamespacedKey(plugin, "sogukdirenci");
                NamespacedKey sicakdi = new NamespacedKey(plugin, "sicakdirenci");
                NamespacedKey hiclikdi = new NamespacedKey(plugin, "hiclikdirenci");

                if (container.has(type) && container.has(name)) {
                    String aksesuartype = container.get(type, PersistentDataType.STRING);
                    String aksesuarname = container.get(name, PersistentDataType.STRING);

                    ArrayList<ItemStack> list = (ArrayList<ItemStack>) stats.getHepsi(uuid);

                    switch (aksesuartype) {
                        case "Tılsım":
                            stats.setTilsim(uuid, aksesuarname);
                            list.set(0, player.getInventory().getItemInMainHand());
                            stats.setHepsi(uuid, list);
                            player.getInventory().setItemInMainHand(null);
                            player.playSound(player, Sound.ITEM_ARMOR_EQUIP_GENERIC, 2, 1.1f);
                            for (NamespacedKey key : container.getKeys()) {
                                if (key.equals(can)) {
                                    player.damage(0.01);
                                    stats.setCan(player, player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));

                                } else if (key.equals(canyenilenmesi)) {
                                    stats.setCanYenileme(player, player.getUniqueId(),
                                            container.get(key, PersistentDataType.INTEGER));

                                } else if (key.equals(guc)) {
                                    stats.setGuc(player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
                                } else if (key.equals(zirh)) {
                                    stats.setDirenc(player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
                                } else if (key.equals(doygunluk)) {
                                    stats.setDoygunluk(player, player.getUniqueId(),
                                            container.get(key, PersistentDataType.INTEGER));
                                } else if (key.equals(saldirihizi)) {
                                    stats.setSaldiriHizi(player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
                                } else if (key.equals(kritikhasari)) {
                                    stats.setKritikHasari(player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
                                } else if (key.equals(kritiksansi)) {
                                    stats.setKritikSansi(player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
                                } else if (key.equals(hiz)) {
                                    stats.setHiz(player, player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
                                } else if (key.equals(sogukdi)) {
                                    stats.setSogukDirenci(player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
                                } else if (key.equals(sicakdi)) {
                                    stats.setSicakDirenci(player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
                                } else if (key.equals(hiclikdi)) {
                                    stats.setHiclikDirenci(player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
                                }
                            }

                            break;
                        case "Eldiven":
                            stats.setEldiven(uuid, aksesuarname);
                            list.set(1, player.getInventory().getItemInMainHand());
                            stats.setHepsi(uuid, list);
                            player.getInventory().setItemInMainHand(null);
                            player.playSound(player, Sound.ITEM_ARMOR_EQUIP_GENERIC, 2, 1.1f);

                            for (NamespacedKey key : container.getKeys()) {
                                if (key.equals(can)) {
                                    player.damage(0.01);
                                    stats.setCan(player, player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));

                                } else if (key.equals(canyenilenmesi)) {
                                    stats.setCanYenileme(player, player.getUniqueId(),
                                            container.get(key, PersistentDataType.INTEGER));

                                } else if (key.equals(guc)) {
                                    stats.setGuc(player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
                                } else if (key.equals(zirh)) {
                                    stats.setDirenc(player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
                                } else if (key.equals(doygunluk)) {
                                    stats.setDoygunluk(player, player.getUniqueId(),
                                            container.get(key, PersistentDataType.INTEGER));
                                } else if (key.equals(saldirihizi)) {
                                    stats.setSaldiriHizi(player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
                                } else if (key.equals(kritikhasari)) {
                                    stats.setKritikHasari(player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
                                } else if (key.equals(kritiksansi)) {
                                    stats.setKritikSansi(player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
                                } else if (key.equals(hiz)) {
                                    stats.setHiz(player, player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
                                } else if (key.equals(sogukdi)) {
                                    stats.setSogukDirenci(player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
                                } else if (key.equals(sicakdi)) {
                                    stats.setSicakDirenci(player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
                                } else if (key.equals(hiclikdi)) {
                                    stats.setHiclikDirenci(player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
                                }
                            }

                            break;
                        case "Kolye":
                            stats.setKolye(uuid, aksesuarname);
                            list.set(2, player.getInventory().getItemInMainHand());
                            stats.setHepsi(uuid, list);
                            player.getInventory().setItemInMainHand(null);
                            player.playSound(player, Sound.ITEM_ARMOR_EQUIP_GENERIC, 2, 1.1f);

                            for (NamespacedKey key : container.getKeys()) {
                                if (key.equals(can)) {
                                    player.damage(0.01);
                                    stats.setCan(player, player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));

                                } else if (key.equals(canyenilenmesi)) {
                                    stats.setCanYenileme(player, player.getUniqueId(),
                                            container.get(key, PersistentDataType.INTEGER));

                                } else if (key.equals(guc)) {
                                    stats.setGuc(player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
                                } else if (key.equals(zirh)) {
                                    stats.setDirenc(player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
                                } else if (key.equals(doygunluk)) {
                                    stats.setDoygunluk(player, player.getUniqueId(),
                                            container.get(key, PersistentDataType.INTEGER));
                                } else if (key.equals(saldirihizi)) {
                                    stats.setSaldiriHizi(player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
                                } else if (key.equals(kritikhasari)) {
                                    stats.setKritikHasari(player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
                                } else if (key.equals(kritiksansi)) {
                                    stats.setKritikSansi(player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
                                } else if (key.equals(hiz)) {
                                    stats.setHiz(player, player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
                                } else if (key.equals(sogukdi)) {
                                    stats.setSogukDirenci(player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
                                } else if (key.equals(sicakdi)) {
                                    stats.setSicakDirenci(player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
                                } else if (key.equals(hiclikdi)) {
                                    stats.setHiclikDirenci(player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
                                }
                            }

                            break;
                        case "Yüzük":
                            stats.setYuzuk(uuid, aksesuarname);
                            list.set(3, player.getInventory().getItemInMainHand());
                            stats.setHepsi(uuid, list);
                            player.getInventory().setItemInMainHand(null);
                            player.playSound(player, Sound.ITEM_ARMOR_EQUIP_GENERIC, 2, 1.1f);

                            for (NamespacedKey key : container.getKeys()) {
                                if (key.equals(can)) {
                                    player.damage(0.01);
                                    stats.setCan(player, player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));

                                } else if (key.equals(canyenilenmesi)) {
                                    stats.setCanYenileme(player, player.getUniqueId(),
                                            container.get(key, PersistentDataType.INTEGER));

                                } else if (key.equals(guc)) {
                                    stats.setGuc(player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
                                } else if (key.equals(zirh)) {
                                    stats.setDirenc(player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
                                } else if (key.equals(doygunluk)) {
                                    stats.setDoygunluk(player, player.getUniqueId(),
                                            container.get(key, PersistentDataType.INTEGER));
                                } else if (key.equals(saldirihizi)) {
                                    stats.setSaldiriHizi(player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
                                } else if (key.equals(kritikhasari)) {
                                    stats.setKritikHasari(player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
                                } else if (key.equals(kritiksansi)) {
                                    stats.setKritikSansi(player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
                                } else if (key.equals(hiz)) {
                                    stats.setHiz(player, player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
                                } else if (key.equals(sogukdi)) {
                                    stats.setSogukDirenci(player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
                                } else if (key.equals(sicakdi)) {
                                    stats.setSicakDirenci(player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
                                } else if (key.equals(hiclikdi)) {
                                    stats.setHiclikDirenci(player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
                                }
                            }

                            break;
                    }
                }

            }
        }
    }


    @EventHandler
    public void armorbroke(PlayerArmorChangeEvent event) {
        Player p = event.getPlayer();
        ItemStack item2 = event.getOldItem();
        ItemStack item = event.getNewItem();
        for (ItemStack armoritem : joinListener.getArmor().get(p.getUniqueId())) {
            if (item2.equals(armoritem)) {
                joinListener.getArmor().remove(p.getUniqueId());
                return;
            }
        }
        if (MaterialTags.CHESTPLATES.isTagged(item) || MaterialTags.LEGGINGS.isTagged(item) || MaterialTags.BOOTS.isTagged(item) || MaterialTags.HELMETS.isTagged(item)) {
            if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                ItemMeta meta = item.getItemMeta();
                PersistentDataContainer container = meta.getPersistentDataContainer();
                NamespacedKey can = new NamespacedKey(plugin, "can");
                NamespacedKey doygunluk = new NamespacedKey(plugin, "doygunluk");
                NamespacedKey canyenilenmesi = new NamespacedKey(plugin, "canyenilenmesi");
                NamespacedKey saldirihizi = new NamespacedKey(plugin, "attackspeed");
                NamespacedKey guc = new NamespacedKey(plugin, "guc");
                NamespacedKey zirh = new NamespacedKey(plugin, "dayaniklilik");
                NamespacedKey kritiksansi = new NamespacedKey(plugin, "kritiksans");
                NamespacedKey kritikhasari = new NamespacedKey(plugin, "kritik");
                NamespacedKey hiz = new NamespacedKey(plugin, "hiz");
                NamespacedKey sogukdi = new NamespacedKey(plugin, "sogukdirenci");
                NamespacedKey sicakdi = new NamespacedKey(plugin, "sicakdirenci");
                NamespacedKey hiclikdi = new NamespacedKey(plugin, "hiclikdirenci");
                for (NamespacedKey key : container.getKeys()) {
                    if (key.equals(can)) {
                        stats.setCan(p, p.getUniqueId(), container.get(key, PersistentDataType.INTEGER));

                    } else if (key.equals(canyenilenmesi)) {
                        stats.setCanYenileme(p, p.getUniqueId(),
                                container.get(key, PersistentDataType.INTEGER));
                    } else if (key.equals(guc)) {
                        stats.setGuc(p.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
                    } else if (key.equals(zirh)) {
                        stats.setDirenc(p.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
                    } else if (key.equals(doygunluk)) {
                        stats.setDoygunluk(p, p.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
                    } else if (key.equals(saldirihizi)) {
                        stats.setSaldiriHizi(p.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
                    } else if (key.equals(kritikhasari)) {
                        stats.setKritikHasari(p.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
                    } else if (key.equals(kritiksansi)) {
                        stats.setKritikSansi(p.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
                    } else if (key.equals(hiz)) {
                        stats.setHiz(p, p.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
                    } else if (key.equals(sogukdi)) {
                        stats.setSogukDirenci(p.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
                    } else if (key.equals(sicakdi)) {
                        stats.setSicakDirenci(p.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
                    } else if (key.equals(hiclikdi)) {
                        stats.setHiclikDirenci(p.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
                    }
                }
            }
        }
        if (MaterialTags.CHESTPLATES.isTagged(item2) || MaterialTags.LEGGINGS.isTagged(item2) || MaterialTags.BOOTS.isTagged(item2) || MaterialTags.HELMETS.isTagged(item2)) {
            if (item2.hasItemMeta() && item2.getItemMeta().getPersistentDataContainer() != null) {
                ItemMeta meta = item2.getItemMeta();
                PersistentDataContainer container = meta.getPersistentDataContainer();
                NamespacedKey can = new NamespacedKey(plugin, "can");
                NamespacedKey doygunluk = new NamespacedKey(plugin, "doygunluk");
                NamespacedKey canyenilenmesi = new NamespacedKey(plugin, "canyenilenmesi");
                NamespacedKey saldirihizi = new NamespacedKey(plugin, "attackspeed");
                NamespacedKey guc = new NamespacedKey(plugin, "guc");
                NamespacedKey zirh = new NamespacedKey(plugin, "dayaniklilik");
                NamespacedKey kritiksansi = new NamespacedKey(plugin, "kritiksans");
                NamespacedKey kritikhasari = new NamespacedKey(plugin, "kritik");
                NamespacedKey hiz = new NamespacedKey(plugin, "hiz");
                NamespacedKey sogukdi = new NamespacedKey(plugin, "sogukdirenci");
                NamespacedKey sicakdi = new NamespacedKey(plugin, "sicakdirenci");
                NamespacedKey hiclikdi = new NamespacedKey(plugin, "hiclikdirenci");
                for (NamespacedKey key : container.getKeys()) {
                    if (key.equals(can)) {
                        stats.setCan(p, p.getUniqueId(), -container.get(key, PersistentDataType.INTEGER));

                    } else if (key.equals(canyenilenmesi)) {
                        stats.setCanYenileme(p, p.getUniqueId(),
                                -container.get(key, PersistentDataType.INTEGER));
                    } else if (key.equals(guc)) {
                        stats.setGuc(p.getUniqueId(), -container.get(key, PersistentDataType.INTEGER));
                    } else if (key.equals(zirh)) {
                        stats.setDirenc(p.getUniqueId(), -container.get(key, PersistentDataType.INTEGER));
                    } else if (key.equals(doygunluk)) {
                        stats.setDoygunluk(p, p.getUniqueId(), -container.get(key, PersistentDataType.INTEGER));
                    } else if (key.equals(saldirihizi)) {
                        stats.setSaldiriHizi(p.getUniqueId(), -container.get(key, PersistentDataType.INTEGER));
                    } else if (key.equals(kritikhasari)) {
                        stats.setKritikHasari(p.getUniqueId(), -container.get(key, PersistentDataType.INTEGER));
                    } else if (key.equals(kritiksansi)) {
                        stats.setKritikSansi(p.getUniqueId(), -container.get(key, PersistentDataType.INTEGER));
                    } else if (key.equals(hiz)) {
                        stats.setHiz(p, p.getUniqueId(), -container.get(key, PersistentDataType.INTEGER));
                    } else if (key.equals(sogukdi)) {
                        stats.setSogukDirenci(p.getUniqueId(), -container.get(key, PersistentDataType.INTEGER));
                    } else if (key.equals(sicakdi)) {
                        stats.setSicakDirenci(p.getUniqueId(), -container.get(key, PersistentDataType.INTEGER));
                    } else if (key.equals(hiclikdi)) {
                        stats.setHiclikDirenci(p.getUniqueId(), -container.get(key, PersistentDataType.INTEGER));
                    }
                }
            }
        }
    }


}
