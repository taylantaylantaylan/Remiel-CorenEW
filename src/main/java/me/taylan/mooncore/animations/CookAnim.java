package me.taylan.mooncore.animations;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Smoker;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Lightable;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.level.Levels;
import me.taylan.mooncore.listeners.InventoryClickListener;
import me.taylan.mooncore.utils.GuiHandler;
import me.taylan.mooncore.utils.Painter;
import me.taylan.mooncore.utils.StatsManager;
import net.md_5.bungee.api.ChatColor;

public class CookAnim {
	public MoonCore plugin;
	private Levels Levels;
	private GuiHandler guiHandler;
	private CookAnim cookAnim;

	private StatsManager stats;

	public CookAnim(MoonCore plugin) {
		this.cookAnim = plugin.getCookAnim();
		this.plugin = plugin;
		this.guiHandler = plugin.getGuiHandler();
		this.Levels = plugin.getLevels();
		this.stats = plugin.getStatsManager();
	}

	public void cookAnimation(Player p, int cookTime, ItemStack result, int exp) {
		int timer = stats.getCookProduction(p.getUniqueId());
		if (timer <= 0) {
			Block block = InventoryClickListener.getCookBlock().get(p.getUniqueId());
			Location loc = block.getLocation().add(0.5, 1, 0.5);
			Location loc2 = block.getLocation().add(0.5, 1.2, 0.5);
			World world = Bukkit.getWorld("world");
			Material type = block.getType();
			BlockState state = block.getState();
			Smoker smok = (Smoker) state;
			BlockData data = block.getState().getBlockData();
			Lightable lit = (Lightable) data;
			new BukkitRunnable() {

				@Override
				public void run() {
					Material type = block.getType();
					BlockState state = block.getState();
					Smoker smok = (Smoker) state;
					BlockData data = block.getState().getBlockData();
					Lightable lit = (Lightable) data;
					lit.setLit(true);
					state.setBlockData((BlockData) data);
					state.update();
				}

			}.runTaskLater(plugin, 1L);
			world.spawn(loc2, ArmorStand.class, armorStand2 -> {
				armorStand2.setMarker(true);
				armorStand2.setVisible(false);
				armorStand2.setGravity(false);
				armorStand2.setSmall(true);
				armorStand2.setCustomNameVisible(true);
				armorStand2.setCustomName(ChatColor.YELLOW + "Pişiriliyor...");

				world.spawn(loc, ArmorStand.class, armorStand -> {
					armorStand.setMarker(true);
					armorStand.setVisible(false);
					armorStand.setGravity(false);
					armorStand.setSmall(true);
					armorStand.setCustomNameVisible(true);
					armorStand.setCustomName("");
					new BukkitRunnable() {

						@Override
						public void run() {
							int timer = stats.getCookProduction(p.getUniqueId());
							stats.setCookProduction(p.getUniqueId(), 1);
							int remain = cookTime - timer;
							armorStand.setCustomName(
									ChatColor.GOLD + "Yemeğin Hazır Olmasına: " + ChatColor.WHITE + remain + " Saniye");
							if (timer >= cookTime) {
								Levels.giveCookLevel(p, result);

								armorStand.setCustomName(ChatColor.GREEN + "✔");
								lit.setLit(false);
								state.setBlockData((BlockData) data);
								state.update();
								p.getInventory().addItem(result);
								new BukkitRunnable() {

									@Override
									public void run() {
										armorStand.remove();

									}
								}.runTaskLater(plugin, 40L);

								armorStand2.remove();
								stats.setCookProduction(p.getUniqueId(), -timer - 1);
								InventoryClickListener.getCookBlock().remove(p.getUniqueId());
								cancel();
							}

						}
					}.runTaskTimer(plugin, 0L, 25L);
				});
			});
		} else {
			p.sendMessage(Painter.paint("&CZaten bir yemek pişiriyorsun!"));
		}
	}

	public void cooking(Player player, ItemStack ingrident, ItemStack product, int malzemeSayi, int productsayi,
			int cookTime, int exp) {

		ItemStack malzeme = new ItemStack(ingrident);
		ItemStack bread = new ItemStack(product);
		bread.setAmount(productsayi);
		malzeme.setAmount(malzemeSayi);

		if (player.getInventory().containsAtLeast(malzeme, malzemeSayi)) {

			player.getInventory().removeItem(malzeme);
			player.closeInventory();
			cookAnim.cookAnimation(player, cookTime, bread, exp);
			ItemStack bread2 = bread.clone();
			ItemMeta meta2 = bread2.getItemMeta();
			ArrayList<String> lore = new ArrayList<String>();
			lore.add(ChatColor.GRAY + " ???");
			lore.add(ChatColor.GRAY + " ???");
			lore.add(ChatColor.GRAY + " ???");
			meta2.setDisplayName(Painter.paint("&fEkmek [T1]"));
			meta2.setLore(lore);
			bread2.setItemMeta(meta2);
			guiHandler.inv11.setItem(13, bread2);
		} else {
			player.sendMessage(Painter.paint("&cMalzemeler eksik."));
		}

	}

}
