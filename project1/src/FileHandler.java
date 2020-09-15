/*
 * *****************************************************************************
 * NAME: Tyler D Clark
 * PROJECT: File Handler - Project 1
 * COURSE: CMSC 330
 * DATE: 14 SEP 2020
 * *****************************************************************************
 */

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
/**
 * This class contain the constructor and methods for the File Handler. It tries to resolve the
 * String arguments into files before analyzing, parsing and creating GUIs from the contents.
 *
 * @author tylerclark
 */
public class FileHandler {

    private File[] files;
    private LexicalAnalyzer[] analyzers;
    private JFrame[] jFrames;

    /**
     * Creates a constructor that will attempt to resolve the file paths of the supplied arguments
     * with {@link #pathResolver(String)} and will add the files to {@link #files}
     *
     * @param args array of strings representing files
     */
    public FileHandler(String[] args) {

        if (args.length == 0) {
            System.out.println("no arguments were given.");
        } else {
            files = new File[args.length];
            for (int i = 0; i <= args.length - 1; i++) {
                files[i] = pathResolver(args[i]);
            }
        }
    }

    /**
     * Creates an analyzer for every resolved file in the the files array. Will catch {@link
     * FileNotFoundException} when {@link LexicalAnalyzer} is passed a file that does not exist.
     */
    private void analyzeFiles() {
        analyzers = new LexicalAnalyzer[this.files.length];
        for (int i = 0; i <= this.files.length - 1; i++) {
            try {
                analyzers[i] = new LexicalAnalyzer(files[i]);
            } catch (FileNotFoundException e) {
                System.err.println(this.files[i] + " Is not a valid file");
            }
        }
    }
    /**
     * Creates a JFrame for every analyzer in the the analyzers array. Will parse the resolved files
     * with the analyzer. Will catch issues with StreamToken and any {@link SyntaxError} errors.
     */
    private void passAnalyzers() {
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

    /**
     * Due to inconsistent pathing during testing, this method is to resolve paths for (hopefully)
     * every environment it is called in.
     *
     * @param argument String to the file path that will be resolved
     * @return File that has attempted to be resolved. If not resolved, will cause {@link
     *     FileNotFoundException}
     */
    private File pathResolver(String argument) {

        File srcDirFile;
        File projectDir;
        File lastDir;

        try {
            srcDirFile =
                    new File(Paths.get("project1/src/" + argument).toAbsolutePath().toString());
            projectDir = new File(Paths.get("src/" + argument).toAbsolutePath().toString());
            lastDir = new File(Paths.get(argument).toAbsolutePath().toString());

            if (srcDirFile.exists()) {
                return srcDirFile;
            } else if (projectDir.exists()) {
                return projectDir;
            } else if (lastDir.exists()) {
                return lastDir;
            }

        } catch (NullPointerException nullPointerException) {
            System.err.println(argument + " Is not a valid file");
        }
        return new File(argument);
    }

    /**
     * Calls {@link #analyzeFiles()} and {@link #passAnalyzers()} before displaying every JFrame in
     * the local array {@link #jFrames}
     */
    public void runGUIs() {
        if (files != null) {
            analyzeFiles();
            if (analyzers != null) {
                passAnalyzers();
            }
            if (jFrames != null) {
                for (JFrame frame : jFrames) {
                    frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                    frame.setVisible(true);
                }
            }
        }
    }
}
