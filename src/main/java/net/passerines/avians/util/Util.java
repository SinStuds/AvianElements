package net.passerines.avians.util;


import net.passerines.avians.AvianElements;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class Util {
    public static List<String> getOnlinePlayerNames() {
        ArrayList<String> names = new ArrayList<>();
        for(Player player : Bukkit.getOnlinePlayers()) {
            names.add(player.getName());
        }
        return names;
    }
    public static boolean isSafe(ItemStack item) {
        if(item!=null) {
            return item.getItemMeta() != null;
        }
        return false;
    }
    public static NamespacedKey getNamespacedKey(String name) {
        return new NamespacedKey(AvianElements.getPlugin(AvianElements.class), name);
    }
    public static void log(String message) {
        Bukkit.getConsoleSender().sendMessage(Chat.format("&7[&bFinchElementalDamage&7] &f" + message));
    }
}
