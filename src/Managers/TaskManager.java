package Managers;

import Entities.*;
import Entities.Object;

import java.util.ArrayList;

/**
 * @author Max Werner
 */
public class TaskManager {
    private ArrayList<Task> tasks = new ArrayList<>();
    private ArrayList<String> requirements;
    private Task currentTask;
    private ArrayList<Action> actions;
    private Position positionToBe;
    private Position position;

    private ArrayList<Object> knownObjects;
    private ArrayList<Person> knownPeople;

    public TaskManager(Position m_position, ArrayList<Object> m_knownObjects, ArrayList<Person> m_knownPeople) {
        position = m_position;
        knownObjects = m_knownObjects;
        knownPeople = m_knownPeople;
    }

    /**
     * Checks tasks for priorities, orders them correctly and starts first task if needed.
     */
    private void checkTasks() {
        sortTasks();
        if (currentTask == null && tasks.size() > 0) {
            currentTask = tasks.remove(0);
        } else if (currentTask != null) {
            if (currentTask.isFinished()) {
                currentTask = tasks.remove(0);
            }

            actions = currentTask.getAction();
            requirements = actions.get(0).getRequirements();

            checkRequirements();
        }
    }

    /**
     * Adds a task to the manager and calls checkTasks.
     *
     * @param task Task to add.
     */
    public void addTask(Task task) {
        tasks.add(task);
        checkTasks();
    }

    /**
     * Checks requirements of actions every tick.
     */
    private void checkRequirements() {
        if (actions.get(0).getRequirements() == null) {
            requirementsMet();
        }

        for (int i = 0; i < actions.get(0).getRequirements().size(); i++) {
            String requ = actions.get(0).getRequirements().get(i);
            String[] requSplit = requ.split(" ");

            if (requSplit[1].contains("#")) {
                for (Object knownObject : knownObjects) {
                    if (knownObject.getGroupID().equals(requSplit[1].replace("#", ""))) {
                        if (checkPosition(knownObject.getPosition(), Integer.parseInt(requSplit[3]))) {
                            requirementsMet();
                        }
                    }
                }
            } else if (requSplit[1].contains("$")) {
                // TODO this one might be tricky, but wait for location first
            }
        }
    }

    /**
     * Checks if the person is at the given position, sets it as positionToBe if this is not the case.
     *
     * @param m_position Position to check against.
     * @param radius     Radius in which the person has to be.
     * @return Whether the person is within the radius of the given position.
     */
    private boolean checkPosition(Position m_position, int radius) // checks if person is at required positon, sets position as positionToBe if not
    {
        boolean xInRadius = false;
        boolean yInRadius = false;

        radius = radius * 5; // going from meters to pixel

        for (int i = -radius; i < radius; i++) {
            if (position.getX() + i == m_position.getX()) {
                xInRadius = true;
            }

            if (position.getY() + i == m_position.getY()) {
                yInRadius = true;
            }
        }

        if (xInRadius && yInRadius) {
            return true;
        } else {
            positionToBe = m_position;
            return false;
        }
    }

    /**
     * Checks whether a person is within a given location.
     *
     * @param location Location to check against.
     * @return Whether the person is at(within) the given location.
     */
    private boolean checkLocation(Location location) {
        // TODO check here if the position of the person is within the location-defining points
        return false;
    }

    /**
     * Checks whether the person is next to the given person (via id).
     *
     * @param id ID of the person to check against.
     * @return Whether the person is next to a given person.
     */
    private boolean checkPerson(int id) {
        // get position of the person first, then engage checkPosition-method
        // TODO implement me
        return false;
    }

    /**
     * Sorts tasks by priority (higher priority first).
     */
    private void sortTasks() {
        Task temp;
        for (int i = 0; i < tasks.size(); i++) {
            for (int t = 1; t < tasks.size() - 1; t++) {
                if (tasks.get(t - 1).getPriority() < tasks.get(t).getPriority()) {
                    temp = tasks.get(t - 1);
                    tasks.set(t - 1, tasks.get(t));
                    tasks.set(t, temp);
                }
            }
        }
    }

    /**
     * Calls the requirement checking for the action that is to be done next.
     */
    private void requirementsMet() {
        actions.get(0).doAction();
        actions.remove(0);
        if (actions.size() < 1) // if there are no more actions in the current task
        {
            currentTask = tasks.remove(0); // start next task
            checkRequirements();
        }
    }

    public Task getCurrentTask() {
        return currentTask;
    }

    public ArrayList<Action> getActions() {
        return actions;
    }

    public Position getPositionToBe() {
        return positionToBe;
    }

    public void setPositionToBe(Position positionToBe) {
        this.positionToBe = positionToBe;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }
}
