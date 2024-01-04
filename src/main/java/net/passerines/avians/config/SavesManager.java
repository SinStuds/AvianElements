package net.passerines.avians.config;

import java.io.File;
import java.io.IOException;
import net.passerines.avians.AvianElements;
import net.passerines.avians.EntityData;
import net.passerines.avians.EntityMap;
import net.passerines.avians.PlayerData;
import net.passerines.avians.util.Util;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class SavesManager {
   public static PlayerData loadPlayerData(Player player) {
      PlayerData playerData = new PlayerData(player);
      File baseDirectory = AvianElements.inst().getDataFolder();
      String var10002 = baseDirectory.getPath();
      File savesDirectory = new File(var10002 + File.separator + "saves");
      if (!savesDirectory.isDirectory()) {
         savesDirectory.mkdir();
      }

      var10002 = savesDirectory.getPath();
      File saveFile = new File(var10002 + File.separator + player.getUniqueId() + ".yml");
      YamlConfiguration save = YamlConfiguration.loadConfiguration(saveFile);
      double persistentHealth = save.getDouble("Persistent.stat.health");
      double persistentDefense = save.getDouble("Persistent.stat.defense");
      double persistentMana = save.getDouble("Persistent.stat.defense");
      int masteryBlade = save.getInt("Mastery.Blade", 1);
      int masteryBlunt = save.getInt("Mastery.Blunt", 1);
      int masteryBow = save.getInt("Mastery.Bow", 1);
      int masteryArcane = save.getInt("Mastery.Arcane", 1);
      playerData.setHealth(persistentHealth);
      playerData.setDefense((float)persistentDefense);
      playerData.setMana(persistentMana);
      playerData.setBladedMastery(masteryBlade);
      playerData.setBluntMastery(masteryBlunt);
      playerData.setRangedMastery(masteryBow);
      playerData.setArcaneMastery(masteryArcane);
      return playerData;
   }

   public static void savePlayerData(Player player) {
      File baseDirectory = AvianElements.inst().getDataFolder();
      String var10002 = baseDirectory.getPath();
      File savesDirectory = new File(var10002 + File.separator + "saves");
      if (!savesDirectory.isDirectory()) {
         savesDirectory.mkdir();
      }

      var10002 = savesDirectory.getPath();
      File saveFile = new File(var10002 + File.separator + player.getUniqueId() + ".yml");
      YamlConfiguration config = new YamlConfiguration();
      EntityData var6 = EntityMap.get(player);
      if (var6 instanceof PlayerData) {
         PlayerData data = (PlayerData)var6;
         config.set("Mastery.Blade", data.getBladedMastery());
         config.set("Mastery.Blunt", data.getBluntMastery());
         config.set("Mastery.Bow", data.getRangedMastery());
         config.set("Mastery.Arcane", data.getArcaneMastery());
         config.set("Stats.Health", data.getHealth());
         config.set("Stats.Mana", data.getMana());

         try {
            config.save(saveFile);
         } catch (IOException var7) {
            Util.log("IOException occurred Saving Player Failed");
         }
      }

   }
}
