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

public class EntityDamageConverter implements Listener {
   public EntityDamageConverter() {
      Bukkit.getPluginManager().registerEvents(this, AvianElements.inst());
   }

   @EventHandler(
      ignoreCancelled = true
   )
   public void damageReceiver(EntityDamageByEntityEvent event) {
      Util.log("entity damage by entity");
      String var10000;
      if (MythicMobsUtil.getActiveMob(event.getEntity()) != null) {
         Util.log("is active mob");
         ActiveMob activeMob = MythicMobsUtil.getActiveMob(event.getEntity());
         switch(EntityMap.get(event.getEntity()).getElement()) {
         case FIRE:
            (new FireDamage(event.getDamager(), activeMob.getEntity().getBukkitEntity(), (float)event.getDamage(), 10, 60)).apply();
            var10000 = event.getDamager().getType().name();
            Util.log(var10000 + " dealt " + event.getDamage() + " damage to " + event.getEntity().getName());
            break;
         default:
            (new FireDamage(event.getDamager(), activeMob.getEntity().getBukkitEntity(), (float)event.getDamage(), 10, 60)).apply();
            var10000 = event.getDamager().getType().name();
            Util.log(var10000 + " dealt " + event.getDamage() + " damage to " + event.getEntity().getName());
         }
      } else {
         Entity var4 = event.getEntity();
         if (var4 instanceof Player) {
            Player player = (Player)var4;
            (new FireDamage(event.getDamager(), player, (float)event.getDamage(), 10, 60)).apply();
            var10000 = event.getDamager().getType().name();
            Util.log(var10000 + " dealt " + event.getDamage() + " damage to " + event.getEntity().getName());
         }
      }

      event.setDamage(0.0D);
   }
}
