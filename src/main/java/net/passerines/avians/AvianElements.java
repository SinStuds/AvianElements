package net.passerines.avians;

import java.io.File;
import net.passerines.avians.commands.ItemsCommand;
import net.passerines.avians.commands.ReloadFilesCommand;
import net.passerines.avians.commands.StatsCommand;
import net.passerines.avians.config.ConfigManager;
import net.passerines.avians.element.DamageProcessing.AttackerDamageCalculations;
import net.passerines.avians.element.DamageProcessing.EntityDamageConverter;
import net.passerines.avians.element.DamageProcessing.VictimCalculations;
import net.passerines.avians.events.EquipmentChangeHandler;
import net.passerines.avians.events.ItemChangeListener;
import net.passerines.avians.itemcreation.ItemManager;
import net.passerines.avians.naturalhealth.NaturalHealthRegen;
import org.bukkit.plugin.java.JavaPlugin;

public class AvianElements extends JavaPlugin {
   public void onLoad() {
      System.out.println("Avian Elements has hooked onto your server");
      super.onLoad();
      ConfigManager.reloadFiles();
      ItemManager.loadItems();
   }

   public void onEnable() {
      if (!inst().getDataFolder().isDirectory()) {
         inst().getDataFolder().mkdir();
      }

      String var10000 = inst().getDataFolder().getPath();
      String str = var10000 + File.separator + "items";
      if (!(new File(str)).isDirectory()) {
         (new File(str)).mkdir();
      }

      new EntityMap();
      new VictimCalculations();
      new AttackerDamageCalculations();
      new EntityDamageConverter();
      new ItemsCommand();
      new ReloadFilesCommand();
      new StatsCommand();
      new ItemChangeListener();
      new EquipmentChangeHandler();
      new DeathEventListener();
      new NaturalHealthRegen();
   }

   public static AvianElements inst() {
      return getPlugin(AvianElements.class);
   }
}
