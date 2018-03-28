package Managers;

import Entities.Object;

import java.util.ArrayList;

/**
 * Manages all objects in the simulation.
 *
 * @author Max Werner
 */
public class ObjectManager {
    private ArrayList<Object> objects = new ArrayList<>();

    public ObjectManager() {

    }

    public void addObject(Object object) {
        objects.add(object);
    }

    public int getObjectsCount() {
        return objects.size();
    }

    public Object getObject(int index) {
        return objects.get(index);
    }

    public ArrayList<Object> getObjects() {
        return objects;
    }
}
