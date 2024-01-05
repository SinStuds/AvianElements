package net.passerines.avians.commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.format.TextColor;

import net.passerines.avians.AvianElements;
import net.passerines.avians.config.ConfigManager;
import net.passerines.avians.itemcreation.ItemManager;
import net.passerines.avians.util.Chat;
import net.passerines.avians.util.Util;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.geom.QuadCurve2D;
import java.util.ArrayList;
import java.util.List;

public class ItemsCommand implements CommandExecutor, TabCompleter {
    private final AvianElements plugin = AvianElements.inst();
    public ItemsCommand(){
        plugin.getCommand("itemgive").setExecutor(this);
        plugin.getCommand("itemgive").setTabCompleter(this);
    }

    //        not included    0         1       2  (index)
    // Length in array is 3   1         2       3
    //if args is /itemgive "itemname" , give 1 item to commandSender
    //if args is /itemgive "itemname" player amount , give amount item to player
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("finch.admin")){
            if(sender instanceof Player player) {
                ItemStack itemStack;
                int amount;
                if(args.length > 0){
                    if(ItemManager.ITEM_MAP.containsKey(args[0])){
                        itemStack = ItemManager.ITEM_MAP.get(args[0]).generate();
                        if(args.length > 1){
                            try {
                                //if args is /itemgive "itemname" amount , give amount item to commandSender
                                amount = Integer.parseInt(args[1]);
                                if(player.getInventory().firstEmpty() < 0){
                                    Chat.sendTitle(player, "&cInventory Full");
                                }
                                else{
                                    itemStack.setAmount(amount);
                                    player.getInventory().addItem(itemStack);
                                }
                            }
                            catch(NumberFormatException e){
                                Player targetPlayer = Util.matchPlayer(args[1]);
                                if(targetPlayer != null){
                                    //if args is /itemgive "itemname" player , give 1 item to player
                                    if(targetPlayer.getInventory().firstEmpty() < 0){
                                        Chat.sendTitle(player, "&cInventory Full");
                                    }
                                    else if(args.length > 2){
                                        try{
                                            amount = Integer.parseInt(args[2]);
                                            itemStack.setAmount(amount);
                                            targetPlayer.getInventory().addItem(itemStack);
                                        }
                                        catch(NumberFormatException ev){
                                            player.sendMessage("Amount null");
                                        }
                                    }
                                    else{
                                        targetPlayer.getInventory().addItem(itemStack);
                                    }
                                }
                                else{
                                    sender.sendMessage(Chat.format("&cThere is no such player as: " + args[1]));
                                    return true;
                                }
                            }
                        }
                        else{
                            if(player.getInventory().firstEmpty() < 0){
                                Chat.sendTitle(player, "&cInventory Full");
                            }
                            else{
                                player.getInventory().addItem(itemStack);
                                Component msg = Component.text("Received item ");
                                msg = msg.style(msg.style().color(TextColor.color(120, 120, 255)));
                                msg = msg.append(itemStack.displayName().hoverEvent(itemStack.asHoverEvent()).clickEvent(ClickEvent.runCommand("/itemgive " + args[0])));
                                player.sendMessage(msg);
                            }
                        }
                    }
                    else{
                        sender.sendMessage(Chat.format("&cThere is no such item as: " + args[0]));
                    }
                }
                else{
                    sender.sendMessage(Chat.format("&cAnother argument is required for this command!"));
                }
            }
        }
        else{
            sender.sendMessage(Chat.format("&cYou don't have permissions for this command!"));
        }
        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        ArrayList<String> results = new ArrayList<>();
        if(args.length<=1) {
            Util.copyPartialContains(args[args.length-1], ItemManager.ITEM_MAP.keySet(), results);
        }
        return results;
    }
}
