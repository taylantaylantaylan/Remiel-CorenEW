//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package me.taylan.mooncore.listeners;

import com.destroystokyo.paper.MaterialTags;
import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.UUID;
import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.Painter;
import me.taylan.mooncore.utils.StatsManager;
import org.apache.commons.lang.ArrayUtils;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class AccessoryListener implements Listener {
    private final MoonCore plugin;
    private final StatsManager stats;
    private final JoinListener joinListener;

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
        FileConfiguration var10000 = (FileConfiguration)this.stats.getStatfile().get(player.getUniqueId());
        if (player.getInventory().getItemInMainHand() != null) {
            if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                if (event.getClickedBlock() != null && this.plugin.getConfig().getStringList("blocked").contains(event.getClickedBlock().getType().toString())) {
                    return;
                }

                ItemStack item = player.getInventory().getItemInMainHand();
                if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                    ItemMeta meta = item.getItemMeta();
                    PersistentDataContainer container = meta.getPersistentDataContainer();
                    NamespacedKey type = new NamespacedKey(this.plugin, "type");
                    NamespacedKey name = new NamespacedKey(this.plugin, "name");
                    NamespacedKey can = new NamespacedKey(this.plugin, "can");
                    NamespacedKey doygunluk = new NamespacedKey(this.plugin, "doygunluk");
                    NamespacedKey canyenilenmesi = new NamespacedKey(this.plugin, "canyenilenmesi");
                    NamespacedKey saldirihizi = new NamespacedKey(this.plugin, "attackspeed");
                    NamespacedKey guc = new NamespacedKey(this.plugin, "guc");
                    NamespacedKey zirh = new NamespacedKey(this.plugin, "dayaniklilik");
                    NamespacedKey kritiksansi = new NamespacedKey(this.plugin, "kritiksans");
                    NamespacedKey kritikhasari = new NamespacedKey(this.plugin, "kritik");
                    NamespacedKey hiz = new NamespacedKey(this.plugin, "hiz");
                    NamespacedKey sogukdi = new NamespacedKey(this.plugin, "sogukdirenci");
                    NamespacedKey sicakdi = new NamespacedKey(this.plugin, "sicakdirenci");
                    NamespacedKey hiclikdi = new NamespacedKey(this.plugin, "hiclikdirenci");
                    if (container.has(type) && container.has(name)) {
                        String aksesuartype = (String)container.get(type, PersistentDataType.STRING);
                        String aksesuarname = (String)container.get(name, PersistentDataType.STRING);
                        ArrayList<ItemStack> list = (ArrayList)this.stats.getHepsi(uuid);
                        Iterator var27;
                        NamespacedKey key;
                        switch (Objects.requireNonNull(aksesuartype)) {
                            case "Tılsım":
                                if (this.stats.getTilsim(player.getUniqueId()).equals("<dark_gray>Yok..")) {
                                    this.stats.setTilsim(uuid, aksesuarname);
                                    list.set(0, player.getInventory().getItemInMainHand());
                                    this.stats.setHepsi(uuid, list);
                                    player.getInventory().setItemInMainHand((ItemStack)null);
                                    player.playSound(player, Sound.ITEM_ARMOR_EQUIP_GENERIC, 2.0F, 1.1F);
                                    var27 = container.getKeys().iterator();

                                    while(var27.hasNext()) {
                                        key = (NamespacedKey)var27.next();
                                        if (key.equals(can)) {
                                            player.damage(0.01);
                                            this.stats.setCan(player, player.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                                        } else if (key.equals(canyenilenmesi)) {
                                            this.stats.setCanYenileme(player, player.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                                        } else if (key.equals(guc)) {
                                            this.stats.setGuc(player.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                                        } else if (key.equals(zirh)) {
                                            this.stats.setDirenc(player.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                                        } else if (key.equals(doygunluk)) {
                                            this.stats.setDoygunluk(player, player.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                                        } else if (key.equals(saldirihizi)) {
                                            this.stats.setSaldiriHizi(player.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                                        } else if (key.equals(kritikhasari)) {
                                            this.stats.setKritikHasari(player.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                                        } else if (key.equals(kritiksansi)) {
                                            this.stats.setKritikSansi(player.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                                        } else if (key.equals(hiz)) {
                                            this.stats.setHiz(player, player.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                                        } else if (key.equals(sogukdi)) {
                                            this.stats.setSogukDirenci(player.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                                        } else if (key.equals(sicakdi)) {
                                            this.stats.setSicakDirenci(player.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                                        } else if (key.equals(hiclikdi)) {
                                            this.stats.setHiclikDirenci(player.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                                        }
                                    }
                                }
                                break;
                            case "Eldiven":
                                if (this.stats.getEldiven(player.getUniqueId()).equals("<dark_gray>Yok..")) {
                                    this.stats.setEldiven(uuid, aksesuarname);
                                    list.set(1, player.getInventory().getItemInMainHand());
                                    this.stats.setHepsi(uuid, list);
                                    player.getInventory().setItemInMainHand((ItemStack)null);
                                    player.playSound(player, Sound.ITEM_ARMOR_EQUIP_GENERIC, 2.0F, 1.1F);
                                    var27 = container.getKeys().iterator();

                                    while(var27.hasNext()) {
                                        key = (NamespacedKey)var27.next();
                                        if (key.equals(can)) {
                                            player.damage(0.01);
                                            this.stats.setCan(player, player.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                                        } else if (key.equals(canyenilenmesi)) {
                                            this.stats.setCanYenileme(player, player.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                                        } else if (key.equals(guc)) {
                                            this.stats.setGuc(player.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                                        } else if (key.equals(zirh)) {
                                            this.stats.setDirenc(player.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                                        } else if (key.equals(doygunluk)) {
                                            this.stats.setDoygunluk(player, player.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                                        } else if (key.equals(saldirihizi)) {
                                            this.stats.setSaldiriHizi(player.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                                        } else if (key.equals(kritikhasari)) {
                                            this.stats.setKritikHasari(player.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                                        } else if (key.equals(kritiksansi)) {
                                            this.stats.setKritikSansi(player.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                                        } else if (key.equals(hiz)) {
                                            this.stats.setHiz(player, player.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                                        } else if (key.equals(sogukdi)) {
                                            this.stats.setSogukDirenci(player.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                                        } else if (key.equals(sicakdi)) {
                                            this.stats.setSicakDirenci(player.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                                        } else if (key.equals(hiclikdi)) {
                                            this.stats.setHiclikDirenci(player.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                                        }
                                    }
                                }
                                break;
                            case "Kolye":
                                if (this.stats.getKolye(player.getUniqueId()).equals("<dark_gray>Yok..")) {
                                    this.stats.setKolye(uuid, aksesuarname);
                                    list.set(2, player.getInventory().getItemInMainHand());
                                    this.stats.setHepsi(uuid, list);
                                    player.getInventory().setItemInMainHand((ItemStack)null);
                                    player.playSound(player, Sound.ITEM_ARMOR_EQUIP_GENERIC, 2.0F, 1.1F);
                                    var27 = container.getKeys().iterator();

                                    while(var27.hasNext()) {
                                        key = (NamespacedKey)var27.next();
                                        if (key.equals(can)) {
                                            player.damage(0.01);
                                            this.stats.setCan(player, player.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                                        } else if (key.equals(canyenilenmesi)) {
                                            this.stats.setCanYenileme(player, player.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                                        } else if (key.equals(guc)) {
                                            this.stats.setGuc(player.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                                        } else if (key.equals(zirh)) {
                                            this.stats.setDirenc(player.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                                        } else if (key.equals(doygunluk)) {
                                            this.stats.setDoygunluk(player, player.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                                        } else if (key.equals(saldirihizi)) {
                                            this.stats.setSaldiriHizi(player.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                                        } else if (key.equals(kritikhasari)) {
                                            this.stats.setKritikHasari(player.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                                        } else if (key.equals(kritiksansi)) {
                                            this.stats.setKritikSansi(player.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                                        } else if (key.equals(hiz)) {
                                            this.stats.setHiz(player, player.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                                        } else if (key.equals(sogukdi)) {
                                            this.stats.setSogukDirenci(player.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                                        } else if (key.equals(sicakdi)) {
                                            this.stats.setSicakDirenci(player.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                                        } else if (key.equals(hiclikdi)) {
                                            this.stats.setHiclikDirenci(player.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                                        }
                                    }
                                }
                                break;
                            case "Yüzük":
                                if (this.stats.getYuzuk(player.getUniqueId()).equals("<dark_gray>Yok..")) {
                                    this.stats.setYuzuk(uuid, aksesuarname);
                                    list.set(3, player.getInventory().getItemInMainHand());
                                    this.stats.setHepsi(uuid, list);
                                    player.getInventory().setItemInMainHand((ItemStack)null);
                                    player.playSound(player, Sound.ITEM_ARMOR_EQUIP_GENERIC, 2.0F, 1.1F);
                                    var27 = container.getKeys().iterator();

                                    while(var27.hasNext()) {
                                        key = (NamespacedKey)var27.next();
                                        if (key.equals(can)) {
                                            player.damage(0.01);
                                            this.stats.setCan(player, player.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                                        } else if (key.equals(canyenilenmesi)) {
                                            this.stats.setCanYenileme(player, player.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                                        } else if (key.equals(guc)) {
                                            this.stats.setGuc(player.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                                        } else if (key.equals(zirh)) {
                                            this.stats.setDirenc(player.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                                        } else if (key.equals(doygunluk)) {
                                            this.stats.setDoygunluk(player, player.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                                        } else if (key.equals(saldirihizi)) {
                                            this.stats.setSaldiriHizi(player.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                                        } else if (key.equals(kritikhasari)) {
                                            this.stats.setKritikHasari(player.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                                        } else if (key.equals(kritiksansi)) {
                                            this.stats.setKritikSansi(player.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                                        } else if (key.equals(hiz)) {
                                            this.stats.setHiz(player, player.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                                        } else if (key.equals(sogukdi)) {
                                            this.stats.setSogukDirenci(player.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                                        } else if (key.equals(sicakdi)) {
                                            this.stats.setSicakDirenci(player.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                                        } else if (key.equals(hiclikdi)) {
                                            this.stats.setHiclikDirenci(player.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                                        }
                                    }
                                }
                        }
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
        NamespacedKey lvlrequirement = new NamespacedKey(this.plugin, "lvlrequirement");
        if (item != null && item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null && item.getItemMeta().getPersistentDataContainer().has(lvlrequirement) && this.stats.getLevel(p.getUniqueId()) < (Integer)item.getItemMeta().getPersistentDataContainer().get(lvlrequirement, PersistentDataType.INTEGER)) {
            p.sendMessage(Painter.paint("&cSeviyen ekipmanı kullanmak için gereken seviyeden düşük!"));
        } else if (item2 != null && item2.hasItemMeta() && item2.getItemMeta().getPersistentDataContainer() != null && item2.getItemMeta().getPersistentDataContainer().has(lvlrequirement) && this.stats.getLevel(p.getUniqueId()) < (Integer)item2.getItemMeta().getPersistentDataContainer().get(lvlrequirement, PersistentDataType.INTEGER)) {
            p.sendMessage(Painter.paint("&cSeviyen ekipmanı kullanmak için gereken seviyeden düşük!"));
        } else {
            if (this.joinListener.getArmor().containsKey(p.getUniqueId())) {
                ItemStack[] var6 = (ItemStack[])this.joinListener.getArmor().get(p.getUniqueId());
                int var7 = var6.length;

                for (ItemStack armoritem : var6) {
                    if (Objects.requireNonNull(item2).equals(armoritem) || Objects.requireNonNull(item).equals(armoritem)) {
                        ArrayUtils.remove((Object[]) this.joinListener.getArmor().get(p.getUniqueId()), ArrayUtils.indexOf((Object[]) this.joinListener.getArmor().get(p.getUniqueId()), armoritem));
                        if (((ItemStack[]) this.joinListener.getArmor().get(p.getUniqueId())).length == 0) {
                            this.joinListener.getArmor().remove(p.getUniqueId());
                        }

                        return;
                    }
                }
            }

            NamespacedKey canyenilenmesi;
            NamespacedKey saldirihizi;
            NamespacedKey guc;
            NamespacedKey zirh;
            NamespacedKey kritiksansi;
            NamespacedKey kritikhasari;
            NamespacedKey hiz;
            NamespacedKey sogukdi;
            NamespacedKey sicakdi;
            NamespacedKey hiclikdi;
            Iterator var20;
            NamespacedKey key;
            ItemMeta meta;
            PersistentDataContainer container;
            NamespacedKey can;
            NamespacedKey doygunluk;
            if ((MaterialTags.CHESTPLATES.isTagged(Objects.requireNonNull(item)) || MaterialTags.LEGGINGS.isTagged(item) || MaterialTags.BOOTS.isTagged(item) || MaterialTags.HELMETS.isTagged(item)) && item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                meta = item.getItemMeta();
                container = meta.getPersistentDataContainer();
                can = new NamespacedKey(this.plugin, "can");
                doygunluk = new NamespacedKey(this.plugin, "doygunluk");
                canyenilenmesi = new NamespacedKey(this.plugin, "canyenilenmesi");
                saldirihizi = new NamespacedKey(this.plugin, "attackspeed");
                guc = new NamespacedKey(this.plugin, "guc");
                zirh = new NamespacedKey(this.plugin, "dayaniklilik");
                kritiksansi = new NamespacedKey(this.plugin, "kritiksans");
                kritikhasari = new NamespacedKey(this.plugin, "kritik");
                hiz = new NamespacedKey(this.plugin, "hiz");
                sogukdi = new NamespacedKey(this.plugin, "sogukdirenci");
                sicakdi = new NamespacedKey(this.plugin, "sicakdirenci");
                hiclikdi = new NamespacedKey(this.plugin, "hiclikdirenci");
                var20 = container.getKeys().iterator();

                while(var20.hasNext()) {
                    key = (NamespacedKey)var20.next();
                    if (key.equals(can)) {
                        this.stats.setCan(p, p.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                    } else if (key.equals(canyenilenmesi)) {
                        this.stats.setCanYenileme(p, p.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                    } else if (key.equals(guc)) {
                        this.stats.setGuc(p.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                    } else if (key.equals(zirh)) {
                        this.stats.setDirenc(p.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                    } else if (key.equals(doygunluk)) {
                        this.stats.setDoygunluk(p, p.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                    } else if (key.equals(saldirihizi)) {
                        this.stats.setSaldiriHizi(p.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                    } else if (key.equals(kritikhasari)) {
                        this.stats.setKritikHasari(p.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                    } else if (key.equals(kritiksansi)) {
                        this.stats.setKritikSansi(p.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                    } else if (key.equals(hiz)) {
                        this.stats.setHiz(p, p.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                    } else if (key.equals(sogukdi)) {
                        this.stats.setSogukDirenci(p.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                    } else if (key.equals(sicakdi)) {
                        this.stats.setSicakDirenci(p.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                    } else if (key.equals(hiclikdi)) {
                        this.stats.setHiclikDirenci(p.getUniqueId(), (Integer)container.get(key, PersistentDataType.INTEGER));
                    }
                }
            }

            if ((MaterialTags.CHESTPLATES.isTagged(Objects.requireNonNull(item2)) || MaterialTags.LEGGINGS.isTagged(item2) || MaterialTags.BOOTS.isTagged(item2) || MaterialTags.HELMETS.isTagged(item2)) && item2.hasItemMeta() && item2.getItemMeta().getPersistentDataContainer() != null) {
                meta = item2.getItemMeta();
                container = meta.getPersistentDataContainer();
                can = new NamespacedKey(this.plugin, "can");
                doygunluk = new NamespacedKey(this.plugin, "doygunluk");
                canyenilenmesi = new NamespacedKey(this.plugin, "canyenilenmesi");
                saldirihizi = new NamespacedKey(this.plugin, "attackspeed");
                guc = new NamespacedKey(this.plugin, "guc");
                zirh = new NamespacedKey(this.plugin, "dayaniklilik");
                kritiksansi = new NamespacedKey(this.plugin, "kritiksans");
                kritikhasari = new NamespacedKey(this.plugin, "kritik");
                hiz = new NamespacedKey(this.plugin, "hiz");
                sogukdi = new NamespacedKey(this.plugin, "sogukdirenci");
                sicakdi = new NamespacedKey(this.plugin, "sicakdirenci");
                hiclikdi = new NamespacedKey(this.plugin, "hiclikdirenci");
                var20 = container.getKeys().iterator();

                while(var20.hasNext()) {
                    key = (NamespacedKey)var20.next();
                    if (key.equals(can)) {
                        this.stats.setCan(p, p.getUniqueId(), -(Integer)container.get(key, PersistentDataType.INTEGER));
                    } else if (key.equals(canyenilenmesi)) {
                        this.stats.setCanYenileme(p, p.getUniqueId(), -(Integer)container.get(key, PersistentDataType.INTEGER));
                    } else if (key.equals(guc)) {
                        this.stats.setGuc(p.getUniqueId(), -(Integer)container.get(key, PersistentDataType.INTEGER));
                    } else if (key.equals(zirh)) {
                        this.stats.setDirenc(p.getUniqueId(), -(Integer)container.get(key, PersistentDataType.INTEGER));
                    } else if (key.equals(doygunluk)) {
                        this.stats.setDoygunluk(p, p.getUniqueId(), -(Integer)container.get(key, PersistentDataType.INTEGER));
                    } else if (key.equals(saldirihizi)) {
                        this.stats.setSaldiriHizi(p.getUniqueId(), -(Integer)container.get(key, PersistentDataType.INTEGER));
                    } else if (key.equals(kritikhasari)) {
                        this.stats.setKritikHasari(p.getUniqueId(), -(Integer)container.get(key, PersistentDataType.INTEGER));
                    } else if (key.equals(kritiksansi)) {
                        this.stats.setKritikSansi(p.getUniqueId(), -(Integer)container.get(key, PersistentDataType.INTEGER));
                    } else if (key.equals(hiz)) {
                        this.stats.setHiz(p, p.getUniqueId(), -(Integer)container.get(key, PersistentDataType.INTEGER));
                    } else if (key.equals(sogukdi)) {
                        this.stats.setSogukDirenci(p.getUniqueId(), -(Integer)container.get(key, PersistentDataType.INTEGER));
                    } else if (key.equals(sicakdi)) {
                        this.stats.setSicakDirenci(p.getUniqueId(), -(Integer)container.get(key, PersistentDataType.INTEGER));
                    } else if (key.equals(hiclikdi)) {
                        this.stats.setHiclikDirenci(p.getUniqueId(), -(Integer)container.get(key, PersistentDataType.INTEGER));
                    }
                }
            }

        }
    }
}
