package net.passerines.avians.element.elementalDamage;

import net.passerines.avians.element.elements.Elements;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.EntityDamageEvent;

import java.awt.*;

public abstract class ElementalDamage {
    protected Elements.Element element;
    protected Entity attacker;
    protected Entity victim;
    protected float amount;
    public ElementalDamage(Elements.Element element, Entity attacker, Entity victim, float amount){}

    public abstract void onHit();
}
