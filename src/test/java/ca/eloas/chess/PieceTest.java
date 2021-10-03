package ca.eloas.chess;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PieceTest {

    @Test
    void createWhitePiece() {

        var piece = Piece.createWhite(PieceType.ROOK);
        assertThat(piece.isWhite()).isTrue();
        assertThat(piece.isOfType(PieceType.ROOK)).isTrue();
    }

    @Test
    void createBlackPiece() {

        var piece = Piece.createBlack(PieceType.ROOK);
        assertThat(piece.isWhite()).isFalse();
        assertThat(piece.isOfType(PieceType.ROOK)).isTrue();
    }

}
