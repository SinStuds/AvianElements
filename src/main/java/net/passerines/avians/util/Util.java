package net.passerines.avians.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import net.passerines.avians.AvianElements;
import org.apache.commons.lang.Validate;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class Util {
   public static List<String> getOnlinePlayerNames() {
      ArrayList<String> names = new ArrayList();
      Iterator var1 = Bukkit.getOnlinePlayers().iterator();

      while(var1.hasNext()) {
         Player player = (Player)var1.next();
         names.add(player.getName());
      }

      return names;
   }

   public static boolean isSafe(ItemStack item) {
      if (item != null) {
         return item.getItemMeta() != null;
      } else {
         return false;
      }
   }

   public static NamespacedKey getNamespacedKey(String name) {
      return new NamespacedKey(AvianElements.getPlugin(AvianElements.class), name);
   }

   public static void log(String message) {
      Bukkit.getConsoleSender().sendMessage(Chat.format("&7[&bAvianElements&7] &f" + message));
   }

   public static Player matchPlayer(String name) {
      List<Player> players = Bukkit.matchPlayer(name);
      if (players.size() > 0) {
         Iterator var2 = players.iterator();
         if (var2.hasNext()) {
            Player player = (Player)var2.next();
            if (player.getName().equals(name)) {
               return player;
            }

            return players.get(0);
         }
      }

      return null;
   }

   @NotNull
   public static <T extends Collection<? super String>> T copyPartialContains(@NotNull String token, @NotNull Iterable<String> originals, @NotNull T collection) throws UnsupportedOperationException, IllegalArgumentException {
      Validate.notNull(token, "Search token cannot be null");
      Validate.notNull(collection, "Collection cannot be null");
      Validate.notNull(originals, "Originals cannot be null");
      Iterator targets = originals.iterator();

      while(targets.hasNext()) {
         String str = (String)targets.next();
         if (str.toLowerCase().contains(token.toLowerCase())) {
            collection.add(str);
         }
      }

      return collection;
   }
}
