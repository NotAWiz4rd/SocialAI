package Testing;

import java.io.IOException;

import Entities.Position;
import Managers.ActionManager;
import Managers.PersonManager;
import Managers.ResourceManager;

/**
 * Created by NotAWiz4rd on 26.03.2017.
 */
public class Startup
{
  PersonManager personManager;
  ActionManager actionManager = new ActionManager();
  ResourceManager resourceManager = new ResourceManager();

  public Startup(PersonManager m_personManager)
    throws IOException
  {
    personManager = m_personManager;
    initializeEntities();
    createEnvironment();
    setTargetPostion(new Position(300, 300, 0));
  }

  private void initializeEntities()
    throws IOException
  {
    resourceManager.loadResources(personManager, actionManager);
  }

  private void setTargetPostion(Position postion)
  {
    for(int i = 0; i < personManager.getPersonCount(); i++)
    {
      personManager.getPerson(i).getTaskManager().setPositionToBe(postion);
    }
  }

  private void createEnvironment()
  {
    // TODO create a Test-Environment here
  }
}
