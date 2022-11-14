//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package me.taylan.mooncore.level;

import com.manya.pdc.DataTypes;
import eu.endercentral.crazy_advancements.advancement.ToastNotification;
import eu.endercentral.crazy_advancements.advancement.AdvancementDisplay.AdvancementFrame;
import fr.mrmicky.fastboard.FastBoard;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.UUID;
import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.commands.SeviyeCommand;
import me.taylan.mooncore.eco.Ekonomi;
import me.taylan.mooncore.seasons.CustomDateMethods;
import me.taylan.mooncore.utils.ItemHandler;
import me.taylan.mooncore.utils.StatsManager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;

public class Levels {
    private final MoonCore plugin;
private final SeviyeCommand seviyeCommand;
    private final CustomDateMethods customDateMethods;
    private final StatsManager stats;
    private final Ekonomi ekonomi;
private final ItemHandler itemHandler;
    private final PersistentDataType<?, HashMap<String, Integer>> Enchants;
    private final BukkitRunnable r;
    private final DecimalFormat df;

    public Levels(final MoonCore plugin) {
        this.Enchants = DataTypes.hashMap(PersistentDataType.STRING, PersistentDataType.INTEGER);
        this.df = new DecimalFormat("#,###.##");
        this.seviyeCommand = plugin.getSeviyeCommand();
        this.plugin = plugin;
        this.itemHandler = plugin.getItemHandler();
        this.stats = plugin.getStatsManager();
        this.ekonomi = plugin.getEkonomi();
        this.customDateMethods = plugin.getCustomDateMethods();
        this.r = new BukkitRunnable() {
            public void run() {
                Iterator var1 = plugin.getServer().getOnlinePlayers().iterator();

                while(var1.hasNext()) {
                    Player player = (Player)var1.next();
                    FastBoard board = new FastBoard(player);
                    double para = Levels.this.ekonomi.getBalance(player);
                    board.updateTitle(ChatColor.AQUA + "Moon Network");
                    String[] var10001 = new String[]{ChatColor.DARK_AQUA +""+ ChatColor.BOLD + "     Remiel", "    ", null, null, null, null, null};
                    ChatColor var10004 = ChatColor.GOLD;
                    var10001[2] = "" + var10004 + "Dinar ⛁" + ChatColor.WHITE + Levels.this.df.format(para);
                    var10001[3] = "";
                    var10004 = ChatColor.DARK_AQUA;
                    var10001[4] = "" + var10004 + Levels.this.customDateMethods.getCustomTime().replace('.', ':') + "0 " + ChatColor.YELLOW + Levels.this.customDateMethods.getTimeLine();
                    var10004 = ChatColor.GRAY;
                    var10001[5] = "" + var10004 + player.getName();
                    var10001[6] = ChatColor.AQUA + "mc.moonnw.xyz  ";
                    board.updateLines(var10001);
                }

            }
        };
        this.r.runTaskTimerAsynchronously(plugin, 0L, 100L);
    }

    public void giveWorkLevel(Player p, int exp2) {
        UUID uuid = p.getUniqueId();
        int smithLevel = this.stats.getWorkLevel(uuid);
        int smithExp = this.stats.getWorkExp(uuid);
        int smithRequiredExp = this.stats.getWorkRequiredExp(uuid);
        FastBoard board = new FastBoard(p);
        board.updateTitle(ChatColor.AQUA + "Moon Network");
        ToastNotification notification = new ToastNotification(Material.SMITHING_TABLE, ChatColor.YELLOW + "El Sanatlarında ustalığın yükseldi!", AdvancementFrame.CHALLENGE);
        this.stats.setWorkExp(uuid, exp2);
        this.stats.setExp(uuid, exp2 - 3);
        int prog = 100 * smithExp / smithRequiredExp;
        double para = this.ekonomi.getBalance(p);
        String[] var10001 = new String[]{ChatColor.DARK_AQUA +""+  ChatColor.BOLD + "        Remiel", " ", null, null, null, null, null, null, null, null};
        ChatColor var10004 = ChatColor.GOLD;
        var10001[2] = "" + var10004 + "Dinar ⛁" + ChatColor.WHITE + this.df.format(para);
        var10001[3] = "   ";
        var10001[4] = ChatColor.YELLOW + "El Sanatları " + ChatColor.WHITE + "Ustalık " + smithLevel;
        var10001[5] = ChatColor.GREEN + "EXP " + ChatColor.WHITE + smithExp + ChatColor.GRAY + "/" + ChatColor.WHITE + smithRequiredExp + ChatColor.GRAY + " (" + ChatColor.GREEN + "%" + prog + ChatColor.GRAY + ")";
        var10001[6] = "     ";
        var10004 = ChatColor.DARK_AQUA;
        var10001[7] = "" + var10004 + this.customDateMethods.getCustomTime().replace('.', ':') + "0 " + ChatColor.YELLOW + this.customDateMethods.getTimeLine();
        var10004 = ChatColor.GRAY;
        var10001[8] = "" + var10004 + p.getName();
        var10001[9] = ChatColor.AQUA + "mc.moonnw.xyz  ";
        board.updateLines(var10001);
        if (smithExp >= smithRequiredExp) {
            this.stats.getExp(uuid);
            this.stats.getRequiredExp(uuid);
            this.stats.getLevel(uuid);
            this.stats.setExp(uuid, smithLevel * 2);
            ++smithLevel;
            this.stats.setWorkLevel(uuid, 1);
            this.stats.setWorkRequiredExp(uuid, smithLevel * 55);
            this.stats.setWorkExp(uuid, -smithExp);
            notification.send(p);
        }

    }

