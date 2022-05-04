package me.taylan.mooncore.level;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import eu.endercentral.crazy_advancements.advancement.AdvancementDisplay.AdvancementFrame;
import eu.endercentral.crazy_advancements.advancement.ToastNotification;
import fr.mrmicky.fastboard.FastBoard;
import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.commands.SeviyeCommand;
import me.taylan.mooncore.utils.ItemHandler;
import me.taylan.mooncore.utils.StatsManager;
import net.md_5.bungee.api.ChatColor;

public class Levels {

	private MoonCore plugin;
	private SeviyeCommand seviyeCommand;
	private StatsManager stats;
	private ItemHandler itemHandler;
	private BukkitRunnable r;

	public Levels(MoonCore plugin) {
		this.seviyeCommand = plugin.getSeviyeCommand();
		this.plugin = plugin;
		this.itemHandler = plugin.getItemHandler();
		this.stats = plugin.getStatsManager();

		r = new BukkitRunnable() {

			@Override
			public void run() {
				for (Player player : plugin.getServer().getOnlinePlayers()) {
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
					Date date = new Date(System.currentTimeMillis());
					FastBoard board = new FastBoard(player);
					int agirlik = stats.getAgirlik(player.getUniqueId());
					int maxagirlik = stats.getMaxAgirlik(player.getUniqueId());
					board.updateTitle(ChatColor.AQUA + "Moon Network");

					board.updateLines(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "     Remiel", "    ",
							ChatColor.GOLD + "Akçe ⛁" + ChatColor.WHITE + 0,
							ChatColor.WHITE + "Ağırlık: " + ChatColor.GRAY + agirlik + "/" + ChatColor.RED + maxagirlik,
							"", ChatColor.GRAY + player.getName(), ChatColor.DARK_GRAY + formatter.format(date),
							ChatColor.AQUA + "mc.moonnw.xyz"

					);
				}
			}
		};
		r.runTaskTimerAsynchronously(plugin, 0, 100L);

	}

	public void giveSmithLevel(Player p, ItemStack item) {
		UUID uuid = p.getUniqueId();
		int smithLevel = stats.getSmithLevel(uuid);
		int smithExp = stats.getSmithExp(uuid);
		int smithRequiredExp = stats.getSmithRequiredExp(uuid);
		FastBoard board = new FastBoard(p);

		board.updateTitle(ChatColor.AQUA + "Moon Network");

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date(System.currentTimeMillis());

		ToastNotification notification = new ToastNotification(Material.SMITHING_TABLE,
				ChatColor.YELLOW + "Demircilikte ustalığın yükseldi!", AdvancementFrame.CHALLENGE);

		if (ExpList.getExpMap().containsKey(item.getType().toString())) {
			int exp2 = ExpList.getExpMap().get(item.getType().toString());
			stats.setSmithExp(uuid, exp2);

		}
		int prog = 100 * smithExp / smithRequiredExp;
		int agirlik = stats.getAgirlik(uuid);
		int maxagirlik = stats.getMaxAgirlik(uuid);
		board.updateLines(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "        Remiel", " ",
				ChatColor.GOLD + "Akçe ⛁" + ChatColor.WHITE + 0,
				ChatColor.WHITE + "Ağırlık: " + ChatColor.GRAY + agirlik + "/" + ChatColor.RED + maxagirlik, "   ",

				ChatColor.YELLOW + "Demircilik " + ChatColor.WHITE + "Ustalık " + smithLevel,
				ChatColor.GREEN + "EXP " + ChatColor.WHITE + smithExp + ChatColor.GRAY + "/" + ChatColor.WHITE
						+ smithRequiredExp + ChatColor.GRAY + " (" + ChatColor.GREEN + "%" + prog + ChatColor.GRAY
						+ ")",
				"     ", ChatColor.GRAY + p.getName(), ChatColor.DARK_GRAY + formatter.format(date),
				ChatColor.AQUA + "mc.moonnw.xyz"

		);
		if (smithExp >= smithRequiredExp) {
			int Exp = stats.getExp(uuid);
			int RequiredExp = stats.getRequiredExp(uuid);
			int Level = stats.getLevel(uuid);
			stats.setExp(uuid, smithLevel * 4);
			if (Exp >= RequiredExp) {
				seviyeCommand.seviyeAtlat(p, 1);

				stats.setRequiredExp(uuid, RequiredExp * 3);
				stats.setExp(uuid, 0);

			}

			smithLevel++;
			stats.setSmithLevel(uuid, smithLevel);
			stats.setSmithRequiredExp(uuid, smithRequiredExp);
			stats.setSmithExp(uuid, 0);
			notification.send(p);

		}
		new BukkitRunnable() {

			@Override
			public void run() {
				FastBoard board = new FastBoard(p);

				board.updateTitle(ChatColor.AQUA + "Moon Network");
				board.updateLines(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "     Remiel", "    ",
						ChatColor.GOLD + "Akçe ⛁" + ChatColor.WHITE + 0, "", ChatColor.GRAY + p.getName(),
						ChatColor.DARK_GRAY + formatter.format(date), ChatColor.AQUA + "mc.moonnw.xyz"

				);
			}
		}.runTaskLaterAsynchronously(plugin, 80L);
	}

