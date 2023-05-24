package net.passerines.avians.element.DamageProcessing;

import net.passerines.avians.AvianElements;
import net.passerines.avians.EntityData;
import net.passerines.avians.EntityMap;
import net.passerines.avians.constants.AttackType;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class VictimCalculations implements Listener {
    public VictimCalculations() {
        Bukkit.getPluginManager().registerEvents(this, AvianElements.inst());
    }
    @EventHandler(priority = EventPriority.HIGHEST)
    public void calculateStats(ElementalDamageEvent event){
        subtractHealth(event);
    }

    public void subtractHealth (ElementalDamageEvent event){
        EntityData entityData = EntityMap.get(event.getElementalDamage().getVictim());
        entityData.setHealth(entityData.getHealth() - event.getElementalDamage().getAmount());
    }
}
