package me.taylan.mooncore.commands;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.Painter;
import me.taylan.mooncore.utils.StatsManager;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class WarpCommand implements CommandExecutor {

    private final MoonCore plugin;
    private final StatsManager stats;

    public WarpCommand(MoonCore plugin) {
        this.plugin = plugin;
        this.stats = plugin.getStatsManager();
        Objects.requireNonNull(plugin.getCommand("warp")).setExecutor(this);
    }

    @SuppressWarnings("deprecation")
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("mooncore.warp")) {
                if (args.length == 0) {
                    p.sendMessage(Painter
                            .paint("&cYanlış Kullanım! Doğrusu /warp <Bölge İsmi>"));
                }
                if (args[0].equalsIgnoreCase("liman")) {
                        if (stats.getLevel(p.getUniqueId()) > 2) {
                            Location location = new Location(Bukkit.getWorld("world"),1520 ,71, 1939);
                            if (p.hasPermission("mooncore.goldwarp")) {

                                coneEffect2(p,location);
                            } else {
                                coneEffect(p,location);
                            }
                        }

                } else   if (args[0].equalsIgnoreCase("krallık")) {
                    if (stats.getLevel(p.getUniqueId()) > 5) {
                        Location location2 = new Location(Bukkit.getWorld("world"),1819 ,89, 1718);

                        if (p.hasPermission("mooncore.goldwarp")) {
                            coneEffect2(p,location2);
                        } else {
                            coneEffect(p,location2);
                        }
                    }

                }
            }
        }
        return false;
    }
    public void coneEffect2(final Player player,Location location) {
        new BukkitRunnable() {
            double phi = 0;
            final Particle.DustOptions dust = new Particle.DustOptions(Color.fromRGB((int) 239, (int) 239, (int) 13), 1);

            @Override
            public void run() {
                phi += Math.PI / 16;
                double x;
                double z;
                double y;
                Location loc = player.getLocation();
                for (double t = 0; t <= Math.PI * 2; t += Math.PI / 16) {
                    for (double i = 0; i <= 1; i += 1) {
                        x = 0.15 * (2 * Math.PI - t) * Math.cos(t + phi + i * Math.PI);
                        y = 0.5 * t;
                        z = 0.15 * (2 * Math.PI - t) * Math.sin(t + phi + i * Math.PI);
                        loc.add(x,y,z);

                        player.spawnParticle(Particle.REDSTONE, loc, 1, 0, 0, 0, 0, dust);
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
                                new TextComponent(Painter.paint("&aIşınlanıyorsun, hareket etme!")));
                        loc.subtract(x,y,z);

                    }
                }
                if(phi >10*Math.PI) {
                    this.cancel();

                    player.teleport(location);
                }
            }
        }.runTaskTimer(plugin,0,1);


    }
    public void coneEffect(final Player player,Location location) {
        new BukkitRunnable() {
            double phi = 0;

            @Override
            public void run() {
                phi += Math.PI / 16;
                double x;
                double z;
                double y;
                Location loc = player.getLocation();
                for (double t = 0; t <= Math.PI * 2; t += Math.PI / 16) {
                    for (double i = 0; i <= 1; i += 1) {
                        x = 0.15 * (2 * Math.PI - t) * Math.cos(t + phi + i * Math.PI);
                        y = 0.5 * t;
                        z = 0.15 * (2 * Math.PI - t) * Math.sin(t + phi + i * Math.PI);
                        loc.add(x,y,z);
                        player.getWorld().spawnParticle(Particle.CRIT_MAGIC,loc,1,0,0,0,0);
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
                                new TextComponent(Painter.paint("&aIşınlanıyorsun, hareket etme!")));
                        loc.subtract(x,y,z);

                    }
                }
                if(phi >10*Math.PI) {
                    this.cancel();
                    player.teleport(location);
                }
            }
        }.runTaskTimer(plugin,0,1);


    }
}
