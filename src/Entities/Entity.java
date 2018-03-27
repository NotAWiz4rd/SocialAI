package Entities;

/**
 * @author Max Werner
 */

// This is the base class for all entities
public class Entity {
    private int id;
    private Position position;

    public Entity(Position m_position) {
        position = m_position;
    }

    public Entity(int m_id, Position m_position) {
        id = m_id;
        position = m_position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setPosition(int x, int y, int z) {
        this.position = new Position(x, y, z);
    }
}
