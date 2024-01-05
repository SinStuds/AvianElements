package net.passerines.avians.itemcreation.weaponcreation;

import net.kyori.adventure.text.Component;
import net.passerines.avians.constants.Stats;
import net.passerines.avians.util.Chat;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;


public class PolearmConfig extends WeaponConfig{
    private final double range;
    public PolearmConfig(ConfigurationSection config) {
        super(config);
        range = config.getDouble("range", 3.5);
    }
    @Override
    public ItemStack generate(){
        ItemStack item = super.generate();
        ItemMeta itemMeta = updateLore(item);
        itemMeta.getPersistentDataContainer().set(Stats.RANGE.getKey(), Stats.RANGE.getValue(), range);
        item.setItemMeta(itemMeta);
        return item;
    }
    @Override
    public ItemMeta updateLore(ItemStack item){
        ItemMeta itemMeta = super.updateLore(item);
        List<Component> lore = itemMeta.lore();
        lore.add(Chat.formatC("Range: " + range));
        itemMeta.lore(lore);
        return itemMeta;
    }
}
