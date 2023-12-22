package net.passerines.avians.events;

import net.passerines.avians.AvianElements;
import net.passerines.avians.EntityMap;
import net.passerines.avians.PlayerData;
import net.passerines.avians.events.slotstatsystem.SlotHashmap;
import net.passerines.avians.util.Cooldown;
import org.bukkit.Bukkit;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class ItemChangeListener implements Listener {
    Cooldown cd = new Cooldown<>(1);
    public ItemChangeListener() {
        Bukkit.getPluginManager().registerEvents(this, AvianElements.inst());
    }
    @EventHandler
    public void onEquipmentChange(ItemChangeEvent changeEvent){
        if(cd.isOffCooldownAndAdd(changeEvent.getPlayer())) {
            Bukkit.getScheduler().scheduleSyncDelayedTask(AvianElements.inst(), ()->{
                changeEvent.getPlayer().sendMessage("Equipment has been changed");
                PlayerData player = (PlayerData) EntityMap.get(changeEvent.getPlayer());

                player.setMaxHealth(100);
                player.setHealthRegen(0);
                player.setMaxMana(100);
                player.setManaRegen(1);
                player.setCritChance(5);
                player.setCritDamage(50);
                player.setCritExecutionRate(0.01);
                player.setStrength(0);
                player.setDefense(0);
                player.setSpeed(1);


                player.getSlotHashmap().setAllSlots();
                for (SlotHashmap.Slot slot : SlotHashmap.Slot.values()) {
                    player.calculate(player.getSlotHashmap().getItemAtSlot(slot));
                }
            }, 1);
        }
    }
}
