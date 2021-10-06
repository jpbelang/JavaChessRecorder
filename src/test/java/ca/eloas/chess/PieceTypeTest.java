package ca.eloas.chess;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PieceTypeTest {

    @Test
    void fromLetter() {
        assertThat(PieceType.fromLetter('Q')).isEqualTo(PieceType.QUEEN);
        assertThat(PieceType.fromLetter('K')).isEqualTo(PieceType.KING);
        assertThat(PieceType.fromLetter('N')).isEqualTo(PieceType.KNIGHT);
        assertThat(PieceType.fromLetter('B')).isEqualTo(PieceType.BISHOP);
        assertThat(PieceType.fromLetter('R')).isEqualTo(PieceType.ROOK);
        assertThat(PieceType.fromLetter('P')).isEqualTo(PieceType.PAWN);
    }

    @Test
    void badLetter() {
        assertThatThrownBy(() -> PieceType.fromLetter('Z')).isInstanceOf(ChessParserException.class);
    }
}