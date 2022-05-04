package me.taylan.mooncore.enchanting;

import java.util.Random;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.taylan.mooncore.MoonCore;

public class Enchants extends EnchantConstructor {
	private MoonCore plugin;

	public Enchants(MoonCore plugin) {
		super(plugin);
		this.plugin = plugin;
	}

	public void addEnchantBow(ItemStack item, Player p, int lvl) {

		for (int ench = 0; ench < 1;) {
			Random rand = new Random();
			int chance = rand.nextInt(9);
			Random rand2 = new Random();
			int chance2 = rand2.nextInt(lvl - 2);
			if (chance2 == 0) {
				chance2 = 1;
			}
			switch (chance) {
			case 0:

				createEnchant(chance, item, p, chance2, ench, "quick", "&4Büyü ▏ &7Hızlı Çekiş: &f", "kalista",
						"infinity", "escape", "yay");
				ench++;
				break;

			case 1:

				createEnchant(chance, item, p, chance2, ench, "escape", "&4Büyü ▏ &7Kaçış: &f", "kalista", "quick",
						"yay");
				ench++;
				break;

			case 2:

				createEnchant(chance, item, p, chance2, ench, "kalista", "&4Büyü ▏ &7Ruh Prangası: &f", "quick",
						"escape", "yay");
				ench++;
				break;

			case 3:

				createEnchant(chance, item, p, chance2, ench, "isabet", "&4Büyü ▏ &7Tam İsabet: &f", "yay");
				ench++;
				break;

			case 4:

				createEnchantVanilla(chance, item, p, chance2, ench, "punch", "&4Büyü ▏ &7Yumruk: &f",
						Enchantment.ARROW_KNOCKBACK, "yay");
				ench++;
				break;

			case 5:

				createEnchantVanilla(chance, item, p, chance2, ench, "güç", "&4Büyü ▏ &7Güç: &f",
						Enchantment.ARROW_DAMAGE, "yay");
				ench++;
				break;

			case 6:

				createEnchantVanilla(chance, item, p, chance2, ench, "infinity", "&4Büyü ▏ &7Sonsuzluk: &f", "quick",
						Enchantment.ARROW_INFINITE, "yay");
				ench++;
				break;

			case 7:

				createEnchantVanilla(chance, item, p, chance2, ench, "flame", "&4Büyü ▏ &7Aleve Ver: &f",
						Enchantment.ARROW_FIRE, "yay");
				ench++;
				break;

			case 8:

				createEnchantVanilla(chance, item, p, chance2, ench, "unbreaking", "&4Büyü ▏ &7Kırılmazlık: &f",
						Enchantment.DURABILITY, "yay");
				ench++;
				break;
			}
		}

		p.getOpenInventory().setItem(29, new ItemStack(Material.RED_STAINED_GLASS_PANE));
		p.getOpenInventory().setItem(40, new ItemStack(Material.RED_STAINED_GLASS_PANE));
		p.getOpenInventory().setItem(33, new ItemStack(Material.RED_STAINED_GLASS_PANE));
	}

