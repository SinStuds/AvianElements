package net.passerines.avians.commands;

import java.util.ArrayList;
import java.util.List;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.format.TextColor;
import net.passerines.avians.AvianElements;
import net.passerines.avians.itemcreation.ItemConfig;
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

public class ItemsCommand implements CommandExecutor, TabCompleter {
   private AvianElements plugin = AvianElements.inst();

   public ItemsCommand() {
      this.plugin.getCommand("itemgive").setExecutor(this);
      this.plugin.getCommand("itemgive").setTabCompleter(this);
   }

   public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
      if (sender.hasPermission("finch.admin")) {
         if (sender instanceof Player) {
            Player player = (Player)sender;
            if (args.length > 0) {
               if (!ItemManager.ITEM_MAP.containsKey(args[0])) {
                  sender.sendMessage(Chat.format("&cThere is no such item as: " + args[0]));
               } else {
                  ItemStack itemStack = ((ItemConfig)ItemManager.ITEM_MAP.get(args[0])).generate();
                  if (args.length > 1) {
                     int amount;
                     try {
                        amount = Integer.parseInt(args[1]);
                        if (player.getInventory().firstEmpty() < 0) {
                           Chat.sendTitle(player, "&cInventory Full");
                        } else {
                           itemStack.setAmount(amount);
                           player.getInventory().addItem(new ItemStack[]{itemStack});
                        }
                     } catch (NumberFormatException var12) {
                        Player targetPlayer = Util.matchPlayer(args[1]);
                        if (targetPlayer == null) {
                           sender.sendMessage(Chat.format("&cThere is no such player as: " + args[1]));
                           return true;
                        }

                        if (targetPlayer.getInventory().firstEmpty() < 0) {
                           Chat.sendTitle(player, "&cInventory Full");
                        } else if (args.length > 2) {
                           try {
                              amount = Integer.parseInt(args[2]);
                              itemStack.setAmount(amount);
                              targetPlayer.getInventory().addItem(new ItemStack[]{itemStack});
                           } catch (NumberFormatException var11) {
                              player.sendMessage("Amount null");
                           }
                        } else {
                           targetPlayer.getInventory().addItem(new ItemStack[]{itemStack});
                        }
                     }
                  } else if (player.getInventory().firstEmpty() < 0) {
                     Chat.sendTitle(player, "&cInventory Full");
                  } else {
                     player.getInventory().addItem(new ItemStack[]{itemStack});
                     Component msg = Component.text("Received item ");
                     Component msg = msg.style(msg.style().color(TextColor.color(120, 120, 255)));
                     msg = msg.append(itemStack.displayName().hoverEvent(itemStack.asHoverEvent()).clickEvent(ClickEvent.runCommand("/itemgive " + args[0])));
                     player.sendMessage(msg);
                  }
               }
            } else {
               sender.sendMessage(Chat.format("&cAnother argument is required for this command!"));
            }
         }
      } else {
         sender.sendMessage(Chat.format("&cYou don't have permissions for this command!"));
      }

      return false;
   }

   @Nullable
   public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
      ArrayList<String> results = new ArrayList();
      if (args.length <= 1) {
         Util.copyPartialContains(args[args.length - 1], ItemManager.ITEM_MAP.keySet(), results);
      }

      return results;
   }
}
