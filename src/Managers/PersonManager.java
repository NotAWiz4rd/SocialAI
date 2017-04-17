package Managers;

import Entities.Entity;
import Entities.Person;
import Entities.Position;

import java.util.ArrayList;

/**
 * Created by notawiz4rd on 26/03/2017.
 */

// this class manages all the entities in one list. All Entities have to be added here to be accessed; they get an id here
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


  // indexes all entities. this should only be called once and only when all entities are added to the manager
  public void indexPeople()
  {
    for(int i = 0; i < people.size(); i++)
    {
      people.get(i).setId(i);
    }
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
