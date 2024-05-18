package org.example.board;

import org.example.piece.OPiece;
import org.example.piece.Piece;
import org.example.piece.XPiece;

// Singleton
public class Board {
    private static Board instance;
    private Piece[][] grid;

    private Board() {
        grid = new Piece[15][15];
    }

    public static Board getInstance() {
        if (instance == null) {
            instance = new Board();
        }
        return instance;
    }

    public Piece[][] getGrid() {
        return grid;
    }

    public void display() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (grid[i][j] == null) {
                    System.out.print("- ");
                } else if (grid[i][j] instanceof XPiece) {
                    System.out.print("X ");
                } else if (grid[i][j] instanceof OPiece) {
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
    }

    public boolean checkRow(int row, int col, Piece piece) {
        for (int i = 0; i < 5; i++) {
            if (col + i >= 15 || grid[row][col + i] == null || !grid[row][col + i].equals(piece)) {
                return false;
            }
        }
        return col + 5 >= 15 || grid[row][col + 5] == null || !grid[row][col + 5].equals(piece);
    }

    public boolean checkCol(int row, int col, Piece piece) {
        for (int i = 0; i < 5; i++) {
            if (row + i >= 15 || grid[row + i][col] == null || !grid[row + i][col].equals(piece)) {
                return false;
            }
        }
        return row + 5 >= 15 || grid[row + 5][col] == null || !grid[row + 5][col].equals(piece);
    }

    public boolean checkDiagonal(int row, int col, Piece piece) {
        for (int i = 0; i < 5; i++) {
            if (row + i >= 15 || col + i >= 15 || grid[row + i][col + i] == null || !grid[row + i][col + i].equals(piece)) {
                return false;
            }
        }
        return row + 5 >= 15 || col + 5 >= 15 || grid[row + 5][col + 5] == null || !grid[row + 5][col + 5].equals(piece);
    }

    public int calculateRow(int row, int col, Piece piece) {
        int length = 0;
        while (col + length < 15 && grid[row][col + length] != null && grid[row][col + length].equals(piece)) {
            length++;
        }
        return length;
    }

    public int calculateCol(int row, int col, Piece piece) {
        int length = 0;
        while (row + length < 15 && grid[row + length][col] != null && grid[row + length][col].equals(piece)) {
            length++;
        }
        return length;
    }

    public int calculateDiagonal(int row, int col, Piece piece) {
        int length = 0;
        while (row + length < 15 && col + length < 15 && grid[row + length][col + length] != null && grid[row + length][col + length].equals(piece)) {
            length++;
        }
        return length;
    }
}
