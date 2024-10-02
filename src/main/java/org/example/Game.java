package org.example;

public class Game {
    boolean gameStarted = false;

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Game();
            }
        });
    }
    public Game() {

    }
}
