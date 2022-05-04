package me.taylan.mooncore.level;

import java.util.HashMap;

import me.taylan.mooncore.MoonCore;

public class ExpList {
	private MoonCore plugin;

	public ExpList(MoonCore plugin) {
		this.plugin = plugin;

	}

	private static HashMap<String, Integer> expMap = new HashMap<>();
	private static HashMap<String, String> ReforgeMap = new HashMap<>();

	public static HashMap<String, Integer> getExpMap() {
		return expMap;
	}

	public static HashMap<String, String> getReforgeMap() {
		return ReforgeMap;
	}

	public void expPut() {
		// MINING
		expMap.put("DIAMOND_ORE", 5);
		expMap.put("IRON_ORE", 3);
		expMap.put("GOLD_ORE", 3);
		expMap.put("REDSTONE_ORE", 2);
		expMap.put("NETHER_QUARTZ_ORE", 2);
		expMap.put("GRANITE", 1);
		expMap.put("COAL_ORE", 2);
		expMap.put("ANCIENT_DEBRIS", 10);
		expMap.put("STONE", 1);
		expMap.put("ANDESITE", 1);
		expMap.put("DIORITE", 1);
		expMap.put("LAPIS_ORE", 3);
		expMap.put("NETHERRACK", 1);
		// FISHING
		expMap.put("COD", 4);
		expMap.put("PUFFERFISH", 5);
		expMap.put("SALMON", 6);
		expMap.put("SADDLE", 10);
		expMap.put("ENCHANTED_BOOK", 20);
		expMap.put("LEATHER", 2);
		expMap.put("BOW", 15);
		expMap.put("LILY_PAD", 3);
		expMap.put("TROPICAL_FISH", 30);
		expMap.put("FISHING_ROD", 14);
		expMap.put("NAME_TAG", 2);
		expMap.put("TRIPWIRE_HOOK", 2);
		expMap.put("NAUTILUS_SHELL", 10);
		expMap.put("BONE", 1);
		// FORAGING
		expMap.put("OAK_WOOD", 2);
		expMap.put("SPRUCE_WOOD", 2);
		expMap.put("BIRCH_WOOD", 2);
		expMap.put("JUNGLE_WOOD", 2);
		expMap.put("DARK_OAK_WOOD", 2);
		expMap.put("ACACIA_WOOD", 2);
		expMap.put("OAK_WOOD", 2);
		expMap.put("OAK_LOG", 2);
		expMap.put("SPRUCE_LOG", 2);
		expMap.put("BIRCH_LOG", 2);
		expMap.put("JUNGLE_LOG", 2);
		expMap.put("DARK_OAK_LOG", 2);
		expMap.put("ACACIA_LOG", 2);
		expMap.put("OAK_LOG", 2);
		expMap.put("BREAD", 20);
		// BREWING
		expMap.put("SUGAR", 4);
		expMap.put("NETHER_WART", 3);
		expMap.put("BLAZE_POWDER", 4);
		expMap.put("GOLDEN_CARROT", 4);
		expMap.put("MAGMA_CREAM", 4);
		expMap.put("GLOWSTONE_DUST", 5);
		expMap.put("REDSTONE", 5);
		expMap.put("GUNPOWDER", 5);
		expMap.put("DRAGON_BREATH", 4);
		expMap.put("FERMENTED_SPIDER_EYE", 4);
		expMap.put("SPIDER_EYE", 4);
		// SMITHING
		expMap.put("IRON_SWORD", 40);
		expMap.put("GOLDEN_SWORD", 60);
		expMap.put("DIAMOND_SWORD", 80);
		expMap.put("NETHERITE_SWORD", 100);
		expMap.put("WOODEN_SWORD", 20);
		// FARMING
		expMap.put("WHEAT", 3);
		expMap.put("PATATOES", 2);
		expMap.put("CARROTS", 2);
		expMap.put("BEETROOTS", 2);
		expMap.put("SUGAR_CANE", 3);
		expMap.put("CACTUS", 3);
		expMap.put("NETHER_WART", 4);
		expMap.put("KELP_PLANT", 4);
		expMap.put("RED_MUSHROOM", 2);
		expMap.put("BROWN_MUSHROOM", 2);
		expMap.put("PUMPKIN", 3);
		expMap.put("MELON", 3);
		expMap.put("SWEET_BERRIES", 3);

		// REFORGEEEEEEEEEEEEEEEEEEEE
		ReforgeMap.put("IRON_SWORD", "IRON_INGOT");
		ReforgeMap.put("GOLDEN_SWORD", "GOLD_INGOT");
		ReforgeMap.put("DIAMOND_SWORD", "DIAMOND");
		ReforgeMap.put("NETHERITE_SWORD", "NETHERITE_INGOT");
		ReforgeMap.put("STONE_SWORD", "COBBLESTONE");
		ReforgeMap.put("WOODEN_SWORD", "COPPER_INGOT");

		ReforgeMap.put("IRON_PICKAXE", "IRON_INGOT");
		ReforgeMap.put("GOLDEN_PICKAXE", "GOLD_INGOT");
		ReforgeMap.put("DIAMOND_PICKAXE", "DIAMOND");
		ReforgeMap.put("NETHERITE_PICKAXE", "NETHERITE_INGOT");
		ReforgeMap.put("STONE_PICKAXE", "COBBLESTONE");
		ReforgeMap.put("WOODEN_PICKAXE", "COPPER_INGOT");

		ReforgeMap.put("IRON_AXE", "IRON_INGOT");
		ReforgeMap.put("GOLDEN_AXE", "GOLD_INGOT");
		ReforgeMap.put("DIAMOND_AXE", "DIAMOND");
		ReforgeMap.put("NETHERITE_AXE", "NETHERITE_INGOT");
		ReforgeMap.put("STONE_AXE", "COBBLESTONE");
		ReforgeMap.put("WOODEN_AXE", "COPPER_INGOT");

		ReforgeMap.put("IRON_CHESTPLATE", "IRON_INGOT");
		ReforgeMap.put("GOLDEN_CHESTPLATE", "GOLD_INGOT");
		ReforgeMap.put("DIAMOND_CHESTPLATE", "DIAMOND");
		ReforgeMap.put("NETHERITE_CHESTPLATE", "NETHERITE_INGOT");
		ReforgeMap.put("LEATHER_CHESTPLATE", "COPPER_INGOT");
		ReforgeMap.put("CHAINMAIL_CHESTPLATE", "CHAIN");

		ReforgeMap.put("IRON_HELMET", "IRON_INGOT");
		ReforgeMap.put("GOLDEN_HELMET", "GOLD_INGOT");
		ReforgeMap.put("DIAMOND_HELMET", "DIAMOND");
		ReforgeMap.put("NETHERITE_HELMET", "NETHERITE_INGOT");
		ReforgeMap.put("LEATHER_HELMET", "COPPER_INGOT");
		ReforgeMap.put("CHAINMAIL_HELMET", "CHAIN");

		ReforgeMap.put("IRON_LEGGINGS", "IRON_INGOT");
		ReforgeMap.put("GOLDEN_LEGGINGS", "GOLD_INGOT");
		ReforgeMap.put("DIAMOND_LEGGINGS", "DIAMOND");
		ReforgeMap.put("NETHERITE_LEGGINGS", "NETHERITE_INGOT");
		ReforgeMap.put("LEATHER_LEGGINGS", "COPPER_INGOT");
		ReforgeMap.put("CHAINMAIL_LEGGINGS", "CHAIN");

		ReforgeMap.put("IRON_BOOTS", "IRON_INGOT");
		ReforgeMap.put("GOLDEN_BOOTS", "GOLD_INGOT");
		ReforgeMap.put("DIAMOND_BOOTS", "DIAMOND");
		ReforgeMap.put("NETHERITE_BOOTS", "NETHERITE_INGOT");
		ReforgeMap.put("LEATHER_BOOTS", "COPPER_INGOT");
		ReforgeMap.put("CHAINMAIL_BOOTS", "CHAIN");

	}

}