    public void giveSmithLevel(Player p, int exp) {
        UUID uuid = p.getUniqueId();
        int smithLevel = this.stats.getSmithLevel(uuid);
        int smithExp = this.stats.getSmithExp(uuid);
        int smithRequiredExp = this.stats.getSmithRequiredExp(uuid);
        FastBoard board = new FastBoard(p);
        board.updateTitle(ChatColor.AQUA + "Moon Network");
        ToastNotification notification = new ToastNotification(Material.SMITHING_TABLE, ChatColor.YELLOW + "Demircilikte ustalığın yükseldi!", AdvancementFrame.CHALLENGE);
        int prog;
        if (((ItemStack)this.stats.getHepsi(p.getUniqueId()).get(1)).hasItemMeta() && ((ItemStack)this.stats.getHepsi(p.getUniqueId()).get(1)).getItemMeta().getDisplayName().contains("Demirci")) {
            prog = exp * 20 / 100;
            this.stats.setSmithExp(uuid, exp + prog);
        } else {
            this.stats.setSmithExp(uuid, exp);
        }

        this.stats.setExp(uuid, exp - 4);
        prog = 100 * smithExp / smithRequiredExp;
        double para = this.ekonomi.getBalance(p);
        String[] var10001 = new String[]{ChatColor.DARK_AQUA +""+  ChatColor.BOLD + "        Remiel", " ", null, null, null, null, null, null, null, null};
        ChatColor var10004 = ChatColor.GOLD;
        var10001[2] = "" + var10004 + "Dinar ⛁" + ChatColor.WHITE + this.df.format(para);
        var10001[3] = "   ";
        var10001[4] = ChatColor.YELLOW + "Demircilik " + ChatColor.WHITE + "Ustalık " + smithLevel;
        var10001[5] = ChatColor.GREEN + "EXP " + ChatColor.WHITE + smithExp + ChatColor.GRAY + "/" + ChatColor.WHITE + smithRequiredExp + ChatColor.GRAY + " (" + ChatColor.GREEN + "%" + prog + ChatColor.GRAY + ")";
        var10001[6] = "     ";
        var10004 = ChatColor.DARK_AQUA;
        var10001[7] = "" + var10004 + this.customDateMethods.getCustomTime().replace('.', ':') + "0 " + ChatColor.YELLOW + this.customDateMethods.getTimeLine();
        var10004 = ChatColor.GRAY;
        var10001[8] = "" + var10004 + p.getName();
        var10001[9] = ChatColor.AQUA + "mc.moonnw.xyz  ";
        board.updateLines(var10001);
        if (smithExp >= smithRequiredExp) {
            this.stats.getExp(uuid);
            this.stats.getRequiredExp(uuid);
            this.stats.getLevel(uuid);
            this.stats.setExp(uuid, smithLevel * 2);
            ++smithLevel;
            this.stats.setSmithLevel(uuid, 1);
            this.stats.setSmithRequiredExp(uuid, smithLevel * 55);
            this.stats.setSmithExp(uuid, -smithExp);
            notification.send(p);
        }

    }

