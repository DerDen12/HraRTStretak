package org.example;


import org.example.GameContent.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameLogic {
    private List<Unit> units;
    private Coordinates moveTo;


    public GameLogic() {
        units = new ArrayList<>();
        Coordinates position = new Coordinates(200,200);
        Coordinates secondposition = new Coordinates(300,200);
        units.add(new Infantry(position,"Infantry",20,20,2,1));
        units.add(new Infantry(secondposition,"Infantry",20,20,2,1));


    }
    public void update() {
        synchronized (units) {
            if (moveTo != null) {
            Iterator<Unit> iterator = units.iterator();
            while (iterator.hasNext()) {
                Unit unit = iterator.next();
                if(unit.isSelected()) {
                    Direction direction = chooseDirection(unit.getPosition(), moveTo);
                    unit.move(1, direction);
                }
                }
            }
        }

    }

    private Direction chooseDirection(Coordinates position, Coordinates moveTo) {
        int differenceX = moveTo.x - position.x;
        int differenceY = moveTo.y - position.y;

        if (differenceX == 0 && differenceY < 0) {
            return Direction.UP;
        } else if (differenceX == 0 && differenceY > 0) {
            return Direction.DOWN;
        } else if (differenceY == 0 && differenceX < 0) {
            return Direction.LEFT;
        } else if (differenceY == 0 && differenceX > 0) {
            return Direction.RIGHT;
        } else if (differenceX < 0 && differenceY < 0) {
            return Direction.UP_LEFT;
        } else if (differenceX > 0 && differenceY < 0) {
            return Direction.UP_RIGHT;
        } else if (differenceX < 0 && differenceY > 0) {
            return Direction.DOWN_LEFT;
        } else if (differenceX > 0 && differenceY > 0) {
            return Direction.DOWN_RIGHT;
        }
        return null;
    }

    public List<Unit> getUnits() {
        return units;
    }

    public void setMoveTo(Coordinates moveTo) {
        this.moveTo = moveTo;
    }
}
