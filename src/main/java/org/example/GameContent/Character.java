package org.example.GameContent;

public abstract class Character {
    private int health;
    private int damage;
    private Coordinates position;

    public Character(int health, int damage, int x, int y) {
        this.health = health;
        this.damage = damage;
        this.position = new Coordinates(x,y);
    }

    public Coordinates getPosition() {
        return position;
    }

    public void setPosition(Coordinates position) {
        this.position = position;
    }
}
