package org.example;

import org.example.board.Board;
import org.example.piece.PieceFactory;
import org.example.piece.PieceType;
import org.example.strategy.LongestLineScoringStrategy;
import org.example.strategy.ScoringStrategy;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Board board = Board.getInstance();
        ScoringStrategy scoringStrategy = new LongestLineScoringStrategy();
        Player player1 = new Player(scoringStrategy, "Player 1", PieceFactory.createPiece(PieceType.X));
        Player player2 = new Player(scoringStrategy, "Player 2", PieceFactory.createPiece(PieceType.O));
        GameMediator mediator = new GameMediator(game, board, player1, player2);
        mediator.play();
    }
}