package me.taylan.mooncore.seasons;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import me.casperge.realisticseasons.api.SeasonsAPI;
import me.taylan.mooncore.MoonCore;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.title.Title;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class CustomDateMethods {
    private final MoonCore plugin;

    private File f;

    private FileConfiguration fc;

    private final SeasonsAPI seasonsAPI;

    public CustomDateMethods(MoonCore plugin) {
        this.plugin = plugin;
        this.seasonsAPI = plugin.getSeasonsAPI();
    }

    public void setTab(int time) {
        this.f = new File("plugins/RemielCore/config.yml");
        this.fc = (FileConfiguration) YamlConfiguration.loadConfiguration(this.f);
        this.fc.set("tab", Integer.valueOf(time));
        try {
            this.fc.save(this.f);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getTab() {
        this.f = new File("plugins/RemielCore/config.yml");
        this.fc = (FileConfiguration) YamlConfiguration.loadConfiguration(this.f);
        return this.fc.getInt("tab");
    }

    public String getSeason() {
        return this.seasonsAPI.getSeason(Bukkit.getWorld("world")).toString().toLowerCase();
    }

    public int getCustomDay() {
        return this.seasonsAPI.getDate(Bukkit.getWorld("world")).getDay();
    }

    public int getCustomYear() {
        return this.seasonsAPI.getDate(Bukkit.getWorld("world")).getYear();
    }

    public String getTimeLine() {
        this.f = new File("plugins/RemielCore/config.yml");
        this.fc = (FileConfiguration) YamlConfiguration.loadConfiguration(this.f);
        if (getHours() < 17 && getHours() > 6) {
            return "x";
        } else {
            return "a";
        }

    }

    public int getHours() {
        return this.seasonsAPI.getHours(this.plugin.getServer().getWorld("world"));
    }

    public String getCustomTime() {
        int hour = this.seasonsAPI.getHours(this.plugin.getServer().getWorld("world"));
        int minutes = this.seasonsAPI.getMinutes(this.plugin.getServer().getWorld("world"));
        return "" + hour + ":" + hour;
    }

    public void changeSeason() {
        String currentseason = getSeason();
        switch (currentseason) {
            case "spring":
                for (Player player : this.plugin.getServer().getOnlinePlayers())
                    player.showTitle(

                            Title.title(
                                    MiniMessage.miniMessage().deserialize("<red>Yaz"),
                                    MiniMessage.miniMessage().deserialize("<gray><i>Havalar Isınıyor..."), Title.Times.times(Duration.ofSeconds(1L), Duration.ofSeconds(5L), Duration.ofSeconds(1L))));
                break;
            case "summer":
                for (Player player : this.plugin.getServer().getOnlinePlayers())
                    player.showTitle(

                            Title.title(
                                    MiniMessage.miniMessage().deserialize("<gold>Sonbahar"),
                                    MiniMessage.miniMessage().deserialize("<gray><i>Yapraklar Dökülüyor..."), Title.Times.times(Duration.ofSeconds(1L), Duration.ofSeconds(5L), Duration.ofSeconds(1L))));
                break;
            case "fall":
                for (Player player : this.plugin.getServer().getOnlinePlayers())
                    player.showTitle(

                            Title.title(
                                    MiniMessage.miniMessage().deserialize("<white>Kış"),
                                    MiniMessage.miniMessage().deserialize("<gray><i>Havalar Soğuyor..."), Title.Times.times(Duration.ofSeconds(1L), Duration.ofSeconds(5L), Duration.ofSeconds(1L))));
                break;
            case "winter":
                for (Player player : this.plugin.getServer().getOnlinePlayers())
                    player.showTitle(

                            Title.title(
                                    MiniMessage.miniMessage().deserialize("<dark_green>İlkbahar"),
                                    MiniMessage.miniMessage().deserialize("<gray><i>Arılar Vızıldıyor..."), Title.Times.times(Duration.ofSeconds(1L), Duration.ofSeconds(5L), Duration.ofSeconds(1L))));
                break;
        }
        try {
            this.fc.save(this.f);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
