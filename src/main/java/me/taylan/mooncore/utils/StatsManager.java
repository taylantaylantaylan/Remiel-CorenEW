package me.taylan.mooncore.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.taylan.mooncore.MoonCore;

public class StatsManager {
	private FileConfiguration fc;
	private MoonCore plugin;

	private HashMap<UUID, FileConfiguration> statfile = new HashMap<UUID, FileConfiguration>();

	public StatsManager(MoonCore plugin) {
		this.plugin = plugin;

	}

	public boolean hasPlayedBefore(UUID uuid) {
		File f = new File("plugins/RemielCore/playerdata", uuid.toString() + ".yml");
		return f.exists();
	}

	public FileConfiguration getFile(UUID uuid) {
		File f = new File("plugins/RemielCore/playerdata", uuid.toString() + ".yml");
		return YamlConfiguration.loadConfiguration(f);
	}

	public void createFile(UUID uuid) throws IOException {
		File f = new File("plugins/RemielCore/playerdata", uuid.toString() + ".yml");
		FileConfiguration fc = YamlConfiguration.loadConfiguration(f);
		fc.set("Levels." + "Level", 1);
		fc.set("Levels." + "Exp", 0);
		fc.set("Levels." + "RequiredExp", 100);
		fc.set("Levels." + "OdunculukLevel", 0);
		fc.set("Levels." + "OdunculukExp", 0);
		fc.set("Levels." + "OdunculukRequiredExp", 20);
		fc.set("Levels." + "MiningLevel", 1);
		fc.set("Levels." + "MiningExp", 0);
		fc.set("Levels." + "MiningRequiredExp", 10);
		fc.set("Levels." + "FishingLevel", 1);
		fc.set("Levels." + "FishingExp", 0);
		fc.set("Levels." + "FishingRequiredExp", 10);
		fc.set("Levels." + "CombatLevel", 1);
		fc.set("Levels." + "CombatExp", 0);
		fc.set("Levels." + "CombatRequiredExp", 10);
		fc.set("Levels." + "CookLevel", 1);
		fc.set("Levels." + "CookExp", 0);
		fc.set("Levels." + "CookRequiredExp", 20);
		fc.set("Levels." + "AlchemyLevel", 1);
		fc.set("Levels." + "AlchemyExp", 0);
		fc.set("Levels." + "AlchemyRequiredExp", 20);
		fc.set("Levels." + "SmithLevel", 1);
		fc.set("Levels." + "SmithExp", 0);
		fc.set("Levels." + "SmithRequiredExp", 20);
		fc.set("Levels." + "EnchLevel", 1);
		fc.set("Levels." + "EnchExp", 0);
		fc.set("Levels." + "EnchRequiredExp", 20);
		fc.set("Levels." + "FarmingLevel", 1);
		fc.set("Levels." + "FarmingExp", 0);
		fc.set("Levels." + "FarmingRequiredExp", 20);
		fc.set("Product." + "Production", 0);
		fc.set("Product." + "Production1", 0);
		fc.set("Product." + "CookProduction", 0);
		fc.set("Stats." + "Guc", 5);
		fc.set("Stats." + "Can", (int) 20);
		fc.set("Stats." + "Zirh", 0);
		fc.set("Stats." + "Hiz", 2);
		fc.set("Stats." + "HiclikDirenci", 0);
		fc.set("Stats." + "SogukDirenci", 0);
		fc.set("Stats." + "SicakDirenci", 0);
		fc.set("Stats." + "SaldiriHizi", 0);
		fc.set("Stats." + "KritikHasari", 12);
		fc.set("Stats." + "KritikSansi", 0);
		fc.set("Stats." + "Doygunluk", 0);
		fc.set("Stats." + "CanYenileme", 5);
		fc.set("Stats." + "Kesif", 0);
		fc.set("Stats." + "Agirlik", 0);
		fc.set("Stats." + "maxAgirlik", 100);
		fc.set("Stats." + "NP", 0);
		fc.set("Stats." + "harcananNP", 0);
		fc.set("Storage." + "depo", "yok");
		fc.set("Enchant." + "vayne", "yok");
		fc.set("Aksesuar." + "KolyeIsim", "Yok..");
		fc.set("Aksesuar." + "YuzukIsim", "Yok..");
		fc.set("Aksesuar." + "EldivenIsim", "Yok..");
		fc.set("Aksesuar." + "TilsimIsim", "Yok..");
		fc.set("Claim." + "Bolge", "Yok..");
		fc.set("Meslek." + "job", "Yok..");
		ArrayList<ItemStack> list = new ArrayList<ItemStack>();
		list.add(new ItemStack(Material.AIR));
		list.add(new ItemStack(Material.AIR));
		list.add(new ItemStack(Material.AIR));
		list.add(new ItemStack(Material.AIR));
		fc.set("Aksesuar." + "Hepsi", list);
		fc.save(f);
		statfile.put(uuid, fc);
	}

