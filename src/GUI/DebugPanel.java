package GUI;

import Entities.EntityManger;

import javax.swing.JFrame;

/**
 * Created by NotAWiz4rd on 27.03.2017.
 */

// this is a side panel to the MainFrame where all entities are shown. They show all info on click (maybe in a new window?)
public class DebugPanel
  extends JFrame
{
  private EntityManger entityManager;

  public DebugPanel(EntityManger m_entityManger)
  {
    entityManager = m_entityManger;
  }
}
