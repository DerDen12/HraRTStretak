package org.example.GameContent;
public class Building extends GameObject {
    private String name;
    private int health;
    private int people;

    public Building(Coordinates position, String name, String name1, int health, int people) {
        super(position, name);
        this.name = name1;
        this.health = health;
        this.people = people;
    }

}
