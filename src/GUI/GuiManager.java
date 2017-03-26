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
  private String version;

  public GuiManager(String m_version)
  {
    version = m_version;
    initializeMainWindow();
  }

  private void initializeMainWindow()
  {
    mainWindow = new MainFrame();
    mainWindow.setTitle("MainWindow v" + version);
    mainWindow.setSize(500, 500);
    mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    mainWindow.setVisible(true);
  }

}
