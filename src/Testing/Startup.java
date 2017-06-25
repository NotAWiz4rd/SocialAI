package Testing;

import java.io.IOException;

import Entities.Person;
import Entities.Position;
import Enums.Sex;
import Managers.PersonManager;
import Managers.ResourceManager;

/**
 * Created by NotAWiz4rd on 26.03.2017.
 */
public class Startup
{
  PersonManager personManager;
  ResourceManager resourceManager = new ResourceManager();

  public Startup(PersonManager m_personManager)
    throws IOException
  {
    personManager = m_personManager;
    initializeEntities();
    createEnvironment();
  }

  private void initializeEntities()
    throws IOException
  {
    resourceManager.loadResources(personManager);
  }

  private void createEnvironment()
  {
    // TODO create a Test-Environment here
  }
}
