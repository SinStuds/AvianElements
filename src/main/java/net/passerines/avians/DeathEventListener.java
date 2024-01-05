package net.passerines.avians;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class DeathEventListener implements Listener {
    public DeathEventListener(){
        Bukkit.getPluginManager().registerEvents(this, AvianElements.inst());
    }
    @EventHandler
    public void onDeathEvent(DeathEvent deathEvent){
        Entity victim = deathEvent.getDeadVictim();
        if(victim instanceof Player player){
            for (ItemStack itemStack : player.getInventory().getContents()) {
                if(itemStack != null) {
                    player.getWorld().dropItem(player.getLocation(), itemStack);
                }
            }
            if(player.getBedSpawnLocation() != null) {
                player.teleport(player.getBedSpawnLocation());
            }
            else {
                player.teleport(player.getWorld().getSpawnLocation());
            }

        }
    }
}
