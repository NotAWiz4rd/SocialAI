package Testing;

import Entities.Person;
import Entities.Position;
import Enums.Sex;
import Managers.PersonManager;

/**
 * Created by NotAWiz4rd on 26.03.2017.
 */
public class Test
{
  PersonManager personManager;

  public Test(PersonManager m_personManager)
  {
    personManager = m_personManager;
    initializeEntities();
    createEnvironment();
  }

  private void initializeEntities()
  {
    Person person = new Person("Max Werner", 18, Sex.MALE, new Position(100, 100, 0), 195, new int[]{10, 13, 7, 7, 14});

    personManager.addPerson(person);
  }

  private void createEnvironment()
  {
    // TODO create a Test-Environment here
  }
}
