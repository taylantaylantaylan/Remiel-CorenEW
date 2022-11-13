package me.taylan.mooncore.listeners;

import fr.mrmicky.fastboard.FastBoard;
import lombok.NonNull;
import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.eco.Ekonomi;
import me.taylan.mooncore.utils.BukkitSerialization;
import me.taylan.mooncore.utils.Painter;
import me.taylan.mooncore.utils.StatsManager;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.bossbar.BossBar;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import javax.annotation.Nullable;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class JoinListener implements Listener {

    private MoonCore plugin;
    private StatsManager stats;
    private DecimalFormat df = new DecimalFormat("#,###.##");
    private Ekonomi ekonomi;
    private static HashMap<UUID, Inventory> menu = new HashMap<UUID, Inventory>();
    private static HashMap<UUID, Inventory> ocakmenu = new HashMap<UUID, Inventory>();

    public HashMap<UUID, Integer> getQuestmap() {
        return questmap;
    }

    private HashMap<UUID, Integer> questmap = new HashMap<>();

    public HashMap<UUID, BossBar> getBossbarmap() {
        return bossbarmap;
    }

    private HashMap<UUID, BossBar> bossbarmap = new HashMap<>();
    private HashMap<UUID, ItemStack[]> armor = new HashMap<UUID, ItemStack[]>();

    public HashMap<UUID, ItemStack[]> getArmor() {
        return armor;
    }

    private static HashMap<UUID, Inventory> furnacemenu = new HashMap<UUID, Inventory>();
    private static HashMap<UUID, Inventory> elsanatmenu = new HashMap<UUID, Inventory>();
    private static HashMap<UUID, Inventory> realfurnacemenu = new HashMap<UUID, Inventory>();

    public JoinListener(MoonCore plugin) {
        this.plugin = plugin;
        this.ekonomi = plugin.getEkonomi();
        this.stats = plugin.getStatsManager();
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    public static HashMap<UUID, Inventory> getMenu() {
        return menu;
    }

    public static HashMap<UUID, Inventory> getOcakMenu() {
        return ocakmenu;
    }

    public static HashMap<UUID, Inventory> getFurnacemenu() {
        return furnacemenu;
    }

    public static HashMap<UUID, Inventory> getElsanatmenu() {
        return elsanatmenu;
    }

    public static HashMap<UUID, Inventory> getRealfurnacemenu() {
        return realfurnacemenu;
    }

    @SuppressWarnings("deprecation")
    @EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = true)
    public void onPlayerJoin(PlayerJoinEvent e) {

        Player player = e.getPlayer();
        if (player.getInventory().getArmorContents() != null) {
            armor.put(player.getUniqueId(), player.getInventory().getArmorContents());
        }
        player.setHealthScale(20);
        e.setJoinMessage(null);
        String name = player.getName();
        String broadcastedMessage = "";
        if (!stats.hasPlayedBefore(player.getUniqueId())) {
            try {
                stats.createFile(player.getUniqueId());
            } catch (IOException ex) {
                plugin.send("&cOyuncu Dosyası oluşturulamadı!");
            }
            broadcastedMessage = Painter.paint(name + " &bRemiel &etopraklarına ilk adımını attı!");
        } else {
            stats.getStatfile().put(player.getUniqueId(), stats.getFile(player.getUniqueId()));
            broadcastedMessage = Painter.paint("&7[&6+&7] " + name);
        }
        for (Player p : plugin.getServer().getOnlinePlayers()) {
            p.sendMessage(broadcastedMessage);
        }
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        if (scoreboard.getTeam(player.getName()) == null) {
            scoreboard.registerNewTeam(player.getName());
        }
        Team isim = scoreboard.getTeam(player.getName());
        if (isim.hasEntry(player.getName())) {
            isim.setPrefix(Painter.paint("&7[&fSvy. " + stats.getLevel(player.getUniqueId()) + "&7] &f"));
            isim.setSuffix(Painter.paint(" &6[" + (int) player.getHealth() + "❤]"));
        } else {
            isim.addEntry(player.getName());
            isim.setPrefix(Painter.paint("&7[&fSvy. " + stats.getLevel(player.getUniqueId()) + "&7] &f"));
            isim.setSuffix(Painter.paint(" &6[" + (int) player.getHealth() + "❤]"));
        }
		/*NamespacedKey weightitm = new NamespacedKey(plugin, "weightitm");
		for (ItemStack item : player.getInventory().getContents()) {

			int totalWeight = 0;
			if (item != null && item.hasItemMeta()) {
				if (item.getItemMeta().getPersistentDataContainer() != null) {
					if (item.getItemMeta().getPersistentDataContainer().has(weightitm, PersistentDataType.INTEGER)) {
						totalWeight += item.getItemMeta().getPersistentDataContainer().get(weightitm,
								PersistentDataType.INTEGER);
						stats.setAgirlik(player.getUniqueId(), totalWeight);

					} else {
						stats.setAgirlik(player.getUniqueId(), 0);

					}
				}
			}
		}
*/
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date(System.currentTimeMillis());
        FastBoard board = new FastBoard(player);

        board.updateTitle(ChatColor.AQUA + "Moon Network");
        player.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(1000);
        double para = ekonomi.getBalance(player);
        board.updateTitle(ChatColor.AQUA + "Moon Network");

        board.updateLines(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "     Remiel", "    ",
                ChatColor.GOLD + "Dinar ⛁" + ChatColor.WHITE + df.format(para),
                "", ChatColor.GRAY + player.getName(), ChatColor.DARK_GRAY + formatter.format(date),
                ChatColor.AQUA + "mc.moonnw.xyz"

        );
        if (!(player.hasPlayedBefore())) {
            PotionEffect effect = new PotionEffect(PotionEffectType.REGENERATION, 600,
                    2,false,false,false);
            PotionEffect effect2 = player.getPotionEffect(PotionEffectType.REGENERATION);
            if (effect2 == null) {
                player.addPotionEffect(effect);
            }
            questmap.put(player.getUniqueId(), 0);
            player.giveExp(20000);
            Location loc2 = new Location(Bukkit.getWorld("dungeonworld"), 495, 63, 308);
            player.teleport(loc2);
            showMyBossBar(player);
            ItemStack star = new ItemStack(Material.KNOWLEDGE_BOOK);
            NamespacedKey key = new NamespacedKey(plugin, "star");
            List<String> lore = new ArrayList<>();
            ItemMeta meta = star.getItemMeta();
            PersistentDataContainer container = meta.getPersistentDataContainer();
            container.set(key, PersistentDataType.STRING, "star");
            meta.setDisplayName(Painter.paint("&bOyuncu El Kitabı"));
            lore.add(Painter.paint("&8Bu kitap sayesinde bir çok şeye erişebilir"));
            lore.add(Painter.paint("&8ve daha önce karşılaştığınız yaratıklar"));
            lore.add(Painter.paint("&8hakkında Bilgi sahibi olabilirsiniz."));
            lore.add(Painter.paint(""));
            lore.add(Painter.paint("&7Kullanmak için &e&lSağ Tıkla."));
            meta.setLore(lore);
            star.setItemMeta(meta);
            player.getInventory().setItem(8, star);
        }

        menu.put(player.getUniqueId(), Bukkit.createInventory(player, 54, MiniMessage.miniMessage().deserialize("<dark_gray>Depo")));
        ocakmenu.put(player.getUniqueId(), Bukkit.createInventory(player, 54, MiniMessage.miniMessage().deserialize("<dark_gray>Ocak Deposu")));
        furnacemenu.put(player.getUniqueId(), Bukkit.createInventory(player, 54, MiniMessage.miniMessage().deserialize("<dark_gray>Maden Fırın Deposu")));
        elsanatmenu.put(player.getUniqueId(), Bukkit.createInventory(player, 54, MiniMessage.miniMessage().deserialize("<dark_gray>El Sanatları Deposu")));
        realfurnacemenu.put(player.getUniqueId(), Bukkit.createInventory(player, 54, MiniMessage.miniMessage().deserialize("<dark_gray>Fırın Deposu")));

        if (!(stats.getStorage(player.getUniqueId()).equals("yok"))) {
            String contents = stats.getStorage(player.getUniqueId());
            try {
                ItemStack[] inv = BukkitSerialization.itemStackArrayFromBase64(contents);
                menu.get(player.getUniqueId()).setContents(inv);
            } catch (IOException ev) {
                plugin.getLogger().warning("Broken");
                ev.printStackTrace();
            }
        }
        if (!(stats.getRealFurnaceStorage(player.getUniqueId()).equals("yok"))) {
            String contents = stats.getRealFurnaceStorage(player.getUniqueId());
            try {
                ItemStack[] inv = BukkitSerialization.itemStackArrayFromBase64(contents);
                realfurnacemenu.get(player.getUniqueId()).setContents(inv);
            } catch (IOException ev) {
                plugin.getLogger().warning("Broken");
                ev.printStackTrace();
            }
        }
        if (!(stats.getFurnaceStorage(player.getUniqueId()).equals("yok"))) {
            String contents = stats.getFurnaceStorage(player.getUniqueId());
            try {
                ItemStack[] inv = BukkitSerialization.itemStackArrayFromBase64(contents);
                furnacemenu.get(player.getUniqueId()).setContents(inv);
            } catch (IOException ev) {
                plugin.getLogger().warning("Broken");
                ev.printStackTrace();
            }
        }
        if (!(stats.getCookStorage(player.getUniqueId()).equals("yok"))) {
            String contents = stats.getCookStorage(player.getUniqueId());
            try {
                ItemStack[] inv = BukkitSerialization.itemStackArrayFromBase64(contents);
                ocakmenu.get(player.getUniqueId()).setContents(inv);
            } catch (IOException ev) {
                plugin.getLogger().warning("Broken");
                ev.printStackTrace();
            }
        }
        if (!(stats.getWorkStorage(player.getUniqueId()).equals("yok"))) {
            String contents = stats.getWorkStorage(player.getUniqueId());
            try {
                ItemStack[] inv = BukkitSerialization.itemStackArrayFromBase64(contents);
                elsanatmenu.get(player.getUniqueId()).setContents(inv);
            } catch (IOException ev) {
                plugin.getLogger().warning("Broken");
                ev.printStackTrace();
            }
        }
        if (stats.getVayne(player.getUniqueId()) != null) {
            ItemStack[] content = stats.getVayne(player.getUniqueId()).toArray(new ItemStack[0]);
            player.getInventory().setArmorContents(content);
            stats.setVayne(player.getUniqueId(), null);
        }
    }


    public void showMyBossBar(final @NonNull Audience target) {
        final Component name = Component.text("Valadir ile Konuş.");
        final BossBar emptyBar = BossBar.bossBar(name, 0, BossBar.Color.YELLOW, BossBar.Overlay.PROGRESS);
        target.showBossBar(emptyBar);
        if (target instanceof Player) {
            Player player = (Player) target;
            bossbarmap.put(player.getUniqueId(),emptyBar);
        }


    }


}
