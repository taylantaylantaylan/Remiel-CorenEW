package me.taylan.mooncore.eco;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.StatsManager;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Ekonomi implements Economy {

private final MoonCore main;
    private final StatsManager statsManager;
    public Ekonomi(MoonCore main) {
        this.main = main;
        this.statsManager = main.getStatsManager();
    }
    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getName() {
        return "Remiel";
    }

    @Override
    public boolean hasBankSupport() {
        return false;
    }

    @Override
    public int fractionalDigits() {
        return 0;
    }

    @Override
    public String format(double v) {
        return null;
    }

    @Override
    public String currencyNamePlural() {
        return "Dinar";
    }

    @Override
    public String currencyNameSingular() {
        return "Dinar";
    }

    @Override
    public boolean hasAccount(String playerName) {
        return hasAccount(playerName, "");
    }

    @Override
    public boolean hasAccount(OfflinePlayer offlinePlayer) {
        return true;
    }

    @Override
    public boolean hasAccount(String playerName, String worldName) {
        return true;
    }

    @Override
    public boolean hasAccount(OfflinePlayer player, String worldName) {
        return hasAccount(player);
    }
    @Override
    public double getBalance(String s) {
        Player player = Bukkit.getPlayer(s);
        UUID uuid = Objects.requireNonNull(player).getUniqueId();
        return statsManager.getPara(uuid);
    }

    @Override
    public double getBalance(OfflinePlayer offlinePlayer) {
        UUID uuid = offlinePlayer.getUniqueId();
        return statsManager.getPara(uuid);
    }

    @Override
    public double getBalance(String s, String s1) {
        Player player = Bukkit.getPlayer(s);
        UUID uuid = Objects.requireNonNull(player).getUniqueId();
        return statsManager.getPara(uuid);
    }

    @Override
    public double getBalance(OfflinePlayer offlinePlayer, String s) {
        UUID uuid = offlinePlayer.getUniqueId();
        return statsManager.getPara(uuid);
    }

    @Override
    public boolean has(String s, double v) {
        return getBalance(Objects.requireNonNull(Bukkit.getPlayer(s))) >= v;
    }

    @Override
    public boolean has(OfflinePlayer offlinePlayer, double v) {
        return getBalance(offlinePlayer) >= v;
    }

    @Override
    public boolean has(String s, String s1, double v) {
        return getBalance(Objects.requireNonNull(Bukkit.getPlayer(s))) >= v;
    }

    @Override
    public boolean has(OfflinePlayer offlinePlayer, String s, double v) {
        return getBalance(offlinePlayer) >= v;
    }



    @Override
    public EconomyResponse withdrawPlayer(String playerName, String worldName, double v) {
        Player player = Bukkit.getPlayer(playerName);
        UUID uuid = Objects.requireNonNull(player).getUniqueId();
        statsManager.setPara(uuid,-v);
        return new EconomyResponse(-v,getBalance(playerName), EconomyResponse.ResponseType.SUCCESS,"Hatalı");

    }

    @Override
    public EconomyResponse withdrawPlayer(String playerName, double v) {
        Player player = Bukkit.getPlayer(playerName);
        UUID uuid = Objects.requireNonNull(player).getUniqueId();
        statsManager.setPara(uuid,-v);
        return new EconomyResponse(-v,getBalance(playerName), EconomyResponse.ResponseType.SUCCESS,"Hatalı");

    }

    @Override
    public EconomyResponse withdrawPlayer(OfflinePlayer offlinePlayer, double v) {
        UUID uuid = offlinePlayer.getUniqueId();
        statsManager.setPara(uuid,-v);
        return new EconomyResponse(-v,getBalance(offlinePlayer), EconomyResponse.ResponseType.SUCCESS,"Hatalı");
    }

    @Override
    public EconomyResponse withdrawPlayer(OfflinePlayer player, String worldName, double v) {
        UUID uuid = player.getUniqueId();
        statsManager.setPara(uuid,-v);
        return new EconomyResponse(-v,getBalance(player), EconomyResponse.ResponseType.SUCCESS,"Hatalı");
    }
    @Override
    public EconomyResponse depositPlayer(String s, double v) {
        Player player = Bukkit.getPlayer(s);
        UUID uuid = Objects.requireNonNull(player).getUniqueId();
        statsManager.setPara(uuid,v);
        return null;
    }

    @Override
    public EconomyResponse depositPlayer(OfflinePlayer offlinePlayer, double v) {
        UUID uuid = offlinePlayer.getUniqueId();
        statsManager.setPara(uuid,v);
        return null;
    }

    @Override
    public EconomyResponse depositPlayer(String s, String s1, double v) {
        Player player = Bukkit.getPlayer(s);
        UUID uuid = Objects.requireNonNull(player).getUniqueId();
        statsManager.setPara(uuid,v);
        return null;
    }

    @Override
    public EconomyResponse depositPlayer(OfflinePlayer offlinePlayer, String s, double v) {
        UUID uuid = offlinePlayer.getUniqueId();
        statsManager.setPara(uuid,v);
        return null;
    }

    @Override
    public EconomyResponse createBank(String name, String player) {
        return new EconomyResponse(0, 0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, null);
    }

    @Override
    public EconomyResponse createBank(String name, OfflinePlayer player) {
        return new EconomyResponse(0, 0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, null);
    }

    @Override
    public EconomyResponse deleteBank(String name) {
        return new EconomyResponse(0, 0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, null);
    }

    @Override
    public EconomyResponse bankBalance(String name) {
        return new EconomyResponse(0, 0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, null);
    }

    @Override
    public EconomyResponse bankHas(String name, double amount) {
        return new EconomyResponse(0, 0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, null);
    }

    @Override
    public EconomyResponse bankWithdraw(String name, double amount) {
        return new EconomyResponse(0, 0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, null);
    }

    @Override
    public EconomyResponse bankDeposit(String name, double amount) {
        return new EconomyResponse(0, 0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, null);
    }

    @Override
    public EconomyResponse isBankOwner(String name, String playerName) {
        return new EconomyResponse(0, 0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, null);
    }

    @Override
    public EconomyResponse isBankOwner(String name, OfflinePlayer player) {
        return new EconomyResponse(0, 0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, null);
    }

    @Override
    public EconomyResponse isBankMember(String name, String playerName) {
        return new EconomyResponse(0, 0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, null);
    }

    @Override
    public EconomyResponse isBankMember(String name, OfflinePlayer player) {
        return new EconomyResponse(0, 0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, null);
    }


    @Override
    public List<String> getBanks() {
        return Collections.emptyList();
    }

    @Override
    public boolean createPlayerAccount(String player) {
        return createPlayerAccount(Bukkit.getPlayer(player));
    }

    @Override
    public boolean createPlayerAccount(OfflinePlayer offlinePlayer) {
        return false;
    }

    @Override
    public boolean createPlayerAccount(String playerName, String worldName) {
        return createPlayerAccount(playerName);
    }

    @Override
    public boolean createPlayerAccount(OfflinePlayer player, String worldName) {
        return createPlayerAccount(player);
    }
}
