package me.taylan.mooncore.listeners;

import com.manya.pdc.DataTypes;
import me.taylan.mooncore.CoreProtectApi;
import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.level.Levels;
import me.taylan.mooncore.utils.ItemHandler;
import me.taylan.mooncore.utils.StatsManager;
import net.coreprotect.CoreProtect;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class SkillListener implements Listener {
    private final PersistentDataType<?, HashMap<String, Integer>> Enchants = DataTypes
            .hashMap(PersistentDataType.STRING, PersistentDataType.INTEGER);
    private MoonCore plugin;
    private Levels levels;
    private ItemHandler itemHandler;
    private StatsManager stats;

    public SkillListener(MoonCore plugin) {
        this.levels = plugin.getLevels();
        this.plugin = plugin;
        this.itemHandler = plugin.getItemHandler();
        this.stats = plugin.getStatsManager();
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {

        LivingEntity e = event.getEntity();
        Player player = event.getEntity().getKiller();

        if (event.getEntity() == e) {
            if (e.getKiller() instanceof Player) {
                levels.giveCombatEXP(player, 2, e);
            }
        }
    }



    @EventHandler
    public void onWoodBreak(BlockBreakEvent event) {

        Block block = event.getBlock();
        if (!(block.getType() == Material.OAK_WOOD || block.getType() == Material.DARK_OAK_WOOD
                || block.getType() == Material.SPRUCE_WOOD || block.getType() == Material.JUNGLE_WOOD
                || block.getType() == Material.STRIPPED_DARK_OAK_WOOD || block.getType() == Material.BIRCH_WOOD
                || block.getType() == Material.ACACIA_WOOD || block.getType() == Material.ANCIENT_DEBRIS
        )) {
            return;
        }
        if (block.getType() == Material.OAK_WOOD || block.getType() == Material.DARK_OAK_WOOD
                || block.getType() == Material.SPRUCE_WOOD || block.getType() == Material.JUNGLE_WOOD
                || block.getType() == Material.STRIPPED_DARK_OAK_WOOD || block.getType() == Material.BIRCH_WOOD
                || block.getType() == Material.ACACIA_WOOD || block.getType() == Material.ANCIENT_DEBRIS
        ) {

            Player player = event.getPlayer();
            levels.giveOduncuExp(player, block);


            if (player.getInventory().getItemInMainHand().getItemMeta() != null) {
                ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
                NamespacedKey key = new NamespacedKey(plugin, "Enchants");
                if (meta.getPersistentDataContainer() != null) {

                    PersistentDataContainer container = meta.getPersistentDataContainer();
                    if (container.has(key, Enchants)) {
                        if (container.get(key, Enchants).containsKey("ustalık")) {
                            int level = container.get(key, Enchants).get("ustalık");
                            stats.setMadencilikExp(player.getUniqueId(), level);
                        }
                    }
                }
            }

        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {

        Block block = event.getBlock();
        if (!(block.getType() == Material.STONE || block.getType() == Material.IRON_ORE
                || block.getType() == Material.COAL_ORE || block.getType() == Material.GOLD_ORE
                || block.getType() == Material.REDSTONE_ORE || block.getType() == Material.LAPIS_ORE
                || block.getType() == Material.ANDESITE || block.getType() == Material.GRANITE || block.getType() == Material.COPPER_ORE
                || block.getType() == Material.DIORITE || block.getType() == Material.ANCIENT_DEBRIS
                || block.getType() == Material.DIAMOND_ORE || block.getType() == Material.NETHER_QUARTZ_ORE || block.getType() == Material.RAW_COPPER_BLOCK || block.getType() == Material.OBSIDIAN || block.getType() == Material.RAW_IRON_BLOCK)) {
            return;
        }
        if ((block.getType() == Material.STONE || block.getType() == Material.IRON_ORE
                || block.getType() == Material.COAL_ORE || block.getType() == Material.GOLD_ORE
                || block.getType() == Material.REDSTONE_ORE || block.getType() == Material.LAPIS_ORE
                || block.getType() == Material.ANDESITE || block.getType() == Material.GRANITE|| block.getType() == Material.COPPER_ORE
                || block.getType() == Material.DIORITE || block.getType() == Material.ANCIENT_DEBRIS
                || block.getType() == Material.DIAMOND_ORE || block.getType() == Material.NETHER_QUARTZ_ORE || block.getType() == Material.RAW_COPPER_BLOCK || block.getType() == Material.OBSIDIAN || block.getType() == Material.RAW_IRON_BLOCK)) {

            Player player = event.getPlayer();
            levels.giveMiningExp(player, block);
            int miningExp = stats.getMadencilikExp(player.getUniqueId());

            if (player.getInventory().getItemInMainHand().getItemMeta() != null) {
                ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
                NamespacedKey key = new NamespacedKey(plugin, "Enchants");
                if (meta.getPersistentDataContainer() != null) {

                    PersistentDataContainer container = meta.getPersistentDataContainer();
                    if (container.has(key, Enchants)) {
                        if (container.get(key, Enchants).containsKey("ustalık")) {
                            int level = container.get(key, Enchants).get("ustalık");
                            stats.setMadencilikExp(player.getUniqueId(), level);
                        }
                    }
                }
            }

        }
    }

    @EventHandler
    public void onFarming(BlockBreakEvent event) {
        Block block = event.getBlock();
        Player player = event.getPlayer();
        if (!(block.getType() == Material.POTATOES || block.getType() == Material.CARROTS
                || block.getType() == Material.WHEAT || block.getType() == Material.BEETROOTS
                || block.getType() == Material.NETHER_WART || block.getType() == Material.CACTUS
                || block.getType() == Material.SWEET_BERRIES || block.getType() == Material.RED_MUSHROOM
                || block.getType() == Material.BROWN_MUSHROOM || block.getType() == Material.SUGAR_CANE
                || block.getType() == Material.KELP_PLANT || block.getType() == Material.PUMPKIN
                || block.getType() == Material.MELON)) {
            return;
        }
        net.coreprotect.CoreProtectAPI api = CoreProtectApi.getCoreProtect();
        if (CoreProtect.getInstance().getAPI().blockLookup(event.getBlock(), (int) (System.currentTimeMillis() / 1000L))
                .size() > 0)
            return;
        if (block.getType() == Material.POTATOES || block.getType() == Material.CARROTS
                || block.getType() == Material.WHEAT || block.getType() == Material.BEETROOTS
                || block.getType() == Material.NETHER_WART || block.getType() == Material.CACTUS
                || block.getType() == Material.SWEET_BERRIES || block.getType() == Material.RED_MUSHROOM
                || block.getType() == Material.BROWN_MUSHROOM || block.getType() == Material.SUGAR_CANE
                || block.getType() == Material.KELP_PLANT || block.getType() == Material.PUMPKIN
                || block.getType() == Material.MELON) {
            levels.giveFarmingExp(player, block);
            ItemStack item = player.getInventory().getItemInMainHand();
            if (item == null) {
                return;
            }
            int farmingExp = stats.getFarmingExp(player.getUniqueId());

            if (player.getInventory().getItemInMainHand().getItemMeta() != null) {
                ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
                NamespacedKey key = new NamespacedKey(plugin, "Enchants");
                if (meta.getPersistentDataContainer() != null) {

                    PersistentDataContainer container = meta.getPersistentDataContainer();
                    if (container.has(key, Enchants)) {
                        if (container.get(key, Enchants).containsKey("ustalık")) {
                            int level = container.get(key, Enchants).get("ustalık");
                            stats.setFarmingExp(player.getUniqueId(), level);
                        }
                    }
                }
            }

        }
    }

    private Set<Block> getNearbyBlocks(Block start, List<Material> allowedMaterials, HashSet<Block> blocks) {
        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                for (int z = -1; z < 2; z++) {
                    Block block = start.getLocation().clone().add(x, y, z).getBlock();
                    if (block != null && !blocks.contains(block) && allowedMaterials.contains(block.getType())) {
                        blocks.add(block);
                        blocks.addAll(getNearbyBlocks(block, allowedMaterials, blocks));
                    }
                }
            }
        }
        return blocks;
    }

    public Set<Block> getTree(Block start, List<Material> allowedMaterials) {
        return getNearbyBlocks(start, allowedMaterials, new HashSet<Block>());
    }
}
