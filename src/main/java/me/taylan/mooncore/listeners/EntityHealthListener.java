package me.taylan.mooncore.listeners;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.listeners.entitydamage.SpawnArmorStand;
import me.taylan.mooncore.utils.ItemHandler;
import me.taylan.mooncore.utils.Painter;
import me.taylan.mooncore.utils.StatsManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class EntityHealthListener implements Listener {
    private MoonCore plugin;
    private ItemHandler itemHandler;
    private StatsManager stats;
    private HashMap<UUID, String> talkmap = new HashMap<>();
    private HashMap<UUID, String> itemmap = new HashMap<>();
    private HashMap<UUID, Integer> questmap = new HashMap<>();

    public EntityHealthListener(MoonCore plugin) {
        this.plugin = plugin;
        this.itemHandler = plugin.getItemHandler();
        this.stats = plugin.getStatsManager();
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void entityregainhealth(EntityRegainHealthEvent event) {
        Entity entity = event.getEntity();
        if (!(entity instanceof Player)) {
            return;
        }
        Player player = (Player) entity;
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        if (scoreboard.getTeam(player.getName()) == null) {
            scoreboard.registerNewTeam(player.getName());
        }
        Team isim = scoreboard.getTeam(player.getName());
        if (isim.hasEntry(player.getName())) {
            isim.setPrefix(Painter.paint("&7[&fSvy. " + stats.getLevel(player.getUniqueId()) + "&7] &f"));
            isim.setSuffix(Painter.paint(" &6[" + (int) player.getHealth() + "❤]"));
        } else {
            isim.addEntry(player.getName());
            isim.setPrefix(Painter.paint("&7[&fSvy. " + stats.getLevel(player.getUniqueId()) + "&7] &f"));
            isim.setSuffix(Painter.paint(" &6[" + (int) player.getHealth() + "❤]"));
        }
    }

    @EventHandler
    public void npctalk(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();
        Entity entity = event.getRightClicked();
        if (entity instanceof Villager) {
            if (!(talkmap.containsKey(player.getUniqueId()))) {
                if (entity.getName().contains("Valadir")) {
                    talkmap.put(player.getUniqueId(), "konustu");
                    new BukkitRunnable() {
                        int i = 0;

                        @Override
                        public void run() {
                            switch (i) {
                                case 0:
                                    i++;
                                    BossBar bb = Bukkit.getBossBar(new NamespacedKey(plugin, "gorev1"));
                                    bb.setProgress(1.0);
                                    ArmorStand stand = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.3, 0), "<white>Merhaba Gezgin. Ben Valadir. Filoya katılmadan önce temel eğitim");
                                    for (Player player2 : Bukkit.getOnlinePlayers()) {
                                        if (player.getWorld().getName().equals("dungeonworld")) {
                                            if (player2 == player) continue;
                                            player2.hideEntity(plugin, stand);
                                        }
                                    }
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            stand.remove();
                                        }
                                    }.runTaskLater(plugin, 70);
                                    break;
                                case 1:
                                    i++;
                                    ArmorStand stand2 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.3, 0), "<white>alman gerek. İlk olarak özelliklerinden başlayalım. /profil komudunu");
                                    for (Player player2 : Bukkit.getOnlinePlayers()) {
                                        if (player.getWorld().getName().equals("dungeonworld")) {
                                            if (player2 == player) continue;
                                            player2.hideEntity(plugin, stand2);
                                        }
                                    }
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            stand2.remove();
                                        }
                                    }.runTaskLater(plugin, 70);
                                    break;
                                case 2:
                                    i++;
                                    ArmorStand stand3 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.3, 0), "<white>kullanarak bilgilerine bakabilirsin. <gold>Dinçlik <white>senin sağlığını gösterir.");
                                    for (Player player2 : Bukkit.getOnlinePlayers()) {
                                        if (player.getWorld().getName().equals("dungeonworld")) {
                                            if (player2 == player) continue;
                                            player2.hideEntity(plugin, stand3);
                                        }
                                    }
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            stand3.remove();
                                        }
                                    }.runTaskLater(plugin, 70);
                                    break;
                                case 3:
                                    i++;
                                    ArmorStand stand4 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.3, 0), "<green>Dayanıklılık <white>aldığın hasarların etkisini azaltır.");
                                    for (Player player2 : Bukkit.getOnlinePlayers()) {
                                        if (player.getWorld().getName().equals("dungeonworld")) {
                                            if (player2 == player) continue;
                                            player2.hideEntity(plugin, stand4);
                                        }
                                    }
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            stand4.remove();
                                        }
                                    }.runTaskLater(plugin, 70);
                                    break;
                                case 4:
                                    i++;
                                    ArmorStand stand5 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.3, 0), "<red>Güç <white>yakın dövüşte vereceğin hasarı belirler. Ne kadar");
                                    for (Player player2 : Bukkit.getOnlinePlayers()) {
                                        if (player.getWorld().getName().equals("dungeonworld")) {
                                            if (player2 == player) continue;
                                            player2.hideEntity(plugin, stand5);
                                        }
                                    }
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            stand5.remove();
                                        }
                                    }.runTaskLater(plugin, 70);
                                    break;
                                case 5:
                                    i++;
                                    ArmorStand stand6 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.3, 0), "<white>güçlüysen o kadar sert vurursun. <yellow>Denge <white>saldırı hızındır.");
                                    for (Player player2 : Bukkit.getOnlinePlayers()) {
                                        if (player.getWorld().getName().equals("dungeonworld")) {
                                            if (player2 == player) continue;
                                            player2.hideEntity(plugin, stand6);
                                        }
                                    }
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            stand6.remove();
                                        }
                                    }.runTaskLater(plugin, 70);
                                    break;
                                case 6:
                                    i++;
                                    ArmorStand stand7 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.3, 0), "<white>Dengen ne kadar yüksekse rakibe vuruşların daha isabetli olur.");
                                    for (Player player2 : Bukkit.getOnlinePlayers()) {
                                        if (player.getWorld().getName().equals("dungeonworld")) {
                                            if (player2 == player) continue;
                                            player2.hideEntity(plugin, stand7);
                                        }
                                    }
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            stand7.remove();
                                        }
                                    }.runTaskLater(plugin, 70);
                                    break;
                                case 7:
                                    i++;
                                    ArmorStand stand8 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.3, 0), "<white>Ayrıca dengene bağlı olarak bir vuruşu birden fazla kez yapabilirsin.");
                                    for (Player player2 : Bukkit.getOnlinePlayers()) {
                                        if (player.getWorld().getName().equals("dungeonworld")) {
                                            if (player2 == player) continue;
                                            player2.hideEntity(plugin, stand8);
                                        }
                                    }
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            stand8.remove();
                                        }
                                    }.runTaskLater(plugin, 70);
                                    break;
                                case 8:
                                    i++;
                                    ArmorStand stand9 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.3, 0), "<white>Çeviklik ne kadar hızlı hareket ettiğini belirler.");
                                    for (Player player2 : Bukkit.getOnlinePlayers()) {
                                        if (player.getWorld().getName().equals("dungeonworld")) {
                                            if (player2 == player) continue;
                                            player2.hideEntity(plugin, stand9);
                                        }
                                    }
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            stand9.remove();
                                        }
                                    }.runTaskLater(plugin, 70);
                                    break;
                                case 9:
                                    i++;
                                    ArmorStand stand10 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.3, 0), "<dark_aqua>Hüner <white>kritik vuruşlarını belirler. Hünerli biri yani, Silahını");
                                    for (Player player2 : Bukkit.getOnlinePlayers()) {
                                        if (player.getWorld().getName().equals("dungeonworld")) {
                                            if (player2 == player) continue;
                                            player2.hideEntity(plugin, stand10);
                                        }
                                    }
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            stand10.remove();
                                        }
                                    }.runTaskLater(plugin, 70);
                                    break;
                                case 10:
                                    i++;
                                    ArmorStand stand11 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.3, 0), "<white>iyi kullanan bir kişi rakibin zayıf noktalarını daha iyi görebilir. Buralarda");
                                    for (Player player2 : Bukkit.getOnlinePlayers()) {
                                        if (player.getWorld().getName().equals("dungeonworld")) {
                                            if (player2 == player) continue;
                                            player2.hideEntity(plugin, stand11);
                                        }
                                    }
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            stand11.remove();

                                        }
                                    }.runTaskLater(plugin, 70);
                                    break;
                                case 11:
                                    i++;
                                    ArmorStand stand12 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.3, 0), "<white>Demirci Ulur var. Onu Bulup eğitimine devam edebilirsin. Patikayı takip et.");
                                    for (Player player2 : Bukkit.getOnlinePlayers()) {
                                        if (player.getWorld().getName().equals("dungeonworld")) {
                                            if (player2 == player) continue;
                                            player2.hideEntity(plugin, stand12);
                                        }
                                    }
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            stand12.remove();

                                        }
                                    }.runTaskLater(plugin, 70);
                                    break;
                                case 12:
                                    i = 0;
                                    player.sendMessage(Painter.paint("&fGörev: &6Demirci Ulur'u bul."));
                                    BossBar bb23133 = Bukkit.getBossBar(new NamespacedKey(plugin, "gorev1"));
                                    bb23133.removePlayer(player);
                                    BossBar bb2 = Bukkit.createBossBar(new NamespacedKey(plugin, "gorev2"), Painter.paint("&6Demirci Ulur'u bul."), BarColor.YELLOW, BarStyle.SOLID);
                                    bb2.addPlayer(player);

                                    questmap.put(player.getUniqueId(), 1);
                                    talkmap.remove(player.getUniqueId());
                                    cancel();
                                    break;
                            }


                        }
                    }.runTaskTimer(plugin, 0, 75);
                } else if (entity.getName().contains("Ulur")) {
                    if (questmap.get(player.getUniqueId()) == 1) {
                        talkmap.put(player.getUniqueId(), "konustu");
                        if (player.getInventory().getItemInMainHand() != null && player.getInventory().getItemInMainHand().hasItemMeta()) {
                            if (player.getInventory().getItemInMainHand().hasItemMeta() && player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Meşe Yay")) {
                                player.getInventory().getItemInMainHand().setType(Material.AIR);
                                new BukkitRunnable() {
                                    int i = 0;

                                    @Override
                                    public void run() {
                                        switch (i) {
                                            case 0:
                                                for(ItemStack item: player.getInventory().getContents()) {
                                                    if (player.getInventory().getItemInMainHand().hasItemMeta() && player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Meşe Yay")) {
                                                        player.getInventory().remove(item);
                                                    }
                                                }
                                                i++;
                                                BossBar bb = Bukkit.getBossBar(new NamespacedKey(plugin, "gorev3"));
                                                bb.setProgress(1.0);
                                                ArmorStand stand = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.3, 0), "<white>Ne kadar teşekkür etsem azdır. Sanırım az çok ekipman yapmayı");
                                                for (Player player2 : Bukkit.getOnlinePlayers()) {
                                                    if (player.getWorld().getName().equals("dungeonworld")) {
                                                        if (player2 == player) continue;
                                                        player2.hideEntity(plugin, stand);
                                                    }
                                                }
                                                new BukkitRunnable() {
                                                    @Override
                                                    public void run() {
                                                        stand.remove();
                                                    }
                                                }.runTaskLater(plugin, 70);
                                                break;
                                            case 1:
                                                i++;
                                                ArmorStand stand2 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.3, 0), "<white>Öğrenmişsindir. Patikayı takip et ve <yellow>Alex'i <white>Bul.");
                                                for (Player player2 : Bukkit.getOnlinePlayers()) {
                                                    if (player.getWorld().getName().equals("dungeonworld")) {
                                                        if (player2 == player) continue;
                                                        player2.hideEntity(plugin, stand2);
                                                    }
                                                }
                                                new BukkitRunnable() {
                                                    @Override
                                                    public void run() {
                                                        stand2.remove();
                                                    }
                                                }.runTaskLater(plugin, 70);
                                                break;
                                            case 2:
                                                i++;
                                                ArmorStand stand3 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.3, 0), "<white>Sana aksesuarlarını nasıl kullanacağını öğreticek.");
                                                for (Player player2 : Bukkit.getOnlinePlayers()) {
                                                    if (player.getWorld().getName().equals("dungeonworld")) {
                                                        if (player2 == player) continue;
                                                        player2.hideEntity(plugin, stand3);
                                                    }
                                                }
                                                new BukkitRunnable() {
                                                    @Override
                                                    public void run() {
                                                        stand3.remove();
                                                    }
                                                }.runTaskLater(plugin, 70);
                                                break;
                                            case 3:
                                                i = 0;
                                                player.sendMessage(Painter.paint("&fGörev: &6Alex'i bul."));
                                                BossBar bb2313 = Bukkit.getBossBar(new NamespacedKey(plugin, "gorev3"));
                                                bb2313.removePlayer(player);
                                                BossBar bb2 = Bukkit.createBossBar(new NamespacedKey(plugin, "gorev4"), Painter.paint("&6Alex'i Bul."), BarColor.YELLOW, BarStyle.SOLID);
                                                bb2.addPlayer(player);
                                                questmap.put(player.getUniqueId(), questmap.get(player.getUniqueId()) + 1);
                                                talkmap.remove(player.getUniqueId());
                                                cancel();
                                                break;

                                        }


                                    }
                                }.runTaskTimer(plugin, 0, 75);
                            }
                        } else {
                            new BukkitRunnable() {
                                int i = 0;

                                @Override
                                public void run() {
                                    switch (i) {
                                        case 0:
                                            i++;
                                            BossBar bb = Bukkit.getBossBar(new NamespacedKey(plugin, "gorev2"));
                                            bb.setProgress(1.0);
                                            ArmorStand stand = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.3, 0), "<white>Hoşgeldin! Kusura bakma etraf biraz dağınık bir siparişimi hazırlıyordum.");
                                            for (Player player2 : Bukkit.getOnlinePlayers()) {
                                                if (player.getWorld().getName().equals("dungeonworld")) {
                                                    if (player2 == player) continue;
                                                    player2.hideEntity(plugin, stand);
                                                }
                                            }
                                            new BukkitRunnable() {
                                                @Override
                                                public void run() {
                                                    stand.remove();
                                                }
                                            }.runTaskLater(plugin, 70);
                                            break;
                                        case 1:
                                            i++;
                                            ArmorStand stand2 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.3, 0), "<white>Zanaatkarlık öğrenmen için <yellow>Valadir <white>yolladı sanırım.");
                                            for (Player player2 : Bukkit.getOnlinePlayers()) {
                                                if (player.getWorld().getName().equals("dungeonworld")) {
                                                    if (player2 == player) continue;
                                                    player2.hideEntity(plugin, stand2);
                                                }
                                            }
                                            new BukkitRunnable() {
                                                @Override
                                                public void run() {
                                                    stand2.remove();
                                                }
                                            }.runTaskLater(plugin, 70);
                                            break;
                                        case 2:
                                            i++;
                                            ArmorStand stand3 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.3, 0), "<white>Ben siparişlerimi demirci masasından hazırlıyorum.");
                                            for (Player player2 : Bukkit.getOnlinePlayers()) {
                                                if (player.getWorld().getName().equals("dungeonworld")) {
                                                    if (player2 == player) continue;
                                                    player2.hideEntity(plugin, stand3);
                                                }
                                            }
                                            new BukkitRunnable() {
                                                @Override
                                                public void run() {
                                                    stand3.remove();
                                                }
                                            }.runTaskLater(plugin, 70);
                                            break;
                                        case 3:
                                            i++;
                                            ArmorStand stand4 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.3, 0), "<white>Sen de bu masayı kullanarak kendine ekipman yapabilirsin.");
                                            for (Player player2 : Bukkit.getOnlinePlayers()) {
                                                if (player.getWorld().getName().equals("dungeonworld")) {
                                                    if (player2 == player) continue;
                                                    player2.hideEntity(plugin, stand4);
                                                }
                                            }
                                            new BukkitRunnable() {
                                                @Override
                                                public void run() {
                                                    stand4.remove();
                                                }
                                            }.runTaskLater(plugin, 70);
                                            break;
                                        case 4:
                                            i++;
                                            ArmorStand stand5 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.3, 0), "<white> Ama ilk olarak malzemeleri toplaman gerek. Dışarıya çık");
                                            for (Player player2 : Bukkit.getOnlinePlayers()) {
                                                if (player.getWorld().getName().equals("dungeonworld")) {
                                                    if (player2 == player) continue;
                                                    player2.hideEntity(plugin, stand5);
                                                }
                                            }
                                            new BukkitRunnable() {
                                                @Override
                                                public void run() {
                                                    stand5.remove();
                                                }
                                            }.runTaskLater(plugin, 70);
                                            break;
                                        case 5:
                                            i++;
                                            ArmorStand stand6 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.3, 0), "<white>ve kayalıklardan <gold>Bakır <white>ve <black>Kömür <white>madeni topla.");
                                            for (Player player2 : Bukkit.getOnlinePlayers()) {
                                                if (player.getWorld().getName().equals("dungeonworld")) {
                                                    if (player2 == player) continue;
                                                    player2.hideEntity(plugin, stand6);
                                                }
                                            }
                                            new BukkitRunnable() {
                                                @Override
                                                public void run() {
                                                    stand6.remove();
                                                }
                                            }.runTaskLater(plugin, 70);
                                            break;
                                        case 6:
                                            i++;
                                            ArmorStand stand7 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.3, 0), "<white>Ayrıca sana çubuk da lazım olacak bunun için dışarıdan odun toplayıp");
                                            for (Player player2 : Bukkit.getOnlinePlayers()) {
                                                if (player.getWorld().getName().equals("dungeonworld")) {
                                                    if (player2 == player) continue;
                                                    player2.hideEntity(plugin, stand7);
                                                }
                                            }
                                            new BukkitRunnable() {
                                                @Override
                                                public void run() {
                                                    stand7.remove();
                                                }
                                            }.runTaskLater(plugin, 70);
                                            break;
                                        case 7:
                                            i++;
                                            ArmorStand stand8 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.3, 0), "<white>onları çalışma masasında çubuk haline getir. <gold>Bakır <white>Ekipmanlar");
                                            for (Player player2 : Bukkit.getOnlinePlayers()) {
                                                if (player.getWorld().getName().equals("dungeonworld")) {
                                                    if (player2 == player) continue;
                                                    player2.hideEntity(plugin, stand8);
                                                }
                                            }
                                            new BukkitRunnable() {
                                                @Override
                                                public void run() {
                                                    stand8.remove();
                                                }
                                            }.runTaskLater(plugin, 70);
                                            break;
                                        case 8:
                                            i++;
                                            ArmorStand stand9 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.3, 0), "<yellow>Ustalığını <white>geliştirmende büyük bir katkı sağlayacak.");
                                            for (Player player2 : Bukkit.getOnlinePlayers()) {
                                                if (player.getWorld().getName().equals("dungeonworld")) {
                                                    if (player2 == player) continue;
                                                    player2.hideEntity(plugin, stand9);
                                                }
                                            }
                                            new BukkitRunnable() {
                                                @Override
                                                public void run() {
                                                    stand9.remove();
                                                }
                                            }.runTaskLater(plugin, 70);
                                            break;
                                        case 9:
                                            i++;
                                            ArmorStand stand10 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.3, 0), "<yellow>Ustalık <white>demişken, /ustalık komudunu kullanarak diğer");
                                            for (Player player2 : Bukkit.getOnlinePlayers()) {
                                                if (player.getWorld().getName().equals("dungeonworld")) {
                                                    if (player2 == player) continue;
                                                    player2.hideEntity(plugin, stand10);
                                                }
                                            }
                                            new BukkitRunnable() {
                                                @Override
                                                public void run() {
                                                    stand10.remove();
                                                }
                                            }.runTaskLater(plugin, 70);
                                            break;
                                        case 10:
                                            i++;
                                            ArmorStand stand11 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.3, 0), "<white>ustalık dallarına da bakabilirsin. Her yaptığın eylem");
                                            for (Player player2 : Bukkit.getOnlinePlayers()) {
                                                if (player.getWorld().getName().equals("dungeonworld")) {
                                                    if (player2 == player) continue;
                                                    player2.hideEntity(plugin, stand11);
                                                }
                                            }
                                            new BukkitRunnable() {
                                                @Override
                                                public void run() {
                                                    stand11.remove();

                                                }
                                            }.runTaskLater(plugin, 70);
                                            break;
                                        case 11:
                                            i++;
                                            ArmorStand stand12 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.3, 0), "<white>Seni bir ustalıkta geliştirir. Bir ustalıkda belirli bir seviyeye");
                                            for (Player player2 : Bukkit.getOnlinePlayers()) {
                                                if (player.getWorld().getName().equals("dungeonworld")) {
                                                    if (player2 == player) continue;
                                                    player2.hideEntity(plugin, stand12);
                                                }
                                            }
                                            new BukkitRunnable() {
                                                @Override
                                                public void run() {
                                                    stand12.remove();

                                                }
                                            }.runTaskLater(plugin, 70);
                                            break;
                                        case 12:
                                            i++;
                                            ArmorStand stand13 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.3, 0), "<white>geldikten sonra o ustalığı meslek olarak alabilirsin.");
                                            for (Player player2 : Bukkit.getOnlinePlayers()) {
                                                if (player.getWorld().getName().equals("dungeonworld")) {
                                                    if (player2 == player) continue;
                                                    player2.hideEntity(plugin, stand13);
                                                }
                                            }
                                            new BukkitRunnable() {
                                                @Override
                                                public void run() {
                                                    stand13.remove();

                                                }
                                            }.runTaskLater(plugin, 70);
                                            break;
                                        case 13:
                                            i++;
                                            ArmorStand stand14 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.3, 0), "<white>Her mesleğinde belirli avantajları ve dezavantajları vardır.");
                                            for (Player player2 : Bukkit.getOnlinePlayers()) {
                                                if (player.getWorld().getName().equals("dungeonworld")) {
                                                    if (player2 == player) continue;
                                                    player2.hideEntity(plugin, stand14);
                                                }
                                            }
                                            new BukkitRunnable() {
                                                @Override
                                                public void run() {
                                                    stand14.remove();

                                                }
                                            }.runTaskLater(plugin, 70);
                                            break;
                                        case 14:
                                            i++;
                                            ArmorStand stand15 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.3, 0), "<white>Benim bir siparişim var, onu sen hazırlayabilir misin?");
                                            for (Player player2 : Bukkit.getOnlinePlayers()) {
                                                if (player.getWorld().getName().equals("dungeonworld")) {
                                                    if (player2 == player) continue;
                                                    player2.hideEntity(plugin, stand15);
                                                }
                                            }
                                            ItemStack stack = itemHandler.string.clone();
                                            stack.setAmount(5);
                                            player.getInventory().addItem(stack);
                                            new BukkitRunnable() {
                                                @Override
                                                public void run() {
                                                    stand15.remove();

                                                }
                                            }.runTaskLater(plugin, 70);
                                            break;
                                        case 15:
                                            i++;
                                            ArmorStand stand16 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.3, 0), "<white>Sağ tarafta el sanatları masası var, oradan yay gerebilir,");
                                            for (Player player2 : Bukkit.getOnlinePlayers()) {
                                                if (player.getWorld().getName().equals("dungeonworld")) {
                                                    if (player2 == player) continue;
                                                    player2.hideEntity(plugin, stand16);
                                                }
                                            }
                                            new BukkitRunnable() {
                                                @Override
                                                public void run() {
                                                    stand16.remove();

                                                }
                                            }.runTaskLater(plugin, 70);
                                            break;
                                        case 16:
                                            i++;
                                            ArmorStand stand17 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.3, 0), "<white>Deri dikebilir ve olta kurabilirsin. Senden isteğim bana");
                                            for (Player player2 : Bukkit.getOnlinePlayers()) {
                                                if (player.getWorld().getName().equals("dungeonworld")) {
                                                    if (player2 == player) continue;
                                                    player2.hideEntity(plugin, stand17);
                                                }
                                            }
                                            new BukkitRunnable() {
                                                @Override
                                                public void run() {
                                                    stand17.remove();

                                                }
                                            }.runTaskLater(plugin, 70);
                                            break;
                                        case 17:
                                            i = 0;
                                            talkmap.remove(player.getUniqueId());
                                            ArmorStand stand18 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.3, 0), "<white>bir adet <yellow>Meşe Yay <white>yapabilir misin?");
                                            for (Player player2 : Bukkit.getOnlinePlayers()) {
                                                if (player.getWorld().getName().equals("dungeonworld")) {
                                                    if (player2 == player) continue;
                                                    player2.hideEntity(plugin, stand18);
                                                }
                                            }
                                            player.sendMessage(Painter.paint("&6El Sanatları masasını kullanarak bir &eMeşe Yay &6yap ve onu &eUlur'a &6götür."));
                                            BossBar bb223 = Bukkit.getBossBar(new NamespacedKey(plugin, "gorev2"));
                                            bb223.removePlayer(player);
                                            BossBar bb2 = Bukkit.createBossBar(new NamespacedKey(plugin, "gorev3"), Painter.paint("&6Meşe Yay yap ve Ulur'a götür."), BarColor.YELLOW, BarStyle.SOLID);
                                            bb2.addPlayer(player);
                                            new BukkitRunnable() {
                                                @Override
                                                public void run() {
                                                    stand18.remove();

                                                }
                                            }.runTaskLater(plugin, 70);
                                            cancel();
                                            break;
                                    }


                                }
                            }.runTaskTimer(plugin, 0, 75);
                        }
                    }

                } else if (entity.getName().contains("Alex")) {
                    if (questmap.get(player.getUniqueId()) == 2) {
                        talkmap.put(player.getUniqueId(), "konustu");
                        if (itemmap.containsKey(player.getUniqueId())) {
                            new BukkitRunnable() {
                                int i = 0;

                                @Override
                                public void run() {
                                    switch (i) {
                                        case 0:
                                            i++;
                                            ArmorStand stand = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.3, 0), "<white>Sanırım senle konuştuk. Hatırlayamıyorum, bilirsin yaşlılık işte.");
                                            for (Player player2 : Bukkit.getOnlinePlayers()) {
                                                if (player.getWorld().getName().equals("dungeonworld")) {
                                                    if (player2 == player) continue;
                                                    player2.hideEntity(plugin, stand);
                                                }
                                            }
                                            new BukkitRunnable() {
                                                @Override
                                                public void run() {
                                                    stand.remove();
                                                }
                                            }.runTaskLater(plugin, 70);
                                            break;

                                        case 1:
                                            i = 0;
                                            talkmap.remove(player.getUniqueId());
                                            cancel();
                                            break;

                                    }


                                }
                            }.runTaskTimer(plugin, 0, 75);
                        } else {
                            new BukkitRunnable() {
                                int i = 0;

                                @Override
                                public void run() {
                                    switch (i) {
                                        case 0:
                                            i++;
                                            BossBar bb = Bukkit.getBossBar(new NamespacedKey(plugin, "gorev4"));
                                            bb.setProgress(1.0);
                                            ArmorStand stand = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.3, 0), "<white>Merhabalar g-gezgin. Ben Alex. Benim işim aksesuar yapmak.");
                                            for (Player player2 : Bukkit.getOnlinePlayers()) {
                                                if (player.getWorld().getName().equals("dungeonworld")) {
                                                    if (player2 == player) continue;
                                                    player2.hideEntity(plugin, stand);
                                                }
                                            }
                                            new BukkitRunnable() {
                                                @Override
                                                public void run() {
                                                    stand.remove();
                                                }
                                            }.runTaskLater(plugin, 70);
                                            break;
                                        case 1:
                                            i++;
                                            ArmorStand stand2 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.3, 0), "<white>4 Çeşit aksesuar yaparım. <light_purple>Tılsım ve Ok Kılıfı, <blue>Eldiven, <yellow>Kolye");
                                            for (Player player2 : Bukkit.getOnlinePlayers()) {
                                                if (player.getWorld().getName().equals("dungeonworld")) {
                                                    if (player2 == player) continue;
                                                    player2.hideEntity(plugin, stand2);
                                                }
                                            }
                                            new BukkitRunnable() {
                                                @Override
                                                public void run() {
                                                    stand2.remove();
                                                }
                                            }.runTaskLater(plugin, 70);
                                            break;
                                        case 2:
                                            i++;
                                            ArmorStand stand3 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.3, 0), "<white>ve son olarak <gold>Yüzük. <white>Bu tarz aksesuarlar sana ekstra nitelik sağlarlar.");
                                            for (Player player2 : Bukkit.getOnlinePlayers()) {
                                                if (player.getWorld().getName().equals("dungeonworld")) {
                                                    if (player2 == player) continue;
                                                    player2.hideEntity(plugin, stand3);
                                                }
                                            }
                                            new BukkitRunnable() {
                                                @Override
                                                public void run() {
                                                    stand3.remove();
                                                }
                                            }.runTaskLater(plugin, 70);
                                            break;
                                        case 3:
                                            i++;
                                            ArmorStand stand4 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.3, 0), "<white>Bu da benim sana hediyem olsun. Sağ tıklayıp takabilirsin.");
                                            ItemStack item = itemHandler.createAccessoryItem("Kolye", new ItemStack(Material.MUSIC_DISC_OTHERSIDE), "&8Çiçek Kolyesi", 1, 1, 0, 2, 0, 1, 0, 0, 0, 0, 0,90);
                                            setUnstackable(item, "akse");
                                            itemmap.put(player.getUniqueId(), "aldı");
                                            player.getInventory().addItem(item);
                                            for (Player player2 : Bukkit.getOnlinePlayers()) {
                                                if (player.getWorld().getName().equals("dungeonworld")) {
                                                    if (player2 == player) continue;
                                                    player2.hideEntity(plugin, stand4);
                                                }
                                            }
                                            new BukkitRunnable() {
                                                @Override
                                                public void run() {
                                                    stand4.remove();
                                                }
                                            }.runTaskLater(plugin, 70);
                                            break;
                                        case 4:
                                            i++;
                                            ArmorStand stand6 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.3, 0), "<white>Söylemeyi unuttum. Aksesuarlarını <aqua>El Kitabını <white>kullanarak çıkarabilirsin.");
                                            for (Player player2 : Bukkit.getOnlinePlayers()) {
                                                if (player.getWorld().getName().equals("dungeonworld")) {
                                                    if (player2 == player) continue;
                                                    player2.hideEntity(plugin, stand6);
                                                }
                                            }
                                            new BukkitRunnable() {
                                                @Override
                                                public void run() {
                                                    stand6.remove();
                                                }
                                            }.runTaskLater(plugin, 70);
                                            break;
                                        case 5:
                                            i++;
                                            ArmorStand stand5 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.3, 0), "<white>Son talimlerini yapmak için <yellow>Aludar'ı <white>Bul.");
                                            for (Player player2 : Bukkit.getOnlinePlayers()) {
                                                if (player.getWorld().getName().equals("dungeonworld")) {
                                                    if (player2 == player) continue;
                                                    player2.hideEntity(plugin, stand5);
                                                }
                                            }
                                            new BukkitRunnable() {
                                                @Override
                                                public void run() {
                                                    stand5.remove();
                                                }
                                            }.runTaskLater(plugin, 70);
                                            break;
                                        case 6:
                                            i = 0;
                                            player.sendMessage(Painter.paint("&fGörev: &6Aludar'ı bul."));
                                            BossBar bb2321311 = Bukkit.getBossBar(new NamespacedKey(plugin, "gorev4"));
                                            bb2321311.removePlayer(player);
                                            BossBar bb2 = Bukkit.createBossBar(new NamespacedKey(plugin, "gorev5"), Painter.paint("&6Aludar'ı Bul."), BarColor.YELLOW, BarStyle.SOLID);
                                            bb2.addPlayer(player);
                                            questmap.put(player.getUniqueId(), questmap.get(player.getUniqueId()) + 1);
                                            talkmap.remove(player.getUniqueId());
                                            cancel();
                                            break;

                                    }


                                }
                            }.runTaskTimer(plugin, 0, 75);
                        }
                    }
                } else if (entity.getName().contains("Aludar")) {
                    if (questmap.get(player.getUniqueId()) == 3) {
                        talkmap.put(player.getUniqueId(), "konustu");
                        new BukkitRunnable() {
                            int i = 0;

                            @Override
                            public void run() {
                                switch (i) {
                                    case 0:
                                        i++;
                                        BossBar bb = Bukkit.getBossBar(new NamespacedKey(plugin, "gorev5"));
                                        bb.setProgress(1.0);
                                        ArmorStand stand = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.3, 0), "<white>Talime hazır ol savaşçı. Sana verdiğim silahları");
                                        player.getInventory().addItem(itemHandler.createWeaponItem(new ItemStack(Material.SHEARS), "&7Demir Hançer", 4, 10, 10, 20, 5, true, 2, 20, 0, "Düşük", 0, "Hançer",9999));
                                        player.getInventory().addItem(itemHandler.createWeaponItem(new ItemStack(Material.WOODEN_SWORD), "&7Demir Kılıç", 4, 10, 10, 20, 5, true, 2, 20, 0, "Düşük", 0, "Kılıç",9999));
                                        player.getInventory().addItem(itemHandler.createWeaponItem(new ItemStack(Material.WOODEN_SHOVEL), "&7Demir Topuz", 4, 10, 10, 20, 5, true, 2, 20, 0, "Orta", 0, "Topuz",9999));
                                        player.getInventory().addItem(itemHandler.createWeaponItem(new ItemStack(Material.WOODEN_HOE), "&7Demir Tırpan", 4, 10, 10, 20, 5, true, 2, 20, 0, "Yüksek", 0, "Tırpan",9999));
                                        player.getInventory().addItem(itemHandler.createWeaponItem(new ItemStack(Material.WOODEN_AXE), "&7Demir Savaş Baltası", 4, 10, 10, 20, 5, true, 2, 20, 0, "Yüksek", 0, "Tırpan",9999));
                                        player.getInventory().addItem(itemHandler.createWeaponItem(new ItemStack(Material.STICK), "&7Demir Mızrak", 4, 10, 10, 20, 5, true, 2, 20, 0, "Yüksek", 0, "Mızrak",9999));
                                        player.getInventory().addItem(itemHandler.createWeaponItem(new ItemStack(Material.BOW), "&6Eğitim Yayı", 4, 10, 10, 20, 5, true, 2, 20, 0, "Yüksek", 0, "Yay",9999));
                                        ItemStack item = new ItemStack(Material.ARROW);
                                        item.setAmount(100);
                                        player.getInventory().addItem(itemHandler.createWeaponItem(new ItemStack(Material.BLAZE_ROD), "&dDivinasyon Asası", 4, 10, 10, 20, 5, true, 2, 20, 0, "Yüksek", 0, "Asa",9999));
                                        player.getInventory().addItem(item);
                                        for (Player player2 : Bukkit.getOnlinePlayers()) {
                                            if (player.getWorld().getName().equals("dungeonworld")) {
                                                if (player2 == player) continue;
                                                player2.hideEntity(plugin, stand);
                                            }
                                        }
                                        new BukkitRunnable() {
                                            @Override
                                            public void run() {
                                                stand.remove();
                                            }
                                        }.runTaskLater(plugin, 70);
                                        break;
                                    case 1:
                                        i++;
                                        ArmorStand stand2 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.3, 0), "<white>Burada gördüğün <yellow>Deneme Kuklaları <white>üzerinde");
                                        for (Player player2 : Bukkit.getOnlinePlayers()) {
                                            if (player.getWorld().getName().equals("dungeonworld")) {
                                                if (player2 == player) continue;
                                                player2.hideEntity(plugin, stand2);
                                            }
                                        }
                                        new BukkitRunnable() {
                                            @Override
                                            public void run() {
                                                stand2.remove();
                                            }
                                        }.runTaskLater(plugin, 70);
                                        break;
                                    case 2:
                                        i++;
                                        ArmorStand stand3 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.3, 0), "<white>dene. Yakın menzil silahlarının her 5. vuruşu bir özelliği tetikler");
                                        for (Player player2 : Bukkit.getOnlinePlayers()) {
                                            if (player.getWorld().getName().equals("dungeonworld")) {
                                                if (player2 == player) continue;
                                                player2.hideEntity(plugin, stand3);
                                            }
                                        }
                                        new BukkitRunnable() {
                                            @Override
                                            public void run() {
                                                stand3.remove();
                                            }
                                        }.runTaskLater(plugin, 70);
                                        break;
                                    case 3:
                                        i++;
                                        ArmorStand stand4 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.3, 0), "<white>Yaylar ise iki farklı saldırıya sahiptir. Biri <red>Seri Atış <white>diğeri");
                                        for (Player player2 : Bukkit.getOnlinePlayers()) {
                                            if (player.getWorld().getName().equals("dungeonworld")) {
                                                if (player2 == player) continue;
                                                player2.hideEntity(plugin, stand4);
                                            }
                                        }
                                        new BukkitRunnable() {
                                            @Override
                                            public void run() {
                                                stand4.remove();
                                            }
                                        }.runTaskLater(plugin, 70);
                                        break;
                                    case 4:
                                        i++;
                                        ArmorStand stand5 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.3, 0), "<red>Ağır Yüklü Atış'dır. <red>Seri Atış'ı <gray>Sol Tık <white>ile <red>Ağır Yüklü Atış'ı <gray>Sağ Tık <white>ile kullanabilirsin.");
                                        for (Player player2 : Bukkit.getOnlinePlayers()) {
                                            if (player.getWorld().getName().equals("dungeonworld")) {
                                                if (player2 == player) continue;
                                                player2.hideEntity(plugin, stand5);
                                            }
                                        }
                                        new BukkitRunnable() {
                                            @Override
                                            public void run() {
                                                stand5.remove();
                                            }
                                        }.runTaskLater(plugin, 70);
                                        break;
                                    case 5:
                                        i++;
                                        ArmorStand stand6 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.3, 0), "<white>Tüm eğitimini tamamladın. Artık yolculuğa hazırsın. Gemiye binip gidebilirsin.");
                                        for (Player player2 : Bukkit.getOnlinePlayers()) {
                                            if (player.getWorld().getName().equals("dungeonworld")) {
                                                if (player2 == player) continue;
                                                player2.hideEntity(plugin, stand6);
                                            }
                                        }
                                        new BukkitRunnable() {
                                            @Override
                                            public void run() {
                                                stand6.remove();
                                            }
                                        }.runTaskLater(plugin, 70);
                                        break;
                                    case 6:
                                        i = 0;
                                        player.sendMessage(Painter.paint("&fGörev: &6Gemiye bin ve Cabbar ile konuş."));
                                        BossBar bb222323 = Bukkit.getBossBar(new NamespacedKey(plugin, "gorev5"));
                                        bb222323.removePlayer(player);
                                        BossBar bb2 = Bukkit.createBossBar(new NamespacedKey(plugin, "gorev6"), Painter.paint("&6Gemiye bin ve Cabbar ile konuş."), BarColor.YELLOW, BarStyle.SOLID);
                                        bb2.addPlayer(player);
                                        questmap.put(player.getUniqueId(), questmap.get(player.getUniqueId()) + 1);
                                        talkmap.remove(player.getUniqueId());
                                        cancel();
                                        break;

                                }


                            }
                        }.runTaskTimer(plugin, 0, 75);
                    }
                } else if (entity.getName().contains("Cabbar")) {
                    if (questmap.get(player.getUniqueId()) == 4) {
                        talkmap.put(player.getUniqueId(), "konustu");
                        new BukkitRunnable() {
                            int i = 0;

                            @Override
                            public void run() {
                                switch (i) {
                                    case 0:
                                        i++;
                                        BossBar bb = Bukkit.getBossBar(new NamespacedKey(plugin, "gorev6"));
                                        bb.setProgress(1.0);
                                        ArmorStand stand = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.3, 0), "<white>Yolculuğa hazır ol dostum.");
                                        for (Player player2 : Bukkit.getOnlinePlayers()) {
                                            if (player.getWorld().getName().equals("dungeonworld")) {
                                                if (player2 == player) continue;
                                                player2.hideEntity(plugin, stand);
                                            }
                                        }
                                        new BukkitRunnable() {
                                            @Override
                                            public void run() {
                                                stand.remove();
                                            }
                                        }.runTaskLater(plugin, 70);
                                        break;
                                    case 1:
                                        i = 0;
                                        Location loc = new Location(Bukkit.getWorld("world"), 1520, 69, 1942);
                                        player.teleport(loc);
                                        BossBar bb22232322 = Bukkit.getBossBar(new NamespacedKey(plugin, "gorev6"));
                                        bb22232322.removePlayer(player);
                                        new BukkitRunnable() {
                                            @Override
                                            public void run() {
                                                ItemStack star = new ItemStack(Material.KNOWLEDGE_BOOK);
                                                NamespacedKey key = new NamespacedKey(plugin, "star");
                                                List<String> lore = new ArrayList<>();
                                                ItemMeta meta = star.getItemMeta();
                                                PersistentDataContainer container = meta.getPersistentDataContainer();
                                                container.set(key, PersistentDataType.STRING, "star");
                                                meta.setDisplayName(Painter.paint("&bOyuncu El Kitabı"));
                                                lore.add(Painter.paint("&8Bu kitap sayesinde bir çok şeye erişebilir"));
                                                lore.add(Painter.paint("&8ve daha önce karşılaştığınız yaratıklar"));
                                                lore.add(Painter.paint("&8hakkında Bilgi sahibi olabilirsiniz."));
                                                lore.add(Painter.paint(""));
                                                lore.add(Painter.paint("&7Kullanmak için &e&lSağ Tıkla."));
                                                meta.setLore(lore);
                                                star.setItemMeta(meta);
                                                player.getInventory().setItem(8, star);
                                            }
                                        }.runTaskLater(plugin, 70);
                                        player.getInventory().clear();
                                        player.setLevel(0);
                                        questmap.remove(player.getUniqueId());
                                        talkmap.remove(player.getUniqueId());
                                        cancel();
                                        break;
                                }
                            }


                        }.runTaskTimer(plugin, 0, 75);
                    }
                } else if (entity.getName().contains("Orvan")) {

                    talkmap.put(player.getUniqueId(), "konustu");
                    if (player.getWorld().getName().equals("world")) {
                        new BukkitRunnable() {
                            int i = 0;

                            @Override
                            public void run() {
                                switch (i) {
                                    case 0:
                                        i++;
                                        ArmorStand stand = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.3, 0), "<white>Yolculuğa hazır ol dostum.");
                                        for (Player player2 : Bukkit.getOnlinePlayers()) {
                                            if (player.getWorld().getName().equals("world")) {
                                                if (player2 == player) continue;
                                                player2.hideEntity(plugin, stand);
                                            }
                                        }
                                        new BukkitRunnable() {
                                            @Override
                                            public void run() {
                                                stand.remove();
                                            }
                                        }.runTaskLater(plugin, 70);
                                        break;
                                    case 1:
                                        i = 0;
                                        Location loc = new Location(Bukkit.getWorld("remielsurvival"),  -66 ,64, -10);
                                        player.teleport(loc);
                                        talkmap.remove(player.getUniqueId());
                                        cancel();
                                        break;
                                }
                            }


                        }.runTaskTimer(plugin, 0, 75);
                    } else  if (player.getWorld().getName().equals("remielsurvival")) {
                        new BukkitRunnable() {
                            int i = 0;

                            @Override
                            public void run() {
                                switch (i) {
                                    case 0:
                                        i++;
                                        ArmorStand stand = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.3, 0), "<white>Yolculuğa hazır ol dostum.");
                                        for (Player player2 : Bukkit.getOnlinePlayers()) {
                                            if (player.getWorld().getName().equals("remielsurvival")) {
                                                if (player2 == player) continue;
                                                player2.hideEntity(plugin, stand);
                                            }
                                        }
                                        new BukkitRunnable() {
                                            @Override
                                            public void run() {
                                                stand.remove();
                                            }
                                        }.runTaskLater(plugin, 70);
                                        break;
                                    case 1:
                                        i = 0;
                                        Location loc = new Location(Bukkit.getWorld("world"), 1533 ,70 ,1967);
                                        player.teleport(loc);
                                        talkmap.remove(player.getUniqueId());
                                        cancel();
                                        break;
                                }
                            }


                        }.runTaskTimer(plugin, 0, 75);
                    }
                }
                }

        }
    }




    public void setUnstackable(ItemStack item, String key) {
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.values());
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, key), PersistentDataType.DOUBLE, Math.random());
        item.setItemMeta(meta);
    }

    public void createDialog(Player player, LivingEntity entity,String text) {
        ArmorStand stand = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.3, 0), text);
        for (Player player2 : Bukkit.getOnlinePlayers()) {
            if (player.getWorld().getName().equals("world")) {
                if (player2 == player) continue;
                player2.hideEntity(plugin, stand);
            }
        }
        new BukkitRunnable() {
            @Override
            public void run() {
                stand.remove();
            }
        }.runTaskLater(plugin, 70);
    }
}
