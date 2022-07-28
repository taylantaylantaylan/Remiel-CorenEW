package me.taylan.mooncore.enchanting;

import java.util.HashMap;
import java.util.List;

import me.taylan.mooncore.level.Levels;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import com.manya.pdc.DataTypes;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.Painter;

public class EnchantConstructor {
    private MoonCore plugin;
    private Levels levels;

    public EnchantConstructor(MoonCore plugin) {
        this.plugin = plugin;
        this.levels = plugin.getLevels();
    }

    private static PersistentDataType<?, HashMap<String, Integer>> Enchants = DataTypes
            .hashMap(PersistentDataType.STRING, PersistentDataType.INTEGER);

    public static PersistentDataType<?, HashMap<String, Integer>> getEnchants() {
        return Enchants;
    }

    public void createEnchant(ItemStack item, Player p, int chance2, String Enchant,
                              String EnchLore, String noEnch, String noEnch2, String noEnch3, ItemStack item1, ItemStack item2) {

        NamespacedKey key = new NamespacedKey(plugin, "Enchants");

        if (item.getItemMeta().getPersistentDataContainer().get(key, Enchants) != null) {
            if (item.getItemMeta().getPersistentDataContainer().get(key, Enchants).containsKey(Enchant) || (item
                    .getItemMeta().getPersistentDataContainer().get(key, Enchants).containsKey(noEnch)
                    || (item.getItemMeta().getPersistentDataContainer().get(key, Enchants).containsKey(noEnch2) || (item
                    .getItemMeta().getPersistentDataContainer().get(key, Enchants).containsKey(noEnch3))))) {
                p.sendMessage("olmadı");
                p.closeInventory();
            } else {
                int level = p.getLevel();
                int plevel = 10 + 10 * chance2;
                int amount = 15 * chance2;
                item1.setAmount(amount);
                item2.setAmount(amount);

                if (p.getInventory().containsAtLeast(item1, amount) && p.getInventory().containsAtLeast(item2, amount)
                        && level >= plevel) {
                    p.getInventory().removeItem(item1);
                    p.getInventory().removeItem(item2);
                    p.setLevel(level - plevel);
                    List<String> itemLore = item.getItemMeta().getLore();
                    ItemMeta item2meta = item.getItemMeta();
                    for (int i = 0; i < itemLore.size(); i++) {
                        String lValue = itemLore.get(i);
                        if (lValue.equals(Painter.paint("&8<Boş Büyü Bölmesi>"))) {
                            itemLore.set(i, Painter.paint(EnchLore + chance2));
                            break;
                        }
                    }
                    NamespacedKey string = new NamespacedKey(plugin, "string");
                    String enchname = Painter.paint(EnchLore);
                    item2meta.getPersistentDataContainer().set(string, PersistentDataType.STRING, enchname);
                    if (item2meta.getPersistentDataContainer().get(key, Enchants) == null) {
                        HashMap<String, Integer> enchs = new HashMap<String, Integer>();
                        enchs.put(Enchant, chance2);

                        item2meta.addEnchant(Enchantment.WATER_WORKER, 1, true);
                        item2meta.getPersistentDataContainer().set(key, Enchants, enchs);
                    } else {
                        HashMap<String, Integer> enchs = item2meta.getPersistentDataContainer().get(key, Enchants);
                        enchs.put(Enchant, chance2);

                        item2meta.addEnchant(Enchantment.WATER_WORKER, 1, true);
                        item2meta.getPersistentDataContainer().set(key, Enchants, enchs);
                    }
                    item2meta.setLore(itemLore);
                    item.setItemMeta(item2meta);
                    p.getInventory().addItem(item);
                    p.getOpenInventory().setItem(22, null);
                    p.playSound(p, Sound.ITEM_TRIDENT_THUNDER, 3, 1.7f);
                    levels.giveEnchantExp(p,chance2);
                    p.closeInventory();
                } else {
                    p.sendMessage(Painter.paint("&cMalzemelerin Eksik."));
                    p.closeInventory();
                }
            }
        } else {
            int level = p.getLevel();
            int plevel = 10 + 10 * chance2;
            int amount = 15 * chance2;
            item1.setAmount(amount);
            item2.setAmount(amount);

            if (p.getInventory().containsAtLeast(item1, amount) && p.getInventory().containsAtLeast(item2, amount)
                    && level >= plevel) {
                p.getInventory().removeItem(item1);
                p.getInventory().removeItem(item2);
                p.setLevel(level - plevel);
                List<String> itemLore = item.getItemMeta().getLore();
                ItemMeta item2meta = item.getItemMeta();
                for (int i = 0; i < itemLore.size(); i++) {
                    String lValue = itemLore.get(i);
                    if (lValue.equals(Painter.paint("&8<Boş Büyü Bölmesi>"))) {
                        itemLore.set(i, Painter.paint(EnchLore + chance2));
                        break;
                    }
                }
                NamespacedKey string = new NamespacedKey(plugin, "string");
                String enchname = Painter.paint(EnchLore);
                item2meta.getPersistentDataContainer().set(string, PersistentDataType.STRING, enchname);
                if (item2meta.getPersistentDataContainer().get(key, Enchants) == null) {
                    HashMap<String, Integer> enchs = new HashMap<String, Integer>();
                    enchs.put(Enchant, chance2);

                    item2meta.addEnchant(Enchantment.WATER_WORKER, 1, true);
                    item2meta.getPersistentDataContainer().set(key, Enchants, enchs);
                } else {
                    HashMap<String, Integer> enchs = item2meta.getPersistentDataContainer().get(key, Enchants);
                    enchs.put(Enchant, chance2);

                    item2meta.addEnchant(Enchantment.WATER_WORKER, 1, true);
                    item2meta.getPersistentDataContainer().set(key, Enchants, enchs);
                }
                item2meta.setLore(itemLore);
                item.setItemMeta(item2meta);
                p.getInventory().addItem(item);
                p.getOpenInventory().setItem(22, null);
                p.playSound(p, Sound.ITEM_TRIDENT_THUNDER, 3, 1.7f);
                levels.giveEnchantExp(p,chance2);
                p.closeInventory();
            } else {
                p.sendMessage(Painter.paint("&cMalzemelerin Eksik."));
                p.closeInventory();
            }
        }
    }


