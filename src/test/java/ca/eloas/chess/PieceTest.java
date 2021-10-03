package ca.eloas.chess;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PieceTest {

    @Test
    void createPiece() {

        var piece = Piece.createWhite(PieceType.ROOK);
        assertThat(piece.isWhite()).isTrue();
        assertThat(piece.isOfType(PieceType.ROOK)).isTrue();
    }
}
