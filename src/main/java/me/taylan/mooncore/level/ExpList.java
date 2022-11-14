//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package me.taylan.mooncore.level;

import java.util.HashMap;
import me.taylan.mooncore.MoonCore;

public class ExpList {
private final MoonCore plugin;
	private static final HashMap<String, Integer> expMap = new HashMap<>();

	public ExpList(MoonCore plugin) {
		this.plugin = plugin;
	}

	public static HashMap<String, Integer> getExpMap() {
		return expMap;
	}

	public void expPut() {
		expMap.put("DIAMOND_ORE", 5);
		expMap.put("IRON_ORE", 3);
		expMap.put("GOLD_ORE", 4);
		expMap.put("REDSTONE_ORE", 2);
		expMap.put("COPPER_ORE", 2);
		expMap.put("OBSIDIAN", 3);
		expMap.put("GRANITE", 1);
		expMap.put("COAL_ORE", 1);
		expMap.put("ANCIENT_DEBRIS", 10);
		expMap.put("STONE", 1);
		expMap.put("COBBLESTONE", 1);
		expMap.put("RAW_COPPER_BLOCK", 4);
		expMap.put("RAW_IRON_BLOCK", 5);
		expMap.put("DEEPSLATE_REDSTONE_ORE", 5);
		expMap.put("NETHER_QUARTZ_ORE", 5);
		expMap.put("LAPIS_ORE", 3);
		expMap.put("CALCITE", 1);
		expMap.put("WITHER_SKELETON", 3);
		expMap.put("SKELETON", 2);
		expMap.put("ZOMBIE", 1);
		expMap.put("GHAST", 5);
		expMap.put("MAGMA_CUBE", 10);
		expMap.put("SLIME", 2);
		expMap.put("BLAZE", 5);
		expMap.put("CREEPER", 5);
		expMap.put("WOLF", 3);
		expMap.put("COW", 1);
		expMap.put("SHEEP", 1);
		expMap.put("ZOGLIN", 3);
		expMap.put("CHICKEN", 1);
		expMap.put("HORSE", 2);
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
		expMap.put("SPRUCE_WOOD", 4);
		expMap.put("BIRCH_WOOD", 3);
		expMap.put("JUNGLE_WOOD", 5);
		expMap.put("DARK_OAK_WOOD", 3);
		expMap.put("STRIPPED_DARK_OAK_WOOD", 4);
		expMap.put("WARPED_HYPHAE", 4);
		expMap.put("ACACIA_WOOD", 5);
		expMap.put("OAK_WOOD", 1);
		expMap.put("BREAD", 5);
		expMap.put("COOKED_BEEF", 10);
		expMap.put("COOKED_MUTTON", 8);
		expMap.put("COOKED_COD", 8);
		expMap.put("COOKED_PORKCHOP", 8);
		expMap.put("BAKED_POTATO", 8);
		expMap.put("COOKED_CHICKEN", 8);
		expMap.put("SUGAR", 4);
		expMap.put("BLAZE_POWDER", 4);
		expMap.put("GOLDEN_CARROT", 4);
		expMap.put("MAGMA_CREAM", 4);
		expMap.put("GLOWSTONE_DUST", 5);
		expMap.put("REDSTONE", 5);
		expMap.put("GUNPOWDER", 5);
		expMap.put("DRAGON_BREATH", 4);
		expMap.put("FERMENTED_SPIDER_EYE", 4);
		expMap.put("SPIDER_EYE", 4);
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
		expMap.put("APPLE", 3);
	}
}
