package net.passerines.avians.itemcreation.weaponcreation;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.passerines.avians.constants.Stats;
import net.passerines.avians.itemcreation.ItemConfig;
import net.passerines.avians.util.Chat;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class WeaponConfig extends ItemConfig {
    private final float weight;
    private final float pen;
    private final float chipPercentage;
    private int health;
    private float healthRegen;
    private float mana;
    private float manaRegen;
    private int defense;
    private int strength;
    private int dexterity;
    private float speed;
    private int critDamage;
    private float critChance;
    private float critExecutionRate;
    private static final List<String> WEAPONSTATS = new ArrayList<>();
    static{
        /*WEAPONSTATS.add("Weight: <Weight> | Pen: <Pen> | Chip Percentage: <ChipPercentage>");
        WEAPONSTATS.add("Health: <Health> | Health Regen: <HealthRegen");
        WEAPONSTATS.add("Mana: <Mana> | Mana Regen: <ManaRegen>");
        WEAPONSTATS.add("Strength: <Strength> | Defense: <Defense> | Dexterity: <Dexterity>");
        WEAPONSTATS.add(("Movement Speed: <Speed>"));
        WEAPONSTATS.add("Crit DMG: <CritDMG> | Crit Chance: <CritChance>");
        WEAPONSTATS.add("Execution Rate: <ExecutionRate>");*/
        WEAPONSTATS.add("<weight_pen_chip>");
        WEAPONSTATS.add("<health_healthregen>");
        WEAPONSTATS.add("<mana_manaregen>");
        WEAPONSTATS.add("<strength_defense_dexterity>");
        WEAPONSTATS.add("<movementspeed>");
        WEAPONSTATS.add("<critdmg_critchance>");
        WEAPONSTATS.add("<executionrate>");
    }

    public WeaponConfig(ConfigurationSection config) {
        super(config);
        weight = config.getInt("weight", 10);
        pen = config.getInt("pen", 0);
        chipPercentage = config.getInt("chipPercentage", 0);
        health = config.getInt("health", 0);
        healthRegen = config.getInt("healthRegen", 0);
        mana = config.getInt("mana", 0);
        manaRegen = config.getInt("manaRegen", 0);
        defense = config.getInt("defense", 0);
        strength = config.getInt("strength", 0);
        dexterity = config.getInt("dexterity",0);
        speed = config.getInt("speed", 0);
        critDamage = config.getInt("critDmg", 0);
        critChance = (float) config.getDouble("critChance", 0);
        critExecutionRate = (float) config.getDouble("critExecutionRate",0);
    }
    @Override
    public ItemStack generate(){
        ItemStack item = super.generate();
        ItemMeta itemMeta = updateLore(item);
        itemMeta.getPersistentDataContainer().set(Stats.CHIP_PERCENTAGE.getKey(), Stats.CHIP_PERCENTAGE.getValue(), chipPercentage);
        itemMeta.getPersistentDataContainer().set(Stats.CRITCHANCE.getKey(), Stats.CRITCHANCE.getValue(), critChance);
        itemMeta.getPersistentDataContainer().set(Stats.CRITDAMAGE.getKey(), Stats.CRITDAMAGE.getValue(), critDamage);
        itemMeta.getPersistentDataContainer().set(Stats.CRITEXECUTIONRATE.getKey(), Stats.CRITEXECUTIONRATE.getValue(), critExecutionRate);
        itemMeta.getPersistentDataContainer().set(Stats.DEFENSE.getKey(), Stats.DEFENSE.getValue(), defense);
        itemMeta.getPersistentDataContainer().set(Stats.DEXTERITY.getKey(), Stats.DEXTERITY.getValue(), dexterity);
        itemMeta.getPersistentDataContainer().set(Stats.HEALTH.getKey(), Stats.HEALTH.getValue(), health);
        itemMeta.getPersistentDataContainer().set(Stats.HEALTH_REGEN.getKey(), Stats.HEALTH_REGEN.getValue(), healthRegen);
        itemMeta.getPersistentDataContainer().set(Stats.MANA.getKey(), Stats.MANA.getValue(), mana);
        itemMeta.getPersistentDataContainer().set(Stats.MANA_REGEN.getKey(), Stats.MANA_REGEN.getValue(), manaRegen);
        itemMeta.getPersistentDataContainer().set(Stats.PEN.getKey(), Stats.PEN.getValue(), pen);
        itemMeta.getPersistentDataContainer().set(Stats.SPEED.getKey(), Stats.SPEED.getValue(), speed);
        itemMeta.getPersistentDataContainer().set(Stats.STRENGTH.getKey(), Stats.STRENGTH.getValue(), strength);
        itemMeta.getPersistentDataContainer().set(Stats.WEIGHT.getKey(), Stats.WEIGHT.getValue(), weight);
        item.setItemMeta(itemMeta);
        return item;
    }
    @Override
    public ItemMeta updateLore(ItemStack item){
        ItemMeta itemMeta = item.getItemMeta();
        List<Component> lore = super.updateLore(item).lore();
        List<String> weaponStats = new ArrayList<>();
        for (String line : WEAPONSTATS){
            String nLine = "";
            if(line.contains("<weight_pen_chip>")){

                if(weight>0){
                    nLine += "Weight: " + weight + " | ";
                }
                else{
                    nLine += "Weight: Weightless | ";
                }
                if(pen>0){
                    nLine += "&ePen: " + pen + " | ";
                }
                if(chipPercentage>0) {
                    nLine += "&7Chip Percentage: " + chipPercentage + " | ";
                }
            }
            if(line.contains("<health_healthregen>")){
                if(health>0){
                    nLine += "&cHealth: " + weight + " | ";
                }

                if(healthRegen>0){
                    nLine += "&4Health Regen: " + pen + " | ";
                }
            }
            if(nLine.length()>2) {
                nLine = nLine.substring(0, nLine.length() - 3);
                weaponStats.add(nLine);
            }
            /*int counter1 = 0;
            int counter2 = 0;
            if(line.contains("<Weight>")){
                if(weight > 0){
                    counter1++;
                }
                counter2++;
                line = line.replaceAll("<Weight>", weight + " KG");
            }
            if(line.contains("<Pen>")){
                if(pen > 0){
                    counter1++;

                }
                counter2++;
                line = line.replaceAll("<Pen>", String.valueOf(pen));
            }
            if(line.contains("<ChipPercentage>")){
                if(chipPercentage > 0){
                    counter1++;
                }
                counter2++;
                line = line.replaceAll("<ChipPercentage>", String.valueOf(chipPercentage));
            }
            if(line.contains("<Health>")){
                if(health > 0){
                    counter1++;
                }
                counter2++;
                line = line.replaceAll("<Health>", String.valueOf(health));
            }
            if(line.contains("<HealthRegen>")){
                if(healthRegen > 0){
                    counter1++;
                }
                counter2++;
                line = line.replaceAll("<HealthRegen>", String.valueOf(healthRegen));
            }
            if(line.contains("<Mana>")){
                if(mana > 0){
                    counter1++;
                }
                counter2++;
                line = line.replaceAll("<Mana>", String.valueOf(mana));
            }
            if(line.contains("<ManaRegen>")){
                if(manaRegen > 0){
                    counter1++;
                }
                counter2++;
                line = line.replaceAll("<ManaRegen>", String.valueOf(manaRegen));
            }
            if(line.contains("<Strength>")){
                if(strength > 0){
                    counter1++;
                }
                counter2++;
                line = line.replaceAll("<Strength>", String.valueOf(strength));
            }
            if(line.contains("<Defense>")){
                if(defense > 0){
                    counter1++;
                }
                counter2++;
                line = line.replaceAll("<Defense>", String.valueOf(defense));
            }
            if(line.contains("<Dexterity>")){
                if(dexterity > 0){
                    counter1++;
                }
                counter2++;
                line = line.replaceAll("<Dexterity>", String.valueOf(dexterity));
            }
            if(line.contains("<Speed>")){
                if(speed > 0){
                    counter1++;
                }
                counter2++;
                line = line.replaceAll("<Speed>", String.valueOf(speed));
            }
            if(line.contains("<CritDamage>")){
                if(critDamage > 0){
                    counter1++;
                }
                counter2++;
                line = line.replaceAll("<CritDamage>", String.valueOf(critDamage));
            }
            if(line.contains("<CritChance>")){
                if(critChance > 0){
                    counter1++;
                }
                counter2++;
                line = line.replaceAll("<CritChance>", String.valueOf(critChance));
            }
            if(line.contains("<ExecutionRate>")){
                if(critExecutionRate > 0){
                    counter1++;
                }
                counter2++;
                line = line.replaceAll("<ExecutionRate>", String.valueOf(critExecutionRate));
            }
            if(counter1 > 0 || counter2 == 0){
                weaponStats.add(line);
            }*/
        }
        lore.addAll(Chat.formatC(weaponStats));
        itemMeta.lore(lore);
        return itemMeta;
    }
}