	public HashMap<UUID, FileConfiguration> getStatfile() {
		return statfile;
	}

	public void s(UUID uuid) {
		statfile.put(uuid, fc);

	}

	public void setHepsi(UUID uuid, List<ItemStack> list) {
		fc = statfile.get(uuid);
		fc.set("Aksesuar." + "Hepsi", list);
		s(uuid);
	}

	@SuppressWarnings("unchecked")
	public List<ItemStack> getHepsi(UUID uuid) {
		fc = statfile.get(uuid);
		return (List<ItemStack>) fc.getList("Aksesuar." + "Hepsi");
	}

	public void setKolye(UUID uuid, String name) {
		fc = statfile.get(uuid);
		fc.set("Aksesuar." + "KolyeIsim", name);
		s(uuid);
	}

	public String getKolye(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getString("Aksesuar." + "KolyeIsim");
	}

	public void setMeslek(UUID uuid, String name) {
		fc = statfile.get(uuid);
		fc.set("Meslek." + "job", name);
		s(uuid);
	}

	public String getMeslek(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getString("Meslek." + "job");
	}

	public void setStorage(UUID uuid, String name) {
		fc = statfile.get(uuid);
		fc.set("Storage." + "depo", name);
		s(uuid);
	}

	public String getStorage(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getString("Storage." + "depo");
	}

	public void setVayne(UUID uuid, List<ItemStack> list) {
		fc = statfile.get(uuid);
		fc.set("Enchant." + "vayne", list);
		s(uuid);
	}

	public List<ItemStack> getVayne(UUID uuid) {
		fc = statfile.get(uuid);
		return (List<ItemStack>) fc.getList("Enchant." + "vayne");
	}

	public void setYuzuk(UUID uuid, String name) {
		fc = statfile.get(uuid);
		fc.set("Aksesuar." + "YuzukIsim", name);
		s(uuid);
	}

	public String getYuzuk(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getString("Aksesuar." + "YuzukIsim");
	}

	public String getEldiven(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getString("Aksesuar." + "EldivenIsim");
	}

	public void setEldiven(UUID uuid, String name) {
		fc = statfile.get(uuid);
		fc.set("Aksesuar." + "EldivenIsim", name);
		s(uuid);
	}

	public String getTilsim(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getString("Aksesuar." + "TilsimIsim");
	}

	public void setTilsim(UUID uuid, String name) {
		fc = statfile.get(uuid);
		fc.set("Aksesuar." + "TilsimIsim", name);
		s(uuid);
	}

	public void setLevel(UUID uuid, int size) {
		fc = statfile.get(uuid);
		int level = getLevel(uuid);
		int result = level + size;
		fc.set("Levels." + "Level", result);
		s(uuid);
	}

	public int getLevel(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getInt("Levels." + "Level");
	}

	public void setExp(UUID uuid, int size) {
		fc = statfile.get(uuid);
		int level = getExp(uuid);
		int result = level + size;
		fc.set("Levels." + "Exp", result);
		s(uuid);
	}

	public int getExp(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getInt("Levels." + "Exp");
	}

