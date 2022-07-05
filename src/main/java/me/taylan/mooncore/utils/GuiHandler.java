package me.taylan.mooncore.utils;

import com.destroystokyo.paper.MaterialTags;
import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.animations.CookAnim;
import me.taylan.mooncore.enchanting.Enchants;
import me.taylan.mooncore.listeners.JoinListener;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.title.Title;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

public class GuiHandler {
    public MoonCore plugin;

    private StatsManager stats;
    private ItemHandler itemHandler;
    private Enchants Enchants;
    private CookAnim cookAnim;

    public GuiHandler(MoonCore plugin) {
        this.plugin = plugin;
        this.cookAnim = plugin.getCookAnim();
        this.itemHandler = plugin.getItemHandler();
        this.Enchants = plugin.getEnchants();
        this.stats = plugin.getStatsManager();
        initialize();

    }

    public Inventory inv;
    public Inventory inv2;
    public Inventory inv3;
    public Inventory inv4;
    public Inventory inv5;
    public Inventory inv6;
    public Inventory inv7;
    public Inventory inv8;
    public Inventory inv9;
    public Inventory inv10;
    public Inventory inv11;
    public Inventory inv13;
    public Inventory inv14;
    public Inventory inv15;
    public Inventory inv16;
    public Inventory inv17;
    public Inventory inv18;
    public Inventory inv19;
    public Inventory inv22;
    public Inventory inv20;
    public Inventory inv23;
    static String name = "none";

    public String inventory_name;
    public String inventory_name2;
    public String inventory_name3;
    public String inventory_name4;
    public String inventory_name5;
    public String inventory_name6;
    public String inventory_name7;
    public String inventory_name8;
    public String inventory_name9;
    public String inventory_name10;
    public String inventory_name11;
    public String inventory_name13;
    public String inventory_name14;
    public String inventory_name15;
    public String inventory_name16;
    public String inventory_name17;
    public String inventory_name22;
    public Inventory inv12;
    public Inventory inv21;
    public String inventory_name12;
    public String inventory_name18;
    public String inventory_name19;
    public String inventory_name20;
    public String inventory_name21;
    public int inv_rows12 = 6 * 9;

    public int inv_rows = 6 * 9;
    public int inv_rows2 = 5 * 9;
    public int inv_rows3 = 5 * 9;
    public int inv_rows4 = 5 * 9;
    public int inv_rows5 = 5 * 9;
    public int inv_rows6 = 3 * 9;
    public int inv_rows7 = 6 * 9;
    public int inv_rows8 = 6 * 9;
    public int inv_rows9 = 3 * 9;
    public int inv_rows14 = 4 * 9;
    public int inv_rows10 = 6 * 9;
    public int inv_rows11 = 3 * 9;
    public static HashMap<UUID, String> zerola = new HashMap<UUID, String>();
    public static HashMap<UUID, String> job = new HashMap<UUID, String>();

    public void initialize() {
        inventory_name = Painter.paint(ChatColor.DARK_GRAY + "Demirci Masası -> Ekipman İşleme");
        inventory_name2 = Painter.paint(ChatColor.DARK_GRAY + "Ustalık Bilgilerin");
        inventory_name3 = Painter.paint(ChatColor.DARK_GRAY + "Ocak");
        inventory_name4 = Painter.paint(ChatColor.DARK_GRAY + "Ocak -> T1 Yemekler");
        inventory_name5 = Painter.paint(ChatColor.DARK_GRAY + "Ekipman İşleme -> Bakır Ekipmanlar");
        inventory_name6 = Painter.paint(ChatColor.DARK_GRAY + "Ekipman İşleme -> Üretimler");
        inventory_name7 = Painter.paint(ChatColor.DARK_GRAY + "Büyü Masası");
        inventory_name8 = Painter.paint(ChatColor.DARK_GRAY + "Demirci Masası -> Hurdaya Çevir");
        inventory_name9 = Painter.paint(ChatColor.DARK_GRAY + "Demirci Masası");
        inventory_name10 = Painter.paint(ChatColor.DARK_GRAY + "Örs");
        inventory_name11 = Painter.paint(ChatColor.DARK_GRAY + "Ocak -> Üretimler");
        inventory_name12 = Painter.paint(ChatColor.DARK_GRAY + "Profili");
        inventory_name13 = Painter.paint(ChatColor.DARK_GRAY + "El Kitabın");
        inventory_name14 = Painter.paint(ChatColor.DARK_GRAY + "El Kitabın -> Niteliklerin");
        inventory_name15 = Painter.paint(ChatColor.DARK_GRAY + "El Kitabın -> Ayarlar");
        inventory_name16 = Painter.paint(ChatColor.DARK_GRAY + "El Kitabın -> Aksesuarların");
        inventory_name17 = Painter.paint(ChatColor.DARK_GRAY + "El Sanatları Masası");
        inventory_name18 = Painter.paint(ChatColor.DARK_GRAY + "El Sanatları Masası -> Yay Ger");
        inventory_name19 = Painter.paint(ChatColor.DARK_GRAY + "El Sanatları Masası -> Deri Dik");
        inventory_name20 = Painter.paint(ChatColor.DARK_GRAY + "El Sanatları Masası -> Olta Kur");
        inventory_name21 = Painter.paint(ChatColor.DARK_GRAY + "Fırın");
        inv = Bukkit.createInventory(null, inv_rows);
        inv2 = Bukkit.createInventory(null, inv_rows2);
        inv3 = Bukkit.createInventory(null, inv_rows3);
        inv4 = Bukkit.createInventory(null, inv_rows4);
        inv5 = Bukkit.createInventory(null, inv_rows5);
        inv6 = Bukkit.createInventory(null, inv_rows6);
        inv7 = Bukkit.createInventory(null, inv_rows7);
        inv8 = Bukkit.createInventory(null, inv_rows11);
        inv9 = Bukkit.createInventory(null, inv_rows9);
        inv10 = Bukkit.createInventory(null, inv_rows10);
        inv11 = Bukkit.createInventory(null, inv_rows11);
        inv12 = Bukkit.createInventory(null, inv_rows12);
        inv13 = Bukkit.createInventory(null, inv_rows4);
        inv14 = Bukkit.createInventory(null, inv_rows4);
        inv15 = Bukkit.createInventory(null, inv_rows4);
        inv16 = Bukkit.createInventory(null, inv_rows4);
        inv17 = Bukkit.createInventory(null, inv_rows9);
        inv18 = Bukkit.createInventory(null, inv_rows8);
        inv19 = Bukkit.createInventory(null, inv_rows5);
        inv20 = Bukkit.createInventory(null, inv_rows5);
        inv21 = Bukkit.createInventory(null, inv_rows5);
        inv22 = Bukkit.createInventory(null, inv_rows8);
        inv23 = Bukkit.createInventory(null, inv_rows11);
    }