    public void createEnchant(ItemStack item, Player p, int chance2, String Enchant,
                              String EnchLore, String noEnch, String noEnch2, ItemStack item1, ItemStack item2) {

        NamespacedKey key = new NamespacedKey(plugin, "Enchants");
        if (item.getItemMeta().getPersistentDataContainer().get(key, Enchants) != null) {
            if (item.getItemMeta().getPersistentDataContainer().get(key, Enchants).containsKey(Enchant) || (item
                    .getItemMeta().getPersistentDataContainer().get(key, Enchants).containsKey(noEnch)
                    || (item.getItemMeta().getPersistentDataContainer().get(key, Enchants).containsKey(noEnch2)))) {
                p.sendMessage("olmadıkn");
                p.closeInventory();
            } else {
                int level = p.getLevel();
                int plevel = 10 + 10 * chance2;
                int amount = 15 * chance2;
                item1.setAmount(amount);
                item2.setAmount(amount);

                if (p.getInventory().containsAtLeast(item1, amount) && p.getInventory().containsAtLeast(item2, amount)
                        && level >= plevel) {
                    p.getInventory().removeItem(item1);
                    p.getInventory().removeItem(item2);
                    p.setLevel(level - plevel);
                    List<String> itemLore = item.getItemMeta().getLore();
                    ItemMeta item2meta = item.getItemMeta();
                    for (int i = 0; i < itemLore.size(); i++) {
                        String lValue = itemLore.get(i);
                        if (lValue.equals(Painter.paint("&8<Boş Büyü Bölmesi>"))) {
                            itemLore.set(i, Painter.paint(EnchLore + chance2));
                            break;
                        }
                    }
                    NamespacedKey string = new NamespacedKey(plugin, "string");
                    String enchname = Painter.paint(EnchLore);
                    item2meta.getPersistentDataContainer().set(string, PersistentDataType.STRING, enchname);
                    if (item2meta.getPersistentDataContainer().get(key, Enchants) == null) {
                        HashMap<String, Integer> enchs = new HashMap<String, Integer>();
                        enchs.put(Enchant, chance2);

                        item2meta.addEnchant(Enchantment.WATER_WORKER, 1, true);
                        item2meta.getPersistentDataContainer().set(key, Enchants, enchs);
                    } else {
                        HashMap<String, Integer> enchs = item2meta.getPersistentDataContainer().get(key, Enchants);
                        enchs.put(Enchant, chance2);

                        item2meta.addEnchant(Enchantment.WATER_WORKER, 1, true);
                        item2meta.getPersistentDataContainer().set(key, Enchants, enchs);
                    }
                    item2meta.setLore(itemLore);
                    item.setItemMeta(item2meta);
                    p.getInventory().addItem(item);
                    p.getOpenInventory().setItem(22, null);
                    p.playSound(p, Sound.ITEM_TRIDENT_THUNDER, 3, 1.7f);
                    levels.giveEnchantExp(p,chance2);
                    p.closeInventory();
                } else {
                    p.sendMessage(Painter.paint("&cMalzemelerin Eksik."));
                    p.closeInventory();
                }
            }
        } else {
            int level = p.getLevel();
            int plevel = 10 + 10 * chance2;
            int amount = 15 * chance2;
            item1.setAmount(amount);
            item2.setAmount(amount);

            if (p.getInventory().containsAtLeast(item1, amount) && p.getInventory().containsAtLeast(item2, amount)
                    && level >= plevel) {
                p.getInventory().removeItem(item1);
                p.getInventory().removeItem(item2);
                p.setLevel(level - plevel);
                List<String> itemLore = item.getItemMeta().getLore();
                ItemMeta item2meta = item.getItemMeta();
                for (int i = 0; i < itemLore.size(); i++) {
                    String lValue = itemLore.get(i);
                    if (lValue.equals(Painter.paint("&8<Boş Büyü Bölmesi>"))) {
                        itemLore.set(i, Painter.paint(EnchLore + chance2));
                        break;
                    }
                }
                NamespacedKey string = new NamespacedKey(plugin, "string");
                String enchname = Painter.paint(EnchLore);
                item2meta.getPersistentDataContainer().set(string, PersistentDataType.STRING, enchname);
                if (item2meta.getPersistentDataContainer().get(key, Enchants) == null) {
                    HashMap<String, Integer> enchs = new HashMap<String, Integer>();
                    enchs.put(Enchant, chance2);

                    item2meta.addEnchant(Enchantment.WATER_WORKER, 1, true);
                    item2meta.getPersistentDataContainer().set(key, Enchants, enchs);
                } else {
                    HashMap<String, Integer> enchs = item2meta.getPersistentDataContainer().get(key, Enchants);
                    enchs.put(Enchant, chance2);

                    item2meta.addEnchant(Enchantment.WATER_WORKER, 1, true);
                    item2meta.getPersistentDataContainer().set(key, Enchants, enchs);
                }
                item2meta.setLore(itemLore);
                item.setItemMeta(item2meta);
                p.getInventory().addItem(item);
                p.getOpenInventory().setItem(22, null);
                p.playSound(p, Sound.ITEM_TRIDENT_THUNDER, 3, 1.7f);
                levels.giveEnchantExp(p,chance2);
                p.closeInventory();
            } else {
                p.sendMessage(Painter.paint("&cMalzemelerin Eksik."));
                p.closeInventory();
            }
        }
    }