	public void addEnchantToSword(ItemStack item, Player p, int lvl) {

		for (int ench = 0; ench < 1;) {
			Random rand = new Random();
			int chance = rand.nextInt(16);
			Random rand2 = new Random();
			int chance2 = rand2.nextInt(lvl - 2);
			if (chance2 == 0) {
				chance2 = 1;
			}
			p.sendMessage("şans:" + chance);
			switch (chance) {
			case 0:

				createEnchant(chance, item, p, chance2, ench, "zehir", "&4Büyü ▏ &7Zehirli Kesik: &f", "lanet",
						"sword");
				ench++;
				break;

			case 1:

				createEnchant(chance, item, p, chance2, ench, "lanet", "&4Büyü ▏ &7Lanetli Vuruş: &f", "zehir",
						"sword");
				ench++;
				break;

			case 2:

				createEnchant(chance, item, p, chance2, ench, "desme", "&4Büyü ▏ &7Deşme: &f", "sword");
				ench++;
				break;

			case 3:

				createEnchant(chance, item, p, chance2, ench, "cancekme", "&4Büyü ▏ &7Sömürü: &f", "sword");
				ench++;
				break;

			case 4:

				createEnchant(chance, item, p, chance2, ench, "armorp", "&4Büyü ▏ &7Zırh Delme: &f", "sword");
				ench++;
				break;

			case 5:

				createEnchant(chance, item, p, chance2, ench, "twice", "&4Büyü ▏ &7Çifte Saldırı: &f", "sword");
				ench++;
				break;

			case 6:

				createEnchantVanilla(chance, item, p, chance2, ench, "sharpness", "&4Büyü ▏ &7Keskinlik: &f", "darbe",
						"orumcek", Enchantment.DAMAGE_ALL, "sword");
				ench++;
				break;

			case 7:

				createEnchantVanilla(chance, item, p, chance2, ench, "darbe", "&4Büyü ▏ &7Darbe: &f", "sharpness",
						"orumcek", Enchantment.DAMAGE_UNDEAD, "sword");
				ench++;
				break;

			case 8:

				createEnchantVanilla(chance, item, p, chance2, ench, "orumcek",
						"&4Büyü ▏ &7Eklembacaklıların Kıyameti: &f", "sharpness", "darbe",
						Enchantment.DAMAGE_ARTHROPODS, "sword");
				ench++;
				break;

			case 9:

				createEnchantVanilla(chance, item, p, chance2, ench, "knockback", "&4Büyü ▏ &7Savurma: &f",
						Enchantment.KNOCKBACK, "sword");
				ench++;
				break;

			case 10:

				createEnchantVanilla(chance, item, p, chance2, ench, "looting", "&4Büyü ▏ &7Ganimet: &f",
						Enchantment.LOOT_BONUS_MOBS, "sword");
				ench++;
				break;

			case 11:

				createEnchantVanilla(chance, item, p, chance2, ench, "alevden", "&4Büyü ▏ &7Alevden Çehre: &f",
						Enchantment.FIRE_ASPECT, "sword");
				ench++;
				break;

			case 12:

				createEnchantVanilla(chance, item, p, chance2, ench, "supurucu", "&4Büyü ▏ &7Süpürücü Kenar: &f",
						Enchantment.SWEEPING_EDGE, "sword");
				ench++;
				break;

			case 13:

				createEnchantVanilla(chance, item, p, chance2, ench, "unbreaking", "&4Büyü ▏ &7Kırılmazlık: &f",
						Enchantment.DURABILITY, "sword");
				ench++;
				break;

			case 14:

				createEnchant(chance, item, p, chance2, ench, "ofke", "&4Büyü ▏ &7Öfke: &f", "souleater", "sword");
				ench++;
				break;

			case 15:

				createEnchant(chance, item, p, chance2, ench, "souleater", "&4Büyü ▏ &7Ruh Yiyen: &f", "ofke", "sword");
				ench++;
				break;

			}
		}

		p.getOpenInventory().setItem(29, new ItemStack(Material.RED_STAINED_GLASS_PANE));
		p.getOpenInventory().setItem(40, new ItemStack(Material.RED_STAINED_GLASS_PANE));
		p.getOpenInventory().setItem(33, new ItemStack(Material.RED_STAINED_GLASS_PANE));

	}

