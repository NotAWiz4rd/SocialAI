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
  private String groupID; // a group ID for beds, toilets, etc.
  private ArrayList<Property> hasProperties;
  private boolean isCurrentlyUsed;

  public Object(String m_name, String m_objectID, String m_groupID, Position position, boolean m_isCurrentlyUsed)
  {
    super(position);
    name = m_name;
    objectID = m_objectID;
    groupID = m_groupID;
    isCurrentlyUsed = m_isCurrentlyUsed;
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

  public boolean isCurrentlyUsed()
  {
    return isCurrentlyUsed;
  }

  public void setCurrentlyUsed(boolean currentlyUsed)
  {
    isCurrentlyUsed = currentlyUsed;
  }

  public String getGroupID()
  {
    return groupID;
  }

  public void setGroupID(String groupID)
  {
    this.groupID = groupID;
  }
}
