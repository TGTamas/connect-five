package org.example;

class Game {
    private GameState state;

    public Game() {
        state = GameState.START;
    }

    public void changeState(GameState newState) {
        state = newState;
    }

    public GameState getState() {
        return state;
    }
}
