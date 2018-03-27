package Entities;

/**
 * @author Max Werner
 */
public class Object
        extends Entity {
    private String objectID; // identifies the object from the object database
    private String groupID; // a group ID for beds, toilets, etc.
    private boolean isCurrentlyUsed;
    // TODO do some objects need an owner?

    public Object(String m_objectID, String m_groupID, Position position) {
        super(position);
        objectID = m_objectID;
        groupID = m_groupID;
        isCurrentlyUsed = false;
    }

    public String getObjectID() {
        return objectID;
    }

    public boolean isCurrentlyUsed() {
        return isCurrentlyUsed;
    }

    public void setCurrentlyUsed(boolean currentlyUsed) {
        isCurrentlyUsed = currentlyUsed;
    }

    public String getGroupID() {
        return groupID;
    }
}
