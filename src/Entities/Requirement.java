package Entities;

/**
 * Created by NotAWiz4rd on 02.04.2017.
 */
public class Requirement
{
  private String requirementString;

  public Requirement(String m_requirementString)
  {
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

  public String getRequirementString()
  {
    return requirementString;
  }

  public void setRequirementString(String requirementString)
  {
    this.requirementString = requirementString;
  }
}
