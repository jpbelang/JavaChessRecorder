package ca.eloas.chess;

import java.util.stream.Stream;

@FunctionalInterface
public interface BoardInitializer {

    BoardInitializer DEFAULT_WHITE = (b) -> {
        Stream.of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h').forEach(c -> b.placePiece(Piece.createWhite(PieceType.PAWN), c, 2));
        b.placePiece(Piece.createWhite(PieceType.ROOK), 'a', 1);
        b.placePiece(Piece.createWhite(PieceType.KNIGHT), 'b', 1);
        b.placePiece(Piece.createWhite(PieceType.BISHOP), 'c', 1);
        b.placePiece(Piece.createWhite(PieceType.QUEEN), 'd', 1);
        b.placePiece(Piece.createWhite(PieceType.KING), 'e', 1);
        b.placePiece(Piece.createWhite(PieceType.BISHOP), 'f', 1);
        b.placePiece(Piece.createWhite(PieceType.KNIGHT), 'g', 1);
        b.placePiece(Piece.createWhite(PieceType.ROOK), 'h', 1);
    };

    BoardInitializer DEFAULT_BLACK = (b) -> {
        Stream.of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h').forEach(c -> b.placePiece(Piece.createBlack(PieceType.PAWN), c, 7));
        b.placePiece(Piece.createBlack(PieceType.ROOK), 'a', 8);
        b.placePiece(Piece.createBlack(PieceType.KNIGHT), 'b', 8);
        b.placePiece(Piece.createBlack(PieceType.BISHOP), 'c', 8);
        b.placePiece(Piece.createBlack(PieceType.QUEEN), 'd', 8);
        b.placePiece(Piece.createBlack(PieceType.KING), 'e', 8);
        b.placePiece(Piece.createBlack(PieceType.BISHOP), 'f', 8);
        b.placePiece(Piece.createBlack(PieceType.KNIGHT), 'g', 8);
        b.placePiece(Piece.createBlack(PieceType.ROOK), 'h', 8);
    };


    void initialize(Board b);
}
