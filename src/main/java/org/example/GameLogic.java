package org.example;


import org.example.GameContent.Alien;
import org.example.GameContent.Human;

import java.util.ArrayList;
import java.util.List;

public class GameLogic {
    private List<Human> humans;
    private List<Alien> aliens;

    public GameLogic() {
        aliens = new ArrayList<>();
        humans = new ArrayList<>();
        aliens.add(new Alien(20,5,120,100));
        humans.add(new Human(20,5,120,200));
    }

    public List<Human> getHumans() {
        return humans;
    }

    public List<Alien> getAliens() {
        return aliens;
    }
}
