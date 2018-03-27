package Entities;

/**
 * @author Max Werner
 */
public class Property {
    private String id;

    public Property(String m_id) {
        id = m_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
