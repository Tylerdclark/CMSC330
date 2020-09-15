/*
 * *****************************************************************************
 * NAME: Tyler D Clark
 * PROJECT: SyntaxError - Project 1
 * COURSE: CMSC 330
 * DATE: 14 SEP 2020
 * *****************************************************************************
 */

/**
 * Class contains a constructor for the custom Syntax error, which is to be called when the GUI
 * grammar is incorrect.
 *
 * @author tylerclark
 */
public class SyntaxError extends Exception {

    /**
     * Constructor for the custom Syntax error. To be called when the GUI grammar supplied is
     * incorrect.
     *
     * @param description A description of the Syntax error. Describe what was expected and what was
     *     given
     * @param line The line on which the SyntaxError was created
     */
    SyntaxError(int line, String description) {
        super(description + " On line: " + line);
    }
}
