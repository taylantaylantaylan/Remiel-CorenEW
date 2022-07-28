package me.taylan.mooncore.listeners;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.ItemHandler;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;
import org.spigotmc.event.player.PlayerSpawnLocationEvent;

public class PlayerCraftListener implements Listener {

    private MoonCore plugin;
    private ItemHandler itemHandler;

    public PlayerCraftListener(MoonCore plugin) {
        this.plugin = plugin;
        this.itemHandler = plugin.getItemHandler();
        Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onCraft(PrepareItemCraftEvent event) {
        if (event.getRecipe() == null) return;
        Material material = event.getRecipe().getResult().getType();

        switch (material) {
            case OAK_PLANKS:
                ItemStack planks = new ItemStack(itemHandler.oakplanks);
                planks.setAmount(4);
                event.getInventory().setResult(planks);
                break;
            case WARPED_PLANKS:
                ItemStack warp = new ItemStack(itemHandler.heavyplanks);
                warp.setAmount(4);
                event.getInventory().setResult(warp);
                break;
            case DARK_OAK_PLANKS:
                if (event.getInventory().containsAtLeast(itemHandler.oldoakwood, 1)) {
                    ItemStack oldoakplanks = itemHandler.oldoakplanks;
                    oldoakplanks.setAmount(4);
                    event.getInventory().setResult(oldoakplanks);
                    break;
                }
                if (event.getInventory().containsAtLeast(itemHandler.darkoakwood, 1)) {
                    ItemStack darkoakplanks = itemHandler.darkoakplanks;
                    darkoakplanks.setAmount(4);
                    event.getInventory().setResult(darkoakplanks);
                    break;
                }


            case JUNGLE_PLANKS:
                ItemStack planks3 = new ItemStack(itemHandler.godplanks);
                planks3.setAmount(4);
                event.getInventory().setResult(planks3);
                break;
            case BIRCH_PLANKS:
                ItemStack planks5 = new ItemStack(itemHandler.birchplanks);
                planks5.setAmount(4);
                event.getInventory().setResult(planks5);
                break;
            case SPRUCE_PLANKS:
                ItemStack planks6 = new ItemStack(itemHandler.spruceplanks);
                planks6.setAmount(4);
                event.getInventory().setResult(planks6);
                break;
            case ACACIA_PLANKS:
                ItemStack planks7 = new ItemStack(itemHandler.acaciaplanks);
                planks7.setAmount(4);
                event.getInventory().setResult(planks7);
                break;
            case IRON_AXE:
                event.getInventory().setResult(new ItemStack(Material.AIR));
                break;
            case ARROW:
                ItemStack arrow = new ItemStack(itemHandler.arrow);
                arrow.setAmount(4);
                event.getInventory().setResult(arrow);
                break;
            case COAL:
                ItemStack coalore = new ItemStack(itemHandler.coal);
                coalore.setAmount(9);
                event.getInventory().setResult(coalore);

                break;
            case DIAMOND:
                ItemStack diamond = new ItemStack(itemHandler.diamond);
                diamond.setAmount(9);
                event.getInventory().setResult(diamond);
                break;
            case EMERALD:
                ItemStack emerald = new ItemStack(itemHandler.emerald);
                emerald.setAmount(9);
                event.getInventory().setResult(emerald);
                break;
            case RAW_IRON:
                event.getInventory().setResult(new ItemStack(Material.AIR));
                break;
            case IRON_INGOT:
                event.getInventory().setResult(new ItemStack(Material.AIR));
                break;
            case RAW_COPPER:
                event.getInventory().setResult(new ItemStack(Material.AIR));
                break;
            case RAW_COPPER_BLOCK:
                event.getInventory().setResult(new ItemStack(Material.AIR));
                break;
            case RAW_IRON_BLOCK:
                event.getInventory().setResult(new ItemStack(Material.AIR));
                break;
            case RAW_GOLD_BLOCK:
                event.getInventory().setResult(new ItemStack(Material.AIR));
                break;
            case BRICKS:
                event.getInventory().setResult(itemHandler.bottle);
                break;
            case GLASS_BOTTLE:
                event.getInventory().setResult(itemHandler.bottle);
                break;
            case LAPIS_BLOCK:
                event.getInventory().setResult(itemHandler.lapislazuliblock);
                break;
            case IRON_BLOCK:
                event.getInventory().setResult(itemHandler.ironblock);
                break;
            case GOLD_BLOCK:
                event.getInventory().setResult(itemHandler.goldblock);
                break;
            case COPPER_INGOT:
                ItemStack coperingot = new ItemStack(itemHandler.copperingot);
                coperingot.setAmount(9);
                event.getInventory().setResult(coperingot);
                break;
            case RAW_GOLD:
                event.getInventory().setResult(new ItemStack(Material.AIR));
                break;
            case LAPIS_LAZULI:
                ItemStack lapisingot = new ItemStack(itemHandler.lapis);
                lapisingot.setAmount(9);
                event.getInventory().setResult(lapisingot);
                break;
            case GOLD_INGOT:
                ItemStack golingot = new ItemStack(itemHandler.goldingot);
                golingot.setAmount(9);
                event.getInventory().setResult(golingot);
                break;
            case GOLD_NUGGET:
                event.getInventory().setResult(new ItemStack(Material.AIR));
                break;
            case IRON_NUGGET:
                event.getInventory().setResult(new ItemStack(Material.AIR));
                break;
            case NETHERITE_INGOT:
                event.getInventory().setResult(new ItemStack(Material.AIR));
                break;
            case NETHERITE_SCRAP:
                event.getInventory().setResult(new ItemStack(Material.AIR));
                break;
            case WOODEN_SWORD:
                if (event.getInventory().getResult().hasItemMeta() && event.getInventory().getResult().getItemMeta().getDisplayName().contains("Kemik")) {
                    ItemStack woodensword = itemHandler.bonesword;
                    event.getInventory().setResult(woodensword);
                } else {
                    ItemStack woodensword = itemHandler.createWeaponItem(new ItemStack(Material.WOODEN_SWORD), "<white>Tahta Kılıç", 1, 4, 0, 4, 0, true, 1, 3, 0, "Düşük", 4, "Kılıç", 100, 1);
                    event.getInventory().setResult(woodensword);
                }
                break;
            case WOODEN_SHOVEL:
                ItemStack woodenshovel = itemHandler.createToolItem(new ItemStack(Material.GOLDEN_SHOVEL), "<white>Tahta Kürek", 1, 3, true, 1, 10, "Kürek", 100, 1);
                event.getInventory().setResult(woodenshovel);
                break;
            case WOODEN_PICKAXE:
                ItemStack woodenpick = itemHandler.createToolItem(new ItemStack(Material.GOLDEN_PICKAXE), "<white>Tahta Kazma", 1, 3, true, 1, 10, "Kazma", 100, 1);
                event.getInventory().setResult(woodenpick);
                break;
            case WOODEN_AXE:
                ItemStack woodenaxe = itemHandler.createToolItem(new ItemStack(Material.GOLDEN_AXE), "<white>Tahta Balta", 1, 4, true, 1, 10, "Balta", 100, 1);
                event.getInventory().setResult(woodenaxe);
                break;
            case WOODEN_HOE:
                if (event.getInventory().getResult().hasItemMeta() && event.getInventory().getResult().getItemMeta().getDisplayName().contains("Çiftçi")) {
                    ItemStack woodenhoe = itemHandler.farmerhoe;
                    event.getInventory().setResult(woodenhoe);
                } else {
                    ItemStack woodenhoe = itemHandler.createToolItem(new ItemStack(Material.GOLDEN_HOE), "<white>Tahta Çapa", 1, 2, true, 1, 10, "Çapa", 150, 1);
                    event.getInventory().setResult(woodenhoe);
                }

                break;
            case STONE_SWORD:
                ItemStack stonesword = itemHandler.createWeaponItem(new ItemStack(Material.WOODEN_SWORD), "<gray>Taş Kılıç", 1, 5, 0, 2, 3, true, 2, 6, 0, "Düşük", 4, "Kılıç", 150, 1);
                event.getInventory().setResult(stonesword);
                break;
            case STONE_SHOVEL:
                ItemStack stoneshovel = itemHandler.createToolItem(new ItemStack(Material.GOLDEN_SHOVEL), "<gray>Taş Kürek", 1, 3, true, 2, 10, "Kürek", 150, 1);
                event.getInventory().setResult(stoneshovel);
                break;
            case STONE_PICKAXE:
                ItemStack stonepick = itemHandler.createToolItem(new ItemStack(Material.GOLDEN_PICKAXE), "<gray>Taş Kazma", 1, 3, true, 2, 10, "Kazma", 150, 1);
                event.getInventory().setResult(stonepick);
                break;
            case STONE_AXE:
                ItemStack stoneaxe = itemHandler.createToolItem(new ItemStack(Material.GOLDEN_AXE), "<gray>Taş Balta", 1, 4, true, 1, 10, "Balta", 150, 1);
                event.getInventory().setResult(stoneaxe);
                break;
            case STONE_HOE:
                ItemStack stonehoe = itemHandler.createToolItem(new ItemStack(Material.GOLDEN_HOE), "<gray>Taş Çapa", 1, 2, true, 1, 10, "Çapa", 150, 1);
                event.getInventory().setResult(stonehoe);
                break;
            case GOLDEN_SWORD:
                event.getInventory().setResult(new ItemStack(Material.AIR));
                break;
            case LEATHER_HELMET:
                if (event.getInventory().getResult().hasItemMeta() && event.getInventory().getResult().getItemMeta().getDisplayName().contains("Kemik")) {
                    ItemStack woodenhoe = itemHandler.bonehelmet;
                    event.getInventory().setResult(woodenhoe);
                } else if (event.getInventory().getResult().hasItemMeta() && event.getInventory().getResult().getItemMeta().getDisplayName().contains("Kararmış")) {
                    ItemStack woodenhoe = itemHandler.kararmiskasket;
                    event.getInventory().setResult(woodenhoe);
                } else {
                    event.getInventory().setResult(new ItemStack(Material.AIR));
                }


                break;
            case LEATHER_CHESTPLATE:
                event.getInventory().setResult(new ItemStack(Material.AIR));
                break;
            case LEATHER_LEGGINGS:
                event.getInventory().setResult(new ItemStack(Material.AIR));
                break;
            case LEATHER_BOOTS:
                event.getInventory().setResult(new ItemStack(Material.AIR));
                break;
            case GOLDEN_SHOVEL:
                event.getInventory().setResult(new ItemStack(Material.AIR));
                break;
            case BOW:
                event.getInventory().setResult(new ItemStack(Material.AIR));
                break;
            case CROSSBOW:
                event.getInventory().setResult(new ItemStack(Material.AIR));
                break;
            case FISHING_ROD:
                event.getInventory().setResult(new ItemStack(Material.AIR));
                break;
            case GOLDEN_PICKAXE:
                event.getInventory().setResult(new ItemStack(Material.AIR));
                break;
            case GOLDEN_AXE:
                event.getInventory().setResult(new ItemStack(Material.AIR));
                break;
            case GOLDEN_HOE:
                event.getInventory().setResult(new ItemStack(Material.AIR));
                break;
            case IRON_SWORD:
                event.getInventory().setResult(new ItemStack(Material.AIR));
                break;
            case IRON_PICKAXE:
                event.getInventory().setResult(new ItemStack(Material.AIR));
                break;
            case IRON_HOE:
                event.getInventory().setResult(new ItemStack(Material.AIR));
                break;
            case IRON_SHOVEL:
                event.getInventory().setResult(new ItemStack(Material.AIR));
                break;
            case DIAMOND_SWORD:
                event.getInventory().setResult(new ItemStack(Material.AIR));
                break;

            case DIAMOND_SHOVEL:
                event.getInventory().setResult(new ItemStack(Material.AIR));
                break;
            case DIAMOND_PICKAXE:
                event.getInventory().setResult(new ItemStack(Material.AIR));
                break;
            case DIAMOND_AXE:
                event.getInventory().setResult(new ItemStack(Material.AIR));
                break;
            case DIAMOND_HOE:
                event.getInventory().setResult(new ItemStack(Material.AIR));
                break;
            case NETHERITE_SWORD:
                event.getInventory().setResult(new ItemStack(Material.AIR));
                break;
            case NETHERITE_SHOVEL:
                event.getInventory().setResult(new ItemStack(Material.AIR));
                break;
            case NETHERITE_PICKAXE:
                event.getInventory().setResult(new ItemStack(Material.AIR));
                break;
            case NETHERITE_AXE:
                event.getInventory().setResult(new ItemStack(Material.AIR));
                break;
            case NETHERITE_HOE:
                event.getInventory().setResult(new ItemStack(Material.AIR));
                break;
            case STICK:
                if (event.getInventory().containsAtLeast(itemHandler.oakplanks, 1)) {
                    event.getInventory().setResult(itemHandler.oakstick);
                    break;
                }
                if (event.getInventory().containsAtLeast(itemHandler.darkoakplanks, 1)) {
                    event.getInventory().setResult(itemHandler.darkoakstick);
                    break;
                }
                if (event.getInventory().containsAtLeast(itemHandler.birchplanks, 1)) {
                    event.getInventory().setResult(itemHandler.birchstick);
                    break;
                }
                if (event.getInventory().containsAtLeast(itemHandler.godplanks, 1)) {
                    event.getInventory().setResult(itemHandler.godstick);
                    break;
                }
                if (event.getInventory().containsAtLeast(itemHandler.acaciaplanks, 1)) {
                    event.getInventory().setResult(itemHandler.acaciastick);
                    break;
                }
                if (event.getInventory().containsAtLeast(itemHandler.oldoakplanks, 1)) {
                    event.getInventory().setResult(itemHandler.oldoakstick);
                    break;
                }
                if (event.getInventory().containsAtLeast(itemHandler.kozplanks, 1)) {
                    event.getInventory().setResult(itemHandler.kozstick);
                    break;
                }
                if (event.getInventory().containsAtLeast(itemHandler.heavyplanks, 1)) {
                    event.getInventory().setResult(itemHandler.heavystick);
                    break;
                }


        }


    }


}
