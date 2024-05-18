package org.example.observer;

import org.example.Player;
import org.example.board.Board;

public class PlayerObserver implements Observer {
    private String name;
    private Player player;

    public PlayerObserver(String name, Player player) {
        this.name = name;
        this.player = player;
    }
    public void update() {
        System.out.println("It's " + name + "'s turn. Current score: " + player.getScore(Board.getInstance()));
    }
}