	public void addEnchantAxe(ItemStack item, Player p, int lvl) {

		for (int ench = 0; ench < 1;) {
			Random rand = new Random();
			int chance = rand.nextInt(13);
			Random rand2 = new Random();
			int chance2 = rand2.nextInt(lvl - 2);
			if (chance2 == 0) {
				chance2 = 1;
			}
			switch (chance) {
			case 0:

				createEnchant(chance, item, p, chance2, ench, "luck", "&4Büyü ▏ &7Şans: &f", "balta");
				ench++;
				break;

			case 1:

				createEnchant(chance, item, p, chance2, ench, "ustalık", "&4Büyü ▏ &7Ustalık Desteği: &f", "balta");
				ench++;
				break;

			case 2:

				createEnchant(chance, item, p, chance2, ench, "kanama", "&4Büyü ▏ &7Ağır Yara: &f", "balta");
				ench++;
				break;

			case 3:

				createEnchant(chance, item, p, chance2, ench, "parry", "&4Büyü ▏ &7Karşılama: &f", "throw", "balta");
				ench++;
				break;

			case 4:

				createEnchant(chance, item, p, chance2, ench, "throw", "&4Büyü ▏ &7Lanetli Balta: &f", "parry",
						"balta");
				ench++;
				break;

			case 5:

				createEnchant(chance, item, p, chance2, ench, "giant2", "&4Büyü ▏ &7İnfaz: &f", "balta");
				ench++;
				break;

			case 6:

				createEnchantVanilla(chance, item, p, chance2, ench, "sharpness", "&4Büyü ▏ &7Keskinlik: &f", "darbe",
						"orumcek", Enchantment.DAMAGE_ALL, "balta");
				ench++;
				break;

			case 7:

				createEnchantVanilla(chance, item, p, chance2, ench, "darbe", "&4Büyü ▏ &7Darbe: &f", "orumcek",
						"sharpness", Enchantment.DAMAGE_UNDEAD, "balta");
				ench++;
				break;

			case 8:

				createEnchantVanilla(chance, item, p, chance2, ench, "orumcek",
						"&4Büyü ▏ &7Eklembacaklılar'ın Kıyameti: &f", "darbe", "sharpness",
						Enchantment.DAMAGE_ARTHROPODS, "balta");
				ench++;
				break;

			case 9:

				createEnchantVanilla(chance, item, p, chance2, ench, "unbreaking", "&4Büyü ▏ &7Kırılmazlık: &f",
						Enchantment.DURABILITY, "balta");
				ench++;
				break;

			case 10:

				createEnchant(chance, item, p, chance2, ench, "ofke", "&4Büyü ▏ &7Öfke: &f", "souleater", "balta");
				ench++;
				break;

			case 11:

				createEnchantVanilla(chance, item, p, chance2, ench, "verimlilik", "&4Büyü ▏ &7Verimlilik: &f",
						Enchantment.DIG_SPEED, "balta");
				ench++;
				break;

			case 12:

				createEnchantVanilla(chance, item, p, chance2, ench, "servet", "&4Büyü ▏ &7Servet: &f",
						Enchantment.LOOT_BONUS_BLOCKS, "balta");
				ench++;
				break;

			case 13:

				createEnchant(chance, item, p, chance2, ench, "souleater", "&4Büyü ▏ &7Ruh Yiyen: &f", "ofke", "balta");
				ench++;
				break;

			}

			p.getOpenInventory().setItem(29, new ItemStack(Material.RED_STAINED_GLASS_PANE));
			p.getOpenInventory().setItem(40, new ItemStack(Material.RED_STAINED_GLASS_PANE));
			p.getOpenInventory().setItem(33, new ItemStack(Material.RED_STAINED_GLASS_PANE));
		}
	}

	public void addEnchantCrossbow(ItemStack item, Player p, int lvl) {

		for (int ench = 0; ench < 1;) {
			Random rand = new Random();
			int chance = rand.nextInt(6);
			Random rand2 = new Random();
			int chance2 = rand2.nextInt(lvl - 2);
			if (chance2 == 0) {
				chance2 = 1;
			}
			switch (chance) {
			case 0:

				createEnchant(chance, item, p, chance2, ench, "vayne", "&4Büyü ▏ &7Kamuflaj: &f", "cross");
				ench++;
				break;

			case 1:

				createEnchant(chance, item, p, chance2, ench, "kazık", "&4Büyü ▏ &7Kazıkatar: &f", "cross");
				ench++;
				break;

			case 2:

				createEnchantVanilla(chance, item, p, chance2, ench, "multishot", "&4Büyü ▏ &7Çoklu Atış: &f",
						Enchantment.MULTISHOT, "cross");
				ench++;
				break;

			case 3:

				createEnchantVanilla(chance, item, p, chance2, ench, "unbreaking", "&4Büyü ▏ &7Kırılmazlık: &f",
						Enchantment.DURABILITY, "cross");
				ench++;
				break;

			case 4:

				createEnchantVanilla(chance, item, p, chance2, ench, "piercing", "&4Büyü ▏ &7Delme: &f",
						Enchantment.PIERCING, "cross");
				ench++;
				break;

			case 5:

				createEnchantVanilla(chance, item, p, chance2, ench, "hızlıcek", "&4Büyü ▏ &7Hızlı Germe: &f",
						Enchantment.QUICK_CHARGE, "cross");
				ench++;
				break;

			}

			p.getOpenInventory().setItem(29, new ItemStack(Material.RED_STAINED_GLASS_PANE));
			p.getOpenInventory().setItem(40, new ItemStack(Material.RED_STAINED_GLASS_PANE));
			p.getOpenInventory().setItem(33, new ItemStack(Material.RED_STAINED_GLASS_PANE));
		}
	}

