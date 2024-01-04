package net.passerines.avians.naturalhealth;

import java.util.HashMap;
import java.util.Iterator;
import net.passerines.avians.AvianElements;
import net.passerines.avians.EntityMap;
import net.passerines.avians.PlayerData;
import net.passerines.avians.element.DamageProcessing.ElementalDamageEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class NaturalHealthRegen implements Listener {
   private static final HashMap<Player, Integer> TIMER = new HashMap();

   public NaturalHealthRegen() {
      Bukkit.getScheduler().scheduleSyncRepeatingTask(AvianElements.inst(), () -> {
         Iterator var0 = Bukkit.getOnlinePlayers().iterator();

         while(var0.hasNext()) {
            Player player = (Player)var0.next();
            int newHealth = 0;
            int newMana = 0;
            PlayerData playerData = (PlayerData)EntityMap.get(player);
            if (player.getFoodLevel() == 20 && playerData.getHealth() < (double)playerData.getMaxHealth()) {
               if (player.getSaturation() > 0.0F) {
                  if ((Integer)TIMER.getOrDefault(player, -2000) <= Bukkit.getCurrentTick() - 60) {
                     newHealth = (int)Math.min((double)playerData.getMaxHealth(), playerData.getHealth() + (double)playerData.getMaxHealth() * 1.5E-4D * (double)playerData.getHealthRegen());
                     playerData.setHealth((double)newHealth);
                  }

                  newMana = (int)Math.min((double)playerData.getMaxMana(), playerData.getMana() + (double)playerData.getMaxMana() * 2.25E-4D * playerData.getManaRegen());
                  playerData.setMana((double)newMana);
                  player.setSaturation(player.getSaturation() - 1.0F);
               } else if (player.getSaturation() == 0.0F) {
                  if ((Integer)TIMER.getOrDefault(player, -2000) <= Bukkit.getCurrentTick() - 60) {
                     newHealth = (int)Math.min((double)playerData.getMaxHealth(), playerData.getHealth() + (double)playerData.getMaxHealth() * 1.5E-4D * (double)playerData.getHealthRegen());
                     playerData.setHealth((double)newHealth);
                  }

                  newMana = (int)Math.min((double)playerData.getMaxMana(), playerData.getMana() + (double)playerData.getMaxMana() * 2.25E-4D * playerData.getManaRegen());
                  playerData.setMana((double)newMana);
                  player.setFoodLevel(player.getFoodLevel() - 1);
               }
            } else {
               if ((Integer)TIMER.getOrDefault(player, -2000) <= Bukkit.getCurrentTick() - 60) {
                  newHealth = (int)Math.min((double)playerData.getMaxHealth(), playerData.getHealth() + (double)playerData.getMaxHealth() * 1.0E-4D * (double)playerData.getHealthRegen());
                  playerData.setHealth((double)newHealth);
               }

               newMana = (int)Math.min((double)playerData.getMaxMana(), playerData.getMana() + (double)playerData.getMaxMana() * 1.5E-4D * playerData.getManaRegen());
               playerData.setMana((double)newMana);
            }

            player.sendMessage("Your new health: " + newHealth);
            player.sendMessage("Your new mana: " + newMana);
         }

      }, 0L, 20L);
   }

   @EventHandler
   public void hitTimer(ElementalDamageEvent event) {
      Entity var3 = event.getElementalDamage().getVictim();
      if (var3 instanceof Player) {
         Player player = (Player)var3;
         TIMER.put(player, Bukkit.getCurrentTick());
      }

   }
}
