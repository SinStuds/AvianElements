package net.passerines.avians.config;

import net.passerines.avians.AvianElements;
import net.passerines.avians.util.Util;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;

public class ConfigManager {
    private static final HashMap<String, File> FILE_MAP = new HashMap<>();
    public static void loadDirectories(File directory) {
        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                loadDirectories(file);
                Util.log("Loaded Directory " + file.getName());
            } else if (file.isFile() && file.getName().endsWith(".yml")) {
                FILE_MAP.put(file.getPath(), file);
                Util.log("Loading " + file.getName());

            } else {
                Util.log("&4Unrecognized File " + file.getName());
            }
        }
    }
    public static void reloadFiles(){
        File baseDirectory = AvianElements.inst().getDataFolder();
        File itemsDirectory = new File(baseDirectory.getPath()+File.separator+"items");
        Util.log("Loading Files!");
        FILE_MAP.clear();
        loadDirectories(itemsDirectory);
    }
    public static Collection<File> getAllFiles(){
        return FILE_MAP.values();
    }
}
