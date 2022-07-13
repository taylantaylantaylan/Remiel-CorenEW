package me.taylan.mooncore.custommining;

import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.block.Block;


import java.util.HashMap;
import java.util.Map;

public class BrokenBlocksService {
/*
    @Getter
    private static Map<Location, BrokenBlock> brokenBlocks = new HashMap<>();

    public void createBrokenBlock(Block block) {
        createBrokenBlock(block, -1);
    }

    public void createBrokenBlock(Block block, int time) {
        if (isBrokenBlock(block.getLocation())) return;
        BrokenBlock brokenBlock;
        if (time == -1) brokenBlock = new BrokenBlock(block);
        else brokenBlock = new BrokenBlock(block, time);
        brokenBlocks.put(block.getLocation(), brokenBlock);
    }

    public void removeBrokenBlock(Location location) {
        brokenBlocks.remove(location);
    }

    public BrokenBlock getBrokenBlock(Location location) {
        createBrokenBlock(location.getBlock());
        return brokenBlocks.get(location);
    }

    public boolean isBrokenBlock(Location location) {
        return brokenBlocks.containsKey(location);
    }
    */
}
