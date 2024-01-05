package net.passerines.avians.events;

import net.passerines.avians.AvianElements;
import net.passerines.avians.EntityMap;
import net.passerines.avians.PlayerData;
import net.passerines.avians.events.slotstatsystem.SlotHashmap;
import net.passerines.avians.util.Cooldown;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class ItemChangeListener implements Listener {
   Cooldown cd = new Cooldown(1);

   public ItemChangeListener() {
      Bukkit.getPluginManager().registerEvents(this, AvianElements.inst());
   }

   @EventHandler
   public void onEquipmentChange(ItemChangeEvent changeEvent) {
      if (this.cd.isOffCooldownAndAdd(changeEvent.getPlayer())) {
         Bukkit.getScheduler().scheduleSyncDelayedTask(AvianElements.inst(), () -> {
            changeEvent.getPlayer().sendMessage("Equipment has been changed");
            PlayerData player = (PlayerData)EntityMap.get(changeEvent.getPlayer());
            player.setMaxHealth(100);
            player.setHealthRegen(0.0F);
            player.setMaxMana(100);
            player.setManaRegen(1.0D);
            player.setCritChance(5.0F);
            player.setCritDamage(50);
            player.setCritExecutionRate(0.01D);
            player.setStrength(0);
            player.setDefense(0.0F);
            player.setSpeed(1.0D);
            player.getSlotHashmap().setAllSlots();
            SlotHashmap.Slot[] var2 = SlotHashmap.Slot.values();
            int var3 = var2.length;

            for(int var4 = 0; var4 < var3; ++var4) {
               SlotHashmap.Slot slot = var2[var4];
               player.calculate(player.getSlotHashmap().getItemAtSlot(slot));
            }

         }, 1L);
      }

   }
}
