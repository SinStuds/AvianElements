package net.passerines.avians.element.DamageProcessing;

import net.passerines.avians.element.elementalDamage.ElementalDamage;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class ElementalDamageEvent extends Event implements Cancellable {
   private static final HandlerList HANDLER_LIST = new HandlerList();
   private boolean cancelled;
   private ElementalDamage elementalDamage;

   public ElementalDamageEvent(ElementalDamage elementalDamage) {
      this.elementalDamage = elementalDamage;
   }

   public ElementalDamage getElementalDamage() {
      return this.elementalDamage;
   }

   public ElementalDamageEvent setElementalDamage(ElementalDamage elementalDamage) {
      this.elementalDamage = elementalDamage;
      return this;
   }

   public String getType() {
      return this.elementalDamage.getType();
   }

   public boolean isCancelled() {
      return this.cancelled;
   }

   public void setCancelled(boolean cancel) {
      this.cancelled = cancel;
   }

   @NotNull
   public HandlerList getHandlers() {
      return HANDLER_LIST;
   }

   public static HandlerList getHandlerList() {
      return HANDLER_LIST;
   }
}
