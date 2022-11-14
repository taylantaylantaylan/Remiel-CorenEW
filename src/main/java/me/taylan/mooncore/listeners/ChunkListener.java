package me.taylan.mooncore.listeners;

import com.destroystokyo.paper.MaterialTags;
import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.GuiHandler;
import me.taylan.mooncore.utils.Painter;
import me.taylan.mooncore.utils.StatsManager;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Objects;

public class ChunkListener implements Listener {

private final MoonCore plugin;
    private final StatsManager statsManager;
    private final GuiHandler guiHandler;

    public ChunkListener(MoonCore plugin) {
        this.plugin = plugin;
        this.statsManager = plugin.getStatsManager();
        this.guiHandler= plugin.getGuiHandler();
        Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void ChunkInteract(PlayerInteractEvent event) {
        if (event.getClickedBlock() != null) {
            Player player = event.getPlayer();
            if (player.getWorld().getName().equalsIgnoreCase("remielsurvival")) {
                Chunk chunk = event.getClickedBlock().getChunk();
                String chunkID = chunk.getX() + "." + chunk.getZ();
                if ((statsManager.getChunkmap().containsValue(player.getUniqueId()))) {
                    if (statsManager.isChunk(chunkID)) {

                        if (!statsManager.getOwner(chunkID).equals(player.getUniqueId())) {
                            if (!player.isOp()) {
                                player.sendMessage(Painter.paint("&cİnşa etmeye çalıştığın bölge &6" + Objects.requireNonNull(Bukkit.getPlayer(statsManager.getOwner(chunkID))).getName() + " &cisimli oyuncuya ait!"));
                                event.setCancelled(true);
                            }
                        } else {
                            event.setCancelled(false);
                            if ((event.getClickedBlock().getType() == Material.BEDROCK)) {
                                player.openInventory(guiHandler.claimBilgi(player));
                            }
                            if(MaterialTags.BEDS.isTagged(event.getClickedBlock().getType())) {
                                event.setCancelled(false);
                            }
                        }
                    } else {
                        if (!player.isOp()) {
                            event.setCancelled(true);
                        }
                    }
                } else {
                    if (!player.isOp()) {
                        event.setCancelled(true);
                    }
                }
            } else {
                if(MaterialTags.BEDS.isTagged(event.getClickedBlock().getType())) {
                    event.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void BlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        Chunk chunk = player.getChunk();
        String chunkID = chunk.getX() + "." + chunk.getZ();
        if ((statsManager.getChunkmap().containsValue(player.getUniqueId()))) {
            if (statsManager.isChunk(chunkID)) {

                if (!statsManager.getOwner(chunkID).equals(player.getUniqueId())) {
                    if (!player.isOp()) {
                        player.sendMessage(Painter.paint("&cİnşa etmeye çalıştığın bölge &6" + Objects.requireNonNull(Bukkit.getPlayer(statsManager.getOwner(chunkID))).getName() + " &cisimli oyuncuya ait!"));
                        event.setCancelled(true);
                    }
                } else {
                    event.setCancelled(false);
                }
            } else {
                if (!player.isOp()) {
                    event.setCancelled(true);
                }
            }
        } else {
            if (!player.isOp()) {
                event.setCancelled(true);
            }
        }

    }

    @EventHandler
    public void BlockBreakChunk(BlockBreakEvent event) {

        if (event.getBlock() != null) {
            Player player = event.getPlayer();
            if (player.getWorld().getName().equalsIgnoreCase("remielsurvival")) {
                Chunk chunk = event.getBlock().getChunk();
                String chunkID = chunk.getX() + "." + chunk.getZ();
                if ((statsManager.getChunkmap().containsValue(player.getUniqueId()))) {
                    if (statsManager.isChunk(chunkID)) {

                        if (!statsManager.getOwner(chunkID).equals(player.getUniqueId())) {
                            if (!player.isOp()) {
                                player.sendMessage(Painter.paint("&cKırmaya çalıştığın bölge &6" + player.getName() + " &cisimli oyuncuya ait!"));
                                event.setCancelled(true);
                            }
                        } else {
                            event.setCancelled(false);
                        }
                    } else {
                        if (!player.isOp()) {
                            event.setCancelled(true);
                        }
                    }
                } else {
                    if (!player.isOp()) {
                        event.setCancelled(true);
                    }
                }
            }
        }
    }
}
