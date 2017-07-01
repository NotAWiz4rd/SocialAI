package Managers;

import java.util.ArrayList;

import Entities.Need;
import Entities.Task;

/**
 * Created by NotAWiz4rd on 14.04.2017.
 */
public class NeedManager // this manager decides whether and which tasks are to be issued based on the input of the person and the circumstances
{
  private ArrayList<Need> needs;
  private TaskManager taskManager;

  public NeedManager(ArrayList<Need> m_needs, TaskManager m_taskManager)
  {
    needs = m_needs;
    taskManager = m_taskManager;
  }

  public void evaluateNeeds()
  {
    // have a look at needs and evaluate which tasks should be issued at which priority
    //taskManager.addTask(new Task(true, 30, ));
  }

  public ArrayList<Need> getNeeds()
  {
    return needs;
  }

  public void setNeeds(ArrayList<Need> needs)
  {
    this.needs = needs;
  }
}
