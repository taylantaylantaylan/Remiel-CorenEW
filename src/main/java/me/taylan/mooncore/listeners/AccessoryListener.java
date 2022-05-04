package me.taylan.mooncore.listeners;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.StatsManager;

public class AccessoryListener implements Listener {
	private MoonCore plugin;
	private StatsManager stats;

	public AccessoryListener(MoonCore plugin) {
		this.plugin = plugin;
		this.stats = plugin.getStatsManager();
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void aksesuar(PlayerInteractEvent event) {
		Player player = event.getPlayer();

		UUID uuid = player.getUniqueId();
		FileConfiguration fc = stats.getStatfile().get(player.getUniqueId());
		if (player.getInventory().getItemInMainHand() == null) {
			return;
		}
		ItemStack item = player.getInventory().getItemInMainHand();
		if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer() != null) {
			ItemMeta meta = item.getItemMeta();
			PersistentDataContainer container = meta.getPersistentDataContainer();
			NamespacedKey type = new NamespacedKey(plugin, "type");
			NamespacedKey name = new NamespacedKey(plugin, "name");
			NamespacedKey can = new NamespacedKey(plugin, "can");
			NamespacedKey doygunluk = new NamespacedKey(plugin, "doygunluk");
			NamespacedKey canyenilenmesi = new NamespacedKey(plugin, "canyenilenmesi");
			NamespacedKey saldirihizi = new NamespacedKey(plugin, "saldirihizi");
			NamespacedKey guc = new NamespacedKey(plugin, "guc");
			NamespacedKey zirh = new NamespacedKey(plugin, "zirh");
			NamespacedKey kritiksansi = new NamespacedKey(plugin, "kritiksansi");
			NamespacedKey kritikhasari = new NamespacedKey(plugin, "kritikhasari");
			NamespacedKey hiz = new NamespacedKey(plugin, "hiz");

			if (container.has(type) && container.has(name)) {
				String aksesuartype = container.get(type, PersistentDataType.STRING);
				String aksesuarname = container.get(name, PersistentDataType.STRING);
				String aksesuarstat = container.get(name, PersistentDataType.STRING);
				ArrayList<ItemStack> list = (ArrayList<ItemStack>) stats.getHepsi(uuid);

				switch (aksesuartype) {
				case "tilsim":
					stats.setTilsim(uuid, aksesuarname);
					list.set(0, player.getInventory().getItemInMainHand());
					stats.setHepsi(uuid, list);
					player.getInventory().setItemInMainHand(null);
					player.playSound(player, Sound.ITEM_ARMOR_EQUIP_GENERIC, 2, 1.1f);
					for (NamespacedKey key : container.getKeys()) {
						if (key.equals(can)) {
							player.damage(0.01);
							stats.setCan(player, player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));

						} else if (key.equals(canyenilenmesi)) {
							stats.setCanYenileme(player, player.getUniqueId(),
									container.get(key, PersistentDataType.INTEGER));

						} else if (key.equals(guc)) {
							stats.setGuc(player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
						} else if (key.equals(zirh)) {
							stats.setZirh(player, player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
						} else if (key.equals(doygunluk)) {
							stats.setDoygunluk(player, player.getUniqueId(),
									container.get(key, PersistentDataType.INTEGER));
						} else if (key.equals(saldirihizi)) {
							stats.setSaldiriHizi(player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
						} else if (key.equals(kritikhasari)) {
							stats.setKritikHasari(player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
						} else if (key.equals(kritiksansi)) {
							stats.setKritikSansi(player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
						} else if (key.equals(hiz)) {
							stats.setHiz(player, player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
						}
					}

					break;
				case "eldiven":
					stats.setEldiven(uuid, aksesuarname);
					list.set(1, player.getInventory().getItemInMainHand());
					stats.setHepsi(uuid, list);
					player.getInventory().setItemInMainHand(null);
					player.playSound(player, Sound.ITEM_ARMOR_EQUIP_GENERIC, 2, 1.1f);

					for (NamespacedKey key : container.getKeys()) {
						if (key.equals(can)) {
							player.damage(0.01);
							stats.setCan(player, player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));

						} else if (key.equals(canyenilenmesi)) {
							stats.setCanYenileme(player, player.getUniqueId(),
									container.get(key, PersistentDataType.INTEGER));

						} else if (key.equals(guc)) {
							stats.setGuc(player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
						} else if (key.equals(zirh)) {
							stats.setZirh(player, player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
						} else if (key.equals(doygunluk)) {
							stats.setDoygunluk(player, player.getUniqueId(),
									container.get(key, PersistentDataType.INTEGER));
						} else if (key.equals(saldirihizi)) {
							stats.setSaldiriHizi(player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
						} else if (key.equals(kritikhasari)) {
							stats.setKritikHasari(player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
						} else if (key.equals(kritiksansi)) {
							stats.setKritikSansi(player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
						} else if (key.equals(hiz)) {
							stats.setHiz(player, player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
						}
					}

					break;
				case "kolye":
					stats.setKolye(uuid, aksesuarname);
					list.set(2, player.getInventory().getItemInMainHand());
					stats.setHepsi(uuid, list);
					player.getInventory().setItemInMainHand(null);
					player.playSound(player, Sound.ITEM_ARMOR_EQUIP_GENERIC, 2, 1.1f);

					for (NamespacedKey key : container.getKeys()) {
						if (key.equals(can)) {
							player.damage(0.01);
							stats.setCan(player, player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));

						} else if (key.equals(canyenilenmesi)) {
							stats.setCanYenileme(player, player.getUniqueId(),
									container.get(key, PersistentDataType.INTEGER));

						} else if (key.equals(guc)) {
							stats.setGuc(player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
						} else if (key.equals(zirh)) {
							stats.setZirh(player, player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
						} else if (key.equals(doygunluk)) {
							stats.setDoygunluk(player, player.getUniqueId(),
									container.get(key, PersistentDataType.INTEGER));
						} else if (key.equals(saldirihizi)) {
							stats.setSaldiriHizi(player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
						} else if (key.equals(kritikhasari)) {
							stats.setKritikHasari(player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
						} else if (key.equals(kritiksansi)) {
							stats.setKritikSansi(player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
						} else if (key.equals(hiz)) {
							stats.setHiz(player, player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
						}
					}

					break;
				case "yuzuk":
					stats.setYuzuk(uuid, aksesuarname);
					list.set(3, player.getInventory().getItemInMainHand());
					stats.setHepsi(uuid, list);
					player.getInventory().setItemInMainHand(null);
					player.playSound(player, Sound.ITEM_ARMOR_EQUIP_GENERIC, 2, 1.1f);

					for (NamespacedKey key : container.getKeys()) {
						if (key.equals(can)) {
							player.damage(0.01);
							stats.setCan(player, player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));

						} else if (key.equals(canyenilenmesi)) {
							stats.setCanYenileme(player, player.getUniqueId(),
									container.get(key, PersistentDataType.INTEGER));

						} else if (key.equals(guc)) {
							stats.setGuc(player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
						} else if (key.equals(zirh)) {
							stats.setZirh(player, player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
						} else if (key.equals(doygunluk)) {
							stats.setDoygunluk(player, player.getUniqueId(),
									container.get(key, PersistentDataType.INTEGER));
						} else if (key.equals(saldirihizi)) {
							stats.setSaldiriHizi(player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
						} else if (key.equals(kritikhasari)) {
							stats.setKritikHasari(player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
						} else if (key.equals(kritiksansi)) {
							stats.setKritikSansi(player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
						} else if (key.equals(hiz)) {
							stats.setHiz(player, player.getUniqueId(), container.get(key, PersistentDataType.INTEGER));
						}
					}

					break;
				}
			}
		}
	}
}
