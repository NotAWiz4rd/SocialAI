package Entities;

/**
 * @author Max Werner
 */
public class Attributes {
    private int strength;  // strength of the body
    private int intelligence;  // general intelligence
    private int constitution;  // general condition of the body
    private int dexterity;  // general speed and flexibility if the body
    private int charisma;  // general social awareness

    public Attributes(int m_strength, int m_intelligence, int m_constitution, int m_dexterity, int m_charisma) {
        strength = m_strength;
        intelligence = m_intelligence;
        constitution = m_constitution;
        dexterity = m_dexterity;
        charisma = m_charisma;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }
}
