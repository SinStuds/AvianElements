package net.passerines.avians.element.DamageProcessing;

import net.passerines.avians.AvianElements;
import net.passerines.avians.EntityData;
import net.passerines.avians.EntityMap;
import net.passerines.avians.PlayerData;
import net.passerines.avians.constants.AttackType;
import net.passerines.avians.element.elementalDamage.ElementalDamage;
import net.passerines.avians.util.Util;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class AttackerDamageCalculations implements Listener {
   public AttackerDamageCalculations() {
      Bukkit.getPluginManager().registerEvents(this, AvianElements.inst());
   }

   @EventHandler(
      priority = EventPriority.LOWEST
   )
   public void calculateMastery(ElementalDamageEvent event) {
      if (event.getElementalDamage().getAttacker() != null) {
         ElementalDamage elementalDamage = event.getElementalDamage();
         Entity attacker = event.getElementalDamage().getAttacker();
         float damage = elementalDamage.getAmount();
         if (attacker instanceof Player player) {
            PlayerData playerData = (PlayerData) EntityMap.get(player);
            String type = event.getType();
            switch (type) {
               case AttackType.ARCANE:
                  damage = damage * (float) (100 + playerData.getArcaneMastery()) / 100.0F;
                  break;
               case AttackType.BLADED:
                  damage = damage * (float) (100 + playerData.getBladedMastery()) / 100.0F;
                  break;
               case AttackType.BLUNTED:
                  damage = damage * (float) (100 + playerData.getBluntMastery()) / 100.0F;
                  break;
               case AttackType.POLEARM:
                  damage = damage * (float) (100 + playerData.getPointedMastery()) / 100.0F;
                  break;
               case AttackType.RANGED:
                  damage = damage * (float) (100 + playerData.getRangedMastery()) / 100.0F;
            }
         } else if (event.getElementalDamage().getAttacker() instanceof LivingEntity) {
            Util.log("Damage Dealt but not a player");
         }

         elementalDamage.setAmount(damage);
         this.calculateStats(event);
      }
      else {
         Util.log("Environmental Damage to: " + event.getElementalDamage().getVictim() + " for " + event.getElementalDamage().getAmount());

      }   }

   public void calculateStats(ElementalDamageEvent event) {
   }
}
