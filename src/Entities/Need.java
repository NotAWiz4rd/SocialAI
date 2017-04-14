package Entities;

/**
 * Created by NotAWiz4rd on 14.04.2017.
 */
public class Need
{
  private String id;
  private String name; // how the value is shown ingame
  private String description; //basically a tooltip
  // the value is saved within the person-object together with the need-id

  public Need(String m_id, String m_name, String m_description)
  {
    id = m_id;
    name = m_name;
    description = m_description;
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

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }
}
