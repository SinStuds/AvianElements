package net.passerines.avians.element.DamageProcessing;

import net.passerines.avians.EntityData;
import net.passerines.avians.EntityMap;
import net.passerines.avians.constants.AttackType;

public class VictimCalculations {
    public void calculateStats(ElementalDamageEvent event){
        EntityData entityData = EntityMap.get(event.getElementalDamage().getAttacker());

    }
}
