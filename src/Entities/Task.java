package Entities;

import java.util.ArrayList;

/**
 * Represents an executable task, which is constructed of one or more actions.
 *
 * @author Max Werner
 */
public class Task {
    // A Task in a persons taskManager. Might have several actions as part of the task
    private boolean isCancelable;
    private boolean isFinished;
    private int priority;
    private ArrayList<Action> actions = new ArrayList<>();

    public Task(boolean m_isCancelable, int m_priority, Action action) {
        isCancelable = m_isCancelable;
        priority = m_priority;
        actions.add(action);
    }

    public Task(boolean m_isCancelable, int m_priority, ArrayList<Action> m_actions) {
        isCancelable = m_isCancelable;
        priority = m_priority;
        actions = m_actions;
    }

    public boolean isCancelable() {
        return isCancelable;
    }

    public void setCancelable(boolean cancelable) {
        isCancelable = cancelable;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public ArrayList<Action> getAction() {
        return actions;
    }

    public void setAction(ArrayList<Action> actions) {
        this.actions = actions;
    }

    public void addAction(Action action) {
        actions.add(action);
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }
}
