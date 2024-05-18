package org.example.strategy;

import org.example.board.Board;
import org.example.piece.Piece;

public class LongestLineScoringStrategy implements ScoringStrategy {
    @Override
    public int calculateScore(Board board, Piece piece) {
        int maxScore = 0;
        for (int row = 0; row < 15; row++) {
            for (int col = 0; col < 15; col++) {
                if (board.getGrid()[row][col] != null && board.getGrid()[row][col].equals(piece)) {
                    int rowScore = board.calculateRow(row, col, piece);
                    int colScore = board.calculateCol(row, col, piece);
                    int diagScore = board.calculateDiagonal(row, col, piece);
                    maxScore = Math.max(maxScore, Math.max(rowScore, Math.max(colScore, diagScore)));
                }
            }
        }
        return maxScore;
    }
}
