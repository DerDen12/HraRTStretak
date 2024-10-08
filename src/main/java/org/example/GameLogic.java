package org.example;


import org.example.GameContent.Coordinates;
import org.example.GameContent.Infantry;
import org.example.GameContent.Unit;

import java.util.ArrayList;
import java.util.List;

public class GameLogic {
    private List<Unit> units;

    public GameLogic() {
        units = new ArrayList<>();
        Coordinates position = new Coordinates(200,200);
        Coordinates secondposition = new Coordinates(300,200);
        units.add(new Infantry(position,"Infantry",20,20,2,1));
        units.add(new Infantry(secondposition,"Infantry",20,20,2,1));

    }

    public List<Unit> getUnits() {
        return units;
    }

}
