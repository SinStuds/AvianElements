package net.passerines.avians.util;

import io.lumine.mythic.api.mobs.MythicMob;
import io.lumine.mythic.bukkit.BukkitAdapter;
import io.lumine.mythic.bukkit.MythicBukkit;
import io.lumine.mythic.core.mobs.ActiveMob;
import java.util.Optional;
import net.passerines.avians.AvianElements;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class MythicMobsUtil {
   public static final AvianElements plugin = AvianElements.inst();
   public static final MythicBukkit mm = MythicBukkit.inst();

   public static ActiveMob spawnMob(String id, Location location) {
      return mm.getMobManager().getMythicMob(id).isPresent() ? ((MythicMob)mm.getMobManager().getMythicMob(id).get()).spawn(BukkitAdapter.adapt(location), 0.0D) : null;
   }

   public static ActiveMob getActiveMob(Entity entity) {
      if (entity == null) {
         return null;
      } else {
         Optional<ActiveMob> mob = mm.getMobManager().getActiveMob(entity.getUniqueId());
         return (ActiveMob)mob.orElse((Object)null);
      }
   }

   public static String getDisplayName(String id) {
      Optional<MythicMob> mob = mm.getMobManager().getMythicMob(id);
      return mob.isPresent() ? ((MythicMob)mob.get()).getDisplayName().get() : id;
   }
}
