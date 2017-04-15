package Entities;

/**
 * Created by NotAWiz4rd on 27.03.2017.
 */
public class Property
{
  private String id;
  private String name;

  public Property(String m_id, String m_name)
  {
    id = m_id;
    name = m_name;
  }

  public String getId()
  {
    return id;
  }

  public void setId(String id)
  {
    this.id = id;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }
}
