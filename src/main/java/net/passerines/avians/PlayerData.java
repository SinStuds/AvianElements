package net.passerines.avians;

import org.bukkit.entity.Player;

public class PlayerData extends EntityData{


    private int bladedMastery;
    private int bluntMastery;
    private int pointedMastery;
    private int rangedMastery;
    private int arcaneMastery;

    private int trapDurationBonus;
    private int trapDamageBonus;
    private int minionDamageBonus;
    private int minionHealthBonus;
    private int minionDefenseBonus;
    private int minionElemenalBonus;
    private int maxMinions;


    public PlayerData(Player player) {
        super(player);
    }

    public int getBladedMastery() {
        return bladedMastery;
    }

    public PlayerData setBladedMastery(int bladedMastery) {
        this.bladedMastery = bladedMastery;
        return this;
    }

    public int getBluntMastery() {
        return bluntMastery;
    }

    public PlayerData setBluntMastery(int bluntMastery) {
        this.bluntMastery = bluntMastery;
        return this;
    }

    public int getRangedMastery() {
        return rangedMastery;
    }

    public PlayerData setRangedMastery(int rangedMastery) {
        this.rangedMastery = rangedMastery;
        return this;
    }

    public int getArcaneMastery() {
        return arcaneMastery;
    }

    public PlayerData setArcaneMastery(int arcaneMastery) {
        this.arcaneMastery = arcaneMastery;
        return this;
    }

    public int getPointedMastery() {
        return pointedMastery;
    }

    public PlayerData setPointedMastery(int pointedMastery) {
        this.pointedMastery = pointedMastery;
        return this;
    }

    public int getTrapDurationBonus() {
        return trapDurationBonus;
    }

    public PlayerData setTrapDurationBonus(int trapDurationBonus) {
        this.trapDurationBonus = trapDurationBonus;
        return this;
    }

    public int getTrapDamageBonus() {
        return trapDamageBonus;
    }

    public PlayerData setTrapDamageBonus(int trapDamageBonus) {
        this.trapDamageBonus = trapDamageBonus;
        return this;
    }

    public int getMinionDamageBonus() {
        return minionDamageBonus;
    }

    public PlayerData setMinionDamageBonus(int minionDamageBonus) {
        this.minionDamageBonus = minionDamageBonus;
        return this;
    }

    public int getMinionHealthBonus() {
        return minionHealthBonus;
    }

    public PlayerData setMinionHealthBonus(int minionHealthBonus) {
        this.minionHealthBonus = minionHealthBonus;
        return this;
    }

    public int getMinionDefenseBonus() {
        return minionDefenseBonus;
    }

    public PlayerData setMinionDefenseBonus(int minionDefenseBonus) {
        this.minionDefenseBonus = minionDefenseBonus;
        return this;
    }

    public int getMinionElemenalBonus() {
        return minionElemenalBonus;
    }

    public PlayerData setMinionElemenalBonus(int minionElemenalBonus) {
        this.minionElemenalBonus = minionElemenalBonus;
        return this;
    }

    public int getMaxMinions() {
        return maxMinions;
    }

    public PlayerData setMaxMinions(int maxMinions) {
        this.maxMinions = maxMinions;
        return this;
    }
}
