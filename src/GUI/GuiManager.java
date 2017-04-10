package GUI;

import Managers.EntityManger;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

/**
 * Created by notawiz4rd on 26/03/2017.
 */

// This is the Base Class from where the GUI is managed
public class GuiManager
{
  private JFrame mainWindow;
  private JFrame debugPanel;
  private String version;
  private EntityManger entityManger = new EntityManger();
  private Image iconImage;

  public GuiManager(String m_version)
  {
    version = m_version;
    getIconImage();
    initializeMainWindow();
    initializeDebugPanel();
  }

  private void initializeMainWindow()
  {
    mainWindow = new MainFrame(entityManger);
    mainWindow.setTitle("MainWindow v" + version);
    mainWindow.setSize(1000, 1000);
    mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    mainWindow.setResizable(true);
    mainWindow.setVisible(true);

    if(iconImage != null)
    {
      mainWindow.setIconImage(iconImage);
    }
  }

  private void initializeDebugPanel()
  {
    debugPanel = new DebugPanel(entityManger);
    debugPanel.setTitle("DebugPanel v" + version);
    debugPanel.setSize(500, 1000);
    debugPanel.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    mainWindow.setResizable(false);
    debugPanel.setVisible(true);

    if(iconImage != null)
    {
      debugPanel.setIconImage(iconImage);
    }
  }

  private void getIconImage()
  {
    URL url = ClassLoader.getSystemResource("sai-icon.png");
    Toolkit kit = Toolkit.getDefaultToolkit();
    iconImage = kit.createImage(url);
  }

}
