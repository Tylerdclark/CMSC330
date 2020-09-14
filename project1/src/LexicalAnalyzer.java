import java.io.*;

public class LexicalAnalyzer {
    private final StreamTokenizer tokenizer;
    private int tokenCounter = 0;

    public LexicalAnalyzer(File currentFile) throws FileNotFoundException {
        Reader reader = new BufferedReader(new FileReader(currentFile));
        tokenizer = new StreamTokenizer(reader);
        tokenizer.ordinaryChar('.');
        tokenizer.quoteChar('"');
    }

    public String getStringValue() {
        return tokenizer.sval;
    }

    public int getNumberValue() {
        return (int) tokenizer.nval;
    }

    public int getLineNumber() {
        return tokenizer.lineno();
    }

    public int getTokenCounter() {
        return this.tokenCounter;
    }

    public Token getNext() throws IOException {
        int nextToken = tokenizer.nextToken();
        tokenCounter++;
        switch (nextToken) {
            case StreamTokenizer.TT_NUMBER:
                return Token.NUMBER;
            case StreamTokenizer.TT_WORD:
                for (Token token : Token.values()) {
                    if (token.name().equals(tokenizer.sval.toUpperCase())) {
                        return token;
                    }
                }
            case '"':
                return Token.STRING;
            case StreamTokenizer.TT_EOF:
                return Token.EOF;
            default:
                return getPunctuationToken(tokenizer.ttype);
        }
    }

    private Token getPunctuationToken(int ttype) {
        switch (ttype) {
            case 40:
                return Token.LEFT_PAREN;
            case 41:
                return Token.RIGHT_PAREN;
            case 44:
                return Token.COMMA;
            case 46:
                return Token.PERIOD;
            case 58:
                return Token.COLON;
            case 59:
                return Token.SEMICOLON;
            default:
                return Token.UNKNOWN;
        }
    }
}
