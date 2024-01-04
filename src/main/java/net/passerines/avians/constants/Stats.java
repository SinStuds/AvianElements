package net.passerines.avians.constants;

import net.passerines.avians.util.Pair;
import net.passerines.avians.util.Util;
import org.bukkit.NamespacedKey;
import org.bukkit.persistence.PersistentDataType;

public class Stats {
   public static final Pair<NamespacedKey, PersistentDataType> SHARPNESS;
   public static final Pair<NamespacedKey, PersistentDataType> MAX_SHARPNESS;
   public static final Pair<NamespacedKey, PersistentDataType> RANGE;
   public static final Pair<NamespacedKey, PersistentDataType> WEIGHT;
   public static final Pair<NamespacedKey, PersistentDataType> PEN;
   public static final Pair<NamespacedKey, PersistentDataType> CHIP_PERCENTAGE;
   public static final Pair<NamespacedKey, PersistentDataType> HEALTH;
   public static final Pair<NamespacedKey, PersistentDataType> HEALTH_REGEN;
   public static final Pair<NamespacedKey, PersistentDataType> MANA;
   public static final Pair<NamespacedKey, PersistentDataType> MANA_REGEN;
   public static final Pair<NamespacedKey, PersistentDataType> DEFENSE;
   public static final Pair<NamespacedKey, PersistentDataType> STRENGTH;
   public static final Pair<NamespacedKey, PersistentDataType> DEXTERITY;
   public static final Pair<NamespacedKey, PersistentDataType> SPEED;
   public static final Pair<NamespacedKey, PersistentDataType> CRITDAMAGE;
   public static final Pair<NamespacedKey, PersistentDataType> CRITCHANCE;
   public static final Pair<NamespacedKey, PersistentDataType> CRITEXECUTIONRATE;

   static {
      SHARPNESS = new Pair(Util.getNamespacedKey("Sharpness"), PersistentDataType.FLOAT);
      MAX_SHARPNESS = new Pair(Util.getNamespacedKey("MaxSharpness"), PersistentDataType.FLOAT);
      RANGE = new Pair(Util.getNamespacedKey("MaxSharpness"), PersistentDataType.DOUBLE);
      WEIGHT = new Pair(Util.getNamespacedKey("Weight"), PersistentDataType.FLOAT);
      PEN = new Pair(Util.getNamespacedKey("Pen"), PersistentDataType.FLOAT);
      CHIP_PERCENTAGE = new Pair(Util.getNamespacedKey("ChipPercentage"), PersistentDataType.FLOAT);
      HEALTH = new Pair(Util.getNamespacedKey("Health"), PersistentDataType.INTEGER);
      HEALTH_REGEN = new Pair(Util.getNamespacedKey("HealthRegen"), PersistentDataType.FLOAT);
      MANA = new Pair(Util.getNamespacedKey("Mana"), PersistentDataType.FLOAT);
      MANA_REGEN = new Pair(Util.getNamespacedKey("ManaRegen"), PersistentDataType.FLOAT);
      DEFENSE = new Pair(Util.getNamespacedKey("Defense"), PersistentDataType.INTEGER);
      STRENGTH = new Pair(Util.getNamespacedKey("Strength"), PersistentDataType.INTEGER);
      DEXTERITY = new Pair(Util.getNamespacedKey("Dexterity"), PersistentDataType.INTEGER);
      SPEED = new Pair(Util.getNamespacedKey("Speed"), PersistentDataType.FLOAT);
      CRITDAMAGE = new Pair(Util.getNamespacedKey("CritDamage"), PersistentDataType.INTEGER);
      CRITCHANCE = new Pair(Util.getNamespacedKey("CritChance"), PersistentDataType.FLOAT);
      CRITEXECUTIONRATE = new Pair(Util.getNamespacedKey("CritExecutionRate"), PersistentDataType.FLOAT);
   }
}
