package me.taylan.mooncore.enchanting;

import java.util.HashMap;
import java.util.List;

import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import com.manya.pdc.DataTypes;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.Painter;

public class EnchantConstructor {
	private  MoonCore plugin;

	public EnchantConstructor(MoonCore plugin) {
		this.plugin = plugin;
	}

	private static PersistentDataType<?, HashMap<String, Integer>> Enchants = DataTypes
			.hashMap(PersistentDataType.STRING, PersistentDataType.INTEGER);

	public static PersistentDataType<?, HashMap<String, Integer>> getEnchants() {
		return Enchants;
	}

	public void createEnchant(int chance, ItemStack item, Player p, int chance2, int enchFor, String Enchant,
			String EnchLore, String noEnch, String noEnch2, String noEnch3, String type) {
		NamespacedKey key = new NamespacedKey(plugin, "Enchants");

		if (item.getItemMeta().getPersistentDataContainer().get(key, Enchants) != null) {
			if (item.getItemMeta().getPersistentDataContainer().get(key, Enchants).containsKey(Enchant) || (item
					.getItemMeta().getPersistentDataContainer().get(key, Enchants).containsKey(noEnch)
					|| (item.getItemMeta().getPersistentDataContainer().get(key, Enchants).containsKey(noEnch2) || (item
							.getItemMeta().getPersistentDataContainer().get(key, Enchants).containsKey(noEnch3))))) {
				chance += 1;
			} else {
				p.setLevel(p.getLevel() - 5);
				List<String> itemLore = item.getItemMeta().getLore();
				ItemMeta item2meta = item.getItemMeta();
				for (int i = 0; i < itemLore.size(); i++) {
					String lValue = itemLore.get(i);
					if (lValue.equals(Painter.paint("&8<Boş Büyü Bölmesi>"))) {
						itemLore.set(i, Painter.paint(EnchLore + chance2));
						break;
					}
				}
				NamespacedKey string = new NamespacedKey(plugin, "string");
				String enchname = Painter.paint(EnchLore);
				NamespacedKey enchanttype = new NamespacedKey(plugin, "enchantType");
				item2meta.getPersistentDataContainer().set(enchanttype, PersistentDataType.STRING, type);
				item2meta.getPersistentDataContainer().set(string, PersistentDataType.STRING, enchname);
				if (item2meta.getPersistentDataContainer().get(key, Enchants) == null) {
					HashMap<String, Integer> enchs = new HashMap<String, Integer>();
					enchs.put(Enchant, chance2);

					item2meta.addEnchant(Enchantment.WATER_WORKER, 1, true);
					item2meta.getPersistentDataContainer().set(key, Enchants, enchs);
				} else {
					HashMap<String, Integer> enchs = item2meta.getPersistentDataContainer().get(key, Enchants);
					enchs.put(Enchant, chance2);

					item2meta.addEnchant(Enchantment.WATER_WORKER, 1, true);
					item2meta.getPersistentDataContainer().set(key, Enchants, enchs);
				}
				item2meta.setLore(itemLore);
				item.setItemMeta(item2meta);
				p.getInventory().addItem(item);
				p.getOpenInventory().setItem(31, null);
				p.playSound(p, Sound.ITEM_TRIDENT_THUNDER, 3, 1.7f);
			}

		} else {
			p.setLevel(p.getLevel() - 5);
			List<String> itemLore = item.getItemMeta().getLore();
			ItemMeta item2meta = item.getItemMeta();
			for (int i = 0; i < itemLore.size(); i++) {
				String lValue = itemLore.get(i);
				if (lValue.equals(Painter.paint("&8<Boş Büyü Bölmesi>"))) {
					itemLore.set(i, Painter.paint(EnchLore + chance2));
					break;
				}
			}
			NamespacedKey string = new NamespacedKey(plugin, "string");
			String enchname = Painter.paint(EnchLore);
			item2meta.getPersistentDataContainer().set(string, PersistentDataType.STRING, enchname);
			if (item2meta.getPersistentDataContainer().get(key, Enchants) == null) {
				HashMap<String, Integer> enchs = new HashMap<String, Integer>();
				enchs.put(Enchant, chance2);

				item2meta.addEnchant(Enchantment.WATER_WORKER, 1, true);
				item2meta.getPersistentDataContainer().set(key, Enchants, enchs);
			} else {
				HashMap<String, Integer> enchs = item2meta.getPersistentDataContainer().get(key, Enchants);
				enchs.put(Enchant, chance2);

				item2meta.addEnchant(Enchantment.WATER_WORKER, 1, true);
				item2meta.getPersistentDataContainer().set(key, Enchants, enchs);
			}
			item2meta.setLore(itemLore);
			item.setItemMeta(item2meta);
			p.getInventory().addItem(item);
			p.getOpenInventory().setItem(31, null);
			p.playSound(p, Sound.ITEM_TRIDENT_THUNDER, 3, 1.7f);
		}
	}

