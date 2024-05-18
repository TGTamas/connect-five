package org.example;

import org.example.board.Board;
import org.example.observer.PlayerObserver;
import org.example.observer.Observer;
import org.example.piece.Piece;
import org.example.piece.PieceFactory;
import org.example.piece.PieceType;

import java.util.Scanner;

class GameMediator {
    private Game game;
    private Board board;
    private Player player1;
    private Player player2;
    private Observer player1Observer;
    private Observer player2Observer;

    public GameMediator(Game game, Board board, Player player1, Player player2) {
        this.game = game;
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.player1Observer = new PlayerObserver("Player 1", player1);
        this.player2Observer = new PlayerObserver("Player 2", player2);
    }

    public Game getGame() {
        return game;
    }

    public Board getBoard() {
        return board;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Observer getPlayer1Observer() {
        return player1Observer;
    }

    public Observer getPlayer2Observer() {
        return player2Observer;
    }

    public void play() {
        while (game.getState() != GameState.END) {
            board.display();
            player1Observer.update();
            makeMove(player1, PieceType.X);
            if (checkGameOver()) {
                game.changeState(GameState.END);
                System.out.println("Player 1 wins!");
                break;
            }

            player2Observer.update();
            makeMove(player2, PieceType.O);
            if (checkGameOver()) {
                game.changeState(GameState.END);
                System.out.println("Player 2 wins!");
                break;
            }
        }
    }

    private void makeMove(Player player, PieceType pieceType) {
        Scanner scanner = new Scanner(System.in);
        int row, col;
        do {
            System.out.println(player.getName() + ", enter your move (row col): ");
            row = scanner.nextInt();
            col = scanner.nextInt();
        } while (!isValidMove(row, col));

        board.getGrid()[row][col] = PieceFactory.createPiece(pieceType);
    }

    private boolean isValidMove(int row, int col) {
        if (row < 0 || row >= 15 || col < 0 || col >= 15) {
            return false;
        }
        return board.getGrid()[row][col] == null;
    }

    private boolean checkGameOver() {
        Piece[][] grid = board.getGrid();
        boolean isFull = true;
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (grid[i][j] == null) {
                    isFull = false;
                } else if (board.checkRow(i, j, grid[i][j]) ||
                        board.checkCol(i, j, grid[i][j]) ||
                        board.checkDiagonal(i, j, grid[i][j])) {
                    return true;
                }
            }
        }
        if (isFull) {
            game.changeState(GameState.END);
            System.out.println("The game is a draw!");
        }
        return false;
    }
}
