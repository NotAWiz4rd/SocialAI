package Entities;

/**
 * Created by notawiz4rd on 01/04/2017.
 */
public class Event
{
  // subject did x with object
  private Entity subject;
  private Entity object;
  private Location location;
  private Action[] actons;
  private int timeStamp;

  public Event()
  {

  }

  public Entity getSubject()
  {
    return subject;
  }

  public void setSubject(Entity subject)
  {
    this.subject = subject;
  }

  public Entity getObject()
  {
    return object;
  }

  public void setObject(Entity object)
  {
    this.object = object;
  }

  public Location getLocation()
  {
    return location;
  }

  public void setLocation(Location location)
  {
    this.location = location;
  }

  public Action[] getActons()
  {
    return actons;
  }

  public void setActons(Action[] actons)
  {
    this.actons = actons;
  }

  public int getTimeStamp()
  {
    return timeStamp;
  }

  public void setTimeStamp(int timeStamp)
  {
    this.timeStamp = timeStamp;
  }
}
