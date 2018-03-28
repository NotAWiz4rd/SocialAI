package Entities;

/**
 * Represents the satisfaction of a need (1-100). The need is identified via its id.
 *
 * @author Max Werner
 */
public class NeedSatisfaction {
    private String needId;
    private int value;

    public NeedSatisfaction(String m_needId, int m_value) {
        needId = m_needId;
        value = m_value;
    }

    public String getNeedId() {
        return needId;
    }

    public void setNeedId(String needId) {
        this.needId = needId;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
