package Entities;

/**
 * @author Max Werner
 */
public class Event {
    // subject did x with object
    private Entity subject;
    private Entity object;
    private Location location;
    private Action[] actions;
    private int timeStamp;

    public Event() {

    }

    public Entity getSubject() {
        return subject;
    }

    public void setSubject(Entity subject) {
        this.subject = subject;
    }

    public Entity getObject() {
        return object;
    }

    public void setObject(Entity object) {
        this.object = object;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Action[] getActons() {
        return actions;
    }

    public void setActons(Action[] actons) {
        this.actions = actons;
    }

    public int getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(int timeStamp) {
        this.timeStamp = timeStamp;
    }
}
