package net.passerines.avians.util;

import io.lumine.mythic.api.mobs.MythicMob;
import io.lumine.mythic.bukkit.BukkitAdapter;
import io.lumine.mythic.bukkit.MythicBukkit;
import io.lumine.mythic.core.mobs.ActiveMob;
import net.passerines.avians.AvianElements;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.event.Listener;

import java.net.http.WebSocket;
import java.util.Optional;

public class MythicMobsUtil {
    public static final AvianElements plugin = AvianElements.inst();
    public static final MythicBukkit mm = MythicBukkit.inst();

    public static ActiveMob spawnMob(String id, Location location) {
        if(mm.getMobManager().getMythicMob(id).isPresent()) {
            return mm.getMobManager().getMythicMob(id).get().spawn(BukkitAdapter.adapt(location), 0);
        }
        return null;
    }

    public static ActiveMob getActiveMob(Entity entity) {
        if(entity==null) return null;
        Optional<ActiveMob> mob = mm.getMobManager().getActiveMob(entity.getUniqueId());
        return mob.orElse(null);
    }

    public static String getDisplayName(String id) {
        Optional<MythicMob> mob = mm.getMobManager().getMythicMob(id);
        if(mob.isPresent()) {
            return mob.get().getDisplayName().get();
        } else {
            return id;
        }
    }
}