	public void addEnchantLeg(ItemStack item, Player p, int lvl) {

		for (int ench = 0; ench < 1;) {
			Random rand = new Random();
			int chance = rand.nextInt(11);
			Random rand2 = new Random();
			int chance2 = rand2.nextInt(lvl - 2);
			if (chance2 == 0) {
				chance2 = 1;
			}
			p.sendMessage("" + chance);
			switch (chance) {
			case 0:

				createEnchant(chance, item, p, chance2, ench, "creeper", "&4Büyü ▏ &7Yaşayan Bomba: &f", "leg");
				ench++;
				break;

			case 1:

				createEnchant(chance, item, p, chance2, ench, "ice", "&4Büyü ▏ &7Mutlak Sıfır: &f", "leg");
				ench++;
				break;

			case 2:

				createEnchant(chance, item, p, chance2, ench, "soul", "&4Büyü ▏ &7Ruh Koruması: &f", "leg");
				ench++;
				break;

			case 3:

				createEnchant(chance, item, p, chance2, ench, "guard", "&4Büyü ▏ &7Son Direniş: &f", "leg");
				ench++;
				break;

			case 4:

				createEnchant(chance, item, p, chance2, ench, "shield", "&4Büyü ▏ &7Kalkan Darbesi: &f", "leg");
				ench++;
				break;

			case 5:

				createEnchantVanilla(chance, item, p, chance2, ench, "protection", "&4Büyü ▏ &7Koruma: &f",

						Enchantment.PROTECTION_ENVIRONMENTAL, "leg");
				ench++;
				break;

			case 6:

				createEnchantVanilla(chance, item, p, chance2, ench, "fireprot", "&4Büyü ▏ &7Alev Koruması: &f",
						Enchantment.PROTECTION_FIRE, "leg");
				ench++;
				break;

			case 7:

				createEnchantVanilla(chance, item, p, chance2, ench, "arrowprot", "&4Büyü ▏ &7Büyülü Kaplama: &f",
						Enchantment.PROTECTION_PROJECTILE, "leg");
				ench++;
				break;

			case 8:

				createEnchantVanilla(chance, item, p, chance2, ench, "exploprot", "&4Büyü ▏ &7Patlama Koruması: &f",
						Enchantment.PROTECTION_EXPLOSIONS, "leg");
				ench++;
				break;

			case 9:

				createEnchantVanilla(chance, item, p, chance2, ench, "unbreaking", "&4Büyü ▏ &7Kırılmazlık: &f",
						Enchantment.DURABILITY, "leg");
				ench++;
				break;

			case 10:

				createEnchantVanilla(chance, item, p, chance2, ench, "thorns", "&4Büyü ▏ &7Dikenler: &f",
						Enchantment.THORNS, "leg");
				ench++;
				break;

			}

			p.getOpenInventory().setItem(29, new ItemStack(Material.RED_STAINED_GLASS_PANE));
			p.getOpenInventory().setItem(40, new ItemStack(Material.RED_STAINED_GLASS_PANE));
			p.getOpenInventory().setItem(33, new ItemStack(Material.RED_STAINED_GLASS_PANE));
		}
	}

