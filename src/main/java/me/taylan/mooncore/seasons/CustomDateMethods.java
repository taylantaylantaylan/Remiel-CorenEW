package me.taylan.mooncore.seasons;

import me.casperge.realisticseasons.api.SeasonsAPI;
import me.taylan.mooncore.MoonCore;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.title.Title;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class CustomDateMethods {

    private MoonCore plugin;
    private File f;
    private FileConfiguration fc;
    private SeasonsAPI seasonsAPI = SeasonsAPI.getInstance();

    public CustomDateMethods(MoonCore plugin) {
        this.plugin = plugin;
    }


    public void setTab(int time) {
        f = new File("plugins/RemielCore/config.yml");
        fc = YamlConfiguration.loadConfiguration(f);
        fc.set("tab", time);
        try {
            fc.save(f);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public int getTab() {
        f = new File("plugins/RemielCore/config.yml");
        fc = YamlConfiguration.loadConfiguration(f);
        return fc.getInt("tab");
    }


    public String getSeason() {
        String season = seasonsAPI.getSeason(Bukkit.getWorld("world")).toString().toLowerCase();
        return season;
    }

    public int getCustomDay() {
        int day = seasonsAPI.getDate(Bukkit.getWorld("world")).getDay();
        return day;
    }

    public int getCustomYear() {
        int year = seasonsAPI.getDate(Bukkit.getWorld("world")).getYear();
        return year;
    }

    public String getTimeLine() {
        f = new File("plugins/RemielCore/config.yml");
        fc = YamlConfiguration.loadConfiguration(f);
        if (getHours() < 17 && getHours() > 6) {
            return "☀";
        } else {
            return "☽";
        }
    }

    public int getHours() {
        int hour = seasonsAPI.getHours(plugin.getServer().getWorld("world"));
        return hour;


    }

    public String getCustomTime() {
        int hour = seasonsAPI.getHours(plugin.getServer().getWorld("world"));
        int minutes = seasonsAPI.getMinutes(plugin.getServer().getWorld("world"));
        return hour + ":" + minutes;


    }

    public void changeSeason() {
        String currentseason = getSeason();
        switch (currentseason) {
            case "spring":
                for (Player player : plugin.getServer().getOnlinePlayers()) {

                    player.showTitle(

                            Title.title(
                                    MiniMessage.miniMessage().deserialize("<red>Yaz 🔥"),
                                    MiniMessage.miniMessage().deserialize("<gray><i>Havalar Isınıyor..."), Title.Times.times(Duration.ofSeconds(1), Duration.ofSeconds(5), Duration.ofSeconds(1))));
                }
                break;
            case "summer":
                for (Player player : plugin.getServer().getOnlinePlayers()) {

                    player.showTitle(

                            Title.title(
                                    MiniMessage.miniMessage().deserialize("<gold>Sonbahar ☘"),
                                    MiniMessage.miniMessage().deserialize("<gray><i>Yapraklar Dökülüyor..."), Title.Times.times(Duration.ofSeconds(1), Duration.ofSeconds(5), Duration.ofSeconds(1))));
                }
                break;
            case "fall":
                for (Player player : plugin.getServer().getOnlinePlayers()) {

                    player.showTitle(

                            Title.title(
                                    MiniMessage.miniMessage().deserialize("<white>Kış ❆"),
                                    MiniMessage.miniMessage().deserialize("<gray><i>Havalar Soğuyor..."), Title.Times.times(Duration.ofSeconds(1), Duration.ofSeconds(5), Duration.ofSeconds(1))));
                }
                break;
            case "winter":
                for (Player player : plugin.getServer().getOnlinePlayers()) {

                    player.showTitle(

                            Title.title(
                                    MiniMessage.miniMessage().deserialize("<dark_green>İlkbahar ✿"),
                                    MiniMessage.miniMessage().deserialize("<gray><i>Arılar vızıldıyor..."), Title.Times.times(Duration.ofSeconds(1), Duration.ofSeconds(5), Duration.ofSeconds(1))));
                }
                break;


        }
        try {
            fc.save(f);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
