package me.taylan.mooncore.listeners;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.Painter;
import me.taylan.mooncore.utils.StatsManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.HashMap;
import java.util.UUID;

public class PlayerDeathListener implements Listener {

    private MoonCore plugin;
    private HashMap<UUID, Location> deathmap = new HashMap<UUID, Location>();
    private StatsManager stats;

    public PlayerDeathListener(MoonCore plugin) {
        this.plugin = plugin;
        this.stats = plugin.getStatsManager();
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void playerdeath(PlayerDeathEvent event) {
        Player player = event.getPlayer();
        Entity entity = player.getKiller();
        event.setDeathMessage(Painter.paint("&c☠ &7"+player.getName()+ " öldü."));
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        Team isim = scoreboard.getTeam(player.getName());
        if (isim.hasEntry(player.getName())) {
            isim.setPrefix(Painter.paint("&7[&fSvy. " + stats.getLevel(player.getUniqueId()) + "&7] &f"));
            isim.setSuffix(Painter.paint(" &6[" + (int) player.getHealth() + "❤]"));
        } else {
            isim.addEntry(player.getName());
            isim.setPrefix(Painter.paint("&7[&fSvy. " + stats.getLevel(player.getUniqueId()) + "&7] &f"));
            isim.setSuffix(Painter.paint(" &6[" + (int) player.getHealth() + "❤]"));
        }
        if (player.isOp()) {
            deathmap.put(player.getUniqueId(), player.getLocation());
        }

    }

    public HashMap<UUID, Location> getDeathmap() {
        return deathmap;
    }

}
