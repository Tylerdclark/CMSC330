public enum Token {

    STRING{
        boolean compare(int value){
            return true;
        }
    }, NUMBER, END, BUTTON,  FLOW, GRID, GROUP, LABEL, LAYOUT, PANEL, RADIO, TEXTFIELD, WINDOW,
    COMMA, COLON, SEMICOLON, PERIOD, LEFT_PAREN, RIGHT_PAREN,
     EOF
}
