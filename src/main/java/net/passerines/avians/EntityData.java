package net.passerines.avians;

import io.lumine.mythic.api.config.MythicConfig;
import io.lumine.mythic.core.mobs.ActiveMob;
import net.passerines.avians.element.elementalDamage.StatusEffects;
import net.passerines.avians.element.elements.Element;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;

public class EntityData {
   private float health;
   private int maxHealth;
   private float healthRegen;
   private float mana;
   private int maxMana;
   private float manaRegen;
   private float defense;
   private int maxDefense;
   private int strength;
   private int dexterity;
   private float speed;
   private int critDamage;
   private float critChance;
   private float critExecutionRate;
   private StatusEffects statusEffects;
   private Element element;
   private Entity entity;

   public EntityData(LivingEntity entity) {
      this.health = (float)((int)entity.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
   }

   public EntityData(ActiveMob entity) {
      MythicConfig config = entity.getType().getConfig();
      this.maxHealth = config.getInt("Health", 100);
      this.health = (float)this.maxHealth;
      this.maxDefense = config.getInt("Defense", 10);
      this.maxMana = config.getInt("Mana", 100);
      this.speed = (float)config.getInt("Speed", 1);
      this.critChance = (float)config.getDouble("Crits.rate", 10.0D);
      this.critDamage = config.getInt("Crits.damage", 1);
      this.critExecutionRate = (float)config.getDouble("Crits.exec", 5.0D);
      this.element = Element.valueOf(config.getString("Element", Element.FIRE.name()));
   }

   public double getHealth() {
      return (double)this.health;
   }

   public EntityData setHealth(double health) {
      this.health = (float)health;
      return this;
   }

   public int getMaxHealth() {
      return this.maxHealth;
   }

   public void setMaxHealth(int maxHealth) {
      if (maxHealth >= 5) {
         this.maxHealth = maxHealth;
      }

   }

   public float getHealthRegen() {
      return this.healthRegen;
   }

   public void setHealthRegen(float healthRegen) {
      this.healthRegen = healthRegen;
   }

   public double getMana() {
      return (double)this.mana;
   }

   public EntityData setMana(double mana) {
      this.mana = (float)mana;
      return this;
   }

   public int getMaxMana() {
      return this.maxMana;
   }

   public EntityData setMaxMana(int maxMana) {
      if (maxMana >= 1) {
         this.maxMana = maxMana;
      }

      return this;
   }

   public double getManaRegen() {
      return (double)this.manaRegen;
   }

   public EntityData setManaRegen(double manaRegen) {
      this.manaRegen = (float)manaRegen;
      return this;
   }

   public float getDefense() {
      return this.defense;
   }

   public EntityData setDefense(float defense) {
      this.defense = defense;
      return this;
   }

   public int getMaxDefense() {
      return this.maxDefense;
   }

   public EntityData setMaxDefense(int maxDefense) {
      this.maxDefense = maxDefense;
      return this;
   }

   public int getStrength() {
      return this.strength;
   }

   public EntityData setStrength(int strength) {
      this.strength = strength;
      return this;
   }

   public int getDexterity() {
      return this.dexterity;
   }

   public EntityData setDexterity(int dexterity) {
      this.dexterity = dexterity;
      return this;
   }

   public double getSpeed() {
      return (double)this.speed;
   }

   public EntityData setSpeed(double speed) {
      this.speed = (float)speed;
      return this;
   }

   public int getCritDamage() {
      return this.critDamage;
   }

   public EntityData setCritDamage(int critDamage) {
      this.critDamage = critDamage;
      return this;
   }

   public float getCritChance() {
      return this.critChance;
   }

   public EntityData setCritChance(float critChance) {
      this.critChance = critChance;
      return this;
   }

   public double getCritExecutionRate() {
      return (double)this.critExecutionRate;
   }

   public EntityData setCritExecutionRate(double critExecutionRate) {
      this.critExecutionRate = (float)critExecutionRate;
      return this;
   }

   public StatusEffects getStatusEffects() {
      return this.statusEffects;
   }

   public Element getElement() {
      return this.element;
   }

   public void setElement(Element element) {
      this.element = element;
   }
}
