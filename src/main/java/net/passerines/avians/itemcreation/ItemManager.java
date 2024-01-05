package net.passerines.avians.itemcreation;



import net.passerines.avians.config.ConfigManager;
import net.passerines.avians.constants.AttackType;
import net.passerines.avians.itemcreation.weaponcreation.BladedConfig;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.HashMap;

public class ItemManager {
    public static HashMap<String, ItemConfig> ITEM_MAP = new HashMap<>();
    public static void loadItems(){
        for(File file : ConfigManager.getAllFiles()){
            YamlConfiguration item = YamlConfiguration.loadConfiguration(file);
            for(String string : item.getKeys(false)){
                ConfigurationSection section = item.getConfigurationSection(string);
                String type = section.getString("Type", "item");
                ItemConfig newItem;
                switch (type){
                    default -> newItem = new ItemConfig(section);
                    case(AttackType.BLADED) -> newItem = new BladedConfig(section);
                }
                if(type.equalsIgnoreCase("weapon")){

                }
                else {

                }
                ITEM_MAP.put(string, newItem);
            }
        }
    }
}
