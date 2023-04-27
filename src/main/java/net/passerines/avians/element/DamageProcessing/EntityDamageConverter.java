package net.passerines.avians.element.DamageProcessing;

import net.passerines.avians.AvianElements;
import net.passerines.avians.element.elements.Elements;
import org.bukkit.Bukkit;
import org.bukkit.entity.Damageable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;


public class EntityDamageConverter implements Listener{
    public EntityDamageConverter(){
        Bukkit.getPluginManager().registerEvents(this, AvianElements.inst());
    }
    @EventHandler
    public void damageReceiver(EntityDamageByEntityEvent event){
        if(event.getEntity() instanceof Damageable damageable){

        }
    }
}
