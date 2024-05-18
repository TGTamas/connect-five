package org.example.piece;

// Decorator
abstract class PieceDecorator implements Piece {
    protected Piece decoratedPiece;

    public PieceDecorator(Piece decoratedPiece) {
        this.decoratedPiece = decoratedPiece;
    }

    public Piece clone() {
        return decoratedPiece.clone();
    }

    public boolean equals(Piece other) {
        return decoratedPiece.equals(other);
    }
}
