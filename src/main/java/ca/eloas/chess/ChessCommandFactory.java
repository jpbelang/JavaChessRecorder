package ca.eloas.chess;

public interface ChessCommandFactory {

    ChessCommand createCommand(ChessMove move);
}
