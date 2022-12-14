package me.taylan.mooncore.utils;

import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.extent.clipboard.Clipboard;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormat;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormats;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardReader;
import com.sk89q.worldedit.function.operation.Operation;
import com.sk89q.worldedit.function.operation.Operations;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.session.ClipboardHolder;
import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.animations.CookAnim;
import me.taylan.mooncore.eco.Ekonomi;
import me.taylan.mooncore.enchanting.EnchantConstructor;
import me.taylan.mooncore.enchanting.Enchants;
import me.taylan.mooncore.listeners.JoinListener;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.title.Title;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class GuiHandler {
    public final MoonCore plugin;

    private final StatsManager stats;
    private final ItemHandler itemHandler;
    private final EnchantConstructor enchantConstructor;
    private final Enchants Enchants;
    private final CookAnim cookAnim;
    private final Ekonomi ekonomi;

    public GuiHandler(MoonCore plugin) {
        this.plugin = plugin;
        this.cookAnim = plugin.getCookAnim();
        this.itemHandler = plugin.getItemHandler();
        this.enchantConstructor = plugin.getEnchantConstructor();
        this.Enchants = plugin.getEnchants();
        this.stats = plugin.getStatsManager();
        this.ekonomi = plugin.getEkonomi();
        initialize();

    }

    public Inventory inv;
    public Inventory inv2;
    private final Pattern DIGITS_PATTERN = Pattern.compile("\\d+");
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

    public Inventory inv24;
    public Inventory inv21;

    public Inventory inv25;

    public Inventory inv26;

    public Inventory inv27;

    public Inventory inv28;
    public Inventory inv29;
    public Inventory inv30;
    public Inventory inv31;
    public Inventory inv32;
    public Inventory inv33;
    public String inventory_name12;
    public String inventory_name25;
    public String inventory_name18;
    public String inventory_name19;
    public String inventory_name20;
    public String inventory_name21;
    public String inventory_name23;
    public String inventory_name24;
    public String inventory_name26;
    public String inventory_name28;
    public String inventory_name27;
    public final int inv_rows12 = 6 * 9;

    public final int inv_rows = 6 * 9;
    public final int inv_rows2 = 5 * 9;
    public final int inv_rows3 = 5 * 9;

    public final int inv_rows4 = 5 * 9;
    public final int inv_rows5 = 5 * 9;

    public final int inv_rows6 = 3 * 9;
    public final int inv_rows7 = 6 * 9;
    public final int inv_rows8 = 6 * 9;
    public final int inv_rows9 = 3 * 9;
    public int inv_rows14 = 4 * 9;
    public final int inv_rows10 = 6 * 9;
    public final int inv_rows11 = 3 * 9;
    public static final HashMap<UUID, String> zerola = new HashMap<UUID, String>();
    public static final HashMap<UUID, String> job = new HashMap<UUID, String>();

    public void initialize() {
        inventory_name = Painter.paint(ChatColor.DARK_GRAY + "Demirci Masas?? -> Ekipman ????leme");
        inventory_name2 = Painter.paint(ChatColor.DARK_GRAY + "Ustal??k Bilgilerin");
        inventory_name3 = Painter.paint(ChatColor.DARK_GRAY + "Ocak");
        inventory_name4 = Painter.paint(ChatColor.DARK_GRAY + "F??r??n -> ??retimler");
        inventory_name5 = Painter.paint(ChatColor.DARK_GRAY + "Ekipman ????leme -> Bak??r Ekipmanlar");
        inventory_name6 = Painter.paint(ChatColor.DARK_GRAY + "Ekipman ????leme -> ??retimler");
        inventory_name7 = Painter.paint(ChatColor.DARK_GRAY + "B??y?? Masas??");
        inventory_name8 = Painter.paint(ChatColor.DARK_GRAY + "Demirci Masas?? -> Hurdaya ??evir");
        inventory_name9 = Painter.paint(ChatColor.DARK_GRAY + "Demirci Masas??");
        inventory_name10 = Painter.paint(ChatColor.DARK_GRAY + "??rs");
        inventory_name11 = Painter.paint(ChatColor.DARK_GRAY + "Ocak -> ??retimler");
        inventory_name12 = Painter.paint(ChatColor.DARK_GRAY + "Profili");
        inventory_name13 = Painter.paint(ChatColor.DARK_GRAY + "El Kitab??n");
        inventory_name14 = Painter.paint(ChatColor.DARK_GRAY + "El Kitab??n -> Niteliklerin");
        inventory_name15 = Painter.paint(ChatColor.DARK_GRAY + "El Kitab??n -> Ayarlar");
        inventory_name16 = Painter.paint(ChatColor.DARK_GRAY + "El Kitab??n -> Aksesuarlar??n");
        inventory_name17 = Painter.paint(ChatColor.DARK_GRAY + "El Sanatlar?? Masas??");
        inventory_name18 = Painter.paint(ChatColor.DARK_GRAY + "El Sanatlar?? Masas?? -> Yay Ger");
        inventory_name19 = Painter.paint(ChatColor.DARK_GRAY + "El Sanatlar?? Masas?? -> Deri Dik");
        inventory_name20 = Painter.paint(ChatColor.DARK_GRAY + "El Sanatlar?? Masas?? -> Olta Kur");
        inventory_name21 = Painter.paint(ChatColor.DARK_GRAY + "Maden F??r??n??");
        inventory_name26 = Painter.paint(ChatColor.DARK_GRAY + "Babayani'nin Teklifleri");
        inventory_name22 = Painter.paint(ChatColor.DARK_GRAY + "F??r??n");
        inventory_name23 = Painter.paint(("&8B??lge Bilgileri"));
        inventory_name24 = Painter.paint(("&8G??rev Defteri"));
        inventory_name27 = Painter.paint(("&8Yapabilece??in Seyehatler"));
        inventory_name28 = Painter.paint(ChatColor.DARK_GRAY + "Demirci Masas?? -> Tamir Et");
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
        inv24 = Bukkit.createInventory(null, inv_rows3);
        inv25 = Bukkit.createInventory(null, inv_rows11);
        inv26 = Bukkit.createInventory(null, inv_rows11);
        inv27 = Bukkit.createInventory(null, inv_rows10);
        inv28 = Bukkit.createInventory(null, inv_rows8);
        inv29 = Bukkit.createInventory(null, inv_rows8);
        inv30 = Bukkit.createInventory(null, inv_rows7);
        inv31 = Bukkit.createInventory(null, inv_rows);
        inv32 = Bukkit.createInventory(null, inv_rows6);
        inv33 = Bukkit.createInventory(null, inv_rows);
    }

    public Inventory tuccar1(Player p) {
        int smithLevel = stats.getWorkLevel(p.getUniqueId());
        Inventory toReturn = Bukkit.createInventory(null, inv_rows8, inventory_name26);

        itemHandler.createItem(inv29, "white_stained_glass_pane", 1, 1, " ");
        itemHandler.createItem(inv29, "white_stained_glass_pane", 1, 2, " ");
        itemHandler.createItem(inv29, "white_stained_glass_pane", 1, 3, " ");
        itemHandler.createItem(inv29, "white_stained_glass_pane", 1, 4, " ");
        itemHandler.createItem(inv29, "emerald", 1, 5, ChatColor.WHITE + "Babayani'nin Teklifleri",
                ChatColor.GRAY + "Burada elindeki malzemelerle", ChatColor.GRAY + "Bu t??ccarla malzeme ekipman",
                ChatColor.GRAY + "takaslayarak dinar kazanabilirsin.");
        itemHandler.createItem(inv29, "white_stained_glass_pane", 1, 6, " ");
        itemHandler.createItem(inv29, "white_stained_glass_pane", 1, 7, " ");
        itemHandler.createItem(inv29, "white_stained_glass_pane", 1, 8, " ");
        itemHandler.createItem(inv29, "white_stained_glass_pane", 1, 9, " ");
        itemHandler.createItem(inv29, "black_stained_glass_pane", 1, 10, " ");
        itemHandler.createItem(inv29, "black_stained_glass_pane", 1, 11, " ");
        itemHandler.createItem(inv29, "black_stained_glass_pane", 1, 12, " ");
        itemHandler.createItem(inv29, "black_stained_glass_pane", 1, 13, " ");
        itemHandler.createItem(inv29, "black_stained_glass_pane", 1, 14, " ");
        itemHandler.createItem(inv29, "black_stained_glass_pane", 1, 15, " ");
        itemHandler.createItem(inv29, "black_stained_glass_pane", 1, 16, " ");
        itemHandler.createItem(inv29, "black_stained_glass_pane", 1, 17, " ");
        itemHandler.createItem(inv29, "black_stained_glass_pane", 1, 18, " ");
        itemHandler.createItem(inv29, "bone", 1, 19, ChatColor.GOLD + "Kemik", "",
                ChatColor.GRAY + " Sat???? Fiyat??: &61 Dinar", "",
                ChatColor.GRAY + "Satmak i??in " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv29, "coal", 1, 20, ChatColor.GOLD + "K??m??r", "",
                ChatColor.GRAY + " Sat???? Fiyat??: &60.5 Dinar", "",
                ChatColor.GRAY + "Satmak i??in " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv29, "bone", 1, 21, ChatColor.GOLD + "Solmu?? Kemik", "",
                ChatColor.GRAY + " Sat???? Fiyat??: &61.4 Dinar", "",
                ChatColor.GRAY + "Satmak i??in " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");

        itemHandler.createItem(inv29, "oak_log", 1, 22, ChatColor.GOLD + "Me??e Odunu", "",
                ChatColor.GRAY + " Sat???? Fiyat??: &60.4 Dinar", "",
                ChatColor.GRAY + "Satmak i??in " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv29, "shears", 1, 23, ChatColor.GOLD + "Y??n K??rken", "",
                ChatColor.GRAY + " Al???? Fiyat??: &6100 Dinar", "",
                ChatColor.GRAY + "Almak i??in " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv29, "apple", 1, 24, ChatColor.GOLD + "Elma", "",
                ChatColor.GRAY + " Sat???? Fiyat??: &61 Dinar", "",
                ChatColor.GRAY + "Satmak i??in " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv29, "leather_chestplate", 1, 25, ChatColor.GOLD + "D??v????c?? Tuni??i", "",
                ChatColor.GRAY + " Al???? Fiyat??: &650 Dinar", "",
                ChatColor.GRAY + "Almak i??in " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv29, "stick", 1, 26, ChatColor.GOLD + "Az Kullan??lm???? M??zrak", "",
                ChatColor.GRAY + " Al???? Fiyat??: &6120 Dinar", "",
                ChatColor.GRAY + "Almak i??in " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv29, "potion", 1, 27, ChatColor.GOLD + "Geri D??n???? ??ksiri", "",
                ChatColor.GRAY + " Al???? Fiyat??: &6420 Dinar", "",
                ChatColor.GRAY + "Almak i??in " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        toReturn.setContents(inv29.getContents());
        return toReturn;
    }

    public Inventory leatherwork(Player p) {
        int smithLevel = stats.getWorkLevel(p.getUniqueId());
        Inventory toReturn = Bukkit.createInventory(null, inv_rows5, inventory_name19);

        itemHandler.createItem(inv20, "white_stained_glass_pane", 1, 1, " ");
        itemHandler.createItem(inv20, "white_stained_glass_pane", 1, 2, " ");
        itemHandler.createItem(inv20, "white_stained_glass_pane", 1, 3, " ");
        itemHandler.createItem(inv20, "white_stained_glass_pane", 1, 4, " ");
        itemHandler.createItem(inv20, "fletching_table", 1, 5, ChatColor.WHITE + "El Sanatlar?? Masas??",
                ChatColor.GRAY + "Burada elindeki malzemelerle", ChatColor.GRAY + "yapabilece??in ekipmanlara bakabilir",
                ChatColor.GRAY + "ve onlar?? yaoabilirsin.", "",
                ChatColor.GOLD + "El Sanatlar??ndaki Ustal??????n: " + ChatColor.GREEN + smithLevel);
        itemHandler.createItem(inv20, "white_stained_glass_pane", 1, 6, " ");
        itemHandler.createItem(inv20, "white_stained_glass_pane", 1, 7, " ");
        itemHandler.createItem(inv20, "white_stained_glass_pane", 1, 8, " ");
        itemHandler.createItem(inv20, "chest", 1, 9, Painter.paint("&6El Sanatlar?? Deposu"),
                Painter.paint("&7Buradan yapt??????n ekipmanlar?? alabilirsin."),
                Painter.paint("&7A??mak i??in &e&lSa?? T??kla."));
        itemHandler.createItem(inv20, "black_stained_glass_pane", 1, 10, " ");
        itemHandler.createItem(inv20, "black_stained_glass_pane", 1, 11, " ");
        itemHandler.createItem(inv20, "black_stained_glass_pane", 1, 12, " ");
        itemHandler.createItem(inv20, "black_stained_glass_pane", 1, 13, " ");
        itemHandler.createItem(inv20, "black_stained_glass_pane", 1, 14, " ");
        itemHandler.createItem(inv20, "black_stained_glass_pane", 1, 15, " ");
        itemHandler.createItem(inv20, "black_stained_glass_pane", 1, 16, " ");
        itemHandler.createItem(inv20, "black_stained_glass_pane", 1, 17, " ");
        itemHandler.createItem(inv20, "black_stained_glass_pane", 1, 18, " ");
        itemHandler.createItem(inv20, "leather", 1, 19, ChatColor.GOLD + "??nek Derisinden Ekipmanlar",
                ChatColor.GRAY + "Yapabilece??in ekipmanlara bakmak",
                ChatColor.GRAY + "i??in " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv20, "leather", 1, 20, ChatColor.GOLD + "Bizon Derisinden Ekipmanlar",
                ChatColor.GRAY + "Yapabilece??in ekipmanlara bakmak",
                ChatColor.GRAY + "i??in " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        if (smithLevel > 2) {
            itemHandler.createItem(inv20, "leather", 1, 21, ChatColor.GRAY + "Yaban Domuzu Derisinden Ekipmanlar",
                    ChatColor.GRAY + "Yapabilece??in ekipmanlara bakmak",
                    ChatColor.GRAY + "i??in " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        } else {
            itemHandler.createItem(inv20, "red_stained_glass_pane", 1, 21, ChatColor.GRAY + "??? " + ChatColor.RED + "(Ustal??k Yetersiz)",
                    ChatColor.GRAY + "Bu deriyi dikebilmek i??in el sanatlar??ndaki",
                    ChatColor.GRAY + "ustal??????n??n 2. seviyeden y??ksek olmas?? gerekir.");
        }
        if (smithLevel > 4) {
            itemHandler.createItem(inv20, "leather", 1, 22, ChatColor.GRAY + "Kurt Postundan Ekipmanlar",
                    ChatColor.GRAY + "Yapabilece??in ekipmanlara bakmak",
                    ChatColor.GRAY + "i??in " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        } else {
            itemHandler.createItem(inv20, "red_stained_glass_pane", 1, 22, ChatColor.GRAY + "??? " + ChatColor.RED + "(Ustal??k Yetersiz)",
                    ChatColor.GRAY + "Bu deriyi dikebilmek i??in el sanatlar??ndaki",
                    ChatColor.GRAY + "ustal??????n??n 4. seviyeden y??ksek olmas?? gerekir.");
        }
        if (smithLevel > 6) {
            itemHandler.createItem(inv20, "leather", 1, 23, ChatColor.YELLOW + "Tav??an Derisinden Ekipmanlar",
                    ChatColor.GRAY + "Yapabilece??in ekipmanlara bakmak",
                    ChatColor.GRAY + "i??in " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        } else {
            itemHandler.createItem(inv20, "red_stained_glass_pane", 1, 23, ChatColor.YELLOW + "??? " + ChatColor.RED + "(Ustal??k Yetersiz)",
                    ChatColor.GRAY + "Bu deriyi dikebilmek i??in el sanatlar??ndaki",
                    ChatColor.GRAY + "ustal??????n??n 6. seviyeden y??ksek olmas?? gerekir.");
        }
        if (smithLevel > 8) {
            itemHandler.createItem(inv20, "leather", 1, 24, ChatColor.GOLD + "Tilki Postundan Ekipmanlar",
                    ChatColor.GRAY + "Yapabilece??in ekipmanlara bakmak",
                    ChatColor.GRAY + "i??in " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        } else {
            itemHandler.createItem(inv20, "red_stained_glass_pane", 1, 24, ChatColor.GOLD + "??? " + ChatColor.RED + "(Ustal??k Yetersiz)",
                    ChatColor.GRAY + "Bu deriyi dikebilmek i??in el sanatlar??ndaki",
                    ChatColor.GRAY + "ustal??????n??n 8. seviyeden y??ksek olmas?? gerekir.");
        }
        if (smithLevel > 10) {
            itemHandler.createItem(inv20, "leather", 1, 25, ChatColor.GOLD + "Deve Derisinden Ekipmanlar",
                    ChatColor.GRAY + "Yapabilece??in ekipmanlara bakmak",
                    ChatColor.GRAY + "i??in " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        } else {
            itemHandler.createItem(inv20, "red_stained_glass_pane", 1, 25, ChatColor.GOLD + "??? " + ChatColor.RED + " (Ustal??k Yetersiz)",
                    ChatColor.GRAY + "Bu deriyi dikebilmek i??in el sanatlar??ndaki",
                    ChatColor.GRAY + "ustal??????n??n 10. seviyeden y??ksek olmas?? gerekir.");
        }
        if (smithLevel > 12) {
            itemHandler.createItem(inv20, "leather", 1, 26, ChatColor.DARK_GRAY + "Mantikor Derisinden Ekipmanlar",
                    ChatColor.GRAY + "Yapabilece??in ekipmanlara bakmak",
                    ChatColor.GRAY + "i??in " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        } else {
            itemHandler.createItem(inv20, "red_stained_glass_pane", 1, 26, ChatColor.DARK_GRAY + "??? " + ChatColor.RED + "(Ustal??k Yetersiz)",
                    ChatColor.GRAY + "Bu deriyi dikebilmek i??in el sanatlar??ndaki",
                    ChatColor.GRAY + "ustal??????n??n 12. seviyeden y??ksek olmas?? gerekir.");
        }
        if (smithLevel > 14) {
            itemHandler.createItem(inv20, "leather", 1, 27, ChatColor.WHITE + "Zefir Postundan Ekipmanlar",
                    ChatColor.GRAY + "Yapabilece??in ekipmanlara bakmak",
                    ChatColor.GRAY + "i??in " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        } else {
            itemHandler.createItem(inv20, "red_stained_glass_pane", 1, 27, ChatColor.RED + "??? " + ChatColor.RED + "(Ustal??k Yetersiz)",
                    ChatColor.GRAY + "Bu deriyi dikebilmek i??in el sanatlar??ndaki",
                    ChatColor.GRAY + "ustal??????n??n 14. seviyeden y??ksek olmas?? gerekir.");
        }

        toReturn.setContents(inv20.getContents());
        return toReturn;
    }

    public Inventory questbook(Player p) {
        int level = stats.getLevel(p.getUniqueId());
        Inventory toReturn = Bukkit.createInventory(null, inv_rows10, inventory_name24);

        itemHandler.createItem(inv26, "white_stained_glass_pane", 1, 1, " ");
        itemHandler.createItem(inv26, "white_stained_glass_pane", 1, 2, " ");
        itemHandler.createItem(inv26, "white_stained_glass_pane", 1, 3, " ");
        itemHandler.createItem(inv26, "white_stained_glass_pane", 1, 4, " ");
        itemHandler.createItem(inv26, "book", 1, 5, ChatColor.WHITE + "G??rev Defteri",
                ChatColor.GRAY + "Buradan g??revleri takip edebilir,", ChatColor.GRAY + "ve yeni g??revler ke??fedebilirsin.");
        itemHandler.createItem(inv26, "white_stained_glass_pane", 1, 6, " ");
        itemHandler.createItem(inv26, "white_stained_glass_pane", 1, 7, " ");
        itemHandler.createItem(inv26, "white_stained_glass_pane", 1, 8, " ");
        itemHandler.createItem(inv26, "white_stained_glass_pane", 1, 9, " ");
        itemHandler.createItem(inv26, "black_stained_glass_pane", 1, 10, " ");
        itemHandler.createItem(inv26, "black_stained_glass_pane", 1, 11, " ");
        itemHandler.createItem(inv26, "black_stained_glass_pane", 1, 12, " ");
        itemHandler.createItem(inv26, "black_stained_glass_pane", 1, 13, " ");
        itemHandler.createItem(inv26, "black_stained_glass_pane", 1, 14, " ");
        itemHandler.createItem(inv26, "black_stained_glass_pane", 1, 15, " ");
        itemHandler.createItem(inv26, "black_stained_glass_pane", 1, 16, " ");
        itemHandler.createItem(inv26, "black_stained_glass_pane", 1, 17, " ");
        itemHandler.createItem(inv26, "black_stained_glass_pane", 1, 18, " ");
        itemHandler.createItem(inv26, "book", 1, 19, ChatColor.GOLD + "&6Ogurus'un G??revleri",
                ChatColor.GREEN + "Seviye 1", "", " &7Lokasyon: &eLiman", " &7Kordinatlar: &e1520, 71, 1932", " &7G??revler:", " &7- &3Ke??fe Ba??lang????");
        itemHandler.createItem(inv26, "book", 1, 20, ChatColor.GOLD + "&6Yarin'in G??revleri",
                ChatColor.GREEN + "Seviye 1", "", " &7Lokasyon: &eLiman", " &7Kordinatlar: &e1483, 76, 1956", " &7G??revler:", " &7- &3Temel Avc??l??k", " &7- &3??lk Bal??k Av??");
        itemHandler.createItem(inv26, "book", 1, 21, ChatColor.GOLD + "&6??ulha'n??n G??revleri",
                ChatColor.GREEN + "Seviye 1", "", " &7Lokasyon: &eLiman", " &7Kordinatlar: &e1483, 76, 1956", " &7G??revler:", " &7- &3Liman Kenti Sakinleri");
        itemHandler.createItem(inv26, "book", 1, 22, ChatColor.GOLD + "&6Talarus'un G??revleri",
                ChatColor.GREEN + "Seviye 1", "", " &7Lokasyon: &eLiman", " &7Kordinatlar: &e1542, 74, 1919", " &7G??revler:", " &7- &3Odun Pazarl??????", " &7- &3K??tl??k");
        if (level > 2) {
            itemHandler.createItem(inv26, "book", 1, 23, ChatColor.GOLD + "&6Ahu'nun G??revleri",
                    ChatColor.GREEN + "Seviye 3", "", " &7Lokasyon: &eKrall??k", " &7Kordinatlar: &e1851, 92, 1664", " &7G??revler:", " &7- &3A??????l??k Dersi", " &7- &3Tuz Depozitosu");

        } else {
            itemHandler.createItem(inv26, "book", 1, 23, ChatColor.GOLD + "&6??? &7(Seviye Yetersiz)",
                    ChatColor.RED + "Bu g??revin bilgilerine ula??abilmek i??in Seviye 3 veya ??st?? olmal??s??n.");

        }
        if (level > 2) {
            itemHandler.createItem(inv26, "book", 1, 24, ChatColor.GOLD + "&6Yolsva'n??n G??revleri",
                    ChatColor.GREEN + "Seviye 3", "", " &7Lokasyon: &eKrall??k", " &7Kordinatlar: &e1814, 91, 1639", " &7G??revler:", " &7- &3El Sanatlar?? Ba??lang????", " &7- &3Yay Talimi");

        } else {
            itemHandler.createItem(inv26, "book", 1, 24, ChatColor.GOLD + "&6??? &7(Seviye Yetersiz)",
                    ChatColor.RED + "Bu g??revin bilgilerine ula??abilmek i??in Seviye 3 veya ??st?? olmal??s??n.");

        }
        if (level > 2) {
            itemHandler.createItem(inv26, "book", 1, 25, ChatColor.GOLD + "&6Avdol'Un G??revleri",
                    ChatColor.GREEN + "Seviye 3", "", " &7Lokasyon: &eKrall??k", " &7Kordinatlar: &e1826, 92, 1614", " &7G??revler:", " &7- &3Demircilik");

        } else {
            itemHandler.createItem(inv26, "book", 1, 25, ChatColor.GOLD + "&6??? &7(Seviye Yetersiz)",
                    ChatColor.RED + "Bu g??revin bilgilerine ula??abilmek i??in Seviye 3 veya ??st?? olmal??s??n.");

        }
        if (level > 4) {
            itemHandler.createItem(inv26, "book", 1, 26, ChatColor.GOLD + "&dSaorin'in G??revleri",
                    ChatColor.GREEN + "Seviye 5", "", " &7Lokasyon: &eKrall??k", " &7Kordinatlar: &e1905, 76, 1593", " &7G??revler:", " &7- &3B??y??c??l????e Ad??m (!)");

        } else {
            itemHandler.createItem(inv26, "book", 1, 26, ChatColor.GOLD + "&6??? &7(Seviye Yetersiz)",
                    ChatColor.RED + "Bu g??revin bilgilerine ula??abilmek i??in Seviye 5 veya ??st?? olmal??s??n.");

        }
        if (level > 4) {
            itemHandler.createItem(inv26, "book", 1, 27, ChatColor.GOLD + "&6Ofram'??n G??revleri",
                    ChatColor.GREEN + "Seviye 5", "", " &7Lokasyon: &eKrall??k", " &7Kordinatlar: &e1813, 92, 1562", " &7G??revler:", " &7- &3Simyac??l??k Dersi 1");

        } else {
            itemHandler.createItem(inv26, "book", 1, 27, ChatColor.GOLD + "&6??? &7(Seviye Yetersiz)",
                    ChatColor.RED + "Bu g??revin bilgilerine ula??abilmek i??in Seviye 5 veya ??st?? olmal??s??n.");

        }
        toReturn.setContents(inv26.getContents());
        return toReturn;
    }

    public Inventory GUI2(Player p) {
        int smithLevel = stats.getSmithLevel(p.getUniqueId());
        Inventory toReturn = Bukkit.createInventory(null, inv_rows, inventory_name);

        itemHandler.createItem(inv, "white_stained_glass_pane", 1, 1, " ");
        itemHandler.createItem(inv, "white_stained_glass_pane", 1, 2, " ");
        itemHandler.createItem(inv, "white_stained_glass_pane", 1, 3, " ");
        itemHandler.createItem(inv, "white_stained_glass_pane", 1, 4, " ");
        itemHandler.createItem(inv, "smithing_table", 1, 5, ChatColor.WHITE + "Demirci Masas??",
                ChatColor.GRAY + "Burada elindeki malzemelerle", ChatColor.GRAY + "yapabilece??in ekipmanlara bakabilir",
                ChatColor.GRAY + "ve onlar?? i??leyebilirsin.", "",
                ChatColor.GOLD + "Demircilikteki Ustal??????n: " + ChatColor.GREEN + smithLevel);
        itemHandler.createItem(inv, "white_stained_glass_pane", 1, 6, " ");
        itemHandler.createItem(inv, "white_stained_glass_pane", 1, 7, " ");
        itemHandler.createItem(inv, "white_stained_glass_pane", 1, 8, " ");
        itemHandler.createItem(inv, "chest", 1, 9, Painter.paint("&6Depo"),
                Painter.paint("&7Buradan i??lenmi?? ekipmanlar??n?? alabilirsin."),
                Painter.paint("&7A??mak i??in &e&lSa?? T??kla."));
        itemHandler.createItem(inv, "black_stained_glass_pane", 1, 10, " ");
        itemHandler.createItem(inv, "black_stained_glass_pane", 1, 11, " ");
        itemHandler.createItem(inv, "black_stained_glass_pane", 1, 12, " ");
        itemHandler.createItem(inv, "black_stained_glass_pane", 1, 13, " ");
        itemHandler.createItem(inv, "black_stained_glass_pane", 1, 14, " ");
        itemHandler.createItem(inv, "black_stained_glass_pane", 1, 15, " ");
        itemHandler.createItem(inv, "black_stained_glass_pane", 1, 16, " ");
        itemHandler.createItem(inv, "black_stained_glass_pane", 1, 17, " ");
        itemHandler.createItem(inv, "black_stained_glass_pane", 1, 18, " ");
        itemHandler.createItem(inv, "copper_ingot", 1, 19, ChatColor.GOLD + "Bak??r Ekipmanlar",
                ChatColor.GRAY + "Yapabilece??in ekipmanlara bakmak",
                ChatColor.GRAY + "i??in " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv, "copper_ingot", 1, 20, ChatColor.GOLD + "Bronz Ekipmanlar",
                ChatColor.GRAY + "Yapabilece??in ekipmanlara bakmak",
                ChatColor.GRAY + "i??in " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        if (smithLevel > 3) {
            itemHandler.createItem(inv, "iron_ingot", 1, 21, ChatColor.GRAY + "Demir Ekipmanlar",
                    ChatColor.GRAY + "Yapabilece??in ekipmanlara bakmak",
                    ChatColor.GRAY + "i??in " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        } else {
            itemHandler.createItem(inv, "red_stained_glass_pane", 1, 21, ChatColor.GRAY + "??? " + ChatColor.RED + "(Ustal??k Yetersiz)",
                    ChatColor.GRAY + "Bu madeni i??leyebilmek i??in demircilikteki",
                    ChatColor.GRAY + "ustal??????n??n 4. seviyeden y??ksek olmas?? gerekir.");
        }
        if (smithLevel > 5) {
            itemHandler.createItem(inv, "gold_ingot", 1, 22, ChatColor.YELLOW + "Alt??n Ekipmanlar",
                    ChatColor.GRAY + "Yapabilece??in ekipmanlara bakmak",
                    ChatColor.GRAY + "i??in " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        } else {
            itemHandler.createItem(inv, "red_stained_glass_pane", 1, 22, ChatColor.YELLOW + "??? " + ChatColor.RED + "(Ustal??k Yetersiz)",
                    ChatColor.GRAY + "Bu madeni i??leyebilmek i??in demircilikteki",
                    ChatColor.GRAY + "ustal??????n??n 6. seviyeden y??ksek olmas?? gerekir.");
        }
        if (smithLevel > 7) {
            itemHandler.createItem(inv, "copper_ingot", 1, 23, ChatColor.DARK_PURPLE + "Obsidyen Ekipmanlar",
                    ChatColor.GRAY + "Yapabilece??in ekipmanlara bakmak",
                    ChatColor.GRAY + "i??in " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        } else {
            itemHandler.createItem(inv, "red_stained_glass_pane", 1, 23, ChatColor.DARK_PURPLE + "??? " + ChatColor.RED + "(Ustal??k Yetersiz)",
                    ChatColor.GRAY + "Bu madeni i??leyebilmek i??in demircilikteki",
                    ChatColor.GRAY + "ustal??????n??n 8. seviyeden y??ksek olmas?? gerekir.");
        }
        if (smithLevel > 9) {
            itemHandler.createItem(inv, "iron_ingot", 1, 24, ChatColor.AQUA + "Adamantium Ekipmanlar",
                    ChatColor.GRAY + "Yapabilece??in ekipmanlara bakmak",
                    ChatColor.GRAY + "i??in " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        } else {
            itemHandler.createItem(inv, "red_stained_glass_pane", 1, 24, ChatColor.AQUA + "??? " + ChatColor.RED + " (Ustal??k Yetersiz)",
                    ChatColor.GRAY + "Bu madeni i??leyebilmek i??in demircilikteki",
                    ChatColor.GRAY + "ustal??????n??n 10. seviyeden y??ksek olmas?? gerekir.");
        }
        if (smithLevel > 11) {
            itemHandler.createItem(inv, "netherite_ingot", 1, 25, ChatColor.DARK_GRAY + "Netherit Ekipmanlar",
                    ChatColor.GRAY + "Yapabilece??in ekipmanlara bakmak",
                    ChatColor.GRAY + "i??in " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        } else {
            itemHandler.createItem(inv, "red_stained_glass_pane", 1, 25, ChatColor.DARK_GRAY + "??? " + ChatColor.RED + "(Ustal??k Yetersiz)",
                    ChatColor.GRAY + "Bu madeni i??leyebilmek i??in demircilikteki",
                    ChatColor.GRAY + "ustal??????n??n 12. seviyeden y??ksek olmas?? gerekir.");
        }
        if (smithLevel > 13) {
            itemHandler.createItem(inv, "copper_ingot", 1, 26, ChatColor.RED + "K??z??l Metal Ekipmanlar",
                    ChatColor.GRAY + "Yapabilece??in ekipmanlara bakmak",
                    ChatColor.GRAY + "i??in " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        } else {
            itemHandler.createItem(inv, "red_stained_glass_pane", 1, 26, ChatColor.RED + "??? " + ChatColor.RED + "(Ustal??k Yetersiz)",
                    ChatColor.GRAY + "Bu madeni i??leyebilmek i??in demircilikteki",
                    ChatColor.GRAY + "ustal??????n??n 14. seviyeden y??ksek olmas?? gerekir.");
        }
        if (smithLevel > 15) {
            itemHandler.createItem(inv, "iron_ingot", 1, 27, ChatColor.DARK_AQUA + "Mitril Ekipmanlar",
                    ChatColor.GRAY + "Yapabilece??in ekipmanlara bakmak",
                    ChatColor.GRAY + "i??in " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        } else {
            itemHandler.createItem(inv, "red_stained_glass_pane", 1, 27, ChatColor.DARK_AQUA + "??? " + ChatColor.RED + "(Ustal??k Yetersiz)",
                    ChatColor.GRAY + "Bu madeni i??leyebilmek i??in demircilikteki",
                    ChatColor.GRAY + "ustal??????n??n 16. seviyeden y??ksek olmas?? gerekir.");
        }
        if (smithLevel > 17) {
            itemHandler.createItem(inv, "gold_ingot", 1, 28, ChatColor.DARK_PURPLE + "Hi??lik Ekipmanlar",
                    ChatColor.GRAY + "Yapabilece??in ekipmanlara bakmak",
                    ChatColor.GRAY + "i??in " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        } else {
            itemHandler.createItem(inv, "red_stained_glass_pane", 1, 28, ChatColor.DARK_PURPLE + "???" + ChatColor.RED + " (Ustal??k Yetersiz)",
                    ChatColor.GRAY + "Bu madeni i??leyebilmek i??in demircilikteki",
                    ChatColor.GRAY + "ustal??????n??n 18. seviyeden y??ksek olmas?? gerekir.");
        }
        if (smithLevel > 19) {
            itemHandler.createItem(inv, "iron_ingot", 1, 29, ChatColor.RED + "Rodonit Ekipmanlar",
                    ChatColor.GRAY + "Yapabilece??in ekipmanlara bakmak",
                    ChatColor.GRAY + "i??in " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        } else {
            itemHandler.createItem(inv, "red_stained_glass_pane", 1, 29, ChatColor.RED + "??? " + ChatColor.RED + "(Ustal??k Yetersiz)",
                    ChatColor.GRAY + "Bu madeni i??leyebilmek i??in demircilikteki",
                    ChatColor.GRAY + "ustal??????n??n 20. seviyeden y??ksek olmas?? gerekir.");
        }
        if (smithLevel > 20) {
            itemHandler.createItem(inv, "iron_ingot", 1, 30, ChatColor.AQUA + "Spektral Ekipmanlar",
                    ChatColor.GRAY + "Yapabilece??in ekipmanlara bakmak",
                    ChatColor.GRAY + "i??in " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        } else {
            itemHandler.createItem(inv, "red_stained_glass_pane", 1, 30, ChatColor.AQUA + "??? " + ChatColor.RED + "(Ustal??k Yetersiz)",
                    ChatColor.GRAY + "Bu madeni i??leyebilmek i??in demircilikteki",
                    ChatColor.GRAY + "ustal??????n??n 22. seviyeden y??ksek olmas?? gerekir.");
        }
        toReturn.setContents(inv.getContents());
        return toReturn;
    }

    public Inventory GUIENCH2(Player p, String enchname, String malzemename2, String malzemename1) {
        int enchLevel = stats.getEnchLevel(p.getUniqueId());
        Inventory toReturn = Bukkit.createInventory(null, inv_rows7, "B??y?? Masas?? -> " + enchname);

        itemHandler.createItem(inv30, "arrow", 1, 1, "&eGeri D??n.");
        itemHandler.createItem(inv30, "white_stained_glass_pane", 1, 2, " ");
        itemHandler.createItem(inv30, "white_stained_glass_pane", 1, 3, " ");
        itemHandler.createItem(inv30, "white_stained_glass_pane", 1, 4, " ");
        itemHandler.createItem(inv30, "enchanting_table", 1, 5, ChatColor.WHITE + "B??y?? Masas??",
                ChatColor.GRAY + "Burada elindeki ekipmanlar?? b??y??leyebilirsin.",
                ChatColor.GRAY + "Ekipmanlar?? b??y??lemek b??y??lenen",
                ChatColor.GRAY + "ekipman??n kullan??l??rl??????n?? artt??r??r.", "",
                ChatColor.GOLD + "B??y??c??l??kte Ustal??????n: " + ChatColor.GREEN + enchLevel);
        itemHandler.createItem(inv30, "white_stained_glass_pane", 1, 6, " ");
        itemHandler.createItem(inv30, "white_stained_glass_pane", 1, 7, " ");
        itemHandler.createItem(inv30, "white_stained_glass_pane", 1, 8, " ");
        itemHandler.createItem(inv30, "white_stained_glass_pane", 1, 9, " ");

        itemHandler.createItem(inv30, "black_stained_glass_pane", 1, 10, " ");
        itemHandler.createItem(inv30, "black_stained_glass_pane", 1, 11, " ");
        itemHandler.createItem(inv30, "black_stained_glass_pane", 1, 12, " ");
        itemHandler.createItem(inv30, "black_stained_glass_pane", 1, 13, " ");
        itemHandler.createItem(inv30, "black_stained_glass_pane", 1, 14, " ");
        itemHandler.createItem(inv30, "black_stained_glass_pane", 1, 15, " ");
        itemHandler.createItem(inv30, "black_stained_glass_pane", 1, 16, " ");
        itemHandler.createItem(inv30, "black_stained_glass_pane", 1, 17, " ");
        itemHandler.createItem(inv30, "black_stained_glass_pane", 1, 18, " ");
        itemHandler.createItem(inv30, "gray_stained_glass_pane", 1, 19, " ");
        itemHandler.createItem(inv30, "gray_stained_glass_pane", 1, 20, " ");
        itemHandler.createItem(inv30, "gray_stained_glass_pane", 1, 21, " ");
        itemHandler.createItem(inv30, "gray_stained_glass_pane", 1, 22, " ");
        inv30.setItem(22, p.getOpenInventory().getTopInventory().getItem(22));
        itemHandler.createItem(inv30, "gray_stained_glass_pane", 1, 24, " ");
        itemHandler.createItem(inv30, "gray_stained_glass_pane", 1, 25, " ");
        itemHandler.createItem(inv30, "gray_stained_glass_pane", 1, 26, " ");
        itemHandler.createItem(inv30, "gray_stained_glass_pane", 1, 27, " ");
        itemHandler.createItem(inv30, "gray_stained_glass_pane", 1, 28, " ");
        itemHandler.createItem(inv30, "gray_stained_glass_pane", 1, 29, " ");
        itemHandler.createItem(inv30, "gray_stained_glass_pane", 1, 30, " ");
        itemHandler.createItem(inv30, "gray_stained_glass_pane", 1, 31, " ");
        itemHandler.createItem(inv30, "gray_stained_glass_pane", 1, 32, " ");
        itemHandler.createItem(inv30, "gray_stained_glass_pane", 1, 33, " ");
        itemHandler.createItem(inv30, "gray_stained_glass_pane", 1, 34, " ");
        itemHandler.createItem(inv30, "gray_stained_glass_pane", 1, 35, " ");
        itemHandler.createItem(inv30, "gray_stained_glass_pane", 1, 36, " ");
        itemHandler.createItem(inv30, "gray_stained_glass_pane", 1, 37, " ");
        itemHandler.createItem(inv30, "gray_stained_glass_pane", 1, 38, " ");
        itemHandler.createItem(inv30, "enchanted_book", 1, 39, ChatColor.DARK_AQUA + enchname + " 1",
                "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 15 " + malzemename1,
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 15 " + malzemename2,
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 20 Seviye", "", ChatColor.GRAY + "B??y??y?? ekipmana i??lemek i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv30, "enchanted_book", 1, 40, ChatColor.DARK_AQUA + enchname + " 2",
                "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 30 " + malzemename1,
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 30 " + malzemename2,
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 30 Seviye", "", ChatColor.GRAY + "B??y??y?? ekipmana i??lemek i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv30, "enchanted_book", 1, 41, ChatColor.DARK_AQUA + enchname + " 3",
                "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 45 " + malzemename1,
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 45 " + malzemename2,
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 40 Seviye", "", ChatColor.GRAY + "B??y??y?? ekipmana i??lemek i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv30, "enchanted_book", 1, 42,
                ChatColor.DARK_AQUA + enchname + " 4",
                "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 60 " + malzemename1,
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 60 " + malzemename2,
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 50 Seviye", "", ChatColor.GRAY + "B??y??y?? ekipmana i??lemek i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv30, "enchanted_book", 1, 43,
                ChatColor.DARK_AQUA + enchname + " 5",
                "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 75 " + malzemename1,
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 75 " + malzemename2,
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 60 Seviye", "", ChatColor.GRAY + "B??y??y?? ekipmana i??lemek i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");

        itemHandler.createItem(inv30, "gray_stained_glass_pane", 1, 44, " ");
        itemHandler.createItem(inv30, "gray_stained_glass_pane", 1, 45, " ");
        itemHandler.createItem(inv30, "gray_stained_glass_pane", 1, 46, " ");
        itemHandler.createItem(inv30, "gray_stained_glass_pane", 1, 47, " ");
        itemHandler.createItem(inv30, "gray_stained_glass_pane", 1, 48, " ");
        itemHandler.createItem(inv30, "gray_stained_glass_pane", 1, 49, " ");
        itemHandler.createItem(inv30, "gray_stained_glass_pane", 1, 50, " ");
        itemHandler.createItem(inv30, "gray_stained_glass_pane", 1, 51, " ");
        itemHandler.createItem(inv30, "gray_stained_glass_pane", 1, 52, " ");
        itemHandler.createItem(inv30, "gray_stained_glass_pane", 1, 53, " ");
        itemHandler.createItem(inv30, "gray_stained_glass_pane", 1, 54, " ");

        toReturn.setContents(inv30.getContents());
        return toReturn;
    }

    public Inventory GUIENCH(Player p) {
        int enchLevel = stats.getEnchLevel(p.getUniqueId());
        Inventory toReturn = Bukkit.createInventory(null, inv_rows7, inventory_name7);

        itemHandler.createItem(inv7, "white_stained_glass_pane", 1, 1, " ");
        itemHandler.createItem(inv7, "white_stained_glass_pane", 1, 2, " ");
        itemHandler.createItem(inv7, "white_stained_glass_pane", 1, 3, " ");
        itemHandler.createItem(inv7, "white_stained_glass_pane", 1, 4, " ");
        itemHandler.createItem(inv7, "enchanting_table", 1, 5, ChatColor.WHITE + "B??y?? Masas??",
                ChatColor.GRAY + "Burada elindeki ekipmanlar?? b??y??leyebilirsin.",
                ChatColor.GRAY + "Ekipmanlar?? b??y??lemek b??y??lenen",
                ChatColor.GRAY + "ekipman??n kullan??l??rl??????n?? artt??r??r.", "",
                ChatColor.GOLD + "B??y??c??l??kte Ustal??????n: " + ChatColor.GREEN + enchLevel);
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
        itemHandler.createItem(inv7, "gray_stained_glass_pane", 1, 24, " ");
        itemHandler.createItem(inv7, "gray_stained_glass_pane", 1, 25, " ");
        itemHandler.createItem(inv7, "gray_stained_glass_pane", 1, 26, " ");
        itemHandler.createItem(inv7, "gray_stained_glass_pane", 1, 27, " ");
        itemHandler.createItem(inv7, "gray_stained_glass_pane", 1, 28, " ");
        itemHandler.createItem(inv7, "red_stained_glass_pane", 1, 29, " ");
        itemHandler.createItem(inv7, "red_stained_glass_pane", 1, 30, " ");
        itemHandler.createItem(inv7, "red_stained_glass_pane", 1, 31, " ");
        itemHandler.createItem(inv7, "red_stained_glass_pane", 1, 32, " ");
        itemHandler.createItem(inv7, "red_stained_glass_pane", 1, 33, " ");
        itemHandler.createItem(inv7, "red_stained_glass_pane", 1, 34, " ");
        itemHandler.createItem(inv7, "red_stained_glass_pane", 1, 35, " ");
        itemHandler.createItem(inv7, "gray_stained_glass_pane", 1, 36, " ");
        itemHandler.createItem(inv7, "gray_stained_glass_pane", 1, 37, " ");
        itemHandler.createItem(inv7, "red_stained_glass_pane", 1, 38, " ");
        itemHandler.createItem(inv7, "red_stained_glass_pane", 1, 39, " ");
        itemHandler.createItem(inv7, "red_stained_glass_pane", 1, 40, " ");
        itemHandler.createItem(inv7, "red_stained_glass_pane", 1, 41, " ");
        itemHandler.createItem(inv7, "red_stained_glass_pane", 1, 42, " ");
        itemHandler.createItem(inv7, "red_stained_glass_pane", 1, 43, " ");
        itemHandler.createItem(inv7, "red_stained_glass_pane", 1, 44, " ");
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
                ChatColor.GRAY + "Burada seviye atlayarak", ChatColor.GRAY + "kazand??????n nitelik puanlar??n??",
                ChatColor.GRAY + "harcay??p daha da g????lenebilirsin.", "",
                ChatColor.GOLD + "Sahip Oldu??un Nitelik Puan??: " + ChatColor.RED + stats.getNP(p.getUniqueId()));
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
        itemHandler.createItem(inv14, "red_dye", 1, 29, Painter.paint("&6&lDin??lik"),
                Painter.paint("&7Puan ba????na &6Can??n?? &e+1 &7ve"), Painter.paint("&6Can Yenilenmeni &e+%1 &7artt??r??r."),
                "", Painter.paint("&8Din??lik can de??erinizi ve can yenilenmenizi belirler."),
                Painter.paint("&8Can de??eriniz sizi ayakta tutan ??eydir. Can yenilenmesi"),
                Painter.paint("&8ise al??nan hasardan sonra ne kadar h??zl?? iyile??ti??inizdir."), "",
                Painter.paint("&7Taban Din??lik: &f20 &7/ &f5"),
                Painter.paint("&7Toplam Din??lik: &f") + stats.getCan(p.getUniqueId()) + " &7/ &f"
                        + stats.getCanYenileme(p.getUniqueId()),
                "", Painter.paint("&7Nitelik Puan?? eklemek i??in &e&lSa?? T??kla."));
        itemHandler.createItem(inv14, "iron_chestplate", 1, 30, Painter.paint("&a&lDayan??kl??l??k"),
                Painter.paint("&7Puan ba????na &aZ??rh De??erini &e+1"),
                Painter.paint("&7ve &aDoygunlu??unu &e+%1 &7artt??r??r."), "",
                Painter.paint("&8Dayan??kl??k ald??????n??z hasar?? ve i?? yapma kapasitenizi belirler."),
                Painter.paint("&8Z??rh de??eriniz ne kadar y??ksekse al??nan hasar o kadar etkili olur,"),
                Painter.paint("&8doygunlu??unuz ne kadar y??ksekse i?? yaparken yorulmazs??n??z."), "",
                Painter.paint("&7Taban Dayan??kl??l??k: &f0 &7/ &f0"),
                Painter.paint("&7Toplam Dayan??kl??l??k: &f") + stats.getDirenc(p.getUniqueId()) + " &7/ &f"
                        + stats.getDoygunluk(p.getUniqueId()),
                "", Painter.paint("&7Nitelik Puan?? eklemek i??in &e&lSa?? T??kla."));
        itemHandler.createItem(inv14, "blaze_powder", 1, 31, Painter.paint("&c&lG????"),
                Painter.paint("&7Puan ba????na &cG??c??n?? &e+4 &7artt??r??r."), "",
                Painter.paint("&8G???? hasar kaynaklar??n??zdan biridir. Ne kadar "),
                Painter.paint("&8g????l??yseniz darbeleriniz de bir o kadar etkili olur."), "",
                Painter.paint("&7Taban G????: &f5"), Painter.paint("&7Toplam G????: &f") + stats.getGuc(p.getUniqueId()),
                "", Painter.paint("&7Nitelik Puan?? eklemek i??in &e&lSa?? T??kla."));
        itemHandler.createItem(inv14, "glowstone_dust", 1, 33, Painter.paint("&e&lDenge"),
                Painter.paint("&7Puan ba????na &eDengeni &e+2 &7artt??r??r."), "",
                Painter.paint("&8Denge daha seri bir ??ekilde sald??rabilmenizi sa??lar."),
                Painter.paint("&8Dengeli bir duru?? vuru??lar??n??z??n da dengeli olmas??n?? sa??lar."), "",
                Painter.paint("&7Taban Denge: &f0"),
                Painter.paint("&7Toplam Denge: &f") + stats.getSaldiriHizi(p.getUniqueId()), "",
                Painter.paint("&7Nitelik Puan?? eklemek i??in &e&lSa?? T??kla."));
        itemHandler.createItem(inv14, "feather", 1, 34, Painter.paint("&f&l??eviklik"),
                Painter.paint("&7Puan ba????na &f??evikli??ini &e+2 &7artt??r??r."), "",
                Painter.paint("&8??eviklik ne kadar seri hareket etti??inizdir. ??evikli??iniz "),
                Painter.paint("&8ne kadar y??ksekse o kadar h??zl?? hareket edersiniz."), "",
                Painter.paint("&7Taban ??eviklik: &f0"),
                Painter.paint("&7Toplam ??eviklik: &f") + stats.getHiz(p.getUniqueId()), "",
                Painter.paint("&7Nitelik Puan?? eklemek i??in &e&lSa?? T??kla."));
        itemHandler.createItem(inv14, "nether_star", 1, 35, Painter.paint("&3&lH??ner"),
                Painter.paint("&7Puan ba????na &3Kritik Hasar??n?? &e+1 &7artt??r??r."), "",
                Painter.paint("&8H??ner sava??ta kulland??????n??z silah?? daha iyi kullanman??z?? sa??lar."),
                Painter.paint("&8Silah??n?? iyi kullanan bir ki??i rakibin zay??f noktalar??n?? da g??rebilir."), "",
                Painter.paint("&7Taban H??ner: &f12 &7/ &f0"),
                Painter.paint("&7Toplam H??ner: &f") + stats.getKritikHasari(p.getUniqueId()) + " &7/ &f"
                        + stats.getKritikSansi(p.getUniqueId()),
                "", Painter.paint("&7Nitelik Puan?? eklemek i??in &e&lSa?? T??kla."));
        if (stats.getharcananNP(p.getUniqueId()) > 3) {
            int harcanannp = stats.getharcananNP(p.getUniqueId()) - 3;
            itemHandler.createItem(inv14, "barrier", 1, 23, Painter.paint("&4Niteliklerini S??f??rla!"),
                    Painter.paint("&7Niteliklerini s??f??rlamak harcad??????n puanlar?? sana geri"),
                    Painter.paint("&7kazand??r??r. Fakat 50 Seviyen yok olur."), "",
                    Painter.paint("&fKazan??lacak Nitelik Puanlar??: &a" + harcanannp), "",
                    Painter.paint("&7Niteliklerini s??f??rlamak i??in &e&lSa?? T??kla."));
        } else {
            itemHandler.createItem(inv14, "barrier", 1, 23, Painter.paint("&4Niteliklerini S??f??rla!"),
                    Painter.paint("&7Niteliklerini s??f??rlamak harcad??????n puanlar?? sana geri"),
                    Painter.paint("&7kazand??r??r. Fakat 50 Seviyen yok olur."), "",
                    Painter.paint("&fKazan??lacak Nitelik Puanlar??: &a" + 0), "",
                    Painter.paint("&7Niteliklerini s??f??rlamak i??in &e&lSa?? T??kla."));
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
        if (p != profil) {
            itemHandler.createItem(inv12, "player_head", 1, 11,
                    Painter.paint("&3" + profil.getName() + " ??simli Karakterin Bilgileri"),
                    Painter.paint("&7??sim: &f" + profil.getName()),
                    Painter.paint("&7Meslek: &6" + stats.getMeslek(profil.getUniqueId())),
                    Painter.paint("&7Seviye: &b" + stats.getLevel(profil.getUniqueId())),
                    Painter.paint("&7Seviye ??lerlemesi: &b" + stats.getExp(profil.getUniqueId())) + " / " + stats.getRequiredExp(profil.getUniqueId()),
                    "",
                    Painter.paint(" &6??? Din??lik: &f") + stats.getCan(profil.getUniqueId()) + " &7/&f "
                            + stats.getCanYenileme(profil.getUniqueId()),
                    Painter.paint(" &8&oDin??lik = Can/Can Yenilenmesi."),
                    Painter.paint(" &a???? Dayan??kl??l??k: &f") + stats.getDirenc(profil.getUniqueId()) + " &7/&f "
                            + stats.getDoygunluk(profil.getUniqueId()),
                    Painter.paint(" &8&oDayan??kl??l??k = Diren??/Doygunluk."),
                    Painter.paint(" &c??? G????: &f") + stats.getGuc(profil.getUniqueId()),
                    Painter.paint(" &e??? Denge: &f") + stats.getSaldiriHizi(profil.getUniqueId()),
                    Painter.paint(" &8&oDenge = Sald??r?? H??z??"),
                    Painter.paint(" &f???? ??eviklik: &f") + stats.getHiz(profil.getUniqueId()),
                    Painter.paint(" &3??? H??ner: &f") + stats.getKritikHasari(profil.getUniqueId()) + " &7/&f "
                            + stats.getKritikSansi(profil.getUniqueId()),
                    Painter.paint(" &8&oH??ner = Kritik Hasar??/Kritik Hasar ??ans??"),
                    Painter.paint(" &b??? Soguk Direnci: &f") + stats.getSogukDirenci(profil.getUniqueId()),
                    Painter.paint(" &4???? S??cak Direnci: &f") + stats.getSicakDirenci(profil.getUniqueId()),
                    Painter.paint(" &5??? Hiclik Direnci: &f") + stats.getHiclikDirenci(profil.getUniqueId()), "");
        } else {
            itemHandler.createItem(inv12, "player_head", 1, 11, Painter.paint("&3Karakter Bilgileri"),
                    Painter.paint("&7??sim: &f" + p.getName()),
                    Painter.paint("&7Meslek: &6" + stats.getMeslek(p.getUniqueId())),
                    Painter.paint("&7Seviye: &b" + stats.getLevel(p.getUniqueId())),
                    Painter.paint("&7Seviye ??lerlemesi: &b" + stats.getExp(p.getUniqueId())) + " / " + stats.getRequiredExp(p.getUniqueId()),
                    "",
                    Painter.paint(" &6??? Din??lik: &f") + stats.getCan(p.getUniqueId()) + " &7/&f "
                            + stats.getCanYenileme(p.getUniqueId()),
                    Painter.paint(" &8&oDin??lik = Can/Can Yenilenmesi."),
                    Painter.paint(" &a???? Dayan??kl??l??k: &f") + stats.getDirenc(p.getUniqueId()) + " &7/&f "
                            + stats.getDoygunluk(p.getUniqueId()),
                    Painter.paint(" &8&oDayan??kl??l??k = Diren??/Doygunluk."),
                    Painter.paint(" &c??? G????: &f") + stats.getGuc(p.getUniqueId()),
                    Painter.paint(" &e??? Denge: &f") + stats.getSaldiriHizi(p.getUniqueId()),
                    Painter.paint(" &8&oDenge = Sald??r?? H??z??"),
                    Painter.paint(" &f???? ??eviklik: &f") + stats.getHiz(p.getUniqueId()),
                    Painter.paint(" &3??? H??ner: &f") + stats.getKritikHasari(p.getUniqueId()) + " &7/&f "
                            + stats.getKritikSansi(p.getUniqueId()),
                    Painter.paint(" &8&oH??ner = Kritik Hasar??/Kritik Hasar ??ans??"),
                    Painter.paint(" &b??? Soguk Direnci: &f") + stats.getSogukDirenci(p.getUniqueId()),
                    Painter.paint(" &4???? S??cak Direnci: &f") + stats.getSicakDirenci(p.getUniqueId()),
                    Painter.paint(" &5??? Hiclik Direnci: &f") + stats.getHiclikDirenci(p.getUniqueId()), "");
        }
        itemHandler.createItem(inv12, "gray_stained_glass_pane", 1, 12, " ");
        itemHandler.createItem(inv12, "gray_stained_glass_pane", 1, 13, " ");
        if (profil.getInventory().getHelmet() == null) {
            itemHandler.createItem(inv12, "red_stained_glass_pane", 1, 14, Painter.paint("&eBo?? Mi??fer B??lmesi"));
        }
        itemHandler.createItem(inv12, "gray_stained_glass_pane", 1, 15, " ");
        itemHandler.createItem(inv12, "gray_stained_glass_pane", 1, 16, " ");
        itemHandler.createItem(inv12, "wooden_pickaxe", 1, 17, Painter.paint("&6Sivil Rozeti"),
                Painter.paint("&7Remiel halk??n??n??n bir par??as?? oldu??un i??in."));
        itemHandler.createItem(inv12, "gray_stained_glass_pane", 1, 18, " ");
        itemHandler.createItem(inv12, "gray_stained_glass_pane", 1, 19, " ");
        itemHandler.createItem(inv12, "red_stained_glass_pane", 1, 20, " ");
        itemHandler.createItem(inv12, "gray_stained_glass_pane", 1, 21, " ");
        if (stats.getKolye(profil.getUniqueId()).equals("Yok..")) {
            itemHandler.createItem(inv12, "red_stained_glass_pane", 1, 22, Painter.paint("&eBo?? Kolye B??lmesi"));
        }
        if (profil.getInventory().getChestplate() == null) {
            itemHandler.createItem(inv12, "red_stained_glass_pane", 1, 23, Painter.paint("&eBo?? G??????sl??k B??lmesi"));
        }
        if (stats.getTilsim(profil.getUniqueId()).equals("Yok..")) {
            itemHandler.createItem(inv12, "red_stained_glass_pane", 1, 24,
                    Painter.paint("&eBo?? T??ls??m/Ok K??l??f?? B??lmesi"));
        }
        itemHandler.createItem(inv12, "gray_stained_glass_pane", 1, 25, " ");
        itemHandler.createItem(inv12, "red_stained_glass_pane", 1, 26, Painter.paint("&6Bo?? Rozet B??lmesi"));
        itemHandler.createItem(inv12, "gray_stained_glass_pane", 1, 27, " ");
        itemHandler.createItem(inv12, "gray_stained_glass_pane", 1, 28, " ");
        itemHandler.createItem(inv12, "red_stained_glass_pane", 1, 29, " ");
        itemHandler.createItem(inv12, "gray_stained_glass_pane", 1, 30, " ");
        if (stats.getEldiven(profil.getUniqueId()).equals("Yok..")) {
            itemHandler.createItem(inv12, "red_stained_glass_pane", 1, 31, Painter.paint("&eBo?? Eldiven B??lmesi"));
        }
        if (profil.getInventory().getLeggings() == null) {
            itemHandler.createItem(inv12, "red_stained_glass_pane", 1, 32, Painter.paint("&eBo?? Pantolon B??lmesi"));
        }
        if (stats.getYuzuk(profil.getUniqueId()).equals("Yok..")) {
            itemHandler.createItem(inv12, "red_stained_glass_pane", 1, 33, Painter.paint("&eBo?? Y??z??k B??lmesi"));
        }
        itemHandler.createItem(inv12, "gray_stained_glass_pane", 1, 34, " ");
        itemHandler.createItem(inv12, "red_stained_glass_pane", 1, 35, Painter.paint("&6Bo?? Rozet B??lmesi"));
        itemHandler.createItem(inv12, "gray_stained_glass_pane", 1, 36, " ");
        itemHandler.createItem(inv12, "gray_stained_glass_pane", 1, 37, " ");
        itemHandler.createItem(inv12, "red_stained_glass_pane", 1, 38, " ");
        itemHandler.createItem(inv12, "gray_stained_glass_pane", 1, 39, " ");
        itemHandler.createItem(inv12, "dirt", 1, 40, Painter.paint("&eBo?? Sa?? El"));

        if (profil.getInventory().getBoots() == null) {
            itemHandler.createItem(inv12, "red_stained_glass_pane", 1, 41, Painter.paint("&eBo?? Bot B??lmesi"));
        }
        itemHandler.createItem(inv12, "dirt", 1, 42, Painter.paint("&eBo?? Sol El"));

        itemHandler.createItem(inv12, "gray_stained_glass_pane", 1, 43, " ");
        itemHandler.createItem(inv12, "red_stained_glass_pane", 1, 44, Painter.paint("&6Bo?? Rozet B??lmesi"));
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
        itemHandler.createItem(inv10, "anvil", 1, 5, ChatColor.WHITE + "??rs",
                ChatColor.GRAY + "Burada elindeki ekipman?? ba??ka",
                ChatColor.GRAY + "bir b??y?? ve benzeri bir ??eyle kombinleyerek",
                ChatColor.GRAY + "ekipmana ek ??zellik ekleyebilirsin.", "",
                ChatColor.GOLD + "Demircilikte Ustal??????n: " + ChatColor.GREEN + smithLevel);
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
        Inventory toReturn = Bukkit.createInventory((InventoryHolder) null, this.inv_rows4, this.inventory_name16);
        ArrayList var10000 = (ArrayList) this.stats.getHepsi(p.getUniqueId());
        this.itemHandler.createItem(this.inv16, "white_stained_glass_pane", 1, 1, " ", new String[0]);
        this.itemHandler.createItem(this.inv16, "white_stained_glass_pane", 1, 2, " ", new String[0]);
        this.itemHandler.createItem(this.inv16, "white_stained_glass_pane", 1, 3, " ", new String[0]);
        this.itemHandler.createItem(this.inv16, "white_stained_glass_pane", 1, 4, " ", new String[0]);
        this.itemHandler.createItem(this.inv16, "item_frame", 1, 5, ChatColor.WHITE + "Aksesuarlar??n", new String[]{ChatColor.GRAY + "Burada aksesuarlar??n?? tak??p ????karabilir", ChatColor.GRAY + "ve aksesuarlar??n??n ??zelliklerini g??rebilirsin."});
        this.itemHandler.createItem(this.inv16, "white_stained_glass_pane", 1, 6, " ", new String[0]);
        this.itemHandler.createItem(this.inv16, "white_stained_glass_pane", 1, 7, " ", new String[0]);
        this.itemHandler.createItem(this.inv16, "white_stained_glass_pane", 1, 8, " ", new String[0]);
        this.itemHandler.createItem(this.inv16, "white_stained_glass_pane", 1, 9, " ", new String[0]);
        this.itemHandler.createItem(this.inv16, "black_stained_glass_pane", 1, 10, " ", new String[0]);
        this.itemHandler.createItem(this.inv16, "black_stained_glass_pane", 1, 11, " ", new String[0]);
        this.itemHandler.createItem(this.inv16, "black_stained_glass_pane", 1, 12, " ", new String[0]);
        this.itemHandler.createItem(this.inv16, "black_stained_glass_pane", 1, 13, " ", new String[0]);
        this.itemHandler.createItem(this.inv16, "black_stained_glass_pane", 1, 14, " ", new String[0]);
        this.itemHandler.createItem(this.inv16, "black_stained_glass_pane", 1, 15, " ", new String[0]);
        this.itemHandler.createItem(this.inv16, "black_stained_glass_pane", 1, 16, " ", new String[0]);
        this.itemHandler.createItem(this.inv16, "black_stained_glass_pane", 1, 17, " ", new String[0]);
        this.itemHandler.createItem(this.inv16, "black_stained_glass_pane", 1, 18, " ", new String[0]);
        if (this.stats.getTilsim(p.getUniqueId()).equals("<dark_gray>Yok..")) {
            this.itemHandler.createItem(this.inv16, "magenta_stained_glass_pane", 1, 29, ChatColor.LIGHT_PURPLE + "T??ls??m/Ok K??l??f??", new String[]{ChatColor.DARK_GRAY + "Yok.."});
        }

        if (this.stats.getEldiven(p.getUniqueId()).equals("<dark_gray>Yok..")) {
            this.itemHandler.createItem(this.inv16, "blue_stained_glass_pane", 1, 31, ChatColor.BLUE + "Eldiven", new String[]{ChatColor.DARK_GRAY + "Yok.."});
        }

        if (this.stats.getKolye(p.getUniqueId()).equals("<dark_gray>Yok..")) {
            this.itemHandler.createItem(this.inv16, "yellow_stained_glass_pane", 1, 33, ChatColor.YELLOW + "Kolye", new String[]{ChatColor.DARK_GRAY + "Yok.."});
        }

        if (this.stats.getYuzuk(p.getUniqueId()).equals("<dark_gray>Yok..")) {
            this.itemHandler.createItem(this.inv16, "orange_stained_glass_pane", 1, 35, ChatColor.GOLD + "Y??z??k", new String[]{ChatColor.DARK_GRAY + "Yok.."});
        }

        toReturn.setContents(this.inv16.getContents());
        return toReturn;
    }


    public Inventory ayarmenu(Player p) {
        Inventory toReturn = Bukkit.createInventory(null, inv_rows4, inventory_name15);

        itemHandler.createItem(inv15, "white_stained_glass_pane", 1, 1, " ");
        itemHandler.createItem(inv15, "white_stained_glass_pane", 1, 2, " ");
        itemHandler.createItem(inv15, "white_stained_glass_pane", 1, 3, " ");
        itemHandler.createItem(inv15, "white_stained_glass_pane", 1, 4, " ");
        itemHandler.createItem(inv15, "comparator", 1, 5, ChatColor.WHITE + "Ayarlar",
                ChatColor.GRAY + "Burada oyun i??i ayarlar?? aktif", ChatColor.GRAY + "veya deaktif edebilirsin");
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
            itemHandler.createItem(inv15, "sunflower", 1, 31, ChatColor.GRAY + "??oklu Vuru?? Ses Efekti",
                    ChatColor.DARK_GREEN + "Aktif",
                    ChatColor.DARK_GRAY + "" + ChatColor.ITALIC + "(Sald??r?? H??z??ndan Gelen ??oklu Vuru??)");
        } else {
            itemHandler.createItem(inv15, "sunflower", 1, 31, ChatColor.GRAY + "??oklu Vuru?? Ses Efekti",
                    ChatColor.DARK_RED + "Deaktif",
                    ChatColor.DARK_GRAY + "" + ChatColor.ITALIC + "(Sald??r?? H??z??ndan Gelen ??oklu Vuru??)");
        }
        if (stats.getYaprakAyar(p.getUniqueId())) {
            itemHandler.createItem(inv15, "oak_leaves", 1, 33, ChatColor.GRAY + "A??a??lardan Yaprak D????me Animasyonu",
                    ChatColor.DARK_GREEN + "Aktif");
        } else {
            itemHandler.createItem(inv15, "oak_leaves", 1, 33, ChatColor.GRAY + "A??a??lardan Yaprak D????me Animasyonu",
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
        int WorkLevel = stats.getWorkLevel(p.getUniqueId());
        int WorkExp = stats.getWorkExp(p.getUniqueId());
        int WorkRequiredExp = stats.getWorkRequiredExp(p.getUniqueId());
        int progAlchemy = alchemyRequiredExp - alchemyExp;
        int progFarming = FarmingRequiredExp - FarmingExp;
        int progEnch = enchRequiredExp - enchExp;
        int progSmith = smithRequiredExp - smithExp;
        int progCooking = cookRequiredExp - cookExp;
        int progMining = miningRequiredExp - miningExp;
        int progFishing = fishingRequiredExp - fishingExp;
        int progCombat = combatRequiredExp - combatExp;
        int progOduncu = odunculukRequiredExp - odunculukExp;
        int progWork = WorkRequiredExp - WorkExp;
        String meslek = stats.getMeslek(p.getUniqueId());
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
        itemHandler.createItem(inv2, "iron_sword", 1, 12, ChatColor.DARK_AQUA + "Avc??l??k",
                ChatColor.GREEN + "Ustal??k " + combatLevel, "",
                ChatColor.GOLD + "Tecr??be: " + ChatColor.WHITE + combatExp,
                ChatColor.GOLD + "Gereken Tecr??be Puan??: " + ChatColor.WHITE + progCombat, "",
                ChatColor.GRAY + "Meslek bilgileri i??in " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv2, "iron_pickaxe", 1, 13, ChatColor.DARK_AQUA + "Madencilik",
                ChatColor.GREEN + "Ustal??k " + miningLevel, "",
                ChatColor.GOLD + "Tecr??be: " + ChatColor.WHITE + miningExp,
                ChatColor.GOLD + "Gereken Tecr??be Puan??: " + ChatColor.WHITE + progMining, "",
                ChatColor.GRAY + "Meslek bilgileri i??in " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv2, "iron_axe", 1, 14, ChatColor.DARK_AQUA + "Odunculuk",
                ChatColor.GREEN + "Ustal??k " + odunculukLevel, "",
                ChatColor.GOLD + "Tecr??be: " + ChatColor.WHITE + odunculukExp,
                ChatColor.GOLD + "Gereken Tecr??be Puan??: " + ChatColor.WHITE + progOduncu, "",
                ChatColor.GRAY + "Meslek bilgileri i??in " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv2, "fishing_rod", 1, 15, ChatColor.DARK_AQUA + "Bal??k????l??k",
                ChatColor.GREEN + "Ustal??k " + fishingLevel, "",
                ChatColor.GOLD + "Tecr??be: " + ChatColor.WHITE + fishingExp,
                ChatColor.GOLD + "Gereken Tecr??be Puan??: " + ChatColor.WHITE + progFishing, "",
                ChatColor.GRAY + "Meslek bilgileri i??in " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv2, "smithing_table", 1, 16, ChatColor.DARK_AQUA + "Demircilik",
                ChatColor.GREEN + "Ustal??k " + smithLevel, "",
                ChatColor.GOLD + "Tecr??be: " + ChatColor.WHITE + smithExp,
                ChatColor.GOLD + "Gereken Tecr??be Puan??: " + ChatColor.WHITE + progSmith, "",
                ChatColor.GRAY + "Meslek bilgileri i??in " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv2, "gray_stained_glass_pane", 1, 17, " ");
        itemHandler.createItem(inv2, "gray_stained_glass_pane", 1, 18, " ");
        itemHandler.createItem(inv2, "gray_stained_glass_pane", 1, 19, " ");
        itemHandler.createItem(inv2, "gray_stained_glass_pane", 1, 20, " ");
        itemHandler.createItem(inv2, "gray_stained_glass_pane", 1, 21, " ");
        itemHandler.createItem(inv2, "bread", 1, 22, ChatColor.DARK_AQUA + "A??????l??k",
                ChatColor.GREEN + "Ustal??k " + cookLevel, "", ChatColor.GOLD + "Tecr??be: " + ChatColor.WHITE + cookExp,
                ChatColor.GOLD + "Gereken Tecr??be Puan??: " + ChatColor.WHITE + progCooking, "",
                ChatColor.GRAY + "Meslek bilgileri i??in " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv2, "brewing_stand", 1, 23, ChatColor.DARK_AQUA + "Simyac??l??k",
                ChatColor.GREEN + "Ustal??k " + alchemyLevel, "",
                ChatColor.GOLD + "Tecr??be: " + ChatColor.WHITE + alchemyExp,
                ChatColor.GOLD + "Gereken Tecr??be Puan??: " + ChatColor.WHITE + progAlchemy, "",
                ChatColor.GRAY + "Meslek bilgileri i??in " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv2, "enchanting_table", 1, 24, ChatColor.DARK_AQUA + "B??y??c??l??k",
                ChatColor.GREEN + "Ustal??k " + enchLevel, "", ChatColor.GOLD + "Tecr??be: " + ChatColor.WHITE + enchExp,
                ChatColor.GOLD + "Gereken Tecr??be Puan??: " + ChatColor.WHITE + progEnch, "",
                ChatColor.GRAY + "Meslek bilgileri i??in " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
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
        itemHandler.createItem(inv2, "wheat", 1, 31, ChatColor.DARK_AQUA + "??ift??ilik",
                ChatColor.GREEN + "Ustal??k " + FarmingLevel, "",
                ChatColor.GOLD + "Tecr??be: " + ChatColor.WHITE + FarmingExp,
                ChatColor.GOLD + "Gereken Tecr??be Puan??: " + ChatColor.WHITE + progFarming, "",
                ChatColor.GRAY + "Meslek bilgileri i??in " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv2, "fletching_table", 1, 33, ChatColor.DARK_AQUA + "El Sanatlar??",
                ChatColor.GREEN + "Ustal??k " + WorkLevel, "",
                ChatColor.GOLD + "Tecr??be: " + ChatColor.WHITE + WorkExp,
                ChatColor.GOLD + "Gereken Tecr??be Puan??: " + ChatColor.WHITE + progWork, "",
                ChatColor.GRAY + "Meslek bilgileri i??in " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv2, "gray_stained_glass_pane", 1, 42, " ");
        itemHandler.createItem(inv2, "gray_stained_glass_pane", 1, 43, " ");
        itemHandler.createItem(inv2, "gray_stained_glass_pane", 1, 44, " ");
        itemHandler.createItem(inv2, "barrier", 1, 45, ChatColor.RED + "Mesle??ini S??f??rla!",
                ChatColor.GRAY + "Buradan mesle??ini s??f??rlayabilirsin.",
                ChatColor.GOLD + "??u anki mesle??in: " + ChatColor.GREEN + meslek);

        toReturn.setContents(inv2.getContents());
        return toReturn;
    }

    public Inventory realFurnaceGui(Player p) {
        Inventory toReturn = Bukkit.createInventory(null, inv_rows3, inventory_name22);

        itemHandler.createItem(inv24, "white_stained_glass_pane", 1, 1, " ");
        itemHandler.createItem(inv24, "white_stained_glass_pane", 1, 2, " ");
        itemHandler.createItem(inv24, "white_stained_glass_pane", 1, 3, " ");
        itemHandler.createItem(inv24, "white_stained_glass_pane", 1, 4, " ");
        itemHandler.createItem(inv24, "furnace", 1, 5, ChatColor.WHITE + "F??r??n",
                ChatColor.GRAY + "Burada elindeki malzemelerle", ChatColor.GRAY + "elde edebilece??in yeni malzemelere bakabilir",
                ChatColor.GRAY + "ve onlar?? pi??irebilirsin.");
        itemHandler.createItem(inv24, "white_stained_glass_pane", 1, 6, " ");
        itemHandler.createItem(inv24, "white_stained_glass_pane", 1, 7, " ");
        itemHandler.createItem(inv24, "white_stained_glass_pane", 1, 8, " ");
        itemHandler.createItem(inv24, "chest", 1, 9, ChatColor.GOLD + "F??r??n Deposu",
                ChatColor.GRAY + "Buradan pi??irdi??in malzemeleri alabilirsin.",
                ChatColor.GRAY + "A??mak i??in " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv24, "black_stained_glass_pane", 1, 10, " ");
        itemHandler.createItem(inv24, "black_stained_glass_pane", 1, 11, " ");
        itemHandler.createItem(inv24, "black_stained_glass_pane", 1, 12, " ");
        itemHandler.createItem(inv24, "black_stained_glass_pane", 1, 13, " ");
        itemHandler.createItem(inv24, "black_stained_glass_pane", 1, 14, " ");
        itemHandler.createItem(inv24, "black_stained_glass_pane", 1, 15, " ");
        itemHandler.createItem(inv24, "black_stained_glass_pane", 1, 16, " ");
        itemHandler.createItem(inv24, "black_stained_glass_pane", 1, 17, " ");
        itemHandler.createItem(inv24, "black_stained_glass_pane", 1, 18, " ");
        itemHandler.createItem(inv24, "glass", 1, 19, ChatColor.YELLOW + "Cam", ChatColor.GREEN + "Ustal??k 1",
                "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Kum",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 K??m??r", "",
                ChatColor.GRAY + "Pi??irmeye ba??lamak i??in ", ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv24, "brick", 1, 20, ChatColor.YELLOW + "Tu??la", ChatColor.GREEN + "Ustal??k 1",
                "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Kil",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 K??m??r", "",
                ChatColor.GRAY + "Pi??irmeye ba??lamak i??in ", ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv24, "coal", 1, 21, ChatColor.YELLOW + "K??m??r",
                ChatColor.GREEN + "Ustal??k 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 Me??e Odunu",
                ChatColor.GRAY + "Pi??irmeye ba??lamak i??in ", ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        toReturn.setContents(inv24.getContents());
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
                ChatColor.GRAY + "Burada elindeki malzemelerle", ChatColor.GRAY + "yapabilece??in yemeklere bakabilir",
                ChatColor.GRAY + "ve onlar?? pi??irebilirsin.", "",
                ChatColor.GOLD + "A??????l??kta Ustal??????n: " + ChatColor.GREEN + cookLevel);
        itemHandler.createItem(inv3, "white_stained_glass_pane", 1, 6, " ");
        itemHandler.createItem(inv3, "white_stained_glass_pane", 1, 7, " ");
        itemHandler.createItem(inv3, "white_stained_glass_pane", 1, 8, " ");
        itemHandler.createItem(inv3, "barrel", 1, 9, ChatColor.GOLD + "Ocak Deposu",
                ChatColor.GRAY + "Buradan pi??irdi??in malzemeleri alabilirsin.",
                ChatColor.GRAY + "A??mak i??in " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv3, "black_stained_glass_pane", 1, 10, " ");
        itemHandler.createItem(inv3, "black_stained_glass_pane", 1, 11, " ");
        itemHandler.createItem(inv3, "black_stained_glass_pane", 1, 12, " ");
        itemHandler.createItem(inv3, "black_stained_glass_pane", 1, 13, " ");
        itemHandler.createItem(inv3, "black_stained_glass_pane", 1, 14, " ");
        itemHandler.createItem(inv3, "black_stained_glass_pane", 1, 15, " ");
        itemHandler.createItem(inv3, "black_stained_glass_pane", 1, 16, " ");
        itemHandler.createItem(inv3, "black_stained_glass_pane", 1, 17, " ");
        itemHandler.createItem(inv3, "black_stained_glass_pane", 1, 18, " ");
        itemHandler.createItem(inv3, "bread", 1, 19, ChatColor.YELLOW + "Ekmek", ChatColor.GREEN + "Ustal??k 1", "",
                ChatColor.GRAY + " Gerekli Malzemeler:", ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Bu??day", "",
                ChatColor.GRAY + "Pi??irmeye ba??lamak i??in ", ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv3, "baked_potato", 1, 20, ChatColor.YELLOW + "Pi??mi?? Patates", ChatColor.GREEN + "Ustal??k 1",
                "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Patates",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 K??m??r", "",
                ChatColor.GRAY + "Pi??irmeye ba??lamak i??in ", ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv3, "cooked_porkchop", 1, 21, ChatColor.YELLOW + "Domuz Past??rmas??",
                ChatColor.GREEN + "Ustal??k 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 ??i?? Domuz Eti",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 K??m??r", "",
                ChatColor.GRAY + "Pi??irmeye ba??lamak i??in ", ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv3, "cooked_cod", 1, 22, ChatColor.YELLOW + "Pi??mi?? Morina",
                ChatColor.GREEN + "Ustal??k 2", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 ??i?? Morina",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 K??m??r", "",
                ChatColor.GRAY + "Pi??irmeye ba??lamak i??in ", ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv3, "cooked_salmon", 1, 23, ChatColor.YELLOW + "Pi??mi?? Somon",
                ChatColor.GREEN + "Ustal??k 2", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 ??i?? Somon",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 K??m??r", "",
                ChatColor.GRAY + "Pi??irmeye ba??lamak i??in ", ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv3, "cooked_mutton", 1, 24, ChatColor.YELLOW + "Pi??mi?? Koyun Budu", ChatColor.GREEN + "Ustal??k 2",
                "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 ??i?? Koyun Eti",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 K??m??r", "",
                ChatColor.GRAY + "Pi??irmeye ba??lamak i??in ", ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv3, "cooked_beef", 1, 25, ChatColor.YELLOW + "Biftek", ChatColor.GREEN + "Ustal??k 2",
                "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 ??i?? K??rm??z?? Eti",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 K??m??r", "",
                ChatColor.GRAY + "Pi??irmeye ba??lamak i??in ", ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv3, "cooked_chicken", 1, 26, ChatColor.YELLOW + "Pi??mi?? Tavuk Eti", ChatColor.GREEN + "Ustal??k 2",
                "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 ??i?? Tavuk Eti",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 K??m??r", "",
                ChatColor.GRAY + "Pi??irmeye ba??lamak i??in ", ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv3, "cooked_cod", 1, 27, ChatColor.YELLOW + "Pi??mi?? G??m???? Bal??????", ChatColor.GREEN + "Ustal??k 2",
                "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 G??m???? Bal??????",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 K??m??r", "",

                ChatColor.GRAY + "Pi??irmeye ba??lamak i??in ", ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv3, "cooked_beef", 1, 28, ChatColor.YELLOW + "Pi??mi?? Antrikot", ChatColor.GREEN + "Ustal??k 2",
                "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 ??i?? K??rm??z?? Et",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 K??m??r",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 Tuz", "",
                ChatColor.GRAY + "Pi??irmeye ba??lamak i??in ", ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
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
                ChatColor.GRAY + "Burada elindeki malzemelerle", ChatColor.GRAY + "yapabilece??in yemeklere bakabilir",
                ChatColor.GRAY + "ve onlar?? pi??irebilirsin.", "",
                ChatColor.GOLD + "A??????l??kta Ustal??????n: " + ChatColor.GREEN + cookLevel);
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

    public Inventory bilgikitab??(Player p) {
        Inventory toReturn = Bukkit.createInventory((InventoryHolder)null, this.inv_rows4, this.inventory_name13);
        this.itemHandler.createItem(this.inv13, "white_stained_glass_pane", 1, 1, " ", new String[0]);
        this.itemHandler.createItem(this.inv13, "white_stained_glass_pane", 1, 2, " ", new String[0]);
        this.itemHandler.createItem(this.inv13, "white_stained_glass_pane", 1, 3, " ", new String[0]);
        this.itemHandler.createItem(this.inv13, "white_stained_glass_pane", 1, 4, " ", new String[0]);
        this.itemHandler.createItem(this.inv13, "knowledge_book", 1, 5, ChatColor.AQUA + "El Kitab??n", new String[]{ChatColor.GRAY + "Buradan aksesuar tak??p ????karabilir, baz?? ayarlar?? ", ChatColor.GRAY + "d??zenleyebilir ve daha bir ??ok ??eyi kontrol edebilirsin."});
        this.itemHandler.createItem(this.inv13, "white_stained_glass_pane", 1, 6, " ", new String[0]);
        this.itemHandler.createItem(this.inv13, "white_stained_glass_pane", 1, 7, " ", new String[0]);
        this.itemHandler.createItem(this.inv13, "white_stained_glass_pane", 1, 8, " ", new String[0]);
        this.itemHandler.createItem(this.inv13, "white_stained_glass_pane", 1, 9, " ", new String[0]);
        this.itemHandler.createItem(this.inv13, "black_stained_glass_pane", 1, 10, " ", new String[0]);
        this.itemHandler.createItem(this.inv13, "black_stained_glass_pane", 1, 11, " ", new String[0]);
        this.itemHandler.createItem(this.inv13, "black_stained_glass_pane", 1, 12, " ", new String[0]);
        this.itemHandler.createItem(this.inv13, "black_stained_glass_pane", 1, 13, " ", new String[0]);
        this.itemHandler.createItem(this.inv13, "black_stained_glass_pane", 1, 14, " ", new String[0]);
        this.itemHandler.createItem(this.inv13, "black_stained_glass_pane", 1, 15, " ", new String[0]);
        this.itemHandler.createItem(this.inv13, "black_stained_glass_pane", 1, 16, " ", new String[0]);
        this.itemHandler.createItem(this.inv13, "black_stained_glass_pane", 1, 17, " ", new String[0]);
        this.itemHandler.createItem(this.inv13, "black_stained_glass_pane", 1, 18, " ", new String[0]);
        this.itemHandler.createItem(this.inv13, "comparator", 1, 29, ChatColor.GRAY + "Ayarlar", new String[]{ChatColor.WHITE + "A??mak i??in " + ChatColor.YELLOW + "Sa?? T??kla."});
        this.itemHandler.createItem(this.inv13, "book", 1, 30, ChatColor.YELLOW + "G??rev Defteri", new String[]{ChatColor.WHITE + "Buradan g??revlerini takip edebilirsin. ", "", ChatColor.GRAY + "A??mak i??in " + ChatColor.YELLOW + ChatColor.BOLD + "Sa?? T??kla."});
        this.itemHandler.createItem(this.inv13, "experience_bottle", 1, 31, ChatColor.RED + "Niteliklerin", new String[]{ChatColor.WHITE + "Buradan nitelik puanlar??n?? harcayabilir ", ChatColor.WHITE + "ve g??c??ne g???? katabilirsin!", "", Painter.paint("&7Sahip Oldu??un Nitelik Puan??: &c") + this.stats.getNP(p.getUniqueId()), "", ChatColor.GRAY + "A??mak i??in " + ChatColor.YELLOW + ChatColor.BOLD + "Sa?? T??kla."});
        this.itemHandler.createItem(this.inv13, "crafting_table", 1, 32, ChatColor.YELLOW + "??al????ma Alan??", new String[]{ChatColor.WHITE + "Buradan e??ya ??retebilirsin. ", "", ChatColor.GRAY + "A??mak i??in " + ChatColor.YELLOW + ChatColor.BOLD + "Sa?? T??kla."});
        this.itemHandler.createItem3(this.inv13, "item_frame", 1, 33, ChatColor.GOLD + "Aksesuarlar??n", new Component[]{MiniMessage.miniMessage().deserialize("<white><i:false>Buradan aksesuarlar??n?? ve ekipmanlar??n??"), MiniMessage.miniMessage().deserialize("<white><i:false>y??netebilirsin."), MiniMessage.miniMessage().deserialize(""), MiniMessage.miniMessage().deserialize("<gray><i:false>Aksesuarlar kullan??c??s??na belirli"), MiniMessage.miniMessage().deserialize("<gray><i:false>??zellikler bah??eden ekipmanlard??r."), MiniMessage.miniMessage().deserialize(""), MiniMessage.miniMessage().deserialize("<white><i:false>Kullan??lan Aksesuarlar:"), MiniMessage.miniMessage().deserialize(" <light_purple><i:false>T??ls??m/Ok K??l??f??: <dark_gray><i:false>").append(MiniMessage.miniMessage().deserialize(this.stats.getTilsim(p.getUniqueId()))), MiniMessage.miniMessage().deserialize(" <blue><i:false>Eldiven: <dark_gray><i:false>").append(MiniMessage.miniMessage().deserialize(this.stats.getEldiven(p.getUniqueId()))), MiniMessage.miniMessage().deserialize(" <yellow><i:false>Kolye: <dark_gray><i:false>").append(MiniMessage.miniMessage().deserialize(this.stats.getKolye(p.getUniqueId()))), MiniMessage.miniMessage().deserialize(" <gold><i:false>Y??z??k: <dark_gray><i:false>").append(MiniMessage.miniMessage().deserialize(this.stats.getYuzuk(p.getUniqueId()))), MiniMessage.miniMessage().deserialize(""), MiniMessage.miniMessage().deserialize("<gray><i:false>Aksesuarlar??n?? ????karmak i??in <yellow><bold><i:false>Sa?? T??kla.")});
        this.itemHandler.createItem(this.inv13, "campfire", 1, 34, ChatColor.YELLOW + "Oldu??un B??lgeyi Sahiplen", new String[]{ChatColor.WHITE + "Buradan gerekli malzemeleri vererek", "", ChatColor.GRAY + "oldu??un b??gleyi sahiplenebilirsin. A??mak i??in " + ChatColor.YELLOW + ChatColor.BOLD + "Sa?? T??kla."});
        this.itemHandler.createItem(this.inv13, "sunflower", 1, 35, ChatColor.YELLOW + "Rozetlerin", new String[]{ChatColor.WHITE + "Buradan rozetlerini y??netebilirsin. ", "", ChatColor.GRAY + "A??mak i??in " + ChatColor.YELLOW + ChatColor.BOLD + "Sa?? T??kla."});
        toReturn.setContents(this.inv13.getContents());
        return toReturn;
    }


    public Inventory productRealFurnace(Player p) {
        Inventory toReturn = Bukkit.createInventory(null, inv_rows11, inventory_name4);

        itemHandler.createItem(inv25, "arrow", 1, 1, "&eGeri D??n.");
        itemHandler.createItem(inv25, "black_stained_glass_pane", 1, 2, " ");
        itemHandler.createItem(inv25, "black_stained_glass_pane", 1, 3, " ");
        itemHandler.createItem(inv25, "black_stained_glass_pane", 1, 4, " ");
        itemHandler.createItem(inv25, "black_stained_glass_pane", 1, 5, " ");
        itemHandler.createItem(inv25, "black_stained_glass_pane", 1, 6, " ");
        itemHandler.createItem(inv25, "black_stained_glass_pane", 1, 7, " ");
        itemHandler.createItem(inv25, "black_stained_glass_pane", 1, 8, " ");
        itemHandler.createItem(inv25, "black_stained_glass_pane", 1, 9, " ");
        itemHandler.createItem(inv25, "black_stained_glass_pane", 1, 10, " ");
        itemHandler.createItem(inv25, "black_stained_glass_pane", 1, 11, " ");
        itemHandler.createItem(inv25, "black_stained_glass_pane", 1, 12, " ");
        itemHandler.createItem(inv25, "black_stained_glass_pane", 1, 13, " ");
        itemHandler.createItem(inv25, "black_stained_glass_pane", 1, 15, " ");
        itemHandler.createItem(inv25, "black_stained_glass_pane", 1, 16, " ");
        itemHandler.createItem(inv25, "black_stained_glass_pane", 1, 17, " ");
        itemHandler.createItem(inv25, "black_stained_glass_pane", 1, 18, " ");
        itemHandler.createItem(inv25, "black_stained_glass_pane", 1, 19, " ");
        itemHandler.createItem(inv25, "black_stained_glass_pane", 1, 20, " ");
        itemHandler.createItem(inv25, "black_stained_glass_pane", 1, 21, " ");
        itemHandler.createItem(inv25, "black_stained_glass_pane", 1, 22, " ");
        itemHandler.createItem(inv25, "black_stained_glass_pane", 1, 23, " ");
        itemHandler.createItem(inv25, "black_stained_glass_pane", 1, 24, " ");
        itemHandler.createItem(inv25, "black_stained_glass_pane", 1, 25, " ");
        itemHandler.createItem(inv25, "black_stained_glass_pane", 1, 26, " ");
        itemHandler.createItem(inv25, "black_stained_glass_pane", 1, 27, " ");
        toReturn.setContents(inv25.getContents());
        return toReturn;
    }

    public Inventory claimBilgi(Player p) {
        Chunk chunk = p.getChunk();
        String chunkID = chunk.getX() + "." + chunk.getZ();
        Inventory toReturn = Bukkit.createInventory(null, inv_rows11, inventory_name23);

        itemHandler.createItem(inv26, "arrow", 1, 1, "&eGeri D??n.");
        itemHandler.createItem(inv26, "black_stained_glass_pane", 1, 2, " ");
        itemHandler.createItem(inv26, "black_stained_glass_pane", 1, 3, " ");
        itemHandler.createItem(inv26, "black_stained_glass_pane", 1, 4, " ");
        itemHandler.createItem(inv26, "black_stained_glass_pane", 1, 5, " ");
        itemHandler.createItem(inv26, "black_stained_glass_pane", 1, 6, " ");
        itemHandler.createItem(inv26, "black_stained_glass_pane", 1, 7, " ");
        itemHandler.createItem(inv26, "black_stained_glass_pane", 1, 8, " ");
        itemHandler.createItem(inv26, "black_stained_glass_pane", 1, 9, " ");
        itemHandler.createItem(inv26, "black_stained_glass_pane", 1, 10, " ");
        itemHandler.createItem(inv26, "black_stained_glass_pane", 1, 11, " ");
        itemHandler.createItem(inv26, "campfire", 1, 12, "&6B??lge Bilgileri", "&eB??lge Sahibi: " + Objects.requireNonNull(Bukkit.getPlayer(stats.getOwner(chunkID))).getName());
        itemHandler.createItem(inv26, "white_banner", 1, 13, "&cKlan Kur", "&7Buradan klan kurup g??clenebilirsin. Klan Kurmak i??in &e&lSa?? T??kla.");

        itemHandler.createItem(inv26, "grass_block", 1, 14, "&aB??lgeni Geni??let", "&7Buradan b??lgeni geni??letebilirsin. A??mak i??in &e&lSa?? T??kla.");

        itemHandler.createItem(inv26, "barrier", 1, 15, "&cB??lgeni Y??k", "&7Buradan Belediye Binan?? y??kabilirsin fakat malzemelerin", " geri gelmez. Belediye Binan?? y??kmak i??in &e&lSa?? T??kla.");

        itemHandler.createItem(inv26, "chest", 1, 16, "&eBelediye Binas?? Deposu", "&7Alt??n madenlerinden ve Mistik R??n altarlar??ndan gelen", "&7malzemeler burada depolan??r. A??mak i??in &e&lSa?? T??kla.");
        itemHandler.createItem(inv26, "black_stained_glass_pane", 1, 17, " ");
        itemHandler.createItem(inv26, "black_stained_glass_pane", 1, 18, " ");
        itemHandler.createItem(inv26, "black_stained_glass_pane", 1, 19, " ");
        itemHandler.createItem(inv26, "black_stained_glass_pane", 1, 20, " ");
        itemHandler.createItem(inv26, "black_stained_glass_pane", 1, 21, " ");
        itemHandler.createItem(inv26, "black_stained_glass_pane", 1, 22, " ");
        itemHandler.createItem(inv26, "black_stained_glass_pane", 1, 23, " ");
        itemHandler.createItem(inv26, "black_stained_glass_pane", 1, 24, " ");
        itemHandler.createItem(inv26, "black_stained_glass_pane", 1, 25, " ");
        itemHandler.createItem(inv26, "black_stained_glass_pane", 1, 26, " ");
        itemHandler.createItem(inv26, "black_stained_glass_pane", 1, 27, " ");
        toReturn.setContents(inv26.getContents());
        return toReturn;
    }

    public Inventory productCook(Player p) {
        Inventory toReturn = Bukkit.createInventory(null, inv_rows11, inventory_name11);

        itemHandler.createItem(inv11, "arrow", 1, 1, "&eGeri D??n.");
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
        itemHandler.createItem(inv19, "fletching_table", 1, 5, ChatColor.WHITE + "El Sanatlar?? Masas??",
                ChatColor.GRAY + "Burada elindeki malzemelerle", ChatColor.GRAY + "yapabilece??in ekipmanlara bakabilir",
                ChatColor.GRAY + "ve onlar?? yapabilirsin.", "",
                ChatColor.GOLD + "El Sanatlar??ndaki Ustal??????n: " + ChatColor.GREEN + smithLevel);
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
        itemHandler.createItem2(inv19, "leather_helmet", 1, 19, ChatColor.YELLOW + Maden + " Derisinden Kap????on",
                zirhmodel, ChatColor.GREEN + "Ustal??k 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 ??p",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 5 " + Maden + " Postu",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 5 Seviye", "", ChatColor.GRAY + "????lemeye ba??lamak i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem2(inv19, "leather_chestplate", 1, 20, ChatColor.YELLOW + Maden + " Derisinden G??????sl??k",
                zirhmodel, ChatColor.GREEN + "Ustal??k 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 6 ??p",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 8 " + Maden + " Postu",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 5 Seviye", "", ChatColor.GRAY + "????lemeye ba??lamak i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem2(inv19, "leather_leggings", 1, 21, ChatColor.YELLOW + Maden + " Derisinden Pantolon",
                zirhmodel, ChatColor.GREEN + "Ustal??k 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 5 ??p",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 7 " + Maden + " Postu",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 5 Seviye", "", ChatColor.GRAY + "????lemeye ba??lamak i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem2(inv19, "leather_boots", 1, 22, ChatColor.YELLOW + Maden + " Derisinden ??izmeler",
                zirhmodel, ChatColor.GREEN + "Ustal??k 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 ??p",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 " + Maden + " Postu",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 5 Seviye", "", ChatColor.GRAY + "????lemeye ba??lamak i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem2(inv19, "bundle", 1, 23, ChatColor.YELLOW + Maden + " Derisinden Ok K??l??f??",
                zirhmodel, ChatColor.GREEN + "Ustal??k 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 5 " + Maden + " Postu",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 5 ??p",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 6 Seviye", "", ChatColor.GRAY + "????lemeye ba??lamak i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem2(inv19, "leather", 1, 24, ChatColor.YELLOW + Maden + " Derisinden ??anta",
                zirhmodel, ChatColor.GREEN + "Ustal??k 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 " + Maden + " Postu",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "????lemeye ba??lamak i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        toReturn.setContents(inv19.getContents());
        return toReturn;
    }

    public Inventory Furnace(Player p) {
        Inventory toReturn = Bukkit.createInventory(null, inv_rows8, inventory_name21);

        itemHandler.createItem(inv22, "white_stained_glass_pane", 1, 1, " ");
        itemHandler.createItem(inv22, "white_stained_glass_pane", 1, 2, " ");
        itemHandler.createItem(inv22, "white_stained_glass_pane", 1, 3, " ");
        itemHandler.createItem(inv22, "white_stained_glass_pane", 1, 4, " ");
        itemHandler.createItem(inv22, "blast_furnace", 1, 5, ChatColor.WHITE + "Y??ksek F??r??n",
                ChatColor.GRAY + "Burada elindeki malzemeleri eritip",
                ChatColor.GRAY + "onlar?? i??lenmeye haz??r hale getirebilirsin.");
        itemHandler.createItem(inv22, "white_stained_glass_pane", 1, 6, " ");
        itemHandler.createItem(inv22, "white_stained_glass_pane", 1, 7, " ");
        itemHandler.createItem(inv22, "white_stained_glass_pane", 1, 8, " ");
        itemHandler.createItem(inv22, "chest", 1, 9, Painter.paint("&6Maden F??r??n?? Deposu"),
                Painter.paint("&7Buradan eritti??in malzemeleri alabilirsin."),
                Painter.paint("&7A??mak i??in &e&lSa?? T??kla."));
        itemHandler.createItem(inv22, "black_stained_glass_pane", 1, 10, " ");
        itemHandler.createItem(inv22, "black_stained_glass_pane", 1, 11, " ");
        itemHandler.createItem(inv22, "black_stained_glass_pane", 1, 12, " ");
        itemHandler.createItem(inv22, "black_stained_glass_pane", 1, 13, " ");
        itemHandler.createItem(inv22, "black_stained_glass_pane", 1, 14, " ");
        itemHandler.createItem(inv22, "black_stained_glass_pane", 1, 15, " ");
        itemHandler.createItem(inv22, "black_stained_glass_pane", 1, 16, " ");
        itemHandler.createItem(inv22, "black_stained_glass_pane", 1, 17, " ");
        itemHandler.createItem(inv22, "black_stained_glass_pane", 1, 18, " ");
        itemHandler.createItem(inv22, "copper_ingot", 1, 19, ChatColor.GOLD + "Bak??r K??l??esi",
                "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Bak??r Cevheri",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 K??m??r", "", ChatColor.GRAY + "Eritmeye ba??lamak i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv22, "copper_ingot", 1, 20, ChatColor.WHITE + "Nikel K??l??esi",
                "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Nikel Cevheri",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 K??m??r", "", ChatColor.GRAY + "Eritmeye ba??lamak i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv22, "copper_ingot", 1, 21, ChatColor.GOLD + "Bronz K??l??esi",
                "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Bak??r Cevheri",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Nikel Cevheri",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 K??m??r", "", ChatColor.GRAY + "Eritmeye ba??lamak i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv22, "iron_ingot", 1, 22, ChatColor.GRAY + "Demir K??l??esi",
                "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Demir Cevheri",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 K??m??r", "", ChatColor.GRAY + "Eritmeye ba??lamak i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv22, "iron_ingot", 1, 23, ChatColor.GRAY + "G??m???? K??l??esi",
                "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 G??m???? Cevheri",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 K??m??r", "", ChatColor.GRAY + "Eritmeye ba??lamak i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv22, "gold_ingot", 1, 24, ChatColor.YELLOW + "Alt??n K??l??esi",
                "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Alt??n Cevheri",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 K??m??r", "", ChatColor.GRAY + "Eritmeye ba??lamak i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv22, "copper_ingot", 1, 25, ChatColor.DARK_PURPLE + "Obsidyen K??l??esi",
                "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Obsidyen Cevheri",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 Nikel Cevheri",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 K??m??r", "", ChatColor.GRAY + "Eritmeye ba??lamak i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv22, "iron_ingot", 1, 26, ChatColor.AQUA + "Adamantium K??l??esi",
                "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Adamantium Cevheri",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 K??m??r", "", ChatColor.GRAY + "Eritmeye ba??lamak i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv22, "netherite_ingot", 1, 27, ChatColor.DARK_GRAY + "Netherit K??l??esi",
                "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 Demir Cevheri",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 Netherit Cevheri",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 K??m??r", "", ChatColor.GRAY + "Eritmeye ba??lamak i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv22, "copper_ingot", 1, 28, ChatColor.RED + "K??z??l Metal K??l??esi",
                "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 K??z??l Metal Cevheri",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Netherit Cevheri",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Lav Kovas??", "", ChatColor.GRAY + "Eritmeye ba??lamak i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv22, "iron_ingot", 1, 29, ChatColor.DARK_AQUA + "Mitril K??l??esi",
                "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Mitril Cevheri",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Lav Kovas??", "", ChatColor.GRAY + "Eritmeye ba??lamak i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv22, "gold_ingot", 1, 30, ChatColor.DARK_PURPLE + "Hi??lik K??l??esi",
                "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Hi??lik Ta????",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 K??z??l Metal Cevheri",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Lav Kovas??", "", ChatColor.GRAY + "Eritmeye ba??lamak i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv22, "iron_ingot", 1, 31, ChatColor.RED + "Rodonit K??l??esi",
                "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Rodonit Cevheri",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 Obsidyen Cevheri",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Lav Kovas??", "", ChatColor.GRAY + "Eritmeye ba??lamak i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv22, "iron_ingot", 1, 32, ChatColor.AQUA + "Spektral K??l??esi",
                "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 Rodonit Cevheri",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 Obsidyen Cevheri",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Mitril Cevheri",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Ektoplazma",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Lav Kovas??", "", ChatColor.GRAY + "Eritmeye ba??lamak i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        toReturn.setContents(inv22.getContents());
        return toReturn;
    }

    public Inventory resourceSmith(Player p, String Maden, String invisim, int zirhmodel, String cubuk) {
        int smithLevel = stats.getSmithLevel(p.getUniqueId());
        Inventory toReturn = Bukkit.createInventory(null, inv_rows5, invisim);

        itemHandler.createItem(inv21, "white_stained_glass_pane", 1, 1, " ");
        itemHandler.createItem(inv21, "white_stained_glass_pane", 1, 2, " ");
        itemHandler.createItem(inv21, "white_stained_glass_pane", 1, 3, " ");
        itemHandler.createItem(inv21, "white_stained_glass_pane", 1, 4, " ");
        itemHandler.createItem(inv21, "smithing_table", 1, 5, ChatColor.WHITE + "Demirci Masas??",
                ChatColor.GRAY + "Burada elindeki malzemelerle", ChatColor.GRAY + "yapabilece??in ekipmanlara bakabilir",
                ChatColor.GRAY + "ve onlar?? i??leyebilirsin.", "",
                ChatColor.GOLD + "Demircilikteki Ustal??????n: " + ChatColor.GREEN + smithLevel);
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
        itemHandler.createItem(inv21, "wooden_sword", 1, 19, ChatColor.YELLOW + Maden + " K??l????",
                ChatColor.GREEN + "Ustal??k 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 " + cubuk + " ??ubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 " + Maden + " K??l??esi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "????lemeye ba??lamak i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv21, "diamond_sword", 1, 20, ChatColor.YELLOW + "A????r " + Maden + " K??l????",
                ChatColor.GREEN + "Ustal??k 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 " + cubuk + " ??ubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 5 " + Maden + " K??l??esi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "????lemeye ba??lamak i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv21, "golden_axe", 1, 21, ChatColor.YELLOW + Maden + " Balta",
                ChatColor.GREEN + "Ustal??k 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 " + cubuk + " ??ubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 " + Maden + " K??l??esi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "????lemeye ba??lamak i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem2(inv21, "leather_chestplate", 1, 22, ChatColor.YELLOW + Maden + " G??????sl??k",
                zirhmodel, ChatColor.GREEN + "Ustal??k 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 8 " + Maden + " K??l??esi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "????lemeye ba??lamak i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem2(inv21, "leather_leggings", 1, 23, ChatColor.YELLOW + Maden + " Pantolon",
                zirhmodel, ChatColor.GREEN + "Ustal??k 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 8 " + Maden + " K??l??esi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "????lemeye ba??lamak i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem2(inv21, "leather_helmet", 1, 24, ChatColor.YELLOW + Maden + " Mi??fer",
                zirhmodel, ChatColor.GREEN + "Ustal??k 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 5 " + Maden + " K??l??esi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "????lemeye ba??lamak i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem2(inv21, "leather_boots", 1, 25, ChatColor.YELLOW + Maden + " Botlar",
                zirhmodel, ChatColor.GREEN + "Ustal??k 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 " + Maden + " K??l??esi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "????lemeye ba??lamak i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv21, "golden_shovel", 1, 26, ChatColor.YELLOW + Maden + " K??rek",
                ChatColor.GREEN + "Ustal??k 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 " + cubuk + " ??ubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 " + Maden + " K??l??esi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "????lemeye ba??lamak i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv21, "golden_pickaxe", 1, 27, ChatColor.YELLOW + Maden + " Kazma",
                ChatColor.GREEN + "Ustal??k 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 " + cubuk + " ??ubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 " + Maden + " K??l??esi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "????lemeye ba??lamak i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv21, "shears", 1, 28, ChatColor.YELLOW + Maden + " Han??er", ChatColor.GREEN + "Ustal??k 1",
                "", ChatColor.GRAY + " Gerekli Malzemeler:", ChatColor.GRAY + " -" + ChatColor.WHITE + " 1" + cubuk + " ??ubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 " + Maden + " K??l??esi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "????lemeye ba??lamak i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv21, "wooden_hoe", 1, 29, ChatColor.YELLOW + Maden + " T??rpan",
                ChatColor.GREEN + "Ustal??k 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 " + cubuk + " ??ubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 " + Maden + " K??l??esi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "????lemeye ba??lamak i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv21, "golden_hoe", 1, 30, ChatColor.YELLOW + Maden + " ??apa",
                ChatColor.GREEN + "Ustal??k 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 " + cubuk + " ??ubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 " + Maden + " K??l??esi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "????lemeye ba??lamak i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv21, "stick", 1, 31, ChatColor.YELLOW + Maden + " M??zrak", ChatColor.GREEN + "Ustal??k 1",
                "", ChatColor.GRAY + " Gerekli Malzemeler:", ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 " + cubuk + " ??ubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 " + Maden + " K??l??esi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "????lemeye ba??lamak i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv21, "wooden_shovel", 1, 32, ChatColor.YELLOW + Maden + " Topuz", ChatColor.GREEN + "Ustal??k 1",
                "", ChatColor.GRAY + " Gerekli Malzemeler:", ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 " + cubuk + " ??ubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 " + Maden + " K??l??esi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "????lemeye ba??lamak i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem2(inv21, "shield", 1, 32, ChatColor.YELLOW + Maden + " Kalkan", zirhmodel, ChatColor.GREEN + "Ustal??k 1",
                "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 " + cubuk + " Tahtas??",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 6 " + Maden + " K??l??esi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "????lemeye ba??lamak i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv21, "wooden_axe", 1, 33, ChatColor.YELLOW + Maden + " Sava?? Baltas??", ChatColor.GREEN + "Ustal??k 1",
                "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 " + cubuk + " ??ubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 6 " + Maden + " K??l??esi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "????lemeye ba??lamak i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        toReturn.setContents(inv21.getContents());
        return toReturn;
    }

    public Inventory Bow(Player p) {
        int smithLevel = stats.getWorkLevel(p.getUniqueId());
        Inventory toReturn = Bukkit.createInventory(null, inv_rows8, inventory_name18);

        itemHandler.createItem(inv18, "white_stained_glass_pane", 1, 1, " ");
        itemHandler.createItem(inv18, "white_stained_glass_pane", 1, 2, " ");
        itemHandler.createItem(inv18, "white_stained_glass_pane", 1, 3, " ");
        itemHandler.createItem(inv18, "white_stained_glass_pane", 1, 4, " ");
        itemHandler.createItem(inv18, "fletching_table", 1, 5, ChatColor.WHITE + "El Sanatlar?? Masas??",
                ChatColor.GRAY + "Burada elindeki malzemelerle", ChatColor.GRAY + "yapabilece??in ekipmanlara bakabilir",
                ChatColor.GRAY + "ve onlar?? yapabilirsin.", "",
                ChatColor.GOLD + "El Sanatlar??ndaki Ustal??????n: " + ChatColor.GREEN + smithLevel);
        itemHandler.createItem(inv18, "white_stained_glass_pane", 1, 6, " ");
        itemHandler.createItem(inv18, "white_stained_glass_pane", 1, 7, " ");
        itemHandler.createItem(inv18, "white_stained_glass_pane", 1, 8, " ");
        itemHandler.createItem(inv18, "chest", 1, 9, Painter.paint("&6El Sanatlar?? Deposu"),
                Painter.paint("&7Buradan yapt??????n ekipmanlar?? alabilirsin."),
                Painter.paint("&7A??mak i??in &e&lSa?? T??kla."));
        itemHandler.createItem(inv18, "black_stained_glass_pane", 1, 10, " ");
        itemHandler.createItem(inv18, "black_stained_glass_pane", 1, 11, " ");
        itemHandler.createItem(inv18, "black_stained_glass_pane", 1, 12, " ");
        itemHandler.createItem(inv18, "black_stained_glass_pane", 1, 13, " ");
        itemHandler.createItem(inv18, "black_stained_glass_pane", 1, 14, " ");
        itemHandler.createItem(inv18, "black_stained_glass_pane", 1, 15, " ");
        itemHandler.createItem(inv18, "black_stained_glass_pane", 1, 16, " ");
        itemHandler.createItem(inv18, "black_stained_glass_pane", 1, 17, " ");
        itemHandler.createItem(inv18, "black_stained_glass_pane", 1, 18, " ");
        itemHandler.createItem2(inv18, "bow", 1, 19, ChatColor.YELLOW + "Me??e Yay",
                8, ChatColor.GREEN + "Ustal??k 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 Me??e ??ubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 ??p",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 Seviye", "", ChatColor.GRAY + "Yapmaya ba??lamak i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        if (smithLevel > 1) {
            itemHandler.createItem2(inv18, "bow", 1, 20, ChatColor.YELLOW + "Hu?? Yay",
                    3, ChatColor.GREEN + "Ustal??k 2", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 Hu?? ??ubuk",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 ??p",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 Seviye", "", ChatColor.GRAY + "Yapmaya ba??lamak i??in ",
                    ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        } else {
            itemHandler.createItem(inv18, "red_stained_glass_pane", 1, 20, ChatColor.RED + "??? " + ChatColor.RED + "(Ustal??k Yetersiz)",
                    ChatColor.GRAY + "Bu yay?? gerebilmek i??in el sanatlar??ndaki",
                    ChatColor.GRAY + "ustal??????n??n 1. seviyeden y??ksek olmas?? gerekir.");

        }
        if (smithLevel > 2) {
            itemHandler.createItem2(inv18, "bow", 1, 21, ChatColor.YELLOW + "Ya??l?? Me??e Yay",
                    2, ChatColor.GREEN + "Ustal??k 3", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 Ya??l?? Me??e ??ubuk",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 ??p",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 Seviye", "", ChatColor.GRAY + "Yapmaya ba??lamak i??in ",
                    ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        } else {
            itemHandler.createItem(inv18, "red_stained_glass_pane", 1, 21, ChatColor.RED + "??? " + ChatColor.RED + "(Ustal??k Yetersiz)",
                    ChatColor.GRAY + "Bu yay?? gerebilmek i??in el sanatlar??ndaki",
                    ChatColor.GRAY + "ustal??????n??n 2. seviyeden y??ksek olmas?? gerekir.");

        }
        if (smithLevel > 3) {
            itemHandler.createItem(inv18, "bow", 1, 22, ChatColor.YELLOW + "Karma Yay",
                    ChatColor.GREEN + "Ustal??k 4", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 Me??e ??ubuk",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 6 ??p ",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Seviye", "", ChatColor.GRAY + "Yapmaya ba??lamak i??in ",
                    ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        } else {
            itemHandler.createItem(inv18, "red_stained_glass_pane", 1, 22, ChatColor.RED + "??? " + ChatColor.RED + "(Ustal??k Yetersiz)",
                    ChatColor.GRAY + "Bu yay?? gerebilmek i??in el sanatlar??ndaki",
                    ChatColor.GRAY + "ustal??????n??n 3. seviyeden y??ksek olmas?? gerekir.");
        }
        if (smithLevel > 4) {
            itemHandler.createItem(inv18, "crossbow", 1, 23, ChatColor.YELLOW + "Me??e Arbalet",
                    ChatColor.GREEN + "Ustal??k 5", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 5 Me??e ??ubuk",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 Kanca",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 ??p",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 Seviye", "", ChatColor.GRAY + "Yapmaya ba??lamak i??in ",
                    ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        } else {
            itemHandler.createItem(inv18, "red_stained_glass_pane", 1, 23, ChatColor.RED + "??? " + ChatColor.RED + "(Ustal??k Yetersiz)",
                    ChatColor.GRAY + "Bu yay?? gerebilmek i??in el sanatlar??ndaki",
                    ChatColor.GRAY + "ustal??????n??n 4. seviyeden y??ksek olmas?? gerekir.");
        }
        if (smithLevel > 5) {
            itemHandler.createItem(inv18, "bow", 1, 24, ChatColor.YELLOW + "??ift Pen??e",
                    ChatColor.GREEN + "Ustal??k 6", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 Me??e ??ubuk",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 Ya???? Me??e ??ubu??u",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 ??p",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 5 Seviye", "", ChatColor.GRAY + "Yapmaya ba??lamak i??in ",
                    ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        } else {
            itemHandler.createItem(inv18, "red_stained_glass_pane", 1, 24, ChatColor.RED + "??? " + ChatColor.RED + "(Ustal??k Yetersiz)",
                    ChatColor.GRAY + "Bu yay?? gerebilmek i??in el sanatlar??ndaki",
                    ChatColor.GRAY + "ustal??????n??n 5. seviyeden y??ksek olmas?? gerekir.");
        }
        if (smithLevel > 6) {
            itemHandler.createItem2(inv18, "bow", 1, 25, ChatColor.YELLOW + "Ladin Yay",
                    4, ChatColor.GREEN + "Ustal??k 7", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 Ladin ??ubuk",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 ??p",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 6 Seviye", "", ChatColor.GRAY + "Yapmaya ba??lamak i??in ",
                    ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        } else {
            itemHandler.createItem(inv18, "red_stained_glass_pane", 1, 25, ChatColor.RED + "??? " + ChatColor.RED + "(Ustal??k Yetersiz)",
                    ChatColor.GRAY + "Bu yay?? gerebilmek i??in el sanatlar??ndaki",
                    ChatColor.GRAY + "ustal??????n??n 6. seviyeden y??ksek olmas?? gerekir.");
        }
        if (smithLevel > 6) {
            itemHandler.createItem(inv18, "crossbow", 1, 26, ChatColor.YELLOW + "Geli??mi?? Arbalet",
                    ChatColor.GREEN + "Ustal??k 7", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 Ladin ??ubuk",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Kanca",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 ??p",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 6 Nikel",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "Yapmaya ba??lamak i??in ",
                    ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        } else {
            itemHandler.createItem(inv18, "red_stained_glass_pane", 1, 26, ChatColor.RED + "??? " + ChatColor.RED + "(Ustal??k Yetersiz)",
                    ChatColor.GRAY + "Bu yay?? gerebilmek i??in el sanatlar??ndaki",
                    ChatColor.GRAY + "ustal??????n??n 6. seviyeden y??ksek olmas?? gerekir.");
        }
        if (smithLevel > 7) {
            itemHandler.createItem(inv18, "bow", 1, 27, ChatColor.YELLOW + "Demir Kaplamal?? Yay",
                    ChatColor.GREEN + "Ustal??k 8", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 Me??e ??ubuk",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 ??p",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 6 Demir",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "Yapmaya ba??lamak i??in ",
                    ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        } else {
            itemHandler.createItem(inv18, "red_stained_glass_pane", 1, 27, ChatColor.RED + "??? " + ChatColor.RED + "(Ustal??k Yetersiz)",
                    ChatColor.GRAY + "Bu yay?? gerebilmek i??in el sanatlar??ndaki",
                    ChatColor.GRAY + "ustal??????n??n 7. seviyeden y??ksek olmas?? gerekir.");
        }
        if (smithLevel > 8) {
            itemHandler.createItem2(inv18, "bow", 1, 28, ChatColor.YELLOW + "Kara Me??e Yay",
                    7, ChatColor.GREEN + "Ustal??k 9", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 6 Kara Me??e ??ubuk",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 ??p",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 Kara Me??e Tahtas??",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "Yapmaya ba??lamak i??in ",
                    ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        } else {
            itemHandler.createItem(inv18, "red_stained_glass_pane", 1, 28, ChatColor.RED + "??? " + ChatColor.RED + "(Ustal??k Yetersiz)",
                    ChatColor.GRAY + "Bu yay?? gerebilmek i??in el sanatlar??ndaki",
                    ChatColor.GRAY + "ustal??????n??n 8. seviyeden y??ksek olmas?? gerekir.");
        }
        if (smithLevel > 9) {
            itemHandler.createItem(inv18, "bow", 1, 29, ChatColor.YELLOW + "Tayfun", ChatColor.GREEN + "Ustal??k 10",
                    "", ChatColor.GRAY + " Gerekli Malzemeler:", ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 ??ubuk",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 6 A????r ??ubuk",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Dalgak??ran Bal??????",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 ??p",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 Bizon Derisi",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 14 Seviye", "", ChatColor.GRAY + "Yapmaya ba??lamak i??in ",
                    ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        } else {
            itemHandler.createItem(inv18, "red_stained_glass_pane", 1, 29, ChatColor.RED + "??? " + ChatColor.RED + "(Ustal??k Yetersiz)",
                    ChatColor.GRAY + "Bu yay?? gerebilmek i??in el sanatlar??ndaki",
                    ChatColor.GRAY + "ustal??????n??n 9. seviyeden y??ksek olmas?? gerekir.");
        }
        if (smithLevel > 10) {
            itemHandler.createItem2(inv18, "bow", 1, 30, ChatColor.YELLOW + "Akasya Yay",
                    6, ChatColor.GREEN + "Ustal??k 11", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 6 Akasya ??ubuk",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 ??p ",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 5 Nikel ",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 15 Seviye", "", ChatColor.GRAY + "Yapmaya ba??lamak i??in ",
                    ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        } else {
            itemHandler.createItem(inv18, "red_stained_glass_pane", 1, 30, ChatColor.RED + "??? " + ChatColor.RED + "(Ustal??k Yetersiz)",
                    ChatColor.GRAY + "Bu yay?? gerebilmek i??in el sanatlar??ndaki",
                    ChatColor.GRAY + "ustal??????n??n 10. seviyeden y??ksek olmas?? gerekir.");
        }
        if (smithLevel > 11) {
            itemHandler.createItem(inv18, "bow", 1, 31, ChatColor.YELLOW + "Yakaryay",
                    ChatColor.GREEN + "Ustal??k 12", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 7 K??r??kalev ??ubuk",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 6 Yanmaz ??p",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Alevb??ce??i",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 15 Seviye", "", ChatColor.GRAY + "Yapmaya ba??lamak i??in ",
                    ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        } else {
            itemHandler.createItem(inv18, "red_stained_glass_pane", 1, 31, ChatColor.RED + "??? " + ChatColor.RED + "(Ustal??k Yetersiz)",
                    ChatColor.GRAY + "Bu yay?? gerebilmek i??in el sanatlar??ndaki",
                    ChatColor.GRAY + "ustal??????n??n 11. seviyeden y??ksek olmas?? gerekir.");
        }
        if (smithLevel > 12) {
            itemHandler.createItem(inv18, "bow", 1, 32, ChatColor.YELLOW + "Minoris", ChatColor.GREEN + "Ustal??k 13",
                    "", ChatColor.GRAY + " Gerekli Malzemeler:", ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 ??ubuk",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 6 A????r ??ubuk",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 Alev ??z??t??",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Bronz K??l??esi",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 12 Tuzlu ??p",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 17 Seviye", "", ChatColor.GRAY + "Yapmaya ba??lamak i??in ",
                    ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        } else {
            itemHandler.createItem(inv18, "red_stained_glass_pane", 1, 32, ChatColor.RED + "??? " + ChatColor.RED + "(Ustal??k Yetersiz)",
                    ChatColor.GRAY + "Bu yay?? gerebilmek i??in el sanatlar??ndaki",
                    ChatColor.GRAY + "ustal??????n??n 12. seviyeden y??ksek olmas?? gerekir.");
        }
        if (smithLevel > 12) {
            itemHandler.createItem(inv18, "crossbow", 1, 33, ChatColor.YELLOW + "G??lge Avc??s?? Arbaleti", ChatColor.GREEN + "Ustal??k 13",
                    "", ChatColor.GRAY + " Gerekli Malzemeler:", ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 ??ubuk",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 8 A????r ??ubuk",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Lanetli ??p",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Kanca",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 7 G??m???? K??l??esi",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 20 Seviye", "", ChatColor.GRAY + "Yapmaya ba??lamak i??in ",
                    ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        } else {
            itemHandler.createItem(inv18, "red_stained_glass_pane", 1, 33, ChatColor.RED + "??? " + ChatColor.RED + "(Ustal??k Yetersiz)",
                    ChatColor.GRAY + "Bu yay?? gerebilmek i??in el sanatlar??ndaki",
                    ChatColor.GRAY + "ustal??????n??n 12. seviyeden y??ksek olmas?? gerekir.");
        }
        if (smithLevel > 13) {
            itemHandler.createItem(inv18, "crossbow", 1, 34, ChatColor.YELLOW + "Ay Par??as?? Arbaleti", ChatColor.GREEN + "Ustal??k 14",
                    "", ChatColor.GRAY + " Gerekli Malzemeler:", ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 ??ubuk",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 5 ??lah S??????t ??ubuk",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 15 Tuzlu ??p",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 R??n Esans??",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 5 G??kta????",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 24 Seviye", "", ChatColor.GRAY + "Yapmaya ba??lamak i??in ",
                    ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        } else {
            itemHandler.createItem(inv18, "red_stained_glass_pane", 1, 34, ChatColor.RED + "??? " + ChatColor.RED + "(Ustal??k Yetersiz)",
                    ChatColor.GRAY + "Bu yay?? gerebilmek i??in el sanatlar??ndaki",
                    ChatColor.GRAY + "ustal??????n??n 13. seviyeden y??ksek olmas?? gerekir.");
        }
        if (smithLevel > 14) {
            itemHandler.createItem2(inv18, "bow", 1, 35, ChatColor.YELLOW + "Gerilla Yay??", 5, ChatColor.GREEN + "Ustal??k 15",
                    "", ChatColor.GRAY + " Gerekli Malzemeler:", ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 ??ubuk",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 12 A????r ??ubuk",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 6 ??p",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 7 Y??ld??r??m ??z??t??",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 32 Seviye", "", ChatColor.GRAY + "Yapmaya ba??lamak i??in ",
                    ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        } else {
            itemHandler.createItem(inv18, "red_stained_glass_pane", 1, 35, ChatColor.RED + "??? " + ChatColor.RED + "(Ustal??k Yetersiz)",
                    ChatColor.GRAY + "Bu yay?? gerebilmek i??in el sanatlar??ndaki",
                    ChatColor.GRAY + "ustal??????n??n 14. seviyeden y??ksek olmas?? gerekir.");
        }
        if (smithLevel > 15) {
            itemHandler.createItem2(inv18, "bow", 1, 36, ChatColor.YELLOW + "??lah S??????t Yay??", 5, ChatColor.GREEN + "Ustal??k 16",
                    "", ChatColor.GRAY + " Gerekli Malzemeler:", ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 ??ubuk",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 11 ??lah S??????t ??ubuk",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 5 Lanetli ??p",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Y??ld??r??m ??z??t??",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Alev ??z??t??",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 12 Topaz",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 32 Seviye", "", ChatColor.GRAY + "Yapmaya ba??lamak i??in ",
                    ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        } else {
            itemHandler.createItem(inv18, "red_stained_glass_pane", 1, 36, ChatColor.RED + "??? " + ChatColor.RED + "(Ustal??k Yetersiz)",
                    ChatColor.GRAY + "Bu yay?? gerebilmek i??in el sanatlar??ndaki",
                    ChatColor.GRAY + "ustal??????n??n 15. seviyeden y??ksek olmas?? gerekir.");
        }
        if (smithLevel > 15) {
            itemHandler.createItem2(inv18, "bow", 1, 37, ChatColor.YELLOW + "Mutlak G???? Yay??", 10, ChatColor.GREEN + "Ustal??k 16",
                    "", ChatColor.GRAY + " Gerekli Malzemeler:", ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 ??ubuk",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 12 ??lah S??????t ??ubuk",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 12 A????r ??ubuk",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 5 Lanetli ??p",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 5 Tuzlu ??p",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Y??ld??r??m ??z??t??",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 Alev ??z??t??",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 Ger??ek Buz ??z??t??",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 12 Ye??im Ta????",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 G??m????",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 36 Seviye", "", ChatColor.GRAY + "Yapmaya ba??lamak i??in ",
                    ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        } else {
            itemHandler.createItem(inv18, "red_stained_glass_pane", 1, 37, ChatColor.RED + "??? " + ChatColor.RED + "(Ustal??k Yetersiz)",
                    ChatColor.GRAY + "Bu yay?? gerebilmek i??in el sanatlar??ndaki",
                    ChatColor.GRAY + "ustal??????n??n 15. seviyeden y??ksek olmas?? gerekir.");
        }
        toReturn.setContents(inv18.getContents());
        return toReturn;
    }

    public Inventory Rod(Player p) {
        int smithLevel = stats.getWorkLevel(p.getUniqueId());
        Inventory toReturn = Bukkit.createInventory(null, inv_rows8, inventory_name20);

        itemHandler.createItem(inv28, "white_stained_glass_pane", 1, 1, " ");
        itemHandler.createItem(inv28, "white_stained_glass_pane", 1, 2, " ");
        itemHandler.createItem(inv28, "white_stained_glass_pane", 1, 3, " ");
        itemHandler.createItem(inv28, "white_stained_glass_pane", 1, 4, " ");
        itemHandler.createItem(inv28, "fletching_table", 1, 5, ChatColor.WHITE + "El Sanatlar?? Masas??",
                ChatColor.GRAY + "Burada elindeki malzemelerle", ChatColor.GRAY + "yapabilece??in ekipmanlara bakabilir",
                ChatColor.GRAY + "ve onlar?? yapabilirsin.", "",
                ChatColor.GOLD + "El Sanatlar??ndaki Ustal??????n: " + ChatColor.GREEN + smithLevel);
        itemHandler.createItem(inv28, "white_stained_glass_pane", 1, 6, " ");
        itemHandler.createItem(inv28, "white_stained_glass_pane", 1, 7, " ");
        itemHandler.createItem(inv28, "white_stained_glass_pane", 1, 8, " ");
        itemHandler.createItem(inv28, "chest", 1, 9, Painter.paint("&6El Sanatlar?? Deposu"),
                Painter.paint("&7Buradan yapt??????n ekipmanlar?? alabilirsin."),
                Painter.paint("&7A??mak i??in &e&lSa?? T??kla."));
        itemHandler.createItem(inv28, "black_stained_glass_pane", 1, 10, " ");
        itemHandler.createItem(inv28, "black_stained_glass_pane", 1, 11, " ");
        itemHandler.createItem(inv28, "black_stained_glass_pane", 1, 12, " ");
        itemHandler.createItem(inv28, "black_stained_glass_pane", 1, 13, " ");
        itemHandler.createItem(inv28, "black_stained_glass_pane", 1, 14, " ");
        itemHandler.createItem(inv28, "black_stained_glass_pane", 1, 15, " ");
        itemHandler.createItem(inv28, "black_stained_glass_pane", 1, 16, " ");
        itemHandler.createItem(inv28, "black_stained_glass_pane", 1, 17, " ");
        itemHandler.createItem(inv28, "black_stained_glass_pane", 1, 18, " ");
        itemHandler.createItem2(inv28, "fishing_rod", 1, 19, ChatColor.YELLOW + "Me??e Olta",
                8, ChatColor.GREEN + "Ustal??k 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 5 Me??e ??ubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 ??p",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 Seviye", "", ChatColor.GRAY + "Yapmaya ba??lamak i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        if (smithLevel > 1) {
            itemHandler.createItem2(inv28, "fishing_rod", 1, 20, ChatColor.YELLOW + "Hu?? Olta",
                    3, ChatColor.GREEN + "Ustal??k 2", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 5 Hu?? ??ubuk",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 ??p",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 Seviye", "", ChatColor.GRAY + "Yapmaya ba??lamak i??in ",
                    ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        } else {
            itemHandler.createItem(inv28, "red_stained_glass_pane", 1, 20, ChatColor.RED + "??? " + ChatColor.RED + "(Ustal??k Yetersiz)",
                    ChatColor.GRAY + "Bu yay?? gerebilmek i??in el sanatlar??ndaki",
                    ChatColor.GRAY + "ustal??????n??n 1. seviyeden y??ksek olmas?? gerekir.");

        }
        if (smithLevel > 2) {
            itemHandler.createItem2(inv28, "fishing_rod", 1, 21, ChatColor.YELLOW + "Ya??l?? Me??e Olta",
                    2, ChatColor.GREEN + "Ustal??k 3", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 5 Ya??l?? Me??e ??ubuk",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 ??p",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 5 Seviye", "", ChatColor.GRAY + "Yapmaya ba??lamak i??in ",
                    ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        } else {
            itemHandler.createItem(inv28, "red_stained_glass_pane", 1, 21, ChatColor.RED + "??? " + ChatColor.RED + "(Ustal??k Yetersiz)",
                    ChatColor.GRAY + "Bu yay?? gerebilmek i??in el sanatlar??ndaki",
                    ChatColor.GRAY + "ustal??????n??n 2. seviyeden y??ksek olmas?? gerekir.");

        }
        if (smithLevel > 3) {
            itemHandler.createItem(inv28, "fishing_rod", 1, 22, ChatColor.YELLOW + "Tuzlu Bal??k Manip??lat??r??",
                    ChatColor.GREEN + "Ustal??k 4", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 Me??e ??ubuk",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 6 Tuzlu ??p ",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 Seviye", "", ChatColor.GRAY + "Yapmaya ba??lamak i??in ",
                    ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        } else {
            itemHandler.createItem(inv28, "red_stained_glass_pane", 1, 22, ChatColor.RED + "??? " + ChatColor.RED + "(Ustal??k Yetersiz)",
                    ChatColor.GRAY + "Bu yay?? gerebilmek i??in el sanatlar??ndaki",
                    ChatColor.GRAY + "ustal??????n??n 3. seviyeden y??ksek olmas?? gerekir.");
        }
        if (smithLevel > 4) {
            itemHandler.createItem(inv28, "fishing_rod", 1, 23, ChatColor.YELLOW + "Kesici",
                    ChatColor.GREEN + "Ustal??k 5", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 5 Me??e ??ubuk",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 Ilviyan Pen??esi",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 Tuzlu ??p",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 Seviye", "", ChatColor.GRAY + "Yapmaya ba??lamak i??in ",
                    ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        } else {
            itemHandler.createItem(inv28, "red_stained_glass_pane", 1, 23, ChatColor.RED + "??? " + ChatColor.RED + "(Ustal??k Yetersiz)",
                    ChatColor.GRAY + "Bu yay?? gerebilmek i??in el sanatlar??ndaki",
                    ChatColor.GRAY + "ustal??????n??n 4. seviyeden y??ksek olmas?? gerekir.");
        }
        if (smithLevel > 5) {
            itemHandler.createItem(inv28, "fishing_rod", 1, 24, ChatColor.YELLOW + "Denizlerin Oltas??",
                    ChatColor.GREEN + "Ustal??k 6", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 Me??e ??ubuk",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 Denizin Kalbi",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 Lanetli ??p",
                    ChatColor.GRAY + " -" + ChatColor.WHITE + " 5 Seviye", "", ChatColor.GRAY + "Yapmaya ba??lamak i??in ",
                    ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        } else {
            itemHandler.createItem(inv28, "red_stained_glass_pane", 1, 24, ChatColor.RED + "??? " + ChatColor.RED + "(Ustal??k Yetersiz)",
                    ChatColor.GRAY + "Bu yay?? gerebilmek i??in el sanatlar??ndaki",
                    ChatColor.GRAY + "ustal??????n??n 5. seviyeden y??ksek olmas?? gerekir.");
        }

        toReturn.setContents(inv28.getContents());
        return toReturn;
    }

    public Inventory t1Ekipman(Player p) {
        int smithLevel = stats.getSmithLevel(p.getUniqueId());
        Inventory toReturn = Bukkit.createInventory(null, inv_rows5, inventory_name5);

        itemHandler.createItem(inv5, "white_stained_glass_pane", 1, 1, " ");
        itemHandler.createItem(inv5, "white_stained_glass_pane", 1, 2, " ");
        itemHandler.createItem(inv5, "white_stained_glass_pane", 1, 3, " ");
        itemHandler.createItem(inv5, "white_stained_glass_pane", 1, 4, " ");
        itemHandler.createItem(inv5, "smithing_table", 1, 5, ChatColor.WHITE + "Demirci Masas??",
                ChatColor.GRAY + "Burada elindeki malzemelerle", ChatColor.GRAY + "yapabilece??in ekipmanlara bakabilir",
                ChatColor.GRAY + "ve onlar?? i??leyebilirsin.", "",
                ChatColor.GOLD + "Demircilikteki Ustal??????n: " + ChatColor.GREEN + smithLevel);
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
        itemHandler.createItem(inv5, "wooden_sword", 1, 19, ChatColor.YELLOW + "Bak??r K??l????",
                ChatColor.GREEN + "Ustal??k 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 ??ubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Bak??r K??l??esi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "????lemeye ba??lamak i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv5, "diamond_sword", 1, 20, ChatColor.YELLOW + "A????r Bak??r K??l????",
                ChatColor.GREEN + "Ustal??k 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 ??ubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Bak??r K??l??esi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "????lemeye ba??lamak i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv5, "golden_axe", 1, 21, ChatColor.YELLOW + "Bak??r Balta",
                ChatColor.GREEN + "Ustal??k 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 ??ubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Bak??r K??l??esi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "????lemeye ba??lamak i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem2(inv5, "leather_chestplate", 1, 22, ChatColor.YELLOW + "Bak??r G??????sl??k",
                8, ChatColor.GREEN + "Ustal??k 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 8 Bak??r K??l??esi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "????lemeye ba??lamak i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem2(inv5, "leather_leggings", 1, 23, ChatColor.YELLOW + "Bak??r Pantolon",
                8, ChatColor.GREEN + "Ustal??k 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 8 Bak??r K??l??esi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "????lemeye ba??lamak i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem2(inv5, "leather_helmet", 1, 24, ChatColor.YELLOW + "Bak??r Mi??fer",
                8, ChatColor.GREEN + "Ustal??k 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 5 Bak??r K??l??esi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "????lemeye ba??lamak i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem2(inv5, "leather_boots", 1, 25, ChatColor.YELLOW + "Bak??r Botlar",
                8, ChatColor.GREEN + "Ustal??k 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 Bak??r K??l??esi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "????lemeye ba??lamak i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv5, "golden_shovel", 1, 26, ChatColor.YELLOW + "Bak??r K??rek",
                ChatColor.GREEN + "Ustal??k 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 ??ubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Bak??r K??l??esi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "????lemeye ba??lamak i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv5, "golden_pickaxe", 1, 27, ChatColor.YELLOW + "Bak??r Kazma",
                ChatColor.GREEN + "Ustal??k 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 ??ubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Bak??r K??l??esi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "????lemeye ba??lamak i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv5, "shears", 1, 28, ChatColor.YELLOW + "Bak??r Han??er", ChatColor.GREEN + "Ustal??k 1",
                "", ChatColor.GRAY + " Gerekli Malzemeler:", ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 ??ubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Bak??r K??l??esi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "????lemeye ba??lamak i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv5, "wooden_hoe", 1, 29, ChatColor.YELLOW + "Bak??r T??rpan",
                ChatColor.GREEN + "Ustal??k 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 ??ubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Bak??r K??l??esi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "????lemeye ba??lamak i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv5, "golden_hoe", 1, 30, ChatColor.YELLOW + "Bak??r ??apa",
                ChatColor.GREEN + "Ustal??k 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 ??ubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Bak??r K??l??esi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "????lemeye ba??lamak i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv5, "stick", 1, 31, ChatColor.YELLOW + "Bak??r M??zrak", ChatColor.GREEN + "Ustal??k 1",
                "", ChatColor.GRAY + " Gerekli Malzemeler:", ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 ??ubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Bak??r K??l??esi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "????lemeye ba??lamak i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        itemHandler.createItem(inv5, "wooden_shovel", 1, 32, ChatColor.YELLOW + "Bak??r Topuz", ChatColor.GREEN + "Ustal??k 1",
                "", ChatColor.GRAY + " Gerekli Malzemeler:", ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 ??ubuk",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Bak??r K??l??esi",
                ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "????lemeye ba??lamak i??in ",
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sa?? T??kla.");
        toReturn.setContents(inv5.getContents());
        return toReturn;
    }

    public Inventory hurda(Player p) {
        Inventory toReturn = Bukkit.createInventory(null, inv_rows, inventory_name8);

        itemHandler.createItem(inv31, "arrow", 1, 1, "&eGeri D??n.");
        itemHandler.createItem(inv31, "white_stained_glass_pane", 1, 2, " ");
        itemHandler.createItem(inv31, "white_stained_glass_pane", 1, 3, " ");
        itemHandler.createItem(inv31, "white_stained_glass_pane", 1, 4, " ");
        itemHandler.createItem(inv31, "stonecutter", 1, 5, ChatColor.WHITE + "Hurdaya ??evir",
                ChatColor.GRAY + "Elindeki ekipman?? burada hurdaya ??evirebilirsin.",
                ChatColor.GRAY + "Ekipman??n ana malzemelerinin bir k??sm?? sana geri d??ner.");
        itemHandler.createItem(inv31, "white_stained_glass_pane", 1, 6, " ");
        itemHandler.createItem(inv31, "white_stained_glass_pane", 1, 7, " ");
        itemHandler.createItem(inv31, "white_stained_glass_pane", 1, 8, " ");
        itemHandler.createItem(inv31, "white_stained_glass_pane", 1, 9, " ");
        itemHandler.createItem(inv31, "black_stained_glass_pane", 1, 10, " ");
        itemHandler.createItem(inv31, "black_stained_glass_pane", 1, 11, " ");
        itemHandler.createItem(inv31, "black_stained_glass_pane", 1, 12, " ");
        itemHandler.createItem(inv31, "black_stained_glass_pane", 1, 13, " ");
        itemHandler.createItem(inv31, "black_stained_glass_pane", 1, 14, " ");
        itemHandler.createItem(inv31, "black_stained_glass_pane", 1, 15, " ");
        itemHandler.createItem(inv31, "black_stained_glass_pane", 1, 16, " ");
        itemHandler.createItem(inv31, "black_stained_glass_pane", 1, 17, " ");
        itemHandler.createItem(inv31, "black_stained_glass_pane", 1, 18, " ");
        itemHandler.createItem(inv31, "gray_stained_glass_pane", 1, 19, " ");
        itemHandler.createItem(inv31, "gray_stained_glass_pane", 1, 20, " ");
        itemHandler.createItem(inv31, "gray_stained_glass_pane", 1, 21, " ");
        itemHandler.createItem(inv31, "gray_stained_glass_pane", 1, 22, " ");
        itemHandler.createItem(inv31, "gray_stained_glass_pane", 1, 23, " ");
        itemHandler.createItem(inv31, "gray_stained_glass_pane", 1, 24, " ");
        itemHandler.createItem(inv31, "gray_stained_glass_pane", 1, 25, " ");
        itemHandler.createItem(inv31, "gray_stained_glass_pane", 1, 26, " ");
        itemHandler.createItem(inv31, "gray_stained_glass_pane", 1, 27, " ");
        itemHandler.createItem(inv31, "gray_stained_glass_pane", 1, 28, " ");
        itemHandler.createItem(inv31, "gray_stained_glass_pane", 1, 29, " ");
        itemHandler.createItem(inv31, "gray_stained_glass_pane", 1, 30, " ");
        itemHandler.createItem(inv31, "gray_stained_glass_pane", 1, 31, " ");

        itemHandler.createItem(inv31, "gray_stained_glass_pane", 1, 33, " ");
        itemHandler.createItem(inv31, "gray_stained_glass_pane", 1, 34, " ");
        itemHandler.createItem(inv31, "gray_stained_glass_pane", 1, 35, " ");
        itemHandler.createItem(inv31, "gray_stained_glass_pane", 1, 36, " ");
        itemHandler.createItem(inv31, "gray_stained_glass_pane", 1, 37, " ");
        itemHandler.createItem(inv31, "gray_stained_glass_pane", 1, 38, " ");
        itemHandler.createItem(inv31, "gray_stained_glass_pane", 1, 39, " ");
        itemHandler.createItem(inv31, "gray_stained_glass_pane", 1, 40, " ");
        itemHandler.createItem(inv31, "stonecutter", 1, 41, "");
        itemHandler.createItem(inv31, "gray_stained_glass_pane", 1, 42, " ");
        itemHandler.createItem(inv31, "gray_stained_glass_pane", 1, 43, " ");
        itemHandler.createItem(inv31, "gray_stained_glass_pane", 1, 44, " ");
        itemHandler.createItem(inv31, "gray_stained_glass_pane", 1, 45, " ");
        itemHandler.createItem(inv31, "gray_stained_glass_pane", 1, 46, " ");
        itemHandler.createItem(inv31, "gray_stained_glass_pane", 1, 47, " ");
        itemHandler.createItem(inv31, "gray_stained_glass_pane", 1, 48, " ");
        itemHandler.createItem(inv31, "gray_stained_glass_pane", 1, 49, " ");
        itemHandler.createItem(inv31, "gray_stained_glass_pane", 1, 50, " ");
        itemHandler.createItem(inv31, "gray_stained_glass_pane", 1, 51, " ");
        itemHandler.createItem(inv31, "gray_stained_glass_pane", 1, 52, " ");
        itemHandler.createItem(inv31, "gray_stained_glass_pane", 1, 53, " ");
        itemHandler.createItem(inv31, "gray_stained_glass_pane", 1, 54, " ");


        toReturn.setContents(inv31.getContents());
        return toReturn;
    }

    public Inventory tamir(Player p) {
        Inventory toReturn = Bukkit.createInventory(null, inv_rows, inventory_name28);

        itemHandler.createItem(inv33, "arrow", 1, 1, "&eGeri D??n.");
        itemHandler.createItem(inv33, "white_stained_glass_pane", 1, 2, " ");
        itemHandler.createItem(inv33, "white_stained_glass_pane", 1, 3, " ");
        itemHandler.createItem(inv33, "white_stained_glass_pane", 1, 4, " ");
        itemHandler.createItem(inv33, "anvil", 1, 5, ChatColor.WHITE + "Tamir Et",
                ChatColor.GRAY + "Elindeki ekipman?? burada tamir edebilirsin.",
                ChatColor.GRAY + "Ama tamir etmek i??in biraz da olsa hurdan olmas?? gerek!");
        itemHandler.createItem(inv33, "white_stained_glass_pane", 1, 6, " ");
        itemHandler.createItem(inv33, "white_stained_glass_pane", 1, 7, " ");
        itemHandler.createItem(inv33, "white_stained_glass_pane", 1, 8, " ");
        itemHandler.createItem(inv33, "white_stained_glass_pane", 1, 9, " ");
        itemHandler.createItem(inv33, "black_stained_glass_pane", 1, 10, " ");
        itemHandler.createItem(inv33, "black_stained_glass_pane", 1, 11, " ");
        itemHandler.createItem(inv33, "black_stained_glass_pane", 1, 12, " ");
        itemHandler.createItem(inv33, "black_stained_glass_pane", 1, 13, " ");
        itemHandler.createItem(inv33, "black_stained_glass_pane", 1, 14, " ");
        itemHandler.createItem(inv33, "black_stained_glass_pane", 1, 15, " ");
        itemHandler.createItem(inv33, "black_stained_glass_pane", 1, 16, " ");
        itemHandler.createItem(inv33, "black_stained_glass_pane", 1, 17, " ");
        itemHandler.createItem(inv33, "black_stained_glass_pane", 1, 18, " ");
        itemHandler.createItem(inv33, "gray_stained_glass_pane", 1, 19, " ");
        itemHandler.createItem(inv33, "gray_stained_glass_pane", 1, 20, " ");
        itemHandler.createItem(inv33, "gray_stained_glass_pane", 1, 21, " ");
        itemHandler.createItem(inv33, "gray_stained_glass_pane", 1, 22, " ");
        itemHandler.createItem(inv33, "gray_stained_glass_pane", 1, 23, " ");
        itemHandler.createItem(inv33, "gray_stained_glass_pane", 1, 24, " ");
        itemHandler.createItem(inv33, "gray_stained_glass_pane", 1, 25, " ");
        itemHandler.createItem(inv33, "gray_stained_glass_pane", 1, 26, " ");
        itemHandler.createItem(inv33, "gray_stained_glass_pane", 1, 27, " ");
        itemHandler.createItem(inv33, "gray_stained_glass_pane", 1, 28, " ");
        itemHandler.createItem(inv33, "gray_stained_glass_pane", 1, 29, " ");
        itemHandler.createItem(inv33, "gray_stained_glass_pane", 1, 30, " ");
        itemHandler.createItem(inv33, "gray_stained_glass_pane", 1, 31, " ");

        itemHandler.createItem(inv33, "gray_stained_glass_pane", 1, 33, " ");
        itemHandler.createItem(inv33, "gray_stained_glass_pane", 1, 34, " ");
        itemHandler.createItem(inv33, "gray_stained_glass_pane", 1, 35, " ");
        itemHandler.createItem(inv33, "gray_stained_glass_pane", 1, 36, " ");
        itemHandler.createItem(inv33, "gray_stained_glass_pane", 1, 37, " ");
        itemHandler.createItem(inv33, "gray_stained_glass_pane", 1, 38, " ");
        itemHandler.createItem(inv33, "gray_stained_glass_pane", 1, 39, " ");
        itemHandler.createItem(inv33, "gray_stained_glass_pane", 1, 40, " ");
        itemHandler.createItem(inv33, "anvil", 1, 41, "");
        itemHandler.createItem(inv33, "gray_stained_glass_pane", 1, 42, " ");
        itemHandler.createItem(inv33, "gray_stained_glass_pane", 1, 43, " ");
        itemHandler.createItem(inv33, "gray_stained_glass_pane", 1, 44, " ");
        itemHandler.createItem(inv33, "gray_stained_glass_pane", 1, 45, " ");
        itemHandler.createItem(inv33, "gray_stained_glass_pane", 1, 46, " ");
        itemHandler.createItem(inv33, "gray_stained_glass_pane", 1, 47, " ");
        itemHandler.createItem(inv33, "gray_stained_glass_pane", 1, 48, " ");
        itemHandler.createItem(inv33, "gray_stained_glass_pane", 1, 49, " ");
        itemHandler.createItem(inv33, "gray_stained_glass_pane", 1, 50, " ");
        itemHandler.createItem(inv33, "gray_stained_glass_pane", 1, 51, " ");
        itemHandler.createItem(inv33, "gray_stained_glass_pane", 1, 52, " ");
        itemHandler.createItem(inv33, "gray_stained_glass_pane", 1, 53, " ");
        itemHandler.createItem(inv33, "gray_stained_glass_pane", 1, 54, " ");


        toReturn.setContents(inv33.getContents());
        return toReturn;
    }

    public Inventory elsanatproduct(Player p) {
        Inventory toReturn = Bukkit.createInventory(null, inv_rows11, "El Sanatlar?? Masas?? -> ??retimler");

        itemHandler.createItem(inv23, "arrow", 1, 1, "&eGeri D??n.");
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
        Inventory toReturn = Bukkit.createInventory(null, inv_rows11, "Maden F??r??n?? -> ??retimler");

        itemHandler.createItem(inv8, "arrow", 1, 1, "&eGeri D??n.");
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

        itemHandler.createItem(inv6, "arrow", 1, 1, "&eGeri D??n.");
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
            itemHandler.createItem(inv6, "red_stained_glass_pane", 1, 13, Painter.paint("&c1. Bo?? ??retim Alan??"),
                    Painter.paint("&7Ekipman ??retmek i??in &e&lSa?? T??kla."));
        }
        itemHandler.createItem(inv6, "black_stained_glass_pane", 1, 14, " ");
        if (timer2 <= 0) {
            itemHandler.createItem(inv6, "red_stained_glass_pane", 1, 15, Painter.paint("&c2. Bo?? ??retim Alan??"),
                    Painter.paint("&7- &fGereken Ustal??k: &a10"),
                    Painter.paint("&7Ekipman ??retmek i??in &e&lSa?? T??kla."));

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


    public Inventory seyehat(Player p) {
        Inventory toReturn = Bukkit.createInventory(null, inv_rows6, inventory_name27);

        itemHandler.createItem(inv32, "red_stained_glass_pane", 1, 1, " ");
        itemHandler.createItem(inv32, "black_stained_glass_pane", 1, 2, " ");
        itemHandler.createItem(inv32, "black_stained_glass_pane", 1, 3, " ");
        itemHandler.createItem(inv32, "black_stained_glass_pane", 1, 4, " ");
        itemHandler.createItem(inv32, "black_stained_glass_pane", 1, 5, " ");
        itemHandler.createItem(inv32, "black_stained_glass_pane", 1, 6, " ");
        itemHandler.createItem(inv32, "black_stained_glass_pane", 1, 7, " ");
        itemHandler.createItem(inv32, "black_stained_glass_pane", 1, 8, " ");
        itemHandler.createItem(inv32, "red_stained_glass_pane", 1, 9, " ");
        itemHandler.createItem(inv32, "red_stained_glass_pane", 1, 10, " ");
        itemHandler.createItem(inv32, "black_stained_glass_pane", 1, 11, " ");
        itemHandler.createItem(inv32, "black_stained_glass_pane", 1, 13, " ");
        itemHandler.createItem(inv32, "black_stained_glass_pane", 1, 15, " ");
        itemHandler.createItem(inv32, "black_stained_glass_pane", 1, 14, " ");
        itemHandler.createItem(inv32, "smithing_table", 1, 12, ChatColor.WHITE + "Ekipman ????le",
                ChatColor.GRAY + "Burada elindeki malzemelerle neler yapabilece??ine",
                ChatColor.GRAY + "bak??p yeni ekipmanlar i??leyebilirsin.", Painter.paint("&7A??mak i??in &e&lSa?? T??kla!"));
        itemHandler.createItem(inv32, "anvil", 1, 14, ChatColor.WHITE + "Tamir Et",
                ChatColor.GRAY + "Elindeki ekipman?? burada tamir edebilirsin.",
                ChatColor.GRAY + "Ama tamir etmek i??in biraz da olsa hurdan olmas?? gerek!",
                Painter.paint("&7A??mak i??in &e&lSa?? T??kla!"));
        itemHandler.createItem(inv32, "stonecutter", 1, 16, ChatColor.WHITE + "Hurdaya ??evir",
                ChatColor.GRAY + "Elindeki ekipman?? burada hurdaya ??evirebilirsin.",
                ChatColor.GRAY + "Ekipman??n ana malzemelerinin bir k??sm?? sana geri d??ner.",
                Painter.paint("&7A??mak i??in &e&lSa?? T??kla!"));

        itemHandler.createItem(inv32, "black_stained_glass_pane", 1, 17, " ");
        itemHandler.createItem(inv32, "red_stained_glass_pane", 1, 18, " ");
        itemHandler.createItem(inv32, "red_stained_glass_pane", 1, 19, " ");
        itemHandler.createItem(inv32, "black_stained_glass_pane", 1, 20, " ");

        itemHandler.createItem(inv32, "black_stained_glass_pane", 1, 21, " ");
        itemHandler.createItem(inv32, "black_stained_glass_pane", 1, 22, " ");
        itemHandler.createItem(inv32, "black_stained_glass_pane", 1, 23, " ");
        itemHandler.createItem(inv32, "black_stained_glass_pane", 1, 24, " ");
        itemHandler.createItem(inv32, "black_stained_glass_pane", 1, 25, " ");
        itemHandler.createItem(inv32, "black_stained_glass_pane", 1, 26, " ");
        itemHandler.createItem(inv32, "red_stained_glass_pane", 1, 27, " ");
        toReturn.setContents(inv32.getContents());
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
        itemHandler.createItem(inv9, "smithing_table", 1, 12, ChatColor.WHITE + "Ekipman ????le",
                ChatColor.GRAY + "Burada elindeki malzemelerle neler yapabilece??ine",
                ChatColor.GRAY + "bak??p yeni ekipmanlar i??leyebilirsin.", Painter.paint("&7A??mak i??in &e&lSa?? T??kla!"));
        itemHandler.createItem(inv9, "anvil", 1, 14, ChatColor.WHITE + "Tamir Et",
                ChatColor.GRAY + "Elindeki ekipman?? burada tamir edebilirsin.",
                ChatColor.GRAY + "Ama tamir etmek i??in biraz da olsa hurdan olmas?? gerek!",
                Painter.paint("&7A??mak i??in &e&lSa?? T??kla!"));
        itemHandler.createItem(inv9, "stonecutter", 1, 16, ChatColor.WHITE + "Hurdaya ??evir",
                ChatColor.GRAY + "Elindeki ekipman?? burada hurdaya ??evirebilirsin.",
                ChatColor.GRAY + "Ekipman??n ana malzemelerinin bir k??sm?? sana geri d??ner.",
                Painter.paint("&7A??mak i??in &e&lSa?? T??kla!"));

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
                ChatColor.GRAY + "Burada elindeki yay par??alar?? ile hangi ekipmanlar?? yapabilece??ine",
                ChatColor.GRAY + "bak??p yeni ekipmanlar elde edebilirsin.", Painter.paint("&7A??mak i??in &e&lSa?? T??kla!"));
        itemHandler.createItem(inv17, "leather", 1, 14, ChatColor.WHITE + "Deri Dik",
                ChatColor.GRAY + "Burada elindeki derilerle hangi ekipmanlar?? yapabilece??ine",
                ChatColor.GRAY + "bak??p yeni ekipmanlar elde edebilirsin.", Painter.paint("&7A??mak i??in &e&lSa?? T??kla!"));
        itemHandler.createItem(inv17, "fishing_rod", 1, 16, ChatColor.WHITE + "Olta Kur",
                ChatColor.GRAY + "Burada elindeki olta par??alar??yla hangi ekipmanlar?? yapabilece??ine",
                ChatColor.GRAY + "bak??p yeni ekipmanlar elde edebilirsin.", Painter.paint("&7A??mak i??in &e&lSa?? T??kla!"));

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
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.WHITE + "Ekipman ????le")) {
            p.openInventory(GUI2(p));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Aksesuarlar??n")) {
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
                meta.setDisplayName(ChatColor.LIGHT_PURPLE + "T??ls??m/Ok K??l??f??" + ChatColor.GRAY + " ("
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
                meta.setDisplayName(ChatColor.GOLD + "Y??z??k" + ChatColor.GRAY + " ("
                        + list.get(3).getItemMeta().getDisplayName() + ChatColor.GRAY + ")");
                yuzuk.setItemMeta(meta);
                p.getOpenInventory().getTopInventory().setItem(34, yuzuk);
            }
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "G??rev Defteri")) {
            p.openInventory(questbook(p));
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
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Painter.paint("&6F??r??n Deposu"))) {
            Inventory baba = JoinListener.getRealfurnacemenu().get(p.getUniqueId());
            p.openInventory(baba);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Painter.paint("&6Maden F??r??n?? Deposu"))) {
            Inventory baba = JoinListener.getFurnacemenu().get(p.getUniqueId());
            p.openInventory(baba);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Painter.paint("&6El Sanatlar?? Deposu"))) {
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
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY + "??oklu Vuru?? Ses Efekti")) {
            if (stats.getSaldiriHiziAyar(p.getUniqueId())) {
                stats.setSaldiriHiziAyar(p.getUniqueId(), false);
                itemHandler.createItem(inv, "sunflower", 1, 31, ChatColor.GRAY + "??oklu Vuru?? Ses Efekti",
                        ChatColor.DARK_RED + "Deaktif",
                        ChatColor.DARK_GRAY + "" + ChatColor.ITALIC + "(Sald??r?? H??z??ndan Gelen ??oklu Vuru??)");
            } else {
                stats.setSaldiriHiziAyar(p.getUniqueId(), true);
                itemHandler.createItem(inv, "sunflower", 1, 31, ChatColor.GRAY + "??oklu Vuru?? Ses Efekti",
                        ChatColor.DARK_GREEN + "Aktif",
                        ChatColor.DARK_GRAY + "" + ChatColor.ITALIC + "(Sald??r?? H??z??ndan Gelen ??oklu Vuru??)");
            }
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName() && clicked.getItemMeta()
                .getDisplayName().equalsIgnoreCase(ChatColor.GRAY + "A??a??lardan Yaprak D????me Animasyonu")) {
            if (stats.getYaprakAyar(p.getUniqueId())) {
                stats.setYaprakAyar(p.getUniqueId(), false);
                itemHandler.createItem(inv, "oak_leaves", 1, 33, ChatColor.GRAY + "A??a??lardan Yaprak D????me Animasyonu",
                        ChatColor.DARK_RED + "Deaktif");
            } else {
                stats.setYaprakAyar(p.getUniqueId(), true);
                itemHandler.createItem(inv, "oak_leaves", 1, 33, ChatColor.GRAY + "A??a??lardan Yaprak D????me Animasyonu",
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
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.WHITE + "Olta Kur")) {
            p.openInventory(Rod(p));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "??al????ma Alan??")) {
            p.openWorkbench(p.getLocation(), true);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Pi??mi?? Patates")) {
            itemHandler.cooking2(p, itemHandler.patato, itemHandler.bakedpotato, 1, 1, 1, itemHandler.coal, 3, 5, "Pi??mi?? Patates");
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Domuz Past??rmas??")) {
            itemHandler.cooking2(p, itemHandler.rawpork, itemHandler.cookedpork, 2, 1, 1, itemHandler.coal, 6, 9, "Domuz Past??rmas??");
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Pi??mi?? Morina")) {
            itemHandler.cooking2(p, itemHandler.rawcod, itemHandler.cookedcod, 1, 1, 1, itemHandler.coal, 6, 5, "Pi??mi?? Morina");
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Pi??mi?? Somon")) {
            itemHandler.cooking2(p, itemHandler.rawsalmon, itemHandler.cookedsalmon, 1, 1, 1, itemHandler.coal, 6, 5, "Pi??mi?? Somon");
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Biftek")) {
            itemHandler.cooking2(p, itemHandler.rawbeef, itemHandler.cookedbeef, 2, 1, 1, itemHandler.coal, 7, 12, "Biftek");
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Pi??mi?? Antrikot")) {
            itemHandler.cooking3(p, itemHandler.rawbeef, itemHandler.antrikot, 2, 1, 1, itemHandler.coal, itemHandler.salt, 2, 10, 22, "Antrikot");
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Pi??mi?? G??m???? Bal??????")) {
            itemHandler.cooking2(p, itemHandler.silverfish, itemHandler.cookedsilverfish, 1, 1, 1, itemHandler.coal, 7, 20, "Pi??mi?? G??m???? Bal??????");
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Pi??mi?? Tavuk Eti")) {
            itemHandler.cooking2(p, itemHandler.rawchicken, itemHandler.cookedchicken, 1, 1, 1, itemHandler.coal, 6, 10, "Pi??mi?? Tavuk Eti");
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Pi??mi?? Koyun Budu")) {
            itemHandler.cooking2(p, itemHandler.rawmutton, itemHandler.cookedmutton, 1, 1, 1, itemHandler.coal, 8, 12, "Pi??mi?? Koyun Budu");
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Bak??r Ekipmanlar")) {
            p.openInventory(t1Ekipman(p));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Bronz Ekipmanlar")) {
            p.openInventory(resourceSmith(p, "Bronz", "Ekipman ????leme -> Bronz Ekipmanlar", 1, "Me??e"));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY + "Demir Ekipmanlar")) {
            p.openInventory(resourceSmith(p, "Demir", "Ekipman ????leme -> Demir Ekipmanlar", 2, "Hu??"));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Alt??n Ekipmanlar")) {
            p.openInventory(resourceSmith(p, "Alt??n", "Ekipman ????leme -> Alt??n Ekipmanlar", 9, "Hu??"));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_PURPLE + "Obsidyen Ekipmanlar")) {
            p.openInventory(resourceSmith(p, "Obsidyen", "Ekipman ????leme -> Obsidyen Ekipmanlar", 7, "A????r"));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Adamantium Ekipmanlar")) {
            p.openInventory(resourceSmith(p, "Adamantium", "Ekipman ????leme -> Adamantium Ekipmanlar", 5, "Kara Me??e"));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_GRAY + "Netherit Ekipmanlar")) {
            p.openInventory(resourceSmith(p, "Netherit", "Ekipman ????leme -> Netherit Ekipmanlar", 10, "A????r"));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_AQUA + "Mitril Ekipmanlar")) {
            p.openInventory(resourceSmith(p, "Mitril", "Ekipman ????leme -> Mitril Ekipmanlar", 4, "Ya??l?? Me??e"));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_PURPLE + "Hi??lik Ekipmanlar")) {
            p.openInventory(resourceSmith(p, "Hi??lik", "Ekipman ????leme -> Hi??lik Ekipmanlar", 4, "Ya??l?? Me??e"));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Rodonit Ekipmanlar")) {
            p.openInventory(resourceSmith(p, "Rodonit", "Ekipman ????leme -> Rodonit Ekipmanlar", 3, "A????r"));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "K??z??l Metal Ekipmanlar")) {
            p.openInventory(resourceSmith(p, "K??z??l Metal", "Ekipman ????leme -> K??z??l Metal Ekipmanlar", 6, "Akasya"));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Spektral Ekipmanlar")) {
            p.openInventory(resourceSmith(p, "Spektral", "Ekipman ????leme -> Spektral Ekipmanlar", 11, "??lah S??????t"));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "??nek Derisinden Ekipmanlar")) {
            p.openInventory(leatherSmith(p, "??nek", "Deri Dik -> ??nek Derisinden Ekipmanlar", 104));
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
            p.openInventory(leatherSmith(p, "Kurt", "Deri Dik -> Kurt Derisinden Ekipmanlar", 107));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Tav??an Derisinden Ekipmanlar")) {
            p.openInventory(leatherSmith(p, "Tav??an", "Deri Dik -> Tav??an Derisinden Ekipmanlar", 100));
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
            p.openInventory(leatherSmith(p, "Zefir", "Deri Dik -> Zefir Derisinden Ekipmanlar", 109));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Niteliklerin")) {
            p.openInventory(nitelik(p));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
                && clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Oldu??un B??lgeyi Sahiplen")) {
            if (p.getWorld().getName().equals("remielsurvival")) {
                ItemStack ingrident = itemHandler.oakwood;
                ItemStack ingrident2 = itemHandler.ironingot;
                ItemStack ingrident3 = itemHandler.bronzeingot;
                ItemStack ingrident4 = itemHandler.cobblestone;
                ItemStack ingrident5 = itemHandler.coal;

                ingrident.setAmount(200);
                ingrident2.setAmount(64);
                ingrident3.setAmount(33);
                ingrident4.setAmount(256);
                ingrident5.setAmount(128);
                if (p.getInventory().containsAtLeast(ingrident, 200) && p.getInventory().containsAtLeast(ingrident2, 64) && p.getInventory().containsAtLeast(ingrident3, 33) && p.getInventory().containsAtLeast(ingrident4, 256) && p.getInventory().containsAtLeast(ingrident5, 128)) {

                    p.getInventory().removeItem(ingrident);
                    p.getInventory().removeItem(ingrident2);
                    p.getInventory().removeItem(ingrident3);
                    p.getInventory().removeItem(ingrident4);
                    p.getInventory().removeItem(ingrident5);

                    Chunk chunk = p.getLocation().getChunk();
                    String chunkID = chunk.getX() + "." + chunk.getZ();
                    if (!(stats.getChunkmap().containsValue(p.getUniqueId()))) {


                        if (stats.isChunk(chunkID)) {
                            p.showTitle(

                                    Title.title(
                                            MiniMessage.miniMessage().deserialize("<gold>[</gold><red>B??lge Al??nm????!</red><gold>]</gold>"),
                                            MiniMessage.miniMessage().deserialize("")));
                        } else {
                            File myfile = new File(plugin.getDataFolder().getAbsolutePath() + "/house.schem");
                            ClipboardFormat format = ClipboardFormats.findByFile(myfile);
                            try (ClipboardReader reader = Objects.requireNonNull(format).getReader(new FileInputStream(myfile))) {
                                Clipboard clipboard = reader.read();
                                try (EditSession editSession = WorldEdit.getInstance().getEditSessionFactory().getEditSession(new BukkitWorld(p.getWorld()), -1)) {
                                    Operation operation = new ClipboardHolder(clipboard)
                                            .createPaste(editSession)
                                            .to(BlockVector3.at(p.getChunk().getBlock(15, p.getWorld().getHighestBlockYAt(p.getLocation()), 0).getX(), p.getWorld().getHighestBlockYAt(p.getLocation()), p.getChunk().getBlock(15, p.getWorld().getHighestBlockYAt(p.getLocation()), 0).getZ()))
                                            .ignoreAirBlocks(false)
                                            .build();
                                    Operations.complete(operation);
                                }
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                            stats.addChunk(chunkID, p.getUniqueId());
                            p.showTitle(

                                    Title.title(
                                            MiniMessage.miniMessage().deserialize("<gold>[</gold><green>B??lge Art??k Senin!</green><gold>]</gold>"),
                                            MiniMessage.miniMessage().deserialize("")));

                        }
                    } else {
                        p.closeInventory();
                        p.sendMessage(Painter.paint("&c&lZaten bir b??lgen var!"));
                    }
                } else {
                    p.closeInventory();
                    p.sendMessage(Painter.paint("&c&lMalzemelerin Eksik!"));
                    p.sendMessage(Painter.paint(""));
                    p.sendMessage(Painter.paint(" &7Gerekenler:"));
                    p.sendMessage(Painter.paint(" &7 - &f200 Me??e Odunu:"));
                    p.sendMessage(Painter.paint(" &7 - &f64 Demir:"));
                    p.sendMessage(Painter.paint(" &7 - &f33 Bronz:"));
                    p.sendMessage(Painter.paint(" &7 - &f256 K??r??kta??:"));
                    p.sendMessage(Painter.paint(" &7 - &f128 K??m??r:"));
                }
            } else {
                p.closeInventory();
                p.sendMessage(Painter.paint("&c&lK??talardan b??lge sahiplenemezsin! Kral??n Kesin Emri!"));
            }
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(Painter.paint("&eGeri D??n."))) {
            if (p.getOpenInventory().getTitle().equals(inventory_name6)) {
                p.openInventory(GUI2(p));
            }
            if (p.getOpenInventory().getTitle().contains("Demirci Masas?? ->")) {
                p.openInventory(demircimasasasas(p));
            }
            if (p.getOpenInventory().getTitle().equals(inventory_name11)) {
                p.openInventory(cookGui(p));
            }
            if (p.getOpenInventory().getTitle().contains("F??r??n ->")) {
                p.openInventory(realFurnaceGui(p));
            }
            if (p.getOpenInventory().getTitle().contains("El Sanatlar?? Masas?? ->")) {
                p.openInventory(Fletching(p));
            }
            if (p.getOpenInventory().getTitle().contains("B??y?? Masas?? ->")) {
                p.openInventory(GUIENCH(p));

            }
            if (p.getOpenInventory().getTitle().contains("Maden F??r??n?? ->")) {
                p.openInventory(Furnace(p));
            }


        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(Painter.paint("&6&lDin??lik"))) {
            if (stats.getNP(p.getUniqueId()) > 0) {
                stats.setNP(p.getUniqueId(), -1);
                stats.setharcananNP(p.getUniqueId(), 1);
                stats.setCan(p, p.getUniqueId(), 1);
                stats.setCanYenileme(p, p.getUniqueId(), 1);
                itemHandler.createItem(inv, "red_dye", 1, 29, Painter.paint("&6&lDin??lik"),
                        Painter.paint("&7Puan ba????na &6Can??n?? &e+1 &7ve"),
                        Painter.paint("&6Can Yenilenmeni &e+%1 &7artt??r??r."), "",
                        Painter.paint("&8Din??lik can de??erinizi ve can yenilenmenizi belirler."),
                        Painter.paint("&8Can de??eriniz sizi ayakta tutan ??eydir. Can yenilenmesi"),
                        Painter.paint("&8ise al??nan hasardan sonra ne kadar h??zl?? iyile??ti??inizdir."), "",
                        Painter.paint("&7Taban Din??lik: &f20 &7/ &f5"),
                        Painter.paint("&7Toplam Din??lik: &f") + stats.getCan(p.getUniqueId()) + " &7/ &f"
                                + stats.getCanYenileme(p.getUniqueId()),
                        "", Painter.paint("&7Nitelik Puan?? eklemek i??in &e&lSa?? T??kla."));
                itemHandler.createItem(inv, "experience_bottle", 1, 5, ChatColor.WHITE + "Niteliklerin",
                        ChatColor.GRAY + "Burada seviye atlayarak", ChatColor.GRAY + "kazand??????n nitelik puanlar??n??",
                        ChatColor.GRAY + "harcay??p daha da g????lenebilirsin.", "",
                        ChatColor.GOLD + "Sahip Oldu??un Nitelik Puan??: " + ChatColor.RED + stats.getNP(p.getUniqueId()));

            } else {
                itemHandler.createItem(inv, "red_dye", 1, 29, Painter.paint("&6&lDin??lik"),
                        Painter.paint("&7Puan ba????na &6Can??n?? &e+1 &7ve"),
                        Painter.paint("&6Can Yenilenmeni &e+%1 &7artt??r??r."), "",
                        Painter.paint("&8Din??lik can de??erinizi ve can yenilenmenizi belirler."),
                        Painter.paint("&8Can de??eriniz sizi ayakta tutan ??eydir. Can yenilenmesi"),
                        Painter.paint("&8ise al??nan hasardan sonra ne kadar h??zl?? iyile??ti??inizdir."), "",
                        Painter.paint("&7Taban Din??lik: &f20 &7/ &f5"),
                        Painter.paint("&7Toplam Din??lik: &f") + stats.getCan(p.getUniqueId()) + " &7/ &f"
                                + stats.getCanYenileme(p.getUniqueId()),
                        "", Painter.paint("&cYeterli Nitelik Puan??n Yok!"));
            }
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                contains(ChatColor.LIGHT_PURPLE + "T??ls??m")) {
            if (!(stats.getTilsim(p.getUniqueId()).equals("<dark_gray>Yok.."))) {
                FileConfiguration fc = stats.getStatfile().get(p.getUniqueId());
                ArrayList<ItemStack> akselist = (ArrayList<ItemStack>) stats.getStatfile().get(p.getUniqueId())
                        .get("Aksesuar." + "Hepsi");

                if (p.getInventory().firstEmpty() == -1) {
                    p.closeInventory();
                    p.sendMessage(Painter.paint("&cEnvanterinde yer yok!"));
                } else {
                    ItemStack item = Objects.requireNonNull(akselist).get(0);
                    p.getInventory().addItem(item);
                    akselist.set(0, new ItemStack(Material.AIR));
                    stats.setTilsim(p.getUniqueId(), "<dark_gray>Yok..");
                    stats.getStatfile().put(p.getUniqueId(), fc);
                    itemHandler.createItem(inv, "magenta_stained_glass_pane", 1, 29,
                            ChatColor.LIGHT_PURPLE + "T??ls??m/Ok K??l??f??", ChatColor.DARK_GRAY + "Yok..");
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
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                contains(ChatColor.BLUE + "Eldiven")) {
            if (!(stats.getEldiven(p.getUniqueId()).equals("<dark_gray>Yok.."))) {
                FileConfiguration fc = stats.getStatfile().get(p.getUniqueId());
                ArrayList<ItemStack> akselist = (ArrayList<ItemStack>) stats.getStatfile().get(p.getUniqueId())
                        .get("Aksesuar." + "Hepsi");

                if (p.getInventory().firstEmpty() == -1) {
                    p.closeInventory();
                    p.sendMessage(Painter.paint("&cEnvanterinde yer yok!"));
                } else {
                    ItemStack item = Objects.requireNonNull(akselist).get(1);
                    p.getInventory().addItem(item);
                    akselist.set(1, new ItemStack(Material.AIR));
                    stats.setEldiven(p.getUniqueId(), "<dark_gray>Yok..");
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
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                contains(ChatColor.YELLOW + "Kolye")) {
            if (!(stats.getKolye(p.getUniqueId()).equals("<dark_gray>Yok.."))) {
                FileConfiguration fc = stats.getStatfile().get(p.getUniqueId());
                ArrayList<ItemStack> akselist = (ArrayList<ItemStack>) stats.getStatfile().get(p.getUniqueId())
                        .get("Aksesuar." + "Hepsi");

                if (p.getInventory().firstEmpty() == -1) {
                    p.closeInventory();
                    p.sendMessage(Painter.paint("&cEnvanterinde yer yok!"));
                } else {
                    ItemStack item = Objects.requireNonNull(akselist).get(2);
                    p.getInventory().addItem(item);
                    akselist.set(2, new ItemStack(Material.AIR));
                    stats.setKolye(p.getUniqueId(), "<dark_gray>Yok..");
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
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                contains(ChatColor.GOLD + "Y??z??k")) {
            if (!(stats.getYuzuk(p.getUniqueId()).equals("<dark_gray>Yok.."))) {
                FileConfiguration fc = stats.getStatfile().get(p.getUniqueId());
                ArrayList<ItemStack> akselist = (ArrayList<ItemStack>) stats.getStatfile().get(p.getUniqueId())
                        .get("Aksesuar." + "Hepsi");

                if (p.getInventory().firstEmpty() == -1) {
                    p.closeInventory();
                    p.sendMessage(Painter.paint("&cEnvanterinde yer yok!"));
                } else {
                    ItemStack item = Objects.requireNonNull(akselist).get(3);
                    p.getInventory().addItem(item);
                    akselist.set(3, new ItemStack(Material.AIR));
                    stats.setYuzuk(p.getUniqueId(), "<dark_gray>Yok..");
                    stats.getStatfile().put(p.getUniqueId(), fc);
                    itemHandler.createItem(inv, "orange_stained_glass_pane", 1, 35, ChatColor.GOLD + "Y??z??k",
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
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(Painter.paint("&a&lDayan??kl??l??k"))) {
            if (stats.getNP(p.getUniqueId()) > 0) {
                stats.setNP(p.getUniqueId(), -1);
                stats.setharcananNP(p.getUniqueId(), 1);
                stats.setDirenc(p.getUniqueId(), 1);
                stats.setDoygunluk(p, p.getUniqueId(), 1);
                itemHandler.createItem(inv, "iron_chestplate", 1, 30, Painter.paint("&a&lDayan??kl??l??k"),
                        Painter.paint("&7Puan ba????na &aZ??rh De??erini &e+1"),
                        Painter.paint("&7ve &aDoygunlu??unu &e+%1 &7artt??r??r."), "",
                        Painter.paint("&8Dayan??kl??k ald??????n??z hasar?? ve i?? yapma kapasitenizi belirler."),
                        Painter.paint("&8Z??rh de??eriniz ne kadar y??ksekse al??nan hasar o kadar etkili olur,"),
                        Painter.paint("&8doygunlu??unuz ne kadar y??ksekse i?? yaparken yorulmazs??n??z."), "",
                        Painter.paint("&7Taban Dayan??kl??l??k: &f0 &7/ &f0"),
                        Painter.paint("&7Toplam Dayan??kl??l??k: &f") + stats.getDirenc(p.getUniqueId()) + " &7/ &f"
                                + stats.getDoygunluk(p.getUniqueId()),
                        "", Painter.paint("&7Nitelik Puan?? eklemek i??in &e&lSa?? T??kla."));
                itemHandler.createItem(inv, "experience_bottle", 1, 5, ChatColor.WHITE + "Niteliklerin",
                        ChatColor.GRAY + "Burada seviye atlayarak", ChatColor.GRAY + "kazand??????n nitelik puanlar??n??",
                        ChatColor.GRAY + "harcay??p daha da g????lenebilirsin.", "",
                        ChatColor.GOLD + "Sahip Oldu??un Nitelik Puan??: " + ChatColor.RED + stats.getNP(p.getUniqueId()));
            } else {
                itemHandler.createItem(inv, "iron_chestplate", 1, 30, Painter.paint("&a&lDayan??kl??l??k"),
                        Painter.paint("&7Puan ba????na &aDiren?? De??erini &e+1"),
                        Painter.paint("&7ve &aDoygunlu??unu &e+%1 &7artt??r??r."), "",
                        Painter.paint("&8Dayan??kl??k ald??????n??z hasar?? ve i?? yapma kapasitenizi belirler."),
                        Painter.paint("&8Diren?? de??eriniz ne kadar y??ksekse al??nan hasar o kadar az etkili olur,"),
                        Painter.paint("&8doygunlu??unuz ne kadar y??ksekse i?? yaparken yorulmazs??n??z."), "",
                        Painter.paint("&7Taban Dayan??kl??l??k: &f0 &7/ &f0"),
                        Painter.paint("&7Toplam Dayan??kl??l??k: &f") + stats.getDirenc(p.getUniqueId()) + " &7/ &f"
                                + stats.getDoygunluk(p.getUniqueId()),
                        "", Painter.paint("&cYeterli Nitelik Puan??n Yok!"));
            }
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(Painter.paint("&c&lG????"))) {
            if (stats.getNP(p.getUniqueId()) > 0) {
                stats.setNP(p.getUniqueId(), -1);
                stats.setharcananNP(p.getUniqueId(), 1);
                stats.setGuc(p.getUniqueId(), 4);
                itemHandler.createItem(inv, "blaze_powder", 1, 31, Painter.paint("&c&lG????"),
                        Painter.paint("&7Puan ba????na &cG??c??n?? &e+4 &7artt??r??r."), "",
                        Painter.paint("&8G???? hasar kaynaklar??n??zdan biridir. Ne kadar "),
                        Painter.paint("&8g????l??yseniz darbeleriniz de bir o kadar etkili olur."), "",
                        Painter.paint("&7Taban G????: &f5"),
                        Painter.paint("&7Toplam G????: &f") + stats.getGuc(p.getUniqueId()), "",
                        Painter.paint("&7Nitelik Puan?? eklemek i??in &e&lSa?? T??kla."));
                itemHandler.createItem(inv, "experience_bottle", 1, 5, ChatColor.WHITE + "Niteliklerin",
                        ChatColor.GRAY + "Burada seviye atlayarak", ChatColor.GRAY + "kazand??????n nitelik puanlar??n??",
                        ChatColor.GRAY + "harcay??p daha da g????lenebilirsin.", "",
                        ChatColor.GOLD + "Sahip Oldu??un Nitelik Puan??: " + ChatColor.RED + stats.getNP(p.getUniqueId()));
            } else {
                itemHandler.createItem(inv, "blaze_powder", 1, 31, Painter.paint("&c&lG????"),
                        Painter.paint("&7Puan ba????na &cG??c??n?? &e+4 &7artt??r??r."), "",
                        Painter.paint("&8G???? hasar kaynaklar??n??zdan biridir. Ne kadar "),
                        Painter.paint("&8g????l??yseniz darbeleriniz de bir o kadar etkili olur."), "",
                        Painter.paint("&7Taban G????: &f5"),
                        Painter.paint("&7Toplam G????: &f") + stats.getGuc(p.getUniqueId()), "",
                        Painter.paint("&cYeterli Nitelik Puan??n Yok!"));

            }
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(Painter.paint("&e&lDenge"))) {
            if (stats.getNP(p.getUniqueId()) > 0) {
                stats.setNP(p.getUniqueId(), -1);
                stats.setharcananNP(p.getUniqueId(), 1);
                stats.setSaldiriHizi(p.getUniqueId(), 2);
                itemHandler.createItem(inv, "glowstone_dust", 1, 33, Painter.paint("&e&lDenge"),
                        Painter.paint("&7Puan ba????na &eDengeni &e+2 &7artt??r??r."), "",
                        Painter.paint("&8Denge daha seri bir ??ekilde sald??rabilmenizi sa??lar."),
                        Painter.paint("&8Dengeli bir duru?? vuru??lar??n??z??n da dengeli olmas??n?? sa??lar."), "",
                        Painter.paint("&7Taban Denge: &f0"),
                        Painter.paint("&7Toplam Denge: &f") + stats.getSaldiriHizi(p.getUniqueId()), "",
                        Painter.paint("&7Nitelik Puan?? eklemek i??in &e&lSa?? T??kla."));
                itemHandler.createItem(inv, "experience_bottle", 1, 5, ChatColor.WHITE + "Niteliklerin",
                        ChatColor.GRAY + "Burada seviye atlayarak", ChatColor.GRAY + "kazand??????n nitelik puanlar??n??",
                        ChatColor.GRAY + "harcay??p daha da g????lenebilirsin.", "",
                        ChatColor.GOLD + "Sahip Oldu??un Nitelik Puan??: " + ChatColor.RED + stats.getNP(p.getUniqueId()));
            } else {
                itemHandler.createItem(inv, "glowstone_dust", 1, 33, Painter.paint("&e&lDenge"),
                        Painter.paint("&7Puan ba????na &eDengeni &e+2 &7artt??r??r."), "",
                        Painter.paint("&8Denge daha seri bir ??ekilde sald??rabilmenizi sa??lar."),
                        Painter.paint("&8Dengeli bir duru?? vuru??lar??n??z??n da dengeli olmas??n?? sa??lar."), "",
                        Painter.paint("&7Taban Denge: &f0"),
                        Painter.paint("&7Toplam Denge: &f") + stats.getSaldiriHizi(p.getUniqueId()), "",
                        Painter.paint("&cYeterli Nitelik Puan??n Yok!"));

            }
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(Painter.paint("&f&l??eviklik"))) {
            if (stats.getNP(p.getUniqueId()) > 0) {
                stats.setNP(p.getUniqueId(), -1);
                stats.setharcananNP(p.getUniqueId(), 1);
                stats.setHiz(p, p.getUniqueId(), 2);
                itemHandler.createItem(inv, "feather", 1, 34, Painter.paint("&f&l??eviklik"),
                        Painter.paint("&7Puan ba????na &f??evikli??ini &e+2 &7artt??r??r."), "",
                        Painter.paint("&8??eviklik ne kadar seri hareket etti??inizdir. ??evikli??iniz "),
                        Painter.paint("&8ne kadar y??ksekse o kadar h??zl?? hareket edersiniz."), "",
                        Painter.paint("&7Taban ??eviklik: &f0"),
                        Painter.paint("&7Toplam ??eviklik: &f") + stats.getHiz(p.getUniqueId()), "",
                        Painter.paint("&7Nitelik Puan?? eklemek i??in &e&lSa?? T??kla."));
                itemHandler.createItem(inv, "experience_bottle", 1, 5, ChatColor.WHITE + "Niteliklerin",
                        ChatColor.GRAY + "Burada seviye atlayarak", ChatColor.GRAY + "kazand??????n nitelik puanlar??n??",
                        ChatColor.GRAY + "harcay??p daha da g????lenebilirsin.", "",
                        ChatColor.GOLD + "Sahip Oldu??un Nitelik Puan??: " + ChatColor.RED + stats.getNP(p.getUniqueId()));
            } else {
                itemHandler.createItem(inv, "feather", 1, 34, Painter.paint("&f&l??eviklik"),
                        Painter.paint("&7Puan ba????na &f??evikli??ini &e+2 &7artt??r??r."), "",
                        Painter.paint("&8??eviklik ne kadar seri hareket etti??inizdir. ??evikli??iniz "),
                        Painter.paint("&8ne kadar y??ksekse o kadar h??zl?? hareket edersiniz."), "",
                        Painter.paint("&7Taban ??eviklik: &f0"),
                        Painter.paint("&7Toplam ??eviklik: &f") + stats.getHiz(p.getUniqueId()), "",
                        Painter.paint("&cYeterli Nitelik Puan??n Yok!"));
            }
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(Painter.paint("&3&lH??ner"))) {
            if (stats.getNP(p.getUniqueId()) > 0) {
                stats.setNP(p.getUniqueId(), -1);
                stats.setharcananNP(p.getUniqueId(), 1);
                stats.setKritikHasari(p.getUniqueId(), 1);
                itemHandler.createItem(inv, "nether_star", 1, 35, Painter.paint("&3&lH??ner"),
                        Painter.paint("&7Puan ba????na &3Kritik Hasar??n?? &e+1 &7artt??r??r."), "",
                        Painter.paint("&8H??ner sava??ta kulland??????n??z silah?? daha iyi kullanman??z?? sa??lar."),
                        Painter.paint("&8Silah??n?? iyi kullanan bir ki??i rakibin zay??f noktalar??n?? da g??rebilir."), "",
                        Painter.paint("&7Taban H??ner: &f12 &7/ &f0"),
                        Painter.paint("&7Toplam H??ner: &f") + stats.getKritikHasari(p.getUniqueId()) + " &7/ &f"
                                + stats.getKritikSansi(p.getUniqueId()),
                        "", Painter.paint("&7Nitelik Puan?? eklemek i??in &e&lSa?? T??kla."));
                itemHandler.createItem(inv, "experience_bottle", 1, 5, ChatColor.WHITE + "Niteliklerin",
                        ChatColor.GRAY + "Burada seviye atlayarak", ChatColor.GRAY + "kazand??????n nitelik puanlar??n??",
                        ChatColor.GRAY + "harcay??p daha da g????lenebilirsin.", "",
                        ChatColor.GOLD + "Sahip Oldu??un Nitelik Puan??: " + ChatColor.RED + stats.getNP(p.getUniqueId()));
            } else {
                itemHandler.createItem(inv, "nether_star", 1, 35, Painter.paint("&3&lH??ner"),
                        Painter.paint("&7Puan ba????na &3Kritik Hasar??n?? &e+1 &7artt??r??r."), "",
                        Painter.paint("&8H??ner sava??ta kulland??????n??z silah?? daha iyi kullanman??z?? sa??lar."),
                        Painter.paint("&8Silah??n?? iyi kullanan bir ki??i rakibin zay??f noktalar??n?? da g??rebilir."), "",
                        Painter.paint("&7Taban H??ner: &f12 &7/ &f0"),
                        Painter.paint("&7Toplam H??ner: &f") + stats.getKritikHasari(p.getUniqueId()) + " &7/ &f"
                                + stats.getKritikSansi(p.getUniqueId()),
                        "", Painter.paint("&cYeterli Nitelik Puan??n Yok!"));
            }
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "K??m??r")) {
            ItemStack coal = itemHandler.coal;
            coal.setAmount(1);
            if (p.getInventory().containsAtLeast(coal, 1)) {
                p.getInventory().removeItem(coal);
                ekonomi.depositPlayer(p.getName(), 0.5);
            } else {
                p.closeInventory();
                p.sendMessage(Painter.paint("&cMalzemen kalmad??!"));
            }
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "Kemik")) {
            ItemStack bone = itemHandler.bone;
            bone.setAmount(1);
            if (p.getInventory().containsAtLeast(bone, 1)) {
                p.getInventory().removeItem(bone);
                ekonomi.depositPlayer(p.getName(), 1);
            } else {
                p.closeInventory();
                p.sendMessage(Painter.paint("&cMalzemen kalmad??!"));
            }
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "Solmu?? Kemik")) {
            ItemStack blackbone = itemHandler.blackbone;
            blackbone.setAmount(1);
            if (p.getInventory().containsAtLeast(blackbone, 1)) {
                p.getInventory().removeItem(blackbone);
                ekonomi.depositPlayer(p.getName(), 1.4);
            } else {
                p.closeInventory();
                p.sendMessage(Painter.paint("&cMalzemen kalmad??!"));
            }
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "Me??e Odunu")) {
            ItemStack oakwood = itemHandler.oakwood;
            oakwood.setAmount(1);
            if (p.getInventory().containsAtLeast(oakwood, 1)) {
                p.getInventory().removeItem(oakwood);
                ekonomi.depositPlayer(p.getName(), 0.4);
            } else {
                p.closeInventory();
                p.sendMessage(Painter.paint("&cMalzemen kalmad??!"));
            }
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "Elma")) {
            ItemStack apple = itemHandler.apple;
            apple.setAmount(1);
            if (p.getInventory().containsAtLeast(apple, 1)) {
                p.getInventory().removeItem(apple);
                ekonomi.depositPlayer(p.getName(), 1);
            } else {
                p.closeInventory();
                p.sendMessage(Painter.paint("&cMalzemen kalmad??!"));
            }
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "Tamir Et")) {
            ItemStack item = inv.getItem(31);
            String input = String.join(" ", Objects.requireNonNull(item).getItemMeta().getDisplayName());
            Matcher matcher = DIGITS_PATTERN.matcher(input);
            NamespacedKey durabi = new NamespacedKey(plugin, "durability");
            if (matcher.find()) {
                String firstDigits = matcher.group();
                ItemStack hurda = itemHandler.hurda;
                int amount = Integer.valueOf(firstDigits) * 3;
                hurda.setAmount(amount);
                int level = p.getLevel();
                if (p.getInventory().containsAtLeast(hurda, amount) && level >= Integer.valueOf(firstDigits) * 4) {
                    Damageable meta = (Damageable) item.getItemMeta();
                    meta.setDamage(0);
                    item.setItemMeta(meta);

                    for (int i = 0; i < Objects.requireNonNull(meta.getLore()).size(); i++) {
                        String lValue = meta.getLore().get(i);
                        if (lValue.contains("???")) {
                            String input2 = String.join(" ", lValue);
                            Matcher matcher2 = DIGITS_PATTERN.matcher(input2);
                            if (matcher2.find()) {
                                String firstDigits2 = matcher2.group();
                                ItemMeta meta2 = item.getItemMeta();
                                meta2.getPersistentDataContainer().set(durabi, PersistentDataType.INTEGER, Integer.valueOf(firstDigits2));
                                item.setItemMeta(meta2);
                            }
                            break;
                        }
                    }

                    if (p.getInventory().firstEmpty() == -1) {
                        p.getWorld().dropItemNaturally(p.getLocation(), item);
                    } else {
                        p.getInventory().addItem(item);
                    }
                    p.playSound(p, Sound.BLOCK_ANVIL_USE, 2f, 0.5f);
                    p.sendMessage(Painter.paint("&6Ekipman?? Tamir Etme Ba??ar??l??!"));
                    p.closeInventory();
                }
            }

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "Hurdaya ??evir")) {
            ItemStack item = inv.getItem(31);
            String input = String.join(" ", Objects.requireNonNull(item).getItemMeta().getDisplayName());
            Matcher matcher = DIGITS_PATTERN.matcher(input);
            if (matcher.find()) {
                String firstDigits = matcher.group();
                ItemStack hurda = itemHandler.hurda;
                int amount = Integer.valueOf(firstDigits) * 2;
                hurda.setAmount(amount);

                if (p.getInventory().firstEmpty() == -1) {
                    p.getWorld().dropItemNaturally(p.getLocation(), hurda);
                } else {
                    p.getInventory().addItem(hurda);
                }
                inv.setItem(31, null);
                p.playSound(p, Sound.UI_STONECUTTER_TAKE_RESULT, 2f, 0.7f);
                p.sendMessage(Painter.paint("&6Hurdaya ??evirme Ba??ar??l??! Ekipmandan ????kan Hurda Say??s??: &f" + amount));
                p.closeInventory();

            }

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.WHITE + "Hurdaya ??evir")) {
            p.openInventory(hurda(p));

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.WHITE + "Tamir Et")) {
            p.openInventory(tamir(p));

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "Y??n K??rken")) {
            ItemStack shears = itemHandler.yunkurken;
            shears.setAmount(1);
            if (ekonomi.has(p.getName(), 100)) {
                ekonomi.withdrawPlayer(p.getName(), 100);
                if (p.getInventory().firstEmpty() == -1) {
                    p.closeInventory();
                    p.sendMessage(Painter.paint("&cEnvanterin Dolu!"));

                } else {
                    p.getInventory().addItem(shears);
                }
            } else {
                p.closeInventory();
                p.sendMessage(Painter.paint("&cDinar'??n Eksik!"));
            }
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "D??v????c?? Tuni??i")) {
            ItemStack dovuscutunigi = itemHandler.dovuscutunigi;
            dovuscutunigi.setAmount(1);
            if (ekonomi.has(p.getName(), 50)) {
                ekonomi.withdrawPlayer(p.getName(), 50);
                if (p.getInventory().firstEmpty() == -1) {
                    p.closeInventory();
                    p.sendMessage(Painter.paint("&cEnvanterin Dolu!"));

                } else {
                    p.getInventory().addItem(dovuscutunigi);
                }
            } else {
                p.closeInventory();
                p.sendMessage(Painter.paint("&cDinar'??n Eksik!"));
            }
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                contains(ChatColor.GOLD + "Geri D??n???? ??ksiri")) {
            ItemStack recallpotion = itemHandler.recallpotion;
            recallpotion.setAmount(1);
            if (ekonomi.has(p.getName(), 420)) {
                ekonomi.withdrawPlayer(p.getName(), 420);
                if (p.getInventory().firstEmpty() == -1) {
                    p.closeInventory();
                    p.sendMessage(Painter.paint("&cEnvanterin Dolu!"));

                } else {
                    p.getInventory().addItem(recallpotion);
                }
            } else {
                p.closeInventory();
                p.sendMessage(Painter.paint("&cDinar'??n Eksik!"));
            }
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "Az Kullan??lm???? M??zrak")) {
            ItemStack azkullanilmismizrak = itemHandler.azkullanilmismizrak;
            azkullanilmismizrak.setAmount(1);
            if (ekonomi.has(p.getName(), 120)) {
                ekonomi.withdrawPlayer(p.getName(), 120);
                if (p.getInventory().firstEmpty() == -1) {
                    p.closeInventory();
                    p.sendMessage(Painter.paint("&cEnvanterin Dolu!"));

                } else {
                    p.getInventory().addItem(azkullanilmismizrak);
                }
            } else {
                p.closeInventory();
                p.sendMessage(Painter.paint("&cDinar'??n Eksik!"));
            }
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(Painter.paint("&4Niteliklerini S??f??rla!"))) {
            if (zerola.containsKey(p.getUniqueId())) {
                List<Integer> statlist = new ArrayList<>();
                for (int i = 0; i < 9; i++) {
                    statlist.add(0);
                }
                List<ItemStack> itemarray = new ArrayList<ItemStack>();
                itemarray.addAll(Arrays.asList(p.getInventory().getArmorContents()));
                List<ItemStack> akselist = stats.getHepsi(p.getUniqueId());
                if (!(stats.getTilsim(p.getUniqueId()).equals("Yok.."))) {
                    itemarray.add(stats.getHepsi(p.getUniqueId()).get(0));

                }
                if (!(stats.getEldiven(p.getUniqueId()).equals("Yok.."))) {
                    itemarray.add(stats.getHepsi(p.getUniqueId()).get(1));

                }
                if (!(stats.getKolye(p.getUniqueId()).equals("Yok.."))) {
                    itemarray.add(stats.getHepsi(p.getUniqueId()).get(2));
                }
                if (!(stats.getYuzuk(p.getUniqueId()).equals("Yok.."))) {
                    itemarray.add(stats.getHepsi(p.getUniqueId()).get(3));
                }

                for (ItemStack item : itemarray) {
                    if (item != null && item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
                        NamespacedKey can = new NamespacedKey(plugin, "can");
                        NamespacedKey doygunluk = new NamespacedKey(plugin, "doygunluk");
                        NamespacedKey canyenilenmesi = new NamespacedKey(plugin, "canyenilenmesi");
                        NamespacedKey saldirihizi = new NamespacedKey(plugin, "attackspeed");
                        NamespacedKey guc = new NamespacedKey(plugin, "guc");
                        NamespacedKey zirh = new NamespacedKey(plugin, "dayaniklilik");
                        NamespacedKey kritiksansi = new NamespacedKey(plugin, "kritiksans");
                        NamespacedKey kritikhasari = new NamespacedKey(plugin, "kritik");
                        NamespacedKey hiz = new NamespacedKey(plugin, "hiz");
                        PersistentDataContainer container = item.getItemMeta().getPersistentDataContainer();
                        for (NamespacedKey key : container.getKeys()) {
                            if (key.equals(can)) {
                                if (statlist.get(0) == null) {
                                    statlist.set(0, container.get(can, PersistentDataType.INTEGER));
                                } else {
                                    int canstat = statlist.get(0) + container.get(can, PersistentDataType.INTEGER);
                                    statlist.set(0, canstat);
                                }

                            } else if (key.equals(canyenilenmesi)) {
                                if (statlist.get(1) == null) {
                                    statlist.set(1, container.get(canyenilenmesi, PersistentDataType.INTEGER));
                                } else {
                                    int canyenistat = statlist.get(1) + container.get(canyenilenmesi, PersistentDataType.INTEGER);
                                    statlist.set(1, canyenistat);
                                }

                            } else if (key.equals(guc)) {
                                if (statlist.get(2) == null) {
                                    statlist.set(2, container.get(guc, PersistentDataType.INTEGER));
                                } else {
                                    int gucstat = statlist.get(2) + container.get(guc, PersistentDataType.INTEGER);
                                    statlist.set(2, gucstat);
                                }
                            } else if (key.equals(zirh)) {
                                if (statlist.get(3) == null) {
                                    statlist.set(3, container.get(zirh, PersistentDataType.INTEGER));
                                } else {
                                    int zirhstat = statlist.get(3) + container.get(zirh, PersistentDataType.INTEGER);
                                    statlist.set(3, zirhstat);
                                }
                            } else if (key.equals(doygunluk)) {
                                if (statlist.get(4) == null) {
                                    statlist.set(4, container.get(doygunluk, PersistentDataType.INTEGER));
                                } else {
                                    int doygunstat = statlist.get(4) + container.get(doygunluk, PersistentDataType.INTEGER);
                                    statlist.set(4, doygunstat);
                                }
                            } else if (key.equals(saldirihizi)) {
                                if (statlist.get(5) == null) {
                                    statlist.set(5, container.get(saldirihizi, PersistentDataType.INTEGER));
                                } else {
                                    int saldirihizistat = statlist.get(5) + container.get(saldirihizi, PersistentDataType.INTEGER);
                                    statlist.set(5, saldirihizistat);
                                }
                            } else if (key.equals(kritikhasari)) {
                                if (statlist.get(6) == null) {
                                    statlist.set(6, container.get(kritikhasari, PersistentDataType.INTEGER));
                                } else {
                                    int kritikhasarstat = statlist.get(6) + container.get(kritikhasari, PersistentDataType.INTEGER);
                                    statlist.set(6, kritikhasarstat);
                                }
                            } else if (key.equals(kritiksansi)) {
                                if (statlist.get(7) == null) {
                                    statlist.set(7, container.get(kritiksansi, PersistentDataType.INTEGER));
                                } else {
                                    int kritiksansstat = statlist.get(7) + container.get(kritiksansi, PersistentDataType.INTEGER);
                                    statlist.set(7, kritiksansstat);
                                }
                            } else if (key.equals(hiz)) {
                                if (statlist.get(8) == null) {
                                    statlist.set(8, container.get(hiz, PersistentDataType.INTEGER));
                                } else {
                                    int hizstat = statlist.get(8) + container.get(hiz, PersistentDataType.INTEGER);
                                    statlist.set(8, hizstat);
                                }
                            }
                        }
                    }
                }

                p.closeInventory();
                p.showTitle(

                        Title.title(MiniMessage.miniMessage().deserialize("<red>Nitelikler</red>"),
                                MiniMessage.miniMessage().deserialize("<gray>S??f??rland??!</gray>")));
                stats.setNP(p.getUniqueId(), stats.getharcananNP(p.getUniqueId()));
                p.setLevel(p.getLevel() - 50);
                stats.setharcananNP(p.getUniqueId(), -stats.getharcananNP(p.getUniqueId()));
                stats.setKritikHasari(p.getUniqueId(), -stats.getKritikHasari(p.getUniqueId()) + 12 + statlist.get(6));
                stats.setKritikSansi(p.getUniqueId(), -stats.getKritikSansi(p.getUniqueId()) + statlist.get(7));
                stats.setCan(p, p.getUniqueId(), -stats.getCan(p.getUniqueId()) + 100 + statlist.get(0));
                stats.setCanYenileme(p, p.getUniqueId(), -stats.getCanYenileme(p.getUniqueId()) + 5 + statlist.get(1));
                stats.setDoygunluk(p, p.getUniqueId(), -stats.getDoygunluk(p.getUniqueId()) + statlist.get(4));
                stats.setGuc(p.getUniqueId(), -stats.getGuc(p.getUniqueId()) + 5 + statlist.get(2));
                stats.setDirenc(p.getUniqueId(), -stats.getDirenc(p.getUniqueId()) + statlist.get(3));
                stats.setHiz(p, p.getUniqueId(), -stats.getHiz(p.getUniqueId()) + statlist.get(8));
                stats.setSaldiriHizi(p.getUniqueId(), -stats.getSaldiriHizi(p.getUniqueId()) + statlist.get(5));
                zerola.remove(p.getUniqueId());
            } else {
                if (stats.getharcananNP(p.getUniqueId()) > 3) {
                    if (p.getLevel() >= 50) {
                        int harcanannp = stats.getharcananNP(p.getUniqueId());
                        itemHandler.createItem(inv, "barrier", 1, 23, Painter.paint("&4Niteliklerini S??f??rla!"),
                                Painter.paint("&7Niteliklerini s??f??rlamak harcad??????n puanlar?? sana geri"),
                                Painter.paint("&7kazand??r??r. Fakat 50 Seviyen yok olur."), "",
                                Painter.paint("&fKazan??lacak Nitelik Puanlar??: &a" + harcanannp), "",
                                Painter.paint("&C&lEmin misin? Eminsen bir daha t??kla."));
                        zerola.put(p.getUniqueId(), p.getName());
                    } else {
                        itemHandler.createItem(inv, "barrier", 1, 23, Painter.paint("&4Niteliklerini S??f??rla!"),
                                Painter.paint("&7Niteliklerini s??f??rlamak harcad??????n puanlar?? sana geri"),
                                Painter.paint("&7kazand??r??r. Fakat 50 Seviyen yok olur."), "",
                                Painter.paint("&fKazan??lacak Nitelik Puanlar??: &a" + 0), "",
                                Painter.paint("&CYeterli Seviyen Yok!"));
                    }
                } else {
                    int harcanannp = stats.getharcananNP(p.getUniqueId());
                    itemHandler.createItem(inv, "barrier", 1, 23, Painter.paint("&4Niteliklerini S??f??rla!"),
                            Painter.paint("&7Niteliklerini s??f??rlamak harcad??????n puanlar?? sana geri"),
                            Painter.paint("&7kazand??r??r. Fakat 50 Seviyen yok olur."), "",
                            Painter.paint("&fKazan??lacak Nitelik Puanlar??: &a" + 0), "",
                            Painter.paint("&CYeterince Nitelik Puan?? Kullanmam????s??n!"));
                }
            }

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Cam")) {
            itemHandler.realFurnaceSmelt(p, itemHandler.sand, itemHandler.glass, 1, 1, 1, itemHandler.coal, 2, Component.text(itemHandler.glass.getAmount() + " x").append(itemHandler.glass.displayName()));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "K??m??r")) {
            itemHandler.realFurnaceSmelt(p, itemHandler.oakwood, itemHandler.coal, 1, 1, 1, itemHandler.oakwood, 2, Component.text(itemHandler.coal.getAmount() + " x").append(itemHandler.coal.displayName()));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Tu??la")) {
            itemHandler.realFurnaceSmelt(p, itemHandler.clay, itemHandler.brick, 1, 1, 1, itemHandler.coal, 2, Component.text(itemHandler.brick.getAmount() + " x").append(itemHandler.brick.displayName()));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Ekmek")) {
            itemHandler.cooking2(p, itemHandler.wheat, itemHandler.bread, 3, 1, 1, itemHandler.coal, 6, 10, itemHandler.bread.getItemMeta().getDisplayName());
        }

        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "Bak??r K??l??esi")) {
            itemHandler.Smelting(p, itemHandler.copperore, itemHandler.copperingot, 1, 1, 2, itemHandler.coal, 3, Component.text(itemHandler.copperingot.getAmount() + " x").append(itemHandler.copperingot.displayName()));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GRAY + "Demir K??l??esi")) {
            itemHandler.Smelting(p, itemHandler.ironore, itemHandler.ironingot, 1, 1, 3, itemHandler.coal, 4, Component.text(itemHandler.ironingot.getAmount() + " x").append(itemHandler.ironingot.displayName()));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GRAY + "G??m???? K??l??esi")) {
            itemHandler.Smelting(p, itemHandler.silverore, itemHandler.silveringot, 1, 1, 3, itemHandler.coal, 6, Component.text(itemHandler.silveringot.getAmount() + " x").append(itemHandler.silveringot.displayName()));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.WHITE + "Nikel K??l??esi")) {
            itemHandler.Smelting(p, itemHandler.nikelore, itemHandler.nikelingot, 1, 1, 2, itemHandler.coal, 4, Component.text(itemHandler.nikelingot.getAmount() + " x").append(itemHandler.nikelingot.displayName()));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Alt??n K??l??esi")) {
            itemHandler.Smelting(p, itemHandler.goldore, itemHandler.goldingot, 1, 1, 3, itemHandler.coal, 5, Component.text(itemHandler.goldingot.getAmount() + " x").append(itemHandler.goldingot.displayName()));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.DARK_AQUA + "Mitril K??l??esi")) {
            itemHandler.Smelting(p, itemHandler.mithrilore, itemHandler.mithrilingot, 3, 1, 1, itemHandler.lavabucket, 10, Component.text(itemHandler.mithrilingot.getAmount() + " x").append(itemHandler.mithrilingot.displayName()));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.AQUA + "Adamantium K??l??esi")) {
            itemHandler.Smelting(p, itemHandler.adamantiumingot, itemHandler.adamantiumingot, 1, 1, 4, itemHandler.coal, 13, Component.text(itemHandler.adamantiumingot.getAmount() + " x").append(itemHandler.mithrilingot.displayName()));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.DARK_PURPLE + "Obsidyen K??l??esi")) {
            itemHandler.Smelting2(p, itemHandler.obsidianore, itemHandler.obsidianingot, 1, 1, 4, 2, itemHandler.coal, itemHandler.nikelore, 12, Component.text(itemHandler.obsidianingot.getAmount() + " x").append(itemHandler.obsidianingot.displayName()));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.DARK_GRAY + "Netherit K??l??esi")) {
            itemHandler.Smelting2(p, itemHandler.netheriteore, itemHandler.netheriteingot, 2, 1, 4, 2, itemHandler.coal, itemHandler.ironore, 12, Component.text(itemHandler.netheriteingot.getAmount() + " x").append(itemHandler.netheriteingot.displayName()));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.RED + "K??z??l Metal K??l??esi")) {
            itemHandler.Smelting2(p, itemHandler.crimsonore, itemHandler.crimsoningot, 2, 1, 1, 1, itemHandler.lavabucket, itemHandler.netheriteore, 12, Component.text(itemHandler.crimsoningot.getAmount() + " x").append(itemHandler.crimsoningot.displayName()));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.DARK_PURPLE + "Hi??lik K??l??esi")) {
            itemHandler.Smelting2(p, itemHandler.voidlore, itemHandler.voidingot, 3, 1, 1, 2, itemHandler.lavabucket, itemHandler.crimsonore, 12, Component.text(itemHandler.voidingot.getAmount() + " x").append(itemHandler.voidingot.displayName()));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.RED + "Rodonit K??l??esi")) {
            itemHandler.Smelting2(p, itemHandler.rodonitore, itemHandler.rodonitingot, 3, 1, 1, 2, itemHandler.lavabucket, itemHandler.obsidianore, 12, Component.text(itemHandler.rodonitingot.getAmount() + " x").append(itemHandler.rodonitingot.displayName()));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.AQUA + "Spektral K??l??esi")) {
            itemHandler.Smelting3(p, itemHandler.spektralore, itemHandler.spektralingot, 1, 1, 4, 1, 2, 1, itemHandler.rodonitore, itemHandler.lavabucket, itemHandler.obsidianore, itemHandler.mithrilore, 12, Component.text(itemHandler.spektralingot.getAmount() + " x").append(itemHandler.spektralingot.displayName()));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "Bronz K??l??esi")) {
            itemHandler.Smelting2(p, itemHandler.copperore, itemHandler.bronzeingot, 1, 1, 2, 1, itemHandler.coal, itemHandler.nikelore, 5, Component.text(itemHandler.bronzeingot.getAmount() + " x").append(itemHandler.bronzeingot.displayName()));
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Bak??r K??l????")) {
            itemHandler.createWeapon(p, itemHandler.copperingot, itemHandler.oakstick, 3, 2,
                    new ItemStack(Material.WOODEN_SWORD), "<gold><i:false>Bak??r K??l????", 2, 6, 4, 2, 2, false, 2, 10, 6, "D??????k", 5,
                    6, 10, 8, 10, "K??l????", 200, 2);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "A????r Bak??r K??l????")) {
            itemHandler.createWeapon(p, itemHandler.copperingot, itemHandler.oakstick, 5, 3,
                    new ItemStack(Material.DIAMOND_SWORD), "<gold><i:false>A????r Bak??r K??l????", 2, 8, 4, 2, 0, false, 2, 10, 6, "Orta", 5,
                    6, 10, 8, 10, "A????r K??l????", 200, 2);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Bak??r Han??er")) {
            itemHandler.createWeapon(p, itemHandler.copperingot, itemHandler.oakstick, 3, 1,
                    new ItemStack(Material.SHEARS), "<gold><i:false>Bak??r Han??er", 2, 6, 7, 5, 0, false, 2, 10, 5, "D??????k", 5, 6, 10,
                    8, 10, "Han??er", 200, 2);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Hu?? Yay")) {
            itemHandler.createWeaponWork(p, itemHandler.birchstick, itemHandler.string, 4, 3,
                    3, new ItemStack(Material.BOW), "<white><i:false>Hu?? Yay", 1, 8, 9, 6, 1, false, 4, 0, 3, "D??????k", 0, 6, 8,
                    12, 2, "Yay", 250, 2);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Me??e Olta")) {
            itemHandler.createWeaponWork(p, itemHandler.oakstick, itemHandler.string, 5, 4,
                    8, new ItemStack(Material.FISHING_ROD), "<gold><i:false>Me??e Olta", 1, 6, 0, 0, 0, false, 5, 4, 0, "D??????k", 5, 6, 10,
                    10, 4, "Olta", 200, 2);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Hu?? Olta")) {
            itemHandler.createWeaponWork(p, itemHandler.birchstick, itemHandler.string, 5, 4,
                    8, new ItemStack(Material.FISHING_ROD), "<white<i:false>Hu?? Olta", 1, 7, 0, 0, 0, false, 5, 4, 0, "D??????k", 5, 6, 12,
                    16, 4, "Olta", 400, 2);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Me??e Yay")) {
            itemHandler.createWeaponWork(p, itemHandler.oakstick, itemHandler.string, 4, 3,
                    8, new ItemStack(Material.BOW), "<gold><i:false>Me??e Yay", 1, 6, 7, 5, 0, false, 5, 0, 5, "D??????k", 0, 6, 10,
                    10, 2, "Yay", 200, 1);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Ya??l?? Me??e Yay")) {
            itemHandler.createWeaponWork(p, itemHandler.oldoakstick, itemHandler.string, 4, 3,
                    3, new ItemStack(Material.BOW), "<white><i:false>Ya??l?? Me??e Yay", 1, 8, 9, 6, 1, false, 4, 0, 3, "D??????k", 0, 6, 8,
                    17, 2, "Yay", 250, 2);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Bak??r T??rpan")) {
            itemHandler.createWeapon(p, itemHandler.copperingot, itemHandler.oakstick, 3, 3,
                    new ItemStack(Material.WOODEN_HOE), "<gold><i:false>Bak??r T??rpan", 2, 4, 7, 5, 0, false, 2, 10, 4, "Orta", 5, 6,
                    10, 8, 10, "T??rpan", 200, 2);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                contains(ChatColor.DARK_AQUA + "Savurma")) {
            String[] chance2 = clicked.getItemMeta().getDisplayName().split(" ");
            ItemStack item1 = itemHandler.coal;
            ItemStack item2 = itemHandler.pigleather;

            enchantConstructor.createEnchantVanilla(Objects.requireNonNull(p.getOpenInventory().getTopInventory().getItem(22)), p, Integer.parseInt(chance2[1]), "knockback", "&4B??y?? ??? &7Savurma: &f",
                    Enchantment.KNOCKBACK, item1, item2);


        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                contains(ChatColor.DARK_AQUA + "Tecr??be Deste??i")) {
            String[] chance2 = clicked.getItemMeta().getDisplayName().split(" ");
            ItemStack item1 = itemHandler.coal;
            ItemStack item2 = itemHandler.pigleather;

            enchantConstructor.createEnchant(Objects.requireNonNull(p.getOpenInventory().getTopInventory().getItem(22)), p, Integer.parseInt(chance2[1]), "xp", "&4B??y?? ??? &7Tecr??be Deste??i: &f",
                    item1, item2);


        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                contains(ChatColor.DARK_AQUA + "H??nerli Avc??")) {
            String[] chance2 = clicked.getItemMeta().getDisplayName().split(" ");
            ItemStack item1 = itemHandler.bone;
            ItemStack item2 = itemHandler.wolfteeth;

            enchantConstructor.createEnchant(Objects.requireNonNull(p.getOpenInventory().getTopInventory().getItem(22)), p, Integer.parseInt(chance2[1]), "hunerliavci", "&4B??y?? ??? &7H??nerli Avc??: &f",
                    item1, item2);


        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                contains(ChatColor.DARK_AQUA + "Alevden ??ehre")) {
            String[] chance2 = clicked.getItemMeta().getDisplayName().split(" ");
            ItemStack item1 = itemHandler.ash;
            ItemStack item2 = itemHandler.magmaball;

            enchantConstructor.createEnchantVanilla(Objects.requireNonNull(p.getOpenInventory().getTopInventory().getItem(22)), p, Integer.parseInt(chance2[1]), "fireaspect", "&4B??y?? ??? &7Alevden ??ehre: &f",
                    Enchantment.FIRE_ASPECT, item1, item2);


        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                contains(ChatColor.DARK_AQUA + "Alevden ??ehre")) {
            String[] chance2 = clicked.getItemMeta().getDisplayName().split(" ");
            ItemStack item1 = itemHandler.ash;
            ItemStack item2 = itemHandler.magmaball;

            enchantConstructor.createEnchantVanilla(Objects.requireNonNull(p.getOpenInventory().getTopInventory().getItem(22)), p, Integer.parseInt(chance2[1]), "fireaspect", "&4B??y?? ??? &7Alevden ??ehre: &f",
                    Enchantment.FIRE_ASPECT, item1, item2);


        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                contains(ChatColor.DARK_AQUA + "??fke")) {
            String[] chance2 = clicked.getItemMeta().getDisplayName().split(" ");
            ItemStack item1 = itemHandler.magmaball;
            ItemStack item2 = itemHandler.blackbone;

            enchantConstructor.createEnchant(Objects.requireNonNull(p.getOpenInventory().getTopInventory().getItem(22)), p, Integer.parseInt(chance2[1]), "rage", "&4B??y?? ??? &7??fke: &f"
                    , item1, item2);


        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                contains(ChatColor.DARK_AQUA + "??nfaz")) {
            String[] chance2 = clicked.getItemMeta().getDisplayName().split(" ");
            ItemStack item1 = itemHandler.gianttoe;
            ItemStack item2 = itemHandler.wolfteeth;

            enchantConstructor.createEnchant(Objects.requireNonNull(p.getOpenInventory().getTopInventory().getItem(22)), p, Integer.parseInt(chance2[1]), "giant2", "&4B??y?? ??? &7??nfaz: &f"
                    , item1, item2);


        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                contains(ChatColor.DARK_AQUA + "Eklembacakl??lar'??n K??yameti")) {
            String[] chance2 = clicked.getItemMeta().getDisplayName().split(" ");
            ItemStack item1 = itemHandler.spidereye;
            ItemStack item2 = itemHandler.string;

            enchantConstructor.createEnchantVanilla(Objects.requireNonNull(p.getOpenInventory().getTopInventory().getItem(22)), p, Integer.parseInt(chance2[1]), "bane", "&4B??y?? ??? &7Eklembacakl??lar'??n K??yameti: &f", "smite", "sharpness",
                    Enchantment.DAMAGE_ARTHROPODS, item1, item2);


        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                contains(ChatColor.DARK_AQUA + "A????r?? Y??kleme")) {
            String[] chance2 = clicked.getItemMeta().getDisplayName().split(" ");
            ItemStack item1 = itemHandler.blackdust;
            ItemStack item2 = itemHandler.magmaball;

            enchantConstructor.createEnchant(Objects.requireNonNull(p.getOpenInventory().getTopInventory().getItem(22)), p, Integer.parseInt(chance2[1]), "overload", "&4B??y?? ??? &7A????r?? Y??kleme: &f",
                    item1, item2);


        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                contains(ChatColor.DARK_AQUA + "Keskin G??r????")) {
            String[] chance2 = clicked.getItemMeta().getDisplayName().split(" ");
            ItemStack item1 = itemHandler.glass;
            ItemStack item2 = itemHandler.ironingot;

            enchantConstructor.createEnchant(Objects.requireNonNull(p.getOpenInventory().getTopInventory().getItem(22)), p, Integer.parseInt(chance2[1]), "keskingorus", "&4B??y?? ??? &7Keskin G??r????: &f",
                    item1, item2);


        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                contains(ChatColor.DARK_AQUA + "Alev Korumas??")) {
            String[] chance2 = clicked.getItemMeta().getDisplayName().split(" ");
            ItemStack item1 = itemHandler.fireoz;
            ItemStack item2 = itemHandler.gravel;

            enchantConstructor.createEnchant(Objects.requireNonNull(p.getOpenInventory().getTopInventory().getItem(22)), p, Integer.parseInt(chance2[1]), "slayer", "&4B??y?? ??? &7Dev Yarma: &f",
                    item1, item2);


        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                contains(ChatColor.DARK_AQUA + "Dev Yarma")) {
            String[] chance2 = clicked.getItemMeta().getDisplayName().split(" ");
            ItemStack item1 = itemHandler.gianteye;
            ItemStack item2 = itemHandler.wolfteeth;

            enchantConstructor.createEnchant(Objects.requireNonNull(p.getOpenInventory().getTopInventory().getItem(22)), p, Integer.parseInt(chance2[1]), "slayer", "&4B??y?? ??? &7Dev Yarma: &f",
                    item1, item2);


        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                contains(ChatColor.DARK_AQUA + "Statik Y??kleme")) {
            String[] chance2 = clicked.getItemMeta().getDisplayName().split(" ");
            ItemStack item1 = itemHandler.lightningesans;
            ItemStack item2 = itemHandler.silverfish;

            enchantConstructor.createEnchant(Objects.requireNonNull(p.getOpenInventory().getTopInventory().getItem(22)), p, Integer.parseInt(chance2[1]), "statik", "&4B??y?? ??? &7Statik Y??kleme: &f",
                    item1, item2);


        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                contains(ChatColor.DARK_AQUA + "Hafif D????????")) {
            String[] chance2 = clicked.getItemMeta().getDisplayName().split(" ");
            ItemStack item1 = itemHandler.feather;
            ItemStack item2 = itemHandler.wool;

            enchantConstructor.createEnchantVanilla(Objects.requireNonNull(p.getOpenInventory().getTopInventory().getItem(22)), p, Integer.parseInt(chance2[1]), "featherfall", "&4B??y?? ??? &7Hafif D????????: &f",
                    Enchantment.PROTECTION_FALL, item1, item2);


        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                contains(ChatColor.DARK_AQUA + "Dikenli Taban")) {
            String[] chance2 = clicked.getItemMeta().getDisplayName().split(" ");
            ItemStack item1 = itemHandler.cactus;
            ItemStack item2 = itemHandler.bronzeingot;

            enchantConstructor.createEnchant(Objects.requireNonNull(p.getOpenInventory().getTopInventory().getItem(22)), p, Integer.parseInt(chance2[1]), "dikenlitaban", "&4B??y?? ??? &7Dikenli Taban: &f",
                    item1, item2);


        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                contains(ChatColor.DARK_AQUA + "Sihirli Pabu??lar")) {
            String[] chance2 = clicked.getItemMeta().getDisplayName().split(" ");
            ItemStack item1 = itemHandler.feather;
            ItemStack item2 = itemHandler.salt;

            enchantConstructor.createEnchant(Objects.requireNonNull(p.getOpenInventory().getTopInventory().getItem(22)), p, Integer.parseInt(chance2[1]), "fast", "&4B??y?? ??? &7Sihirli Pabu??lar: &f",
                    item1, item2);


        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                contains(ChatColor.DARK_AQUA + "Mutlak S??f??r")) {
            String[] chance2 = clicked.getItemMeta().getDisplayName().split(" ");
            ItemStack item1 = itemHandler.iceesans;
            ItemStack item2 = itemHandler.rotten;

            enchantConstructor.createEnchant(Objects.requireNonNull(p.getOpenInventory().getTopInventory().getItem(22)), p, Integer.parseInt(chance2[1]), "ice", "&4B??y?? ??? &7Mutlak S??f??r: &f",
                    item1, item2);


        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                contains(ChatColor.DARK_AQUA + "??ntikam")) {
            String[] chance2 = clicked.getItemMeta().getDisplayName().split(" ");
            ItemStack item1 = itemHandler.blackbone;
            ItemStack item2 = itemHandler.rotten;

            enchantConstructor.createEnchant(Objects.requireNonNull(p.getOpenInventory().getTopInventory().getItem(22)), p, Integer.parseInt(chance2[1]), "revenge", "&4B??y?? ??? &7??ntikam: &f",
                    item1, item2);


        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                contains(ChatColor.DARK_AQUA + "Kar???? Sald??r??")) {
            String[] chance2 = clicked.getItemMeta().getDisplayName().split(" ");
            ItemStack item1 = itemHandler.shieldfrag;
            ItemStack item2 = itemHandler.ironingot;

            enchantConstructor.createEnchant(Objects.requireNonNull(p.getOpenInventory().getTopInventory().getItem(22)), p, Integer.parseInt(chance2[1]), "shield", "&4B??y?? ??? &7Kar???? Sald??r??: &f",
                    item1, item2);


        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                contains(ChatColor.DARK_AQUA + "Ruh Korumas??")) {
            String[] chance2 = clicked.getItemMeta().getDisplayName().split(" ");
            ItemStack item1 = itemHandler.spektralore;
            ItemStack item2 = itemHandler.tear;

            enchantConstructor.createEnchant(Objects.requireNonNull(p.getOpenInventory().getTopInventory().getItem(22)), p, Integer.parseInt(chance2[1]), "soul", "&4B??y?? ??? &7Ruh Korumas??: &f",
                    item1, item2);


        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                contains(ChatColor.DARK_AQUA + "Kutsanm????")) {
            String[] chance2 = clicked.getItemMeta().getDisplayName().split(" ");
            ItemStack item1 = itemHandler.spektralore;
            ItemStack item2 = itemHandler.aralit;

            enchantConstructor.createEnchant(Objects.requireNonNull(p.getOpenInventory().getTopInventory().getItem(22)), p, Integer.parseInt(chance2[1]), "yenilen", "&4B??y?? ??? &7Kutsanm????: &f",
                    item1, item2);


        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                contains(ChatColor.DARK_AQUA + "Ba????????kl??k")) {
            String[] chance2 = clicked.getItemMeta().getDisplayName().split(" ");
            ItemStack item1 = itemHandler.glowstone;
            ItemStack item2 = itemHandler.aralit;

            enchantConstructor.createEnchant(Objects.requireNonNull(p.getOpenInventory().getTopInventory().getItem(22)), p, Integer.parseInt(chance2[1]), "kutsal", "&4B??y?? ??? &7Ba????????kl??k: &f",
                    item1, item2);


        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                contains(ChatColor.DARK_AQUA + "Obsidyen Kaplama")) {
            String[] chance2 = clicked.getItemMeta().getDisplayName().split(" ");
            ItemStack item1 = itemHandler.magmaball;
            ItemStack item2 = itemHandler.obsidianore;

            enchantConstructor.createEnchant(Objects.requireNonNull(p.getOpenInventory().getTopInventory().getItem(22)), p, Integer.parseInt(chance2[1]), "fireres", "&4B??y?? ??? &7Obsidyen Kaplama: &f",
                    item1, item2);


        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                contains(ChatColor.DARK_AQUA + "S??v????ma")) {
            String[] chance2 = clicked.getItemMeta().getDisplayName().split(" ");
            ItemStack item1 = itemHandler.wool;
            ItemStack item2 = itemHandler.feather;

            enchantConstructor.createEnchant(Objects.requireNonNull(p.getOpenInventory().getTopInventory().getItem(22)), p, Integer.parseInt(chance2[1]), "dodgerate", "&4B??y?? ??? &7S??v????ma: &f",
                    item1, item2);


        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                contains(ChatColor.DARK_AQUA + "Barbar G??c??")) {
            String[] chance2 = clicked.getItemMeta().getDisplayName().split(" ");
            ItemStack item1 = itemHandler.gianttoe;
            ItemStack item2 = itemHandler.pufferfish;

            enchantConstructor.createEnchant(Objects.requireNonNull(p.getOpenInventory().getTopInventory().getItem(22)), p, Integer.parseInt(chance2[1]), "barbarian", "&4B??y?? ??? &7Barbar G??c??: &f",
                    item1, item2);


        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                contains(ChatColor.DARK_AQUA + "Solunga??")) {
            String[] chance2 = clicked.getItemMeta().getDisplayName().split(" ");
            ItemStack item1 = itemHandler.rawsalmon;
            ItemStack item2 = itemHandler.pufferfish;

            enchantConstructor.createEnchantVanilla(Objects.requireNonNull(p.getOpenInventory().getTopInventory().getItem(22)), p, Integer.parseInt(chance2[1]), "waterwork", "&4B??y?? ??? &7Solunga??: &f",
                    Enchantment.OXYGEN, item1, item2);


        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                contains(ChatColor.DARK_AQUA + "Potansiyel")) {
            String[] chance2 = clicked.getItemMeta().getDisplayName().split(" ");
            ItemStack item1 = itemHandler.gunpowder;
            ItemStack item2 = itemHandler.blackdust;

            enchantConstructor.createEnchant(Objects.requireNonNull(p.getOpenInventory().getTopInventory().getItem(22)), p, Integer.parseInt(chance2[1]), "potansiyel", "&4B??y?? ??? &7Potansiyel: &f",
                    item1, item2);


        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                contains(ChatColor.DARK_AQUA + "Din??le??tirme")) {
            String[] chance2 = clicked.getItemMeta().getDisplayName().split(" ");
            ItemStack item1 = itemHandler.glowstone;
            ItemStack item2 = itemHandler.apple;

            enchantConstructor.createEnchant(Objects.requireNonNull(p.getOpenInventory().getTopInventory().getItem(22)), p, Integer.parseInt(chance2[1]), "rejuv", "&4B??y?? ??? &7Din??le??tirme: &f",
                    item1, item2);


        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                contains(ChatColor.DARK_AQUA + "Tam ??sabet")) {
            String[] chance2 = clicked.getItemMeta().getDisplayName().split(" ");
            ItemStack item1 = itemHandler.blackbone;
            ItemStack item2 = itemHandler.feather;

            enchantConstructor.createEnchant(Objects.requireNonNull(p.getOpenInventory().getTopInventory().getItem(22)), p, Integer.parseInt(chance2[1]), "isabetw", "&4B??y?? ??? &7Tam ??sabet: &f",
                    item1, item2);


        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                contains(ChatColor.DARK_AQUA + "G????")) {
            String[] chance2 = clicked.getItemMeta().getDisplayName().split(" ");
            ItemStack item1 = itemHandler.bone;
            ItemStack item2 = itemHandler.arrow;

            enchantConstructor.createEnchantVanilla(Objects.requireNonNull(p.getOpenInventory().getTopInventory().getItem(22)), p, Integer.parseInt(chance2[1]), "power", "&4B??y?? ??? &7G????: &f",
                    Enchantment.ARROW_DAMAGE, item1, item2);


        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                contains(ChatColor.DARK_AQUA + "Aleve Ver")) {
            String[] chance2 = clicked.getItemMeta().getDisplayName().split(" ");
            ItemStack item1 = itemHandler.fireoz;
            ItemStack item2 = itemHandler.magmaball;

            enchantConstructor.createEnchantVanilla(Objects.requireNonNull(p.getOpenInventory().getTopInventory().getItem(22)), p, Integer.parseInt(chance2[1]), "flame", "&4B??y?? ??? &7Aleve Ver: &f",
                    Enchantment.ARROW_FIRE, item1, item2);


        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                contains(ChatColor.DARK_AQUA + "Servet")) {
            String[] chance2 = clicked.getItemMeta().getDisplayName().split(" ");
            ItemStack item1 = itemHandler.goldingot;
            ItemStack item2 = itemHandler.silveringot;

            enchantConstructor.createEnchantVanilla(Objects.requireNonNull(p.getOpenInventory().getTopInventory().getItem(22)), p, Integer.parseInt(chance2[1]), "servet", "&4B??y?? ??? &7Servet: &f",
                    Enchantment.LOOT_BONUS_BLOCKS, item1, item2);


        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                contains(ChatColor.DARK_AQUA + "Ustal??k Deste??i")) {
            String[] chance2 = clicked.getItemMeta().getDisplayName().split(" ");
            ItemStack item1 = itemHandler.birchwood;
            ItemStack item2 = itemHandler.nikelingot;

            enchantConstructor.createEnchant(Objects.requireNonNull(p.getOpenInventory().getTopInventory().getItem(22)), p, Integer.parseInt(chance2[1]), "ustal??k", "&4B??y?? ??? &7Ustal??k Deste??i: &f"
                    , item1, item2);


        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                contains(ChatColor.DARK_AQUA + "Verimlilik")) {
            String[] chance2 = clicked.getItemMeta().getDisplayName().split(" ");
            ItemStack item1 = itemHandler.coal;
            ItemStack item2 = itemHandler.paper;

            enchantConstructor.createEnchantVanilla(Objects.requireNonNull(p.getOpenInventory().getTopInventory().getItem(22)), p, Integer.parseInt(chance2[1]), "efficiency", "&4B??y?? ??? &7Verimlilik: &f",
                    Enchantment.DIG_SPEED, item1, item2);


        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                contains(ChatColor.DARK_AQUA + "????len")) {
            String[] chance2 = clicked.getItemMeta().getDisplayName().split(" ");
            ItemStack item1 = itemHandler.feather;
            ItemStack item2 = itemHandler.wolfleather;

            enchantConstructor.createEnchant(Objects.requireNonNull(p.getOpenInventory().getTopInventory().getItem(22)), p, Integer.parseInt(chance2[1]), "solen", "&4B??y?? ??? &7????len: &f",
                    item1, item2);


        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                contains(ChatColor.DARK_AQUA + "??i??leme")) {
            String[] chance2 = clicked.getItemMeta().getDisplayName().split(" ");
            ItemStack item1 = itemHandler.rawsalmon;
            ItemStack item2 = itemHandler.tridentfrag;

            enchantConstructor.createEnchant(Objects.requireNonNull(p.getOpenInventory().getTopInventory().getItem(22)), p, Integer.parseInt(chance2[1]), "impaling", "&4B??y?? ??? &7??i??leme: &f",
                    item1, item2);


        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                contains(ChatColor.DARK_AQUA + "Y??ld??r??m Oku")) {
            String[] chance2 = clicked.getItemMeta().getDisplayName().split(" ");
            ItemStack item1 = itemHandler.wawebreakerfish;
            ItemStack item2 = itemHandler.feather;

            enchantConstructor.createEnchant(Objects.requireNonNull(p.getOpenInventory().getTopInventory().getItem(22)), p, Integer.parseInt(chance2[1]), "loku", "&4B??y?? ??? &7Y??ld??r??m Oku: &f",
                    item1, item2);


        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                contains(ChatColor.DARK_AQUA + "A????r?? B??y??me")) {
            String[] chance2 = clicked.getItemMeta().getDisplayName().split(" ");
            ItemStack item1 = itemHandler.gianttoe;
            ItemStack item2 = itemHandler.pufferfish;

            enchantConstructor.createEnchant(Objects.requireNonNull(p.getOpenInventory().getTopInventory().getItem(22)), p, Integer.parseInt(chance2[1]), "growth", "&4B??y?? ??? &7A????r?? B??y??me: &f",
                    item1, item2);


        }

        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                contains(ChatColor.DARK_AQUA + "Dikenler")) {
            String[] chance2 = clicked.getItemMeta().getDisplayName().split(" ");
            ItemStack item1 = itemHandler.cactus;
            ItemStack item2 = itemHandler.kezicicek;

            enchantConstructor.createEnchantVanilla(Objects.requireNonNull(p.getOpenInventory().getTopInventory().getItem(22)), p, Integer.parseInt(chance2[1]), "thorns", "&4B??y?? ??? &7Dikenler: &f",
                    Enchantment.THORNS, item1, item2);


        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                contains(ChatColor.DARK_AQUA + "Koruma")) {
            String[] chance2 = clicked.getItemMeta().getDisplayName().split(" ");
            ItemStack item1 = itemHandler.ironingot;
            ItemStack item2 = itemHandler.cowleather;

            enchantConstructor.createEnchantVanilla(Objects.requireNonNull(p.getOpenInventory().getTopInventory().getItem(22)), p, Integer.parseInt(chance2[1]), "prot", "&4B??y?? ??? &7Koruma: &f",
                    Enchantment.PROTECTION_ENVIRONMENTAL, item1, item2);


        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                contains(ChatColor.DARK_AQUA + "Patlama Korumas??")) {
            String[] chance2 = clicked.getItemMeta().getDisplayName().split(" ");
            ItemStack item1 = itemHandler.wool;
            ItemStack item2 = itemHandler.copperingot;

            enchantConstructor.createEnchantVanilla(Objects.requireNonNull(p.getOpenInventory().getTopInventory().getItem(22)), p, Integer.parseInt(chance2[1]), "exploprot", "&4B??y?? ??? &7Patlama Korumas??: &f",
                    Enchantment.PROTECTION_EXPLOSIONS, item1, item2);


        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                contains(ChatColor.DARK_AQUA + "S??p??r??c?? Kenar")) {
            String[] chance2 = clicked.getItemMeta().getDisplayName().split(" ");
            ItemStack item1 = itemHandler.ilviyanpencesi;
            ItemStack item2 = itemHandler.ironingot;

            enchantConstructor.createEnchantVanilla(Objects.requireNonNull(p.getOpenInventory().getTopInventory().getItem(22)), p, Integer.parseInt(chance2[1]), "sweeep", "&4B??y?? ??? &7S??p??r??c?? Kenar: &f",
                    Enchantment.SWEEPING_EDGE, item1, item2);


        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                contains(ChatColor.DARK_AQUA + "Keskinlik")) {
            String[] chance2 = clicked.getItemMeta().getDisplayName().split(" ");
            ItemStack item1 = itemHandler.gravel;
            ItemStack item2 = itemHandler.ironore;

            enchantConstructor.createEnchantVanilla(Objects.requireNonNull(p.getOpenInventory().getTopInventory().getItem(22)), p, Integer.parseInt(chance2[1]), "sharpness", "&4B??y?? ??? &7Keskinlik: &f", "smite", "bane",
                    Enchantment.DAMAGE_ALL, item1, item2);


        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                contains(ChatColor.DARK_AQUA + "Akuapunktur")) {
            String[] chance2 = clicked.getItemMeta().getDisplayName().split(" ");
            ItemStack item1 = itemHandler.ilviyanpencesi;
            ItemStack item2 = itemHandler.wolfteeth;

            enchantConstructor.createEnchant(Objects.requireNonNull(p.getOpenInventory().getTopInventory().getItem(22)), p, Integer.parseInt(chance2[2]), "akuapunktur", "&4B??y?? ??? &7Akuapunktur Ustas??: &f",
                    item1, item2);


        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                contains(ChatColor.DARK_AQUA + "Darbe")) {
            String[] chance2 = clicked.getItemMeta().getDisplayName().split(" ");
            ItemStack item1 = itemHandler.blackbone;
            ItemStack item2 = itemHandler.rotten;

            enchantConstructor.createEnchantVanilla(Objects.requireNonNull(p.getOpenInventory().getTopInventory().getItem(22)), p, Integer.parseInt(chance2[1]), "smite", "&4B??y?? ??? &7Darbe: &f", "sharpness", "bane",
                    Enchantment.DAMAGE_UNDEAD, item1, item2);


        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                contains(ChatColor.DARK_AQUA + "K??r??lmazl??k")) {
            String[] chance2 = clicked.getItemMeta().getDisplayName().split(" ");
            ItemStack item1 = itemHandler.silverfish;
            ItemStack item2 = itemHandler.nikelingot;

            enchantConstructor.createEnchantVanilla(Objects.requireNonNull(p.getOpenInventory().getTopInventory().getItem(22)), p, Integer.parseInt(chance2[1]), "unbreaking", "&4B??y?? ??? &7K??r??lmazl??k: &f",
                    Enchantment.DURABILITY, item1, item2);


        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Bak??r Balta")) {
            itemHandler.createTool(p, itemHandler.bronzeingot, 3, itemHandler.oakstick, 2,
                    new ItemStack(Material.GOLDEN_AXE), "<gold><i:false>Bak??r Balta", 1, 5, false, 3, 4, 7, 8, 10, "Balta", 200, 2);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Bak??r M??zrak")) {
            itemHandler.createWeapon(p, itemHandler.copperingot, itemHandler.oakstick, 3, 2,
                    new ItemStack(Material.STICK), "<gold><i:false>Bak??r M??zrak", 2, 7, 5, 3, 4, false, 1, 14, 7, "D??????k", 6, 6, 10,
                    8, 10, "M??zrak", 200, 2);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Bak??r Topuz")) {
            itemHandler.createWeapon(p, itemHandler.copperingot, itemHandler.oakstick, 3, 3,
                    new ItemStack(Material.WOODEN_SHOVEL), "<gold><i:false>Bak??r Topuz", 2, 7, 5, 3, 4, false, 1, 14, 7, "D??????k", 5, 6, 10,
                    8, 10, "Topuz", 300, 2);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Bak??r K??rek")) {
            itemHandler.createTool(p, itemHandler.copperingot, 3, itemHandler.oakstick, 2,
                    new ItemStack(Material.GOLDEN_SHOVEL), "<gold><i:false>Bak??r K??rek", 2, 4, false, 3, 20, 6, 8, 10, "K??rek", 200, 2);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Bak??r Kazma")) {
            itemHandler.createTool(p, itemHandler.copperingot, 3, itemHandler.oakstick, 3,
                    new ItemStack(Material.GOLDEN_PICKAXE), "<gold><i:false>Bak??r Kazma", 2, 5, false, 3, 20, 6, 8, 10, "Kazma", 200, 2);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Bak??r ??apa")) {
            itemHandler.createTool(p, itemHandler.copperingot, 3, itemHandler.oakstick, 3,
                    new ItemStack(Material.GOLDEN_HOE), "<gold><i:false>Bak??r ??apa", 2, 5, false, 3, 20, 6, 8, 10, "??apa", 200, 2);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Bak??r G??????sl??k")) {
            itemHandler.createArmor(p, "G??????sl??k", itemHandler.copperingot, 8,
                    new ItemStack(Material.LEATHER_CHESTPLATE), "<gold><i:false>Bak??r G??????sl??k", 2, 4, 5, 5, 1, 0, 0, 0, 0, 0, 0,
                    0, 4, 10, 8, 10, 8, 200, 2);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "??nek Derisinden Kap????on")) {
            itemHandler.createArmorWork(p, "Mi??fer", itemHandler.cowleather, itemHandler.string, 5, 3,
                    new ItemStack(Material.LEATHER_HELMET), "<gold><i:false>??nek Derisinden Kap????on", 2, 2, 1, 0, 0, 0, 1, 1, 0, 0, 8,
                    8, 4, 6, 12, 5, 104, 100, 2);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "??nek Derisinden G??????sl??k")) {
            itemHandler.createArmorWork(p, "G??????sl??k", itemHandler.cowleather, itemHandler.string, 8, 6,
                    new ItemStack(Material.LEATHER_CHESTPLATE), "<gold><i:false>??nek Derisinden G??????sl??k", 2, 4, 3, 0, 0, 0, 2, 3, 0, 0, 12,
                    8, 4, 7, 12, 5, 104, 120, 2);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "??nek Derisinden Pantolon")) {
            itemHandler.createArmorWork(p, "Pantolon", itemHandler.cowleather, itemHandler.string, 7, 5,
                    new ItemStack(Material.LEATHER_LEGGINGS), "<gold><i:false>??nek Derisinden Pantolon", 2, 4, 2, 0, 0, 0, 2, 3, 0, 0, 10,
                    8, 4, 7, 12, 5, 104, 120, 2);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "??nek Derisinden ??izmeler")) {
            itemHandler.createArmorWork(p, "Botlar", itemHandler.cowleather, itemHandler.string, 4, 3,
                    new ItemStack(Material.LEATHER_BOOTS), "<gold><i:false>??nek Derisinden ??izmeler", 2, 3, 1, 0, 0, 0, 2, 2, 0, 0, 8,
                    8, 4, 7, 12, 5, 104, 100, 2);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "??nek Derisinden ??anta")) {
            itemHandler.createBackpack(p, itemHandler.cowleather, 10
                    , 2, new ItemStack(Material.LEATHER), "<gold><i:false>??nek Derisinden ??anta", 1, 9, 4, 12, 10, "??anta", 1);

        }

        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Bizon Derisinden Kap????on")) {
            itemHandler.createArmorWork(p, "Mi??fer", itemHandler.bizoneleather, itemHandler.string, 5, 3,
                    new ItemStack(Material.LEATHER_HELMET), "<gold><i:false>Bizon Derisinden Kap????on", 2, 2, 2, 0, 0, 1, 1, 3, 0, 0, 11,
                    8, 4, 6, 15, 5, 101, 100, 4);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Bizon Derisinden G??????sl??k")) {
            itemHandler.createArmorWork(p, "G??????sl??k", itemHandler.bizoneleather, itemHandler.string, 8, 6,
                    new ItemStack(Material.LEATHER_CHESTPLATE), "<gold><i:false>Bizon Derisinden G??????sl??k", 2, 4, 4, 0, 0, 3, 2, 5, 0, 0, 15,
                    8, 4, 7, 16, 5, 101, 120, 4);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Bizon Derisinden Pantolon")) {
            itemHandler.createArmorWork(p, "Pantolon", itemHandler.bizoneleather, itemHandler.string, 7, 5,
                    new ItemStack(Material.LEATHER_LEGGINGS), "<gold><i:false>Bizon Derisinden Pantolon", 2, 4, 3, 0, 0, 2, 2, 5, 0, 0, 13,
                    8, 4, 7, 16, 5, 101, 120, 4);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Bizon Derisinden ??izmeler")) {
            itemHandler.createArmorWork(p, "Botlar", itemHandler.bizoneleather, itemHandler.string, 4, 3,
                    new ItemStack(Material.LEATHER_BOOTS), "<gold><i:false>Bizon Derisinden ??izmeler", 2, 4, 2, 0, 0, 4, 2, 4, 0, 0, 10,
                    8, 4, 7, 16, 5, 101, 100, 4);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Bizon Derisinden ??anta")) {
            itemHandler.createBackpack(p, itemHandler.bizoneleather, 10
                    , 2, new ItemStack(Material.LEATHER), "<gold><i:false>Bizon Derisinden ??anta", 1, 18, 5, 16, 10, "??anta", 1);

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Yaban Domuzu Derisinden Kap????on")) {
            itemHandler.createArmorWork(p, "Mi??fer", itemHandler.pigleather, itemHandler.string, 5, 3,
                    new ItemStack(Material.LEATHER_HELMET), "<gold><i:false>Yaban Domuzu Derisinden Kap????on", 3, 2, 2, 0, 0, 1, 1, 5, 0, 0, 14,
                    10, 4, 8, 25, 5, 103, 200, 6);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Yaban Domuzu Derisinden G??????sl??k")) {
            itemHandler.createArmorWork(p, "G??????sl??k", itemHandler.pigleather, itemHandler.string, 8, 6,
                    new ItemStack(Material.LEATHER_CHESTPLATE), "<gold><i:false>Yaban Domuzu Derisinden G??????sl??k", 3, 4, 4, 2, 0, 5, 4, 5, 0, 0, 16,
                    10, 4, 8, 25, 5, 103, 220, 6);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Yaban Domuzu Derisinden Pantolon")) {
            itemHandler.createArmorWork(p, "Pantolon", itemHandler.pigleather, itemHandler.string, 7, 5,
                    new ItemStack(Material.LEATHER_LEGGINGS), "<gold><i:false>Yaban Domuzu Derisinden Pantolon", 3, 4, 3, 1, 0, 2, 4, 6, 0, 0, 15,
                    10, 4, 8, 25, 5, 103, 220, 6);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Yaban Domuzu Derisinden ??izmeler")) {
            itemHandler.createArmorWork(p, "Botlar", itemHandler.pigleather, itemHandler.string, 4, 3,
                    new ItemStack(Material.LEATHER_BOOTS), "<gold><i:false>Yaban Domuzu Derisinden ??izmeler", 3, 4, 2, 0, 0, 7, 4, 5, 0, 0, 13,
                    11, 4, 8, 25, 5, 103, 200, 6);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Yaban Domuzu Derisinden ??anta")) {
            itemHandler.createBackpack(p, itemHandler.pigleather, 10
                    , 2, new ItemStack(Material.LEATHER), "<gold><i:false>Yaban Domuzu Derisinden ??anta", 1, 27, 10, 20, 10, "??anta", 3);

        }


        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Kurt Derisinden Kap????on")) {
            itemHandler.createArmorWork(p, "Mi??fer", itemHandler.wolfleather, itemHandler.string, 5, 3,
                    new ItemStack(Material.LEATHER_HELMET), "<gold><i:false>Yaban Domuzu Derisinden Kap????on", 3, 2, 2, 0, 0, 1, 1, 5, 0, 0, 14,
                    10, 4, 8, 25, 5, 103, 200, 6);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Kurt Derisinden G??????sl??k")) {
            itemHandler.createArmorWork(p, "G??????sl??k", itemHandler.wolfleather, itemHandler.string, 8, 6,
                    new ItemStack(Material.LEATHER_CHESTPLATE), "<gold><i:false>Kurt Derisinden G??????sl??k", 3, 4, 5, 2, 0, 7, 5, 6, 0, 0, 16,
                    12, 4, 11, 30, 5, 107, 420, 7);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Kurt Derisinden Pantolon")) {
            itemHandler.createArmorWork(p, "Pantolon", itemHandler.wolfleather, itemHandler.string, 7, 5,
                    new ItemStack(Material.LEATHER_LEGGINGS), "<gold><i:false>Kurt Derisinden Pantolon", 3, 4, 5, 2, 0, 4, 5, 7, 0, 0, 15,
                    13, 4, 11, 30, 5, 107, 420, 7);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Kurt Derisinden ??izmeler")) {
            itemHandler.createArmorWork(p, "Botlar", itemHandler.wolfleather, itemHandler.string, 4, 3,
                    new ItemStack(Material.LEATHER_BOOTS), "<gold><i:false>Kurt Derisinden ??izmeler", 3, 4, 4, 0, 0, 9, 5, 7, 0, 0, 13,
                    14, 4, 11, 30, 5, 107, 400, 7);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Yaban Domuzu Derisinden ??anta")) {
            itemHandler.createBackpack(p, itemHandler.wolfleather, 10
                    , 2, new ItemStack(Material.LEATHER), "<gray><i:false>Kurt Derisinden ??anta", 1, 36, 12, 25, 10, "??anta", 5);

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Bak??r Pantolon")) {
            itemHandler.createArmor(p, "Pantolon", itemHandler.copperingot, 7,
                    new ItemStack(Material.LEATHER_LEGGINGS), "<gold><i:false>Bak??r Pantolon", 2, 3, 4, 5, 1, 0, 0, 0, 0, 0, 0, 0,
                    4, 10, 8, 10, 8, 200, 2);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Bak??r Mi??fer")) {
            itemHandler.createArmor(p, "Mi??fer", itemHandler.copperingot, 5,
                    new ItemStack(Material.LEATHER_HELMET), "<gold><i:false>Bak??r Mi??fer", 2, 2, 4, 5, 1, 0, 0, 0, 0, 0, 0, 0, 4,
                    10, 8, 10, 8, 200, 2);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Bak??r Botlar")) {
            itemHandler.createArmor(p, "Botlar", itemHandler.copperingot, 4,
                    new ItemStack(Material.LEATHER_BOOTS), "<gold><i:false>Bak??r Botlar", 2, 2, 4, 5, 1, 0, 0, 0, 0, 0, 0, 0, 4,
                    12, 8, 10, 8, 200, 2);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Bronz K??l????")) {
            itemHandler.createWeapon(p, itemHandler.bronzeingot, itemHandler.oakstick, 3, 2,
                    new ItemStack(Material.WOODEN_SWORD), "<gold><i:false>Bronz K??l????", 2, 6, 4, 3, 2, false, 3, 16, 6, "D??????k", 5,
                    6, 12, 12, 10, "K??l????", 400, 4);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Bronz Sava?? Baltas??")) {
            itemHandler.createWeapon(p, itemHandler.bronzeingot, itemHandler.oakstick, 6, 3,
                    new ItemStack(Material.WOODEN_AXE), "<gold><i:false>Bronz Sava?? Baltas??", 2, 10, 4, 0, 0, false, 1, 20, 0, "Orta", 5,
                    6, 12, 12, 10, "Sava?? Baltas??", 400, 4);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "G????")) {
            p.openInventory(GUIENCH2(p, "G????", "Ok", "Kemik"));

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "Tam ??sabet")) {
            p.openInventory(GUIENCH2(p, "Tam ??sabet", "Solmu?? Kemik", "T??y"));

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "Alev")) {
            p.openInventory(GUIENCH2(p, "Alev", "Alev ??z??t??", "Magmarit"));

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "Servet")) {
            p.openInventory(GUIENCH2(p, "Servet", "Alt??n K??l??esi", "G??m???? K??l??esi"));

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "Ustal??k Deste??i")) {
            p.openInventory(GUIENCH2(p, "Ustal??k Deste??i", "Hu?? Odunu", "Nikel K??l??esi"));

        }

        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "Verimlilik")) {
            p.openInventory(GUIENCH2(p, "Verimlilik", "K??m??r", "Ka????t"));

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "????len")) {
            p.openInventory(GUIENCH2(p, "????len", "T??y", "Kurt Postu"));

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "Ni??angah")) {
            p.openInventory(GUIENCH2(p, "Ni??angah", "Kemik", "Obsidyen Cevheri"));

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "??i??leme")) {
            p.openInventory(GUIENCH2(p, "??i??leme", "Somon", "???? Ba??l?? M??zrak Kal??nt??s??"));

        }

        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "Y??ld??r??m Oku")) {
            p.openInventory(GUIENCH2(p, "Y??ld??r??m Oku", "Dalgak??ran Bal??????", "T??y"));

        }

        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "A????r?? Y??kleme")) {
            p.openInventory(GUIENCH2(p, "A????r?? Y??kleme", "Kara Toz", "Magmarit"));

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "Keskin G??r????")) {
            p.openInventory(GUIENCH2(p, "Keskin G??r????", "Cam", "Demir K??l??esi"));

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "Yumruk")) {
            p.openInventory(GUIENCH2(p, "Yumruk", "Bal????k Topu", "Me??e Odunu"));

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "Alev Korumas??")) {
            p.openInventory(GUIENCH2(p, "Alev Korumas??", "Alev ??z??t??", "??ak??l Ta????"));

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "Barbar G??c??")) {
            p.openInventory(GUIENCH2(p, "Barbar G??c??", "Solm???? Kemik", "B??y??l?? Kemik"));

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "Dev Yarma")) {
            p.openInventory(GUIENCH2(p, "Dev Yarma", "Dev G??z??", "Kurt Di??i"));

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "Statik Y??kleme")) {
            p.openInventory(GUIENCH2(p, "Statik Y??kleme", "Y??ld??r??m ??z??t??", "G??m???? Bal??????"));

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "Sa??lam Duru??")) {
            p.openInventory(GUIENCH2(p, "Sa??lam Duru??", "Bal????k Topu", "Sava?????? Ruhu"));

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "Hafif D????????")) {
            p.openInventory(GUIENCH2(p, "Hafif D????????", "T??y", "Y??n"));

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "Dikenli Taban")) {
            p.openInventory(GUIENCH2(p, "Dikenli Taban", "Kakt??s", "Bronz K??l??esi"));

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "Sihirli Pabu??lar")) {
            p.openInventory(GUIENCH2(p, "Sihirli Pabu??lar", "T??y", "Tuz"));

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "Mutlak S??f??r")) {
            p.openInventory(GUIENCH2(p, "Mutlak S??f??r", "Kara Buz", "Ger??ek Buz ??z??t??"));

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "Akuapunktur Ustas??")) {
            p.openInventory(GUIENCH2(p, "Akuapunktur Ustas??", "Kurt Di??i", "??lviyan Pen??esi"));

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "Kaplama Darbesi")) {
            p.openInventory(GUIENCH2(p, "Kalkan Darbesi", "Kalkan Par??as??", "B??y??l?? Kemik"));

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "??ntikam")) {
            p.openInventory(GUIENCH2(p, "??ntikam", "Solmu?? Kemik", "????r??k Et"));

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "Kar???? Sald??r??")) {
            p.openInventory(GUIENCH2(p, "Kar???? Sald??r??", "Kalkan Par??as??", "Demir K??l??esi"));

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "Ruh Korumas??")) {
            p.openInventory(GUIENCH2(p, "Ruh Korumas??", "Ektoplazma", "G??zya????"));

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "Kutsanm????")) {
            p.openInventory(GUIENCH2(p, "Kutsanm????", "Ektoplazma", "Aralit ??i??e??i"));

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "Ba????????kl??k")) {
            p.openInventory(GUIENCH2(p, "Ba????????kl??k", "I????k Tozu", "Aralit ??i??e??i"));

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "Obsidyen Kaplama")) {
            p.openInventory(GUIENCH2(p, "Obsidyen Kaplama", "Obsidyen K??l??esi", "Magmarit"));

        }

        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "S??v????ma")) {
            p.openInventory(GUIENCH2(p, "S??v????ma", "Y??n", "T??y"));

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "Potansiyel")) {
            p.openInventory(GUIENCH2(p, "Potansiyel", "Barut", "Kara Toz"));

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "Din??le??tirme")) {
            p.openInventory(GUIENCH2(p, "Din??le??tirme", "I????k Tozu", "Elma"));

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "Solunga??")) {
            p.openInventory(GUIENCH2(p, "Solunga??", "Somon", "Balon Bal??????"));

        }


        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "A????r?? B??y??me")) {
            p.openInventory(GUIENCH2(p, "A????r?? B??y??me", "Dev T??rna????", "Balon Bal??????"));

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "B??y??l?? Kaplama")) {
            p.openInventory(GUIENCH2(p, "B??y??l?? Kaplama", "B??y??l?? Kemik", "Nikel Cevheri"));

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "Dikenler")) {
            p.openInventory(GUIENCH2(p, "Dikenler", "Kakt??s", "Kezi ??i??e??i"));

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "Koruma")) {
            p.openInventory(GUIENCH2(p, "Koruma", "Demir K??l??esi", "??nek Derisi"));

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "Patlama Korumas??")) {
            p.openInventory(GUIENCH2(p, "Patlama Korumas??", "Y??n", "Bak??r K??l??esi"));

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "Darbe")) {
            p.openInventory(GUIENCH2(p, "Darbe", "????r??k Et", "Solmu?? Kemik"));

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "Keskinlik")) {
            p.openInventory(GUIENCH2(p, "Keskinlik", "??ak??l Ta????", "Demir Cevheri"));

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "Eklembacakl??lar'??n K??yameti")) {
            p.openInventory(GUIENCH2(p, "Eklembacakl??lar'??n K??yameti", "??r??mcek G??z??", "??p"));

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "S??m??r??")) {
            p.openInventory(GUIENCH2(p, "S??m??r??", "??blis Kan??", "Tuz"));

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "??nfaz")) {
            p.openInventory(GUIENCH2(p, "Ganimet", "Dev T??rna????", "Kurt Di??i"));

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "S??p??r??c?? Kenar")) {
            p.openInventory(GUIENCH2(p, "S??p??r??c?? Kenar", "Ilviyan Pen??esi", "Demir K??l??esi"));

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "??fke")) {
            p.openInventory(GUIENCH2(p, "??fke", "Solmu?? Kemik", "Magmarit"));

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "Tecr??be Deste??i")) {
            p.openInventory(GUIENCH2(p, "Tecr??be Deste??i", "Lapis Lazuli", "Cam"));

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "K??r??lmazl??k")) {
            p.openInventory(GUIENCH2(p, "K??r??lmazl??k", "Nikel K??l??esi", "G??m???? Bal??????"));

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "Zehirli Kesik")) {
            p.openInventory(GUIENCH2(p, "Zehirli Kesik", "Solmu?? Kemik", "Kezi ??i??e??i"));

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "H??nerli Avc??")) {
            p.openInventory(GUIENCH2(p, "H??nerli Avc??", "Kemik", "Kurt Di??i"));

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "Alevden ??ehre")) {
            p.openInventory(GUIENCH2(p, "Alevden ??ehre", "Kara K??l", "Magmarit"));

        }

        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.GOLD + "Savurma")) {
            p.openInventory(GUIENCH2(p, "Savurma", "Yaban Domuzu Derisi", "K??m??r"));

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "A????r Bronz K??l????")) {
            itemHandler.createWeapon(p, itemHandler.bronzeingot, itemHandler.oakstick, 5, 3,
                    new ItemStack(Material.DIAMOND_SWORD), "<gold><i:false>A????r Bronz K??l????", 2, 9, 4, 3, 2, false, 1, 18, 0, "Y??ksek", 5,
                    6, 12, 12, 10, "A????r K??l????", 400, 4);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Bronz Han??er")) {
            itemHandler.createWeapon(p, itemHandler.bronzeingot, itemHandler.oakstick, 3, 1,
                    new ItemStack(Material.SHEARS), "<gold><i:false>Bronz Han??er", 2, 6, 8, 2, 3, false, 3, 12, 5, "D??????k", 5, 6, 12,
                    10, 10, "Han??er", 400, 4);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Bronz T??rpan")) {
            itemHandler.createWeapon(p, itemHandler.bronzeingot, itemHandler.oakstick, 3, 3,
                    new ItemStack(Material.WOODEN_HOE), "<gold><i:false>Bronz T??rpan", 2, 4, 4, 5, 0, false, 2, 14, 0, "Y??ksek", 5, 6,
                    12, 12, 10, "T??rpan", 400, 4);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Bronz Balta")) {
            itemHandler.createTool(p, itemHandler.bronzeingot, 3, itemHandler.oakstick, 2,
                    new ItemStack(Material.GOLDEN_AXE), "<gold><i:false>Bronz Balta", 2, 7, false, 4, 4, 10, 10, 10, "Balta", 400, 4);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Bronz M??zrak")) {
            itemHandler.createWeapon(p, itemHandler.bronzeingot, itemHandler.oakstick, 3, 3,
                    new ItemStack(Material.STICK), "<gold><i:false>Bronz M??zrak", 2, 11, 3, 2, 4, false, 2, 14, 0, "D??????k", 6, 6, 12,
                    12, 10, "M??zrak", 400, 4);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Bronz Topuz")) {
            itemHandler.createWeapon(p, itemHandler.bronzeingot, itemHandler.oakstick, 3, 3,
                    new ItemStack(Material.WOODEN_SHOVEL), "<gold><i:false>Bronz Topuz", 2, 12, 4, 3, 1, false, 2, 17, 0, "D??????k", 5, 6, 12,
                    12, 10, "Topuz", 400, 4);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Bronz K??rek")) {
            itemHandler.createTool(p, itemHandler.bronzeingot, 3, itemHandler.oakstick, 2,
                    new ItemStack(Material.GOLDEN_SHOVEL), "<gold><i:false>Bronz K??rek", 2, 4, false, 3, 4, 10, 10, 10, "K??rek", 400, 4);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Bronz Kazma")) {
            itemHandler.createTool(p, itemHandler.bronzeingot, 3, itemHandler.oakstick, 3,
                    new ItemStack(Material.GOLDEN_PICKAXE), "<gold><i:false>Bronz Kazma", 2, 5, false, 4, 4, 10, 10, 10, "Kazma", 400, 4);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Bronz ??apa")) {
            itemHandler.createTool(p, itemHandler.bronzeingot, 3, itemHandler.oakstick, 3,
                    new ItemStack(Material.GOLDEN_HOE), "<gold><i:false>Bronz ??apa", 2, 5, false, 4, 4, 10, 10, 10, "??apa", 400, 4);
        }

        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Bronz G??????sl??k")) {
            itemHandler.createArmor(p, "G??????sl??k", itemHandler.bronzeingot, 8,
                    new ItemStack(Material.LEATHER_CHESTPLATE), "<gold><i:false>Bronz G??????sl??k", 2, 5, 5, 7, 0, 0, 1, 0, 0, 0, 0,
                    0, 4, 15, 12, 10, 8, 400, 4);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Bronz Pantolon")) {
            itemHandler.createArmor(p, "Pantolon", itemHandler.bronzeingot, 7,
                    new ItemStack(Material.LEATHER_LEGGINGS), "<gold><i:false>Bronz Pantolon", 2, 5, 4, 6, 0, 0, 1, 0, 0, 0, 0, 0,
                    4, 15, 10, 10, 8, 400, 4);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Bronz Mi??fer")) {
            itemHandler.createArmor(p, "Mi??fer", itemHandler.bronzeingot, 5,
                    new ItemStack(Material.LEATHER_HELMET), "<gold><i:false>Bronz Mi??fer", 2, 4, 4, 6, 0, 0, 0, 0, 0, 0, 0, 0, 4,
                    15, 10, 10, 8, 400, 4);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Bronz Botlar")) {
            itemHandler.createArmor(p, "Botlar", itemHandler.bronzeingot, 4,
                    new ItemStack(Material.LEATHER_BOOTS), "<gold><i:false>Bronz Botlar", 2, 4, 4, 6, 0, 0, 1, 0, 0, 0, 0, 0, 0,
                    15, 10, 10, 8, 400, 4);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Bronz Kalkan")) {
            itemHandler.createShield(1, p, itemHandler.bronzeingot, itemHandler.oakplanks, 6, 4,
                    new ItemStack(Material.SHIELD), "<gold><i:false>Bronz Kalkan", 2, 5, 0, 0, 0, false, 0, 2, 0, "D??????k", 2,
                    6, 15, 10, 10, "Kalkan", 400, 4);
        }

        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Demir K??l????")) {
            itemHandler.createWeapon(p, itemHandler.ironingot, itemHandler.birchstick, 3, 1,
                    new ItemStack(Material.WOODEN_SWORD), "<gray><i:false>Demir K??l????", 3, 10, 4, 3, 2, false, 3, 22, 3, "D??????k", 5,
                    6, 15, 15, 10, "K??l????", 500, 6);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Demir Sava?? Baltas??")) {
            itemHandler.createWeapon(p, itemHandler.ironingot, itemHandler.birchstick, 6, 2,
                    new ItemStack(Material.WOODEN_AXE), "<gray><i:false>Demir Sava?? Baltas??", 3, 16, 4, 2, 0, false, 1, 25, 0, "Orta", 5,
                    6, 15, 15, 10, "Sava?? Baltas??", 500, 6);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "A????r Demir K??l????")) {
            itemHandler.createWeapon(p, itemHandler.ironingot, itemHandler.birchstick, 5, 1,
                    new ItemStack(Material.DIAMOND_SWORD), "<gray><i:false>A????r Demir K??l????", 2, 12, 5, 4, 2, false, 1, 20, 0, "Y??ksek", 5,
                    6, 15, 15, 10, "A????r K??l????", 500, 6);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Demir Han??er")) {
            itemHandler.createWeapon(p, itemHandler.ironingot, itemHandler.birchstick, 3, 1,
                    new ItemStack(Material.SHEARS), "<gray><i:false>Demir Han??er", 2, 7, 8, 3, 4, false, 3, 13, 5, "D??????k", 5, 6, 15,
                    15, 10, "Han??er", 500, 6);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Demir T??rpan")) {
            itemHandler.createWeapon(p, itemHandler.ironingot, itemHandler.birchstick, 3, 3,
                    new ItemStack(Material.WOODEN_HOE), "<gray><i:false>Demir T??rpan", 2, 4, 4, 5, 0, false, 2, 14, 0, "Y??ksek", 5, 6,
                    15, 15, 10, "T??rpan", 500, 6);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Demir Balta")) {
            itemHandler.createTool(p, itemHandler.ironingot, 3, itemHandler.birchstick, 2,
                    new ItemStack(Material.GOLDEN_AXE), "<gray><i:false>Demir Balta", 2, 7, false, 5, 4, 15, 15, 10, "Balta", 500, 6);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Demir M??zrak")) {
            itemHandler.createWeapon(p, itemHandler.ironingot, itemHandler.birchstick, 3, 2,
                    new ItemStack(Material.STICK), "<gray><i:false>Demir M??zrak", 2, 12, 4, 3, 4, false, 2, 18, 0, "D??????k", 6, 6, 15,
                    15, 10, "M??zrak", 500, 6);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Demir Topuz")) {
            itemHandler.createWeapon(p, itemHandler.ironingot, itemHandler.oakstick, 3, 2,
                    new ItemStack(Material.WOODEN_SHOVEL), "<gray><i:false>Demir Topuz", 2, 14, 7, 3, 1, false, 2, 19, 0, "D??????k", 5, 6, 15,
                    15, 10, "Topuz", 500, 6);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Demir K??rek")) {
            itemHandler.createTool(p, itemHandler.ironingot, 3, itemHandler.birchstick, 2,
                    new ItemStack(Material.GOLDEN_SHOVEL), "<gray><i:false>Demir K??rek", 2, 4, false, 4, 4, 15, 15, 10, "K??rek", 500, 6);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Demir Kazma")) {
            itemHandler.createTool(p, itemHandler.ironingot, 3, itemHandler.birchstick, 2,
                    new ItemStack(Material.GOLDEN_PICKAXE), "<gray><i:false>Demir Kazma", 2, 5, false, 5, 4, 15, 15, 10, "Kazma", 500, 6);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Demir ??apa")) {
            itemHandler.createTool(p, itemHandler.ironingot, 3, itemHandler.birchstick, 2,
                    new ItemStack(Material.GOLDEN_HOE), "<gray><i:false>Demir ??apa", 2, 5, false, 5, 4, 15, 15, 10, "??apa", 500, 6);
        }

        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Demir G??????sl??k")) {
            itemHandler.createArmor(p, "G??????sl??k", itemHandler.ironingot, 8,
                    new ItemStack(Material.LEATHER_CHESTPLATE), "<gray><i:false>Demir G??????sl??k", 2, 6, 6, 8, 2, 0, 1, 0, 0, 0, 0,
                    0, 4, 20, 15, 10, 2, 500, 6);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Demir Pantolon")) {
            itemHandler.createArmor(p, "Pantolon", itemHandler.ironingot, 7,
                    new ItemStack(Material.LEATHER_LEGGINGS), "<gray><i:false>Demir Pantolon", 2, 6, 4, 8, 2, 0, 1, 0, 0, 0, 0, 0,
                    4, 20, 10, 10, 2, 500, 6);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Demir Mi??fer")) {
            itemHandler.createArmor(p, "Mi??fer", itemHandler.ironingot, 5,
                    new ItemStack(Material.LEATHER_HELMET), "<gray><i:false>Demir Mi??fer", 2, 6, 5, 8, 2, 0, 0, 0, 0, 0, 0, 0, 4,
                    20, 15, 10, 2, 500, 6);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Demir Botlar")) {
            itemHandler.createArmor(p, "Botlar", itemHandler.ironingot, 4,
                    new ItemStack(Material.LEATHER_BOOTS), "<gray><i:false>Demir Botlar", 2, 6, 5, 8, 2, 0, 1, 0, 0, 0, 0, 0, 0,
                    20, 10, 10, 2, 500, 6);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Demir Kalkan")) {
            itemHandler.createShield(2, p, itemHandler.ironingot, itemHandler.birchplanks, 6, 1,
                    new ItemStack(Material.SHIELD), "<gray><i:false>Demir Kalkan", 2, 5, 0, 0, 0, false, 0, 2, 0, "D??????k", 2,
                    6, 20, 15, 10, "Kalkan", 500, 6);
        }


        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Alt??n K??l????")) {
            itemHandler.createWeapon(p, itemHandler.goldingot, itemHandler.birchstick, 3, 1,
                    new ItemStack(Material.WOODEN_SWORD), "<yellow><i:false>Alt??n K??l????", 3, 13, 5, 3, 4, false, 3, 24, 3, "D??????k", 5,
                    6, 20, 20, 10, "K??l????", 600, 8);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Alt??n Sava?? Baltas??")) {
            itemHandler.createWeapon(p, itemHandler.goldingot, itemHandler.birchstick, 6, 2,
                    new ItemStack(Material.WOODEN_AXE), "<yellow><i:false>Alt??n Sava?? Baltas??", 3, 18, 5, 3, 0, false, 1, 28, 0, "Orta", 5,
                    6, 20, 20, 10, "Sava?? Baltas??", 600, 8);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "A????r Alt??n K??l????")) {
            itemHandler.createWeapon(p, itemHandler.goldingot, itemHandler.birchstick, 5, 1,
                    new ItemStack(Material.DIAMOND_SWORD), "<yellow><i:false>A????r Alt??n K??l????", 2, 17, 7, 6, 2, false, 1, 24, 0, "Y??ksek", 5,
                    6, 20, 20, 10, "A????r K??l????", 600, 8);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Alt??n Han??er")) {
            itemHandler.createWeapon(p, itemHandler.goldingot, itemHandler.birchstick, 3, 1,
                    new ItemStack(Material.SHEARS), "<yellow><i:false>Alt??n Han??er", 2, 8, 9, 3, 5, false, 3, 15, 5, "D??????k", 5, 6, 20,
                    20, 10, "Han??er", 600, 8);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Alt??n T??rpan")) {
            itemHandler.createWeapon(p, itemHandler.goldingot, itemHandler.birchstick, 3, 3,
                    new ItemStack(Material.WOODEN_HOE), "<yellow><i:false>Alt??n T??rpan", 2, 12, 6, 5, 0, false, 2, 20, 0, "Y??ksek", 5, 6,
                    20, 20, 10, "T??rpan", 600, 8);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Alt??n Balta")) {
            itemHandler.createTool(p, itemHandler.goldingot, 3, itemHandler.birchstick, 2,
                    new ItemStack(Material.GOLDEN_AXE), "<yellow><i:false>Alt??n Balta", 2, 7, false, 6, 4, 20, 20, 10, "Balta", 600, 8);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Alt??n M??zrak")) {
            itemHandler.createWeapon(p, itemHandler.goldingot, itemHandler.birchstick, 3, 2,
                    new ItemStack(Material.STICK), "<yellow><i:false>Alt??n M??zrak", 2, 15, 6, 3, 4, false, 2, 22, 0, "D??????k", 6, 6, 20,
                    20, 10, "M??zrak", 600, 8);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Alt??n Topuz")) {
            itemHandler.createWeapon(p, itemHandler.goldingot, itemHandler.oakstick, 3, 2,
                    new ItemStack(Material.WOODEN_SHOVEL), "<yellow><i:false>Alt??n Topuz", 2, 13, 7, 4, 1, false, 2, 23, 0, "D??????k", 5, 6, 20,
                    20, 10, "Topuz", 600, 8);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Alt??n K??rek")) {
            itemHandler.createTool(p, itemHandler.goldingot, 3, itemHandler.birchstick, 2,
                    new ItemStack(Material.GOLDEN_SHOVEL), "<yellow><i:false>Alt??n K??rek", 2, 4, false, 5, 4, 20, 20, 10, "K??rek", 600, 8);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Alt??n Kazma")) {
            itemHandler.createTool(p, itemHandler.goldingot, 3, itemHandler.birchstick, 2,
                    new ItemStack(Material.GOLDEN_PICKAXE), "<yellow><i:false>Alt??n Kazma", 2, 5, false, 6, 4, 25, 15, 10, "Kazma", 600, 8);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Alt??n ??apa")) {
            itemHandler.createTool(p, itemHandler.goldingot, 3, itemHandler.birchstick, 2,
                    new ItemStack(Material.GOLDEN_HOE), "<yellow><i:false>Alt??n ??apa", 2, 5, false, 6, 4, 25, 15, 10, "??apa", 600, 8);
        }

        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Alt??n G??????sl??k")) {
            itemHandler.createArmor(p, "G??????sl??k", itemHandler.goldingot, 8,
                    new ItemStack(Material.LEATHER_CHESTPLATE), "<yellow><i:false>Alt??n G??????sl??k", 2, 7, 6, 9, 3, 1, 1, 0, 0, 0, 0,
                    0, 4, 25, 20, 10, 9, 600, 8);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Alt??n Pantolon")) {
            itemHandler.createArmor(p, "Pantolon", itemHandler.goldingot, 7,
                    new ItemStack(Material.LEATHER_LEGGINGS), "<yellow><i:false>Alt??n Pantolon", 2, 7, 4, 9, 3, 1, 1, 0, 0, 0, 0, 0,
                    4, 25, 20, 10, 9, 600, 8);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Alt??n Mi??fer")) {
            itemHandler.createArmor(p, "Mi??fer", itemHandler.goldingot, 5,
                    new ItemStack(Material.LEATHER_HELMET), "<yellow><i:false>Alt??n Mi??fer", 2, 6, 5, 9, 3, 1, 0, 0, 0, 0, 0, 0, 4,
                    25, 20, 10, 9, 600, 8);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Alt??n Botlar")) {
            itemHandler.createArmor(p, "Botlar", itemHandler.goldingot, 4,
                    new ItemStack(Material.LEATHER_BOOTS), "<yellow><i:false>Alt??n Botlar", 2, 6, 5, 8, 3, 1, 1, 0, 0, 0, 0, 0, 0,
                    25, 20, 10, 9, 600, 8);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Alt??n Kalkan")) {
            itemHandler.createShield(9, p, itemHandler.goldingot, itemHandler.birchplanks, 6, 1,
                    new ItemStack(Material.SHIELD), "<yellow><i:false>Alt??n Kalkan", 2, 5, 0, 0, 0, false, 0, 2, 0, "D??????k", 2,
                    6, 25, 20, 10, "Kalkan", 600, 8);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Obsidyen K??l????")) {
            itemHandler.createWeapon(p, itemHandler.obsidianingot, itemHandler.heavystick, 3, 1,
                    new ItemStack(Material.WOODEN_SWORD), "<dark_purple><i:false>Obsidyen K??l????", 3, 16, 8, 6, 5, false, 3, 25, 3, "D??????k", 5,
                    6, 30, 30, 10, "K??l????", 800, 10);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Obsidyen Sava?? Baltas??")) {
            itemHandler.createWeapon(p, itemHandler.obsidianingot, itemHandler.heavystick, 6, 2,
                    new ItemStack(Material.WOODEN_AXE), "<dark_purple><i:false>Obsidyen Sava?? Baltas??", 3, 23, 8, 5, 0, false, 1, 32, 0, "Orta", 5,
                    6, 30, 30, 10, "Sava?? Baltas??", 800, 10);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "A????r Obsidyen K??l????")) {
            itemHandler.createWeapon(p, itemHandler.obsidianingot, itemHandler.heavystick, 5, 1,
                    new ItemStack(Material.DIAMOND_SWORD), "<dark_purple><i:false>A????r Obsidyen K??l????", 3, 23, 10, 8, 0, false, 1, 29, 0, "Y??ksek", 5,
                    6, 30, 30, 10, "A????r K??l????", 800, 10);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Obsidyen Han??er")) {
            itemHandler.createWeapon(p, itemHandler.obsidianingot, itemHandler.heavystick, 3, 1,
                    new ItemStack(Material.SHEARS), "<dark_purple><i:false>Obsidyen Han??er", 3, 11, 9, 4, 6, false, 3, 20, 5, "D??????k", 5, 6, 30,
                    30, 10, "Han??er", 800, 10);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Obsidyen T??rpan")) {
            itemHandler.createWeapon(p, itemHandler.obsidianingot, itemHandler.heavystick, 3, 3,
                    new ItemStack(Material.WOODEN_HOE), "<dark_purple><i:false>Obsidyen T??rpan", 2, 17, 10, 7, 0, false, 2, 20, 0, "Y??ksek", 5, 6,
                    30, 30, 10, "T??rpan", 800, 10);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Obsidyen Balta")) {
            itemHandler.createTool(p, itemHandler.obsidianingot, 3, itemHandler.heavystick, 2,
                    new ItemStack(Material.GOLDEN_AXE), "<dark_purple><i:false>Obsidyen Balta", 3, 8, false, 7, 4, 30, 30, 10, "Balta", 800, 10);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Obsidyen M??zrak")) {
            itemHandler.createWeapon(p, itemHandler.obsidianingot, itemHandler.heavystick, 3, 2,
                    new ItemStack(Material.STICK), "<dark_purple><i:false>Obsidyen M??zrak", 3, 17, 20, 6, 7, false, 2, 27, 0, "D??????k", 6, 6, 30,
                    30, 10, "M??zrak", 800, 10);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Obsidyen Topuz")) {
            itemHandler.createWeapon(p, itemHandler.obsidianingot, itemHandler.heavystick, 3, 2,
                    new ItemStack(Material.WOODEN_SHOVEL), "<dark_purple><i:false>Obsidyen Topuz", 3, 16, 20, 5, 1, false, 2, 33, 0, "D??????k", 5, 6, 26,
                    30, 10, "Topuz", 800, 10);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Obsidyen K??rek")) {
            itemHandler.createTool(p, itemHandler.obsidianingot, 3, itemHandler.heavystick, 2,
                    new ItemStack(Material.GOLDEN_SHOVEL), "<dark_purple><i:false>Obsidyen K??rek", 3, 6, false, 7, 4, 20, 20, 10, "K??rek", 800, 10);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Obsidyen Kazma")) {
            itemHandler.createTool(p, itemHandler.obsidianingot, 3, itemHandler.heavystick, 2,
                    new ItemStack(Material.GOLDEN_PICKAXE), "<dark_purple><i:false>Obsidyen Kazma", 3, 6, false, 7, 4, 25, 20, 10, "Kazma", 800, 10);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Obsidyen ??apa")) {
            itemHandler.createTool(p, itemHandler.obsidianingot, 3, itemHandler.heavystick, 2,
                    new ItemStack(Material.GOLDEN_HOE), "<dark_purple><i:false>Obsidyen ??apa", 3, 6, false, 7, 4, 25, 20, 10, "??apa", 800, 10);
        }

        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Obsidyen G??????sl??k")) {
            itemHandler.createArmor(p, "G??????sl??k", itemHandler.obsidianingot, 8,
                    new ItemStack(Material.LEATHER_CHESTPLATE), "<dark_purple><i:false>Obsidyen G??????sl??k", 3, 7, 10, 12, 6, 0, 3, 0, 5, 0, 0,
                    0, 4, 33, 34, 10, 7, 800, 10);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Obsidyen Pantolon")) {
            itemHandler.createArmor(p, "Pantolon", itemHandler.obsidianingot, 7,
                    new ItemStack(Material.LEATHER_LEGGINGS), "<dark_purple><i:false>Obsidyen Pantolon", 3, 7, 8, 11, 6, 0, 2, 0, 6, 0, 0, 0,
                    4, 32, 33, 10, 7, 800, 10);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Obsidyen Mi??fer")) {
            itemHandler.createArmor(p, "Mi??fer", itemHandler.obsidianingot, 5,
                    new ItemStack(Material.LEATHER_HELMET), "<dark_purple><i:false>Obsidyen Mi??fer", 3, 7, 6, 10, 6, 0, 2, 0, 4, 0, 0, 0, 4,
                    30, 32, 10, 7, 800, 10);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Obsidyen Botlar")) {
            itemHandler.createArmor(p, "Botlar", itemHandler.obsidianingot, 4,
                    new ItemStack(Material.LEATHER_BOOTS), "<dark_purple><i:false>Obsidyen Botlar", 3, 7, 6, 10, 5, 0, 3, 0, 4, 0, 0, 0, 0,
                    30, 32, 10, 7, 800, 10);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.YELLOW + "Obsidyen Kalkan")) {
            itemHandler.createShield(9, p, itemHandler.obsidianingot, itemHandler.heavyplanks, 6, 1,
                    new ItemStack(Material.SHIELD), "<dark_purple><i:false>Obsidyen Kalkan", 3, 5, 0, 0, 0, false, 0, 2, 0, "D??????k", 2,
                    6, 27, 26, 10, "Kalkan", 800, 10);
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.DARK_AQUA + "Avc??l??k")) {
            int combatlevel = stats.getCombatLevel(p.getUniqueId());
            if ((stats.getMeslek(p.getUniqueId()).equals("Yok.."))) {
                if (combatlevel >= 5) {
                    itemHandler.createItem(inv, "iron_sword", 1, 12,
                            Painter.paint("&3Avc??l??k &8[&7Meslek Bilgileri&8]"), "",
                            Painter.paint(" &fMeslek Avantajlar??:"),
                            Painter.paint("&7 - Yarat??klardan ekstra tecr??be puan?? d????er."), Painter.paint(" &7- Yok.."), "",
                            Painter.paint("&7Bu mesle??i se??mek i??in &e&lSa?? T??kla."));
                } else {
                    itemHandler.createItem(inv, "iron_sword", 1, 12,
                            Painter.paint("&3Avc??l??k &8[&7Meslek Bilgileri&8]"), "",
                            Painter.paint(" &fMeslek Avantajlar??:"),
                            Painter.paint("&7 - Yarat??klardan ekstra tecr??be puan?? d????er."), Painter.paint(" &7- Yok.."), "",
                            Painter.paint("&cBu mesle??i se??ebilmek i??in Avc??l??kta 5. seviye olman gerek."));
                }
            } else {
                itemHandler.createItem(inv, "iron_sword", 1, 12, Painter.paint("&cAvc??l??k &8[&7Meslek Bilgileri&8]"),
                        "", Painter.paint(" &fMeslek Avantajlar??:"),
                        Painter.paint("&7 - Yarat??klardan ekstra tecr??be puan?? d????er."), Painter.paint(" &7- Yok.."), "",
                        Painter.paint("&cZaten bir meslek se??mi??sin!"));

            }

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.DARK_AQUA + "Madencilik")) {
            int mininglevel = stats.getMadencilikLevel(p.getUniqueId());
            if ((stats.getMeslek(p.getUniqueId()).equals("Yok.."))) {
                if (mininglevel >= 5) {
                    itemHandler.createItem(inv, "iron_pickaxe", 1, 13,
                            Painter.paint("&3Madencilik &8[&7Meslek Bilgileri&8]"), "",
                            Painter.paint(" &fMeslek Avantajlar??:"),
                            Painter.paint("&7 - Kaz??lan madenlerden ek maden d????er."), Painter.paint(" &7 - Yok.."), "",
                            Painter.paint("&7Bu mesle??i se??mek i??in &e&lSa?? T??kla."));
                } else {
                    itemHandler.createItem(inv, "iron_pickaxe", 1, 13,
                            Painter.paint("&3Madencilik &8[&7Meslek Bilgileri&8]"), "",
                            Painter.paint(" &fMeslek Avantajlar??:"),
                            Painter.paint("&7 - Kaz??lan madenlerden ek maden d????er."), Painter.paint(" &7- Yok.."), "",
                            Painter.paint("&cBu mesle??i se??ebilmek i??in Madencilikte 5. seviye olman gerek."));
                }
            } else {
                itemHandler.createItem(inv, "iron_pickaxe", 1, 13,
                        Painter.paint("&cMadencilik &8[&7Meslek Bilgileri&8]"), "",
                        Painter.paint(" &fMeslek Avantajlar??:"),
                        Painter.paint("&7 - Kaz??lan madenlerden ek maden d????er."), Painter.paint(" &7- Yok.."), "",
                        Painter.paint("&cZaten bir meslek se??mi??sin!"));
            }

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.DARK_AQUA + "Odunculuk")) {
            int mininglevel = stats.getOdunculukLevel(p.getUniqueId());
            if ((stats.getMeslek(p.getUniqueId()).equals("Yok.."))) {
                if (mininglevel >= 5) {
                    itemHandler.createItem(inv, "iron_axe", 1, 14,
                            Painter.paint("&3Odunculuk &8[&7Meslek Bilgileri&8]"), "",
                            Painter.paint(" &fMeslek Avantajlar??:"),
                            Painter.paint("&7 - Balta ile ekstra hasar uygulars??n."), Painter.paint(" &7- Yok.."), "",
                            Painter.paint("&7Bu mesle??i se??mek i??in &e&lSa?? T??kla."));
                } else {
                    itemHandler.createItem(inv, "iron_axe", 1, 14,
                            Painter.paint("&3Odunculuk &8[&7Meslek Bilgileri&8]"), "",
                            Painter.paint(" &fMeslek Avantajlar??:"),
                            Painter.paint("&7 - Balta ile ekstra hasar uygulars??n."), Painter.paint(" &7- Yok.."), "",
                            Painter.paint("&cBu mesle??i se??ebilmek i??in Odunculukta 5. seviye olman gerek."));
                }
            } else {
                itemHandler.createItem(inv, "iron_axe", 1, 14, Painter.paint("&cOdunculuk &8[&7Meslek Bilgileri&8]"),
                        "", Painter.paint(" &fMeslek Avantajlar??:"),
                        Painter.paint("&7 - Balta ile ekstra hasar uygulars??n."), Painter.paint(" &7- Yok.."), "",
                        Painter.paint("&cZaten bir meslek se??mi??sin!"));
            }

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.DARK_AQUA + "Bal??k????l??k")) {
            int mininglevel = stats.getFishingLevel(p.getUniqueId());
            if ((stats.getMeslek(p.getUniqueId()).equals("Yok.."))) {
                if (mininglevel >= 5) {
                    itemHandler.createItem(inv, "fishing_rod", 1, 15,
                            Painter.paint("&3Bal??k????l??k &8[&7Meslek Bilgileri&8]"), "",
                            Painter.paint(" &fMeslek Avantajlar??:"),
                            Painter.paint("&7 - Bal??k tutarken kutu ??ekme ??ans??n?? artt??r??r."),
                            Painter.paint(" &7- Yok.."), "", Painter.paint("&7Bu mesle??i se??mek i??in &e&lSa?? T??kla."));
                } else {
                    itemHandler.createItem(inv, "fishing_rod", 1, 15,
                            Painter.paint("&3Bal??k????l??k &8[&7Meslek Bilgileri&8]"), "",
                            Painter.paint(" &fMeslek Avantajlar??:"),
                            Painter.paint("&7 - Bal??k tutarken kutu ??ekme ??ans??n?? artt??r??r."),
                            Painter.paint(" &7- Yok.."), "",
                            Painter.paint("&cBu mesle??i se??ebilmek i??in Bal??k????l??kta 5. seviye olman gerek."));
                }
            } else {
                itemHandler.createItem(inv, "fishing_rod", 1, 15,
                        Painter.paint("&cBal??k????l??k &8[&7Meslek Bilgileri&8]"), "",
                        Painter.paint(" &fMeslek Avantajlar??:"),
                        Painter.paint("&7 - Bal??k tutarken kutu ??ekme ??ans??n?? artt??r??r."), Painter.paint(" &7- Yok.."),
                        "", Painter.paint("&cZaten bir meslek se??mi??sin!"));
            }

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.DARK_AQUA + "Demircilik")) {
            int mininglevel = stats.getSmithLevel(p.getUniqueId());
            if ((stats.getMeslek(p.getUniqueId()).equals("Yok.."))) {
                if (mininglevel >= 5) {
                    itemHandler.createItem(inv, "smithing_table", 1, 16,
                            Painter.paint("&3Demircilik &8[&7Meslek Bilgileri&8]"), "",
                            Painter.paint(" &fMeslek Avantajlar??:"),
                            Painter.paint("&7 - Bir ekipman i??ledi??inde ya ekstra ya da ekstra demircilik puan?? kazan??rs??n."), Painter.paint(" &7- Yok.."), "",
                            Painter.paint("&7Bu mesle??i se??mek i??in &e&lSa?? T??kla."));
                } else {
                    itemHandler.createItem(inv, "smithing_table", 1, 16,
                            Painter.paint("&3Demircilik &8[&7Meslek Bilgileri&8]"), "",
                            Painter.paint(" &fMeslek Avantajlar??:"),
                            Painter.paint("&7 - Bir ekipman i??ledi??inde ya ekstra ya da ekstra demircilik puan?? kazan??rs??n."), Painter.paint(" &7- Yok.."), ""
                            , Painter.paint(" &7- Yok.."), "",
                            Painter.paint("&cBu mesle??i se??ebilmek i??in Demircilikte 5. seviye olman gerek."));
                }
            } else {
                itemHandler.createItem(inv, "smithing_table", 1, 16,
                        Painter.paint("&cDemircilik &8[&7Meslek Bilgileri&8]"), "",
                        Painter.paint(" &fMeslek Avantajlar??:"),
                        Painter.paint("&7 - Bir ekipman i??ledi??inde ya ekstra ya da ekstra demircilik puan?? kazan??rs??n."), Painter.paint(" &7- Yok.."), ""
                        , Painter.paint(" &7- Yok.."), "",
                        Painter.paint("&cZaten bir meslek se??mi??sin!"));
            }
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.DARK_AQUA + "A??????l??k")) {
            int mininglevel = stats.getCookLevel(p.getUniqueId());
            if ((stats.getMeslek(p.getUniqueId()).equals("Yok.."))) {
                if (mininglevel >= 5) {
                    itemHandler.createItem(inv, "bread", 1, 22, Painter.paint("&3A??????l??k &8[&7Meslek Bilgileri&8]"), "",
                            Painter.paint(" &fMeslek Avantajlar??:"),
                            Painter.paint("&7 - Pi??irilen yemeklerin etkisi artar."), Painter.paint(" &7- Yok.."), "",
                            Painter.paint("&7Bu mesle??i se??mek i??in &e&lSa?? T??kla."));
                } else {
                    itemHandler.createItem(inv, "bread", 1, 22, Painter.paint("&3A??????l??k &8[&7Meslek Bilgileri&8]"), "",
                            Painter.paint(" &fMeslek Avantajlar??:"),
                            Painter.paint("&7 - Pi??irilen yemeklerin etkisi artar."), Painter.paint(" &7- Yok.."), "",
                            Painter.paint("&cBu mesle??i se??ebilmek i??in A??????l??kta 5. seviye olman gerek."));
                }
            } else {
                itemHandler.createItem(inv, "bread", 1, 22, Painter.paint("&cA??????l??k &8[&7Meslek Bilgileri&8]"), "",
                        Painter.paint(" &fMeslek Avantajlar??:"),
                        Painter.paint("&7 - Pi??irilen yemeklerin etkisi artar."), Painter.paint(" &7- Yok.."), "",
                        Painter.paint("&cZaten bir meslek se??mi??sin!"));
            }

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.DARK_AQUA + "Simyac??l??k")) {
            int mininglevel = stats.getAlchemyLevel(p.getUniqueId());
            if ((stats.getMeslek(p.getUniqueId()).equals("Yok.."))) {
                if (mininglevel >= 5) {
                    itemHandler.createItem(inv, "brewing_stand", 1, 23,
                            Painter.paint("&3Simyac??l??k &8[&7Meslek Bilgileri&8]"), "",
                            Painter.paint(" &fMeslek Avantajlar??:"),
                            Painter.paint("&7 - Mayalanan iksirlerin etkisi artar."), Painter.paint(" &7- Yok.."), "",
                            Painter.paint("&7Bu mesle??i se??mek i??in &e&lSa?? T??kla."));
                } else {
                    itemHandler.createItem(inv, "brewing_stand", 1, 23,
                            Painter.paint("&3Simyac??l??k &8[&7Meslek Bilgileri&8]"), "",
                            Painter.paint(" &fMeslek Avantajlar??:"),
                            Painter.paint("&7 - Mayalanan iksirlerin etkisi artar."), Painter.paint(" &7- Yok.."), "",
                            Painter.paint("&cBu mesle??i se??ebilmek i??in Simyac??l??kta 5. seviye olman gerek."));
                }
            } else {
                itemHandler.createItem(inv, "brewing_stand", 1, 23,
                        Painter.paint("&cSimyac??l??k &8[&7Meslek Bilgileri&8]"), "",
                        Painter.paint(" &fMeslek Avantajlar??:"),
                        Painter.paint("&7 - Mayalanan iksirlerin etkisi artar."), Painter.paint(" &7- Yok.."), "",
                        Painter.paint("&cZaten bir meslek se??mi??sin!"));
            }
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.DARK_AQUA + "El Sanatlar??")) {
            int workLevel = stats.getWorkLevel(p.getUniqueId());
            if ((stats.getMeslek(p.getUniqueId()).equals("Yok.."))) {
                if (workLevel >= 5) {
                    itemHandler.createItem(inv, "fletching_table", 1, 33,
                            Painter.paint("&3El Sanatlar?? &8[&7Meslek Bilgileri&8]"), "",
                            Painter.paint(" &fMeslek Avantajlar??:"),
                            Painter.paint("&7 - El sanatlar?? masas??n?? kullanarak yap??lan itemler daha dayan??kl?? olur."), Painter.paint(" &7- Yok.."), "",
                            Painter.paint("&7Bu mesle??i se??mek i??in &e&lSa?? T??kla."));
                } else {
                    itemHandler.createItem(inv, "fletching_table", 1, 33,
                            Painter.paint("&3El Sanatlar?? &8[&7Meslek Bilgileri&8]"), "",
                            Painter.paint(" &fMeslek Avantajlar??:"),
                            Painter.paint("&7 - El sanatlar?? masas??n?? kullanarak yap??lan itemler daha dayan??kl?? olur."), Painter.paint(" &7- Yok.."), "",
                            Painter.paint("&cBu mesle??i se??ebilmek i??in El Sanatlar??nda 5. seviye olman gerek."));
                }
            } else {
                itemHandler.createItem(inv, "fletching_table", 1, 33,
                        Painter.paint("&cEl Sanatlar?? &8[&7Meslek Bilgileri&8]"), "",
                        Painter.paint(" &fMeslek Avantajlar??:"),
                        Painter.paint("&7 - El sanatlar?? masas??n?? kullanarak yap??lan itemler daha dayan??kl?? olur."), Painter.paint(" &7- Yok.."), "",
                        Painter.paint("&cZaten bir meslek se??mi??sin!"));
            }
        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.DARK_AQUA + "B??y??c??l??k")) {
            int mininglevel = stats.getEnchLevel(p.getUniqueId());
            if ((stats.getMeslek(p.getUniqueId()).equals("Yok.."))) {
                if (mininglevel >= 5) {
                    itemHandler.createItem(inv, "enchanting_table", 1, 24,
                            Painter.paint("&3B??y??c??l??k &8[&7Meslek Bilgileri&8]"), "",
                            Painter.paint(" &fMeslek Avantajlar??:"),
                            Painter.paint("&7 - Bir ekipman?? b??y??lerken seviye gereksinimi azal??r."),
                            Painter.paint(" &7 - Yok.."), "", Painter.paint("&7Bu mesle??i se??mek i??in &e&lSa?? T??kla."));
                } else {
                    itemHandler.createItem(inv, "enchanting_table", 1, 24,
                            Painter.paint("&3B??y??c??l??k &8[&7Meslek Bilgileri&8]"), "",
                            Painter.paint(" &fMeslek Avantajlar??:"),
                            Painter.paint("&7 - Bir ekipman?? b??y??lerken seviye gereksinimi azal??r."),
                            Painter.paint(" &7- Yok.."), "",
                            Painter.paint("&cBu mesle??i se??ebilmek i??in B??y??c??l??kte 5. seviye olman gerek."));
                }
            } else {
                itemHandler.createItem(inv, "enchanting_table", 1, 24,
                        Painter.paint("&cB??y??c??l??k &8[&7Meslek Bilgileri&8]"), "",
                        Painter.paint(" &fMeslek Avantajlar??:"),
                        Painter.paint("&7 - Bir ekipman?? b??y??lerken seviye gereksinimi azal??r."),
                        Painter.paint(" &7- Yok.."), "", Painter.paint("&cZaten bir meslek se??mi??sin!"));
            }

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(ChatColor.DARK_AQUA + "??ift??ilik")) {
            int mininglevel = stats.getFarmingLevel(p.getUniqueId());
            if ((stats.getMeslek(p.getUniqueId()).equals("Yok.."))) {
                if (mininglevel >= 5) {
                    itemHandler.createItem(inv, "wheat", 1, 31, Painter.paint("&3??ift??ilik &8[&7Meslek Bilgileri&8]"),
                            "", Painter.paint(" &fMeslek Avantajlar??:"),
                            Painter.paint("&7 - Hasat yaparken ekinlerden ekstra ??r??n d????er."),
                            Painter.paint(" &7- Yok.."), "", Painter.paint("&7Bu mesle??i se??mek i??in &e&lSa?? T??kla."));
                } else {
                    itemHandler.createItem(inv, "wheat", 1, 31, Painter.paint("&3??ift??ilik &8[&7Meslek Bilgileri&8]"),
                            "", Painter.paint(" &fMeslek Avantajlar??:"),
                            Painter.paint("&7 - Hasat yaparken ekinlerden ekstra ??r??n d????er."),
                            Painter.paint(" &7- Yok.."), "",
                            Painter.paint("&cBu mesle??i se??ebilmek i??in ??ift??ilikte 5. seviye olman gerek."));
                }
            } else {
                itemHandler.createItem(inv, "wheat", 1, 31, Painter.paint("&c??ift??ilik &8[&7Meslek Bilgileri&8]"), "",
                        Painter.paint(" &fMeslek Avantajlar??:"),
                        Painter.paint("&7 - Hasat yaparken ekinlerden ekstra ??r??n d????er."), Painter.paint(" &7- Yok.."),
                        "", Painter.paint("&cZaten bir meslek se??mi??sin!"));
            }
        }

        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName() && clicked.getItemMeta()
                        .

                getDisplayName().

                equalsIgnoreCase(Painter.paint("&3Avc??l??k &8[&7Meslek Bilgileri&8]"))) {
            int combatlevel = stats.getCombatLevel(p.getUniqueId());
            if (combatlevel >= 5) {
                itemHandler.createItem(inv, "iron_sword", 1, 12, Painter.paint("&3Avc??l??k &8[&7Meslek Bilgileri&8]"),
                        "", Painter.paint(" &fMeslek Avantajlar??:"),
                        Painter.paint("&7 - Yarat??klardan ekstra tecr??be puan?? d????er."), Painter.paint(" &7- Yok.."), "",
                        Painter.paint("&cE??er bu mesle??i se??ersen uzun bir s??re"),
                        Painter.paint("&cmesle??ini de??i??teremeyeceksin. Bu mesle??i se??meyi"),
                        Painter.paint("&conayl??yorsan tekrar &e&lSa?? T??kla."));
                jobekle("Avc??", p);
            }

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName() && clicked.getItemMeta()
                        .

                getDisplayName().

                equalsIgnoreCase(Painter.paint("&3El Sanatlar?? &8[&7Meslek Bilgileri&8]"))) {
            int workLevel = stats.getWorkLevel(p.getUniqueId());
            if (workLevel >= 5) {
                itemHandler.createItem(inv, "flecthing_table", 1, 33,
                        Painter.paint("&3El Sanatlar?? &8[&7Meslek Bilgileri&8]"), "",
                        Painter.paint(" &fMeslek Avantajlar??:"),
                        Painter.paint("&7 - El sanatlar?? masas??n?? kullanarak yap??lan itemler daha dayan??kl?? olur."), Painter.paint(" &7- Yok.."), "",
                        Painter.paint("&cE??er bu mesle??i se??ersen uzun bir s??re"),
                        Painter.paint("&cmesle??ini de??i??teremeyeceksin. Bu mesle??i se??meyi"),
                        Painter.paint("&conayl??yorsan tekrar &e&lSa?? T??kla."));
                jobekle("Zanaatkar", p);
            }

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName() && clicked.getItemMeta()
                        .

                getDisplayName().

                equalsIgnoreCase(Painter.paint("&3Madencilik &8[&7Meslek Bilgileri&8]"))) {
            int mininglevel = stats.getMadencilikLevel(p.getUniqueId());
            if (mininglevel >= 5) {
                itemHandler.createItem(inv, "iron_pickaxe", 1, 13,
                        Painter.paint("&3Madencilik &8[&7Meslek Bilgileri&8]"), "",
                        Painter.paint(" &fMeslek Avantajlar??:"),
                        Painter.paint("&7 - Kaz??lan madenlerden ek maden d????er."), Painter.paint(" &7 - Yok.."), "",
                        Painter.paint("&cE??er bu mesle??i se??ersen uzun bir s??re"),
                        Painter.paint("&cmesle??ini de??i??teremeyeceksin. Bu mesle??i se??meyi"),
                        Painter.paint("&conayl??yorsan tekrar &e&lSa?? T??kla."));
                jobekle("Madenci", p);
            }

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName() && clicked.getItemMeta()
                        .

                getDisplayName().

                equalsIgnoreCase(Painter.paint("&3Odunculuk &8[&7Meslek Bilgileri&8]"))) {
            int mininglevel = stats.getOdunculukLevel(p.getUniqueId());
            if (mininglevel >= 5) {
                itemHandler.createItem(inv, "iron_axe", 1, 14, Painter.paint("&3Odunculuk &8[&7Meslek Bilgileri&8]"),
                        "", Painter.paint(" &fMeslek Avantajlar??:"),
                        Painter.paint("&7 - Balta ile ekstra hasar uygulars??n."), Painter.paint(" &7- Yok.."), "",
                        Painter.paint("&cE??er bu mesle??i se??ersen uzun bir s??re"),
                        Painter.paint("&cmesle??ini de??i??teremeyeceksin. Bu mesle??i se??meyi"),
                        Painter.paint("&conayl??yorsan tekrar &e&lSa?? T??kla."));
                jobekle("Oduncu", p);
            }

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName() && clicked.getItemMeta()
                        .

                getDisplayName().

                equalsIgnoreCase(Painter.paint("&3Bal??k????l??k &8[&7Meslek Bilgileri&8]"))) {
            int mininglevel = stats.getFishingLevel(p.getUniqueId());
            if (mininglevel >= 5) {
                itemHandler.createItem(inv, "fishing_rod", 1, 15,
                        Painter.paint("&3Bal??k????l??k &8[&7Meslek Bilgileri&8]"), "",
                        Painter.paint(" &fMeslek Avantajlar??:"),
                        Painter.paint("&7 - Bal??k tutarken kutu ??ekme ??ans??n?? artt??r??r."), Painter.paint(" &7- Yok.."),
                        "", Painter.paint("&cE??er bu mesle??i se??ersen uzun bir s??re"),
                        Painter.paint("&cmesle??ini de??i??teremeyeceksin. Bu mesle??i se??meyi"),
                        Painter.paint("&conayl??yorsan tekrar &e&lSa?? T??kla."));
                jobekle("Bal??k????", p);
            }

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName() && clicked.getItemMeta()
                        .

                getDisplayName().

                equalsIgnoreCase(Painter.paint("&3Demircilik &8[&7Meslek Bilgileri&8]"))) {
            int mininglevel = stats.getSmithLevel(p.getUniqueId());
            if (mininglevel >= 5) {
                itemHandler.createItem(inv, "smithing_table", 1, 16,
                        Painter.paint("&3Demircilik &8[&7Meslek Bilgileri&8]"), "",
                        Painter.paint(" &fMeslek Avantajlar??:"),
                        Painter.paint("&7 - Bir ekipman i??ledi??inde ya ekstra ya da ekstra demircilik puan?? kazan??rs??n."), Painter.paint(" &7- Yok.."), ""
                        , Painter.paint(" &7- Yok.."), "",
                        Painter.paint("&cE??er bu mesle??i se??ersen uzun bir s??re"),
                        Painter.paint("&cmesle??ini de??i??teremeyeceksin. Bu mesle??i se??meyi"),
                        Painter.paint("&conayl??yorsan tekrar &e&lSa?? T??kla."));
                jobekle("Demirci", p);
            }

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName() && clicked.getItemMeta()
                        .

                getDisplayName().

                equalsIgnoreCase(Painter.paint("&3A??????l??k &8[&7Meslek Bilgileri&8]"))) {
            int mininglevel = stats.getCookLevel(p.getUniqueId());
            if (mininglevel >= 5) {
                itemHandler.createItem(inv, "bread", 1, 22, Painter.paint("&3A??????l??k &8[&7Meslek Bilgileri&8]"), "",
                        Painter.paint(" &fMeslek Avantajlar??:"),
                        Painter.paint("&7 - Pi??irilen yemeklerin etkisi artar."), Painter.paint(" &7- Yok.."), "",
                        Painter.paint("&cE??er bu mesle??i se??ersen uzun bir s??re"),
                        Painter.paint("&cmesle??ini de??i??teremeyeceksin. Bu mesle??i se??meyi"),
                        Painter.paint("&conayl??yorsan tekrar &e&lSa?? T??kla."));
                jobekle("A??????", p);
            }

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName() && clicked.getItemMeta()
                        .

                getDisplayName().

                equalsIgnoreCase(Painter.paint("&cMesle??ini S??f??rla!"))) {

            if (!(stats.getMeslek(p.getUniqueId()).equals("Yok.."))) {
                jobekle("Yok..", p);
            }

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName() && clicked.getItemMeta()
                        .

                getDisplayName().

                equalsIgnoreCase(Painter.paint("&3Simyac??l??k &8[&7Meslek Bilgileri&8]"))) {
            int mininglevel = stats.getAlchemyLevel(p.getUniqueId());
            if (mininglevel >= 5) {
                itemHandler.createItem(inv, "brewing_stand", 1, 23,
                        Painter.paint("&3Simyac??l??k &8[&7Meslek Bilgileri&8]"), "",
                        Painter.paint(" &fMeslek Avantajlar??:"),
                        Painter.paint("&7 - Mayalanan iksirlerin etkisi artar."), Painter.paint(" &7- Yok.."), "",
                        Painter.paint("&cE??er bu mesle??i se??ersen uzun bir s??re"),
                        Painter.paint("&cmesle??ini de??i??teremeyeceksin. Bu mesle??i se??meyi"),
                        Painter.paint("&conayl??yorsan tekrar &e&lSa?? T??kla."));
                jobekle("Simyac??", p);
            }

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName() && clicked.getItemMeta()
                        .

                getDisplayName().

                equalsIgnoreCase(Painter.paint("&3B??y??c??l??k &8[&7Meslek Bilgileri&8]"))) {
            int mininglevel = stats.getEnchLevel(p.getUniqueId());
            if (mininglevel >= 5) {
                itemHandler.createItem(inv, "enchanting_table", 1, 24,
                        Painter.paint("&3B??y??c??l??k &8[&7Meslek Bilgileri&8]"), "",
                        Painter.paint(" &fMeslek Avantajlar??:"),
                        Painter.paint("&7 - Bir ekipman?? b??y??lerken seviye gereksinimi azal??r."),
                        Painter.paint(" &7 - Yok.."), "", Painter.paint("&cE??er bu mesle??i se??ersen uzun bir s??re"),
                        Painter.paint("&cmesle??ini de??i??teremeyeceksin. Bu mesle??i se??meyi"),
                        Painter.paint("&conayl??yorsan tekrar &e&lSa?? T??kla."));
                jobekle("B??y??c??", p);
            }

        }
        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName() && clicked.getItemMeta()
                        .

                getDisplayName().

                equalsIgnoreCase(Painter.paint("&3??ift??ilik &8[&7Meslek Bilgileri&8]"))) {
            int mininglevel = stats.getFarmingLevel(p.getUniqueId());
            if (mininglevel >= 5) {
                itemHandler.createItem(inv, "wheat", 1, 31, Painter.paint("&3??ift??ilik &8[&7Meslek Bilgileri&8]"), "",
                        Painter.paint(" &fMeslek Avantajlar??:"),
                        Painter.paint("&7 - Hasat yaparken ekinlerden ekstra ??r??n d????er."), Painter.paint(" &7- Yok.."),
                        "", Painter.paint("&cE??er bu mesle??i se??ersen uzun bir s??re"),
                        Painter.paint("&cmesle??ini de??i??teremeyeceksin. Bu mesle??i se??meyi"),
                        Painter.paint("&conayl??yorsan tekrar &e&lSa?? T??kla."));
                jobekle("??ift??i", p);
            }

        }

        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().

                equalsIgnoreCase(Painter.paint("&c2. Bo?? ??retim Alan??"))) {
            int smithLevel = stats.getSmithLevel(p.getUniqueId());
            if (smithLevel >= 10) {
                p.openInventory(GUI2(p));
            } else {
                p.sendMessage(
                        Painter.paint("&c????lemeye 2. bir ekipman koymak demircilikte 10. seviye ustal??k gerektirir!"));
            }

        }

        if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().

                hasDisplayName()
                && clicked.getItemMeta().

                getDisplayName().


                equalsIgnoreCase(Painter.paint("&c1. Bo?? ??retim Alan??"))) {


            p.openInventory(GUI2(p));


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
                            MiniMessage.miniMessage().deserialize("<gold>[</gold><yellow>Meslek Se??ildi!</yellow><gold>]</gold>"),
                            MiniMessage.miniMessage().deserialize("<gray>" + meslek + "</gray>")));
            job.remove(p.getUniqueId());
        } else {
            job.put(p.getUniqueId(), "job");
        }
    }

}