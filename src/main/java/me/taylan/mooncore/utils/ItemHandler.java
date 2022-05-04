package me.taylan.mooncore.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.animations.SmithAnim;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.md_5.bungee.api.ChatColor;

public class ItemHandler {
	private MoonCore main;
	private SmithAnim smithAnim;
	private StatsManager stats;
	private List<String> lore = new ArrayList<>();

	public ItemHandler(MoonCore main) {
		this.main = main;
		this.smithAnim = main.getSmithAnim();
		this.stats = main.getStatsManager();

	}

	@SuppressWarnings("deprecation")
	public ItemStack createItem(Inventory inv, String materialString, int amount, int invSlot, String displayName,
			String... loreString) {

		ItemStack item = new ItemStack(Material.matchMaterial(materialString), amount);
		List<String> lore = new ArrayList<>();
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.setDisplayName(Painter.paint(displayName));
		for (String s : loreString) {
			lore.add(Painter.paint(s));
		}
		meta.setLore(lore);
		item.setItemMeta(meta);
		inv.setItem(invSlot - 1, item);
		return item;
	}

	public void addEnchantSlot(ItemStack item, int slotNumber, List<String> Loreknk) {
		ItemStack itemStack = item;
		NamespacedKey key = new NamespacedKey(main, "enchantSlots");
		ItemMeta itemMeta = itemStack.getItemMeta();
		PersistentDataContainer container = itemMeta.getPersistentDataContainer();
		container.set(key, PersistentDataType.INTEGER, slotNumber);
		for (int i = 0; i < slotNumber; i++) {
			Loreknk.add(Painter.paint("&8<Boş Büyü Bölmesi>"));
		}

	}

