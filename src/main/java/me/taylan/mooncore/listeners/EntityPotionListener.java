package me.taylan.mooncore.listeners;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.StatsManager;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPotionEffectEvent;
import org.bukkit.event.entity.EntityPotionEffectEvent.Action;
import org.bukkit.event.entity.EntityPotionEffectEvent.Cause;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.*;

public class EntityPotionListener implements Listener {

private final MoonCore plugin;
    private final StatsManager manager;
    private final PlayerDeathListener deathListener;
    private final HashMap<UUID, List<PotionEffect>> potionmap = new HashMap<UUID, List<PotionEffect>>();

    public EntityPotionListener(MoonCore plugin) {
        this.plugin = plugin;
        this.deathListener = plugin.getDeathListener();
        this.manager = plugin.getStatsManager();
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerItemConsumeEvent(PlayerItemConsumeEvent e) {
        Player p = e.getPlayer();
        if (e.getItem().hasItemMeta() && e.getItem().getItemMeta().getDisplayName().contains("Geri Dönüş İksiri")) {
            if (deathListener.getDeathmap().containsKey(p.getUniqueId())) {
                p.teleport(deathListener.getDeathmap().get(p.getUniqueId()));
                deathListener.getDeathmap().remove(p.getUniqueId());
            }
        } else if (e.getItem().hasItemMeta() && e.getItem().getItemMeta().getDisplayName().contains("Antrikot")) {
            PotionEffect effect = new PotionEffect(PotionEffectType.REGENERATION, 60,
                    1, true, true, true);


            p.addPotionEffect(effect);

        } else if (e.getItem().hasItemMeta() && e.getItem().getItemMeta().getDisplayName().contains("Pişmiş Gümüş Balığı")) {
            PotionEffect effect = new PotionEffect(PotionEffectType.SATURATION, 60,
                    1, true, true, true);


            p.addPotionEffect(effect);
        }

    }

    @EventHandler
    public void potionevent(EntityPotionEffectEvent event) {
        Entity entity = event.getEntity();
        if (!(entity instanceof Player)) {
            return;
        }
        Player player = (Player) entity;
        if (event.getAction() == Action.ADDED || event.getAction() == Action.CHANGED)
            if (Objects.requireNonNull(event.getNewEffect()).getType().equals(PotionEffectType.SLOW_FALLING)) {
                PotionEffect effect = player.getPotionEffect(PotionEffectType.SLOW_FALLING);
                if (effect == null) {
                    if (potionmap.containsKey(player.getUniqueId())) {
                        List<PotionEffect> poteffects = potionmap.get(player.getUniqueId());
                        poteffects.add(event.getNewEffect());
                        int ampi = event.getNewEffect().getAmplifier() + 1;
                        int gucpot = ampi * 50;
                        manager.setKritikHasari(player.getUniqueId(), gucpot);
                        potionmap.put(player.getUniqueId(), poteffects);
                        player.sendMessage("Altarın kanını ictin." + manager.getKritikHasari(player.getUniqueId()));
                        player.sendMessage("knk");
                    } else {
                        List<PotionEffect> poteffects = new ArrayList<PotionEffect>();
                        poteffects.add(event.getNewEffect());
                        int ampi = event.getNewEffect().getAmplifier() + 1;
                        int gucpot = ampi * 50;
                        manager.setKritikHasari(player.getUniqueId(), gucpot);
                        potionmap.put(player.getUniqueId(), poteffects);
                        player.sendMessage("Altarın kanını ictin." + manager.getKritikHasari(player.getUniqueId()));

                    }
                }

            }

    }

    @EventHandler
    public void altarkanı(EntityPotionEffectEvent event) {
        Entity entity = event.getEntity();
        if (!(entity instanceof Player)) {
            return;
        }
        Player player = (Player) entity;
        if (potionmap.containsKey(player.getUniqueId())) {
            if (event.getCause() == Cause.EXPIRATION || event.getCause() == Cause.MILK
                    || event.getCause() == Cause.DEATH) {
                List<PotionEffect> potmap = potionmap.get(player.getUniqueId());
                for (PotionEffect effect : potmap) {
                    if (Objects.requireNonNull(event.getOldEffect()).getType().equals(PotionEffectType.SLOW_FALLING)
                            && effect.getType().equals(PotionEffectType.SLOW_FALLING)) {
                        int ampi = effect.getAmplifier() + 1;
                        int gucpot = ampi * 50;
                        manager.setKritikHasari(player.getUniqueId(), -gucpot);
                        player.sendMessage("Altarın kanı sona erdi.");
                        potmap.remove(effect);
                        potionmap.put(player.getUniqueId(), potmap);

                    }
                }
            }
        }

    }

}