    public void createEnchant(ItemStack item, Player p, int chance2, String Enchant,
                              String EnchLore, String noEnch, ItemStack item1, ItemStack item2) {

        NamespacedKey key = new NamespacedKey(plugin, "Enchants");
        if (item.getItemMeta().getPersistentDataContainer().get(key, Enchants) != null) {
            if (item.getItemMeta().getPersistentDataContainer().get(key, Enchants).containsKey(Enchant)
                    || (item.getItemMeta().getPersistentDataContainer().get(key, Enchants).containsKey(noEnch))) {
                p.sendMessage("aga");
                p.closeInventory();
            } else {
                int level = p.getLevel();
                int plevel = 10 + 10 * chance2;
                int amount = 15 * chance2;
                item1.setAmount(amount);
                item2.setAmount(amount);

                if (p.getInventory().containsAtLeast(item1, amount) && p.getInventory().containsAtLeast(item2, amount)
                        && level >= plevel) {
                    p.getInventory().removeItem(item1);
                    p.getInventory().removeItem(item2);
                    p.setLevel(level - plevel);
                    List<String> itemLore = item.getItemMeta().getLore();
                    ItemMeta item2meta = item.getItemMeta();
                    for (int i = 0; i < itemLore.size(); i++) {
                        String lValue = itemLore.get(i);
                        if (lValue.equals(Painter.paint("&8<Boş Büyü Bölmesi>"))) {
                            itemLore.set(i, Painter.paint(EnchLore + chance2));
                            break;
                        }
                    }

                    NamespacedKey string = new NamespacedKey(plugin, "string");
                    String enchname = Painter.paint(EnchLore);
                    item2meta.getPersistentDataContainer().set(string, PersistentDataType.STRING, enchname);
                    if (item2meta.getPersistentDataContainer().get(key, Enchants) == null) {
                        HashMap<String, Integer> enchs = new HashMap<String, Integer>();
                        enchs.put(Enchant, chance2);

                        item2meta.addEnchant(Enchantment.WATER_WORKER, 1, true);
                        item2meta.getPersistentDataContainer().set(key, Enchants, enchs);
                    } else {
                        HashMap<String, Integer> enchs = item2meta.getPersistentDataContainer().get(key, Enchants);
                        enchs.put(Enchant, chance2);

                        item2meta.addEnchant(Enchantment.WATER_WORKER, 1, true);
                        item2meta.getPersistentDataContainer().set(key, Enchants, enchs);
                    }

                    item2meta.setLore(itemLore);
                    item.setItemMeta(item2meta);
                    p.getInventory().addItem(item);
                    p.getOpenInventory().setItem(22, null);
                    p.playSound(p, Sound.ITEM_TRIDENT_THUNDER, 3, 1.7f);
                    levels.giveEnchantExp(p,chance2);
                    p.closeInventory();
                } else {
                    p.sendMessage(Painter.paint("&cMalzemelerin Eksik."));
                    p.closeInventory();
                }
            }
        } else {
            int level = p.getLevel();
            int plevel = 10 + 10 * chance2;
            int amount = 15 * chance2;
            item1.setAmount(amount);
            item2.setAmount(amount);

            if (p.getInventory().containsAtLeast(item1, amount) && p.getInventory().containsAtLeast(item2, amount)
                    && level >= plevel) {
                p.getInventory().removeItem(item1);
                p.getInventory().removeItem(item2);
                p.setLevel(level - plevel);

                List<String> itemLore = item.getItemMeta().getLore();
                ItemMeta item2meta = item.getItemMeta();
                for (int i = 0; i < itemLore.size(); i++) {
                    String lValue = itemLore.get(i);
                    if (lValue.equals(Painter.paint("&8<Boş Büyü Bölmesi>"))) {
                        itemLore.set(i, Painter.paint(EnchLore + chance2));
                        break;
                    }
                }
                NamespacedKey string = new NamespacedKey(plugin, "string");
                String enchname = Painter.paint(EnchLore);
                item2meta.getPersistentDataContainer().set(string, PersistentDataType.STRING, enchname);
                if (item2meta.getPersistentDataContainer().get(key, Enchants) == null) {
                    HashMap<String, Integer> enchs = new HashMap<String, Integer>();
                    enchs.put(Enchant, chance2);

                    item2meta.addEnchant(Enchantment.WATER_WORKER, 1, true);
                    item2meta.getPersistentDataContainer().set(key, Enchants, enchs);
                } else {
                    HashMap<String, Integer> enchs = item2meta.getPersistentDataContainer().get(key, Enchants);
                    enchs.put(Enchant, chance2);

                    item2meta.addEnchant(Enchantment.WATER_WORKER, 1, true);
                    item2meta.getPersistentDataContainer().set(key, Enchants, enchs);
                }

                item2meta.setLore(itemLore);
                item.setItemMeta(item2meta);
                p.getInventory().addItem(item);
                p.getOpenInventory().setItem(22, null);
                p.playSound(p, Sound.ITEM_TRIDENT_THUNDER, 3, 1.7f);
                levels.giveEnchantExp(p,chance2);
                p.closeInventory();
            } else {
                p.sendMessage(Painter.paint("&cMalzemelerin Eksik."));
                p.closeInventory();
            }
        }
    }

