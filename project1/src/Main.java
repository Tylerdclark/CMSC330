
import javax.swing.*;
import java.io.IOException;

class Main {

  public static void main(String[] args) throws IOException, SyntaxError {

    FileHandler handler = new FileHandler(args);
    LexicalAnalyzer[] analyzers = handler.analyzeFiles();
        for (LexicalAnalyzer analyzer : analyzers) {
          Parser parser = new Parser(analyzer);
            JFrame result = parser.run();
            result.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            result.setVisible(true);
      }
  }

}
