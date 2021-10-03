package ca.eloas.chess;

import org.junit.jupiter.api.Test;

import static ca.eloas.chess.ChessConditions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BoardTest {

    @Test
    void createAndInitialize() {

        var board = Board.create((b -> b.placePiece(Piece.createWhite(PieceType.PAWN), 'e', 4)));

        assertThat(board.pieceAt('e', 4)).is(existingPieceThat(isWhite().and(ofType(PieceType.PAWN))));
    }

    @Test
    void placePiece() {

        var board = Board.create();
        Piece placed = Piece.createWhite(PieceType.ROOK);
        Piece anotherplaced = Piece.createWhite(PieceType.ROOK);

        board.placePiece(placed, 'a', 1);
        board.placePiece(anotherplaced, 'f', 6);

        assertThat(board.pieceAt('a', 1)).is(existingPieceThat(isWhite().and(ofType(PieceType.ROOK))));
        assertThat(board.pieceAt('f', 6)).is(existingPieceThat(isWhite().and(ofType(PieceType.ROOK))));
    }
}