    public void giveCookLevel(Player p, ItemStack item) {
        UUID uuid = p.getUniqueId();
        int cookLevel = this.stats.getCookLevel(uuid);
        int cookExp = this.stats.getCookExp(uuid);
        int cookRequiredExp = this.stats.getCookRequiredExp(uuid);
        FastBoard board = new FastBoard(p);
        board.updateTitle(ChatColor.AQUA + "Moon Network");
        ToastNotification notification = new ToastNotification(Material.BREAD, ChatColor.YELLOW + "Aşçılıkta ustalığın yükseldi!", AdvancementFrame.CHALLENGE);
        int prog;
        if (ExpList.getExpMap().containsKey(item.getType().toString())) {
            prog = (Integer)ExpList.getExpMap().get(item.getType().toString());
            this.stats.setCookExp(uuid, prog);
            this.stats.setExp(uuid, prog - 1);
        }

        prog = 100 * cookExp / cookRequiredExp;
        double para = this.ekonomi.getBalance(p);
        String[] var10001 = new String[]{ChatColor.DARK_AQUA + ""+ ChatColor.BOLD + "        Remiel", " ", null, null, null, null, null, null, null, null};
        ChatColor var10004 = ChatColor.GOLD;
        var10001[2] = "" + var10004 + "Dinar ⛁" + ChatColor.WHITE + this.df.format(para);
        var10001[3] = "   ";
        var10001[4] = ChatColor.YELLOW + "Aşçılık " + ChatColor.WHITE + "Ustalık " + cookLevel;
        var10001[5] = ChatColor.GREEN + "EXP " + ChatColor.WHITE + cookExp + ChatColor.GRAY + "/" + ChatColor.WHITE + cookRequiredExp + ChatColor.GRAY + " (" + ChatColor.GREEN + "%" + prog + ChatColor.GRAY + ")";
        var10001[6] = "     ";
        var10004 = ChatColor.DARK_AQUA;
        var10001[7] = "" + var10004 + this.customDateMethods.getCustomTime().replace('.', ':') + "0 " + ChatColor.YELLOW + this.customDateMethods.getTimeLine();
        var10004 = ChatColor.GRAY;
        var10001[8] = "" + var10004 + p.getName();
        var10001[9] = ChatColor.AQUA + "mc.moonnw.xyz  ";
        board.updateLines(var10001);
        if (cookExp >= cookRequiredExp) {
            this.stats.setCan(p, p.getUniqueId(), 1);
            this.stats.getExp(uuid);
            this.stats.getRequiredExp(uuid);
            this.stats.setExp(uuid, cookLevel * 2);
            ++cookLevel;
            this.stats.setCookLevel(uuid, 1);
            this.stats.setCookRequiredExp(uuid, cookLevel * 70);
            this.stats.setCookExp(uuid, -cookExp);
            notification.send(p);
        }

    }

// --Commented out by Inspection START (14.11.2022 02:08):
//    public void giveCombatEXP(Player player, int exp, LivingEntity Entity) {
//        ToastNotification notification = new ToastNotification(Material.IRON_SWORD, ChatColor.YELLOW + "Avcılıkta ustalığın yükseldi!", AdvancementFrame.CHALLENGE);
//        UUID uuid = player.getUniqueId();
//        int combatLevel = this.stats.getCombatLevel(uuid);
//        int combatExp = this.stats.getCombatExp(uuid);
//        int combatRequiredExp = this.stats.getCombatRequiredExp(uuid);
//        FastBoard board = new FastBoard(player);
//        board.updateTitle(ChatColor.AQUA + "Moon Network");
//        this.stats.setCombatExp(uuid, exp);
//        int prog;
//        if (ExpList.getExpMap().containsKey(Entity.getType().toString())) {
//            prog = (Integer)ExpList.getExpMap().get(Entity.getType().toString());
//            this.stats.setExp(uuid, prog);
//            if (player.getInventory().getItemInMainHand().getItemMeta() != null) {
//                ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
//                NamespacedKey key = new NamespacedKey(this.plugin, "Enchants");
//                if (meta.getPersistentDataContainer() != null) {
//                    PersistentDataContainer container = meta.getPersistentDataContainer();
//                    if (container.has(key, this.Enchants) && ((HashMap)container.get(key, this.Enchants)).containsKey("ustalık")) {
//                        int level = (Integer)((HashMap)container.get(key, this.Enchants)).get("ustalık");
//                        this.stats.setMadencilikExp(player.getUniqueId(), level);
//                    }
//                }
//            }
//        }
//
//        prog = 100 * combatExp / combatRequiredExp;
//        double para = this.ekonomi.getBalance(player);
//        String[] var10001 = new String[]{ChatColor.DARK_AQUA +""+  ChatColor.BOLD + "        Remiel", " ", null, null, null, null, null, null, null, null};
//        ChatColor var10004 = ChatColor.GOLD;
//        var10001[2] = "" + var10004 + "Dinar ⛁" + ChatColor.WHITE + this.df.format(para);
//        var10001[3] = "   ";
//        var10001[4] = ChatColor.YELLOW + "Avcılık " + ChatColor.WHITE + "Ustalık " + combatLevel;
//        var10001[5] = ChatColor.GREEN + "EXP " + ChatColor.WHITE + combatExp + ChatColor.GRAY + "/" + ChatColor.WHITE + combatRequiredExp + ChatColor.GRAY + " (" + ChatColor.GREEN + "%" + prog + ChatColor.GRAY + ")";
//        var10001[6] = "     ";
//        var10004 = ChatColor.DARK_AQUA;
//        var10001[7] = "" + var10004 + this.customDateMethods.getCustomTime().replace('.', ':') + "0 " + ChatColor.YELLOW + this.customDateMethods.getTimeLine();
//        var10004 = ChatColor.GRAY;
//        var10001[8] = "" + var10004 + player.getName();
//        var10001[9] = ChatColor.AQUA + "mc.moonnw.xyz  ";
//        board.updateLines(var10001);
//        if (combatExp >= combatRequiredExp) {
//            this.stats.setKritikHasari(player.getUniqueId(), 1);
//            this.stats.getExp(uuid);
//            this.stats.getRequiredExp(uuid);
//            this.stats.setExp(uuid, combatLevel * 2);
//            ++combatLevel;
//            this.stats.setCombatLevel(uuid, 1);
//            this.stats.setCombatRequiredExp(uuid, combatLevel * 60);
//            this.stats.setCombatExp(uuid, -combatExp);
//            notification.send(player);
//        }
//
//    }
// --Commented out by Inspection STOP (14.11.2022 02:08)

