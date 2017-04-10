package Managers;

import Entities.Entity;
import Entities.Position;

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

  public void addEntity(Entity entity)
  {
    entities.add(entity);
  }

  public Position[] getEntityLocations()
  {
    Position[] positions = new Position[entities.size()];

    for(int i = 0; i < entities.size(); i++)
    {
      positions[i] = entities.get(i).getPosition();
    }

    return positions;
  }


  // indexes all entities. this should only be called once and only when all entities are added to the manager
  public void indexEntities()
  {
    for(int i = 0; i < entities.size(); i++)
    {
      entities.get(i).setId(i);
    }
  }

  public Entity getEntity(int index)
  {
    return entities.get(index);
  }

  public int getEntityCount()
  {
    return entities.size();
  }
}
