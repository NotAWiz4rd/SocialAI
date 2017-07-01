package Managers;

import java.util.ArrayList;

import Entities.Action;
import Entities.Location;
import Entities.Position;
import Entities.Task;

/**
 * Created by NotAWiz4rd on 02.04.2017.
 */
public class TaskManager
{
  private ArrayList<Task> tasks;
  private ArrayList<String> requirements;
  private Task currentTask;
  private ArrayList<Action> actions;
  private Position positionToBe;
  private Position position;

  public TaskManager(Position m_position)
  {
    position = m_position;
  }

  private void checkTasks()
  {
    // check tasks for priorities and order them correctly, eventually start first task
    sortTasks();
    if(currentTask.isFinished())
    {
      currentTask = tasks.remove(0);
    }

    actions = currentTask.getAction();
    requirements = actions.get(0).getRequirements();
  }

  public void addTask(Task task)
  {
    tasks.add(task);
    checkTasks();
  }


  // Requirement checking happens here
  private void checkRequirements()
  {
    if(actions.get(0).getRequirements() == null)
    {
      return;
    }

    for(int i = 0; i < actions.get(0).getRequirements().size(); i++)
    {
      String requ = actions.get(0).getRequirements().get(i);
      String[] requSplit = requ.split(" ");

      if(requSplit[1].contains("#"))
      {
        // TODO do stuff here, check for nearest suitable object
      }
      else if(requSplit[1].contains("$"))
      {
        // TODO this one might be tricky
      }
    }
  }

  private boolean checkPosition(Position m_position, int radius) // checks if person is at required positon, sets position as positionToBe if not
  {
    boolean xInRadius = false;
    boolean yInRadius = false;

    radius = radius * 5; // going from meters to pixel

    for(int i = -radius; i < radius; i++)
    {
      if(position.getX() + i == m_position.getX())
      {
        xInRadius = true;
      }

      if(position.getY() + i == m_position.getY())
      {
        yInRadius = true;
      }
    }

    if(xInRadius && yInRadius)
    {
      return true;
    }
    else
    {
      positionToBe = m_position;
      return false;
    }
  }

  private boolean checkLocation(Location location)
  {
    return false;
  }

  private boolean checkPerson(int id)
  {
    // this will probably require the personManager in here...  or the runtimeManager - which would get really confusing
    // get position of the person first, then engage checkPosition-method
    return false;
  }

  private void sortTasks()
  {
    Task temp;
    for(int i = 0; i < tasks.size(); i++)
    {
      for(int t = 1; t < tasks.size() - 1; t++)
      {
        if(tasks.get(t - 1).getPriority() < tasks.get(t).getPriority())
        {
          temp = tasks.get(t - 1);
          tasks.set(t - 1, tasks.get(t));
          tasks.set(t, temp);
        }
      }
    }
  }

  public Position getPositionToBe()
  {
    return positionToBe;
  }

  public void setPositionToBe(Position positionToBe)
  {
    this.positionToBe = positionToBe;
  }
}
