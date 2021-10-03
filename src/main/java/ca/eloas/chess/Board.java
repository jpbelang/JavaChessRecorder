package ca.eloas.chess;

import java.util.Arrays;
import java.util.Optional;

public class Board {

    private final Piece[][] pieces;

    public static Board create(BoardInitializer... initializers) {

        var piecesRanks = new Piece[8][];
        for (var i = 0; i < 8; i ++) {
            piecesRanks[i] = new Piece[8];
        }

        var b =  new Board(piecesRanks);
        Arrays.stream(initializers).forEach(i -> i.initialize(b));
        return b;
    }

    Board(Piece[][] pieces) {

        this.pieces = pieces;
    }

    public void placePiece(Piece piece, char file, int rank) {

        int[] v = translate(file, rank);
        this.pieces[v[0]][v[1]] = piece;
    }

    public Optional<Piece> pieceAt(char file, int rank) {
        int[] v = translate(file, rank);
        return Optional.ofNullable(this.pieces[v[0]][v[1]]);
    }

    private int[] translate(char file, int rank) {
        return new int[]{(int) file - (int)'a', rank - 1};
    }
}
