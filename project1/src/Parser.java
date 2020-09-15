/*
 * *****************************************************************************
 * NAME: Tyler D Clark
 * PROJECT: Parser - Project 1
 * COURSE: CMSC 330
 * DATE: 14 SEP 2020
 * *****************************************************************************
 */

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * This class contain the constructor and methods related to parsing the language defined by the
 * assignment
 *
 * @author tylerclark
 */
public class Parser {

    private final LexicalAnalyzer lexer;
    private Token currentToken;
    private Token expectedToken;
    private JFrame result;
    private String string;
    private ButtonGroup group;

    /**
     * Parse constructor on which the parsing methods will be called.
     *
     * @param lexer A lexer object which contains the source file
     */
    public Parser(LexicalAnalyzer lexer) {
        this.lexer = lexer;
        System.out.println("Parsing " + this.lexer.getFile() + "...");
    }

    /**
     * Parse a program from a String producing a GUI. This method will parse the contents of a
     * String and generate a GUI based on the content.
     *
     * @throws IOException On problems with StreamTokenizer
     * @throws SyntaxError On any token parsing error
     * @return A <code>JFrame</code> GUI in which the supplied rules have been applied
     */
    public JFrame run() throws IOException, SyntaxError {
        currentToken = lexer.getNext();
        if (parseGUI()) {
            return result;
        } else {
            throw new SyntaxError(
                    lexer.getLineNumber(),
                    " Expecting Token "
                            + expectedToken
                            + " not "
                            + currentToken
                            + " on token #"
                            + lexer.getTokenCounter());
        }
    }

    /**
     * Heavy lifter of the class. Will execute button grouping and retrieve string values based on
     * the value of the current token. Most importantly, will update current token if it is the same
     * as the argument, otherwise will return false, resulting in {@link SyntaxError}.
     *
     * @throws IOException On problems with StreamTokenizer
     * @param argToken A token to be compared against current token
     * @return <code>true</code> if token if current token is correct and consumed, otherwise <code>
     *     false</code>
     */
    private boolean evaluate(Token argToken) throws IOException {
        if (currentToken == argToken) {
            if (currentToken == Token.GROUP) {
                group = new ButtonGroup();
            } else if (currentToken == Token.STRING) {
                string = lexer.getStringValue();
            }
            currentToken = lexer.getNext();
            return true;
        } else {
            expectedToken = argToken;
            return false;
        }
    }

    /**
     * Recursive Descent Parser for gui. Parses gui as per the grammar:
     *
     * <p>gui ::= Window STRING '(' NUMBER ',' NUMBER ')' layout widgets End '.'
     *
     * @throws IOException On problems reading the StreamTokenizer
     * @throws SyntaxError On any token parsing error
     * @return <code>true</code> if GUI is correctly parsed, otherwise <code>false</code>
     */
    private boolean parseGUI() throws IOException, SyntaxError {
        int width, height;
        if (evaluate(Token.WINDOW) && evaluate(Token.STRING)) {
            result = new JFrame(string);
            JPanel main = new JPanel();
            if (evaluate(Token.LEFT_PAREN) && evaluate(Token.NUMBER)) {
                width = lexer.getNumberValue();
                if (evaluate(Token.COMMA) && evaluate(Token.NUMBER)) {
                    height = lexer.getNumberValue();
                    if (evaluate(Token.RIGHT_PAREN)) {
                        result.setSize(width, height);
                        main.setSize(width, height);
                        result.add(main);
                        if (parseLayout(main) && parseWidgets(main) && evaluate(Token.END)) {
                            return evaluate(Token.PERIOD);
                        }
                    }
                }
            }
        }

        return false;
    }

    /**
     * Recursive Descent Parser for layout. Parses layout as per the grammar:
     *
     * <p>layout ::= Layout layout_type ':'
     *
     * @throws IOException On problems with StreamTokenizer
     * @param container A container to set the layout of
     * @return <code>true</code> if layout is parsed correctly, otherwise <code>false</code>
     */
    private boolean parseLayout(Container container) throws IOException {
        if (evaluate(Token.LAYOUT) && parseLayoutType(container)) {
            return evaluate(Token.COLON);
        }
        return false;
    }

