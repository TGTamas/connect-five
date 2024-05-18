package org.example.piece;

public class XPiece implements Piece {
    public Piece clone() {
        return new XPiece();
    }

    public boolean equals(Piece other) {
        return other instanceof XPiece;
    }
}