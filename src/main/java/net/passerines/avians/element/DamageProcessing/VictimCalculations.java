package net.passerines.avians.element.DamageProcessing;

import net.passerines.avians.AvianElements;
import net.passerines.avians.DeathEvent;
import net.passerines.avians.EntityData;
import net.passerines.avians.EntityMap;
import net.passerines.avians.util.Util;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class VictimCalculations implements Listener {
   public VictimCalculations() {
      Bukkit.getPluginManager().registerEvents(this, AvianElements.inst());
   }

   @EventHandler(
      priority = EventPriority.MONITOR
   )
   public void calculateStats(ElementalDamageEvent event) {
      this.subtractHealth(event);
   }

   public void subtractHealth(ElementalDamageEvent event) {
      EntityData entityData = EntityMap.get(event.getElementalDamage().getVictim());
      int entityHealth;
      if (entityData.getHealth() - event.getElementalDamage().getAmount() <= 0) {
         entityHealth = entityData.getMaxHealth();
         Util.log("Max Health: " + entityHealth + " Current Health: " + entityData.getHealth());
         DeathEvent death = new DeathEvent(event.getElementalDamage());
         death.apply();
      } else {
         entityData.setHealth(entityData.getHealth() - event.getElementalDamage().getAmount());
         entityHealth = entityData.getMaxHealth();
         Util.log("Max Health: " + entityHealth + " Current Health: " + entityData.getHealth());
      }

   }
}
