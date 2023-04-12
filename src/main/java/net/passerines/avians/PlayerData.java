package net.passerines.avians;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class PlayerData extends EntityData{


    private int bladedMastery;
    private int bluntMastery;
    private int bowMastery;
    private int arcaneMastery;

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

    public int getBowMastery() {
        return bowMastery;
    }

    public PlayerData setBowMastery(int bowMastery) {
        this.bowMastery = bowMastery;
        return this;
    }

    public int getArcaneMastery() {
        return arcaneMastery;
    }

    public PlayerData setArcaneMastery(int arcaneMastery) {
        this.arcaneMastery = arcaneMastery;
        return this;
    }
}
