package ca.eloas.chess;

import org.junit.jupiter.api.Test;

import java.io.StringReader;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class ParserTest {

    @Test
    void parser() throws Exception {

        var boo = "1. Bc6 Bc6";
        var parser = new Parser() {
            @Override
            protected void buildMove(int moveNumber, boolean isEllipsis, Move firstMove, Optional<Move> secondMove) {
                assertThat(moveNumber).isEqualTo(1);
                assertThat(isEllipsis).isFalse();
                assertThat(firstMove.type()).isEqualTo('B');
                assertThat(firstMove.move()).isEqualTo("c6");
                assertThat(secondMove.map(Move::type).orElseThrow(() -> new AssertionError("no second move?"))).isEqualTo('B');
                assertThat(secondMove.map(Move::move).orElseThrow(() -> new AssertionError("no second move?"))).isEqualTo("c6");
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
            protected void buildMove(int moveNumber, boolean isEllipsis, Move firstMove, Optional<Move> secondMove) {
                assertThat(moveNumber).isEqualTo(1);
                assertThat(isEllipsis).isFalse();
                assertThat(firstMove.type()).isEqualTo('B');
                assertThat(firstMove.move()).isEqualTo("c6");
            }
        };

        var commands = parser.parseCommands(new StringReader(boo));

        assertThat(commands).hasSize(2);
    }
}