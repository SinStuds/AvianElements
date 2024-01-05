package net.passerines.avians.element.elementalDamage;

import net.passerines.avians.element.DamageProcessing.ElementalDamageEvent;
import net.passerines.avians.element.elements.Element;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;

public abstract class ElementalDamage {
   protected Element element;
   protected Entity attacker;
   protected Entity victim;
   protected float amount;
   protected String type;
   private boolean isApplied;

   public ElementalDamage(Element element, Entity attacker, Entity victim, float amount) {
      this.type = "environment";
      this.isApplied = false;
      this.element = element;
      this.attacker = attacker;
      this.victim = victim;
      this.amount = amount;
   }

   public ElementalDamage(Element element, Entity attacker, Entity victim, float amount, String type) {
      this(element, attacker, victim, amount);
      this.type = type;
   }

   public abstract void onHit();

   public Element getElement() {
      return this.element;
   }

   public ElementalDamage setElement(Element element) {
      this.element = element;
      return this;
   }

   public Entity getAttacker() {
      return this.attacker;
   }

   public ElementalDamage setAttacker(Entity attacker) {
      this.attacker = attacker;
      return this;
   }

   public Entity getVictim() {
      return this.victim;
   }

   public ElementalDamage setVictim(Entity victim) {
      this.victim = victim;
      return this;
   }

   public float getAmount() {
      return this.amount;
   }

   public ElementalDamage setAmount(float amount) {
      this.amount = amount;
      return this;
   }

   public String getType() {
      return this.type;
   }

   public void setType(String type) {
      this.type = type;
   }

   public void apply() {
      if (!this.isApplied) {
         this.isApplied = true;
         Bukkit.getPluginManager().callEvent(new ElementalDamageEvent(this));
      }

   }
}
