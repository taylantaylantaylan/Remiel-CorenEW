
package me.taylan.mooncore.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import me.taylan.mooncore.MoonCore;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class StatsManager {
    private FileConfiguration fc;
private final MoonCore plugin;
    private final HashMap<UUID, FileConfiguration> statfile = new HashMap<>();
    private final HashMap<String, UUID> chunkmap = new HashMap<>();

    public HashMap<String, UUID> getChunkmap() {
        return this.chunkmap;
    }

    public StatsManager(MoonCore plugin) {
        this.plugin = plugin;
    }

    public boolean hasPlayedBefore(UUID uuid) {
        File f = new File("plugins/RemielCore/playerdata", uuid.toString() + ".yml");
        return f.exists();
    }

    public boolean hasClaimFile() {
        File f = new File("plugins/RemielCore", "claims.yml");
        return f.exists();
    }

    public FileConfiguration getFile(UUID uuid) {
        File f = new File("plugins/RemielCore/playerdata", uuid.toString() + ".yml");
        return YamlConfiguration.loadConfiguration(f);
    }

 
    public FileConfiguration getClaimFile() {
        File f = new File("plugins/RemielCore", "claims.yml");
        return YamlConfiguration.loadConfiguration(f);
    }


    public void createClaimFile() throws IOException {
        File f = new File("plugins/RemielCore", "claims.yml");
        FileConfiguration fc = YamlConfiguration.loadConfiguration(f);
        fc.set("Claims", (Object)null);
        fc.save(f);
    }

    public void createFile(UUID uuid) throws IOException {
        File f = new File("plugins/RemielCore/playerdata", uuid.toString() + ".yml");
        FileConfiguration fc = YamlConfiguration.loadConfiguration(f);
        fc.set("Levels.Level", 1);
        fc.set("Levels.Exp", 0);
        fc.set("Levels.RequiredExp", 100);
        fc.set("Levels.OdunculukLevel", 1);
        fc.set("Levels.OdunculukExp", 0);
        fc.set("Levels.OdunculukRequiredExp", 20);
        fc.set("Levels.MiningLevel", 1);
        fc.set("Levels.MiningExp", 0);
        fc.set("Levels.MiningRequiredExp", 10);
        fc.set("Levels.FishingLevel", 1);
        fc.set("Levels.FishingExp", 0);
        fc.set("Levels.FishingRequiredExp", 10);
        fc.set("Levels.CombatLevel", 1);
        fc.set("Levels.CombatExp", 0);
        fc.set("Levels.CombatRequiredExp", 10);
        fc.set("Levels.CookLevel", 1);
        fc.set("Levels.CookExp", 0);
        fc.set("Levels.CookRequiredExp", 20);
        fc.set("Levels.AlchemyLevel", 1);
        fc.set("Levels.AlchemyExp", 0);
        fc.set("Levels.AlchemyRequiredExp", 20);
        fc.set("Levels.SmithLevel", 1);
        fc.set("Levels.SmithExp", 0);
        fc.set("Levels.SmithRequiredExp", 20);
        fc.set("Levels.EnchLevel", 1);
        fc.set("Levels.EnchExp", 0);
        fc.set("Levels.EnchRequiredExp", 20);
        fc.set("Levels.WorkLevel", 1);
        fc.set("Levels.WorkExp", 0);
        fc.set("Levels.WorkRequiredExp", 20);
        fc.set("Levels.FarmingLevel", 1);
        fc.set("Levels.FarmingExp", 0);
        fc.set("Levels.FarmingRequiredExp", 20);
        fc.set("Product.Production", 0);
        fc.set("Product.Production1", 0);
        fc.set("Product.FurnaceProduction", 0);
        fc.set("Product.FurnaceAmount", 0);
        fc.set("Product.CookProduction", 0);
        fc.set("Product.CookAmount", 0);
        fc.set("Product.JeweleryProduction", 0);
        fc.set("Product.JeweleryAmount", 0);
        fc.set("Product.RealFurnaceProduction", 0);
        fc.set("Product.RealFurnaceAmount", 0);
        fc.set("Product.WorkProduction", 0);
        fc.set("Product.CookBlock", (Object)null);
        fc.set("Product.FurnaceBlock", (Object)null);
        fc.set("Product.SmithBlock", (Object)null);
        fc.set("Product.WorkBlock", (Object)null);
        fc.set("Product.BlastFurnaceBlock", (Object)null);
        fc.set("Product.JeweleryBlock", (Object)null);
        fc.set("Product.Time", 0);
        fc.set("Stats.Guc", 5);
        fc.set("Stats.Can", 100);
        fc.set("Stats.Direnc", 2);
        fc.set("Stats.Hiz", 2);
        fc.set("Stats.Para", 50);
        fc.set("Stats.HiclikDirenci", 0);
        fc.set("Stats.SogukDirenci", 0);
        fc.set("Stats.SicakDirenci", 0);
        fc.set("Stats.SaldiriHizi", 0);
        fc.set("Stats.ZirhDelme", 0);
        fc.set("Stats.BuyuHasari", 0);
        fc.set("Stats.KritikHasari", 12);
        fc.set("Stats.KritikSansi", 0);
        fc.set("Stats.Doygunluk", 2);
        fc.set("Stats.CanYenileme", 5);
        fc.set("Stats.İlham", 100);
        fc.set("Stats.Şans", 100);
        fc.set("Stats.NP", 0);
        fc.set("Stats.AlinanBolge", 0);
        fc.set("Stats.harcananNP", 0);
        fc.set("Storage.Depo", "yok");
        fc.set("Storage.RealFurnaceDepo", "yok");
        fc.set("Storage.FurnaceDepo", "yok");
        fc.set("Storage.CookDepo", "yok");
        fc.set("Storage.WorkDepo", "yok");
        fc.set("Enchant.vayne", "yok");
        fc.set("Aksesuar.KolyeIsim", "<dark_gray>Yok..");
        fc.set("Aksesuar.YuzukIsim", "<dark_gray>Yok..");
        fc.set("Aksesuar.EldivenIsim", "<dark_gray>Yok..");
        fc.set("Aksesuar.TilsimIsim", "<dark_gray>Yok..");
        fc.set("Meslek.job", "Yok..");
        ArrayList<ItemStack> list = new ArrayList<>();
        list.add(new ItemStack(Material.AIR));
        list.add(new ItemStack(Material.AIR));
        list.add(new ItemStack(Material.AIR));
        list.add(new ItemStack(Material.AIR));
        fc.set("Aksesuar.Hepsi", list);
        fc.set("Ayarlar.KritikHasarAyar", true);
        fc.set("Ayarlar.SaldiriHiziAyar", true);
        fc.set("Ayarlar.YaprakAyar", true);
        fc.set("Ayarlar.TabloAyar", true);
        fc.save(f);
        this.statfile.put(uuid, fc);
    }

    public HashMap<UUID, FileConfiguration> getStatfile() {
        return this.statfile;
    }

    public void s(UUID uuid) {
        this.statfile.put(uuid, this.fc);
    }

    public void setHepsi(UUID uuid, List<ItemStack> list) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        this.fc.set("Aksesuar.Hepsi", list);
        this.s(uuid);
    }

    public List<ItemStack> getHepsi(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return (List<ItemStack>) this.fc.getList("Aksesuar.Hepsi");
    }

    public void setKolye(UUID uuid, String name) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        this.fc.set("Aksesuar.KolyeIsim", name);
        this.s(uuid);
    }

    public String getKolye(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getString("Aksesuar.KolyeIsim");
    }

    public void setMeslek(UUID uuid, String name) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        this.fc.set("Meslek.job", name);
        this.s(uuid);
    }

    public String getMeslek(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getString("Meslek.job");
    }

    public void setStorage(UUID uuid, String name) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        this.fc.set("Storage.Depo", name);
        this.s(uuid);
    }

    public String getStorage(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getString("Storage.Depo");
    }

    public void setRealFurnaceStorage(UUID uuid, String name) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        this.fc.set("Storage.RealFurnaceDepo", name);
        this.s(uuid);
    }

    public String getRealFurnaceStorage(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getString("Storage.RealFurnaceDepo");
    }

    public void setFurnaceStorage(UUID uuid, String name) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        this.fc.set("Storage.FurnaceDepo", name);
        this.s(uuid);
    }

    public String getFurnaceStorage(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getString("Storage.FurnaceDepo");
    }

    public void setCookStorage(UUID uuid, String name) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        this.fc.set("Storage.CookDepo", name);
        this.s(uuid);
    }

    public String getCookStorage(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getString("Storage.CookDepo");
    }

    public void setWorkStorage(UUID uuid, String name) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        this.fc.set("Storage.WorkDepo", name);
        this.s(uuid);
    }

    public String getWorkStorage(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getString("Storage.WorkDepo");
    }

    public void setVayne(UUID uuid, List<ItemStack> list) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        this.fc.set("Enchant.vayne", list);
        this.s(uuid);
    }

    public List<ItemStack> getVayne(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return (List<ItemStack>) this.fc.getList("Enchant.vayne");
    }

    public void setYuzuk(UUID uuid, String name) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        this.fc.set("Aksesuar.YuzukIsim", name);
        this.s(uuid);
    }

    public String getYuzuk(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getString("Aksesuar.YuzukIsim");
    }

    public String getEldiven(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getString("Aksesuar.EldivenIsim");
    }

    public void setEldiven(UUID uuid, String name) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        this.fc.set("Aksesuar.EldivenIsim", name);
        this.s(uuid);
    }

    public String getTilsim(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getString("Aksesuar.TilsimIsim");
    }

    public void setTilsim(UUID uuid, String name) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        this.fc.set("Aksesuar.TilsimIsim", name);
        this.s(uuid);
    }

    public void setLevel(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getLevel(uuid);
        int result = level + size;
        this.fc.set("Levels.Level", result);
        this.s(uuid);
    }

    public int getLevel(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Levels.Level");
    }

    public void setExp(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getExp(uuid);
        int result = level + size;
        this.fc.set("Levels.Exp", result);
        this.s(uuid);
    }

    public void setExp0(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        this.fc.set("Levels.Exp", size);
        this.s(uuid);
    }

    public int getExp(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Levels.Exp");
    }

    public void setRequiredExp(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getRequiredExp(uuid);
        int result = level + size;
        this.fc.set("Levels.RequiredExp", result);
        this.s(uuid);
    }

    public int getRequiredExp(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Levels.RequiredExp");
    }

    public void setOdunculukLevel(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getOdunculukLevel(uuid);
        int result = level + size;
        this.fc.set("Levels.OdunculukLevel", result);
        this.s(uuid);
    }

    public int getOdunculukLevel(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Levels.OdunculukLevel");
    }

    public void setOdunculukExp(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getOdunculukExp(uuid);
        int result = level + size;
        this.fc.set("Levels.OdunculukExp", result);
        this.s(uuid);
    }

    public int getOdunculukExp(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Levels.OdunculukExp");
    }

    public void setOdunculukRequiredExp(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getOdunculukRequiredExp(uuid);
        int result = level + size;
        this.fc.set("Levels.OdunculukRequiredExp", result);
        this.s(uuid);
    }

    public int getOdunculukRequiredExp(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Levels.OdunculukRequiredExp");
    }

    public void setWorkLevel(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getWorkLevel(uuid);
        int result = level + size;
        this.fc.set("Levels.WorkLevel", result);
        this.s(uuid);
    }

    public int getWorkLevel(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Levels.WorkLevel");
    }

    public void setWorkExp(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getWorkExp(uuid);
        int result = level + size;
        this.fc.set("Levels.WorkExp", result);
        this.s(uuid);
    }

    public int getWorkExp(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Levels.WorkExp");
    }

    public void setWorkRequiredExp(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getWorkRequiredExp(uuid);
        int result = level + size;
        this.fc.set("Levels.WorkRequiredExp", result);
        this.s(uuid);
    }

    public int getWorkRequiredExp(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Levels.WorkRequiredExp");
    }

    public void setMadencilikLevel(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getMadencilikLevel(uuid);
        int result = level + size;
        this.fc.set("Levels.MiningLevel", result);
        this.s(uuid);
    }

    public int getMadencilikLevel(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Levels.MiningLevel");
    }

    public void setMadencilikExp(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getMadencilikExp(uuid);
        int result = level + size;
        this.fc.set("Levels.MiningExp", result);
        this.s(uuid);
    }

    public int getMadencilikExp(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Levels.MiningExp");
    }

    public void setMadencilikRequiredExp(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getMadencilikRequiredExp(uuid);
        int result = level + size;
        this.fc.set("Levels.MiningRequiredExp", result);
        this.s(uuid);
    }

    public int getMadencilikRequiredExp(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Levels.MiningRequiredExp");
    }

    public void setFishingLevel(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getFishingLevel(uuid);
        int result = level + size;
        this.fc.set("Levels.FishingLevel", result);
        this.s(uuid);
    }

    public int getFishingLevel(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Levels.FishingLevel");
    }

    public void setFishingExp(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getFishingExp(uuid);
        int result = level + size;
        this.fc.set("Levels.FishingExp", result);
        this.s(uuid);
    }

    public int getFishingExp(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Levels.FishingExp");
    }

    public void setFishingRequiredExp(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getFishingRequiredExp(uuid);
        int result = level + size;
        this.fc.set("Levels.FishingRequiredExp", result);
        this.s(uuid);
    }

    public int getFishingRequiredExp(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Levels.FishingRequiredExp");
    }

    public void setCombatLevel(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getCombatLevel(uuid);
        int result = level + size;
        this.fc.set("Levels.CombatLevel", result);
        this.s(uuid);
    }

    public int getCombatLevel(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Levels.CombatLevel");
    }

    public void setCombatExp(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getCombatExp(uuid);
        int result = level + size;
        this.fc.set("Levels.CombatExp", result);
        this.s(uuid);
    }

    public int getCombatExp(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Levels.CombatExp");
    }

    public void setCombatRequiredExp(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getCombatRequiredExp(uuid);
        int result = level + size;
        this.fc.set("Levels.CombatRequiredExp", result);
        this.s(uuid);
    }

    public int getCombatRequiredExp(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Levels.CombatRequiredExp");
    }

    public void setPara(UUID uuid, double size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        double level = this.getPara(uuid);
        double result = level + size;
        this.fc.set("Stats.Para", result);
        this.s(uuid);
    }

    public double getPara(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getDouble("Stats.Para");
    }

    public void setCookLevel(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getCookLevel(uuid);
        int result = level + size;
        this.fc.set("Levels.CookLevel", result);
        this.s(uuid);
    }

    public int getCookLevel(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Levels.CookLevel");
    }

    public void setCookExp(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getCookExp(uuid);
        int result = level + size;
        this.fc.set("Levels.CookExp", result);
        this.s(uuid);
    }

    public int getCookExp(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Levels.CookExp");
    }

    public void setCookRequiredExp(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getCookRequiredExp(uuid);
        int result = level + size;
        this.fc.set("Levels.CookRequiredExp", result);
        this.s(uuid);
    }

    public int getCookRequiredExp(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Levels.CookRequiredExp");
    }

    public void setAlchemyLevel(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getAlchemyLevel(uuid);
        int result = level + size;
        this.fc.set("Levels.AlchemyLevel", result);
        this.s(uuid);
    }

    public int getAlchemyLevel(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Levels.AlchemyLevel");
    }

    public void setAlchemyExp(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getAlchemyExp(uuid);
        int result = level + size;
        this.fc.set("Levels.AlchemyExp", result);
        this.s(uuid);
    }

    public int getAlchemyExp(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Levels.AlchemyExp");
    }

    public void setAlchemyRequiredExp(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getAlchemyRequiredExp(uuid);
        int result = level + size;
        this.fc.set("Levels.AlchemyRequiredExp", result);
        this.s(uuid);
    }

    public int getAlchemyRequiredExp(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Levels.AlchemyRequiredExp");
    }

    public void setSmithLevel(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getSmithLevel(uuid);
        int result = level + size;
        this.fc.set("Levels.SmithLevel", result);
        this.s(uuid);
    }

    public int getSmithLevel(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Levels.SmithLevel");
    }

    public void setSmithExp(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getSmithExp(uuid);
        int result = level + size;
        this.fc.set("Levels.SmithExp", result);
        this.s(uuid);
    }

    public int getSmithExp(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Levels.SmithExp");
    }

    public void setSmithRequiredExp(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getSmithRequiredExp(uuid);
        int result = level + size;
        this.fc.set("Levels.SmithRequiredExp", result);
        this.s(uuid);
    }


  public int getSmithRequiredExp(UUID uuid) {
      this.fc = (FileConfiguration)this.statfile.get(uuid);
      return this.fc.getInt("Levels.SmithRequiredExp");
    }

  public void setEnchLevel(UUID uuid, int size) {
       this.fc = (FileConfiguration)this.statfile.get(uuid);

        int level = this.getEnchLevel(uuid);
        int result = level + size;
        this.fc.set("Levels.EnchLevel", result);
        this.s(uuid);
    }

    public int getEnchLevel(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Levels.EnchLevel");
    }

    public void setEnchExp(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
 
        int level = this.getEnchExp(uuid);
        int result = level + size;
        this.fc.set("Levels.EnchExp", result);
        this.s(uuid);
    }

    public int getEnchExp(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Levels.EnchExp");

    }

 
    public void setEnchRequiredExp(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getEnchRequiredExp(uuid);
        int result = level + size;
        this.fc.set("Levels.EnchRequiredExp", result);
        this.s(uuid);
    }


    public int getEnchRequiredExp(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Levels.EnchRequiredExp");
    }

    public void setFarmingLevel(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getFarmingLevel(uuid);
        int result = level + size;
        this.fc.set("Levels.FarmingLevel", result);
        this.s(uuid);
    }

    public int getFarmingLevel(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Levels.FarmingLevel");
    }

    public void setFarmingExp(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getFarmingExp(uuid);
        int result = level + size;
        this.fc.set("Levels.FarmingExp", result);
        this.s(uuid);
    }

    public int getFarmingExp(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Levels.FarmingExp");
    }

    public void setFarmingRequiredExp(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getFarmingRequiredExp(uuid);
        int result = level + size;
        this.fc.set("Levels.FarmingRequiredExp", result);
        this.s(uuid);
    }

    public int getFarmingRequiredExp(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Levels.FarmingRequiredExp");
    }

    public void setWorkProduction(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getWorkProduction(uuid);
        int result = level + size;
        this.fc.set("Product.WorkProduction", result);
        this.s(uuid);
    }

    public int getWorkProduction(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Product.WorkProduction");
    }

    public void setProduction(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getProduction(uuid);
        int result = level + size;
        this.fc.set("Product.Production", result);
        this.s(uuid);
    }

    public int getProduction(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Product.Production");
    }

    public void setProduction1(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getProduction1(uuid);
        int result = level + size;
        this.fc.set("Product.Production1", result);
        this.s(uuid);
    }

    public int getProduction1(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Product.Production1");
    }

    public void setCookProduction(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getCookProduction(uuid);
        int result = level + size;
        this.fc.set("Product.CookProduction", result);
        this.s(uuid);
    }

    public int getRealFurnaceAmount(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Product.RealFurnaceAmount");
    }

    public void setRealFurnaceAmount(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getRealFurnaceAmount(uuid);
        int result = level + size;
        this.fc.set("Product.RealFurnaceAmount", result);
        this.s(uuid);
    }

    public int getFurnaceAmount(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Product.FurnaceAmount");
    }

    public void setFurnaceAmount(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getFurnaceAmount(uuid);
        int result = level + size;
        this.fc.set("Product.FurnaceAmount", result);
        this.s(uuid);
    }

    public int getRealFurnaceProduction(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Product.RealFurnaceProduction");
    }

    public void setRealFurnaceProduction(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getRealFurnaceProduction(uuid);
        int result = level + size;
        this.fc.set("Product.RealFurnaceProduction", result);
        this.s(uuid);
    }

    public int getFurnaceProduction(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Product.FurnaceProduction");
    }

    public void setFurnaceProduction(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getFurnaceProduction(uuid);
        int result = level + size;
        this.fc.set("Product.FurnaceProduction", result);
        this.s(uuid);
    }

    public int getCookAmount(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Product.CookAmount");
    }

    public void setCookAmount(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getCookAmount(uuid);
        int result = level + size;
        this.fc.set("Product.CookAmount", result);
        this.s(uuid);
    }

    public int getCookProduction(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Product.CookProduction");
    }

    public void setGuc(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getGuc(uuid);
        int result = level + size;
        this.fc.set("Stats.Guc", result);
        this.s(uuid);
    }

    public int getGuc(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Stats.Guc");
    }

    public void setCan(Player p, UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getCan(uuid);
        int result = level + size;
        p.setMaxHealth((double)result);
        p.setHealthScale(20.0);
        this.fc.set("Stats.Can", result);
        this.s(uuid);
    }

    public int getCan(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Stats.Can");
    }

    public void setNP(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        double level = (double)this.getNP(uuid);
        double result = level + (double)size;
        this.fc.set("Stats.NP", result);
        this.s(uuid);
    }

    public int getNP(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Stats.NP");
    }

    public void setharcananNP(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        double level = (double)this.getharcananNP(uuid);
        double result = level + (double)size;
        this.fc.set("Stats.harcananNP", result);
 
        this.s(uuid);
    }

    public int getharcananNP(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Stats.harcananNP");
    }

    public void setBuyuHasari(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        double level = (double)this.getBuyuHasari(uuid);

        double result = level + (double)size;
        this.fc.set("Stats.BuyuHasari", result);
        this.s(uuid);
    }

    public int getBuyuHasari(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Stats.BuyuHasari");
    }

    public void setİlham(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
 
        double level = (double)this.getharcananNP(uuid);
 
        double result = level + (double)size;
        this.fc.set("Stats.İlham", result);
        this.s(uuid);
    }

    public int getİlham(UUID uuid) {

        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Stats.İlham");

    }

 
    public void setAlinanBolge(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getAlinanBolge(uuid);
        int result = level + size;
        this.fc.set("Stats.AlinanBolge", result);
        this.s(uuid);
    }


    public int getAlinanBolge(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Stats.AlinanBolge");
    }

    public void setCan1(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        this.fc.set("Stats.Can", 1);
        this.s(uuid);
    }

    public void setDirenc1(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        this.fc.set("Stats.Direnc", 1);
        this.s(uuid);
    }

    public void setDirenc(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getDirenc(uuid);
        int result = level + size;
        this.fc.set("Stats.Direnc", result);
        this.s(uuid);
    }

    public int getDirenc(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Stats.Direnc");
    }

    public void setHiz(Player p, UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getHiz(uuid);
        int result = level + size;
        this.fc.set("Stats.Hiz", result);
        this.s(uuid);
    }

    public int getHiz(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Stats.Hiz");
    }

    public void setHiclikDirenci(UUID uuid, int size) {
 
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getHiclikDirenci(uuid);
        int result = level + size;
        this.fc.set("Stats.HiclikDirenci", result);
        this.s(uuid);
    }

    public int getHiclikDirenci(UUID uuid) {

        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Stats.HiclikDirenci");
    }

    public void setSogukDirenci(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getSogukDirenci(uuid);
 
        int result = level + size;
        this.fc.set("Stats.SogukDirenci", result);
        this.s(uuid);
    }

    public int getSogukDirenci(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Stats.SogukDirenci");
    }

    public void setZirhDelme(UUID uuid, int size) {

        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getZirhDelme(uuid);
        int result = level + size;
        this.fc.set("Stats.ZirhDelme", result);
        this.s(uuid);
    }

    public int getZirhDelme(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Stats.ZirhDelme");
    }

    public void setSicakDirenci(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getSicakDirenci(uuid);
        int result = level + size;
        this.fc.set("Stats.SicakDirenci", result);
        this.s(uuid);
    }

    public int getSicakDirenci(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Stats.SicakDirenci");
    }

    public void setSaldiriHizi(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getSaldiriHizi(uuid);
        int result = level + size;
        this.fc.set("Stats.SaldiriHizi", result);
        this.s(uuid);
    }

    public void setSaldiriHiziCap(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        this.fc.set("Stats.SaldiriHizi", 100);
        this.s(uuid);
    }

    public int getSaldiriHizi(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Stats.SaldiriHizi");
    }

    public void setDoygunluk(Player p, UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getDoygunluk(uuid);
        int result = level + size;
        p.setSaturation(p.getSaturation() + (float)size);
        this.fc.set("Stats.Doygunluk", result);
        this.s(uuid);
    }

    public int getDoygunluk(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Stats.Doygunluk");
    }

    public void setCanYenileme(Player p, UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getCanYenileme(uuid);
        int result = level + size;
        p.setUnsaturatedRegenRate(p.getUnsaturatedRegenRate() + size / 10);
        this.fc.set("Stats.CanYenileme", result);
        this.s(uuid);
    }

    public int getCanYenileme(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Stats.CanYenileme");
    }

    public void setKritikHasari(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getKritikHasari(uuid);
        int result = level + size;
        this.fc.set("Stats.KritikHasari", result);
        this.s(uuid);
    }

    public boolean getKritikAyar(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getBoolean("Ayarlar.KritikHasarAyar");
    }

    public void setKritikAyar(UUID uuid, boolean s) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        this.fc.set("Ayarlar.KritikHasarAyar", s);
        this.s(uuid);
    }

    public boolean getSaldiriHiziAyar(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getBoolean("Ayarlar.SaldiriHiziAyar");
    }

    public void setSaldiriHiziAyar(UUID uuid, boolean s) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        this.fc.set("Ayarlar.SaldiriHiziAyar", s);
        this.s(uuid);
    }

    public boolean getYaprakAyar(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getBoolean("Ayarlar.YaprakAyar");
    }

    public void setYaprakAyar(UUID uuid, boolean s) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        this.fc.set("Ayarlar.YaprakAyar", s);
        this.s(uuid);
    }

    public boolean getSkorAyar(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getBoolean("Ayarlar.SkorAyar");
    }

    public void setSkorAyar(UUID uuid, boolean s) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        this.fc.set("Ayarlar.SkorAyar", s);
        this.s(uuid);
    }

    public int getKritikHasari(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Stats.KritikHasari");
    }

    public void setKritikSansi(UUID uuid, int size) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        int level = this.getKritikSansi(uuid);
        int result = level + size;
        this.fc.set("Stats.KritikSansi", result);
        this.s(uuid);
    }

    public void setKritikSansiCap(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        this.fc.set("Stats.KritikSansi", 100);
        this.s(uuid);
    }

    public void setSpeedCap(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        this.fc.set("Stats.Hiz", 100);
        this.s(uuid);
    }

    public int getKritikSansi(UUID uuid) {
        this.fc = (FileConfiguration)this.statfile.get(uuid);
        return this.fc.getInt("Stats.KritikSansi");
    }

    public void addChunk(String chunk, UUID owner) {
        this.chunkmap.put(chunk, owner);
    }

    public boolean isChunk(String chunk) {
        return this.chunkmap.containsKey(chunk);
    }

    public UUID getOwner(String chunk) {
        return (UUID)this.chunkmap.get(chunk);
    }
}
