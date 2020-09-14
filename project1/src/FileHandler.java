import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandler {

    private File[] files;
    private LexicalAnalyzer[] analyzers;
    private JFrame[] jFrames;

    public FileHandler(String[] args) {

        if (args.length == 0) {
            System.out.println("no arguments were given.");
        } else {
            files = new File[args.length];
            for (int i = 0; i <= args.length - 1; i++) {
                try {
                    // for some reason, my ide thinks the working directory is the directory above this one
                    Path current = Paths.get("project1/src/"+args[i]);

                    // so for the final program, use below
                    //Path current = Paths.get(args[i]);

                    String s = current.toAbsolutePath().toString();
                    files[i] = new File(s);
                } catch (NullPointerException nullPointerException) {
                    System.err.println(args[i] + " Is not a valid file");
                }
            }
        }
    }

    public void analyzeFiles() {
        analyzers = new LexicalAnalyzer[this.files.length];
        for (int i = 0; i <= this.files.length - 1; i++) {
            try {
                analyzers[i] = new LexicalAnalyzer(files[i]);
            } catch (FileNotFoundException e) {
                System.err.println(files[i] + " Is not a valid file");
            }
        }
    }

    public void passAnalyzers() {
        jFrames = new JFrame[analyzers.length];
        for (int i = 0; i <= analyzers.length - 1; i++) {
            JFrame result;
            try {
                Parser parser = new Parser(analyzers[i]);
                result = parser.run();
                jFrames[i] = result;
            } catch (IOException ioException) {
                System.err.println("Issue with StreamTokenizer");
            } catch (SyntaxError syntaxError) {
                System.err.println(syntaxError.getMessage());
            }
        }
    }

    public void runGUIs() {
        for (JFrame frame : jFrames) {
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }
    }
}
