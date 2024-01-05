package net.passerines.avians;

import net.passerines.avians.constants.Stats;
import net.passerines.avians.events.slotstatsystem.SlotHashmap;
import net.passerines.avians.itemcreation.ItemConfig;
import net.passerines.avians.itemcreation.weaponcreation.WeaponConfig;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

public class PlayerData extends EntityData{

    private SlotHashmap slotHashmap;
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
    private Player player;

    public PlayerData(Player player) {
        super(player);
        this.player = player;
        slotHashmap = new SlotHashmap(player);
    }
    public void calculate(ItemStack item){
        if(item != null && item.getItemMeta() != null) {
            /*player.sendMessage("Max Health " + (getMaxHealth() + item.getItemMeta().getPersistentDataContainer().getOrDefault(Stats.HEALTH.getKey(), Stats.HEALTH.getValue(),0)));
            player.sendMessage("Health Regen " + (getHealthRegen() + item.getItemMeta().getPersistentDataContainer().getOrDefault(Stats.HEALTH_REGEN.getKey(), Stats.HEALTH_REGEN.getValue(),0f)));
            player.sendMessage("Strength " + (getStrength() + item.getItemMeta().getPersistentDataContainer().getOrDefault(Stats.STRENGTH.getKey(), Stats.STRENGTH.getValue(),0)));
            player.sendMessage("Max Defense " + (getMaxDefense() + item.getItemMeta().getPersistentDataContainer().getOrDefault(Stats.DEFENSE.getKey(), Stats.DEFENSE.getValue(),0)));*/
            setMaxHealth(getMaxHealth() + item.getItemMeta().getPersistentDataContainer().getOrDefault(Stats.HEALTH.getKey(), Stats.HEALTH.getValue(),0));
            setHealthRegen(getHealthRegen() + item.getItemMeta().getPersistentDataContainer().getOrDefault(Stats.HEALTH_REGEN.getKey(), Stats.HEALTH_REGEN.getValue(),0f));
            setStrength(getStrength() + item.getItemMeta().getPersistentDataContainer().getOrDefault(Stats.STRENGTH.getKey(), Stats.STRENGTH.getValue(),0));
            setDexterity(getDexterity() + item.getItemMeta().getPersistentDataContainer().getOrDefault(Stats.DEXTERITY.getKey(), Stats.DEXTERITY.getValue(),0));
            setMaxDefense(getMaxDefense() + item.getItemMeta().getPersistentDataContainer().getOrDefault(Stats.DEFENSE.getKey(), Stats.DEFENSE.getValue(),0));
            setCritChance(getCritChance() + item.getItemMeta().getPersistentDataContainer().getOrDefault(Stats.CRITCHANCE.getKey(), Stats.CRITCHANCE.getValue(),0f));
            setCritDamage(getCritDamage() + item.getItemMeta().getPersistentDataContainer().getOrDefault(Stats.CRITDAMAGE.getKey(), Stats.CRITDAMAGE.getValue(),0));
            setCritExecutionRate(getCritExecutionRate() + item.getItemMeta().getPersistentDataContainer().getOrDefault(Stats.CRITEXECUTIONRATE.getKey(), Stats.CRITEXECUTIONRATE.getValue(),0f));
        }
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

    public SlotHashmap getSlotHashmap() {
        return slotHashmap;
    }
}
