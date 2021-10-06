package ca.eloas.chess;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum PieceType {


    PAWN, ROOK, BISHOP, KNIGHT, KING, QUEEN;

    public static Map<Character, PieceType> mapOfCharsToPieces = new HashMap<>();
    static {
        mapOfCharsToPieces.put('P', PAWN);
        mapOfCharsToPieces.put('R', ROOK);
        mapOfCharsToPieces.put('B', BISHOP);
        mapOfCharsToPieces.put('N', KNIGHT);
        mapOfCharsToPieces.put('Q', QUEEN);
        mapOfCharsToPieces.put('K', KING);
    }

    public static PieceType fromLetter(char c) {

        return Optional.ofNullable(mapOfCharsToPieces.get(c)).orElseThrow(() -> new ChessParserException("no such piece" + c));
    }

}
