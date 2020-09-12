
import java.io.IOException;

class Main {

  public static void main(String[] args) throws IOException {

    FileHandler handler = new FileHandler(args);
    LexicalAnalyzer[] lyzers = handler.analyzeFiles();
    for (LexicalAnalyzer lyzer : lyzers) lyzer.getNext();
  }
}
