package org.example.strategy;

import org.example.board.Board;
import org.example.piece.Piece;

public interface ScoringStrategy {
    int calculateScore(Board board, Piece piece);
}