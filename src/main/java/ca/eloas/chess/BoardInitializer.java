package ca.eloas.chess;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

@FunctionalInterface
public interface BoardInitializer {

    private static Function<PieceType, Piece> white() {
        return Piece::createWhite;
    }

    private static Function<PieceType, Piece> black() {
        return Piece::createBlack;
    }
    
    BoardInitializer DEFAULT_WHITE = (b) -> {
        placeAll(b, white(), 2, 1);
    };

    BoardInitializer DEFAULT_BLACK = (b) -> {
        placeAll(b, black(), 7, 8);
    };

    static private void placeAll(Board b, Function<PieceType, Piece> factory, int pawnRank, int leadersRank) {
        Stream.of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h').forEach(c -> b.placePiece(factory.apply((PieceType.PAWN)), c, pawnRank));
        b.placePiece(factory.apply(PieceType.ROOK), 'a', leadersRank);
        b.placePiece(factory.apply(PieceType.KNIGHT), 'b', leadersRank);
        b.placePiece(factory.apply(PieceType.BISHOP), 'c', leadersRank);
        b.placePiece(factory.apply(PieceType.QUEEN), 'd', leadersRank);
        b.placePiece(factory.apply(PieceType.KING), 'e', leadersRank);
        b.placePiece(factory.apply(PieceType.BISHOP), 'f', leadersRank);
        b.placePiece(factory.apply(PieceType.KNIGHT), 'g', leadersRank);
        b.placePiece(factory.apply(PieceType.ROOK), 'h', leadersRank);
    }



    void initialize(Board b);
}
