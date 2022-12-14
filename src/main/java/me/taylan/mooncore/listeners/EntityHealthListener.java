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
            isim.setSuffix(Painter.paint(" &6[" + (int) player.getHealth() + "???]"));
        } else {
            isim.addEntry(player.getName());
            isim.setPrefix(Painter.paint("&7[&fSvy. " + stats.getLevel(player.getUniqueId()) + "&7] &f"));
            isim.setSuffix(Painter.paint(" &6[" + (int) player.getHealth() + "???]"));
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
                                        ArmorStand stand = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Merhaba Gezgin. Ben Valadir. Filoya kat??lmadan ??nce temel e??itim");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Valadir: <white>Merhaba Gezgin. Ben Valadir. Filoya kat??lmadan ??nce temel e??itim"));
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
                                        ArmorStand stand2 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>alman gerek. ??lk olarak ??zelliklerinden ba??layal??m. /profil komudunu");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Valadir: <white>alman gerek. ??lk olarak ??zelliklerinden ba??layal??m. /profil komudunu"));
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
                                        ArmorStand stand3 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>kullanarak bilgilerine bakabilirsin. <gold>Din??lik <white>senin sa??l??????n?? g??sterir.");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Valadir: <white>kullanarak bilgilerine bakabilirsin. <gold>Din??lik <white>senin sa??l??????n?? g??sterir."));
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
                                        ArmorStand stand4 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<green>Dayan??kl??l??k <white>ald??????n hasarlar??n etkisini azalt??r.");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Valadir: <green>Dayan??kl??l??k <white>ald??????n hasarlar??n etkisini azalt??r."));
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
                                        ArmorStand stand5 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<red>G???? <white>yak??n d??v????te verece??in hasar?? belirler. Ne kadar");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Valadir: <red>G???? <white>yak??n d??v????te verece??in hasar?? belirler. Ne kadar"));
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
                                        ArmorStand stand6 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>g????l??ysen o kadar sert vurursun. <yellow>Denge <white>sald??r?? h??z??nd??r.");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Valadir: <white>g????l??ysen o kadar sert vurursun. <yellow>Denge <white>sald??r?? h??z??nd??r."));
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
                                        ArmorStand stand7 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Dengen ne kadar y??ksekse rakibe vuru??lar??n daha isabetli olur.");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Valadir: <white>Dengen ne kadar y??ksekse rakibe vuru??lar??n daha isabetli olur."));
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
                                        ArmorStand stand8 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Ayr??ca dengene ba??l?? olarak bir vuru??u birden fazla kez yapabilirsin.");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Valadir: <white>Ayr??ca dengene ba??l?? olarak bir vuru??u birden fazla kez yapabilirsin."));
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
                                        ArmorStand stand9 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>??eviklik ne kadar h??zl?? hareket etti??ini belirler.");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Valadir: <white>??eviklik ne kadar h??zl?? hareket etti??ini belirler."));
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
                                        ArmorStand stand10 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<dark_aqua>H??ner <white>kritik vuru??lar??n?? belirler. H??nerli biri yani, Silah??n??");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Valadir: H??ner <white>kritik vuru??lar??n?? belirler. H??nerli biri yani, Silah??n??"));
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
                                        ArmorStand stand11 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>iyi kullanan bir ki??i rakibin zay??f noktalar??n?? daha iyi g??rebilir. Buralarda");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Valadir: <white>iyi kullanan bir ki??i rakibin zay??f noktalar??n?? daha iyi g??rebilir. Buralarda"));
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
                                        ArmorStand stand12 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Demirci Ulur var. Onu Bulup e??itimine devam edebilirsin. Patikay?? takip et.");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Valadir: <white>Demirci Ulur var. Onu Bulup e??itimine devam edebilirsin. Patikay?? takip et."));
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
                                        player.sendMessage(Painter.paint("         &6&lG??REV"));
                                        player.sendMessage(Painter.paint(""));
                                        player.sendMessage(Painter.paint(""));
                                        player.sendMessage(Painter.paint("&fG??rev: &eDemirci Ulur'u bul."));
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
                                                ArmorStand stand = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Ne kadar te??ekk??r etsem azd??r. San??r??m az ??ok ekipman yapmay??");
                                                player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Ulur: <white>Ne kadar te??ekk??r etsem azd??r. San??r??m az ??ok ekipman yapmay??"));
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
                                                ArmorStand stand2 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>????renmi??sindir. Patikay?? takip et ve <yellow>Alex'i <white>Bul.");
                                                player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Ulur: <white>????renmi??sindir. Patikay?? takip et ve <yellow>Alex'i <white>Bul."));
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
                                                ArmorStand stand3 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Sana aksesuarlar??n?? nas??l kullanaca????n?? ????reticek.");
                                                player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Ulur: <white>Sana aksesuarlar??n?? nas??l kullanaca????n?? ????reticek."));
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
                                                player.sendMessage(Painter.paint("         &6&lG??REV"));
                                                player.sendMessage(Painter.paint(""));
                                                player.sendMessage(Painter.paint(""));
                                                player.sendMessage(Painter.paint("&fG??rev: &eAksesuarc?? Alex'i bul."));
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
                                        ArmorStand stand = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Ho??geldin! Kusura bakma etraf biraz da????n??k bir sipari??imi haz??rl??yordum.");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Ulur: <white>Ho??geldin! Kusura bakma etraf biraz da????n??k bir sipari??imi haz??rl??yordum."));
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
                                        ArmorStand stand2 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Zanaatkarl??k ????renmen i??in <yellow>Valadir <white>yollad?? san??r??m.");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Ulur: <white>Zanaatkarl??k ????renmen i??in <yellow>Valadir <white>yollad?? san??r??m."));
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
                                        ArmorStand stand3 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Ben sipari??lerimi demirci masas??ndan haz??rl??yorum.");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Ulur: <white>Ben sipari??lerimi demirci masas??ndan haz??rl??yorum."));
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
                                        ArmorStand stand4 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Sen de bu masay?? kullanarak kendine ekipman yapabilirsin.");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Ulur: <white>Sen de bu masay?? kullanarak kendine ekipman yapabilirsin."));
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
                                        ArmorStand stand5 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white> Ama ilk olarak malzemeleri toplaman gerek. D????ar??ya ????k");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Ulur: <white> Ama ilk olarak malzemeleri toplaman gerek. D????ar??ya ????k"));
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
                                        ArmorStand stand6 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>ve kayal??klardan <gold>Bak??r <white>ve <black>K??m??r <white>madeni topla.");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Ulur: <white>ve kayal??klardan <gold>Bak??r <white>ve <black>K??m??r <white>madeni topla.<white> Ama ilk olarak malzemeleri toplaman gerek. D????ar??ya ????k"));
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
                                        ArmorStand stand7 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Ayr??ca sana ??ubuk da laz??m olacak bunun i??in d????ar??dan odun toplay??p");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Ulur: <white>Ayr??ca sana ??ubuk da laz??m olacak bunun i??in d????ar??dan odun toplay??p"));
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
                                        ArmorStand stand8 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>onlar?? ??al????ma masas??nda ??ubuk haline getir. <gold>Bak??r <white>Ekipmanlar");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Ulur: <white>onlar?? ??al????ma masas??nda ??ubuk haline getir. <gold>Bak??r <white>Ekipmanlar"));
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
                                        ArmorStand stand9 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<yellow>Ustal??????n?? <white>geli??tirmende b??y??k bir katk?? sa??layacak.");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Ulur: <yellow>Ustal??????n?? <white>geli??tirmende b??y??k bir katk?? sa??layacak."));
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
                                        ArmorStand stand10 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<yellow>Ustal??k <white>demi??ken, /ustal??k komudunu kullanarak di??er");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Ulur: <yellow>Ustal??k <white>demi??ken, /ustal??k komudunu kullanarak di??er"));
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
                                        ArmorStand stand11 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>ustal??k dallar??na da bakabilirsin. Her yapt??????n eylem");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Ulur: <white>ustal??k dallar??na da bakabilirsin. Her yapt??????n eylem"));
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
                                        ArmorStand stand12 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Seni bir ustal??kta geli??tirir. Bir ustal??kda belirli bir seviyeye");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Ulur: <white>Seni bir ustal??kta geli??tirir. Bir ustal??kda belirli bir seviyeye"));
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
                                        ArmorStand stand13 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>geldikten sonra o ustal?????? meslek olarak alabilirsin.");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Ulur: <white>geldikten sonra o ustal?????? meslek olarak alabilirsin."));
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
                                        ArmorStand stand14 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Her mesle??inde belirli avantajlar?? ve dezavantajlar?? vard??r.");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Ulur: <white>Her mesle??inde belirli avantajlar?? ve dezavantajlar?? vard??r."));
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
                                        ArmorStand stand15 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Benim bir sipari??im var, onu sen haz??rlayabilir misin?");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Ulur: <white>Benim bir sipari??im var, onu sen haz??rlayabilir misin?"));
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
                                        ArmorStand stand16 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Sa?? tarafta el sanatlar?? masas?? var, oradan yay gerebilir,");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Ulur: <white>Sa?? tarafta el sanatlar?? masas?? var, oradan yay gerebilir,"));
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
                                        ArmorStand stand17 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Deri dikebilir ve olta kurabilirsin. Senden iste??im bana");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Ulur: <white>Deri dikebilir ve olta kurabilirsin. Senden iste??im bana"));
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
                                        ArmorStand stand18 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>bir adet <yellow>Me??e Yay <white>yapabilir misin?");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Ulur: <white>bir adet <yellow>Me??e Yay <white>yapabilir misin?"));
                                        for (Player player2 : Bukkit.getOnlinePlayers()) {
                                            if (player.getWorld().getName().equals("dungeonworld")) {
                                                if (player2 == player) continue;
                                                player2.hideEntity(plugin, stand18);
                                            }
                                        }
                                        player.sendMessage(Painter.paint(""));
                                        player.sendMessage(Painter.paint("         &6&lG??REV"));
                                        player.sendMessage(Painter.paint(""));
                                        player.sendMessage(Painter.paint(""));
                                        player.sendMessage(Painter.paint("&fG??rev: &eEl Sanatlar?? Masas??n?? kullanarak"));
                                        player.sendMessage(Painter.paint("&ebir &eMe??e Yay &eyap ve onu &6Ulur'a &eg??t??r."));
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
                                            ArmorStand stand = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>San??r??m senle konu??tuk. Hat??rlayam??yorum, bilirsin ya??l??l??k i??te.");
                                            player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Alex: <white>San??r??m senle konu??tuk. Hat??rlayam??yorum, bilirsin ya??l??l??k i??te."));
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
                                            ArmorStand stand = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Merhabalar g-gezgin. Ben Alex. Benim i??im aksesuar yapmak.");
                                            player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Alex: <white>Merhabalar g-gezgin. Ben Alex. Benim i??im aksesuar yapmak."));
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
                                            ArmorStand stand2 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>4 ??e??it aksesuar yapar??m. <light_purple>T??ls??m ve Ok K??l??f??, <blue>Eldiven, <yellow>Kolye");
                                            player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Alex: <white>4 ??e??it aksesuar yapar??m. <light_purple>T??ls??m ve Ok K??l??f??, <blue>Eldiven, <yellow>Kolye"));
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
                                            ArmorStand stand3 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>ve son olarak <gold>Y??z??k. <white>Bu tarz aksesuarlar sana ekstra nitelik sa??larlar.");
                                            player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Alex: <white>ve son olarak <gold>Y??z??k. <white>Bu tarz aksesuarlar sana ekstra nitelik sa??larlar."));
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
                                            ArmorStand stand4 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Bu da benim sana hediyem olsun. Sa?? t??klay??p takabilirsin.");
                                            player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Alex: <white>Bu da benim sana hediyem olsun. Sa?? t??klay??p takabilirsin."));
                                            ItemStack item = itemHandler.createAccessoryItem("Kolye", new ItemStack(Material.MUSIC_DISC_OTHERSIDE), "<green>??i??ek Kolyesi", 1, 1, 0, 2, 0, 1, 0, 0, 0, 0, 0, 90, 0);
                                            setUnstackable(item, "akse");
                                            itemmap.put(player.getUniqueId(), "ald??");
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
                                            ArmorStand stand6 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>S??ylemeyi unuttum. Aksesuarlar??n?? <aqua>El Kitab??n?? <white>kullanarak ????karabilirsin.");
                                            player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Alex: <white>S??ylemeyi unuttum. Aksesuarlar??n?? <aqua>El Kitab??n?? <white>kullanarak ????karabilirsin."));
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
                                            ArmorStand stand5 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Son talimlerini yapmak i??in <yellow>Aludar'?? <white>Bul.");
                                            player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Alex: <white>Son talimlerini yapmak i??in <yellow>Aludar'?? <white>Bul."));
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
                                            player.sendMessage(Painter.paint("         &6&lG??REV"));
                                            player.sendMessage(Painter.paint(""));
                                            player.sendMessage(Painter.paint(""));
                                            player.sendMessage(Painter.paint("&fG??rev: &eAludar'?? bul."));
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
                                        ArmorStand stand = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Talime haz??r ol sava??????. Sana verdi??im silahlar??");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Aludar: <white>Talime haz??r ol sava??????. Sana verdi??im silahlar??"));
                                        player.getInventory().addItem(itemHandler.createWeaponItem(new ItemStack(Material.SHEARS), "<gray><i:false>Demir Han??er", 4, 10, 10, 20, 5, true, 2, 20, 0, "D??????k", 0, "Han??er", 9999, 0));
                                        player.getInventory().addItem(itemHandler.createWeaponItem(new ItemStack(Material.WOODEN_SWORD), "<gray><i:false>Demir K??l????", 4, 10, 10, 20, 5, true, 2, 20, 0, "D??????k", 0, "K??l????", 9999, 0));
                                        player.getInventory().addItem(itemHandler.createWeaponItem(new ItemStack(Material.WOODEN_SHOVEL), "<gray><i:false>Demir Topuz", 4, 10, 10, 20, 5, true, 2, 20, 0, "Orta", 0, "Topuz", 9999, 0));
                                        player.getInventory().addItem(itemHandler.createWeaponItem(new ItemStack(Material.WOODEN_HOE), "<gray><i:false>Demir T??rpan", 4, 10, 10, 20, 5, true, 2, 20, 0, "Y??ksek", 0, "T??rpan", 9999, 0));
                                        player.getInventory().addItem(itemHandler.createWeaponItem(new ItemStack(Material.WOODEN_AXE), "<gray><i:false>Demir Sava?? Baltas??", 4, 10, 10, 20, 5, true, 2, 20, 0, "Y??ksek", 0, "T??rpan", 9999, 0));
                                        player.getInventory().addItem(itemHandler.createWeaponItem(new ItemStack(Material.STICK), "<gray><i:false>Demir M??zrak", 4, 10, 10, 20, 5, true, 2, 20, 0, "Y??ksek", 0, "M??zrak", 9999, 0));
                                        player.getInventory().addItem(itemHandler.createWeaponItem(new ItemStack(Material.BOW), "<gold><i:false>Hu?? Yay", 4, 10, 10, 20, 5, true, 2, 20, 0, "Y??ksek", 0, "Yay", 9999, 0));
                                        ItemStack item = new ItemStack(Material.ARROW);
                                        item.setAmount(100);
                                        player.getInventory().addItem(itemHandler.createWeaponItem(new ItemStack(Material.BLAZE_ROD), "<light_purple><i:false>Divinasyon Asas??", 4, 10, 10, 20, 5, true, 2, 20, 0, "Y??ksek", 0, "Asa", 9999, 0));
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
                                        ArmorStand stand2 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Burada g??rd??????n <yellow>Deneme Kuklalar?? <white>??zerinde");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Aludar: <white>Burada g??rd??????n <yellow>Deneme Kuklalar?? <white>??zerinde"));
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
                                        ArmorStand stand3 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>dene. Yak??n menzil silahlar??n??n her 5. vuru??u bir ??zelli??i tetikler");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Aludar: <white>dene. Yak??n menzil silahlar??n??n her 5. vuru??u bir ??zelli??i tetikler"));
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
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Aludar: <white>Yaylar ise iki farkl?? sald??r??ya sahiptir. Biri <red>Seri At???? <white>di??eri"));
                                        ArmorStand stand4 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Yaylar ise iki farkl?? sald??r??ya sahiptir. Biri <red>Seri At???? <white>di??eri");
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
                                        ArmorStand stand5 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<red>A????r Y??kl?? At????'d??r. <red>Seri At????'?? <gray>Sol T??k <white>ile <red>A????r Y??kl?? At????'?? <gray>Sa?? T??k <white>ile kullanabilirsin.");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Aludar: <red>A????r Y??kl?? At????'d??r. <red>Seri At????'?? <gray>Sol T??k <white>ile <red>A????r Y??kl?? At????'?? <gray>Sa?? T??k <white>ile kullanabilirsin."));
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
                                        ArmorStand stand6 = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>T??m e??itimini tamamlad??n. Art??k yolculu??a haz??rs??n. Gemiye binip gidebilirsin.");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Aludar: <white>T??m e??itimini tamamlad??n. Art??k yolculu??a haz??rs??n. Gemiye binip gidebilirsin."));
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
                                        player.sendMessage(Painter.paint("         &6&lG??REV"));
                                        player.sendMessage(Painter.paint(""));
                                        player.sendMessage(Painter.paint(""));
                                        player.sendMessage(Painter.paint("&fG??rev: &eGemiye bin ve Cabbar ile konu??."));
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
                                        ArmorStand stand = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Yolculu??a haz??r ol dostum.");
                                        player.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>Cabbar: <white>Yolculu??a haz??r ol dostum."));
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
                                                                MiniMessage.miniMessage().deserialize("<dark_green>[</dark_green><green>E??itimi Tamamlad??n!</green><dark_green>]</dark_green>"),
                                                                MiniMessage.miniMessage().deserialize("<gray>Limandaki ??nsanlarla Konu??.</gray>")));
                                                player.playSound(player, Sound.ENTITY_PLAYER_LEVELUP, 5f, 0.1f);
                                                NamespacedKey key = new NamespacedKey(plugin, "star");
                                                List<String> lore = new ArrayList<>();
                                                ItemMeta meta = star.getItemMeta();
                                                PersistentDataContainer container = meta.getPersistentDataContainer();
                                                container.set(key, PersistentDataType.STRING, "star");
                                                meta.setDisplayName(Painter.paint("&bOyuncu El Kitab??"));
                                                lore.add(Painter.paint("&8Bu kitap sayesinde bir ??ok ??eye eri??ebilir"));
                                                lore.add(Painter.paint("&8ve daha ??nce kar????la??t??????n??z yarat??klar"));
                                                lore.add(Painter.paint("&8hakk??nda Bilgi sahibi olabilirsiniz."));
                                                lore.add(Painter.paint(""));
                                                lore.add(Painter.paint("&7Kullanmak i??in &e&lSa?? T??kla."));
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
                                        ArmorStand stand = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Yolculu??a haz??r ol dostum.");
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
                                        ArmorStand stand = SpawnArmorStand.spawnArmorStand(entity.getLocation().add(0, 2.4, 0), "<white>Yolculu??a haz??r ol dostum.");
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
        final Component name = Component.text("Valadir ile Konu??");
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
