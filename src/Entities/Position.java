package Entities;

/**
 * Represents a three-dimensional position.
 *
 * @author Max Werner
 */
public class Position {
    private int x;
    private int y;
    private int z;

    public Position(int m_x, int m_y, int m_z) {
        x = m_x;
        y = m_y;
        z = m_z;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }
}