	public  void createEnchant(int chance, ItemStack item, Player p, int chance2, int enchFor, String Enchant,
			String EnchLore, String noEnch, String noEnch2, String type) {
		NamespacedKey key = new NamespacedKey(plugin, "Enchants");
		if (item.getItemMeta().getPersistentDataContainer().get(key, Enchants) != null) {
			if (item.getItemMeta().getPersistentDataContainer().get(key, Enchants).containsKey(Enchant) || (item
					.getItemMeta().getPersistentDataContainer().get(key, Enchants).containsKey(noEnch)
					|| (item.getItemMeta().getPersistentDataContainer().get(key, Enchants).containsKey(noEnch2)))) {
				chance += 1;
			} else {
				p.setLevel(p.getLevel() - 5);
				List<String> itemLore = item.getItemMeta().getLore();
				ItemMeta item2meta = item.getItemMeta();
				for (int i = 0; i < itemLore.size(); i++) {
					String lValue = itemLore.get(i);
					if (lValue.equals(Painter.paint("&8<Boş Büyü Bölmesi>"))) {
						itemLore.set(i, Painter.paint(EnchLore + chance2));
						break;
					}
				}
				NamespacedKey string = new NamespacedKey(plugin, "string");
				String enchname = Painter.paint(EnchLore);
				NamespacedKey enchanttype = new NamespacedKey(plugin, "enchantType");
				item2meta.getPersistentDataContainer().set(enchanttype, PersistentDataType.STRING, type);
				item2meta.getPersistentDataContainer().set(string, PersistentDataType.STRING, enchname);
				if (item2meta.getPersistentDataContainer().get(key, Enchants) == null) {
					HashMap<String, Integer> enchs = new HashMap<String, Integer>();
					enchs.put(Enchant, chance2);

					item2meta.addEnchant(Enchantment.WATER_WORKER, 1, true);
					item2meta.getPersistentDataContainer().set(key, Enchants, enchs);
				} else {
					HashMap<String, Integer> enchs = item2meta.getPersistentDataContainer().get(key, Enchants);
					enchs.put(Enchant, chance2);

					item2meta.addEnchant(Enchantment.WATER_WORKER, 1, true);
					item2meta.getPersistentDataContainer().set(key, Enchants, enchs);
				}
				item2meta.setLore(itemLore);
				item.setItemMeta(item2meta);
				p.getInventory().addItem(item);
				p.getOpenInventory().setItem(31, null);
				p.playSound(p, Sound.ITEM_TRIDENT_THUNDER, 3, 1.7f);
			}

		} else {
			p.setLevel(p.getLevel() - 5);
			List<String> itemLore = item.getItemMeta().getLore();
			ItemMeta item2meta = item.getItemMeta();
			for (int i = 0; i < itemLore.size(); i++) {
				String lValue = itemLore.get(i);
				if (lValue.equals(Painter.paint("&8<Boş Büyü Bölmesi>"))) {
					itemLore.set(i, Painter.paint(EnchLore + chance2));
					break;
				}
			}
			NamespacedKey string = new NamespacedKey(plugin, "string");
			String enchname = Painter.paint(EnchLore);
			item2meta.getPersistentDataContainer().set(string, PersistentDataType.STRING, enchname);
			if (item2meta.getPersistentDataContainer().get(key, Enchants) == null) {
				HashMap<String, Integer> enchs = new HashMap<String, Integer>();
				enchs.put(Enchant, chance2);

				item2meta.addEnchant(Enchantment.WATER_WORKER, 1, true);
				item2meta.getPersistentDataContainer().set(key, Enchants, enchs);
			} else {
				HashMap<String, Integer> enchs = item2meta.getPersistentDataContainer().get(key, Enchants);
				enchs.put(Enchant, chance2);

				item2meta.addEnchant(Enchantment.WATER_WORKER, 1, true);
				item2meta.getPersistentDataContainer().set(key, Enchants, enchs);
			}
			item2meta.setLore(itemLore);
			item.setItemMeta(item2meta);
			p.getInventory().addItem(item);
			p.getOpenInventory().setItem(31, null);
			p.playSound(p, Sound.ITEM_TRIDENT_THUNDER, 3, 1.7f);
		}
	}

