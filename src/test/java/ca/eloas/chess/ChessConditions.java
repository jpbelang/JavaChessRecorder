package ca.eloas.chess;

import org.assertj.core.api.Condition;

import java.util.Optional;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.allOf;

public class ChessConditions {

    public static Condition<Optional<Piece>> ofType(PieceType type) {
        return new Condition<>((p) -> p.map(n -> n.isOfType(type)).orElse(false), "of type " + type.name());
    }

    public static Condition<Optional<Piece>> isPlaced() {
        return new Condition<>(Optional::isPresent, "is placed");
    }


    public static Condition<Optional<Piece>> isWhite() {
        return new Condition<>((p) -> p.map(Piece::isWhite).orElse(false), "is black");
    }

    public static Condition<Optional<Piece>> isBlack() {
        return new Condition<>((p) -> p.map(n -> !n.isWhite()).orElse(false), "is black");
    }
}