    public void giveOduncuExp(Player player, Block block) {
        ToastNotification notification = new ToastNotification(Material.IRON_AXE, ChatColor.YELLOW + "Odunculukta ustalığın yükseldi!", AdvancementFrame.CHALLENGE);
        UUID uuid = player.getUniqueId();
        int odunculukLevel = this.stats.getOdunculukLevel(uuid);
        int odunculukExp = this.stats.getOdunculukExp(uuid);
        int odunculukRequiredExp = this.stats.getOdunculukRequiredExp(uuid);
        FastBoard board = new FastBoard(player);
        board.updateTitle(ChatColor.AQUA + "Moon Network");
        int prog;
        if (ExpList.getExpMap().containsKey(block.getType().toString())) {
            prog = (Integer)ExpList.getExpMap().get(block.getType().toString());
            this.stats.setOdunculukExp(uuid, prog);
            this.stats.setExp(uuid, prog - 1);
            if (player.getInventory().getItemInMainHand().getItemMeta() != null) {
                ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
                NamespacedKey key = new NamespacedKey(this.plugin, "Enchants");
                if (meta.getPersistentDataContainer() != null) {
                    PersistentDataContainer container = meta.getPersistentDataContainer();
                    if (container.has(key, this.Enchants) && ((HashMap) Objects.requireNonNull(container.get(key, this.Enchants))).containsKey("ustalık")) {
                        int level = (Integer)((HashMap) Objects.requireNonNull(container.get(key, this.Enchants))).get("ustalık");
                        this.stats.setOdunculukExp(player.getUniqueId(), level);
                    }
                }
            }
        }

        prog = 100 * odunculukExp / odunculukRequiredExp;
        double para = this.ekonomi.getBalance(player);
        String[] var10001 = new String[]{ChatColor.DARK_AQUA +""+  ChatColor.BOLD + "         Remiel", " ", null, null, null, null, null, null, null, null};
        ChatColor var10004 = ChatColor.GOLD;
        var10001[2] = "" + var10004 + "Dinar ⛁" + ChatColor.WHITE + this.df.format(para);
        var10001[3] = "   ";
        var10001[4] = ChatColor.YELLOW + "Odunculuk " + ChatColor.WHITE + "Ustalık " + odunculukLevel;
        var10001[5] = ChatColor.GREEN + "EXP " + ChatColor.WHITE + odunculukExp + ChatColor.GRAY + "/" + ChatColor.WHITE + odunculukRequiredExp + ChatColor.GRAY + " (" + ChatColor.GREEN + "%" + prog + ChatColor.GRAY + ")";
        var10001[6] = "     ";
        var10004 = ChatColor.DARK_AQUA;
        var10001[7] = "" + var10004 + this.customDateMethods.getCustomTime().replace('.', ':') + "0 " + ChatColor.YELLOW + this.customDateMethods.getTimeLine();
        var10004 = ChatColor.GRAY;
        var10001[8] = "" + var10004 + player.getName();
        var10001[9] = ChatColor.AQUA + "mc.moonnw.xyz  ";
        board.updateLines(var10001);
        if (odunculukExp >= odunculukRequiredExp) {
            this.stats.setGuc(player.getUniqueId(), 1);
            this.stats.getExp(uuid);
            this.stats.getRequiredExp(uuid);
            this.stats.getLevel(uuid);
            this.stats.setExp(uuid, odunculukLevel * 2);
            ++odunculukLevel;
            this.stats.setOdunculukLevel(uuid, 1);
            this.stats.setOdunculukRequiredExp(uuid, odunculukLevel * 60);
            this.stats.setOdunculukExp(uuid, -odunculukExp);
            notification.send(player);
        }

    }

