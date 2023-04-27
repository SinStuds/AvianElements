package net.passerines.avians;

import com.ticxo.modelengine.api.ModelEngineAPI;
import io.lumine.mythic.bukkit.events.MythicMobSpawnEvent;
import io.lumine.mythic.core.mobs.ActiveMob;
import net.passerines.avians.config.SavesManager;
import net.passerines.avians.util.Chat;
import net.passerines.avians.util.Util;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.persistence.PersistentDataType;

import java.util.HashMap;

public class EntityMap implements Listener {
    private static final HashMap<Entity, EntityData> ENTITIES = new HashMap<>();
    public EntityMap(){
        Bukkit.getPluginManager().registerEvents(this, AvianElements.inst());
    }

    @EventHandler
    public void onMythicSpawn(MythicMobSpawnEvent event){
        ActiveMob eventEntity = event.getMob();
        ENTITIES.put(event.getEntity(), new EntityData((Entity) eventEntity));
    }
    @EventHandler
    public void onVanillaSpawn(EntitySpawnEvent event){
        if(event.getEntity() instanceof LivingEntity livingEntity) {
            if (event.getEntity().getPersistentDataContainer().has(NameSpacedKeys.FAKE_ENTITY, PersistentDataType.BYTE))
                return;
            if(ModelEngineAPI.isModeledEntity(livingEntity.getUniqueId())) {
                if(!ModelEngineAPI.getModeledEntity(livingEntity.getUniqueId()).getBase().getUniqueId().equals(livingEntity.getUniqueId())) {
                    return;
                }
            }
            if(livingEntity.getPersistentDataContainer().has(NameSpacedKeys.FAKE_ENTITY)){
                return;
            }
            ENTITIES.put(event.getEntity(), new EntityData(livingEntity));
            Util.log("Added: " + livingEntity.getType() + " to ENTITY MAP");
        }
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        ENTITIES.put(event.getPlayer(), new PlayerData(event.getPlayer()));
        SavesManager.loadPlayerData(event.getPlayer());
        Util.log("Loaded " + event.getPlayer().getName() + " with UUID of " + event.getPlayer().getUniqueId());
    }
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event){
        ENTITIES.remove(event.getPlayer());
        SavesManager.savePlayerData(event.getPlayer());
        Util.log("Saved " + event.getPlayer().getName() + " with UUID of " + event.getPlayer().getUniqueId());
    }


    public static EntityData get(Entity entity) {
        if(ModelEngineAPI.isModeledEntity(entity.getUniqueId())) {
            return ENTITIES.get(Bukkit.getEntity(ModelEngineAPI.getModeledEntity(entity.getUniqueId()).getBase().getUniqueId()));
        }
        else if(ModelEngineAPI.getModelTicker().getSubHitboxBone(entity.getUniqueId())!=null) {
            return ENTITIES.get(Bukkit.getEntity(ModelEngineAPI.getModelTicker().getSubHitboxBone(entity.getUniqueId()).getActiveModel().getModeledEntity().getBase().getUniqueId()));
        }
        else {
            return ENTITIES.get(entity);
        }
    }

    public static void remove(Entity entity) {
        ENTITIES.remove(entity);
    }
    public static boolean has(Entity entity) {
        return get(entity)!=null;
    }
}
