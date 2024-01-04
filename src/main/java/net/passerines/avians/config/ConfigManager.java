package net.passerines.avians.config;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import net.passerines.avians.AvianElements;
import net.passerines.avians.util.Util;

public class ConfigManager {
   private static final HashMap<String, File> FILE_MAP = new HashMap();

   public static void loadDirectories(File directory) {
      File[] var1 = directory.listFiles();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         File file = var1[var3];
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

   public static void reloadFiles() {
      File baseDirectory = AvianElements.inst().getDataFolder();
      String var10002 = baseDirectory.getPath();
      File itemsDirectory = new File(var10002 + File.separator + "items");
      Util.log("Loading Files!");
      FILE_MAP.clear();
      loadDirectories(itemsDirectory);
   }

   public static Collection<File> getAllFiles() {
      return FILE_MAP.values();
   }
}
