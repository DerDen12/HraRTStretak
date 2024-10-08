package org.example.GameContent;

public class Unit extends GameObject {
    private int health;
    private int damage;
    private int population;
    private int team;
    private boolean selected;

    public Unit(Coordinates position, String name, int health, int damage, int population, int team) {
        super(position, name);
        this.health = health;
        this.damage = damage;
        this.population = population;
        this.team = team;
        this.selected = false;
    }
    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

}

