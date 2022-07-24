package me.taylan.mooncore.listeners;

import lombok.NonNull;
import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.level.ExpList;
import me.taylan.mooncore.utils.Painter;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.bossbar.BossBar;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class ScrollListener implements Listener {

    private MoonCore plugin;
    private Map<UUID,String> scrollmap = new HashMap<>();

    public ScrollListener(MoonCore plugin) {
        this.plugin = plugin;
        Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void scroll(PlayerInteractEvent event) {
        Player player = event.getPlayer();

            if (event.getItem() != null && event.getItem().hasItemMeta() && event.getItem().getItemMeta().getDisplayName().contains("Global Tecrübe")) {
                if(scrollmap.isEmpty()) {
                player.getInventory().getItemInMainHand().setType(Material.AIR);
                scrollmap.put(player.getUniqueId(), "xp");
                int chancexp = ThreadLocalRandom.current().nextInt(5);
                switch (chancexp) {
                    case 0:
                        // MINING
                        ExpList.getExpMap().put("DIAMOND_ORE", 6);
                        ExpList.getExpMap().put("IRON_ORE", 4);
                        ExpList.getExpMap().put("GOLD_ORE", 5);
                        ExpList.getExpMap().put("REDSTONE_ORE", 3);
                        ExpList.getExpMap().put("NETHER_QUARTZ_ORE", 3);
                        ExpList.getExpMap().put("OBSIDIAN", 4);
                        ExpList.getExpMap().put("GRANITE", 2);
                        ExpList.getExpMap().put("COAL_ORE", 3);
                        ExpList.getExpMap().put("ANCIENT_DEBRIS", 12);
                        ExpList.getExpMap().put("STONE", 2);
                        ExpList.getExpMap().put("COBBLESTONE", 2);
                        ExpList.getExpMap().put("RAW_COPPER_BLOCK", 4);
                        ExpList.getExpMap().put("RAW_IRON_BLOCK", 6);
                        ExpList.getExpMap().put("DEEPSLATE_REDSTONE_ORE", 6);
                        ExpList.getExpMap().put("NETHER_QUARTZ_ORE", 6);
                        ExpList.getExpMap().put("LAPIS_ORE", 4);

                        for (Player destek : Bukkit.getOnlinePlayers()) {
                            showMyBossBar(destek);
                            final Component newText = Component.text("Global Tecrübe Puanı Takviyesi: Madencilik");
                            activeBar.name(newText);
                        }
                        break;
                    case 1:
                        ExpList.getExpMap().put("WITHER_SKELETON", 5);
                        ExpList.getExpMap().put("SKELETON", 4);
                        ExpList.getExpMap().put("ZOMBIE", 2);
                        ExpList.getExpMap().put("GHAST", 10);
                        ExpList.getExpMap().put("MAGMA_CUBE", 6);
                        ExpList.getExpMap().put("SLIME", 4);
                        ExpList.getExpMap().put("BLAZE", 10);
                        ExpList.getExpMap().put("CREEPER", 10);
                        ExpList.getExpMap().put("WOLF", 5);
                        ExpList.getExpMap().put("COW", 3);
                        ExpList.getExpMap().put("SHEEP", 3);
                        ExpList.getExpMap().put("ZOGLIN", 5);
                        ExpList.getExpMap().put("CHICKEN", 3);
                        ExpList.getExpMap().put("HORSE", 4);
                        for (Player destek : Bukkit.getOnlinePlayers()) {
                            showMyBossBar(destek);
                            final Component newText = Component.text("Global Tecrübe Puanı Takviyesi: Avcılık");
                            activeBar.name(newText);
                        }
                        break;
                    case 2:
                        ExpList.getExpMap().put("WHEAT", 5);
                        ExpList.getExpMap().put("PATATOES", 4);
                        ExpList.getExpMap().put("CARROTS", 4);
                        ExpList.getExpMap().put("BEETROOTS", 4);
                        ExpList.getExpMap().put("SUGAR_CANE", 5);
                        ExpList.getExpMap().put("CACTUS", 5);
                        ExpList.getExpMap().put("NETHER_WART", 6);
                        ExpList.getExpMap().put("RED_MUSHROOM", 4);
                        ExpList.getExpMap().put("BROWN_MUSHROOM", 4);
                        ExpList.getExpMap().put("PUMPKIN", 6);
                        ExpList.getExpMap().put("MELON", 5);
                        for (Player destek : Bukkit.getOnlinePlayers()) {
                            showMyBossBar(destek);
                            final Component newText = Component.text("Global Tecrübe Puanı Takviyesi: Çiftçilik");
                            activeBar.name(newText);
                        }
                        break;
                    case 3:
                        ExpList.getExpMap().put("SUGAR", 6);
                        ExpList.getExpMap().put("NETHER_WART", 5);
                        ExpList.getExpMap().put("BLAZE_POWDER", 6);
                        ExpList.getExpMap().put("GOLDEN_CARROT", 5);
                        ExpList.getExpMap().put("MAGMA_CREAM", 6);
                        ExpList.getExpMap().put("GLOWSTONE_DUST", 6);
                        ExpList.getExpMap().put("REDSTONE", 6);
                        ExpList.getExpMap().put("GUNPOWDER", 6);
                        ExpList.getExpMap().put("DRAGON_BREATH", 5);
                        ExpList.getExpMap().put("FERMENTED_SPIDER_EYE", 6);
                        ExpList.getExpMap().put("SPIDER_EYE", 6);
                        for (Player destek : Bukkit.getOnlinePlayers()) {
                            showMyBossBar(destek);
                            final Component newText = Component.text("Global Tecrübe Puanı Takviyesi: Simyacılık");
                            activeBar.name(newText);
                        }
                        break;
                    case 4:
                        ExpList.getExpMap().put("BREAD", 7);
                        ExpList.getExpMap().put("COOKED_BEEF", 12);
                        ExpList.getExpMap().put("COOKED_MUTTON", 10);
                        ExpList.getExpMap().put("COOKED_COD", 12);
                        ExpList.getExpMap().put("COOKED_PORKCHOP", 10);
                        ExpList.getExpMap().put("BAKED_POTATO", 10);
                        ExpList.getExpMap().put("COOKED_CHICKEN", 11);
                        for (Player destek : Bukkit.getOnlinePlayers()) {
                            showMyBossBar(destek);
                            final Component newText = Component.text("Global Tecrübe Puanı Takviyesi: Aşçılık");
                            activeBar.name(newText);
                        }
                        break;
                    case 5:
                        ExpList.getExpMap().put("COD", 6);
                        ExpList.getExpMap().put("PUFFERFISH", 7);
                        ExpList.getExpMap().put("SALMON", 8);
                        ExpList.getExpMap().put("SADDLE", 12);
                        ExpList.getExpMap().put("ENCHANTED_BOOK", 22);
                        ExpList.getExpMap().put("LEATHER", 4);
                        ExpList.getExpMap().put("BOW", 17);
                        ExpList.getExpMap().put("LILY_PAD", 5);
                        ExpList.getExpMap().put("TROPICAL_FISH", 6);
                        ExpList.getExpMap().put("FISHING_ROD", 17);
                        ExpList.getExpMap().put("NAME_TAG", 4);
                        ExpList.getExpMap().put("TRIPWIRE_HOOK", 5);
                        ExpList.getExpMap().put("NAUTILUS_SHELL", 13);
                        ExpList.getExpMap().put("BONE", 3);
                        for (Player destek : Bukkit.getOnlinePlayers()) {
                            showMyBossBar(destek);
                            final Component newText = Component.text("Global Tecrübe Puanı Takviyesi: Balıkçılık");
                            activeBar.name(newText);
                        }
                        break;

                }
                new BukkitRunnable() {

                    @Override
                    public void run() {
                        for (Player destek : Bukkit.getOnlinePlayers()) {
                            hideActiveBossBar(destek);
                            destek.sendMessage(Painter.paint("&8[&bMoonNetwork] &6Global Tecrübe Puanı Takviyesi sona erdi. Bu etkinliği yapan: &e" + player.getName()));
                            // MINING

                        }
                        ExpList.getExpMap().put("DIAMOND_ORE", 5);
                        ExpList.getExpMap().put("IRON_ORE", 3);
                        ExpList.getExpMap().put("GOLD_ORE", 4);
                        ExpList.getExpMap().put("REDSTONE_ORE", 2);
                        ExpList.getExpMap().put("NETHER_QUARTZ_ORE", 2);
                        ExpList.getExpMap().put("OBSIDIAN", 3);
                        ExpList.getExpMap().put("GRANITE", 1);
                        ExpList.getExpMap().put("COAL_ORE", 2);
                        ExpList.getExpMap().put("ANCIENT_DEBRIS", 10);
                        ExpList.getExpMap().put("STONE", 1);
                        ExpList.getExpMap().put("COBBLESTONE", 1);
                        ExpList.getExpMap().put("RAW_COPPER_BLOCK", 4);
                        ExpList.getExpMap().put("RAW_IRON_BLOCK", 5);
                        ExpList.getExpMap().put("DEEPSLATE_REDSTONE_ORE", 5);
                        ExpList.getExpMap().put("NETHER_QUARTZ_ORE", 5);
                        ExpList.getExpMap().put("LAPIS_ORE", 3);
                        // COMBAT
                        ExpList.getExpMap().put("WITHER_SKELETON", 3);
                        ExpList.getExpMap().put("SKELETON", 2);
                        ExpList.getExpMap().put("ZOMBIE", 1);
                        ExpList.getExpMap().put("GHAST", 5);
                        ExpList.getExpMap().put("MAGMA_CUBE", 3);
                        ExpList.getExpMap().put("SLIME", 2);
                        ExpList.getExpMap().put("BLAZE", 5);
                        ExpList.getExpMap().put("CREEPER", 5);
                        ExpList.getExpMap().put("WOLF", 3);
                        ExpList.getExpMap().put("COW", 1);
                        ExpList.getExpMap().put("SHEEP", 1);
                        ExpList.getExpMap().put("ZOGLIN", 3);
                        ExpList.getExpMap().put("CHICKEN", 1);
                        ExpList.getExpMap().put("HORSE", 2);
                        // FISHING
                        ExpList.getExpMap().put("COD", 4);
                        ExpList.getExpMap().put("PUFFERFISH", 5);
                        ExpList.getExpMap().put("SALMON", 6);
                        ExpList.getExpMap().put("SADDLE", 10);
                        ExpList.getExpMap().put("ENCHANTED_BOOK", 20);
                        ExpList.getExpMap().put("LEATHER", 2);
                        ExpList.getExpMap().put("BOW", 15);
                        ExpList.getExpMap().put("LILY_PAD", 3);
                        ExpList.getExpMap().put("TROPICAL_FISH", 30);
                        ExpList.getExpMap().put("FISHING_ROD", 14);
                        ExpList.getExpMap().put("NAME_TAG", 2);
                        ExpList.getExpMap().put("TRIPWIRE_HOOK", 2);
                        ExpList.getExpMap().put("NAUTILUS_SHELL", 10);
                        ExpList.getExpMap().put("BONE", 1);
                        // FORAGING
                        ExpList.getExpMap().put("SPRUCE_WOOD", 4);
                        ExpList.getExpMap().put("BIRCH_WOOD", 3);
                        ExpList.getExpMap().put("JUNGLE_WOOD", 5);
                        ExpList.getExpMap().put("DARK_OAK_WOOD", 3);
                        ExpList.getExpMap().put("STRIPPED_DARK_OAK_WOOD", 4);
                        ExpList.getExpMap().put("ACACIA_WOOD", 5);
                        ExpList.getExpMap().put("OAK_WOOD", 1);
                        //COOKING
                        ExpList.getExpMap().put("BREAD", 5);
                        ExpList.getExpMap().put("COOKED_BEEF", 10);
                        ExpList.getExpMap().put("COOKED_MUTTON", 8);
                        ExpList.getExpMap().put("COOKED_COD", 8);
                        ExpList.getExpMap().put("COOKED_PORKCHOP", 8);
                        ExpList.getExpMap().put("BAKED_POTATO", 8);
                        ExpList.getExpMap().put("COOKED_CHICKEN", 8);
                        // BREWING
                        ExpList.getExpMap().put("SUGAR", 4);
                        ExpList.getExpMap().put("NETHER_WART", 3);
                        ExpList.getExpMap().put("BLAZE_POWDER", 4);
                        ExpList.getExpMap().put("GOLDEN_CARROT", 4);
                        ExpList.getExpMap().put("MAGMA_CREAM", 4);
                        ExpList.getExpMap().put("GLOWSTONE_DUST", 5);
                        ExpList.getExpMap().put("REDSTONE", 5);
                        ExpList.getExpMap().put("GUNPOWDER", 5);
                        ExpList.getExpMap().put("DRAGON_BREATH", 4);
                        ExpList.getExpMap().put("FERMENTED_SPIDER_EYE", 4);
                        ExpList.getExpMap().put("SPIDER_EYE", 4);

                        // FARMING
                        ExpList.getExpMap().put("WHEAT", 3);
                        ExpList.getExpMap().put("PATATOES", 2);
                        ExpList.getExpMap().put("CARROTS", 2);
                        ExpList.getExpMap().put("BEETROOTS", 2);
                        ExpList.getExpMap().put("SUGAR_CANE", 3);
                        ExpList.getExpMap().put("CACTUS", 3);
                        ExpList.getExpMap().put("NETHER_WART", 4);
                        ExpList.getExpMap().put("RED_MUSHROOM", 2);
                        ExpList.getExpMap().put("BROWN_MUSHROOM", 2);
                        ExpList.getExpMap().put("PUMPKIN", 3);
                        ExpList.getExpMap().put("MELON", 3);
                        scrollmap.clear();
                    }
                }.runTaskLater(plugin, 36000);
            }else {
                    player.sendMessage(Painter.paint("&c&lZaten bir exp takviyesi var!"));
                }
        }
    }

    @EventHandler
    public void playerjoinsup(PlayerJoinEvent event) {
        if(!(scrollmap.isEmpty())) {
            Player player = event.getPlayer();
            showMyBossBar(player);
        }
    }

    private @Nullable BossBar activeBar;

    public void showMyBossBar(final @NonNull Audience target) {
        final Component name = Component.text("Global Tecrübe Puanı Takviyesi:");
        // etc..
        final BossBar fullBar = BossBar.bossBar(name, 1, BossBar.Color.BLUE, BossBar.Overlay.NOTCHED_20);

        // Send a bossbar to your audience
        target.showBossBar(fullBar);

        // Store it locally to be able to hide it manually later
        this.activeBar = fullBar;
    }

    public void hideActiveBossBar(final @NonNull Audience target) {
        target.hideBossBar(this.activeBar);
        this.activeBar = null;
    }

}
