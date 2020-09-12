import java.io.File;
import java.util.Objects;

public class FileHandler {

  private File[] files;

  public FileHandler(String[] args) {

    if (args.length == 0) {
      System.out.println("no arguments were given.");
    } else {

      files = new File[args.length];
      for (int i = 0; i <= args.length - 1; i++) {
        try {
          ClassLoader classLoader = getClass().getClassLoader();
          files[i] = new File(Objects.requireNonNull(classLoader.getResource(args[i])).getFile());
        } catch (NullPointerException nullPointerException) {
          System.err.println("src/" + args[i] + "Is not a valid file");
        }
      }
    }
  }

  public LexicalAnalyzer[] analyzeFiles() {
    LexicalAnalyzer[] analyzers = new LexicalAnalyzer[this.files.length];
    for (int i = 0; i <= this.files.length - 1; i++) {
      analyzers[i] = new LexicalAnalyzer(files[i]);
    }
    return analyzers;
  }
}
