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
import java.util.ArrayList;

/**
 * This class contain the constructor and methods for the File Handler. It tries to resolve the
 * String arguments into files before analyzing, parsing and creating GUIs from the contents.
 *
 * @author tylerclark
 */
public class FileHandler {

    private ArrayList<File> files;
    private ArrayList<LexicalAnalyzer> analyzers;
    private ArrayList<JFrame> jFrames;

    /**
     * Creates a constructor that will attempt to resolve the file paths of the supplied arguments
     * with {@link #pathResolver(String)} and will add the files to {@link #files}
     *
     * @param args array of strings representing files
     */
    public FileHandler(String[] args) {
        files = new ArrayList<>();
        analyzers = new ArrayList<>();
        jFrames = new ArrayList<>();
        if (args.length == 0) {
            System.out.println("no arguments were given.");
        } else {
            for (int i = 0; i <= args.length - 1; i++) {
                File newFile = pathResolver(args[i]);
                if (newFile.exists()) {
                    files.add(newFile);
                } else {
                    System.out.println(args[i] + " is not a valid file or path");
                }
            }
        }
    }

    /**
     * Creates an analyzer for every resolved file in the the files array. Will catch {@link
     * FileNotFoundException} when {@link LexicalAnalyzer} is passed a file that does not exist.
     */
    private void analyzeFiles() {
        // analyzers = new LexicalAnalyzer[this.files.size()];
        for (File file : this.files) {
            try {
                this.analyzers.add(new LexicalAnalyzer(file));
            } catch (FileNotFoundException e) {
                System.err.println(this.files + " Is not a valid file");
            }
        }
    }
    /**
     * Creates a JFrame for every analyzer in the the analyzers array. Will parse the resolved files
     * with the analyzer. Will catch issues with StreamToken and any {@link SyntaxError} errors.
     */
    private void passAnalyzers() {
        // jFrames = new JFrame[analyzers.length];
        for (LexicalAnalyzer analyzer : this.analyzers) {
            JFrame result;
            try {
                Parser parser = new Parser(analyzer);
                result = parser.run();
                jFrames.add(result);
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

        File srcDir;
        File projectDir;
        File lastDir;

        try {
            srcDir = new File(Paths.get("project1/test/" + argument).toAbsolutePath().toString());
            projectDir = new File(Paths.get("test/" + argument).toAbsolutePath().toString());
            lastDir = new File(Paths.get(argument).toAbsolutePath().toString());

            if (srcDir.exists()) {
                return srcDir;
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
        analyzeFiles();
        passAnalyzers();
        for (JFrame frame : jFrames) {
            frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            frame.setVisible(true);
        }
    }
}
