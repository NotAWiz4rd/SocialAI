package GUI;

import Managers.RuntimeManager;
import Testing.Test;

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
  private MainFrame mainFrame;
  private DebugPanel debugPanel;
  private String version;
  private RuntimeManager runtimeManager = new RuntimeManager();
  private Image iconImage;

  public GuiManager(String m_version)
  {
    version = m_version;
    getIconImage();
    Test test = new Test(runtimeManager.personManager);
    initializeMainWindow();
    initializeDebugPanel();
    mainFrame.reload();
  }

  private void initializeMainWindow()
  {
    mainFrame = new MainFrame(runtimeManager.personManager);
    mainFrame.setTitle("MainWindow v" + version);
    mainFrame.setSize(1000, 1000);
    mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    mainFrame.setResizable(true);
    mainFrame.setVisible(true);

    if(iconImage != null)
    {
      mainFrame.setIconImage(iconImage);
    }
  }

  private void initializeDebugPanel()
  {
    debugPanel = new DebugPanel(runtimeManager.personManager);
    debugPanel.setTitle("DebugPanel v" + version);
    debugPanel.setSize(500, 1000);
    debugPanel.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    debugPanel.setResizable(false);
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

  public void reload()
  {
    debugPanel.reload();
    mainFrame.reload();
  }

}
