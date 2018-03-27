package GUI;

import Entities.Position;
import Managers.PersonManager;
import Managers.RuntimeManager;

import javax.swing.*;
import java.awt.*;

/**
 * @author Max Werner
 */
public class MainFrame
        extends JFrame {
    private PersonManager personManager;
    private RuntimeManager runtimeManager;
    private JPanel[] people;
    private JPanel[] objects;

    public MainFrame(RuntimeManager m_runtimeManager) {
        ToolTipManager.sharedInstance().setInitialDelay(0);
        runtimeManager = m_runtimeManager;
        personManager = runtimeManager.personManager;
        setLayout(null);
        people = new JPanel[personManager.getPersonCount()];
        objects = new JPanel[runtimeManager.objectManager.getObjectsCount()];
        displayButtons();
        initializeEntities();
        displayEntities();
        displayObjects();
    }

    private void displayEntities() {
        Position[] positions = personManager.getPeoplePositions();
        for (int i = 0; i < positions.length; i++) {
            people[i].setLocation(positions[i].getX(), positions[i].getY());
        }
    }

    private void displayEnvironment() {
        // TODO display environment
    }

    private void displayObjects() {
        for (int i = 0; i < runtimeManager.objectManager.getObjectsCount(); i++) {
            objects[i] = new JPanel();
            objects[i].setSize(5, 5);
            objects[i].setBackground(Color.red);
            objects[i].setToolTipText(runtimeManager.objectManager.getObject(i).getObjectID() + "/ " +
                    runtimeManager.objectManager.getObject(i).getGroupID());
            objects[i].setLocation(runtimeManager.objectManager.getObject(i).getPosition().getX(),
                    runtimeManager.objectManager.getObject(i).getPosition().getY());
            add(objects[i]);
        }
    }

    private void initializeEntities() {
        for (int i = 0; i < personManager.getPersonCount(); i++) {
            people[i] = new JPanel();
            people[i].setSize(3, 3);
            people[i].setBackground(Color.black);
            people[i].setToolTipText(personManager.getPerson(i).getId() + "");
            add(people[i]);
        }
    }

    private void displayButtons() {
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

    public void reload() {
        displayEntities();
        displayEnvironment();
    }
}
