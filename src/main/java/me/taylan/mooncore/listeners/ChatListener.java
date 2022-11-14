package me.taylan.mooncore.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import io.papermc.paper.event.player.AsyncChatEvent;
import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.StatsManager;

public class ChatListener implements Listener {

	// --Commented out by Inspection// --Commented out by Inspection (14.11.2022 02:08): (14.11.2022 02:08):private final MoonCore plugin;
	// --Commented out by Inspection (14.11.2022 02:08):private final StatsManager statsManager;

// --Commented out by Inspection START (14.11.2022 02:08):
//	public ChatListener(MoonCore plugin) {
//		this.plugin = plugin;
//		this.statsManager = plugin.getStatsManager();
//		plugin.getServer().getPluginManager().registerEvents(this, plugin);
//	}
// --Commented out by Inspection STOP (14.11.2022 02:08)

	@EventHandler
	public void chatevent(AsyncChatEvent event) {
		Player player = event.getPlayer();
		/*event.message(
				event.message().append(MiniMessage.get().parse("<gray>[<white>Seviye " + statsManager.getLevel(player.getUniqueId())+"<gray>]"),
						MiniMessage.get().parse(player.getName()+"&7> "), event.message()).build());*/

	}

}