	public void createSword(Player p, ItemStack ingrident, int amount, ItemStack item, String name, int tierNumber,
			int defaulthasar, boolean el, Double atkspeed, String knockback, int weight, int producttime, int exp,
			int plevel) {

		ItemMeta meta = item.getItemMeta();
		NamespacedKey key2 = new NamespacedKey(main, "enchantType");

		PersistentDataContainer container = meta.getPersistentDataContainer();
		container.set(key2, PersistentDataType.STRING, item.getType().toString());

		String toolType = item.getType().toString();
		int level = p.getLevel();
		ItemStack stick = new ItemStack(Material.STICK);
		stick.setAmount(1);
		ingrident.setAmount(amount);
		if (p.getInventory().containsAtLeast(ingrident, amount) && p.getInventory().containsAtLeast(stick, 1)
				&& level >= plevel) {
			p.getInventory().removeItem(ingrident);
			p.getInventory().removeItem(stick);
			p.setLevel(level - plevel);
			p.closeInventory();
			double atkDamage = p.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).getValue();
			double realAtkSpeed = p.getAttribute(Attribute.GENERIC_ATTACK_SPEED).getValue();
			realAtkSpeed = 0;
			int realDamage = (int) (defaulthasar - atkDamage);

			meta.setDisplayName(Painter.paint(name + " &3[&bT" + tierNumber + "&3]"));
			NamespacedKey key = new NamespacedKey(main, "Name");
			NamespacedKey hasar = new NamespacedKey(main, "damage");
			NamespacedKey hasarreal = new NamespacedKey(main, "damagereal");
			NamespacedKey etype = new NamespacedKey(main, "enchantType");
			NamespacedKey weightitm = new NamespacedKey(main, "weightitm");
			NamespacedKey attackspeed = new NamespacedKey(main, "attackspeed");
			container.set(hasarreal, PersistentDataType.INTEGER, defaulthasar);
			container.set(etype, PersistentDataType.STRING, "sword");
			container.set(key, PersistentDataType.STRING, Painter.paint(name + " &3[&bT" + tierNumber + "&3]"));

			if (el) {
				lore.add(Painter.paint("&7(Sağ El)"));
			} else {
				lore.add(Painter.paint("&7(Sol El)"));
			}
			lore.add("");
			if (defaulthasar <= 8) {
				lore.add(Painter.paint("&a " + realDamage + "-" + defaulthasar + " &cHasar"));
				container.set(hasar, PersistentDataType.STRING,
						Painter.paint("&a " + realDamage + "-" + defaulthasar + " &cHasar"));
			} else if (defaulthasar >= 10) {
				lore.add(Painter.paint("&e " + realDamage + "-" + defaulthasar + " &cHasar"));
				container.set(hasar, PersistentDataType.STRING,
						Painter.paint("&e " + realDamage + "-" + defaulthasar + " &cHasar"));
			} else if (defaulthasar >= 20) {
				lore.add(Painter.paint("&c " + realDamage + "-" + defaulthasar + " &cHasar"));
				container.set(hasar, PersistentDataType.STRING,
						Painter.paint("&c " + realDamage + "-" + defaulthasar + " &cHasar"));
			} else if (defaulthasar >= 20) {
				lore.add(Painter.paint("&4 " + realDamage + "-" + defaulthasar + " &cHasar"));
				container.set(hasar, PersistentDataType.STRING,
						Painter.paint("&4 " + realDamage + "-" + defaulthasar + " &cHasar"));
			}
			if (atkspeed <= 0.5) {
				lore.add(Painter.paint("&a " + atkspeed + " &3Saldırı Hızı"));
				container.set(attackspeed, PersistentDataType.STRING,
						Painter.paint("&a " + atkspeed + " &3Saldırı Hızı"));
			} else if (defaulthasar >= 1) {
				lore.add(Painter.paint("&e " + atkspeed + " &3Saldırı Hızı"));
				container.set(attackspeed, PersistentDataType.STRING,
						Painter.paint("&e " + atkspeed + " &3Saldırı Hızı"));
			} else if (defaulthasar >= 1.5) {
				lore.add(Painter.paint("&c " + atkspeed + " &3Saldırı Hızı"));
				container.set(attackspeed, PersistentDataType.STRING,
						Painter.paint("&c " + atkspeed + " &3Saldırı Hızı"));
			} else if (defaulthasar >= 2) {
				lore.add(Painter.paint("&4 " + atkspeed + " &3Saldırı Hızı"));
				container.set(attackspeed, PersistentDataType.STRING,
						Painter.paint("&4 " + atkspeed + " &3Saldırı Hızı"));
			}
			if (knockback.equalsIgnoreCase("Düşük")) {
				lore.add(Painter.paint("&a " + knockback + " &9Savurma"));
				item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 1);
			} else if (knockback.equalsIgnoreCase("Orta")) {
				lore.add(Painter.paint("&e " + knockback + " &9Savurma"));
				item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
			} else if (knockback.equalsIgnoreCase("Yüksek")) {
				lore.add(Painter.paint("&c " + knockback + " &9Savurma"));
				item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
			}
			lore.add("");
			lore.add(Painter.paint("&8<Boş Büyü Bölmesi>"));
			addEnchantSlot(item, tierNumber, lore);
			lore.add("");
			lore.add(Painter.paint("&8Ekipman Tipi: " + "&OKılıç"));
			lore.add(Painter.paint("&8&o*" + "Ağırlık: " + weight + "*"));
			container.set(weightitm, PersistentDataType.INTEGER, weight);
			AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", defaulthasar,
					AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
			meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
			AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -atkspeed,
					AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
			meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
			meta.setLore(lore);
			meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			item.setItemMeta(meta);

