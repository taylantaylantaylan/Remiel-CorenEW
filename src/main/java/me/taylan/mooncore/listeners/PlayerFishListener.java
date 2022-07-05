package me.taylan.mooncore.listeners;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.PlayerHeads;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerFishListener implements Listener {
    private final MoonCore plugin;
    private Player player;

    public PlayerFishListener(MoonCore plugin) {
        this.plugin = plugin;
        Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void playerFisheventt(PlayerFishEvent event) {
        Player player = event.getPlayer();
        if (event.getState() == PlayerFishEvent.State.BITE) {
            event.getCaught().remove();
            Location location = event.getHook().getLocation();
            ItemStack fishhead = PlayerHeads.getSkull("http://textures.minecraft.net/texture/c2ad3cc6d3631caa887a91ebc5e6a65cf257803c7c7acd57d19a0ac22fae8403");
            ArmorStand stand = spawnArmorStand(location, "Balık", fishhead,player);
            new BukkitRunnable() {
                @Override
                public void run() {
                    event.getHook().setHookedEntity(stand);
                }
            }.runTaskLater(plugin,10);


        }
    }

    public ArmorStand spawnArmorStand(Location loc, String name, ItemStack head,Player catcher) {
        ArmorStand armorStand2 = loc.getWorld().spawn(loc, ArmorStand.class, armorStand -> {
            armorStand.setMarker(false);
            armorStand.setVisible(false);
            armorStand.setGravity(true);
            armorStand.setSmall(false);
            armorStand.getLocation().setDirection(catcher.getLocation().getDirection().multiply(-1));
            armorStand.getEquipment().setHelmet(head);
            armorStand.setCustomNameVisible(true);
            armorStand.customName(MiniMessage.miniMessage().deserialize(name));

        });
        return armorStand2;
    }
}