	public void addEnchantChestplate(ItemStack item, Player p, int lvl) {

		for (int ench = 0; ench < 1;) {
			Random rand = new Random();
			int chance = rand.nextInt(12);
			Random rand2 = new Random();
			int chance2 = rand2.nextInt(lvl - 2);
			if (chance2 == 0) {
				chance2 = 1;
			}
			switch (chance) {
			case 0:

				createEnchant(chance, item, p, chance2, ench, "sabotage", "&4Büyü ▏ &7Sabotaj: &f", "chest");
				ench++;
				break;

			case 1:

				createEnchant(chance, item, p, chance2, ench, "revenge", "&4Büyü ▏ &7İntikam: &f", "chest");
				ench++;
				break;

			case 2:

				createEnchant(chance, item, p, chance2, ench, "growth", "&4Büyü ▏ &7Aşırı Büyüme: &f", "chest");
				ItemMeta item2meta = item.getItemMeta();
				AttributeModifier health = new AttributeModifier(UUID.randomUUID(), "generic.max_health", chance2 * 2,
						AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
				item2meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, health);
				item.setItemMeta(item2meta);
				ench++;
				break;

			case 3:

				createEnchant(chance, item, p, chance2, ench, "kutsal", "&4Büyü ▏ &7Bağışıklık: &f", "chest");
				ench++;
				break;

			case 4:

				createEnchant(chance, item, p, chance2, ench, "fireres", "&4Büyü ▏ &7Obsidyen Kaplama: &f", "chest");
				ench++;
				break;

			case 5:

				createEnchant(chance, item, p, chance2, ench, "yenilen", "&4Büyü ▏ &7Kutsanmış: &f", "chest");
				ench++;
				break;

			case 6:

				createEnchantVanilla(chance, item, p, chance2, ench, "protection", "&4Büyü ▏ &7Koruma: &f",
						Enchantment.PROTECTION_ENVIRONMENTAL, "chest");
				ench++;
				break;

			case 7:

				createEnchantVanilla(chance, item, p, chance2, ench, "fireprot", "&4Büyü ▏ &7Alev Koruması: &f",
						Enchantment.PROTECTION_FIRE, "chest");
				ench++;
				break;

			case 8:

				createEnchantVanilla(chance, item, p, chance2, ench, "arrowprot", "&4Büyü ▏ &7Büyülü Kaplama: &f",
						Enchantment.PROTECTION_PROJECTILE, "chest");
				ench++;
				break;

			case 9:

				createEnchantVanilla(chance, item, p, chance2, ench, "exploprot", "&4Büyü ▏ &7Patlama Koruması: &f",
						Enchantment.PROTECTION_EXPLOSIONS, "chest");
				ench++;
				break;

			case 10:

				createEnchantVanilla(chance, item, p, chance2, ench, "unbreaking", "&4Büyü ▏ &7Kırılmazlık: &f",
						Enchantment.DURABILITY, "chest");
				ench++;
				break;

			case 11:

				createEnchantVanilla(chance, item, p, chance2, ench, "thorns", "&4Büyü ▏ &7Dikenler: &f",
						Enchantment.THORNS, "chest");
				ench++;
				break;

			}

			p.getOpenInventory().setItem(29, new ItemStack(Material.RED_STAINED_GLASS_PANE));
			p.getOpenInventory().setItem(40, new ItemStack(Material.RED_STAINED_GLASS_PANE));
			p.getOpenInventory().setItem(33, new ItemStack(Material.RED_STAINED_GLASS_PANE));
		}
	}

