package net.passerines.derp.util;

import net.passerines.derp.Derp;
import net.passerines.derp.math.Pair;
import org.bukkit.Bukkit;

import java.util.HashMap;

public class CooldownRunnable<T> {

    private int defaultCooldown;
    private HashMap<T, Pair<Integer, Integer>> cooldowns;

    public CooldownRunnable(int defaultCooldownTicks) {
        cooldowns = new HashMap<>();
        this.defaultCooldown = defaultCooldownTicks;
    }

    public void add(T target) {
        add(target, defaultCooldown);
    }
    public void add(T target, int ticks) {
        add(target, ticks, null);
    }
    public void add(T target, Runnable onEnd) {
        add(target, defaultCooldown, onEnd);
    }
    public void add(T target, int ticks, Runnable onEnd) {
        if(cooldowns.containsKey(target)) {
            Bukkit.getScheduler().cancelTask(cooldowns.get(target).getKey());
        }
        cooldowns.put(target, new Pair<>(
                Bukkit.getScheduler().scheduleSyncDelayedTask(Derp.inst(), () -> {
                    cooldowns.remove(target);
                    if(onEnd!=null) onEnd.run();
                }, ticks), Bukkit.getCurrentTick() + ticks
        ));
    }
    public void appendTask(T target, Runnable onEnd) {
        if(cooldowns.containsKey(target)) {
            Bukkit.getScheduler().cancelTask(cooldowns.get(target).getKey());
            cooldowns.put(target, new Pair<>(
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Derp.inst(), () -> {
                        cooldowns.remove(target);
                        if(onEnd!=null) onEnd.run();
                    }, getTicksLeft(target)), Bukkit.getCurrentTick() + getTicksLeft(target)
            ));
        }
    }

    public boolean isOffCooldown(T target) {
        return !cooldowns.containsKey(target);
    }
    public boolean isOnCooldown(T target) {
        return cooldowns.containsKey(target);
    }
    public int getTicksLeft(T target) {
        if(cooldowns.containsKey(target)) {
            return cooldowns.get(target).getValue() - Bukkit.getCurrentTick();
        } else {
            return -1;
        }
    }

    public void clear() {
        for(T target : cooldowns.keySet()) {
            if (cooldowns.containsKey(target)) {
                Bukkit.getScheduler().cancelTask(cooldowns.get(target).getKey());
            }
        }
    }

    public int getDefaultCooldown() {
        return defaultCooldown;
    }
}