package net.passerines.avians.element.elements;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.passerines.avians.util.Chat;

public class Elements {

    //Fire and sub elements
    public static final Element FIRE = new Element("fire", "Fire", TextColor.color(255, 128, 0));
    public static final Element FIRE_SULFUREOUS = new Element("fire_sulfureous", "Sulfureous Fire", TextColor.color(255, 255, 0));
    public static final Element FIRE_UNYIELDING = new Element("fire_unyielding", "Unyielding Inferno", TextColor.color(255, 0, 0));
    public static final Element FIRE_AZURE = new Element("fire_azure", "Azure Flames", TextColor.color(51, 255, 255));

    public static class Element {
        private final String id;
        private final String name;
        private final TextColor color;
        private final Component displayName;
        private Element(String id, String name, TextColor color) {
            this.id = id;
            this.name = name;
            this.color = color;
            displayName = Chat.formatC(name).color(color);
        }

        public String getId() {
            return id;
        }
        public String getName() {
            return name;
        }
        public TextColor getColor() {
            return color;
        }
        public Component getDisplayName() {
            return displayName;
        }
    }
}
