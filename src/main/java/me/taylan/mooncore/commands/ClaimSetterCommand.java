package me.taylan.mooncore.commands;

import me.taylan.mooncore.MoonCore;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class ClaimSetterCommand implements CommandExecutor {

    private final MoonCore plugin;
    private List<Location> loclist = new ArrayList<>();
    private List<Block> blocklist = new ArrayList<>();

    private HashMap<Player, List<Location>> binakey = new HashMap<>();
    private HashMap<Player, List<Block>> binakey2 = new HashMap<>();


    public ClaimSetterCommand(MoonCore plugin) {
        this.plugin = plugin;
        Objects.requireNonNull(plugin.getCommand("claimset")).setExecutor(this);
    }

    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player)) {
            return true;
        }

        Player p = (Player) sender;

        if (p.hasPermission("claim")) {
            p.sendMessage("Bu komut calışmaz.");
			/*if (args.length == 0) {
				Chunk chunk = p.getChunk();
				ChunkSnapshot bina = chunk.getChunkSnapshot();
				for (int x = 0; x < 16; x++) {
					for (int z = 0; z < 16; z++) {
						for (int y = 1; y < 256; y++) {
							Material type = bina.getBlockType(x, y, z);
							if (Tag.STONE_BRICKS.isTagged(type) || Tag.WALLS.isTagged(type)
									|| Tag.WALL_POST_OVERRIDE.isTagged(type) || Tag.SLABS.isTagged(type)
									|| Tag.WOODEN_TRAPDOORS.isTagged(type) || Tag.CARPETS.isTagged(type)
									|| type == Material.COARSE_DIRT || type == Material.COBBLESTONE
									|| Tag.STAIRS.isTagged(type) || type == Material.GRASS_BLOCK
									|| type == Material.MOSS_BLOCK || type == Material.BARREL
									|| type == Material.ANDESITE || type == Material.OXIDIZED_CUT_COPPER
									|| type == Material.MOSS_CARPET || type == Material.OAK_PLANKS
									|| type == Material.GRASS || type == Material.TALL_GRASS || type == Material.FERN
									|| type == Material.LARGE_FERN) {
								Location loc = new Location(Bukkit.getWorld("world"), bina.getX() * 16 + x, y,
										bina.getZ() * 16 + z);
								blocklist.add(chunk.getBlock(x, y, z));
								binakey2.put(p, blocklist);
								loclist.add(loc);
								chunk.getBlock(x, y, z).setType(Material.AIR);

								if (y == 256) {
									binakey.put(p, loclist);

								}

							}
						}
					}
				}
			} else if (args.length > 0) {
				if (binakey.containsKey(p)) {
					for (Location loc : binakey.get(p)) {
						
					}
				}
			}*/

        }
        return false;
    }

}
