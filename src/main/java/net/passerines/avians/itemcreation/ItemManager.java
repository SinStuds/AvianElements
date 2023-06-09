package net.passerines.avians.itemcreation;



import net.passerines.avians.config.ConfigManager;
import net.passerines.avians.itemcreation.weaponcreation.BladedConfig;
import net.passerines.avians.itemcreation.weaponcreation.WeaponConfig;
import net.passerines.avians.util.Util;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.util.HashMap;
import java.util.Locale;

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
                    case("bladed") -> newItem = new BladedConfig(section);
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
