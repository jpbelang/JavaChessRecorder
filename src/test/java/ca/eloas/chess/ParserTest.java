package ca.eloas.chess;

import org.junit.jupiter.api.Test;

import java.io.StringReader;

import static org.assertj.core.api.Assertions.assertThat;

class ParserTest {

    @Test
    void parser() throws Exception {

        var boo = "1. Bc6 Bc6";
        var parser = new Parser() {
            @Override
            protected void buildMove(int moveNumber, boolean isEllipsis, char whitePiece, String whiteTarget, char blackPiece, String blackTarget) {
                assertThat(moveNumber).isEqualTo(1);
                assertThat(isEllipsis).isFalse();
                assertThat(whitePiece).isEqualTo('B');
                assertThat(whiteTarget).isEqualTo("c6");
                assertThat(blackPiece).isEqualTo('B');
                assertThat(blackTarget).isEqualTo("c6");
            }
        };

        var commands = parser.parseCommands(new StringReader(boo));

        assertThat(commands).hasSize(2);
    }

    @Test
    void parseNoBlack() throws Exception {

        var boo = "1. Bc6";
        var parser = new Parser() {
            @Override
            protected void buildMove(int moveNumber, boolean isEllipsis, char whitePiece, String whiteTarget, char blackPiece, String blackTarget) {
                assertThat(moveNumber).isEqualTo(1);
                assertThat(isEllipsis).isFalse();
                assertThat(whitePiece).isEqualTo('B');
                assertThat(whiteTarget).isEqualTo("c6");
            }
        };

        var commands = parser.parseCommands(new StringReader(boo));

        assertThat(commands).hasSize(2);
    }
}