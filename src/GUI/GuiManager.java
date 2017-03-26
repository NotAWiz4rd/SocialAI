package GUI;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Created by notawiz4rd on 26/03/2017.
 */

// This is the Base Class from where the GUI is managed
public class GuiManager
{
  private JFrame mainWindow;

  public GuiManager()
  {
    initializeMainWindow();
  }

  private void initializeMainWindow()
  {
    mainWindow = new JFrame("MainWindow");
    mainWindow.setSize(500, 500);
    mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    mainWindow.setVisible(true);
  }

}
