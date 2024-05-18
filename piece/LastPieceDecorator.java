package org.example.piece;

class LastPieceDecorator extends PieceDecorator {
    private boolean isHighlighted;

    public LastPieceDecorator(Piece decoratedPiece) {
        super(decoratedPiece);
        this.isHighlighted = false;
    }

    public void highlight() {
        this.isHighlighted = true;
    }

    public void unhighlight() {
        this.isHighlighted = false;
    }

    public boolean isHighlighted() {
        return this.isHighlighted;
    }
}
