/*
 * *****************************************************************************
 * NAME: Tyler D Clark
 * PROJECT: Token - Project 1
 * COURSE: CMSC 330
 * DATE: 14 SEP 2020
 * *****************************************************************************
 */

/**
 * An enumerated type used by the {@link LexicalAnalyzer} and the {@link Parser}. Establishes the
 * tokens to be used in the parsing of GUIs.
 *
 * @author tylerclark
 */
public enum Token {
    STRING,
    NUMBER,
    END,
    BUTTON,
    FLOW,
    GRID,
    GROUP,
    LABEL,
    LAYOUT,
    PANEL,
    RADIO,
    TEXTFIELD,
    WINDOW,
    COMMA,
    COLON,
    SEMICOLON,
    PERIOD,
    LEFT_PAREN,
    RIGHT_PAREN,
    EOF,
    UNKNOWN
}