	public void giveCookLevel(Player p, ItemStack item) {
		UUID uuid = p.getUniqueId();
		int cookLevel = stats.getCookLevel(uuid);
		int cookExp = stats.getCookExp(uuid);
		int cookRequiredExp = stats.getCookRequiredExp(uuid);
		FastBoard board = new FastBoard(p);

		board.updateTitle(ChatColor.AQUA + "Moon Network");

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date(System.currentTimeMillis());

		ToastNotification notification = new ToastNotification(Material.BREAD,
				ChatColor.YELLOW + "Aşçılıkta ustalığın yükseldi!", AdvancementFrame.CHALLENGE);

		if (ExpList.getExpMap().containsKey(item.getType().toString())) {
			int exp2 = ExpList.getExpMap().get(item.getType().toString());
			stats.setCookExp(uuid, exp2);

		}
		int prog = 100 * cookExp / cookRequiredExp;
		int agirlik = stats.getAgirlik(uuid);
		int maxagirlik = stats.getMaxAgirlik(uuid);
		board.updateLines(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "        Remiel", " ",
				ChatColor.GOLD + "Akçe ⛁" + ChatColor.WHITE + 0,
				ChatColor.WHITE + "Ağırlık: " + ChatColor.GRAY + agirlik + "/" + ChatColor.RED + maxagirlik, "   ",

				ChatColor.YELLOW + "Aşçılık " + ChatColor.WHITE + "Ustalık " + cookLevel,
				ChatColor.GREEN + "EXP " + ChatColor.WHITE + cookExp + ChatColor.GRAY + "/" + ChatColor.WHITE
						+ cookRequiredExp + ChatColor.GRAY + " (" + ChatColor.GREEN + "%" + prog + ChatColor.GRAY + ")",
				"     ", ChatColor.GRAY + p.getName(), ChatColor.DARK_GRAY + formatter.format(date),
				ChatColor.AQUA + "mc.moonnw.xyz"

		);
		if (cookExp >= cookRequiredExp) {
			int Exp = stats.getExp(uuid);
			int RequiredExp = stats.getRequiredExp(uuid);
			stats.setExp(uuid, cookLevel * 4);
			if (Exp >= RequiredExp) {
				seviyeCommand.seviyeAtlat(p, 1);

				stats.setRequiredExp(uuid, RequiredExp * 3);
				stats.setExp(uuid, 0);

			}

			cookLevel++;
			stats.setCookLevel(uuid, cookLevel);
			stats.setCookRequiredExp(uuid, cookRequiredExp * 2);
			stats.setCookExp(uuid, 0);
			notification.send(p);

		}
		new BukkitRunnable() {

			@Override
			public void run() {
				FastBoard board = new FastBoard(p);

				board.updateTitle(ChatColor.AQUA + "Moon Network");
				board.updateLines(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "     Remiel", "    ",
						ChatColor.GOLD + "Akçe ⛁" + ChatColor.WHITE + 0, "", ChatColor.GRAY + p.getName(),
						ChatColor.DARK_GRAY + formatter.format(date), ChatColor.AQUA + "mc.moonnw.xyz"

				);
			}
		}.runTaskLaterAsynchronously(plugin, 80L);
	}