    public Inventory leatherwork(Player p) {
        int smithLevel = stats.getSmithLevel(p.getUniqueId());
        Inventory toReturn = Bukkit.createInventory(null, inv_rows5, inventory_name19);

        itemHandler.createItem(inv20, "white_stained_glass_pane", 1, 1, " ");
        itemHandler.createItem(inv20, "white_stained_glass_pane", 1, 2, " ");
        itemHandler.createItem(inv20, "white_stained_glass_pane", 1, 3, " ");
        itemHandler.createItem(inv20, "white_stained_glass_pane", 1, 4, " ");
        itemHandler.createItem(inv20, "fletching_table", 1, 5, ChatColor.WHITE + "El Sanatları Masası",
                ChatColor.GRAY + "Burada elindeki malzemelerle", ChatColor.GRAY + "yapabileceğin ekipmanlara bakabilir",
                ChatColor.GRAY + "ve onları yaoabilirsin.", "",
                ChatColor.GOLD + "El Sanatlarındaki Ustalığın: " + ChatColor.GREEN + smithLevel);
        itemHandler.createItem(inv20, "white_stained_glass_pane", 1, 6, " ");
        itemHandler.createItem(inv20, "white_stained_glass_pane", 1, 7, " ");
        itemHandler.createItem(inv20, "white_stained_glass_pane", 1, 8, " ");
        itemHandler.createItem(inv20, "chest", 1, 9, Painter.paint("&6El Sanatları Deposu"),
                Painter.paint("&7Buradan yaptığın ekipmanları alabilirsin."),
                Painter.paint("&7Açmak için &e&lSağ Tıkla."));
        itemHandler.createItem(inv20, "black_stained_glass_pane", 1, 10, " ");
        itemHandler.createItem(inv20, "black_stained_glass_pane", 1, 11, " ");
        itemHandler.createItem(inv20, "black_stained_glass_pane", 1, 12, " ");
        itemHandler.createItem(inv20, "black_stained_glass_pane", 1, 13, " ");
        itemHandler.createItem(inv20, "black_stained_glass_pane", 1, 14, " ");
        itemHandler.createItem(inv20, "black_stained_glass_pane", 1, 15, " ");
        itemHandler.createItem(inv20, "black_stained_glass_pane", 1, 16, " ");
        itemHandler.createItem(inv20, "black_stained_glass_pane", 1, 17, " ");
        itemHandler.createItem(inv20, "black_stained_glass_pane", 1, 18, " ");
        itemHandler.createItem(inv20, "leather", 1, 19, ChatColor.GOLD + "İnek Derisinden Ekipmanlar",
                ChatColor.GRAY + "Yapabileceğin ekipmanlara bakmak",
                ChatColor.GRAY + "için " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv20, "leather", 1, 20, ChatColor.GOLD + "Bizon Derisinden Ekipmanlar",
                ChatColor.GRAY + "Yapabileceğin ekipmanlara bakmak",
                ChatColor.GRAY + "için " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        if (smithLevel > 2) {
            itemHandler.createItem(inv20, "leather", 1, 21, ChatColor.GRAY + "Yaban Domuzu Derisi Ekipmanlar",
                    ChatColor.GRAY + "Yapabileceğin ekipmanlara bakmak",
                    ChatColor.GRAY + "için " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        } else {
            itemHandler.createItem(inv20, "red_stained_glass_pane", 1, 21, ChatColor.GRAY + "??? " + ChatColor.RED + "(Ustalık Yetersiz)",
                    ChatColor.GRAY + "Bu deriyi dikebilmek için el sanatlarındaki",
                    ChatColor.GRAY + "ustalığının 2. seviyeden yüksek olması gerekir.");
        }
        if (smithLevel > 4) {
            itemHandler.createItem(inv20, "leather", 1, 22, ChatColor.GRAY + "Kurt Postundan Ekipmanlar",
                    ChatColor.GRAY + "Yapabileceğin ekipmanlara bakmak",
                    ChatColor.GRAY + "için " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        } else {
            itemHandler.createItem(inv20, "red_stained_glass_pane", 1, 22, ChatColor.GRAY + "??? " + ChatColor.RED + "(Ustalık Yetersiz)",
                    ChatColor.GRAY + "Bu deriyi dikebilmek için el sanatlarındaki",
                    ChatColor.GRAY + "ustalığının 4. seviyeden yüksek olması gerekir.");
        }
        if (smithLevel > 6) {
            itemHandler.createItem(inv20, "leather", 1, 23, ChatColor.YELLOW + "Tavşan Derisinden Ekipmanlar",
                    ChatColor.GRAY + "Yapabileceğin ekipmanlara bakmak",
                    ChatColor.GRAY + "için " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        } else {
            itemHandler.createItem(inv20, "red_stained_glass_pane", 1, 23, ChatColor.YELLOW + "??? " + ChatColor.RED + "(Ustalık Yetersiz)",
                    ChatColor.GRAY + "Bu deriyi dikebilmek için el sanatlarındaki",
                    ChatColor.GRAY + "ustalığının 6. seviyeden yüksek olması gerekir.");
        }
        if (smithLevel > 8) {
            itemHandler.createItem(inv20, "leather", 1, 24, ChatColor.GOLD + "Tilki Postundan Ekipmanlar",
                    ChatColor.GRAY + "Yapabileceğin ekipmanlara bakmak",
                    ChatColor.GRAY + "için " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        } else {
            itemHandler.createItem(inv20, "red_stained_glass_pane", 1, 24, ChatColor.GOLD + "??? " + ChatColor.RED + "(Ustalık Yetersiz)",
                    ChatColor.GRAY + "Bu deriyi dikebilmek için el sanatlarındaki",
                    ChatColor.GRAY + "ustalığının 8. seviyeden yüksek olması gerekir.");
        }
        if (smithLevel > 10) {
            itemHandler.createItem(inv20, "leather", 1, 25, ChatColor.GOLD + "Deve Derisinden Ekipmanlar",
                    ChatColor.GRAY + "Yapabileceğin ekipmanlara bakmak",
                    ChatColor.GRAY + "için " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        } else {
            itemHandler.createItem(inv20, "red_stained_glass_pane", 1, 25, ChatColor.GOLD + "??? " + ChatColor.RED + " (Ustalık Yetersiz)",
                    ChatColor.GRAY + "Bu deriyi dikebilmek için el sanatlarındaki",
                    ChatColor.GRAY + "ustalığının 10. seviyeden yüksek olması gerekir.");
        }
        if (smithLevel > 12) {
            itemHandler.createItem(inv20, "leather", 1, 26, ChatColor.DARK_GRAY + "Mantikor Derisinden Ekipmanlar",
                    ChatColor.GRAY + "Yapabileceğin ekipmanlara bakmak",
                    ChatColor.GRAY + "için " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        } else {
            itemHandler.createItem(inv20, "red_stained_glass_pane", 1, 26, ChatColor.DARK_GRAY + "??? " + ChatColor.RED + "(Ustalık Yetersiz)",
                    ChatColor.GRAY + "Bu deriyi dikebilmek için el sanatlarındaki",
                    ChatColor.GRAY + "ustalığının 12. seviyeden yüksek olması gerekir.");
        }
        if (smithLevel > 14) {
            itemHandler.createItem(inv20, "leather", 1, 27, ChatColor.WHITE + "Zefir Postundan Ekipmanlar",
                    ChatColor.GRAY + "Yapabileceğin ekipmanlara bakmak",
                    ChatColor.GRAY + "için " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        } else {
            itemHandler.createItem(inv20, "red_stained_glass_pane", 1, 27, ChatColor.RED + "??? " + ChatColor.RED + "(Ustalık Yetersiz)",
                    ChatColor.GRAY + "Bu deriyi dikebilmek için el sanatlarındaki",
                    ChatColor.GRAY + "ustalığının 14. seviyeden yüksek olması gerekir.");
        }

        toReturn.setContents(inv20.getContents());
        return toReturn;
    }

    public Inventory GUI2(Player p) {
        int smithLevel = stats.getSmithLevel(p.getUniqueId());
        Inventory toReturn = Bukkit.createInventory(null, inv_rows, inventory_name);

        itemHandler.createItem(inv, "white_stained_glass_pane", 1, 1, " ");
        itemHandler.createItem(inv, "white_stained_glass_pane", 1, 2, " ");
        itemHandler.createItem(inv, "white_stained_glass_pane", 1, 3, " ");
        itemHandler.createItem(inv, "white_stained_glass_pane", 1, 4, " ");
        itemHandler.createItem(inv, "smithing_table", 1, 5, ChatColor.WHITE + "Demirci Masası",
                ChatColor.GRAY + "Burada elindeki malzemelerle", ChatColor.GRAY + "yapabileceğin ekipmanlara bakabilir",
                ChatColor.GRAY + "ve onları işleyebilirsin.", "",
                ChatColor.GOLD + "Demircilikteki Ustalığın: " + ChatColor.GREEN + smithLevel);
        itemHandler.createItem(inv, "white_stained_glass_pane", 1, 6, " ");
        itemHandler.createItem(inv, "white_stained_glass_pane", 1, 7, " ");
        itemHandler.createItem(inv, "white_stained_glass_pane", 1, 8, " ");
        itemHandler.createItem(inv, "chest", 1, 9, Painter.paint("&6Depo"),
                Painter.paint("&7Buradan işlenmiş ekipmanlarını alabilirsin."),
                Painter.paint("&7Açmak için &e&lSağ Tıkla."));
        itemHandler.createItem(inv, "black_stained_glass_pane", 1, 10, " ");
        itemHandler.createItem(inv, "black_stained_glass_pane", 1, 11, " ");
        itemHandler.createItem(inv, "black_stained_glass_pane", 1, 12, " ");
        itemHandler.createItem(inv, "black_stained_glass_pane", 1, 13, " ");
        itemHandler.createItem(inv, "black_stained_glass_pane", 1, 14, " ");
        itemHandler.createItem(inv, "black_stained_glass_pane", 1, 15, " ");
        itemHandler.createItem(inv, "black_stained_glass_pane", 1, 16, " ");
        itemHandler.createItem(inv, "black_stained_glass_pane", 1, 17, " ");
        itemHandler.createItem(inv, "black_stained_glass_pane", 1, 18, " ");
        itemHandler.createItem(inv, "copper_ingot", 1, 19, ChatColor.GOLD + "Bakır Ekipmanlar",
                ChatColor.GRAY + "Yapabileceğin ekipmanlara bakmak",
                ChatColor.GRAY + "için " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv, "copper_ingot", 1, 20, ChatColor.GOLD + "Bronz Ekipmanlar",
                ChatColor.GRAY + "Yapabileceğin ekipmanlara bakmak",
                ChatColor.GRAY + "için " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        if (smithLevel > 3) {
            itemHandler.createItem(inv, "iron_ingot", 1, 21, ChatColor.GRAY + "Demir Ekipmanlar",
                    ChatColor.GRAY + "Yapabileceğin ekipmanlara bakmak",
                    ChatColor.GRAY + "için " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        } else {
            itemHandler.createItem(inv, "red_stained_glass_pane", 1, 21, ChatColor.GRAY + "??? " + ChatColor.RED + "(Ustalık Yetersiz)",
                    ChatColor.GRAY + "Bu madeni işleyebilmek için demircilikteki",
                    ChatColor.GRAY + "ustalığının 4. seviyeden yüksek olması gerekir.");
        }
        if (smithLevel > 5) {
            itemHandler.createItem(inv, "gold_ingot", 1, 22, ChatColor.YELLOW + "Altın Ekipmanlar",
                    ChatColor.GRAY + "Yapabileceğin ekipmanlara bakmak",
                    ChatColor.GRAY + "için " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        } else {
            itemHandler.createItem(inv, "red_stained_glass_pane", 1, 22, ChatColor.YELLOW + "??? " + ChatColor.RED + "(Ustalık Yetersiz)",
                    ChatColor.GRAY + "Bu madeni işleyebilmek için demircilikteki",
                    ChatColor.GRAY + "ustalığının 6. seviyeden yüksek olması gerekir.");
        }
        if (smithLevel > 7) {
            itemHandler.createItem(inv, "copper_ingot", 1, 23, ChatColor.DARK_PURPLE + "Obsidyen Ekipmanlar",
                    ChatColor.GRAY + "Yapabileceğin ekipmanlara bakmak",
                    ChatColor.GRAY + "için " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        } else {
            itemHandler.createItem(inv, "red_stained_glass_pane", 1, 23, ChatColor.DARK_PURPLE + "??? " + ChatColor.RED + "(Ustalık Yetersiz)",
                    ChatColor.GRAY + "Bu madeni işleyebilmek için demircilikteki",
                    ChatColor.GRAY + "ustalığının 8. seviyeden yüksek olması gerekir.");
        }
        if (smithLevel > 9) {
            itemHandler.createItem(inv, "iron_ingot", 1, 24, ChatColor.AQUA + "Adamantium Ekipmanlar",
                    ChatColor.GRAY + "Yapabileceğin ekipmanlara bakmak",
                    ChatColor.GRAY + "için " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        } else {
            itemHandler.createItem(inv, "red_stained_glass_pane", 1, 24, ChatColor.AQUA + "??? " + ChatColor.RED + " (Ustalık Yetersiz)",
                    ChatColor.GRAY + "Bu madeni işleyebilmek için demircilikteki",
                    ChatColor.GRAY + "ustalığının 10. seviyeden yüksek olması gerekir.");
        }
        if (smithLevel > 11) {
            itemHandler.createItem(inv, "netherite_ingot", 1, 25, ChatColor.DARK_GRAY + "Netherit Ekipmanlar",
                    ChatColor.GRAY + "Yapabileceğin ekipmanlara bakmak",
                    ChatColor.GRAY + "için " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        } else {
            itemHandler.createItem(inv, "red_stained_glass_pane", 1, 25, ChatColor.DARK_GRAY + "??? " + ChatColor.RED + "(Ustalık Yetersiz)",
                    ChatColor.GRAY + "Bu madeni işleyebilmek için demircilikteki",
                    ChatColor.GRAY + "ustalığının 12. seviyeden yüksek olması gerekir.");
        }
        if (smithLevel > 13) {
            itemHandler.createItem(inv, "copper_ingot", 1, 26, ChatColor.RED + "Kızıl Metal Ekipmanlar",
                    ChatColor.GRAY + "Yapabileceğin ekipmanlara bakmak",
                    ChatColor.GRAY + "için " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        } else {
            itemHandler.createItem(inv, "red_stained_glass_pane", 1, 26, ChatColor.RED + "??? " + ChatColor.RED + "(Ustalık Yetersiz)",
                    ChatColor.GRAY + "Bu madeni işleyebilmek için demircilikteki",
                    ChatColor.GRAY + "ustalığının 14. seviyeden yüksek olması gerekir.");
        }
        if (smithLevel > 15) {
            itemHandler.createItem(inv, "iron_ingot", 1, 27, ChatColor.DARK_AQUA + "Mitril Ekipmanlar",
                    ChatColor.GRAY + "Yapabileceğin ekipmanlara bakmak",
                    ChatColor.GRAY + "için " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        } else {
            itemHandler.createItem(inv, "red_stained_glass_pane", 1, 27, ChatColor.DARK_AQUA + "??? " + ChatColor.RED + "(Ustalık Yetersiz)",
                    ChatColor.GRAY + "Bu madeni işleyebilmek için demircilikteki",
                    ChatColor.GRAY + "ustalığının 16. seviyeden yüksek olması gerekir.");
        }
        if (smithLevel > 17) {
            itemHandler.createItem(inv, "gold_ingot", 1, 28, ChatColor.DARK_PURPLE + "Hiçlik Ekipmanlar",
                    ChatColor.GRAY + "Yapabileceğin ekipmanlara bakmak",
                    ChatColor.GRAY + "için " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        } else {
            itemHandler.createItem(inv, "red_stained_glass_pane", 1, 28, ChatColor.DARK_PURPLE + "???" + ChatColor.RED + " (Ustalık Yetersiz)",
                    ChatColor.GRAY + "Bu madeni işleyebilmek için demircilikteki",
                    ChatColor.GRAY + "ustalığının 18. seviyeden yüksek olması gerekir.");
        }
        if (smithLevel > 19) {
            itemHandler.createItem(inv, "iron_ingot", 1, 29, ChatColor.RED + "Rodonit Ekipmanlar",
                    ChatColor.GRAY + "Yapabileceğin ekipmanlara bakmak",
                    ChatColor.GRAY + "için " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        } else {
            itemHandler.createItem(inv, "red_stained_glass_pane", 1, 29, ChatColor.RED + "??? " + ChatColor.RED + "(Ustalık Yetersiz)",
                    ChatColor.GRAY + "Bu madeni işleyebilmek için demircilikteki",
                    ChatColor.GRAY + "ustalığının 20. seviyeden yüksek olması gerekir.");
        }
        if (smithLevel > 20) {
            itemHandler.createItem(inv, "iron_ingot", 1, 30, ChatColor.AQUA + "Spektral Ekipmanlar",
                    ChatColor.GRAY + "Yapabileceğin ekipmanlara bakmak",
                    ChatColor.GRAY + "için " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        } else {
            itemHandler.createItem(inv, "red_stained_glass_pane", 1, 30, ChatColor.AQUA + "??? " + ChatColor.RED + "(Ustalık Yetersiz)",
                    ChatColor.GRAY + "Bu madeni işleyebilmek için demircilikteki",
                    ChatColor.GRAY + "ustalığının 22. seviyeden yüksek olması gerekir.");
        }
        toReturn.setContents(inv.getContents());
        return toReturn;
    }

    public Inventory GUIENCH(Player p) {
        int enchLevel = stats.getEnchLevel(p.getUniqueId());
        Inventory toReturn = Bukkit.createInventory(null, inv_rows7, inventory_name7);

        itemHandler.createItem(inv7, "white_stained_glass_pane", 1, 1, " ");
        itemHandler.createItem(inv7, "white_stained_glass_pane", 1, 2, " ");
        itemHandler.createItem(inv7, "white_stained_glass_pane", 1, 3, " ");
        itemHandler.createItem(inv7, "white_stained_glass_pane", 1, 4, " ");
        itemHandler.createItem(inv7, "enchanting_table", 1, 5, ChatColor.WHITE + "Büyü Masası",
                ChatColor.GRAY + "Burada elindeki ekipmanları büyüleyebilirsin.",
                ChatColor.GRAY + "Ekipmanları büyülemek büyülenen",
                ChatColor.GRAY + "ekipmanın kullanılırlığını arttırır.", "",
                ChatColor.GOLD + "Büyücülükte Ustalığın: " + ChatColor.GREEN + enchLevel);
        itemHandler.createItem(inv7, "white_stained_glass_pane", 1, 6, " ");
        itemHandler.createItem(inv7, "white_stained_glass_pane", 1, 7, " ");
        itemHandler.createItem(inv7, "white_stained_glass_pane", 1, 8, " ");
        itemHandler.createItem(inv7, "white_stained_glass_pane", 1, 9, " ");

        itemHandler.createItem(inv7, "black_stained_glass_pane", 1, 10, " ");
        itemHandler.createItem(inv7, "black_stained_glass_pane", 1, 11, " ");
        itemHandler.createItem(inv7, "black_stained_glass_pane", 1, 12, " ");
        itemHandler.createItem(inv7, "black_stained_glass_pane", 1, 13, " ");
        itemHandler.createItem(inv7, "black_stained_glass_pane", 1, 14, " ");
        itemHandler.createItem(inv7, "black_stained_glass_pane", 1, 15, " ");
        itemHandler.createItem(inv7, "black_stained_glass_pane", 1, 16, " ");
        itemHandler.createItem(inv7, "black_stained_glass_pane", 1, 17, " ");
        itemHandler.createItem(inv7, "black_stained_glass_pane", 1, 18, " ");
        itemHandler.createItem(inv7, "gray_stained_glass_pane", 1, 19, " ");
        itemHandler.createItem(inv7, "gray_stained_glass_pane", 1, 20, " ");
        itemHandler.createItem(inv7, "gray_stained_glass_pane", 1, 21, " ");
        itemHandler.createItem(inv7, "gray_stained_glass_pane", 1, 22, " ");
        itemHandler.createItem(inv7, "gray_stained_glass_pane", 1, 23, " ");
        itemHandler.createItem(inv7, "gray_stained_glass_pane", 1, 24, " ");
        itemHandler.createItem(inv7, "gray_stained_glass_pane", 1, 25, " ");
        itemHandler.createItem(inv7, "gray_stained_glass_pane", 1, 26, " ");
        itemHandler.createItem(inv7, "gray_stained_glass_pane", 1, 27, " ");
        itemHandler.createItem(inv7, "gray_stained_glass_pane", 1, 28, " ");
        itemHandler.createItem(inv7, "gray_stained_glass_pane", 1, 29, " ");
        itemHandler.createItem(inv7, "red_stained_glass_pane", 1, 30, " ");
        itemHandler.createItem(inv7, "gray_stained_glass_pane", 1, 31, " ");
        itemHandler.createItem(inv7, "gray_stained_glass_pane", 1, 33, " ");
        itemHandler.createItem(inv7, "red_stained_glass_pane", 1, 34, " ");
        itemHandler.createItem(inv7, "gray_stained_glass_pane", 1, 35, " ");
        itemHandler.createItem(inv7, "gray_stained_glass_pane", 1, 36, " ");
        itemHandler.createItem(inv7, "gray_stained_glass_pane", 1, 37, " ");
        itemHandler.createItem(inv7, "gray_stained_glass_pane", 1, 38, " ");
        itemHandler.createItem(inv7, "gray_stained_glass_pane", 1, 39, " ");
        itemHandler.createItem(inv7, "gray_stained_glass_pane", 1, 40, " ");
        itemHandler.createItem(inv7, "red_stained_glass_pane", 1, 41, " ");
        itemHandler.createItem(inv7, "gray_stained_glass_pane", 1, 42, " ");
        itemHandler.createItem(inv7, "gray_stained_glass_pane", 1, 43, " ");
        itemHandler.createItem(inv7, "gray_stained_glass_pane", 1, 44, " ");
        itemHandler.createItem(inv7, "gray_stained_glass_pane", 1, 45, " ");
        itemHandler.createItem(inv7, "gray_stained_glass_pane", 1, 46, " ");
        itemHandler.createItem(inv7, "gray_stained_glass_pane", 1, 47, " ");
        itemHandler.createItem(inv7, "gray_stained_glass_pane", 1, 48, " ");
        itemHandler.createItem(inv7, "gray_stained_glass_pane", 1, 49, " ");
        itemHandler.createItem(inv7, "gray_stained_glass_pane", 1, 50, " ");
        itemHandler.createItem(inv7, "gray_stained_glass_pane", 1, 51, " ");
        itemHandler.createItem(inv7, "gray_stained_glass_pane", 1, 52, " ");
        itemHandler.createItem(inv7, "gray_stained_glass_pane", 1, 53, " ");
        itemHandler.createItem(inv7, "gray_stained_glass_pane", 1, 54, " ");

        toReturn.setContents(inv7.getContents());
        return toReturn;
    }

    public Inventory nitelik(Player p) {

        Inventory toReturn = Bukkit.createInventory(null, inv_rows4, inventory_name14);
        itemHandler.createItem(inv14, "white_stained_glass_pane", 1, 1, " ");
        itemHandler.createItem(inv14, "white_stained_glass_pane", 1, 2, " ");
        itemHandler.createItem(inv14, "white_stained_glass_pane", 1, 3, " ");
        itemHandler.createItem(inv14, "white_stained_glass_pane", 1, 4, " ");
        itemHandler.createItem(inv14, "experience_bottle", 1, 5, ChatColor.WHITE + "Niteliklerin",
                ChatColor.GRAY + "Burada seviye atlayarak", ChatColor.GRAY + "kazandığın nitelik puanlarını",
                ChatColor.GRAY + "harcayıp daha da güçlenebilirsin.", "",
                ChatColor.GOLD + "Sahip Olduğun Nitelik Puanı: " + ChatColor.RED + stats.getNP(p.getUniqueId()));
        itemHandler.createItem(inv14, "white_stained_glass_pane", 1, 6, " ");
        itemHandler.createItem(inv14, "white_stained_glass_pane", 1, 7, " ");
        itemHandler.createItem(inv14, "white_stained_glass_pane", 1, 8, " ");
        itemHandler.createItem(inv14, "white_stained_glass_pane", 1, 9, " ");
        itemHandler.createItem(inv14, "black_stained_glass_pane", 1, 10, " ");
        itemHandler.createItem(inv14, "black_stained_glass_pane", 1, 11, " ");
        itemHandler.createItem(inv14, "black_stained_glass_pane", 1, 12, " ");
        itemHandler.createItem(inv14, "black_stained_glass_pane", 1, 13, " ");
        itemHandler.createItem(inv14, "black_stained_glass_pane", 1, 14, " ");
        itemHandler.createItem(inv14, "black_stained_glass_pane", 1, 15, " ");
        itemHandler.createItem(inv14, "black_stained_glass_pane", 1, 16, " ");
        itemHandler.createItem(inv14, "black_stained_glass_pane", 1, 17, " ");
        itemHandler.createItem(inv14, "black_stained_glass_pane", 1, 18, " ");
        itemHandler.createItem(inv14, "black_stained_glass_pane", 1, 19, " ");
        itemHandler.createItem(inv14, "black_stained_glass_pane", 1, 27, " ");
        itemHandler.createItem(inv14, "black_stained_glass_pane", 1, 28, " ");
        itemHandler.createItem(inv14, "black_stained_glass_pane", 1, 36, " ");
        itemHandler.createItem(inv14, "black_stained_glass_pane", 1, 37, " ");
        itemHandler.createItem(inv14, "black_stained_glass_pane", 1, 38, " ");
        itemHandler.createItem(inv14, "black_stained_glass_pane", 1, 39, " ");
        itemHandler.createItem(inv14, "black_stained_glass_pane", 1, 40, " ");
        itemHandler.createItem(inv14, "black_stained_glass_pane", 1, 41, " ");
        itemHandler.createItem(inv14, "black_stained_glass_pane", 1, 42, " ");
        itemHandler.createItem(inv14, "black_stained_glass_pane", 1, 43, " ");
        itemHandler.createItem(inv14, "black_stained_glass_pane", 1, 44, " ");
        itemHandler.createItem(inv14, "black_stained_glass_pane", 1, 45, " ");
        itemHandler.createItem(inv14, "red_dye", 1, 29, Painter.paint("&6&lDinçlik"),
                Painter.paint("&7Puan başına &6Canını &e+1 &7ve"), Painter.paint("&6Can Yenilenmeni &e+%1 &7arttırır."),
                "", Painter.paint("&8Dinçlik can değerinizi ve can yenilenmenizi belirler."),
                Painter.paint("&8Can değeriniz sizi ayakta tutan şeydir. Can yenilenmesi"),
                Painter.paint("&8ise alınan hasardan sonra ne kadar hızlı iyileştiğinizdir."), "",
                Painter.paint("&7Taban Dinçlik: &f20 &7/ &f5"),
                Painter.paint("&7Toplam Dinçlik: &f") + stats.getCan(p.getUniqueId()) + " &7/ &f"
                        + stats.getCanYenileme(p.getUniqueId()),
                "", Painter.paint("&7Nitelik Puanı eklemek için &e&lSağ Tıkla."));
        itemHandler.createItem(inv14, "iron_chestplate", 1, 30, Painter.paint("&a&lDayanıklılık"),
                Painter.paint("&7Puan başına &aZırh Değerini &e+1"),
                Painter.paint("&7ve &aDoygunluğunu &e+%1 &7arttırır."), "",
                Painter.paint("&8Dayanıklık aldığınız hasarı ve iş yapma kapasitenizi belirler."),
                Painter.paint("&8Zırh değeriniz ne kadar yüksekse alınan hasar o kadar etkili olur,"),
                Painter.paint("&8doygunluğunuz ne kadar yüksekse iş yaparken yorulmazsınız."), "",
                Painter.paint("&7Taban Dayanıklılık: &f0 &7/ &f0"),
                Painter.paint("&7Toplam Dayanıklılık: &f") + stats.getDirenc(p.getUniqueId()) + " &7/ &f"
                        + stats.getDoygunluk(p.getUniqueId()),
                "", Painter.paint("&7Nitelik Puanı eklemek için &e&lSağ Tıkla."));
        itemHandler.createItem(inv14, "blaze_powder", 1, 31, Painter.paint("&c&lGüç"),
                Painter.paint("&7Puan başına &cGücünü &e+4 &7arttırır."), "",
                Painter.paint("&8Güç hasar kaynaklarınızdan biridir. Ne kadar "),
                Painter.paint("&8güçlüyseniz darbeleriniz de bir o kadar etkili olur."), "",
                Painter.paint("&7Taban Güç: &f5"), Painter.paint("&7Toplam Güç: &f") + stats.getGuc(p.getUniqueId()),
                "", Painter.paint("&7Nitelik Puanı eklemek için &e&lSağ Tıkla."));
        itemHandler.createItem(inv14, "glowstone_dust", 1, 33, Painter.paint("&e&lDenge"),
                Painter.paint("&7Puan başına &eDengeni &e+2 &7arttırır."), "",
                Painter.paint("&8Denge daha seri bir şekilde saldırabilmenizi sağlar."),
                Painter.paint("&8Dengeli bir duruş vuruşlarınızın da dengeli olmasını sağlar."), "",
                Painter.paint("&7Taban Denge: &f0"),
                Painter.paint("&7Toplam Denge: &f") + stats.getSaldiriHizi(p.getUniqueId()), "",
                Painter.paint("&7Nitelik Puanı eklemek için &e&lSağ Tıkla."));
        itemHandler.createItem(inv14, "feather", 1, 34, Painter.paint("&f&lÇeviklik"),
                Painter.paint("&7Puan başına &fÇevikliğini &e+1 &7arttırır."), "",
                Painter.paint("&8Çeviklik ne kadar seri hareket ettiğinizdir. Çevikliğiniz "),
                Painter.paint("&8ne kadar yüksekse o kadar hızlı hareket edersiniz."), "",
                Painter.paint("&7Taban Çeviklik: &f0"),
                Painter.paint("&7Toplam Çeviklik: &f") + stats.getHiz(p.getUniqueId()), "",
                Painter.paint("&7Nitelik Puanı eklemek için &e&lSağ Tıkla."));
        itemHandler.createItem(inv14, "nether_star", 1, 35, Painter.paint("&3&lHüner"),
                Painter.paint("&7Puan başına &3Kritik Hasarını &e+1"),
                Painter.paint("&7ve &3Kritik Şansını &e+%1 &7arttırır."), "",
                Painter.paint("&8Hüner savaşta kullandığınız silahı daha iyi kullanmanızı sağlar."),
                Painter.paint("&8Silahını iyi kullanan bir kişi rakibin zayıf noktalarını da görebilir."), "",
                Painter.paint("&7Taban Hüner: &f12 &7/ &f0"),
                Painter.paint("&7Toplam Hüner: &f") + stats.getKritikHasari(p.getUniqueId()) + " &7/ &f"
                        + stats.getKritikSansi(p.getUniqueId()),
                "", Painter.paint("&7Nitelik Puanı eklemek için &e&lSağ Tıkla."));
        if (stats.getharcananNP(p.getUniqueId()) > 3) {
            int harcanannp = stats.getharcananNP(p.getUniqueId()) - 3;
            itemHandler.createItem(inv14, "barrier", 1, 23, Painter.paint("&4Niteliklerini Sıfırla!"),
                    Painter.paint("&7Niteliklerini sıfırlamak harcadığın puanları sana geri"),
                    Painter.paint("&7kazandırır. Fakat nitelik puanlarının birazı yok olur."), "",
                    Painter.paint("&fKazanılacak Nitelik Puanları: &a" + harcanannp), "",
                    Painter.paint("&7Niteliklerini sıfırlamak için &e&lSağ Tıkla."));
        } else {
            itemHandler.createItem(inv14, "barrier", 1, 23, Painter.paint("&4Niteliklerini Sıfırla!"),
                    Painter.paint("&7Niteliklerini sıfırlamak harcadığın puanları sana geri"),
                    Painter.paint("&7kazandırır. Fakat nitelik puanlarının birazı yok olur."), "",
                    Painter.paint("&fKazanılacak Nitelik Puanları: &a" + 0), "",
                    Painter.paint("&7Niteliklerini sıfırlamak için &e&lSağ Tıkla."));
        }
        toReturn.setContents(inv14.getContents());
        return toReturn;
    }

    public Inventory profil(Player p, Player profil) {
        Inventory toReturn = Bukkit.createInventory(null, inv_rows12,
                Painter.paint("&7" + profil.getName() + " Profili"));

        itemHandler.createItem(inv12, "gray_stained_glass_pane", 1, 1, " ");
        itemHandler.createItem(inv12, "gray_stained_glass_pane", 1, 2, " ");
        itemHandler.createItem(inv12, "gray_stained_glass_pane", 1, 3, " ");
        itemHandler.createItem(inv12, "gray_stained_glass_pane", 1, 4, " ");
        itemHandler.createItem(inv12, "gray_stained_glass_pane", 1, 5, " ");
        itemHandler.createItem(inv12, "gray_stained_glass_pane", 1, 6, " ");
        itemHandler.createItem(inv12, "gray_stained_glass_pane", 1, 7, " ");
        itemHandler.createItem(inv12, "gray_stained_glass_pane", 1, 8, " ");
        itemHandler.createItem(inv12, "gray_stained_glass_pane", 1, 9, " ");
        itemHandler.createItem(inv12, "gray_stained_glass_pane", 1, 10, " ");
        if (!(p == profil)) {
            itemHandler.createItem(inv12, "player_head", 1, 11,
                    Painter.paint("&3" + profil.getName() + " İsimli Karakterin Bilgileri"),
                    Painter.paint("&7İsim: &f" + profil.getName()),
                    Painter.paint("&7Meslek: &6" + stats.getMeslek(profil.getUniqueId())),
                    Painter.paint("&7Seviye: &b" + stats.getLevel(profil.getUniqueId())),
                    Painter.paint("&7Seviye İlerlemesi: &b" + stats.getExp(profil.getUniqueId()))+" / "+stats.getRequiredExp(profil.getUniqueId()),
                    Painter.paint("&7Şuanki Ağırlığı: &f") + stats.getAgirlik(profil.getUniqueId()), "",
                    Painter.paint(" &6❤ Dinçlik: &f") + stats.getCan(profil.getUniqueId()) + " &7/&f "
                            + stats.getCanYenileme(profil.getUniqueId()),
                    Painter.paint(" &8&oDinçlik = Can/Can Yenilenmesi."),
                    Painter.paint(" &a🛡 Dayanıklılık: &f") + stats.getDirenc(profil.getUniqueId()) + " &7/&f "
                            + stats.getDoygunluk(profil.getUniqueId()),
                    Painter.paint(" &8&oDayanıklılık = Direnç/Doygunluk."),
                    Painter.paint(" &c⚔ Güç: &f") + stats.getGuc(profil.getUniqueId()),
                    Painter.paint(" &e❂ Denge: &f") + stats.getSaldiriHizi(profil.getUniqueId()),
                    Painter.paint(" &8&oDenge = Saldırı Hızı"),
                    Painter.paint(" &f🌊 Çeviklik: &f") + stats.getHiz(profil.getUniqueId()),
                    Painter.paint(" &3※ Hüner: &f") + stats.getKritikHasari(profil.getUniqueId()) + " &7/&f "
                            + stats.getKritikSansi(profil.getUniqueId()),
                    Painter.paint(" &8&oHüner = Kritik Hasarı/Kritik Hasar Şansı"),
                    Painter.paint(" &b❆ Soguk Direnci: &f") + stats.getSogukDirenci(profil.getUniqueId()),
                    Painter.paint(" &4🔥 Sıcak Direnci: &f") + stats.getSicakDirenci(profil.getUniqueId()),
                    Painter.paint(" &5⌘ Hiclik Direnci: &f") + stats.getHiclikDirenci(profil.getUniqueId()), "");
        } else {
            itemHandler.createItem(inv12, "player_head", 1, 11, Painter.paint("&3Karakter Bilgileri"),
                    Painter.paint("&7İsim: &f" + p.getName()),
                    Painter.paint("&7Meslek: &6" + stats.getMeslek(p.getUniqueId())),
                    Painter.paint("&7Seviye: &b" + stats.getLevel(p.getUniqueId())),
                    Painter.paint("&7Seviye İlerlemesi: &b" + stats.getExp(p.getUniqueId()))+" / "+stats.getRequiredExp(p.getUniqueId()),
                    Painter.paint("&7Şuanki Ağırlığı: &f") + stats.getAgirlik(p.getUniqueId()), "",
                    Painter.paint(" &6❤ Dinçlik: &f") + stats.getCan(p.getUniqueId()) + " &7/&f "
                            + stats.getCanYenileme(p.getUniqueId()),
                    Painter.paint(" &8&oDinçlik = Can/Can Yenilenmesi."),
                    Painter.paint(" &a🛡 Dayanıklılık: &f") + stats.getDirenc(p.getUniqueId()) + " &7/&f "
                            + stats.getDoygunluk(p.getUniqueId()),
                    Painter.paint(" &8&oDayanıklılık = Direnç/Doygunluk."),
                    Painter.paint(" &c⚔ Güç: &f") + stats.getGuc(p.getUniqueId()),
                    Painter.paint(" &e❂ Denge: &f") + stats.getSaldiriHizi(p.getUniqueId()),
                    Painter.paint(" &8&oDenge = Saldırı Hızı"),
                    Painter.paint(" &f🌊 Çeviklik: &f") + stats.getHiz(p.getUniqueId()),
                    Painter.paint(" &3※ Hüner: &f") + stats.getKritikHasari(p.getUniqueId()) + " &7/&f "
                            + stats.getKritikSansi(p.getUniqueId()),
                    Painter.paint(" &8&oHüner = Kritik Hasarı/Kritik Hasar Şansı"),
                    Painter.paint(" &b❆ Soguk Direnci: &f") + stats.getSogukDirenci(p.getUniqueId()),
                    Painter.paint(" &4🔥 Sıcak Direnci: &f") + stats.getSicakDirenci(p.getUniqueId()),
                    Painter.paint(" &5⌘ Hiclik Direnci: &f") + stats.getHiclikDirenci(p.getUniqueId()), "");
        }
        itemHandler.createItem(inv12, "gray_stained_glass_pane", 1, 12, " ");
        itemHandler.createItem(inv12, "gray_stained_glass_pane", 1, 13, " ");
        if (profil.getInventory().getHelmet() == null) {
            itemHandler.createItem(inv12, "red_stained_glass_pane", 1, 14, Painter.paint("&eBoş Miğfer Bölmesi"));
        }
        itemHandler.createItem(inv12, "gray_stained_glass_pane", 1, 15, " ");
        itemHandler.createItem(inv12, "gray_stained_glass_pane", 1, 16, " ");
        itemHandler.createItem(inv12, "wooden_pickaxe", 1, 17, Painter.paint("&6Sivil Rozeti"),
                Painter.paint("&7Remiel halkınının bir parçası olduğun için."));
        itemHandler.createItem(inv12, "gray_stained_glass_pane", 1, 18, " ");
        itemHandler.createItem(inv12, "gray_stained_glass_pane", 1, 19, " ");
        itemHandler.createItem(inv12, "red_stained_glass_pane", 1, 20, " ");
        itemHandler.createItem(inv12, "gray_stained_glass_pane", 1, 21, " ");
        if (stats.getKolye(profil.getUniqueId()).equals("Yok..")) {
            itemHandler.createItem(inv12, "red_stained_glass_pane", 1, 22, Painter.paint("&eBoş Kolye Bölmesi"));
        }
        if (profil.getInventory().getChestplate() == null) {
            itemHandler.createItem(inv12, "red_stained_glass_pane", 1, 23, Painter.paint("&eBoş Göğüslük Bölmesi"));
        }
        if (stats.getTilsim(profil.getUniqueId()).equals("Yok..")) {
            itemHandler.createItem(inv12, "red_stained_glass_pane", 1, 24,
                    Painter.paint("&eBoş Tılsım/Ok Kılıfı Bölmesi"));
        }
        itemHandler.createItem(inv12, "gray_stained_glass_pane", 1, 25, " ");
        itemHandler.createItem(inv12, "red_stained_glass_pane", 1, 26, Painter.paint("&6Boş Rozet Bölmesi"));
        itemHandler.createItem(inv12, "gray_stained_glass_pane", 1, 27, " ");
        itemHandler.createItem(inv12, "gray_stained_glass_pane", 1, 28, " ");
        itemHandler.createItem(inv12, "red_stained_glass_pane", 1, 29, " ");
        itemHandler.createItem(inv12, "gray_stained_glass_pane", 1, 30, " ");
        if (stats.getEldiven(profil.getUniqueId()).equals("Yok..")) {
            itemHandler.createItem(inv12, "red_stained_glass_pane", 1, 31, Painter.paint("&eBoş Eldiven Bölmesi"));
        }
        if (profil.getInventory().getLeggings() == null) {
            itemHandler.createItem(inv12, "red_stained_glass_pane", 1, 32, Painter.paint("&eBoş Pantolon Bölmesi"));
        }
        if (stats.getYuzuk(profil.getUniqueId()).equals("Yok..")) {
            itemHandler.createItem(inv12, "red_stained_glass_pane", 1, 33, Painter.paint("&eBoş Yüzük Bölmesi"));
        }
        itemHandler.createItem(inv12, "gray_stained_glass_pane", 1, 34, " ");
        itemHandler.createItem(inv12, "red_stained_glass_pane", 1, 35, Painter.paint("&6Boş Rozet Bölmesi"));
        itemHandler.createItem(inv12, "gray_stained_glass_pane", 1, 36, " ");
        itemHandler.createItem(inv12, "gray_stained_glass_pane", 1, 37, " ");
        itemHandler.createItem(inv12, "red_stained_glass_pane", 1, 38, " ");
        itemHandler.createItem(inv12, "gray_stained_glass_pane", 1, 39, " ");
        itemHandler.createItem(inv12, "dirt", 1, 40, Painter.paint("&eBoş Sağ El"));

        if (profil.getInventory().getBoots() == null) {
            itemHandler.createItem(inv12, "red_stained_glass_pane", 1, 41, Painter.paint("&eBoş Bot Bölmesi"));
        }
        itemHandler.createItem(inv12, "dirt", 1, 42, Painter.paint("&eBoş Sol El"));

        itemHandler.createItem(inv12, "gray_stained_glass_pane", 1, 43, " ");
        itemHandler.createItem(inv12, "red_stained_glass_pane", 1, 44, Painter.paint("&6Boş Rozet Bölmesi"));
        itemHandler.createItem(inv12, "gray_stained_glass_pane", 1, 45, " ");
        itemHandler.createItem(inv12, "gray_stained_glass_pane", 1, 46, " ");
        itemHandler.createItem(inv12, "gray_stained_glass_pane", 1, 47, " ");
        itemHandler.createItem(inv12, "gray_stained_glass_pane", 1, 48, " ");
        itemHandler.createItem(inv12, "gray_stained_glass_pane", 1, 49, " ");
        itemHandler.createItem(inv12, "gray_stained_glass_pane", 1, 50, " ");
        itemHandler.createItem(inv12, "gray_stained_glass_pane", 1, 51, " ");
        itemHandler.createItem(inv12, "gray_stained_glass_pane", 1, 52, " ");
        itemHandler.createItem(inv12, "gray_stained_glass_pane", 1, 53, " ");
        itemHandler.createItem(inv12, "gray_stained_glass_pane", 1, 54, " ");

        toReturn.setContents(inv12.getContents());
        return toReturn;
    }

    public Inventory anvilgui(Player p) {
        int smithLevel = stats.getSmithLevel(p.getUniqueId());
        Inventory toReturn = Bukkit.createInventory(null, inv_rows10, inventory_name10);

        itemHandler.createItem(inv10, "white_stained_glass_pane", 1, 1, " ");
        itemHandler.createItem(inv10, "white_stained_glass_pane", 1, 2, " ");
        itemHandler.createItem(inv10, "white_stained_glass_pane", 1, 3, " ");
        itemHandler.createItem(inv10, "white_stained_glass_pane", 1, 4, " ");
        itemHandler.createItem(inv10, "anvil", 1, 5, ChatColor.WHITE + "Örs",
                ChatColor.GRAY + "Burada elindeki ekipmanı başka",
                ChatColor.GRAY + "bir büyü ve benzeri bir şeyle kombinleyerek",
                ChatColor.GRAY + "ekipmana ek özellik ekleyebilirsin.", "",
                ChatColor.GOLD + "Demircilikte Ustalığın: " + ChatColor.GREEN + smithLevel);
        itemHandler.createItem(inv10, "white_stained_glass_pane", 1, 6, " ");
        itemHandler.createItem(inv10, "white_stained_glass_pane", 1, 7, " ");
        itemHandler.createItem(inv10, "white_stained_glass_pane", 1, 8, " ");
        itemHandler.createItem(inv10, "white_stained_glass_pane", 1, 9, " ");

        itemHandler.createItem(inv10, "black_stained_glass_pane", 1, 10, " ");
        itemHandler.createItem(inv10, "black_stained_glass_pane", 1, 11, " ");
        itemHandler.createItem(inv10, "black_stained_glass_pane", 1, 12, " ");
        itemHandler.createItem(inv10, "black_stained_glass_pane", 1, 13, " ");
        itemHandler.createItem(inv10, "black_stained_glass_pane", 1, 14, " ");
        itemHandler.createItem(inv10, "black_stained_glass_pane", 1, 15, " ");
        itemHandler.createItem(inv10, "black_stained_glass_pane", 1, 16, " ");
        itemHandler.createItem(inv10, "black_stained_glass_pane", 1, 17, " ");
        itemHandler.createItem(inv10, "black_stained_glass_pane", 1, 18, " ");
        itemHandler.createItem(inv10, "gray_stained_glass_pane", 1, 19, " ");
        itemHandler.createItem(inv10, "gray_stained_glass_pane", 1, 20, " ");
        itemHandler.createItem(inv10, "gray_stained_glass_pane", 1, 21, " ");
        itemHandler.createItem(inv10, "gray_stained_glass_pane", 1, 22, " ");
        itemHandler.createItem(inv10, "gray_stained_glass_pane", 1, 23, " ");
        itemHandler.createItem(inv10, "gray_stained_glass_pane", 1, 24, " ");
        itemHandler.createItem(inv10, "gray_stained_glass_pane", 1, 25, " ");
        itemHandler.createItem(inv10, "gray_stained_glass_pane", 1, 26, " ");
        itemHandler.createItem(inv10, "gray_stained_glass_pane", 1, 27, " ");
        itemHandler.createItem(inv10, "gray_stained_glass_pane", 1, 28, " ");
        itemHandler.createItem(inv10, "gray_stained_glass_pane", 1, 29, " ");

        itemHandler.createItem(inv10, "gray_stained_glass_pane", 1, 31, " ");
        itemHandler.createItem(inv10, "gray_stained_glass_pane", 1, 32, " ");
        itemHandler.createItem(inv10, "gray_stained_glass_pane", 1, 33, " ");

        itemHandler.createItem(inv10, "gray_stained_glass_pane", 1, 35, " ");
        itemHandler.createItem(inv10, "gray_stained_glass_pane", 1, 36, " ");
        itemHandler.createItem(inv10, "gray_stained_glass_pane", 1, 37, " ");
        itemHandler.createItem(inv10, "gray_stained_glass_pane", 1, 38, " ");
        itemHandler.createItem(inv10, "red_stained_glass_pane", 1, 39, " ");
        itemHandler.createItem(inv10, "red_stained_glass_pane", 1, 40, " ");
        itemHandler.createItem(inv10, "red_stained_glass_pane", 1, 42, " ");
        itemHandler.createItem(inv10, "red_stained_glass_pane", 1, 43, " ");
        itemHandler.createItem(inv10, "gray_stained_glass_pane", 1, 44, " ");
        itemHandler.createItem(inv10, "gray_stained_glass_pane", 1, 45, " ");
        itemHandler.createItem(inv10, "gray_stained_glass_pane", 1, 46, " ");
        itemHandler.createItem(inv10, "gray_stained_glass_pane", 1, 47, " ");
        itemHandler.createItem(inv10, "gray_stained_glass_pane", 1, 48, " ");
        itemHandler.createItem(inv10, "gray_stained_glass_pane", 1, 49, " ");
        itemHandler.createItem(inv10, "gray_stained_glass_pane", 1, 50, " ");
        itemHandler.createItem(inv10, "gray_stained_glass_pane", 1, 51, " ");
        itemHandler.createItem(inv10, "gray_stained_glass_pane", 1, 52, " ");
        itemHandler.createItem(inv10, "gray_stained_glass_pane", 1, 53, " ");
        itemHandler.createItem(inv10, "gray_stained_glass_pane", 1, 54, " ");

        toReturn.setContents(inv10.getContents());
        return toReturn;
    }

    public Inventory accessorymenu(Player p) {
        Inventory toReturn = Bukkit.createInventory(null, inv_rows4, inventory_name16);
        ArrayList<ItemStack> list = (ArrayList<ItemStack>) stats.getHepsi(p.getUniqueId());
        itemHandler.createItem(inv16, "white_stained_glass_pane", 1, 1, " ");
        itemHandler.createItem(inv16, "white_stained_glass_pane", 1, 2, " ");
        itemHandler.createItem(inv16, "white_stained_glass_pane", 1, 3, " ");
        itemHandler.createItem(inv16, "white_stained_glass_pane", 1, 4, " ");
        itemHandler.createItem(inv16, "item_frame", 1, 5, ChatColor.WHITE + "Aksesuarların",
                ChatColor.GRAY + "Burada aksesuarlarını takıp çıkarabilir",
                ChatColor.GRAY + "ve aksesuarlarının özelliklerini görebilirsin.");
        itemHandler.createItem(inv16, "white_stained_glass_pane", 1, 6, " ");
        itemHandler.createItem(inv16, "white_stained_glass_pane", 1, 7, " ");
        itemHandler.createItem(inv16, "white_stained_glass_pane", 1, 8, " ");
        itemHandler.createItem(inv16, "white_stained_glass_pane", 1, 9, " ");

        itemHandler.createItem(inv16, "black_stained_glass_pane", 1, 10, " ");
        itemHandler.createItem(inv16, "black_stained_glass_pane", 1, 11, " ");
        itemHandler.createItem(inv16, "black_stained_glass_pane", 1, 12, " ");
        itemHandler.createItem(inv16, "black_stained_glass_pane", 1, 13, " ");
        itemHandler.createItem(inv16, "black_stained_glass_pane", 1, 14, " ");
        itemHandler.createItem(inv16, "black_stained_glass_pane", 1, 15, " ");
        itemHandler.createItem(inv16, "black_stained_glass_pane", 1, 16, " ");
        itemHandler.createItem(inv16, "black_stained_glass_pane", 1, 17, " ");
        itemHandler.createItem(inv16, "black_stained_glass_pane", 1, 18, " ");
        if ((stats.getTilsim(p.getUniqueId()).equals("Yok.."))) {
            itemHandler.createItem(inv16, "magenta_stained_glass_pane", 1, 29,
                    ChatColor.LIGHT_PURPLE + "Tılsım/Ok Kılıfı", ChatColor.DARK_GRAY + "Yok..");
        }
        if ((stats.getEldiven(p.getUniqueId()).equals("Yok.."))) {
            itemHandler.createItem(inv16, "blue_stained_glass_pane", 1, 31, ChatColor.BLUE + "Eldiven",
                    ChatColor.DARK_GRAY + "Yok..");
        }
        if ((stats.getKolye(p.getUniqueId()).equals("Yok.."))) {
            itemHandler.createItem(inv16, "yellow_stained_glass_pane", 1, 33, ChatColor.YELLOW + "Kolye",
                    ChatColor.DARK_GRAY + "Yok..");
        }
        if ((stats.getYuzuk(p.getUniqueId()).equals("Yok.."))) {
            itemHandler.createItem(inv16, "orange_stained_glass_pane", 1, 35, ChatColor.GOLD + "Yüzük",
                    ChatColor.DARK_GRAY + "Yok..");
        }
        toReturn.setContents(inv16.getContents());
        return toReturn;
    }

    public Inventory ayarmenu(Player p) {
        Inventory toReturn = Bukkit.createInventory(null, inv_rows4, inventory_name15);

        itemHandler.createItem(inv15, "white_stained_glass_pane", 1, 1, " ");
        itemHandler.createItem(inv15, "white_stained_glass_pane", 1, 2, " ");
        itemHandler.createItem(inv15, "white_stained_glass_pane", 1, 3, " ");
        itemHandler.createItem(inv15, "white_stained_glass_pane", 1, 4, " ");
        itemHandler.createItem(inv15, "comparator", 1, 5, ChatColor.WHITE + "Ayarlar",
                ChatColor.GRAY + "Burada oyun içi ayarları aktif", ChatColor.GRAY + "veya deaktif edebilirsin");
        itemHandler.createItem(inv15, "white_stained_glass_pane", 1, 6, " ");
        itemHandler.createItem(inv15, "white_stained_glass_pane", 1, 7, " ");
        itemHandler.createItem(inv15, "white_stained_glass_pane", 1, 8, " ");
        itemHandler.createItem(inv15, "white_stained_glass_pane", 1, 9, " ");

        itemHandler.createItem(inv15, "black_stained_glass_pane", 1, 10, " ");
        itemHandler.createItem(inv15, "black_stained_glass_pane", 1, 11, " ");
        itemHandler.createItem(inv15, "black_stained_glass_pane", 1, 12, " ");
        itemHandler.createItem(inv15, "black_stained_glass_pane", 1, 13, " ");
        itemHandler.createItem(inv15, "black_stained_glass_pane", 1, 14, " ");
        itemHandler.createItem(inv15, "black_stained_glass_pane", 1, 15, " ");
        itemHandler.createItem(inv15, "black_stained_glass_pane", 1, 16, " ");
        itemHandler.createItem(inv15, "black_stained_glass_pane", 1, 17, " ");
        itemHandler.createItem(inv15, "black_stained_glass_pane", 1, 18, " ");
        if (stats.getKritikAyar(p.getUniqueId())) {
            itemHandler.createItem(inv15, "tube_coral", 1, 29, ChatColor.GRAY + "Kritik Hasar Efekti",
                    ChatColor.DARK_GREEN + "Aktif");
        } else {
            itemHandler.createItem(inv15, "tube_coral", 1, 29, ChatColor.GRAY + "Kritik Hasar Efekti",
                    ChatColor.DARK_RED + "Deaktif");
        }
        if (stats.getSaldiriHiziAyar(p.getUniqueId())) {
            itemHandler.createItem(inv15, "sunflower", 1, 31, ChatColor.GRAY + "Çoklu Vuruş Ses Efekti",
                    ChatColor.DARK_GREEN + "Aktif",
                    ChatColor.DARK_GRAY + "" + ChatColor.ITALIC + "(Saldırı Hızından Gelen Çoklu Vuruş)");
        } else {
            itemHandler.createItem(inv15, "sunflower", 1, 31, ChatColor.GRAY + "Çoklu Vuruş Ses Efekti",
                    ChatColor.DARK_RED + "Deaktif",
                    ChatColor.DARK_GRAY + "" + ChatColor.ITALIC + "(Saldırı Hızından Gelen Çoklu Vuruş)");
        }
        if (stats.getYaprakAyar(p.getUniqueId())) {
            itemHandler.createItem(inv15, "oak_leaves", 1, 33, ChatColor.GRAY + "Ağaçlardan Yaprak Düşme Animasyonu",
                    ChatColor.DARK_GREEN + "Aktif");
        } else {
            itemHandler.createItem(inv15, "oak_leaves", 1, 33, ChatColor.GRAY + "Ağaçlardan Yaprak Düşme Animasyonu",
                    ChatColor.DARK_RED + "Deaktif");
        }
        if (stats.getSkorAyar(p.getUniqueId())) {
            itemHandler.createItem(inv15, "painting", 1, 35, ChatColor.GRAY + "Skor Tablosu",
                    ChatColor.DARK_GREEN + "Aktif");
        } else {
            itemHandler.createItem(inv15, "painting", 1, 35, ChatColor.GRAY + "Skor Tablosu",
                    ChatColor.DARK_RED + "Deaktif");
        }
        toReturn.setContents(inv15.getContents());
        return toReturn;
    }

    public Inventory skillGui(Player p) {
        int combatLevel = stats.getCombatLevel(p.getUniqueId());
        int combatExp = stats.getCombatExp(p.getUniqueId());
        int combatRequiredExp = stats.getCombatRequiredExp(p.getUniqueId());
        int odunculukLevel = stats.getOdunculukLevel(p.getUniqueId());
        int odunculukExp = stats.getOdunculukExp(p.getUniqueId());
        int odunculukRequiredExp = stats.getOdunculukRequiredExp(p.getUniqueId());
        int fishingLevel = stats.getFishingLevel(p.getUniqueId());
        int fishingExp = stats.getFishingExp(p.getUniqueId());
        int fishingRequiredExp = stats.getFishingRequiredExp(p.getUniqueId());
        int miningLevel = stats.getMadencilikLevel(p.getUniqueId());
        int miningExp = stats.getMadencilikExp(p.getUniqueId());
        int miningRequiredExp = stats.getMadencilikRequiredExp(p.getUniqueId());
        int cookLevel = stats.getCookLevel(p.getUniqueId());
        int cookExp = stats.getCookExp(p.getUniqueId());
        int cookRequiredExp = stats.getCookRequiredExp(p.getUniqueId());
        int alchemyLevel = stats.getAlchemyLevel(p.getUniqueId());
        int alchemyExp = stats.getAlchemyExp(p.getUniqueId());
        int alchemyRequiredExp = stats.getAlchemyRequiredExp(p.getUniqueId());
        int smithLevel = stats.getSmithLevel(p.getUniqueId());
        int smithExp = stats.getSmithExp(p.getUniqueId());
        int smithRequiredExp = stats.getSmithRequiredExp(p.getUniqueId());
        int enchLevel = stats.getEnchLevel(p.getUniqueId());
        int enchExp = stats.getEnchExp(p.getUniqueId());
        int enchRequiredExp = stats.getEnchRequiredExp(p.getUniqueId());
        int FarmingLevel = stats.getFarmingLevel(p.getUniqueId());
        int FarmingExp = stats.getFarmingExp(p.getUniqueId());
        int FarmingRequiredExp = stats.getFarmingRequiredExp(p.getUniqueId());
        int progAlchemy = alchemyRequiredExp - alchemyExp;
        int progFarming = FarmingRequiredExp - FarmingExp;
        int progEnch = enchRequiredExp - enchExp;
        int progSmith = smithRequiredExp - smithExp;
        int progCooking = cookRequiredExp - cookExp;
        int progMining = miningRequiredExp - miningExp;
        int progFishing = fishingRequiredExp - fishingExp;
        int progCombat = combatRequiredExp - combatExp;
        int progOduncu = odunculukRequiredExp - odunculukExp;
        Inventory toReturn = Bukkit.createInventory(null, inv_rows2, inventory_name2);

        itemHandler.createItem(inv2, "gray_stained_glass_pane", 1, 1, " ");
        itemHandler.createItem(inv2, "gray_stained_glass_pane", 1, 2, " ");
        itemHandler.createItem(inv2, "gray_stained_glass_pane", 1, 3, " ");
        itemHandler.createItem(inv2, "gray_stained_glass_pane", 1, 4, " ");
        itemHandler.createItem(inv2, "gray_stained_glass_pane", 1, 5, " ");
        itemHandler.createItem(inv2, "gray_stained_glass_pane", 1, 6, " ");
        itemHandler.createItem(inv2, "gray_stained_glass_pane", 1, 7, " ");
        itemHandler.createItem(inv2, "gray_stained_glass_pane", 1, 8, " ");
        itemHandler.createItem(inv2, "gray_stained_glass_pane", 1, 9, " ");
        itemHandler.createItem(inv2, "gray_stained_glass_pane", 1, 10, " ");
        itemHandler.createItem(inv2, "gray_stained_glass_pane", 1, 11, " ");
        itemHandler.createItem(inv2, "iron_sword", 1, 12, ChatColor.DARK_AQUA + "Avcılık",
                ChatColor.GREEN + "Ustalık " + combatLevel, "",
                ChatColor.GOLD + "Tecrübe: " + ChatColor.WHITE + combatExp,
                ChatColor.GOLD + "Gereken Tecrübe Puanı: " + ChatColor.WHITE + progCombat, "",
                ChatColor.GRAY + "Meslek bilgileri için " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv2, "iron_pickaxe", 1, 13, ChatColor.DARK_AQUA + "Madencilik",
                ChatColor.GREEN + "Ustalık " + miningLevel, "",
                ChatColor.GOLD + "Tecrübe: " + ChatColor.WHITE + miningExp,
                ChatColor.GOLD + "Gereken Tecrübe Puanı: " + ChatColor.WHITE + progMining, "",
                ChatColor.GRAY + "Meslek bilgileri için " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv2, "iron_axe", 1, 14, ChatColor.DARK_AQUA + "Odunculuk",
                ChatColor.GREEN + "Ustalık " + odunculukLevel, "",
                ChatColor.GOLD + "Tecrübe: " + ChatColor.WHITE + odunculukExp,
                ChatColor.GOLD + "Gereken Tecrübe Puanı: " + ChatColor.WHITE + progOduncu, "",
                ChatColor.GRAY + "Meslek bilgileri için " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv2, "fishing_rod", 1, 15, ChatColor.DARK_AQUA + "Balıkçılık",
                ChatColor.GREEN + "Ustalık " + fishingLevel, "",
                ChatColor.GOLD + "Tecrübe: " + ChatColor.WHITE + fishingExp,
                ChatColor.GOLD + "Gereken Tecrübe Puanı: " + ChatColor.WHITE + progFishing, "",
                ChatColor.GRAY + "Meslek bilgileri için " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv2, "smithing_table", 1, 16, ChatColor.DARK_AQUA + "Demircilik",
                ChatColor.GREEN + "Ustalık " + smithLevel, "",
                ChatColor.GOLD + "Tecrübe: " + ChatColor.WHITE + smithExp,
                ChatColor.GOLD + "Gereken Tecrübe Puanı: " + ChatColor.WHITE + progSmith, "",
                ChatColor.GRAY + "Meslek bilgileri için " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv2, "gray_stained_glass_pane", 1, 17, " ");
        itemHandler.createItem(inv2, "gray_stained_glass_pane", 1, 18, " ");
        itemHandler.createItem(inv2, "gray_stained_glass_pane", 1, 19, " ");
        itemHandler.createItem(inv2, "gray_stained_glass_pane", 1, 20, " ");
        itemHandler.createItem(inv2, "gray_stained_glass_pane", 1, 21, " ");
        itemHandler.createItem(inv2, "bread", 1, 22, ChatColor.DARK_AQUA + "Aşçılık",
                ChatColor.GREEN + "Ustalık " + cookLevel, "", ChatColor.GOLD + "Tecrübe: " + ChatColor.WHITE + cookExp,
                ChatColor.GOLD + "Gereken Tecrübe Puanı: " + ChatColor.WHITE + progCooking, "",
                ChatColor.GRAY + "Meslek bilgileri için " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv2, "brewing_stand", 1, 23, ChatColor.DARK_AQUA + "Simyacılık",
                ChatColor.GREEN + "Ustalık " + alchemyLevel, "",
                ChatColor.GOLD + "Tecrübe: " + ChatColor.WHITE + alchemyExp,
                ChatColor.GOLD + "Gereken Tecrübe Puanı: " + ChatColor.WHITE + progAlchemy, "",
                ChatColor.GRAY + "Meslek bilgileri için " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv2, "enchanting_table", 1, 24, ChatColor.DARK_AQUA + "Büyücülük",
                ChatColor.GREEN + "Ustalık " + enchLevel, "", ChatColor.GOLD + "Tecrübe: " + ChatColor.WHITE + enchExp,
                ChatColor.GOLD + "Gereken Tecrübe Puanı: " + ChatColor.WHITE + progEnch, "",
                ChatColor.GRAY + "Meslek bilgileri için " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv2, "gray_stained_glass_pane", 1, 25, " ");
        itemHandler.createItem(inv2, "gray_stained_glass_pane", 1, 26, " ");
        itemHandler.createItem(inv2, "gray_stained_glass_pane", 1, 27, " ");
        itemHandler.createItem(inv2, "gray_stained_glass_pane", 1, 28, " ");
        itemHandler.createItem(inv2, "gray_stained_glass_pane", 1, 29, " ");
        itemHandler.createItem(inv2, "gray_stained_glass_pane", 1, 30, " ");
        itemHandler.createItem(inv2, "gray_stained_glass_pane", 1, 31, " ");
        itemHandler.createItem(inv2, "gray_stained_glass_pane", 1, 33, " ");
        itemHandler.createItem(inv2, "gray_stained_glass_pane", 1, 34, " ");
        itemHandler.createItem(inv2, "gray_stained_glass_pane", 1, 35, " ");
        itemHandler.createItem(inv2, "gray_stained_glass_pane", 1, 36, " ");
        itemHandler.createItem(inv2, "gray_stained_glass_pane", 1, 37, " ");
        itemHandler.createItem(inv2, "gray_stained_glass_pane", 1, 38, " ");
        itemHandler.createItem(inv2, "gray_stained_glass_pane", 1, 39, " ");
        itemHandler.createItem(inv2, "gray_stained_glass_pane", 1, 40, " ");
        itemHandler.createItem(inv2, "gray_stained_glass_pane", 1, 41, " ");
        itemHandler.createItem(inv2, "wheat", 1, 32, ChatColor.DARK_AQUA + "Çiftçilik",
                ChatColor.GREEN + "Ustalık " + FarmingLevel, "",
                ChatColor.GOLD + "Tecrübe: " + ChatColor.WHITE + FarmingExp,
                ChatColor.GOLD + "Gereken Tecrübe Puanı: " + ChatColor.WHITE + progFarming, "",
                ChatColor.GRAY + "Meslek bilgileri için " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv2, "gray_stained_glass_pane", 1, 42, " ");
        itemHandler.createItem(inv2, "gray_stained_glass_pane", 1, 43, " ");
        itemHandler.createItem(inv2, "gray_stained_glass_pane", 1, 44, " ");
        itemHandler.createItem(inv2, "gray_stained_glass_pane", 1, 45, " ");

        toReturn.setContents(inv2.getContents());
        return toReturn;
    }

    public Inventory cookGui(Player p) {
        int cookLevel = stats.getCookLevel(p.getUniqueId());
        Inventory toReturn = Bukkit.createInventory(null, inv_rows3, inventory_name3);

        itemHandler.createItem(inv3, "white_stained_glass_pane", 1, 1, " ");
        itemHandler.createItem(inv3, "white_stained_glass_pane", 1, 2, " ");
        itemHandler.createItem(inv3, "white_stained_glass_pane", 1, 3, " ");
        itemHandler.createItem(inv3, "white_stained_glass_pane", 1, 4, " ");
        itemHandler.createItem(inv3, "smoker", 1, 5, ChatColor.WHITE + "Ocak",
                ChatColor.GRAY + "Burada elindeki malzemelerle", ChatColor.GRAY + "yapabileceğin yemeklere bakabilir",
                ChatColor.GRAY + "ve onları pişirebilirsin.", "",
                ChatColor.GOLD + "Aşçılıkta Ustalığın: " + ChatColor.GREEN + cookLevel);
        itemHandler.createItem(inv3, "white_stained_glass_pane", 1, 6, " ");
        itemHandler.createItem(inv3, "white_stained_glass_pane", 1, 7, " ");
        itemHandler.createItem(inv3, "white_stained_glass_pane", 1, 8, " ");
        itemHandler.createItem(inv3, "barrel", 1, 9, ChatColor.GOLD + "Ocak Deposu",
                ChatColor.GRAY + "Buradan pişirdiğin malzemeleri alabilirsin.",
                ChatColor.GRAY + "Açmak için "+ ChatColor.YELLOW+""+ ChatColor.BOLD+"Sağ Tıkla.");
        itemHandler.createItem(inv3, "black_stained_glass_pane", 1, 10, " ");
        itemHandler.createItem(inv3, "black_stained_glass_pane", 1, 11, " ");
        itemHandler.createItem(inv3, "black_stained_glass_pane", 1, 12, " ");
        itemHandler.createItem(inv3, "black_stained_glass_pane", 1, 13, " ");
        itemHandler.createItem(inv3, "black_stained_glass_pane", 1, 14, " ");
        itemHandler.createItem(inv3, "black_stained_glass_pane", 1, 15, " ");
        itemHandler.createItem(inv3, "black_stained_glass_pane", 1, 16, " ");
        itemHandler.createItem(inv3, "black_stained_glass_pane", 1, 17, " ");
        itemHandler.createItem(inv3, "black_stained_glass_pane", 1, 18, " ");
        itemHandler.createItem(inv3, "bread", 1, 19, ChatColor.YELLOW + "Ekmek", ChatColor.GREEN + "Ustalık 1", "",
                ChatColor.GRAY + " Gerekli Malzemeler:", ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Buğday", "",
                ChatColor.GRAY + "Pişirmeye başlamak için ", ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv3, "baked_potato", 1, 20, ChatColor.YELLOW + "Pişmiş Patates", ChatColor.GREEN + "Ustalık 1",
                "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Patates",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Kömür", "",
                ChatColor.GRAY + "Pişirmeye başlamak için ", ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv3, "cooked_porkchop", 1, 21, ChatColor.YELLOW + "Domuz Pastırması",
                ChatColor.GREEN + "Ustalık 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 Çiğ Domuz Eti",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Kömür", "",
                ChatColor.GRAY + "Pişirmeye başlamak için ", ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv3, "cooked_cod", 1, 22, ChatColor.YELLOW + "Pişmiş Morina",
                ChatColor.GREEN + "Ustalık 2", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Çiğ Morina",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Kömür", "",
                ChatColor.GRAY + "Pişirmeye başlamak için ", ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv3, "cooked_salmon", 1, 23, ChatColor.YELLOW + "Pişmiş Somon",
                ChatColor.GREEN + "Ustalık 2", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Çiğ Somon",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Kömür", "",
                ChatColor.GRAY + "Pişirmeye başlamak için ", ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv3, "cooked_mutton", 1, 24 ,ChatColor.YELLOW + "Pişmiş Koyun Budu", ChatColor.GREEN + "Ustalık 2",
                "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 Çiğ Koyun Eti",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Kömür", "",
                ChatColor.GRAY + "Pişirmeye başlamak için ", ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv3, "cooked_beef", 1, 25, ChatColor.YELLOW + "Biftek", ChatColor.GREEN + "Ustalık 2",
                "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 Çiğ Kırmızı Et",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Kömür", "",
                ChatColor.GRAY + "Pişirmeye başlamak için ", ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        toReturn.setContents(inv3.getContents());
        return toReturn;
    }

    public Inventory t1Yemek(Player p) {
        int cookLevel = stats.getCookLevel(p.getUniqueId());
        Inventory toReturn = Bukkit.createInventory(null, inv_rows4, inventory_name4);

        itemHandler.createItem(inv4, "white_stained_glass_pane", 1, 1, " ");
        itemHandler.createItem(inv4, "white_stained_glass_pane", 1, 2, " ");
        itemHandler.createItem(inv4, "white_stained_glass_pane", 1, 3, " ");
        itemHandler.createItem(inv4, "white_stained_glass_pane", 1, 4, " ");
        itemHandler.createItem(inv4, "smoker", 1, 5, ChatColor.WHITE + "Ocak",
                ChatColor.GRAY + "Burada elindeki malzemelerle", ChatColor.GRAY + "yapabileceğin yemeklere bakabilir",
                ChatColor.GRAY + "ve onları pişirebilirsin.", "",
                ChatColor.GOLD + "Aşçılıkta Ustalığın: " + ChatColor.GREEN + cookLevel);
        itemHandler.createItem(inv4, "white_stained_glass_pane", 1, 6, " ");
        itemHandler.createItem(inv4, "white_stained_glass_pane", 1, 7, " ");
        itemHandler.createItem(inv4, "white_stained_glass_pane", 1, 8, " ");
        itemHandler.createItem(inv4, "white_stained_glass_pane", 1, 9, " ");
        itemHandler.createItem(inv4, "black_stained_glass_pane", 1, 10, " ");
        itemHandler.createItem(inv4, "black_stained_glass_pane", 1, 11, " ");
        itemHandler.createItem(inv4, "black_stained_glass_pane", 1, 12, " ");
        itemHandler.createItem(inv4, "black_stained_glass_pane", 1, 13, " ");
        itemHandler.createItem(inv4, "black_stained_glass_pane", 1, 14, " ");
        itemHandler.createItem(inv4, "black_stained_glass_pane", 1, 15, " ");
        itemHandler.createItem(inv4, "black_stained_glass_pane", 1, 16, " ");
        itemHandler.createItem(inv4, "black_stained_glass_pane", 1, 17, " ");
        itemHandler.createItem(inv4, "black_stained_glass_pane", 1, 18, " ");

        toReturn.setContents(inv4.getContents());
        return toReturn;
    }

    public Inventory bilgikitabı(Player p) {
        Inventory toReturn = Bukkit.createInventory(null, inv_rows4, inventory_name13);

        itemHandler.createItem(inv13, "white_stained_glass_pane", 1, 1, " ");
        itemHandler.createItem(inv13, "white_stained_glass_pane", 1, 2, " ");
        itemHandler.createItem(inv13, "white_stained_glass_pane", 1, 3, " ");
        itemHandler.createItem(inv13, "white_stained_glass_pane", 1, 4, " ");
        itemHandler.createItem(inv13, "knowledge_book", 1, 5, ChatColor.AQUA + "El Kitabın",
                ChatColor.GRAY + "Buradan aksesuar takıp çıkarabilir, bazı ayarları ",
                ChatColor.GRAY + "düzenleyebilir ve daha bir çok şeyi kontrol edebilirsin.");
        itemHandler.createItem(inv13, "white_stained_glass_pane", 1, 6, " ");
        itemHandler.createItem(inv13, "white_stained_glass_pane", 1, 7, " ");
        itemHandler.createItem(inv13, "white_stained_glass_pane", 1, 8, " ");
        itemHandler.createItem(inv13, "white_stained_glass_pane", 1, 9, " ");
        itemHandler.createItem(inv13, "black_stained_glass_pane", 1, 10, " ");
        itemHandler.createItem(inv13, "black_stained_glass_pane", 1, 11, " ");
        itemHandler.createItem(inv13, "black_stained_glass_pane", 1, 12, " ");
        itemHandler.createItem(inv13, "black_stained_glass_pane", 1, 13, " ");
        itemHandler.createItem(inv13, "black_stained_glass_pane", 1, 14, " ");
        itemHandler.createItem(inv13, "black_stained_glass_pane", 1, 15, " ");
        itemHandler.createItem(inv13, "black_stained_glass_pane", 1, 16, " ");
        itemHandler.createItem(inv13, "black_stained_glass_pane", 1, 17, " ");
        itemHandler.createItem(inv13, "black_stained_glass_pane", 1, 18, " ");
        itemHandler.createItem(inv13, "comparator", 1, 29, ChatColor.GRAY + "Ayarlar",
                ChatColor.WHITE + "Açmak için " + ChatColor.YELLOW + "Sağ Tıkla.");
        itemHandler.createItem(inv13, "experience_bottle", 1, 31, ChatColor.RED + "Niteliklerin",
                ChatColor.WHITE + "Buradan nitelik puanlarını harcayabilir ",
                ChatColor.WHITE + "ve gücüne güç katabilirsin!", "",
                Painter.paint("&7Sahip Olduğun Nitelik Puanı: &c") + stats.getNP(p.getUniqueId()), "",
                ChatColor.GRAY + "Açmak için " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv13, "crafting_table", 1, 32, ChatColor.YELLOW + "Çalışma Alanı",
                ChatColor.WHITE + "Buradan eşya üretebilirsin. ", "",
                ChatColor.GRAY + "Açmak için " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv13, "item_frame", 1, 33, ChatColor.GOLD + "Aksesuarların",
                ChatColor.WHITE + "Buradan aksesuarlarını ve ekipmanlarını", ChatColor.WHITE + "yönetebilirsin.", "",
                Painter.paint("&7Aksesuarlar kullanıcısına belirli"),
                Painter.paint("&7özellikler bahşeden ekipmanlardır."), "", Painter.paint("&fKullanılan Aksesuarlar:"),
                Painter.paint(" &dTılsım/Ok Kılıfı: &8") + stats.getTilsim(p.getUniqueId()),
                Painter.paint(" &9Eldiven: &8") + stats.getEldiven(p.getUniqueId()),
                Painter.paint(" &eKolye: &8") + stats.getKolye(p.getUniqueId()),
                Painter.paint(" &6Yüzük: &8") + stats.getYuzuk(p.getUniqueId()), "", ChatColor.GRAY
                        + "Aksesuarlarını çıkarmak için " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv13, "sunflower", 1, 35, ChatColor.YELLOW + "Rozetlerin",
                ChatColor.WHITE + "Buradan rozetlerini yönetebilirsin. ", "",
                ChatColor.GRAY + "Açmak için " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");

        toReturn.setContents(inv13.getContents());
        return toReturn;
    }

    public Inventory productCook(Player p) {
        Inventory toReturn = Bukkit.createInventory(null, inv_rows11, inventory_name11);

        itemHandler.createItem(inv11, "arrow", 1, 1, "&eGeri Dön.");
        itemHandler.createItem(inv11, "black_stained_glass_pane", 1, 2, " ");
        itemHandler.createItem(inv11, "black_stained_glass_pane", 1, 3, " ");
        itemHandler.createItem(inv11, "black_stained_glass_pane", 1, 4, " ");
        itemHandler.createItem(inv11, "black_stained_glass_pane", 1, 5, " ");
        itemHandler.createItem(inv11, "black_stained_glass_pane", 1, 6, " ");
        itemHandler.createItem(inv11, "black_stained_glass_pane", 1, 7, " ");
        itemHandler.createItem(inv11, "black_stained_glass_pane", 1, 8, " ");
        itemHandler.createItem(inv11, "black_stained_glass_pane", 1, 9, " ");
        itemHandler.createItem(inv11, "black_stained_glass_pane", 1, 10, " ");
        itemHandler.createItem(inv11, "black_stained_glass_pane", 1, 11, " ");
        itemHandler.createItem(inv11, "black_stained_glass_pane", 1, 12, " ");
        itemHandler.createItem(inv11, "black_stained_glass_pane", 1, 13, " ");
        itemHandler.createItem(inv11, "black_stained_glass_pane", 1, 15, " ");
        itemHandler.createItem(inv11, "black_stained_glass_pane", 1, 16, " ");
        itemHandler.createItem(inv11, "black_stained_glass_pane", 1, 17, " ");
        itemHandler.createItem(inv11, "black_stained_glass_pane", 1, 18, " ");
        itemHandler.createItem(inv11, "black_stained_glass_pane", 1, 19, " ");
        itemHandler.createItem(inv11, "black_stained_glass_pane", 1, 20, " ");
        itemHandler.createItem(inv11, "black_stained_glass_pane", 1, 21, " ");
        itemHandler.createItem(inv11, "black_stained_glass_pane", 1, 22, " ");
        itemHandler.createItem(inv11, "black_stained_glass_pane", 1, 23, " ");
        itemHandler.createItem(inv11, "black_stained_glass_pane", 1, 24, " ");
        itemHandler.createItem(inv11, "black_stained_glass_pane", 1, 25, " ");
        itemHandler.createItem(inv11, "black_stained_glass_pane", 1, 26, " ");
        itemHandler.createItem(inv11, "black_stained_glass_pane", 1, 27, " ");
        toReturn.setContents(inv11.getContents());
        return toReturn;
    }

    public Inventory leatherSmith(Player p, String Maden, String invisim, int zirhmodel) {
        int smithLevel = stats.getSmithLevel(p.getUniqueId());
        Inventory toReturn = Bukkit.createInventory(null, inv_rows5, invisim);

        itemHandler.createItem(inv19, "white_stained_glass_pane", 1, 1, " ");
        itemHandler.createItem(inv19, "white_stained_glass_pane", 1, 2, " ");
        itemHandler.createItem(inv19, "white_stained_glass_pane", 1, 3, " ");
        itemHandler.createItem(inv19, "white_stained_glass_pane", 1, 4, " ");
        itemHandler.createItem(inv19, "fletching_table", 1, 5, ChatColor.WHITE + "El Sanatları Masası",
                ChatColor.GRAY + "Burada elindeki malzemelerle", ChatColor.GRAY + "yapabileceğin ekipmanlara bakabilir",
                ChatColor.GRAY + "ve onları yapabilirsin.", "",
                ChatColor.GOLD + "El Sanatlarındaki Ustalığın: " + ChatColor.GREEN + smithLevel);
        itemHandler.createItem(inv19, "white_stained_glass_pane", 1, 6, " ");
        itemHandler.createItem(inv19, "white_stained_glass_pane", 1, 7, " ");
        itemHandler.createItem(inv19, "white_stained_glass_pane", 1, 8, " ");
        itemHandler.createItem(inv19, "white_stained_glass_pane", 1, 9, " ");
        itemHandler.createItem(inv19, "black_stained_glass_pane", 1, 10, " ");
        itemHandler.createItem(inv19, "black_stained_glass_pane", 1, 11, " ");
        itemHandler.createItem(inv19, "black_stained_glass_pane", 1, 12, " ");
        itemHandler.createItem(inv19, "black_stained_glass_pane", 1, 13, " ");
        itemHandler.createItem(inv19, "black_stained_glass_pane", 1, 14, " ");
        itemHandler.createItem(inv19, "black_stained_glass_pane", 1, 15, " ");
        itemHandler.createItem(inv19, "black_stained_glass_pane", 1, 16, " ");
        itemHandler.createItem(inv19, "black_stained_glass_pane", 1, 17, " ");
        itemHandler.createItem(inv19, "black_stained_glass_pane", 1, 18, " ");
        itemHandler.createItem(inv19, "leather_helmet", 1, 19, ChatColor.YELLOW + Maden + " Derisinden Kapüşon",
                ChatColor.GREEN + "Ustalık 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 İp",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 5 " + Maden + " Postu",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 5 Seviye", "", ChatColor.GRAY + "İşlemeye başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv19, "leather_chestplate", 1, 20, ChatColor.YELLOW + Maden + " Derisinden Göğüslük",
                ChatColor.GREEN + "Ustalık 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 8 " + Maden + " Postu",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 5 Seviye", "", ChatColor.GRAY + "İşlemeye başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv19, "leather_leggings", 1, 21, ChatColor.YELLOW + Maden + " Derisinden Pantolon",
                ChatColor.GREEN + "Ustalık 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 7 " + Maden + " Postu",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 5 Seviye", "", ChatColor.GRAY + "İşlemeye başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem2(inv19, "leather_boots", 1, 22, ChatColor.YELLOW + Maden + " Derisinden Çizmeler",
                zirhmodel, ChatColor.GREEN + "Ustalık 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 " + Maden + " Postu",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 5 Seviye", "", ChatColor.GRAY + "İşlemeye başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem2(inv19, "bundle", 1, 23, ChatColor.YELLOW + Maden + " Derisinden Ok Kılıfı",
                zirhmodel, ChatColor.GREEN + "Ustalık 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 5 " + Maden + " Postu",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 5 İp",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 6 Seviye", "", ChatColor.GRAY + "İşlemeye başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem2(inv19, "leather", 1, 24, ChatColor.YELLOW + Maden + " Derisinden Çanta",
                zirhmodel, ChatColor.GREEN + "Ustalık 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 " + Maden + " Postu",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "İşlemeye başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        toReturn.setContents(inv19.getContents());
        return toReturn;
    }

    public Inventory Furnace(Player p) {
        Inventory toReturn = Bukkit.createInventory(null, inv_rows8, inventory_name21);

        itemHandler.createItem(inv22, "white_stained_glass_pane", 1, 1, " ");
        itemHandler.createItem(inv22, "white_stained_glass_pane", 1, 2, " ");
        itemHandler.createItem(inv22, "white_stained_glass_pane", 1, 3, " ");
        itemHandler.createItem(inv22, "white_stained_glass_pane", 1, 4, " ");
        itemHandler.createItem(inv22, "blast_furnace", 1, 5, ChatColor.WHITE + "Yüksek Fırın",
                ChatColor.GRAY + "Burada elindeki malzemeleri eritip",
                ChatColor.GRAY + "onları işlenmeye hazır hale getirebilirsin.");
        itemHandler.createItem(inv22, "white_stained_glass_pane", 1, 6, " ");
        itemHandler.createItem(inv22, "white_stained_glass_pane", 1, 7, " ");
        itemHandler.createItem(inv22, "white_stained_glass_pane", 1, 8, " ");
        itemHandler.createItem(inv22, "chest", 1, 9, Painter.paint("&6Fırın Deposu"),
                Painter.paint("&7Buradan erittiğin malzemeleri alabilirsin."),
                Painter.paint("&7Açmak için &e&lSağ Tıkla."));
        itemHandler.createItem(inv22, "black_stained_glass_pane", 1, 10, " ");
        itemHandler.createItem(inv22, "black_stained_glass_pane", 1, 11, " ");
        itemHandler.createItem(inv22, "black_stained_glass_pane", 1, 12, " ");
        itemHandler.createItem(inv22, "black_stained_glass_pane", 1, 13, " ");
        itemHandler.createItem(inv22, "black_stained_glass_pane", 1, 14, " ");
        itemHandler.createItem(inv22, "black_stained_glass_pane", 1, 15, " ");
        itemHandler.createItem(inv22, "black_stained_glass_pane", 1, 16, " ");
        itemHandler.createItem(inv22, "black_stained_glass_pane", 1, 17, " ");
        itemHandler.createItem(inv22, "black_stained_glass_pane", 1, 18, " ");
        itemHandler.createItem(inv22, "copper_ingot", 1, 19, ChatColor.GOLD + "Bakır Külçesi",
                "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Bakır Cevheri",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 Kömür", "", ChatColor.GRAY + "Eritmeye başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv22, "copper_ingot", 1, 20, ChatColor.WHITE + "Nikel Külçesi",
                "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Nikel Cevheri",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 Kömür", "", ChatColor.GRAY + "Eritmeye başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv22, "copper_ingot", 1, 21, ChatColor.GOLD + "Bronz Külçesi",
                "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Bakır Cevheri",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Nikel Cevheri",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 Kömür", "", ChatColor.GRAY + "Eritmeye başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv22, "iron_ingot", 1, 22, ChatColor.GRAY + "Demir Külçesi",
                "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Demir Cevheri",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Kömür", "", ChatColor.GRAY + "Eritmeye başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv22, "gold_ingot", 1, 23, ChatColor.YELLOW + "Altın Külçesi",
                "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Altın Cevheri",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Kömür", "", ChatColor.GRAY + "Eritmeye başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv22, "copper_ingot", 1, 24, ChatColor.DARK_PURPLE + "Obsidyen Külçesi",
                "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Obsidyen Cevheri",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 Nikel Cevheri",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 Kömür", "", ChatColor.GRAY + "Eritmeye başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv22, "iron_ingot", 1, 25, ChatColor.AQUA + "Adamantium Külçesi",
                "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Adamantium Cevheri",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 Kömür", "", ChatColor.GRAY + "Eritmeye başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv22, "netherite_ingot", 1, 26, ChatColor.DARK_GRAY + "Netherit Külçesi",
                "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 Demir Cevheri",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 Netherit Cevheri",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 Kömür", "", ChatColor.GRAY + "Eritmeye başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv22, "copper_ingot", 1, 27, ChatColor.RED + "Kızıl Metal Külçesi",
                "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 Kızıl Metal Cevheri",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Netherit Cevheri",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Lav Kovası", "", ChatColor.GRAY + "Eritmeye başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv22, "iron_ingot", 1, 28, ChatColor.DARK_AQUA + "Mitril Külçesi",
                "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Mitril Cevheri",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Lav Kovası", "", ChatColor.GRAY + "Eritmeye başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv22, "gold_ingot", 1, 29, ChatColor.DARK_PURPLE + "Hiçlik Külçesi",
                "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Hiçlik Taşı",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 Kızıl Metal Cevheri",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Lav Kovası", "", ChatColor.GRAY + "Eritmeye başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv22, "iron_ingot", 1, 30, ChatColor.RED + "Rodonit Külçesi",
                "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Rodonit Cevheri",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 Obsidyen Cevheri",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Lav Kovası", "", ChatColor.GRAY + "Eritmeye başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv22, "iron_ingot", 1, 31, ChatColor.AQUA + "Spektral Külçesi",
                "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 Rodonit Cevheri",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 Obsidyen Cevheri",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Mitril Cevheri",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Ektoplazma",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Lav Kovası", "", ChatColor.GRAY + "Eritmeye başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        toReturn.setContents(inv22.getContents());
        return toReturn;
}

    public Inventory resourceSmith(Player p, String Maden, String invisim, int zirhmodel,String cubuk) {
        int smithLevel = stats.getSmithLevel(p.getUniqueId());
        Inventory toReturn = Bukkit.createInventory(null, inv_rows5, invisim);

        itemHandler.createItem(inv21, "white_stained_glass_pane", 1, 1, " ");
        itemHandler.createItem(inv21, "white_stained_glass_pane", 1, 2, " ");
        itemHandler.createItem(inv21, "white_stained_glass_pane", 1, 3, " ");
        itemHandler.createItem(inv21, "white_stained_glass_pane", 1, 4, " ");
        itemHandler.createItem(inv21, "smithing_table", 1, 5, ChatColor.WHITE + "Demirci Masası",
                ChatColor.GRAY + "Burada elindeki malzemelerle", ChatColor.GRAY + "yapabileceğin ekipmanlara bakabilir",
                ChatColor.GRAY + "ve onları işleyebilirsin.", "",
                ChatColor.GOLD + "Demircilikteki Ustalığın: " + ChatColor.GREEN + smithLevel);
        itemHandler.createItem(inv21, "white_stained_glass_pane", 1, 6, " ");
        itemHandler.createItem(inv21, "white_stained_glass_pane", 1, 7, " ");
        itemHandler.createItem(inv21, "white_stained_glass_pane", 1, 8, " ");
        itemHandler.createItem(inv21, "white_stained_glass_pane", 1, 9, " ");
        itemHandler.createItem(inv21, "black_stained_glass_pane", 1, 10, " ");
        itemHandler.createItem(inv21, "black_stained_glass_pane", 1, 11, " ");
        itemHandler.createItem(inv21, "black_stained_glass_pane", 1, 12, " ");
        itemHandler.createItem(inv21, "black_stained_glass_pane", 1, 13, " ");
        itemHandler.createItem(inv21, "black_stained_glass_pane", 1, 14, " ");
        itemHandler.createItem(inv21, "black_stained_glass_pane", 1, 15, " ");
        itemHandler.createItem(inv21, "black_stained_glass_pane", 1, 16, " ");
        itemHandler.createItem(inv21, "black_stained_glass_pane", 1, 17, " ");
        itemHandler.createItem(inv21, "black_stained_glass_pane", 1, 18, " ");
        itemHandler.createItem(inv21, "wooden_sword", 1, 19, ChatColor.YELLOW + Maden + " Kılıç",
                ChatColor.GREEN + "Ustalık 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 "+cubuk+" Çubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 " + Maden + " Külçesi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "İşlemeye başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv21, "diamond_sword", 1, 20, ChatColor.YELLOW + "Ağır " + Maden + " Kılıç",
                ChatColor.GREEN + "Ustalık 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 "+cubuk+" Çubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 5 " + Maden + " Külçesi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "İşlemeye başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv21, "golden_axe", 1, 21, ChatColor.YELLOW + Maden + " Balta",
                ChatColor.GREEN + "Ustalık 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 "+cubuk+" Çubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 " + Maden + " Külçesi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "İşlemeye başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem2(inv21, "leather_chestplate", 1, 22, ChatColor.YELLOW + Maden + " Göğüslük",
                zirhmodel, ChatColor.GREEN + "Ustalık 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 8 " + Maden + " Külçesi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "İşlemeye başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem2(inv21, "leather_leggings", 1, 23, ChatColor.YELLOW + Maden + " Pantolon",
                zirhmodel, ChatColor.GREEN + "Ustalık 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 8 " + Maden + " Külçesi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "İşlemeye başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem2(inv21, "leather_helmet", 1, 24, ChatColor.YELLOW + Maden + " Miğfer",
                zirhmodel, ChatColor.GREEN + "Ustalık 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 5 " + Maden + " Külçesi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "İşlemeye başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem2(inv21, "leather_boots", 1, 25, ChatColor.YELLOW + Maden + " Botlar",
                zirhmodel, ChatColor.GREEN + "Ustalık 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 " + Maden + " Külçesi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "İşlemeye başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv21, "golden_shovel", 1, 26, ChatColor.YELLOW + Maden + " Kürek",
                ChatColor.GREEN + "Ustalık 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 "+cubuk+" Çubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 " + Maden + " Külçesi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "İşlemeye başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv21, "golden_pickaxe", 1, 27, ChatColor.YELLOW + Maden + " Kazma",
                ChatColor.GREEN + "Ustalık 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 "+cubuk+" Çubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 " + Maden + " Külçesi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "İşlemeye başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv21, "shears", 1, 28, ChatColor.YELLOW + Maden + " Hançer", ChatColor.GREEN + "Ustalık 1",
                "", ChatColor.GRAY + " Gerekli Malzemeler:", ChatColor.GRAY + " -" + ChatColor.WHITE + " 1"+cubuk+" Çubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 " + Maden + " Külçesi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "İşlemeye başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv21, "iron_hoe", 1, 29, ChatColor.YELLOW + Maden + " Tırpan",
                ChatColor.GREEN + "Ustalık 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 "+cubuk+" Çubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 " + Maden + " Külçesi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "İşlemeye başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv21, "golden_hoe", 1, 30, ChatColor.YELLOW + Maden + " Çapa",
                ChatColor.GREEN + "Ustalık 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 "+cubuk +" Çubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 " + Maden + " Külçesi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "İşlemeye başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv21, "stick", 1, 31, ChatColor.YELLOW + Maden + " Mızrak", ChatColor.GREEN + "Ustalık 1",
                "", ChatColor.GRAY + " Gerekli Malzemeler:", ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 "+cubuk+" Çubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 " + Maden + " Külçesi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "İşlemeye başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv21, "wooden_shovel", 1, 32, ChatColor.YELLOW + Maden + " Topuz", ChatColor.GREEN + "Ustalık 1",
                "", ChatColor.GRAY + " Gerekli Malzemeler:", ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 "+cubuk+" Çubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 " + Maden + " Külçesi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "İşlemeye başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem2(inv21, "shield", 1, 32, ChatColor.YELLOW + Maden +" Kalkan", zirhmodel,ChatColor.GREEN + "Ustalık 1",
                "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 "+cubuk+" Tahtası",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 6 "+Maden+ " Külçesi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "İşlemeye başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv21, "wooden_axe", 1, 33, ChatColor.YELLOW + Maden +" Savaş Baltası",ChatColor.GREEN + "Ustalık 1",
                "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 "+cubuk +" Çubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 6 "+Maden+ " Külçesi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "İşlemeye başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        toReturn.setContents(inv21.getContents());
        return toReturn;
    }

    public Inventory Bow(Player p) {
        int smithLevel = stats.getSmithLevel(p.getUniqueId());
        Inventory toReturn = Bukkit.createInventory(null, inv_rows8, inventory_name18);

        itemHandler.createItem(inv18, "white_stained_glass_pane", 1, 1, " ");
        itemHandler.createItem(inv18, "white_stained_glass_pane", 1, 2, " ");
        itemHandler.createItem(inv18, "white_stained_glass_pane", 1, 3, " ");
        itemHandler.createItem(inv18, "white_stained_glass_pane", 1, 4, " ");
        itemHandler.createItem(inv18, "fletching_table", 1, 5, ChatColor.WHITE + "El Sanatları Masası",
                ChatColor.GRAY + "Burada elindeki malzemelerle", ChatColor.GRAY + "yapabileceğin ekipmanlara bakabilir",
                ChatColor.GRAY + "ve onları yapabilirsin.", "",
                ChatColor.GOLD + "El Sanatlarındaki Ustalığın: " + ChatColor.GREEN + smithLevel);
        itemHandler.createItem(inv18, "white_stained_glass_pane", 1, 6, " ");
        itemHandler.createItem(inv18, "white_stained_glass_pane", 1, 7, " ");
        itemHandler.createItem(inv18, "white_stained_glass_pane", 1, 8, " ");
        itemHandler.createItem(inv18, "chest", 1, 9, Painter.paint("&6El Sanatları Deposu"),
                Painter.paint("&7Buradan yaptığın ekipmanları alabilirsin."),
                Painter.paint("&7Açmak için &e&lSağ Tıkla."));
        itemHandler.createItem(inv18, "black_stained_glass_pane", 1, 10, " ");
        itemHandler.createItem(inv18, "black_stained_glass_pane", 1, 11, " ");
        itemHandler.createItem(inv18, "black_stained_glass_pane", 1, 12, " ");
        itemHandler.createItem(inv18, "black_stained_glass_pane", 1, 13, " ");
        itemHandler.createItem(inv18, "black_stained_glass_pane", 1, 14, " ");
        itemHandler.createItem(inv18, "black_stained_glass_pane", 1, 15, " ");
        itemHandler.createItem(inv18, "black_stained_glass_pane", 1, 16, " ");
        itemHandler.createItem(inv18, "black_stained_glass_pane", 1, 17, " ");
        itemHandler.createItem(inv18, "black_stained_glass_pane", 1, 18, " ");
        itemHandler.createItem2(inv18, "bow", 1, 19, ChatColor.YELLOW + "Meşe Yay",
                8, ChatColor.GREEN + "Ustalık 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 Meşe Çubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 İp",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 Seviye", "", ChatColor.GRAY + "Yapmaya başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem2(inv18, "bow", 1, 20, ChatColor.YELLOW + "Huş Yay",
                3, ChatColor.GREEN + "Ustalık 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 Meşe Çubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 İp",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 Seviye", "", ChatColor.GRAY + "Yapmaya başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem2(inv18, "bow", 1, 21, ChatColor.YELLOW + "Yaşlı Meşe Yay",
                2, ChatColor.GREEN + "Ustalık 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 Yaşlı Meşe Çubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 İp",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 Seviye", "", ChatColor.GRAY + "Yapmaya başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv18, "bow", 1, 22, ChatColor.YELLOW + "Karma Yay",
                ChatColor.GREEN + "Ustalık 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 Meşe Çubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 6 İp ",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Seviye", "", ChatColor.GRAY + "Yapmaya başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv18, "crossbow", 1, 23, ChatColor.YELLOW + "Meşe Arbalet",
                ChatColor.GREEN + "Ustalık 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 5 Meşe Çubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 Kanca",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 İp",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 Seviye", "", ChatColor.GRAY + "Yapmaya başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv18, "bow", 1, 24, ChatColor.YELLOW + "Çift Pençe",
                ChatColor.GREEN + "Ustalık 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 Meşe Çubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 Yaşı Meşe Çubuğu",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 İp",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 5 Seviye", "", ChatColor.GRAY + "Yapmaya başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem2(inv18, "bow", 1, 25, ChatColor.YELLOW + "Ladin Yay",
                4, ChatColor.GREEN + "Ustalık 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 Ladin Çubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 İp",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 6 Seviye", "", ChatColor.GRAY + "Yapmaya başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv18, "crossbow", 1, 26, ChatColor.YELLOW + "Gelişmiş Arbalet",
                ChatColor.GREEN + "Ustalık 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 Ladin Çubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Kanca",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 İp",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 6 Nikel",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "Yapmaya başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv18, "bow", 1, 27, ChatColor.YELLOW + "Demir Kaplamalı Yay",
                ChatColor.GREEN + "Ustalık 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 Meşe Çubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 İp",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 6 Demir",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "Yapmaya başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem2(inv18, "bow", 1, 28, ChatColor.YELLOW + "Kara Meşe Yay",
                7, ChatColor.GREEN + "Ustalık 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 6 Kara Meşe Çubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 İp",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 Kara Meşe Tahtası",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "Yapmaya başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv18, "bow", 1, 29, ChatColor.YELLOW + "Tayfun", ChatColor.GREEN + "Ustalık 1",
                "", ChatColor.GRAY + " Gerekli Malzemeler:", ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Çubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 6 Ağır Çubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Dalgakıran Balığı",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 İp",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 Bizon Derisi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 14 Seviye", "", ChatColor.GRAY + "Yapmaya başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem2(inv18, "bow", 1, 30, ChatColor.YELLOW + "Akasya Yay",
                6, ChatColor.GREEN + "Ustalık 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 6 Akasya Çubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 İp ",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 5 Nikel ",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 15 Seviye", "", ChatColor.GRAY + "Yapmaya başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv18, "bow", 1, 31, ChatColor.YELLOW + "Yakaryay",
                ChatColor.GREEN + "Ustalık 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 7 Körükalev Çubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 6 Yanmaz İp",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Alevböceği",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 15 Seviye", "", ChatColor.GRAY + "Yapmaya başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv18, "bow", 1, 32, ChatColor.YELLOW + "Minoris", ChatColor.GREEN + "Ustalık 1",
                "", ChatColor.GRAY + " Gerekli Malzemeler:", ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Çubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 6 Ağır Çubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 Alev Özütü",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Bronz Külçesi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 12 Tuzlu İp",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 17 Seviye", "", ChatColor.GRAY + "Yapmaya başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv18, "crossbow", 1, 33, ChatColor.YELLOW + "Gölge Avcısı Arbaleti", ChatColor.GREEN + "Ustalık 1",
                "", ChatColor.GRAY + " Gerekli Malzemeler:", ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Çubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 8 Ağır Çubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Lanetli İp",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Kanca",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 7 Gümüş Külçesi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 20 Seviye", "", ChatColor.GRAY + "Yapmaya başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv18, "crossbow", 1, 34, ChatColor.YELLOW + "Ay Parçası Arbaleti", ChatColor.GREEN + "Ustalık 1",
                "", ChatColor.GRAY + " Gerekli Malzemeler:", ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Çubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 5 İlah Söğüt Çubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 15 Tuzlu İp",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 Rün Esansı",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 5 Göktaşı",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 24 Seviye", "", ChatColor.GRAY + "Yapmaya başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem2(inv18, "bow", 1, 35, ChatColor.YELLOW + "Gerilla Yayı", 5, ChatColor.GREEN + "Ustalık 1",
                "", ChatColor.GRAY + " Gerekli Malzemeler:", ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Çubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 12 Ağır Çubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 6 İp",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 7 Yıldırım Özütü",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 32 Seviye", "", ChatColor.GRAY + "Yapmaya başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem2(inv18, "bow", 1, 36, ChatColor.YELLOW + "İlah Söğüt Yayı", 5, ChatColor.GREEN + "Ustalık 1",
                "", ChatColor.GRAY + " Gerekli Malzemeler:", ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Çubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 11 İlah Söğüt Çubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 5 Lanetli İp",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Yıldırım Özütü",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Alev Özütü",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 12 Topaz",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 32 Seviye", "", ChatColor.GRAY + "Yapmaya başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem2(inv18, "bow", 1, 37, ChatColor.YELLOW + "Mutlak Güç Yayı", 10, ChatColor.GREEN + "Ustalık 1",
                "", ChatColor.GRAY + " Gerekli Malzemeler:", ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Çubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 12 İlah Söğüt Çubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 12 Ağır Çubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 5 Lanetli İp",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 5 Tuzlu İp",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Yıldırım Özütü",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 Alev Özütü",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 Gerçek Buz Özütü",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 12 Yeşim Taşı",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 Gümüş",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 36 Seviye", "", ChatColor.GRAY + "Yapmaya başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        toReturn.setContents(inv18.getContents());
        return toReturn;
    }

    public Inventory t1Ekipman(Player p) {
        int smithLevel = stats.getSmithLevel(p.getUniqueId());
        Inventory toReturn = Bukkit.createInventory(null, inv_rows5, inventory_name5);

        itemHandler.createItem(inv5, "white_stained_glass_pane", 1, 1, " ");
        itemHandler.createItem(inv5, "white_stained_glass_pane", 1, 2, " ");
        itemHandler.createItem(inv5, "white_stained_glass_pane", 1, 3, " ");
        itemHandler.createItem(inv5, "white_stained_glass_pane", 1, 4, " ");
        itemHandler.createItem(inv5, "smithing_table", 1, 5, ChatColor.WHITE + "Demirci Masası",
                ChatColor.GRAY + "Burada elindeki malzemelerle", ChatColor.GRAY + "yapabileceğin ekipmanlara bakabilir",
                ChatColor.GRAY + "ve onları işleyebilirsin.", "",
                ChatColor.GOLD + "Demircilikteki Ustalığın: " + ChatColor.GREEN + smithLevel);
        itemHandler.createItem(inv5, "white_stained_glass_pane", 1, 6, " ");
        itemHandler.createItem(inv5, "white_stained_glass_pane", 1, 7, " ");
        itemHandler.createItem(inv5, "white_stained_glass_pane", 1, 8, " ");
        itemHandler.createItem(inv5, "white_stained_glass_pane", 1, 9, " ");
        itemHandler.createItem(inv5, "black_stained_glass_pane", 1, 10, " ");
        itemHandler.createItem(inv5, "black_stained_glass_pane", 1, 11, " ");
        itemHandler.createItem(inv5, "black_stained_glass_pane", 1, 12, " ");
        itemHandler.createItem(inv5, "black_stained_glass_pane", 1, 13, " ");
        itemHandler.createItem(inv5, "black_stained_glass_pane", 1, 14, " ");
        itemHandler.createItem(inv5, "black_stained_glass_pane", 1, 15, " ");
        itemHandler.createItem(inv5, "black_stained_glass_pane", 1, 16, " ");
        itemHandler.createItem(inv5, "black_stained_glass_pane", 1, 17, " ");
        itemHandler.createItem(inv5, "black_stained_glass_pane", 1, 18, " ");
        itemHandler.createItem(inv5, "wooden_sword", 1, 19, ChatColor.YELLOW + "Bakır Kılıç",
                ChatColor.GREEN + "Ustalık 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Çubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Bakır Külçesi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "İşlemeye başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv5, "diamond_sword", 1, 20, ChatColor.YELLOW + "Ağır Bakır Kılıç",
                ChatColor.GREEN + "Ustalık 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Çubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Bakır Külçesi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "İşlemeye başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv5, "golden_axe", 1, 21, ChatColor.YELLOW + "Bakır Balta",
                ChatColor.GREEN + "Ustalık 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Çubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Bakır Külçesi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "İşlemeye başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem2(inv5, "leather_chestplate", 1, 22, ChatColor.YELLOW + "Bakır Göğüslük",
                8, ChatColor.GREEN + "Ustalık 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 8 Bakır Külçesi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "İşlemeye başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem2(inv5, "leather_leggings", 1, 23, ChatColor.YELLOW + "Bakır Pantolon",
                8, ChatColor.GREEN + "Ustalık 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 8 Bakır Külçesi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "İşlemeye başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem2(inv5, "leather_helmet", 1, 24, ChatColor.YELLOW + "Bakır Miğfer",
                8, ChatColor.GREEN + "Ustalık 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 5 Bakır Külçesi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "İşlemeye başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem2(inv5, "leather_boots", 1, 25, ChatColor.YELLOW + "Bakır Botlar",
                8, ChatColor.GREEN + "Ustalık 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 Bakır Külçesi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "İşlemeye başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv5, "golden_shovel", 1, 26, ChatColor.YELLOW + "Bakır Kürek",
                ChatColor.GREEN + "Ustalık 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Çubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Bakır Külçesi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "İşlemeye başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv5, "wooden_pickaxe", 1, 27, ChatColor.YELLOW + "Bakır Kazma",
                ChatColor.GREEN + "Ustalık 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Çubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Bakır Külçesi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "İşlemeye başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv5, "shears", 1, 28, ChatColor.YELLOW + "Bakır Hançer", ChatColor.GREEN + "Ustalık 1",
                "", ChatColor.GRAY + " Gerekli Malzemeler:", ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Çubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Bakır Külçesi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "İşlemeye başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv5, "wooden_hoe", 1, 29, ChatColor.YELLOW + "Bakır Tırpan",
                ChatColor.GREEN + "Ustalık 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Çubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Bakır Külçesi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "İşlemeye başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv5, "golden_hoe", 1, 30, ChatColor.YELLOW + "Bakır Çapa",
                ChatColor.GREEN + "Ustalık 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Çubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Bakır Külçesi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "İşlemeye başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv5, "stick", 1, 31, ChatColor.YELLOW + "Bakır Mızrak", ChatColor.GREEN + "Ustalık 1",
                "", ChatColor.GRAY + " Gerekli Malzemeler:", ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Çubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Bakır Külçesi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "İşlemeye başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        itemHandler.createItem(inv5, "wooden_shovel", 1, 32, ChatColor.YELLOW + "Bakır Topuz", ChatColor.GREEN + "Ustalık 1",
                "", ChatColor.GRAY + " Gerekli Malzemeler:", ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Çubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Bakır Külçesi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "İşlemeye başlamak için ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
        toReturn.setContents(inv5.getContents());
        return toReturn;
    }
    public Inventory elsanatproduct(Player p) {
        Inventory toReturn = Bukkit.createInventory(null, inv_rows11, "El Sanatları Masası -> Üretimler");

        itemHandler.createItem(inv23, "arrow", 1, 1, "&eGeri Dön.");
        itemHandler.createItem(inv23, "black_stained_glass_pane", 1, 2, " ");
        itemHandler.createItem(inv23, "black_stained_glass_pane", 1, 3, " ");
        itemHandler.createItem(inv23, "black_stained_glass_pane", 1, 4, " ");
        itemHandler.createItem(inv23, "black_stained_glass_pane", 1, 5, " ");
        itemHandler.createItem(inv23, "black_stained_glass_pane", 1, 6, " ");
        itemHandler.createItem(inv23, "black_stained_glass_pane", 1, 7, " ");
        itemHandler.createItem(inv23, "black_stained_glass_pane", 1, 8, " ");
        itemHandler.createItem(inv23, "black_stained_glass_pane", 1, 9, " ");
        itemHandler.createItem(inv23, "black_stained_glass_pane", 1, 10, " ");
        itemHandler.createItem(inv23, "black_stained_glass_pane", 1, 11, " ");
        itemHandler.createItem(inv23, "black_stained_glass_pane", 1, 12, " ");
        itemHandler.createItem(inv23, "black_stained_glass_pane", 1, 13, " ");
        itemHandler.createItem(inv23, "black_stained_glass_pane", 1, 15, " ");
        itemHandler.createItem(inv23, "black_stained_glass_pane", 1, 16, " ");
        itemHandler.createItem(inv23, "black_stained_glass_pane", 1, 17, " ");
        itemHandler.createItem(inv23, "black_stained_glass_pane", 1, 18, " ");
        itemHandler.createItem(inv23, "black_stained_glass_pane", 1, 19, " ");
        itemHandler.createItem(inv23, "black_stained_glass_pane", 1, 20, " ");
        itemHandler.createItem(inv23, "black_stained_glass_pane", 1, 21, " ");
        itemHandler.createItem(inv23, "black_stained_glass_pane", 1, 22, " ");
        itemHandler.createItem(inv23, "black_stained_glass_pane", 1, 23, " ");
        itemHandler.createItem(inv23, "black_stained_glass_pane", 1, 24, " ");
        itemHandler.createItem(inv23, "black_stained_glass_pane", 1, 25, " ");
        itemHandler.createItem(inv23, "black_stained_glass_pane", 1, 26, " ");
        itemHandler.createItem(inv23, "black_stained_glass_pane", 1, 27, " ");
        toReturn.setContents(inv23.getContents());
        return toReturn;
    }
    public Inventory furnaceproduct(Player p) {
        Inventory toReturn = Bukkit.createInventory(null, inv_rows11, "Fırın -> Üretimler");

        itemHandler.createItem(inv8, "arrow", 1, 1, "&eGeri Dön.");
        itemHandler.createItem(inv8, "black_stained_glass_pane", 1, 2, " ");
        itemHandler.createItem(inv8, "black_stained_glass_pane", 1, 3, " ");
        itemHandler.createItem(inv8, "black_stained_glass_pane", 1, 4, " ");
        itemHandler.createItem(inv8, "black_stained_glass_pane", 1, 5, " ");
        itemHandler.createItem(inv8, "black_stained_glass_pane", 1, 6, " ");
        itemHandler.createItem(inv8, "black_stained_glass_pane", 1, 7, " ");
        itemHandler.createItem(inv8, "black_stained_glass_pane", 1, 8, " ");
        itemHandler.createItem(inv8, "black_stained_glass_pane", 1, 9, " ");
        itemHandler.createItem(inv8, "black_stained_glass_pane", 1, 10, " ");
        itemHandler.createItem(inv8, "black_stained_glass_pane", 1, 11, " ");
        itemHandler.createItem(inv8, "black_stained_glass_pane", 1, 12, " ");
        itemHandler.createItem(inv8, "black_stained_glass_pane", 1, 13, " ");
        itemHandler.createItem(inv8, "black_stained_glass_pane", 1, 15, " ");
        itemHandler.createItem(inv8, "black_stained_glass_pane", 1, 16, " ");
        itemHandler.createItem(inv8, "black_stained_glass_pane", 1, 17, " ");
        itemHandler.createItem(inv8, "black_stained_glass_pane", 1, 18, " ");
        itemHandler.createItem(inv8, "black_stained_glass_pane", 1, 19, " ");
        itemHandler.createItem(inv8, "black_stained_glass_pane", 1, 20, " ");
        itemHandler.createItem(inv8, "black_stained_glass_pane", 1, 21, " ");
        itemHandler.createItem(inv8, "black_stained_glass_pane", 1, 22, " ");
        itemHandler.createItem(inv8, "black_stained_glass_pane", 1, 23, " ");
        itemHandler.createItem(inv8, "black_stained_glass_pane", 1, 24, " ");
        itemHandler.createItem(inv8, "black_stained_glass_pane", 1, 25, " ");
        itemHandler.createItem(inv8, "black_stained_glass_pane", 1, 26, " ");
        itemHandler.createItem(inv8, "black_stained_glass_pane", 1, 27, " ");
        toReturn.setContents(inv8.getContents());
        return toReturn;
    }

    public Inventory product(Player p) {
        Inventory toReturn = Bukkit.createInventory(null, inv_rows6, inventory_name6);

        itemHandler.createItem(inv6, "arrow", 1, 1, "&eGeri Dön.");
        itemHandler.createItem(inv6, "black_stained_glass_pane", 1, 2, " ");
        itemHandler.createItem(inv6, "black_stained_glass_pane", 1, 3, " ");
        itemHandler.createItem(inv6, "black_stained_glass_pane", 1, 4, " ");
        itemHandler.createItem(inv6, "black_stained_glass_pane", 1, 5, " ");
        itemHandler.createItem(inv6, "black_stained_glass_pane", 1, 6, " ");
        itemHandler.createItem(inv6, "black_stained_glass_pane", 1, 7, " ");
        itemHandler.createItem(inv6, "black_stained_glass_pane", 1, 8, " ");
        itemHandler.createItem(inv6, "black_stained_glass_pane", 1, 9, " ");
        itemHandler.createItem(inv6, "black_stained_glass_pane", 1, 10, " ");
        itemHandler.createItem(inv6, "black_stained_glass_pane", 1, 11, " ");
        itemHandler.createItem(inv6, "black_stained_glass_pane", 1, 12, " ");
        int timer = stats.getProduction(p.getUniqueId());
        int timer2 = stats.getProduction1(p.getUniqueId());

        if (timer <= 0) {
            itemHandler.createItem(inv6, "red_stained_glass_pane", 1, 13, Painter.paint("&c1. Boş Üretim Alanı"),
                    Painter.paint("&7Ekipman Üretmek için &e&lSağ Tıkla."));
        }
        itemHandler.createItem(inv6, "black_stained_glass_pane", 1, 14, " ");
        if (timer2 <= 0) {
            itemHandler.createItem(inv6, "red_stained_glass_pane", 1, 15, Painter.paint("&c2. Boş Üretim Alanı"),
                    Painter.paint("&7- &fGereken Ustalık: &a10"),
                    Painter.paint("&7Ekipman Üretmek için &e&lSağ Tıkla."));

        }

        itemHandler.createItem(inv6, "black_stained_glass_pane", 1, 16, " ");

        itemHandler.createItem(inv6, "black_stained_glass_pane", 1, 17, " ");
        itemHandler.createItem(inv6, "black_stained_glass_pane", 1, 18, " ");
        itemHandler.createItem(inv6, "black_stained_glass_pane", 1, 19, " ");
        itemHandler.createItem(inv6, "black_stained_glass_pane", 1, 20, " ");
        itemHandler.createItem(inv6, "black_stained_glass_pane", 1, 21, " ");
        itemHandler.createItem(inv6, "black_stained_glass_pane", 1, 22, " ");
        itemHandler.createItem(inv6, "black_stained_glass_pane", 1, 23, " ");
        itemHandler.createItem(inv6, "black_stained_glass_pane", 1, 24, " ");
        itemHandler.createItem(inv6, "black_stained_glass_pane", 1, 25, " ");
        itemHandler.createItem(inv6, "black_stained_glass_pane", 1, 26, " ");
        itemHandler.createItem(inv6, "black_stained_glass_pane", 1, 27, " ");
        toReturn.setContents(inv6.getContents());
        return toReturn;
    }

    public Inventory demircimasasasas(Player p) {
        Inventory toReturn = Bukkit.createInventory(null, inv_rows9, inventory_name9);

        itemHandler.createItem(inv9, "red_stained_glass_pane", 1, 1, " ");
        itemHandler.createItem(inv9, "black_stained_glass_pane", 1, 2, " ");
        itemHandler.createItem(inv9, "black_stained_glass_pane", 1, 3, " ");
        itemHandler.createItem(inv9, "black_stained_glass_pane", 1, 4, " ");
        itemHandler.createItem(inv9, "black_stained_glass_pane", 1, 5, " ");
        itemHandler.createItem(inv9, "black_stained_glass_pane", 1, 6, " ");
        itemHandler.createItem(inv9, "black_stained_glass_pane", 1, 7, " ");
        itemHandler.createItem(inv9, "black_stained_glass_pane", 1, 8, " ");
        itemHandler.createItem(inv9, "red_stained_glass_pane", 1, 9, " ");
        itemHandler.createItem(inv9, "red_stained_glass_pane", 1, 10, " ");
        itemHandler.createItem(inv9, "black_stained_glass_pane", 1, 11, " ");
        itemHandler.createItem(inv9, "black_stained_glass_pane", 1, 13, " ");
        itemHandler.createItem(inv9, "black_stained_glass_pane", 1, 15, " ");
        itemHandler.createItem(inv9, "black_stained_glass_pane", 1, 14, " ");
        itemHandler.createItem(inv9, "smithing_table", 1, 12, ChatColor.WHITE + "Ekipman İşle",
                ChatColor.GRAY + "Burada elindeki malzemelerle neler yapabileceğine",
                ChatColor.GRAY + "bakıp yeni ekipmanlar işleyebilirsin.", Painter.paint("&7Açmak için &e&lSağ Tıkla!"));
        itemHandler.createItem(inv9, "stonecutter", 1, 16, ChatColor.WHITE + "Hurdaya Çevir",
                ChatColor.GRAY + "Elindeki ekipmanı burada hurdaya çevirebilirsin.",
                ChatColor.GRAY + "Ekipmanın ana malzemelerinin bir kısmı sana geri döner.",
                Painter.paint("&7Açmak için &e&lSağ Tıkla!"));

        itemHandler.createItem(inv9, "black_stained_glass_pane", 1, 17, " ");
        itemHandler.createItem(inv9, "red_stained_glass_pane", 1, 18, " ");
        itemHandler.createItem(inv9, "red_stained_glass_pane", 1, 19, " ");
        itemHandler.createItem(inv9, "black_stained_glass_pane", 1, 20, " ");
        itemHandler.createItem(inv9, "black_stained_glass_pane", 1, 21, " ");
        itemHandler.createItem(inv9, "black_stained_glass_pane", 1, 22, " ");
        itemHandler.createItem(inv9, "black_stained_glass_pane", 1, 23, " ");
        itemHandler.createItem(inv9, "black_stained_glass_pane", 1, 24, " ");
        itemHandler.createItem(inv9, "black_stained_glass_pane", 1, 25, " ");
        itemHandler.createItem(inv9, "black_stained_glass_pane", 1, 26, " ");
        itemHandler.createItem(inv9, "red_stained_glass_pane", 1, 27, " ");
        toReturn.setContents(inv9.getContents());
        return toReturn;
    }

    public Inventory Fletching(Player p) {
        Inventory toReturn = Bukkit.createInventory(null, inv_rows9, inventory_name17);

        itemHandler.createItem(inv17, "red_stained_glass_pane", 1, 1, " ");
        itemHandler.createItem(inv17, "black_stained_glass_pane", 1, 2, " ");
        itemHandler.createItem(inv17, "black_stained_glass_pane", 1, 3, " ");
        itemHandler.createItem(inv17, "black_stained_glass_pane", 1, 4, " ");
        itemHandler.createItem(inv17, "black_stained_glass_pane", 1, 5, " ");
        itemHandler.createItem(inv17, "black_stained_glass_pane", 1, 6, " ");
        itemHandler.createItem(inv17, "black_stained_glass_pane", 1, 7, " ");
        itemHandler.createItem(inv17, "black_stained_glass_pane", 1, 8, " ");
        itemHandler.createItem(inv17, "red_stained_glass_pane", 1, 9, " ");
        itemHandler.createItem(inv17, "red_stained_glass_pane", 1, 10, " ");
        itemHandler.createItem(inv17, "black_stained_glass_pane", 1, 11, " ");
        itemHandler.createItem(inv17, "black_stained_glass_pane", 1, 13, " ");
        itemHandler.createItem(inv17, "black_stained_glass_pane", 1, 15, " ");
        itemHandler.createItem(inv17, "black_stained_glass_pane", 1, 14, " ");
        itemHandler.createItem(inv17, "bow", 1, 12, ChatColor.WHITE + "Yay Ger",
                ChatColor.GRAY + "Burada elindeki yay parçaları ile hangi ekipmanları yapabileceğine",
                ChatColor.GRAY + "bakıp yeni ekipmanlar elde edebilirsin.", Painter.paint("&7Açmak için &e&lSağ Tıkla!"));
        itemHandler.createItem(inv17, "leather", 1, 14, ChatColor.WHITE + "Deri Dik",
                ChatColor.GRAY + "Burada elindeki derilerle hangi ekipmanları yapabileceğine",
                ChatColor.GRAY + "bakıp yeni ekipmanlar elde edebilirsin.", Painter.paint("&7Açmak için &e&lSağ Tıkla!"));
        itemHandler.createItem(inv17, "fishing_rod", 1, 16, ChatColor.WHITE + "Olta Kur",
                ChatColor.GRAY + "Burada elindeki olta parçalarıyla hangi ekipmanları yapabileceğine",
                ChatColor.GRAY + "bakıp yeni ekipmanlar elde edebilirsin.", Painter.paint("&7Açmak için &e&lSağ Tıkla!"));

        itemHandler.createItem(inv17, "black_stained_glass_pane", 1, 17, " ");
        itemHandler.createItem(inv17, "red_stained_glass_pane", 1, 18, " ");
        itemHandler.createItem(inv17, "red_stained_glass_pane", 1, 19, " ");
        itemHandler.createItem(inv17, "black_stained_glass_pane", 1, 20, " ");
        itemHandler.createItem(inv17, "black_stained_glass_pane", 1, 21, " ");
        itemHandler.createItem(inv17, "black_stained_glass_pane", 1, 22, " ");
        itemHandler.createItem(inv17, "black_stained_glass_pane", 1, 23, " ");
        itemHandler.createItem(inv17, "black_stained_glass_pane", 1, 24, " ");
        itemHandler.createItem(inv17, "black_stained_glass_pane", 1, 25, " ");
        itemHandler.createItem(inv17, "black_stained_glass_pane", 1, 26, " ");
        itemHandler.createItem(inv17, "red_stained_glass_pane", 1, 27, " ");
        toReturn.setContents(inv17.getContents());
        return toReturn;
    }

    @SuppressWarnings("deprecation")
    public void clicked(Player p, int slot, ItemStack clicked, Inventory inv) {
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.WHITE + "Ekipman İşle")) {
            p.openInventory(GUI2(p));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Aksesuarların")) {
            p.openInventory(accessorymenu(p));
            ArrayList<ItemStack> list = (ArrayList<ItemStack>) stats.getHepsi(p.getUniqueId());
            if (!(stats.getKolye(p.getUniqueId()).equals("Yok.."))) {
                ItemStack Kolye = list.get(2).clone();
                ItemMeta meta = Kolye.getItemMeta();
                meta.setDisplayName(ChatColor.YELLOW + "Kolye" + ChatColor.GRAY + " ("
                        + list.get(2).getItemMeta().getDisplayName() + ChatColor.GRAY + ")");
                Kolye.setItemMeta(meta);
                p.getOpenInventory().getTopInventory().setItem(32, Kolye);

            }
            if (!(stats.getTilsim(p.getUniqueId()).equals("Yok.."))) {
                ItemStack tilsim = list.get(0).clone();
                ItemMeta meta = tilsim.getItemMeta();
                meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Tılsım/Ok Kılıfı" + ChatColor.GRAY + " ("
                        + list.get(0).getItemMeta().getDisplayName() + ChatColor.GRAY + ")");
                tilsim.setItemMeta(meta);
                p.getOpenInventory().getTopInventory().setItem(28, tilsim);
            }
            if (!(stats.getEldiven(p.getUniqueId()).equals("Yok.."))) {
                ItemStack eldiven = list.get(1).clone();
                ItemMeta meta = eldiven.getItemMeta();
                meta.setDisplayName(ChatColor.BLUE + "Eldiven" + ChatColor.GRAY + " ("
                        + list.get(1).getItemMeta().getDisplayName() + ChatColor.GRAY + ")");
                eldiven.setItemMeta(meta);
                p.getOpenInventory().getTopInventory().setItem(30, eldiven);
            }
            if (!(stats.getYuzuk(p.getUniqueId()).equals("Yok.."))) {
                ItemStack yuzuk = list.get(3).clone();
                ItemMeta meta = yuzuk.getItemMeta();
                meta.setDisplayName(ChatColor.GOLD + "Yüzük" + ChatColor.GRAY + " ("
                        + list.get(3).getItemMeta().getDisplayName() + ChatColor.GRAY + ")");
                yuzuk.setItemMeta(meta);
                p.getOpenInventory().getTopInventory().setItem(34, yuzuk);
            }
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY + "Ayarlar")) {
            p.openInventory(ayarmenu(p));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.WHITE + "Deri Dik")) {
            p.openInventory(leatherwork(p));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.WHITE + "Hurdaya Çevir")) {
            p.openInventory(GUI2(p));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Painter.paint("&6Depo"))) {
            Inventory baba = JoinListener.getMenu().get(p.getUniqueId());
            p.openInventory(baba);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Painter.paint("&6Ocak Deposu"))) {
            Inventory baba = JoinListener.getOcakMenu().get(p.getUniqueId());
            p.openInventory(baba);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Painter.paint("&6Fırın Deposu"))) {
            Inventory baba = JoinListener.getFurnacemenu().get(p.getUniqueId());
            p.openInventory(baba);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Painter.paint("&6El Sanatları Deposu"))) {
            Inventory baba = JoinListener.getElsanatmenu().get(p.getUniqueId());
            p.openInventory(baba);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY + "Kritik Hasar Efekti")) {
            if (stats.getKritikAyar(p.getUniqueId())) {
                stats.setKritikAyar(p.getUniqueId(), false);
                itemHandler.createItem(inv, "tube_coral", 1, 29, ChatColor.GRAY + "Kritik Hasar Efekti",
                        ChatColor.DARK_RED + "Deaktif");
            } else {
                stats.setKritikAyar(p.getUniqueId(), true);
                itemHandler.createItem(inv, "tube_coral", 1, 29, ChatColor.GRAY + "Kritik Hasar Efekti",
                        ChatColor.DARK_GREEN + "Aktif");
            }
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY + "Çoklu Vuruş Ses Efekti")) {
            if (stats.getSaldiriHiziAyar(p.getUniqueId())) {
                stats.setSaldiriHiziAyar(p.getUniqueId(), false);
                itemHandler.createItem(inv, "sunflower", 1, 31, ChatColor.GRAY + "Çoklu Vuruş Ses Efekti",
                        ChatColor.DARK_RED + "Deaktif",
                        ChatColor.DARK_GRAY + "" + ChatColor.ITALIC + "(Saldırı Hızından Gelen Çoklu Vuruş)");
            } else {
                stats.setSaldiriHiziAyar(p.getUniqueId(), true);
                itemHandler.createItem(inv, "sunflower", 1, 31, ChatColor.GRAY + "Çoklu Vuruş Ses Efekti",
                        ChatColor.DARK_GREEN + "Aktif",
                        ChatColor.DARK_GRAY + "" + ChatColor.ITALIC + "(Saldırı Hızından Gelen Çoklu Vuruş)");
            }
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName() && clicked.getItemMeta()
                .getDisplayName().equalsIgnoreCase(ChatColor.GRAY + "Ağaçlardan Yaprak Düşme Animasyonu")) {
            if (stats.getYaprakAyar(p.getUniqueId())) {
                stats.setYaprakAyar(p.getUniqueId(), false);
                itemHandler.createItem(inv, "oak_leaves", 1, 33, ChatColor.GRAY + "Ağaçlardan Yaprak Düşme Animasyonu",
                        ChatColor.DARK_RED + "Deaktif");
            } else {
                stats.setYaprakAyar(p.getUniqueId(), true);
                itemHandler.createItem(inv, "oak_leaves", 1, 33, ChatColor.GRAY + "Ağaçlardan Yaprak Düşme Animasyonu",
                        ChatColor.DARK_GREEN + "Aktif");
            }
        }

        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY + "Skor Tablosu")) {
            if (stats.getSkorAyar(p.getUniqueId())) {
                stats.setSkorAyar(p.getUniqueId(), false);
                itemHandler.createItem(inv, "painting", 1, 35, ChatColor.GRAY + "Skor Tablosu",
                        ChatColor.DARK_RED + "Deaktif");
            } else {
                stats.setSkorAyar(p.getUniqueId(), true);
                itemHandler.createItem(inv, "painting", 1, 35, ChatColor.GRAY + "Skor Tablosu",
                        ChatColor.DARK_GREEN + "Aktif");
            }
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.WHITE + "Yay Ger")) {
            p.openInventory(Bow(p));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Çalışma Alanı")) {
            p.openWorkbench(p.getLocation(),true);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Pişmiş Patates")) {
            itemHandler.cooking2(p,itemHandler.patato,itemHandler.bakedpotato,1,1,1,itemHandler.coal,3,5,"Pişmiş Patates");
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Domuz Pastırması")) {
            itemHandler.cooking2(p,itemHandler.rawpork,itemHandler.cookedpork,2,1,1,itemHandler.coal,6,9,"Domuz Pastırması");
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Pişmiş Morina")) {
            itemHandler.cooking2(p,itemHandler.rawcod,itemHandler.cookedcod,1,1,1,itemHandler.coal,6,5,"Pişmiş Morina");
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Pişmiş Somon")) {
            itemHandler.cooking2(p,itemHandler.rawsalmon,itemHandler.cookedsalmon,1,1,1,itemHandler.coal,6,5,"Pişmiş Somon");
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Biftek")) {
            itemHandler.cooking2(p,itemHandler.rawbeef,itemHandler.cookedbeef,2,1,1,itemHandler.coal,7,12,"Biftek");
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Pişmiş Koyun Budu")) {
            itemHandler.cooking2(p,itemHandler.rawmutton,itemHandler.cookedmutton,1,1,1,itemHandler.coal,8,12,"Pişmiş Koyun Budu");
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Bakır Ekipmanlar")) {
            p.openInventory(t1Ekipman(p));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Bronz Ekipmanlar")) {
            p.openInventory(resourceSmith(p, "Bronz", "Ekipman İşleme -> Bronz Ekipmanlar", 1,"Meşe"));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY + "Demir Ekipmanlar")) {
            p.openInventory(resourceSmith(p, "Demir", "Ekipman İşleme -> Demir Ekipmanlar", 2,"Huş"));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Altın Ekipmanlar")) {
            p.openInventory(resourceSmith(p, "Altın", "Ekipman İşleme -> Altın Ekipmanlar", 9,"Huş"));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_PURPLE + "Obsidyen Ekipmanlar")) {
            p.openInventory(resourceSmith(p, "Obsidyen", "Ekipman İşleme -> Obsidyen Ekipmanlar", 7,"Ağır"));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Adamantium Ekipmanlar")) {
            p.openInventory(resourceSmith(p, "Adamantium", "Ekipman İşleme -> Adamantium Ekipmanlar", 5,"Kara Meşe"));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_GRAY + "Netherit Ekipmanlar")) {
            p.openInventory(resourceSmith(p, "Netherit", "Ekipman İşleme -> Netherit Ekipmanlar", 10,"Ağır"));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_AQUA + "Mitril Ekipmanlar")) {
            p.openInventory(resourceSmith(p, "Mitril", "Ekipman İşleme -> Mitril Ekipmanlar", 4,"Yaşlı Meşe"));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_PURPLE + "Hiçlik Ekipmanlar")) {
            p.openInventory(resourceSmith(p, "Hiçlik", "Ekipman İşleme -> Hiçlik Ekipmanlar", 4,"Yaşlı Meşe"));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Rodonit Ekipmanlar")) {
            p.openInventory(resourceSmith(p, "Rodonit", "Ekipman İşleme -> Rodonit Ekipmanlar", 3,"Ağır"));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Kızıl Metal Ekipmanlar")) {
            p.openInventory(resourceSmith(p, "Kızıl Metal", "Ekipman İşleme -> Kızıl Metal Ekipmanlar", 6,"Akasya"));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Spektral Ekipmanlar")) {
            p.openInventory(resourceSmith(p, "Spektral", "Ekipman İşleme -> Spektral Ekipmanlar", 11,"İlah Söğüt"));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "İnek Derisinden Ekipmanlar")) {
            p.openInventory(leatherSmith(p, "İnek", "Deri Dik -> İnek Derisinden Ekipmanlar", 0));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Bizon Derisinden Ekipmanlar")) {
            p.openInventory(leatherSmith(p, "Bizon", "Deri Dik -> Bizon Derisinden Ekipmanlar", 101));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY + "Yaban Domuzu Derisinden Ekipmanlar")) {
            p.openInventory(leatherSmith(p, "Yaban Domuzu", "Deri Dik -> Yaban Domuzu Derisinden Ekipmanlar", 103));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY + "Kurt Postundan Ekipmanlar")) {
            p.openInventory(leatherSmith(p, "Kurt", "Deri Dik -> Kurt Derisinden Ekipmanlar", 106));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Tavşan Derisinden Ekipmanlar")) {
            p.openInventory(leatherSmith(p, "Tavşan", "Deri Dik -> Tavşan Derisinden Ekipmanlar", 100));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Tilki Postundan Ekipmanlar")) {
            p.openInventory(leatherSmith(p, "Tilki", "Deri Dik -> Tilki Derisinden Ekipmanlar", 102));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Deve Derisinden Ekipmanlar")) {
            p.openInventory(leatherSmith(p, "Deve", "Deri Dik -> Deve Derisinden Ekipmanlar", 104));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_GRAY + "Mantikor Derisinden Ekipmanlar")) {
            p.openInventory(leatherSmith(p, "Mantikor", "Deri Dik -> Mantikor Derisinden Ekipmanlar", 108));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.WHITE + "Zefir Postundan Ekipmanlar")) {
            p.openInventory(leatherSmith(p, "Zefir", "Deri Dik -> Zefir Derisinden Ekipmanlar", 107));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Niteliklerin")) {
            p.openInventory(nitelik(p));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Painter.paint("&eGeri Dön."))) {
            if (p.getOpenInventory().getTitle().equals(inventory_name6)) {
                p.openInventory(GUI2(p));
            }
            if (p.getOpenInventory().getTitle().equals(inventory_name11)) {
                p.openInventory(cookGui(p));
            }
            if (p.getOpenInventory().getTitle().contains("Fırın ->")) {
                p.openInventory(Furnace(p));
            }


        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Painter.paint("&6&lDinçlik"))) {
            if (stats.getNP(p.getUniqueId()) > 0) {
                stats.setNP(p.getUniqueId(), -1);
                stats.setharcananNP(p.getUniqueId(), 1);
                stats.setCan(p, p.getUniqueId(), 1);
                stats.setCanYenileme(p, p.getUniqueId(), 1);
                itemHandler.createItem(inv, "red_dye", 1, 29, Painter.paint("&6&lDinçlik"),
                        Painter.paint("&7Puan başına &6Canını &e+1 &7ve"),
                        Painter.paint("&6Can Yenilenmeni &e+%1 &7arttırır."), "",
                        Painter.paint("&8Dinçlik can değerinizi ve can yenilenmenizi belirler."),
                        Painter.paint("&8Can değeriniz sizi ayakta tutan şeydir. Can yenilenmesi"),
                        Painter.paint("&8ise alınan hasardan sonra ne kadar hızlı iyileştiğinizdir."), "",
                        Painter.paint("&7Taban Dinçlik: &f20 &7/ &f5"),
                        Painter.paint("&7Toplam Dinçlik: &f") + stats.getCan(p.getUniqueId()) + " &7/ &f"
                                + stats.getCanYenileme(p.getUniqueId()),
                        "", Painter.paint("&7Nitelik Puanı eklemek için &e&lSağ Tıkla."));
                itemHandler.createItem(inv, "experience_bottle", 1, 5, ChatColor.WHITE + "Niteliklerin",
                        ChatColor.GRAY + "Burada seviye atlayarak", ChatColor.GRAY + "kazandığın nitelik puanlarını",
                        ChatColor.GRAY + "harcayıp daha da güçlenebilirsin.", "",
                        ChatColor.GOLD + "Sahip Olduğun Nitelik Puanı: " + ChatColor.RED + stats.getNP(p.getUniqueId()));

            } else {
                itemHandler.createItem(inv, "red_dye", 1, 29, Painter.paint("&6&lDinçlik"),
                        Painter.paint("&7Puan başına &6Canını &e+1 &7ve"),
                        Painter.paint("&6Can Yenilenmeni &e+%1 &7arttırır."), "",
                        Painter.paint("&8Dinçlik can değerinizi ve can yenilenmenizi belirler."),
                        Painter.paint("&8Can değeriniz sizi ayakta tutan şeydir. Can yenilenmesi"),
                        Painter.paint("&8ise alınan hasardan sonra ne kadar hızlı iyileştiğinizdir."), "",
                        Painter.paint("&7Taban Dinçlik: &f20 &7/ &f5"),
                        Painter.paint("&7Toplam Dinçlik: &f") + stats.getCan(p.getUniqueId()) + " &7/ &f"
                                + stats.getCanYenileme(p.getUniqueId()),
                        "", Painter.paint("&cYeterli Nitelik Puanın Yok!"));
            }
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().contains(ChatColor.LIGHT_PURPLE + "Tılsım")) {
            if (!(stats.getTilsim(p.getUniqueId()).equals("Yok.."))) {
                FileConfiguration fc = stats.getStatfile().get(p.getUniqueId());
                ArrayList<ItemStack> akselist = (ArrayList<ItemStack>) stats.getStatfile().get(p.getUniqueId())
                        .get("Aksesuar." + "Hepsi");

                if (p.getInventory().firstEmpty() == -1) {
                    p.closeInventory();
                    p.sendMessage(Painter.paint("&cEnvanterinde yer yok!"));
                } else {
                    ItemStack item = akselist.get(0);
                    p.getInventory().addItem(item);
                    akselist.set(0, new ItemStack(Material.AIR));
                    stats.setTilsim(p.getUniqueId(), "Yok..");
                    stats.getStatfile().put(p.getUniqueId(), fc);
                    itemHandler.createItem(inv, "magenta_stained_glass_pane", 1, 29,
                            ChatColor.LIGHT_PURPLE + "Tılsım/Ok Kılıfı", ChatColor.DARK_GRAY + "Yok..");
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
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().contains(ChatColor.BLUE + "Eldiven")) {
            if (!(stats.getEldiven(p.getUniqueId()).equals("Yok.."))) {
                FileConfiguration fc = stats.getStatfile().get(p.getUniqueId());
                ArrayList<ItemStack> akselist = (ArrayList<ItemStack>) stats.getStatfile().get(p.getUniqueId())
                        .get("Aksesuar." + "Hepsi");

                if (p.getInventory().firstEmpty() == -1) {
                    p.closeInventory();
                    p.sendMessage(Painter.paint("&cEnvanterinde yer yok!"));
                } else {
                    ItemStack item = akselist.get(1);
                    p.getInventory().addItem(item);
                    akselist.set(1, new ItemStack(Material.AIR));
                    stats.setEldiven(p.getUniqueId(), "Yok..");
                    stats.getStatfile().put(p.getUniqueId(), fc);
                    itemHandler.createItem(inv, "blue_stained_glass_pane", 1, 31, ChatColor.BLUE + "Eldiven",
                            ChatColor.DARK_GRAY + "Yok..");
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
                            } else if (key.equals(sicakdi)) {
                                stats.setSicakDirenci(p.getUniqueId(), -container.get(key, PersistentDataType.INTEGER));
                            } else if (key.equals(sogukdi)) {
                                stats.setSogukDirenci(p.getUniqueId(), -container.get(key, PersistentDataType.INTEGER));
                            } else if (key.equals(hiclikdi)) {
                                stats.setHiclikDirenci(p.getUniqueId(), -container.get(key, PersistentDataType.INTEGER));
                            }
                        }
                    }
                }
            }
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().contains(ChatColor.YELLOW + "Kolye")) {
            if (!(stats.getKolye(p.getUniqueId()).equals("Yok.."))) {
                FileConfiguration fc = stats.getStatfile().get(p.getUniqueId());
                ArrayList<ItemStack> akselist = (ArrayList<ItemStack>) stats.getStatfile().get(p.getUniqueId())
                        .get("Aksesuar." + "Hepsi");

                if (p.getInventory().firstEmpty() == -1) {
                    p.closeInventory();
                    p.sendMessage(Painter.paint("&cEnvanterinde yer yok!"));
                } else {
                    ItemStack item = akselist.get(2);
                    p.getInventory().addItem(item);
                    akselist.set(2, new ItemStack(Material.AIR));
                    stats.setKolye(p.getUniqueId(), "Yok..");
                    stats.getStatfile().put(p.getUniqueId(), fc);
                    itemHandler.createItem(inv, "yellow_stained_glass_pane", 1, 33, ChatColor.YELLOW + "Kolye",
                            ChatColor.DARK_GRAY + "Yok..");
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
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().contains(ChatColor.GOLD + "Yüzük")) {
            if (!(stats.getYuzuk(p.getUniqueId()).equals("Yok.."))) {
                FileConfiguration fc = stats.getStatfile().get(p.getUniqueId());
                ArrayList<ItemStack> akselist = (ArrayList<ItemStack>) stats.getStatfile().get(p.getUniqueId())
                        .get("Aksesuar." + "Hepsi");

                if (p.getInventory().firstEmpty() == -1) {
                    p.closeInventory();
                    p.sendMessage(Painter.paint("&cEnvanterinde yer yok!"));
                } else {
                    ItemStack item = akselist.get(3);
                    p.getInventory().addItem(item);
                    akselist.set(3, new ItemStack(Material.AIR));
                    stats.setYuzuk(p.getUniqueId(), "Yok..");
                    stats.getStatfile().put(p.getUniqueId(), fc);
                    itemHandler.createItem(inv, "orange_stained_glass_pane", 1, 35, ChatColor.GOLD + "Yüzük",
                            ChatColor.DARK_GRAY + "Yok..");
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
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Painter.paint("&a&lDayanıklılık"))) {
            if (stats.getNP(p.getUniqueId()) > 0) {
                stats.setNP(p.getUniqueId(), -1);
                stats.setharcananNP(p.getUniqueId(), 1);
                stats.setDirenc(p.getUniqueId(), 1);
                stats.setDoygunluk(p, p.getUniqueId(), 1);
                itemHandler.createItem(inv, "iron_chestplate", 1, 30, Painter.paint("&a&lDayanıklılık"),
                        Painter.paint("&7Puan başına &aZırh Değerini &e+1"),
                        Painter.paint("&7ve &aDoygunluğunu &e+%1 &7arttırır."), "",
                        Painter.paint("&8Dayanıklık aldığınız hasarı ve iş yapma kapasitenizi belirler."),
                        Painter.paint("&8Zırh değeriniz ne kadar yüksekse alınan hasar o kadar etkili olur,"),
                        Painter.paint("&8doygunluğunuz ne kadar yüksekse iş yaparken yorulmazsınız."), "",
                        Painter.paint("&7Taban Dayanıklılık: &f0 &7/ &f0"),
                        Painter.paint("&7Toplam Dayanıklılık: &f") + stats.getDirenc(p.getUniqueId()) + " &7/ &f"
                                + stats.getDoygunluk(p.getUniqueId()),
                        "", Painter.paint("&7Nitelik Puanı eklemek için &e&lSağ Tıkla."));
                itemHandler.createItem(inv, "experience_bottle", 1, 5, ChatColor.WHITE + "Niteliklerin",
                        ChatColor.GRAY + "Burada seviye atlayarak", ChatColor.GRAY + "kazandığın nitelik puanlarını",
                        ChatColor.GRAY + "harcayıp daha da güçlenebilirsin.", "",
                        ChatColor.GOLD + "Sahip Olduğun Nitelik Puanı: " + ChatColor.RED + stats.getNP(p.getUniqueId()));
            } else {
                itemHandler.createItem(inv, "iron_chestplate", 1, 30, Painter.paint("&a&lDayanıklılık"),
                        Painter.paint("&7Puan başına &aDirenç Değerini &e+1"),
                        Painter.paint("&7ve &aDoygunluğunu &e+%1 &7arttırır."), "",
                        Painter.paint("&8Dayanıklık aldığınız hasarı ve iş yapma kapasitenizi belirler."),
                        Painter.paint("&8Direnç değeriniz ne kadar yüksekse alınan hasar o kadar az etkili olur,"),
                        Painter.paint("&8doygunluğunuz ne kadar yüksekse iş yaparken yorulmazsınız."), "",
                        Painter.paint("&7Taban Dayanıklılık: &f0 &7/ &f0"),
                        Painter.paint("&7Toplam Dayanıklılık: &f") + stats.getDirenc(p.getUniqueId()) + " &7/ &f"
                                + stats.getDoygunluk(p.getUniqueId()),
                        "", Painter.paint("&cYeterli Nitelik Puanın Yok!"));
            }
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Painter.paint("&c&lGüç"))) {
            if (stats.getNP(p.getUniqueId()) > 0) {
                stats.setNP(p.getUniqueId(), -1);
                stats.setharcananNP(p.getUniqueId(), 1);
                stats.setGuc(p.getUniqueId(), 4);
                itemHandler.createItem(inv, "blaze_powder", 1, 31, Painter.paint("&c&lGüç"),
                        Painter.paint("&7Puan başına &cGücünü &e+4 &7arttırır."), "",
                        Painter.paint("&8Güç hasar kaynaklarınızdan biridir. Ne kadar "),
                        Painter.paint("&8güçlüyseniz darbeleriniz de bir o kadar etkili olur."), "",
                        Painter.paint("&7Taban Güç: &f5"),
                        Painter.paint("&7Toplam Güç: &f") + stats.getGuc(p.getUniqueId()), "",
                        Painter.paint("&7Nitelik Puanı eklemek için &e&lSağ Tıkla."));
                itemHandler.createItem(inv, "experience_bottle", 1, 5, ChatColor.WHITE + "Niteliklerin",
                        ChatColor.GRAY + "Burada seviye atlayarak", ChatColor.GRAY + "kazandığın nitelik puanlarını",
                        ChatColor.GRAY + "harcayıp daha da güçlenebilirsin.", "",
                        ChatColor.GOLD + "Sahip Olduğun Nitelik Puanı: " + ChatColor.RED + stats.getNP(p.getUniqueId()));
            } else {
                itemHandler.createItem(inv, "blaze_powder", 1, 31, Painter.paint("&c&lGüç"),
                        Painter.paint("&7Puan başına &cGücünü &e+4 &7arttırır."), "",
                        Painter.paint("&8Güç hasar kaynaklarınızdan biridir. Ne kadar "),
                        Painter.paint("&8güçlüyseniz darbeleriniz de bir o kadar etkili olur."), "",
                        Painter.paint("&7Taban Güç: &f5"),
                        Painter.paint("&7Toplam Güç: &f") + stats.getGuc(p.getUniqueId()), "",
                        Painter.paint("&cYeterli Nitelik Puanın Yok!"));

            }
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Painter.paint("&e&lDenge"))) {
            if (stats.getNP(p.getUniqueId()) > 0) {
                stats.setNP(p.getUniqueId(), -1);
                stats.setharcananNP(p.getUniqueId(), 1);
                stats.setSaldiriHizi(p.getUniqueId(), 2);
                itemHandler.createItem(inv, "glowstone_dust", 1, 33, Painter.paint("&e&lDenge"),
                        Painter.paint("&7Puan başına &eDengeni &e+2 &7arttırır."), "",
                        Painter.paint("&8Denge daha seri bir şekilde saldırabilmenizi sağlar."),
                        Painter.paint("&8Dengeli bir duruş vuruşlarınızın da dengeli olmasını sağlar."), "",
                        Painter.paint("&7Taban Denge: &f0"),
                        Painter.paint("&7Toplam Denge: &f") + stats.getSaldiriHizi(p.getUniqueId()), "",
                        Painter.paint("&7Nitelik Puanı eklemek için &e&lSağ Tıkla."));
                itemHandler.createItem(inv, "experience_bottle", 1, 5, ChatColor.WHITE + "Niteliklerin",
                        ChatColor.GRAY + "Burada seviye atlayarak", ChatColor.GRAY + "kazandığın nitelik puanlarını",
                        ChatColor.GRAY + "harcayıp daha da güçlenebilirsin.", "",
                        ChatColor.GOLD + "Sahip Olduğun Nitelik Puanı: " + ChatColor.RED + stats.getNP(p.getUniqueId()));
            } else {
                itemHandler.createItem(inv, "glowstone_dust", 1, 33, Painter.paint("&e&lDenge"),
                        Painter.paint("&7Puan başına &eDengeni &e+2 &7arttırır."), "",
                        Painter.paint("&8Denge daha seri bir şekilde saldırabilmenizi sağlar."),
                        Painter.paint("&8Dengeli bir duruş vuruşlarınızın da dengeli olmasını sağlar."), "",
                        Painter.paint("&7Taban Denge: &f0"),
                        Painter.paint("&7Toplam Denge: &f") + stats.getSaldiriHizi(p.getUniqueId()), "",
                        Painter.paint("&cYeterli Nitelik Puanın Yok!"));

            }
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Painter.paint("&f&lÇeviklik"))) {
            if (stats.getNP(p.getUniqueId()) > 0) {
                stats.setNP(p.getUniqueId(), -1);
                stats.setharcananNP(p.getUniqueId(), 1);
                stats.setHiz(p, p.getUniqueId(), 1);
                itemHandler.createItem(inv, "feather", 1, 34, Painter.paint("&f&lÇeviklik"),
                        Painter.paint("&7Puan başına &fÇevikliğini &e+1 &7arttırır."), "",
                        Painter.paint("&8Çeviklik ne kadar seri hareket ettiğinizdir. Çevikliğiniz "),
                        Painter.paint("&8ne kadar yüksekse o kadar hızlı hareket edersiniz."), "",
                        Painter.paint("&7Taban Çeviklik: &f0"),
                        Painter.paint("&7Toplam Çeviklik: &f") + stats.getHiz(p.getUniqueId()), "",
                        Painter.paint("&7Nitelik Puanı eklemek için &e&lSağ Tıkla."));
                itemHandler.createItem(inv, "experience_bottle", 1, 5, ChatColor.WHITE + "Niteliklerin",
                        ChatColor.GRAY + "Burada seviye atlayarak", ChatColor.GRAY + "kazandığın nitelik puanlarını",
                        ChatColor.GRAY + "harcayıp daha da güçlenebilirsin.", "",
                        ChatColor.GOLD + "Sahip Olduğun Nitelik Puanı: " + ChatColor.RED + stats.getNP(p.getUniqueId()));
            } else {
                itemHandler.createItem(inv, "feather", 1, 34, Painter.paint("&f&lÇeviklik"),
                        Painter.paint("&7Puan başına &fÇevikliğini &e+1 &7arttırır."), "",
                        Painter.paint("&8Çeviklik ne kadar seri hareket ettiğinizdir. Çevikliğiniz "),
                        Painter.paint("&8ne kadar yüksekse o kadar hızlı hareket edersiniz."), "",
                        Painter.paint("&7Taban Çeviklik: &f0"),
                        Painter.paint("&7Toplam Çeviklik: &f") + stats.getHiz(p.getUniqueId()), "",
                        Painter.paint("&cYeterli Nitelik Puanın Yok!"));
            }
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Painter.paint("&3&lHüner"))) {
            if (stats.getNP(p.getUniqueId()) > 0) {
                stats.setNP(p.getUniqueId(), -1);
                stats.setharcananNP(p.getUniqueId(), 1);
                stats.setKritikHasari(p.getUniqueId(), 1);
                stats.setKritikSansi(p.getUniqueId(), 1);
                itemHandler.createItem(inv, "nether_star", 1, 35, Painter.paint("&3&lHüner"),
                        Painter.paint("&7Puan başına &3Kritik Hasarını &e+1"),
                        Painter.paint("&7ve &3Kritik Şansını &e+%1 &7arttırır."), "",
                        Painter.paint("&8Hüner savaşta kullandığınız silahı daha iyi kullanmanızı sağlar."),
                        Painter.paint("&8Silahını iyi kullanan bir kişi rakibin zayıf noktalarını da görebilir."), "",
                        Painter.paint("&7Taban Hüner: &f12 &7/ &f0"),
                        Painter.paint("&7Toplam Hüner: &f") + stats.getKritikHasari(p.getUniqueId()) + " &7/ &f"
                                + stats.getKritikSansi(p.getUniqueId()),
                        "", Painter.paint("&7Nitelik Puanı eklemek için &e&lSağ Tıkla."));
                itemHandler.createItem(inv, "experience_bottle", 1, 5, ChatColor.WHITE + "Niteliklerin",
                        ChatColor.GRAY + "Burada seviye atlayarak", ChatColor.GRAY + "kazandığın nitelik puanlarını",
                        ChatColor.GRAY + "harcayıp daha da güçlenebilirsin.", "",
                        ChatColor.GOLD + "Sahip Olduğun Nitelik Puanı: " + ChatColor.RED + stats.getNP(p.getUniqueId()));
            } else {
                itemHandler.createItem(inv, "nether_star", 1, 35, Painter.paint("&3&lHüner"),
                        Painter.paint("&7Puan başına &3Kritik Hasarını &e+1"),
                        Painter.paint("&7ve &3Kritik Şansını &e+%1 &7arttırır."), "",
                        Painter.paint("&8Hüner savaşta kullandığınız silahı daha iyi kullanmanızı sağlar."),
                        Painter.paint("&8Silahını iyi kullanan bir kişi rakibin zayıf noktalarını da görebilir."), "",
                        Painter.paint("&7Taban Hüner: &f12 &7/ &f0"),
                        Painter.paint("&7Toplam Hüner: &f") + stats.getKritikHasari(p.getUniqueId()) + " &7/ &f"
                                + stats.getKritikSansi(p.getUniqueId()),
                        "", Painter.paint("&cYeterli Nitelik Puanın Yok!"));
            }
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Painter.paint("&4Niteliklerini Sıfırla!"))) {
            if (zerola.containsKey(p.getUniqueId())) {
                p.closeInventory();
                p.showTitle(

                        Title.title(MiniMessage.miniMessage().deserialize("<red>Nitelikler</red>"),
                                MiniMessage.miniMessage().deserialize("<gray>Sıfırlandı!</gray>")));
                stats.setNP(p.getUniqueId(), stats.getharcananNP(p.getUniqueId()) - 3);
                stats.setharcananNP(p.getUniqueId(), -stats.getharcananNP(p.getUniqueId()));
                stats.setKritikHasari(p.getUniqueId(), -stats.getKritikHasari(p.getUniqueId()) + 12);
                stats.setKritikSansi(p.getUniqueId(), -stats.getKritikSansi(p.getUniqueId()));
                stats.setCan(p, p.getUniqueId(), -stats.getCan(p.getUniqueId()) + 20);
                stats.setCanYenileme(p, p.getUniqueId(), -stats.getCanYenileme(p.getUniqueId()) + 5);
                stats.setDoygunluk(p, p.getUniqueId(), -stats.getDoygunluk(p.getUniqueId()));
                stats.setGuc(p.getUniqueId(), -stats.getGuc(p.getUniqueId()) + 5);
                stats.setDirenc(p.getUniqueId(), -stats.getDirenc(p.getUniqueId()));
                stats.setHiz(p, p.getUniqueId(), -stats.getHiz(p.getUniqueId()));
                stats.setSaldiriHizi(p.getUniqueId(), -stats.getSaldiriHizi(p.getUniqueId()));
                zerola.remove(p.getUniqueId());
            } else {
                if (stats.getharcananNP(p.getUniqueId()) > 3) {
                    int harcanannp = stats.getharcananNP(p.getUniqueId()) - 3;
                    itemHandler.createItem(inv, "barrier", 1, 14, Painter.paint("&4Niteliklerini Sıfırla!"),
                            Painter.paint("&7Niteliklerini sıfırlamak harcadığın puanları sana geri"),
                            Painter.paint("&7kazandırır. Fakat nitelik puanlarının birazı yok olur."), "",
                            Painter.paint("&fKazanılacak Nitelik Puanları: &a" + harcanannp), "",
                            Painter.paint("&C&lEmin misin? Eminsen bir daha tıkla."));
                    zerola.put(p.getUniqueId(), p.getName());

                } else {
                    int harcanannp = stats.getharcananNP(p.getUniqueId()) - 3;
                    itemHandler.createItem(inv, "barrier", 1, 14, Painter.paint("&4Niteliklerini Sıfırla!"),
                            Painter.paint("&7Niteliklerini sıfırlamak harcadığın puanları sana geri"),
                            Painter.paint("&7kazandırır. Fakat nitelik puanlarının birazı yok olur."), "",
                            Painter.paint("&fKazanılacak Nitelik Puanları: &a" + 0), "",
                            Painter.paint("&CYeterince Nitelik Puanı Kullanmamışsın!"));
                }
            }

        }

        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Ekmek")) {
            itemHandler.cooking2(p, itemHandler.wheat, itemHandler.bread, 3, 1, 1, itemHandler.coal, 6,10,itemHandler.bread.getItemMeta().getDisplayName());
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Bakır Külçesi")) {
            itemHandler.Smelting(p, itemHandler.copperore, itemHandler.copperingot, 1, 1, 2, itemHandler.coal,3,itemHandler.copperingot.getItemMeta().getDisplayName());
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY + "Demir Külçesi")) {
            itemHandler.Smelting(p, itemHandler.ironore, itemHandler.ironingot, 1, 1, 3, itemHandler.coal,4,itemHandler.ironingot.getItemMeta().getDisplayName());
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.WHITE + "Nikel Külçesi")) {
            itemHandler.Smelting(p, itemHandler.nikelore, itemHandler.nikelingot, 1, 1, 2, itemHandler.coal,4,itemHandler.nikelingot.getItemMeta().getDisplayName());
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Altın Külçesi")) {
            itemHandler.Smelting(p, itemHandler.goldore, itemHandler.goldingot, 1, 1, 3, itemHandler.coal,5,itemHandler.goldingot.getItemMeta().getDisplayName());
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_AQUA + "Mitril Külçesi")) {
            itemHandler.Smelting(p, itemHandler.mithrilore, itemHandler.mithrilingot, 3, 1, 1, itemHandler.lavabucket,10,itemHandler.mithrilingot.getItemMeta().getDisplayName());
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Adamantium Külçesi")) {
            itemHandler.Smelting(p, itemHandler.adamantiumingot, itemHandler.adamantiumingot, 1, 1, 4, itemHandler.coal,13,itemHandler.adamantiumingot.getItemMeta().getDisplayName());
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_PURPLE + "Obsidyen Külçesi")) {
            itemHandler.Smelting2(p, itemHandler.obsidianore, itemHandler.obsidianingot, 1, 1, 4,2, itemHandler.coal, itemHandler.nikelore,12,itemHandler.obsidianingot.getItemMeta().getDisplayName());
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_GRAY + "Netherit Külçesi")) {
            itemHandler.Smelting2(p, itemHandler.netheriteore, itemHandler.netheriteingot, 2, 1, 4,2, itemHandler.coal, itemHandler.ironore,12,itemHandler.netheriteingot.getItemMeta().getDisplayName());
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Kızıl Metal Külçesi")) {
            itemHandler.Smelting2(p, itemHandler.crimsonore, itemHandler.crimsoningot, 2, 1, 1,1, itemHandler.lavabucket, itemHandler.netheriteore,12,itemHandler.crimsoningot.getItemMeta().getDisplayName());
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_PURPLE + "Hiçlik Külçesi")) {
            itemHandler.Smelting2(p, itemHandler.voidlore, itemHandler.voidingot, 3, 1, 1,2, itemHandler.lavabucket, itemHandler.crimsonore,12,itemHandler.voidingot.getItemMeta().getDisplayName());
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Rodonit Külçesi")) {
            itemHandler.Smelting2(p, itemHandler.rodonitore, itemHandler.rodonitingot, 3, 1, 1,2, itemHandler.lavabucket, itemHandler.obsidianore,12,itemHandler.rodonitingot.getItemMeta().getDisplayName());
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Spektral Külçesi")) {
            itemHandler.Smelting3(p, itemHandler.spektralore, itemHandler.spektralingot, 1, 1, 4,1,2,1, itemHandler.rodonitore,itemHandler.lavabucket,itemHandler.obsidianore, itemHandler.mithrilore,12,itemHandler.spektralingot.getItemMeta().getDisplayName());
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Bronz Külçesi")) {
            itemHandler.Smelting2(p, itemHandler.copperore, itemHandler.bronzeingot, 1, 1, 2,1, itemHandler.coal, itemHandler.ironore,5,itemHandler.bronzeingot.getItemMeta().getDisplayName());
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Bakır Kılıç")) {
            itemHandler.createWeapon(p, itemHandler.copperingot, itemHandler.oakstick, 3, 2,
                    new ItemStack(Material.WOODEN_SWORD), "&6Bakır Kılıç", 2, 6, 4, 2, 2, false, 2, 10, 6, "Düşük", 5,
                    6, 10, 20, 5, "Kılıç",200);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Ağır Bakır Kılıç")) {
            itemHandler.createWeapon(p, itemHandler.copperingot, itemHandler.oakstick, 5, 3,
                    new ItemStack(Material.DIAMOND_SWORD), "&6Ağır Bakır Kılıç", 2, 8, 4, 2, 0, false, 2, 10, 6, "Orta", 5,
                    6, 10, 20, 5, "Ağır Kılıç",200);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Bakır Hançer")) {
            itemHandler.createWeapon(p, itemHandler.copperingot, itemHandler.oakstick, 3, 1,
                    new ItemStack(Material.SHEARS), "&6Bakır Hançer", 2, 6, 7, 5, 0, false, 2, 10, 5, "Düşük", 5, 6, 10,
                    20, 5, "Hançer",200);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Meşe Yay")) {
            itemHandler.createWeaponWork(p, itemHandler.oakstick, itemHandler.string, 4, 3,
                    8,new ItemStack(Material.BOW), "&eMeşe Yay", 1, 6, 7, 5, 0, false, 5, 0, 5, "Düşük", 0, 6, 10,
                    20, 2, "Yay",200);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Bakır Tırpan")) {
            itemHandler.createWeapon(p, itemHandler.copperingot, itemHandler.oakstick, 3, 3,
                    new ItemStack(Material.IRON_HOE), "&6Bakır Tırpan", 2, 4, 7, 5, 0, false, 2, 10, 4, "Orta", 5, 6,
                    10, 20, 5, "Tırpan",200);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Bakır Balta")) {
            itemHandler.createWeapon(p, itemHandler.copperingot, itemHandler.oakstick, 3, 2,
                    new ItemStack(Material.GOLDEN_AXE), "&6Bakır Balta", 2, 7, 5, 3, 0, false, 1, 14, 3, "Düşük", 5, 6,
                    10, 20, 5, "Balta",200);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Bakır Mızrak")) {
            itemHandler.createWeapon(p, itemHandler.copperingot, itemHandler.oakstick, 3, 2,
                    new ItemStack(Material.STICK), "&6Bakır Mızrak", 2, 7, 5, 3, 4, false, 1, 14, 7, "Düşük", 6, 6, 10,
                    20, 5, "Mızrak",200);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Bakır Topuz")) {
            itemHandler.createWeapon(p, itemHandler.copperingot, itemHandler.oakstick, 3, 3,
                    new ItemStack(Material.WOODEN_SHOVEL), "&6Bakır Topuz", 2, 7, 5, 3, 4, false, 1, 14, 7, "Düşük", 5, 6, 10,
                    20, 5, "Topuz",300);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Bakır Kürek")) {
            itemHandler.createTool(p, itemHandler.copperingot, 3, itemHandler.oakstick, 2,
                    new ItemStack(Material.GOLDEN_SHOVEL), "&6Bakır Kürek", 2, 4, false, 3, 20, 6, 10, 4, "Kürek",200);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Bakır Kazma")) {
            itemHandler.createTool(p,itemHandler.copperingot, 3, itemHandler.oakstick, 3,
                    new ItemStack(Material.GOLDEN_PICKAXE), "&6Bakır Kazma", 2, 5, false, 3, 20, 6, 10, 4, "Kazma",200);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Bakır Çapa")) {
            itemHandler.createTool(p, itemHandler.copperingot, 3, itemHandler.oakstick ,3,
                    new ItemStack(Material.GOLDEN_HOE), "&6Bakır Çapa", 2, 5, false, 3, 20, 6, 10, 4, "Çapa",200);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Bakır Göğüslük")) {
            itemHandler.createArmor(p, "Göğüslük", itemHandler.copperingot, 8,
                    new ItemStack(Material.LEATHER_CHESTPLATE), "&6Bakır Göğüslük", 2, 4, 5, 5, 1, 0, 0, 0, 0, 0, 0,
                    0, 4, 10, 8, 10,  8,200);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "İnek Derisinden Kapüşon")) {
            itemHandler.createArmorWork(p, "Kapüşon", itemHandler.cowleather, 8,
                    new ItemStack(Material.LEATHER_HELMET), "&6İnek Derisinden Kapüşon", 2, 2, 1, 2, 0, 0, 1, 1, 0, 0, 10,
                    8, 4, 20, 12, 10,  8,200);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Bakır Pantolon")) {
            itemHandler.createArmor(p, "Pantolon", itemHandler.copperingot, 7,
                    new ItemStack(Material.LEATHER_LEGGINGS), "&6Bakır Pantolon", 2, 3, 4, 5, 1, 0, 0, 0, 0, 0, 0, 0,
                    4, 10, 8, 10,  8,200);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Bakır Miğfer")) {
            itemHandler.createArmor(p, "Miğfer", itemHandler.copperingot, 5,
                    new ItemStack(Material.LEATHER_HELMET), "&6Bakır Miğfer", 2, 2, 4, 5, 1, 0, 0, 0, 0, 0, 0, 0, 4,
                    10, 8, 10,  8,200);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Bakır Botlar")) {
            itemHandler.createArmor(p, "Botlar", itemHandler.copperingot, 4,
                    new ItemStack(Material.LEATHER_BOOTS), "&6Bakır Botlar", 2, 2, 4, 5, 1, 0, 0, 0, 0, 0, 0, 0, 4,
                    12, 8, 10,  8,200);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Bronz Kılıç")) {
            itemHandler.createWeapon(p, itemHandler.bronzeingot, itemHandler.oakstick, 3, 2,
                    new ItemStack(Material.WOODEN_SWORD), "&6Bronz Kılıç", 2, 6, 4, 3, 2, false, 3, 16, 6, "Düşük", 5,
                    6, 12, 12, 10, "Kılıç",400);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Bronz Savaş Baltası")) {
            itemHandler.createWeapon(p, itemHandler.bronzeingot, itemHandler.oakstick, 6, 3,
                    new ItemStack(Material.WOODEN_AXE), "&6Bronz Savaş Baltası", 2, 10, 4, 0, 0, false, 1, 20, 0, "Orta", 5,
                    6, 12, 12, 10, "Savaş Baltası",400);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Ağır Bronz Kılıç")) {
            itemHandler.createWeapon(p, itemHandler.bronzeingot, itemHandler.oakstick, 5, 3,
                    new ItemStack(Material.DIAMOND_SWORD), "&6Ağır Bronz Kılıç", 2, 9, 4, 3, 2, false, 1, 18, 0, "Yüksek", 5,
                    6, 12, 12, 10, "Ağır Kılıç",400);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Bronz Hançer")) {
            itemHandler.createWeapon(p, itemHandler.bronzeingot, itemHandler.oakstick, 3, 1,
                    new ItemStack(Material.SHEARS), "&6Bronz Hançer", 2, 6, 8, 2, 3, false, 3, 12, 5, "Düşük", 5, 6, 12,
                    10, 10, "Hançer",400);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Bronz Tırpan")) {
            itemHandler.createWeapon(p, itemHandler.bronzeingot, itemHandler.oakstick, 3, 3,
                    new ItemStack(Material.IRON_HOE), "&6Bronz Tırpan", 2, 4, 4, 5, 0, false, 2, 14, 0, "Yüksek", 5, 6,
                    12, 12, 10, "Tırpan",400);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Bronz Balta")) {
            itemHandler.createTool(p,itemHandler.bronzeingot, 3, itemHandler.oakstick, 2,
                    new ItemStack(Material.GOLDEN_AXE), "&6Bronz Balta", 2, 7, false, 4, 4, 10, 10, 10, "Balta",400);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Bronz Mızrak")) {
            itemHandler.createWeapon(p, itemHandler.bronzeingot, itemHandler.oakstick, 3, 3,
                    new ItemStack(Material.STICK), "&6Bronz Mızrak", 2, 11, 3, 2, 4, false, 2, 14, 0, "Düşük", 6, 6, 12,
                    12, 10, "Mızrak",400);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Bronz Topuz")) {
            itemHandler.createWeapon(p, itemHandler.bronzeingot, itemHandler.oakstick, 3, 3,
                    new ItemStack(Material.WOODEN_SHOVEL), "&6Bronz Topuz", 2, 12, 4, 3, 1, false, 2, 17, 0, "Düşük", 5, 6, 12,
                    12, 10, "Topuz",400);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Bronz Kürek")) {
            itemHandler.createTool(p, itemHandler.bronzeingot, 3, itemHandler.oakstick, 2,
                    new ItemStack(Material.GOLDEN_SHOVEL), "&6Bronz Kürek", 2, 4, false, 3, 4, 10, 10, 10, "Kürek",400);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Bronz Kazma")) {
            itemHandler.createTool(p,itemHandler.bronzeingot, 3, itemHandler.oakstick, 3,
                    new ItemStack(Material.GOLDEN_PICKAXE), "&6Bronz Kazma", 2, 5, false, 4, 4, 10, 10, 10, "Kazma",400);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Bronz Çapa")) {
            itemHandler.createTool(p, itemHandler.bronzeingot, 3, itemHandler.oakstick ,3,
                    new ItemStack(Material.GOLDEN_HOE), "&6Bronz Çapa", 2, 5, false, 4, 4, 10, 10, 10, "Çapa",400);
        }

        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Bronz Göğüslük")) {
            itemHandler.createArmor(p, "Göğüslük", itemHandler.bronzeingot, 8,
                    new ItemStack(Material.LEATHER_CHESTPLATE), "&6Bronz Göğüslük", 2, 5, 5, 7, 0, 0, 1, 0, 0, 0, 0,
                    0, 4, 15, 12, 10,  8,400);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Bronz Pantolon")) {
            itemHandler.createArmor(p, "Pantolon", itemHandler.bronzeingot, 7,
                    new ItemStack(Material.LEATHER_LEGGINGS), "&6Bronz Pantolon", 2, 5, 4, 6, 0, 0, 1, 0, 0, 0, 0, 0,
                    4, 15, 10, 10,  8,400);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Bronz Miğfer")) {
            itemHandler.createArmor(p, "Miğfer", itemHandler.bronzeingot, 5,
                    new ItemStack(Material.LEATHER_HELMET), "&6Bronz Miğfer", 2, 4, 4, 6, 0, 0, 0, 0, 0, 0, 0, 0, 4,
                    15, 10, 10, 8,400);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Bronz Botlar")) {
            itemHandler.createArmor(p, "Botlar", itemHandler.bronzeingot, 4,
                    new ItemStack(Material.LEATHER_BOOTS), "&6Bronz Botlar", 2, 4, 4, 6, 0, 0, 1, 0, 0,0 , 0, 0, 0,
                    15, 10, 10,  8,400);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Bronz Kalkan")) {
            itemHandler.createShield(1,p, itemHandler.bronzeingot,itemHandler.oakplanks, 6, 4,
                    new ItemStack(Material.SHIELD), "&6Bronz Kalkan", 2, 5, 0, 0, 0, false, 0, 2, 0, "Düşük", 2,
                    6, 15, 10, 10, "Kalkan",400);
        }

        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Demir Kılıç")) {
            itemHandler.createWeapon(p, itemHandler.ironingot, itemHandler.birchstick, 3, 1,
                    new ItemStack(Material.WOODEN_SWORD), "&7Demir Kılıç", 3, 10, 4, 3, 2, false, 3, 22, 3, "Düşük", 5,
                    6, 15, 15, 10, "Kılıç",500);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Demir Savaş Baltası")) {
            itemHandler.createWeapon(p, itemHandler.ironingot, itemHandler.birchstick, 6, 2,
                    new ItemStack(Material.WOODEN_AXE), "&7Demir Savaş Baltası", 3, 16, 4, 2, 0, false, 1, 25, 0, "Orta", 5,
                    6, 15, 15, 10, "Savaş Baltası",500);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Ağır Demir Kılıç")) {
            itemHandler.createWeapon(p, itemHandler.ironingot, itemHandler.birchstick, 5, 1,
                    new ItemStack(Material.DIAMOND_SWORD), "&7Ağır Demir Kılıç", 2, 12, 5, 4, 2, false, 1, 20, 0, "Yüksek", 5,
                    6, 15, 15, 10, "Ağır Kılıç",500);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Demir Hançer")) {
            itemHandler.createWeapon(p, itemHandler.ironingot, itemHandler.birchstick, 3, 1,
                    new ItemStack(Material.SHEARS), "&7Demir Hançer", 2, 7, 8, 3, 4, false, 3, 13, 5, "Düşük", 5, 6, 15,
                    15, 10, "Hançer",500);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Demir Tırpan")) {
            itemHandler.createWeapon(p, itemHandler.ironingot, itemHandler.birchstick, 3, 3,
                    new ItemStack(Material.IRON_HOE), "&7Demir Tırpan", 2, 4, 4, 5, 0, false, 2, 14, 0, "Yüksek", 5, 6,
                    15, 15, 10, "Tırpan",500);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Demir Balta")) {
            itemHandler.createTool(p,itemHandler.ironingot, 3, itemHandler.birchstick, 2,
                    new ItemStack(Material.GOLDEN_AXE), "&7Demir Balta", 2, 7, false, 5, 4, 15, 15, 10, "Balta",500);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Demir Mızrak")) {
            itemHandler.createWeapon(p, itemHandler.ironingot, itemHandler.birchstick, 3, 2,
                    new ItemStack(Material.STICK), "&7Demir Mızrak", 2, 12, 4, 3, 4, false, 2, 18, 0, "Düşük", 6, 6, 15,
                    15, 10, "Mızrak",500);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Demir Topuz")) {
            itemHandler.createWeapon(p, itemHandler.ironingot, itemHandler.oakstick, 3, 2,
                    new ItemStack(Material.WOODEN_SHOVEL), "&7Demir Topuz", 2, 14, 7, 3, 1, false, 2, 19, 0, "Düşük", 5, 6, 15,
                    15, 10, "Topuz",500);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Demir Kürek")) {
            itemHandler.createTool(p, itemHandler.ironingot, 3, itemHandler.birchstick, 2,
                    new ItemStack(Material.GOLDEN_SHOVEL), "&7Demir Kürek", 2, 4, false, 4, 4, 15, 15, 10, "Kürek",500);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Demir Kazma")) {
            itemHandler.createTool(p,itemHandler.ironingot, 3, itemHandler.birchstick, 2,
                    new ItemStack(Material.GOLDEN_PICKAXE), "&7Demir Kazma", 2, 5, false, 5, 4, 15, 15, 10, "Kazma",500);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Demir Çapa")) {
            itemHandler.createTool(p, itemHandler.ironingot, 3, itemHandler.birchstick ,2,
                    new ItemStack(Material.GOLDEN_HOE), "&7Demir Çapa", 2, 5, false, 5, 4, 15, 15, 10, "Çapa",500);
        }

        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Demir Göğüslük")) {
            itemHandler.createArmor(p, "Göğüslük", itemHandler.ironingot, 8,
                    new ItemStack(Material.LEATHER_CHESTPLATE), "&7Demir Göğüslük", 2, 6, 6, 8, 2, 0, 1, 0, 0, 0, 0,
                    0, 4, 20, 15, 10,  2,500);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Demir Pantolon")) {
            itemHandler.createArmor(p, "Pantolon", itemHandler.ironingot, 7,
                    new ItemStack(Material.LEATHER_LEGGINGS), "&7Demir Pantolon", 2, 6, 4, 8, 2, 0, 1, 0, 0, 0, 0, 0,
                    4, 20, 10, 10,  2,500);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Demir Miğfer")) {
            itemHandler.createArmor(p, "Miğfer", itemHandler.ironingot, 5,
                    new ItemStack(Material.LEATHER_HELMET), "&7Demir Miğfer", 2, 6, 5, 8, 2, 0, 0, 0, 0, 0, 0, 0, 4,
                    20, 15, 10, 2,500);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Demir Botlar")) {
            itemHandler.createArmor(p, "Botlar", itemHandler.ironingot, 4,
                    new ItemStack(Material.LEATHER_BOOTS), "&7Demir Botlar", 2, 6, 5, 8, 2, 0, 1, 0, 0,0 , 0, 0, 0,
                    20, 10, 10,  2,500);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Demir Kalkan")) {
            itemHandler.createShield(2,p, itemHandler.ironingot,itemHandler.birchplanks, 6, 1,
                    new ItemStack(Material.SHIELD), "&7Demir Kalkan", 2, 5, 0, 0, 0, false, 0, 2, 0, "Düşük", 2,
                    6, 20, 15, 10, "Kalkan",500);
        }


        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Altın Kılıç")) {
            itemHandler.createWeapon(p, itemHandler.goldingot, itemHandler.birchstick, 3, 1,
                    new ItemStack(Material.WOODEN_SWORD), "&eAltın Kılıç", 3, 13, 5, 3, 4, false, 3, 24, 3, "Düşük", 5,
                    6, 20, 20, 10, "Kılıç",600);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Altın Savaş Baltası")) {
            itemHandler.createWeapon(p, itemHandler.goldingot, itemHandler.birchstick, 6, 2,
                    new ItemStack(Material.WOODEN_AXE), "&eAltın Savaş Baltası", 3, 18, 5, 3, 0, false, 1, 28, 0, "Orta", 5,
                    6, 20, 20, 10, "Savaş Baltası",600);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Ağır Altın Kılıç")) {
            itemHandler.createWeapon(p, itemHandler.goldingot, itemHandler.birchstick, 5, 1,
                    new ItemStack(Material.DIAMOND_SWORD), "&eAğır Altın Kılıç", 2, 17, 7, 6, 2, false, 1, 24, 0, "Yüksek", 5,
                    6, 20, 20, 10, "Ağır Kılıç",600);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Altın Hançer")) {
            itemHandler.createWeapon(p, itemHandler.goldingot, itemHandler.birchstick, 3, 1,
                    new ItemStack(Material.SHEARS), "&eAltın Hançer", 2, 8, 9, 3, 5, false, 3, 15, 5, "Düşük", 5, 6, 20,
                    20, 10, "Hançer",600);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Altın Tırpan")) {
            itemHandler.createWeapon(p, itemHandler.goldingot, itemHandler.birchstick, 3, 3,
                    new ItemStack(Material.IRON_HOE), "&eAltın Tırpan", 2, 12, 6, 5, 0, false, 2, 20, 0, "Yüksek", 5, 6,
                    20, 20, 10, "Tırpan",600);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Altın Balta")) {
            itemHandler.createTool(p,itemHandler.goldingot, 3, itemHandler.birchstick, 2,
                    new ItemStack(Material.GOLDEN_AXE), "&eAltın Balta", 2, 7, false, 6, 4, 20, 20, 10, "Balta",600);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Altın Mızrak")) {
            itemHandler.createWeapon(p, itemHandler.goldingot, itemHandler.birchstick, 3, 2,
                    new ItemStack(Material.STICK), "&eAltın Mızrak", 2, 15, 6, 3, 4, false, 2, 22, 0, "Düşük", 6, 6, 20,
                    20, 10, "Mızrak",600);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Altın Topuz")) {
            itemHandler.createWeapon(p, itemHandler.goldingot, itemHandler.oakstick, 3, 2,
                    new ItemStack(Material.WOODEN_SHOVEL), "&eAltın Topuz", 2,13 , 7, 4, 1, false, 2, 23, 0, "Düşük", 5, 6, 20,
                    20, 10, "Topuz",600);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Altın Kürek")) {
            itemHandler.createTool(p, itemHandler.goldingot, 3, itemHandler.birchstick, 2,
                    new ItemStack(Material.GOLDEN_SHOVEL), "&eAltın Kürek", 2, 4, false, 5, 4, 20, 20, 10, "Kürek",600);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Altın Kazma")) {
            itemHandler.createTool(p,itemHandler.goldingot, 3, itemHandler.birchstick, 2,
                    new ItemStack(Material.GOLDEN_PICKAXE), "&eAltın Kazma", 2, 5, false, 6, 4, 25, 15, 10, "Kazma",600);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Altın Çapa")) {
            itemHandler.createTool(p, itemHandler.goldingot, 3, itemHandler.birchstick ,2,
                    new ItemStack(Material.GOLDEN_HOE), "&eAltın Çapa", 2, 5, false, 6, 4, 25, 15, 10, "Çapa",600);
        }

        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Altın Göğüslük")) {
            itemHandler.createArmor(p, "Göğüslük", itemHandler.goldingot, 8,
                    new ItemStack(Material.LEATHER_CHESTPLATE), "&eAltın Göğüslük", 2, 7, 6, 9, 3, 1, 1, 0, 0, 0, 0,
                    0, 4, 25, 20, 10,  9,600);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Altın Pantolon")) {
            itemHandler.createArmor(p, "Pantolon", itemHandler.goldingot, 7,
                    new ItemStack(Material.LEATHER_LEGGINGS), "&eAltın Pantolon", 2, 7, 4, 9, 3, 1, 1, 0, 0, 0, 0, 0,
                    4, 25, 20, 10,  9,600);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Altın Miğfer")) {
            itemHandler.createArmor(p, "Miğfer", itemHandler.goldingot, 5,
                    new ItemStack(Material.LEATHER_HELMET), "&eAltın Miğfer", 2, 6, 5, 9, 3, 1, 0, 0, 0, 0, 0, 0, 4,
                    25, 20, 10, 9,600);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Altın Botlar")) {
            itemHandler.createArmor(p, "Botlar", itemHandler.goldingot, 4,
                    new ItemStack(Material.LEATHER_BOOTS), "&eAltın Botlar", 2, 6, 5, 8, 3, 1, 1, 0, 0,0 , 0, 0, 0,
                    25, 20, 10,  9,600);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Altın Kalkan")) {
            itemHandler.createShield(9,p, itemHandler.goldingot,itemHandler.birchplanks, 6, 1,
                    new ItemStack(Material.SHIELD), "&eAltın Kalkan", 2, 5, 0, 0, 0, false, 0, 2, 0, "Düşük", 2,
                    6, 25, 20, 10, "Kalkan",600);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_AQUA + "Avcılık")) {
            int combatlevel = stats.getCombatLevel(p.getUniqueId());
            if ((stats.getMeslek(p.getUniqueId()).equals("Yok.."))) {
                if (combatlevel >= 5) {
                    itemHandler.createItem(inv, "iron_sword", 1, 12,
                            Painter.paint("&3Avcılık &8[&7Meslek Bilgileri&8]"), "",
                            Painter.paint(" &fMeslek Avantajları:"),
                            Painter.paint("&7 - Yaratıklardan düşen ganimet artar."), Painter.paint(" &7- Yok.."), "",
                            Painter.paint("&7Bu mesleği seçmek için &e&lSağ Tıkla."));
                } else {
                    itemHandler.createItem(inv, "iron_sword", 1, 12,
                            Painter.paint("&3Avcılık &8[&7Meslek Bilgileri&8]"), "",
                            Painter.paint(" &fMeslek Avantajları:"),
                            Painter.paint("&7 - Yaratıklardan düşen ganimet artar."), Painter.paint(" &7- Yok.."), "",
                            Painter.paint("&cBu mesleği seçebilmek için Avcılıkta 5. seviye olman gerek."));
                }
            } else {
                itemHandler.createItem(inv, "iron_sword", 1, 12, Painter.paint("&cAvcılık &8[&7Meslek Bilgileri&8]"),
                        "", Painter.paint(" &fMeslek Avantajları:"),
                        Painter.paint("&7 - Yaratıklardan düşen ganimet artar."), Painter.paint(" &7- Yok.."), "",
                        Painter.paint("&cZaten bir meslek seçmişsin!"));

            }

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_AQUA + "Madencilik")) {
            int mininglevel = stats.getMadencilikLevel(p.getUniqueId());
            if ((stats.getMeslek(p.getUniqueId()).equals("Yok.."))) {
                if (mininglevel >= 5) {
                    itemHandler.createItem(inv, "iron_pickaxe", 1, 13,
                            Painter.paint("&3Madencilik &8[&7Meslek Bilgileri&8]"), "",
                            Painter.paint(" &fMeslek Avantajları:"),
                            Painter.paint("&7 - Kazılan madenlerden ek maden düşer."), Painter.paint(" &7 - Yok.."), "",
                            Painter.paint("&7Bu mesleği seçmek için &e&lSağ Tıkla."));
                } else {
                    itemHandler.createItem(inv, "iron_pickaxe", 1, 13,
                            Painter.paint("&3Madencilik &8[&7Meslek Bilgileri&8]"), "",
                            Painter.paint(" &fMeslek Avantajları:"),
                            Painter.paint("&7 - Kazılan madenlerden ek maden düşer."), Painter.paint(" &7- Yok.."), "",
                            Painter.paint("&cBu mesleği seçebilmek için Madencilikte 5. seviye olman gerek."));
                }
            } else {
                itemHandler.createItem(inv, "iron_pickaxe", 1, 13,
                        Painter.paint("&cMadencilik &8[&7Meslek Bilgileri&8]"), "",
                        Painter.paint(" &fMeslek Avantajları:"),
                        Painter.paint("&7 - Kazılan madenlerden ek maden düşer."), Painter.paint(" &7- Yok.."), "",
                        Painter.paint("&cZaten bir meslek seçmişsin!"));
            }

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_AQUA + "Odunculuk")) {
            int mininglevel = stats.getOdunculukLevel(p.getUniqueId());
            if ((stats.getMeslek(p.getUniqueId()).equals("Yok.."))) {
                if (mininglevel >= 5) {
                    itemHandler.createItem(inv, "iron_axe", 1, 14,
                            Painter.paint("&3Odunculuk &8[&7Meslek Bilgileri&8]"), "",
                            Painter.paint(" &fMeslek Avantajları:"),
                            Painter.paint("&7 - Balta ile ekstra hasar uygularsın."), Painter.paint(" &7- Yok.."), "",
                            Painter.paint("&7Bu mesleği seçmek için &e&lSağ Tıkla."));
                } else {
                    itemHandler.createItem(inv, "iron_axe", 1, 14,
                            Painter.paint("&3Odunculuk &8[&7Meslek Bilgileri&8]"), "",
                            Painter.paint(" &fMeslek Avantajları:"),
                            Painter.paint("&7 - Balta ile ekstra hasar uygularsın."), Painter.paint(" &7- Yok.."), "",
                            Painter.paint("&cBu mesleği seçebilmek için Odunculukta 5. seviye olman gerek."));
                }
            } else {
                itemHandler.createItem(inv, "iron_axe", 1, 14, Painter.paint("&cOdunculuk &8[&7Meslek Bilgileri&8]"),
                        "", Painter.paint(" &fMeslek Avantajları:"),
                        Painter.paint("&7 - Balta ile ekstra hasar uygularsın."), Painter.paint(" &7- Yok.."), "",
                        Painter.paint("&cZaten bir meslek seçmişsin!"));
            }

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_AQUA + "Balıkçılık")) {
            int mininglevel = stats.getFishingLevel(p.getUniqueId());
            if ((stats.getMeslek(p.getUniqueId()).equals("Yok.."))) {
                if (mininglevel >= 5) {
                    itemHandler.createItem(inv, "fishing_rod", 1, 15,
                            Painter.paint("&3Balıkçılık &8[&7Meslek Bilgileri&8]"), "",
                            Painter.paint(" &fMeslek Avantajları:"),
                            Painter.paint("&7 - Balık tutarken kutu çekme şansını arttırır."),
                            Painter.paint(" &7- Yok.."), "", Painter.paint("&7Bu mesleği seçmek için &e&lSağ Tıkla."));
                } else {
                    itemHandler.createItem(inv, "fishing_rod", 1, 15,
                            Painter.paint("&3Balıkçılık &8[&7Meslek Bilgileri&8]"), "",
                            Painter.paint(" &fMeslek Avantajları:"),
                            Painter.paint("&7 - Balık tutarken kutu çekme şansını arttırır."),
                            Painter.paint(" &7- Yok.."), "",
                            Painter.paint("&cBu mesleği seçebilmek için Balıkçılıkta 5. seviye olman gerek."));
                }
            } else {
                itemHandler.createItem(inv, "fishing_rod", 1, 15,
                        Painter.paint("&cBalıkçılık &8[&7Meslek Bilgileri&8]"), "",
                        Painter.paint(" &fMeslek Avantajları:"),
                        Painter.paint("&7 - Balık tutarken kutu çekme şansını arttırır."), Painter.paint(" &7- Yok.."),
                        "", Painter.paint("&cZaten bir meslek seçmişsin!"));
            }

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_AQUA + "Demircilik")) {
            int mininglevel = stats.getSmithLevel(p.getUniqueId());
            if ((stats.getMeslek(p.getUniqueId()).equals("Yok.."))) {
                if (mininglevel >= 5) {
                    itemHandler.createItem(inv, "smithing_table", 1, 16,
                            Painter.paint("&3Demircilik &8[&7Meslek Bilgileri&8]"), "",
                            Painter.paint(" &fMeslek Avantajları:"),
                            Painter.paint("&7 - İşlenen ekipmanların kalitesi artar."), Painter.paint(" &7- Yok.."), "",
                            Painter.paint("&7Bu mesleği seçmek için &e&lSağ Tıkla."));
                } else {
                    itemHandler.createItem(inv, "smithing_table", 1, 16,
                            Painter.paint("&3Demircilik &8[&7Meslek Bilgileri&8]"), "",
                            Painter.paint(" &fMeslek Avantajları:"),
                            Painter.paint("&7 - İşlenen ekipmanların kalitesi artar."), Painter.paint(" &7- Yok.."), "",
                            Painter.paint("&cBu mesleği seçebilmek için Demircilikte 5. seviye olman gerek."));
                }
            } else {
                itemHandler.createItem(inv, "smithing_table", 1, 16,
                        Painter.paint("&cDemircilik &8[&7Meslek Bilgileri&8]"), "",
                        Painter.paint(" &fMeslek Avantajları:"),
                        Painter.paint("&7 - İşlenen ekipmanların kalitesi artar."), Painter.paint(" &7- Yok.."), "",
                        Painter.paint("&cZaten bir meslek seçmişsin!"));
            }
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_AQUA + "Aşçılık")) {
            int mininglevel = stats.getCookLevel(p.getUniqueId());
            if ((stats.getMeslek(p.getUniqueId()).equals("Yok.."))) {
                if (mininglevel >= 5) {
                    itemHandler.createItem(inv, "bread", 1, 22, Painter.paint("&3Aşçılık &8[&7Meslek Bilgileri&8]"), "",
                            Painter.paint(" &fMeslek Avantajları:"),
                            Painter.paint("&7 - Pişirilen yemeklerin etkisi artar."), Painter.paint(" &7- Yok.."), "",
                            Painter.paint("&7Bu mesleği seçmek için &e&lSağ Tıkla."));
                } else {
                    itemHandler.createItem(inv, "bread", 1, 22, Painter.paint("&3Aşçılık &8[&7Meslek Bilgileri&8]"), "",
                            Painter.paint(" &fMeslek Avantajları:"),
                            Painter.paint("&7 - Pişirilen yemeklerin etkisi artar."), Painter.paint(" &7- Yok.."), "",
                            Painter.paint("&cBu mesleği seçebilmek için Aşçılıkta 5. seviye olman gerek."));
                }
            } else {
                itemHandler.createItem(inv, "bread", 1, 22, Painter.paint("&cAşçılık &8[&7Meslek Bilgileri&8]"), "",
                        Painter.paint(" &fMeslek Avantajları:"),
                        Painter.paint("&7 - Pişirilen yemeklerin etkisi artar."), Painter.paint(" &7- Yok.."), "",
                        Painter.paint("&cZaten bir meslek seçmişsin!"));
            }

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_AQUA + "Simyacılık")) {
            int mininglevel = stats.getAlchemyLevel(p.getUniqueId());
            if ((stats.getMeslek(p.getUniqueId()).equals("Yok.."))) {
                if (mininglevel >= 5) {
                    itemHandler.createItem(inv, "brewing_stand", 1, 23,
                            Painter.paint("&3Simyacılık &8[&7Meslek Bilgileri&8]"), "",
                            Painter.paint(" &fMeslek Avantajları:"),
                            Painter.paint("&7 - Mayalanan iksirlerin etkisi artar."), Painter.paint(" &7- Yok.."), "",
                            Painter.paint("&7Bu mesleği seçmek için &e&lSağ Tıkla."));
                } else {
                    itemHandler.createItem(inv, "brewing_stand", 1, 23,
                            Painter.paint("&3Simyacılık &8[&7Meslek Bilgileri&8]"), "",
                            Painter.paint(" &fMeslek Avantajları:"),
                            Painter.paint("&7 - Mayalanan iksirlerin etkisi artar."), Painter.paint(" &7- Yok.."), "",
                            Painter.paint("&cBu mesleği seçebilmek için Simyacılıkta 5. seviye olman gerek."));
                }
            } else {
                itemHandler.createItem(inv, "brewing_stand", 1, 23,
                        Painter.paint("&cSimyacılık &8[&7Meslek Bilgileri&8]"), "",
                        Painter.paint(" &fMeslek Avantajları:"),
                        Painter.paint("&7 - Mayalanan iksirlerin etkisi artar."), Painter.paint(" &7- Yok.."), "",
                        Painter.paint("&cZaten bir meslek seçmişsin!"));
            }
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_AQUA + "Büyücülük")) {
            int mininglevel = stats.getEnchLevel(p.getUniqueId());
            if ((stats.getMeslek(p.getUniqueId()).equals("Yok.."))) {
                if (mininglevel >= 5) {
                    itemHandler.createItem(inv, "enchanting_table", 1, 24,
                            Painter.paint("&3Büyücülük &8[&7Meslek Bilgileri&8]"), "",
                            Painter.paint(" &fMeslek Avantajları:"),
                            Painter.paint("&7 - Bir ekipmanı büyülerken seviye gereksinimi azalır."),
                            Painter.paint(" &7 - Yok.."), "", Painter.paint("&7Bu mesleği seçmek için &e&lSağ Tıkla."));
                } else {
                    itemHandler.createItem(inv, "enchanting_table", 1, 24,
                            Painter.paint("&3Büyücülük &8[&7Meslek Bilgileri&8]"), "",
                            Painter.paint(" &fMeslek Avantajları:"),
                            Painter.paint("&7 - Bir ekipmanı büyülerken seviye gereksinimi azalır."),
                            Painter.paint(" &7- Yok.."), "",
                            Painter.paint("&cBu mesleği seçebilmek için Büyücülükte 5. seviye olman gerek."));
                }
            } else {
                itemHandler.createItem(inv, "enchanting_table", 1, 24,
                        Painter.paint("&cBüyücülük &8[&7Meslek Bilgileri&8]"), "",
                        Painter.paint(" &fMeslek Avantajları:"),
                        Painter.paint("&7 - Bir ekipmanı büyülerken seviye gereksinimi azalır."),
                        Painter.paint(" &7- Yok.."), "", Painter.paint("&cZaten bir meslek seçmişsin!"));
            }

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_AQUA + "Çiftçilik")) {
            int mininglevel = stats.getFarmingLevel(p.getUniqueId());
            if ((stats.getMeslek(p.getUniqueId()).equals("Yok.."))) {
                if (mininglevel >= 5) {
                    itemHandler.createItem(inv, "wheat", 1, 32, Painter.paint("&3Çiftçilik &8[&7Meslek Bilgileri&8]"),
                            "", Painter.paint(" &fMeslek Avantajları:"),
                            Painter.paint("&7 - Hasat yaparken ekinlerden ekstra ürün düşer."),
                            Painter.paint(" &7- Yok.."), "", Painter.paint("&7Bu mesleği seçmek için &e&lSağ Tıkla."));
                } else {
                    itemHandler.createItem(inv, "wheat", 1, 32, Painter.paint("&3Çiftçilik &8[&7Meslek Bilgileri&8]"),
                            "", Painter.paint(" &fMeslek Avantajları:"),
                            Painter.paint("&7 - Hasat yaparken ekinlerden ekstra ürün düşer."),
                            Painter.paint(" &7- Yok.."), "",
                            Painter.paint("&cBu mesleği seçebilmek için Çiftçilikte 5. seviye olman gerek."));
                }
            } else {
                itemHandler.createItem(inv, "wheat", 1, 32, Painter.paint("&cÇiftçilik &8[&7Meslek Bilgileri&8]"), "",
                        Painter.paint(" &fMeslek Avantajları:"),
                        Painter.paint("&7 - Hasat yaparken ekinlerden ekstra ürün düşer."), Painter.paint(" &7- Yok.."),
                        "", Painter.paint("&cZaten bir meslek seçmişsin!"));
            }
        }

        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName() && clicked.getItemMeta()
                .getDisplayName().equalsIgnoreCase(Painter.paint("&3Avcılık &8[&7Meslek Bilgileri&8]"))) {
            int combatlevel = stats.getCombatLevel(p.getUniqueId());
            if (combatlevel >= 5) {
                itemHandler.createItem(inv, "iron_sword", 1, 12, Painter.paint("&3Avcılık &8[&7Meslek Bilgileri&8]"),
                        "", Painter.paint(" &fMeslek Avantajları:"),
                        Painter.paint("&7 - Yaratıklardan düşen ganimet artar."), Painter.paint(" &7- Yok.."), "",
                        Painter.paint("&cEğer bu mesleği seçersen uzun bir süre"),
                        Painter.paint("&cmesleğini değişteremeyeceksin. Bu mesleği seçmeyi"),
                        Painter.paint("&conaylıyorsan tekrar &e&lSağ Tıkla."));
                jobekle("Avcı", p);
            }

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName() && clicked.getItemMeta()
                .getDisplayName().equalsIgnoreCase(Painter.paint("&3Madencilik &8[&7Meslek Bilgileri&8]"))) {
            int mininglevel = stats.getMadencilikLevel(p.getUniqueId());
            if (mininglevel >= 5) {
                itemHandler.createItem(inv, "iron_pickaxe", 1, 13,
                        Painter.paint("&3Madencilik &8[&7Meslek Bilgileri&8]"), "",
                        Painter.paint(" &fMeslek Avantajları:"),
                        Painter.paint("&7 - Kazılan madenlerden ek maden düşer."), Painter.paint(" &7 - Yok.."), "",
                        Painter.paint("&cEğer bu mesleği seçersen uzun bir süre"),
                        Painter.paint("&cmesleğini değişteremeyeceksin. Bu mesleği seçmeyi"),
                        Painter.paint("&conaylıyorsan tekrar &e&lSağ Tıkla."));
                jobekle("Madenci", p);
            }

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName() && clicked.getItemMeta()
                .getDisplayName().equalsIgnoreCase(Painter.paint("&3Odunculuk &8[&7Meslek Bilgileri&8]"))) {
            int mininglevel = stats.getOdunculukLevel(p.getUniqueId());
            if (mininglevel >= 5) {
                itemHandler.createItem(inv, "iron_axe", 1, 14, Painter.paint("&3Odunculuk &8[&7Meslek Bilgileri&8]"),
                        "", Painter.paint(" &fMeslek Avantajları:"),
                        Painter.paint("&7 - Balta ile ekstra hasar uygularsın."), Painter.paint(" &7- Yok.."), "",
                        Painter.paint("&cEğer bu mesleği seçersen uzun bir süre"),
                        Painter.paint("&cmesleğini değişteremeyeceksin. Bu mesleği seçmeyi"),
                        Painter.paint("&conaylıyorsan tekrar &e&lSağ Tıkla."));
                jobekle("Oduncu", p);
            }

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName() && clicked.getItemMeta()
                .getDisplayName().equalsIgnoreCase(Painter.paint("&3Balıkçılık &8[&7Meslek Bilgileri&8]"))) {
            int mininglevel = stats.getFishingLevel(p.getUniqueId());
            if (mininglevel >= 5) {
                itemHandler.createItem(inv, "fishing_rod", 1, 15,
                        Painter.paint("&3Balıkçılık &8[&7Meslek Bilgileri&8]"), "",
                        Painter.paint(" &fMeslek Avantajları:"),
                        Painter.paint("&7 - Balık tutarken kutu çekme şansını arttırır."), Painter.paint(" &7- Yok.."),
                        "", Painter.paint("&cEğer bu mesleği seçersen uzun bir süre"),
                        Painter.paint("&cmesleğini değişteremeyeceksin. Bu mesleği seçmeyi"),
                        Painter.paint("&conaylıyorsan tekrar &e&lSağ Tıkla."));
                jobekle("Balıkçı", p);
            }

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName() && clicked.getItemMeta()
                .getDisplayName().equalsIgnoreCase(Painter.paint("&3Demircilik &8[&7Meslek Bilgileri&8]"))) {
            int mininglevel = stats.getSmithLevel(p.getUniqueId());
            if (mininglevel >= 5) {
                itemHandler.createItem(inv, "smithing_table", 1, 16,
                        Painter.paint("&3Demircilik &8[&7Meslek Bilgileri&8]"), "",
                        Painter.paint(" &fMeslek Avantajları:"),
                        Painter.paint("&7 - İşlenen ekipmanların kalitesi artar."), Painter.paint(" &7- Yok.."), "",
                        Painter.paint("&cEğer bu mesleği seçersen uzun bir süre"),
                        Painter.paint("&cmesleğini değişteremeyeceksin. Bu mesleği seçmeyi"),
                        Painter.paint("&conaylıyorsan tekrar &e&lSağ Tıkla."));
                jobekle("Demirci", p);
            }

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName() && clicked.getItemMeta()
                .getDisplayName().equalsIgnoreCase(Painter.paint("&3Aşçılık &8[&7Meslek Bilgileri&8]"))) {
            int mininglevel = stats.getCookLevel(p.getUniqueId());
            if (mininglevel >= 5) {
                itemHandler.createItem(inv, "bread", 1, 22, Painter.paint("&3Aşçılık &8[&7Meslek Bilgileri&8]"), "",
                        Painter.paint(" &fMeslek Avantajları:"),
                        Painter.paint("&7 - Pişirilen yemeklerin etkisi artar."), Painter.paint(" &7- Yok.."), "",
                        Painter.paint("&cEğer bu mesleği seçersen uzun bir süre"),
                        Painter.paint("&cmesleğini değişteremeyeceksin. Bu mesleği seçmeyi"),
                        Painter.paint("&conaylıyorsan tekrar &e&lSağ Tıkla."));
                jobekle("Aşçı", p);
            }

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName() && clicked.getItemMeta()
                .getDisplayName().equalsIgnoreCase(Painter.paint("&3Simyacılık &8[&7Meslek Bilgileri&8]"))) {
            int mininglevel = stats.getAlchemyLevel(p.getUniqueId());
            if (mininglevel >= 5) {
                itemHandler.createItem(inv, "brewing_stand", 1, 23,
                        Painter.paint("&3Simyacılık &8[&7Meslek Bilgileri&8]"), "",
                        Painter.paint(" &fMeslek Avantajları:"),
                        Painter.paint("&7 - Mayalanan iksirlerin etkisi artar."), Painter.paint(" &7- Yok.."), "",
                        Painter.paint("&cEğer bu mesleği seçersen uzun bir süre"),
                        Painter.paint("&cmesleğini değişteremeyeceksin. Bu mesleği seçmeyi"),
                        Painter.paint("&conaylıyorsan tekrar &e&lSağ Tıkla."));
                jobekle("Simyacı", p);
            }

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName() && clicked.getItemMeta()
                .getDisplayName().equalsIgnoreCase(Painter.paint("&3Büyücülük &8[&7Meslek Bilgileri&8]"))) {
            int mininglevel = stats.getEnchLevel(p.getUniqueId());
            if (mininglevel >= 5) {
                itemHandler.createItem(inv, "enchanting_table", 1, 24,
                        Painter.paint("&3Büyücülük &8[&7Meslek Bilgileri&8]"), "",
                        Painter.paint(" &fMeslek Avantajları:"),
                        Painter.paint("&7 - Bir ekipmanı büyülerken seviye gereksinimi azalır."),
                        Painter.paint(" &7 - Yok.."), "", Painter.paint("&cEğer bu mesleği seçersen uzun bir süre"),
                        Painter.paint("&cmesleğini değişteremeyeceksin. Bu mesleği seçmeyi"),
                        Painter.paint("&conaylıyorsan tekrar &e&lSağ Tıkla."));
                jobekle("Büyücü", p);
            }

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName() && clicked.getItemMeta()
                .getDisplayName().equalsIgnoreCase(Painter.paint("&3Çiftçilik &8[&7Meslek Bilgileri&8]"))) {
            int mininglevel = stats.getFarmingLevel(p.getUniqueId());
            if (mininglevel >= 5) {
                itemHandler.createItem(inv, "wheat", 1, 32, Painter.paint("&3Çiftçilik &8[&7Meslek Bilgileri&8]"), "",
                        Painter.paint(" &fMeslek Avantajları:"),
                        Painter.paint("&7 - Hasat yaparken ekinlerden ekstra ürün düşer."), Painter.paint(" &7- Yok.."),
                        "", Painter.paint("&cEğer bu mesleği seçersen uzun bir süre"),
                        Painter.paint("&cmesleğini değişteremeyeceksin. Bu mesleği seçmeyi"),
                        Painter.paint("&conaylıyorsan tekrar &e&lSağ Tıkla."));
                jobekle("Çiftçi", p);
            }

        }

        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Painter.paint("&c2. Boş Üretim Alanı"))) {
            int smithLevel = stats.getSmithLevel(p.getUniqueId());
            if (smithLevel >= 10) {
                p.openInventory(GUI2(p));
            } else {
                p.sendMessage(
                        Painter.paint("&cİşlemeye 2. bir ekipman koymak demircilikte 10. seviye ustalık gerektirir!"));
            }

        }

        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Painter.paint("&c1. Boş Üretim Alanı"))) {

            p.openInventory(GUI2(p));

        }

        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Painter.paint("&e5. Seviye Büyü"))) {
            ItemStack item = p.getOpenInventory().getItem(31);
            if (item != null && item.getItemMeta() != null) {
                if (p.getLevel() >= 5) {

                    if (item.getType() == Material.BOW) {
                        Enchants.addEnchantBow(item, p, 5);

                    }
                    if (item.getType() == Material.CROSSBOW) {
                        Enchants.addEnchantCrossbow(item, p, 5);
                    }
                    if (MaterialTags.CHESTPLATES.isTagged(item)) {
                        Enchants.addEnchantChestplate(item, p, 5);

                    }
                    if (MaterialTags.LEGGINGS.isTagged(item)) {
                        Enchants.addEnchantLeg(item, p, 5);

                    }
                    if (MaterialTags.HELMETS.isTagged(item)) {
                        Enchants.addEnchantHelmet(item, p, 5);
                    }
                    if (MaterialTags.BOOTS.isTagged(item)) {
                        Enchants.addEnchantBoots(item, p, 5);
                    }
                    if (MaterialTags.PICKAXES.isTagged(item)) {
                        Enchants.addEnchantPickaxe(item, p, 5);
                    }
                    if (MaterialTags.SHOVELS.isTagged(item)) {
                        Enchants.addEnchantShovel(item, p, 5);
                    }
                    if (MaterialTags.AXES.isTagged(item)) {
                        Enchants.addEnchantAxe(item, p, 5);
                    }
                    if (item.getType() == Material.FISHING_ROD) {
                        Enchants.addEnchantFishingRod(item, p, 5);
                    }
                    if (item.getType() == Material.BOOK) {
                        Random random = new Random();
                        int enchchance = random.nextInt(11);
                        switch (enchchance) {
                            case 0:
                                Enchants.addEnchantBow(item, p, 5);
                                break;
                            case 1:
                                Enchants.addEnchantCrossbow(item, p, 5);
                                break;
                            case 2:
                                Enchants.addEnchantAxe(item, p, 5);
                                break;
                            case 3:
                                Enchants.addEnchantToSword(item, p, 5);
                                break;
                            case 4:
                                Enchants.addEnchantChestplate(item, p, 5);
                                break;
                            case 5:
                                Enchants.addEnchantShovel(item, p, 5);
                                break;
                            case 6:
                                Enchants.addEnchantLeg(item, p, 5);
                                break;
                            case 7:
                                Enchants.addEnchantBoots(item, p, 5);
                                break;
                            case 8:
                                Enchants.addEnchantHelmet(item, p, 5);
                                break;
                            case 9:
                                Enchants.addEnchantPickaxe(item, p, 5);
                                break;
                            case 10:
                                Enchants.addEnchantFishingRod(item, p, 5);
                                break;

                        }

                    }
                    if (item.getType() == Material.IRON_SWORD || item.getType() == Material.STONE_SWORD
                            || item.getType() == Material.GOLDEN_SWORD || item.getType() == Material.WOODEN_SWORD
                            || item.getType() == Material.DIAMOND_SWORD || item.getType() == Material.NETHERITE_SWORD) {
                        Enchants.addEnchantToSword(item, p, 5);

                    }
                }
            }
        }

    }

    public Inventory getInv() {
        return inv;
    }

    public Inventory getInv2() {
        return inv2;
    }

    public Inventory getInv3() {
        return inv3;
    }

    public Inventory getInv4() {
        return inv4;
    }

    public Inventory getInv5() {
        return inv5;
    }

    public Inventory getInv6() {
        return inv6;
    }

    public Inventory getInv7() {
        return inv7;
    }

    public Inventory getInv8() {
        return inv8;
    }

    public Inventory getInv9() {
        return inv9;
    }

    public Inventory getInv10() {
        return inv10;
    }

    public Inventory getInv11() {
        return inv11;
    }

    public Inventory getInv13() {
        return inv13;
    }

    public Inventory getInv14() {
        return inv14;
    }

    public Inventory getInv12() {
        return inv12;
    }
    public Inventory getInv23() {
        return inv23;
    }
    public void jobekle(String meslek, Player p) {
        if (job.containsKey(p.getUniqueId())) {
            stats.setMeslek(p.getUniqueId(), meslek);
            p.closeInventory();
            p.showTitle(

                    Title.title(
                            MiniMessage.miniMessage()
                                    .deserialize("<gold>[</gold><yellow>Meslek Seçildi!</yellow><gold>]</gold>"),
                            MiniMessage.miniMessage().deserialize("<gray>" + meslek + "</gray>")));
            job.remove(p.getUniqueId());
        } else {
            job.put(p.getUniqueId(), "job");
        }
    }

}