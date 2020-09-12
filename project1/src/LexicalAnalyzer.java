import javax.swing.*;
import java.io.*;

public class LexicalAnalyzer {
    private final StreamTokenizer tokenizer;
    private Reader reader;

    public LexicalAnalyzer(File currentFile) {
        try {
            reader = new BufferedReader(new FileReader(currentFile));
        } catch (FileNotFoundException fnf) {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), fnf.getMessage());
        }
        tokenizer = new StreamTokenizer(reader);
        tokenizer.ordinaryChar('.');
        tokenizer.quoteChar('"');
    }
    // chaning Token to void for testing
    public void getNext() throws IOException {
        //        switch (tokenizer.nextToken()){
        //
        //        }
        int nextToken = tokenizer.nextToken();
        while (nextToken != StreamTokenizer.TT_EOF) {

            if (nextToken == StreamTokenizer.TT_NUMBER) {
                System.out.println("Number: "+tokenizer.nval + " TTYPE: "+ tokenizer.ttype);
            } else if (nextToken == StreamTokenizer.TT_WORD) {
                System.out.println("String: " + tokenizer.sval+ " TTYPE: "+ tokenizer.ttype);

            } else if(nextToken == '"'){
                System.out.println("String: " + tokenizer.sval+" TTYPE: "+ tokenizer.ttype);
            }else {

                System.out.println((char)nextToken);
            }

            nextToken = tokenizer.nextToken();
        }
    }
}