	public void giveCombatEXP(Player player, int exp) {
		ToastNotification notification = new ToastNotification(Material.IRON_SWORD,
				ChatColor.YELLOW + "Avcılıkta ustalığın yükseldi!", AdvancementFrame.CHALLENGE);
		UUID uuid = player.getUniqueId();
		int combatLevel = stats.getCombatLevel(uuid);
		int combatExp = stats.getCombatExp(uuid);
		int combatRequiredExp = stats.getCombatRequiredExp(uuid);

		FastBoard board = new FastBoard(player);

		board.updateTitle(ChatColor.AQUA + "Moon Network");
		stats.setCombatExp(uuid, exp);
		int prog = 100 * combatExp / combatRequiredExp;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date(System.currentTimeMillis());
		int agirlik = stats.getAgirlik(player.getUniqueId());
		int maxagirlik = stats.getMaxAgirlik(player.getUniqueId());
		board.updateLines(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "        Remiel", " ",
				ChatColor.GOLD + "Akçe ⛁" + ChatColor.WHITE + 0,
				ChatColor.WHITE + "Ağırlık: " + ChatColor.GRAY + agirlik + "/" + ChatColor.RED + maxagirlik, "   ",

				ChatColor.YELLOW + "Avcılık " + ChatColor.WHITE + "Ustalık " + combatLevel,
				ChatColor.GREEN + "EXP " + ChatColor.WHITE + combatExp + ChatColor.GRAY + "/" + ChatColor.WHITE
						+ combatRequiredExp + ChatColor.GRAY + " (" + ChatColor.GREEN + "%" + prog + ChatColor.GRAY
						+ ")",
				"     ", ChatColor.GRAY + player.getName(), ChatColor.DARK_GRAY + formatter.format(date),
				ChatColor.AQUA + "mc.moonnw.xyz"

		);

		if (combatExp >= combatRequiredExp) {
			int Exp = stats.getExp(uuid);
			int RequiredExp = stats.getRequiredExp(uuid);
			stats.setExp(uuid, combatLevel * 4);
			if (Exp >= RequiredExp) {
				seviyeCommand.seviyeAtlat(player, 1);

				stats.setRequiredExp(uuid, RequiredExp * 3);
				stats.setExp(uuid, 0);

			}

			combatLevel++;
			stats.setCombatLevel(uuid, combatLevel);
			stats.setCombatRequiredExp(uuid, combatRequiredExp * 3);
			stats.setCombatExp(uuid, 0);
			notification.send(player);

		}
	}

	public void giveOduncuExp(Player player, Block block) {
		ToastNotification notification = new ToastNotification(Material.IRON_AXE,
				ChatColor.YELLOW + "Odunculukta ustalığın yükseldi!", AdvancementFrame.CHALLENGE);
		UUID uuid = player.getUniqueId();
		int odunculukLevel = stats.getOdunculukLevel(uuid);
		int odunculukExp = stats.getOdunculukExp(uuid);
		int odunculukRequiredExp = stats.getOdunculukRequiredExp(uuid);
		FastBoard board = new FastBoard(player);

		board.updateTitle(ChatColor.AQUA + "Moon Network");
		if (ExpList.getExpMap().containsKey(block.getType().toString())) {

			int exp = ExpList.getExpMap().get(block.getType().toString());
			stats.setOdunculukExp(uuid, exp);
		}

		int prog = 100 * odunculukExp / odunculukRequiredExp;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date(System.currentTimeMillis());
		int agirlik = stats.getAgirlik(player.getUniqueId());
		int maxagirlik = stats.getMaxAgirlik(player.getUniqueId());
		board.updateLines(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "         Remiel", " ",
				ChatColor.GOLD + "Akçe ⛁" + ChatColor.WHITE + 0,
				ChatColor.WHITE + "Ağırlık: " + ChatColor.GRAY + agirlik + "/" + ChatColor.RED + maxagirlik, "   ",

				ChatColor.YELLOW + "Odunculuk " + ChatColor.WHITE + "Ustalık " + odunculukLevel,
				ChatColor.GREEN + "EXP " + ChatColor.WHITE + odunculukExp + ChatColor.GRAY + "/" + ChatColor.WHITE
						+ odunculukRequiredExp + ChatColor.GRAY + " (" + ChatColor.GREEN + "%" + prog + ChatColor.GRAY
						+ ")",
				"     ", ChatColor.GRAY + player.getName(), ChatColor.DARK_GRAY + formatter.format(date),
				ChatColor.AQUA + "mc.moonnw.xyz"

		);
		if (odunculukExp >= odunculukRequiredExp) {
			int Exp = stats.getExp(uuid);
			int RequiredExp = stats.getRequiredExp(uuid);
			int Level = stats.getLevel(uuid);
			stats.setExp(uuid, odunculukLevel * 3);
			if (Exp >= RequiredExp) {
				seviyeCommand.seviyeAtlat(player, 1);

				stats.setRequiredExp(uuid, RequiredExp * 3);
				stats.setExp(uuid, 0);
			}

			odunculukLevel++;

			stats.setOdunculukLevel(uuid, odunculukLevel);
			stats.setOdunculukRequiredExp(uuid, odunculukRequiredExp * 2);
			stats.setOdunculukExp(uuid, 0);
			notification.send(player);
		}

	}