    public void createEnchant(ItemStack item, Player p, int chance2, String Enchant,
                              String EnchLore, ItemStack item1, ItemStack item2) {

        NamespacedKey key = new NamespacedKey(plugin, "Enchants");
        if (item.getItemMeta().getPersistentDataContainer().get(key, Enchants) != null
                && (item.getItemMeta().getPersistentDataContainer().get(key, Enchants).containsKey(Enchant))) {
            p.sendMessage("olmadı kn");
            p.closeInventory();
        } else {
            int level = p.getLevel();
            int plevel = 10 + 10 * chance2;
            int amount = 15 * chance2;
            item1.setAmount(amount);
            item2.setAmount(amount);

            if (p.getInventory().containsAtLeast(item1, amount) && p.getInventory().containsAtLeast(item2, amount)
                    && level >= plevel) {
                p.getInventory().removeItem(item1);
                p.getInventory().removeItem(item2);
                p.setLevel(level - plevel);
                p.setLevel(p.getLevel() - 5);
                List<String> itemLore = item.getItemMeta().getLore();
                ItemMeta item2meta = item.getItemMeta();
                for (int i = 0; i < itemLore.size(); i++) {
                    String lValue = itemLore.get(i);
                    if (lValue.equals(Painter.paint("&8<Boş Büyü Bölmesi>"))) {
                        itemLore.set(i, Painter.paint(EnchLore + chance2));
                        break;
                    }
                }
                NamespacedKey string = new NamespacedKey(plugin, "string");
                String enchname = Painter.paint(EnchLore);
                item2meta.getPersistentDataContainer().set(string, PersistentDataType.STRING, enchname);
                if (item2meta.getPersistentDataContainer().get(key, Enchants) == null) {
                    HashMap<String, Integer> enchs = new HashMap<String, Integer>();
                    enchs.put(Enchant, chance2);

                    item2meta.addEnchant(Enchantment.WATER_WORKER, 1, true);
                    item2meta.getPersistentDataContainer().set(key, Enchants, enchs);
                } else {
                    HashMap<String, Integer> enchs = item2meta.getPersistentDataContainer().get(key, Enchants);
                    enchs.put(Enchant, chance2);

                    item2meta.addEnchant(Enchantment.WATER_WORKER, 1, true);
                    item2meta.getPersistentDataContainer().set(key, Enchants, enchs);
                }

                item2meta.setLore(itemLore);
                item.setItemMeta(item2meta);
                p.getInventory().addItem(item);
                p.getOpenInventory().setItem(22, null);
                p.playSound(p, Sound.ITEM_TRIDENT_THUNDER, 3, 1.7f);
                levels.giveEnchantExp(p,chance2);
                p.closeInventory();
            } else {
                p.sendMessage(Painter.paint("&cMalzemelerin Eksik."));
                p.closeInventory();
            }
        }
    }

