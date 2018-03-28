package Managers;

import Entities.Need;
import Entities.Task;

import java.util.ArrayList;

/**
 * Manages whether and which tasks are to be issued based on the input of the person and its circumstances
 *
 * @author Max Werner
 */
public class NeedManager {
    private ArrayList<Need> needs;
    private TaskManager taskManager;
    private ActionManager actionManager;
    private Task[] tasks;

    public NeedManager(ArrayList<Need> m_needs, TaskManager m_taskManager, ActionManager m_actionManager) {
        needs = m_needs;
        taskManager = m_taskManager;
        actionManager = m_actionManager;
        tasks = new Task[needs.size()];
    }

    /**
     * Evaluates the given needs and issues tasks via the TaskManager accordingly.
     */
    public void evaluateNeeds() {
        // have a look at needs and evaluate which tasks should be issued at which priority
        for (int i = 0; i < needs.size(); i++) {
            if (needs.get(i).getValue() < 50) {
                if (!taskManager.getTasks().contains(tasks[i])) // only add new task if one isnt already in taskManager
                {
                    tasks[i] = new Task(false, 100 - needs.get(i).getValue(),
                            actionManager.searchForNeedSatisfaction(needs.get(i).getId()));
                    taskManager.addTask(tasks[i]);
                } else {
                    int f = taskManager.getTasks().indexOf(tasks[i]);
                    tasks[i].setPriority(100 - needs.get(i).getValue());
                    taskManager.getTasks().set(f, tasks[i]);
                }
            }
        }
    }

    public ArrayList<Need> getNeeds() {
        return needs;
    }

    public void setNeeds(ArrayList<Need> needs) {
        this.needs = needs;
    }
}
