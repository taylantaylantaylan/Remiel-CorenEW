package me.taylan.mooncore.listeners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import com.destroystokyo.paper.MaterialTags;
import com.manya.pdc.DataTypes;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.GuiHandler;
import me.taylan.mooncore.utils.ItemHandler;
import me.taylan.mooncore.utils.Painter;
import me.taylan.mooncore.utils.StatsManager;

public class InventoryClickListener implements Listener {
	private static HashMap<UUID, Block> SmithBlock = new HashMap<UUID, Block>();
	private static HashMap<UUID, Block> CookBlock = new HashMap<UUID, Block>();
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
			if (event.getClickedBlock().getType() == Material.SMOKER) {
				Block smok = event.getClickedBlock();
				if (CookBlock.isEmpty()) {
					CookBlock.put(player.getUniqueId(), smok);
					int cookProduct = stats.getCookProduction(player.getUniqueId());
					if (cookProduct <= 0) {
						event.setCancelled(true);
						player.openInventory(guiHandler.cookGui(player));
					} else {
						event.setCancelled(true);
						player.openInventory(guiHandler.productCook(player));
					}
				} else if (CookBlock.containsKey(player.getUniqueId())) {

					int cookProduct = stats.getCookProduction(player.getUniqueId());
					if (cookProduct <= 0) {
						event.setCancelled(true);
						player.openInventory(guiHandler.cookGui(player));
					} else {
						event.setCancelled(true);
						player.openInventory(guiHandler.productCook(player));
					}

				}
			}
		}
	}

	@EventHandler
	public void CookClose(InventoryCloseEvent event) {
		StatsManager stats = new StatsManager(plugin);
		Player player = (Player) event.getPlayer();
		if (CookBlock.containsKey(player.getUniqueId())) {
			int production = stats.getCookProduction(player.getUniqueId());
			if (event.getInventory().equals(guiHandler.cookGui(player))) {
				CookBlock.remove(player.getUniqueId());
			}
		}
	}

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
	public void onClickKnowledge(InventoryClickEvent event) {
		NamespacedKey star = new NamespacedKey(plugin, "star");
		Player player = (Player) event.getWhoClicked();
		if (!(event.getInventory() == player.getInventory())) {
			return;
		}
		if (event.getWhoClicked().getItemOnCursor() != null && event.getCurrentItem() != null) {
			if (event.getCurrentItem().getItemMeta().getPersistentDataContainer().has(star,
					PersistentDataType.STRING)) {
				event.setCancelled(true);
				player.openInventory(guiHandler.bilgikitabı(player));
				event.setCurrentItem(null);
			}
		}
	}

	@EventHandler
	public void onClick5(InventoryClickEvent event) {
		String title = event.getView().getTitle();
		if (title.equals(guiHandler.inventory_name5)) {
			event.setCancelled(true);
			if (event.getCurrentItem() == null) {
				return;
			}

			guiHandler.clicked((Player) event.getWhoClicked(), event.getSlot(), event.getCurrentItem(),
					event.getInventory());

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
		if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (event.getClickedBlock().getType() == Material.ENCHANTING_TABLE) {
				Block block = event.getClickedBlock();

				event.setCancelled(true);
				player.openInventory(guiHandler.GUIENCH(player));

			}
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

	@EventHandler
	public void SmithClose(InventoryCloseEvent event) {
		Player player = (Player) event.getPlayer();
		if (SmithBlock.containsKey(player.getUniqueId())) {
			int production = stats.getProduction(player.getUniqueId());
			int production1 = stats.getProduction1(player.getUniqueId());
			if (event.getInventory().equals(guiHandler.demircimasasasas(player))
					|| event.getInventory().equals(guiHandler.product(player))) {
				SmithBlock.remove(player.getUniqueId());

			}
		}
	}

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
						int enchLevel = plugin.getConfig().getInt("Levels." + player.getUniqueId() + ".EnchLevel");
						if (event.getView().getItem(31) == null) {
							int amount = item.getAmount();
							item2.setAmount(1);
							player.getInventory().removeItem(item2);
							event.getView().setItem(31, item2);
						}

						ItemStack buyu1 = new ItemStack(Material.EXPERIENCE_BOTTLE);
						ItemMeta meta1 = buyu1.getItemMeta();
						List<String> lore = new ArrayList<>();
						meta1.setDisplayName(Painter.paint("&e5. Seviye Büyü"));
						lore.add(Painter.paint("&aUstalık 1"));
						lore.add("");
						lore.add(Painter.paint("&7???"));
						lore.add("");
						lore.add(Painter.paint(" &7Gerekli Malzemeler:"));
						lore.add(Painter.paint(" &7- &f1 Büyü Parşömeni"));
						lore.add(Painter.paint(" &7- &f5 Seviye"));
						lore.add(Painter.paint(""));
						lore.add(Painter.paint("&7Büyüyü ekipmanına basmak için"));
						lore.add(Painter.paint("&e&lSağ Tıkla."));
						meta1.setLore(lore);
						buyu1.setItemMeta(meta1);
						event.getView().setItem(29, buyu1);
						lore.clear();
						ItemStack buyu2 = new ItemStack(Material.EXPERIENCE_BOTTLE);
						ItemMeta meta2 = buyu2.getItemMeta();
						List<String> lore2 = new ArrayList<>();
						meta2.setDisplayName(Painter.paint("&d10. Seviye Büyü"));
						lore2.add(Painter.paint("&aUstalık 5"));
						lore2.add("");
						lore2.add(Painter.paint("&7???"));
						lore2.add("");
						lore2.add(Painter.paint(" &7Gerekli Malzemeler:"));
						lore2.add(Painter.paint(" &7- &f2 Büyü Parşömeni"));
						lore2.add(Painter.paint(" &7- &f10 Seviye"));
						lore2.add(Painter.paint(""));
						if (enchLevel >= 5) {
							lore2.add(Painter.paint("&7Büyüyü ekipmanına basmak için"));
							lore2.add(Painter.paint("&e&lSağ Tıkla."));
						} else {
							lore2.add(
									Painter.paint("&cBüyücülükteki ustalığınız bu büyüyü basmak için yeterli değil!"));
						}
						meta2.setLore(lore2);
						buyu2.setItemMeta(meta2);
						event.getView().setItem(40, buyu2);
						lore.clear();
						ItemStack buyu3 = new ItemStack(Material.EXPERIENCE_BOTTLE);
						ItemMeta meta3 = buyu3.getItemMeta();
						List<String> lore3 = new ArrayList<>();
						meta3.setDisplayName(Painter.paint("&c15. Seviye Büyü"));
						lore3.add(Painter.paint("&aUstalık 10"));
						lore3.add("");
						lore3.add(Painter.paint("&7???"));
						lore3.add("");
						lore3.add(Painter.paint(" &7Gerekli Malzemeler:"));
						lore3.add(Painter.paint(" &7- &f3 Büyü Parşömeni"));
						lore3.add(Painter.paint(" &7- &f15 Seviye"));
						lore3.add(Painter.paint(""));
						if (enchLevel >= 10) {
							lore3.add(Painter.paint("&7Büyüyü ekipmanına basmak için"));
							lore3.add(Painter.paint("&e&lSağ Tıkla."));
						} else {
							lore3.add(
									Painter.paint("&cBüyücülükteki ustalığınız bu büyüyü basmak için yeterli değil!"));
						}
						meta3.setLore(lore3);
						buyu3.setItemMeta(meta3);
						event.getView().setItem(33, buyu3);
						lore.clear();

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
							event.getView().setItem(31, null);
							event.getView().setItem(29, new ItemStack(Material.RED_STAINED_GLASS_PANE));
							event.getView().setItem(40, new ItemStack(Material.RED_STAINED_GLASS_PANE));
							event.getView().setItem(33, new ItemStack(Material.RED_STAINED_GLASS_PANE));

						} else {
							player.getInventory().addItem(item);
							event.getView().setItem(31, null);
							event.getView().setItem(29, new ItemStack(Material.RED_STAINED_GLASS_PANE));
							event.getView().setItem(40, new ItemStack(Material.RED_STAINED_GLASS_PANE));
							event.getView().setItem(33, new ItemStack(Material.RED_STAINED_GLASS_PANE));
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
			if (event.getInventory().getItem(31) != null) {
				if (player.getInventory().firstEmpty() == -1) {
					ItemStack item = event.getInventory().getItem(31);
					player.getWorld().dropItemNaturally(player.getLocation(), item);

				} else {
					ItemStack item = event.getInventory().getItem(31);
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
