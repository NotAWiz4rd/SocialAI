package GUI;

import Entities.EntityManger;

import javax.swing.JFrame;

/**
 * Created by NotAWiz4rd on 27.03.2017.
 */
public class MainFrame
  extends JFrame
{
  EntityManger entityManger;

  public MainFrame(EntityManger m_entityManager)
  {
    entityManger = m_entityManager;
  }

  private void displayEntities()
  {
    /* TODO display entities from entityManager
    this should only need their location
     */
  }

  private void displayEnvironment()
  {
    // TODO display environment
  }
}
