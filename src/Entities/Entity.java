package Entities;

/**
 * Created by notawiz4rd on 26/03/2017.
 */

// This is the base class for all entities
public class Entity
{
  private int id;
  private Position position;

  public Entity(Position m_position)
  {
    position = m_position;
  }

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public Position getPosition()
  {
    return position;
  }

  public void setPosition(Position position)
  {
    this.position = position;
  }
}
