package ca.eloas.chess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class Parser {

    private static final Pattern command = Pattern.compile("(\\d+)\\.(\\.\\.)? ([PRNBQK][a-h][1-8])( ([PRNBQK][a-h][1-8]))?");

    public List<ChessCommand> parseCommands(Reader reader) throws IOException {

        var line = new BufferedReader(reader);
        var match = command.matcher(line.readLine());
        List<ChessCommand> comm = new ArrayList<>();
        if ( match.matches()) {

            int moveNumber = Integer.parseInt(match.group(1));
            boolean isEllipsis = "..".equals(match.group(2));
            var whiteMove = match.group(3);
            Optional<String> blackMove = Optional.ofNullable(match.group(5));
            buildMove(moveNumber, isEllipsis, whiteMove.charAt(0), whiteMove.substring(1), blackMove.map(m -> m.charAt(0)).orElse('z'), blackMove.map(m -> m.substring(1)).orElse(null) );
            comm.add(() -> {});
            comm.add(() -> {});
        }
        
        return comm;
    }

    protected void buildMove(int moveNumber, boolean isEllipsis, char whitePiece, String whiteTarget, char blackPiece, String blackTarget) {

    }
}
