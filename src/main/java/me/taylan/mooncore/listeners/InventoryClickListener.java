//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package me.taylan.mooncore.listeners;

import com.destroystokyo.paper.MaterialTags;
import com.manya.pdc.DataTypes;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.BukkitSerialization;
import me.taylan.mooncore.utils.GuiHandler;
import me.taylan.mooncore.utils.ItemHandler;
import me.taylan.mooncore.utils.Painter;
import me.taylan.mooncore.utils.StatsManager;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Chest;
import org.bukkit.block.DoubleChest;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockCookEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.InventoryCloseEvent.Reason;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.event.player.PlayerTakeLecternBookEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class InventoryClickListener implements Listener {
    private static final HashMap<UUID, Block> SmithBlock = new HashMap();
    private static final HashMap<UUID, Block> CookBlock = new HashMap();
    private static final HashMap<UUID, Block> FurnaceBlock = new HashMap();
    // --Commented out by Inspection (14.11.2022 02:08):private HashSet<String> enchplayer = new HashSet();
    private final Pattern DIGITS_PATTERN = Pattern.compile("\\d+");
    private static final HashMap<UUID, Block> RealFurnaceBlock = new HashMap();
    private static final HashMap<UUID, Block> ElSanatBlock = new HashMap();
    private final MoonCore plugin;
    private final ItemHandler itemHandler;
    private final GuiHandler guiHandler;
    private final StatsManager stats;
    private final PersistentDataType<?, HashMap<String, Integer>> Enchants;

    public static HashMap<UUID, Block> getRealFurnaceBlock() {
        return RealFurnaceBlock;
    }

    public InventoryClickListener(MoonCore plugin) {
        this.Enchants = DataTypes.hashMap(PersistentDataType.STRING, PersistentDataType.INTEGER);
        this.stats = plugin.getStatsManager();
        this.plugin = plugin;
        this.itemHandler = plugin.getItemHandler();
        this.guiHandler = plugin.getGuiHandler();
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    public static HashMap<UUID, Block> getSmithBlock() {
        return SmithBlock;
    }

    public static HashMap<UUID, Block> getCookBlock() {
        return CookBlock;
    }

    public static HashMap<UUID, Block> getFurnaceBlock() {
        return FurnaceBlock;
    }

    public static HashMap<UUID, Block> getElSanatBlock() {
        return ElSanatBlock;
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        String title = event.getView().getTitle();
        if (title.equals(this.guiHandler.inventory_name)) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            this.guiHandler.clicked((Player)event.getWhoClicked(), event.getSlot(), event.getCurrentItem(), event.getInventory());
            Player player = (Player)event.getWhoClicked();
            player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2.0F, 1.1F);
        }

    }

    @EventHandler
    public void Cook(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Block block = event.getClickedBlock();
            if (Objects.requireNonNull(block).getType() == Material.SMOKER) {
                int cookProduct = this.stats.getCookProduction(player.getUniqueId());
                if (cookProduct <= 0) {
                    if (!CookBlock.containsKey(player.getUniqueId())) {
                        CookBlock.put(player.getUniqueId(), block);
                    }

                    event.setCancelled(true);
                    player.openInventory(this.guiHandler.cookGui(player));
                } else {
                    if (!CookBlock.containsKey(player.getUniqueId())) {
                        CookBlock.put(player.getUniqueId(), block);
                    }

                    event.setCancelled(true);
                    player.openInventory(this.guiHandler.productCook(player));
                }
            }
        }

    }

    @EventHandler
    public void playerclosejob(InventoryCloseEvent event) {
        Player player = (Player)event.getPlayer();
        String title = event.getView().getTitle();
        if (title.equals(this.guiHandler.inventory_name2) && GuiHandler.job.containsKey(player.getUniqueId())) {
            GuiHandler.job.remove(player.getUniqueId());
        }

    }

    @EventHandler
    public void resource2(InventoryClickEvent event) {
        String title = event.getView().getTitle();
        if (title.contains("Deri Dik ->")) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            this.guiHandler.clicked((Player)event.getWhoClicked(), event.getSlot(), event.getCurrentItem(), event.getInventory());
            Player player = (Player)event.getWhoClicked();
            player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2.0F, 1.1F);
        }

    }

    @EventHandler
    public void booktake(PlayerTakeLecternBookEvent event) {
        Player player = event.getPlayer();
        if (!player.isOp()) {
            event.setCancelled(true);
        }

    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player p = (Player)event.getWhoClicked();
        Inventory clicked = event.getClickedInventory();
        if ((event.getInventory().getHolder() instanceof Chest || event.getInventory().getHolder() instanceof DoubleChest) && clicked == event.getWhoClicked().getInventory()) {
            ItemStack clickedOn = event.getCurrentItem();
            if (clickedOn != null && event.getCurrentItem().hasItemMeta() && Objects.requireNonNull(event.getCurrentItem().getItemMeta().displayName()).contains(MiniMessage.builder().build().deserialize("Oyuncu El Kitab??"))) {
                event.setCancelled(true);
            }
        }

    }

    @EventHandler
    public void resource222(InventoryClickEvent event) {
        String title = event.getView().getTitle();
        if (title.contains("??retimler")) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            this.guiHandler.clicked((Player)event.getWhoClicked(), event.getSlot(), event.getCurrentItem(), event.getInventory());
            Player player = (Player)event.getWhoClicked();
            player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2.0F, 1.1F);
        }

    }

    @EventHandler
    public void resource22(InventoryClickEvent event) {
        String title = event.getView().getTitle();
        if (title.contains("Profil")) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }
        }

    }

    @EventHandler
    public void resource(InventoryClickEvent event) {
        String title = event.getView().getTitle();
        if (title.contains("Ekipman ????leme ->")) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            this.guiHandler.clicked((Player)event.getWhoClicked(), event.getSlot(), event.getCurrentItem(), event.getInventory());
            Player player = (Player)event.getWhoClicked();
            player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2.0F, 1.1F);
        }

    }

    @EventHandler
    public void onClick2(InventoryClickEvent event) {
        String title = event.getView().getTitle();
        if (title.equals(this.guiHandler.inventory_name2)) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            this.guiHandler.clicked((Player)event.getWhoClicked(), event.getSlot(), event.getCurrentItem(), event.getInventory());
            Player player = (Player)event.getWhoClicked();
            player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2.0F, 1.1F);
        }

    }

    @EventHandler
    public void onClick11(InventoryClickEvent event) {
        String title = event.getView().getTitle();
        if (title.equals(this.guiHandler.inventory_name11)) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            this.guiHandler.clicked((Player)event.getWhoClicked(), event.getSlot(), event.getCurrentItem(), event.getInventory());
            Player player = (Player)event.getWhoClicked();
            player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2.0F, 1.1F);
        }

    }

    @EventHandler
    public void oninventory(InventoryCloseEvent event) {
        String title = event.getView().getTitle();
        Player player = (Player)event.getPlayer();
        if (title.equals(this.guiHandler.inventory_name14)) {
            GuiHandler var10000 = this.guiHandler;
            if (GuiHandler.zerola.containsKey(player.getUniqueId())) {
                var10000 = this.guiHandler;
                GuiHandler.zerola.remove(player.getUniqueId());
            }
        }

    }

    @EventHandler
    public void onClick3(InventoryClickEvent event) {
        String title = event.getView().getTitle();
        if (title.equals(this.guiHandler.inventory_name3)) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            this.guiHandler.clicked((Player)event.getWhoClicked(), event.getSlot(), event.getCurrentItem(), event.getInventory());
            Player player = (Player)event.getWhoClicked();
            player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2.0F, 1.1F);
        }

    }

    @EventHandler
    public void onClickench(InventoryClickEvent event) {
        String title = event.getView().getTitle();
        if (title.contains("B??y??")) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            this.guiHandler.clicked((Player)event.getWhoClicked(), event.getSlot(), event.getCurrentItem(), event.getInventory());
        }

    }

    @EventHandler
    public void onClickench22(InventoryClickEvent event) {
        String title = event.getView().getTitle();
        if (title.equals(this.guiHandler.inventory_name15)) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            this.guiHandler.clicked((Player)event.getWhoClicked(), event.getSlot(), event.getCurrentItem(), event.getInventory());
        }

    }

    @EventHandler
    public void onClickench222(InventoryClickEvent event) {
        String title = event.getView().getTitle();
        if (title.equals(this.guiHandler.inventory_name16)) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            this.guiHandler.clicked((Player)event.getWhoClicked(), event.getSlot(), event.getCurrentItem(), event.getInventory());
        }

    }

    @EventHandler
    public void questclic(InventoryClickEvent event) {
        String title = event.getView().getTitle();
        if (title.equals(this.guiHandler.inventory_name24)) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            this.guiHandler.clicked((Player)event.getWhoClicked(), event.getSlot(), event.getCurrentItem(), event.getInventory());
            Player player = (Player)event.getWhoClicked();
            player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2.0F, 1.1F);
        }

    }

    @EventHandler
    public void onClick42(InventoryClickEvent event) {
        String title = event.getView().getTitle();
        if (title.equals(this.guiHandler.inventory_name22)) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            this.guiHandler.clicked((Player)event.getWhoClicked(), event.getSlot(), event.getCurrentItem(), event.getInventory());
            Player player = (Player)event.getWhoClicked();
            player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2.0F, 1.1F);
        }

    }

    @EventHandler
    public void onClick4(InventoryClickEvent event) {
        String title = event.getView().getTitle();
        if (title.equals(this.guiHandler.inventory_name4)) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            this.guiHandler.clicked((Player)event.getWhoClicked(), event.getSlot(), event.getCurrentItem(), event.getInventory());
            Player player = (Player)event.getWhoClicked();
            player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2.0F, 1.1F);
        }

    }

    @EventHandler
    public void onClick20(InventoryClickEvent event) {
        String title = event.getView().getTitle();
        if (title.equals(this.guiHandler.inventory_name13)) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            this.guiHandler.clicked((Player)event.getWhoClicked(), event.getSlot(), event.getCurrentItem(), event.getInventory());
            Player player = (Player)event.getWhoClicked();
            player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2.0F, 1.1F);
        }

    }

    @EventHandler
    public void onClickKnowledge(PlayerSwapHandItemsEvent event) {
        NamespacedKey star = new NamespacedKey(this.plugin, "star");
        Player player = event.getPlayer();
        if (event.getOffHandItem() != null && event.getOffHandItem().hasItemMeta() && event.getOffHandItem().getItemMeta().getPersistentDataContainer() != null && event.getOffHandItem().getItemMeta().getPersistentDataContainer().has(star, PersistentDataType.STRING)) {
            event.setCancelled(true);
            player.openInventory(this.guiHandler.bilgikitab??(player));
        }

    }

    @EventHandler
    public void onClickKnowledge(InventoryClickEvent event) {
        NamespacedKey star = new NamespacedKey(this.plugin, "star");
        Player player = (Player)event.getWhoClicked();
        if (event.getWhoClicked().getItemOnCursor() != null && event.getCurrentItem() != null && event.getCurrentItem().hasItemMeta() && event.getCurrentItem().getItemMeta().getPersistentDataContainer() != null && event.getCurrentItem().getItemMeta().getPersistentDataContainer().has(star, PersistentDataType.STRING)) {
            event.setCancelled(true);
            if (event.getWhoClicked().getItemOnCursor().hasItemMeta() && event.getWhoClicked().getItemOnCursor().getItemMeta().getPersistentDataContainer() != null && event.getWhoClicked().getItemOnCursor().getItemMeta().getPersistentDataContainer().has(star)) {
                player.setItemOnCursor((ItemStack)null);
            }

            player.openInventory(this.guiHandler.bilgikitab??(player));
        }

    }

    @EventHandler
    public void Claimbilgi(InventoryClickEvent event) {
        String title = event.getView().getTitle();
        Player player = (Player)event.getWhoClicked();
        if (title.equals(this.guiHandler.inventory_name23)) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            this.guiHandler.clicked((Player)event.getWhoClicked(), event.getSlot(), event.getCurrentItem(), event.getInventory());
            player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2.0F, 1.1F);
        }

    }

    @EventHandler
    public void onClicknitelik(InventoryClickEvent event) {
        String title = event.getView().getTitle();
        Player player = (Player)event.getWhoClicked();
        if (title.equals(this.guiHandler.inventory_name14)) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            this.guiHandler.clicked((Player)event.getWhoClicked(), event.getSlot(), event.getCurrentItem(), event.getInventory());
            player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2.0F, 1.1F);
        }

    }

    @EventHandler
    public void onClickBackPack(InventoryClickEvent event) {
        NamespacedKey backp = new NamespacedKey(this.plugin, "backpack");
        String title = event.getView().getTitle();
        Player player = (Player)event.getWhoClicked();
        if (event.getCurrentItem() != null) {
            if (title.contains("??anta") && event.getCurrentItem().hasItemMeta() && event.getCurrentItem().getItemMeta().getPersistentDataContainer() != null && event.getCurrentItem().getItemMeta().getPersistentDataContainer().has(backp)) {
                event.setCancelled(true);
            }

        }
    }

    @EventHandler
    public void dropbackpack(PlayerDropItemEvent event) throws IOException {
        NamespacedKey backp = new NamespacedKey(this.plugin, "backpack");
        NamespacedKey backpslot = new NamespacedKey(this.plugin, "backpackslot");
        Player player = event.getPlayer();
        ItemStack item = event.getItemDrop().getItemStack();
        if (item.hasItemMeta() && item != null && item.getItemMeta().getPersistentDataContainer().has(backp, PersistentDataType.STRING)) {
            event.setCancelled(true);
            if (!((String) Objects.requireNonNull(item.getItemMeta().getPersistentDataContainer().get(backp, PersistentDataType.STRING))).equals("Yok..")) {
                String contents = (String)item.getItemMeta().getPersistentDataContainer().get(backp, PersistentDataType.STRING);
                Inventory inventory = Bukkit.createInventory((InventoryHolder)null, (Integer)item.getItemMeta().getPersistentDataContainer().get(backpslot, PersistentDataType.INTEGER), item.getItemMeta().getDisplayName());
                ItemStack[] inv = BukkitSerialization.itemStackArrayFromBase64(contents);
                inventory.setContents(inv);
                player.openInventory(inventory);
            } else {
                player.openInventory(Bukkit.createInventory((InventoryHolder)null, (Integer)item.getItemMeta().getPersistentDataContainer().get(backpslot, PersistentDataType.INTEGER), item.getItemMeta().getDisplayName()));
            }
        }

    }

    @EventHandler
    public void dropbook(PlayerDropItemEvent event) {
        NamespacedKey star = new NamespacedKey(this.plugin, "star");
        Player player = event.getPlayer();
        ItemStack item = event.getItemDrop().getItemStack();
        if (item.hasItemMeta() && item != null && item.getItemMeta().getPersistentDataContainer().has(star, PersistentDataType.STRING)) {
            event.setCancelled(true);
            player.openInventory(this.guiHandler.bilgikitab??(player));
            player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2.0F, 1.2F);
        }

    }

    @EventHandler
    public void clickbook(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        NamespacedKey star = new NamespacedKey(this.plugin, "star");
        if ((event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) && player.getInventory().getItemInMainHand().hasItemMeta() && player.getInventory().getItemInMainHand() != null && player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().has(star, PersistentDataType.STRING)) {
            event.setCancelled(true);
            player.openInventory(this.guiHandler.bilgikitab??(player));
            player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2.0F, 1.2F);
        }

    }

    @EventHandler
    public void clickbook2(PlayerInteractEvent event) throws IOException {
        Player player = event.getPlayer();
        NamespacedKey backp = new NamespacedKey(this.plugin, "backpack");
        NamespacedKey backpslot = new NamespacedKey(this.plugin, "backpackslot");
        ItemStack item = player.getInventory().getItemInMainHand();
        if ((event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) && player.getInventory().getItemInMainHand().hasItemMeta() && player.getInventory().getItemInMainHand() != null && item.getItemMeta().getPersistentDataContainer().has(backp, PersistentDataType.STRING) && item.getItemMeta().getPersistentDataContainer().has(backpslot, PersistentDataType.INTEGER)) {
            if (!((String) Objects.requireNonNull(item.getItemMeta().getPersistentDataContainer().get(backp, PersistentDataType.STRING))).equals("Yok..")) {
                String contents = (String)item.getItemMeta().getPersistentDataContainer().get(backp, PersistentDataType.STRING);
                Inventory inventory = Bukkit.createInventory((InventoryHolder)null, (Integer)item.getItemMeta().getPersistentDataContainer().get(backpslot, PersistentDataType.INTEGER), item.getItemMeta().getDisplayName());
                ItemStack[] inv = BukkitSerialization.itemStackArrayFromBase64(contents);
                inventory.setContents(inv);
                player.openInventory(inventory);
            } else {
                player.openInventory(Bukkit.createInventory((InventoryHolder)null, (Integer)item.getItemMeta().getPersistentDataContainer().get(backpslot, PersistentDataType.INTEGER), item.getItemMeta().getDisplayName()));
            }
        }

    }

    @EventHandler
    public void Backpackclose(InventoryCloseEvent event) {
        Player player = (Player)event.getPlayer();
        String title = event.getView().getTitle();
        if (title.contains("??anta")) {
            NamespacedKey backp = new NamespacedKey(this.plugin, "backpack");
            NamespacedKey backpslot = new NamespacedKey(this.plugin, "backpackslot");
            ItemStack item = player.getInventory().getItemInMainHand();
            ItemMeta meta = item.getItemMeta();
            if (item != null && item.hasItemMeta() && meta.getPersistentDataContainer().has(backp, PersistentDataType.STRING) && meta.getPersistentDataContainer().has(backpslot, PersistentDataType.INTEGER)) {
                String invToBase64work = BukkitSerialization.itemStackArrayToBase64(event.getView().getTopInventory().getContents());
                meta.getPersistentDataContainer().set(backp, PersistentDataType.STRING, invToBase64work);
                item.setItemMeta(meta);
            }
        }

    }

    @EventHandler
    public void onClick622(InventoryClickEvent event) {
        String title = event.getView().getTitle();
        if (title.equals(this.guiHandler.inventory_name6)) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            this.guiHandler.clicked((Player)event.getWhoClicked(), event.getSlot(), event.getCurrentItem(), event.getInventory());
            Player player = (Player)event.getWhoClicked();
            player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2.0F, 1.1F);
        }

    }

    @EventHandler
    public void onClick6222(InventoryClickEvent event) {
        String title = event.getView().getTitle();
        if (title.equals(this.guiHandler.inventory_name9)) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            this.guiHandler.clicked((Player)event.getWhoClicked(), event.getSlot(), event.getCurrentItem(), event.getInventory());
            Player player = (Player)event.getWhoClicked();
            player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2.0F, 1.1F);
        }

    }

    @EventHandler
    public void onClick622321(InventoryClickEvent event) {
        String title = event.getView().getTitle();
        if (title.equals(this.guiHandler.inventory_name19)) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            this.guiHandler.clicked((Player)event.getWhoClicked(), event.getSlot(), event.getCurrentItem(), event.getInventory());
            Player player = (Player)event.getWhoClicked();
            player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2.0F, 1.1F);
        }

    }

    @EventHandler
    public void onClick62232(InventoryClickEvent event) {
        String title = event.getView().getTitle();
        if (title.equals(this.guiHandler.inventory_name18)) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            this.guiHandler.clicked((Player)event.getWhoClicked(), event.getSlot(), event.getCurrentItem(), event.getInventory());
            Player player = (Player)event.getWhoClicked();
            player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2.0F, 1.1F);
        }

    }

    @EventHandler
    public void onClick622222(InventoryClickEvent event) {
        String title = event.getView().getTitle();
        if (title.equals(this.guiHandler.inventory_name21)) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            this.guiHandler.clicked((Player)event.getWhoClicked(), event.getSlot(), event.getCurrentItem(), event.getInventory());
            Player player = (Player)event.getWhoClicked();
            player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2.0F, 1.1F);
        }

    }

    @EventHandler
    public void onClick62222(InventoryClickEvent event) {
        String title = event.getView().getTitle();
        if (title.equals(this.guiHandler.inventory_name17)) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            this.guiHandler.clicked((Player)event.getWhoClicked(), event.getSlot(), event.getCurrentItem(), event.getInventory());
            Player player = (Player)event.getWhoClicked();
            player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2.0F, 1.1F);
        }

    }

    @EventHandler
    public void onClickPorfile2(InventoryClickEvent event) {
        Inventory inv = event.getInventory();
        if (inv == this.guiHandler.inv17) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            this.guiHandler.clicked((Player)event.getWhoClicked(), event.getSlot(), event.getCurrentItem(), event.getInventory());
            Player player = (Player)event.getWhoClicked();
            player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2.0F, 1.1F);
        }

    }

    @EventHandler
    public void onClickFletch(InventoryClickEvent event) {
        Inventory inv = event.getInventory();
        if (inv == this.guiHandler.inv17) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            this.guiHandler.clicked((Player)event.getWhoClicked(), event.getSlot(), event.getCurrentItem(), event.getInventory());
            Player player = (Player)event.getWhoClicked();
            player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2.0F, 1.1F);
        }

    }

    @EventHandler
    public void onClickLeatherFletch(InventoryClickEvent event) {
        Inventory inv = event.getInventory();
        if (inv == this.guiHandler.inv19) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            this.guiHandler.clicked((Player)event.getWhoClicked(), event.getSlot(), event.getCurrentItem(), event.getInventory());
            Player player = (Player)event.getWhoClicked();
            player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2.0F, 1.1F);
        }

    }

    @EventHandler
    public void onClickLeatherFletch2(InventoryClickEvent event) {
        Inventory inv = event.getInventory();
        if (inv == this.guiHandler.inv21) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            this.guiHandler.clicked((Player)event.getWhoClicked(), event.getSlot(), event.getCurrentItem(), event.getInventory());
            Player player = (Player)event.getWhoClicked();
            player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2.0F, 1.1F);
        }

    }

    @EventHandler
    public void onClickFishingFletch(InventoryClickEvent event) {
        Inventory inv = event.getInventory();
        if (inv == this.guiHandler.inv20) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            this.guiHandler.clicked((Player)event.getWhoClicked(), event.getSlot(), event.getCurrentItem(), event.getInventory());
            Player player = (Player)event.getWhoClicked();
            player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2.0F, 1.1F);
        }

    }

    @EventHandler
    public void onClickPorfile(InventoryClickEvent event) {
        Inventory inv = event.getInventory();
        if (inv == this.guiHandler.inv12) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            this.guiHandler.clicked((Player)event.getWhoClicked(), event.getSlot(), event.getCurrentItem(), event.getInventory());
            Player player = (Player)event.getWhoClicked();
            player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2.0F, 1.1F);
        }

    }

    @EventHandler
    public void onrod(InventoryClickEvent event) {
        String title = event.getView().getTitle();
        if (title.equals(this.guiHandler.inventory_name20)) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            this.guiHandler.clicked((Player)event.getWhoClicked(), event.getSlot(), event.getCurrentItem(), event.getInventory());
        }

    }

    @EventHandler
    public void onClickSa(InventoryClickEvent event) {
        String title = event.getView().getTitle();
        if (title.equals(this.guiHandler.inventory_name28)) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            this.guiHandler.clicked((Player)event.getWhoClicked(), event.getSlot(), event.getCurrentItem(), event.getInventory());
        }

    }

    @EventHandler
    public void onClick62(InventoryClickEvent event) {
        String title = event.getView().getTitle();
        if (title.equals(this.guiHandler.inventory_name8)) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            this.guiHandler.clicked((Player)event.getWhoClicked(), event.getSlot(), event.getCurrentItem(), event.getInventory());
        }

    }

    @EventHandler
    public void onClick6212(InventoryClickEvent event) {
        String title = event.getView().getTitle();
        if (title.equals(this.guiHandler.inventory_name26)) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            this.guiHandler.clicked((Player)event.getWhoClicked(), event.getSlot(), event.getCurrentItem(), event.getInventory());
        }

    }

    @EventHandler
    public void onClickEnv(InventoryClickEvent event) {
        Player player = (Player)event.getWhoClicked();
        String title = event.getView().getTitle();
        if (title.equalsIgnoreCase(Painter.paint("&8Depo"))) {
            if (event.getClickedInventory() != null && event.getClickedInventory().equals(JoinListener.getMenu().get(player.getUniqueId()))) {
                event.setCancelled(false);
            } else {
                event.setCancelled(true);
            }

            if (event.getCurrentItem() == null) {
                return;
            }
        }

    }

    @EventHandler
    public void ench(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getClickedBlock() != null && event.getClickedBlock().getType() == Material.ENCHANTING_TABLE) {
            if (player.hasPermission("mooncore.ench")) {
                event.setCancelled(true);
                player.openInventory(this.guiHandler.GUIENCH(player));
            } else {
                player.sendMessage(Painter.paint("&cB??y?? masas??n?? kullanabilmek i??in &dSaorin'in &cg??revlerini bitirmen gerek."));
                event.setCancelled(true);
            }
        }

    }

    @EventHandler
    public void camp(BlockCookEvent event) {
        Block block = event.getBlock();
        if (event.getBlock().getType() == Material.CAMPFIRE) {
            event.setCancelled(true);
        }

    }

    @EventHandler
    public void anvil(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK && Objects.requireNonNull(event.getClickedBlock()).getType() == Material.ANVIL) {
            Block block = event.getClickedBlock();
            event.setCancelled(true);
            player.openInventory(this.guiHandler.anvilgui(player));
        }

    }

    public boolean hasScaffold(Block block) {
        if (block.getRelative(BlockFace.NORTH).getType().equals(Material.SCAFFOLDING)) {
            return true;
        } else if (block.getRelative(BlockFace.SOUTH).getType().equals(Material.SCAFFOLDING)) {
            return true;
        } else if (block.getRelative(BlockFace.EAST).getType().equals(Material.SCAFFOLDING)) {
            return true;
        } else {
            return block.getRelative(BlockFace.WEST).getType().equals(Material.SCAFFOLDING);
        }
    }

    @EventHandler
    public void profil(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();
        Entity entity = event.getRightClicked();
        if (entity instanceof Player clickedplayer) {
            if (this.stats.hasPlayedBefore(clickedplayer.getUniqueId()) && player.isSneaking()) {
                player.openInventory(this.guiHandler.profil(player, clickedplayer));
                ArrayList<ItemStack> list = (ArrayList)this.stats.getHepsi(clickedplayer.getUniqueId());
                if (clickedplayer.getInventory().getHelmet() != null) {
                    player.getOpenInventory().getTopInventory().setItem(13, clickedplayer.getInventory().getHelmet());
                }

                if (clickedplayer.getInventory().getChestplate() != null) {
                    player.getOpenInventory().getTopInventory().setItem(22, clickedplayer.getInventory().getChestplate());
                }

                if (clickedplayer.getInventory().getLeggings() != null) {
                    player.getOpenInventory().getTopInventory().setItem(31, clickedplayer.getInventory().getLeggings());
                }

                if (clickedplayer.getInventory().getBoots() != null) {
                    player.getOpenInventory().getTopInventory().setItem(40, clickedplayer.getInventory().getBoots());
                }

                if (clickedplayer.getInventory().getItemInMainHand() != null) {
                    player.getOpenInventory().getTopInventory().setItem(39, clickedplayer.getInventory().getItemInMainHand());
                }

                if (clickedplayer.getInventory().getItemInOffHand() != null) {
                    player.getOpenInventory().getTopInventory().setItem(41, clickedplayer.getInventory().getItemInOffHand());
                }

                if (!this.stats.getKolye(clickedplayer.getUniqueId()).equals("Yok..")) {
                    player.getOpenInventory().getTopInventory().setItem(21, (ItemStack)list.get(2));
                }

                if (!this.stats.getTilsim(clickedplayer.getUniqueId()).equals("Yok..")) {
                    player.getOpenInventory().getTopInventory().setItem(23, (ItemStack)list.get(0));
                }

                if (!this.stats.getEldiven(clickedplayer.getUniqueId()).equals("Yok..")) {
                    player.getOpenInventory().getTopInventory().setItem(30, (ItemStack)list.get(1));
                }

                if (!this.stats.getYuzuk(clickedplayer.getUniqueId()).equals("Yok..")) {
                    player.getOpenInventory().getTopInventory().setItem(32, (ItemStack)list.get(3));
                }
            }

        }
    }

    @EventHandler
    public void RealFurnaceaga(InventoryOpenEvent event) {
        Player player = (Player)event.getPlayer();
        if (event.getInventory().getType() == InventoryType.ANVIL || event.getInventory().getType() == InventoryType.FURNACE || event.getInventory().getType() == InventoryType.BLAST_FURNACE || event.getInventory().getType() == InventoryType.SMOKER || event.getInventory().getType() == InventoryType.SMITHING) {
            event.setCancelled(true);
        }

    }

    @EventHandler
    public void RealFurnace(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Block block = event.getClickedBlock();
            if (Objects.requireNonNull(block).getType() == Material.FURNACE) {
                int cookProduct = this.stats.getRealFurnaceProduction(player.getUniqueId());
                if (cookProduct <= 0) {
                    if (!RealFurnaceBlock.containsKey(player.getUniqueId())) {
                        RealFurnaceBlock.put(player.getUniqueId(), block);
                    }

                    event.setCancelled(true);
                    player.openInventory(this.guiHandler.realFurnaceGui(player));
                } else {
                    if (!RealFurnaceBlock.containsKey(player.getUniqueId())) {
                        RealFurnaceBlock.put(player.getUniqueId(), block);
                    }

                    event.setCancelled(true);
                    player.openInventory(this.guiHandler.productRealFurnace(player));
                }
            }
        }

    }

    @EventHandler
    public void Furnace(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Block block = event.getClickedBlock();
            if (Objects.requireNonNull(block).getType() == Material.BLAST_FURNACE) {
                int cookProduct = this.stats.getFurnaceProduction(player.getUniqueId());
                if (cookProduct <= 0) {
                    if (!FurnaceBlock.containsKey(player.getUniqueId())) {
                        FurnaceBlock.put(player.getUniqueId(), block);
                    }

                    event.setCancelled(true);
                    player.openInventory(this.guiHandler.Furnace(player));
                } else {
                    if (!FurnaceBlock.containsKey(player.getUniqueId())) {
                        FurnaceBlock.put(player.getUniqueId(), block);
                    }

                    event.setCancelled(true);
                    player.openInventory(this.guiHandler.furnaceproduct(player));
                }
            }
        }

    }

    @EventHandler
    public void Fletch(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK && Objects.requireNonNull(event.getClickedBlock()).getType() == Material.FLETCHING_TABLE) {
            if (this.hasScaffold(event.getClickedBlock())) {
                Block block = event.getClickedBlock();
                ElSanatBlock.put(player.getUniqueId(), block);
                int timer = this.stats.getWorkProduction(player.getUniqueId());
                if (timer <= 0) {
                    event.setCancelled(true);
                    player.openInventory(this.guiHandler.Fletching(player));
                } else {
                    event.setCancelled(true);
                    player.openInventory(this.guiHandler.elsanatproduct(player));
                }
            } else {
                player.sendMessage(Painter.paint("&cAh??aplarla ??al????abilmen i??in bir masa gerek."));
            }
        }

    }

    @EventHandler
    public void Smith(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK && Objects.requireNonNull(event.getClickedBlock()).getType() == Material.SMITHING_TABLE) {
            Block block = event.getClickedBlock();
            SmithBlock.put(player.getUniqueId(), block);
            int timer = this.stats.getProduction(player.getUniqueId());
            int timer2 = this.stats.getProduction1(player.getUniqueId());
            if (timer <= 0 && timer2 <= 0) {
                event.setCancelled(true);
                player.openInventory(this.guiHandler.demircimasasasas(player));
            } else {
                event.setCancelled(true);
                player.openInventory(this.guiHandler.product(player));
            }
        }

    }

    @EventHandler
    public void onClickTamir(InventoryClickEvent event) {
        Player player = (Player)event.getWhoClicked();
        String title = event.getView().getTitle();
        if (title.equals(this.guiHandler.inventory_name28)) {
            ItemStack item;
            if (event.getClickedInventory() != null && event.getClickedInventory().equals(player.getInventory())) {
                event.setCancelled(true);
                if (event.getWhoClicked().getItemOnCursor() != null && event.getCurrentItem() != null) {
                    item = event.getCurrentItem();
                    ItemStack item2 = event.getCurrentItem().clone();
                    if (MaterialTags.SWORDS.isTagged(item) || MaterialTags.AXES.isTagged(item) || MaterialTags.BOWS.isTagged(item) || MaterialTags.PICKAXES.isTagged(item) || MaterialTags.HOES.isTagged(item) || MaterialTags.HELMETS.isTagged(item) || MaterialTags.CHESTPLATES.isTagged(item) || MaterialTags.LEGGINGS.isTagged(item) || MaterialTags.BOOTS.isTagged(item) || MaterialTags.SHOVELS.isTagged(item) || item.getType() == Material.FISHING_ROD || item.getType() == Material.STICK || item.getType() == Material.SHEARS) {
                        int enchLevel = this.stats.getEnchLevel(player.getUniqueId());
                        if (event.getView().getItem(31) == null) {
                            int amount = item.getAmount();
                            item2.setAmount(1);
                            player.getInventory().removeItem(new ItemStack[]{item2});
                            event.getView().setItem(31, item2);
                            String input = String.join(" ", item.getItemMeta().getDisplayName());
                            Matcher matcher = this.DIGITS_PATTERN.matcher(input);
                            if (matcher.find()) {
                                String firstDigits = matcher.group();
                                ItemHandler var10000 = this.itemHandler;
                                Inventory var10001 = event.getView().getTopInventory();
                                String[] var10006 = new String[]{"&8Bu ekipman?? tamir etmek", "&8i??in gereken malzemeler:", "", null, null, null, null};
                                int var10009 = Integer.valueOf(firstDigits);
                                var10006[3] = " &7- &f" + var10009 * 3 + " Tane Hurda";
                                var10009 = Integer.valueOf(firstDigits);
                                var10006[4] = " &7- &f" + var10009 * 4 + " Seviye";
                                var10006[5] = "";
                                var10006[6] = "&8Bu ekipman?? tamir etmek istiyorsan &e&lSa?? T??kla.";
                                var10000.createItem(var10001, "anvil", 1, 41, "&6Tamir Et", var10006);
                            }
                        }
                    }
                }
            } else {
                event.setCancelled(true);
                if (event.getWhoClicked().getItemOnCursor() != null && event.getCurrentItem() != null) {
                    item = event.getCurrentItem();
                    if (MaterialTags.SWORDS.isTagged(item) || MaterialTags.AXES.isTagged(item) || MaterialTags.BOWS.isTagged(item) || MaterialTags.PICKAXES.isTagged(item) || MaterialTags.HOES.isTagged(item) || MaterialTags.HELMETS.isTagged(item) || MaterialTags.CHESTPLATES.isTagged(item) || MaterialTags.LEGGINGS.isTagged(item) || MaterialTags.BOOTS.isTagged(item) || MaterialTags.SHOVELS.isTagged(item) || item.getType() == Material.FISHING_ROD || item.getType() == Material.STICK || item.getType() == Material.SHEARS) {
                        if (player.getInventory().firstEmpty() == -1) {
                            player.getWorld().dropItemNaturally(player.getLocation(), item);
                            event.getView().setItem(31, (ItemStack)null);
                            event.getView().setItem(40, new ItemStack(Material.ANVIL));
                        } else {
                            player.getInventory().addItem(new ItemStack[]{item});
                            event.getView().setItem(31, (ItemStack)null);
                            event.getView().setItem(40, new ItemStack(Material.ANVIL));
                        }
                    }
                }
            }
        }

    }

    @EventHandler
    public void onClickhurda(InventoryClickEvent event) {
        Player player = (Player)event.getWhoClicked();
        String title = event.getView().getTitle();
        if (title.equals(this.guiHandler.inventory_name8)) {
            ItemStack item;
            if (event.getClickedInventory() != null && event.getClickedInventory().equals(player.getInventory())) {
                event.setCancelled(true);
                if (event.getWhoClicked().getItemOnCursor() != null && event.getCurrentItem() != null) {
                    item = event.getCurrentItem();
                    ItemStack item2 = event.getCurrentItem().clone();
                    if (MaterialTags.SWORDS.isTagged(item) || MaterialTags.AXES.isTagged(item) || MaterialTags.BOWS.isTagged(item) || MaterialTags.PICKAXES.isTagged(item) || MaterialTags.HOES.isTagged(item) || MaterialTags.HELMETS.isTagged(item) || MaterialTags.CHESTPLATES.isTagged(item) || MaterialTags.LEGGINGS.isTagged(item) || MaterialTags.BOOTS.isTagged(item) || MaterialTags.SHOVELS.isTagged(item) || item.getType() == Material.FISHING_ROD || item.getType() == Material.STICK || item.getType() == Material.SHEARS) {
                        int enchLevel = this.stats.getEnchLevel(player.getUniqueId());
                        if (event.getView().getItem(31) == null) {
                            int amount = item.getAmount();
                            item2.setAmount(1);
                            player.getInventory().removeItem(new ItemStack[]{item2});
                            event.getView().setItem(31, item2);
                            String input = String.join(" ", item.getItemMeta().getDisplayName());
                            Matcher matcher = this.DIGITS_PATTERN.matcher(input);
                            if (matcher.find()) {
                                String firstDigits = matcher.group();
                                player.sendMessage(firstDigits);
                                ItemHandler var10000 = this.itemHandler;
                                Inventory var10001 = event.getView().getTopInventory();
                                String[] var10006 = new String[]{"&8Bu ekipman?? hurdaya ??evirmek sana", "", null, null, null};
                                int var10009 = Integer.valueOf(firstDigits);
                                var10006[2] = " &7- &f" + var10009 * 2 + " Tane Hurda";
                                var10006[3] = "";
                                var10006[4] = "&8kazand??racak. Hurdaya ??evirmek i??in &e&lSa?? T??kla.";
                                var10000.createItem(var10001, "stonecutter", 1, 41, "&6Hurdaya ??evir", var10006);
                            }
                        }
                    }
                }
            } else {
                event.setCancelled(true);
                if (event.getWhoClicked().getItemOnCursor() != null && event.getCurrentItem() != null) {
                    item = event.getCurrentItem();
                    if (MaterialTags.SWORDS.isTagged(item) || MaterialTags.AXES.isTagged(item) || MaterialTags.BOWS.isTagged(item) || MaterialTags.PICKAXES.isTagged(item) || MaterialTags.HOES.isTagged(item) || MaterialTags.HELMETS.isTagged(item) || MaterialTags.CHESTPLATES.isTagged(item) || MaterialTags.LEGGINGS.isTagged(item) || MaterialTags.BOOTS.isTagged(item) || MaterialTags.SHOVELS.isTagged(item) || item.getType() == Material.FISHING_ROD || item.getType() == Material.STICK || item.getType() == Material.SHEARS) {
                        if (player.getInventory().firstEmpty() == -1) {
                            player.getWorld().dropItemNaturally(player.getLocation(), item);
                            event.getView().setItem(31, (ItemStack)null);
                            event.getView().setItem(40, new ItemStack(Material.STONECUTTER));
                        } else {
                            player.getInventory().addItem(new ItemStack[]{item});
                            event.getView().setItem(31, (ItemStack)null);
                            event.getView().setItem(40, new ItemStack(Material.STONECUTTER));
                        }
                    }
                }
            }
        }

    }

    @EventHandler
    public void onClickEncha(InventoryClickEvent event) {
        Player player = (Player)event.getWhoClicked();
        String title = event.getView().getTitle();
        if (title.equals(this.guiHandler.inventory_name7)) {
            ItemStack item;
            if (event.getClickedInventory() != null && event.getClickedInventory().equals(player.getInventory())) {
                event.setCancelled(true);
                if (event.getWhoClicked().getItemOnCursor() != null && event.getCurrentItem() != null) {
                    item = event.getCurrentItem();
                    ItemStack item2 = event.getCurrentItem().clone();
                    if (MaterialTags.SWORDS.isTagged(item) || MaterialTags.AXES.isTagged(item) || MaterialTags.BOWS.isTagged(item) || MaterialTags.PICKAXES.isTagged(item) || MaterialTags.HOES.isTagged(item) || MaterialTags.HELMETS.isTagged(item) || MaterialTags.CHESTPLATES.isTagged(item) || MaterialTags.LEGGINGS.isTagged(item) || MaterialTags.BOOTS.isTagged(item) || MaterialTags.SHOVELS.isTagged(item) || item.getType() == Material.FISHING_ROD || item.getType() == Material.BOOK || item.getType() == Material.STICK || item.getType() == Material.SHEARS && Objects.requireNonNull(item.getItemMeta().getLore()).contains(Painter.paint("&8<Bo?? B??y?? B??lmesi>"))) {
                        int enchLevel = this.stats.getEnchLevel(player.getUniqueId());
                        if (event.getView().getItem(22) == null) {
                            int amount = item.getAmount();
                            item2.setAmount(1);
                            player.getInventory().removeItem(new ItemStack[]{item2});
                            event.getView().setItem(22, item2);
                        }

                        if (MaterialTags.SWORDS.isTagged(item)) {
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 31, "&6Eklembacakl??lar'??n K??yameti", new String[]{"&aUstal??k 1", "", " &7B??y??y?? bar??nd??ran ekipman ile yap??lan sald??r??lar", " &7eklembacakl??lara ekstra hasar verir.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 30, "&6Keskinlik", new String[]{"&aUstal??k 1", "", " &7B??y??y?? bar??nd??ran ekipman??n sald??r?? hasar?? artar.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 29, "&6Darbe", new String[]{"&aUstal??k 1", "", " &7B??y??y?? bar??nd??ran ekipman ile yap??lan sald??r??lar", " &7??l?? yarat??klara daha fazla hasar verir", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 33, "&6Alevden ??ehre", new String[]{"&aUstal??k 1", "", " &7B??y??y?? bar??nd??ran ekipman ile yap??lan sald??r??lar kurban?? yakar.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 32, "&6Savurma", new String[]{"&aUstal??k 1", "", " &7B??y??y?? bar??nd??ran ekipman ile yap??lan", " &7sald??r??lar rakibi uzaklara savurur.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            if (enchLevel > 1) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 34, "&6H??nerli Avc??", new String[]{"&aUstal??k 2", "", " &7B??y??y?? bar??nd??ran ekipman??n", " &7kritik hasar?? artar.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 34, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 1. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 1) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 35, "&6Zehirli Kesik", new String[]{"&aUstal??k 2", "", " &7B??y??y?? bar??nd??ran ekipman ile yap??lan", " &7sald??r??lar kurban?? zehirler.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 35, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 1. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 1) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 38, "&6K??r??lmazl??k", new String[]{"&aUstal??k 2", "", " &7B??y??y?? bar??nd??ran ekipman??n dayan??kl??l?????? artar.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 38, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 1. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 2) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 39, "&6Tecr??be Deste??i", new String[]{"&aUstal??k 3", "", " &7B??y??y?? bar??nd??ran ekipman ile avlanan", " &7yarat??klardan ekstra tecr??be puan?? d????er.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 39, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 2. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 2) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 40, "&6??fke", new String[]{"&aUstal??k 3", "", " &7B??y??y?? bar??nd??ran ekipman ile yap??lan sald??r??lar", " &7kullan??c??y?? ??fkelendirir. Kullan??c?? ??fkesi", " &7artt??k??a ekstra hasar ve sald??r?? h??z?? kazan??r.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 40, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 2. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 2) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 41, "&6S??p??r??c?? Kenar", new String[]{"&aUstal??k 3", "", " &6B??y??y?? bar??nd??ran ekipman ile yap??lan sald??r??lar", " &7kurban??n etraf??ndaki birimlere de hasar verir.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 41, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 2. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 3) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 42, "&6Ganimet", new String[]{"&aUstal??k 4", "", " &7B??y??y?? bar??nd??ran ekipman ile ??ld??r??len", " &7kurbandan ekstra ganimet d????er.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 42, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 3. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 3) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 43, "&6S??m??r??", new String[]{"&aUstal??k 4", "", " &7B??y??y?? bar??nd??ran ekipman ile yap??lan", " &7sald??r??lar kurbandan can ??alar.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 43, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 3. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 3) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 44, "&6??nfaz", new String[]{"&aUstal??k 4", "", " &7B??y??y?? bar??nd??ran ekipman ile yap??lan sald??r??lar", " &7can?? az olan kurbanlar?? infaz eder.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 44, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 3. seviyeden y??ksek olmas?? gerekir."});
                            }

                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "arrow", 1, 50, "&aSonraki Sayfa", new String[]{"&7Sonraki sayfaya ge??mek i??in &e&lSa?? T??kla."});
                        } else if (item.getType() == Material.BOW) {
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 31, "&6G????", new String[]{"&aUstal??k 1", "", " &7B??y??y?? bar??nd??ran yay ile yap??lan sald??r??lar ekstra hasar verir.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 30, "&6Yumruk", new String[]{"&aUstal??k 1", "", " &7B??y??y?? bar??nd??ran yay ile vurulan rakipler savrulur.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 29, "&6Alev", new String[]{"&aUstal??k 1", "", " &7B??y??y?? bar??nd??ran yay ile yap??lan sald??r??lar rakibi yakar", " &7", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 33, "&6Delme", new String[]{"&aUstal??k 1", "", " &7B??y??y?? bar??nd??ran ekipman ile yap??lan sald??r??lar rakipleri deler.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            if (enchLevel > 1) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 32, "&6Tam ??sabet", new String[]{"&aUstal??k 1", "", " &7B??y??y?? bar??nd??ran yay ile rakinin kafas??na", " &7yap??lan sald??r??lar ekstra hasar verir.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 32, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 1. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 1) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 34, "&6H??nerli Avc??", new String[]{"&aUstal??k 2", "", " &7B??y??y?? bar??nd??ran ekipman??n", " &7kritik hasar?? artar.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 34, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 1. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 1) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 35, "&6Keskin G??r????", new String[]{"&aUstal??k 2", "", " &7B??y??y?? bar??nd??ran yay ile f??rlat??lan", " &7okun katetti??i mesafeye g??re hasar?? artar.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 35, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 1. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 1) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 38, "&6K??r??lmazl??k", new String[]{"&aUstal??k 2", "", " &7B??y??y?? bar??nd??ran ekipman??n dayan??kl??l?????? artar.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 38, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 1. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 2) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 39, "&6Tecr??be Deste??i", new String[]{"&aUstal??k 3", "", " &7B??y??y?? bar??nd??ran ekipman ile avlanan", " &7yarat??klardan ekstra tecr??be puan?? d????er.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 39, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 2. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 2) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 40, "&6A????r?? Y??kleme", new String[]{"&aUstal??k 3", "", " &7B??y??y?? bar??nd??ran yay ile yap??lan a????r", " &7y??kl?? at????lar rakibi sersemletir.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 40, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 2. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 2) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 41, "&6Y??ld??r??m Oku", new String[]{"&aUstal??k 3", "", " &6B??y??y?? bar??nd??ran yay ile f??rlat??lan ok", " &7rakipler aras??nda seker ve hasar verir.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 41, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 2. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 3) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 42, "&6??i??leme", new String[]{"&aUstal??k 4", "", " &7B??y??y?? bar??nd??ran yay ile yap??lan sald??r??lar", " &7su yarat??klar??na ekstra hasar verir.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 42, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 3. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 3) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 43, "&6Ni??angah", new String[]{"&aUstal??k 4", "", " &7B??y??y?? bar??nd??ran yay ile yap??lan sald??r??lar", " &7sald??r??lar oyuncunun kritik hasar??n?? artt??r??r.", "&7Kullan??c?? sald??r??ya devam etmez ise", "&7bu etki bir s??re sonra kaybolur.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 43, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 3. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 3) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 44, "&6????len", new String[]{"&aUstal??k 4", "", " &7Y??r??d??????n??zde y??k biriktirirsiniz. Her 100. y??kde", " &7bir vuru?? yaparsan??z iyile??irsiniz.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 44, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 3. seviyeden y??ksek olmas?? gerekir."});
                            }

                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "arrow", 1, 50, "&aSonraki Sayfa", new String[]{"&7Sonraki sayfaya ge??mek i??in &e&lSa?? T??kla."});
                        } else if (item.getType() == Material.WOODEN_AXE) {
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 31, "&6Eklembacakl??lar'??n K??yameti", new String[]{"&aUstal??k 1", "", " &7B??y??y?? bar??nd??ran ekipman ile yap??lan sald??r??lar", " &7eklembacakl??lara ekstra hasar verir.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 30, "&6Keskinlik", new String[]{"&aUstal??k 1", "", " &7B??y??y?? bar??nd??ran ekipman??n sald??r?? hasar?? artar.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 29, "&6Darbe", new String[]{"&aUstal??k 1", "", " &7B??y??y?? bar??nd??ran ekipman ile yap??lan sald??r??lar", " &7??l?? yarat??klara daha fazla hasar verir", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 33, "&6Verimlilik", new String[]{"&aUstal??k 1", "", " &7B??y??y?? bar??nd??ran ekipman??n kazma h??z?? artar.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 32, "&6Ustal??k Deste??i", new String[]{"&aUstal??k 1", "", " &7B??y??y?? bar??nd??ran baltan??n verdi??i &6Ustal??k EXP'si &7artar.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            if (enchLevel > 1) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 34, "&6H??nerli Avc??", new String[]{"&aUstal??k 2", "", " &7B??y??y?? bar??nd??ran ekipman??n", " &7kritik hasar?? artar.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 34, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 1. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 1) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 35, "&6Kar????lama", new String[]{"&aUstal??k 2", "", " &7B??y??y?? bar??nd??ran ekipmanla bir sald??r??y??", " &7kar????layabilirsiniz. Bir sald??r??y?? kar????lamak", "&7rakibe hasar verir ve onu savurur.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 35, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 1. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 1) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 38, "&6K??r??lmazl??k", new String[]{"&aUstal??k 2", "", " &7B??y??y?? bar??nd??ran ekipman??n dayan??kl??l?????? artar.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 38, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 1. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 2) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 39, "&6Tecr??be Deste??i", new String[]{"&aUstal??k 3", "", " &7B??y??y?? bar??nd??ran ekipman ile avlanan", " &7yarat??klardan ekstra tecr??be puan?? d????er.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 39, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 2. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 2) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 40, "&6??lk Vuru??", new String[]{"&aUstal??k 3", "", " &7B??y??y?? bar??nd??ran ekipman ile yap??lan ilk", " &7vuru?? rakibe ekstra hasar verir.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 40, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 2. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 2) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 41, "&6Y??ld??r??m Lordu", new String[]{"&aUstal??k 3", "", " &6B??y??y?? bar??nd??ran ekipman ile yap??lan", " &7sald??r??lar kurbana y??ld??r??m ??arpar.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 41, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 2. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 3) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 42, "&6Ganimet", new String[]{"&aUstal??k 4", "", " &7B??y??y?? bar??nd??ran ekipman ile ??ld??r??len", " &7kurbandan ekstra ganimet d????er.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 42, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 3. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 3) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 43, "&6S??m??r??", new String[]{"&aUstal??k 4", "", " &7B??y??y?? bar??nd??ran ekipman ile yap??lan", " &7sald??r??lar kurbandan can ??alar.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 43, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 3. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 3) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 44, "&6??nfaz", new String[]{"&aUstal??k 4", "", " &7B??y??y?? bar??nd??ran ekipman ile yap??lan sald??r??lar", " &7can?? az olan kurbanlar?? infaz eder.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 44, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 3. seviyeden y??ksek olmas?? gerekir."});
                            }

                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "arrow", 1, 50, "&aSonraki Sayfa", new String[]{"&7Sonraki sayfaya ge??mek i??in &e&lSa?? T??kla."});
                        } else if (item.getType() == Material.STICK) {
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 31, "&6Eklembacakl??lar'??n K??yameti", new String[]{"&aUstal??k 1", "", " &7B??y??y?? bar??nd??ran ekipman ile yap??lan sald??r??lar", " &7eklembacakl??lara ekstra hasar verir.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 30, "&6Keskinlik", new String[]{"&aUstal??k 1", "", " &7B??y??y?? bar??nd??ran ekipman??n sald??r?? hasar?? artar.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 29, "&6Darbe", new String[]{"&aUstal??k 1", "", " &7B??y??y?? bar??nd??ran ekipman ile yap??lan sald??r??lar", " &7??l?? yarat??klara daha fazla hasar verir", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 33, "&6??eki??", new String[]{"&aUstal??k 1", "", " &7B??y??y?? bar??nd??ran ekipman ile yap??lan sald??r??lar kurban?? kullan??c??ya ??eker.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 32, "&6??i??leme", new String[]{"&aUstal??k 1", "", " &7B??y??y?? bar??nd??ran ekipman ile yap??lan sald??r??lar", " &7su yarat??klar??na ekstra hasar verir.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            if (enchLevel > 1) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 34, "&6H??nerli Avc??", new String[]{"&aUstal??k 2", "", " &7B??y??y?? bar??nd??ran ekipman??n", " &7kritik hasar?? artar.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 34, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 1. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 1) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 35, "&6Zehirli Kesik", new String[]{"&aUstal??k 2", "", " &7B??y??y?? bar??nd??ran ekipman ile yap??lan", " &7sald??r??lar kurban?? zehirler.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 35, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 1. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 1) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 38, "&6K??r??lmazl??k", new String[]{"&aUstal??k 2", "", " &7B??y??y?? bar??nd??ran ekipman??n dayan??kl??l?????? artar.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 38, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 1. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 2) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 39, "&6Tecr??be Deste??i", new String[]{"&aUstal??k 3", "", " &7B??y??y?? bar??nd??ran ekipman ile avlanan", " &7yarat??klardan ekstra tecr??be puan?? d????er.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 39, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 2. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 2) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 40, "&6??fke", new String[]{"&aUstal??k 3", "", " &7B??y??y?? bar??nd??ran ekipman ile yap??lan sald??r??lar", " &7kullan??c??y?? ??fkelendirir. Kullan??c?? ??fkesi", " &7artt??k??a ekstra hasar ve sald??r?? h??z?? kazan??r.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 40, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 2. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 2) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 41, "&6Yara De??me", new String[]{"&aUstal??k 3", "", " &6B??y??y?? bar??nd??ran ekipman ile kanayan rakiplere", " &7yap??lan sald??r??lar ekstra hasar verir.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 41, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 2. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 3) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 42, "&6Ganimet", new String[]{"&aUstal??k 4", "", " &7B??y??y?? bar??nd??ran ekipman ile ??ld??r??len", " &7kurbandan ekstra ganimet d????er.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 42, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 3. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 3) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 43, "&6S??m??r??", new String[]{"&aUstal??k 4", "", " &7B??y??y?? bar??nd??ran ekipman ile yap??lan", " &7sald??r??lar kurbandan can ??alar.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 43, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 3. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 3) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 44, "&6??nfaz", new String[]{"&aUstal??k 4", "", " &7B??y??y?? bar??nd??ran ekipman ile yap??lan sald??r??lar", " &7can?? az olan kurbanlar?? infaz eder.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 44, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 3. seviyeden y??ksek olmas?? gerekir."});
                            }

                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "arrow", 1, 50, "&aSonraki Sayfa", new String[]{"&7Sonraki sayfaya ge??mek i??in &e&lSa?? T??kla."});
                        } else if (item.getType() == Material.SHEARS) {
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 31, "&6Eklembacakl??lar'??n K??yameti", new String[]{"&aUstal??k 1", "", " &7B??y??y?? bar??nd??ran ekipman ile yap??lan sald??r??lar", " &7eklembacakl??lara ekstra hasar verir.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 30, "&6Keskinlik", new String[]{"&aUstal??k 1", "", " &7B??y??y?? bar??nd??ran ekipman??n sald??r?? hasar?? artar.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 29, "&6Darbe", new String[]{"&aUstal??k 1", "", " &7B??y??y?? bar??nd??ran ekipman ile yap??lan sald??r??lar", " &7??l?? yarat??klara daha fazla hasar verir", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 33, "&6Akuapunktur Ustas??", new String[]{"&aUstal??k 1", "", " &7B??y??y?? bar??nd??ran han??er ile i??nelemeler rakibi kanat??r.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 32, "&6??i??leme", new String[]{"&aUstal??k 1", "", " &7B??y??y?? bar??nd??ran ekipman ile yap??lan sald??r??lar", " &7su yarat??klar??na ekstra hasar verir.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            if (enchLevel > 1) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 34, "&6H??nerli Avc??", new String[]{"&aUstal??k 2", "", " &7B??y??y?? bar??nd??ran ekipman??n", " &7kritik hasar?? artar.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 34, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 1. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 1) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 35, "&6Zehirli Kesik", new String[]{"&aUstal??k 2", "", " &7B??y??y?? bar??nd??ran ekipman ile yap??lan", " &7sald??r??lar kurban?? zehirler.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 35, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 1. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 1) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 38, "&6K??r??lmazl??k", new String[]{"&aUstal??k 2", "", " &7B??y??y?? bar??nd??ran ekipman??n dayan??kl??l?????? artar.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 38, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 1. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 2) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 39, "&6Tecr??be Deste??i", new String[]{"&aUstal??k 3", "", " &7B??y??y?? bar??nd??ran ekipman ile avlanan", " &7yarat??klardan ekstra tecr??be puan?? d????er.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 39, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 2. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 2) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 40, "&6Suikastci Ruhu", new String[]{"&aUstal??k 3", "", " &7G??r??nmez iken verilen hasar?? artt??r??r.", " &7artt??k??a ekstra hasar ve sald??r?? h??z?? kazan??r.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 40, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 2. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 2) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 41, "&6Yara De??me", new String[]{"&aUstal??k 3", "", " &6B??y??y?? bar??nd??ran ekipman ile kanayan rakiplere", " &7yap??lan sald??r??lar ekstra hasar verir.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 41, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 2. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 3) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 42, "&6Ganimet", new String[]{"&aUstal??k 4", "", " &7B??y??y?? bar??nd??ran ekipman ile ??ld??r??len", " &7kurbandan ekstra ganimet d????er.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 42, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 3. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 3) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 43, "&6S??m??r??", new String[]{"&aUstal??k 4", "", " &7B??y??y?? bar??nd??ran ekipman ile yap??lan", " &7sald??r??lar kurbandan can ??alar.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 43, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 3. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 3) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 44, "&6??nfaz", new String[]{"&aUstal??k 4", "", " &7B??y??y?? bar??nd??ran ekipman ile yap??lan sald??r??lar", " &7can?? az olan kurbanlar?? infaz eder.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 44, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 3. seviyeden y??ksek olmas?? gerekir."});
                            }

                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "arrow", 1, 50, "&aSonraki Sayfa", new String[]{"&7Sonraki sayfaya ge??mek i??in &e&lSa?? T??kla."});
                        } else if (MaterialTags.HELMETS.isTagged(item)) {
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 31, "&6Koruma", new String[]{"&aUstal??k 1", "", " &7Kullan??c??y?? gelen hasar??n biraz??ndan korur.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 30, "&6Patlama Korumas??", new String[]{"&aUstal??k 1", "", " &7Kullan??c??y?? gelen patlama hasar??n??n biraz??ndan korur.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 29, "&6Alev Korumas??", new String[]{"&aUstal??k 1", "", " &7Kullan??c??y?? gelen alev hasar??n??n biraz??ndan korur.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 33, "&6B??y??l?? Kaplama", new String[]{"&aUstal??k 1", "", " &7Kullan??c??y?? gelen menzilli sald??r?? hasar??n??n biraz??ndan korur.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 32, "&6Dikenler", new String[]{"&aUstal??k 1", "", " &7Kullan??c??ya gelen hasar??n biraz??n?? sald??rana yans??t??r.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            if (enchLevel > 1) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 34, "&6A????r?? B??y??me", new String[]{"&aUstal??k 2", "", " &7Kullan??c??n??n can de??erini artt??r??r.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 34, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 1. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 1) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 35, "&6Barbar G??c??", new String[]{"&aUstal??k 2", "", " &7Kullan??c??n??n yak??n menzildeki hasar??n?? artt??r??r.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 35, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 1. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 1) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 38, "&6K??r??lmazl??k", new String[]{"&aUstal??k 2", "", " &7B??y??y?? bar??nd??ran ekipman??n dayan??kl??l?????? artar.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 38, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 1. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 2) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 39, "&6Keskin G??r????", new String[]{"&aUstal??k 3", "", " &7Kullan??c??n??n uzak menzildeki hasar??n?? artt??r??r.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 39, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 2. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 2) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 40, "&6Dev Yarma", new String[]{"&aUstal??k 3", "", " &7Can de??eri kullan??c??dan b??y??k olan", " &7rakiplere kullan??c?? ekstra hasar verir.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 40, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 2. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 2) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 41, "&6Solunga??", new String[]{"&aUstal??k 3", "", " &6Kullan??c??n??n su alt??nda daha fazla", " &7oksijen depolayabilmesini sa??lar..", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 41, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 2. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 3) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 42, "&6Din??le??tirme", new String[]{"&aUstal??k 4", "", " &7Kullan??c??n??n do??al can yenilenmesini artt??r??r.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 42, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 3. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 3) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 43, "&6Potansiyel", new String[]{"&aUstal??k 4", "", " &7Kullan??c?? bir iyile??tirme etkisi al??rsa", " &7etraf??ndakilere patlama hasar?? verir.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 43, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 3. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 3) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 44, "&6S??v????ma", new String[]{"&aUstal??k 4", "", " &7Kullan??c?? baz?? sald??r??lardan s??v????abilir.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 44, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 3. seviyeden y??ksek olmas?? gerekir."});
                            }

                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "arrow", 1, 50, "&aSonraki Sayfa", new String[]{"&7Sonraki sayfaya ge??mek i??in &e&lSa?? T??kla."});
                        } else if (MaterialTags.CHESTPLATES.isTagged(item)) {
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 31, "&6Koruma", new String[]{"&aUstal??k 1", "", " &7Kullan??c??y?? gelen hasar??n biraz??ndan korur.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 30, "&6Patlama Korumas??", new String[]{"&aUstal??k 1", "", " &7Kullan??c??y?? gelen patlama hasar??n??n biraz??ndan korur.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 29, "&6Alev Korumas??", new String[]{"&aUstal??k 1", "", " &7Kullan??c??y?? gelen alev hasar??n??n biraz??ndan korur.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 33, "&6B??y??l?? Kaplama", new String[]{"&aUstal??k 1", "", " &7Kullan??c??y?? gelen menzilli sald??r?? hasar??n??n biraz??ndan korur.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 32, "&6Dikenler", new String[]{"&aUstal??k 1", "", " &7Kullan??c??ya gelen hasar??n biraz??n?? sald??rana yans??t??r.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            if (enchLevel > 1) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 34, "&6A????r?? B??y??me", new String[]{"&aUstal??k 2", "", " &7Kullan??c??n??n can de??erini artt??r??r.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 34, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 1. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 1) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 35, "&6Ba????????kl??k", new String[]{"&aUstal??k 2", "", " &7Kullan??c?? baz?? k??t?? efektlere kar???? ba????????kl??k kazan??r.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 35, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 1. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 1) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 38, "&6K??r??lmazl??k", new String[]{"&aUstal??k 2", "", " &7B??y??y?? bar??nd??ran ekipman??n dayan??kl??l?????? artar.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 38, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 1. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 2) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 39, "&6Obsidyen Kaplama", new String[]{"&aUstal??k 3", "", " &7Kullan??c?? ate?? direnci kazan??r.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 39, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 2. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 2) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 40, "&6Kutsanm????", new String[]{"&aUstal??k 3", "", " &7Kullan??c?? sava?? d??????nda iken yenilenme kazan??r.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 40, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 2. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 2) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 41, "&6Kar???? Sald??r??", new String[]{"&aUstal??k 3", "", " &6Kullan??c?? ald?????? ilk hasarda diren?? etkisi kazan??r.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 41, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 2. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 3) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 42, "&6Din??le??tirme", new String[]{"&aUstal??k 4", "", " &7Kullan??c??n??n do??al can yenilenmesini artt??r??r.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 42, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 3. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 3) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 43, "&6??ntikam", new String[]{"&aUstal??k 4", "", " &7Kullan??c?? ??l??rse d??????k ??ans ile geri do??ar.", " &7ve etraf??ndakilere hasar verir.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 43, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 3. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 3) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 44, "&6S??v????ma", new String[]{"&aUstal??k 4", "", " &7Kullan??c?? baz?? sald??r??lardan s??v????abilir.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 44, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 3. seviyeden y??ksek olmas?? gerekir."});
                            }

                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "arrow", 1, 50, "&aSonraki Sayfa", new String[]{"&7Sonraki sayfaya ge??mek i??in &e&lSa?? T??kla."});
                        } else if (MaterialTags.LEGGINGS.isTagged(item)) {
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 31, "&6Koruma", new String[]{"&aUstal??k 1", "", " &7Kullan??c??y?? gelen hasar??n biraz??ndan korur.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 30, "&6Patlama Korumas??", new String[]{"&aUstal??k 1", "", " &7Kullan??c??y?? gelen patlama hasar??n??n biraz??ndan korur.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 29, "&6Alev Korumas??", new String[]{"&aUstal??k 1", "", " &7Kullan??c??y?? gelen alev hasar??n??n biraz??ndan korur.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 33, "&6B??y??l?? Kaplama", new String[]{"&aUstal??k 1", "", " &7Kullan??c??y?? gelen menzilli sald??r?? hasar??n??n biraz??ndan korur.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 32, "&6Dikenler", new String[]{"&aUstal??k 1", "", " &7Kullan??c??ya gelen hasar??n biraz??n?? sald??rana yans??t??r.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            if (enchLevel > 1) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 34, "&6A????r?? B??y??me", new String[]{"&aUstal??k 2", "", " &7Kullan??c??n??n can de??erini artt??r??r.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 34, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 1. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 1) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 35, "&6Ruh Korumas??", new String[]{"&aUstal??k 2", "", " &7Kullan??c?? baz?? k??t?? efektlere kar???? ba????????kl??k kazan??r.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 35, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 1. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 1) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 38, "&6K??r??lmazl??k", new String[]{"&aUstal??k 2", "", " &7B??y??y?? bar??nd??ran ekipman??n dayan??kl??l?????? artar.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 38, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 1. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 2) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 39, "&6Kaplama Darbesi", new String[]{"&aUstal??k 3", "", " &7Kullan??c??n??n ald?????? ilk hasar rakiplere", "&7hasar verir ve onlar?? u??urur.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 39, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 2. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 2) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 40, "&6Kutsanm????", new String[]{"&aUstal??k 3", "", " &7Kullan??c?? sava?? d??????nda iken yenilenme kazan??r.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 40, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 2. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 2) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 41, "&6Kar???? Sald??r??", new String[]{"&aUstal??k 3", "", " &6Kullan??c?? ald?????? ilk hasarda diren?? etkisi kazan??r.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 41, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 2. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 3) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 42, "&6Din??le??tirme", new String[]{"&aUstal??k 4", "", " &7Kullan??c??n??n do??al can yenilenmesini artt??r??r.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 42, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 3. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 3) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 43, "&6Mutlak S??f??r", new String[]{"&aUstal??k 4", "", " &7Kullan??c?? hasar al??rsa sald??ran.", " &7rakipler yava??lar ve sald??r?? h??zlar?? d????er.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 43, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 3. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 3) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 44, "&6S??v????ma", new String[]{"&aUstal??k 4", "", " &7Kullan??c?? baz?? sald??r??lardan s??v????abilir.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 44, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 3. seviyeden y??ksek olmas?? gerekir."});
                            }

                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "arrow", 1, 50, "&aSonraki Sayfa", new String[]{"&7Sonraki sayfaya ge??mek i??in &e&lSa?? T??kla."});
                        } else if (MaterialTags.BOOTS.isTagged(item)) {
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 31, "&6Koruma", new String[]{"&aUstal??k 1", "", " &7Kullan??c??y?? gelen hasar??n biraz??ndan korur.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 30, "&6Patlama Korumas??", new String[]{"&aUstal??k 1", "", " &7Kullan??c??y?? gelen patlama hasar??n??n biraz??ndan korur.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 29, "&6Alev Korumas??", new String[]{"&aUstal??k 1", "", " &7Kullan??c??y?? gelen alev hasar??n??n biraz??ndan korur.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 33, "&6B??y??l?? Kaplama", new String[]{"&aUstal??k 1", "", " &7Kullan??c??y?? gelen menzilli sald??r?? hasar??n??n biraz??ndan korur.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 32, "&6Dikenler", new String[]{"&aUstal??k 1", "", " &7Kullan??c??ya gelen hasar??n biraz??n?? sald??rana yans??t??r.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            if (enchLevel > 1) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 34, "&6A????r?? B??y??me", new String[]{"&aUstal??k 2", "", " &7Kullan??c??n??n can de??erini artt??r??r.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 34, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 1. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 1) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 35, "&6Sihirli Pabu??lar", new String[]{"&aUstal??k 2", "", " &7Kullan??c?? ekstra &f??eviklik &7kazan??r.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 35, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 1. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 1) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 38, "&6K??r??lmazl??k", new String[]{"&aUstal??k 2", "", " &7B??y??y?? bar??nd??ran ekipman??n dayan??kl??l?????? artar.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 38, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 1. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 2) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 39, "&6Statik Y??klenme", new String[]{"&aUstal??k 3", "", " &7Kullan??c??n??n y??r??rken y??k biriktirir. Her 100.", "&7y??k rakibe bir y??ld??r??m ??arpar.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 39, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 2. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 2) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 40, "&6Dikenli Taban", new String[]{"&aUstal??k 3", "", " &7Kullan??c?? savrulma direnci kazan??r.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 40, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 2. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 2) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 41, "&6Hafif D????????", new String[]{"&aUstal??k 3", "", " &6Kullan??c?? daha az d????me hasar?? al??r.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 41, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 2. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 3) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 42, "&6Din??le??tirme", new String[]{"&aUstal??k 4", "", " &7Kullan??c??n??n do??al can yenilenmesini artt??r??r.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 42, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 3. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 3) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 43, "&6Sa??lam Duru??", new String[]{"&aUstal??k 4", "", " &6Kullan??c?? ekstra &eDenge &7kazan??r.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 43, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 3. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 3) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 44, "&6S??v????ma", new String[]{"&aUstal??k 4", "", " &7Kullan??c?? baz?? sald??r??lardan s??v????abilir.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 44, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 3. seviyeden y??ksek olmas?? gerekir."});
                            }

                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "arrow", 1, 50, "&aSonraki Sayfa", new String[]{"&7Sonraki sayfaya ge??mek i??in &e&lSa?? T??kla."});
                        } else if (MaterialTags.PICKAXES.isTagged(item)) {
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 31, "&6Verimlilik", new String[]{"&aUstal??k 1", "", " &7B??y??y?? bar??nd??ran ekipman??n kazma h??z?? artar.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 30, "&6Ustal??k Deste??i", new String[]{"&aUstal??k 1", "", " &7B??y??y?? bar??nd??ran kazman??n verdi??i &6Ustal??k EXP'si &7artar.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 29, "&6S??cak Dokunu??", new String[]{"&aUstal??k 1", "", " &7B??y??y?? bar??nd??ran kazma ile kaz??lan madenler", "&7kullan??c??n??n envanterine eriyik halde gelir", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 33, "&6Servet", new String[]{"&aUstal??k 1", "", " &7B??y??y?? bar??nd??ran kazma ile kaz??lan", "&7ekstra malzeme d????er.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 32, "&6Dedekt??r", new String[]{"&aUstal??k 1", "", " &7K??r??lan her 64. blokta oyuncuya rastgele bir ganimet verir.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            if (enchLevel > 1) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 34, "&6K??r??lmazl??k", new String[]{"&aUstal??k 2", "", " &7B??y??y?? bar??nd??ran ekipman??n dayan??kl??l?????? artar.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 34, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 1. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 1) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 35, "&6Madencinin L??tfu", new String[]{"&aUstal??k 2", "", " &7B??y??y?? bar??nd??ran ekipman??n ile kaz??lan her", "&7her k??m??r kullan??c??ya acele kazand??r??r.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 35, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 1. seviyeden y??ksek olmas?? gerekir."});
                            }

                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "arrow", 1, 50, "&aSonraki Sayfa", new String[]{"&7Sonraki sayfaya ge??mek i??in &e&lSa?? T??kla."});
                        } else if (item.getType() == Material.GOLDEN_AXE) {
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 30, "&6Verimlilik", new String[]{"&aUstal??k 1", "", " &7B??y??y?? bar??nd??ran ekipman??n kazma h??z?? artar.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 29, "&6Ustal??k Deste??i", new String[]{"&aUstal??k 1", "", " &7B??y??y?? bar??nd??ran baltan??n verdi??i &6Ustal??k EXP'si &7artar.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 31, "&6Servet", new String[]{"&aUstal??k 1", "", " &7B??y??y?? bar??nd??ran kazma ile kaz??lan", "&7ekstra malzeme d????er.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            if (enchLevel > 1) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 32, "&6K??r??lmazl??k", new String[]{"&aUstal??k 2", "", " &7B??y??y?? bar??nd??ran ekipman??n dayan??kl??l?????? artar.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 32, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 1. seviyeden y??ksek olmas?? gerekir."});
                            }

                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "arrow", 1, 50, "&aSonraki Sayfa", new String[]{"&7Sonraki sayfaya ge??mek i??in &e&lSa?? T??kla."});
                        } else if (item.getType() == Material.WOODEN_HOE) {
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 31, "&6Eklembacakl??lar'??n K??yameti", new String[]{"&aUstal??k 1", "", " &7B??y??y?? bar??nd??ran ekipman ile yap??lan sald??r??lar", " &7eklembacakl??lara ekstra hasar verir.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 30, "&6Keskinlik", new String[]{"&aUstal??k 1", "", " &7B??y??y?? bar??nd??ran ekipman??n sald??r?? hasar?? artar.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 29, "&6Darbe", new String[]{"&aUstal??k 1", "", " &7B??y??y?? bar??nd??ran ekipman ile yap??lan sald??r??lar", " &7??l?? yarat??klara daha fazla hasar verir", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 33, "&6??eki??", new String[]{"&aUstal??k 1", "", " &7B??y??y?? bar??nd??ran ekipman ile yap??lan sald??r??lar kurban?? kullan??c??ya ??eker.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 32, "&6??i??leme", new String[]{"&aUstal??k 1", "", " &7B??y??y?? bar??nd??ran ekipman ile yap??lan sald??r??lar", " &7su yarat??klar??na ekstra hasar verir.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            if (enchLevel > 1) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 34, "&6H??nerli Avc??", new String[]{"&aUstal??k 2", "", " &7B??y??y?? bar??nd??ran ekipman??n", " &7kritik hasar?? artar.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 34, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 1. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 1) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 35, "&6Bi??me", new String[]{"&aUstal??k 2", "", " &7B??y??y?? bar??nd??ran t??rpan ile yap??lan", " &7alan sald??r??lar?? ekstra hasar verir.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 35, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 1. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 1) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 38, "&6K??r??lmazl??k", new String[]{"&aUstal??k 2", "", " &7B??y??y?? bar??nd??ran ekipman??n dayan??kl??l?????? artar.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 38, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 1. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 2) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 39, "&6Tecr??be Deste??i", new String[]{"&aUstal??k 3", "", " &7B??y??y?? bar??nd??ran ekipman ile avlanan", " &7yarat??klardan ekstra tecr??be puan?? d????er.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 39, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 2. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 2) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 40, "&6??fke", new String[]{"&aUstal??k 3", "", " &7B??y??y?? bar??nd??ran ekipman ile yap??lan sald??r??lar", " &7kullan??c??y?? ??fkelendirir. Kullan??c?? ??fkesi", " &7artt??k??a ekstra hasar ve sald??r?? h??z?? kazan??r.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 40, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 2. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 2) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 41, "&6Ruh Yiyen", new String[]{"&aUstal??k 3", "", " &6??ld??r??len bir rakibin ruhunu ekipman ele ge??irir.", " &7Her 100 ruhda ekstra hasar art?????? ya??an??r.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 41, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 2. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 3) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 42, "&6Ganimet", new String[]{"&aUstal??k 4", "", " &7B??y??y?? bar??nd??ran ekipman ile ??ld??r??len", " &7kurbandan ekstra ganimet d????er.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 42, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 3. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 3) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 43, "&6S??m??r??", new String[]{"&aUstal??k 4", "", " &7B??y??y?? bar??nd??ran ekipman ile yap??lan", " &7sald??r??lar kurbandan can ??alar.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 43, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 3. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 3) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 44, "&6??nfaz", new String[]{"&aUstal??k 4", "", " &7B??y??y?? bar??nd??ran ekipman ile yap??lan sald??r??lar", " &7can?? az olan kurbanlar?? infaz eder.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 44, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 3. seviyeden y??ksek olmas?? gerekir."});
                            }

                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "arrow", 1, 50, "&aSonraki Sayfa", new String[]{"&7Sonraki sayfaya ge??mek i??in &e&lSa?? T??kla."});
                        } else if (item.getType() == Material.WOODEN_SHOVEL) {
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 31, "&6Eklembacakl??lar'??n K??yameti", new String[]{"&aUstal??k 1", "", " &7B??y??y?? bar??nd??ran ekipman ile yap??lan sald??r??lar", " &7eklembacakl??lara ekstra hasar verir.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 30, "&6Keskinlik", new String[]{"&aUstal??k 1", "", " &7B??y??y?? bar??nd??ran ekipman??n sald??r?? hasar?? artar.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 29, "&6Darbe", new String[]{"&aUstal??k 1", "", " &7B??y??y?? bar??nd??ran ekipman ile yap??lan sald??r??lar", " &7??l?? yarat??klara daha fazla hasar verir", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 33, "&6G????ertme", new String[]{"&aUstal??k 1", "", " &7B??y??y?? bar??nd??ran ekipman ile yap??lan sersemletmelerin s??resi uzar.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 32, "&6??i??leme", new String[]{"&aUstal??k 1", "", " &7B??y??y?? bar??nd??ran ekipman ile yap??lan sald??r??lar", " &7su yarat??klar??na ekstra hasar verir.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            if (enchLevel > 1) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 34, "&6H??nerli Avc??", new String[]{"&aUstal??k 2", "", " &7B??y??y?? bar??nd??ran ekipman??n", " &7kritik hasar?? artar.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 34, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 1. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 1) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 35, "&6Sersemd??ver", new String[]{"&aUstal??k 2", "", " &7Sersemlemi?? rakiplere ekstra hasar verir.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 35, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 1. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 1) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 38, "&6K??r??lmazl??k", new String[]{"&aUstal??k 2", "", " &7B??y??y?? bar??nd??ran ekipman??n dayan??kl??l?????? artar.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 38, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 1. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 2) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 39, "&6Tecr??be Deste??i", new String[]{"&aUstal??k 3", "", " &7B??y??y?? bar??nd??ran ekipman ile avlanan", " &7yarat??klardan ekstra tecr??be puan?? d????er.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 39, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 2. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 2) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 40, "&6Deprem", new String[]{"&aUstal??k 3", "", " &7B??y??y?? bar??nd??ran ekipman ile yere yap??lan sald??r??lar", " &7bir yery??z?? par??as??n?? havaya f??rlat??r.", "&7Bu par??a bir s??re sonra yere d????er", "&7ve etraf??ndakilere hasar verir.", " &7artt??k??a ekstra hasar ve sald??r?? h??z?? kazan??r.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 40, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 2. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 2) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 41, "&6Zay??flatma", new String[]{"&aUstal??k 3", "", " &7B??y??y?? bar??nd??ran ekipman ile yap??lan sald??r??lar", " &7rakibi zay??flat??r ve sald??r?? h??z??n?? d??????r??r.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 41, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 2. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 3) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 42, "&6Ganimet", new String[]{"&aUstal??k 4", "", " &7B??y??y?? bar??nd??ran ekipman ile ??ld??r??len", " &7kurbandan ekstra ganimet d????er.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 42, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 3. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 3) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 43, "&6S??m??r??", new String[]{"&aUstal??k 4", "", " &7B??y??y?? bar??nd??ran ekipman ile yap??lan", " &7sald??r??lar kurbandan can ??alar.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 43, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 3. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 3) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 44, "&6??nfaz", new String[]{"&aUstal??k 4", "", " &7B??y??y?? bar??nd??ran ekipman ile yap??lan sald??r??lar", " &7can?? az olan kurbanlar?? infaz eder.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 44, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 3. seviyeden y??ksek olmas?? gerekir."});
                            }

                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "arrow", 1, 50, "&aSonraki Sayfa", new String[]{"&7Sonraki sayfaya ge??mek i??in &e&lSa?? T??kla."});
                        } else if (item.getType() == Material.FISHING_ROD) {
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 31, "&6Denizin ??ans??", new String[]{"&aUstal??k 1", "", " &7B??y??y?? bar??nd??ran olta ile iyi bir", "&7yakalama yapma ??ans??n?? artt??r??r.", " &7eklembacakl??lara ekstra hasar verir.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 30, "&6Ayartma", new String[]{"&aUstal??k 1", "", " &7B??y??y?? bar??nd??ran oltan??n yakalama h??z??n?? artt??r??r.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 29, "&6Siftah", new String[]{"&aUstal??k 1", "", " &7B??y??y?? bar??nd??ran olta kullan??c??ya ??ifte", "&7yakalama yapma ??ans?? ekler.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 33, "&6Ustal??k Deste??i", new String[]{"&aUstal??k 1", "", " &7B??y??y?? bar??nd??ran oltan??n verdi??i &6Ustal??k EXP'si &7artar.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 32, "&6Dikenli Kanca", new String[]{"&aUstal??k 1", "", " &7B??y??y?? bar??nd??ran oltan??n verdi??i hasar?? artt??r??r.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            if (enchLevel > 1) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 34, "&6H??nerli Avc??", new String[]{"&aUstal??k 2", "", " &7B??y??y?? bar??nd??ran ekipman??n", " &7kritik hasar?? artar.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 34, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 1. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 1) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 35, "&6Deniz ????pl?????? Avc??s??", new String[]{"&aUstal??k 2", "", " &7Kullan??c??n??n denizden bal??k d??????nda", " &7di??er ??eyleri tutma ??ans??n?? artt??r??r.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 35, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 1. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 1) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 38, "&6K??r??lmazl??k", new String[]{"&aUstal??k 2", "", " &7B??y??y?? bar??nd??ran ekipman??n dayan??kl??l?????? artar.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 38, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 1. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 2) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 39, "&6Tecr??be Deste??i", new String[]{"&aUstal??k 3", "", " &7B??y??y?? bar??nd??ran ekipman ile avlanan", " &7yarat??klardan ekstra tecr??be puan?? d????er.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 39, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 2. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 2) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 40, "&6Deprem", new String[]{"&aUstal??k 3", "", " &7B??y??y?? bar??nd??ran ekipman ile yere yap??lan sald??r??lar", " &7bir yery??z?? par??as??n?? havaya f??rlat??r.", "&7Bu par??a bir s??re sonra yere d????er", "&7ve etraf??ndakilere hasar verir.", " &7artt??k??a ekstra hasar ve sald??r?? h??z?? kazan??r.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 40, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 2. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 2) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 41, "&6??ansl?? Kanca", new String[]{"&aUstal??k 3", "", " &7B??y??y?? bar??nd??ran oltaya yem harcamama olas??l?????? ekler.", " &7rakibi zay??flat??r ve sald??r?? h??z??n?? d??????r??r.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 41, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 2. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 3) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 42, "&6Ganimet", new String[]{"&aUstal??k 4", "", " &7B??y??y?? bar??nd??ran ekipman ile ??ld??r??len", " &7kurbandan ekstra ganimet d????er.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 42, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 3. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 3) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 43, "&6S??m??r??", new String[]{"&aUstal??k 4", "", " &7B??y??y?? bar??nd??ran ekipman ile yap??lan", " &7sald??r??lar kurbandan can ??alar.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 43, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 3. seviyeden y??ksek olmas?? gerekir."});
                            }

                            if (enchLevel > 3) {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 44, "&6??nfaz", new String[]{"&aUstal??k 4", "", " &7B??y??y?? bar??nd??ran ekipman ile yap??lan sald??r??lar", " &7can?? az olan kurbanlar?? infaz eder.", "", "&7Ekipman?? b??y??lemek i??in &e&lSa?? T??kla."});
                            } else {
                                this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 44, "&6??? &c(Ustal??k Yetersiz)", new String[]{"&7Bu b??y??ye eri??im sa??layabilmek i??in b??y??c??l??kteki", "&7ustal??????n??n 3. seviyeden y??ksek olmas?? gerekir."});
                            }

                            this.itemHandler.createItem(player.getOpenInventory().getTopInventory(), "arrow", 1, 50, "&aSonraki Sayfa", new String[]{"&7Sonraki sayfaya ge??mek i??in &e&lSa?? T??kla."});
                        }
                    }
                }
            } else {
                event.setCancelled(true);
                if (event.getWhoClicked().getItemOnCursor() != null && event.getCurrentItem() != null) {
                    item = event.getCurrentItem();
                    int amount = item.getAmount();
                    if (MaterialTags.SWORDS.isTagged(item) || MaterialTags.AXES.isTagged(item) || MaterialTags.BOWS.isTagged(item) || MaterialTags.PICKAXES.isTagged(item) || MaterialTags.HOES.isTagged(item) || MaterialTags.HELMETS.isTagged(item) || MaterialTags.CHESTPLATES.isTagged(item) || MaterialTags.LEGGINGS.isTagged(item) || MaterialTags.BOOTS.isTagged(item) || MaterialTags.SHOVELS.isTagged(item) || item.getType() == Material.FISHING_ROD || item.getType() == Material.BOOK || item.getType() == Material.STICK || item.getType() == Material.SHEARS && Objects.requireNonNull(item.getItemMeta().getLore()).contains(Painter.paint("&8<Bo?? B??y?? B??lmesi>"))) {
                        if (player.getInventory().firstEmpty() == -1) {
                            player.getWorld().dropItemNaturally(player.getLocation(), item);
                            event.getView().setItem(22, (ItemStack)null);
                            event.getView().setItem(28, new ItemStack(Material.RED_STAINED_GLASS_PANE));
                            event.getView().setItem(29, new ItemStack(Material.RED_STAINED_GLASS_PANE));
                            event.getView().setItem(30, new ItemStack(Material.RED_STAINED_GLASS_PANE));
                            event.getView().setItem(31, new ItemStack(Material.RED_STAINED_GLASS_PANE));
                            event.getView().setItem(32, new ItemStack(Material.RED_STAINED_GLASS_PANE));
                            event.getView().setItem(33, new ItemStack(Material.RED_STAINED_GLASS_PANE));
                            event.getView().setItem(34, new ItemStack(Material.RED_STAINED_GLASS_PANE));
                            event.getView().setItem(37, new ItemStack(Material.RED_STAINED_GLASS_PANE));
                            event.getView().setItem(38, new ItemStack(Material.RED_STAINED_GLASS_PANE));
                            event.getView().setItem(39, new ItemStack(Material.RED_STAINED_GLASS_PANE));
                            event.getView().setItem(40, new ItemStack(Material.RED_STAINED_GLASS_PANE));
                            event.getView().setItem(41, new ItemStack(Material.RED_STAINED_GLASS_PANE));
                            event.getView().setItem(42, new ItemStack(Material.RED_STAINED_GLASS_PANE));
                            event.getView().setItem(43, new ItemStack(Material.RED_STAINED_GLASS_PANE));
                        } else {
                            player.getInventory().addItem(new ItemStack[]{item});
                            event.getView().setItem(22, (ItemStack)null);
                            event.getView().setItem(28, new ItemStack(Material.RED_STAINED_GLASS_PANE));
                            event.getView().setItem(29, new ItemStack(Material.RED_STAINED_GLASS_PANE));
                            event.getView().setItem(30, new ItemStack(Material.RED_STAINED_GLASS_PANE));
                            event.getView().setItem(31, new ItemStack(Material.RED_STAINED_GLASS_PANE));
                            event.getView().setItem(32, new ItemStack(Material.RED_STAINED_GLASS_PANE));
                            event.getView().setItem(33, new ItemStack(Material.RED_STAINED_GLASS_PANE));
                            event.getView().setItem(34, new ItemStack(Material.RED_STAINED_GLASS_PANE));
                            event.getView().setItem(37, new ItemStack(Material.RED_STAINED_GLASS_PANE));
                            event.getView().setItem(38, new ItemStack(Material.RED_STAINED_GLASS_PANE));
                            event.getView().setItem(39, new ItemStack(Material.RED_STAINED_GLASS_PANE));
                            event.getView().setItem(40, new ItemStack(Material.RED_STAINED_GLASS_PANE));
                            event.getView().setItem(41, new ItemStack(Material.RED_STAINED_GLASS_PANE));
                            event.getView().setItem(42, new ItemStack(Material.RED_STAINED_GLASS_PANE));
                            event.getView().setItem(43, new ItemStack(Material.RED_STAINED_GLASS_PANE));
                        }
                    }
                }
            }
        }

        event.getCurrentItem();
    }

    @EventHandler
    public void tamirclose(InventoryCloseEvent event) {
        Player player = (Player)event.getPlayer();
        if (event.getInventory() != null & event.getView().getTitle().equals(this.guiHandler.inventory_name28) && event.getInventory().getItem(31) != null) {
            ItemStack item;
            if (player.getInventory().firstEmpty() == -1) {
                item = event.getInventory().getItem(31);
                player.getWorld().dropItemNaturally(player.getLocation(), Objects.requireNonNull(item));
            } else {
                item = event.getInventory().getItem(31);
                player.getInventory().addItem(new ItemStack[]{Objects.requireNonNull(item)});
            }
        }

    }

    @EventHandler
    public void hurdaclose(InventoryCloseEvent event) {
        Player player = (Player)event.getPlayer();
        if (event.getInventory() != null & event.getView().getTitle().equals(this.guiHandler.inventory_name8) && event.getInventory().getItem(31) != null) {
            ItemStack item;
            if (player.getInventory().firstEmpty() == -1) {
                item = event.getInventory().getItem(31);
                player.getWorld().dropItemNaturally(player.getLocation(), Objects.requireNonNull(item));
            } else {
                item = event.getInventory().getItem(31);
                player.getInventory().addItem(new ItemStack[]{Objects.requireNonNull(item)});
            }
        }

    }

    @EventHandler
    public void enchclose(InventoryCloseEvent event) {
        Player player = (Player)event.getPlayer();
        ItemStack item;
        if (event.getInventory() != null & event.getView().getTitle().equals(this.guiHandler.inventory_name7)) {
            if (event.getInventory().getItem(22) != null && event.getReason() != Reason.OPEN_NEW) {
                if (player.getInventory().firstEmpty() == -1) {
                    item = event.getInventory().getItem(22);
                    player.getWorld().dropItemNaturally(player.getLocation(), Objects.requireNonNull(item));
                } else {
                    item = event.getInventory().getItem(22);
                    player.getInventory().addItem(new ItemStack[]{Objects.requireNonNull(item)});
                }
            }
        } else if (event.getInventory() != null & event.getView().getTitle().contains("B??y?? Masas?? ->")) {
            if (player.getInventory().firstEmpty() == -1) {
                item = event.getInventory().getItem(22);
                player.getWorld().dropItemNaturally(player.getLocation(), Objects.requireNonNull(item));
            } else {
                item = event.getInventory().getItem(22);
                player.getInventory().addItem(new ItemStack[]{Objects.requireNonNull(item)});
            }
        }

    }

    @EventHandler
    public void anvilclose(InventoryCloseEvent event) {
        Player player = (Player)event.getPlayer();
        if (event.getInventory() != null & event.getView().getTitle().equals(this.guiHandler.inventory_name10)) {
            ItemStack item;
            if (event.getInventory().getItem(29) != null) {
                if (player.getInventory().firstEmpty() == -1) {
                    item = event.getInventory().getItem(29);
                    player.getWorld().dropItemNaturally(player.getLocation(), Objects.requireNonNull(item));
                } else {
                    item = event.getInventory().getItem(29);
                    player.getInventory().addItem(new ItemStack[]{Objects.requireNonNull(item)});
                }
            }

            if (event.getInventory().getItem(33) != null) {
                if (player.getInventory().firstEmpty() == -1) {
                    item = event.getInventory().getItem(33);
                    player.getWorld().dropItemNaturally(player.getLocation(), Objects.requireNonNull(item));
                } else {
                    item = event.getInventory().getItem(33);
                    player.getInventory().addItem(new ItemStack[]{Objects.requireNonNull(item)});
                }
            }
        }

    }

    @EventHandler
    public void anviltime(InventoryClickEvent event) {
        Player player = (Player)event.getWhoClicked();
        String title = event.getView().getTitle();
        if (title.equals(this.guiHandler.inventory_name10) && event.getClickedInventory() != null) {
            ItemStack item;
            ItemStack itemanvil;
            if (event.getClickedInventory().equals(player.getInventory())) {
                event.setCancelled(true);
                if (event.getWhoClicked().getItemOnCursor() != null && event.getCurrentItem() != null) {
                    item = event.getCurrentItem();
                    ItemStack item2 = event.getCurrentItem().clone();
                    if (event.getView().getItem(29) == null) {
                        if (MaterialTags.SWORDS.isTagged(item) || MaterialTags.AXES.isTagged(item) || MaterialTags.BOWS.isTagged(item) || MaterialTags.PICKAXES.isTagged(item) || MaterialTags.HOES.isTagged(item) || MaterialTags.HELMETS.isTagged(item) || MaterialTags.CHESTPLATES.isTagged(item) || MaterialTags.LEGGINGS.isTagged(item) || MaterialTags.BOOTS.isTagged(item) || MaterialTags.SHOVELS.isTagged(item) || item.getType() == Material.FISHING_ROD || item.getType() == Material.STICK || item.getType() == Material.SHEARS) {
                            item2.setAmount(1);
                            player.getInventory().removeItem(new ItemStack[]{item2});
                            event.getView().setItem(29, item2);
                        }
                    } else if (item.getType() == Material.BOOK) {
                        if (event.getView().getItem(33) == null) {
                            item2.setAmount(1);
                            player.getInventory().removeItem(new ItemStack[]{item2});
                            event.getView().setItem(33, item2);
                        }

                        itemanvil = Objects.requireNonNull(event.getView().getItem(29)).clone();
                        ItemStack book = event.getView().getItem(33);
                        NamespacedKey keytype = new NamespacedKey(this.plugin, "enchantType");
                        if (((String) Objects.requireNonNull(book.getItemMeta().getPersistentDataContainer().get(keytype, PersistentDataType.STRING))).equals(itemanvil.getItemMeta().getPersistentDataContainer().get(keytype, PersistentDataType.STRING))) {
                            if (Objects.requireNonNull(itemanvil.getItemMeta().getLore()).contains(Painter.paint("&8<Bo?? B??y?? B??lmesi>"))) {
                                ItemMeta meta = book.getItemMeta();
                                NamespacedKey key = new NamespacedKey(this.plugin, "Enchants");
                                if (meta.getPersistentDataContainer() == null) {
                                    return;
                                }

                                PersistentDataContainer container = meta.getPersistentDataContainer();
                                if (!container.has(key, this.Enchants)) {
                                    return;
                                }

                                Optional<String> firstKey = ((HashMap) Objects.requireNonNull(container.get(key, this.Enchants))).keySet().stream().findFirst();
                                if (firstKey.isPresent()) {
                                    String enchant = (String)firstKey.get();
                                    NamespacedKey string = new NamespacedKey(this.plugin, "string");
                                    int level = (Integer)((HashMap) Objects.requireNonNull(container.get(key, this.Enchants))).get(enchant);
                                    List<String> itemLore = itemanvil.getItemMeta().getLore();
                                    ItemMeta item2meta = itemanvil.getItemMeta();

                                    for(int i = 0; i < itemLore.size(); ++i) {
                                        String lValue = (String)itemLore.get(i);
                                        if (lValue.equals(Painter.paint("&8<Bo?? B??y?? B??lmesi>"))) {
                                            String var10002 = (String)container.get(string, PersistentDataType.STRING);
                                            itemLore.set(i, Painter.paint(var10002 + level));
                                            break;
                                        }
                                    }

                                    ItemMeta meta1;
                                    ArrayList lore;
                                    HashMap enchs;
                                    ItemStack buyu1;
                                    if (item2meta.getPersistentDataContainer().get(key, this.Enchants) == null) {
                                        enchs = new HashMap();
                                        enchs.put(enchant, level);
                                        item2meta.addEnchant(Enchantment.WATER_WORKER, 1, true);
                                        item2meta.getPersistentDataContainer().set(key, this.Enchants, enchs);
                                        item2meta.setLore(itemLore);
                                        itemanvil.setItemMeta(item2meta);
                                        event.getView().setItem(40, itemanvil);
                                        buyu1 = new ItemStack(Material.ANVIL);
                                        meta1 = buyu1.getItemMeta();
                                        lore = new ArrayList();
                                        meta1.setDisplayName(Painter.paint("&eMalzemeleri Birle??tir"));
                                        lore.add(Painter.paint("&7Sa??daki ve soldaki b??lmelere koydu??un "));
                                        lore.add(Painter.paint("&7malzemeleri birle??tirebilirsin."));
                                        lore.add(Painter.paint(""));
                                        lore.add(Painter.paint(" &7Maliyet:"));
                                        lore.add(Painter.paint(" &7-&f " + level * 5 + " &fSeviye"));
                                        lore.add(Painter.paint(""));
                                        lore.add(Painter.paint("&7Birle??tirmek i??in yukar??daki ekipmana &e&lSa?? T??kla."));
                                        meta1.setLore(lore);
                                        buyu1.setItemMeta(meta1);
                                        event.getView().setItem(49, buyu1);
                                        lore.clear();
                                    } else {
                                        enchs = (HashMap)item2meta.getPersistentDataContainer().get(key, this.Enchants);
                                        Objects.requireNonNull(enchs).put(enchant, level);
                                        item2meta.addEnchant(Enchantment.WATER_WORKER, 1, true);
                                        item2meta.getPersistentDataContainer().set(key, this.Enchants, enchs);
                                        item2meta.setLore(itemLore);
                                        itemanvil.setItemMeta(item2meta);
                                        event.getView().setItem(40, itemanvil);
                                        buyu1 = new ItemStack(Material.ANVIL);
                                        meta1 = buyu1.getItemMeta();
                                        lore = new ArrayList();
                                        meta1.setDisplayName(Painter.paint("&eMalzemeleri Birle??tir"));
                                        lore.add(Painter.paint("&7Sa??daki ve soldaki b??lmelere koydu??un "));
                                        lore.add(Painter.paint("&7malzemeleri birle??tirebilirsin."));
                                        lore.add(Painter.paint(""));
                                        lore.add(Painter.paint(" &7Maliyet:"));
                                        lore.add(Painter.paint(" &7-&f " + level * 5 + " &fSeviye"));
                                        lore.add(Painter.paint(""));
                                        lore.add(Painter.paint("&7Birle??tirmek i??in yukar??daki ekipmana &e&lSa?? T??kla."));
                                        meta1.setLore(lore);
                                        buyu1.setItemMeta(meta1);
                                        event.getView().setItem(49, buyu1);
                                        lore.clear();
                                    }
                                }
                            }
                        } else {
                            ItemStack buyu1 = new ItemStack(Material.BARRIER);
                            ItemMeta meta1 = buyu1.getItemMeta();
                            List<String> lore = new ArrayList();
                            meta1.setDisplayName(Painter.paint("&cBu malzemeler birle??emez!"));
                            lore.add(Painter.paint("&7Sa??daki ve soldaki b??lmelere koydu??un "));
                            lore.add(Painter.paint("&7malzemeler birbirlerine uygun de??il!"));
                            meta1.setLore(lore);
                            buyu1.setItemMeta(meta1);
                            event.getView().setItem(40, buyu1);
                            lore.clear();
                        }
                    }
                }
            } else {
                event.setCancelled(true);
                if (event.getWhoClicked().getItemOnCursor() != null && event.getCurrentItem() != null) {
                    item = event.getCurrentItem();
                    int amount = item.getAmount();
                    if (item.equals(event.getView().getItem(40))) {
                        itemanvil = event.getView().getItem(49);
                        ItemMeta levelmeta = Objects.requireNonNull(itemanvil).getItemMeta();
                        List<String> lore = levelmeta.getLore();
                        String level = (String) Objects.requireNonNull(lore).get(4);
                        String xp = level.toString().split(" ")[2];
                        int i = Integer.parseInt(xp);
                        if (player.getLevel() > i) {
                            if (player.getInventory().firstEmpty() == -1) {
                                player.setLevel(player.getLevel() - i);
                                player.playSound(player, Sound.BLOCK_ANVIL_USE, 2.0F, 0.6F);
                                player.getWorld().dropItemNaturally(player.getLocation(), item);
                                event.getView().setItem(29, (ItemStack)null);
                                event.getView().setItem(33, (ItemStack)null);
                                event.getView().setItem(40, (ItemStack)null);
                                event.getView().setItem(49, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
                            } else {
                                player.playSound(player, Sound.BLOCK_ANVIL_USE, 2.0F, 0.6F);
                                player.setLevel(player.getLevel() - i);
                                player.getInventory().addItem(new ItemStack[]{item});
                                event.getView().setItem(29, (ItemStack)null);
                                event.getView().setItem(40, (ItemStack)null);
                                event.getView().setItem(33, (ItemStack)null);
                                event.getView().setItem(49, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
                            }
                        } else {
                            player.sendMessage(Painter.paint("&cYeterli seviyeye sahip de??ilsin!"));
                        }
                    }
                }
            }
        }

        event.getCurrentItem();
    }
}
