package ca.eloas.chess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private static final Pattern LINE = Pattern.compile("(\\d+)\\.(\\.\\.)? (\\S*)( (\\S*))?");
    private static final Pattern COMMAND = Pattern.compile("[PRNBQK][a-h][1-8]");

    public List<ChessCommand> parseCommands(Reader reader) throws IOException {

        var line = new BufferedReader(reader);
        var match = LINE.matcher(line.readLine());
        List<ChessCommand> comm = new ArrayList<>();
        if ( match.matches()) {

            int moveNumber = Integer.parseInt(match.group(1));
            boolean isEllipsis = "..".equals(match.group(2));
            var first = match.group(3);
            var second = match.group(5);

            Matcher firstMatcher = createFirstMatcher(first);
            Optional<Matcher> secondMatcher = createSecondMatcher(second);

            var firstMove = firstMatcher.group();

            Character secondPiece = secondMatcher.map(m -> m.group(0).charAt(0)).orElse('z');
            String secondMove = secondMatcher.map(m -> m.group(0).substring(1)).orElse(null);
            buildMove(moveNumber, isEllipsis,
                    firstMove.charAt(0), firstMove.substring(1),
                    secondPiece, secondMove);
            comm.add(() -> {});
            comm.add(() -> {});
        }
        
        return comm;
    }

    private Optional<Matcher> createSecondMatcher(String secondOrNull) {
        var second = Optional.ofNullable(secondOrNull);
        var secondMatcher = second.map(COMMAND::matcher);
        if ( secondMatcher.isPresent() && !secondMatcher.get().matches() ) {

            throw new ChessParserException("error parsing second move");
        }
        return secondMatcher;
    }

    private Matcher createFirstMatcher(String first) {
        var firstMatcher = COMMAND.matcher(first);
        if (! firstMatcher.matches() ) {
            throw new ChessParserException("error parsing first move");
        }
        return firstMatcher;
    }

    protected void buildMove(int moveNumber, boolean isEllipsis, char whitePiece, String whiteTarget, char blackPiece, String blackTarget) {

    }
}
