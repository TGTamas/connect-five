package org.example.piece;

public class OPiece implements Piece {
    public Piece clone() {
        return new OPiece();
    }

    public boolean equals(Piece other) {
        return other instanceof OPiece;
    }
}
