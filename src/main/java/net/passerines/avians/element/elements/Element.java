package net.passerines.avians.element.elements;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.passerines.avians.util.Chat;

public enum Element {

    //  To get the element by ID, use Element.valueOf(String name)
    //      name is case sensitive, use full uppercase such as "FIRE"
    //  To get name by enum use .name()
    //      for example, Element.FIRE.name()
    //  To compare enums, use ==
    //      for example, event.getElement()==Element.FIRE

    FIRE("Fire", TextColor.color(255, 128, 0)),
    FIRE_SULFUREOUS("Sulfureous Fire", TextColor.color(255, 255, 0)),
    FIRE_UNYIELDING("Unyielding Inferno", TextColor.color(255, 0, 0)),
    FIRE_AZURE("Azure Flames", TextColor.color(51, 255, 255));

    private final String name;
    private final TextColor color;
    private final Component displayName;
    Element(String name, TextColor color) {
        this.name = name;
        this.color = color;
        displayName = Chat.formatC(name).color(color);
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

