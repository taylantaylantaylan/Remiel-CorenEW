package me.taylan.mooncore.alchemy;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.inventory.ItemStack;

public class BrewingStandData {
  private final Map<Integer, Boolean> potionSlots;
  
  private final ItemStack ingredient;
  
  public BrewingStandData(ItemStack ingredient) {
    this.potionSlots = new HashMap<>();
    this.ingredient = ingredient;
  }
  
  public boolean isSlotBrewed(int slot) {
    return ((Boolean)this.potionSlots.getOrDefault(Integer.valueOf(slot), Boolean.valueOf(false))).booleanValue();
  }
  
  public void setSlotBrewed(int slot, boolean isSlotBrewed) {
    this.potionSlots.put(Integer.valueOf(slot), Boolean.valueOf(isSlotBrewed));
  }
  
  public ItemStack getIngredient() {
    return this.ingredient;
  }
}