	public  void createEnchant(int chance, ItemStack item, Player p, int chance2, int enchFor, String Enchant,
			String EnchLore, String noEnch, String type) {
		NamespacedKey key = new NamespacedKey(plugin, "Enchants");
		if (item.getItemMeta().getPersistentDataContainer().get(key, Enchants) != null) {
			if (item.getItemMeta().getPersistentDataContainer().get(key, Enchants).containsKey(Enchant)
					|| (item.getItemMeta().getPersistentDataContainer().get(key, Enchants).containsKey(noEnch))) {
				chance += 1;
			} else {
				p.setLevel(p.getLevel() - 5);
				List<String> itemLore = item.getItemMeta().getLore();
				ItemMeta item2meta = item.getItemMeta();
				for (int i = 0; i < itemLore.size(); i++) {
					String lValue = itemLore.get(i);
					if (lValue.equals(Painter.paint("&8<Boş Büyü Bölmesi>"))) {
						itemLore.set(i, Painter.paint(EnchLore + chance2));
						break;
					}
				}
				NamespacedKey enchanttype = new NamespacedKey(plugin, "enchantType");
				item2meta.getPersistentDataContainer().set(enchanttype, PersistentDataType.STRING, type);
				NamespacedKey string = new NamespacedKey(plugin, "string");
				String enchname = Painter.paint(EnchLore);
				item2meta.getPersistentDataContainer().set(string, PersistentDataType.STRING, enchname);
				if (item2meta.getPersistentDataContainer().get(key, Enchants) == null) {
					HashMap<String, Integer> enchs = new HashMap<String, Integer>();
					enchs.put(Enchant, chance2);

					item2meta.addEnchant(Enchantment.WATER_WORKER, 1, true);
					item2meta.getPersistentDataContainer().set(key, Enchants, enchs);
				} else {
					HashMap<String, Integer> enchs = item2meta.getPersistentDataContainer().get(key, Enchants);
					enchs.put(Enchant, chance2);

					item2meta.addEnchant(Enchantment.WATER_WORKER, 1, true);
					item2meta.getPersistentDataContainer().set(key, Enchants, enchs);
				}

				item2meta.setLore(itemLore);
				item.setItemMeta(item2meta);
				p.getInventory().addItem(item);
				p.getOpenInventory().setItem(31, null);
				p.playSound(p, Sound.ITEM_TRIDENT_THUNDER, 3, 1.7f);
			}
		} else {
			p.setLevel(p.getLevel() - 5);
			List<String> itemLore = item.getItemMeta().getLore();
			ItemMeta item2meta = item.getItemMeta();
			for (int i = 0; i < itemLore.size(); i++) {
				String lValue = itemLore.get(i);
				if (lValue.equals(Painter.paint("&8<Boş Büyü Bölmesi>"))) {
					itemLore.set(i, Painter.paint(EnchLore + chance2));
					break;
				}
			}
			NamespacedKey string = new NamespacedKey(plugin, "string");
			String enchname = Painter.paint(EnchLore);
			item2meta.getPersistentDataContainer().set(string, PersistentDataType.STRING, enchname);
			if (item2meta.getPersistentDataContainer().get(key, Enchants) == null) {
				HashMap<String, Integer> enchs = new HashMap<String, Integer>();
				enchs.put(Enchant, chance2);

				item2meta.addEnchant(Enchantment.WATER_WORKER, 1, true);
				item2meta.getPersistentDataContainer().set(key, Enchants, enchs);
			} else {
				HashMap<String, Integer> enchs = item2meta.getPersistentDataContainer().get(key, Enchants);
				enchs.put(Enchant, chance2);

				item2meta.addEnchant(Enchantment.WATER_WORKER, 1, true);
				item2meta.getPersistentDataContainer().set(key, Enchants, enchs);
			}

			item2meta.setLore(itemLore);
			item.setItemMeta(item2meta);
			p.getInventory().addItem(item);
			p.getOpenInventory().setItem(31, null);
			p.playSound(p, Sound.ITEM_TRIDENT_THUNDER, 3, 1.7f);
		}

	}

