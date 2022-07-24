package me.taylan.mooncore;

import me.taylan.mooncore.animations.*;
import me.taylan.mooncore.commands.*;
import me.taylan.mooncore.eco.Ekonomi;
import me.taylan.mooncore.eco.VaultHook;
import me.taylan.mooncore.enchanting.EnchantRunnable;
import me.taylan.mooncore.enchanting.Enchants;
import me.taylan.mooncore.level.ExpList;
import me.taylan.mooncore.level.Levels;
import me.taylan.mooncore.listeners.*;
import me.taylan.mooncore.listeners.entitydamage.AttackDamage;
import me.taylan.mooncore.listeners.entitydamage.AttackSpeed;
import me.taylan.mooncore.listeners.entitydamage.Dodge;
import me.taylan.mooncore.listeners.entitydamage.SpawnArmorStand;
import me.taylan.mooncore.utils.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.IOException;
import java.util.*;

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
    private WorkAnim workAnim;
    private FurnaceAnim furnaceAnim;
    private SmithAnim smithAnim;
    private Loots loots;
    private VaultHook vaultHook;
    private PlayerAttackListener attackListener;
    private PlayerDeathListener deathListener;
    private PlayerFishListener playerFishListener;
    private InventoryClickListener inventoryClickListener;

    public RealFurnaceAnim getRealFurnaceAnim() {
        return realFurnaceAnim;
    }

    private RealFurnaceAnim realFurnaceAnim;

    public JoinListener getJoinListener() {
        return joinListener;
    }

    private JoinListener joinListener;

    public ItemDrop getItemDrop() {
        return itemDrop;
    }

    private ItemDrop itemDrop;

    public Ekonomi getEkonomi() {
        return ekonomi;
    }

    private Ekonomi ekonomi;

    private Configuration configuration;

    public Configuration getConfiguration() {
        return configuration;
    }


    private Map<Entity, Integer> indicators = new HashMap<>();

    public Map<Entity, Integer> getIndicators2() {
        return indicators2;
    }

    private Map<Entity, Integer> indicators2 = new HashMap<>();

    public void onEnable() {
        saveDefaultConfig();
        exp = new ExpList(this);
        exp.expPut();
        statsManager = new StatsManager(this);
        ekonomi = new Ekonomi(this);
        vaultHook = new VaultHook(this);
        vaultHook.hook();
        new EconomyCommand(this);
        seviyeCommand = new SeviyeCommand(this);
        attackListener = new PlayerAttackListener(this);




        levels = new Levels(this);
        smithAnim = new SmithAnim(this);
        cookAnim = new CookAnim(this);
        workAnim = new WorkAnim(this);
        furnaceAnim = new FurnaceAnim(this);
        itemHandler = new ItemHandler(this);
        itemHandler.init();

        realFurnaceAnim = new RealFurnaceAnim(this);
        loots = new Loots(this);
        itemDrop = new ItemDrop(this);

        enchants = new Enchants(this);
        guiHandler = new GuiHandler(this);

        inventoryClickListener = new InventoryClickListener(this);
        enchantListener = new EnchantListener(this);
        deathListener = new PlayerDeathListener(this);
        enchantRunnable = new EnchantRunnable(this);
        playerFishListener = new PlayerFishListener(this);
        joinListener = new JoinListener(this);
        File playerData = new File(this.getDataFolder(), "playerdata");
        if (!playerData.exists()) {
            playerData.mkdirs();
        }
        new SpawnArmorStand(this);
        new EntityHealthListener(this);
        new BrewListener(this);
        new PlayerCraftListener(this);
        new VehicleDamageListener(this);
        new ItemPickupListener(this);
        new AttackDamage(this);
        new AttackSpeed(this);
        new Dodge(this);
        new LoreCommand(this);
        new ItemDropListener(this);
        new AccessoryListener(this);
        new ProjectileHitListener(this);
        new QuitListener(this);
        new SkillListener(this);
        new BlockRegenListener(this);
        new PlayerAttackListener(this);
        new MobSpawnListener(this);
        new EntityPotionListener(this);
        new LootListener(this);
        new EntityDeathListener(this);
        new ClaimSetterCommand(this);
        new DiscordCommand(this);
        new KnowledgeCommand(this);
        new NitelikCommand(this);
        new ProfileCommand(this);
        new SkillCommand(this);
        new PlaytimeCommand(this);
        new RequirementListener(this);
        new FurnaceResetCommand(this);
        new BackCommand(this);
        new StatsCommand(this);
        new NpcCommand(this);
        new RenameCommand(this);
        new LootCrateCommand(this);
        new ChunkListener(this);
        new WarpCommand(this);
        new ItemHandlerCommand(this);
        new ItemDamageListener(this);
        new ItemInfoCommand(this);
        new XpGiveCommand(this);
        new MapCommand(this);
        new SkillGetCommand(this);
        new ScrollListener(this);
        new BroadcastCommand(this);
        new QuestMapCommand(this);
        new EnchantRunnable(this).runTaskTimer(this, 0, 2L);
        if (!statsManager.hasClaimFile()) {
            try {
                statsManager.createClaimFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        File f = new File("plugins/RemielCore", "claims.yml");
        FileConfiguration fc = YamlConfiguration.loadConfiguration(f);
        for (String rawData : fc.getStringList("Claims")) {
            if (f.exists()) {
                String[] raw = rawData.split(":");
                statsManager.getChunkmap().put(raw[1], UUID.fromString(raw[0]));
            }
        }
        new BukkitRunnable() {

            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    UUID uuid = player.getUniqueId();
                    if (statsManager.getChunkmap().containsValue(uuid)) {
                        List<String> chunklist = new ArrayList<>();
                        for (String string : statsManager.getChunkmap().keySet()) {
                            chunklist.add(statsManager.getOwner(string) + ":" + string);
                        }
                        File f = new File("plugins/RemielCore", "claims.yml");
                        FileConfiguration fc = YamlConfiguration.loadConfiguration(f);
                        fc.set("Claims", chunklist);
                        if (f.exists()) {
                            try {
                                fc.save(f);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
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
        }.runTaskTimerAsynchronously(this, 0, 100L);

        send("MoonCore Aktif");
    }

    public PlayerAttackListener getAttackListener() {
        return attackListener;
    }

    public void onDisable() {
        for(ArmorStand stand:itemDrop.getDropmap().keySet()) {
            stand.remove();
        }
        Set<Entity> stands = indicators2.keySet();

        List<Entity> removal = new ArrayList<>();
        for (Entity stand : stands) {
            stand.remove();
            removal.add(stand);
            continue;
        }
        stands.removeAll(removal);
        vaultHook.unhook();
        Bukkit.getServer().getScheduler().cancelTasks(this);
        for (Player player : Bukkit.getOnlinePlayers()) {
            UUID uuid = player.getUniqueId();
            if (statsManager.getChunkmap().containsValue(uuid)) {
                List<String> chunklist = new ArrayList<>();
                for (String string : statsManager.getChunkmap().keySet()) {
                    chunklist.add(statsManager.getOwner(string) + ":" + string);
                }
                File f = new File("plugins/RemielCore", "claims.yml");
                FileConfiguration fc = YamlConfiguration.loadConfiguration(f);
                fc.set("Claims", chunklist);
                if (f.exists()) {
                    try {
                        fc.save(f);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            if (EnchantRunnable.getCreeper().get(player.getUniqueId()) != null) {
                EnchantRunnable.getCreeper().get(player.getUniqueId()).remove();
                EnchantRunnable.getCreeper().remove(player.getUniqueId());
            }
            String invToBase64 = BukkitSerialization
                    .itemStackArrayToBase64(JoinListener.getMenu().get(player.getUniqueId()).getContents());
            String invToBase64RealFurnace = BukkitSerialization
                    .itemStackArrayToBase64(JoinListener.getRealfurnacemenu().get(player.getUniqueId()).getContents());
            String invToBase64furnace = BukkitSerialization
                    .itemStackArrayToBase64(JoinListener.getFurnacemenu().get(player.getUniqueId()).getContents());
            String invToBase64smoker = BukkitSerialization
                    .itemStackArrayToBase64(JoinListener.getOcakMenu().get(player.getUniqueId()).getContents());
            String invToBase64work = BukkitSerialization
                    .itemStackArrayToBase64(JoinListener.getElsanatmenu().get(player.getUniqueId()).getContents());
            String name = player.getUniqueId().toString();
            File f = new File("plugins/RemielCore/playerdata", name + ".yml");
            FileConfiguration fc = statsManager.getStatfile().get(player.getUniqueId());
            statsManager.setStorage(player.getUniqueId(), invToBase64);
            statsManager.setRealFurnaceStorage(player.getUniqueId(),invToBase64RealFurnace);
            statsManager.setFurnaceStorage(player.getUniqueId(), invToBase64furnace);
            statsManager.setCookStorage(player.getUniqueId(), invToBase64smoker);
            statsManager.setWorkStorage(player.getUniqueId(), invToBase64work);

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

    public WorkAnim getWorkAnim() {
        return workAnim;
    }

    public CookAnim getCookAnim() {
        return cookAnim;
    }

    public FurnaceAnim getFurnaceAnim() {
        return furnaceAnim;
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

    public Loots getLoots() {
        return loots;
    }


}