	public void addEnchantHelmet(ItemStack item, Player p, int lvl) {

		for (int ench = 0; ench < 1;) {
			Random rand = new Random();
			int chance = rand.nextInt(13);
			Random rand2 = new Random();
			int chance2 = rand2.nextInt(lvl - 2);
			if (chance2 == 0) {
				chance2 = 1;
			}
			ItemMeta item2meta = item.getItemMeta();
			switch (chance) {
			case 0:

				createEnchant(chance, item, p, chance2, ench, "barbarian", "&4Büyü ▏ &7Barbar Gücü: &f", "helmet");

				AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed",
						(double) -chance2 / 100, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
				item2meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, speed);
				item.setItemMeta(item2meta);
				ench++;
				break;

			case 1:

				createEnchant(chance, item, p, chance2, ench, "growth", "&4Büyü ▏ &7Aşırı Büyüme: &f", "helmet");
				AttributeModifier health = new AttributeModifier(UUID.randomUUID(), "generic.max_health", chance2 * 2,
						AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
				item2meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, health);
				item.setItemMeta(item2meta);
				ench++;
				break;

			case 2:

				createEnchant(chance, item, p, chance2, ench, "archerhead", "&4Büyü ▏ &7Keskin Görüş: &f", "helmet");
				ench++;

				break;

			case 3:

				createEnchant(chance, item, p, chance2, ench, "wisdom", "&4Büyü ▏ &7Yücelik: &f", "helmet");
				ench++;
				break;

			case 4:

				createEnchant(chance, item, p, chance2, ench, "slayer", "&4Büyü ▏ &7Dev Avcısı: &f", "helmet");
				ench++;
				break;

			case 5:

				createEnchantVanilla(chance, item, p, chance2, ench, "protection", "&4Büyü ▏ &7Koruma: &f",
						Enchantment.PROTECTION_ENVIRONMENTAL, "helmet");
				ench++;
				break;

			case 6:

				createEnchantVanilla(chance, item, p, chance2, ench, "fireprot", "&4Büyü ▏ &7Alev Koruması: &f",
						Enchantment.PROTECTION_FIRE, "helmet");
				ench++;
				break;

			case 7:

				createEnchantVanilla(chance, item, p, chance2, ench, "arrowprot", "&4Büyü ▏ &7Büyülü Kaplama: &f",
						Enchantment.PROTECTION_PROJECTILE, "helmet");
				ench++;
				break;

			case 8:

				createEnchantVanilla(chance, item, p, chance2, ench, "exploprot", "&4Büyü ▏ &7Patlama Koruması: &f",
						Enchantment.PROTECTION_EXPLOSIONS, "helmet");
				ench++;
				break;

			case 9:

				createEnchantVanilla(chance, item, p, chance2, ench, "unbreaking", "&4Büyü ▏ &7Kırılmazlık: &f",
						Enchantment.DURABILITY, "helmet");
				ench++;
				break;

			case 10:

				createEnchantVanilla(chance, item, p, chance2, ench, "thorns", "&4Büyü ▏ &7Dikenler: &f",
						Enchantment.THORNS, "helmet");
				ench++;
				break;

			case 11:

				createEnchantVanilla(chance, item, p, chance2, ench, "solungac", "&4Büyü ▏ &7Solungaç: &f",
						Enchantment.OXYGEN, "helmet");
				ench++;
				break;

			case 12:

				createEnchantVanilla(chance, item, p, chance2, ench, "waterworker", "&4Büyü ▏ &7Su Adaptasyonu: &f",
						Enchantment.WATER_WORKER, "helmet");
				ench++;
				break;

			}

			p.getOpenInventory().setItem(29, new ItemStack(Material.RED_STAINED_GLASS_PANE));
			p.getOpenInventory().setItem(40, new ItemStack(Material.RED_STAINED_GLASS_PANE));
			p.getOpenInventory().setItem(33, new ItemStack(Material.RED_STAINED_GLASS_PANE));
		}
	}

	public void addEnchantBoots(ItemStack item, Player p, int lvl) {

		for (int ench = 0; ench < 1;) {
			Random rand = new Random();
			int chance = rand.nextInt(15);
			Random rand2 = new Random();
			int chance2 = rand2.nextInt(lvl - 2);
			if (chance2 == 0) {
				chance2 = 1;
			}
			ItemMeta item2meta = item.getItemMeta();
			switch (chance) {
			case 0:

				createEnchant(chance, item, p, chance2, ench, "magicboot", "&4Büyü ▏ &7Sihirli Pabuçlar: &f", "boot");
				AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed",
						(double) chance2 / 100, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
				item2meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, speed);
				item.setItemMeta(item2meta);
				ench++;
				break;

			case 1:

				createEnchant(chance, item, p, chance2, ench, "growth", "&4Büyü ▏ &7Aşırı Büyüme: &f", "boot");
				AttributeModifier health = new AttributeModifier(UUID.randomUUID(), "generic.max_health", chance2 * 2,
						AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
				item2meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, health);
				item.setItemMeta(item2meta);
				ench++;
				break;

			case 2:

				createEnchant(chance, item, p, chance2, ench, "knockbackres", "&4Büyü ▏ &7Dikenli Taban: &f", "boot");
				AttributeModifier knock = new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance",
						(double) chance2 / 100, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
				item2meta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, knock);
				item.setItemMeta(item2meta);
				ench++;
				break;

			case 3:

				createEnchant(chance, item, p, chance2, ench, "attacksped", "&4Büyü ▏ &7Sağlam Duruş: &f", "boot");
				ench++;
				break;

			case 4:

				createEnchant(chance, item, p, chance2, ench, "dodgerate", "&4Büyü ▏ &7Sıvışma: &f", "boot");
				ench++;
				break;

			case 5:

				createEnchantVanilla(chance, item, p, chance2, ench, "protection", "&4Büyü ▏ &7Koruma: &f",
						Enchantment.PROTECTION_ENVIRONMENTAL, "boot");
				ench++;
				break;

			case 6:

				createEnchantVanilla(chance, item, p, chance2, ench, "fireprot", "&4Büyü ▏ &7Alev Koruması: &f",
						Enchantment.PROTECTION_FIRE, "boot");
				ench++;
				break;

			case 7:

				createEnchantVanilla(chance, item, p, chance2, ench, "arrowprot", "&4Büyü ▏ &7Büyülü Kaplama: &f",
						Enchantment.PROTECTION_PROJECTILE, "boot");
				ench++;
				break;

			case 8:

				createEnchantVanilla(chance, item, p, chance2, ench, "exploprot", "&4Büyü ▏ &7Patlama Koruması: &f",
						Enchantment.PROTECTION_EXPLOSIONS, "boot");
				ench++;
				break;

			case 9:

				createEnchantVanilla(chance, item, p, chance2, ench, "unbreaking", "&4Büyü ▏ &7Kırılmazlık: &f",
						Enchantment.DURABILITY, "boot");
				ench++;
				break;

			case 10:

				createEnchantVanilla(chance, item, p, chance2, ench, "thorns", "&4Büyü ▏ &7Dikenler: &f",
						Enchantment.THORNS, "boot");
				ench++;
				break;

			case 11:

				createEnchantVanilla(chance, item, p, chance2, ench, "depth", "&4Büyü ▏ &7Derin Koşucu: &f",
						Enchantment.DEPTH_STRIDER, "boot");
				ench++;
				break;

			case 12:

				createEnchantVanilla(chance, item, p, chance2, ench, "soulspeed", "&4Büyü ▏ &7Ruh Hızı: &f",
						Enchantment.SOUL_SPEED, "boot");
				ench++;
				break;

			case 13:

				createEnchantVanilla(chance, item, p, chance2, ench, "icewalker",
						"&4Büyü ▏ &7Kırağılaştırıcı Yürüyücü: &f", Enchantment.FROST_WALKER, "boot");
				ench++;
				break;

			case 14:

				createEnchantVanilla(chance, item, p, chance2, ench, "feather", "&4Büyü ▏ &7Tüy Düşüşü: &f",
						Enchantment.PROTECTION_FALL, "boot");
				ench++;
				break;

			}

			p.getOpenInventory().setItem(29, new ItemStack(Material.RED_STAINED_GLASS_PANE));
			p.getOpenInventory().setItem(40, new ItemStack(Material.RED_STAINED_GLASS_PANE));
			p.getOpenInventory().setItem(33, new ItemStack(Material.RED_STAINED_GLASS_PANE));
		}

	}

	public void addEnchantShovel(ItemStack item, Player p, int lvl) {

		for (int ench = 0; ench < 1;) {
			Random rand = new Random();
			int chance = rand.nextInt(7);
			Random rand2 = new Random();
			int chance2 = rand2.nextInt(lvl - 2);
			if (chance2 == 0) {
				chance2 = 1;
			}
			switch (chance) {
			case 0:

				createEnchant(chance, item, p, chance2, ench, "luck", "&4Büyü ▏ &7Şans: &f", "shovel");
				ench++;
				break;

			case 1:

				createEnchant(chance, item, p, chance2, ench, "hazine", "&4Büyü ▏ &7Hazine Avcısı: &f", "shovel");
				ench++;
				break;

			case 2:

				createEnchant(chance, item, p, chance2, ench, "shovelknight",
						"&4Büyü ▏ &7Kürekli Şövalye'nin Lütfu: &f", "shovel");
				ench++;
				break;

			case 3:

				createEnchantVanilla(chance, item, p, chance2, ench, "verimlilik", "&4Büyü ▏ &7Verimlilik: &f",
						Enchantment.DIG_SPEED, "shovel");
				ench++;
				break;

			case 4:

				createEnchantVanilla(chance, item, p, chance2, ench, "unbreaking", "&4Büyü ▏ &7Kırılmazlık: &f",
						Enchantment.DURABILITY, "shovel");
				ench++;
				break;

			case 5:

				createEnchantVanilla(chance, item, p, chance2, ench, "silk", "&4Büyü ▏ &İpeksi Dokunuş: &f", "servet",
						Enchantment.SILK_TOUCH, "shovel");
				ench++;
				break;

			case 6:

				createEnchantVanilla(chance, item, p, chance2, ench, "servet", "&4Büyü ▏ &Servet: &f", "silk",
						Enchantment.LOOT_BONUS_BLOCKS, "shovel");
				ench++;
				break;

			}

			p.getOpenInventory().setItem(29, new ItemStack(Material.RED_STAINED_GLASS_PANE));
			p.getOpenInventory().setItem(40, new ItemStack(Material.RED_STAINED_GLASS_PANE));
			p.getOpenInventory().setItem(33, new ItemStack(Material.RED_STAINED_GLASS_PANE));
		}

	}

	public void addEnchantPickaxe(ItemStack item, Player p, int lvl) {

		for (int ench = 0; ench < 1;) {
			Random rand = new Random();
			int chance = rand.nextInt(7);
			Random rand2 = new Random();
			int chance2 = rand2.nextInt(lvl - 2);
			if (chance2 == 0) {
				chance2 = 1;
			}
			switch (chance) {
			case 0:

				createEnchant(chance, item, p, chance2, ench, "luck", "&4Büyü ▏ &7Şans: &f", "pickaxe");
				ench++;
				break;

			case 1:

				createEnchant(chance, item, p, chance2, ench, "xp", "&4Büyü ▏ &7Tecrübe Desteği: &f", "pickaxe");
				ench++;
				break;

			case 2:

				createEnchant(chance, item, p, chance2, ench, "ustalık", "&4Büyü ▏ &7Ustalık Desteği: &f", "pickaxe");
				ench++;
				break;

			case 3:

				createEnchantVanilla(chance, item, p, chance2, ench, "verimlilik", "&4Büyü ▏ &7Verimlilik: &f",
						Enchantment.DIG_SPEED, "pickaxe");
				ench++;
				break;

			case 4:

				createEnchantVanilla(chance, item, p, chance2, ench, "unbreaking", "&4Büyü ▏ &7Kırılmazlık: &f",
						Enchantment.DURABILITY, "pickaxe");
				ench++;
				break;

			case 5:

				createEnchantVanilla(chance, item, p, chance2, ench, "silk", "&4Büyü ▏ &İpeksi Dokunuş: &f", "servet",
						Enchantment.SILK_TOUCH, "pickaxe");
				ench++;
				break;

			case 6:

				createEnchantVanilla(chance, item, p, chance2, ench, "servet", "&4Büyü ▏ &Servet: &f", "silk",
						Enchantment.LOOT_BONUS_BLOCKS, "pickaxe");
				ench++;
				break;

			}

			p.getOpenInventory().setItem(29, new ItemStack(Material.RED_STAINED_GLASS_PANE));
			p.getOpenInventory().setItem(40, new ItemStack(Material.RED_STAINED_GLASS_PANE));
			p.getOpenInventory().setItem(33, new ItemStack(Material.RED_STAINED_GLASS_PANE));
		}

	}

	public void addEnchantFishingRod(ItemStack item, Player p, int lvl) {

		for (int ench = 0; ench < 1;) {
			Random rand = new Random();
			int chance = rand.nextInt(7);
			Random rand2 = new Random();
			int chance2 = rand2.nextInt(lvl - 2);
			if (chance2 == 0) {
				chance2 = 1;
			}
			switch (chance) {
			case 0:

				createEnchant(chance, item, p, chance2, ench, "luck", "&4Büyü ▏ &7Şans: &f", "rod");
				ench++;
				break;

			case 1:

				createEnchant(chance, item, p, chance2, ench, "xp", "&4Büyü ▏ &7Tecrübe Desteği: &f", "rod");
				ench++;
				break;

			case 2:

				createEnchant(chance, item, p, chance2, ench, "ustalık", "&4Büyü ▏ &7Ustalık Desteği: &f", "rod");
				ench++;
				break;

			case 3:

				createEnchant(chance, item, p, chance2, ench, "siftah", "&4Büyü ▏ &7Siftah: &f", "rod");
				ench++;
				break;

			case 4:

				createEnchant(chance, item, p, chance2, ench, "keskinkanca", "&4Büyü ▏ &7Keskin Kanca: &f", "rod");
				ench++;
				break;

			case 5:

				createEnchantVanilla(chance, item, p, chance2, ench, "ayartma", "&4Büyü ▏ &7Ayartma: &f",
						Enchantment.LURE, "rod");
				ench++;
				break;

			case 6:

				createEnchantVanilla(chance, item, p, chance2, ench, "luckofthesea", "&4Büyü ▏ &7Deniz Şansı: &f",

						Enchantment.LUCK, "rod");
				ench++;
				break;

			}

			p.getOpenInventory().setItem(29, new ItemStack(Material.RED_STAINED_GLASS_PANE));
			p.getOpenInventory().setItem(40, new ItemStack(Material.RED_STAINED_GLASS_PANE));
			p.getOpenInventory().setItem(33, new ItemStack(Material.RED_STAINED_GLASS_PANE));
		}

	}

	public void getEnchantType(ItemStack item) {

	}
}
