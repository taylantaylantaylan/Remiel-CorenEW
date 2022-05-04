package me.taylan.mooncore.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.utils.ItemHandler;
import me.taylan.mooncore.utils.Painter;
import me.taylan.mooncore.utils.StatsManager;

public class EntityHealthListener implements Listener {
	private MoonCore plugin;
	private ItemHandler itemHandler;
	private StatsManager stats;

	public EntityHealthListener(MoonCore plugin) {
		this.plugin = plugin;
		this.itemHandler = plugin.getItemHandler();
		this.stats = plugin.getStatsManager();
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void entityregainhealth(EntityRegainHealthEvent event) {
		Entity entity = event.getEntity();
		if (!(entity instanceof Player)) {
			return;
		}
		Player player = (Player) entity;
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
	}

}
