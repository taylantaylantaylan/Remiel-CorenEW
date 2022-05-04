package me.taylan.mooncore;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.taylan.mooncore.animations.CookAnim;
import me.taylan.mooncore.animations.SmithAnim;
import me.taylan.mooncore.commands.BackCommand;
import me.taylan.mooncore.commands.ClaimSetterCommand;
import me.taylan.mooncore.commands.DiscordCommand;
import me.taylan.mooncore.commands.KnowledgeCommand;
import me.taylan.mooncore.commands.NitelikCommand;
import me.taylan.mooncore.commands.PlaytimeCommand;
import me.taylan.mooncore.commands.ProfileCommand;
import me.taylan.mooncore.commands.SeviyeCommand;
import me.taylan.mooncore.commands.SkillCommand;
import me.taylan.mooncore.commands.StatsCommand;
import me.taylan.mooncore.enchanting.EnchantRunnable;
import me.taylan.mooncore.enchanting.Enchants;
import me.taylan.mooncore.level.ExpList;
import me.taylan.mooncore.level.Levels;
import me.taylan.mooncore.listeners.AccessoryListener;
import me.taylan.mooncore.listeners.BlockRegenListener;
import me.taylan.mooncore.listeners.BrewListener;
import me.taylan.mooncore.listeners.ChunkLoadListener;
import me.taylan.mooncore.listeners.EnchantListener;
import me.taylan.mooncore.listeners.EntityHealthListener;
import me.taylan.mooncore.listeners.EntityPotionListener;
import me.taylan.mooncore.listeners.InventoryClickListener;
import me.taylan.mooncore.listeners.ItemDropListener;
import me.taylan.mooncore.listeners.ItemPickupListener;
import me.taylan.mooncore.listeners.JoinListener;
import me.taylan.mooncore.listeners.MobSpawnListener;
import me.taylan.mooncore.listeners.PlayerAttackListener;
import me.taylan.mooncore.listeners.PlayerDeathListener;
import me.taylan.mooncore.listeners.ProjectileHitListener;
import me.taylan.mooncore.listeners.QuitListener;
import me.taylan.mooncore.listeners.SkillListener;
import me.taylan.mooncore.listeners.entitydamage.AttackDamage;
import me.taylan.mooncore.listeners.entitydamage.AttackSpeed;
import me.taylan.mooncore.listeners.entitydamage.Dodge;
import me.taylan.mooncore.listeners.entitydamage.SpawnArmorStand;
import me.taylan.mooncore.utils.BukkitSerialization;
import me.taylan.mooncore.utils.GuiHandler;
import me.taylan.mooncore.utils.ItemHandler;
import me.taylan.mooncore.utils.StatsManager;
import net.md_5.bungee.api.ChatColor;

public class MoonCore extends JavaPlugin {

	private StatsManager statsManager;
	private Enchants enchants;
	private GuiHandler guiHandler;
	private SeviyeCommand seviyeCommand;
	private ItemHandler itemHandler;
	private EnchantListener enchantListener;
	private ExpList exp;
	private EnchantRunnable enchantRunnable;
	private Levels levels;
	private CookAnim cookAnim;
	private SmithAnim smithAnim;
	private PlayerDeathListener deathListener;

	private InventoryClickListener inventoryClickListener;
	private Map<Entity, Integer> indicators = new HashMap<>();

