package GUI;

import Managers.PersonManager;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Created by NotAWiz4rd on 27.03.2017.
 */

// this is a side panel to the MainFrame where all entities are shown. They show all info on click (maybe in a new window?)
public class DebugPanel
  extends JFrame
{
  private PersonManager personManager;

  public DebugPanel(PersonManager m_personManager)
  {
    personManager = m_personManager;
  }

  private void loadEntities()
  {
    JLabel entity = new JLabel("BLA");
    add(entity);
  }

  public void reload()
  {
    // TODO check what has changed and only change those values
  }
}