	public void giveFarmingExp(Player player, Block block) {
		ToastNotification notification = new ToastNotification(Material.WHEAT,
				ChatColor.YELLOW + "Çiftçilikte ustalığın yükseldi!", AdvancementFrame.CHALLENGE);
		UUID uuid = player.getUniqueId();
		int farmingLevel = stats.getFarmingLevel(uuid);
		int farmingExp = stats.getFarmingExp(uuid);
		int farmingRequiredExp = stats.getFarmingRequiredExp(uuid);
		FastBoard board = new FastBoard(player);

		board.updateTitle(ChatColor.AQUA + "Moon Network");
		if (ExpList.getExpMap().containsKey(block.getType().toString())) {

			int exp = ExpList.getExpMap().get(block.getType().toString());
			stats.setFarmingExp(uuid, exp);
		}

		int prog = 100 * farmingExp / farmingRequiredExp;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date(System.currentTimeMillis());
		int agirlik = stats.getAgirlik(player.getUniqueId());
		int maxagirlik = stats.getMaxAgirlik(player.getUniqueId());
		board.updateLines(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "         Remiel", " ",
				ChatColor.GOLD + "Akçe ⛁" + ChatColor.WHITE + 0,
				ChatColor.WHITE + "Ağırlık: " + ChatColor.GRAY + agirlik + "/" + ChatColor.RED + maxagirlik, "   ",

				ChatColor.YELLOW + "Çiftçilik " + ChatColor.WHITE + "Ustalık " + farmingLevel,
				ChatColor.GREEN + "EXP " + ChatColor.WHITE + farmingExp + ChatColor.GRAY + "/" + ChatColor.WHITE
						+ farmingRequiredExp + ChatColor.GRAY + " (" + ChatColor.GREEN + "%" + prog + ChatColor.GRAY
						+ ")",
				"     ", ChatColor.GRAY + player.getName(), ChatColor.DARK_GRAY + formatter.format(date),
				ChatColor.AQUA + "mc.moonnw.xyz"

		);
		if (farmingExp >= farmingRequiredExp) {
			int Exp = stats.getExp(uuid);
			int RequiredExp = stats.getRequiredExp(uuid);
			int Level = stats.getLevel(uuid);
			stats.setExp(uuid, farmingLevel * 3);
			if (Exp >= RequiredExp) {
				seviyeCommand.seviyeAtlat(player, 1);

				stats.setRequiredExp(uuid, RequiredExp * 3);
				stats.setExp(uuid, 0);

			}
			farmingLevel++;
			stats.setFarmingLevel(uuid, farmingLevel);
			stats.setFarmingRequiredExp(uuid, farmingRequiredExp * 2);
			stats.setFarmingExp(uuid, 0);
			notification.send(player);
		}

	}

