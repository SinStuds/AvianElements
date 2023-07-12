package net.passerines.avians.itemcreation.weaponcreation;

import net.kyori.adventure.text.Component;
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
    private final int weight;
    private final int pen;
    private final int chipPercentage;
    private double health;
    private double healthRegen;
    private double mana;
    private double manaRegen;
    private int defense;
    private int strength;
    private int dexterity;
    private double speed;
    private int critDamage;
    private double critChance;
    private double critExecutionRate;
    private static final List<String> WEAPONSTATS = new ArrayList<>();
    static{
        WEAPONSTATS.add("Weight: <Weight> | Pen: <Pen> | Chip Percentage: <ChipPercentage>");
        WEAPONSTATS.add("Health: <Health> | Health Regen: <HealthRegen");
        WEAPONSTATS.add("Mana: <Mana> | Mana Regen: <ManaRegen>");
        WEAPONSTATS.add("Strength: <Strength> | Defense: <Defense> | Dexterity: <Dexterity>");
        WEAPONSTATS.add(("Movement Speed: <Speed>"));
        WEAPONSTATS.add("Crit DMG: <CritDMG> | Crit Chance: <CritChance>");
        WEAPONSTATS.add("Execution Rate: <ExectutionRate>");
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
        critChance = config.getDouble("critChance", 0);
        critExecutionRate = config.getDouble("critExecutionRate",0);
    }
    @Override
    public ItemStack generate(){
        ItemStack item = super.generate();
        ItemMeta itemMeta = updateLore(item);
        item.setItemMeta(itemMeta);
        return item;
    }
    @Override
    public ItemMeta updateLore(ItemStack item){
        ItemMeta itemMeta = item.getItemMeta();
        List<Component> lore = super.updateLore(item).lore();
        List<String> weaponStats = new ArrayList<>();
        for (String line : WEAPONSTATS){
            int counter1 = 0;
            int counter2 = 0;
            if(line.contains("<Weight>")){
                if(weight > 0){
                    counter1++;
                }
                counter2++;
                line.replaceAll("<Weight>", String.valueOf(weight));
            }
            if(line.contains("<Pen>")){
                if(pen > 0){
                    counter1++;
                }
                counter2++;
                line.replaceAll("<Pen>", String.valueOf(pen));
            }
            if(line.contains("<ChipPercentage>")){
                if(chipPercentage > 0){
                    counter1++;
                }
                counter2++;
                line.replaceAll("<ChipPercentage>", String.valueOf(chipPercentage));
            }
            if(line.contains("<Health>")){
                if(health > 0){
                    counter1++;
                }
                counter2++;
                line.replaceAll("<Health>", String.valueOf(health));
            }
            if(line.contains("<HealthRegen>")){
                if(healthRegen > 0){
                    counter1++;
                }
                counter2++;
                line.replaceAll("<HealthRegen>", String.valueOf(healthRegen));
            }
            if(line.contains("<Mana>")){
                if(mana > 0){
                    counter1++;
                }
                counter2++;
                line.replaceAll("<Mana>", String.valueOf(mana));
            }
            if(line.contains("<ManaRegen>")){
                if(manaRegen > 0){
                    counter1++;
                }
                counter2++;
                line.replaceAll("<ManaRegen>", String.valueOf(manaRegen));
            }
            if(line.contains("<Strength>")){
                if(strength > 0){
                    counter1++;
                }
                counter2++;
                line.replaceAll("<Strength>", String.valueOf(strength));
            }
            if(line.contains("<Defense>")){
                if(defense > 0){
                    counter1++;
                }
                counter2++;
                line.replaceAll("<Defense>", String.valueOf(defense));
            }
            if(line.contains("<Dexterity>")){
                if(dexterity > 0){
                    counter1++;
                }
                counter2++;
                line.replaceAll("<Dexterity>", String.valueOf(dexterity));
            }
            if(line.contains("<Speed>")){
                if(speed > 0){
                    counter1++;
                }
                counter2++;
                line.replaceAll("<Speed>", String.valueOf(speed));
            }
            if(line.contains("<CritDamage>")){
                if(critDamage > 0){
                    counter1++;
                }
                counter2++;
                line.replaceAll("<CritDamage>", String.valueOf(strength));
            }
            if(line.contains("<CritChance>")){
                if(critChance > 0){
                    counter1++;
                }
                counter2++;
                line.replaceAll("<CritChance>", String.valueOf(critChance));
            }
            if(line.contains("<ExecutionRate>")){
                if(critExecutionRate > 0){
                    counter1++;
                }
                counter2++;
                line.replaceAll("<ExecutionRate>", String.valueOf(critExecutionRate));
            }
            if(counter1 > 0 || counter2 == 0){
                weaponStats.add(line);
            }
        }
        lore.addAll(Chat.formatC(weaponStats));
        itemMeta.lore(lore);
        return itemMeta;
    }
}