    public void giveFarmingExp(Player player, ItemStack item) {
        ToastNotification notification = new ToastNotification(Material.WHEAT, ChatColor.YELLOW + "Çiftçilikte ustalığın yükseldi!", AdvancementFrame.CHALLENGE);
        UUID uuid = player.getUniqueId();
        int farmingLevel = this.stats.getFarmingLevel(uuid);
        int farmingExp = this.stats.getFarmingExp(uuid);
        int farmingRequiredExp = this.stats.getFarmingRequiredExp(uuid);
        FastBoard board = new FastBoard(player);
        board.updateTitle(ChatColor.AQUA + "Moon Network");
        int prog;
        if (ExpList.getExpMap().containsKey(item.getType().toString())) {
            prog = (Integer)ExpList.getExpMap().get(item.getType().toString());
            this.stats.setFarmingExp(uuid, prog);
            this.stats.setExp(uuid, prog - 1);
            if (player.getInventory().getItemInMainHand().getItemMeta() != null) {
                ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
                NamespacedKey key = new NamespacedKey(this.plugin, "Enchants");
                if (meta.getPersistentDataContainer() != null) {
                    PersistentDataContainer container = meta.getPersistentDataContainer();
                    if (container.has(key, this.Enchants) && ((HashMap) Objects.requireNonNull(container.get(key, this.Enchants))).containsKey("ustalık")) {
                        int level = (Integer)((HashMap) Objects.requireNonNull(container.get(key, this.Enchants))).get("ustalık");
                        this.stats.setMadencilikExp(player.getUniqueId(), level);
                    }
                }
            }
        }

        prog = 100 * farmingExp / farmingRequiredExp;
        double para = this.ekonomi.getBalance(player);
        String[] var10001 = new String[]{ChatColor.DARK_AQUA +""+  ChatColor.BOLD + "         Remiel", " ", null, null, null, null, null, null, null, null};
        ChatColor var10004 = ChatColor.GOLD;
        var10001[2] = "" + var10004 + "Dinar ⛁" + ChatColor.WHITE + this.df.format(para);
        var10001[3] = "   ";
        var10001[4] = ChatColor.YELLOW + "Çiftçilik " + ChatColor.WHITE + "Ustalık " + farmingLevel;
        var10001[5] = ChatColor.GREEN + "EXP " + ChatColor.WHITE + farmingExp + ChatColor.GRAY + "/" + ChatColor.WHITE + farmingRequiredExp + ChatColor.GRAY + " (" + ChatColor.GREEN + "%" + prog + ChatColor.GRAY + ")";
        var10001[6] = "     ";
        var10004 = ChatColor.DARK_AQUA;
        var10001[7] = "" + var10004 + this.customDateMethods.getCustomTime().replace('.', ':') + "0 " + ChatColor.YELLOW + this.customDateMethods.getTimeLine();
        var10004 = ChatColor.GRAY;
        var10001[8] = "" + var10004 + player.getName();
        var10001[9] = ChatColor.AQUA + "mc.moonnw.xyz  ";
        board.updateLines(var10001);
        if (farmingExp >= farmingRequiredExp) {
            this.stats.setDoygunluk(player, player.getUniqueId(), 1);
            this.stats.getExp(uuid);
            this.stats.getRequiredExp(uuid);
            this.stats.getLevel(uuid);
            this.stats.setExp(uuid, farmingLevel * 2);
            ++farmingLevel;
// --Commented out by Inspection START (14.11.2022 02:08):
//            this.stats.setFarmingLevel(uuid, 1);
//            this.stats.setFarmingRequiredExp(uuid, farmingLevel * 60);
//            this.stats.setFarmingExp(uuid, -farmingExp);
//            notification.send(player);
//        }
//
//    }
//
//    public void giveFarmingExp(Player player, Block block) {
//        ToastNotification notification = new ToastNotification(Material.WHEAT, ChatColor.YELLOW + "Çiftçilikte ustalığın yükseldi!", AdvancementFrame.CHALLENGE);
//        UUID uuid = player.getUniqueId();
//        int farmingLevel = this.stats.getFarmingLevel(uuid);
//        int farmingExp = this.stats.getFarmingExp(uuid);
//        int farmingRequiredExp = this.stats.getFarmingRequiredExp(uuid);
//        FastBoard board = new FastBoard(player);
//        board.updateTitle(ChatColor.AQUA + "Moon Network");
//        int prog;
//        if (ExpList.getExpMap().containsKey(block.getType().toString())) {
//            prog = (Integer)ExpList.getExpMap().get(block.getType().toString());
//            this.stats.setFarmingExp(uuid, prog);
//            this.stats.setExp(uuid, prog - 1);
//        }
//
//        prog = 100 * farmingExp / farmingRequiredExp;
//        double para = this.ekonomi.getBalance(player);
//        String[] var10001 = new String[]{ChatColor.DARK_AQUA +""+  ChatColor.BOLD + "         Remiel", " ", null, null, null, null, null, null, null, null};
//        ChatColor var10004 = ChatColor.GOLD;
//        var10001[2] = "" + var10004 + "Dinar ⛁" + ChatColor.WHITE + this.df.format(para);
//        var10001[3] = "   ";
//        var10001[4] = ChatColor.YELLOW + "Çiftçilik " + ChatColor.WHITE + "Ustalık " + farmingLevel;
//        var10001[5] = ChatColor.GREEN + "EXP " + ChatColor.WHITE + farmingExp + ChatColor.GRAY + "/" + ChatColor.WHITE + farmingRequiredExp + ChatColor.GRAY + " (" + ChatColor.GREEN + "%" + prog + ChatColor.GRAY + ")";
//        var10001[6] = "     ";
//        var10004 = ChatColor.DARK_AQUA;
//        var10001[7] = "" + var10004 + this.customDateMethods.getCustomTime().replace('.', ':') + "0 " + ChatColor.YELLOW + this.customDateMethods.getTimeLine();
//        var10004 = ChatColor.GRAY;
//        var10001[8] = "" + var10004 + player.getName();
//        var10001[9] = ChatColor.AQUA + "mc.moonnw.xyz  ";
//        board.updateLines(var10001);
//        if (farmingExp >= farmingRequiredExp) {
//            this.stats.setDoygunluk(player, player.getUniqueId(), 1);
//            this.stats.getExp(uuid);
//            this.stats.getRequiredExp(uuid);
//            this.stats.getLevel(uuid);
//            this.stats.setExp(uuid, farmingLevel * 2);
//            ++farmingLevel;
//            this.stats.setFarmingLevel(uuid, 1);
// --Commented out by Inspection STOP (14.11.2022 02:08)
            this.stats.setFarmingRequiredExp(uuid, farmingLevel * 60);
            this.stats.setFarmingExp(uuid, -farmingExp);
            notification.send(player);
        }

    }

