package net.passerines.avians.events.slotstatsystem;

import java.util.HashMap;
import net.passerines.avians.EntityMap;
import net.passerines.avians.PlayerData;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class SlotHashmap {
   private final Player player;
   private HashMap<SlotHashmap.Slot, ItemStack> slots;

   public SlotHashmap(Player player) {
      this.player = player;
      this.slots = new HashMap();
   }

   public ItemStack getItemAtSlot(SlotHashmap.Slot slot) {
      return (ItemStack)this.slots.get(slot);
   }

   public void setSlots(SlotHashmap.Slot slot, ItemStack item) {
      this.slots.put(slot, item);
   }

   public void setAllSlots() {
      PlayerData playerData = (PlayerData)EntityMap.get(this.player);
      playerData.getSlotHashmap().setSlots(SlotHashmap.Slot.HELMET, this.player.getInventory().getHelmet());
      playerData.getSlotHashmap().setSlots(SlotHashmap.Slot.CHESTPLATE, this.player.getInventory().getChestplate());
      playerData.getSlotHashmap().setSlots(SlotHashmap.Slot.LEGGINGS, this.player.getInventory().getLeggings());
      playerData.getSlotHashmap().setSlots(SlotHashmap.Slot.BOOTS, this.player.getInventory().getBoots());
      playerData.getSlotHashmap().setSlots(SlotHashmap.Slot.MAINHAND, this.player.getInventory().getItemInMainHand());
      playerData.getSlotHashmap().setSlots(SlotHashmap.Slot.OFFHAND, this.player.getInventory().getItemInOffHand());
   }

   public static enum Slot {
      HELMET,
      CHESTPLATE,
      LEGGINGS,
      BOOTS,
      MAINHAND,
      OFFHAND;

      // $FF: synthetic method
      private static SlotHashmap.Slot[] $values() {
         return new SlotHashmap.Slot[]{HELMET, CHESTPLATE, LEGGINGS, BOOTS, MAINHAND, OFFHAND};
      }
   }
}
