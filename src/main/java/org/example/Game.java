package org.example;

import org.example.GameContent.Coordinates;
import org.example.GameContent.Unit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;


public class Game {

    private Coordinates selectionStart;
    private Coordinates selectionEnd;
    private boolean dragging = false;

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Game();
            }
        });
    }
    public Game() {
        GameLogic logic = new GameLogic();
        GameGraphics graphic = new GameGraphics(logic,this);
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
                selectionStart = new Coordinates(e.getX(),e.getY());
                selectionEnd = selectionStart;
                dragging = true;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                dragging = false;
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        graphic.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                selectionEnd = new Coordinates(e.getX(),e.getY());
            }

            @Override
            public void mouseMoved(MouseEvent e) {

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
    public boolean isDragging() {
        return dragging;
    }

    public Coordinates getSelectionStart() {
        return selectionStart;
    }

    public Coordinates getSelectionEnd() {
        return selectionEnd;
    }
}
