package net.passerines.avians.element.DamageProcessing;

import io.lumine.mythic.core.mobs.ActiveMob;
import net.passerines.avians.AvianElements;
import net.passerines.avians.EntityMap;
import net.passerines.avians.element.elementalDamage.ElementalDamage;
import net.passerines.avians.element.elementalDamage.fire.FireDamage;
import net.passerines.avians.element.elements.Elements;
import net.passerines.avians.util.MythicMobsUtil;
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
        if(MythicMobsUtil.getActiveMob(event.getEntity()) != null){
            ActiveMob activeMob = MythicMobsUtil.getActiveMob(event.getEntity());
            switch(EntityMap.get(event.getEntity()).getElement().getId()){
                case "fire" -> {
                    new FireDamage(event.getDamager(), event.getEntity(), (float) event.getDamage(), 10, 60).apply();
                }
            }
        }
    }
}
