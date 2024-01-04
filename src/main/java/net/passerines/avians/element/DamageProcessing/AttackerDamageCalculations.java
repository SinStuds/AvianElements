package net.passerines.avians.element.DamageProcessing;

import net.passerines.avians.AvianElements;
import net.passerines.avians.EntityData;
import net.passerines.avians.EntityMap;
import net.passerines.avians.PlayerData;
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
      ElementalDamage elementalDamage = event.getElementalDamage();
      Entity attacker = event.getElementalDamage().getAttacker();
      float damage = elementalDamage.getAmount();
      if (attacker instanceof Player) {
         Player player = (Player)attacker;
         PlayerData playerData = (PlayerData)EntityMap.get(player);
         String var7 = event.getType();
         byte var8 = -1;
         switch(var7.hashCode()) {
         case -1409612218:
            if (var7.equals("arcane")) {
               var8 = 0;
            }
            break;
         case -1386581172:
            if (var7.equals("bladed")) {
               var8 = 1;
            }
            break;
         case -938283321:
            if (var7.equals("ranged")) {
               var8 = 4;
            }
            break;
         case -398121052:
            if (var7.equals("polearm")) {
               var8 = 3;
            }
            break;
         case -15560496:
            if (var7.equals("blunted")) {
               var8 = 2;
            }
         }

         switch(var8) {
         case 0:
            damage = damage * (float)(100 + playerData.getArcaneMastery()) / 100.0F;
            break;
         case 1:
            damage = damage * (float)(100 + playerData.getBladedMastery()) / 100.0F;
            break;
         case 2:
            damage = damage * (float)(100 + playerData.getBluntMastery()) / 100.0F;
            break;
         case 3:
            damage = damage * (float)(100 + playerData.getPointedMastery()) / 100.0F;
            break;
         case 4:
            damage = damage * (float)(100 + playerData.getRangedMastery()) / 100.0F;
         }
      } else if (event.getElementalDamage().getAttacker() instanceof LivingEntity) {
         Util.log("Damage Dealt but not a player");
      }

      elementalDamage.setAmount(damage);
      this.calculateStats(event);
   }

   public void calculateStats(ElementalDamageEvent event) {
      EntityData entityData = EntityMap.get(event.getElementalDamage().getAttacker());
      float damage = event.getElementalDamage().getAmount();
      String var4 = event.getElementalDamage().getType();
      byte var5 = -1;
      switch(var4.hashCode()) {
      case -1409612218:
         if (var4.equals("arcane")) {
            var5 = 0;
         }
         break;
      case -1386581172:
         if (var4.equals("bladed")) {
            var5 = 1;
         }
         break;
      case -938283321:
         if (var4.equals("ranged")) {
            var5 = 4;
         }
         break;
      case -398121052:
         if (var4.equals("polearm")) {
            var5 = 3;
         }
         break;
      case -15560496:
         if (var4.equals("blunted")) {
            var5 = 2;
         }
      }

      switch(var5) {
      case 0:
         damage = damage * (float)(1000 + entityData.getMaxMana()) / 1000.0F;
         break;
      case 1:
      case 2:
      case 3:
         damage = damage * (float)(100 + entityData.getStrength()) / 100.0F;
         break;
      case 4:
         damage = damage * (float)(100 + entityData.getDexterity()) / 100.0F;
      }

      event.getElementalDamage().setAmount(damage);
   }
}
