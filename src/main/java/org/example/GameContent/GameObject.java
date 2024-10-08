package org.example.GameContent;

public class GameObject {
    private Coordinates position;
    private String name;

    public GameObject(Coordinates position, String name) {
        this.position = position;
        this.name = name;
    }

    public Coordinates getPosition() {
        return position;
    }

    public void setPosition(Coordinates position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
