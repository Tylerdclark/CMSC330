import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Main {


  public static void main(String[] args) throws InvocationTargetException, InterruptedException {
    int userChoice = getUserChoice();
    while (userChoice == 0) {
      // JFileChooser showDialog was giving me issues on OSX, so this allowed it to execute in the
      // right thread
      EventQueue.invokeAndWait(Main::getFile);

      userChoice = getUserChoice();
    }
  }

  public static int getUserChoice() {
    return JOptionPane.showConfirmDialog(
        null, "Would you like to select a file?", "Project 1", JOptionPane.YES_NO_CANCEL_OPTION);
  }

  public static void getFile() {
    JFileChooser chooser = new JFileChooser();
    Scanner fileIn = null;
    // Show both directories and files
    chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
    // use current directory for ease
    chooser.setCurrentDirectory(new File("."));
    int response = chooser.showOpenDialog(chooser.getParent());
    if (response == JFileChooser.APPROVE_OPTION) {
      File currentFile = chooser.getSelectedFile();
      
    }
  }
}
