package me.taylan.mooncore.utils;

import me.taylan.mooncore.MoonCore;
import net.kyori.adventure.text.minimessage.MiniMessage;
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


		if(chance2<3) {
			ItemStack loot5 = itemHandler.shinyenderpearl;
			list.add(loot5);
		}
		if(chance2==5) {
			ItemStack loot6 = itemHandler.woodKutu();
			list.add(loot6);
		}
		list.add(itemHandler.silverore);
		list.add(itemHandler.zincirlenmisgogusluk);
		list.add(itemHandler.delinmiscarik);
		list.add(itemHandler.experiencebottle);
		return list;
	}
	public void rename(ItemStack item, String s) {
		ItemMeta meta = item.getItemMeta();
		meta.displayName(MiniMessage.miniMessage().deserialize(Painter.paint(s)));
		item.setItemMeta(meta);
	}
}
