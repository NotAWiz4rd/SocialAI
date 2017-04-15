package Entities;

/**
 * Created by NotAWiz4rd on 27.03.2017.
 */
public class Task
{
  private boolean isCancelable;
  private int priority;
  private Action action;  // TODO evaluate if this should be an Array to be able to make complex tasks

  public Task(boolean m_isCancelable, int m_priority)
  {
    isCancelable = m_isCancelable;
    priority = m_priority;
  }

  public boolean isCancelable()
  {
    return isCancelable;
  }

  public void setCancelable(boolean cancelable)
  {
    isCancelable = cancelable;
  }

  public int getPriority()
  {
    return priority;
  }

  public void setPriority(int priority)
  {
    this.priority = priority;
  }

  public Action getAction()
  {
    return action;
  }

  public void setAction(Action action)
  {
    this.action = action;
  }
}
