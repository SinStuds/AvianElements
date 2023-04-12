package net.passerines.avians;

import org.bukkit.plugin.java.JavaPlugin;

public class AvianElements extends JavaPlugin {

    @Override
    public void onLoad() {
        System.out.println("Avian Elements has hooked onto your server");
        super.onLoad();
    }
    @Override
    public void onEnable(){
        new EntityMap();
    }
    public static AvianElements inst() {
        return AvianElements.getPlugin(AvianElements.class);
    }

}