    public void giveEnchantExp(Player player, int aga) {
        ToastNotification notification = new ToastNotification(Material.ENCHANTING_TABLE, ChatColor.YELLOW + "Büyücülükte ustalığın yükseldi!", AdvancementFrame.CHALLENGE);
        UUID uuid = player.getUniqueId();
        int miningLevel = this.stats.getEnchLevel(uuid);
        int miningExp = this.stats.getEnchExp(uuid);
        int miningRequiredExp = this.stats.getEnchRequiredExp(uuid);
        FastBoard board = new FastBoard(player);
        board.updateTitle(ChatColor.AQUA + "Moon Network");
        this.stats.setEnchExp(uuid, aga * 10);
        this.stats.setExp(uuid, aga * 10 - 5 * aga);
        int prog = 100 * miningExp / miningRequiredExp;
        double para = this.ekonomi.getBalance(player);
        String[] var10001 = new String[]{ChatColor.DARK_AQUA +""+  ChatColor.BOLD + "        Remiel", " ", null, null, null, null, null, null, null, null};
        ChatColor var10004 = ChatColor.GOLD;
        var10001[2] = "" + var10004 + "Dinar ⛁" + ChatColor.WHITE + this.df.format(para);
        var10001[3] = "   ";
        var10001[4] = ChatColor.YELLOW + "Büyücülük " + ChatColor.WHITE + "Ustalık " + miningLevel;
        var10001[5] = ChatColor.GREEN + "EXP " + ChatColor.WHITE + miningExp + ChatColor.GRAY + "/" + ChatColor.WHITE + miningRequiredExp + ChatColor.GRAY + " (" + ChatColor.GREEN + "%" + prog + ChatColor.GRAY + ")";
        var10001[6] = "     ";
        var10004 = ChatColor.DARK_AQUA;
        var10001[7] = "" + var10004 + this.customDateMethods.getCustomTime().replace('.', ':') + "0 " + ChatColor.YELLOW + this.customDateMethods.getTimeLine();
        var10004 = ChatColor.GRAY;
        var10001[8] = "" + var10004 + player.getName();
        var10001[9] = ChatColor.AQUA + "mc.moonnw.xyz  ";
        board.updateLines(var10001);
        if (miningExp >= miningRequiredExp) {
            this.stats.setİlham(player.getUniqueId(), 1);
            this.stats.getExp(uuid);
            this.stats.getRequiredExp(uuid);
            this.stats.getLevel(uuid);
            this.stats.setExp(uuid, miningLevel * 2);
            ++miningLevel;
            this.stats.setMadencilikLevel(uuid, 1);
            this.stats.setMadencilikRequiredExp(uuid, miningLevel * 60);
            this.stats.setMadencilikExp(uuid, -miningExp);
            notification.send(player);
        }

    }

