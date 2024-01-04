package net.passerines.avians.util;

import java.util.HashMap;
import net.passerines.avians.AvianElements;
import org.bukkit.Bukkit;

public class Cooldown<T> {
   private int defaultCooldown;
   private HashMap<T, Pair<Integer, Integer>> cooldowns = new HashMap();

   public Cooldown(int defaultCooldownTicks) {
      this.defaultCooldown = defaultCooldownTicks;
   }

   public void add(T target) {
      this.add(target, this.defaultCooldown);
   }

   public void add(T target, int ticks) {
      if (ticks > 0) {
         if (this.cooldowns.containsKey(target)) {
            Bukkit.getScheduler().cancelTask((Integer)((Pair)this.cooldowns.get(target)).getKey());
         }

         this.cooldowns.put(target, new Pair(Bukkit.getScheduler().scheduleSyncDelayedTask(AvianElements.inst(), () -> {
            this.cooldowns.remove(target);
         }, (long)ticks), Bukkit.getCurrentTick() + ticks));
      }

   }

   public boolean isOffCooldown(T target) {
      return !this.cooldowns.containsKey(target);
   }

   public boolean isOnCooldown(T target) {
      return this.cooldowns.containsKey(target);
   }

   public int getTicksLeft(T target) {
      return this.cooldowns.containsKey(target) ? (Integer)((Pair)this.cooldowns.get(target)).getValue() - Bukkit.getCurrentTick() : -1;
   }

   public boolean isOffCooldownAndAdd(T target) {
      boolean offcd = !this.cooldowns.containsKey(target);
      if (offcd) {
         this.add(target);
      }

      return offcd;
   }

   public int getDefaultCooldown() {
      return this.defaultCooldown;
   }

   public void setDefaultCooldown(int defaultCooldown) {
      this.defaultCooldown = defaultCooldown;
   }
}
