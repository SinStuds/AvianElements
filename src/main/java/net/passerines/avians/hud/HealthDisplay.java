package net.passerines.avians.hud;

import net.passerines.avians.AvianElements;
import net.passerines.avians.EntityMap;
import net.passerines.avians.PlayerData;
import net.passerines.avians.element.DamageProcessing.ElementalDamageEvent;
import net.passerines.avians.util.Chat;
import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class HealthDisplay implements Listener {
    public HealthDisplay(){
        Bukkit.getPluginManager().registerEvents(this, AvianElements.inst());
    }

    @EventHandler
    public void sendBarOnDamage(ElementalDamageEvent event){
        Entity victim = event.getElementalDamage().getVictim();
        if(victim instanceof Player){
            updateActionBar((Player) victim);
        }
    }


    public static void updateActionBar(Player player){
        PlayerData playerData = (PlayerData) EntityMap.get(player);
        if(playerData!=null) {
            int maxDefense = playerData.getMaxDefense();
            float defense = playerData.getDefense();

            int maxHealth = playerData.getMaxHealth();
            float currentHealth = playerData.getHealth();

            int maxMana = playerData.getMaxMana();
            float currentMana = playerData.getMana();

            float percentHealth = currentHealth/maxHealth;
            float vanillaMaxHealth = (float) player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
            int vanillaHealth = (int)Math.ceil(percentHealth*vanillaMaxHealth);
            if(player.getHealth()!=vanillaHealth)player.setHealth(Math.max(0, Math.min(vanillaMaxHealth, vanillaHealth)));

            String bar = Chat.format("&cHealth: " + currentHealth + "/" + maxHealth + "    &aDefense: " + defense + "/" + maxDefense + "    &bMana: " + currentMana + "/" + maxMana);
            Chat.sendActionBar(player, bar);
        }
    }
}
