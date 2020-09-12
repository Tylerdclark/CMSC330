import javax.swing.*;
import java.io.*;

public class LexicalAnalyzer {
    private final StreamTokenizer tokenizer;
    private Reader reader;
    private int tokenCounter = 0;

    public LexicalAnalyzer(File currentFile) {
        try {
            reader = new BufferedReader(new FileReader(currentFile));
        } catch (FileNotFoundException fnf) {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), fnf.getMessage());
        }
        tokenizer = new StreamTokenizer(reader);
        tokenizer.ordinaryChar('.');
        tokenizer.quoteChar('"');
    }

    public String getStringValue() {
        return tokenizer.sval;
    }

    public double getNumberValue() {
        return tokenizer.nval;
    }

    public int getLineNumber() {
        return tokenizer.lineno();
    }
    public int getTokenCounter(){
        return this.tokenCounter;
    }

    public Token getNext() throws IOException {
        int nextToken = tokenizer.nextToken();
        tokenCounter++;
        System.out.println(tokenizer);
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
