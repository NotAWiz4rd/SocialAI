package Managers;

import Entities.Action;
import Entities.NeedSatisfaction;

import java.util.ArrayList;

/**
 * @author Max Werner
 */
public class ActionManager {
    private ArrayList<Action> actions = new ArrayList<>();

    public ActionManager() {

    }

    public void addAction(Action action) {
        actions.add(action);
    }

    public ArrayList<Action> getActions() {
        return actions;
    }

    public Action searchForNeedSatisfaction(String needId) {
        int f = 0;
        int satisfaction = 0;

        for (int i = 0; i < actions.size(); i++) {
            if (actions.get(i).getNeedSatisfaction() != null) {
                for (NeedSatisfaction needSatisfaction : actions.get(i).getNeedSatisfaction()) {
                    if (needSatisfaction.getNeedId().equals(needId)) {
                        if (needSatisfaction.getValue() > satisfaction) {
                            satisfaction = needSatisfaction.getValue();
                            f = i;
                        }
                    }
                }
            }
        }

        return actions.get(f);
    }
}