	public void onEnable() {
		exp = new ExpList(this);
		exp.expPut();
		statsManager = new StatsManager(this);
		seviyeCommand = new SeviyeCommand(this);
		levels = new Levels(this);
		cookAnim = new CookAnim(this);
		smithAnim = new SmithAnim(this);
		itemHandler = new ItemHandler(this);
	
	
		enchants = new Enchants(this);
		guiHandler = new GuiHandler(this);

		inventoryClickListener = new InventoryClickListener(this);
		enchantListener = new EnchantListener(this);
		deathListener = new PlayerDeathListener(this);
		enchantRunnable = new EnchantRunnable(this);
		File playerData = new File(this.getDataFolder(), "playerdata");
		if (!playerData.exists()) {
			playerData.mkdirs();
		}
		new SpawnArmorStand(this);
		new EntityHealthListener(this);
		new AccessoryListener(this);
		new BrewListener(this);
		new ItemPickupListener(this);
		new ChunkLoadListener(this);
		new AttackDamage(this);
		new AttackSpeed(this);
		new Dodge(this);

		new ItemDropListener(this);
		new JoinListener(this);
		new ProjectileHitListener(this);
		new QuitListener(this);
		new SkillListener(this);
		new BlockRegenListener(this);
		new PlayerAttackListener(this);
		new MobSpawnListener(this);
		new EntityPotionListener(this);

		new ClaimSetterCommand(this);
		new DiscordCommand(this);
		new KnowledgeCommand(this);
		new NitelikCommand(this);
		new ProfileCommand(this);
		new SkillCommand(this);
		new PlaytimeCommand(this);
		new BackCommand(this);
		new StatsCommand(this);

		new EnchantRunnable(this).runTaskTimer(this, 0, 2L);
		new BukkitRunnable() {

			@Override
			public void run() {

				for (Player player : Bukkit.getOnlinePlayers()) {
					String name = player.getUniqueId().toString();
					File f = new File("plugins/RemielCore/playerdata", name + ".yml");
					if (statsManager.getStatfile().containsKey(player.getUniqueId())) {
						if (f.exists()) {
							try {
								statsManager.getStatfile().get(player.getUniqueId()).save(f);
							} catch (IOException e) {
								e.printStackTrace();
							}

						}
					}
				}

			}
		}.runTaskTimerAsynchronously(this, 0, 40L);
		send("MoonCore Aktif");

	}

	public void onDisable() {
		Bukkit.getServer().getScheduler().cancelTasks(this);
		for (Player player : Bukkit.getOnlinePlayers()) {
			if (EnchantRunnable.getCreeper().get(player.getUniqueId()) != null) {
				EnchantRunnable.getCreeper().get(player.getUniqueId()).remove();
				EnchantRunnable.getCreeper().remove(player.getUniqueId());
			}
			String invToBase64 = BukkitSerialization
					.itemStackArrayToBase64(JoinListener.getMenu().get(player.getUniqueId()).getContents());
			String name = player.getUniqueId().toString();
			File f = new File("plugins/RemielCore/playerdata", name + ".yml");
			FileConfiguration fc = statsManager.getStatfile().get(player.getUniqueId());
			statsManager.setStorage(player.getUniqueId(), invToBase64);
			statsManager.setVayne(player.getUniqueId(), enchantListener.armorsave.get(player.getUniqueId()));
			try {
				fc.save(f);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		send("MoonCore Deaktif");
	}

	public void send(String s) {
		getServer().getConsoleSender().sendMessage("[MoonCore] " + ChatColor.translateAlternateColorCodes('&', s));
	}

	public StatsManager getStatsManager() {
		return statsManager;
	}

	public EnchantListener getEnchantListener() {
		return enchantListener;
	}

	public GuiHandler getGuiHandler() {
		return guiHandler;
	}

	public Map<Entity, Integer> getIndicators() {
		return indicators;
	}

	public ItemHandler getItemHandler() {
		return itemHandler;
	}

	public Levels getLevels() {
		return levels;
	}

	public SeviyeCommand getSeviyeCommand() {
		return seviyeCommand;
	}

	public CookAnim getCookAnim() {
		return cookAnim;
	}

	public Enchants getEnchants() {
		return enchants;
	}

	public InventoryClickListener getInventoryClickListener() {
		return inventoryClickListener;
	}

	public SmithAnim getSmithAnim() {
		return smithAnim;
	}

	public PlayerDeathListener getDeathListener() {
		return deathListener;
	}
}
