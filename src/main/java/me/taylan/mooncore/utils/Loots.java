package me.taylan.mooncore.utils;

import me.taylan.mooncore.MoonCore;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Loots {

	private MoonCore plugin;
	private ItemHandler itemHandler;

	public Loots(MoonCore plugin) {
		this.plugin = plugin;
		this.itemHandler = plugin.getItemHandler();
	}

	public List<ItemStack> ormanLoot() {
		List<ItemStack> list = new ArrayList<>();
		int chance = ThreadLocalRandom.current().nextInt(6);
		ItemStack loot1 = new ItemStack(Material.EMERALD, chance);
		rename(loot1, "&aSaf Zümrüt");
		ItemStack loot2 = new ItemStack(Material.AMETHYST_SHARD, chance);
		rename(loot2, "&dAmetist Parçası");
		ItemStack loot3 = itemHandler.soulesans;
		list.add(loot1);
		list.add(loot2);
		list.add(loot3);
		return list;
	}
	public List<ItemStack> dungeonLoot() {
		List<ItemStack> list = new ArrayList<>();
		int chance = ThreadLocalRandom.current().nextInt(3);
		int chance2 = ThreadLocalRandom.current().nextInt(10);
		ItemStack loot1 = new ItemStack(Material.TRIPWIRE_HOOK, 1);
		rename(loot1, "&eGeçit Anahtarı");
		ItemStack loot2 = new ItemStack(Material.GOLD_INGOT, chance);
		rename(loot2, "&6Dirhem");
		ItemStack loot3 = new ItemStack(Material.ENDER_EYE, chance);
		rename(loot3, "&bRuh Bağı");
		ItemStack loot4 = new ItemStack(Material.BONE, chance);
		loot4.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1);
		loot4.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		rename(loot4, "&bBüyülü Kemik");
		if(chance2<3) {
			ItemStack loot5 = itemHandler.shinyenderpearl;
			list.add(loot5);
		}
		if(chance2==5) {
			ItemStack loot6 = itemHandler.woodKutu();
			list.add(loot6);
		}
		list.add(loot1);
		list.add(loot2);
		list.add(loot3);
		list.add(loot4);
		return list;
	}
	public void rename(ItemStack item, String s) {
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(Painter.paint(s));
		item.setItemMeta(meta);
	}
}
