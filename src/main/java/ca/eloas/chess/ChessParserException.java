package ca.eloas.chess;

public class ChessParserException extends RuntimeException {

    public ChessParserException(String message) {
        super(message);
    }

    public ChessParserException(String message, Throwable cause) {
        super(message, cause);
    }

    public ChessParserException(Throwable cause) {
        super(cause);
    }

    public ChessParserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
