package net.passerines.avians.commands;

import net.passerines.avians.AvianElements;
import net.passerines.avians.EntityMap;
import net.passerines.avians.PlayerData;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StatsCommand implements CommandExecutor {
   private AvianElements plugin = AvianElements.inst();

   public StatsCommand() {
      this.plugin.getCommand("stats").setExecutor(this);
   }

   public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
      if (sender instanceof Player) {
         Player player = (Player)sender;
         PlayerData playerData = (PlayerData)EntityMap.get(player);
         int var10001 = playerData.getMaxHealth();
         sender.sendMessage("Max Health: " + var10001 + " Health: " + playerData.getHealth() + " Health Regen: " + playerData.getHealthRegen());
         var10001 = playerData.getMaxDefense();
         sender.sendMessage("Max Defense: " + var10001 + " Defense: " + playerData.getDefense());
         var10001 = playerData.getMaxMana();
         sender.sendMessage("Max Mana: " + var10001 + " Mana: " + playerData.getMana() + " Mana Regen: " + playerData.getManaRegen());
         float var7 = playerData.getCritChance();
         sender.sendMessage("Crit Chance: " + var7 + " Crit Damage: " + playerData.getCritDamage() + " Crit Execution Rate: " + playerData.getCritExecutionRate());
         var10001 = playerData.getStrength();
         sender.sendMessage("Strength: " + var10001 + " Dexterity: " + playerData.getDexterity() + " Speed: " + playerData.getSpeed());
      }

      return false;
   }
}
