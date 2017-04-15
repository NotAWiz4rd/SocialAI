package GUI;

import Entities.Position;
import Managers.PersonManager;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Created by NotAWiz4rd on 27.03.2017.
 */
public class MainFrame
  extends JFrame
{
  private PersonManager personManager;
  private JPanel[] entities;

  public MainFrame(PersonManager m_personManager)
  {
    personManager = m_personManager;
    setLayout(null);
    entities = new JPanel[personManager.getPersonCount()];
    initializeEntities();
  }

  private void displayEntities()
  {
    Position[] positions = personManager.getEntityPositions();
    for(int i = 0; i < positions.length; i++)
    {
      entities[i].setLocation(positions[i].getX(), positions[i].getY());
    }
  }

  private void displayEnvironment()
  {
    // TODO display environment
  }

  private void initializeEntities()
  {
    for(int i = 0; i < entities.length; i++)
    {
      entities[i] = new JPanel();
      entities[i].setSize(2, 2);
      add(entities[i]);
    }
  }

  public void reload()
  {
    displayEntities();
  }
}
