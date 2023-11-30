package net.passerines.avians.events.slotstatsystem;

import com.comphenix.protocol.PacketType;
import net.passerines.avians.EntityMap;
import net.passerines.avians.PlayerData;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class  SlotHashmap {
    private final Player player;
    public enum Slot {
        HELMET,
        CHESTPLATE,
        LEGGINGS,
        BOOTS,
        MAINHAND,
        OFFHAND,

    }
    private HashMap<Slot, ItemStack> slots;
    public SlotHashmap(Player player){
        this.player=player;
        slots = new HashMap<>();
    }
    public ItemStack getItemAtSlot(Slot slot){
        return slots.get(slot);
    }
    public void setSlots(Slot slot, ItemStack item) {
        slots.put(slot, item);
    }
    public void setAllSlots(){
        PlayerData playerData = (PlayerData) EntityMap.get(player);
        playerData.getSlotHashmap().setSlots(SlotHashmap.Slot.HELMET, player.getInventory().getHelmet());
        playerData.getSlotHashmap().setSlots(SlotHashmap.Slot.CHESTPLATE, player.getInventory().getChestplate());
        playerData.getSlotHashmap().setSlots(SlotHashmap.Slot.LEGGINGS, player.getInventory().getLeggings());
        playerData.getSlotHashmap().setSlots(SlotHashmap.Slot.BOOTS, player.getInventory().getBoots());
        playerData.getSlotHashmap().setSlots(SlotHashmap.Slot.MAINHAND, player.getInventory().getItemInMainHand());
        playerData.getSlotHashmap().setSlots(SlotHashmap.Slot.OFFHAND, player.getInventory().getItemInOffHand());
    }
}
