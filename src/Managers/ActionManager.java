package Managers;

import java.util.ArrayList;

import Entities.Action;

/**
 * Created by notawiz4rd on 27.06.17.
 */
public class ActionManager
{
  private ArrayList<Action> actions = new ArrayList<>();

  public ActionManager()
  {

  }

  public void addAction(Action action)
  {
    actions.add(action);
  }

  public ArrayList<Action> getActions()
  {
    return actions;
  }
}
