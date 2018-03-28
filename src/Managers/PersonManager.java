package Managers;

import Entities.Person;
import Entities.Position;

import java.util.ArrayList;

/**
 * Manages all entities. Entities have to added before they can be accessed.
 *
 * @author Max Werner
 */
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

    /**
     * Adds a person to the accessible list of people.
     *
     * @param person Person to add
     */
    public void addPerson(Person person) {
        people.add(person);
    }

    /**
     * Returns positions of all people currently registered.
     *
     * @return Positions of all people.
     */
    public Position[] getPeoplePositions() {
        Position[] positions = new Position[people.size()];

        for (int i = 0; i < people.size(); i++) {
            positions[i] = people.get(i).getPosition();
        }

        return positions;
    }

    /**
     * Executes the move-function of each person.
     */
    private void movePeople() {
        for (Person person : people) {
            person.move(mapWidth, mapHeight);
        }
    }

    /**
     * Decreases needs of all registered people.
     */
    private void decreaseNeeds() {
        for (Person person : people) {
            if (tickCount % DECREASE_TICK == 0) // decrease needs every x ticks
            {
                person.decreaseNeeds();
            }
        }
    }

    /**
     * Simulates all registered people by doing the following things:
     * - activating the ActionManager if there is none
     * - moving them
     * - decreasing their needs
     */
    public void simulatePeople() {
        if (!setActionManager) {
            setActionManager();
        }

        tickCount++;
        movePeople();
        decreaseNeeds();
    }

    /**
     * Assigns an ActionManager to all people.
     */
    private void setActionManager() {
        for (Person person : people) {
            person.setActionManager(actionManager);
        }
    }

    //GETTER AND SETTER

    public Person getPerson(int index) {
        return people.get(index);
    }

    public int getPersonCount() {
        return people.size();
    }
}
