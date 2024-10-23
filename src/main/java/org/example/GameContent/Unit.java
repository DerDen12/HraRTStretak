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

    public void move(int steps,Direction direction) {

        switch (direction) {
            case LEFT -> {
                this.getPosition().x -= steps;
            }
            case RIGHT -> {
                this.getPosition().x += steps;
            }
            case UP -> {
                this.getPosition().y -= steps;
            }
            case DOWN -> {
                this.getPosition().y += steps;
            }
            case UP_LEFT -> {
                this.getPosition().x -= steps;
                this.getPosition().y -= steps;
            }
            case UP_RIGHT -> {
                this.getPosition().x += steps;
                this.getPosition().y -= steps;
            }
            case DOWN_LEFT -> {
                this.getPosition().x -= steps;
                this.getPosition().y += steps;
            }
            case DOWN_RIGHT -> {
                this.getPosition().x += steps;
                this.getPosition().y += steps;
            }
        }
    }
    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

}

