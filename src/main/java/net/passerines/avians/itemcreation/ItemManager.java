package net.passerines.avians.itemcreation;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import net.passerines.avians.config.ConfigManager;
import net.passerines.avians.itemcreation.armorcreation.ArmorConfig;
import net.passerines.avians.itemcreation.weaponcreation.BladedConfig;
import net.passerines.avians.itemcreation.weaponcreation.PolearmConfig;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

public class ItemManager {
   public static HashMap<String, ItemConfig> ITEM_MAP = new HashMap();

   public static void loadItems() {
      Iterator var0 = ConfigManager.getAllFiles().iterator();

      while(var0.hasNext()) {
         File file = (File)var0.next();
         YamlConfiguration item = YamlConfiguration.loadConfiguration(file);

         String string;
         Object newItem;
         for(Iterator var3 = item.getKeys(false).iterator(); var3.hasNext(); ITEM_MAP.put(string, newItem)) {
            string = (String)var3.next();
            ConfigurationSection section = item.getConfigurationSection(string);
            String type = section.getString("Type", "item");
            byte var9 = -1;
            switch(type.hashCode()) {
            case -1386581172:
               if (type.equals("bladed")) {
                  var9 = 1;
               }
               break;
            case -398121052:
               if (type.equals("polearm")) {
                  var9 = 2;
               }
               break;
            case 93086015:
               if (type.equals("armor")) {
                  var9 = 3;
               }
            }

            switch(var9) {
            case 1:
               newItem = new BladedConfig(section);
               break;
            case 2:
               newItem = new PolearmConfig(section);
               break;
            case 3:
               newItem = new ArmorConfig(section);
               break;
            default:
               newItem = new ItemConfig(section);
            }

            if (type.equalsIgnoreCase("weapon")) {
            }
         }
      }

   }
}