	public void setRequiredExp(UUID uuid, int size) {
		fc = statfile.get(uuid);
		int level = getRequiredExp(uuid);
		int result = level + size;
		fc.set("Levels." + "RequiredExp", result);
		s(uuid);
	}

	public int getRequiredExp(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getInt("Levels." + "RequiredExp");
	}

	public void setOdunculukLevel(UUID uuid, int size) {
		fc = statfile.get(uuid);
		int level = getOdunculukLevel(uuid);
		int result = level + size;
		fc.set("Levels." + "OdunculukLevel", result);
		s(uuid);
	}

	public int getOdunculukLevel(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getInt("Levels." + "OdunculukLevel");
	}

	public void setOdunculukExp(UUID uuid, int size) {
		fc = statfile.get(uuid);
		int level = getOdunculukExp(uuid);
		int result = level + size;
		fc.set("Levels." + "OdunculukExp", result);
		s(uuid);
	}

	public int getOdunculukExp(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getInt("Levels." + "OdunculukExp");
	}

	public void setOdunculukRequiredExp(UUID uuid, int size) {
		fc = statfile.get(uuid);
		int level = getOdunculukRequiredExp(uuid);
		int result = level + size;
		fc.set("Levels." + "OdunculukRequiredExp", result);
		s(uuid);
	}

	public int getOdunculukRequiredExp(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getInt("Levels." + "OdunculukRequiredExp");
	}

	public void setMadencilikLevel(UUID uuid, int size) {
		fc = statfile.get(uuid);
		int level = getMadencilikLevel(uuid);
		int result = level + size;
		fc.set("Levels." + "MiningLevel", result);
		s(uuid);
	}

	public int getMadencilikLevel(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getInt("Levels." + "MiningLevel");
	}

	public void setMadencilikExp(UUID uuid, int size) {
		fc = statfile.get(uuid);
		int level = getMadencilikExp(uuid);
		int result = level + size;
		fc.set("Levels." + "MiningExp", result);
		s(uuid);
	}

	public int getMadencilikExp(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getInt("Levels." + "MiningExp");
	}

	public void setMadencilikRequiredExp(UUID uuid, int size) {
		fc = statfile.get(uuid);
		int level = getMadencilikRequiredExp(uuid);
		int result = level + size;
		fc.set("Levels." + "MiningRequiredExp", result);
		s(uuid);
	}

	public int getMadencilikRequiredExp(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getInt("Levels." + "MiningRequiredExp");
	}

	public void setFishingLevel(UUID uuid, int size) {
		fc = statfile.get(uuid);
		int level = getFishingLevel(uuid);
		int result = level + size;
		fc.set("Levels." + "FishingLevel", result);
		s(uuid);
	}

	public int getFishingLevel(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getInt("Levels." + "FishingLevel");
	}

	public void setFishingExp(UUID uuid, int size) {
		fc = statfile.get(uuid);
		int level = getFishingExp(uuid);
		int result = level + size;
		fc.set("Levels." + "FishingExp", result);
		s(uuid);
	}

	public int getFishingExp(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getInt("Levels." + "FishingExp");
	}

	public void setFishingRequiredExp(UUID uuid, int size) {
		fc = statfile.get(uuid);
		int level = getFishingRequiredExp(uuid);
		int result = level + size;
		fc.set("Levels." + "FishingRequiredExp", result);
		s(uuid);
	}

	public int getFishingRequiredExp(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getInt("Levels." + "FishingRequiredExp");
	}

	public void setCombatLevel(UUID uuid, int size) {
		fc = statfile.get(uuid);
		int level = getCombatLevel(uuid);
		int result = level + size;
		fc.set("Levels." + "CombatLevel", result);
		s(uuid);
	}

	public int getCombatLevel(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getInt("Levels." + "CombatLevel");
	}

	public void setCombatExp(UUID uuid, int size) {
		fc = statfile.get(uuid);
		int level = getCombatExp(uuid);
		int result = level + size;
		fc.set("Levels." + "CombatExp", result);
		s(uuid);
	}

	public int getCombatExp(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getInt("Levels." + "CombatExp");
	}

