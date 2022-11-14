package me.taylan.mooncore.listeners;

import com.destroystokyo.paper.MaterialTags;
import lombok.NonNull;
import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.listeners.entitydamage.SpawnArmorStand;
import me.taylan.mooncore.utils.GuiHandler;
import me.taylan.mooncore.utils.ItemHandler;
import me.taylan.mooncore.utils.Painter;
import me.taylan.mooncore.utils.StatsManager;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.bossbar.BossBar;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.title.Title;
import org.bukkit.*;
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


import java.util.*;

public class EntityHealthListener implements Listener {
    private final MoonCore plugin;
    private final ItemHandler itemHandler;
    private final JoinListener joinListener;
    private final StatsManager stats;
    private final GuiHandler guiHandler;
    private final HashMap<UUID, String> talkmap = new HashMap<>();
    private final HashMap<UUID, String> itemmap = new HashMap<>();


    public EntityHealthListener(MoonCore plugin) {
        this.plugin = plugin;
        this.itemHandler = plugin.getItemHandler();
        this.stats = plugin.getStatsManager();
        this.joinListener = plugin.getJoinListener();
        this.guiHandler = plugin.getGuiHandler();
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
        if (Objects.requireNonNull(isim).hasEntry(player.getName())) {
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
        HashMap<UUID, Integer> questmap = joinListener.getQuestmap();
        if (entity instanceof Villager) {
            if (entity.getName().contains("Wan'dul")) {
                player.performCommand("ah");
            }
            if (entity.getName().contains("Babayani")) {
                player.openInventory(guiHandler.tuccar1(player));
            }
            if (!(talkmap.containsKey(player.getUniqueId()))) {
                if (entity.getName().contains("Valadir")) {
                    if (questmap.get(player.getUniqueId()) == 0) {
                        talkmap.put(player.getUniqueId(), "konustu");
                        new BukkitRunnable() {
                            int i = 0;

                            @Override
                            public void run() {
                                switch (i) {
                                    case 0 -> {
                                        i++;
                                        hideActiveBossBar(player);
                                        showFullBossBar(player);
                                        ArmorStand stand = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Merhaba Gezgin. Ben Valadir. Filoya katılmadan önce temel eğitim");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Valadir: <white>Merhaba Gezgin. Ben Valadir. Filoya katılmadan önce temel eğitim"));
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
                                    }
                                    case 1 -> {
                                        i++;
                                        ArmorStand stand2 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>alman gerek. İlk olarak özelliklerinden başlayalım. /profil komudunu");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Valadir: <white>alman gerek. İlk olarak özelliklerinden başlayalım. /profil komudunu"));
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
                                    }
                                    case 2 -> {
                                        i++;
                                        ArmorStand stand3 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>kullanarak bilgilerine bakabilirsin. <gold>Dinçlik <white>senin sağlığını gösterir.");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Valadir: <white>kullanarak bilgilerine bakabilirsin. <gold>Dinçlik <white>senin sağlığını gösterir."));
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
                                    }
                                    case 3 -> {
                                        i++;
                                        ArmorStand stand4 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<green>Dayanıklılık <white>aldığın hasarların etkisini azaltır.");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Valadir: <green>Dayanıklılık <white>aldığın hasarların etkisini azaltır."));
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
                                    }
                                    case 4 -> {
                                        i++;
                                        ArmorStand stand5 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<red>Güç <white>yakın dövüşte vereceğin hasarı belirler. Ne kadar");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Valadir: <red>Güç <white>yakın dövüşte vereceğin hasarı belirler. Ne kadar"));
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
                                    }
                                    case 5 -> {
                                        i++;
                                        ArmorStand stand6 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>güçlüysen o kadar sert vurursun. <yellow>Denge <white>saldırı hızındır.");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Valadir: <white>güçlüysen o kadar sert vurursun. <yellow>Denge <white>saldırı hızındır."));
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
                                    }
                                    case 6 -> {
                                        i++;
                                        ArmorStand stand7 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Dengen ne kadar yüksekse rakibe vuruşların daha isabetli olur.");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Valadir: <white>Dengen ne kadar yüksekse rakibe vuruşların daha isabetli olur."));
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
                                    }
                                    case 7 -> {
                                        i++;
                                        ArmorStand stand8 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Ayrıca dengene bağlı olarak bir vuruşu birden fazla kez yapabilirsin.");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Valadir: <white>Ayrıca dengene bağlı olarak bir vuruşu birden fazla kez yapabilirsin."));
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
                                    }
                                    case 8 -> {
                                        i++;
                                        ArmorStand stand9 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Çeviklik ne kadar hızlı hareket ettiğini belirler.");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Valadir: <white>Çeviklik ne kadar hızlı hareket ettiğini belirler."));
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
                                    }
                                    case 9 -> {
                                        i++;
                                        ArmorStand stand10 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<dark_aqua>Hüner <white>kritik vuruşlarını belirler. Hünerli biri yani, Silahını");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Valadir: Hüner <white>kritik vuruşlarını belirler. Hünerli biri yani, Silahını"));
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
                                    }
                                    case 10 -> {
                                        i++;
                                        ArmorStand stand11 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>iyi kullanan bir kişi rakibin zayıf noktalarını daha iyi görebilir. Buralarda");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Valadir: <white>iyi kullanan bir kişi rakibin zayıf noktalarını daha iyi görebilir. Buralarda"));
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
                                    }
                                    case 11 -> {
                                        i++;
                                        ArmorStand stand12 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Demirci Ulur var. Onu Bulup eğitimine devam edebilirsin. Patikayı takip et.");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Valadir: <white>Demirci Ulur var. Onu Bulup eğitimine devam edebilirsin. Patikayı takip et."));
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
                                    }
                                    case 12 -> {
                                        i = 0;
                                        player.sendMessage(Painter.paint(""));
                                        player.sendMessage(Painter.paint("         &6&lGÖREV"));
                                        player.sendMessage(Painter.paint(""));
                                        player.sendMessage(Painter.paint(""));
                                        player.sendMessage(Painter.paint("&fGörev: &eDemirci Ulur'u bul."));
                                        player.sendMessage(Painter.paint(""));
                                        player.sendMessage(Painter.paint(""));
                                        player.playSound(player, Sound.BLOCK_NOTE_BLOCK_BANJO, 5f, 0.1f);
                                        hideActiveBossBar(player);
                                        questmap.put(player.getUniqueId(), 1);
                                        talkmap.remove(player.getUniqueId());
                                        cancel();
                                    }
                                }


                            }

                        }.runTaskTimer(plugin, 0, 75);
                    }
                } else if (entity.getName().contains("Ulur")) {
                    if (questmap.get(player.getUniqueId()) == 2) {
                        if (player.getInventory().getItemInMainHand() != null && player.getInventory().getItemInMainHand().hasItemMeta()) {
                            if (MaterialTags.BOWS.isTagged(player.getInventory().getItemInMainHand())) {
                                talkmap.put(player.getUniqueId(), "konustu");
                                player.getInventory().remove(Material.BOW);

                                new BukkitRunnable() {
                                    int i = 0;

                                    @Override
                                    public void run() {
                                        switch (i) {
                                            case 0 -> {
                                                i++;
                                                ArmorStand stand = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Ne kadar teşekkür etsem azdır. Sanırım az çok ekipman yapmayı");
                                                player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Ulur: <white>Ne kadar teşekkür etsem azdır. Sanırım az çok ekipman yapmayı"));
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
                                            }
                                            case 1 -> {
                                                i++;
                                                ArmorStand stand2 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Öğrenmişsindir. Patikayı takip et ve <yellow>Alex'i <white>Bul.");
                                                player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Ulur: <white>Öğrenmişsindir. Patikayı takip et ve <yellow>Alex'i <white>Bul."));
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
                                            }
                                            case 2 -> {
                                                i++;
                                                ArmorStand stand3 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Sana aksesuarlarını nasıl kullanacağını öğreticek.");
                                                player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Ulur: <white>Sana aksesuarlarını nasıl kullanacağını öğreticek."));
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
                                            }
                                            case 3 -> {
                                                i = 0;
                                                player.sendMessage(Painter.paint(""));
                                                player.sendMessage(Painter.paint("         &6&lGÖREV"));
                                                player.sendMessage(Painter.paint(""));
                                                player.sendMessage(Painter.paint(""));
                                                player.sendMessage(Painter.paint("&fGörev: &eAksesuarcı Alex'i bul."));
                                                player.sendMessage(Painter.paint(""));
                                                player.sendMessage(Painter.paint(""));
                                                player.playSound(player, Sound.BLOCK_NOTE_BLOCK_BANJO, 5f, 0.1f);
                                                questmap.put(player.getUniqueId(), questmap.get(player.getUniqueId()) + 1);
                                                talkmap.remove(player.getUniqueId());
                                                cancel();
                                            }
                                        }


                                    }
                                }.runTaskTimer(plugin, 0, 75);

                            }
                        }
                    } else if (questmap.get(player.getUniqueId()) == 1) {
                        talkmap.put(player.getUniqueId(), "konustu");
                        new BukkitRunnable() {
                            int i = 0;

                            @Override
                            public void run() {
                                switch (i) {
                                    case 0 -> {
                                        i++;
                                        ArmorStand stand = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Hoşgeldin! Kusura bakma etraf biraz dağınık bir siparişimi hazırlıyordum.");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Ulur: <white>Hoşgeldin! Kusura bakma etraf biraz dağınık bir siparişimi hazırlıyordum."));
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
                                    }
                                    case 1 -> {
                                        i++;
                                        ArmorStand stand2 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Zanaatkarlık öğrenmen için <yellow>Valadir <white>yolladı sanırım.");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Ulur: <white>Zanaatkarlık öğrenmen için <yellow>Valadir <white>yolladı sanırım."));
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
                                    }
                                    case 2 -> {
                                        i++;
                                        ArmorStand stand3 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Ben siparişlerimi demirci masasından hazırlıyorum.");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Ulur: <white>Ben siparişlerimi demirci masasından hazırlıyorum."));
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
                                    }
                                    case 3 -> {
                                        i++;
                                        ArmorStand stand4 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Sen de bu masayı kullanarak kendine ekipman yapabilirsin.");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Ulur: <white>Sen de bu masayı kullanarak kendine ekipman yapabilirsin."));
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
                                    }
                                    case 4 -> {
                                        i++;
                                        ArmorStand stand5 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white> Ama ilk olarak malzemeleri toplaman gerek. Dışarıya çık");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Ulur: <white> Ama ilk olarak malzemeleri toplaman gerek. Dışarıya çık"));
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
                                    }
                                    case 5 -> {
                                        i++;
                                        ArmorStand stand6 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>ve kayalıklardan <gold>Bakır <white>ve <black>Kömür <white>madeni topla.");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Ulur: <white>ve kayalıklardan <gold>Bakır <white>ve <black>Kömür <white>madeni topla.<white> Ama ilk olarak malzemeleri toplaman gerek. Dışarıya çık"));
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
                                    }
                                    case 6 -> {
                                        i++;
                                        ArmorStand stand7 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Ayrıca sana çubuk da lazım olacak bunun için dışarıdan odun toplayıp");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Ulur: <white>Ayrıca sana çubuk da lazım olacak bunun için dışarıdan odun toplayıp"));
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
                                    }
                                    case 7 -> {
                                        i++;
                                        ArmorStand stand8 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>onları çalışma masasında çubuk haline getir. <gold>Bakır <white>Ekipmanlar");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Ulur: <white>onları çalışma masasında çubuk haline getir. <gold>Bakır <white>Ekipmanlar"));
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
                                    }
                                    case 8 -> {
                                        i++;
                                        ArmorStand stand9 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<yellow>Ustalığını <white>geliştirmende büyük bir katkı sağlayacak.");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Ulur: <yellow>Ustalığını <white>geliştirmende büyük bir katkı sağlayacak."));
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
                                    }
                                    case 9 -> {
                                        i++;
                                        ArmorStand stand10 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<yellow>Ustalık <white>demişken, /ustalık komudunu kullanarak diğer");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Ulur: <yellow>Ustalık <white>demişken, /ustalık komudunu kullanarak diğer"));
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
                                    }
                                    case 10 -> {
                                        i++;
                                        ArmorStand stand11 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>ustalık dallarına da bakabilirsin. Her yaptığın eylem");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Ulur: <white>ustalık dallarına da bakabilirsin. Her yaptığın eylem"));
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
                                    }
                                    case 11 -> {
                                        i++;
                                        ArmorStand stand12 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Seni bir ustalıkta geliştirir. Bir ustalıkda belirli bir seviyeye");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Ulur: <white>Seni bir ustalıkta geliştirir. Bir ustalıkda belirli bir seviyeye"));
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
                                    }
                                    case 12 -> {
                                        i++;
                                        ArmorStand stand13 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>geldikten sonra o ustalığı meslek olarak alabilirsin.");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Ulur: <white>geldikten sonra o ustalığı meslek olarak alabilirsin."));
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
                                    }
                                    case 13 -> {
                                        i++;
                                        ArmorStand stand14 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Her mesleğinde belirli avantajları ve dezavantajları vardır.");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Ulur: <white>Her mesleğinde belirli avantajları ve dezavantajları vardır."));
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
                                    }
                                    case 14 -> {
                                        i++;
                                        ArmorStand stand15 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Benim bir siparişim var, onu sen hazırlayabilir misin?");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Ulur: <white>Benim bir siparişim var, onu sen hazırlayabilir misin?"));
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
                                    }
                                    case 15 -> {
                                        i++;
                                        ArmorStand stand16 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Sağ tarafta el sanatları masası var, oradan yay gerebilir,");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Ulur: <white>Sağ tarafta el sanatları masası var, oradan yay gerebilir,"));
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
                                    }
                                    case 16 -> {
                                        i++;
                                        ArmorStand stand17 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Deri dikebilir ve olta kurabilirsin. Senden isteğim bana");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Ulur: <white>Deri dikebilir ve olta kurabilirsin. Senden isteğim bana"));
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
                                    }
                                    case 17 -> {
                                        i = 0;
                                        talkmap.remove(player.getUniqueId());
                                        ArmorStand stand18 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>bir adet <yellow>Meşe Yay <white>yapabilir misin?");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Ulur: <white>bir adet <yellow>Meşe Yay <white>yapabilir misin?"));
                                        for (Player player2 : Bukkit.getOnlinePlayers()) {
                                            if (player.getWorld().getName().equals("dungeonworld")) {
                                                if (player2 == player) continue;
                                                player2.hideEntity(plugin, stand18);
                                            }
                                        }
                                        player.sendMessage(Painter.paint(""));
                                        player.sendMessage(Painter.paint("         &6&lGÖREV"));
                                        player.sendMessage(Painter.paint(""));
                                        player.sendMessage(Painter.paint(""));
                                        player.sendMessage(Painter.paint("&fGörev: &eEl Sanatları Masasını kullanarak"));
                                        player.sendMessage(Painter.paint("&ebir &eMeşe Yay &eyap ve onu &6Ulur'a &egötür."));
                                        player.sendMessage(Painter.paint(""));
                                        player.sendMessage(Painter.paint(""));
                                        questmap.put(player.getUniqueId(), questmap.get(player.getUniqueId()) + 1);
                                        player.playSound(player, Sound.BLOCK_NOTE_BLOCK_BANJO, 5f, 0.1f);
                                        new BukkitRunnable() {
                                            @Override
                                            public void run() {
                                                stand18.remove();

                                            }
                                        }.runTaskLater(plugin, 70);
                                        cancel();
                                    }
                                }


                            }
                        }.runTaskTimer(plugin, 0, 75);
                    }


                } else if (entity.getName().contains("Alex")) {
                    if (questmap.get(player.getUniqueId()) == 3) {
                        talkmap.put(player.getUniqueId(), "konustu");
                        if (itemmap.containsKey(player.getUniqueId())) {
                            new BukkitRunnable() {
                                int i = 0;

                                @Override
                                public void run() {
                                    switch (i) {
                                        case 0 -> {
                                            i++;
                                            ArmorStand stand = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Sanırım senle konuştuk. Hatırlayamıyorum, bilirsin yaşlılık işte.");
                                            player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Alex: <white>Sanırım senle konuştuk. Hatırlayamıyorum, bilirsin yaşlılık işte."));
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
                                        }
                                        case 1 -> {
                                            i = 0;
                                            talkmap.remove(player.getUniqueId());
                                            cancel();
                                        }
                                    }


                                }
                            }.runTaskTimer(plugin, 0, 75);
                        } else {
                            talkmap.put(player.getUniqueId(), "konustu");
                            new BukkitRunnable() {
                                int i = 0;

                                @Override
                                public void run() {
                                    switch (i) {
                                        case 0 -> {
                                            i++;
                                            ArmorStand stand = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Merhabalar g-gezgin. Ben Alex. Benim işim aksesuar yapmak.");
                                            player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Alex: <white>Merhabalar g-gezgin. Ben Alex. Benim işim aksesuar yapmak."));
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
                                        }
                                        case 1 -> {
                                            i++;
                                            ArmorStand stand2 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>4 Çeşit aksesuar yaparım. <light_purple>Tılsım ve Ok Kılıfı, <blue>Eldiven, <yellow>Kolye");
                                            player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Alex: <white>4 Çeşit aksesuar yaparım. <light_purple>Tılsım ve Ok Kılıfı, <blue>Eldiven, <yellow>Kolye"));
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
                                        }
                                        case 2 -> {
                                            i++;
                                            ArmorStand stand3 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>ve son olarak <gold>Yüzük. <white>Bu tarz aksesuarlar sana ekstra nitelik sağlarlar.");
                                            player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Alex: <white>ve son olarak <gold>Yüzük. <white>Bu tarz aksesuarlar sana ekstra nitelik sağlarlar."));
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
                                        }
                                        case 3 -> {
                                            i++;
                                            ArmorStand stand4 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Bu da benim sana hediyem olsun. Sağ tıklayıp takabilirsin.");
                                            player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Alex: <white>Bu da benim sana hediyem olsun. Sağ tıklayıp takabilirsin."));
                                            ItemStack item = itemHandler.createAccessoryItem("Kolye", new ItemStack(Material.MUSIC_DISC_OTHERSIDE), "<green>Çiçek Kolyesi", 1, 1, 0, 2, 0, 1, 0, 0, 0, 0, 0, 90, 0);
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
                                        }
                                        case 4 -> {
                                            i++;
                                            ArmorStand stand6 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Söylemeyi unuttum. Aksesuarlarını <aqua>El Kitabını <white>kullanarak çıkarabilirsin.");
                                            player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Alex: <white>Söylemeyi unuttum. Aksesuarlarını <aqua>El Kitabını <white>kullanarak çıkarabilirsin."));
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
                                        }
                                        case 5 -> {
                                            i++;
                                            ArmorStand stand5 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Son talimlerini yapmak için <yellow>Aludar'ı <white>Bul.");
                                            player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Alex: <white>Son talimlerini yapmak için <yellow>Aludar'ı <white>Bul."));
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
                                        }
                                        case 6 -> {
                                            i = 0;
                                            player.sendMessage(Painter.paint(""));
                                            player.sendMessage(Painter.paint("         &6&lGÖREV"));
                                            player.sendMessage(Painter.paint(""));
                                            player.sendMessage(Painter.paint(""));
                                            player.sendMessage(Painter.paint("&fGörev: &eAludar'ı bul."));
                                            player.sendMessage(Painter.paint(""));
                                            player.sendMessage(Painter.paint(""));
                                            player.playSound(player, Sound.BLOCK_NOTE_BLOCK_BANJO, 5f, 0.1f);
                                            questmap.put(player.getUniqueId(), questmap.get(player.getUniqueId()) + 1);
                                            talkmap.remove(player.getUniqueId());
                                            cancel();
                                        }
                                    }


                                }
                            }.runTaskTimer(plugin, 0, 75);
                        }
                    }
                } else if (entity.getName().contains("Aludar")) {
                    if (questmap.get(player.getUniqueId()) == 4) {
                        talkmap.put(player.getUniqueId(), "konustu");
                        new BukkitRunnable() {
                            int i = 0;

                            @Override
                            public void run() {
                                switch (i) {
                                    case 0 -> {
                                        i++;
                                        ArmorStand stand = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Talime hazır ol savaşçı. Sana verdiğim silahları");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Aludar: <white>Talime hazır ol savaşçı. Sana verdiğim silahları"));
                                        player.getInventory().addItem(itemHandler.createWeaponItem(new ItemStack(Material.SHEARS), "<gray><i:false>Demir Hançer", 4, 10, 10, 20, 5, true, 2, 20, 0, "Düşük", 0, "Hançer", 9999, 0));
                                        player.getInventory().addItem(itemHandler.createWeaponItem(new ItemStack(Material.WOODEN_SWORD), "<gray><i:false>Demir Kılıç", 4, 10, 10, 20, 5, true, 2, 20, 0, "Düşük", 0, "Kılıç", 9999, 0));
                                        player.getInventory().addItem(itemHandler.createWeaponItem(new ItemStack(Material.WOODEN_SHOVEL), "<gray><i:false>Demir Topuz", 4, 10, 10, 20, 5, true, 2, 20, 0, "Orta", 0, "Topuz", 9999, 0));
                                        player.getInventory().addItem(itemHandler.createWeaponItem(new ItemStack(Material.WOODEN_HOE), "<gray><i:false>Demir Tırpan", 4, 10, 10, 20, 5, true, 2, 20, 0, "Yüksek", 0, "Tırpan", 9999, 0));
                                        player.getInventory().addItem(itemHandler.createWeaponItem(new ItemStack(Material.WOODEN_AXE), "<gray><i:false>Demir Savaş Baltası", 4, 10, 10, 20, 5, true, 2, 20, 0, "Yüksek", 0, "Tırpan", 9999, 0));
                                        player.getInventory().addItem(itemHandler.createWeaponItem(new ItemStack(Material.STICK), "<gray><i:false>Demir Mızrak", 4, 10, 10, 20, 5, true, 2, 20, 0, "Yüksek", 0, "Mızrak", 9999, 0));
                                        player.getInventory().addItem(itemHandler.createWeaponItem(new ItemStack(Material.BOW), "<gold><i:false>Huş Yay", 4, 10, 10, 20, 5, true, 2, 20, 0, "Yüksek", 0, "Yay", 9999, 0));
                                        ItemStack item = new ItemStack(Material.ARROW);
                                        item.setAmount(100);
                                        player.getInventory().addItem(itemHandler.createWeaponItem(new ItemStack(Material.BLAZE_ROD), "<light_purple><i:false>Divinasyon Asası", 4, 10, 10, 20, 5, true, 2, 20, 0, "Yüksek", 0, "Asa", 9999, 0));
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
                                    }
                                    case 1 -> {
                                        i++;
                                        ArmorStand stand2 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Burada gördüğün <yellow>Deneme Kuklaları <white>üzerinde");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Aludar: <white>Burada gördüğün <yellow>Deneme Kuklaları <white>üzerinde"));
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
                                    }
                                    case 2 -> {
                                        i++;
                                        ArmorStand stand3 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>dene. Yakın menzil silahlarının her 5. vuruşu bir özelliği tetikler");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Aludar: <white>dene. Yakın menzil silahlarının her 5. vuruşu bir özelliği tetikler"));
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
                                    }
                                    case 3 -> {
                                        i++;
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Aludar: <white>Yaylar ise iki farklı saldırıya sahiptir. Biri <red>Seri Atış <white>diğeri"));
                                        ArmorStand stand4 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Yaylar ise iki farklı saldırıya sahiptir. Biri <red>Seri Atış <white>diğeri");
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
                                    }
                                    case 4 -> {
                                        i++;
                                        ArmorStand stand5 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<red>Ağır Yüklü Atış'dır. <red>Seri Atış'ı <gray>Sol Tık <white>ile <red>Ağır Yüklü Atış'ı <gray>Sağ Tık <white>ile kullanabilirsin.");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Aludar: <red>Ağır Yüklü Atış'dır. <red>Seri Atış'ı <gray>Sol Tık <white>ile <red>Ağır Yüklü Atış'ı <gray>Sağ Tık <white>ile kullanabilirsin."));
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
                                    }
                                    case 5 -> {
                                        i++;
                                        ArmorStand stand6 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Tüm eğitimini tamamladın. Artık yolculuğa hazırsın. Gemiye binip gidebilirsin.");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Aludar: <white>Tüm eğitimini tamamladın. Artık yolculuğa hazırsın. Gemiye binip gidebilirsin."));
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
                                    }
                                    case 6 -> {
                                        i = 0;
                                        player.sendMessage(Painter.paint(""));
                                        player.sendMessage(Painter.paint("         &6&lGÖREV"));
                                        player.sendMessage(Painter.paint(""));
                                        player.sendMessage(Painter.paint(""));
                                        player.sendMessage(Painter.paint("&fGörev: &eGemiye bin ve Cabbar ile konuş."));
                                        player.sendMessage(Painter.paint(""));
                                        player.sendMessage(Painter.paint(""));
                                        player.playSound(player, Sound.BLOCK_NOTE_BLOCK_BANJO, 5f, 0.1f);
                                        questmap.put(player.getUniqueId(), questmap.get(player.getUniqueId()) + 1);
                                        talkmap.remove(player.getUniqueId());
                                        cancel();
                                    }
                                }


                            }
                        }.runTaskTimer(plugin, 0, 75);
                    }
                } else if (entity.getName().contains("Cabbar")) {
                    if (questmap.get(player.getUniqueId()) == 5) {
                        talkmap.put(player.getUniqueId(), "konustu");
                        new BukkitRunnable() {
                            int i = 0;

                            @Override
                            public void run() {
                                switch (i) {
                                    case 0 -> {
                                        i++;
                                        ArmorStand stand = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Yolculuğa hazır ol dostum.");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Cabbar: <white>Yolculuğa hazır ol dostum."));
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
                                    }
                                    case 1 -> {
                                        i = 0;
                                        Location loc = new Location(Bukkit.getWorld("world"), 1520, 69, 1942);
                                        player.teleport(loc);
                                        new BukkitRunnable() {
                                            @Override
                                            public void run() {
                                                ItemStack star = new ItemStack(Material.KNOWLEDGE_BOOK);
                                                player.showTitle(

                                                        Title.title(
                                                                MiniMessage.miniMessage().deserialize("<dark_green>[</dark_green><green>Eğitimi Tamamladın!</green><dark_green>]</dark_green>"),
                                                                MiniMessage.miniMessage().deserialize("<gray>Limandaki İnsanlarla Konuş.</gray>")));
                                                player.playSound(player, Sound.ENTITY_PLAYER_LEVELUP, 5f, 0.1f);
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
                                    }
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
                                    case 0 -> {
                                        i++;
                                        ArmorStand stand = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Yolculuğa hazır ol dostum.");
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
                                    case 1 -> {
                                        i = 0;
                                        Location loc = new Location(Bukkit.getWorld("remielsurvival"), -66, 64, -10);
                                        player.teleport(loc);
                                        talkmap.remove(player.getUniqueId());
                                        cancel();
                                    }
                                }
                            }


                        }.runTaskTimer(plugin, 0, 75);
                    } else if (player.getWorld().getName().equals("remielsurvival")) {
                        new BukkitRunnable() {
                            int i = 0;

                            @Override
                            public void run() {
                                switch (i) {
                                    case 0 -> {
                                        i++;
                                        ArmorStand stand = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Yolculuğa hazır ol dostum.");
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
                                    }
                                    case 1 -> {
                                        i = 0;
                                        Location loc = new Location(Bukkit.getWorld("world"), 1533, 70, 1967);
                                        player.teleport(loc);
                                        talkmap.remove(player.getUniqueId());
                                        cancel();
                                    }
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

// --Commented out by Inspection START (14.11.2022 02:08):
//    public void createDialog(Player player, LivingEntity entity, String text) {
//        ArmorStand stand = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), text);
//        for (Player player2 : Bukkit.getOnlinePlayers()) {
//            if (player.getWorld().getName().equals("world")) {
//                if (player2 == player) continue;
//                player2.hideEntity(plugin, stand);
//            }
//        }
//        new BukkitRunnable() {
//            @Override
//            public void run() {
//                stand.remove();
//            }
//        }.runTaskLater(plugin, 70);
//    }
// --Commented out by Inspection STOP (14.11.2022 02:08)

    public void showFullBossBar(final @NonNull Audience target) {
        final Component name = Component.text("Valadir ile Konuş");
        final BossBar fullBar = BossBar.bossBar(name, 1, BossBar.Color.YELLOW, BossBar.Overlay.NOTCHED_20);
        target.showBossBar(fullBar);
        if (target instanceof Player) {
            Player player = (Player) target;
            joinListener.getBossbarmap().put(player.getUniqueId(), fullBar);
        }
        // Store it locally to be able to hide it manually later
    }

    public void hideActiveBossBar(final @NonNull Audience target) {
        HashMap<UUID, BossBar> bossBarHashMap = joinListener.getBossbarmap();
        if (target instanceof Player) {
            Player player = (Player) target;
            if (bossBarHashMap.containsKey(player.getUniqueId())) {
                target.hideBossBar(bossBarHashMap.get(player.getUniqueId()));
                joinListener.getBossbarmap().remove(player.getUniqueId());
            }
        }
    }
}
