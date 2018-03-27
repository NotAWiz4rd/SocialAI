package Managers;

import Entities.Person;
import Entities.Position;

import java.util.ArrayList;

/**
 * @author Max Werner
 */

// this class manages all the entities in one list. All Entities have to be added here to be accessed
public class PersonManager {
    private ArrayList<Person> people = new ArrayList<>();

    private long tickCount = 0;

    private final int DECREASE_TICK = 10;

    private int mapWidth;
    private int mapHeight;
    private ActionManager actionManager;

    private boolean setActionManager = false;

    public PersonManager(int m_mapWidth, int m_mapHeight, ActionManager m_actionManager) {
        mapWidth = m_mapWidth;
        mapHeight = m_mapHeight;
        actionManager = m_actionManager;
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public Position[] getPeoplePositions() {
        Position[] positions = new Position[people.size()];

        for (int i = 0; i < people.size(); i++) {
            positions[i] = people.get(i).getPosition();
        }

        return positions;
    }

    public Person getPerson(int index) {
        return people.get(index);
    }

    public int getPersonCount() {
        return people.size();
    }

    private void movePeople() {
        for (Person person : people) {
            person.move(mapWidth, mapHeight);
        }
    }

    private void decreaseNeeds() {
        for (Person person : people) {
            if (tickCount % DECREASE_TICK == 0) // decrease needs every x ticks
            {
                person.decreaseNeeds();
            }
        }
    }

    public void simulatePeople() {
        if (!setActionManager) {
            setActionManager();
        }

        tickCount++;
        movePeople();
        decreaseNeeds();
    }

    private void setActionManager() {
        for (Person person : people) {
            person.setActionManager(actionManager);
        }
    }
}
