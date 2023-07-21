package net.passerines.avians.itemcreation.weaponcreation;

import net.kyori.adventure.text.Component;
import net.passerines.avians.constants.Stats;
import net.passerines.avians.util.Chat;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;


public class BladedConfig extends WeaponConfig{
    private final int sharpness;
    private final int initialSharpness;
    public BladedConfig(ConfigurationSection config) {
        super(config);
        sharpness = config.getInt("sharpness", 100);
        initialSharpness = (int) config.get("initialSharpness", sharpness);
    }
    @Override
    public ItemStack generate(){
        ItemStack item = super.generate();
        ItemMeta itemMeta = updateLore(item);
        itemMeta.getPersistentDataContainer().set(Stats.SHARPNESS.getKey(), Stats.SHARPNESS.getValue(), initialSharpness);
        itemMeta.getPersistentDataContainer().set(Stats.MAX_SHARPNESS.getKey(), Stats.MAX_SHARPNESS.getValue(), sharpness);
        item.setItemMeta(itemMeta);
        return item;
    }
    @Override
    public ItemMeta updateLore(ItemStack item){
        ItemMeta itemMeta = super.updateLore(item);
        List<Component> lore = itemMeta.lore();
        lore.add(Chat.formatC("Sharpness: " + initialSharpness + "/" + sharpness));
        itemMeta.lore(lore);
        return itemMeta;
    }
}
