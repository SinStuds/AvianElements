package net.passerines.avians.events;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import net.passerines.avians.AvianElements;
import net.passerines.avians.EntityMap;
import net.passerines.avians.PlayerData;
import net.passerines.avians.util.Util;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.ItemStack;

public class EquipmentChangeHandler implements Listener {
   public EquipmentChangeHandler() {
      Bukkit.getPluginManager().registerEvents(this, AvianElements.inst());
   }

   @EventHandler
   public void onArmorChange(PlayerArmorChangeEvent event) {
      Bukkit.getPluginManager().callEvent(new ItemChangeEvent(event.getPlayer(), event.getNewItem()));
   }

   @EventHandler
   public void playerSwitchItem(PlayerSwapHandItemsEvent event) {
      Player player = event.getPlayer();
      Bukkit.getPluginManager().callEvent(new ItemChangeEvent(player, event.getMainHandItem()));
   }

   @EventHandler
   public void onDrop(PlayerDropItemEvent event) {
      Player player = event.getPlayer();
      if (player.getInventory().getItemInMainHand().getType().isAir()) {
         Bukkit.getPluginManager().callEvent(new ItemChangeEvent(player, new ItemStack(Material.AIR)));
      }

   }

   @EventHandler
   public void onWeaponChange(PlayerItemHeldEvent event) {
      Player player = event.getPlayer();
      Bukkit.getPluginManager().callEvent(new ItemChangeEvent(player, player.getInventory().getItem(event.getNewSlot())));
   }

   @EventHandler
   public void dragEvent(InventoryDragEvent event) {
      Player player = (Player)event.getWhoClicked();
      if (player.getInventory().getItemInMainHand().getType().isAir()) {
         Bukkit.getScheduler().scheduleSyncDelayedTask(AvianElements.inst(), () -> {
            if (!player.getInventory().getItemInMainHand().getType().isAir()) {
               Bukkit.getPluginManager().callEvent(new ItemChangeEvent(player, player.getInventory().getItemInMainHand()));
            }

         });
      }

   }

   @EventHandler
   public void pickupEvent(EntityPickupItemEvent event) {
      LivingEntity var3 = event.getEntity();
      if (var3 instanceof Player player) {
          if (player.getInventory().getItemInMainHand().getType().isAir()) {
            Bukkit.getScheduler().scheduleSyncDelayedTask(AvianElements.inst(), () -> {
               if (!player.getInventory().getItemInMainHand().getType().isAir()) {
                  Bukkit.getPluginManager().callEvent(new ItemChangeEvent(player, player.getInventory().getItemInMainHand()));
               }

            });
         }
      }

   }

   @EventHandler
   public void onJoin(PlayerJoinEvent event) {
      Player player = event.getPlayer();
      PlayerData playerData = (PlayerData)EntityMap.get(player);
      Bukkit.getPluginManager().callEvent(new ItemChangeEvent(player, player.getInventory().getItemInMainHand()));
   }

   @EventHandler
   public void onItemChange(ItemChangeEvent itemChangeEvent) {
      Player player = itemChangeEvent.getPlayer();
      PlayerData playerData = (PlayerData)EntityMap.get(player);
      playerData.getSlotHashmap().setAllSlots();
      Util.log("OnItemChangeEventCalled");
   }
}
