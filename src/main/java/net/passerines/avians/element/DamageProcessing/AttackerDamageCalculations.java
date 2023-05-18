package net.passerines.avians.element.DamageProcessing;

import net.passerines.avians.AvianElements;
import net.passerines.avians.EntityData;
import net.passerines.avians.EntityMap;
import net.passerines.avians.PlayerData;
import net.passerines.avians.constants.AttackType;
import net.passerines.avians.element.elementalDamage.ElementalDamage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class AttackerDamageCalculations implements Listener {
    float damage;
    String type;
    public AttackerDamageCalculations(){
        Bukkit.getPluginManager().registerEvents(this, AvianElements.inst());
    }
    @EventHandler
    public void calculateMastery(ElementalDamageEvent event){
        type = event.getType();
        ElementalDamage elementalDamage = event.getElementalDamage();
        Entity attacker = event.getElementalDamage().getAttacker();

        if(attacker instanceof Player player) {
            PlayerData playerData = ((PlayerData) EntityMap.get(player));
            float hitDamage = elementalDamage.getAmount();
            switch (event.getType()) {
                case AttackType.ARCANE -> damage = hitDamage * (100 + playerData.getArcaneMastery())/100;
                case AttackType.BLADED -> damage = hitDamage * (100 + playerData.getBladedMastery())/100;
                case AttackType.BLUNTED -> damage = hitDamage * (100 + playerData.getBluntMastery())/100;
                case AttackType.POLEARMS -> damage = hitDamage * (100 + playerData.getPointedMastery())/100;
                case AttackType.RANGED -> damage = hitDamage * (100 + playerData.getRangedMastery())/100;
            }
        }
        calculateStats(event);
    }
    public void calculateStats(ElementalDamageEvent event){
        EntityData entityData = EntityMap.get(event.getElementalDamage().getAttacker());
        switch (type) {
            case AttackType.ARCANE -> damage = damage * (1000 + entityData.getMaxMana())/1000;
            case AttackType.BLADED, AttackType.BLUNTED, AttackType.POLEARMS -> damage = damage * (100 + entityData.getStrength())/100;
            case AttackType.RANGED -> damage = damage * (100 + entityData.getDexterity())/100;
        }
    }
}
