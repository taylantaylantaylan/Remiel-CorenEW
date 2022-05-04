package me.taylan.mooncore.alchemy;

import org.bukkit.block.Block;

import com.google.common.base.Objects;

public class BlockPosition {
  private final int x;
  
  private final int y;
  
  private final int z;
  
  public BlockPosition(int x, int y, int z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }
  
  public int getX() {
    return this.x;
  }
  
  public int getY() {
    return this.y;
  }
  
  public int getZ() {
    return this.z;
  }
  
  public static BlockPosition fromBlock(Block block) {
    return new BlockPosition(block.getX(), block.getY(), block.getZ());
  }
  
  public boolean equals(Object obj) {
    if (this == obj)
      return true; 
    if (obj == null)
      return false; 
    if (!(obj instanceof BlockPosition))
      return false; 
    BlockPosition other = (BlockPosition)obj;
    return (this.x == other.x && this.y == other.y && this.z == other.z);
  }
  
  public int hashCode() {
    return Objects.hashCode(new Object[] { Integer.valueOf(this.x), Integer.valueOf(this.y), Integer.valueOf(this.z) });
  }
}