	public  void createEnchant(int chance, ItemStack item, Player p, int chance2, int enchFor, String Enchant,
			String EnchLore, String type) {
		NamespacedKey key = new NamespacedKey(plugin, "Enchants");
		if (item.getItemMeta().getPersistentDataContainer().get(key, Enchants) != null
				&& (item.getItemMeta().getPersistentDataContainer().get(key, Enchants).containsKey(Enchant))) {
			chance += 1;
		} else {
			p.setLevel(p.getLevel() - 5);
			List<String> itemLore = item.getItemMeta().getLore();
			ItemMeta item2meta = item.getItemMeta();
			for (int i = 0; i < itemLore.size(); i++) {
				String lValue = itemLore.get(i);
				if (lValue.equals(Painter.paint("&8<Boş Büyü Bölmesi>"))) {
					itemLore.set(i, Painter.paint(EnchLore + chance2));
					break;
				}
			}
			NamespacedKey enchanttype = new NamespacedKey(plugin, "enchantType");
			item2meta.getPersistentDataContainer().set(enchanttype, PersistentDataType.STRING, type);
			NamespacedKey string = new NamespacedKey(plugin, "string");
			String enchname = Painter.paint(EnchLore);
			item2meta.getPersistentDataContainer().set(string, PersistentDataType.STRING, enchname);
			if (item2meta.getPersistentDataContainer().get(key, Enchants) == null) {
				HashMap<String, Integer> enchs = new HashMap<String, Integer>();
				enchs.put(Enchant, chance2);

				item2meta.addEnchant(Enchantment.WATER_WORKER, 1, true);
				item2meta.getPersistentDataContainer().set(key, Enchants, enchs);
			} else {
				HashMap<String, Integer> enchs = item2meta.getPersistentDataContainer().get(key, Enchants);
				enchs.put(Enchant, chance2);

				item2meta.addEnchant(Enchantment.WATER_WORKER, 1, true);
				item2meta.getPersistentDataContainer().set(key, Enchants, enchs);
			}

			item2meta.setLore(itemLore);
			item.setItemMeta(item2meta);
			p.getInventory().addItem(item);
			p.getOpenInventory().setItem(31, null);
			p.playSound(p, Sound.ITEM_TRIDENT_THUNDER, 3, 1.7f);
		}

	}

