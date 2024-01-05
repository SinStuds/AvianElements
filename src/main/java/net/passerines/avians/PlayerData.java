package net.passerines.avians;

import net.passerines.avians.constants.Stats;
import net.passerines.avians.events.slotstatsystem.SlotHashmap;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

public class PlayerData extends EntityData {
   private final SlotHashmap slotHashmap;
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
   private final Player player;

   public PlayerData(Player player) {
      super(player);
      this.player = player;
      this.slotHashmap = new SlotHashmap(player);
   }

   public void calculate(ItemStack item) {
      if (item != null && item.getItemMeta() != null) {
         this.setMaxHealth(this.getMaxHealth() + item.getItemMeta().getPersistentDataContainer().getOrDefault(Stats.HEALTH.getKey(), Stats.HEALTH.getValue(), 0));
         this.setHealthRegen(this.getHealthRegen() + item.getItemMeta().getPersistentDataContainer().getOrDefault(Stats.HEALTH_REGEN.getKey(), Stats.HEALTH_REGEN.getValue(), 0.0F));
         this.setStrength(this.getStrength() + item.getItemMeta().getPersistentDataContainer().getOrDefault(Stats.STRENGTH.getKey(), Stats.STRENGTH.getValue(), 0));
         this.setDexterity(this.getDexterity() + item.getItemMeta().getPersistentDataContainer().getOrDefault(Stats.DEXTERITY.getKey(), Stats.DEXTERITY.getValue(), 0));
         this.setMaxDefense(this.getMaxDefense() + item.getItemMeta().getPersistentDataContainer().getOrDefault(Stats.DEFENSE.getKey(), Stats.DEFENSE.getValue(), 0));
         this.setCritChance(this.getCritChance() + item.getItemMeta().getPersistentDataContainer().getOrDefault(Stats.CRITCHANCE.getKey(), Stats.CRITCHANCE.getValue(), 0.0F));
         this.setCritDamage(this.getCritDamage() + item.getItemMeta().getPersistentDataContainer().getOrDefault(Stats.CRITDAMAGE.getKey(), Stats.CRITDAMAGE.getValue(), 0));
         this.setCritExecutionRate(this.getCritExecutionRate() + (double) item.getItemMeta().getPersistentDataContainer().getOrDefault(Stats.CRITEXECUTIONRATE.getKey(), Stats.CRITEXECUTIONRATE.getValue(), 0.0F));
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
