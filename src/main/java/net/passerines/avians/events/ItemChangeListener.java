package net.passerines.avians.events;

import net.passerines.avians.AvianElements;
import net.passerines.avians.EntityMap;
import net.passerines.avians.PlayerData;
import net.passerines.avians.events.slotstatsystem.SlotHashmap;
import org.bukkit.Bukkit;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class ItemChangeListener implements Listener {
    public ItemChangeListener() {
        Bukkit.getPluginManager().registerEvents(this, AvianElements.inst());
    }
    @EventHandler
    public void onEquipmentChange(ItemChangeEvent changeEvent){
        changeEvent.getPlayer().sendMessage("Equipment has been changed");
        PlayerData player = (PlayerData) EntityMap.get(changeEvent.getPlayer());
        player.getSlotHashmap().setAllSlots();
        player.setMaxHealth(100);
        player.setStrength(0);
        player.setDefense(0);
        player.setSpeed(1);
        for (SlotHashmap.Slot slot: SlotHashmap.Slot.values()) {
            player.calculate(player.getSlotHashmap().getItemAtSlot(slot));
        }
    }
}
