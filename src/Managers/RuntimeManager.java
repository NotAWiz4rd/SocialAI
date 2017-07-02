package Managers;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import Interfaces.ChangeListener;

/**
 * Created by NotAWiz4rd on 15.04.2017.
 */
public class RuntimeManager
{
  // this class runs the simulation in ticks. It makes sure everything gets updated properly
  // 1 tick = 1 second

  private final int mapHeight = 1000;
  private final int mapWidth = 1000;
  public PersonManager personManager = new PersonManager(mapWidth, mapHeight);
  public ObjectManager objectManager = new ObjectManager();
  public ActionManager actionManager = new ActionManager();
  private ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
  private long speed = 250; // 1000 = 1 tick per second
  private ChangeListener listener;

  private boolean isRunning = true;

  public RuntimeManager()
  {
  }

  private void run()
  {
    scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
    scheduledExecutorService.scheduleAtFixedRate(this::simulateTick, 0, speed, TimeUnit.MILLISECONDS);
  }

  public void start()
  {
    isRunning = true;
    run();
  }

  public void stop()
  {
    isRunning = false;
    scheduledExecutorService.shutdown();
  }

  private void simulateTick()
  {
    personManager.simulatePeople();

    if(listener != null)
    {
      listener.onChangeHappened(); // notify GuiManager to reload; this is just for testing in our GUI
    }
  }

  public void setSpeed(int newSpeed)
  {
    speed = newSpeed; // 500 double speed, 250 quadruple speed
  }

  public void setChangeListener(ChangeListener m_listener)
  {
    listener = m_listener;
  }

  public int getMapHeight()
  {
    return mapHeight;
  }

  public int getMapWidth()
  {
    return mapWidth;
  }
}
