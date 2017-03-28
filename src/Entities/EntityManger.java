package Entities;

import java.util.ArrayList;

/**
 * Created by notawiz4rd on 26/03/2017.
 */

// this class manages all the entities in one list. All Entities have to be added here to be accessed; they get an id here
public class EntityManger
{
  private ArrayList<Entity> entities = new ArrayList<>();

  public EntityManger()
  {
  }

  public Location[] getEntityLocations()
  {
    Location[] locations = new Location[entities.size()];

    for(int i = 0; i < entities.size(); i++)
    {
      locations[i] = entities.get(i).getLocation();
    }

    return locations;
  }

  public Entity getEntity(int index){
    return entities.get(index);
  }

  public int getEntityCount(){
    return entities.size();
  }
}
