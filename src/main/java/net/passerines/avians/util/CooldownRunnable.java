package net.passerines.avians.util;

import java.util.HashMap;
import java.util.Iterator;
import net.passerines.avians.AvianElements;
import org.bukkit.Bukkit;

public class CooldownRunnable<T> {
   private int defaultCooldown;
   private HashMap<T, Pair<Integer, Integer>> cooldowns = new HashMap();

   public CooldownRunnable(int defaultCooldownTicks) {
      this.defaultCooldown = defaultCooldownTicks;
   }

   public void add(T target) {
      this.add(target, this.defaultCooldown);
   }

   public void add(T target, int ticks) {
      this.add(target, ticks, (Runnable)null);
   }

   public void add(T target, Runnable onEnd) {
      this.add(target, this.defaultCooldown, onEnd);
   }

   public void add(T target, int ticks, Runnable onEnd) {
      if (this.cooldowns.containsKey(target)) {
         Bukkit.getScheduler().cancelTask((Integer)((Pair)this.cooldowns.get(target)).getKey());
      }

      this.cooldowns.put(target, new Pair(Bukkit.getScheduler().scheduleSyncDelayedTask(AvianElements.inst(), () -> {
         this.cooldowns.remove(target);
         if (onEnd != null) {
            onEnd.run();
         }

      }, (long)ticks), Bukkit.getCurrentTick() + ticks));
   }

   public void appendTask(T target, Runnable onEnd) {
      if (this.cooldowns.containsKey(target)) {
         Bukkit.getScheduler().cancelTask((Integer)((Pair)this.cooldowns.get(target)).getKey());
         this.cooldowns.put(target, new Pair(Bukkit.getScheduler().scheduleSyncDelayedTask(AvianElements.inst(), () -> {
            this.cooldowns.remove(target);
            if (onEnd != null) {
               onEnd.run();
            }

         }, (long)this.getTicksLeft(target)), Bukkit.getCurrentTick() + this.getTicksLeft(target)));
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

   public void clear() {
      Iterator var1 = this.cooldowns.keySet().iterator();

      while(var1.hasNext()) {
         T target = var1.next();
         if (this.cooldowns.containsKey(target)) {
            Bukkit.getScheduler().cancelTask((Integer)((Pair)this.cooldowns.get(target)).getKey());
         }
      }

   }

   public int getDefaultCooldown() {
      return this.defaultCooldown;
   }
}
