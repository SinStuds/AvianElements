package net.passerines.avians.element.elementalDamage.fire;

import net.passerines.avians.AvianElements;
import net.passerines.avians.EntityMap;
import net.passerines.avians.element.elementalDamage.ElementalDamage;
import net.passerines.avians.element.elementalDamage.StatusEffects;
import net.passerines.avians.element.elements.Element;
import org.bukkit.entity.Entity;
import org.bukkit.scheduler.BukkitRunnable;

public class FireDamage extends ElementalDamage {
   public final int burningPercentage;
   public final int burnTicks;

   public FireDamage(Entity attacker, Entity victim, float amount, int burningPercentage, int burnTicks) {
      super(Element.FIRE, attacker, victim, amount);
      this.burningPercentage = burningPercentage;
      this.burnTicks = burnTicks;
   }

   public void onHit() {
      if (Math.random() * 100.0D < (double)this.burningPercentage) {
         final StatusEffects status = EntityMap.get(this.victim).getStatusEffects();
         this.victim.setVisualFire(true);
         status.setBurnTicksRemaining(this.burnTicks);
         BukkitRunnable burn = new BukkitRunnable() {
            public void run() {
               if (status.getBurnTicksRemaining() > 0 && !FireDamage.this.victim.isInWater()) {
                  status.setBurnTicksRemaining(status.getBurnTicksRemaining() - 5);
               } else {
                  FireDamage.this.victim.setVisualFire(false);
                  this.cancel();
               }

            }
         };
         burn.runTaskTimer(AvianElements.inst(), 0L, 5L);
         status.setFire(burn);
      }

   }
}
