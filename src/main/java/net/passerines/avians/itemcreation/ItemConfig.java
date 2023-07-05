package net.passerines.avians.itemcreation;

import net.passerines.avians.util.Chat;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.Locale;

public class ItemConfig {
    private final String name;
    private final String id;
    private final String type;
    private final List<String> lore;
    private final Material material;
    private final int customModelData;
    public ItemConfig(ConfigurationSection config){
        name = config.getString("Name", "null:noname");
        id = config.getName();
        type = config.getString("Type", "item");
        lore = config.getStringList("Lore");
        material = Material.valueOf(config.getString("Material", "paper").toUpperCase());
        customModelData = config.getInt("CustomModelData", 0);
    }
    public ItemStack generate(){
        ItemStack item = new ItemStack(material);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.displayName(Chat.formatC(name));
        itemMeta.lore(Chat.formatC(lore));
        itemMeta.setCustomModelData(customModelData);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(itemMeta);
        return item;
    }
}
