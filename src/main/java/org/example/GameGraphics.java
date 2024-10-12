package org.example;

import org.example.GameContent.Coordinates;
import org.example.GameContent.Unit;
import org.example.GameContent.Infantry;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GameGraphics extends JFrame {

    GameLogic logic;
    Draw draw;
    Game game;
    public GameGraphics(GameLogic logic, Game game) throws HeadlessException {

        this.logic = logic;
        this.game = game;
        this.draw = new Draw();


        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Darkest Day");

        add(draw);

    }
    public void render(GameLogic logic) {
        this.logic = logic;
        repaint();
    }

    public class Draw extends JPanel{
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            List<Unit> units = logic.getUnits();

            for (Unit unit: units) {
                drawCharacter(g, unit);
            }
            if (game.isDragging()) {
                drawSelectionBox(g, game.getSelectionStart(),game.getSelectionEnd());
            }
        }
        private void drawSelectionBox(Graphics g, Coordinates selectionStart, Coordinates selectionEnd) {
            g.setColor(Color.BLUE);
            int x = Math.min(selectionStart.x, selectionEnd.x);
            int y = Math.min(selectionStart.y, selectionEnd.y);
            int width = Math.abs(selectionEnd.x - selectionStart.x);
            int height = Math.abs(selectionEnd.y - selectionStart.y);
            g.drawRect(x,y,width,height);

        }
        private void drawCharacter(Graphics g, Unit character) {
            int x = character.getPosition().x;
            int y = character.getPosition().y;

            if (character.isSelected()) {
                g.setColor(Color.green);
            } else {
                g.setColor(Color.blue);
            }


            g.fillOval(x-10,y-10,50,50);
        }
    }
}
