package ca.eloas.chess;

import org.assertj.core.api.Condition;

import java.util.Optional;
import java.util.function.Predicate;

public class ChessConditions {
    public static Condition<Optional<Piece>> existingPieceThat(Predicate<Piece> predicate) {
        return new Condition<>((p) -> predicate.test(p.orElseThrow(() -> new AssertionError("no such piece"))), "correct piece");
    }

    public static Predicate<Piece> ofType(PieceType type) {
        return (p) -> p.isOfType(type);
    }

    public static Predicate<Piece> isWhite() {
        return Piece::isWhite;
    }

    public static Predicate<Piece> isBlack() {
        return isWhite().negate();
    }
}
