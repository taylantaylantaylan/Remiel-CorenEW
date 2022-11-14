package me.taylan.mooncore.listeners;

import eu.endercentral.crazy_advancements.advancement.AdvancementDisplay;
import eu.endercentral.crazy_advancements.advancement.ToastNotification;
import fr.mrmicky.fastboard.FastBoard;
import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.eco.Ekonomi;
import me.taylan.mooncore.level.ExpList;
import me.taylan.mooncore.utils.ItemHandler;
import me.taylan.mooncore.utils.Painter;
import me.taylan.mooncore.utils.PlayerHeads;
import me.taylan.mooncore.utils.StatsManager;

import net.kyori.adventure.text.minimessage.MiniMessage;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;

import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class PlayerFishListener implements Listener {
    private final MoonCore plugin;
    private final ItemHandler itemHandler;
    private final HashMap<UUID, LivingEntity> fishmap = new HashMap<>();
    private final StatsManager stats;
    private final Ekonomi ekonomi;
    private final DecimalFormat df = new DecimalFormat("#,###.##");

    public PlayerFishListener(MoonCore plugin) {
        this.plugin = plugin;
        this.itemHandler = plugin.getItemHandler();
        this.stats = plugin.getStatsManager();
        this.ekonomi = plugin.getEkonomi();
        Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void playerFisheventt(PlayerFishEvent event) {
        Player player = event.getPlayer();
        if (fishmap.containsKey(player.getUniqueId())) {
            event.setCancelled(true);
            fishmap.get(player.getUniqueId()).setVelocity(player.getVelocity()
                    .add(player.getLocation().getDirection().normalize().multiply(-0.4)));

        } else {

            int chanceminer = ThreadLocalRandom.current().nextInt(20);
            switch (chanceminer) {
                case 0:
                    if (event.getState() == PlayerFishEvent.State.BITE) {
                        if (event.getCaught() != null) {
                            event.getCaught().remove();
                        }
                        Location location = event.getHook().getLocation().add(0, -1.4, 0);
                        Villager stand = spawnFish(location, "Balık", itemHandler.rawcod, player, event.getHook(), "https://textures.minecraft.net/texture/7892d7dd6aadf35f86da27fb63da4edda211df96d2829f691462a4fb1cab0", 10, 0.2);

                        event.getHook().setHookedEntity(null);
                        new BukkitRunnable() {
                            @Override
                            public void run() {

                                event.getHook().setHookedEntity(stand);

                            }
                        }.runTaskLater(plugin, 10);
                        player.sendMessage(Painter.paint("&6Bir balık yakaladın kaçmasına izin verme!!!"));
                    }
                    break;
                case 1:
                    if (event.getState() == PlayerFishEvent.State.BITE) {
                        if (event.getCaught() != null) {
                            event.getCaught().remove();
                        }
                        Location location = event.getHook().getLocation().add(0, -1.4, 0);
                        Villager stand = spawnFish(location, "salmon", itemHandler.rawsalmon, player, event.getHook(), "https://textures.minecraft.net/texture/b770d917d1ccc12f3a1cf73fe7de8c6548f4a842086923c7bb4446bcc7aaebfa", 12, 0.3);

                        event.getHook().setHookedEntity(null);
                        new BukkitRunnable() {
                            @Override
                            public void run() {

                                event.getHook().setHookedEntity(stand);

                            }
                        }.runTaskLater(plugin, 10);
                        player.sendMessage(Painter.paint("&6Bir balık yakaladın kaçmasına izin verme!!!"));
                    }
                    break;
                case 2:
                    if (event.getState() == PlayerFishEvent.State.CAUGHT_FISH) {

                        event.setExpToDrop(7);
                        Item d = (Item) event.getCaught();

                        Objects.requireNonNull(d).setItemStack(itemHandler.copperore);
                        giveFishingExp(player, itemHandler.copperore);
                    }
                    break;
                case 3:
                    if (event.getState() == PlayerFishEvent.State.CAUGHT_FISH) {

                        event.setExpToDrop(5);
                        Item d = (Item) event.getCaught();
                        Objects.requireNonNull(d).setItemStack(itemHandler.woodkutu);
                        giveFishingExp(player, d.getItemStack());
                    }
                    break;
                case 4:
                    if (event.getState() == PlayerFishEvent.State.BITE) {
                        if (event.getCaught() != null) {
                            event.getCaught().remove();
                        }
                        Location location = event.getHook().getLocation().add(0, -1.4, 0);
                        Villager stand = spawnFish(location, "puffer", itemHandler.pufferfish, player, event.getHook(), "https://textures.minecraft.net/texture/fd06018830f8aea63ec8e6544b68b95e26e133ca50f3b84ad487ae89b511ee74", 12, 0.4);

                        event.getHook().setHookedEntity(null);
                        new BukkitRunnable() {
                            @Override
                            public void run() {

                                event.getHook().setHookedEntity(stand);

                            }
                        }.runTaskLater(plugin, 10);
                        player.sendMessage(Painter.paint("&6Bir balık yakaladın kaçmasına izin verme!!!"));
                    }
                    break;
                case 5:
                    if (event.getState() == PlayerFishEvent.State.CAUGHT_FISH) {

                        event.setExpToDrop(5);
                        Item d = (Item) event.getCaught();
                        Objects.requireNonNull(d).setItemStack(itemHandler.trash);
                        giveFishingExp(player, d.getItemStack());
                    }
                    break;
                case 6:
                    if (event.getState() == PlayerFishEvent.State.CAUGHT_FISH) {

                        event.setExpToDrop(5);
                        Item d = (Item) event.getCaught();
                        Objects.requireNonNull(d).setItemStack(itemHandler.oakstick);
                        giveFishingExp(player, d.getItemStack());
                    }
                    break;
                case 7:
                    if (event.getState() == PlayerFishEvent.State.CAUGHT_FISH) {

                        event.setExpToDrop(5);
                        Item d = (Item) event.getCaught();
                        Objects.requireNonNull(d).setItemStack(itemHandler.saltstring);
                        giveFishingExp(player, d.getItemStack());
                    }
                    break;
                case 8:
                    if (event.getState() == PlayerFishEvent.State.CAUGHT_FISH) {

                        event.setExpToDrop(5);
                        Item d = (Item) event.getCaught();
                        Objects.requireNonNull(d).setItemStack(itemHandler.string);
                        giveFishingExp(player, d.getItemStack());
                    }
                    break;
                case 9:
                    if (event.getState() == PlayerFishEvent.State.CAUGHT_FISH) {

                        event.setExpToDrop(5);
                        Item d = (Item) event.getCaught();
                        Objects.requireNonNull(d).setItemStack(itemHandler.arrow);
                        giveFishingExp(player, d.getItemStack());
                    }
                    break;
                case 10:
                    if (event.getState() == PlayerFishEvent.State.CAUGHT_FISH) {

                        event.setExpToDrop(5);
                        Item d = (Item) event.getCaught();
                        Objects.requireNonNull(d).setItemStack(itemHandler.ironkutu);
                        giveFishingExp(player, d.getItemStack());
                    }
                    break;
                case 11:
                    if (event.getState() == PlayerFishEvent.State.CAUGHT_FISH) {

                        event.setExpToDrop(5);
                        Item d = (Item) event.getCaught();
                        Objects.requireNonNull(d).setItemStack(itemHandler.experiencebottle);
                        giveFishingExp(player, d.getItemStack());
                    }
                    break;
                case 12:
                    if (event.getState() == PlayerFishEvent.State.BITE) {
                        if (event.getCaught() != null) {
                            event.getCaught().remove();
                        }
                        Location location = event.getHook().getLocation().add(0, -1.4, 0);
                        Villager stand = spawnFish(location, "salmon", itemHandler.wawebreakerfish, player, event.getHook(), "https://textures.minecraft.net/texture/a3d0791b0aafe18134860ceafaf60f0fd660320be79a3a9d2faec98066350fda", 20, 0.4);

                        event.getHook().setHookedEntity(null);
                        new BukkitRunnable() {
                            @Override
                            public void run() {

                                event.getHook().setHookedEntity(stand);

                            }
                        }.runTaskLater(plugin, 10);
                        player.sendMessage(Painter.paint("&6Bir balık yakaladın kaçmasına izin verme!!!"));
                    }
                    break;
                case 13:
                    if (event.getState() == PlayerFishEvent.State.BITE) {
                        if (event.getCaught() != null) {
                            event.getCaught().remove();
                        }
                        Location location = event.getHook().getLocation().add(0, -1.4, 0);
                        Villager stand = spawnFish(location, "silverfish", itemHandler.silverfish, player, event.getHook(), "https://textures.minecraft.net/texture/ca3a363368ed1e06cee3900717f062e02ec39aee1747675392255b48f7f83600", 30, 0.5);

                        event.getHook().setHookedEntity(null);
                        new BukkitRunnable() {
                            @Override
                            public void run() {

                                event.getHook().setHookedEntity(stand);

                            }
                        }.runTaskLater(plugin, 10);
                        player.sendMessage(Painter.paint("&6Bir balık yakaladın kaçmasına izin verme!!!"));
                    }
                    break;
                default:
                    if (event.getState() == PlayerFishEvent.State.BITE) {
                        if (event.getCaught() != null) {
                            event.getCaught().remove();
                        }
                        Location location = event.getHook().getLocation().add(0, -1.4, 0);
                        Villager stand = spawnFish(location, "Balık", itemHandler.rawcod, player, event.getHook(), "https://textures.minecraft.net/texture/7892d7dd6aadf35f86da27fb63da4edda211df96d2829f691462a4fb1cab0", 10, 0.2);

                        event.getHook().setHookedEntity(null);
                        new BukkitRunnable() {
                            @Override
                            public void run() {

                                event.getHook().setHookedEntity(stand);

                            }
                        }.runTaskLater(plugin, 10);
                        player.sendMessage(Painter.paint("&6Bir balık yakaladın kaçmasına izin verme!!!"));
                    }
                    break;
            }


        }
    }

    public Villager spawnFish(Location loc, String name, ItemStack item, final Player catcher, FishHook hook, String url, int exp, double direc) {
        ItemStack fishhead = PlayerHeads.getSkull(url);
        return loc.getWorld().spawn(loc, Villager.class, armorStand -> {
            armorStand.setGravity(true);
            armorStand.setInvisible(true);
            armorStand.setAI(true);
            armorStand.setSilent(true);
            armorStand.setSwimming(false);
            armorStand.setInvulnerable(true);
            armorStand.setCollidable(false);
            armorStand.getEquipment().setHelmet(fishhead);
            armorStand.setCustomNameVisible(true);

            armorStand.customName(MiniMessage.miniMessage().deserialize(name));
            armorStand.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.001);
            fishmap.put(catcher.getUniqueId(), armorStand);
            new BukkitRunnable() {
                int lenght = 0;
                int maxlenght = 20;

                @Override
                public void run() {
                    lenght++;
                    armorStand.setVelocity(catcher.getVelocity()
                            .add(catcher.getLocation().getDirection().normalize().multiply(direc)));
                    if (lenght > maxlenght) {
                        armorStand.remove();
                        catcher.sendMessage(Painter.paint("&cBalık kaçtı..."));
                        fishmap.remove(catcher.getUniqueId());
                        hook.remove();
                        this.cancel();

                    }
                    for (Entity entity : armorStand.getNearbyEntities(0.5, 0.4, 0.5)) {
                        if (!(entity instanceof Player)) {
                            return;
                        }
                        if (catcher != entity) {
                            return;
                        }
                        if (fishmap.keySet().contains(entity.getUniqueId())) {

                            if (catcher.getInventory().firstEmpty() == -1) {
                                catcher.spigot().sendMessage(ChatMessageType.ACTION_BAR,
                                        new TextComponent(Painter.paint("&cEnvanterin Dolu!")));
                            } else {
                                item.setAmount(1);
                                catcher.getInventory().addItem(item);
                                giveFishingExp(catcher, item);
                                catcher.sendMessage(Painter.paint("&6Bir balık tutuldu."));
                                catcher.playSound(catcher, Sound.ENTITY_FISHING_BOBBER_SPLASH, 0.5F, 1.3F);
                                armorStand.remove();
                                fishmap.remove(catcher.getUniqueId());
                                hook.remove();
                                this.cancel();
                            }
                        }
                    }

                }
            }.runTaskTimer(plugin, 0, 20);
        });
    }

    public void giveFishingExp(Player player, ItemStack item) {
        ToastNotification notification = new ToastNotification(Material.FISHING_ROD,
                ChatColor.YELLOW + "Balıkçılıkta ustalığın yükseldi!", AdvancementDisplay.AdvancementFrame.CHALLENGE);
        UUID uuid = player.getUniqueId();
        int fishingLevel = stats.getFishingLevel(uuid);
        int fishingExp = stats.getFishingExp(uuid);
        int fishingRequiredExp = stats.getFishingRequiredExp(uuid);
        FastBoard board = new FastBoard(player);

        board.updateTitle(ChatColor.AQUA + "Moon Network");
        if (ExpList.getExpMap().containsKey(item.getType().toString())) {

            int exp2 = ExpList.getExpMap().get(item.getType().toString());
            stats.setFishingExp(uuid, exp2);
            stats.setExp(uuid, exp2 - 1);

        } else if (item == itemHandler.woodkutu || item == itemHandler.ironkutu || item == itemHandler.mistikKutu()
                || item == itemHandler.goldkutu) {
            player.sendMessage(ChatColor.YELLOW + "Bir kutu yakaladın.");
            stats.setFishingExp(uuid, 40);
            stats.setExp(uuid, 10);
        }

        int prog = 100 * fishingExp / fishingRequiredExp;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date(System.currentTimeMillis());

        double para = ekonomi.getBalance(player);

        board.updateLines(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "      Remiel", " ",
                ChatColor.GOLD + "Dinar ⛁" + ChatColor.WHITE + df.format(para), "   ",

                ChatColor.YELLOW + "Balıkçılık " + ChatColor.WHITE + "Ustalık " + fishingLevel,
                ChatColor.GREEN + "EXP " + ChatColor.WHITE + fishingExp + ChatColor.GRAY + "/" + ChatColor.WHITE
                        + fishingRequiredExp + ChatColor.GRAY + " (" + ChatColor.GREEN + "%" + prog + ChatColor.GRAY
                        + ")",
                "     ", ChatColor.GRAY + player.getName(), ChatColor.DARK_GRAY + formatter.format(date),
                ChatColor.AQUA + "mc.moonnw.xyz"

        );
        if (fishingExp >= fishingRequiredExp) {
            stats.setCanYenileme(player, player.getUniqueId(), 1);
            int Exp = stats.getExp(uuid);
            int RequiredExp = stats.getRequiredExp(uuid);
            int Level = stats.getLevel(uuid);
            stats.setExp(uuid, fishingLevel * 3);
            fishingLevel++;
            stats.setFishingLevel(uuid, 1);
            stats.setFishingRequiredExp(uuid, fishingLevel * 50);
            stats.setFishingExp(uuid, -fishingExp);
            notification.send(player);
        }

    }

    @EventHandler
    public void crateplace(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            ItemStack item = player.getInventory().getItemInMainHand();
            ItemStack item2 = player.getInventory().getItemInOffHand();
            NamespacedKey kutu = new NamespacedKey(plugin, "kutu");
            if (item != null && item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer().has(kutu)) {
                event.setCancelled(true);
            } else if (item2 != null && item2.hasItemMeta()
                    && item2.getItemMeta().getPersistentDataContainer().has(kutu)) {
                event.setCancelled(true);
            }
        } else if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_AIR) {
            NamespacedKey kutu = new NamespacedKey(plugin, "kutu");
            ItemStack item = player.getInventory().getItemInMainHand();
            ItemStack item2 = player.getInventory().getItemInOffHand();
            if (item != null && item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer().has(kutu) && Objects.requireNonNull(item.getItemMeta().getPersistentDataContainer().get(kutu, PersistentDataType.STRING)).equalsIgnoreCase("tahtakutu")) {
                int CHANCE = ThreadLocalRandom.current().nextInt(3);
                switch (CHANCE) {
                    case 0 -> {
                        ItemStack box = itemHandler.woodkutu;
                        box.setAmount(1);
                        player.getInventory().removeItem(box);
                        player.sendMessage("Tahta Kutudan Çıkan: " + itemHandler.ironingot.getItemMeta().getDisplayName());
                        if (player.getInventory().firstEmpty() == -1) {
                            player.getWorld().dropItemNaturally(player.getLocation(), itemHandler.ironingot);

                        } else {
                            player.getInventory().addItem(itemHandler.ironingot);
                        }
                    }
                    case 1 -> {
                        ItemStack box1 = itemHandler.woodkutu;
                        box1.setAmount(1);
                        player.getInventory().removeItem(box1);
                        player.sendMessage("Tahta Kutudan Çıkan: " + itemHandler.copperingot.getItemMeta().getDisplayName());
                        if (player.getInventory().firstEmpty() == -1) {
                            player.getWorld().dropItemNaturally(player.getLocation(), itemHandler.copperingot);

                        } else {
                            player.getInventory().addItem(itemHandler.copperingot);
                        }
                    }
                    case 2 -> {
                        ItemStack box2 = itemHandler.woodkutu;
                        box2.setAmount(1);
                        player.sendMessage("Tahta Kutudan Çıkan: " + itemHandler.trash.getItemMeta().getDisplayName());
                        player.getInventory().removeItem(box2);
                        if (player.getInventory().firstEmpty() == -1) {
                            player.getWorld().dropItemNaturally(player.getLocation(), itemHandler.trash);

                        } else {
                            player.getInventory().addItem(itemHandler.trash);
                        }
                    }
                }
            } else if (item != null && item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer().has(kutu) && Objects.requireNonNull(item.getItemMeta().getPersistentDataContainer().get(kutu, PersistentDataType.STRING)).equalsIgnoreCase("demirkutu")) {
                int CHANCE = ThreadLocalRandom.current().nextInt(4);

                switch (CHANCE) {
                    case 0 -> {
                        ItemStack box = itemHandler.ironkutu;
                        box.setAmount(1);
                        player.getInventory().removeItem(box);
                        player.sendMessage("Demir Kutudan Çıkan: " + itemHandler.ironingot.getItemMeta().getDisplayName());
                        if (player.getInventory().firstEmpty() == -1) {
                            player.getWorld().dropItemNaturally(player.getLocation(), itemHandler.ironingot);

                        } else {
                            player.getInventory().addItem(itemHandler.ironingot);
                        }
                    }
                    case 1 -> {
                        ItemStack box1 = itemHandler.ironkutu;
                        box1.setAmount(1);
                        player.getInventory().removeItem(box1);
                        player.sendMessage("Demir Kutudan Çıkan: " + itemHandler.copperingot.getItemMeta().getDisplayName());
                        if (player.getInventory().firstEmpty() == -1) {
                            player.getWorld().dropItemNaturally(player.getLocation(), itemHandler.copperingot);

                        } else {
                            player.getInventory().addItem(itemHandler.copperingot);
                        }
                    }
                    case 2 -> {
                        ItemStack box2 = itemHandler.ironkutu;
                        box2.setAmount(1);
                        player.getInventory().removeItem(box2);
                        player.sendMessage("Demir Kutudan Çıkan: " + itemHandler.trash.getItemMeta().getDisplayName());
                        if (player.getInventory().firstEmpty() == -1) {
                            player.getWorld().dropItemNaturally(player.getLocation(), itemHandler.trash);

                        } else {
                            player.getInventory().addItem(itemHandler.trash);
                        }
                    }
                    case 3 -> {
                        ItemStack box3 = itemHandler.ironkutu;
                        box3.setAmount(1);
                        player.getInventory().removeItem(box3);
                        player.sendMessage("Demir Kutudan Çıkan: " + itemHandler.silverfish.getItemMeta().getDisplayName());
                        if (player.getInventory().firstEmpty() == -1) {
                            player.getWorld().dropItemNaturally(player.getLocation(), itemHandler.silverfish);

                        } else {
                            player.getInventory().addItem(itemHandler.silverfish);
                        }
                    }
                }
            } else if (item != null && item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer().has(kutu) && Objects.requireNonNull(item.getItemMeta().getPersistentDataContainer().get(kutu, PersistentDataType.STRING)).equalsIgnoreCase("magmav")) {
                int CHANCE = ThreadLocalRandom.current().nextInt(5);

                switch (CHANCE) {
                    case 0 -> {
                        ItemStack box = itemHandler.magmaloot;
                        box.setAmount(1);
                        player.getInventory().removeItem(box);
                        player.sendMessage("Ganimet Çantasından Çıkan: " + itemHandler.crimsonore.getItemMeta().getDisplayName());
                        if (player.getInventory().firstEmpty() == -1) {
                            player.getWorld().dropItemNaturally(player.getLocation(), itemHandler.crimsonore);

                        } else {
                            player.getInventory().addItem(itemHandler.crimsonore);
                        }
                    }
                    case 1 -> {
                        ItemStack box1 = itemHandler.magmaloot;
                        box1.setAmount(1);
                        player.getInventory().removeItem(box1);
                        player.sendMessage("Ganimet Çantasından Çıkan: " + itemHandler.kutsalbileklik.getItemMeta().getDisplayName());
                        if (player.getInventory().firstEmpty() == -1) {
                            player.getWorld().dropItemNaturally(player.getLocation(), itemHandler.kutsalbileklik);

                        } else {
                            player.getInventory().addItem(itemHandler.kutsalbileklik);
                        }
                    }
                    case 2 -> {
                        ItemStack box5 = itemHandler.magmaloot;
                        box5.setAmount(1);
                        player.getInventory().removeItem(box5);
                        player.sendMessage("Ganimet Çantasından Çıkan: " + Painter.paint("&a100 Tecrübe Puanı"));
                        stats.setExp(player.getUniqueId(), 100);
                    }
                    case 3 -> {
                        ItemStack box3 = itemHandler.magmaloot;
                        box3.setAmount(1);
                        player.getInventory().removeItem(box3);
                        player.sendMessage("Ganimet Çantasından Çıkan: " + itemHandler.magmapickaxe.getItemMeta().getDisplayName());
                        if (player.getInventory().firstEmpty() == -1) {
                            player.getWorld().dropItemNaturally(player.getLocation(), itemHandler.magmapickaxe);

                        } else {
                            player.getInventory().addItem(itemHandler.magmapickaxe);
                        }
                    }
                    case 4 -> {
                        ItemStack box4 = itemHandler.magmaloot;
                        box4.setAmount(1);
                        player.getInventory().removeItem(box4);
                        player.sendMessage("Ganimet Çantasından Çıkan: " + itemHandler.magmafrag.getItemMeta().getDisplayName());
                        if (player.getInventory().firstEmpty() == -1) {
                            player.getWorld().dropItemNaturally(player.getLocation(), itemHandler.magmafrag);

                        } else {
                            player.getInventory().addItem(itemHandler.magmafrag);
                        }
                    }
                }
            }

        }

    }
}
