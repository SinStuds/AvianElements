package net.passerines.avians.itemcreation;



import net.passerines.avians.config.ConfigManager;
import net.passerines.avians.util.Util;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.util.HashMap;

public class ItemManager {
    public static HashMap<String, ItemConfig> ITEM_MAP = new HashMap<>();
    public static void loadItems(){
        for(File file : ConfigManager.getAllFiles()){
            YamlConfiguration item = YamlConfiguration.loadConfiguration(file);
            for(String string : item.getKeys(false)){
                ConfigurationSection section = item.getConfigurationSection(string);
                ItemConfig newItem = new ItemConfig(section);
                ITEM_MAP.put(string, newItem);
            }
        }
    }
}
