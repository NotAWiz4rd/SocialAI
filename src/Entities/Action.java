package Entities;

import java.util.Map;

/**
 * Created by notawiz4rd on 01/04/2017.
 */
public class Action
{
  private String id;
  private boolean isMultitaskable;
  private Map<String, Integer> needSatisfaction; // String is the need-id, integer is the value, this can be negative
  private Requirement[] requirements;
  // TODO implement this being pausable and have a standard time or something

  public Action(String m_id, boolean m_isMultitaskable, Requirement[] m_requirements)
  {
    id = m_id;
    isMultitaskable = m_isMultitaskable;
    requirements = m_requirements;
  }

  public void doAction()
  {

  }

  public boolean isMultitaskable()
  {
    return isMultitaskable;
  }

  public void setMultitaskable(boolean multitaskable)
  {
    isMultitaskable = multitaskable;
  }

  public Requirement[] getRequirements()
  {
    return requirements;
  }

  public void setRequirements(Requirement[] requirements)
  {
    this.requirements = requirements;
  }

  public String getId()
  {
    return id;
  }

  public void setId(String id)
  {
    this.id = id;
  }

  public Map<String, Integer> getNeedSatisfaction()
  {
    return needSatisfaction;
  }

  public void setNeedSatisfaction(Map<String, Integer> needSatisfaction)
  {
    this.needSatisfaction = needSatisfaction;
  }
}
