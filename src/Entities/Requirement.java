package Entities;

/**
 * Created by NotAWiz4rd on 02.04.2017.
 */
public class Requirement
{
  private String actionID;
  private String requirementString;

  public Requirement(String m_actionID, String m_requirementString)
  {
    actionID = m_actionID;
    requirementString = m_requirementString;
  }

  public boolean checkRequirement()
  {
    // check everything here
    return false;
  }

  private void decodeRequirement()
  {

  }

  public String getActionID()
  {
    return actionID;
  }

  public void setActionID(String actionID)
  {
    this.actionID = actionID;
  }

  public String getRequirementString()
  {
    return requirementString;
  }

  public void setRequirementString(String requirementString)
  {
    this.requirementString = requirementString;
  }
}
