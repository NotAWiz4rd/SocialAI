package Entities;

/**
 * Created by NotAWiz4rd on 27.03.2017.
 */
public class Property
{
  private String id;

  public Property(String m_id)
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
