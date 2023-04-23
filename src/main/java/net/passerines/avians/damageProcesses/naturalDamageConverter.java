package net.passerines.avians.damageProcesses;

import net.passerines.avians.AvianElements;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class naturalDamageConverter implements Listener{
    public naturalDamageConverter(){
        Bukkit.getPluginManager().registerEvents(this, AvianElements.inst());
    }
    @EventHandler
    public void damageReceiver(EntityDamageEvent event){
        EntityDamageEvent.DamageCause damageCause = event.getCause();

    }
}