    public void giveMiningExp(Player player, Block block) {
        ToastNotification notification = new ToastNotification(Material.IRON_PICKAXE, ChatColor.YELLOW + "Madencilikte ustalığın yükseldi!", AdvancementFrame.CHALLENGE);
        UUID uuid = player.getUniqueId();
        int miningLevel = this.stats.getMadencilikLevel(uuid);
        int miningExp = this.stats.getMadencilikExp(uuid);
        int miningRequiredExp = this.stats.getMadencilikRequiredExp(uuid);
        FastBoard board = new FastBoard(player);
        board.updateTitle(ChatColor.AQUA + "Moon Network");
        int prog;
        if (ExpList.getExpMap().containsKey(block.getType().toString())) {
            prog = (Integer)ExpList.getExpMap().get(block.getType().toString());
            this.stats.setMadencilikExp(uuid, prog);
            this.stats.setExp(uuid, prog - 1);
            if (player.getInventory().getItemInMainHand().getItemMeta() != null) {
                ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
                NamespacedKey key = new NamespacedKey(this.plugin, "Enchants");
                if (meta.getPersistentDataContainer() != null) {
                    PersistentDataContainer container = meta.getPersistentDataContainer();
                    if (container.has(key, this.Enchants) && ((HashMap) Objects.requireNonNull(container.get(key, this.Enchants))).containsKey("ustalık")) {
                        int level = (Integer)((HashMap) Objects.requireNonNull(container.get(key, this.Enchants))).get("ustalık");
                        this.stats.setMadencilikExp(player.getUniqueId(), level);
                    }
                }
            }
        }

        prog = 100 * miningExp / miningRequiredExp;
        double para = this.ekonomi.getBalance(player);
        String[] var10001 = new String[]{ChatColor.DARK_AQUA +""+  ChatColor.BOLD + "        Remiel", " ", null, null, null, null, null, null, null, null};
        ChatColor var10004 = ChatColor.GOLD;
        var10001[2] = "" + var10004 + "Dinar ⛁" + ChatColor.WHITE + this.df.format(para);
        var10001[3] = "   ";
        var10001[4] = ChatColor.YELLOW + "Madencilik " + ChatColor.WHITE + "Ustalık " + miningLevel;
        var10001[5] = ChatColor.GREEN + "EXP " + ChatColor.WHITE + miningExp + ChatColor.GRAY + "/" + ChatColor.WHITE + miningRequiredExp + ChatColor.GRAY + " (" + ChatColor.GREEN + "%" + prog + ChatColor.GRAY + ")";
        var10001[6] = "     ";
        var10004 = ChatColor.DARK_AQUA;
        var10001[7] = "" + var10004 + this.customDateMethods.getCustomTime().replace('.', ':') + "0 " + ChatColor.YELLOW + this.customDateMethods.getTimeLine();
        var10004 = ChatColor.GRAY;
        var10001[8] = "" + var10004 + player.getName();
        var10001[9] = ChatColor.AQUA + "mc.moonnw.xyz  ";
        board.updateLines(var10001);
        if (miningExp >= miningRequiredExp) {
            this.stats.setDirenc(player.getUniqueId(), 1);
            this.stats.getExp(uuid);
            this.stats.getRequiredExp(uuid);
            this.stats.getLevel(uuid);
            this.stats.setExp(uuid, miningLevel * 2);
            ++miningLevel;
            this.stats.setMadencilikLevel(uuid, 1);
            this.stats.setMadencilikRequiredExp(uuid, miningLevel * 60);
            this.stats.setMadencilikExp(uuid, -miningExp);
            notification.send(player);
        }

    }

