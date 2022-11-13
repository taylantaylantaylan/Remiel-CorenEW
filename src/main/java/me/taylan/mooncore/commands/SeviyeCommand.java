package me.taylan.mooncore.commands;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.listeners.entitydamage.SpawnArmorStand;
import me.taylan.mooncore.utils.Painter;
import me.taylan.mooncore.utils.StatsManager;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.title.Title;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class SeviyeCommand implements CommandExecutor {
    private MoonCore plugin;
    private StatsManager stats;
    private HashMap<ArmorStand, Integer> timer = new HashMap<ArmorStand, Integer>();

    public static double getRandomOffset() {
        double random = Math.random();
        if (Math.random() > 0.4)
            random *= -1;
        return random;
    }

    public static double getRandomOffset2() {
        double random = Math.random();
        if (Math.random() > 0.5)
            random *= -1;
        return random;
    }

    public SeviyeCommand(MoonCore plugin) {
        this.plugin = plugin;
        this.stats = plugin.getStatsManager();

        plugin.getCommand("seviye").setExecutor(this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            return true;
        }

        Player p = (Player) sender;

        if (p.hasPermission("mooncore.seviye")) {

            if (args.length <= 0) {
                p.sendMessage(Painter.paint("&cYanlış Kullanım!"));
            } else if (args.length > 0) {
                switch (args[0].toString()) {
                    case "ekle":
                        int seviye = Integer.valueOf(args[1]);
                        seviyeAtlat(p, seviye);

                        break;

                }

            }

        }

        return false;
    }

    public void seviyeAtlat(Player p, int seviye) {
        int offset2 = 2;
        int offset = 2;
        int xOff = ThreadLocalRandom.current().nextInt(-offset, offset);
        int zOff = ThreadLocalRandom.current().nextInt(-offset2, offset2);

        int seviye2 = stats.getLevel(p.getUniqueId()) - seviye + 1;
        int seviyestat = stats.getLevel(p.getUniqueId()) + 1;
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        Team isim = scoreboard.getTeam(p.getName());
        if (isim.hasEntry(p.getName())) {
            isim.setPrefix(Painter.paint("&7[&fSvy. " + stats.getLevel(p.getUniqueId()) + "&7] &f"));
            isim.setSuffix(Painter.paint(" &6[" + (int) p.getHealth() + "❤]"));
        } else {
            isim.addEntry(p.getName());
            isim.setPrefix(Painter.paint("&7[&fSvy. " + stats.getLevel(p.getUniqueId()) + "&7] &f"));
            isim.setSuffix(Painter.paint(" &6[" + (int) p.getHealth() + "❤]"));
        }
        Location loc = p.getLocation().clone().add(getRandomOffset(), 1.3, zOff);
        Location loc2 = p.getLocation().clone().add(xOff, 1.1, getRandomOffset2());
        Location loc3 = p.getLocation().clone().add(getRandomOffset2(), 1.2, zOff);
        Location loc4 = p.getLocation().clone().add(xOff, 1.0, getRandomOffset());

        p.playSound(p.getLocation(), Sound.ENTITY_ILLUSIONER_PREPARE_MIRROR, 100, 0.6f);

        p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100, 0.8f);
        p.showTitle(

                Title.title(MiniMessage.builder().build().deserialize("<green>-=[</green><aqua>Seviye Atladın!</aqua><green>]=-</green>"),
                        MiniMessage.builder().build().deserialize("<yellow>(</yellow><green>" + seviye2 + " <yellow>-></yellow> <green> "
                                + seviyestat + "<yellow>)")));
        p.spawnParticle(Particle.VILLAGER_HAPPY, p.getLocation().add(0, 1, 0), 40, 0.4, 0.3, 0.4, 0);
        p.spawnParticle(Particle.SPELL_INSTANT, p.getLocation(), 50, 0.4, 0.3, 0.4, 0);
        p.spawnParticle(Particle.ENCHANTMENT_TABLE, p.getLocation().add(0, 2, 0), 30, 1.2, 0.6, 1.2, 0);
        p.playSound(p.getLocation(), Sound.ENTITY_ILLUSIONER_PREPARE_MIRROR, 100, 0.2f);
        /*
        ArmorStand armorStand = SpawnArmorStand.spawnArmorStand(loc.add(1, 0, 0), "<white>⬆<gold>❤");
        plugin.getIndicators().put(armorStand, 50);
        ArmorStand armorStand2 = SpawnArmorStand.spawnArmorStand(loc2, "<green>⬆<gold>❤");
        plugin.getIndicators().put(armorStand2, 50);
        ArmorStand armorStand3 = SpawnArmorStand.spawnArmorStand(loc2.add(-1, 0, -1), "<yellow>⬆<red>⚔");
        plugin.getIndicators().put(armorStand3, 50);
        ArmorStand armorStand4 = SpawnArmorStand.spawnArmorStand(loc.add(0, 1, -1), "<white>⬆<white>🌊");
        plugin.getIndicators().put(armorStand4, 50);
        ArmorStand armorStand5 = SpawnArmorStand.spawnArmorStand(loc4, "<red>⬆<white>🌊");
        plugin.getIndicators().put(armorStand5, 50);
        ArmorStand armorStand6 = SpawnArmorStand.spawnArmorStand(loc3, "<white>⬆<red>⚔");
        plugin.getIndicators().put(armorStand6, 50);
        ArmorStand armorStand7 = SpawnArmorStand.spawnArmorStand(loc2, "<white>⬆<yellow>❂");
        plugin.getIndicators().put(armorStand7, 50);
        ArmorStand armorStand8 = SpawnArmorStand.spawnArmorStand(loc4.add(-2, 0, 1), "<blue>⬆<yellow>❂");
        plugin.getIndicators().put(armorStand8, 50);
        ArmorStand armorStand9 = SpawnArmorStand.spawnArmorStand(loc3, "<white>⬆<dark_aqua>※");
        plugin.getIndicators().put(armorStand9, 50);
        ArmorStand armorStand10 = SpawnArmorStand.spawnArmorStand(loc2, "<gray>⬆<dark_aqua>※");
        plugin.getIndicators().put(armorStand10, 50);
*/
        stats.setLevel(p.getUniqueId(), seviye);
        p.sendMessage(Painter.paint("&8-----------------------------------------------------"));
        p.sendMessage(Painter.paint(
                " &6+3" + " &cNitelik Puanı &7 kazandın! /nitelik yazarak bu nitelik puanlarını kullanabilirsin!"));
        p.sendMessage(Painter.paint("       &6Yeni Tarifler Açıldı!"));
        p.sendMessage(Painter.paint("&8-----------------------------------------------------"));
        stats.setNP(p.getUniqueId(), 3);
           if (seviye2 + 1 == 2) {
            p.discoverRecipe(NamespacedKey.minecraft("farmer_hoe"));
            p.discoverRecipe(NamespacedKey.minecraft("bone_helmet"));
            p.discoverRecipe(NamespacedKey.minecraft("wither_rose_talisman"));
        } else if (seviye2 + 1 == 3) {
            p.discoverRecipe(NamespacedKey.minecraft("brew_gaunlet"));
            p.discoverRecipe(NamespacedKey.minecraft("wolf_gaunlet"));
            p.discoverRecipe(NamespacedKey.minecraft("bone_sword"));
        } else if (seviye2 + 1 == 4) {
            p.discoverRecipe(NamespacedKey.minecraft("spider_bow"));
            p.discoverRecipe(NamespacedKey.minecraft("black_helmet"));
            p.discoverRecipe(NamespacedKey.minecraft("oksidat_pant"));
        }else if (seviye2 + 1 == 5) {
            p.discoverRecipe(NamespacedKey.minecraft("king_killer"));
            p.discoverRecipe(NamespacedKey.minecraft("experience_bottle_lapis"));
            p.discoverRecipe(NamespacedKey.minecraft("ancient_silver_spear"));
        } else if (seviye2 + 1 == 6) {
            p.discoverRecipe(NamespacedKey.minecraft("hellfire_dagger"));
            p.discoverRecipe(NamespacedKey.minecraft("mistik_bow"));
            p.discoverRecipe(NamespacedKey.minecraft("silver_block"));
        } else if (seviye2 + 1 == 7) {
            p.discoverRecipe(NamespacedKey.minecraft("magma_sword"));
            p.discoverRecipe(NamespacedKey.minecraft("golem_gaunlet"));
            p.discoverRecipe(NamespacedKey.minecraft("golem_chestplate"));
        }

    }

}
