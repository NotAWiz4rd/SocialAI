package Entities;

import java.util.ArrayList;

/**
 * Created by NotAWiz4rd on 27.03.2017.
 */
public class Object
  extends Entity
{
  private String name;
  private String objectID; // identifies the object from the object database
  private ArrayList<Property> hasProperties;

  public Object(Position position)
  {
    super(position);
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getObjectID()
  {
    return objectID;
  }

  public void setObjectID(String objectID)
  {
    this.objectID = objectID;
  }

  public ArrayList<Property> getHasProperties()
  {
    return hasProperties;
  }

  public void setHasProperties(ArrayList<Property> hasProperties)
  {
    this.hasProperties = hasProperties;
  }
}