    public void giveBrewEXP(Player player, Material mat) {
        ToastNotification notification = new ToastNotification(Material.BREWING_STAND, ChatColor.YELLOW + "Simyacılıkta ustalığın yükseldi!", AdvancementFrame.CHALLENGE);
        UUID uuid = player.getUniqueId();
        int alchemyLevel = this.stats.getAlchemyLevel(uuid);
        int alchemyExp = this.stats.getAlchemyExp(uuid);
        int alchemyRequiredExp = this.stats.getAlchemyRequiredExp(uuid);
        FastBoard board = new FastBoard(player);
        board.updateTitle(ChatColor.AQUA + "Moon Network");
        int prog;
        if (ExpList.getExpMap().containsKey(mat.toString())) {
            prog = (Integer)ExpList.getExpMap().get(mat.toString());
            this.stats.setAlchemyExp(uuid, prog);
            this.stats.setExp(uuid, prog - 1);
        }

        prog = 100 * alchemyExp / alchemyRequiredExp;
        double para = this.ekonomi.getBalance(player);
        String[] var10001 = new String[]{ChatColor.DARK_AQUA +""+  ChatColor.BOLD + "        Remiel", " ", null, null, null, null, null, null, null, null};
        ChatColor var10004 = ChatColor.GOLD;
        var10001[2] = "" + var10004 + "Dinar ⛁" + ChatColor.WHITE + this.df.format(para);
        var10001[3] = "   ";
        var10001[4] = ChatColor.YELLOW + "Simyacılık " + ChatColor.WHITE + "Ustalık " + alchemyLevel;
        var10001[5] = ChatColor.GREEN + "EXP " + ChatColor.WHITE + alchemyExp + ChatColor.GRAY + "/" + ChatColor.WHITE + alchemyRequiredExp + ChatColor.GRAY + " (" + ChatColor.GREEN + "%" + prog + ChatColor.GRAY + ")";
        var10001[6] = "     ";
        var10004 = ChatColor.DARK_AQUA;
        var10001[7] = "" + var10004 + this.customDateMethods.getCustomTime().replace('.', ':') + "0 " + ChatColor.YELLOW + this.customDateMethods.getTimeLine();
        var10004 = ChatColor.GRAY;
        var10001[8] = "" + var10004 + player.getName();
        var10001[9] = ChatColor.AQUA + "mc.moonnw.xyz  ";
        board.updateLines(var10001);
        if (alchemyExp >= alchemyRequiredExp) {
            this.stats.getExp(uuid);
            this.stats.getRequiredExp(uuid);
            this.stats.getLevel(uuid);
            this.stats.setExp(uuid, alchemyLevel * 2);
            ++alchemyLevel;
            this.stats.setAlchemyLevel(uuid, 1);
            this.stats.setAlchemyRequiredExp(uuid, alchemyLevel * 60);
            this.stats.setAlchemyExp(uuid, -alchemyExp);
            notification.send(player);
        }

    }
}
