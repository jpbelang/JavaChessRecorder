package ca.eloas.chess;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.StringReader;
import java.util.Optional;

import static ca.eloas.chess.ChessConditions.chessMove;
import static org.assertj.core.api.Assertions.allOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ParserTest {

    @Captor ArgumentCaptor<ChessMove> chessMoves;

    @Test
    void parser(@Mock ChessCommandFactory commandFactory) throws Exception {

        var boo = "1. Bc6 Kc4";
        var parser = new Parser(commandFactory);
        when(commandFactory.createCommand(any())).thenReturn(() -> {});
        
        var commands = parser.parseCommands(new StringReader(boo));

        verify(commandFactory, times(2)).createCommand(chessMoves.capture());
        assertThat(chessMoves.getAllValues())
                .haveAtLeastOne(chessMove(PieceType.BISHOP, "c6"))
                .haveAtLeastOne(chessMove(PieceType.KING, "c4"));
    }

    @Test
    void parseNoBlack(@Mock ChessCommandFactory commandFactory) throws Exception {

       var parser = new Parser(commandFactory);
        when(commandFactory.createCommand(any())).thenReturn(() -> {});

        var commands = parser.parseCommands(new StringReader("1. Bc6"));

        verify(commandFactory, times(1)).createCommand(chessMoves.capture());
        assertThat(chessMoves.getAllValues())
                .haveAtLeastOne(chessMove(PieceType.BISHOP, "c6"));
    }
}