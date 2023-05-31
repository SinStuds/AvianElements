package net.passerines.avians;

import net.passerines.avians.util.Util;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnEntityDeathEvent implements Listener {
    public OnEntityDeathEvent(){
        Bukkit.getPluginManager().registerEvents(this, AvianElements.inst());
    }
    @EventHandler
    public void onDeath(DeathEvent event){
        if(!(EntityMap.get(event.getDeadVictim()) instanceof Player)){
            LivingEntity victim = (LivingEntity) event.getDeadVictim();
            EntityMap.remove(victim);
            Util.log("Registered Mob Died: " + victim.getName());
            EntityMap.remove(victim);
            victim.damage(99999);
            victim.remove();
        }
    }
}
