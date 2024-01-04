package net.passerines.avians.util;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import com.comphenix.protocol.wrappers.EnumWrappers.ChatType;
import java.lang.reflect.InvocationTargetException;
import org.bukkit.entity.Player;

public class ProtocolLibIntegration {
   public static ProtocolManager manager = ProtocolLibrary.getProtocolManager();

   public static void sendJson(Player player, String message) {
      PacketContainer chat = manager.createPacket(Server.CHAT, true);
      chat.getChatTypes().write(0, ChatType.SYSTEM);
      chat.getChatComponents().write(0, WrappedChatComponent.fromJson(message));

      try {
         manager.sendServerPacket(player, chat);
      } catch (InvocationTargetException var4) {
         var4.printStackTrace();
      }

   }

   public static void sendActionBar(Player player, String message) {
      PacketContainer chat = manager.createPacket(Server.SET_ACTION_BAR_TEXT, true);
      chat.getChatComponents().write(0, WrappedChatComponent.fromText(Chat.format(message)));

      try {
         manager.sendServerPacket(player, chat);
      } catch (InvocationTargetException var4) {
         var4.printStackTrace();
      }

   }
}
