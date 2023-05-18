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

    public Elements.Element getElement() {
        return element;
    }

    public ElementalDamage setElement(Elements.Element element) {
        this.element = element;
        return this;
    }

    public Entity getAttacker() {
        return attacker;
    }

    public ElementalDamage setAttacker(Entity attacker) {
        this.attacker = attacker;
        return this;
    }

    public Entity getVictim() {
        return victim;
    }

    public ElementalDamage setVictim(Entity victim) {
        this.victim = victim;
        return this;
    }

    public float getAmount() {
        return amount;
    }

    public ElementalDamage setAmount(float amount) {
        this.amount = amount;
        return this;
    }
}
