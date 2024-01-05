package net.passerines.avians.itemcreation.weaponcreation;

import java.util.List;
import net.kyori.adventure.text.Component;
import net.passerines.avians.constants.Stats;
import net.passerines.avians.util.Chat;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BladedConfig extends AttributedItemConfig {
   private final float sharpness;
   private final float initialSharpness;

   public BladedConfig(ConfigurationSection config) {
      super(config);
      this.sharpness = (float)config.getInt("sharpness", 100);
      this.initialSharpness = (float)config.getInt("initialSharpness", (int)this.sharpness);
   }

   public ItemStack generate() {
      ItemStack item = super.generate();
      ItemMeta itemMeta = this.updateLore(item);
      itemMeta.getPersistentDataContainer().set(Stats.SHARPNESS.getKey(), Stats.SHARPNESS.getValue(), this.initialSharpness);
      itemMeta.getPersistentDataContainer().set(Stats.MAX_SHARPNESS.getKey(), Stats.MAX_SHARPNESS.getValue(), this.sharpness);
      item.setItemMeta(itemMeta);
      return item;
   }

   public ItemMeta updateLore(ItemStack item) {
      ItemMeta itemMeta = super.updateLore(item);
      List<Component> lore = itemMeta.lore();
      lore.add(Chat.formatC("Sharpness: " + this.initialSharpness + "/" + this.sharpness));
      itemMeta.lore(lore);
      return itemMeta;
   }
}
