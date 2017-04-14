package Managers;

import Entities.Need;

/**
 * Created by NotAWiz4rd on 14.04.2017.
 */
public class NeedManager // this manager decides whether and which tasks are to be issued based on the input of the person and the circumstances
{
  private Need[] needs;

  public NeedManager()
  {
  }

  public void evaluateNeeds()
  {

  }

  public Need[] getNeeds()
  {
    return needs;
  }

  public void setNeeds(Need[] needs)
  {
    this.needs = needs;
  }
}
