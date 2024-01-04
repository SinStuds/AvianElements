package net.passerines.avians.itemcreation;

import java.util.List;
import net.kyori.adventure.text.Component;
import net.passerines.avians.util.Chat;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemConfig {
   private final String name;
   private final String id;
   private final String type;
   private final List<String> lore;
   private final Material material;
   private final int customModelData;

   public ItemConfig(ConfigurationSection config) {
      this.name = config.getString("Name", "null:noname");
      this.id = config.getName();
      this.type = config.getString("Type", "item");
      this.lore = config.getStringList("Lore");
      this.material = Material.valueOf(config.getString("Material", "paper").toUpperCase());
      this.customModelData = config.getInt("CustomModelData", 0);
   }

   public ItemStack generate() {
      ItemStack item = new ItemStack(this.material);
      ItemMeta itemMeta = item.getItemMeta();
      itemMeta.displayName(Chat.formatC(this.name));
      itemMeta.lore(Chat.formatC(this.lore));
      itemMeta.setCustomModelData(this.customModelData);
      itemMeta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES});
      itemMeta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_UNBREAKABLE});
      item.setItemMeta(itemMeta);
      return item;
   }

   public ItemMeta updateLore(ItemStack item) {
      ItemMeta itemMeta = item.getItemMeta();
      List<Component> lore = Chat.formatC(this.lore);
      itemMeta.lore(lore);
      return itemMeta;
   }
}