			lore.clear();
			ItemStack pre = item.clone();
			ItemMeta meta2 = pre.getItemMeta();
			lore.add(ChatColor.GRAY + " ???");
			lore.add(ChatColor.GRAY + " ???");
			lore.add(ChatColor.GRAY + " ???");
			meta2.setLore(lore);
			pre.setItemMeta(meta2);
			lore.clear();
			int timer = stats.getProduction(p.getUniqueId());
			int timerlvl10 = stats.getProduction1(p.getUniqueId());
			int smithLevel = stats.getSmithLevel(p.getUniqueId());
			if (timer <= 0) {
				smithAnim.smithAnimation(p, producttime, item, exp);
				main.getGuiHandler().getInv6().setItem(12, pre);
			} else if (timerlvl10 <= 0) {
				if (smithLevel >= 10) {
					timerlvl10++;
					stats.setProduction1(p.getUniqueId(), timerlvl10);
					smithAnim.smithAnimation(p, producttime, item, exp);
					main.getGuiHandler().getInv6().setItem(14, pre);
				}
			}

		} else {
			p.sendMessage(Painter.paint("&cMalzemelerin eksik."));
		}

	}

	public void createAxe(Player p, ItemStack ingrident, int amount, ItemStack item, String name, int tierNumber,
			int defaulthasar, boolean el, Double atkspeed, String knockback, int weight, int producttime, int exp,
			int plevel) {
		NamespacedKey key2 = new NamespacedKey(main, "enchantType");
		ItemMeta meta = item.getItemMeta();
		PersistentDataContainer container2 = meta.getPersistentDataContainer();
		container2.set(key2, PersistentDataType.STRING, item.getType().toString());

		int level = p.getLevel();
		ItemStack stick = new ItemStack(Material.STICK);
		stick.setAmount(2);
		ingrident.setAmount(amount);
		if (p.getInventory().containsAtLeast(ingrident, amount) && p.getInventory().containsAtLeast(stick, 2)
				&& level >= plevel) {
			p.getInventory().removeItem(ingrident);
			p.getInventory().removeItem(stick);
			p.setLevel(level - plevel);
			p.closeInventory();
			double atkDamage = p.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).getValue();
			double realAtkSpeed = p.getAttribute(Attribute.GENERIC_ATTACK_SPEED).getValue();
			realAtkSpeed = 0;
			int realDamage = (int) (defaulthasar - atkDamage);

			meta.setDisplayName(Painter.paint(name + " &3[&bT" + tierNumber + "&3]"));
			NamespacedKey key = new NamespacedKey(main, "Name");
			PersistentDataContainer container = meta.getPersistentDataContainer();
			container.set(key, PersistentDataType.STRING, Painter.paint(name + " &3[&bT" + tierNumber + "&3]"));

			if (el) {
				lore.add(Painter.paint("&7(Sağ El)"));
			} else {
				lore.add(Painter.paint("&7(Sol El)"));
			}
			lore.add("");
			if (defaulthasar <= 8) {
				lore.add(Painter.paint("&a " + realDamage + "-" + defaulthasar + " &cHasar"));
			} else if (defaulthasar >= 10) {
				lore.add(Painter.paint("&e " + realDamage + "-" + defaulthasar + 3 + " &cHasar"));
			} else if (defaulthasar >= 20) {
				lore.add(Painter.paint("&c " + realDamage + "-" + defaulthasar + 3 + " &cHasar"));
			} else if (defaulthasar >= 20) {
				lore.add(Painter.paint("&4 " + realDamage + "-" + defaulthasar + 3 + " &cHasar"));
			}
			if (atkspeed <= 0.5) {
				lore.add(Painter.paint("&a " + atkspeed + " &3Saldırı Hızı"));
			} else if (defaulthasar >= 1) {
				lore.add(Painter.paint("&e " + atkspeed + " &3Saldırı Hızı"));
			} else if (defaulthasar >= 1.5) {
				lore.add(Painter.paint("&c " + atkspeed + " &3Saldırı Hızı"));
			} else if (defaulthasar >= 2) {
				lore.add(Painter.paint("&4 " + atkspeed + " &3Saldırı Hızı"));
			}
			if (knockback.equalsIgnoreCase("Düşük")) {
				lore.add(Painter.paint("&a " + knockback + " &9Savurma"));
				item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 1);
			} else if (knockback.equalsIgnoreCase("Orta")) {
				lore.add(Painter.paint("&e " + knockback + " &9Savurma"));
				item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
			} else if (knockback.equalsIgnoreCase("Yüksek")) {
				lore.add(Painter.paint("&c " + knockback + " &9Savurma"));
				item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
			}
			lore.add("");
			lore.add(Painter.paint("&8<Boş Büyü Bölmesi>"));
			addEnchantSlot(item, tierNumber, lore);
			lore.add("");
			lore.add(Painter.paint("&8Ekipman Tipi: " + "&OBalta"));
			lore.add(Painter.paint("&8&o*" + "Ağırlık: " + weight + "*"));
			NamespacedKey weightitm = new NamespacedKey(main, "weightitm");
			container.set(weightitm, PersistentDataType.INTEGER, weight);
			AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", realDamage,
					AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
			meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
			AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -atkspeed,
					AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
			meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
			meta.setLore(lore);
			meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			item.setItemMeta(meta);

			lore.clear();
			ItemStack pre = item.clone();
			ItemMeta meta2 = pre.getItemMeta();
			lore.add(ChatColor.GRAY + " ???");
			lore.add(ChatColor.GRAY + " ???");
			lore.add(ChatColor.GRAY + " ???");
			meta2.setLore(lore);
			pre.setItemMeta(meta2);
			lore.clear();
			int timer = stats.getProduction(p.getUniqueId());
			int timerlvl10 = stats.getProduction1(p.getUniqueId());
			int smithLevel = stats.getSmithLevel(p.getUniqueId());
			if (timer <= 0) {
				smithAnim.smithAnimation(p, producttime, item, exp);
				main.getGuiHandler().getInv6().setItem(12, pre);
			} else if (timerlvl10 <= 0) {
				if (smithLevel >= 10) {
					timerlvl10++;
					stats.setProduction1(p.getUniqueId(), timerlvl10);
					smithAnim.smithAnimation(p, producttime, item, exp);
					main.getGuiHandler().getInv6().setItem(14, pre);
				}
			}

		} else {
			p.sendMessage(Painter.paint("&cMalzemelerin eksik."));
		}
	}

	public void createCrossbow(Player p, ItemStack ingrident, int amount, ItemStack item, String name, int tierNumber,
			int defaulthasar, boolean el, String knockback, int weight, int producttime, int exp, int plevel) {
		NamespacedKey key2 = new NamespacedKey(main, "enchantType");
		ItemMeta meta = item.getItemMeta();
		PersistentDataContainer container = meta.getPersistentDataContainer();
		container.set(key2, PersistentDataType.STRING, item.getType().toString());

		int level = p.getLevel();
		ItemStack stick = new ItemStack(Material.STICK);
		stick.setAmount(2);
		ingrident.setAmount(amount);
		if (p.getInventory().containsAtLeast(ingrident, amount) && p.getInventory().containsAtLeast(stick, 2)
				&& level >= plevel) {
			p.getInventory().removeItem(ingrident);
			p.getInventory().removeItem(stick);
			p.setLevel(level - plevel);
			p.closeInventory();
			double atkDamage = p.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).getValue();
			int realDamage = (int) (defaulthasar - atkDamage);

			meta.setDisplayName(Painter.paint(name + " &3[&bT" + tierNumber + "&3]"));
			NamespacedKey key = new NamespacedKey(main, "Name");
			container.set(key, PersistentDataType.STRING, Painter.paint(name + " &3[&bT" + tierNumber + "&3]"));

			if (el) {
				lore.add(Painter.paint("&7(Sağ El)"));
			} else {
				lore.add(Painter.paint("&7(Sol El)"));
			}
			lore.add("");
			if (defaulthasar <= 8) {
				lore.add(Painter.paint("&a " + realDamage + "-" + defaulthasar + " &cHasar"));
			} else if (defaulthasar >= 10) {
				lore.add(Painter.paint("&e " + realDamage + "-" + defaulthasar + 3 + " &cHasar"));
			} else if (defaulthasar >= 20) {
				lore.add(Painter.paint("&c " + realDamage + "-" + defaulthasar + 3 + " &cHasar"));
			} else if (defaulthasar >= 20) {
				lore.add(Painter.paint("&4 " + realDamage + "-" + defaulthasar + 3 + " &cHasar"));
			}
			lore.add("");
			lore.add(Painter.paint("&8<Boş Büyü Bölmesi>"));
			addEnchantSlot(item, tierNumber, lore);
			lore.add("");
			lore.add(Painter.paint("&8Ekipman Tipi: " + "&OArbalet"));
			lore.add(Painter.paint("&8&o*" + "Ağırlık: " + weight + "*"));
			NamespacedKey weightitm = new NamespacedKey(main, "weightitm");
			container.set(weightitm, PersistentDataType.INTEGER, weight);
			AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", realDamage,
					AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
			meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
			meta.setLore(lore);
			meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			item.setItemMeta(meta);

			lore.clear();
			ItemStack pre = item.clone();
			ItemMeta meta2 = pre.getItemMeta();
			lore.add(ChatColor.GRAY + " ???");
			lore.add(ChatColor.GRAY + " ???");
			lore.add(ChatColor.GRAY + " ???");
			meta2.setLore(lore);
			pre.setItemMeta(meta2);
			lore.clear();
			int timer = stats.getProduction(p.getUniqueId());
			int timerlvl10 = stats.getProduction1(p.getUniqueId());
			int smithLevel = stats.getSmithLevel(p.getUniqueId());
			if (timer <= 0) {
				smithAnim.smithAnimation(p, producttime, item, exp);
				main.getGuiHandler().getInv6().setItem(12, pre);
			} else if (timerlvl10 <= 0) {
				if (smithLevel >= 10) {
					timerlvl10++;
					stats.setProduction1(p.getUniqueId(), timerlvl10);
					smithAnim.smithAnimation(p, producttime, item, exp);
					main.getGuiHandler().getInv6().setItem(14, pre);
				}
			}

		} else {
			p.sendMessage(Painter.paint("&cMalzemelerin eksik."));
		}
	}

	public void createArmor(Player p, String type, EquipmentSlot slot, ItemStack ingrident, int amount, ItemStack item,
			String name, int tierNumber, int defaulthasar, String knockback, int weight, int producttime, int exp,
			int plevel) {
		int level = p.getLevel();
		ItemMeta meta = item.getItemMeta();
		NamespacedKey key2 = new NamespacedKey(main, "enchantType");

		PersistentDataContainer container = meta.getPersistentDataContainer();
		container.set(key2, PersistentDataType.STRING, item.getType().toString());

		if (p.getInventory().containsAtLeast(ingrident, amount) && level >= plevel) {
			p.getInventory().removeItem(ingrident);
			p.setLevel(level - plevel);
			p.closeInventory();
			double atkDamage = p.getAttribute(Attribute.GENERIC_ARMOR).getValue();

			meta.setDisplayName(Painter.paint(name + " &3[&bT" + tierNumber + "&3]"));
			NamespacedKey key = new NamespacedKey(main, "Name");

			container.set(key, PersistentDataType.STRING, Painter.paint(name + " &3[&bT" + tierNumber + "&3]"));

			lore.add("");
			if (defaulthasar <= 8) {
				lore.add(Painter.paint("&a " + defaulthasar + " &cZırh"));
			} else if (defaulthasar >= 10) {
				lore.add(Painter.paint("&e " + defaulthasar + " &cZırh"));
			} else if (defaulthasar >= 20) {
				lore.add(Painter.paint("&c " + defaulthasar + " &cZırh"));
			} else if (defaulthasar >= 20) {
				lore.add(Painter.paint("&4 " + defaulthasar + " &cZırh"));
			}
			lore.add("");
			lore.add(Painter.paint("&8<Boş Büyü Bölmesi>"));
			addEnchantSlot(item, tierNumber, lore);
			lore.add("");
			lore.add(Painter.paint("&8Ekipman Tipi: " + type));
			lore.add(Painter.paint("&8&o*" + "Ağırlık: " + weight + "*"));
			NamespacedKey weightitm = new NamespacedKey(main, "weightitm");
			container.set(weightitm, PersistentDataType.INTEGER, weight);
			AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.armor", defaulthasar,
					AttributeModifier.Operation.ADD_NUMBER, slot);
			meta.addAttributeModifier(Attribute.GENERIC_ARMOR, damage);
			meta.setLore(lore);
			meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			item.setItemMeta(meta);

			lore.clear();
			ItemStack pre = item.clone();
			ItemMeta meta2 = pre.getItemMeta();
			lore.add(ChatColor.GRAY + " ???");
			lore.add(ChatColor.GRAY + " ???");
			lore.add(ChatColor.GRAY + " ???");
			meta2.setLore(lore);
			pre.setItemMeta(meta2);
			lore.clear();
			int timer = stats.getProduction(p.getUniqueId());
			int timerlvl10 = stats.getProduction1(p.getUniqueId());
			int smithLevel = stats.getSmithLevel(p.getUniqueId());
			if (timer <= 0) {
				smithAnim.smithAnimation(p, producttime, item, exp);
				main.getGuiHandler().getInv6().setItem(12, pre);
			} else if (timerlvl10 <= 0) {
				if (smithLevel >= 10) {
					timerlvl10++;
					stats.setProduction1(p.getUniqueId(), timerlvl10);
					smithAnim.smithAnimation(p, producttime, item, exp);
					main.getGuiHandler().getInv6().setItem(14, pre);
				}
			}

		} else {
			p.sendMessage(Painter.paint("&cMalzemelerin eksik."));

		}
	}

	public ItemStack woodKutu() {
		ItemStack item = new ItemStack(Material.BARREL, 1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(Painter.paint("&6Tahta Kutu"));
		List<String> lore = new ArrayList<>();
		lore.add("");
		lore.add(Painter.paint("&8Şunlardan birini içerir:"));
		lore.add(Painter.paint("&7✦ &fDemir Külçesi"));
		lore.add(Painter.paint("&7✦ &6Bronz Madeni"));
		lore.add(Painter.paint("&7✦ &aBalıkçı Ekipmanı Parçası"));
		lore.add(Painter.paint("&7✦ &dRastgele Bir Mühür Parçası"));
		lore.add(Painter.paint("&7✦ &8Deniz Çöpü"));
		lore.add("");
		lore.add(Painter.paint("&8Kutuyu açmak için elinde iken"));
		lore.add(Painter.paint("&e&lSağ Tıkla"));
		meta.setLore(lore);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		item.setItemMeta(meta);
		return item;

	}
	public ItemStack ironKutu() {
		ItemStack item = new ItemStack(Material.LODESTONE, 1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(Painter.paint("&fDemir Kutu"));
		PersistentDataContainer container = meta.getPersistentDataContainer();
		NamespacedKey kutu = new NamespacedKey(main, "kutu");
		container.set(kutu, PersistentDataType.STRING, "kutu");
		List<String> lore = new ArrayList<>();
		lore.add("");
		lore.add(Painter.paint("&8Şunlardan birini içerir:"));
		lore.add(Painter.paint("&7✦ &fDemir Külçesi"));
		lore.add(Painter.paint("&7✦ &8Zincir"));
		lore.add(Painter.paint("&7✦ &7Gümüşbalığı"));
		lore.add(Painter.paint("&4✦ &eRünik Kalıntı"));
		lore.add(Painter.paint("&8✦ &8Gümüş Aksesuar Parçası"));
		lore.add(Painter.paint("&7✦ &aBalıkçı Ekipmanı Parçası"));
		lore.add(Painter.paint("&7✦ &dRastgele Bir Mühür Parçası"));
		lore.add(Painter.paint("&7✦ &8Deniz Çöpü"));
		lore.add("");
		lore.add(Painter.paint("&8Kutuyu açmak için elinde iken"));
		lore.add(Painter.paint("&e&lSağ Tıkla"));
		meta.setLore(lore);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		item.setItemMeta(meta);
		return item;

	}
	public ItemStack goldKutu() {
		ItemStack item = new ItemStack(Material.HONEYCOMB_BLOCK, 1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(Painter.paint("&eAltın Kutu"));
		PersistentDataContainer container = meta.getPersistentDataContainer();
		NamespacedKey kutu = new NamespacedKey(main, "kutu");
		container.set(kutu, PersistentDataType.STRING, "kutu");
		List<String> lore = new ArrayList<>();
		lore.add("");
		lore.add(Painter.paint("&8Şunlardan birini içerir:"));
		lore.add(Painter.paint("&e✦ &fAltın Külçesi"));
		lore.add(Painter.paint("&6✦ &eDev Anahtar"));
		lore.add(Painter.paint("&b✦ &6Parıldak"));
		lore.add(Painter.paint("&3✦ &2Demirdövüm Ekspertizörü"));
		lore.add(Painter.paint("&4✦ &eRünik Kalıntı"));
		lore.add(Painter.paint("&3✦ &aBalık Adam Pulu"));
		lore.add(Painter.paint("&7✦ &dRastgele Bir Mühür Parçası"));
		lore.add(Painter.paint("&7✦ &8Deniz Çöpü"));
		lore.add("");
		lore.add(Painter.paint("&8Kutuyu açmak için elinde iken"));
		lore.add(Painter.paint("&e&lSağ Tıkla"));
		meta.setLore(lore);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		item.setItemMeta(meta);
		return item;

	}
	public ItemStack mistikKutu() {
		ItemStack item = new ItemStack(Material.RESPAWN_ANCHOR, 1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(Painter.paint("&dMistik Kutu"));
		PersistentDataContainer container = meta.getPersistentDataContainer();
		NamespacedKey kutu = new NamespacedKey(main, "kutu");
		container.set(kutu, PersistentDataType.STRING, "kutu");
		List<String> lore = new ArrayList<>();
		lore.add("");
		lore.add(Painter.paint("&8Şunlardan birini içerir:"));
		lore.add(Painter.paint("&d✦ &dAmetist"));
		lore.add(Painter.paint("&b✦ &6Parıldak"));
		lore.add(Painter.paint("&b✦ &5Mistik Toz"));
		lore.add(Painter.paint("&7✦ &cRastgele Lanetli Büyü"));
		lore.add(Painter.paint("&7✦ &cVelimoth Pulu"));
		lore.add(Painter.paint("&7✦ &3Sezgi Cevheri"));
		lore.add(Painter.paint("&7✦ &fParlak İnci"));
		lore.add(Painter.paint("&3✦ &aBalık Adam Pulu"));
		lore.add(Painter.paint("&7✦ &dRastgele Bir Mühür Parçası"));
		lore.add(Painter.paint("&7✦ &8Deniz Çöpü"));
		lore.add("");
		lore.add(Painter.paint("&8Kutuyu açmak için elinde iken"));
		lore.add(Painter.paint("&e&lSağ Tıkla"));
		meta.setLore(lore);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		item.setItemMeta(meta);
		return item;

	}
	public ItemStack cicekkolye() {
		ItemStack item = new ItemStack(Material.DANDELION, 1);
		ItemMeta meta = item.getItemMeta();
		PersistentDataContainer container = meta.getPersistentDataContainer();
		NamespacedKey type = new NamespacedKey(main, "type");
		NamespacedKey name = new NamespacedKey(main, "name");
		NamespacedKey can = new NamespacedKey(main, "can");
		NamespacedKey hiz = new NamespacedKey(main, "hiz");
		container.set(can, PersistentDataType.INTEGER, 5);
		container.set(hiz, PersistentDataType.INTEGER, 10);
		container.set(type, PersistentDataType.STRING, "kolye");

		String nameitem = Painter.paint("&6Cicek Kolyesi &3[&BT1&3]");
		container.set(name, PersistentDataType.STRING, nameitem);
		meta.setDisplayName(nameitem);
		List<String> lore = new ArrayList<>();
		lore.add("");
		lore.add(Painter.paint(" &cCan +5"));
		lore.add("");
		lore.add(Painter.paint("&8Ekipman Tipi: Kolye"));
		meta.setLore(lore);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		item.setItemMeta(meta);
		return item;

	}

	public ItemStack celikzirh() {
		ItemStack item = new ItemStack(Material.IRON_CHESTPLATE, 1);
		ItemMeta meta = item.getItemMeta();
		PersistentDataContainer container = meta.getPersistentDataContainer();
		meta.displayName(
				MiniMessage.get().parse("<gradient:yellow:gold>Çelik Kaplamalı Zırh <dark_aqua>[<aqua>T3<dark_aqua>]"));
		List<String> lore = new ArrayList<>();
		lore.add("");
		lore.add(Painter.paint(" &cCan: &f+5"));
		lore.add(Painter.paint(" &bZırh: &f+2 &8[&7+3&8]"));
		lore.add(Painter.paint(" &4Güç: &f+2"));
		lore.add(Painter.paint(" &eDenge: &f+2"));
		lore.add("");
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, false);
		addEnchantSlot(item, 3, lore);
		lore.add("");
		lore.add(Painter.paint("&8Ekipman Tipi: Göğüslük"));
		lore.add(Painter.paint("&8&o*Ağırlık: 20*"));
		meta.setLore(lore);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;

	}
}
