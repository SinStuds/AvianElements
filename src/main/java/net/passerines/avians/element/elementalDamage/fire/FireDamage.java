package net.passerines.avians.element.elementalDamage.fire;

import net.passerines.avians.element.elementalDamage.ElementalDamage;
import net.passerines.avians.element.elements.Element;
import org.bukkit.entity.Entity;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.concurrent.atomic.AtomicInteger;

public class FireDamage extends ElementalDamage {
    public final int burningPercentage;
    public final int burnTicks;
    public FireDamage(Entity attacker, Entity victim, float amount, int burningPercentage, int burnTicks){
        super(Element.FIRE, attacker, victim, amount);
        this.burningPercentage = burningPercentage;
        this.burnTicks = burnTicks;
    }
    @Override
    public void onHit() {
        victim.setVisualFire(true);
        AtomicInteger counter = new AtomicInteger(0);
        BukkitRunnable bukkitRunnable = new BukkitRunnable() {
            @Override
            public void run() {
                if(!(counter.get() >= burnTicks) && !victim.isInWater()){
                    counter.getAndAdd(1);
                    //victim.
                }
                else{
                    victim.setVisualFire(false);
                }
            }
        };
    }

}
