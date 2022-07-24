package me.taylan.mooncore.listeners;

import com.destroystokyo.paper.MaterialTags;
import com.manya.pdc.DataTypes;
import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.*;
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
import org.bukkit.event.player.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.io.IOException;
import java.util.*;

public class InventoryClickListener implements Listener {
    private static HashMap<UUID, Block> SmithBlock = new HashMap<UUID, Block>();
    private static HashMap<UUID, Block> CookBlock = new HashMap<UUID, Block>();
    private static HashMap<UUID, Block> FurnaceBlock = new HashMap<UUID, Block>();

    public static HashMap<UUID, Block> getRealFurnaceBlock() {
        return RealFurnaceBlock;
    }

    private static HashMap<UUID, Block> RealFurnaceBlock = new HashMap<UUID, Block>();
    private static HashMap<UUID, Block> ElSanatBlock = new HashMap<UUID, Block>();
    private MoonCore plugin;
    private ItemHandler itemHandler;
    private GuiHandler guiHandler;
    private StatsManager stats;

    public InventoryClickListener(MoonCore plugin) {
        this.stats = plugin.getStatsManager();
        this.plugin = plugin;
        this.itemHandler = plugin.getItemHandler();
        this.guiHandler = plugin.getGuiHandler();

        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    private PersistentDataType<?, HashMap<String, Integer>> Enchants = DataTypes.hashMap(PersistentDataType.STRING,
            PersistentDataType.INTEGER);

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
        if (title.equals(guiHandler.inventory_name)) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            guiHandler.clicked((Player) event.getWhoClicked(), event.getSlot(), event.getCurrentItem(),
                    event.getInventory());
            Player player = (Player) event.getWhoClicked();
            player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2, 1.1f);

        }
    }

    @EventHandler
    public void Cook(PlayerInteractEvent event) {

        Player player = event.getPlayer();
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Block block = event.getClickedBlock();
            if (block.getType() == Material.SMOKER) {

                int cookProduct = stats.getCookProduction(player.getUniqueId());
                if (cookProduct <= 0) {
                    if (!(CookBlock.containsKey(player.getUniqueId()))) {
                        CookBlock.put(player.getUniqueId(), block);
                    }
                    event.setCancelled(true);
                    player.openInventory(guiHandler.cookGui(player));
                } else {
                    if (!(CookBlock.containsKey(player.getUniqueId()))) {
                        CookBlock.put(player.getUniqueId(), block);
                    }
                    event.setCancelled(true);
                    player.openInventory(guiHandler.productCook(player));
                }

            }
        }
    }

   /* @EventHandler
    public void ElSanatClose(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();
        if (ElSanatBlock.containsKey(player.getUniqueId())) {
            if (event.getView().getTitle()
                    .contains("El Sanatları Masası") || event.getView().getTitle()
                    .contains("Deri Dik") || event.getView().getTitle()
                    .contains("Yay Ger") || event.getView().getTitle()
                    .contains("El Sanatları Deposu")) {
                ElSanatBlock.remove(player.getUniqueId());
            }
        }
    }*/

    /*@EventHandler
    public void FurnaceClose(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();
        if (FurnaceBlock.containsKey(player.getUniqueId())) {
            if (event.getView().getTitle()
                    .contains("Fırın") || event.getView().getTitle()
                    .contains("Fırın Deposu")) {
                FurnaceBlock.remove(player.getUniqueId());
            }
        }
    }*/

    /*@EventHandler
    public void CookClose(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();
        if (CookBlock.containsKey(player.getUniqueId())) {
            int production = stats.getCookProduction(player.getUniqueId());
            if (event.getView().getTitle()
                    .contains("Ocak") || event.getView().getTitle()
                    .contains("Ocak Deposu")) {
                CookBlock.remove(player.getUniqueId());

            }
        }
    }*/

    @EventHandler
    public void playerclosejob(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();
        String title = event.getView().getTitle();
        if (title.equals(guiHandler.inventory_name2)) {
            if (GuiHandler.job.containsKey(player.getUniqueId())) {
                GuiHandler.job.remove(player.getUniqueId());
            }
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

            guiHandler.clicked((Player) event.getWhoClicked(), event.getSlot(), event.getCurrentItem(),
                    event.getInventory());
            Player player = (Player) event.getWhoClicked();
            player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2, 1.1f);

        }
    }

    @EventHandler
    public void booktake(PlayerTakeLecternBookEvent event) {
        Player player = event.getPlayer();
        if (!(player.isOp())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {

        Player p = (Player) event.getWhoClicked();
        Inventory clicked = event.getClickedInventory();
        if (event.getInventory().getHolder() instanceof Chest || event.getInventory().getHolder() instanceof DoubleChest) {

            if (clicked == event.getWhoClicked().getInventory()) {

                ItemStack clickedOn = event.getCurrentItem();
                if (clickedOn != null && event.getCurrentItem().hasItemMeta() && event.getCurrentItem().getItemMeta().displayName().contains(MiniMessage.builder().build().deserialize("Oyuncu El Kitabı")
                )) {
                    event.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void resource222(InventoryClickEvent event) {
        String title = event.getView().getTitle();
        if (title.contains("Üretimler")) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }
            guiHandler.clicked((Player) event.getWhoClicked(), event.getSlot(), event.getCurrentItem(),
                    event.getInventory());
            Player player = (Player) event.getWhoClicked();
            player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2, 1.1f);

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
        if (title.contains("Ekipman İşleme ->")) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            guiHandler.clicked((Player) event.getWhoClicked(), event.getSlot(), event.getCurrentItem(),
                    event.getInventory());
            Player player = (Player) event.getWhoClicked();
            player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2, 1.1f);

        }
    }

    @EventHandler
    public void onClick2(InventoryClickEvent event) {
        String title = event.getView().getTitle();
        if (title.equals(guiHandler.inventory_name2)) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            guiHandler.clicked((Player) event.getWhoClicked(), event.getSlot(), event.getCurrentItem(),
                    event.getInventory());
            Player player = (Player) event.getWhoClicked();
            player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2, 1.1f);

        }
    }

    @EventHandler
    public void onClick11(InventoryClickEvent event) {
        String title = event.getView().getTitle();
        if (title.equals(guiHandler.inventory_name11)) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            guiHandler.clicked((Player) event.getWhoClicked(), event.getSlot(), event.getCurrentItem(),
                    event.getInventory());
            Player player = (Player) event.getWhoClicked();
            player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2, 1.1f);

        }
    }

    @EventHandler
    public void oninventory(InventoryCloseEvent event) {
        String title = event.getView().getTitle();
        Player player = (Player) event.getPlayer();
        if (title.equals(guiHandler.inventory_name14)) {
            if (guiHandler.zerola.containsKey(player.getUniqueId())) {
                guiHandler.zerola.remove(player.getUniqueId());
            }
        }
    }

    @EventHandler
    public void onClick3(InventoryClickEvent event) {
        String title = event.getView().getTitle();
        if (title.equals(guiHandler.inventory_name3)) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            guiHandler.clicked((Player) event.getWhoClicked(), event.getSlot(), event.getCurrentItem(),
                    event.getInventory());
            Player player = (Player) event.getWhoClicked();
            player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2, 1.1f);

        }
    }

    @EventHandler
    public void onClickench(InventoryClickEvent event) {
        String title = event.getView().getTitle();
        if (title.equals(guiHandler.inventory_name7)) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            guiHandler.clicked((Player) event.getWhoClicked(), event.getSlot(), event.getCurrentItem(),
                    event.getInventory());

        }
    }

    @EventHandler
    public void onClickench22(InventoryClickEvent event) {
        String title = event.getView().getTitle();
        if (title.equals(guiHandler.inventory_name15)) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            guiHandler.clicked((Player) event.getWhoClicked(), event.getSlot(), event.getCurrentItem(),
                    event.getInventory());

        }
    }

    @EventHandler
    public void onClickench222(InventoryClickEvent event) {
        String title = event.getView().getTitle();
        if (title.equals(guiHandler.inventory_name16)) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            guiHandler.clicked((Player) event.getWhoClicked(), event.getSlot(), event.getCurrentItem(),
                    event.getInventory());

        }
    }

    @EventHandler
    public void questclic(InventoryClickEvent event) {
        String title = event.getView().getTitle();
        if (title.equals(guiHandler.inventory_name24)) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            guiHandler.clicked((Player) event.getWhoClicked(), event.getSlot(), event.getCurrentItem(),
                    event.getInventory());
            Player player = (Player) event.getWhoClicked();
            player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2, 1.1f);

        }
    }

    @EventHandler
    public void onClick42(InventoryClickEvent event) {
        String title = event.getView().getTitle();
        if (title.equals(guiHandler.inventory_name22)) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            guiHandler.clicked((Player) event.getWhoClicked(), event.getSlot(), event.getCurrentItem(),
                    event.getInventory());
            Player player = (Player) event.getWhoClicked();
            player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2, 1.1f);

        }
    }

    @EventHandler
    public void onClick4(InventoryClickEvent event) {
        String title = event.getView().getTitle();
        if (title.equals(guiHandler.inventory_name4)) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            guiHandler.clicked((Player) event.getWhoClicked(), event.getSlot(), event.getCurrentItem(),
                    event.getInventory());
            Player player = (Player) event.getWhoClicked();
            player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2, 1.1f);

        }
    }

    @EventHandler
    public void onClick20(InventoryClickEvent event) {
        String title = event.getView().getTitle();
        if (title.equals(guiHandler.inventory_name13)) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            guiHandler.clicked((Player) event.getWhoClicked(), event.getSlot(), event.getCurrentItem(),
                    event.getInventory());
            Player player = (Player) event.getWhoClicked();
            player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2, 1.1f);

        }
    }

    @EventHandler
    public void onClickKnowledge(PlayerSwapHandItemsEvent event) {
        NamespacedKey star = new NamespacedKey(plugin, "star");
        Player player = (Player) event.getPlayer();
        if (event.getOffHandItem() != null && event.getOffHandItem().hasItemMeta() && event.getOffHandItem().getItemMeta().getPersistentDataContainer() != null) {
            if (event.getOffHandItem().getItemMeta().getPersistentDataContainer().has(star,
                    PersistentDataType.STRING)) {
                event.setCancelled(true);
                player.openInventory(guiHandler.bilgikitabı(player));

            }
        }
    }

    @EventHandler
    public void onClickKnowledge(InventoryClickEvent event) {
        NamespacedKey star = new NamespacedKey(plugin, "star");
        Player player = (Player) event.getWhoClicked();
        if (event.getWhoClicked().getItemOnCursor() != null && event.getCurrentItem() != null && event.getCurrentItem().hasItemMeta() && event.getCurrentItem().getItemMeta().getPersistentDataContainer() != null) {
            if (event.getCurrentItem().getItemMeta().getPersistentDataContainer().has(star,
                    PersistentDataType.STRING)) {
                event.setCancelled(true);
                if (event.getWhoClicked().getItemOnCursor().hasItemMeta() && event.getWhoClicked().getItemOnCursor().getItemMeta().getPersistentDataContainer() != null && event.getWhoClicked().getItemOnCursor().getItemMeta().getPersistentDataContainer().has(star)) {

                    player.setItemOnCursor(null);
                }
                player.openInventory(guiHandler.bilgikitabı(player));
            }
        }
    }

    @EventHandler
    public void Claimbilgi(InventoryClickEvent event) {
        String title = event.getView().getTitle();
        Player player = (Player) event.getWhoClicked();
        if (title.equals(guiHandler.inventory_name23)) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            guiHandler.clicked((Player) event.getWhoClicked(), event.getSlot(), event.getCurrentItem(),
                    event.getInventory());
            player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2, 1.1f);

        }
    }

    @EventHandler
    public void onClicknitelik(InventoryClickEvent event) {
        String title = event.getView().getTitle();
        Player player = (Player) event.getWhoClicked();
        if (title.equals(guiHandler.inventory_name14)) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            guiHandler.clicked((Player) event.getWhoClicked(), event.getSlot(), event.getCurrentItem(),
                    event.getInventory());
            player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2, 1.1f);

        }
    }

    @EventHandler
    public void onClickBackPack(InventoryClickEvent event) {
        NamespacedKey backp = new NamespacedKey(plugin, "backpack");
        String title = event.getView().getTitle();
        Player player = (Player) event.getWhoClicked();
        if (event.getCurrentItem() == null) {
            return;
        }
        if (title.contains("Çanta")) {
            if (event.getCurrentItem().hasItemMeta() && event.getCurrentItem().getItemMeta().getPersistentDataContainer() != null && event.getCurrentItem().getItemMeta().getPersistentDataContainer().has(backp)) {
                event.setCancelled(true);
            }


        }
    }

    @EventHandler
    public void dropbackpack(PlayerDropItemEvent event) throws IOException {
        NamespacedKey backp = new NamespacedKey(plugin, "backpack");
        NamespacedKey backpslot = new NamespacedKey(plugin, "backpackslot");
        Player player = event.getPlayer();
        ItemStack item = event.getItemDrop().getItemStack();
        if (item.hasItemMeta() && item != null) {
            if (item.getItemMeta().getPersistentDataContainer().has(backp, PersistentDataType.STRING)) {
                event.setCancelled(true);
                if (!(item.getItemMeta().getPersistentDataContainer().get(backp, PersistentDataType.STRING).equals("Yok.."))) {
                    String contents = item.getItemMeta().getPersistentDataContainer().get(backp, PersistentDataType.STRING);
                    Inventory inventory = Bukkit.createInventory(null, item.getItemMeta().getPersistentDataContainer().get(backpslot, PersistentDataType.INTEGER), item.getItemMeta().getDisplayName());
                    ItemStack[] inv = BukkitSerialization.itemStackArrayFromBase64(contents);
                    inventory.setContents(inv);
                    player.openInventory(inventory);

                } else {
                    player.openInventory(Bukkit.createInventory(null, item.getItemMeta().getPersistentDataContainer().get(backpslot, PersistentDataType.INTEGER), item.getItemMeta().getDisplayName()));
                }
            }
        }
    }


    @EventHandler
    public void dropbook(PlayerDropItemEvent event) {
        NamespacedKey star = new NamespacedKey(plugin, "star");
        Player player = event.getPlayer();
        ItemStack item = event.getItemDrop().getItemStack();
        if (item.hasItemMeta() && item != null) {
            if (item.getItemMeta().getPersistentDataContainer().has(star, PersistentDataType.STRING)) {
                event.setCancelled(true);
                player.openInventory(guiHandler.bilgikitabı(player));
                player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2, 1.2f);
            }
        }
    }

    @EventHandler
    public void clickbook(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        NamespacedKey star = new NamespacedKey(plugin, "star");
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (player.getInventory().getItemInMainHand().hasItemMeta()
                    && player.getInventory().getItemInMainHand() != null) {
                if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().has(star,
                        PersistentDataType.STRING)) {
                    event.setCancelled(true);
                    player.openInventory(guiHandler.bilgikitabı(player));
                    player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2, 1.2f);
                }
            }
        }
    }

    @EventHandler
    public void clickbook2(PlayerInteractEvent event) throws IOException {
        Player player = event.getPlayer();
        NamespacedKey backp = new NamespacedKey(plugin, "backpack");
        NamespacedKey backpslot = new NamespacedKey(plugin, "backpackslot");
        ItemStack item = player.getInventory().getItemInMainHand();
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (player.getInventory().getItemInMainHand().hasItemMeta()
                    && player.getInventory().getItemInMainHand() != null) {
                if (item.getItemMeta().getPersistentDataContainer().has(backp,
                        PersistentDataType.STRING) && item.getItemMeta().getPersistentDataContainer().has(backpslot,
                        PersistentDataType.INTEGER)) {


                    if (!(item.getItemMeta().getPersistentDataContainer().get(backp, PersistentDataType.STRING).equals("Yok.."))) {
                        String contents = item.getItemMeta().getPersistentDataContainer().get(backp, PersistentDataType.STRING);
                        Inventory inventory = Bukkit.createInventory(null, item.getItemMeta().getPersistentDataContainer().get(backpslot, PersistentDataType.INTEGER), item.getItemMeta().getDisplayName());
                        ItemStack[] inv = BukkitSerialization.itemStackArrayFromBase64(contents);
                        inventory.setContents(inv);
                        player.openInventory(inventory);

                    } else {
                        player.openInventory(Bukkit.createInventory(null, item.getItemMeta().getPersistentDataContainer().get(backpslot, PersistentDataType.INTEGER), item.getItemMeta().getDisplayName()));
                    }

                }
            }
        }
    }

    @EventHandler
    public void Backpackclose(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();
        String title = event.getView().getTitle();
        if (title.contains("Çanta")) {
            NamespacedKey backp = new NamespacedKey(plugin, "backpack");
            NamespacedKey backpslot = new NamespacedKey(plugin, "backpackslot");
            ItemStack item = player.getInventory().getItemInMainHand();
            ItemMeta meta = item.getItemMeta();
            if (item != null && item.hasItemMeta()
            ) {
                if (meta.getPersistentDataContainer().has(backp,
                        PersistentDataType.STRING) && meta.getPersistentDataContainer().has(backpslot,
                        PersistentDataType.INTEGER)) {
                    String invToBase64work = BukkitSerialization
                            .itemStackArrayToBase64(event.getView().getTopInventory().getContents());
                    meta.getPersistentDataContainer().set(backp, PersistentDataType.STRING, invToBase64work);
                    item.setItemMeta(meta);

                }
            }
        }
    }


    @EventHandler

    public void onClick622(InventoryClickEvent event) {
        String title = event.getView().getTitle();
        if (title.equals(guiHandler.inventory_name6)) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            guiHandler.clicked((Player) event.getWhoClicked(), event.getSlot(), event.getCurrentItem(),
                    event.getInventory());
            Player player = (Player) event.getWhoClicked();
            player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2, 1.1f);

        }
    }

    @EventHandler
    public void onClick6222(InventoryClickEvent event) {
        String title = event.getView().getTitle();
        if (title.equals(guiHandler.inventory_name9)) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            guiHandler.clicked((Player) event.getWhoClicked(), event.getSlot(), event.getCurrentItem(),
                    event.getInventory());
            Player player = (Player) event.getWhoClicked();
            player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2, 1.1f);

        }
    }


    @EventHandler
    public void onClick622321(InventoryClickEvent event) {
        String title = event.getView().getTitle();
        if (title.equals(guiHandler.inventory_name19)) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            guiHandler.clicked((Player) event.getWhoClicked(), event.getSlot(), event.getCurrentItem(),
                    event.getInventory());
            Player player = (Player) event.getWhoClicked();
            player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2, 1.1f);

        }
    }

    @EventHandler
    public void onClick62232(InventoryClickEvent event) {
        String title = event.getView().getTitle();
        if (title.equals(guiHandler.inventory_name18)) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            guiHandler.clicked((Player) event.getWhoClicked(), event.getSlot(), event.getCurrentItem(),
                    event.getInventory());
            Player player = (Player) event.getWhoClicked();
            player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2, 1.1f);

        }
    }

    @EventHandler
    public void onClick622222(InventoryClickEvent event) {
        String title = event.getView().getTitle();
        if (title.equals(guiHandler.inventory_name21)) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            guiHandler.clicked((Player) event.getWhoClicked(), event.getSlot(), event.getCurrentItem(),
                    event.getInventory());
            Player player = (Player) event.getWhoClicked();
            player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2, 1.1f);

        }
    }

    @EventHandler
    public void onClick62222(InventoryClickEvent event) {
        String title = event.getView().getTitle();
        if (title.equals(guiHandler.inventory_name17)) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            guiHandler.clicked((Player) event.getWhoClicked(), event.getSlot(), event.getCurrentItem(),
                    event.getInventory());
            Player player = (Player) event.getWhoClicked();
            player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2, 1.1f);

        }
    }

    @EventHandler
    public void onClickPorfile2(InventoryClickEvent event) {
        Inventory inv = event.getInventory();
        if (inv == guiHandler.inv17) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            guiHandler.clicked((Player) event.getWhoClicked(), event.getSlot(), event.getCurrentItem(),
                    event.getInventory());
            Player player = (Player) event.getWhoClicked();
            player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2, 1.1f);

        }
    }

    @EventHandler
    public void onClickFletch(InventoryClickEvent event) {
        Inventory inv = event.getInventory();
        if (inv == guiHandler.inv17) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            guiHandler.clicked((Player) event.getWhoClicked(), event.getSlot(), event.getCurrentItem(),
                    event.getInventory());
            Player player = (Player) event.getWhoClicked();
            player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2, 1.1f);

        }
    }

    @EventHandler
    public void onClickLeatherFletch(InventoryClickEvent event) {
        Inventory inv = event.getInventory();
        if (inv == guiHandler.inv19) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            guiHandler.clicked((Player) event.getWhoClicked(), event.getSlot(), event.getCurrentItem(),
                    event.getInventory());
            Player player = (Player) event.getWhoClicked();
            player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2, 1.1f);

        }
    }

    @EventHandler
    public void onClickLeatherFletch2(InventoryClickEvent event) {
        Inventory inv = event.getInventory();
        if (inv == guiHandler.inv21) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            guiHandler.clicked((Player) event.getWhoClicked(), event.getSlot(), event.getCurrentItem(),
                    event.getInventory());
            Player player = (Player) event.getWhoClicked();
            player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2, 1.1f);

        }
    }

    @EventHandler
    public void onClickFishingFletch(InventoryClickEvent event) {
        Inventory inv = event.getInventory();
        if (inv == guiHandler.inv20) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            guiHandler.clicked((Player) event.getWhoClicked(), event.getSlot(), event.getCurrentItem(),
                    event.getInventory());
            Player player = (Player) event.getWhoClicked();
            player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2, 1.1f);

        }
    }

    @EventHandler
    public void onClickPorfile(InventoryClickEvent event) {
        Inventory inv = event.getInventory();
        if (inv == guiHandler.inv12) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            guiHandler.clicked((Player) event.getWhoClicked(), event.getSlot(), event.getCurrentItem(),
                    event.getInventory());
            Player player = (Player) event.getWhoClicked();
            player.playSound(player, Sound.UI_LOOM_SELECT_PATTERN, 2, 1.1f);

        }
    }

    @EventHandler
    public void onrod(InventoryClickEvent event) {
        String title = event.getView().getTitle();
        if (title.equals(guiHandler.inventory_name20)) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            guiHandler.clicked((Player) event.getWhoClicked(), event.getSlot(), event.getCurrentItem(),
                    event.getInventory());

        }

    }

    @EventHandler
    public void onClick62(InventoryClickEvent event) {
        String title = event.getView().getTitle();
        if (title.equals(guiHandler.inventory_name8)) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            guiHandler.clicked((Player) event.getWhoClicked(), event.getSlot(), event.getCurrentItem(),
                    event.getInventory());

        }

    }

    @EventHandler
    public void onClick6212(InventoryClickEvent event) {
        String title = event.getView().getTitle();
        if (title.equals(guiHandler.inventory_name26)) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }

            guiHandler.clicked((Player) event.getWhoClicked(), event.getSlot(), event.getCurrentItem(),
                    event.getInventory());

        }

    }

    @EventHandler
    public void onClickEnv(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        String title = event.getView().getTitle();
        if (title.equalsIgnoreCase(Painter.paint("&8Depo"))) {
            if (event.getClickedInventory() != null
                    && event.getClickedInventory().equals(JoinListener.getMenu().get(player.getUniqueId()))) {
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
        if (event.getClickedBlock() != null) {
            if (event.getClickedBlock().getType() == Material.ENCHANTING_TABLE) {
                if (player.hasPermission("mooncore.ench")) {

                    event.setCancelled(true);
                    player.openInventory(guiHandler.GUIENCH(player));


                } else {
                    player.sendMessage(Painter.paint("&cBüyü masasını kullanabilmek için &dSaorin'in &cgörevlerini bitirmen gerek."));
                }
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
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (event.getClickedBlock().getType() == Material.ANVIL) {
                Block block = event.getClickedBlock();

                event.setCancelled(true);
                player.openInventory(guiHandler.anvilgui(player));

            }
        }
    }

    public boolean hasScaffold(Block block) {
        if (block.getRelative(BlockFace.NORTH).getType().equals(Material.SCAFFOLDING)) return true;
        if (block.getRelative(BlockFace.SOUTH).getType().equals(Material.SCAFFOLDING)) return true;
        if (block.getRelative(BlockFace.EAST).getType().equals(Material.SCAFFOLDING)) return true;
        if (block.getRelative(BlockFace.WEST).getType().equals(Material.SCAFFOLDING)) return true;
        return false;
    }

    @EventHandler
    public void profil(PlayerInteractEntityEvent event) {

        Player player = event.getPlayer();
        Entity entity = event.getRightClicked();
        if (!(entity instanceof Player)) {
            return;
        }

        Player clickedplayer = (Player) entity;
        if (stats.hasPlayedBefore(clickedplayer.getUniqueId())) {


            if (player.isSneaking()) {
                player.openInventory(guiHandler.profil(player, clickedplayer));
                ArrayList<ItemStack> list = (ArrayList<ItemStack>) stats.getHepsi(clickedplayer.getUniqueId());
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
                if (!(stats.getKolye(clickedplayer.getUniqueId()).equals("Yok.."))) {
                    player.getOpenInventory().getTopInventory().setItem(21, list.get(2));
                }
                if (!(stats.getTilsim(clickedplayer.getUniqueId()).equals("Yok.."))) {
                    player.getOpenInventory().getTopInventory().setItem(23, list.get(0));
                }
                if (!(stats.getEldiven(clickedplayer.getUniqueId()).equals("Yok.."))) {
                    player.getOpenInventory().getTopInventory().setItem(30, list.get(1));
                }
                if (!(stats.getYuzuk(clickedplayer.getUniqueId()).equals("Yok.."))) {
                    player.getOpenInventory().getTopInventory().setItem(32, list.get(3));
                }
            }
        }

    }

    @EventHandler
    public void RealFurnaceaga(InventoryOpenEvent event) {
        Player player = (Player) event.getPlayer();
        if (event.getInventory().getType() == InventoryType.ANVIL || event.getInventory().getType() == InventoryType.FURNACE || event.getInventory().getType() == InventoryType.BLAST_FURNACE || event.getInventory().getType() == InventoryType.SMOKER || event.getInventory().getType() == InventoryType.SMITHING) {
            event.setCancelled(true);
        }

    }

    @EventHandler
    public void RealFurnace(PlayerInteractEvent event) {

        Player player = event.getPlayer();
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Block block = event.getClickedBlock();
            if (block.getType() == Material.FURNACE) {

                int cookProduct = stats.getRealFurnaceProduction(player.getUniqueId());
                if (cookProduct <= 0) {
                    if (!(RealFurnaceBlock.containsKey(player.getUniqueId()))) {
                        RealFurnaceBlock.put(player.getUniqueId(), block);
                    }
                    event.setCancelled(true);
                    player.openInventory(guiHandler.realFurnaceGui(player));
                } else {
                    if (!(RealFurnaceBlock.containsKey(player.getUniqueId()))) {
                        RealFurnaceBlock.put(player.getUniqueId(), block);
                    }
                    event.setCancelled(true);
                    player.openInventory(guiHandler.productRealFurnace(player));
                }

            }
        }
    }

    @EventHandler
    public void Furnace(PlayerInteractEvent event) {

        Player player = event.getPlayer();
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Block block = event.getClickedBlock();
            if (block.getType() == Material.BLAST_FURNACE) {

                int cookProduct = stats.getFurnaceProduction(player.getUniqueId());
                if (cookProduct <= 0) {
                    if (!(FurnaceBlock.containsKey(player.getUniqueId()))) {
                        FurnaceBlock.put(player.getUniqueId(), block);
                    }
                    event.setCancelled(true);
                    player.openInventory(guiHandler.Furnace(player));
                } else {
                    if (!(FurnaceBlock.containsKey(player.getUniqueId()))) {
                        FurnaceBlock.put(player.getUniqueId(), block);
                    }
                    event.setCancelled(true);
                    player.openInventory(guiHandler.furnaceproduct(player));
                }

            }
        }
    }

    @EventHandler
    public void Fletch(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (event.getClickedBlock().getType() == Material.FLETCHING_TABLE) {
                if (hasScaffold(event.getClickedBlock())) {
                    Block block = event.getClickedBlock();
                    ElSanatBlock.put(player.getUniqueId(), block);
                    int timer = stats.getWorkProduction(player.getUniqueId());
                    if (timer <= 0) {
                        event.setCancelled(true);
                        player.openInventory(guiHandler.Fletching(player));

                    } else {
                        event.setCancelled(true);
                        player.openInventory(guiHandler.elsanatproduct(player));

                    }

                } else {
                    player.sendMessage(Painter.paint("&cAhşaplarla çalışabilmen için bir masa gerek."));
                }
            }
        }
    }

    @EventHandler
    public void Smith(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (event.getClickedBlock().getType() == Material.SMITHING_TABLE) {

                Block block = event.getClickedBlock();
                SmithBlock.put(player.getUniqueId(), block);
                int timer = stats.getProduction(player.getUniqueId());
                int timer2 = stats.getProduction1(player.getUniqueId());
                if (timer <= 0 && timer2 <= 0) {
                    event.setCancelled(true);
                    player.openInventory(guiHandler.demircimasasasas(player));

                } else {
                    event.setCancelled(true);
                    player.openInventory(guiHandler.product(player));

                }


            }
        }
    }


    /*@EventHandler
    public void SmithClose(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();
        if (SmithBlock.containsKey(player.getUniqueId())) {
            int production = stats.getProduction(player.getUniqueId());
            int production1 = stats.getProduction1(player.getUniqueId());
            if (event.getView().getTitle().contains("Demirci Masası") || event.getView().getTitle().contains("Depo")
                    || event.getInventory().equals(guiHandler.product(player)) || event.getView().getTitle().contains("Ekipman İşleme ->")) {
                SmithBlock.remove(player.getUniqueId());

            }
        }
    }*/

    @EventHandler
    public void onClickEncha(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        String title = event.getView().getTitle();
        if (title.equals(guiHandler.inventory_name7)) {
            if (event.getClickedInventory() != null && event.getClickedInventory().equals(player.getInventory())) {
                event.setCancelled(true);
                if (event.getWhoClicked().getItemOnCursor() != null && event.getCurrentItem() != null) {
                    ItemStack item = event.getCurrentItem();
                    ItemStack item2 = event.getCurrentItem().clone();

                    if (MaterialTags.SWORDS.isTagged(item) || MaterialTags.AXES.isTagged(item)
                            || MaterialTags.BOWS.isTagged(item) || MaterialTags.PICKAXES.isTagged(item)
                            || MaterialTags.HOES.isTagged(item) || MaterialTags.HELMETS.isTagged(item)
                            || MaterialTags.CHESTPLATES.isTagged(item) || MaterialTags.LEGGINGS.isTagged(item)
                            || MaterialTags.BOOTS.isTagged(item) || MaterialTags.SHOVELS.isTagged(item)
                            || item.getType() == Material.FISHING_ROD || item.getType() == Material.BOOK
                            && (item.getItemMeta().getLore().contains(Painter.paint("&8<Boş Büyü Bölmesi>")))) {
                        int enchLevel = stats.getEnchLevel(player.getUniqueId());
                        if (event.getView().getItem(22) == null) {
                            int amount = item.getAmount();
                            item2.setAmount(1);
                            player.getInventory().removeItem(item2);
                            event.getView().setItem(22, item2);
                        }
                        if (MaterialTags.SWORDS.isTagged(item)) {

                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 31, "&6Eklembacaklılar'ın Kıyameti", "&aUstalık 1", "", " &7Büyüyü barındıran ekipman ile yapılan saldırılar", " &7eklembacaklılara ekstra hasar verir.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 30, "&6Keskinlik", "&aUstalık 1", "", " &7Büyüyü barındıran ekipmanın saldırı hasarı artar.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 29, "&6Darbe", "&aUstalık 1", "", " &7Büyüyü barındıran ekipman ile yapılan saldırılar", " &7ölü yaratıklara daha fazla hasar verir", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 33, "&6Alevden Çehre", "&aUstalık 1", "", " &7Büyüyü barındıran ekipman ile yapılan saldırılar kurbanı yakar.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 32, "&6Savurma", "&aUstalık 1", "", " &7Büyüyü barındıran ekipman ile yapılan", " &7saldırılar rakibi uzaklara savurur.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            if (enchLevel > 1) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 34, "&6Hünerli Avcı", "&aUstalık 2", "", " &7Büyüyü barındıran ekipmanın", " &7kritik hasarı artar.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 34, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 1. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 1) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 35, "&6Zehirli Kesik", "&aUstalık 2", "", " &7Büyüyü barındıran ekipman ile yapılan", " &7saldırılar kurbanı zehirler.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 35, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 1. seviyeden yüksek olması gerekir.");
                            }
                            if (enchLevel > 1) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 38, "&6Kırılmazlık", "&aUstalık 2", "", " &7Büyüyü barındıran ekipmanın dayanıklılığı artar.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 38, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 1. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 2) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 39, "&6Tecrübe Desteği", "&aUstalık 3", "", " &7Büyüyü barındıran ekipman ile avlanan", " &7yaratıklardan ekstra tecrübe puanı düşer.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 39, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 2. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 2) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 40, "&6Öfke", "&aUstalık 3", "", " &7Büyüyü barındıran ekipman ile yapılan saldırılar", " &7kullanıcıyı öfkelendirir. Kullanıcı öfkesi", " &7arttıkça ekstra hasar ve saldırı hızı kazanır.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 40, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 2. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 2) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 41, "&6Süpürücü Kenar", "&aUstalık 3", "", " &6Büyüyü barındıran ekipman ile yapılan saldırılar", " &7kurbanın etrafındaki birimlere de hasar verir.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 41, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 2. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 3) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 42, "&6Ganimet", "&aUstalık 4", "", " &7Büyüyü barındıran ekipman ile öldürülen", " &7kurbandan ekstra ganimet düşer.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 42, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 3. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 3) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 43, "&6Sömürü", "&aUstalık 4", "", " &7Büyüyü barındıran ekipman ile yapılan", " &7saldırılar kurbandan can çalar.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 43, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 3. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 3) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 44, "&6İnfaz", "&aUstalık 4", "", " &7Büyüyü barındıran ekipman ile yapılan saldırılar", " &7canı az olan kurbanları infaz eder.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 44, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 3. seviyeden yüksek olması gerekir.");

                            }
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "arrow", 1, 50, "&aSonraki Sayfa", "&7Sonraki sayfaya geçmek için &e&lSağ Tıkla.");
                        } else if (item.getType() == Material.BOW) {

                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 31, "&6Güç", "&aUstalık 1", "", " &7Büyüyü barındıran yay ile yapılan saldırılar ekstra hasar verir.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 30, "&6Yumruk", "&aUstalık 1", "", " &7Büyüyü barındıran yay ile vurulan rakipler savrulur.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 29, "&6Alev", "&aUstalık 1", "", " &7Büyüyü barındıran yay ile yapılan saldırılar rakibi yakar", " &7", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 33, "&6Delme", "&aUstalık 1", "", " &7Büyüyü barındıran ekipman ile yapılan saldırılar rakipleri deler.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            if (enchLevel > 1) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 32, "&6Tam İsabet", "&aUstalık 1", "", " &7Büyüyü barındıran yay ile rakinin kafasına", " &7yapılan saldırılar ekstra hasar verir.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 32, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 1. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 1) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 34, "&6Hünerli Avcı", "&aUstalık 2", "", " &7Büyüyü barındıran ekipmanın", " &7kritik hasarı artar.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 34, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 1. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 1) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 35, "&6Keskin Görüş", "&aUstalık 2", "", " &7Büyüyü barındıran yay ile fırlatılan", " &7okun katettiği mesafeye göre hasarı artar.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 35, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 1. seviyeden yüksek olması gerekir.");
                            }
                            if (enchLevel > 1) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 38, "&6Kırılmazlık", "&aUstalık 2", "", " &7Büyüyü barındıran ekipmanın dayanıklılığı artar.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 38, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 1. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 2) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 39, "&6Tecrübe Desteği", "&aUstalık 3", "", " &7Büyüyü barındıran ekipman ile avlanan", " &7yaratıklardan ekstra tecrübe puanı düşer.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 39, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 2. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 2) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 40, "&6Aşırı Yükleme", "&aUstalık 3", "", " &7Büyüyü barındıran yay ile yapılan ağır", " &7yüklü atışlar rakibi sersemletir.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 40, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 2. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 2) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 41, "&6Yıldırım Oku", "&aUstalık 3", "", " &6Büyüyü barındıran yay ile fırlatılan ok", " &7rakipler arasında seker ve hasar verir.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 41, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 2. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 3) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 42, "&6Şişleme", "&aUstalık 4", "", " &7Büyüyü barındıran yay ile yapılan saldırılar", " &7su yaratıklarına ekstra hasar verir.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 42, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 3. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 3) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 43, "&6Nişangah", "&aUstalık 4", "", " &7Büyüyü barındıran yay ile yapılan saldırılar", " &7saldırılar oyuncunun kritik hasarını arttırır.", "&7Kullanıcı saldırıya devam etmez ise", "&7bu etki bir süre sonra kaybolur.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 43, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 3. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 3) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 44, "&6Şölen", "&aUstalık 4", "", " &7Yürüdüğünüzde yük biriktirirsiniz. Her 100. yükde", " &7bir vuruş yaparsanız iyileşirsiniz.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 44, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 3. seviyeden yüksek olması gerekir.");

                            }
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "arrow", 1, 50, "&aSonraki Sayfa", "&7Sonraki sayfaya geçmek için &e&lSağ Tıkla.");
                        } else if (item.getType() == Material.WOODEN_AXE) {

                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 31, "&6Eklembacaklılar'ın Kıyameti", "&aUstalık 1", "", " &7Büyüyü barındıran ekipman ile yapılan saldırılar", " &7eklembacaklılara ekstra hasar verir.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 30, "&6Keskinlik", "&aUstalık 1", "", " &7Büyüyü barındıran ekipmanın saldırı hasarı artar.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 29, "&6Darbe", "&aUstalık 1", "", " &7Büyüyü barındıran ekipman ile yapılan saldırılar", " &7ölü yaratıklara daha fazla hasar verir", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 33, "&6Verimlilik", "&aUstalık 1", "", " &7Büyüyü barındıran ekipmanın kazma hızı artar.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 32, "&6Ustalık Desteği", "&aUstalık 1", "", " &7Büyüyü barındıran baltanın verdiği &6Ustalık EXP'si &7artar.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            if (enchLevel > 1) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 34, "&6Hünerli Avcı", "&aUstalık 2", "", " &7Büyüyü barındıran ekipmanın", " &7kritik hasarı artar.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 34, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 1. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 1) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 35, "&6Karşılama", "&aUstalık 2", "", " &7Büyüyü barındıran ekipmanla bir saldırıyı", " &7karşılayabilirsiniz. Bir saldırıyı karşılamak", "&7rakibe hasar verir ve onu savurur.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 35, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 1. seviyeden yüksek olması gerekir.");
                            }
                            if (enchLevel > 1) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 38, "&6Kırılmazlık", "&aUstalık 2", "", " &7Büyüyü barındıran ekipmanın dayanıklılığı artar.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 38, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 1. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 2) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 39, "&6Tecrübe Desteği", "&aUstalık 3", "", " &7Büyüyü barındıran ekipman ile avlanan", " &7yaratıklardan ekstra tecrübe puanı düşer.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 39, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 2. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 2) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 40, "&6İlk Vuruş", "&aUstalık 3", "", " &7Büyüyü barındıran ekipman ile yapılan ilk", " &7vuruş rakibe ekstra hasar verir.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 40, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 2. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 2) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 41, "&6Yıldırım Lordu", "&aUstalık 3", "", " &6Büyüyü barındıran ekipman ile yapılan", " &7saldırılar kurbana yıldırım çarpar.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 41, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 2. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 3) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 42, "&6Ganimet", "&aUstalık 4", "", " &7Büyüyü barındıran ekipman ile öldürülen", " &7kurbandan ekstra ganimet düşer.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 42, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 3. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 3) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 43, "&6Sömürü", "&aUstalık 4", "", " &7Büyüyü barındıran ekipman ile yapılan", " &7saldırılar kurbandan can çalar.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 43, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 3. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 3) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 44, "&6İnfaz", "&aUstalık 4", "", " &7Büyüyü barındıran ekipman ile yapılan saldırılar", " &7canı az olan kurbanları infaz eder.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 44, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 3. seviyeden yüksek olması gerekir.");

                            }
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "arrow", 1, 50, "&aSonraki Sayfa", "&7Sonraki sayfaya geçmek için &e&lSağ Tıkla.");


                        } else if (item.getType() == Material.STICK) {


                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 31, "&6Eklembacaklılar'ın Kıyameti", "&aUstalık 1", "", " &7Büyüyü barındıran ekipman ile yapılan saldırılar", " &7eklembacaklılara ekstra hasar verir.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 30, "&6Keskinlik", "&aUstalık 1", "", " &7Büyüyü barındıran ekipmanın saldırı hasarı artar.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 29, "&6Darbe", "&aUstalık 1", "", " &7Büyüyü barındıran ekipman ile yapılan saldırılar", " &7ölü yaratıklara daha fazla hasar verir", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 33, "&6Çekiş", "&aUstalık 1", "", " &7Büyüyü barındıran ekipman ile yapılan saldırılar kurbanı kullanıcıya çeker.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 32, "&6Şişleme", "&aUstalık 1", "", " &7Büyüyü barındıran ekipman ile yapılan saldırılar", " &7su yaratıklarına ekstra hasar verir.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            if (enchLevel > 1) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 34, "&6Hünerli Avcı", "&aUstalık 2", "", " &7Büyüyü barındıran ekipmanın", " &7kritik hasarı artar.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 34, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 1. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 1) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 35, "&6Zehirli Kesik", "&aUstalık 2", "", " &7Büyüyü barındıran ekipman ile yapılan", " &7saldırılar kurbanı zehirler.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 35, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 1. seviyeden yüksek olması gerekir.");
                            }
                            if (enchLevel > 1) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 38, "&6Kırılmazlık", "&aUstalık 2", "", " &7Büyüyü barındıran ekipmanın dayanıklılığı artar.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 38, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 1. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 2) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 39, "&6Tecrübe Desteği", "&aUstalık 3", "", " &7Büyüyü barındıran ekipman ile avlanan", " &7yaratıklardan ekstra tecrübe puanı düşer.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 39, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 2. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 2) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 40, "&6Öfke", "&aUstalık 3", "", " &7Büyüyü barındıran ekipman ile yapılan saldırılar", " &7kullanıcıyı öfkelendirir. Kullanıcı öfkesi", " &7arttıkça ekstra hasar ve saldırı hızı kazanır.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 40, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 2. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 2) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 41, "&6Yara Deşme", "&aUstalık 3", "", " &6Büyüyü barındıran ekipman ile kanayan rakiplere", " &7yapılan saldırılar ekstra hasar verir.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 41, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 2. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 3) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 42, "&6Ganimet", "&aUstalık 4", "", " &7Büyüyü barındıran ekipman ile öldürülen", " &7kurbandan ekstra ganimet düşer.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 42, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 3. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 3) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 43, "&6Sömürü", "&aUstalık 4", "", " &7Büyüyü barındıran ekipman ile yapılan", " &7saldırılar kurbandan can çalar.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 43, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 3. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 3) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 44, "&6İnfaz", "&aUstalık 4", "", " &7Büyüyü barındıran ekipman ile yapılan saldırılar", " &7canı az olan kurbanları infaz eder.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 44, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 3. seviyeden yüksek olması gerekir.");

                            }
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "arrow", 1, 50, "&aSonraki Sayfa", "&7Sonraki sayfaya geçmek için &e&lSağ Tıkla.");
                        } else if (item.getType() == Material.SHEARS) {


                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 31, "&6Eklembacaklılar'ın Kıyameti", "&aUstalık 1", "", " &7Büyüyü barındıran ekipman ile yapılan saldırılar", " &7eklembacaklılara ekstra hasar verir.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 30, "&6Keskinlik", "&aUstalık 1", "", " &7Büyüyü barındıran ekipmanın saldırı hasarı artar.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 29, "&6Darbe", "&aUstalık 1", "", " &7Büyüyü barındıran ekipman ile yapılan saldırılar", " &7ölü yaratıklara daha fazla hasar verir", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 33, "&6Akuapunktur Ustası", "&aUstalık 1", "", " &7Büyüyü barındıran hançer ile iğnelemeler rakibi kanatır.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 32, "&6Şişleme", "&aUstalık 1", "", " &7Büyüyü barındıran ekipman ile yapılan saldırılar", " &7su yaratıklarına ekstra hasar verir.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            if (enchLevel > 1) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 34, "&6Hünerli Avcı", "&aUstalık 2", "", " &7Büyüyü barındıran ekipmanın", " &7kritik hasarı artar.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 34, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 1. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 1) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 35, "&6Zehirli Kesik", "&aUstalık 2", "", " &7Büyüyü barındıran ekipman ile yapılan", " &7saldırılar kurbanı zehirler.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 35, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 1. seviyeden yüksek olması gerekir.");
                            }
                            if (enchLevel > 1) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 38, "&6Kırılmazlık", "&aUstalık 2", "", " &7Büyüyü barındıran ekipmanın dayanıklılığı artar.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 38, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 1. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 2) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 39, "&6Tecrübe Desteği", "&aUstalık 3", "", " &7Büyüyü barındıran ekipman ile avlanan", " &7yaratıklardan ekstra tecrübe puanı düşer.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 39, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 2. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 2) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 40, "&6Suikastci Ruhu", "&aUstalık 3", "", " &7Görünmez iken verilen hasarı arttırır.", " &7arttıkça ekstra hasar ve saldırı hızı kazanır.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 40, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 2. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 2) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 41, "&6Yara Deşme", "&aUstalık 3", "", " &6Büyüyü barındıran ekipman ile kanayan rakiplere", " &7yapılan saldırılar ekstra hasar verir.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 41, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 2. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 3) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 42, "&6Ganimet", "&aUstalık 4", "", " &7Büyüyü barındıran ekipman ile öldürülen", " &7kurbandan ekstra ganimet düşer.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 42, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 3. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 3) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 43, "&6Sömürü", "&aUstalık 4", "", " &7Büyüyü barındıran ekipman ile yapılan", " &7saldırılar kurbandan can çalar.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 43, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 3. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 3) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 44, "&6İnfaz", "&aUstalık 4", "", " &7Büyüyü barındıran ekipman ile yapılan saldırılar", " &7canı az olan kurbanları infaz eder.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 44, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 3. seviyeden yüksek olması gerekir.");

                            }
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "arrow", 1, 50, "&aSonraki Sayfa", "&7Sonraki sayfaya geçmek için &e&lSağ Tıkla.");
                        } else if (MaterialTags.HELMETS.isTagged(item)) {


                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 31, "&6Koruma", "&aUstalık 1", "", " &7Kullanıcıyı gelen hasarın birazından korur.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 30, "&6Patlama Koruması", "&aUstalık 1", "", " &7Kullanıcıyı gelen patlama hasarının birazından korur.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 29, "&6Alev Koruması", "&aUstalık 1", "", " &7Kullanıcıyı gelen alev hasarının birazından korur.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 33, "&6Büyülü Kaplama", "&aUstalık 1", "", " &7Kullanıcıyı gelen menzilli saldırı hasarının birazından korur.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 32, "&6Dikenler", "&aUstalık 1", "", " &7Kullanıcıya gelen hasarın birazını saldırana yansıtır.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            if (enchLevel > 1) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 34, "&6Aşırı Büyüme", "&aUstalık 2", "", " &7Kullanıcının can değerini arttırır.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 34, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 1. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 1) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 35, "&6Barbar Gücü", "&aUstalık 2", "", " &7Kullanıcının yakın menzildeki hasarını arttırır.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 35, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 1. seviyeden yüksek olması gerekir.");
                            }
                            if (enchLevel > 1) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 38, "&6Kırılmazlık", "&aUstalık 2", "", " &7Büyüyü barındıran ekipmanın dayanıklılığı artar.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 38, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 1. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 2) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 39, "&6Keskin Görüş", "&aUstalık 3", "", " &7Kullanıcının uzak menzildeki hasarını arttırır.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 39, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 2. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 2) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 40, "&6Dev Yarma", "&aUstalık 3", "", " &7Can değeri kullanıcıdan büyük olan", " &7rakiplere kullanıcı ekstra hasar verir.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 40, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 2. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 2) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 41, "&6Solungaç", "&aUstalık 3", "", " &6Kullanıcının su altında daha fazla", " &7oksijen depolayabilmesini sağlar..", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 41, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 2. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 3) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 42, "&6Dinçleştirme", "&aUstalık 4", "", " &7Kullanıcının doğal can yenilenmesini arttırır.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 42, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 3. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 3) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 43, "&6Potansiyel", "&aUstalık 4", "", " &7Kullanıcı bir iyileştirme etkisi alırsa", " &7etrafındakilere patlama hasarı verir.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 43, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 3. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 3) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 44, "&6Sıvışma", "&aUstalık 4", "", " &7Kullanıcı bazı saldırılardan sıvışabilir.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 44, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 3. seviyeden yüksek olması gerekir.");

                            }
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "arrow", 1, 50, "&aSonraki Sayfa", "&7Sonraki sayfaya geçmek için &e&lSağ Tıkla.");
                        } else if (MaterialTags.CHESTPLATES.isTagged(item)) {


                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 31, "&6Koruma", "&aUstalık 1", "", " &7Kullanıcıyı gelen hasarın birazından korur.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 30, "&6Patlama Koruması", "&aUstalık 1", "", " &7Kullanıcıyı gelen patlama hasarının birazından korur.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 29, "&6Alev Koruması", "&aUstalık 1", "", " &7Kullanıcıyı gelen alev hasarının birazından korur.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 33, "&6Büyülü Kaplama", "&aUstalık 1", "", " &7Kullanıcıyı gelen menzilli saldırı hasarının birazından korur.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 32, "&6Dikenler", "&aUstalık 1", "", " &7Kullanıcıya gelen hasarın birazını saldırana yansıtır.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            if (enchLevel > 1) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 34, "&6Aşırı Büyüme", "&aUstalık 2", "", " &7Kullanıcının can değerini arttırır.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 34, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 1. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 1) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 35, "&6Bağışıklık", "&aUstalık 2", "", " &7Kullanıcı bazı kötü efektlere karşı bağışıklık kazanır.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 35, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 1. seviyeden yüksek olması gerekir.");
                            }
                            if (enchLevel > 1) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 38, "&6Kırılmazlık", "&aUstalık 2", "", " &7Büyüyü barındıran ekipmanın dayanıklılığı artar.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 38, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 1. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 2) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 39, "&6Obsidyen Kaplama", "&aUstalık 3", "", " &7Kullanıcı ateş direnci kazanır.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 39, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 2. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 2) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 40, "&6Kutsanmış", "&aUstalık 3", "", " &7Kullanıcı savaş dışında iken yenilenme kazanır.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 40, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 2. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 2) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 41, "&6Karşı Saldırı", "&aUstalık 3", "", " &6Kullanıcı aldığı ilk hasarda direnç etkisi kazanır.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 41, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 2. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 3) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 42, "&6Dinçleştirme", "&aUstalık 4", "", " &7Kullanıcının doğal can yenilenmesini arttırır.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 42, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 3. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 3) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 43, "&6İntikam", "&aUstalık 4", "", " &7Kullanıcı ölürse düşük şans ile geri doğar.", " &7ve etrafındakilere hasar verir.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 43, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 3. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 3) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 44, "&6Sıvışma", "&aUstalık 4", "", " &7Kullanıcı bazı saldırılardan sıvışabilir.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 44, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 3. seviyeden yüksek olması gerekir.");

                            }
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "arrow", 1, 50, "&aSonraki Sayfa", "&7Sonraki sayfaya geçmek için &e&lSağ Tıkla.");
                        } else if (MaterialTags.LEGGINGS.isTagged(item)) {


                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 31, "&6Koruma", "&aUstalık 1", "", " &7Kullanıcıyı gelen hasarın birazından korur.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 30, "&6Patlama Koruması", "&aUstalık 1", "", " &7Kullanıcıyı gelen patlama hasarının birazından korur.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 29, "&6Alev Koruması", "&aUstalık 1", "", " &7Kullanıcıyı gelen alev hasarının birazından korur.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 33, "&6Büyülü Kaplama", "&aUstalık 1", "", " &7Kullanıcıyı gelen menzilli saldırı hasarının birazından korur.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 32, "&6Dikenler", "&aUstalık 1", "", " &7Kullanıcıya gelen hasarın birazını saldırana yansıtır.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            if (enchLevel > 1) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 34, "&6Aşırı Büyüme", "&aUstalık 2", "", " &7Kullanıcının can değerini arttırır.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 34, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 1. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 1) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 35, "&6Ruh Koruması", "&aUstalık 2", "", " &7Kullanıcı bazı kötü efektlere karşı bağışıklık kazanır.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 35, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 1. seviyeden yüksek olması gerekir.");
                            }
                            if (enchLevel > 1) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 38, "&6Kırılmazlık", "&aUstalık 2", "", " &7Büyüyü barındıran ekipmanın dayanıklılığı artar.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 38, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 1. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 2) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 39, "&6Kaplama Darbesi", "&aUstalık 3", "", " &7Kullanıcının aldığı ilk hasar rakiplere", "&7hasar verir ve onları uçurur.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 39, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 2. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 2) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 40, "&6Kutsanmış", "&aUstalık 3", "", " &7Kullanıcı savaş dışında iken yenilenme kazanır.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 40, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 2. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 2) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 41, "&6Karşı Saldırı", "&aUstalık 3", "", " &6Kullanıcı aldığı ilk hasarda direnç etkisi kazanır.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 41, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 2. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 3) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 42, "&6Dinçleştirme", "&aUstalık 4", "", " &7Kullanıcının doğal can yenilenmesini arttırır.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 42, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 3. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 3) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 43, "&6Mutlak Sıfır", "&aUstalık 4", "", " &7Kullanıcı hasar alırsa saldıran.", " &7rakipler yavaşlar ve saldırı hızları düşer.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 43, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 3. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 3) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 44, "&6Sıvışma", "&aUstalık 4", "", " &7Kullanıcı bazı saldırılardan sıvışabilir.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 44, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 3. seviyeden yüksek olması gerekir.");

                            }
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "arrow", 1, 50, "&aSonraki Sayfa", "&7Sonraki sayfaya geçmek için &e&lSağ Tıkla.");
                        } else if (MaterialTags.BOOTS.isTagged(item)) {


                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 31, "&6Koruma", "&aUstalık 1", "", " &7Kullanıcıyı gelen hasarın birazından korur.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 30, "&6Patlama Koruması", "&aUstalık 1", "", " &7Kullanıcıyı gelen patlama hasarının birazından korur.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 29, "&6Alev Koruması", "&aUstalık 1", "", " &7Kullanıcıyı gelen alev hasarının birazından korur.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 33, "&6Büyülü Kaplama", "&aUstalık 1", "", " &7Kullanıcıyı gelen menzilli saldırı hasarının birazından korur.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 32, "&6Dikenler", "&aUstalık 1", "", " &7Kullanıcıya gelen hasarın birazını saldırana yansıtır.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            if (enchLevel > 1) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 34, "&6Aşırı Büyüme", "&aUstalık 2", "", " &7Kullanıcının can değerini arttırır.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 34, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 1. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 1) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 35, "&6Sihirli Pabuçlar", "&aUstalık 2", "", " &7Kullanıcı ekstra &fÇeviklik &7kazanır.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 35, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 1. seviyeden yüksek olması gerekir.");
                            }
                            if (enchLevel > 1) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 38, "&6Kırılmazlık", "&aUstalık 2", "", " &7Büyüyü barındıran ekipmanın dayanıklılığı artar.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 38, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 1. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 2) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 39, "&6Statik Yüklenme", "&aUstalık 3", "", " &7Kullanıcının yürürken yük biriktirir. Her 100.", "&7yük rakibe bir yıldırım çarpar.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 39, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 2. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 2) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 40, "&6Dikenli Taban", "&aUstalık 3", "", " &7Kullanıcı savrulma direnci kazanır.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 40, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 2. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 2) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 41, "&6Hafif Düşüş", "&aUstalık 3", "", " &6Kullanıcı daha az düşme hasarı alır.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 41, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 2. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 3) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 42, "&6Dinçleştirme", "&aUstalık 4", "", " &7Kullanıcının doğal can yenilenmesini arttırır.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 42, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 3. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 3) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 43, "&6Sağlam Duruş", "&aUstalık 4", "", " &6Kullanıcı ekstra &eDenge &7kazanır.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 43, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 3. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 3) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 44, "&6Sıvışma", "&aUstalık 4", "", " &7Kullanıcı bazı saldırılardan sıvışabilir.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 44, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 3. seviyeden yüksek olması gerekir.");

                            }
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "arrow", 1, 50, "&aSonraki Sayfa", "&7Sonraki sayfaya geçmek için &e&lSağ Tıkla.");
                        } else if (MaterialTags.PICKAXES.isTagged(item)) {


                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 31, "&6Verimlilik", "&aUstalık 1", "", " &7Büyüyü barındıran ekipmanın kazma hızı artar.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 30, "&6Ustalık Desteği", "&aUstalık 1", "", " &7Büyüyü barındıran kazmanın verdiği &6Ustalık EXP'si &7artar.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 29, "&6Sıcak Dokunuş", "&aUstalık 1", "", " &7Büyüyü barındıran kazma ile kazılan madenler", "&7kullanıcının envanterine eriyik halde gelir", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 33, "&6Servet", "&aUstalık 1", "", " &7Büyüyü barındıran kazma ile kazılan", "&7ekstra malzeme düşer.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 32, "&6Dedektör", "&aUstalık 1", "", " &7Kırılan her 64. blokta oyuncuya rastgele bir ganimet verir.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");

                            if (enchLevel > 1) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 34, "&6Kırılmazlık", "&aUstalık 2", "", " &7Büyüyü barındıran ekipmanın dayanıklılığı artar.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 34, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 1. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 1) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 35, "&6Madencinin Lütfu", "&aUstalık 2", "", " &7Büyüyü barındıran ekipmanın ile kazılan her", "&7her kömür kullanıcıya acele kazandırır.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 35, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 1. seviyeden yüksek olması gerekir.");

                            }
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "arrow", 1, 50, "&aSonraki Sayfa", "&7Sonraki sayfaya geçmek için &e&lSağ Tıkla.");
                        } else if (item.getType() == Material.GOLDEN_AXE) {


                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 30, "&6Verimlilik", "&aUstalık 1", "", " &7Büyüyü barındıran ekipmanın kazma hızı artar.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 29, "&6Ustalık Desteği", "&aUstalık 1", "", " &7Büyüyü barındıran baltanın verdiği &6Ustalık EXP'si &7artar.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 31, "&6Servet", "&aUstalık 1", "", " &7Büyüyü barındıran kazma ile kazılan", "&7ekstra malzeme düşer.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");

                            if (enchLevel > 1) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 32, "&6Kırılmazlık", "&aUstalık 2", "", " &7Büyüyü barındıran ekipmanın dayanıklılığı artar.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 32, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 1. seviyeden yüksek olması gerekir.");

                            }

                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "arrow", 1, 50, "&aSonraki Sayfa", "&7Sonraki sayfaya geçmek için &e&lSağ Tıkla.");
                        } else if (item.getType() == Material.WOODEN_HOE) {


                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 31, "&6Eklembacaklılar'ın Kıyameti", "&aUstalık 1", "", " &7Büyüyü barındıran ekipman ile yapılan saldırılar", " &7eklembacaklılara ekstra hasar verir.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 30, "&6Keskinlik", "&aUstalık 1", "", " &7Büyüyü barındıran ekipmanın saldırı hasarı artar.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 29, "&6Darbe", "&aUstalık 1", "", " &7Büyüyü barındıran ekipman ile yapılan saldırılar", " &7ölü yaratıklara daha fazla hasar verir", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 33, "&6Çekiş", "&aUstalık 1", "", " &7Büyüyü barındıran ekipman ile yapılan saldırılar kurbanı kullanıcıya çeker.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 32, "&6Şişleme", "&aUstalık 1", "", " &7Büyüyü barındıran ekipman ile yapılan saldırılar", " &7su yaratıklarına ekstra hasar verir.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            if (enchLevel > 1) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 34, "&6Hünerli Avcı", "&aUstalık 2", "", " &7Büyüyü barındıran ekipmanın", " &7kritik hasarı artar.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 34, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 1. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 1) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 35, "&6Biçme", "&aUstalık 2", "", " &7Büyüyü barındıran tırpan ile yapılan", " &7alan saldırıları ekstra hasar verir.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 35, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 1. seviyeden yüksek olması gerekir.");
                            }
                            if (enchLevel > 1) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 38, "&6Kırılmazlık", "&aUstalık 2", "", " &7Büyüyü barındıran ekipmanın dayanıklılığı artar.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 38, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 1. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 2) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 39, "&6Tecrübe Desteği", "&aUstalık 3", "", " &7Büyüyü barındıran ekipman ile avlanan", " &7yaratıklardan ekstra tecrübe puanı düşer.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 39, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 2. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 2) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 40, "&6Öfke", "&aUstalık 3", "", " &7Büyüyü barındıran ekipman ile yapılan saldırılar", " &7kullanıcıyı öfkelendirir. Kullanıcı öfkesi", " &7arttıkça ekstra hasar ve saldırı hızı kazanır.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 40, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 2. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 2) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 41, "&6Ruh Yiyen", "&aUstalık 3", "", " &6Öldürülen bir rakibin ruhunu ekipman ele geçirir.", " &7Her 100 ruhda ekstra hasar artışı yaşanır.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 41, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 2. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 3) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 42, "&6Ganimet", "&aUstalık 4", "", " &7Büyüyü barındıran ekipman ile öldürülen", " &7kurbandan ekstra ganimet düşer.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 42, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 3. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 3) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 43, "&6Sömürü", "&aUstalık 4", "", " &7Büyüyü barındıran ekipman ile yapılan", " &7saldırılar kurbandan can çalar.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 43, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 3. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 3) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 44, "&6İnfaz", "&aUstalık 4", "", " &7Büyüyü barındıran ekipman ile yapılan saldırılar", " &7canı az olan kurbanları infaz eder.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 44, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 3. seviyeden yüksek olması gerekir.");

                            }
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "arrow", 1, 50, "&aSonraki Sayfa", "&7Sonraki sayfaya geçmek için &e&lSağ Tıkla.");
                        } else if (item.getType() == Material.WOODEN_SHOVEL) {


                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 31, "&6Eklembacaklılar'ın Kıyameti", "&aUstalık 1", "", " &7Büyüyü barındıran ekipman ile yapılan saldırılar", " &7eklembacaklılara ekstra hasar verir.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 30, "&6Keskinlik", "&aUstalık 1", "", " &7Büyüyü barındıran ekipmanın saldırı hasarı artar.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 29, "&6Darbe", "&aUstalık 1", "", " &7Büyüyü barındıran ekipman ile yapılan saldırılar", " &7ölü yaratıklara daha fazla hasar verir", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 33, "&6Göçertme", "&aUstalık 1", "", " &7Büyüyü barındıran ekipman ile yapılan sersemletmelerin süresi uzar.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 32, "&6Şişleme", "&aUstalık 1", "", " &7Büyüyü barındıran ekipman ile yapılan saldırılar", " &7su yaratıklarına ekstra hasar verir.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            if (enchLevel > 1) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 34, "&6Hünerli Avcı", "&aUstalık 2", "", " &7Büyüyü barındıran ekipmanın", " &7kritik hasarı artar.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 34, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 1. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 1) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 35, "&6Sersemdöver", "&aUstalık 2", "", " &7Sersemlemiş rakiplere ekstra hasar verir.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 35, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 1. seviyeden yüksek olması gerekir.");
                            }
                            if (enchLevel > 1) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 38, "&6Kırılmazlık", "&aUstalık 2", "", " &7Büyüyü barındıran ekipmanın dayanıklılığı artar.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 38, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 1. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 2) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 39, "&6Tecrübe Desteği", "&aUstalık 3", "", " &7Büyüyü barındıran ekipman ile avlanan", " &7yaratıklardan ekstra tecrübe puanı düşer.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 39, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 2. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 2) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 40, "&6Deprem", "&aUstalık 3", "", " &7Büyüyü barındıran ekipman ile yere yapılan saldırılar", " &7bir yeryüzü parçasını havaya fırlatır.", "&7Bu parça bir süre sonra yere düşer", "&7ve etrafındakilere hasar verir.", " &7arttıkça ekstra hasar ve saldırı hızı kazanır.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 40, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 2. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 2) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 41, "&6Zayıflatma", "&aUstalık 3", "", " &7Büyüyü barındıran ekipman ile yapılan saldırılar", " &7rakibi zayıflatır ve saldırı hızını düşürür.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 41, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 2. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 3) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 42, "&6Ganimet", "&aUstalık 4", "", " &7Büyüyü barındıran ekipman ile öldürülen", " &7kurbandan ekstra ganimet düşer.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 42, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 3. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 3) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 43, "&6Sömürü", "&aUstalık 4", "", " &7Büyüyü barındıran ekipman ile yapılan", " &7saldırılar kurbandan can çalar.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 43, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 3. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 3) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 44, "&6İnfaz", "&aUstalık 4", "", " &7Büyüyü barındıran ekipman ile yapılan saldırılar", " &7canı az olan kurbanları infaz eder.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 44, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 3. seviyeden yüksek olması gerekir.");

                            }
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "arrow", 1, 50, "&aSonraki Sayfa", "&7Sonraki sayfaya geçmek için &e&lSağ Tıkla.");
                        } else if (item.getType() == Material.FISHING_ROD) {


                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 31, "&6Denizin Şansı", "&aUstalık 1", "", " &7Büyüyü barındıran olta ile iyi bir", "&7yakalama yapma şansını arttırır.", " &7eklembacaklılara ekstra hasar verir.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 30, "&6Ayartma", "&aUstalık 1", "", " &7Büyüyü barındıran oltanın yakalama hızını arttırır.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 29, "&6Siftah", "&aUstalık 1", "", " &7Büyüyü barındıran olta kullanıcıya çifte", "&7yakalama yapma şansı ekler.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 33, "&6Ustalık Desteği", "&aUstalık 1", "", " &7Büyüyü barındıran oltanın verdiği &6Ustalık EXP'si &7artar.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 32, "&6Dikenli Kanca", "&aUstalık 1", "", " &7Büyüyü barındıran oltanın verdiği hasarı arttırır.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            if (enchLevel > 1) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 34, "&6Hünerli Avcı", "&aUstalık 2", "", " &7Büyüyü barındıran ekipmanın", " &7kritik hasarı artar.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 34, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 1. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 1) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 35, "&6Deniz Çöplüğü Avcısı", "&aUstalık 2", "", " &7Kullanıcının denizden balık dışında", " &7diğer şeyleri tutma şansını arttırır.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 35, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 1. seviyeden yüksek olması gerekir.");
                            }
                            if (enchLevel > 1) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 38, "&6Kırılmazlık", "&aUstalık 2", "", " &7Büyüyü barındıran ekipmanın dayanıklılığı artar.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 38, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 1. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 2) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 39, "&6Tecrübe Desteği", "&aUstalık 3", "", " &7Büyüyü barındıran ekipman ile avlanan", " &7yaratıklardan ekstra tecrübe puanı düşer.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 39, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 2. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 2) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 40, "&6Deprem", "&aUstalık 3", "", " &7Büyüyü barındıran ekipman ile yere yapılan saldırılar", " &7bir yeryüzü parçasını havaya fırlatır.", "&7Bu parça bir süre sonra yere düşer", "&7ve etrafındakilere hasar verir.", " &7arttıkça ekstra hasar ve saldırı hızı kazanır.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 40, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 2. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 2) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 41, "&6Şanslı Kanca", "&aUstalık 3", "", " &7Büyüyü barındıran oltaya yem harcamama olasılığı ekler.", " &7rakibi zayıflatır ve saldırı hızını düşürür.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 41, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 2. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 3) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 42, "&6Ganimet", "&aUstalık 4", "", " &7Büyüyü barındıran ekipman ile öldürülen", " &7kurbandan ekstra ganimet düşer.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 42, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 3. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 3) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 43, "&6Sömürü", "&aUstalık 4", "", " &7Büyüyü barındıran ekipman ile yapılan", " &7saldırılar kurbandan can çalar.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 43, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 3. seviyeden yüksek olması gerekir.");

                            }
                            if (enchLevel > 3) {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 44, "&6İnfaz", "&aUstalık 4", "", " &7Büyüyü barındıran ekipman ile yapılan saldırılar", " &7canı az olan kurbanları infaz eder.", "", "&7Ekipmanı büyülemek için &e&lSağ Tıkla.");
                            } else {
                                itemHandler.createItem(player.getOpenInventory().getTopInventory(), "enchanted_book", 1, 44, "&6??? &c(Ustalık Yetersiz)", "&7Bu büyüye erişim sağlayabilmek için büyücülükteki", "&7ustalığının 3. seviyeden yüksek olması gerekir.");

                            }
                            itemHandler.createItem(player.getOpenInventory().getTopInventory(), "arrow", 1, 50, "&aSonraki Sayfa", "&7Sonraki sayfaya geçmek için &e&lSağ Tıkla.");
                        }
                    }
                }
            } else {
                event.setCancelled(true);
                if (event.getWhoClicked().getItemOnCursor() != null && event.getCurrentItem() != null) {
                    ItemStack item = event.getCurrentItem();
                    int amount = item.getAmount();
                    if (MaterialTags.SWORDS.isTagged(item) || MaterialTags.AXES.isTagged(item)
                            || MaterialTags.BOWS.isTagged(item) || MaterialTags.PICKAXES.isTagged(item)
                            || MaterialTags.HOES.isTagged(item) || MaterialTags.HELMETS.isTagged(item)
                            || MaterialTags.CHESTPLATES.isTagged(item) || MaterialTags.LEGGINGS.isTagged(item)
                            || MaterialTags.BOOTS.isTagged(item) || MaterialTags.SHOVELS.isTagged(item)
                            || item.getType() == Material.FISHING_ROD || item.getType() == Material.BOOK
                            && (item.getItemMeta().getLore().contains(Painter.paint("&8<Boş Büyü Bölmesi>")))) {
                        if (player.getInventory().firstEmpty() == -1) {

                            player.getWorld().dropItemNaturally(player.getLocation(), item);
                            event.getView().setItem(22, null);
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
                            player.getInventory().addItem(item);
                            event.getView().setItem(22, null);
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
        if (event.getCurrentItem() == null) {
            return;
        }

    }

    @EventHandler
    public void enchclose(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();
        if (event.getInventory() != null & event.getView().getTitle().equals(guiHandler.inventory_name7)) {
            if (event.getInventory().getItem(22) != null) {
                if (player.getInventory().firstEmpty() == -1) {
                    ItemStack item = event.getInventory().getItem(22);
                    player.getWorld().dropItemNaturally(player.getLocation(), item);

                } else {
                    ItemStack item = event.getInventory().getItem(22);
                    player.getInventory().addItem(item);
                }
            }
        }
    }

    @EventHandler
    public void anvilclose(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();
        if (event.getInventory() != null & event.getView().getTitle().equals(guiHandler.inventory_name10)) {
            if (event.getInventory().getItem(29) != null) {
                if (player.getInventory().firstEmpty() == -1) {
                    ItemStack item = event.getInventory().getItem(29);
                    player.getWorld().dropItemNaturally(player.getLocation(), item);

                } else {
                    ItemStack item = event.getInventory().getItem(29);
                    player.getInventory().addItem(item);
                }
            }
            if (event.getInventory().getItem(33) != null) {
                if (player.getInventory().firstEmpty() == -1) {
                    ItemStack item = event.getInventory().getItem(33);
                    player.getWorld().dropItemNaturally(player.getLocation(), item);

                } else {
                    ItemStack item = event.getInventory().getItem(33);
                    player.getInventory().addItem(item);
                }
            }
        }
    }

    @EventHandler
    public void anviltime(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        String title = event.getView().getTitle();
        if (title.equals(guiHandler.inventory_name10)) {
            if (event.getClickedInventory() != null) {
                if (event.getClickedInventory().equals(player.getInventory())) {
                    event.setCancelled(true);
                    if (event.getWhoClicked().getItemOnCursor() != null && event.getCurrentItem() != null) {
                        ItemStack item = event.getCurrentItem();
                        ItemStack item2 = event.getCurrentItem().clone();
                        if (event.getView().getItem(29) == null) {
                            if (MaterialTags.SWORDS.isTagged(item) || MaterialTags.AXES.isTagged(item)
                                    || MaterialTags.BOWS.isTagged(item) || MaterialTags.PICKAXES.isTagged(item)
                                    || MaterialTags.HOES.isTagged(item) || MaterialTags.HELMETS.isTagged(item)
                                    || MaterialTags.CHESTPLATES.isTagged(item) || MaterialTags.LEGGINGS.isTagged(item)
                                    || MaterialTags.BOOTS.isTagged(item) || MaterialTags.SHOVELS.isTagged(item)
                                    || item.getType() == Material.FISHING_ROD) {
                                item2.setAmount(1);
                                player.getInventory().removeItem(item2);

                                event.getView().setItem(29, item2);

                            }
                        } else {
                            if (item.getType() == Material.BOOK) {
                                if (event.getView().getItem(33) == null) {
                                    item2.setAmount(1);
                                    player.getInventory().removeItem(item2);
                                    event.getView().setItem(33, item2);
                                }
                                ItemStack itemanvil = event.getView().getItem(29).clone();
                                ItemStack book = event.getView().getItem(33);
                                NamespacedKey keytype = new NamespacedKey(plugin, "enchantType");
                                if (book.getItemMeta().getPersistentDataContainer().get(keytype,
                                        PersistentDataType.STRING).equals(itemanvil.getItemMeta()
                                        .getPersistentDataContainer()
                                        .get(keytype, PersistentDataType.STRING))) {
                                    if (itemanvil.getItemMeta().getLore()
                                            .contains(Painter.paint("&8<Boş Büyü Bölmesi>"))) {

                                        ItemMeta meta = book.getItemMeta();
                                        NamespacedKey key = new NamespacedKey(plugin, "Enchants");
                                        if (meta.getPersistentDataContainer() == null)
                                            return;

                                        PersistentDataContainer container = meta.getPersistentDataContainer();
                                        if (!container.has(key, Enchants))
                                            return;

                                        Optional<String> firstKey = container.get(key, Enchants).keySet().stream()
                                                .findFirst();
                                        if (firstKey.isPresent()) {
                                            String enchant = firstKey.get();
                                            NamespacedKey string = new NamespacedKey(plugin, "string");
                                            int level = container.get(key, Enchants).get(enchant);
                                            List<String> itemLore = itemanvil.getItemMeta().getLore();
                                            ItemMeta item2meta = itemanvil.getItemMeta();
                                            for (int i = 0; i < itemLore.size(); i++) {
                                                String lValue = itemLore.get(i);
                                                if (lValue.equals(Painter.paint("&8<Boş Büyü Bölmesi>"))) {
                                                    itemLore.set(i, Painter.paint(
                                                            container.get(string, PersistentDataType.STRING) + level));
                                                    break;
                                                }
                                            }

                                            if (item2meta.getPersistentDataContainer().get(key, Enchants) == null) {
                                                HashMap<String, Integer> enchs = new HashMap<String, Integer>();
                                                enchs.put(enchant, level);
                                                item2meta.addEnchant(Enchantment.WATER_WORKER, 1, true);
                                                item2meta.getPersistentDataContainer().set(key, Enchants, enchs);
                                                item2meta.setLore(itemLore);
                                                itemanvil.setItemMeta(item2meta);
                                                event.getView().setItem(40, itemanvil);
                                                ItemStack buyu1 = new ItemStack(Material.ANVIL);
                                                ItemMeta meta1 = buyu1.getItemMeta();
                                                List<String> lore = new ArrayList<>();
                                                meta1.setDisplayName(Painter.paint("&eMalzemeleri Birleştir"));
                                                lore.add(Painter.paint("&7Sağdaki ve soldaki bölmelere koyduğun "));
                                                lore.add(Painter.paint("&7malzemeleri birleştirebilirsin."));
                                                lore.add(Painter.paint(""));
                                                lore.add(Painter.paint(" &7Maliyet:"));
                                                lore.add(Painter.paint(" &7-&f " + level * 5 + " &fSeviye"));
                                                lore.add(Painter.paint(""));
                                                lore.add(Painter.paint(
                                                        "&7Birleştirmek için yukarıdaki ekipmana &e&lSağ Tıkla."));
                                                meta1.setLore(lore);
                                                buyu1.setItemMeta(meta1);
                                                event.getView().setItem(49, buyu1);
                                                lore.clear();
                                            } else {
                                                HashMap<String, Integer> enchs = item2meta.getPersistentDataContainer()
                                                        .get(key, Enchants);
                                                enchs.put(enchant, level);
                                                item2meta.addEnchant(Enchantment.WATER_WORKER, 1, true);
                                                item2meta.getPersistentDataContainer().set(key, Enchants, enchs);
                                                item2meta.setLore(itemLore);
                                                itemanvil.setItemMeta(item2meta);
                                                event.getView().setItem(40, itemanvil);
                                                ItemStack buyu1 = new ItemStack(Material.ANVIL);
                                                ItemMeta meta1 = buyu1.getItemMeta();
                                                List<String> lore = new ArrayList<>();
                                                meta1.setDisplayName(Painter.paint("&eMalzemeleri Birleştir"));
                                                lore.add(Painter.paint("&7Sağdaki ve soldaki bölmelere koyduğun "));
                                                lore.add(Painter.paint("&7malzemeleri birleştirebilirsin."));
                                                lore.add(Painter.paint(""));
                                                lore.add(Painter.paint(" &7Maliyet:"));
                                                lore.add(Painter.paint(" &7-&f " + level * 5 + " &fSeviye"));
                                                lore.add(Painter.paint(""));
                                                lore.add(Painter.paint(
                                                        "&7Birleştirmek için yukarıdaki ekipmana &e&lSağ Tıkla."));

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
                                    List<String> lore = new ArrayList<>();
                                    meta1.setDisplayName(Painter.paint("&cBu malzemeler birleşemez!"));
                                    lore.add(Painter.paint("&7Sağdaki ve soldaki bölmelere koyduğun "));
                                    lore.add(Painter.paint("&7malzemeler birbirlerine uygun değil!"));
                                    meta1.setLore(lore);
                                    buyu1.setItemMeta(meta1);
                                    event.getView().setItem(40, buyu1);
                                    lore.clear();

                                }
                            }
                        }

                    }
                } else {
                    event.setCancelled(true);
                    if (event.getWhoClicked().getItemOnCursor() != null && event.getCurrentItem() != null) {
                        ItemStack item = event.getCurrentItem();
                        int amount = item.getAmount();
                        if (item.equals(event.getView().getItem(40))) {
                            ItemStack anvillevel = event.getView().getItem(49);
                            ItemMeta levelmeta = anvillevel.getItemMeta();
                            List<String> lore = levelmeta.getLore();
                            String level = lore.get(4);
                            String xp = level.toString().split(" ")[2];
                            int i = Integer.parseInt(xp);

                            if (player.getLevel() > i) {
                                if (player.getInventory().firstEmpty() == -1) {
                                    player.setLevel(player.getLevel() - i);
                                    player.playSound(player, Sound.BLOCK_ANVIL_USE, 2, 0.6f);
                                    player.getWorld().dropItemNaturally(player.getLocation(), item);
                                    event.getView().setItem(29, null);
                                    event.getView().setItem(33, null);
                                    event.getView().setItem(40, null);
                                    event.getView().setItem(49, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));

                                } else {
                                    player.playSound(player, Sound.BLOCK_ANVIL_USE, 2, 0.6f);
                                    player.setLevel(player.getLevel() - i);
                                    player.getInventory().addItem(item);
                                    event.getView().setItem(29, null);
                                    event.getView().setItem(40, null);
                                    event.getView().setItem(33, null);
                                    event.getView().setItem(49, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
                                }
                            } else {
                                player.sendMessage(Painter.paint("&cYeterli seviyeye sahip değilsin!"));
                            }

                        }
                    }
                }
            }

        }

        if (event.getCurrentItem() == null) {
            return;
        }

    }
}
