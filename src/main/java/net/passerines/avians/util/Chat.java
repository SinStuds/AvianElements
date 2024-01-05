package net.passerines.avians.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.StyleBuilderApplicable;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import net.kyori.adventure.title.TitlePart;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Chat {
   public static String format(String str) {
      str = applyColorCode(str);
      return str;
   }

   public static List<String> format(List<String> list) {
      for(int i = 0; i < list.size(); ++i) {
         list.set(i, format(list.get(i)));
      }

      return list;
   }

   public static String formatTime(int seconds) {
      return String.format("%d:%02d", seconds / 60, seconds % 60);
   }

   public static String applyColorCode(String str) {
      return ChatColor.translateAlternateColorCodes('&', str);
   }

   public static void sendTitle(Player player, String title) {
      player.sendTitlePart(TitlePart.TITLE, formatC(title));
   }

   public static void sendSubtitle(Player player, String subtitle) {
      player.sendTitlePart(TitlePart.SUBTITLE, formatC(subtitle));
   }

   public static void sendJson(Player player, String json) {
      ProtocolLibIntegration.sendJson(player, json);
   }

   public static void sendActionBar(Player player, String message) {
      ProtocolLibIntegration.sendActionBar(player, message);
   }

   public static String asPlainText(Component component) {
      return PlainTextComponentSerializer.plainText().serialize(component);
   }

   public static String asLegacy(Component component) {
      return LegacyComponentSerializer.legacyAmpersand().serialize(component);
   }

   public static ArrayList<String> asLegacy(List<Component> components) {
      ArrayList<String> list = new ArrayList();
      Iterator var2 = components.iterator();

      while(var2.hasNext()) {
         Component component = (Component)var2.next();
         list.add(LegacyComponentSerializer.legacyAmpersand().serialize(component));
      }

      return list;
   }

   public static String asGson(Component component) {
      return GsonComponentSerializer.gson().serialize(component);
   }

   public static Component asComponent(String str) {
      return LegacyComponentSerializer.legacySection().deserialize(str).applyFallbackStyle(TextDecoration.ITALIC.withState(false), NamedTextColor.WHITE);
   }

   public static List<Component> asComponent(List<String> list) {
      List<Component> components = new ArrayList();
      Iterator var2 = list.iterator();

      while(var2.hasNext()) {
         String str = (String)var2.next();
         components.add(asComponent(str));
      }

      return components;
   }

   public static Component formatC(String str) {
      return LegacyComponentSerializer.legacyAmpersand().deserialize(str).applyFallbackStyle(TextDecoration.ITALIC.withState(false), NamedTextColor.WHITE);
   }

   public static List<Component> formatC(List<String> list) {
      List<Component> components = new ArrayList();
      Iterator var2 = list.iterator();

      while(var2.hasNext()) {
         String str = (String)var2.next();
         components.add(formatC(str));
      }

      return components;
   }
}
