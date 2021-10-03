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
            var white = match.group(3);
            var black = Optional.ofNullable(match.group(5));

            var whiteMatcher = COMMAND.matcher(white);
            if (! whiteMatcher.matches() ) {
                throw new RuntimeException();
            }

            var blackMatcher = black.map(COMMAND::matcher);
            if ( blackMatcher.isPresent() && !blackMatcher.get().matches() ) {

                throw new RuntimeException();
            }

            var whiteMove = whiteMatcher.group();

            Character blackPiece = blackMatcher.map(m -> m.group(0).charAt(0)).orElse('z');
            String blackMove = blackMatcher.map(m -> m.group(0).substring(1)).orElse(null);
            buildMove(moveNumber, isEllipsis,
                    whiteMove.charAt(0), whiteMove.substring(1),
                    blackPiece, blackMove);
            comm.add(() -> {});
            comm.add(() -> {});
        }
        
        return comm;
    }

    protected void buildMove(int moveNumber, boolean isEllipsis, char whitePiece, String whiteTarget, char blackPiece, String blackTarget) {

    }
}
