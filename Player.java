package org.example;

import org.example.board.Board;
import org.example.piece.Piece;
import org.example.strategy.ScoringStrategy;

public class Player {
    private ScoringStrategy scoringStrategy;
    public String name;
    private Piece piece;

    public Player(ScoringStrategy scoringStrategy, String name, Piece piece) {
        this.scoringStrategy = scoringStrategy;
        this.name = name;
        this.piece = piece;
    }

    public String getName() {
        return name;
    }

    public int getScore(Board board) {
        return scoringStrategy.calculateScore(board, piece);
    }
}
