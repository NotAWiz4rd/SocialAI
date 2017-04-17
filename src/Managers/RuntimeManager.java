package Managers;

/**
 * Created by NotAWiz4rd on 15.04.2017.
 */
public class RuntimeManager
{
  // this class runs the simulation in ticks. It makes sure everything gets updated properly
  // 1 tick = 1 second

  private ResourceManager resourceManager = new ResourceManager();
  public PersonManager personManager = new PersonManager();
  public ObjectManager objectManager = new ObjectManager();

  private boolean isRunning = false;

  public RuntimeManager()
  {
    while(isRunning)
    {

    }
  }

  public void start()
  {
    isRunning = true;
  }

  public void stop()
  {
    isRunning = false;
  }

  private void simulateTick()
  {

  }
}
