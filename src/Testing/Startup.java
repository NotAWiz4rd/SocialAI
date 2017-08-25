package Testing;

import java.io.IOException;

import Entities.Position;
import Managers.ActionManager;
import Managers.ObjectManager;
import Managers.PersonManager;
import Managers.ResourceManager;

/**
 * Created by NotAWiz4rd on 26.03.2017.
 */
public class Startup
{
  PersonManager personManager;
  ActionManager actionManager;
  ObjectManager objectManager;
  ResourceManager resourceManager = new ResourceManager();

  public Startup(PersonManager m_personManager, ActionManager m_actionManager, ObjectManager m_objectManager)
    throws IOException
  {
    personManager = m_personManager;
    actionManager = m_actionManager;
    objectManager = m_objectManager;
    initializeEntities();
    createEnvironment();
    objectShoutOut();
    //TODO Test setTargetPostion(new Position(300, 300, 0));
  }

  private void initializeEntities()
    throws IOException
  {
    resourceManager.loadResources(personManager, actionManager, objectManager);
  }

  private void objectShoutOut()
  {
    for(int i = 0; i < personManager.getPersonCount(); i++)
    {
      personManager.getPerson(i).setKnownObjects(objectManager.getObjects());
    }
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
