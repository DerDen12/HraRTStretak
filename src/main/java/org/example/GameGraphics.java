package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class GameGraphics extends JFrame {
    public GameGraphics(GameLogic logic) throws HeadlessException {

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Darkest Day");

    }
}
