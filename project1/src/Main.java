/*
 * *****************************************************************************
 * NAME: Tyler D Clark
 * PROJECT: Main - Project 1
 * COURSE: CMSC 330
 * DATE: 14 SEP 2020
 * *****************************************************************************
 */

/**
 * The Main class provides a command line launch of the parser. This class consists of the public
 * static void main entry point.
 *
 * @author tylerclark
 */
class Main {

    /**
     * Entry point
     *
     * @param args names of the input files from where the GUIs will be constructed based on on the
     *     syntax contained.
     */
    public static void main(String[] args) {

        FileHandler handler = new FileHandler(args);
        handler.runGUIs();
    }
}
