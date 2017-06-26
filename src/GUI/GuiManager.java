package GUI;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URL;

import javax.swing.WindowConstants;

import Interfaces.ChangeListener;
import Managers.RuntimeManager;
import Testing.Startup;

/**
 * Created by notawiz4rd on 26/03/2017.
 */

// This is the Base Class from where the GUI is managed
public class GuiManager
  implements ChangeListener
{
  private MainFrame mainFrame;
  private DebugPanel debugPanel;
  private String version;
  private RuntimeManager runtimeManager = new RuntimeManager();
  private Image iconImage;

  public GuiManager(String m_version)
    throws IOException
  {
    version = m_version;
    getIconImage();
    Startup test = new Startup(runtimeManager.personManager);
    runtimeManager.setChangeListener(this);
    initializeMainWindow();
    initializeDebugPanel();
    reload();
  }

  private void initializeMainWindow()
  {
    mainFrame = new MainFrame(runtimeManager);
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

  @Override
  public void onChangeHappened()
  {
    reload();
  }
}