	public void setCombatRequiredExp(UUID uuid, int size) {
		fc = statfile.get(uuid);
		int level = getCombatRequiredExp(uuid);
		int result = level + size;
		fc.set("Levels." + "CombatRequiredExp", result);
		s(uuid);
	}

	public int getCombatRequiredExp(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getInt("Levels." + "CombatRequiredExp");
	}

	public void setCookLevel(UUID uuid, int size) {
		fc = statfile.get(uuid);
		int level = getCookLevel(uuid);
		int result = level + size;
		fc.set("Levels." + "CookLevel", result);
		s(uuid);
	}

	public int getCookLevel(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getInt("Levels." + "CookLevel");
	}

	public void setCookExp(UUID uuid, int size) {
		fc = statfile.get(uuid);
		int level = getCookExp(uuid);
		int result = level + size;
		fc.set("Levels." + "CookExp", result);
		s(uuid);
	}

	public int getCookExp(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getInt("Levels." + "CookExp");
	}

	public void setCookRequiredExp(UUID uuid, int size) {
		fc = statfile.get(uuid);
		int level = getCookRequiredExp(uuid);
		int result = level + size;
		fc.set("Levels." + "CookRequiredExp", result);
		s(uuid);
	}

	public int getCookRequiredExp(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getInt("Levels." + "CookRequiredExp");
	}

	public void setAlchemyLevel(UUID uuid, int size) {
		fc = statfile.get(uuid);
		int level = getAlchemyLevel(uuid);
		int result = level + size;
		fc.set("Levels." + "AlchemyLevel", result);
		s(uuid);
	}

	public int getAlchemyLevel(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getInt("Levels." + "AlchemyLevel");
	}

	public void setAlchemyExp(UUID uuid, int size) {
		fc = statfile.get(uuid);
		int level = getAlchemyExp(uuid);
		int result = level + size;
		fc.set("Levels." + "AlchemyExp", result);
		s(uuid);
	}

	public int getAlchemyExp(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getInt("Levels." + "AlchemyExp");
	}

	public void setAlchemyRequiredExp(UUID uuid, int size) {
		fc = statfile.get(uuid);
		int level = getAlchemyRequiredExp(uuid);
		int result = level + size;
		fc.set("Levels." + "AlchemyRequiredExp", result);
		s(uuid);
	}

	public int getAlchemyRequiredExp(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getInt("Levels." + "AlchemyRequiredExp");
	}

	public void setSmithLevel(UUID uuid, int size) {
		fc = statfile.get(uuid);
		int level = getSmithLevel(uuid);
		int result = level + size;
		fc.set("Levels." + "SmithLevel", result);
		s(uuid);
	}

	public int getSmithLevel(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getInt("Levels." + "SmithLevel");
	}

	public void setSmithExp(UUID uuid, int size) {
		fc = statfile.get(uuid);
		int level = getSmithExp(uuid);
		int result = level + size;
		fc.set("Levels." + "SmithExp", result);
		s(uuid);
	}

	public int getSmithExp(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getInt("Levels." + "SmithExp");
	}

	public void setSmithRequiredExp(UUID uuid, int size) {
		fc = statfile.get(uuid);
		int level = getSmithRequiredExp(uuid);
		int result = level + size;
		fc.set("Levels." + "SmithRequiredExp", result);
		s(uuid);
	}

	public int getSmithRequiredExp(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getInt("Levels." + "SmithRequiredExp");
	}

	public void setEnchLevel(UUID uuid, int size) {
		fc = statfile.get(uuid);
		int level = getEnchLevel(uuid);
		int result = level + size;
		fc.set("Levels." + "EnchLevel", result);
		s(uuid);
	}

	public int getEnchLevel(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getInt("Levels." + "SmithLevel");
	}

	public void setEnchExp(UUID uuid, int size) {
		fc = statfile.get(uuid);
		int level = getEnchExp(uuid);
		int result = level + size;
		fc.set("Levels." + "EnchExp", result);
		s(uuid);
	}

	public int getEnchExp(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getInt("Levels." + "EnchExp");
	}