    public void createEnchantVanilla(ItemStack item, Player p, int chance2,
                                     String Enchant, String EnchLore, String noEnch, String noEnch2, Enchantment vanilla, ItemStack item1, ItemStack item2) {

        NamespacedKey key = new NamespacedKey(plugin, "Enchants");
        if (item.getItemMeta().getPersistentDataContainer().get(key, Enchants) != null) {
            if (item.getItemMeta().getPersistentDataContainer().get(key, Enchants).containsKey(Enchant) || (item
                    .getItemMeta().getPersistentDataContainer().get(key, Enchants).containsKey(noEnch)
                    || (item.getItemMeta().getPersistentDataContainer().get(key, Enchants).containsKey(noEnch2)))) {
                p.sendMessage("olmadı kn");
                p.closeInventory();
            } else {

                int level = p.getLevel();
                int plevel = 10 + 10 * chance2;
                int amount = 15 * chance2;
                item1.setAmount(amount);
                item2.setAmount(amount);

                if (p.getInventory().containsAtLeast(item1, amount) && p.getInventory().containsAtLeast(item2, amount)
                        && level >= plevel) {
                    p.getInventory().removeItem(item1);
                    p.getInventory().removeItem(item2);
                    p.setLevel(level - plevel);
                    List<String> itemLore = item.getItemMeta().getLore();
                    ItemMeta item2meta = item.getItemMeta();
                    for (int i = 0; i < itemLore.size(); i++) {
                        String lValue = itemLore.get(i);
                        if (lValue.equals(Painter.paint("&8<Boş Büyü Bölmesi>"))) {
                            itemLore.set(i, Painter.paint(EnchLore + chance2));
                            break;
                        }
                    }

                    NamespacedKey string = new NamespacedKey(plugin, "string");
                    String enchname = Painter.paint(EnchLore);
                    item2meta.getPersistentDataContainer().set(string, PersistentDataType.STRING, enchname);
                    if (item2meta.getPersistentDataContainer().get(key, Enchants) == null) {
                        HashMap<String, Integer> enchs = new HashMap<String, Integer>();
                        enchs.put(Enchant, chance2);

                        item2meta.addEnchant(vanilla, chance2, true);
                        item2meta.getPersistentDataContainer().set(key, Enchants, enchs);
                    } else {
                        HashMap<String, Integer> enchs = item2meta.getPersistentDataContainer().get(key, Enchants);
                        enchs.put(Enchant, chance2);

                        item2meta.addEnchant(vanilla, chance2, true);
                        item2meta.getPersistentDataContainer().set(key, Enchants, enchs);
                    }
                    item2meta.setLore(itemLore);
                    item.setItemMeta(item2meta);
                    p.getInventory().addItem(item);
                    p.getOpenInventory().setItem(22, null);
                    p.playSound(p, Sound.ITEM_TRIDENT_THUNDER, 3, 1.7f);
                    levels.giveEnchantExp(p,chance2);
                    p.closeInventory();
                } else {
                    p.sendMessage(Painter.paint("&cMalzemelerin Eksik."));
                    p.closeInventory();
                }
            }
        } else {

            int level = p.getLevel();
            int plevel = 10 + 10 * chance2;
            int amount = 15 * chance2;
            item1.setAmount(amount);
            item2.setAmount(amount);

            if (p.getInventory().containsAtLeast(item1, amount) && p.getInventory().containsAtLeast(item2, amount)
                    && level >= plevel) {
                p.getInventory().removeItem(item1);
                p.getInventory().removeItem(item2);
                p.setLevel(level - plevel);
                List<String> itemLore = item.getItemMeta().getLore();
                ItemMeta item2meta = item.getItemMeta();
                for (int i = 0; i < itemLore.size(); i++) {
                    String lValue = itemLore.get(i);
                    if (lValue.equals(Painter.paint("&8<Boş Büyü Bölmesi>"))) {
                        itemLore.set(i, Painter.paint(EnchLore + chance2));
                        break;
                    }
                }
                NamespacedKey string = new NamespacedKey(plugin, "string");
                String enchname = Painter.paint(EnchLore);
                item2meta.getPersistentDataContainer().set(string, PersistentDataType.STRING, enchname);
                if (item2meta.getPersistentDataContainer().get(key, Enchants) == null) {
                    HashMap<String, Integer> enchs = new HashMap<String, Integer>();
                    enchs.put(Enchant, chance2);

                    item2meta.addEnchant(vanilla, chance2, true);
                    item2meta.getPersistentDataContainer().set(key, Enchants, enchs);
                } else {
                    HashMap<String, Integer> enchs = item2meta.getPersistentDataContainer().get(key, Enchants);
                    enchs.put(Enchant, chance2);

                    item2meta.addEnchant(vanilla, chance2, true);
                    item2meta.getPersistentDataContainer().set(key, Enchants, enchs);
                }
                item2meta.setLore(itemLore);
                item.setItemMeta(item2meta);
                p.getInventory().addItem(item);
                p.getOpenInventory().setItem(22, null);
                p.playSound(p, Sound.ITEM_TRIDENT_THUNDER, 3, 1.7f);
                levels.giveEnchantExp(p,chance2);
                p.closeInventory();
            } else {
                p.sendMessage(Painter.paint("&cMalzemelerin Eksik."));
                p.closeInventory();
            }
        }


    }

