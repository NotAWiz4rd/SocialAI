package Entities;

/**
 * Represents an opinion, which people have over a certain property, with the personalLevel of the opinion included.
 *
 * @author Max Werner
 */
public class Opinion {
    private Property property;
    private int impact;  // how much the opinion effects the general opinion of someone
    private int personalLevel;  // how likely a person will share this opinion, between 0 and 100, where 100 is really
    // personal (people will noone about this opinion.

    public Opinion(Property m_property, int m_impact, int m_personalLevel) {
        property = m_property;
        impact = m_impact;
        personalLevel = m_personalLevel;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public int getImpact() {
        return impact;
    }

    public void setImpact(int impact) {
        this.impact = impact;
    }

    public int getPersonalLevel() {
        return personalLevel;
    }

    public void setPersonalLevel(int personalLevel) {
        this.personalLevel = personalLevel;
    }
}
