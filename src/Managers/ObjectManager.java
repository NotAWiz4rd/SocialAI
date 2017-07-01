package Managers;

import java.util.ArrayList;

import Entities.Object;

/**
 * Created by NotAWiz4rd on 15.04.2017.
 */
public class ObjectManager
{
  private ArrayList<Object> objects = new ArrayList<>();

  public ObjectManager()
  {

  }

  public void addObject(Object object)
  {
    objects.add(object);
  }

  public int getObjectsCount()
  {
    return objects.size();
  }

  public Object getObject(int index)
  {
    return objects.get(index);
  }

  public ArrayList<Object> getObjects()
  {
    return objects;
  }
}
