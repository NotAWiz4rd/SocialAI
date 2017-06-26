package GUI;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Entities.Position;
import Managers.PersonManager;
import Managers.RuntimeManager;

/**
 * Created by NotAWiz4rd on 27.03.2017.
 */
public class MainFrame
  extends JFrame
{
  private PersonManager personManager;
  private RuntimeManager runtimeManager;
  private JPanel[] entities;

  public MainFrame(RuntimeManager m_runtimeManager)
  {
    runtimeManager = m_runtimeManager;
    personManager = runtimeManager.personManager;
    setLayout(null);
    entities = new JPanel[personManager.getPersonCount()];
    displayButtons();
    initializeEntities();
    displayEntities();
  }

  private void displayEntities()
  {
    Position[] positions = personManager.getPeoplePositions();
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
    for(int i = 0; i < personManager.getPersonCount(); i++)
    {
      entities[i] = new JPanel();
      entities[i].setSize(3, 3);
      entities[i].setBackground(Color.black);
      add(entities[i]);
    }
  }

  private void displayButtons()
  {
    JButton start = new JButton("Start");
    JButton stop = new JButton("Stop");

    start.addActionListener(e -> runtimeManager.start());

    stop.addActionListener(e -> runtimeManager.stop());

    start.setSize(50, 50);
    stop.setSize(50, 50);

    start.setLocation(50, 400);
    stop.setLocation(100, 400);

    add(start);
    add(stop);
  }

  public void reload()
  {
    displayEntities();
    displayEnvironment();
  }
}
