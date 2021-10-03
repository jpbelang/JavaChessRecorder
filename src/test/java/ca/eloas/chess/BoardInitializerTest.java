package ca.eloas.chess;

import org.junit.jupiter.api.Test;

import static ca.eloas.chess.ChessConditions.*;
import static org.assertj.core.api.Assertions.allOf;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BoardInitializerTest {

    @Test
    void placeWhites() {

        var board = Board.create();
        BoardInitializer.DEFAULT_WHITE.initialize(board);

        assertThat(board.pieceAt('a', 2)).is(allOf(isPlaced(), isWhite(), ofType(PieceType.PAWN)));

        assertThat(board.pieceAt('a', 1)).is(allOf(isPlaced(), isWhite(), ofType(PieceType.ROOK)));
        assertThat(board.pieceAt('b', 1)).is(allOf(isPlaced(), isWhite(), ofType(PieceType.KNIGHT)));
        assertThat(board.pieceAt('c', 1)).is(allOf(isPlaced(), isWhite(), ofType(PieceType.BISHOP)));
        assertThat(board.pieceAt('d', 1)).is(allOf(isPlaced(), isWhite(), ofType(PieceType.QUEEN)));
        assertThat(board.pieceAt('e', 1)).is(allOf(isPlaced(), isWhite(), ofType(PieceType.KING)));
        assertThat(board.pieceAt('f', 1)).is(allOf(isPlaced(), isWhite(), ofType(PieceType.BISHOP)));
        assertThat(board.pieceAt('g', 1)).is(allOf(isPlaced(), isWhite(), ofType(PieceType.KNIGHT)));
        assertThat(board.pieceAt('h', 1)).is(allOf(isPlaced(), isWhite(), ofType(PieceType.ROOK)));
    }

    @Test
    void placeBlacks() {

        var board = Board.create();
        BoardInitializer.DEFAULT_BLACK.initialize(board);

        assertThat(board.pieceAt('a', 7)).is(allOf(isPlaced(), isBlack(), ofType(PieceType.PAWN)));

        assertThat(board.pieceAt('a', 8)).is(allOf(isPlaced(), isBlack(), ofType(PieceType.ROOK)));
        assertThat(board.pieceAt('b', 8)).is(allOf(isPlaced(), isBlack(), ofType(PieceType.KNIGHT)));
        assertThat(board.pieceAt('c', 8)).is(allOf(isPlaced(), isBlack(), ofType(PieceType.BISHOP)));
        assertThat(board.pieceAt('d', 8)).is(allOf(isPlaced(), isBlack(), ofType(PieceType.QUEEN)));
        assertThat(board.pieceAt('e', 8)).is(allOf(isPlaced(), isBlack(), ofType(PieceType.KING)));
        assertThat(board.pieceAt('f', 8)).is(allOf(isPlaced(), isBlack(), ofType(PieceType.BISHOP)));
        assertThat(board.pieceAt('g', 8)).is(allOf(isPlaced(), isBlack(), ofType(PieceType.KNIGHT)));
        assertThat(board.pieceAt('h', 8)).is(allOf(isPlaced(), isBlack(), ofType(PieceType.ROOK)));
    }

}