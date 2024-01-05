package net.passerines.avians;

import com.ticxo.modelengine.api.ModelEngineAPI;
import io.lumine.mythic.bukkit.events.MythicMobSpawnEvent;
import io.lumine.mythic.core.mobs.ActiveMob;
import java.util.HashMap;
import net.passerines.avians.config.SavesManager;
import net.passerines.avians.util.Util;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.persistence.PersistentDataType;

public class EntityMap implements Listener {
   private static final HashMap<Entity, EntityData> ENTITIES = new HashMap();

   public EntityMap() {
      Bukkit.getPluginManager().registerEvents(this, AvianElements.inst());
   }

   @EventHandler
   public void onMythicSpawn(MythicMobSpawnEvent event) {
      ActiveMob eventEntity = event.getMob();
      ENTITIES.put(event.getEntity(), new EntityData(eventEntity));
   }

   @EventHandler
   public void onVanillaSpawn(EntitySpawnEvent event) {
      Entity var3 = event.getEntity();
      if (var3 instanceof LivingEntity livingEntity) {
          if (event.getEntity().getPersistentDataContainer().has(NameSpacedKeys.FAKE_ENTITY, PersistentDataType.BYTE)) {
            return;
         }

         if (ModelEngineAPI.isModeledEntity(livingEntity.getUniqueId()) && !ModelEngineAPI.getModeledEntity(livingEntity.getUniqueId()).getBase().getUniqueId().equals(livingEntity.getUniqueId())) {
            return;
         }

         if (livingEntity.getPersistentDataContainer().has(NameSpacedKeys.FAKE_ENTITY)) {
            return;
         }

         ENTITIES.put(event.getEntity(), new EntityData(livingEntity));
         Util.log("Added: " + livingEntity.getType() + " to ENTITY MAP");
      }

   }

   @EventHandler
   public void onPlayerJoin(PlayerJoinEvent event) {
      ENTITIES.put(event.getPlayer(), new PlayerData(event.getPlayer()));
      SavesManager.loadPlayerData(event.getPlayer());
      String var10000 = event.getPlayer().getName();
      Util.log("Loaded " + var10000 + " with UUID of " + event.getPlayer().getUniqueId());
   }

   @EventHandler
   public void onPlayerLeave(PlayerQuitEvent event) {
      SavesManager.savePlayerData(event.getPlayer());
      ENTITIES.remove(event.getPlayer());
      String var10000 = event.getPlayer().getName();
      Util.log("Saved " + var10000 + " with UUID of " + event.getPlayer().getUniqueId());
   }

   @EventHandler
   public void onDeathEntity(EntityDeathEvent event) {
      remove(event.getEntity());
      Util.log("Removed: " + event.getEntity().getType() + " from ENTITY MAP");
   }

   public static EntityData get(Entity entity) {
      if (ModelEngineAPI.isModeledEntity(entity.getUniqueId())) {
         return ENTITIES.get(Bukkit.getEntity(ModelEngineAPI.getModeledEntity(entity.getUniqueId()).getBase().getUniqueId()));
      } else {
         return ModelEngineAPI.getModelTicker().getSubHitboxBone(entity.getUniqueId()) != null ? ENTITIES.get(Bukkit.getEntity(ModelEngineAPI.getModelTicker().getSubHitboxBone(entity.getUniqueId()).getActiveModel().getModeledEntity().getBase().getUniqueId())) : ENTITIES.get(entity);
      }
   }

   public static void remove(Entity entity) {
      ENTITIES.remove(entity);
   }

   public static boolean has(Entity entity) {
      return get(entity) != null;
   }
}