	public void setEnchRequiredExp(UUID uuid, int size) {
		fc = statfile.get(uuid);
		int level = getEnchRequiredExp(uuid);
		int result = level + size;
		fc.set("Levels." + "EnchRequiredExp", result);
		s(uuid);
	}

	public int getEnchRequiredExp(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getInt("Levels." + "EnchRequiredExp");
	}

	public void setFarmingLevel(UUID uuid, int size) {
		fc = statfile.get(uuid);
		int level = getFarmingLevel(uuid);
		int result = level + size;
		fc.set("Levels." + "FarmingLevel", result);
		s(uuid);
	}

	public int getFarmingLevel(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getInt("Levels." + "FarmingLevel");
	}

	public void setFarmingExp(UUID uuid, int size) {
		fc = statfile.get(uuid);
		int level = getFarmingExp(uuid);
		int result = level + size;
		fc.set("Levels." + "FarmingExp", result);
		s(uuid);
	}

	public int getFarmingExp(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getInt("Levels." + "FarmingExp");
	}

	public void setFarmingRequiredExp(UUID uuid, int size) {
		fc = statfile.get(uuid);
		int level = getFarmingRequiredExp(uuid);
		int result = level + size;
		fc.set("Levels." + "FarmingRequiredExp", result);
		s(uuid);
	}

	public int getFarmingRequiredExp(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getInt("Levels." + "FarmingRequiredExp");
	}

	public void setProduction(UUID uuid, int size) {
		fc = statfile.get(uuid);
		int level = getProduction(uuid);
		int result = level + size;
		fc.set("Product." + "Production", result);
		s(uuid);
	}

	public int getProduction(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getInt("Product." + "Production");
	}

	public void setProduction1(UUID uuid, int size) {
		fc = statfile.get(uuid);
		int level = getProduction1(uuid);
		int result = level + size;
		fc.set("Product." + "Production1", result);
		s(uuid);
	}

	public int getProduction1(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getInt("Product." + "Production1");
	}

	public void setCookProduction(UUID uuid, int size) {
		fc = statfile.get(uuid);
		int level = getCookProduction(uuid);
		int result = level + size;
		fc.set("Product." + "CookProduction", result);
		s(uuid);
	}

	public int getCookProduction(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getInt("Product." + "CookProduction");
	}

	public void setGuc(UUID uuid, int size) {
		fc = statfile.get(uuid);
		int level = getGuc(uuid);
		int result = level + size;
		fc.set("Stats." + "Guc", result);
		s(uuid);
	}

	public int getGuc(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getInt("Stats." + "Guc");
	}

	@SuppressWarnings("deprecation")
	public void setCan(Player p, UUID uuid, int size) {
		fc = statfile.get(uuid);
		int level = getCan(uuid);
		int result = level + size;
		p.setMaxHealth((double) result);
		p.setHealthScale(20);
		fc.set("Stats." + "Can", result);
		s(uuid);
	}

	public int getCan(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getInt("Stats." + "Can");
	}

	public void setNP(UUID uuid, int size) {
		fc = statfile.get(uuid);
		double level = getNP(uuid);
		double result = level + size;
		fc.set("Stats." + "NP", result);
		s(uuid);
	}

	public int getNP(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getInt("Stats." + "NP");
	}

	public void setharcananNP(UUID uuid, int size) {
		fc = statfile.get(uuid);
		double level = getharcananNP(uuid);
		double result = level + size;
		fc.set("Stats." + "harcananNP", result);
		s(uuid);
	}

	public int getharcananNP(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getInt("Stats." + "harcananNP");
	}

	public void setZirh(Player p, UUID uuid, int size) {
		fc = statfile.get(uuid);
		int level = getZirh(uuid);
		int result = level + size;
		p.getAttribute(Attribute.GENERIC_ARMOR)
				.setBaseValue(p.getAttribute(Attribute.GENERIC_ARMOR).getBaseValue() + size);
		fc.set("Stats." + "Zirh", result);
		s(uuid);
	}

	public int getZirh(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getInt("Stats." + "Zirh");
	}

