package net.passerines.avians.commands;

import net.passerines.avians.AvianElements;
import net.passerines.avians.EntityMap;
import net.passerines.avians.PlayerData;
import net.passerines.avians.config.ConfigManager;
import net.passerines.avians.itemcreation.ItemManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StatsCommand implements CommandExecutor {
    private AvianElements plugin = AvianElements.inst();
    public StatsCommand() {
        plugin.getCommand("stats").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player player) {
            PlayerData playerData = (PlayerData) EntityMap.get(player);
            sender.sendMessage("Max Health: " + playerData.getMaxHealth() + " Health: " + playerData.getHealth() + " Health Regen: " + playerData.getHealthRegen());
            sender.sendMessage("Max Defense: " + playerData.getMaxDefense() + " Defense: " + playerData.getDefense());
            sender.sendMessage("Max Mana: " + playerData.getMaxMana() + " Mana: " + playerData.getMana() + " Mana Regen: " + playerData.getManaRegen());
            sender.sendMessage("Strength: " + playerData.getStrength() + " Dexterity: " + playerData.getDexterity() + " Speed: " + playerData.getSpeed());
        }
        return false;
    }
}
