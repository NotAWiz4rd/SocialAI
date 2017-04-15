package Entities;

/**
 * Created by NotAWiz4rd on 28.03.2017.
 */
public class Location
{
  private String id;
  private int[] x;
  private int[] y;
  private int z;

  // TODO define this as a proper Location, e.g. a school or a shop. Also give it a groupID, for shops and co

  public Location(String m_id)
  {
    id = m_id;
  }

  public String getId()
  {
    return id;
  }

  public void setId(String id)
  {
    this.id = id;
  }
}
