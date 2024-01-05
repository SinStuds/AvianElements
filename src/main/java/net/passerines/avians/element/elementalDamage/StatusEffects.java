package net.passerines.avians.element.elementalDamage;

import org.bukkit.scheduler.BukkitRunnable;

public class StatusEffects {
   private BukkitRunnable fire;
   private int burnTicksRemaining;
   private BukkitRunnable water;
   private BukkitRunnable earth;
   private BukkitRunnable lightning;
   private BukkitRunnable curse;
   private BukkitRunnable holy;

   public BukkitRunnable getFire() {
      return this.fire;
   }

   public void setFire(BukkitRunnable fire) {
      this.fire = fire;
   }

   public int getBurnTicksRemaining() {
      return this.burnTicksRemaining;
   }

   public void setBurnTicksRemaining(int burnTicksRemaining) {
      this.burnTicksRemaining = burnTicksRemaining;
   }

   public BukkitRunnable getWater() {
      return this.water;
   }

   public void setWater(BukkitRunnable water) {
      this.water = water;
   }

   public BukkitRunnable getEarth() {
      return this.earth;
   }

   public void setEarth(BukkitRunnable earth) {
      this.earth = earth;
   }

   public BukkitRunnable getLightning() {
      return this.lightning;
   }

   public void setLightning(BukkitRunnable lightning) {
      this.lightning = lightning;
   }

   public BukkitRunnable getCurse() {
      return this.curse;
   }

   public void setCurse(BukkitRunnable curse) {
      this.curse = curse;
   }

   public BukkitRunnable getHoly() {
      return this.holy;
   }

   public void setHoly(BukkitRunnable holy) {
      this.holy = holy;
   }
}