	public  void createEnchantVanilla(int chance, ItemStack item, Player p, int chance2, int enchFor,
			String Enchant, String EnchLore, String noEnch, String noEnch2, Enchantment vanilla, String type) {
		NamespacedKey key = new NamespacedKey(plugin, "Enchants");
		if (item.getItemMeta().getPersistentDataContainer().get(key, Enchants) != null) {
			if (item.getItemMeta().getPersistentDataContainer().get(key, Enchants).containsKey(Enchant) || (item
					.getItemMeta().getPersistentDataContainer().get(key, Enchants).containsKey(noEnch)
					|| (item.getItemMeta().getPersistentDataContainer().get(key, Enchants).containsKey(noEnch2)))) {
				chance += 1;
			} else {
				p.setLevel(p.getLevel() - 5);
				List<String> itemLore = item.getItemMeta().getLore();
				ItemMeta item2meta = item.getItemMeta();
				for (int i = 0; i < itemLore.size(); i++) {
					String lValue = itemLore.get(i);
					if (lValue.equals(Painter.paint("&8<Boş Büyü Bölmesi>"))) {
						itemLore.set(i, Painter.paint(EnchLore + chance2));
						break;
					}
				}
				NamespacedKey enchanttype = new NamespacedKey(plugin, "enchantType");
				item2meta.getPersistentDataContainer().set(enchanttype, PersistentDataType.STRING, type);
				NamespacedKey string = new NamespacedKey(plugin, "string");
				String enchname = Painter.paint(EnchLore);
				item2meta.getPersistentDataContainer().set(string, PersistentDataType.STRING, enchname);
				if (item2meta.getPersistentDataContainer().get(key, Enchants) == null) {
					HashMap<String, Integer> enchs = new HashMap<String, Integer>();
					enchs.put(Enchant, chance2);

					item2meta.addEnchant(vanilla, chance2, true);
					item2meta.getPersistentDataContainer().set(key, Enchants, enchs);
				} else {
					HashMap<String, Integer> enchs = item2meta.getPersistentDataContainer().get(key, Enchants);
					enchs.put(Enchant, chance2);

					item2meta.addEnchant(vanilla, chance2, true);
					item2meta.getPersistentDataContainer().set(key, Enchants, enchs);
				}
				item2meta.setLore(itemLore);
				item.setItemMeta(item2meta);
				p.getInventory().addItem(item);
				p.getOpenInventory().setItem(31, null);
				p.playSound(p, Sound.ITEM_TRIDENT_THUNDER, 3, 1.7f);
			}

		} else {
			p.setLevel(p.getLevel() - 5);
			List<String> itemLore = item.getItemMeta().getLore();
			ItemMeta item2meta = item.getItemMeta();
			for (int i = 0; i < itemLore.size(); i++) {
				String lValue = itemLore.get(i);
				if (lValue.equals(Painter.paint("&8<Boş Büyü Bölmesi>"))) {
					itemLore.set(i, Painter.paint(EnchLore + chance2));
					break;
				}
			}
			NamespacedKey string = new NamespacedKey(plugin, "string");
			String enchname = Painter.paint(EnchLore);
			item2meta.getPersistentDataContainer().set(string, PersistentDataType.STRING, enchname);
			if (item2meta.getPersistentDataContainer().get(key, Enchants) == null) {
				HashMap<String, Integer> enchs = new HashMap<String, Integer>();
				enchs.put(Enchant, chance2);

				item2meta.addEnchant(vanilla, chance2, true);
				item2meta.getPersistentDataContainer().set(key, Enchants, enchs);
			} else {
				HashMap<String, Integer> enchs = item2meta.getPersistentDataContainer().get(key, Enchants);
				enchs.put(Enchant, chance2);

				item2meta.addEnchant(vanilla, chance2, true);
				item2meta.getPersistentDataContainer().set(key, Enchants, enchs);
			}
			item2meta.setLore(itemLore);
			item.setItemMeta(item2meta);
			p.getInventory().addItem(item);
			p.getOpenInventory().setItem(31, null);
			p.playSound(p, Sound.ITEM_TRIDENT_THUNDER, 3, 1.7f);
		}
	}