	public void giveFishingExp(Player player, ItemStack item) {
		ToastNotification notification = new ToastNotification(Material.FISHING_ROD,
				ChatColor.YELLOW + "Balıkçılıkta ustalığın yükseldi!", AdvancementFrame.CHALLENGE);
		UUID uuid = player.getUniqueId();
		int fishingLevel = stats.getFishingLevel(uuid);
		int fishingExp = stats.getFishingExp(uuid);
		int fishingRequiredExp = stats.getFishingRequiredExp(uuid);
		FastBoard board = new FastBoard(player);

		board.updateTitle(ChatColor.AQUA + "Moon Network");
		if (ExpList.getExpMap().containsKey(item.getType().toString())) {

			int exp2 = ExpList.getExpMap().get(item.getType().toString());
			player.sendMessage(ChatColor.YELLOW + "Bir " + item.getType().toString() + " yakaladın.");
			stats.setFishingExp(uuid, exp2);

		} else if (item == itemHandler.woodKutu() || item == itemHandler.ironKutu() || item == itemHandler.mistikKutu()
				|| item == itemHandler.goldKutu()) {
			player.sendMessage(ChatColor.YELLOW + "Bir " + item.getItemMeta().getDisplayName() + " yakaladın.");
			stats.setFishingExp(uuid, 40);
		}

		int prog = 100 * fishingExp / fishingRequiredExp;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date(System.currentTimeMillis());
		int agirlik = stats.getAgirlik(player.getUniqueId());
		int maxagirlik = stats.getMaxAgirlik(player.getUniqueId());
		board.updateLines(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "      Remiel", " ",
				ChatColor.GOLD + "Akçe ⛁" + ChatColor.WHITE + 0,
				ChatColor.WHITE + "Ağırlık: " + ChatColor.GRAY + agirlik + "/" + ChatColor.RED + maxagirlik, "   ",

				ChatColor.YELLOW + "Balıkçılık " + ChatColor.WHITE + "Ustalık " + fishingLevel,
				ChatColor.GREEN + "EXP " + ChatColor.WHITE + fishingExp + ChatColor.GRAY + "/" + ChatColor.WHITE
						+ fishingRequiredExp + ChatColor.GRAY + " (" + ChatColor.GREEN + "%" + prog + ChatColor.GRAY
						+ ")",
				"     ", ChatColor.GRAY + player.getName(), ChatColor.DARK_GRAY + formatter.format(date),
				ChatColor.AQUA + "mc.moonnw.xyz"

		);
		if (fishingExp >= fishingRequiredExp) {
			int Exp = stats.getExp(uuid);
			int RequiredExp = stats.getRequiredExp(uuid);
			int Level = stats.getLevel(uuid);
			stats.setExp(uuid, fishingLevel * 3);
			if (Exp >= RequiredExp) {
				seviyeCommand.seviyeAtlat(player, 1);

				stats.setRequiredExp(uuid, RequiredExp * 3);
				stats.setExp(uuid, 0);

			}
			fishingLevel++;
			stats.setFishingLevel(uuid, fishingLevel);
			stats.setFishingRequiredExp(uuid, fishingRequiredExp * 2);
			stats.setFishingExp(uuid, 0);
			notification.send(player);
		}

	}

