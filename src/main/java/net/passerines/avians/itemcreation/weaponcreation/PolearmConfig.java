package net.passerines.avians.itemcreation.weaponcreation;

import java.util.List;
import net.kyori.adventure.text.Component;
import net.passerines.avians.constants.Stats;
import net.passerines.avians.util.Chat;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class PolearmConfig extends AttributedItemConfig {
   private final double range;

   public PolearmConfig(ConfigurationSection config) {
      super(config);
      this.range = config.getDouble("range", 3.5D);
   }

   public ItemStack generate() {
      ItemStack item = super.generate();
      ItemMeta itemMeta = this.updateLore(item);
      itemMeta.getPersistentDataContainer().set(Stats.RANGE.getKey(), Stats.RANGE.getValue(), this.range);
      item.setItemMeta(itemMeta);
      return item;
   }

   public ItemMeta updateLore(ItemStack item) {
      ItemMeta itemMeta = super.updateLore(item);
      List<Component> lore = itemMeta.lore();
      lore.add(Chat.formatC("Range: " + this.range));
      itemMeta.lore(lore);
      return itemMeta;
   }
}
