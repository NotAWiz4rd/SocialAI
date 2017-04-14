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

  public Action()
  {

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
}
