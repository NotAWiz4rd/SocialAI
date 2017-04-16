package Managers;

import Entities.Location;
import Entities.Position;
import Entities.Requirement;
import Entities.Task;

import java.util.ArrayList;

/**
 * Created by NotAWiz4rd on 02.04.2017.
 */
public class TaskManager
{
  private ArrayList<Task> tasks;
  private ArrayList<Requirement> requirements;

  public TaskManager()
  {

  }

  private void checkTasks()
  {
    // check tasks for priorities and order them correctly, eventually start first task
  }


  // Requirement checking happens here
  private boolean checkPosition(Position position, int radius)
  {
    return false;
  }

  private boolean checkLocation(Location location)
  {
    return false;
  }

  private boolean checkPerson(int id)
  {
    // this will probably require the personManager in here...
    // get position of the person first, then engage checkPosition-method
    return false;
  }
}