	public  void createEnchantVanilla(int chance, ItemStack item, Player p, int chance2, int enchFor,
			String Enchant, String EnchLore, String noEnch, Enchantment vanilla, String type) {
		NamespacedKey key = new NamespacedKey(plugin, "Enchants");
		if (item.getItemMeta().getPersistentDataContainer().get(key, Enchants) != null) {
			if (item.getItemMeta().getPersistentDataContainer().get(key, Enchants).containsKey(Enchant)
					|| (item.getItemMeta().getPersistentDataContainer().get(key, Enchants).containsKey(noEnch))) {
				chance += 1;
			} else {
				p.setLevel(p.getLevel() - 5);
				List<String> itemLore = item.getItemMeta().getLore();
				ItemMeta item2meta = item.getItemMeta();
				for (int i = 0; i < itemLore.size(); i++) {
					String lValue = itemLore.get(i);
					if (lValue.equals(Painter.paint("&8<Boş Büyü Bölmesi>"))) {
						itemLore.set(i, Painter.paint(EnchLore + chance2));
						break;
					}
				}
				NamespacedKey string = new NamespacedKey(plugin, "string");
				String enchname = Painter.paint(EnchLore);
				NamespacedKey enchanttype = new NamespacedKey(plugin, "enchantType");
				item2meta.getPersistentDataContainer().set(enchanttype, PersistentDataType.STRING, type);
				item2meta.getPersistentDataContainer().set(string, PersistentDataType.STRING, enchname);
				if (item2meta.getPersistentDataContainer().get(key, Enchants) == null) {
					HashMap<String, Integer> enchs = new HashMap<String, Integer>();
					enchs.put(Enchant, chance2);

					item2meta.addEnchant(vanilla, chance2, true);
					item2meta.getPersistentDataContainer().set(key, Enchants, enchs);
				} else {
					HashMap<String, Integer> enchs = item2meta.getPersistentDataContainer().get(key, Enchants);
					enchs.put(Enchant, chance2);

					item2meta.addEnchant(vanilla, chance2, true);
					item2meta.getPersistentDataContainer().set(key, Enchants, enchs);
				}

				item2meta.setLore(itemLore);
				item.setItemMeta(item2meta);
				p.getInventory().addItem(item);
				p.getOpenInventory().setItem(31, null);
				p.playSound(p, Sound.ITEM_TRIDENT_THUNDER, 3, 1.7f);
			}
		} else {
			p.setLevel(p.getLevel() - 5);
			List<String> itemLore = item.getItemMeta().getLore();
			ItemMeta item2meta = item.getItemMeta();
			for (int i = 0; i < itemLore.size(); i++) {
				String lValue = itemLore.get(i);
				if (lValue.equals(Painter.paint("&8<Boş Büyü Bölmesi>"))) {
					itemLore.set(i, Painter.paint(EnchLore + chance2));
					break;
				}
			}
			NamespacedKey string = new NamespacedKey(plugin, "string");
			String enchname = Painter.paint(EnchLore);
			item2meta.getPersistentDataContainer().set(string, PersistentDataType.STRING, enchname);
			if (item2meta.getPersistentDataContainer().get(key, Enchants) == null) {
				HashMap<String, Integer> enchs = new HashMap<String, Integer>();
				enchs.put(Enchant, chance2);

				item2meta.addEnchant(vanilla, chance2, true);
				item2meta.getPersistentDataContainer().set(key, Enchants, enchs);
			} else {
				HashMap<String, Integer> enchs = item2meta.getPersistentDataContainer().get(key, Enchants);
				enchs.put(Enchant, chance2);

				item2meta.addEnchant(vanilla, chance2, true);
				item2meta.getPersistentDataContainer().set(key, Enchants, enchs);
			}

			item2meta.setLore(itemLore);
			item.setItemMeta(item2meta);
			p.getInventory().addItem(item);
			p.getOpenInventory().setItem(31, null);
			p.playSound(p, Sound.ITEM_TRIDENT_THUNDER, 3, 1.7f);
		}

	}

	public  void createEnchantVanilla(int chance, ItemStack item, Player p, int chance2, int enchFor,
			String Enchant, String EnchLore, Enchantment vanilla, String type) {
		NamespacedKey key = new NamespacedKey(plugin, "Enchants");
		if (item.getItemMeta().getPersistentDataContainer().get(key, Enchants) != null
				&& (item.getItemMeta().getPersistentDataContainer().get(key, Enchants).containsKey(Enchant))) {
			chance += 1;
		} else {
			p.setLevel(p.getLevel() - 5);
			List<String> itemLore = item.getItemMeta().getLore();
			ItemMeta item2meta = item.getItemMeta();
			for (int i = 0; i < itemLore.size(); i++) {
				String lValue = itemLore.get(i);
				if (lValue.equals(Painter.paint("&8<Boş Büyü Bölmesi>"))) {
					itemLore.set(i, Painter.paint(EnchLore + chance2));
					break;
				}
			}
			NamespacedKey string = new NamespacedKey(plugin, "string");
			String enchname = Painter.paint(EnchLore);
			NamespacedKey enchanttype = new NamespacedKey(plugin, "enchantType");
			item2meta.getPersistentDataContainer().set(enchanttype, PersistentDataType.STRING, type);
			item2meta.getPersistentDataContainer().set(string, PersistentDataType.STRING, enchname);
			if (item2meta.getPersistentDataContainer().get(key, Enchants) == null) {
				HashMap<String, Integer> enchs = new HashMap<String, Integer>();
				enchs.put(Enchant, chance2);

				item2meta.addEnchant(vanilla, chance2, true);
				item2meta.getPersistentDataContainer().set(key, Enchants, enchs);
			} else {
				HashMap<String, Integer> enchs = item2meta.getPersistentDataContainer().get(key, Enchants);
				enchs.put(Enchant, chance2);

				item2meta.addEnchant(vanilla, chance2, true);
				item2meta.getPersistentDataContainer().set(key, Enchants, enchs);
			}

			item2meta.setLore(itemLore);
			item.setItemMeta(item2meta);
			p.getInventory().addItem(item);
			p.getOpenInventory().setItem(31, null);
			p.playSound(p, Sound.ITEM_TRIDENT_THUNDER, 3, 1.7f);
		}

	}
}
