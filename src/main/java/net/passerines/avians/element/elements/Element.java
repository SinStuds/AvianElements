package net.passerines.avians.element.elements;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.passerines.avians.util.Chat;

public enum Element {
   FIRE("Fire", TextColor.color(255, 128, 0)),
   FIRE_SULFUREOUS("Sulfureous Fire", TextColor.color(255, 255, 0)),
   FIRE_UNYIELDING("Unyielding Inferno", TextColor.color(255, 0, 0)),
   FIRE_AZURE("Azure Flames", TextColor.color(51, 255, 255));

   private final String name;
   private final TextColor color;
   private final Component displayName;

   private Element(String name, TextColor color) {
      this.name = name;
      this.color = color;
      this.displayName = Chat.formatC(name).color(color);
   }

   public String getName() {
      return this.name;
   }

   public TextColor getColor() {
      return this.color;
   }

   public Component getDisplayName() {
      return this.displayName;
   }

   // $FF: synthetic method
   private static Element[] $values() {
      return new Element[]{FIRE, FIRE_SULFUREOUS, FIRE_UNYIELDING, FIRE_AZURE};
   }
}
