package net.passerines.avians;

import net.passerines.avians.element.elementalDamage.ElementalDamage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class DeathEvent extends Event {
   private final ElementalDamage elementalDamage;
   private static final HandlerList HANDLER_LIST = new HandlerList();

   public DeathEvent(ElementalDamage elementalDamage) {
      this.elementalDamage = elementalDamage;
   }

   public void apply() {
      Bukkit.getPluginManager().callEvent(this);
   }

   public Entity getDeadVictim() {
      return this.elementalDamage.getVictim();
   }

   public ElementalDamage getElementalDamage() {
      return this.elementalDamage;
   }

   @NotNull
   public HandlerList getHandlers() {
      return HANDLER_LIST;
   }

   public static HandlerList getHandlerList() {
      return HANDLER_LIST;
   }
}