	public void setAgirlik(UUID uuid, int size) {
		fc = statfile.get(uuid);
		int level = getAgirlik(uuid);
		int result = level + size;
		fc.set("Stats." + "Agirlik", result);
		s(uuid);
	}

	public int getAgirlik(UUID uuid) {
		fc = statfile.get(uuid);

		return fc.getInt("Stats." + "Agirlik");
	}

	public void setMaxAgirlik(UUID uuid, int size) {
		fc = statfile.get(uuid);
		int level = getMaxAgirlik(uuid);
		int result = level + size;
		fc.set("Stats." + "maxAgirlik", result);
		s(uuid);
	}

	public int getMaxAgirlik(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getInt("Stats." + "maxAgirlik");
	}

	public void setHiz(Player p, UUID uuid, int size) {
		fc = statfile.get(uuid);
		int level = getHiz(uuid);
		int result = level + size;
		p.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED)
				.setBaseValue(p.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getBaseValue() + size / 100);
		fc.set("Stats." + "Hiz", result);
		s(uuid);
	}

	public int getHiz(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getInt("Stats." + "Hiz");
	}

	public void setHiclikDirenci(UUID uuid, int size) {
		fc = statfile.get(uuid);
		int level = getHiclikDirenci(uuid);
		int result = level + size;
		fc.set("Stats." + "HiclikDirenci", result);
		s(uuid);
	}

	public int getHiclikDirenci(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getInt("Stats." + "HiclikDirenci");
	}

	public void setSogukDirenci(UUID uuid, int size) {
		fc = statfile.get(uuid);
		int level = getSogukDirenci(uuid);
		int result = level + size;
		fc.set("Stats." + "SogukDirenci", result);
		s(uuid);
	}

	public int getSogukDirenci(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getInt("Stats." + "SogukDirenci");
	}

	public void setSicakDirenci(UUID uuid, int size) {
		fc = statfile.get(uuid);
		int level = getSicakDirenci(uuid);
		int result = level + size;
		fc.set("Stats." + "SicakDirenci", result);
		s(uuid);
	}

	public int getSicakDirenci(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getInt("Stats." + "SicakDirenci");
	}

	public void setSaldiriHizi(UUID uuid, int size) {
		fc = statfile.get(uuid);
		int level = getSaldiriHizi(uuid);
		int result = level + size;
		fc.set("Stats." + "SaldiriHizi", result);
		s(uuid);
	}

	public int getSaldiriHizi(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getInt("Stats." + "SaldiriHizi");
	}

	public void setDoygunluk(Player p, UUID uuid, int size) {
		fc = statfile.get(uuid);
		int level = getDoygunluk(uuid);
		int result = level + size;
		p.setSaturation(p.getSaturation() + size);
		fc.set("Stats." + "Doygunluk", result);
		s(uuid);
	}

	public int getDoygunluk(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getInt("Stats." + "Doygunluk");
	}

	public void setCanYenileme(Player p, UUID uuid, int size) {
		fc = statfile.get(uuid);
		int level = getCanYenileme(uuid);
		int result = level + size;
		p.setUnsaturatedRegenRate(p.getUnsaturatedRegenRate() + size / 10);
		fc.set("Stats." + "CanYenileme", result);
		s(uuid);
	}

	public int getCanYenileme(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getInt("Stats." + "CanYenileme");
	}

	public void setKritikHasari(UUID uuid, int size) {
		fc = statfile.get(uuid);
		int level = getKritikHasari(uuid);
		int result = level + size;
		fc.set("Stats." + "KritikHasari", result);
		s(uuid);
	}

	public int getKritikHasari(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getInt("Stats." + "KritikHasari");
	}

	public void setKritikSansi(UUID uuid, int size) {
		fc = statfile.get(uuid);
		int level = getKritikSansi(uuid);
		int result = level + size;
		fc.set("Stats." + "KritikSansi", result);
		s(uuid);
	}

	public int getKritikSansi(UUID uuid) {
		fc = statfile.get(uuid);
		return fc.getInt("Stats." + "KritikSansi");
	}

}
