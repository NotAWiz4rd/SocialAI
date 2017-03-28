package GUI;

import Entities.EntityManger;
import Entities.Location;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Created by NotAWiz4rd on 27.03.2017.
 */
public class MainFrame
  extends JFrame
{
  private EntityManger entityManger;
  private JPanel[] entities;

  public MainFrame(EntityManger m_entityManager)
  {
    entityManger = m_entityManager;
    setLayout(null);
    entities = new JPanel[entityManger.getEntityCount()];
  }

  private void displayEntities()
  {
    /* TODO display entities from entityManager
    this should only need their location
     */
    Location[] locations = entityManger.getEntityLocations();
    for(int i = 0; i < locations.length; i++)
    {
      entities[i].setLocation(locations[i].getX(), locations[i].getY());
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
    }
  }
}
