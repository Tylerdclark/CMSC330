class Main {

    public static void main(String[] args) {

        FileHandler handler = new FileHandler(args);
        handler.analyzeFiles();
        handler.passAnalyzers();
        handler.runGUIs();
    }
}
