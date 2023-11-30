package net.passerines.avians;

import net.passerines.avians.commands.ItemsCommand;
import net.passerines.avians.commands.ReloadFilesCommand;
import net.passerines.avians.commands.StatsCommand;
import net.passerines.avians.config.ConfigManager;
import net.passerines.avians.constants.Stats;
import net.passerines.avians.element.DamageProcessing.AttackerDamageCalculations;
import net.passerines.avians.element.DamageProcessing.EntityDamageConverter;
import net.passerines.avians.element.DamageProcessing.VictimCalculations;
import net.passerines.avians.events.EquipmentChangeHandler;
import net.passerines.avians.events.ItemChangeListener;
import net.passerines.avians.itemcreation.ItemManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class AvianElements extends JavaPlugin {

    @Override
    public void onLoad() {
        System.out.println("Avian Elements has hooked onto your server");
        super.onLoad();
        ConfigManager.reloadFiles();
        ItemManager.loadItems();

    }
    @Override
    public void onEnable(){
        if(!AvianElements.inst().getDataFolder().isDirectory()){
            AvianElements.inst().getDataFolder().mkdir();
        }
        String str = AvianElements.inst().getDataFolder().getPath()+File.separator+"items";
        if(!new File(str).isDirectory()){
            new File(str).mkdir();
        }
        new EntityMap();
        new VictimCalculations();
        new AttackerDamageCalculations();
        new EntityDamageConverter();
        new OnEntityDeathEvent();
        new ItemsCommand();
        new ReloadFilesCommand();
        new StatsCommand();
        new ItemChangeListener();
        new EquipmentChangeHandler();
    }
    public static AvianElements inst() {
        return AvianElements.getPlugin(AvianElements.class);
    }


}
