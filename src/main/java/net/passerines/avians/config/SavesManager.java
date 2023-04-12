package net.passerines.avians.config;

import net.passerines.avians.AvianElements;
import net.passerines.avians.PlayerData;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class SavesManager {
    public static PlayerData loadPlayerData(Player player){
        PlayerData playerData = new PlayerData(player);
        File baseDirectory = AvianElements.inst().getDataFolder();
        File savesDirectory = new File(baseDirectory.getPath()+File.separator+"saves");
        if(!savesDirectory.isDirectory()) savesDirectory.mkdir();
        File saveFile = new File(savesDirectory.getPath()+File.separator+player.getUniqueId()+".yml");
        YamlConfiguration save = YamlConfiguration.loadConfiguration(saveFile);

        //Random example
        int masteryBlade = save.getInt("Mastery.Blade", 1);
        int masteryBlunt = save.getInt("Mastery.Blunt", 1);
        int masteryBow = save.getInt("Mastery.Bow", 1);
        int masteryArcane = save.getInt("Mastery.Arcane", 1);
        playerData.setBladedMastery(masteryBlade);
        playerData.setBluntMastery(masteryBlunt);
        playerData.setBowMastery(masteryBow);
        playerData.setArcaneMastery(masteryArcane);
        return playerData;
    }
    public static void savePlayerData(Player player){
        YamlConfiguration config = null;
        File baseDirectory = AvianElements.inst().getDataFolder();
        File savesDirectory = new File(baseDirectory.getPath()+File.separator+"saves");
        if(!savesDirectory.isDirectory()) savesDirectory.mkdir();
        File saveFile = new File(savesDirectory.getPath()+File.separator+player.getUniqueId()+".yml");
        try {
            config.save(saveFile);
        } catch(IOException e) {
            //say yeet
        }
    }
}
