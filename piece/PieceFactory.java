package org.example.piece;

public class PieceFactory {
    public static Piece createPiece(PieceType type) {
        switch (type) {
            case X:
                return new XPiece();
            case O:
                return new OPiece();
            default:
                throw new IllegalArgumentException("Invalid piece type");
        }
    }
}
