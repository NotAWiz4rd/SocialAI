package GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Entities.Attributes;
import Entities.Person;
import Managers.PersonManager;

/**
 * Created by NotAWiz4rd on 27.03.2017.
 */

// this is a side panel to the MainFrame where all entities are shown. They show all info on click (maybe in a new window?)
public class DebugPanel
  extends JFrame
{
  private PersonManager personManager;

  private static int ENTRYHEIGHT = 40;

  private int personCount;

  //all Panels and Labels
  JPanel[] panels;
  JLabel[] namePanels;
  JLabel[] positionPanels;
  JLabel[] actionPanels;
  JLabel[] idPanels;

  public DebugPanel(PersonManager m_personManager)
  {
    personManager = m_personManager;
    setLayout(null);

    personCount = personManager.getPersonCount();

    panels = new JPanel[personCount];
    idPanels = new JLabel[personCount];
    namePanels = new JLabel[personCount];
    positionPanels = new JLabel[personCount];
    actionPanels = new JLabel[personCount];

    loadEntities();
  }

  private void loadEntities()
  {
    int y = 0;
    for(int i = 0; i < personCount; i++)
    {
      panels[i] = new JPanel();
      idPanels[i] = new JLabel("ID: " + personManager.getPerson(i).getId());
      namePanels[i] = new JLabel("Name: " + personManager.getPerson(i).getName());
      positionPanels[i] = new JLabel("Position: " + personManager.getPerson(i).getPosition().getX() + " "
                                     + personManager.getPerson(i).getPosition().getY() + " " + personManager.getPerson(i).getPosition().getZ());
      actionPanels[i] = new JLabel("Current Action: " + "Chilling");
      panels[i].setSize(500, ENTRYHEIGHT);
      panels[i].setLocation(0, y);
      panels[i].add(idPanels[i]);
      panels[i].add(namePanels[i]);
      panels[i].add(positionPanels[i]);
      panels[i].add(actionPanels[i]);
      add(panels[i]);
      y += ENTRYHEIGHT;

      panels[i].addMouseListener(new MouseAdapter()
      {
        @Override
        public void mouseClicked(MouseEvent e)
        {
          int x = (int) e.getYOnScreen() / ENTRYHEIGHT;
          showDetailInfo(x - 1);
        }
      });
    }
  }

  public void reload()
  {
    for(int i = 0; i < personCount; i++)
    {
      positionPanels[i].setText("Position: " + personManager.getPerson(i).getPosition().getX() + " "
                                     + personManager.getPerson(i).getPosition().getY() + " " + personManager.getPerson(i).getPosition().getZ());
      actionPanels[i].setText("Current Action: " + "Chilling");
    }
  }

  private void showDetailInfo(int index)
  {
    JFrame detailWindow = new JFrame("ID: " + (index + 1));
    Person person = personManager.getPerson(index);

    detailWindow.setSize(500, 400);
    detailWindow.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    detailWindow.setVisible(true);
    detailWindow.setResizable(false);

    JPanel panel = new JPanel();

    JLabel idPanel = new JLabel("ID: " + person.getId() + "                     ");
    JLabel namePanel = new JLabel("Name: " + person.getName() + "                     ");
    JLabel positionPanel = new JLabel("Position: " + person.getPosition().getX() + " "
                                      + person.getPosition().getY() + " " + person.getPosition().getZ());
    JLabel actionPanel = new JLabel("Current Action: " + "Chilling" + "         ");
    Attributes attributes = person.getAttributes();
    JLabel attributePanel = new JLabel("Strength: " + attributes.getStrength() + "  Charisma: " + attributes.getCharisma() + "  Constitution: "
                                       + attributes.getConstitution() + "  Intelligence: " + attributes.getIntelligence() + "  Dexterity: "
                                       + attributes.getDexterity());
    JLabel sexPanel = new JLabel("Sex: " + person.getSex() + "                     ");
    JLabel heightPanel = new JLabel("Height: " + person.getHeight() + "cm           ");
    JLabel workplacePanel = new JLabel("Workplace: " + person.getWorkplaceID() + "                     ");
    JLabel stancePanel = new JLabel("Stance: " + person.getStance() + "        ");
    JLabel propertiesPanel = new JLabel();
    JLabel likesPanel = new JLabel();
    JLabel dislikesPanel = new JLabel();
    JLabel needsPanel = new JLabel();
    JLabel currentSizePanel = new JLabel("Current Size: " + person.getCurrentSize() + "cm            ");
    // TODO think about ways of displaying the arrayLists

    panel.add(idPanel);
    panel.add(namePanel);
    panel.add(positionPanel);
    panel.add(actionPanel);
    panel.add(sexPanel);
    panel.add(heightPanel);
    panel.add(workplacePanel);
    panel.add(needsPanel);
    panel.add(stancePanel);
    panel.add(attributePanel);
    panel.add(propertiesPanel);
    panel.add(currentSizePanel);
    panel.add(likesPanel);
    panel.add(dislikesPanel);

    detailWindow.add(panel);
  }
}
