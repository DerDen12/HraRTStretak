package org.example;

import org.example.GameContent.Alien;
import org.example.GameContent.Character;
import org.example.GameContent.Human;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GameGraphics extends JFrame {

    GameLogic logic;
    Draw draw;
    public GameGraphics(GameLogic logic) throws HeadlessException {

        this.logic = logic;
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

            List<Alien> aliens = logic.getAliens();
            List<Human> humans = logic.getHumans();

            g.setColor(Color.GREEN);
            for (Alien alien : aliens) {
                drawCharacter(g, alien);
            }
            g.setColor(Color.CYAN);
            for (Human human : humans) {
                drawCharacter(g, human);
            }
        }
        private void drawCharacter(Graphics g, Character character) {
            int x = character.getPosition().x;
            int y = character.getPosition().y;

            g.fillOval(x-10,y-10,50,50);
        }
    }
}
