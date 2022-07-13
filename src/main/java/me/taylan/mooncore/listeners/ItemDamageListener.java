package me.taylan.mooncore.listeners;

import com.destroystokyo.paper.MaterialTags;
import me.taylan.mooncore.MoonCore;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class ItemDamageListener implements Listener {

    private MoonCore plugin;

    public ItemDamageListener(MoonCore plugin) {
        this.plugin = plugin;
        Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void itemdamage(PlayerItemDamageEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();
        if (item != null && item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
            NamespacedKey dura = new NamespacedKey(plugin, "durability");
            if (MaterialTags.CHESTPLATES.isTagged(item) || MaterialTags.LEGGINGS.isTagged(item) || MaterialTags.HELMETS.isTagged(item) || MaterialTags.BOOTS.isTagged(item) || item.getType() == Material.DIAMOND_SWORD || item.getType() == Material.WOODEN_HOE || item.getType() == Material.WOODEN_SWORD || item.getType() == Material.WOODEN_SHOVEL  || item.getType() == Material.WOODEN_AXE || item.getType() == Material.BOW || item.getType() == Material.FISHING_ROD || item.getType() == Material.CROSSBOW || item.getType() == Material.GOLDEN_SHOVEL|| item.getType() == Material.GOLDEN_PICKAXE || item.getType() == Material.GOLDEN_AXE
            ) {
                if (item != null && item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null && item.getItemMeta().getPersistentDataContainer().has(dura)) {

                    ItemMeta meta = item.getItemMeta();
                    int durabilt = meta.getPersistentDataContainer().get(dura, PersistentDataType.INTEGER);
                    meta.getPersistentDataContainer().set(dura, PersistentDataType.INTEGER, durabilt - 1);
                    item.setItemMeta(meta);
                    Damageable damagemeta = (Damageable) meta;
                    if (durabilt < item.getType().getMaxDurability()) {
                        damagemeta.setDamage(damagemeta.getDamage() + 1);
                        item.setItemMeta(damagemeta);
                        if (durabilt < 0) {
                            player.getInventory().remove(item);
                            player.playSound(player, Sound.ITEM_SHIELD_BREAK, 0.5F, 1.3F);
                        }
                    } else {
                        damagemeta.setDamage(0);
                        item.setItemMeta(damagemeta);
                    }
                }
            }
        }
    }
}
