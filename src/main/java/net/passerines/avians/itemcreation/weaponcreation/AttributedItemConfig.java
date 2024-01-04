package net.passerines.avians.itemcreation.weaponcreation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.kyori.adventure.text.Component;
import net.passerines.avians.constants.Stats;
import net.passerines.avians.itemcreation.ItemConfig;
import net.passerines.avians.util.Chat;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public abstract class AttributedItemConfig extends ItemConfig {
   private final float weight;
   private final float pen;
   private final float chipPercentage;
   private int health;
   private float healthRegen;
   private float mana;
   private float manaRegen;
   private int defense;
   private int strength;
   private int dexterity;
   private float speed;
   private int critDamage;
   private float critChance;
   private float critExecutionRate;
   private static final List<String> ITEMSTATS = new ArrayList();

   public AttributedItemConfig(ConfigurationSection config) {
      super(config);
      this.weight = (float)config.getInt("weight", 10);
      this.pen = (float)config.getInt("pen", 0);
      this.chipPercentage = (float)config.getInt("chipPercentage", 0);
      this.health = config.getInt("health", 0);
      this.healthRegen = (float)config.getInt("healthRegen", 0);
      this.mana = (float)config.getInt("mana", 0);
      this.manaRegen = (float)config.getInt("manaRegen", 0);
      this.defense = config.getInt("defense", 0);
      this.strength = config.getInt("strength", 0);
      this.dexterity = config.getInt("dexterity", 0);
      this.speed = (float)config.getInt("speed", 0);
      this.critDamage = config.getInt("critDmg", 0);
      this.critChance = (float)config.getDouble("critChance", 0.0D);
      this.critExecutionRate = (float)config.getDouble("critExecutionRate", 0.0D);
   }

   public ItemStack generate() {
      ItemStack item = super.generate();
      ItemMeta itemMeta = this.updateLore(item);
      itemMeta.getPersistentDataContainer().set((NamespacedKey)Stats.CHIP_PERCENTAGE.getKey(), (PersistentDataType)Stats.CHIP_PERCENTAGE.getValue(), this.chipPercentage);
      itemMeta.getPersistentDataContainer().set((NamespacedKey)Stats.CRITCHANCE.getKey(), (PersistentDataType)Stats.CRITCHANCE.getValue(), this.critChance);
      itemMeta.getPersistentDataContainer().set((NamespacedKey)Stats.CRITDAMAGE.getKey(), (PersistentDataType)Stats.CRITDAMAGE.getValue(), this.critDamage);
      itemMeta.getPersistentDataContainer().set((NamespacedKey)Stats.CRITEXECUTIONRATE.getKey(), (PersistentDataType)Stats.CRITEXECUTIONRATE.getValue(), this.critExecutionRate);
      itemMeta.getPersistentDataContainer().set((NamespacedKey)Stats.DEFENSE.getKey(), (PersistentDataType)Stats.DEFENSE.getValue(), this.defense);
      itemMeta.getPersistentDataContainer().set((NamespacedKey)Stats.DEXTERITY.getKey(), (PersistentDataType)Stats.DEXTERITY.getValue(), this.dexterity);
      itemMeta.getPersistentDataContainer().set((NamespacedKey)Stats.HEALTH.getKey(), (PersistentDataType)Stats.HEALTH.getValue(), this.health);
      itemMeta.getPersistentDataContainer().set((NamespacedKey)Stats.HEALTH_REGEN.getKey(), (PersistentDataType)Stats.HEALTH_REGEN.getValue(), this.healthRegen);
      itemMeta.getPersistentDataContainer().set((NamespacedKey)Stats.MANA.getKey(), (PersistentDataType)Stats.MANA.getValue(), this.mana);
      itemMeta.getPersistentDataContainer().set((NamespacedKey)Stats.MANA_REGEN.getKey(), (PersistentDataType)Stats.MANA_REGEN.getValue(), this.manaRegen);
      itemMeta.getPersistentDataContainer().set((NamespacedKey)Stats.PEN.getKey(), (PersistentDataType)Stats.PEN.getValue(), this.pen);
      itemMeta.getPersistentDataContainer().set((NamespacedKey)Stats.SPEED.getKey(), (PersistentDataType)Stats.SPEED.getValue(), this.speed);
      itemMeta.getPersistentDataContainer().set((NamespacedKey)Stats.STRENGTH.getKey(), (PersistentDataType)Stats.STRENGTH.getValue(), this.strength);
      itemMeta.getPersistentDataContainer().set((NamespacedKey)Stats.WEIGHT.getKey(), (PersistentDataType)Stats.WEIGHT.getValue(), this.weight);
      item.setItemMeta(itemMeta);
      return item;
   }

   public ItemMeta updateLore(ItemStack item) {
      ItemMeta itemMeta = item.getItemMeta();
      List<Component> lore = super.updateLore(item).lore();
      List<String> weaponStats = new ArrayList();
      Iterator var5 = ITEMSTATS.iterator();

      while(var5.hasNext()) {
         String line = (String)var5.next();
         String nLine = "";
         if (line.contains("<weight_pen_chip>")) {
            if (this.weight > 0.0F) {
               nLine = nLine + "Weight: " + this.weight + " | ";
            } else {
               nLine = nLine + "Weight: Weightless | ";
            }

            if (this.pen > 0.0F) {
               nLine = nLine + "&ePen: " + this.pen + " | ";
            }

            if (this.chipPercentage > 0.0F) {
               nLine = nLine + "&7Chip Percentage: " + this.chipPercentage + " | ";
            }
         }

         if (line.contains("<health_healthregen>")) {
            if (this.health > 0) {
               nLine = nLine + "&cHealth: " + this.weight + " | ";
            }

            if (this.healthRegen > 0.0F) {
               nLine = nLine + "&4Health Regen: " + this.healthRegen + " | ";
            }
         }

         if (nLine.length() > 2) {
            nLine = nLine.substring(0, nLine.length() - 3);
            weaponStats.add(nLine);
         }
      }

      lore.addAll(Chat.formatC((List)weaponStats));
      itemMeta.lore(lore);
      return itemMeta;
   }

   static {
      ITEMSTATS.add("<weight_pen_chip>");
      ITEMSTATS.add("<health_healthregen>");
      ITEMSTATS.add("<mana_manaregen>");
      ITEMSTATS.add("<strength_defense_dexterity>");
      ITEMSTATS.add("<movementspeed>");
      ITEMSTATS.add("<critdmg_critchance>");
      ITEMSTATS.add("<executionrate>");
   }
}
