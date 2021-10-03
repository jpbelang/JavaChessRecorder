package ca.eloas.chess;

public class Piece {

    private final boolean white;
    private final PieceType pieceType;

    Piece(boolean white, PieceType pieceType) {

        this.white = white;
        this.pieceType = pieceType;
    }

    public static Piece createWhite(PieceType pieceType) {
        return new Piece(true, pieceType);
    }

    public static Piece createBlack(PieceType pieceType) {
        return new Piece(false, pieceType);
    }

    public boolean isWhite() {
        return white;
    }

    public boolean isOfType(PieceType rook) {
        return this.pieceType == rook;
    }
}
