package me.taylan.mooncore.eco;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.Painter;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.ServicePriority;

public class VaultHook {
    private MoonCore plugin;

    private Economy provider;

    public VaultHook(MoonCore plugin) {
        this.plugin = plugin;
    }

    public void hook() {
        provider = plugin.getEkonomi();
        Bukkit.getServicesManager().register(Economy.class,this.provider,this.plugin, ServicePriority.Normal);
        Bukkit.getConsoleSender().sendMessage(Painter.paint("&2VaultAPI Baglandi!"));
    }
    public void unhook() {
        provider = plugin.getEkonomi();
        Bukkit.getServicesManager().unregister(Economy.class,this.provider);
        Bukkit.getConsoleSender().sendMessage(Painter.paint("&2VaultAPI kapandi!"));
    }
}
