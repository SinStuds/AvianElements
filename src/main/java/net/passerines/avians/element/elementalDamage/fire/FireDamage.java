package net.passerines.avians.element.elementalDamage.fire;

import net.passerines.avians.AvianElements;
import net.passerines.avians.EntityMap;
import net.passerines.avians.element.elementalDamage.ElementalDamage;
import net.passerines.avians.element.elementalDamage.StatusEffects;
import net.passerines.avians.element.elements.Element;
import org.bukkit.entity.Entity;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.concurrent.atomic.AtomicInteger;

public class FireDamage extends ElementalDamage {


    public final int burningPercentage;//Chance
    public final int burnTicks;
    public FireDamage(Entity attacker, Entity victim, float amount, int burningPercentage, int burnTicks){
        super(Element.FIRE, attacker, victim, amount);
        this.burningPercentage = burningPercentage;
        this.burnTicks = burnTicks;
    }
    @Override
    public void onHit() {
        if(Math.random()*100 < burningPercentage) {
            StatusEffects status = EntityMap.get(victim).getStatusEffects();
            victim.setVisualFire(true);
            status.setBurnTicksRemaining(burnTicks);
            BukkitRunnable burn = new BukkitRunnable() {
                @Override
                public void run() {
                    if(!(status.getBurnTicksRemaining() <= 0) && !victim.isInWater()){
                        status.setBurnTicksRemaining(status.getBurnTicksRemaining()-5);

                    }
                    else{
                        victim.setVisualFire(false);
                        this.cancel();
                    }
                }
            };
            burn.runTaskTimer(AvianElements.inst(), 0, 5);
            status.setFire(burn);
        }
    }
}
