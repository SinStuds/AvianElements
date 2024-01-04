package net.passerines.avians;

import net.passerines.avians.constants.Stats;
import net.passerines.avians.events.slotstatsystem.SlotHashmap;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

public class PlayerData extends EntityData {
   private SlotHashmap slotHashmap;
   private int bladedMastery;
   private int bluntMastery;
   private int pointedMastery;
   private int rangedMastery;
   private int arcaneMastery;
   private int trapDurationBonus;
   private int trapDamageBonus;
   private int minionDamageBonus;
   private int minionHealthBonus;
   private int minionDefenseBonus;
   private int minionElemenalBonus;
   private int maxMinions;
   private Player player;

   public PlayerData(Player player) {
      super((LivingEntity)player);
      this.player = player;
      this.slotHashmap = new SlotHashmap(player);
   }

   public void calculate(ItemStack item) {
      if (item != null && item.getItemMeta() != null) {
         this.setMaxHealth(this.getMaxHealth() + (Integer)item.getItemMeta().getPersistentDataContainer().getOrDefault((NamespacedKey)Stats.HEALTH.getKey(), (PersistentDataType)Stats.HEALTH.getValue(), 0));
         this.setHealthRegen(this.getHealthRegen() + (Float)item.getItemMeta().getPersistentDataContainer().getOrDefault((NamespacedKey)Stats.HEALTH_REGEN.getKey(), (PersistentDataType)Stats.HEALTH_REGEN.getValue(), 0.0F));
         this.setStrength(this.getStrength() + (Integer)item.getItemMeta().getPersistentDataContainer().getOrDefault((NamespacedKey)Stats.STRENGTH.getKey(), (PersistentDataType)Stats.STRENGTH.getValue(), 0));
         this.setDexterity(this.getDexterity() + (Integer)item.getItemMeta().getPersistentDataContainer().getOrDefault((NamespacedKey)Stats.DEXTERITY.getKey(), (PersistentDataType)Stats.DEXTERITY.getValue(), 0));
         this.setMaxDefense(this.getMaxDefense() + (Integer)item.getItemMeta().getPersistentDataContainer().getOrDefault((NamespacedKey)Stats.DEFENSE.getKey(), (PersistentDataType)Stats.DEFENSE.getValue(), 0));
         this.setCritChance(this.getCritChance() + (Float)item.getItemMeta().getPersistentDataContainer().getOrDefault((NamespacedKey)Stats.CRITCHANCE.getKey(), (PersistentDataType)Stats.CRITCHANCE.getValue(), 0.0F));
         this.setCritDamage(this.getCritDamage() + (Integer)item.getItemMeta().getPersistentDataContainer().getOrDefault((NamespacedKey)Stats.CRITDAMAGE.getKey(), (PersistentDataType)Stats.CRITDAMAGE.getValue(), 0));
         this.setCritExecutionRate(this.getCritExecutionRate() + (double)(Float)item.getItemMeta().getPersistentDataContainer().getOrDefault((NamespacedKey)Stats.CRITEXECUTIONRATE.getKey(), (PersistentDataType)Stats.CRITEXECUTIONRATE.getValue(), 0.0F));
      }

   }

   public int getBladedMastery() {
      return this.bladedMastery;
   }

   public PlayerData setBladedMastery(int bladedMastery) {
      this.bladedMastery = bladedMastery;
      return this;
   }

   public int getBluntMastery() {
      return this.bluntMastery;
   }

   public PlayerData setBluntMastery(int bluntMastery) {
      this.bluntMastery = bluntMastery;
      return this;
   }

   public int getRangedMastery() {
      return this.rangedMastery;
   }

   public PlayerData setRangedMastery(int rangedMastery) {
      this.rangedMastery = rangedMastery;
      return this;
   }

   public int getArcaneMastery() {
      return this.arcaneMastery;
   }

   public PlayerData setArcaneMastery(int arcaneMastery) {
      this.arcaneMastery = arcaneMastery;
      return this;
   }

   public int getPointedMastery() {
      return this.pointedMastery;
   }

   public PlayerData setPointedMastery(int pointedMastery) {
      this.pointedMastery = pointedMastery;
      return this;
   }

   public int getTrapDurationBonus() {
      return this.trapDurationBonus;
   }

   public PlayerData setTrapDurationBonus(int trapDurationBonus) {
      this.trapDurationBonus = trapDurationBonus;
      return this;
   }

   public int getTrapDamageBonus() {
      return this.trapDamageBonus;
   }

   public PlayerData setTrapDamageBonus(int trapDamageBonus) {
      this.trapDamageBonus = trapDamageBonus;
      return this;
   }

   public int getMinionDamageBonus() {
      return this.minionDamageBonus;
   }

   public PlayerData setMinionDamageBonus(int minionDamageBonus) {
      this.minionDamageBonus = minionDamageBonus;
      return this;
   }

   public int getMinionHealthBonus() {
      return this.minionHealthBonus;
   }

   public PlayerData setMinionHealthBonus(int minionHealthBonus) {
      this.minionHealthBonus = minionHealthBonus;
      return this;
   }

   public int getMinionDefenseBonus() {
      return this.minionDefenseBonus;
   }

   public PlayerData setMinionDefenseBonus(int minionDefenseBonus) {
      this.minionDefenseBonus = minionDefenseBonus;
      return this;
   }

   public int getMinionElemenalBonus() {
      return this.minionElemenalBonus;
   }

   public PlayerData setMinionElemenalBonus(int minionElemenalBonus) {
      this.minionElemenalBonus = minionElemenalBonus;
      return this;
   }

   public int getMaxMinions() {
      return this.maxMinions;
   }

   public PlayerData setMaxMinions(int maxMinions) {
      this.maxMinions = maxMinions;
      return this;
   }

   public SlotHashmap getSlotHashmap() {
      return this.slotHashmap;
   }
}
