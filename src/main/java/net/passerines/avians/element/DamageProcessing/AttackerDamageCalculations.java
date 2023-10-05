package net.passerines.avians.element.DamageProcessing;

import net.passerines.avians.AvianElements;
import net.passerines.avians.EntityData;
import net.passerines.avians.EntityMap;
import net.passerines.avians.PlayerData;
import net.passerines.avians.constants.AttackType;
import net.passerines.avians.element.elementalDamage.ElementalDamage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class AttackerDamageCalculations implements Listener {
    public AttackerDamageCalculations(){
        Bukkit.getPluginManager().registerEvents(this, AvianElements.inst());
    }
    @EventHandler(priority = EventPriority.LOWEST)
    public void calculateMastery(ElementalDamageEvent event){
        ElementalDamage elementalDamage = event.getElementalDamage();
        Entity attacker = event.getElementalDamage().getAttacker();
        float damage = elementalDamage.getAmount();
        if(attacker instanceof Player player) {
            PlayerData playerData = ((PlayerData) EntityMap.get(player));
            switch (event.getType()) {
                case AttackType.ARCANE -> damage = damage * (100 + playerData.getArcaneMastery())/100;
                case AttackType.BLADED -> damage = damage * (100 + playerData.getBladedMastery())/100;
                case AttackType.BLUNTED -> damage = damage * (100 + playerData.getBluntMastery())/100;
                case AttackType.POLEARM -> damage = damage * (100 + playerData.getPointedMastery())/100;
                case AttackType.RANGED -> damage = damage * (100 + playerData.getRangedMastery())/100;
            }
        }
        else{
            if(event.getElementalDamage().getAttacker() instanceof LivingEntity){

            }
        }
        elementalDamage.setAmount(damage);

        calculateStats(event);
    }
    public void calculateStats(ElementalDamageEvent event){
        EntityData entityData = EntityMap.get(event.getElementalDamage().getAttacker());
        float damage = event.getElementalDamage().getAmount();
        switch (event.getElementalDamage().getType()) {
            case AttackType.ARCANE -> damage = damage * (1000 + entityData.getMaxMana())/1000;
            case AttackType.BLADED, AttackType.BLUNTED, AttackType.POLEARM -> damage = damage * (100 + entityData.getStrength())/100;
            case AttackType.RANGED -> damage = damage * (100 + entityData.getDexterity())/100;
        }
        event.getElementalDamage().setAmount(damage);
    }
}
