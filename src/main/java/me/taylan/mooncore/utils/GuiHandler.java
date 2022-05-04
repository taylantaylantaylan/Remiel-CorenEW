package me.taylan.mooncore.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import com.destroystokyo.paper.MaterialTags;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.animations.CookAnim;
import me.taylan.mooncore.enchanting.Enchants;
import me.taylan.mooncore.listeners.JoinListener;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.title.Title;
import net.md_5.bungee.api.ChatColor;

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

	public Inventory inv12;
	public String inventory_name12;
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
		inventory_name8 = Painter.paint(ChatColor.DARK_GRAY + "Demirci Masası -> Yeniden İşleme");
		inventory_name9 = Painter.paint(ChatColor.DARK_GRAY + "Demirci Masası");
		inventory_name10 = Painter.paint(ChatColor.DARK_GRAY + "Örs");
		inventory_name11 = Painter.paint(ChatColor.DARK_GRAY + "Ocak -> Üretimler");
		inventory_name12 = Painter.paint(ChatColor.DARK_GRAY + "Profili");
		inventory_name13 = Painter.paint(ChatColor.DARK_GRAY + "Bilgi Kitabı");
		inventory_name14 = Painter.paint(ChatColor.DARK_GRAY + "Bilgi Kitabı -> Niteliklerin");

		inv = Bukkit.createInventory(null, inv_rows);
		inv2 = Bukkit.createInventory(null, inv_rows2);
		inv3 = Bukkit.createInventory(null, inv_rows3);
		inv4 = Bukkit.createInventory(null, inv_rows4);
		inv5 = Bukkit.createInventory(null, inv_rows5);
		inv6 = Bukkit.createInventory(null, inv_rows6);
		inv7 = Bukkit.createInventory(null, inv_rows7);
		inv8 = Bukkit.createInventory(null, inv_rows8);
		inv9 = Bukkit.createInventory(null, inv_rows9);
		inv10 = Bukkit.createInventory(null, inv_rows10);
		inv11 = Bukkit.createInventory(null, inv_rows11);
		inv12 = Bukkit.createInventory(null, inv_rows12);
		inv13 = Bukkit.createInventory(null, inv_rows4);
		inv14 = Bukkit.createInventory(null, inv_rows14);

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
		itemHandler.createItem(inv, "iron_ingot", 1, 20, ChatColor.WHITE + "Demir Ekipmanlar",
				ChatColor.GRAY + "Yapabileceğin ekipmanlara bakmak",
				ChatColor.GRAY + "için " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
		itemHandler.createItem(inv, "gold_ingot", 1, 21, ChatColor.YELLOW + "Altın Ekipmanlar",
				ChatColor.GRAY + "Yapabileceğin ekipmanlara bakmak",
				ChatColor.GRAY + "için " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
		itemHandler.createItem(inv, "chain", 1, 22, ChatColor.GRAY + "Zincir Ekipmanlar",
				ChatColor.GRAY + "Yapabileceğin ekipmanlara bakmak",
				ChatColor.GRAY + "için " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
		itemHandler.createItem(inv, "emerald", 1, 23, ChatColor.DARK_GREEN + "Zümrüt Ekipmanlar",
				ChatColor.GRAY + "Yapabileceğin ekipmanlara bakmak",
				ChatColor.GRAY + "için " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
		itemHandler.createItem(inv, "amethyst_shard", 1, 24, ChatColor.LIGHT_PURPLE + "Ametist Ekipmanlar",
				ChatColor.GRAY + "Yapabileceğin ekipmanlara bakmak",
				ChatColor.GRAY + "için " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
		itemHandler.createItem(inv, "diamond", 1, 25, ChatColor.AQUA + "Elmas Ekipmanlar",
				ChatColor.GRAY + "Yapabileceğin ekipmanlara bakmak",
				ChatColor.GRAY + "için " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
		itemHandler.createItem(inv, "netherite_ingot", 1, 26, ChatColor.DARK_GRAY + "Ağır Alaşımlı Ekipmanlar",
				ChatColor.GRAY + "Yapabileceğin ekipmanlara bakmak",
				ChatColor.GRAY + "için " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");

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

		Inventory toReturn = Bukkit.createInventory(null, inv_rows14, inventory_name14);
		itemHandler.createItem(inv14, "black_stained_glass_pane", 1, 1, " ");
		itemHandler.createItem(inv14, "black_stained_glass_pane", 1, 2, " ");
		itemHandler.createItem(inv14, "black_stained_glass_pane", 1, 3, " ");
		itemHandler.createItem(inv14, "black_stained_glass_pane", 1, 4, " ");
		itemHandler.createItem(inv14, "black_stained_glass_pane", 1, 5, " ");
		itemHandler.createItem(inv14, "black_stained_glass_pane", 1, 6, " ");
		itemHandler.createItem(inv14, "black_stained_glass_pane", 1, 7, " ");
		itemHandler.createItem(inv14, "black_stained_glass_pane", 1, 8, " ");
		itemHandler.createItem(inv14, "black_stained_glass_pane", 1, 9, " ");
		itemHandler.createItem(inv14, "black_stained_glass_pane", 1, 10, " ");
		itemHandler.createItem(inv14, "black_stained_glass_pane", 1, 18, " ");
		itemHandler.createItem(inv14, "black_stained_glass_pane", 1, 19, " ");
		itemHandler.createItem(inv14, "black_stained_glass_pane", 1, 27, " ");
		itemHandler.createItem(inv14, "black_stained_glass_pane", 1, 28, " ");
		itemHandler.createItem(inv14, "black_stained_glass_pane", 1, 29, " ");
		itemHandler.createItem(inv14, "black_stained_glass_pane", 1, 30, " ");
		itemHandler.createItem(inv14, "black_stained_glass_pane", 1, 31, " ");
		itemHandler.createItem(inv14, "black_stained_glass_pane", 1, 32, " ");
		itemHandler.createItem(inv14, "black_stained_glass_pane", 1, 33, " ");
		itemHandler.createItem(inv14, "black_stained_glass_pane", 1, 34, " ");
		itemHandler.createItem(inv14, "black_stained_glass_pane", 1, 35, " ");
		itemHandler.createItem(inv14, "black_stained_glass_pane", 1, 36, " ");
		itemHandler.createItem(inv14, "red_dye", 1, 20, Painter.paint("&6&lDinçlik"),
				Painter.paint("&7Puan başına &6Canını &e+1 &7ve"), Painter.paint("&6Can Yenilenmeni &e+%1 &7arttırır."),
				"", Painter.paint("&8Dinçlik can değerinizi ve can yenilenmenizi belirler."),
				Painter.paint("&8Can değeriniz sizi ayakta tutan şeydir. Can yenilenmesi"),
				Painter.paint("&8ise alınan hasardan sonra ne kadar hızlı iyileştiğinizdir."), "",
				Painter.paint("&7Taban Dinçlik: &f20 &7/ &f5"),
				Painter.paint("&7Toplam Dinçlik: &f") + stats.getCan(p.getUniqueId()) + " &7/ &f"
						+ stats.getCanYenileme(p.getUniqueId()),
				"", Painter.paint("&7Nitelik Puanı eklemek için &e&lSağ Tıkla."));
		itemHandler.createItem(inv14, "iron_chestplate", 1, 21, Painter.paint("&a&lDayanıklılık"),
				Painter.paint("&7Puan başına &aZırh Değerini &e+1"),
				Painter.paint("&7ve &aDoygunluğunu &e+%1 &7arttırır."), "",
				Painter.paint("&8Dayanıklık aldığınız hasarı ve iş yapma kapasitenizi belirler."),
				Painter.paint("&8Zırh değeriniz ne kadar yüksekse alınan hasar o kadar etkili olur,"),
				Painter.paint("&8doygunluğunuz ne kadar yüksekse iş yaparken yorulmazsınız."), "",
				Painter.paint("&7Taban Dayanıklılık: &f0 &7/ &f0"),
				Painter.paint("&7Toplam Dayanıklılık: &f") + stats.getZirh(p.getUniqueId()) + " &7/ &f"
						+ stats.getDoygunluk(p.getUniqueId()),
				"", Painter.paint("&7Nitelik Puanı eklemek için &e&lSağ Tıkla."));
		itemHandler.createItem(inv14, "blaze_powder", 1, 22, Painter.paint("&c&lGüç"),
				Painter.paint("&7Puan başına &cGücünü &e+4 &7arttırır."), "",
				Painter.paint("&8Güç hasar kaynaklarınızdan biridir. Ne kadar "),
				Painter.paint("&8güçlüyseniz darbeleriniz de bir o kadar etkili olur."), "",
				Painter.paint("&7Taban Güç: &f5"), Painter.paint("&7Toplam Güç: &f") + stats.getGuc(p.getUniqueId()),
				"", Painter.paint("&7Nitelik Puanı eklemek için &e&lSağ Tıkla."));
		itemHandler.createItem(inv14, "glowstone_dust", 1, 24, Painter.paint("&e&lDenge"),
				Painter.paint("&7Puan başına &eDengeni &e+2 &7arttırır."), "",
				Painter.paint("&8Denge daha seri bir şekilde saldırabilmenizi sağlar."),
				Painter.paint("&8Dengeli bir duruş vuruşlarınızın da dengeli olmasını sağlar."), "",
				Painter.paint("&7Taban Denge: &f0"),
				Painter.paint("&7Toplam Denge: &f") + stats.getSaldiriHizi(p.getUniqueId()), "",
				Painter.paint("&7Nitelik Puanı eklemek için &e&lSağ Tıkla."));
		itemHandler.createItem(inv14, "feather", 1, 25, Painter.paint("&f&lÇeviklik"),
				Painter.paint("&7Puan başına &fÇevikliğini &e+1 &7arttırır."), "",
				Painter.paint("&8Çeviklik ne kadar seri hareket ettiğinizdir. Çevikliğiniz "),
				Painter.paint("&8ne kadar yüksekse o kadar hızlı hareket edersiniz."), "",
				Painter.paint("&7Taban Çeviklik: &f0"),
				Painter.paint("&7Toplam Çeviklik: &f") + stats.getHiz(p.getUniqueId()), "",
				Painter.paint("&7Nitelik Puanı eklemek için &e&lSağ Tıkla."));
		itemHandler.createItem(inv14, "nether_star", 1, 26, Painter.paint("&3&lHüner"),
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
			itemHandler.createItem(inv14, "barrier", 1, 14, Painter.paint("&4Niteliklerini Sıfırla!"),
					Painter.paint("&7Niteliklerini sıfırlamak harcadığın puanları sana geri"),
					Painter.paint("&7kazandırır. Fakat nitelik puanlarının birazı yok olur."), "",
					Painter.paint("&fKazanılacak Nitelik Puanları: &a" + harcanannp), "",
					Painter.paint("&7Niteliklerini sıfırlamak için &e&lSağ Tıkla."));
		} else {
			itemHandler.createItem(inv14, "barrier", 1, 14, Painter.paint("&4Niteliklerini Sıfırla!"),
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
					Painter.paint("&7Meslek: &6" + stats.getMeslek(p.getUniqueId())),
					Painter.paint("&7Seviye: &b" + stats.getLevel(profil.getUniqueId())),
					Painter.paint("&7Şuanki Ağırlığı: &f") + stats.getAgirlik(profil.getUniqueId()), "",
					Painter.paint(" &6❤ Dinçlik: &f") + stats.getCan(profil.getUniqueId()) + " &7/&f "
							+ stats.getCanYenileme(profil.getUniqueId()),
					Painter.paint(" &8&oDinçlik = Can/Can Yenilenmesi."),
					Painter.paint(" &a🛡 Dayanıklılık: &f") + stats.getZirh(profil.getUniqueId()) + " &7/&f "
							+ stats.getDoygunluk(profil.getUniqueId()),
					Painter.paint(" &8&oDayanıklılık = Zırh/Doygunluk."),
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
					Painter.paint("&7Şuanki Ağırlığı: &f") + stats.getAgirlik(p.getUniqueId()), "",
					Painter.paint(" &6❤ Dinçlik: &f") + stats.getCan(p.getUniqueId()) + " &7/&f "
							+ stats.getCanYenileme(p.getUniqueId()),
					Painter.paint(" &8&oDinçlik = Can/Can Yenilenmesi."),
					Painter.paint(" &a🛡 Dayanıklılık: &f") + stats.getZirh(p.getUniqueId()) + " &7/&f "
							+ stats.getDoygunluk(p.getUniqueId()),
					Painter.paint(" &8&oDayanıklılık = Zırh/Doygunluk."),
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
		itemHandler.createItem(inv3, "white_stained_glass_pane", 1, 9, " ");
		itemHandler.createItem(inv3, "black_stained_glass_pane", 1, 10, " ");
		itemHandler.createItem(inv3, "black_stained_glass_pane", 1, 11, " ");
		itemHandler.createItem(inv3, "black_stained_glass_pane", 1, 12, " ");
		itemHandler.createItem(inv3, "black_stained_glass_pane", 1, 13, " ");
		itemHandler.createItem(inv3, "black_stained_glass_pane", 1, 14, " ");
		itemHandler.createItem(inv3, "black_stained_glass_pane", 1, 15, " ");
		itemHandler.createItem(inv3, "black_stained_glass_pane", 1, 16, " ");
		itemHandler.createItem(inv3, "black_stained_glass_pane", 1, 17, " ");
		itemHandler.createItem(inv3, "black_stained_glass_pane", 1, 18, " ");
		itemHandler.createItem(inv3, "rotten_flesh", 1, 29, ChatColor.GOLD + "T1 Yemekler",
				ChatColor.GRAY + "Yapabileceğin yemeklere bakmak",
				ChatColor.GRAY + "için " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
		itemHandler.createItem(inv3, "apple", 1, 31, ChatColor.GRAY + "T2 Yemekler",
				ChatColor.GRAY + "Yapabileceğin yemeklere bakmak",
				ChatColor.GRAY + "için " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
		itemHandler.createItem(inv3, "rabbit_stew", 1, 33, ChatColor.WHITE + "T3 Yemekler",
				ChatColor.GRAY + "Yapabileceğin yemeklere bakmak",
				ChatColor.GRAY + "için " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
		itemHandler.createItem(inv3, "cake", 1, 35, ChatColor.YELLOW + "T4 Yemekler",
				ChatColor.GRAY + "Yapabileceğin yemeklere bakmak",
				ChatColor.GRAY + "için " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");

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
		itemHandler.createItem(inv4, "bread", 1, 19, ChatColor.YELLOW + "Ekmek", ChatColor.GREEN + "Ustalık 1", "",
				ChatColor.GRAY + " Gerekli Malzemeler:", ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Buğday", "",
				ChatColor.GRAY + "Pişirmeye başlamak için ", ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
		itemHandler.createItem(inv4, "cooked_beef", 1, 20, ChatColor.YELLOW + "Biftek", ChatColor.GREEN + "Ustalık 2",
				"", ChatColor.GRAY + " Gerekli Malzemeler:",
				ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 Çiğ İnek Eti", "",
				ChatColor.GRAY + "Pişirmeye başlamak için ", ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
		itemHandler.createItem(inv4, "cooked_porkchop", 1, 21, ChatColor.YELLOW + "Domuz Pastırması",
				ChatColor.GREEN + "Ustalık 2", "", ChatColor.GRAY + " Gerekli Malzemeler:",
				ChatColor.GRAY + " -" + ChatColor.WHITE + " 2 Çiğ Domuz Eti", "",
				ChatColor.GRAY + "Pişirmeye başlamak için ", ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");

		toReturn.setContents(inv4.getContents());
		return toReturn;
	}

	public Inventory bilgikitabı(Player p) {
		Inventory toReturn = Bukkit.createInventory(null, inv_rows4, inventory_name13);

		itemHandler.createItem(inv13, "white_stained_glass_pane", 1, 1, " ");
		itemHandler.createItem(inv13, "white_stained_glass_pane", 1, 2, " ");
		itemHandler.createItem(inv13, "white_stained_glass_pane", 1, 3, " ");
		itemHandler.createItem(inv13, "white_stained_glass_pane", 1, 4, " ");
		itemHandler.createItem(inv13, "knowledge_book", 1, 5, ChatColor.AQUA + "Bilgi Kitabı",
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
		itemHandler.createItem(inv13, "item_frame", 1, 33, ChatColor.GOLD + "Aksesuarlarını Yönet",
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
		int timer = stats.getCookProduction(p.getUniqueId());
		if (timer <= 0) {
			itemHandler.createItem(inv11, "red_stained_glass_pane", 1, 14, Painter.paint("&c1. Boş Üretim Alanı"),
					Painter.paint("&7Ekipman Üretmek için &e&lSağ Tıkla."));
		}
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
		itemHandler.createItem(inv5, "wooden_axe", 1, 20, ChatColor.YELLOW + "Bakır Balta",
				ChatColor.GREEN + "Ustalık 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
				ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Çubuk",
				ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Bakır Külçesi",
				ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "İşlemeye başlamak için ",
				ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
		itemHandler.createItem(inv5, "crossbow", 1, 21, ChatColor.YELLOW + "Arbalet", ChatColor.GREEN + "Ustalık 1", "",
				ChatColor.GRAY + " Gerekli Malzemeler:", ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Çubuk",
				ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Bakır Külçesi",
				ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "İşlemeye başlamak için ",
				ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
		itemHandler.createItem(inv5, "bow", 1, 22, ChatColor.YELLOW + "Yay", ChatColor.GREEN + "Ustalık 1", "",
				ChatColor.GRAY + " Gerekli Malzemeler:", ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Çubuk",
				ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Bakır Külçesi",
				ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "İşlemeye başlamak için ",
				ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
		itemHandler.createItem(inv5, "leather_chestplate", 1, 23, ChatColor.YELLOW + "Bakır Göğüslük",
				ChatColor.GREEN + "Ustalık 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
				ChatColor.GRAY + " -" + ChatColor.WHITE + " 8 Bakır Külçesi",
				ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "İşlemeye başlamak için ",
				ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
		itemHandler.createItem(inv5, "leather_leggings", 1, 24, ChatColor.YELLOW + "Bakır Pantolon",
				ChatColor.GREEN + "Ustalık 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
				ChatColor.GRAY + " -" + ChatColor.WHITE + " 8 Bakır Külçesi",
				ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "İşlemeye başlamak için ",
				ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
		itemHandler.createItem(inv5, "leather_helmet", 1, 25, ChatColor.YELLOW + "Bakır Miğfer",
				ChatColor.GREEN + "Ustalık 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
				ChatColor.GRAY + " -" + ChatColor.WHITE + " 5 Bakır Külçesi",
				ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "İşlemeye başlamak için ",
				ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
		itemHandler.createItem(inv5, "leather_boots", 1, 26, ChatColor.YELLOW + "Bakır Botlar",
				ChatColor.GREEN + "Ustalık 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
				ChatColor.GRAY + " -" + ChatColor.WHITE + " 4 Bakır Külçesi",
				ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "İşlemeye başlamak için ",
				ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
		itemHandler.createItem(inv5, "wooden_shovel", 1, 27, ChatColor.YELLOW + "Bakır Kürek",
				ChatColor.GREEN + "Ustalık 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
				ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Çubuk",
				ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Bakır Külçesi",
				ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "İşlemeye başlamak için ",
				ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
		itemHandler.createItem(inv5, "wooden_pickaxe", 1, 28, ChatColor.YELLOW + "Bakır Kazma",
				ChatColor.GREEN + "Ustalık 1", "", ChatColor.GRAY + " Gerekli Malzemeler:",
				ChatColor.GRAY + " -" + ChatColor.WHITE + " 1 Çubuk",
				ChatColor.GRAY + " -" + ChatColor.WHITE + " 3 Bakır Külçesi",
				ChatColor.GRAY + " -" + ChatColor.WHITE + " 10 Seviye", "", ChatColor.GRAY + "İşlemeye başlamak için ",
				ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");

		toReturn.setContents(inv5.getContents());
		return toReturn;
	}

	public Inventory reforge(Player p) {
		int smithLevel = stats.getSmithLevel(p.getUniqueId());
		Inventory toReturn = Bukkit.createInventory(null, inv_rows8, inventory_name8);

		itemHandler.createItem(inv8, "white_stained_glass_pane", 1, 1, " ");
		itemHandler.createItem(inv8, "white_stained_glass_pane", 1, 2, " ");
		itemHandler.createItem(inv8, "white_stained_glass_pane", 1, 3, " ");
		itemHandler.createItem(inv8, "white_stained_glass_pane", 1, 4, " ");
		itemHandler.createItem(inv8, "stonecutter", 1, 5, ChatColor.WHITE + "Hurdaya Çevir",
				ChatColor.GRAY + "Burada elindeki ekipmanı hurdaya çevirebilirsin.",
				ChatColor.GRAY + "Ekipmanın ana malzemelerinin bir kısmı sana geri gelir.", "");
		itemHandler.createItem(inv8, "white_stained_glass_pane", 1, 6, " ");
		itemHandler.createItem(inv8, "white_stained_glass_pane", 1, 7, " ");
		itemHandler.createItem(inv8, "white_stained_glass_pane", 1, 8, " ");
		itemHandler.createItem(inv8, "white_stained_glass_pane", 1, 9, " ");
		itemHandler.createItem(inv8, "black_stained_glass_pane", 1, 10, " ");
		itemHandler.createItem(inv8, "black_stained_glass_pane", 1, 11, " ");
		itemHandler.createItem(inv8, "black_stained_glass_pane", 1, 12, " ");
		itemHandler.createItem(inv8, "black_stained_glass_pane", 1, 13, " ");
		itemHandler.createItem(inv8, "black_stained_glass_pane", 1, 14, " ");
		itemHandler.createItem(inv8, "black_stained_glass_pane", 1, 15, " ");
		itemHandler.createItem(inv8, "black_stained_glass_pane", 1, 16, " ");
		itemHandler.createItem(inv8, "black_stained_glass_pane", 1, 17, " ");
		itemHandler.createItem(inv8, "black_stained_glass_pane", 1, 18, " ");
		itemHandler.createItem(inv8, "gray_stained_glass_pane", 1, 19, " ");
		itemHandler.createItem(inv8, "gray_stained_glass_pane", 1, 20, " ");
		itemHandler.createItem(inv8, "gray_stained_glass_pane", 1, 21, " ");
		itemHandler.createItem(inv8, "gray_stained_glass_pane", 1, 22, " ");
		itemHandler.createItem(inv8, "gray_stained_glass_pane", 1, 24, " ");
		itemHandler.createItem(inv8, "gray_stained_glass_pane", 1, 25, " ");
		itemHandler.createItem(inv8, "gray_stained_glass_pane", 1, 26, " ");
		itemHandler.createItem(inv8, "gray_stained_glass_pane", 1, 27, " ");
		itemHandler.createItem(inv8, "gray_stained_glass_pane", 1, 28, " ");
		itemHandler.createItem(inv8, "gray_stained_glass_pane", 1, 29, " ");
		itemHandler.createItem(inv8, "gray_stained_glass_pane", 1, 30, " ");
		itemHandler.createItem(inv8, "gray_stained_glass_pane", 1, 31, " ");
		itemHandler.createItem(inv8, "red_stained_glass_pane", 1, 32, " ");
		itemHandler.createItem(inv8, "gray_stained_glass_pane", 1, 33, " ");
		itemHandler.createItem(inv8, "gray_stained_glass_pane", 1, 34, " ");
		itemHandler.createItem(inv8, "gray_stained_glass_pane", 1, 35, " ");
		itemHandler.createItem(inv8, "gray_stained_glass_pane", 1, 36, " ");
		itemHandler.createItem(inv8, "gray_stained_glass_pane", 1, 37, " ");
		itemHandler.createItem(inv8, "gray_stained_glass_pane", 1, 38, " ");
		itemHandler.createItem(inv8, "gray_stained_glass_pane", 1, 39, " ");
		itemHandler.createItem(inv8, "gray_stained_glass_pane", 1, 40, " ");
		itemHandler.createItem(inv8, "gray_stained_glass_pane", 1, 41, " ");
		itemHandler.createItem(inv8, "gray_stained_glass_pane", 1, 42, " ");
		itemHandler.createItem(inv8, "gray_stained_glass_pane", 1, 43, " ");
		itemHandler.createItem(inv8, "gray_stained_glass_pane", 1, 44, " ");

		itemHandler.createItem(inv8, "gray_stained_glass_pane", 1, 45, " ");
		itemHandler.createItem(inv8, "gray_stained_glass_pane", 1, 46, " ");
		itemHandler.createItem(inv8, "gray_stained_glass_pane", 1, 47, " ");
		itemHandler.createItem(inv8, "gray_stained_glass_pane", 1, 48, " ");
		itemHandler.createItem(inv8, "gray_stained_glass_pane", 1, 49, " ");
		itemHandler.createItem(inv8, "gray_stained_glass_pane", 1, 50, " ");
		itemHandler.createItem(inv8, "gray_stained_glass_pane", 1, 51, " ");
		itemHandler.createItem(inv8, "gray_stained_glass_pane", 1, 52, " ");
		itemHandler.createItem(inv8, "gray_stained_glass_pane", 1, 53, " ");
		itemHandler.createItem(inv8, "gray_stained_glass_pane", 1, 54, " ");

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

	@SuppressWarnings("deprecation")
	public void clicked(Player p, int slot, ItemStack clicked, Inventory inv) {
		if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
				&& clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "T1 Yemekler")) {
			p.openInventory(t1Yemek(p));
		}
		if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
				&& clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.WHITE + "Ekipman İşle")) {
			p.openInventory(GUI2(p));
		}
		if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
				&& clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.WHITE + "Hurdaya Çevir")) {
			p.openInventory(reforge(p));
		}
		if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
				&& clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Painter.paint("&6Depo"))) {
			Inventory baba = JoinListener.getMenu().get(p.getUniqueId());
			p.openInventory(baba);
		}
		if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
				&& clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Bakır Ekipmanlar")) {
			p.openInventory(t1Ekipman(p));
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

		}
		if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
				&& clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Painter.paint("&6&lDinçlik"))) {
			if (stats.getNP(p.getUniqueId()) > 0) {
				stats.setNP(p.getUniqueId(), -1);
				stats.setharcananNP(p.getUniqueId(), 1);
				stats.setCan(p, p.getUniqueId(), 1);
				stats.setCanYenileme(p, p.getUniqueId(), 1);
				itemHandler.createItem(inv, "red_dye", 1, 20, Painter.paint("&6&lDinçlik"),
						Painter.paint("&7Puan başına &6Canını &e+1 &7ve"),
						Painter.paint("&6Can Yenilenmeni &e+%1 &7arttırır."), "",
						Painter.paint("&8Dinçlik can değerinizi ve can yenilenmenizi belirler."),
						Painter.paint("&8Can değeriniz sizi ayakta tutan şeydir. Can yenilenmesi"),
						Painter.paint("&8ise alınan hasardan sonra ne kadar hızlı iyileştiğinizdir."), "",
						Painter.paint("&7Taban Dinçlik: &f20 &7/ &f5"),
						Painter.paint("&7Toplam Dinçlik: &f") + stats.getCan(p.getUniqueId()) + " &7/ &f"
								+ stats.getCanYenileme(p.getUniqueId()),
						"", Painter.paint("&7Nitelik Puanı eklemek için &e&lSağ Tıkla."));

			} else {
				itemHandler.createItem(inv, "red_dye", 1, 20, Painter.paint("&6&lDinçlik"),
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
				&& clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Painter.paint("&a&lDayanıklılık"))) {
			if (stats.getNP(p.getUniqueId()) > 0) {
				stats.setNP(p.getUniqueId(), -1);
				stats.setharcananNP(p.getUniqueId(), 1);
				stats.setZirh(p, p.getUniqueId(), 1);
				stats.setDoygunluk(p, p.getUniqueId(), 1);
				itemHandler.createItem(inv, "iron_chestplate", 1, 21, Painter.paint("&a&lDayanıklılık"),
						Painter.paint("&7Puan başına &aZırh Değerini &e+1"),
						Painter.paint("&7ve &aDoygunluğunu &e+%1 &7arttırır."), "",
						Painter.paint("&8Dayanıklık aldığınız hasarı ve iş yapma kapasitenizi belirler."),
						Painter.paint("&8Zırh değeriniz ne kadar yüksekse alınan hasar o kadar etkili olur,"),
						Painter.paint("&8doygunluğunuz ne kadar yüksekse iş yaparken yorulmazsınız."), "",
						Painter.paint("&7Taban Dayanıklılık: &f0 &7/ &f0"),
						Painter.paint("&7Toplam Dayanıklılık: &f") + stats.getZirh(p.getUniqueId()) + " &7/ &f"
								+ stats.getDoygunluk(p.getUniqueId()),
						"", Painter.paint("&7Nitelik Puanı eklemek için &e&lSağ Tıkla."));
			} else {
				itemHandler.createItem(inv, "iron_chestplate", 1, 21, Painter.paint("&a&lDayanıklılık"),
						Painter.paint("&7Puan başına &aZırh Değerini &e+1"),
						Painter.paint("&7ve &aDoygunluğunu &e+%1 &7arttırır."), "",
						Painter.paint("&8Dayanıklık aldığınız hasarı ve iş yapma kapasitenizi belirler."),
						Painter.paint("&8Zırh değeriniz ne kadar yüksekse alınan hasar o kadar etkili olur,"),
						Painter.paint("&8doygunluğunuz ne kadar yüksekse iş yaparken yorulmazsınız."), "",
						Painter.paint("&7Taban Dayanıklılık: &f0 &7/ &f0"),
						Painter.paint("&7Toplam Dayanıklılık: &f") + stats.getZirh(p.getUniqueId()) + " &7/ &f"
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
				itemHandler.createItem(inv, "blaze_powder", 1, 22, Painter.paint("&c&lGüç"),
						Painter.paint("&7Puan başına &cGücünü &e+4 &7arttırır."), "",
						Painter.paint("&8Güç hasar kaynaklarınızdan biridir. Ne kadar "),
						Painter.paint("&8güçlüyseniz darbeleriniz de bir o kadar etkili olur."), "",
						Painter.paint("&7Taban Güç: &f5"),
						Painter.paint("&7Toplam Güç: &f") + stats.getGuc(p.getUniqueId()), "",
						Painter.paint("&7Nitelik Puanı eklemek için &e&lSağ Tıkla."));
			} else {
				itemHandler.createItem(inv, "blaze_powder", 1, 22, Painter.paint("&c&lGüç"),
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
				itemHandler.createItem(inv, "glowstone_dust", 1, 24, Painter.paint("&e&lDenge"),
						Painter.paint("&7Puan başına &eDengeni &e+2 &7arttırır."), "",
						Painter.paint("&8Denge daha seri bir şekilde saldırabilmenizi sağlar."),
						Painter.paint("&8Dengeli bir duruş vuruşlarınızın da dengeli olmasını sağlar."), "",
						Painter.paint("&7Taban Denge: &f0"),
						Painter.paint("&7Toplam Denge: &f") + stats.getSaldiriHizi(p.getUniqueId()), "",
						Painter.paint("&7Nitelik Puanı eklemek için &e&lSağ Tıkla."));
			} else {
				itemHandler.createItem(inv, "glowstone_dust", 1, 24, Painter.paint("&e&lDenge"),
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
				itemHandler.createItem(inv, "feather", 1, 25, Painter.paint("&f&lÇeviklik"),
						Painter.paint("&7Puan başına &fÇevikliğini &e+1 &7arttırır."), "",
						Painter.paint("&8Çeviklik ne kadar seri hareket ettiğinizdir. Çevikliğiniz "),
						Painter.paint("&8ne kadar yüksekse o kadar hızlı hareket edersiniz."), "",
						Painter.paint("&7Taban Çeviklik: &f0"),
						Painter.paint("&7Toplam Çeviklik: &f") + stats.getHiz(p.getUniqueId()), "",
						Painter.paint("&7Nitelik Puanı eklemek için &e&lSağ Tıkla."));
			} else {
				itemHandler.createItem(inv, "feather", 1, 25, Painter.paint("&f&lÇeviklik"),
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
				itemHandler.createItem(inv, "nether_star", 1, 26, Painter.paint("&3&lHüner"),
						Painter.paint("&7Puan başına &3Kritik Hasarını &e+1"),
						Painter.paint("&7ve &3Kritik Şansını &e+%1 &7arttırır."), "",
						Painter.paint("&8Hüner savaşta kullandığınız silahı daha iyi kullanmanızı sağlar."),
						Painter.paint("&8Silahını iyi kullanan bir kişi rakibin zayıf noktalarını da görebilir."), "",
						Painter.paint("&7Taban Hüner: &f12 &7/ &f0"),
						Painter.paint("&7Toplam Hüner: &f") + stats.getKritikHasari(p.getUniqueId()) + " &7/ &f"
								+ stats.getKritikSansi(p.getUniqueId()),
						"", Painter.paint("&7Nitelik Puanı eklemek için &e&lSağ Tıkla."));
			} else {
				itemHandler.createItem(inv, "nether_star", 1, 26, Painter.paint("&3&lHüner"),
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

						Title.title(MiniMessage.get().parse("<red>Nitelikler</red>"),
								MiniMessage.get().parse("<gray>Sıfırlandı!</gray>")));
				stats.setNP(p.getUniqueId(), stats.getharcananNP(p.getUniqueId()) - 3);
				stats.setharcananNP(p.getUniqueId(), -stats.getharcananNP(p.getUniqueId()));
				stats.setKritikHasari(p.getUniqueId(), -stats.getKritikHasari(p.getUniqueId()) + 12);
				stats.setKritikSansi(p.getUniqueId(), -stats.getKritikSansi(p.getUniqueId()));
				stats.setCan(p, p.getUniqueId(), -stats.getCan(p.getUniqueId()) + 20);
				stats.setCanYenileme(p, p.getUniqueId(), -stats.getCanYenileme(p.getUniqueId()) + 5);
				stats.setDoygunluk(p, p.getUniqueId(), -stats.getDoygunluk(p.getUniqueId()));
				stats.setGuc(p.getUniqueId(), -stats.getGuc(p.getUniqueId()) + 5);
				stats.setZirh(p, p.getUniqueId(), -stats.getZirh(p.getUniqueId()));
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
				&& clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Aksesuarlarını Yönet")) {
			String name2 = p.getUniqueId().toString();
			FileConfiguration fc = stats.getStatfile().get(p.getUniqueId());
			ArrayList<ItemStack> akselist = (ArrayList<ItemStack>) stats.getStatfile().get(p.getUniqueId())
					.get("Aksesuar." + "Hepsi");
			ItemStack[] list = ((List<ItemStack>) stats.getStatfile().get(p.getUniqueId()).get("Aksesuar." + "Hepsi"))
					.toArray(new ItemStack[0]);

			if (p.getInventory().firstEmpty() == -1) {
				p.closeInventory();
				p.sendMessage(Painter.paint("&cEnvanterinde yer yok!"));
			} else {
				p.getInventory().addItem(list);

				akselist.set(0, new ItemStack(Material.AIR));
				akselist.set(1, new ItemStack(Material.AIR));
				akselist.set(2, new ItemStack(Material.AIR));
				akselist.set(3, new ItemStack(Material.AIR));
				stats.setHepsi(p.getUniqueId(), akselist);
				stats.setYuzuk(p.getUniqueId(), "Yok..");
				stats.setKolye(p.getUniqueId(), "Yok..");
				stats.setEldiven(p.getUniqueId(), "Yok..");
				stats.setTilsim(p.getUniqueId(), "Yok..");
				itemHandler.createItem(inv, "item_frame", 1, 33, ChatColor.GOLD + "Aksesuarlarını Yönet",
						ChatColor.WHITE + "Buradan aksesuarlarını ve ekipmanlarını",
						ChatColor.WHITE + "yönetebilirsin.", "", Painter.paint("&7Aksesuarlar kullanıcısına belirli"),
						Painter.paint("&7özellikler bahşeden ekipmanlardır."), "",
						Painter.paint("&fKullanılan Aksesuarlar:"), Painter.paint(" &dTılsım/Ok Kılıfı: &8Yok.."),
						Painter.paint(" &9Eldiven: &8Yok.."), Painter.paint(" &eKolye: &8Yok.."),
						Painter.paint(" &6Yüzük: &8Yok.."), "", ChatColor.GRAY + "Aksesuarlarını çıkarmak için "
								+ ChatColor.YELLOW + "" + ChatColor.BOLD + "Sağ Tıkla.");
				stats.getStatfile().put(p.getUniqueId(), fc);
				for (ItemStack item : list) {
					if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
						ItemMeta meta = item.getItemMeta();
						PersistentDataContainer container = meta.getPersistentDataContainer();
						NamespacedKey can = new NamespacedKey(plugin, "can");
						NamespacedKey doygunluk = new NamespacedKey(plugin, "doygunluk");
						NamespacedKey canyenilenmesi = new NamespacedKey(plugin, "canyenilenmesi");
						NamespacedKey saldirihizi = new NamespacedKey(plugin, "saldirihizi");
						NamespacedKey guc = new NamespacedKey(plugin, "guc");
						NamespacedKey zirh = new NamespacedKey(plugin, "zirh");
						NamespacedKey kritiksansi = new NamespacedKey(plugin, "kritiksansi");
						NamespacedKey kritikhasari = new NamespacedKey(plugin, "kritikhasari");
						NamespacedKey hiz = new NamespacedKey(plugin, "hiz");
						for (NamespacedKey key : container.getKeys()) {
							if (key.equals(can)) {
								stats.setCan(p, p.getUniqueId(), -container.get(key, PersistentDataType.INTEGER));

							} else if (key.equals(canyenilenmesi)) {
								stats.setCanYenileme(p, p.getUniqueId(),
										-container.get(key, PersistentDataType.INTEGER));
							} else if (key.equals(guc)) {
								stats.setGuc(p.getUniqueId(), -container.get(key, PersistentDataType.INTEGER));
							} else if (key.equals(zirh)) {
								stats.setZirh(p, p.getUniqueId(), -container.get(key, PersistentDataType.INTEGER));
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
							}
						}
					}
				}
			}
		}

		if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
				&& clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Ekmek")) {
			cookAnim.cooking(p, new ItemStack(Material.WHEAT), new ItemStack(Material.BREAD), 2, 1, 10, 20);
		}
		if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
				&& clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Bakır Kılıç")) {
			itemHandler.createSword(p, new ItemStack(Material.COPPER_INGOT), 3, new ItemStack(Material.WOODEN_SWORD),
					"&6Bakır Kılıç", 5, 8, false, 0.6, "Orta", 50, 10, 20, 10);
		}
		if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
				&& clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Bakır Balta")) {
			itemHandler.createAxe(p, new ItemStack(Material.COPPER_INGOT), 3, new ItemStack(Material.WOODEN_AXE),
					"&6Bakır Balta", 5, 7, false, 0.3, "Orta", 50, 10, 20, 10);
		}
		if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
				&& clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Bakır Kürek")) {
			itemHandler.createAxe(p, new ItemStack(Material.COPPER_INGOT), 3, new ItemStack(Material.WOODEN_SHOVEL),
					"&6Bakır Kürek", 1, 7, false, 0.3, "Orta", 50, 10, 20, 10);
		}
		if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
				&& clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Bakır Kazma")) {
			itemHandler.createAxe(p, new ItemStack(Material.COPPER_INGOT), 3, new ItemStack(Material.WOODEN_PICKAXE),
					"&6Bakır Kazma", 1, 7, false, 0.3, "Orta", 50, 10, 20, 10);
		}
		if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
				&& clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Arbalet")) {
			itemHandler.createCrossbow(p, new ItemStack(Material.COPPER_INGOT), 3, new ItemStack(Material.CROSSBOW),
					"&6Arbalet", 3, 7, false, "Orta", 50, 10, 20, 10);
		}
		if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
				&& clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Yay")) {
			itemHandler.createCrossbow(p, new ItemStack(Material.COPPER_INGOT), 3, new ItemStack(Material.BOW), "&6Yay",
					3, 7, false, "Orta", 50, 10, 20, 10);
		}
		if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
				&& clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Bakır Göğüslük")) {
			itemHandler.createArmor(p, "&oGöğüslük", EquipmentSlot.CHEST, new ItemStack(Material.COPPER_INGOT), 8,
					new ItemStack(Material.LEATHER_CHESTPLATE), "&6Bakır Göğüslük", 4, 7, "Orta", 50, 10, 20, 10);
		}
		if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
				&& clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Bakır Pantolon")) {
			itemHandler.createArmor(p, "&oPantolon", EquipmentSlot.LEGS, new ItemStack(Material.COPPER_INGOT), 8,
					new ItemStack(Material.LEATHER_LEGGINGS), "&6Bakır Göğüslük", 4, 7, "Orta", 50, 10, 20, 10);
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
				&& clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Bakır Miğfer")) {
			itemHandler.createArmor(p, "&oGöğüslük", EquipmentSlot.HEAD, new ItemStack(Material.COPPER_INGOT), 8,
					new ItemStack(Material.LEATHER_HELMET), "&6Bakır Miğfer", 4, 7, "Orta", 50, 10, 20, 10);
		}
		if (clicked != null && clicked.hasItemMeta() && clicked.getItemMeta().hasDisplayName()
				&& clicked.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Bakır Botlar")) {
			itemHandler.createArmor(p, "&oPantolon", EquipmentSlot.FEET, new ItemStack(Material.COPPER_INGOT), 8,
					new ItemStack(Material.LEATHER_BOOTS), "&6Bakır Botlar", 4, 7, "Orta", 50, 10, 20, 10);
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

	public void jobekle(String meslek, Player p) {
		if (job.containsKey(p.getUniqueId())) {
			stats.setMeslek(p.getUniqueId(), meslek);
			p.closeInventory();
			p.showTitle(

					Title.title(MiniMessage.get().parse("<gold>[</gold><yellow>Meslek Seçildi!</yellow><gold>]</gold>"),
							MiniMessage.get().parse("<gray>" + meslek + "</gray>")));
			job.remove(p.getUniqueId());
		} else {
			job.put(p.getUniqueId(), "job");
		}
	}

}