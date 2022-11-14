//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package me.taylan.mooncore;

import com.keenant.tabbed.Tabbed;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import me.casperge.realisticseasons.api.SeasonsAPI;
import me.taylan.mooncore.animations.CookAnim;
import me.taylan.mooncore.animations.FurnaceAnim;
import me.taylan.mooncore.animations.RealFurnaceAnim;
import me.taylan.mooncore.animations.SmithAnim;
import me.taylan.mooncore.animations.WorkAnim;
import me.taylan.mooncore.commands.BackCommand;
import me.taylan.mooncore.commands.BroadcastCommand;
import me.taylan.mooncore.commands.ClaimSetterCommand;
import me.taylan.mooncore.commands.DiscordCommand;
import me.taylan.mooncore.commands.DuraCommand;
import me.taylan.mooncore.commands.EconomyCommand;
import me.taylan.mooncore.commands.FurnaceResetCommand;
import me.taylan.mooncore.commands.ItemHandlerCommand;
import me.taylan.mooncore.commands.ItemInfoCommand;
import me.taylan.mooncore.commands.KnowledgeCommand;
import me.taylan.mooncore.commands.LootCrateCommand;
import me.taylan.mooncore.commands.LoreCommand;
import me.taylan.mooncore.commands.MapCommand;
import me.taylan.mooncore.commands.NitelikCommand;
import me.taylan.mooncore.commands.NpcCommand;
import me.taylan.mooncore.commands.PlaytimeCommand;
import me.taylan.mooncore.commands.ProfileCommand;
import me.taylan.mooncore.commands.QuestMapCommand;
import me.taylan.mooncore.commands.RenameCommand;
import me.taylan.mooncore.commands.SeviyeCommand;
import me.taylan.mooncore.commands.SkillCommand;
import me.taylan.mooncore.commands.SkillGetCommand;
import me.taylan.mooncore.commands.StatsCommand;
import me.taylan.mooncore.commands.WarpCommand;
import me.taylan.mooncore.commands.XpGiveCommand;
import me.taylan.mooncore.eco.Ekonomi;
import me.taylan.mooncore.eco.VaultHook;
import me.taylan.mooncore.enchanting.EnchantConstructor;
import me.taylan.mooncore.enchanting.EnchantRunnable;
import me.taylan.mooncore.enchanting.Enchants;
import me.taylan.mooncore.level.ExpList;
import me.taylan.mooncore.level.Levels;
import me.taylan.mooncore.listeners.AccessoryListener;
import me.taylan.mooncore.listeners.BlockRegenListener;
import me.taylan.mooncore.listeners.BrewListener;
import me.taylan.mooncore.listeners.ChunkListener;
import me.taylan.mooncore.listeners.EnchantListener;
import me.taylan.mooncore.listeners.EntityDeathListener;
import me.taylan.mooncore.listeners.EntityHealthListener;
import me.taylan.mooncore.listeners.EntityPotionListener;
import me.taylan.mooncore.listeners.InventoryClickListener;
import me.taylan.mooncore.listeners.ItemDamageListener;
import me.taylan.mooncore.listeners.ItemDropListener;
import me.taylan.mooncore.listeners.ItemPickupListener;
import me.taylan.mooncore.listeners.JoinListener;
import me.taylan.mooncore.listeners.LootListener;
import me.taylan.mooncore.listeners.MobSpawnListener;
import me.taylan.mooncore.listeners.PlayerAttackListener;
import me.taylan.mooncore.listeners.PlayerCraftListener;
import me.taylan.mooncore.listeners.PlayerDeathListener;
import me.taylan.mooncore.listeners.PlayerFishListener;
import me.taylan.mooncore.listeners.ProjectileHitListener;
import me.taylan.mooncore.listeners.QuitListener;
import me.taylan.mooncore.listeners.RequirementListener;
import me.taylan.mooncore.listeners.ScrollListener;
import me.taylan.mooncore.listeners.VehicleDamageListener;
import me.taylan.mooncore.listeners.entitydamage.AttackDamage;
import me.taylan.mooncore.listeners.entitydamage.AttackSpeed;
import me.taylan.mooncore.listeners.entitydamage.Dodge;
import me.taylan.mooncore.listeners.entitydamage.SpawnArmorStand;
import me.taylan.mooncore.seasons.CustomDateMethods;
import me.taylan.mooncore.utils.BukkitSerialization;
import me.taylan.mooncore.utils.GuiHandler;
import me.taylan.mooncore.utils.ItemDrop;
import me.taylan.mooncore.utils.ItemHandler;
import me.taylan.mooncore.utils.Loots;
import me.taylan.mooncore.utils.StatsManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class MoonCore extends JavaPlugin {
    private StatsManager statsManager;
    private Enchants enchants;
    private GuiHandler guiHandler;
    private Tabbed tabbed;
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
    private CustomDateMethods customDateMethods;
    private RealFurnaceAnim realFurnaceAnim;
    private JoinListener joinListener;
    private ItemDrop itemDrop;
    private Ekonomi ekonomi;
    private EnchantConstructor enchantConstructor;
    private Configuration configuration;
    private SeasonsAPI seasonsAPI;
    private final Map<Entity, Integer> indicators = new HashMap();
    private final Map<Entity, Integer> indicators2 = new HashMap();

    public MoonCore() {
    }

    public Tabbed getTabbed() {
        return this.tabbed;
    }

    public CustomDateMethods getCustomDateMethods() {
        return this.customDateMethods;
    }

    public RealFurnaceAnim getRealFurnaceAnim() {
        return this.realFurnaceAnim;
    }

    public JoinListener getJoinListener() {
        return this.joinListener;
    }
    public SeasonsAPI getSeasonsAPI() {
        return  this.seasonsAPI;
    }

    public ItemDrop getItemDrop() {
        return this.itemDrop;
    }

    public EnchantConstructor getEnchantConstructor() {

        return this.enchantConstructor;
    }

    public Ekonomi getEkonomi() {
        return this.ekonomi;

    }


    public Configuration getConfiguration() {
        return this.configuration;
    }


    public Map<Entity, Integer> getIndicators2() {
        return this.indicators2;
    }

    public void onEnable() {
        this.saveDefaultConfig();
        this.exp = new ExpList(this);
        this.exp.expPut();
        this.seasonsAPI = SeasonsAPI.getInstance();
        this.customDateMethods = new CustomDateMethods(this);
        this.statsManager = new StatsManager(this);
        this.ekonomi = new Ekonomi(this);
        this.vaultHook = new VaultHook(this);
        this.vaultHook.hook();
        new EconomyCommand(this);
        this.seviyeCommand = new SeviyeCommand(this);
        this.attackListener = new PlayerAttackListener(this);
        this.tabbed = new Tabbed(this);
        this.levels = new Levels(this);
        this.smithAnim = new SmithAnim(this);
        this.cookAnim = new CookAnim(this);
        this.workAnim = new WorkAnim(this);
        this.furnaceAnim = new FurnaceAnim(this);
        this.itemHandler = new ItemHandler(this);
        this.itemHandler.init();
        this.realFurnaceAnim = new RealFurnaceAnim(this);
        this.loots = new Loots(this);
        this.itemDrop = new ItemDrop(this);
        this.enchantConstructor = new EnchantConstructor(this);
        this.enchants = new Enchants(this);
        this.guiHandler = new GuiHandler(this);
        this.inventoryClickListener = new InventoryClickListener(this);
        this.enchantListener = new EnchantListener(this);
        this.deathListener = new PlayerDeathListener(this);
        this.enchantRunnable = new EnchantRunnable(this);
        this.playerFishListener = new PlayerFishListener(this);
        this.joinListener = new JoinListener(this);
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
        new DuraCommand(this);
        (new EnchantRunnable(this)).runTaskTimer(this, 0L, 2L);
        if (!this.statsManager.hasClaimFile()) {
            try {
                this.statsManager.createClaimFile();
            } catch (IOException var7) {
                throw new RuntimeException(var7);
            }
        }

        File f = new File("plugins/RemielCore", "claims.yml");
        FileConfiguration fc = YamlConfiguration.loadConfiguration(f);
        Iterator var4 = fc.getStringList("Claims").iterator();

        while (var4.hasNext()) {
            String rawData = (String) var4.next();
            if (f.exists()) {
                String[] raw = rawData.split(":");
                this.statsManager.getChunkmap().put(raw[1], UUID.fromString(raw[0]));
            }
        }

        (new BukkitRunnable() {
            public void run() {
                Iterator var1 = Bukkit.getOnlinePlayers().iterator();

                while (var1.hasNext()) {
                    Player player = (Player) var1.next();
                    UUID uuid = player.getUniqueId();
                    File f;
                    if (MoonCore.this.statsManager.getChunkmap().containsValue(uuid)) {
                        List<String> chunklist = new ArrayList();
                        Iterator var5 = MoonCore.this.statsManager.getChunkmap().keySet().iterator();

                        while (var5.hasNext()) {
                            String string = (String) var5.next();
                            UUID var10001 = MoonCore.this.statsManager.getOwner(string);
                            chunklist.add("" + var10001 + ":" + string);
                        }

                        f = new File("plugins/RemielCore", "claims.yml");
                        FileConfiguration fc = YamlConfiguration.loadConfiguration(f);
                        fc.set("Claims", chunklist);
                        if (f.exists()) {
                            try {
                                fc.save(f);
                            } catch (IOException var9) {
                                throw new RuntimeException(var9);
                            }
                        }
                    }

                    String name = player.getUniqueId().toString();
                    f = new File("plugins/RemielCore/playerdata", name + ".yml");
                    if (MoonCore.this.statsManager.getStatfile().containsKey(player.getUniqueId()) && f.exists()) {
                        try {
                            ((FileConfiguration) MoonCore.this.statsManager.getStatfile().get(player.getUniqueId())).save(f);
                        } catch (IOException var8) {
                            var8.printStackTrace();
                        }
                    }
                }

            }
        }).runTaskTimerAsynchronously(this, 0L, 100L);
        this.send("MoonCore Aktif");
    }

    public PlayerAttackListener getAttackListener() {
        return this.attackListener;
    }

    public void onDisable() {
        if (this.itemDrop.getDropmap() != null) {
            Iterator var1 = this.itemDrop.getDropmap().keySet().iterator();

            while (var1.hasNext()) {
                ArmorStand stand = (ArmorStand) var1.next();
                stand.remove();
            }
        }

        Set<Entity> stands = this.indicators2.keySet();
        List<Entity> removal = new ArrayList();
        Iterator var3 = stands.iterator();

        while (var3.hasNext()) {
            Entity stand = (Entity) var3.next();
            stand.remove();
            removal.add(stand);
        }

        removal.forEach(stands::remove);
        this.vaultHook.unhook();
        Bukkit.getServer().getScheduler().cancelTasks(this);
        var3 = Bukkit.getOnlinePlayers().iterator();

        while (var3.hasNext()) {
            Player player = (Player) var3.next();
            UUID uuid = player.getUniqueId();
            String invToBase64furnace;
            if (this.statsManager.getChunkmap().containsValue(uuid)) {
                List<String> chunklist = new ArrayList();
                Iterator var7 = this.statsManager.getChunkmap().keySet().iterator();

                while (var7.hasNext()) {
                    invToBase64furnace = (String) var7.next();
                    UUID var10001 = this.statsManager.getOwner(invToBase64furnace);
                    chunklist.add("" + var10001 + ":" + invToBase64furnace);
                }

                File f = new File("plugins/RemielCore", "claims.yml");
                FileConfiguration fc = YamlConfiguration.loadConfiguration(f);
                fc.set("Claims", chunklist);
                if (f.exists()) {
                    try {
                        fc.save(f);
                    } catch (IOException var16) {
                        throw new RuntimeException(var16);
                    }
                }
            }

            if (EnchantRunnable.getCreeper().get(player.getUniqueId()) != null) {
                ((Entity) EnchantRunnable.getCreeper().get(player.getUniqueId())).remove();
                EnchantRunnable.getCreeper().remove(player.getUniqueId());
            }

            String invToBase64 = BukkitSerialization.itemStackArrayToBase64(((Inventory) JoinListener.getMenu().get(player.getUniqueId())).getContents());
            String invToBase64RealFurnace = BukkitSerialization.itemStackArrayToBase64(((Inventory) JoinListener.getRealfurnacemenu().get(player.getUniqueId())).getContents());
            invToBase64furnace = BukkitSerialization.itemStackArrayToBase64(((Inventory) JoinListener.getFurnacemenu().get(player.getUniqueId())).getContents());
            String invToBase64smoker = BukkitSerialization.itemStackArrayToBase64(((Inventory) JoinListener.getOcakMenu().get(player.getUniqueId())).getContents());
            String invToBase64work = BukkitSerialization.itemStackArrayToBase64(((Inventory) JoinListener.getElsanatmenu().get(player.getUniqueId())).getContents());
            String name = player.getUniqueId().toString();
            File f = new File("plugins/RemielCore/playerdata", name + ".yml");
            FileConfiguration fc = (FileConfiguration) this.statsManager.getStatfile().get(player.getUniqueId());
            this.statsManager.setStorage(player.getUniqueId(), invToBase64);
            this.statsManager.setRealFurnaceStorage(player.getUniqueId(), invToBase64RealFurnace);
            this.statsManager.setFurnaceStorage(player.getUniqueId(), invToBase64furnace);
            this.statsManager.setCookStorage(player.getUniqueId(), invToBase64smoker);
            this.statsManager.setWorkStorage(player.getUniqueId(), invToBase64work);
            this.statsManager.setVayne(player.getUniqueId(), (List) this.enchantListener.armorsave.get(player.getUniqueId()));

            try {
                fc.save(f);
            } catch (IOException var15) {
                var15.printStackTrace();
            }
        }

        this.send("MoonCore Deaktif");
    }

    public void send(String s) {
        this.getServer().getConsoleSender().sendMessage("[MoonCore] " + ChatColor.translateAlternateColorCodes('&', s));
    }

    public StatsManager getStatsManager() {
        return this.statsManager;
    }

    public EnchantListener getEnchantListener() {
        return this.enchantListener;
    }

    public GuiHandler getGuiHandler() {
        return this.guiHandler;
    }

    public Map<Entity, Integer> getIndicators() {
        return this.indicators;
    }

    public ItemHandler getItemHandler() {
        return this.itemHandler;
    }

    public Levels getLevels() {
        return this.levels;
    }

    public SeviyeCommand getSeviyeCommand() {
        return this.seviyeCommand;
    }

    public WorkAnim getWorkAnim() {
        return this.workAnim;
    }


    public CookAnim getCookAnim() {
        return this.cookAnim;
    }

    public FurnaceAnim getFurnaceAnim() {


        return this.furnaceAnim;
    }

    public Enchants getEnchants() {
        return this.enchants;

    }

    public InventoryClickListener getInventoryClickListener() {
        return this.inventoryClickListener;
    }

    public SmithAnim getSmithAnim() {
        return this.smithAnim;
    }

    public PlayerDeathListener getDeathListener() {
        return this.deathListener;
    }

    public Loots getLoots() {
        return this.loots;
    }
}