    public void createEnchantVanilla(ItemStack item, Player p, int chance2,
                                     String Enchant, String EnchLore, String noEnch, Enchantment vanilla, ItemStack item1, ItemStack item2) {

        NamespacedKey key = new NamespacedKey(plugin, "Enchants");
        if (item.getItemMeta().getPersistentDataContainer().get(key, Enchants) != null) {
            if (item.getItemMeta().getPersistentDataContainer().get(key, Enchants).containsKey(Enchant)
                    || (item.getItemMeta().getPersistentDataContainer().get(key, Enchants).containsKey(noEnch))) {
                p.sendMessage("olmad kn");
                p.closeInventory();
            } else {
                int level = p.getLevel();
                int plevel = 10 + 10 * chance2;
                int amount = 15 * chance2;
                item1.setAmount(amount);
                item2.setAmount(amount);

                if (p.getInventory().containsAtLeast(item1, amount) && p.getInventory().containsAtLeast(item2, amount)
                        && level >= plevel) {
                    p.getInventory().removeItem(item1);
                    p.getInventory().removeItem(item2);
                    p.setLevel(level - plevel);

                    List<String> itemLore = item.getItemMeta().getLore();
                    ItemMeta item2meta = item.getItemMeta();
                    for (int i = 0; i < itemLore.size(); i++) {
                        String lValue = itemLore.get(i);
                        if (lValue.equals(Painter.paint("&8<Boş Büyü Bölmesi>"))) {
                            itemLore.set(i, Painter.paint(EnchLore + chance2));
                            break;
                        }
                    }
                    NamespacedKey string = new NamespacedKey(plugin, "string");
                    String enchname = Painter.paint(EnchLore);

                    item2meta.getPersistentDataContainer().set(string, PersistentDataType.STRING, enchname);
                    if (item2meta.getPersistentDataContainer().get(key, Enchants) == null) {
                        HashMap<String, Integer> enchs = new HashMap<String, Integer>();
                        enchs.put(Enchant, chance2);

                        item2meta.addEnchant(vanilla, chance2, true);
                        item2meta.getPersistentDataContainer().set(key, Enchants, enchs);
                    } else {
                        HashMap<String, Integer> enchs = item2meta.getPersistentDataContainer().get(key, Enchants);
                        enchs.put(Enchant, chance2);

                        item2meta.addEnchant(vanilla, chance2, true);
                        item2meta.getPersistentDataContainer().set(key, Enchants, enchs);
                    }

                    item2meta.setLore(itemLore);
                    item.setItemMeta(item2meta);
                    p.getInventory().addItem(item);
                    p.getOpenInventory().setItem(22, null);
                    p.playSound(p, Sound.ITEM_TRIDENT_THUNDER, 3, 1.7f);
                    levels.giveEnchantExp(p,chance2);
                    p.closeInventory();
                } else {
                    p.sendMessage(Painter.paint("&cMalzemelerin Eksik."));
                    p.closeInventory();
                }
            }
        } else {

            int level = p.getLevel();
            int plevel = 10 + 10 * chance2;
            int amount = 15 * chance2;
            item1.setAmount(amount);
            item2.setAmount(amount);

            if (p.getInventory().containsAtLeast(item1, amount) && p.getInventory().containsAtLeast(item2, amount)
                    && level >= plevel) {
                p.getInventory().removeItem(item1);
                p.getInventory().removeItem(item2);
                p.setLevel(level - plevel);

                List<String> itemLore = item.getItemMeta().getLore();
                ItemMeta item2meta = item.getItemMeta();
                for (int i = 0; i < itemLore.size(); i++) {
                    String lValue = itemLore.get(i);
                    if (lValue.equals(Painter.paint("&8<Boş Büyü Bölmesi>"))) {
                        itemLore.set(i, Painter.paint(EnchLore + chance2));
                        break;
                    }
                }
                NamespacedKey string = new NamespacedKey(plugin, "string");
                String enchname = Painter.paint(EnchLore);
                item2meta.getPersistentDataContainer().set(string, PersistentDataType.STRING, enchname);
                if (item2meta.getPersistentDataContainer().get(key, Enchants) == null) {
                    HashMap<String, Integer> enchs = new HashMap<String, Integer>();
                    enchs.put(Enchant, chance2);

                    item2meta.addEnchant(vanilla, chance2, true);
                    item2meta.getPersistentDataContainer().set(key, Enchants, enchs);
                } else {
                    HashMap<String, Integer> enchs = item2meta.getPersistentDataContainer().get(key, Enchants);
                    enchs.put(Enchant, chance2);

                    item2meta.addEnchant(vanilla, chance2, true);
                    item2meta.getPersistentDataContainer().set(key, Enchants, enchs);
                }

                item2meta.setLore(itemLore);
                item.setItemMeta(item2meta);
                p.getInventory().addItem(item);
                p.getOpenInventory().setItem(22, null);
                p.playSound(p, Sound.ITEM_TRIDENT_THUNDER, 3, 1.7f);
                levels.giveEnchantExp(p,chance2);
                p.closeInventory();
            } else {
                p.sendMessage(Painter.paint("&cMalzemelerin Eksik."));
                p.closeInventory();
            }
        }
    }


