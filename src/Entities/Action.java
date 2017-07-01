package Entities;

import java.util.ArrayList;

/**
 * Created by notawiz4rd on 01/04/2017.
 */
public class Action
{
  // a single action which might be multitaskable (e.g. eat, read, etc.)
  private String id;
  private boolean isMultitaskable;
  private ArrayList<NeedSatisfaction> needSatisfactions; // String is the need-id, integer is the value, this can be negative
  private ArrayList<String> requirements;
  // TODO implement this being pausable and have a standard time or something

  public Action(String m_id, boolean m_isMultitaskable, ArrayList<String> m_requirements)
  {
    id = m_id;
    isMultitaskable = m_isMultitaskable;
    requirements = m_requirements;
  }

  public Action(String m_id, boolean m_isMultitaskable, ArrayList<String> m_requirements, ArrayList<NeedSatisfaction> m_needSatisfactions)
  {
    id = m_id;
    isMultitaskable = m_isMultitaskable;
    requirements = m_requirements;
    needSatisfactions = m_needSatisfactions;
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

  public ArrayList<String> getRequirements()
  {
    return requirements;
  }

  public void setRequirements(ArrayList<String> requirements)
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

  public ArrayList<NeedSatisfaction> getNeedSatisfaction()
  {
    return needSatisfactions;
  }

  public void setNeedSatisfaction(ArrayList<NeedSatisfaction> needSatisfaction)
  {
    this.needSatisfactions = needSatisfaction;
  }
}
