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
  private JPanel[] panels;
  private JLabel[] namePanels;
  private JLabel[] positionPanels;
  private JLabel[] actionPanels;
  private JLabel[] idPanels;
  private JLabel[] needPanels;
  private JLabel[] stancePanels;
  private JLabel[] currentSizePanels;

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
    needPanels = new JLabel[personCount];
    stancePanels = new JLabel[personCount];
    currentSizePanels = new JLabel[personCount];

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
      Person person = personManager.getPerson(i);

      positionPanels[i].setText("Position: " + person.getPosition().getX() + " "
                                + person.getPosition().getY() + " " + person.getPosition().getZ());
      actionPanels[i].setText("Current Action: " + "Chilling");

      StringBuilder needsString = new StringBuilder();
      for(int t = 0; t < person.getNeeds().size(); t++)
      {
        needsString.append(person.getNeeds().get(t).getId() + ": " + person.getNeeds().get(t).getValue() + "   ");
      }
      if(needPanels[i] != null)
      {
        needPanels[i].setText(needsString.toString());
      }

      if(stancePanels[i] != null)
      {
        stancePanels[i].setText("Stance: " + person.getStance() + "        ");
      }

      if(currentSizePanels[i] != null)
      {
        currentSizePanels[i].setText("Current Size: " + person.getCurrentSize() + "cm            ");
      }
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

    JLabel agePanel = new JLabel("Age: " + person.getAge() + "   ");
    Attributes attributes = person.getAttributes();
    JLabel attributePanel = new JLabel("Strength: " + attributes.getStrength() + "  Charisma: " + attributes.getCharisma() + "  Constitution: "
                                       + attributes.getConstitution() + "  Intelligence: " + attributes.getIntelligence() + "  Dexterity: "
                                       + attributes.getDexterity());
    JLabel sexPanel = new JLabel("Sex: " + person.getSex() + "          ");
    JLabel heightPanel = new JLabel("Height: " + person.getHeight() + "cm           ");
    JLabel workplacePanel = new JLabel("Workplace: " + person.getWorkplaceID() + "                     ");
    stancePanels[index] = new JLabel("Stance: " + person.getStance() + "        ");

    StringBuilder propertyString = new StringBuilder();
    for(int l = 0; l < person.getHasProperties().size(); l++)
    {
      propertyString.append(person.getHasProperties().get(l).getId());
      propertyString.append(", \n ");
    }
    JLabel propertiesPanel = new JLabel(propertyString.toString());

    // TODO think about ways of displaying the arrayLists
    JLabel likesPanel = new JLabel();
    JLabel dislikesPanel = new JLabel();

    StringBuilder needsString = new StringBuilder();
    for(int i = 0; i < person.getNeeds().size(); i++)
    {
      needsString.append(person.getNeeds().get(i).getId() + ": " + person.getNeeds().get(i).getValue() + "   ");
    }
    needPanels[index] = new JLabel(needsString.toString());
    currentSizePanels[index] = new JLabel("Current Size: " + person.getCurrentSize() + "cm            ");

    panel.add(idPanels[index]);
    panel.add(namePanels[index]);
    panel.add(positionPanels[index]);
    panel.add(agePanel);
    panel.add(actionPanels[index]);
    panel.add(sexPanel);
    panel.add(heightPanel);
    panel.add(workplacePanel);
    panel.add(needPanels[index]);
    panel.add(stancePanels[index]);
    panel.add(attributePanel);
    panel.add(propertiesPanel);
    panel.add(currentSizePanels[index]);
    panel.add(likesPanel);
    panel.add(dislikesPanel);

    // possible changes in: position, action, needs, stance, currentSize

    detailWindow.add(panel);
  }
}