    public void createEnchantVanilla(ItemStack item, Player p, int chance2,
                                     String Enchant, String EnchLore, Enchantment vanilla, ItemStack item1, ItemStack item2) {

        NamespacedKey key = new NamespacedKey(plugin, "Enchants");
        if (item.getItemMeta().getPersistentDataContainer().get(key, Enchants) != null
                && (item.getItemMeta().getPersistentDataContainer().get(key, Enchants).containsKey(Enchant))) {
            p.closeInventory();
            p.sendMessage("OLmadı");
        } else {
            int level = p.getLevel();
            int plevel = 10 + 10 * chance2;
            int amount = 15 * chance2;
            item1.setAmount(amount);
            item2.setAmount(amount);

            if (p.getInventory().containsAtLeast(item1, amount) && p.getInventory().containsAtLeast(item2, amount)
                    && level >= plevel) {
                p.getInventory().removeItem(item1);
                p.getInventory().removeItem(item2);
                p.setLevel(level - plevel);
                List<String> itemLore = item.getItemMeta().getLore();
                ItemMeta item2meta = item.getItemMeta();
                for (int i = 0; i < itemLore.size(); i++) {
                    String lValue = itemLore.get(i);
                    if (lValue.equals(Painter.paint("&8<Boş Büyü Bölmesi>"))) {
                        itemLore.set(i, Painter.paint(EnchLore + chance2));
                        break;
                    }
                }
                NamespacedKey string = new NamespacedKey(plugin, "string");
                String enchname = Painter.paint(EnchLore);
                item2meta.getPersistentDataContainer().set(string, PersistentDataType.STRING, enchname);
                if (item2meta.getPersistentDataContainer().get(key, Enchants) == null) {
                    HashMap<String, Integer> enchs = new HashMap<String, Integer>();
                    enchs.put(Enchant, chance2);

                    item2meta.addEnchant(vanilla, chance2, true);
                    item2meta.getPersistentDataContainer().set(key, Enchants, enchs);
                } else {
                    HashMap<String, Integer> enchs = item2meta.getPersistentDataContainer().get(key, Enchants);
                    enchs.put(Enchant, chance2);

                    item2meta.addEnchant(vanilla, chance2, true);
                    item2meta.getPersistentDataContainer().set(key, Enchants, enchs);
                }

                item2meta.setLore(itemLore);
                item.setItemMeta(item2meta);
                p.getInventory().addItem(item);
                p.getOpenInventory().setItem(22, null);
                p.playSound(p, Sound.ITEM_TRIDENT_THUNDER, 3, 1.7f);
                levels.giveEnchantExp(p,chance2);
                p.closeInventory();
            } else {
                p.sendMessage(Painter.paint("&cMalzemelerin Eksik."));
                p.closeInventory();
            }

        }
    }
}
