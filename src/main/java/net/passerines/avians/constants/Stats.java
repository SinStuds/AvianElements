package net.passerines.avians.constants;

import net.passerines.avians.util.Pair;
import net.passerines.avians.util.Util;
import org.bukkit.NamespacedKey;
import org.bukkit.persistence.PersistentDataType;

public class Stats {
    public final static Pair<NamespacedKey, PersistentDataType> SHARPNESS = new Pair<>(Util.getNamespacedKey("Sharpness"), PersistentDataType.FLOAT);
    public final static Pair<NamespacedKey, PersistentDataType> MAX_SHARPNESS = new Pair<>(Util.getNamespacedKey("MaxSharpness"), PersistentDataType.FLOAT);


    public final static Pair<NamespacedKey, PersistentDataType> WEIGHT = new Pair<>(Util.getNamespacedKey("Weight"), PersistentDataType.FLOAT);

    public final static Pair<NamespacedKey, PersistentDataType> PEN = new Pair<>(Util.getNamespacedKey("Pen"), PersistentDataType.FLOAT);
    public final static Pair<NamespacedKey, PersistentDataType> CHIP_PERCENTAGE = new Pair<>(Util.getNamespacedKey("ChipPercentage"), PersistentDataType.FLOAT);
    public final static Pair<NamespacedKey, PersistentDataType> HEALTH = new Pair<>(Util.getNamespacedKey("Health"), PersistentDataType.INTEGER);

    public final static Pair<NamespacedKey, PersistentDataType> HEALTH_REGEN = new Pair<>(Util.getNamespacedKey("HealthRegen"), PersistentDataType.FLOAT);

    public final static Pair<NamespacedKey, PersistentDataType> MANA = new Pair<>(Util.getNamespacedKey("Mana"), PersistentDataType.FLOAT);

    public final static Pair<NamespacedKey, PersistentDataType> MANA_REGEN = new Pair<>(Util.getNamespacedKey("ManaRegen"), PersistentDataType.FLOAT);
    public final static Pair<NamespacedKey, PersistentDataType> DEFENSE = new Pair<>(Util.getNamespacedKey("Defense"), PersistentDataType.FLOAT);
    public final static Pair<NamespacedKey, PersistentDataType> STRENGTH = new Pair<>(Util.getNamespacedKey("Strength"), PersistentDataType.FLOAT);
    public final static Pair<NamespacedKey, PersistentDataType> DEXTERITY = new Pair<>(Util.getNamespacedKey("Dexterity"), PersistentDataType.FLOAT);
    public final static Pair<NamespacedKey, PersistentDataType> SPEED = new Pair<>(Util.getNamespacedKey("Speed"), PersistentDataType.FLOAT);
    public final static Pair<NamespacedKey, PersistentDataType> CRITDAMAGE = new Pair<>(Util.getNamespacedKey("CritDamage"), PersistentDataType.FLOAT);
    public final static Pair<NamespacedKey, PersistentDataType> CRITCHANCE = new Pair<>(Util.getNamespacedKey("CritChance"), PersistentDataType.FLOAT);
    public final static Pair<NamespacedKey, PersistentDataType> CRITEXECUTIONRATE = new Pair<>(Util.getNamespacedKey("CritExecutionRate"), PersistentDataType.FLOAT);
}
