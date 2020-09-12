import javax.swing.*;

public class Parser {

LexicalAnalyzer lexer;
JFrame result;


    public Parser(LexicalAnalyzer lexer){
        this.lexer = lexer;

    }

    public JFrame run() {
        return result;
    }
}
