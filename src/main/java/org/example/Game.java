package org.example;

import org.example.GameContent.Unit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class Game {


    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Game();
            }
        });
    }
    public Game() {
        GameLogic logic = new GameLogic();
        GameGraphics graphic = new GameGraphics(logic);
        graphic.render(logic);

        graphic.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                List<Unit> units = logic.getUnits();
                boolean clickedOnUnit = false;

                for (Unit unit: units) {
                    int x = unit.getPosition().x;
                    int y = unit.getPosition().y;

                    if (e.getX() >= x - 10 && e.getX() <= x + 40 && e.getY() >= y - 10 && e.getY() <= y + 40) {
                       unit.setSelected(true);
                       clickedOnUnit = true;
                    } else {
                        unit.setSelected(false);
                    }
                }


                    if (!clickedOnUnit) {
                        for (Unit unit: units) {
                            unit.setSelected(false);
                        }
                    }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                graphic.render(logic);
            }
        });
        timer.start();
    }
}
