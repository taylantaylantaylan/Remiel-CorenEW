package me.taylan.mooncore.level;

import java.util.HashMap;

import me.taylan.mooncore.MoonCore;

public class ExpList {
	private MoonCore plugin;

	public ExpList(MoonCore plugin) {
		this.plugin = plugin;

	}

	private static HashMap<String, Integer> expMap = new HashMap<>();

	public static HashMap<String, Integer> getExpMap() {
		return expMap;
	}


	public void expPut() {
		// MINING
		expMap.put("DIAMOND_ORE", 5);
		expMap.put("IRON_ORE", 3);
		expMap.put("GOLD_ORE", 4);
		expMap.put("REDSTONE_ORE", 2);
		expMap.put("NETHER_QUARTZ_ORE", 2);
		expMap.put("OBSIDIAN", 3);
		expMap.put("GRANITE", 1);
		expMap.put("COAL_ORE", 2);
		expMap.put("ANCIENT_DEBRIS", 10);
		expMap.put("STONE", 1);
		expMap.put("COBBLESTONE", 1);
		expMap.put("RAW_COPPER_BLOCK", 4);
		expMap.put("RAW_IRON_BLOCK", 5);
		expMap.put("DEEPSLATE_REDSTONE_ORE", 5);
		expMap.put("NETHER_QUARTZ_ORE", 5);
		expMap.put("LAPIS_ORE", 3);
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
		expMap.put("SPRUCE_WOOD", 4);
		expMap.put("BIRCH_WOOD", 3);
		expMap.put("JUNGLE_WOOD", 5);
		expMap.put("DARK_OAK_WOOD", 3);
		expMap.put("STRIPPED_DARK_OAK_WOOD", 4);
		expMap.put("ACACIA_WOOD", 5);
		expMap.put("OAK_WOOD", 1);
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

		// FARMING
		expMap.put("WHEAT", 3);
		expMap.put("PATATOES", 2);
		expMap.put("CARROTS", 2);
		expMap.put("BEETROOTS", 2);
		expMap.put("SUGAR_CANE", 3);
		expMap.put("CACTUS", 3);
		expMap.put("NETHER_WART", 4);
		expMap.put("RED_MUSHROOM", 2);
		expMap.put("BROWN_MUSHROOM", 2);
		expMap.put("PUMPKIN", 3);
		expMap.put("MELON", 3);
		expMap.put("SWEET_BERRIES", 3);

	}

}
