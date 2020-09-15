/*
 * *****************************************************************************
 * NAME: Tyler D Clark
 * PROJECT: Lexical Analyzer - Project 1
 * COURSE: CMSC 330
 * DATE: 14 SEP 2020
 * *****************************************************************************
 */

import java.io.*;
/**
 * This class contain the constructor and methods for the Lexical Analyzers
 *
 * @author tylerclark
 */
public class LexicalAnalyzer {
    private final StreamTokenizer tokenizer;
    private final File file;
    private int tokenCounter = 0;
    /**
     * Creates a constructor that which will call several methods involved in traversing and
     * receiving data from the source file
     *
     * @throws FileNotFoundException Missing or invalid files
     * @param currentFile - File to be parsed and GUI to be created from
     */
    public LexicalAnalyzer(File currentFile) throws FileNotFoundException {
        if (currentFile.exists()) {
            file = currentFile;
            System.out.println("Analyzing " + currentFile + "...");
            Reader reader = new BufferedReader(new FileReader(currentFile));
            tokenizer = new StreamTokenizer(reader);
            tokenizer.ordinaryChar('.');
            tokenizer.quoteChar('"');
        } else {
            throw new FileNotFoundException();
        }
    }
    /**
     * Retrieves the next token from the StreamTokenizer and keeps count of the number of Tokens.
     * Compares the token to the {@link Token} enum types.
     *
     * @throws IOException On problems with StreamTokenizer
     * @return Token Corresponding Token enum
     */
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
    /**
     * Compares the token to the {@link Token} punctuation enum types.
     *
     * @param ttype Integer value representing the StreamToken type
     * @return Token Corresponding punctuation Token enum OR UNKNOWN
     */
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
    /**
     * Getter method for returning the String value of the token the StreamTokenizer is holding
     *
     * @return a string value of the current token
     */
    public String getStringValue() {
        return tokenizer.sval;
    }

    /**
     * Getter method for returning the Integer value of the token the StreamTokenizer is holding
     *
     * @return Integer value of the current token
     */
    public int getNumberValue() {
        return (int) tokenizer.nval;
    }
    /**
     * Getter method for returning the line number of the file the StreamTokenizer is on
     *
     * @return Line number of Source file
     */
    public int getLineNumber() {
        return tokenizer.lineno();
    }
    /**
     * Getter method for returning the count of tokens the StreamTokenizer has encountered.
     *
     * @return Token count
     */
    public int getTokenCounter() {
        return this.tokenCounter;
    }
    /**
     * Getter method for file the analyzer is analyzing
     *
     * @return File file
     */
    public File getFile() {
        return this.file;
    }
}
