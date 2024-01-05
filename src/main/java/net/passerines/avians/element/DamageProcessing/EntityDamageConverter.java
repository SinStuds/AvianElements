package net.passerines.avians.element.DamageProcessing;

import io.lumine.mythic.core.mobs.ActiveMob;
import net.passerines.avians.AvianElements;
import net.passerines.avians.EntityMap;
import net.passerines.avians.element.elementalDamage.fire.FireDamage;
import net.passerines.avians.util.MythicMobsUtil;
import net.passerines.avians.util.Util;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamageConverter implements Listener {
   public EntityDamageConverter() {
      Bukkit.getPluginManager().registerEvents(this, AvianElements.inst());
   }
   @EventHandler
   public void entityDamageEvent(EntityDamageEvent event){
      (new FireDamage(null, event.getEntity(), (float)event.getDamage(), 10, 60)).apply();
      event.setDamage(0);
   }
   @EventHandler(
      ignoreCancelled = true
   )
   public void damageReceiver(EntityDamageByEntityEvent event) {
      Util.log("entity damage by entity");
      String damager;
      if (MythicMobsUtil.getActiveMob(event.getEntity()) != null) {
         Util.log("is active mob");
         ActiveMob activeMob = MythicMobsUtil.getActiveMob(event.getEntity());
         switch(EntityMap.get(event.getEntity()).getElement()) {
         case FIRE:
            (new FireDamage(event.getDamager(), activeMob.getEntity().getBukkitEntity(), (float)event.getDamage(), 10, 60)).apply();
            damager = event.getDamager().getType().name();
            Util.log(damager + " dealt " + event.getDamage() + " damage to " + event.getEntity().getName());
            break;
         default:
            (new FireDamage(event.getDamager(), activeMob.getEntity().getBukkitEntity(), (float)event.getDamage(), 10, 60)).apply();
            damager = event.getDamager().getType().name();
            Util.log(damager + " dealt " + event.getDamage() + " damage to " + event.getEntity().getName());
         }
      } else {
         if (event.getEntity() instanceof Player player) {
             (new FireDamage(event.getDamager(), player, (float)event.getDamage(), 10, 60)).apply();
            damager = event.getDamager().getType().name();
            Util.log(damager + " dealt " + event.getDamage() + " damage to " + event.getEntity().getName());
         }
      }

      event.setDamage(0);
   }
}
