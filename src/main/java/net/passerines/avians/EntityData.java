package net.passerines.avians;

import io.lumine.mythic.api.config.MythicConfig;
import io.lumine.mythic.core.mobs.ActiveMob;
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

    private int defense;
    private int maxDefense;

    private int strength;
    private int dexterity;
    private float speed;

    private int critDamage;
    private float critChance;
    private float critExecutionRate;

    private Element element;

    private Entity entity;
    public EntityData(LivingEntity entity){
        this.health = (int) entity.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
    }
    public EntityData(ActiveMob entity){
        MythicConfig config = entity.getType().getConfig();
        this.maxHealth = config.getInt("Health", 100);
        this.health = maxHealth;
        this.maxDefense = config.getInt("Defense", 10);
        this.maxMana = config.getInt("Mana", 100);
        this.speed = config.getInt("Speed", 1);
        this.critChance = (float) config.getDouble("Crits.rate", 10.0);
        this.critDamage = config.getInt("Crits.damage", 1);
        this.critExecutionRate = (float) config.getDouble("Crits.exec", 5);
        this.element = Element.valueOf(config.getString("Element", Element.FIRE.name()));
    }
    public double getHealth() {
        return health;
    }

    public EntityData setHealth(double health) {
        this.health = (float) health;
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
        this.healthRegen = (float) healthRegen;
        return this;
    }

    public double getMana() {
        return mana;
    }

    public EntityData setMana(double mana) {
        this.mana = (float) mana;
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
        this.manaRegen = (float) manaRegen;
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
        this.speed = (float) speed;
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
        this.critChance = (float) critChance;
        return this;
    }

    public double getCritExecutionRate() {
        return critExecutionRate;
    }

    public EntityData setCritExecutionRate(double critExecutionRate) {
        this.critExecutionRate = (float) critExecutionRate;
        return this;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }
}