    /**
     * Recursive Descent Parser for layout_type. Parses layout_type as per the grammar:
     *
     * <p>layout_type ::= Flow | Grid '(' NUMBER ',' NUMBER [',' NUMBER ',' NUMBER] ')'
     *
     * @throws IOException On problems with StreamTokenizer
     * @param container A container to set the layout of
     * @return <code>true</code> if layout type is parsed correctly, otherwise <code>false</code>
     */
    private boolean parseLayoutType(Container container) throws IOException {
        int rows, cols, hgap, vgap;
        if (evaluate(Token.FLOW)) {
            container.setLayout(new FlowLayout());
            return true;
        } else if (evaluate(Token.GRID) && evaluate(Token.LEFT_PAREN) && evaluate(Token.NUMBER)) {
            rows = lexer.getNumberValue();
            if (evaluate(Token.COMMA) && evaluate(Token.NUMBER)) {
                cols = lexer.getNumberValue();
                if (evaluate(Token.RIGHT_PAREN)) {
                    container.setLayout(new GridLayout(rows, cols));
                    return true;
                } else if (evaluate(Token.COMMA) && evaluate(Token.NUMBER)) {
                    hgap = lexer.getNumberValue();
                    if (evaluate(Token.COMMA) && evaluate(Token.NUMBER)) {
                        vgap = lexer.getNumberValue();
                        if (evaluate(Token.RIGHT_PAREN)) {
                            container.setLayout(new GridLayout(rows, cols, hgap, vgap));
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * Recursive Descent Parser for widgets. Parses widgets as per the grammar:
     *
     * <p>widgets ::= widget widgets | widget
     *
     * @throws IOException On problems with StreamTokenizer
     * @param container A container to parse widgets within
     * @return <code>true</code> if widgets are parsed correctly, otherwise <code>false</code>
     */
    private boolean parseWidgets(Container container) throws IOException, SyntaxError {
        if (parseWidget(container)) {
            if (parseWidgets(container)) {
                return true;
            }
            return true;
        }
        return false;
    }

    /**
     * Recursive Descent Parser for widget. Parses widget as per the grammar:
     *
     * <p>widget ::= Button STRING ';' | Group radio_buttons End ';' | Label STRING ';' | Panel
     * layout widgets End ';' | Textfield NUMBER ';'
     *
     * @throws IOException On problems with StreamTokenizer
     * @param container A container to parse widgets within
     * @return <code>true</code> if widget is parsed correctly, otherwise <code>false</code>
     */
    private boolean parseWidget(Container container) throws IOException, SyntaxError {
        int cols;
        if (evaluate(Token.BUTTON) && evaluate(Token.STRING) && evaluate(Token.SEMICOLON)) {
            container.add(new JButton(string));
            return true;

        } else if (evaluate(Token.GROUP) && parseRadioButtons(container)) {
            return evaluate(Token.END) && evaluate(Token.SEMICOLON);

        } else if (evaluate(Token.LABEL) && evaluate(Token.STRING) && evaluate(Token.SEMICOLON)) {
            container.add(new JLabel(string));
            return true;

        } else if (evaluate(Token.PANEL)) {
            container.add(container = new JPanel());
            if (parseLayout(container) && parseWidgets(container)) {
                return evaluate(Token.END) && evaluate(Token.SEMICOLON);
            }
        } else if (evaluate(Token.TEXTFIELD) && evaluate(Token.NUMBER)) {
            cols = lexer.getNumberValue();
            if (evaluate(Token.SEMICOLON)) {
                container.add(new JTextField(cols));
                return true;
            }
        }
        return false;
    }

    /**
     * Recursive Descent Parser for radio_buttons. Parses radio_buttons as per the grammar:
     *
     * <p>radio_buttons ::= radio_button radio_buttons | radio_button
     *
     * @throws IOException On problems reading the StreamTokenizer
     * @param container A container to parse radio buttons within
     * @return <code>true</code> if radio buttons are parsed correctly, otherwise <code>false</code>
     */
    private boolean parseRadioButtons(Container container) throws IOException {
        if (parseRadioButton(container)) {
            if (parseRadioButtons(container)) {
                return true;
            }
            return true;
        }
        return false;
    }

    /**
     * Recursive Descent Parser for radio_button. Parses radio_button as per the grammar:
     *
     * <p>radio_button ::= Radio STRING ';'
     *
     * @throws IOException On problems reading the StreamTokenizer
     * @param container A container to parse radio buttons within
     * @return <code>true</code> if radio button is parsed correctly, otherwise <code>false</code>
     */
    private boolean parseRadioButton(Container container) throws IOException {
        if (evaluate(Token.RADIO) && evaluate(Token.STRING) && evaluate(Token.SEMICOLON)) {
            JRadioButton radioButton = new JRadioButton(string);
            container.add(radioButton);
            group.add(radioButton);
            return true;
        }
        return false;
    }
}
