package net.passerines.avians.config;

import net.passerines.avians.AvianElements;
import net.passerines.avians.EntityMap;
import net.passerines.avians.PlayerData;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class SavesManager {
    public static PlayerData loadPlayerData(Player player){
        PlayerData playerData = new PlayerData(player);
        File baseDirectory = AvianElements.inst().getDataFolder();
        File savesDirectory = new File(baseDirectory.getPath()+File.separator+"saves");
        if(!savesDirectory.isDirectory()) savesDirectory.mkdir();
        File saveFile = new File(savesDirectory.getPath()+File.separator+player.getUniqueId()+".yml");
        YamlConfiguration save = YamlConfiguration.loadConfiguration(saveFile);

        //Random example
        double persistentHealth = save.getDouble("Persistent.stat.health");
        double persistentDefense = save.getDouble("Persistent.stat.defense");
        double persistentMana = save.getDouble("Persistent.stat.defense");
        int masteryBlade = save.getInt("Mastery.Blade", 1);
        int masteryBlunt = save.getInt("Mastery.Blunt", 1);
        int masteryBow = save.getInt("Mastery.Bow", 1);
        int masteryArcane = save.getInt("Mastery.Arcane", 1);
        playerData.setBladedMastery(masteryBlade);
        playerData.setBluntMastery(masteryBlunt);
        playerData.setRangedMastery(masteryBow);
        playerData.setArcaneMastery(masteryArcane);
        return playerData;
    }
    public static void savePlayerData(Player player){
        File baseDirectory = AvianElements.inst().getDataFolder();
        File savesDirectory = new File(baseDirectory.getPath()+File.separator+"saves");
        if(!savesDirectory.isDirectory()) savesDirectory.mkdir();
        File saveFile = new File(savesDirectory.getPath()+File.separator+player.getUniqueId()+".yml");

        YamlConfiguration config = new YamlConfiguration();
        if(EntityMap.get(player) instanceof PlayerData data) {
            config.set("Mastery.Blade", data.getBladedMastery());
            config.set("Mastery.Blunt", data.getBluntMastery());
            config.set("Mastery.Bow", data.getRangedMastery());
            config.set("Mastery.Arcane", data.getArcaneMastery());
            try {
                config.save(saveFile);
            } catch (IOException e) {
                //say yeet
            }
        }
    }
}
