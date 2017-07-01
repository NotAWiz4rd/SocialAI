package Entities;

/**
 * Created by NotAWiz4rd on 14.04.2017.
 */
public class Need
{
  private String id;
  private String description; //basically a tooltip
  private int value;

  public Need(String m_id, String m_description, int m_value)
  {
    id = m_id;
    description = m_description;
    value = m_value;
  }

  public String getId()
  {
    return id;
  }

  public void setId(String id)
  {
    this.id = id;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  public int getValue()
  {
    return value;
  }

  public void setValue(int value)
  {
    this.value = value;
  }
}
