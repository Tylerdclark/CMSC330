import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FromFile {
  public FromFile() throws InvocationTargetException, InterruptedException {
    int userChoice = getUserChoice();
    while (userChoice == 0) {
      // JFileChooser showDialog was giving me issues on OSX, so this allowed it to execute in the
      // right thread
      EventQueue.invokeAndWait(this::getFile);
      userChoice = getUserChoice();
    }
  }

  public int getUserChoice() {
    return JOptionPane.showConfirmDialog(
        null, "Would you like to select a file?", "Project 4", JOptionPane.YES_NO_CANCEL_OPTION);
  }

  public File getFile() {
    JFileChooser chooser = new JFileChooser();
    Scanner fileIn = null;
    // Show both directories and files
    chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
    // use current directory for ease
    chooser.setCurrentDirectory(new File("."));
    int response = chooser.showOpenDialog(chooser.getParent());
    if (response == JFileChooser.APPROVE_OPTION) {
      File file = chooser.getSelectedFile();
      try {
        fileIn = new Scanner(file);
        return file;
        //                while (fileIn.hasNextLine()) {
        //                    System.out.println(fileIn.nextLine());
        //                }

      } catch (NoSuchElementException nse) {
        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "File is empty!");
      } catch (FileNotFoundException fne) {
        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "File is not found!");
      } finally {
        assert fileIn != null;
        fileIn.close();
      }
    }
    return null;
  }
}
