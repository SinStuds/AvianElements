package net.passerines.avians;

import net.passerines.avians.util.Util;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class DeathEventListener implements Listener {
   public DeathEventListener() {
      Bukkit.getPluginManager().registerEvents(this, AvianElements.inst());
   }

   @EventHandler
   public void onDeathEvent(DeathEvent deathEvent) {
      Entity victim = deathEvent.getDeadVictim();
      if (victim instanceof Player player) {
          Util.log("Player died " + player.getName());
         ItemStack[] var4 = player.getInventory().getContents();
         int var5 = var4.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            ItemStack itemStack = var4[var6];
            if (itemStack != null) {
               player.getWorld().dropItem(player.getLocation(), itemStack);
            }
         }

         PlayerData playerData = (PlayerData)EntityMap.get(player);
         playerData.setHealth(playerData.getMaxHealth() / 4);
         if (player.getBedSpawnLocation() != null) {
            player.teleport(player.getBedSpawnLocation());
         } else {
            player.teleport(player.getWorld().getSpawnLocation());
         }
      } else {
         LivingEntity le = (LivingEntity)victim;
         EntityMap.remove(victim);
         Util.log("Registered Mob Died: " + victim.getName());
         EntityMap.remove(victim);
         le.damage(99999.0D);
         victim.remove();
      }

   }
}
