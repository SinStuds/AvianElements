package net.passerines.avians.itemcreation.armorcreation;

import net.kyori.adventure.text.Component;
import net.passerines.avians.constants.Stats;
import net.passerines.avians.itemcreation.weaponcreation.AttributedItemConfig;
import net.passerines.avians.util.Chat;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ArmorConfig extends AttributedItemConfig {

   public ArmorConfig(ConfigurationSection config) {
      super(config);
   }

   public ItemStack generate() {
      ItemStack item = super.generate();
      ItemMeta itemMeta = this.updateLore(item);
      item.setItemMeta(itemMeta);
      return item;
   }

   public ItemMeta updateLore(ItemStack item) {
      ItemMeta itemMeta = super.updateLore(item);
      List<Component> lore = itemMeta.lore();
      itemMeta.lore(lore);
      return itemMeta;
   }
}
