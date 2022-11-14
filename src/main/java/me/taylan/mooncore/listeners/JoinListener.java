//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package me.taylan.mooncore.listeners;

import com.keenant.tabbed.Tabbed;
import com.keenant.tabbed.item.TextTabItem;
import com.keenant.tabbed.tablist.TableTabList;
import com.keenant.tabbed.util.Skin;
import com.keenant.tabbed.util.Skins;
import fr.mrmicky.fastboard.FastBoard;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

import lombok.NonNull;
import me.casperge.realisticseasons.api.SeasonChangeEvent;
import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.eco.Ekonomi;
import me.taylan.mooncore.seasons.CustomDateMethods;
import me.taylan.mooncore.utils.BukkitSerialization;
import me.taylan.mooncore.utils.Painter;
import me.taylan.mooncore.utils.StatsManager;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.bossbar.BossBar;
import net.kyori.adventure.bossbar.BossBar.Color;
import net.kyori.adventure.bossbar.BossBar.Overlay;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class JoinListener implements Listener {
    private final MoonCore plugin;
    private final StatsManager stats;
    private final Tabbed tabbed;
    private final DecimalFormat df = new DecimalFormat("#,###.##");
    private final Ekonomi ekonomi;
    private static final HashMap<UUID, Inventory> menu = new HashMap();
    private static final HashMap<UUID, Inventory> ocakmenu = new HashMap();
    private final HashMap<UUID, Integer> questmap = new HashMap();
    private final HashMap<UUID, BossBar> bossbarmap = new HashMap();
    private final HashMap<UUID, ItemStack[]> armor = new HashMap();
    private static final HashMap<UUID, Inventory> furnacemenu = new HashMap();
    private static final HashMap<UUID, Inventory> elsanatmenu = new HashMap();
    private static final HashMap<UUID, Inventory> realfurnacemenu = new HashMap();
    private final CustomDateMethods customDateMethods;

    public HashMap<UUID, Integer> getQuestmap() {
        return this.questmap;
    }

    public HashMap<UUID, BossBar> getBossbarmap() {
        return this.bossbarmap;
    }

    public HashMap<UUID, ItemStack[]> getArmor() {
        return this.armor;
    }

    public JoinListener(MoonCore plugin) {
        this.plugin = plugin;
        this.ekonomi = plugin.getEkonomi();
        this.stats = plugin.getStatsManager();
        this.customDateMethods = plugin.getCustomDateMethods();
        this.tabbed = plugin.getTabbed();
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    public static HashMap<UUID, Inventory> getMenu() {
        return menu;
    }

    public static HashMap<UUID, Inventory> getOcakMenu() {
        return ocakmenu;
    }

    public static HashMap<UUID, Inventory> getFurnacemenu() {
        return furnacemenu;
    }

    public static HashMap<UUID, Inventory> getElsanatmenu() {
        return elsanatmenu;
    }

    public static HashMap<UUID, Inventory> getRealfurnacemenu() {
        return realfurnacemenu;
    }

    @EventHandler(
            priority = EventPriority.LOWEST,
            ignoreCancelled = true
    )
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        if (player.getInventory().getArmorContents() != null) {
            this.armor.put(player.getUniqueId(), player.getInventory().getArmorContents());
        }

        player.setHealthScale(20.0);
        e.setJoinMessage((String) null);
        String name = player.getName();
        String broadcastedMessage;
        if (!this.stats.hasPlayedBefore(player.getUniqueId())) {
            try {
                this.stats.createFile(player.getUniqueId());
            } catch (IOException var23) {
                this.plugin.send("&cOyuncu Dosyası oluşturulamadı!");
            }

            broadcastedMessage = Painter.paint(name + " &bRemiel &etopraklarına ilk adımını attı!");
        } else {
            this.stats.getStatfile().put(player.getUniqueId(), this.stats.getFile(player.getUniqueId()));
            broadcastedMessage = Painter.paint("&7[&6+&7] " + name);
        }

        Iterator var5 = this.plugin.getServer().getOnlinePlayers().iterator();

        while (var5.hasNext()) {
            Player p = (Player) var5.next();
            p.sendMessage(broadcastedMessage);
        }

        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        if (scoreboard.getTeam(player.getName()) == null) {
            scoreboard.registerNewTeam(player.getName());
        }

        Team isim = scoreboard.getTeam(player.getName());
        StatsManager var10001;
        if (Objects.requireNonNull(isim).hasEntry(player.getName())) {
            var10001 = this.stats;
            isim.setPrefix(Painter.paint("&7[&fSvy. " + var10001.getLevel(player.getUniqueId()) + "&7] &f"));
            isim.setSuffix(Painter.paint(" &6[" + (int) player.getHealth() + "❤]"));
        } else {
            isim.addEntry(player.getName());
            var10001 = this.stats;
            isim.setPrefix(Painter.paint("&7[&fSvy. " + var10001.getLevel(player.getUniqueId()) + "&7] &f"));
            isim.setSuffix(Painter.paint(" &6[" + (int) player.getHealth() + "❤]"));
        }

        FastBoard board = new FastBoard(player);
        board.updateTitle(ChatColor.AQUA + "Moon Network");
        Objects.requireNonNull(player.getAttribute(Attribute.GENERIC_ATTACK_SPEED)).setBaseValue(1000.0);
        double para = this.ekonomi.getBalance(player);
        board.updateTitle(ChatColor.AQUA + "Moon Network");
        String[] var31 = new String[]{ChatColor.DARK_AQUA +""+ ChatColor.BOLD + "     Remiel", "    ", null, null, null, null, null};
        ChatColor var10004 = ChatColor.GOLD;
        var31[2] = "" + var10004 + "Dinar ⛁" + ChatColor.WHITE + this.df.format(para);
        var31[3] = "";
        var10004 = ChatColor.DARK_AQUA;
        var31[4] = "" + var10004 + this.customDateMethods.getCustomTime().replace('.', ':') + "0 " + ChatColor.YELLOW + this.customDateMethods.getTimeLine();
        var10004 = ChatColor.GRAY;
        var31[5] = "" + var10004 + player.getName();
        var31[6] = ChatColor.AQUA + "mc.moonnw.xyz  ";
        board.updateLines(var31);
        if (!player.hasPlayedBefore()) {
            PotionEffect effect = new PotionEffect(PotionEffectType.REGENERATION, 600, 2, false, false, false);
            PotionEffect effect2 = player.getPotionEffect(PotionEffectType.REGENERATION);
            if (effect2 == null) {
                player.addPotionEffect(effect);
            }

            this.questmap.put(player.getUniqueId(), 0);
            player.giveExp(20000);
            Location loc2 = new Location(Bukkit.getWorld("dungeonworld"), 495.0, 63.0, 308.0);
            player.teleport(loc2);
            this.showMyBossBar(player);
            ItemStack star = new ItemStack(Material.KNOWLEDGE_BOOK);
            NamespacedKey key = new NamespacedKey(this.plugin, "star");
            List<String> lore = new ArrayList();
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

        menu.put(player.getUniqueId(), Bukkit.createInventory(player, 54, MiniMessage.miniMessage().deserialize("<dark_gray>Depo")));
        ocakmenu.put(player.getUniqueId(), Bukkit.createInventory(player, 54, MiniMessage.miniMessage().deserialize("<dark_gray>Ocak Deposu")));
        furnacemenu.put(player.getUniqueId(), Bukkit.createInventory(player, 54, MiniMessage.miniMessage().deserialize("<dark_gray>Maden Fırın Deposu")));
        elsanatmenu.put(player.getUniqueId(), Bukkit.createInventory(player, 54, MiniMessage.miniMessage().deserialize("<dark_gray>El Sanatları Deposu")));
        realfurnacemenu.put(player.getUniqueId(), Bukkit.createInventory(player, 54, MiniMessage.miniMessage().deserialize("<dark_gray>Fırın Deposu")));
        String contents;
        ItemStack[] inv;
        if (!this.stats.getStorage(player.getUniqueId()).equals("yok")) {
            contents = this.stats.getStorage(player.getUniqueId());

            try {
                inv = BukkitSerialization.itemStackArrayFromBase64(contents);
                ((Inventory) menu.get(player.getUniqueId())).setContents(inv);
            } catch (IOException var22) {
                this.plugin.getLogger().warning("Broken");
                var22.printStackTrace();
            }
        }

        if (!this.stats.getRealFurnaceStorage(player.getUniqueId()).equals("yok")) {
            contents = this.stats.getRealFurnaceStorage(player.getUniqueId());

            try {
                inv = BukkitSerialization.itemStackArrayFromBase64(contents);
                ((Inventory) realfurnacemenu.get(player.getUniqueId())).setContents(inv);
            } catch (IOException var21) {
                this.plugin.getLogger().warning("Broken");
                var21.printStackTrace();
            }
        }

        if (!this.stats.getFurnaceStorage(player.getUniqueId()).equals("yok")) {
            contents = this.stats.getFurnaceStorage(player.getUniqueId());

            try {
                inv = BukkitSerialization.itemStackArrayFromBase64(contents);
                ((Inventory) furnacemenu.get(player.getUniqueId())).setContents(inv);
            } catch (IOException var20) {
                this.plugin.getLogger().warning("Broken");
                var20.printStackTrace();
            }
        }

        if (!this.stats.getCookStorage(player.getUniqueId()).equals("yok")) {
            contents = this.stats.getCookStorage(player.getUniqueId());

            try {
                inv = BukkitSerialization.itemStackArrayFromBase64(contents);
                ((Inventory) ocakmenu.get(player.getUniqueId())).setContents(inv);
            } catch (IOException var19) {
                this.plugin.getLogger().warning("Broken");
                var19.printStackTrace();
            }
        }

        if (!this.stats.getWorkStorage(player.getUniqueId()).equals("yok")) {
            contents = this.stats.getWorkStorage(player.getUniqueId());

            try {
                inv = BukkitSerialization.itemStackArrayFromBase64(contents);
                ((Inventory) elsanatmenu.get(player.getUniqueId())).setContents(inv);
            } catch (IOException var18) {
                this.plugin.getLogger().warning("Broken");
                var18.printStackTrace();
            }
        }

        if (this.stats.getVayne(player.getUniqueId()) != null) {
            ItemStack[] content = (ItemStack[]) this.stats.getVayne(player.getUniqueId()).toArray(new ItemStack[0]);
            player.getInventory().setArmorContents(content);
            this.stats.setVayne(player.getUniqueId(), (List) null);
        }

        TableTabList tab = this.tabbed.newTableTabList(player);
        tab.setHeaderFooter(ChatColor.AQUA + "Moon Network\n" + ChatColor.DARK_AQUA + ChatColor.BOLD + "Remiel", ChatColor.GRAY + "\nDiscord: " + ChatColor.AQUA + "moonnw.discord.url\nIP: " + ChatColor.AQUA + "play.moonnw.xyz\n\n" + ChatColor.GRAY + "Güncelleme, yama notları ve mağaza için sitemizi ziyaret edin! " + ChatColor.AQUA + "mc.moonnw.xyz");
        tab.set(0, 0, new TextTabItem(ChatColor.GRAY + "" + ChatColor.BOLD + "Oyuncular", 1000, new Skin("ewogICJ0aW1lc3RhbXAiIDogMTY2NzQxNTE1MzgzMiwKICAicHJvZmlsZUlkIiA6ICIxNzZkNGQzOWRjOWU0ODM5ODQwODk1MDM5N2UyYWE0ZCIsCiAgInByb2ZpbGVOYW1lIiA6ICJTbWMyNjU0IiwKICAic2lnbmF0dXJlUmVxdWlyZWQiIDogdHJ1ZSwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzhlNDkxOTY3NWFkNzkyMjlmYTZiOTYxOWVmZWNhNTcwNzMzZTk0ZDIxYmIyMTZlMTM2YTk0OTE5ZTk4OTA2ZiIKICAgIH0KICB9Cn0=", "RiCfeMdNiLcl2WLsakHKjDjGqYGFrtXXAcFQusoEj/mP3rTnFb2YvdVznUu/IJfkP2OHXzF+jlI4uDAvdYvBKWD31JLY8jds4L0YyebUgaSCt3ZNxbop8xR0/SAaWvdgUkzgF7JqYcaX89xJyViVryv3WmbF8yTm66ww39rJWtqjRijC7im6c13v2zGCUuJQesI8ncdlLEQJ1HUsvunnswXm2hJnXI3uqCe6Xp585z6rb09EwaRI8Ch6Q0s1a+TKnYMlNIrVCPvx1oV569+PZLlQ1kqmlvHBOPsYmuB4AAC8UsHKpCt3yYHu/eBBGUpvm8ytFMN5bPoCU4VfFI+IhgwBMW9pRmw6VXJdhl7VdcHO/GdtOAR5awnLYzHTNNb6pSqagrTE8YD3ha28Vqe54sY60lyHnxTB/u7QZkfZp72/GCe9wx4uJbF3z/punsEepB7QNJjfE0PZF6Q6cdSuDpsmvAzn1WSIj3I+VdQfVgbq1tVUhShkN9TBDzjdMeybIUQOX2GxfvulN/7pHKed7gWgvX5hUPmlisRyytmxRarY7b4sCJvJqacrEVVNnlIQS8MJEeJDiT1yxfcQM4UNhNsCn7dG9QB0dwOwuXCyYnxJCriC2Zp0o27/BMEX1XhdPqNfSJ+PoWLHc3H9SnFX6EWIzgTtS//MGxZ+wJvd01I=")));
        tab.set(2, 0, new TextTabItem(ChatColor.WHITE + "" + ChatColor.BOLD + "Küresel Bilgiler", 1000, new Skin("ewogICJ0aW1lc3RhbXAiIDogMTY2NzQxNDg0Nzk1MywKICAicHJvZmlsZUlkIiA6ICJjMWQzYTRjZjU1OWE0YzZjOTYzNzdlZTQzYmQ3ZDAyNiIsCiAgInByb2ZpbGVOYW1lIiA6ICJzaGFkaXhfNjMiLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODc5ZTU0Y2JlODc4NjdkMTRiMmZiZGYzZjE4NzA4OTQzNTIwNDhkZmVjZDk2Mjg0NmRlYTg5M2IyMTU0Yzg1IgogICAgfQogIH0KfQ==", "mvWPimw6WQ6U+caiiEavBarVTyhBk0GpIsZEP69hH6+hkXVGaTNQWrkqG1DhCc3GpFZg6AoFanurFMnqUum2zaP/9EdqCDgjLbrAbtTgeBLYF6vxXEUiDMUe8HuZ0L5q6IeRFrSdbRZFBCgmBao5HFMc0Bvqnza7+K5hK9xdB75Y5dmGAx7Env7hGWeXvGjwZRxTeFl3gckjn6zKoE92yoGKziuXlfyKv7gpyXqjvSB5VJ8/3NaNcrmwA16nTbWxL6ywQD9oIAufmS9VOjum2JTqG7rFOv3ythem3PiCnpOCA1EaYJk1T5Ts615nfHMa4aZ5vvkB5km95MraXSavojH5PvThkgltAV+92Hpw0U5p55pQavgRY5U386mRdfM2VBJEyT6sn6RQJsCWIFhSp8h7l61f99hm/+N1x3I5U6l1qTgHf0ojb/0yeN3AKrtqJcGMJK5UsnFChtCc582l55aPzgw8bYuhILCOGgM5nFA7LnYGVlY6zg/9PPEvk0WqzeQp+p/hVqTKeF2lKSPQwdm2h46IkJfd0VR36kCBfuDmpRwJgAZNFRdbL2wLgFSJio63ug2Vu/P0G+NzaFYnBICrwXvu+paSiZD9otDmZgYWiivRlhm1qbP0Cl9VtoVkJgXA4oUUzRpAczg9tC03Ys7RXc3Qy+QAbppeaUSg5eU=")));
        ChatColor var10005 = ChatColor.YELLOW;
        tab.set(2, 1, new TextTabItem("" + var10005 + "Yıl: " + ChatColor.WHITE + this.customDateMethods.getCustomYear()));
        var10005 = ChatColor.YELLOW;
        tab.set(2, 2, new TextTabItem("" + var10005 + "Gün: " + ChatColor.WHITE + this.customDateMethods.getCustomDay()));
        var10005 = ChatColor.YELLOW;
        tab.set(2, 3, new TextTabItem("" + var10005 + "Mevsim: " + ChatColor.WHITE + this.customDateMethods.getSeason()));
        tab.set(3, 0, new TextTabItem(ChatColor.GOLD +""+ ChatColor.BOLD + "Sana Ait Bilgiler", 1000, Skins.getPlayer(player.getName())));
        var10005 = ChatColor.GOLD;
        tab.set(3, 1, new TextTabItem("" + var10005 + "İsim: " + ChatColor.WHITE + player.getName()));
        var10005 = ChatColor.GOLD;
        tab.set(3, 2, new TextTabItem("" + var10005 + "Dinar: ⛁" + ChatColor.WHITE + this.df.format(para)));
        tab.set(3, 3, new TextTabItem(ChatColor.GOLD + "Klan: " + ChatColor.WHITE + "Yok..."));
        tab.set(3, 10, new TextTabItem(ChatColor.GOLD + "Ekipman Üretim Durumu:"));
        tab.set(3, 11, new TextTabItem(ChatColor.GRAY + " Demirci Masası: " + ChatColor.WHITE + "Boş..."));
        tab.set(3, 12, new TextTabItem(ChatColor.GRAY + " El Sanatları Masası: " + ChatColor.WHITE + "Boş..."));
        tab.set(3, 7, new TextTabItem(ChatColor.GOLD + "Aktif Olan Etkilerin:"));
        tab.set(3, 8, new TextTabItem(ChatColor.WHITE + " Yok..."));
        tab.set(2, 8, new TextTabItem(ChatColor.YELLOW + "Etkinlik Durumu:" + ChatColor.GOLD + " Odunculuk Festivali"));
        tab.set(2, 9, new TextTabItem(ChatColor.GRAY + " 3 Gün sonra başlayacak."));
        tab.set(2, 12, new TextTabItem(ChatColor.YELLOW + "Aktif Tecrübe Desteği:"));
        tab.set(2, 13, new TextTabItem(ChatColor.GRAY + " Yok.."));
        int i = this.customDateMethods.getTab();
        Bukkit.getOnlinePlayers().forEach((player1) -> {
            TableTabList newTabList = (TableTabList) this.tabbed.getTabList(player1);
            newTabList.setBatchEnabled(true);
            tab.setBatchEnabled(true);
            int var100052 = this.stats.getLevel(player.getUniqueId());
            tab.set(0, i, new TextTabItem(Painter.paint("&7[&fSvy. " + var100052 + "&7] &f" + player.getName())));
            var100052 = this.stats.getLevel(player.getUniqueId());
            newTabList.set(0, i, new TextTabItem(Painter.paint("&7[&fSvy. " + var100052 + "&7] &f" + player.getName())));
            this.customDateMethods.setTab(i + 1);
            tab.batchUpdate();
            newTabList.batchUpdate();
        });
    }

    public void showMyBossBar(@NonNull Audience target) {
        Component name = Component.text("Valadir ile Konuş.");
        BossBar emptyBar = BossBar.bossBar(name, 0.0F, Color.YELLOW, Overlay.PROGRESS);
        target.showBossBar(emptyBar);
        if (target instanceof Player player) {
            this.bossbarmap.put(player.getUniqueId(), emptyBar);
        }

    }

    @EventHandler
    public void seasonevent(SeasonChangeEvent event) {
        this.customDateMethods.changeSeason();
    }
}