	public void giveMiningExp(Player player, Block block) {
		ToastNotification notification = new ToastNotification(Material.IRON_PICKAXE,
				ChatColor.YELLOW + "Madencilikte ustalığın yükseldi!", AdvancementFrame.CHALLENGE);
		UUID uuid = player.getUniqueId();
		int miningLevel = stats.getMadencilikLevel(uuid);
		int miningExp = stats.getMadencilikExp(uuid);
		int miningRequiredExp = stats.getMadencilikRequiredExp(uuid);
		FastBoard board = new FastBoard(player);

		board.updateTitle(ChatColor.AQUA + "Moon Network");
		if (ExpList.getExpMap().containsKey(block.getType().toString())) {
			int exp = ExpList.getExpMap().get(block.getType().toString());
			stats.setMadencilikExp(uuid, exp);

		}

		int prog = 100 * miningExp / miningRequiredExp;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date(System.currentTimeMillis());
		int agirlik = stats.getAgirlik(player.getUniqueId());
		int maxagirlik = stats.getMaxAgirlik(player.getUniqueId());
		board.updateLines(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "        Remiel", " ",
				ChatColor.GOLD + "Akçe ⛁" + ChatColor.WHITE + 0,
				ChatColor.WHITE + "Ağırlık: " + ChatColor.GRAY + agirlik + "/" + ChatColor.RED + maxagirlik, "   ",

				ChatColor.YELLOW + "Madencilik " + ChatColor.WHITE + "Ustalık " + miningLevel,
				ChatColor.GREEN + "EXP " + ChatColor.WHITE + miningExp + ChatColor.GRAY + "/" + ChatColor.WHITE
						+ miningRequiredExp + ChatColor.GRAY + " (" + ChatColor.GREEN + "%" + prog + ChatColor.GRAY
						+ ")",
				"     ", ChatColor.GRAY + player.getName(), ChatColor.DARK_GRAY + formatter.format(date),
				ChatColor.AQUA + "mc.moonnw.xyz"

		);
		if (miningExp >= miningRequiredExp) {
			int Exp = stats.getExp(uuid);
			int RequiredExp = stats.getRequiredExp(uuid);
			int Level = stats.getLevel(uuid);
			stats.setExp(uuid, miningLevel * 3);
			if (Exp >= RequiredExp) {
				seviyeCommand.seviyeAtlat(player, 1);

				stats.setRequiredExp(uuid, RequiredExp * 3);
				stats.setExp(uuid, 0);

			}

			miningLevel++;
			stats.setMadencilikLevel(uuid, miningLevel);
			stats.setMadencilikRequiredExp(uuid, miningRequiredExp * 2);
			stats.setMadencilikExp(uuid, 0);
			notification.send(player);
		}

	}

	public void giveBrewEXP(Player player, Material mat) {
		ToastNotification notification = new ToastNotification(Material.BREWING_STAND,
				ChatColor.YELLOW + "Simyacılıkta ustalığın yükseldi!", AdvancementFrame.CHALLENGE);
		UUID uuid = player.getUniqueId();
		int alchemyLevel = stats.getAlchemyLevel(uuid);
		int alchemyExp = stats.getAlchemyExp(uuid);
		int alchemyRequiredExp = stats.getAlchemyRequiredExp(uuid);
		FastBoard board = new FastBoard(player);

		board.updateTitle(ChatColor.AQUA + "Moon Network");
		if (ExpList.getExpMap().containsKey(mat.toString())) {
			int exp = ExpList.getExpMap().get(mat.toString());
			stats.setAlchemyExp(uuid, exp);
		}

		int prog = 100 * alchemyExp / alchemyRequiredExp;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date(System.currentTimeMillis());
		int agirlik = stats.getAgirlik(player.getUniqueId());
		int maxagirlik = stats.getMaxAgirlik(player.getUniqueId());
		board.updateLines(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "        Remiel", " ",
				ChatColor.GOLD + "Akçe ⛁" + ChatColor.WHITE + 0,
				ChatColor.WHITE + "Ağırlık: " + ChatColor.GRAY + agirlik + "/" + ChatColor.RED + maxagirlik, "   ",

				ChatColor.YELLOW + "Simyacılık " + ChatColor.WHITE + "Ustalık " + alchemyLevel,
				ChatColor.GREEN + "EXP " + ChatColor.WHITE + alchemyExp + ChatColor.GRAY + "/" + ChatColor.WHITE
						+ alchemyRequiredExp + ChatColor.GRAY + " (" + ChatColor.GREEN + "%" + prog + ChatColor.GRAY
						+ ")",
				"     ", ChatColor.GRAY + player.getName(), ChatColor.DARK_GRAY + formatter.format(date),
				ChatColor.AQUA + "mc.moonnw.xyz"

		);

		if (alchemyExp >= alchemyRequiredExp) {
			int Exp = stats.getExp(uuid);
			int RequiredExp = stats.getRequiredExp(uuid);
			int Level = stats.getLevel(uuid);
			stats.setExp(uuid, alchemyLevel * 3);
			if (Exp >= RequiredExp) {
				seviyeCommand.seviyeAtlat(player, 1);

				stats.setRequiredExp(uuid, RequiredExp * 3);
				stats.setExp(uuid, 0);

			}
			alchemyLevel++;
			stats.setAlchemyLevel(uuid, alchemyLevel);
			stats.setAlchemyRequiredExp(uuid, alchemyRequiredExp * 2);
			stats.setAlchemyExp(uuid, 0);
			notification.send(player);

		}

	}

}
