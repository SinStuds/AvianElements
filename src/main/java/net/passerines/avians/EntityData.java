package net.passerines.avians;

import io.lumine.mythic.api.config.MythicConfig;
import io.lumine.mythic.api.mobs.MobManager;
import io.lumine.mythic.api.mobs.MythicMob;
import io.lumine.mythic.bukkit.MythicBukkit;
import io.lumine.mythic.core.mobs.ActiveMob;
import net.passerines.avians.util.MythicMobsUtil;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;

public class EntityData {
    private double health;
    private int maxHealth;
    private double healthRegen;

    private double mana;
    private int maxMana;
    private double manaRegen;

    private int defense;
    private int maxDefense;

    private int strength;
    private int dexterity;
    private double speed;

    private int critDamage;
    private double critChance;
    private double critExecutionRate;

    private Entity entity;
    public EntityData(LivingEntity entity){
        this.health = (int) entity.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
    }
    public EntityData(ActiveMob entity){
        MythicConfig config = entity.getType().getConfig();
        this.maxHealth = config.getInt("Health", 100);
        this.maxDefense = config.getInt("Defense", 10);
        this.maxMana = config.getInt("Mana", 100);
        this.speed = config.getInt("Speed", 1);
        this.critChance = config.getDouble("Crits.rate", 10.0);
        this.critDamage = config.getInt("Crits.damage", 1);
        this.critExecutionRate = config.getDouble("Crits.exec", 5);

    }
    public double getHealth() {
        return health;
    }

    public EntityData setHealth(double health) {
        this.health = health;
        return this;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public EntityData setMaxHealth(int maxHealth) {
        if(maxHealth >= 5) {
            this.maxHealth = maxHealth;
        }
        return this;
    }

    public double getHealthRegen() {
        return healthRegen;
    }

    public EntityData setHealthRegen(double healthRegen) {
        this.healthRegen = healthRegen;
        return this;
    }

    public double getMana() {
        return mana;
    }

    public EntityData setMana(double mana) {
        this.mana = mana;
        return this;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public EntityData setMaxMana(int maxMana) {
        if(maxMana >= 1){
            this.maxMana = maxMana;
        }
        return this;
    }

    public double getManaRegen() {
        return manaRegen;
    }

    public EntityData setManaRegen(double manaRegen) {
        this.manaRegen = manaRegen;
        return this;
    }

    public int getDefense() {
        return defense;
    }

    public EntityData setDefense(int defense) {
        this.defense = defense;
        return this;
    }

    public int getMaxDefense() {
        return maxDefense;
    }

    public EntityData setMaxDefense(int maxDefense) {
        this.maxDefense = maxDefense;
        return this;
    }

    public int getStrength() {
        return strength;
    }

    public EntityData setStrength(int strength) {
        this.strength = strength;
        return this;
    }

    public int getDexterity() {
        return dexterity;
    }

    public EntityData setDexterity(int dexterity) {
        this.dexterity = dexterity;
        return this;
    }

    public double getSpeed() {
        return speed;
    }

    public EntityData setSpeed(double speed) {
        this.speed = speed;
        return this;
    }

    public int getCritDamage() {
        return critDamage;
    }

    public EntityData setCritDamage(int critDamage) {
        this.critDamage = critDamage;
        return this;
    }

    public double getCritChance() {
        return critChance;
    }

    public EntityData setCritChance(double critChance) {
        this.critChance = critChance;
        return this;
    }

    public double getCritExecutionRate() {
        return critExecutionRate;
    }

    public EntityData setCritExecutionRate(double critExecutionRate) {
        this.critExecutionRate = critExecutionRate;
        return this;
    }
}
