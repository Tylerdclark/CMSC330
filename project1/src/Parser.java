import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Parser {

    LexicalAnalyzer lexer;
    Token token;
    Token expectedToken;
    JFrame result;
    private String string;
    private ButtonGroup group;

    public Parser(LexicalAnalyzer lexer) {
        this.lexer = lexer;
    }

    public JFrame run() throws IOException, SyntaxError {
        token = lexer.getNext();
        if (parseGUI()) {
            return result;
        } else {
            throw new SyntaxError(
                    lexer.getLineNumber(),
                    " Expecting Token "
                            + expectedToken
                            + " not "
                            + token
                            + " on token #"
                            + lexer.getTokenCounter());
        }
    }

    private boolean evaluate(Token argToken) throws IOException {
        if (token == argToken) {
            if (token == Token.GROUP) {
                group = new ButtonGroup();
            } else if (token == Token.STRING) {
                string = lexer.getStringValue();
            }
            token = lexer.getNext();
            return true;
        } else {
            expectedToken = argToken;
            return false;
        }
    }

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

    private boolean parseLayout(Container container) throws IOException {
        if (evaluate(Token.LAYOUT) && parseLayoutType(container)) {
            return evaluate(Token.COLON);
        }
        return false;
    }

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

    private boolean parseWidgets(Container container) throws IOException, SyntaxError {
        if (parseWidget(container)) {
            if (parseWidgets(container)) {
                return true;
            }
            return true;
        }
        return false;
    }

    private boolean parseWidget(Container container) throws IOException, SyntaxError {
        int cols;
        if (evaluate(Token.BUTTON) && evaluate(Token.STRING) && evaluate(Token.SEMICOLON)) {
            container.add(new JButton(string));
            return true;

        } else if (evaluate(Token.GROUP) && parseRadioButtons(container)) {
            return endWidget();

        } else if (evaluate(Token.LABEL) && evaluate(Token.STRING) && evaluate(Token.SEMICOLON)) {
            container.add(new JLabel(string));
            return true;

        } else if (evaluate(Token.PANEL)) {
            container.add(container = new JPanel());
            if (parseLayout(container) && parseWidgets(container)) {
                return endWidget();
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

    private boolean endWidget() throws IOException {
        if (evaluate(Token.END)) {
            return evaluate(Token.SEMICOLON);
        }
        return false;
    }

    private boolean parseRadioButtons(Container container) throws IOException {
        if (parseRadioButton(container)) {
            if (parseRadioButtons(container)) {
                return true;
            }
            return true;
        }
        return false;
    }

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
