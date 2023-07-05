package net.passerines.avians;

import net.passerines.avians.commands.ItemsCommand;
import net.passerines.avians.config.ConfigManager;
import net.passerines.avians.element.DamageProcessing.AttackerDamageCalculations;
import net.passerines.avians.element.DamageProcessing.EntityDamageConverter;
import net.passerines.avians.element.DamageProcessing.VictimCalculations;
import net.passerines.avians.itemcreation.ItemManager;
import org.bukkit.plugin.java.JavaPlugin;

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
        new EntityMap();
        new VictimCalculations();
        new AttackerDamageCalculations();
        new EntityDamageConverter();
        new OnEntityDeathEvent();
        new ItemsCommand();
    }
    public static AvianElements inst() {
        return AvianElements.getPlugin(AvianElements.class);
    }


}
