package net.passerines.avians.commands;

import net.passerines.avians.AvianElements;
import net.passerines.avians.config.ConfigManager;
import net.passerines.avians.itemcreation.ItemManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadFilesCommand implements CommandExecutor {
    private AvianElements plugin = AvianElements.inst();

    public ReloadFilesCommand() {
        plugin.getCommand("raload").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        ItemManager.ITEM_MAP.clear();
        ConfigManager.reloadFiles();
        ItemManager.loadItems();
        return false;
    }
}
