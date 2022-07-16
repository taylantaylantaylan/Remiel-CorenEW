package me.taylan.mooncore.commands;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Villager.Profession;


import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.listeners.entitydamage.SpawnArmorStand;
import me.taylan.mooncore.utils.Painter;
import net.kyori.adventure.text.minimessage.MiniMessage;

public class NpcCommand implements CommandExecutor {

	private MoonCore plugin;

	public NpcCommand(MoonCore plugin) {
		this.plugin = plugin;
		plugin.getCommand("npcolustur").setExecutor(this);
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (p.hasPermission("mooncore.npc")) {
				if (args.length <= 0) {
					p.sendMessage(Painter
							.paint("&cYanlış Kullanım! Doğrusu /npcolustur <npcismi> <rütbesi> <meslek> <memleket>"));
				} else if (args.length > 0) {
					String name = String.valueOf(args[0]);
					String rank = String.valueOf(args[1]);
					String meslek = String.valueOf(args[2]);
					String memleket = String.valueOf(args[3]);
					World world = p.getWorld();

					Villager villager = (Villager) world.spawnEntity(p.getLocation(), EntityType.VILLAGER);
					villager.setCustomNameVisible(true);
					villager.setVillagerLevel(1);
					villager.setVillagerExperience(1);
					villager.setProfession(Profession.valueOf(meslek));
					villager.setPersistent(true);
					villager.setVillagerType(Villager.Type.valueOf(memleket));

					villager.customName(MiniMessage.builder().build().deserialize(name));
					villager.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(-1);
					villager.getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE).setBaseValue(100);
					villager.setCollidable(false);
					ArmorStand armorStand = SpawnArmorStand.spawnArmorStand(p.getLocation().add(0,1.72,0), rank);
					

				}
			}
		}
		return false;
	}

}
