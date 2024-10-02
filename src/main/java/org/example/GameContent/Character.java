package org.example.GameContent;

public abstract class Character {
    private int health;
    private int damage;
    private int rangeResistance;
    private int meleeResistance;

    public Character(int health, int damage, int rangeResistance, int meleeResistance) {
        this.health = health;
        this.damage = damage;
        this.rangeResistance = rangeResistance;
        this.meleeResistance = meleeResistance;
    }
}
