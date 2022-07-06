package me.taylan.mooncore.listeners;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.Painter;
import me.taylan.mooncore.utils.StatsManager;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class ChunkListener implements Listener {

    private MoonCore plugin;
    private StatsManager statsManager;

    public ChunkListener(MoonCore plugin) {
        this.plugin = plugin;
        this.statsManager = plugin.getStatsManager();
        Bukkit.getServer().getPluginManager().registerEvents(this,plugin);
    }

    @EventHandler
    public void ChunkInteract(PlayerInteractEvent event) {
        if(event.getClickedBlock() != null) {
            Chunk chunk = event.getClickedBlock().getChunk();
            String chunkID = chunk.getX()+"."+chunk.getZ();
            if(statsManager.isChunk(chunkID)) {
                Player player = event.getPlayer();
                if(!statsManager.getOwner(chunkID).equals(player.getUniqueId())) {
                    if(!player.isOp()) {
                        player.sendMessage(Painter.paint("&cİnşa etmeye çalıştığın bölge &6"+ Bukkit.getPlayer(statsManager.getOwner(chunkID))+" &cisimli oyuncuya ait!"));
                    }
                }
            }
        }
    }
}
