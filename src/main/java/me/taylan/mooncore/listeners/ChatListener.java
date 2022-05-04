package me.taylan.mooncore.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import io.papermc.paper.event.player.AsyncChatEvent;
import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.StatsManager;
import net.kyori.adventure.text.minimessage.MiniMessage;

public class ChatListener implements Listener {

	private MoonCore plugin;
	private StatsManager statsManager;

	public ChatListener(MoonCore plugin) {
		this.plugin = plugin;
		this.statsManager = plugin.getStatsManager();
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void chatevent(AsyncChatEvent event) {
		Player player = event.getPlayer();
		/*event.message(
				event.message().append(MiniMessage.get().parse("<gray>[<white>Seviye " + statsManager.getLevel(player.getUniqueId())+"<gray>]"),
						MiniMessage.get().parse(player.getName()+"&7> "), event.message()).build());*/

	}

}
