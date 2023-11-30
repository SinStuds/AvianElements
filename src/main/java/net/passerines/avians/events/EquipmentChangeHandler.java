package net.passerines.avians.events;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import net.passerines.avians.AvianElements;
import net.passerines.avians.EntityMap;
import net.passerines.avians.PlayerData;
import net.passerines.avians.events.slotstatsystem.SlotHashmap;
import net.passerines.avians.util.Util;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.ItemStack;

public class EquipmentChangeHandler implements Listener {
    public EquipmentChangeHandler(){
        Bukkit.getPluginManager().registerEvents(this, AvianElements.inst());
    }
    @EventHandler
    public void onArmorChange(PlayerArmorChangeEvent event) {
        Bukkit.getPluginManager().callEvent(new ItemChangeEvent(event.getPlayer(), event.getNewItem()));
    }
    @EventHandler
    public void playerSwitchItem(PlayerSwapHandItemsEvent event){
        Player player = event.getPlayer();
        //PlayerMap.PLAYERS.get(player).calculateHand(event.getMainHandItem());
        Bukkit.getPluginManager().callEvent(new ItemChangeEvent(player, event.getMainHandItem()));
    }
    @EventHandler
    public void onDrop(PlayerDropItemEvent event){
        Player player = event.getPlayer();
        if(player.getInventory().getItemInMainHand().getType().isAir()) {
            //PlayerMap.PLAYERS.get(player).calculateHand(new ItemStack(Material.AIR));
            Bukkit.getPluginManager().callEvent(new ItemChangeEvent(player, new ItemStack(Material.AIR)));
        }
    }
    /*@EventHandler
    public void onWeaponInventoryChange(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        Bukkit.getScheduler().scheduleSyncDelayedTask(AvianElements.inst(),()->{
            if(EntityMap.get(player).getOldItem() == null || !EntityMap.get(player).getOldItem().isSimilar(player.getInventory().getItemInMainHand())) {
                //PlayerMap.PLAYERS.get(player).calculateHand(player.getInventory().getItemInMainHand());
                Bukkit.getPluginManager().callEvent(new ItemChangeEvent(player, player.getInventory().getItemInMainHand()));
            }
        });
    }*/
    @EventHandler
    public void onWeaponChange(PlayerItemHeldEvent event){
        Player player = event.getPlayer();
        //PlayerMap.PLAYERS.get(player).calculateHand(player.getInventory().getItem(event.getNewSlot()));
        Bukkit.getPluginManager().callEvent(new ItemChangeEvent(player, player.getInventory().getItem(event.getNewSlot())));

    }
    @EventHandler
    public void dragEvent(InventoryDragEvent event){
        Player player = (Player) event.getWhoClicked();
        if(player.getInventory().getItemInMainHand().getType().isAir()) {
            Bukkit.getScheduler().scheduleSyncDelayedTask(AvianElements.inst(), ()->{
                if(!player.getInventory().getItemInMainHand().getType().isAir()){
                    //PlayerMap.PLAYERS.get(player).calculateHand(player.getInventory().getItemInMainHand());
                    Bukkit.getPluginManager().callEvent(new ItemChangeEvent(player, player.getInventory().getItemInMainHand()));
                }
            });
        }
    }
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        PlayerData playerData = (PlayerData) EntityMap.get(player);
        playerData.getSlotHashmap().setAllSlots();
    }

    @EventHandler
    public void onItemChange(ItemChangeEvent itemChangeEvent){
        Player player = itemChangeEvent.getPlayer();
        PlayerData playerData = (PlayerData) EntityMap.get(player);
        playerData.getSlotHashmap().setAllSlots();
        Util.log("OnItemChangeEventCalled");
    }
}
