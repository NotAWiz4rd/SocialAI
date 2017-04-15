package Entities;

/**
 * Created by NotAWiz4rd on 27.03.2017.
 */
public class Opinion
{
  private Property property;
  private int impact;  // how much the opinion effects the general opinion of someone
  private int personalLevel;  // how likely a person will share this opinion

  public Opinion(Property m_property, int m_impact, int m_personalLevel)
  {
    property = m_property;
    impact = m_impact;
    personalLevel = m_personalLevel;
  }

  public Property getProperty()
  {
    return property;
  }

  public void setProperty(Property property)
  {
    this.property = property;
  }

  public int getImpact()
  {
    return impact;
  }

  public void setImpact(int impact)
  {
    this.impact = impact;
  }

  public int getPersonalLevel()
  {
    return personalLevel;
  }

  public void setPersonalLevel(int personalLevel)
  {
    this.personalLevel = personalLevel;
  }
}
