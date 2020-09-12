public class SyntaxError extends Exception{


    SyntaxError(int line, String description){
        super("Line: " + line + " " + description);
    }

}
