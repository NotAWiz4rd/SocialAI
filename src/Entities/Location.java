package Entities;

/**
 * @author Max Werner
 */
public class Location {
    private String id;
    private String groupID;
    private int[] x;
    private int[] y;
    private int z;

    public Location(String m_id, int[] m_x, int[] m_y, int m_z) {
        id = m_id;
        x = m_x;
        y = m_y;
        z = m_z;
    }

    public Location(String m_id, String m_groupID, int[] m_x, int[] m_y, int m_z) {
        id = m_id;
        groupID = m_groupID;
        x = m_x;
        y = m_y;
        z = m_z;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupID() {
        return groupID;
    }

    public int[] getX() {
        return x;
    }

    public int[] getY() {
        return y;
    }

    public int getZ() {
        return z;
    }
}
