package me.taylan.mooncore.custommining;

// --Commented out by Inspection START (14.11.2022 02:08):
//public class BrokenBlock {
///*
//    private int time;
//    private int oldAnimation;
//    private double damage = -1;
//    private final Block block;
//    private long lastDamage;
//
//    public BrokenBlock(Block block, int time) {
//        this.block = block;
//        this.time = time;
//        lastDamage = System.currentTimeMillis();
//    }
//
//    public void incrementDamage(Player from, double multiplier) {
//        if (isBroken()) return;
//
//        time = event.getBrokenBlock().getTime();
//        damage = event.getBrokenBlock().getDamage();
//        multiplier = event.getMultiplier();
//
//        damage += multiplier;
//        int animation = getAnimation();
//
//        if (animation != oldAnimation) {
//            if (animation < 10) {
//                sendBreakPacket(animation);
//                lastDamage = System.currentTimeMillis();
//            } else {
//                breakBlock(from);
//                return;
//            }
//        }
//
//        oldAnimation = animation;
//    }
//
//    public boolean isBroken() {
//        return getAnimation() >= 10;
//    }
//
//    public void breakBlock(Player breaker) {
//        destroyBlockObject();
//        SoundPlayerUtils.playBlockSound(block);
//        if (breaker == null) return;
//      breaker.breakBlock(getBlockPosition(block));
//    }
//
//    public void destroyBlockObject() {
//        sendBreakPacket(-1);
//        //  Here you have to remove your BrokenBlock using the BrokenBlocksService, on the next step
//        BrokenBlocksService.removeBrokenBlock(block.getLocation());
//    }
//
//    public int getAnimation() {
//        return (int) (damage / time * 11) - 1;
//    }
//
//    public void sendBreakPacket(int animation, Block block) {
//        ((CraftServer) Bukkit.getServer()).getHandle().sendPacketNearby(null, block.getX(), block.getY(), block.getZ(), 120, ((CraftWorld) block.getLocation().getWorld()).getHandle().dimension,
//                new PacketPlayOutBlockBreakAnimation(getBlockEntityId(block), getBlockPosition(block), animation));
//    }
//
//
//    private @NotNull Block getBlockPosition(Block block) {
//        return new BlockPosition(block.getX(), block.getY(), block.getZ());
//    }
//
//    private int getBlockEntityId(Block block) {
//        return ((block.getX() & 0xFFF) << 20 | (block.getZ() & 0xFFF) << 8) | (block.getY() & 0xFF);
//    }
//*/
// --Commented out by Inspection STOP (14.11.2022 02:08)
//}