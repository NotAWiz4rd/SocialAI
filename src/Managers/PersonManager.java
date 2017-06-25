package Managers;

import java.util.ArrayList;

import Entities.Entity;
import Entities.Person;
import Entities.Position;

/**
 * Created by notawiz4rd on 26/03/2017.
 */

// this class manages all the entities in one list. All Entities have to be added here to be accessed
public class PersonManager
{
  private ArrayList<Person> people = new ArrayList<>();

  public PersonManager()
  {
  }

  public void addPerson(Person person)
  {
    people.add(person);
  }

  public Position[] getPeoplePositions()
  {
    Position[] positions = new Position[people.size()];

    for(int i = 0; i < people.size(); i++)
    {
      positions[i] = people.get(i).getPosition();
    }

    return positions;
  }

  public Entity getPerson(int index)
  {
    return people.get(index);
  }

  public int getPersonCount()
  {
    return people.size();
  }
}
