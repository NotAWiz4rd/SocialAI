package Entities;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

import Enums.Sex;
import Enums.Stance;
import Managers.TaskManager;

/**
 * Created by NotAWiz4rd on 27.03.2017.
 */
public class Person
  extends Entity
{
  private static String name;
  private int age;
  private static Sex sex; // male or female
  private static int height; // actual height of the person when standing up in cm
  private Attributes attributes;
  private String workplaceID; // this is the locationID for the persons workplace
  private ArrayList<Object> inventory = new ArrayList<>();

  private Stance stance;

  private ArrayList<Property> hasProperties;
  private ArrayList<Opinion> likesProperties;
  private ArrayList<Opinion> dislikesProperties;
  private Map<String, Integer> needs; // stores need-id with their value
  private TaskManager taskManager;


  public Person(int m_id, String m_name, String m_sex, int m_age, int m_height, String m_workplaceID, int[] m_attributes,
                ArrayList<Property> m_hasProperties, ArrayList<Opinion> m_likesProperties, ArrayList<Opinion> m_dislikesProperties, Position position)
  {
    super(position);
    name = m_name;
    age = m_age;
    if(Objects.equals(m_sex, "male"))
    {
      sex = Sex.MALE;
    }
    else
    {
      sex = Sex.FEMALE;
    }
    height = m_height;
    workplaceID = m_workplaceID;
    hasProperties = m_hasProperties;
    likesProperties = m_likesProperties;
    dislikesProperties = m_dislikesProperties;

    attributes = new Attributes(m_attributes[0], m_attributes[1], m_attributes[2], m_attributes[3], m_attributes[4]);

    stance = Stance.STANDING;
  }

  public int getCurrentSize()
  {
    switch(stance)
    {
      case STANDING:
        return height;
      case DUCKING:
        return height / 2;
      case SITTING:
        return (int) (height * 0.75);
      case LYING:
        return 30;
    }
    return -1;
  }

  public void move()
  {
    // TODO implement a random move function
  }

  public Stance getStance()
  {
    return stance;
  }

  public void setStance(Stance stance)
  {
    this.stance = stance;
  }

  public int getHeight()
  {
    return height;
  }

  public String getName()
  {
    return name;
  }

  public int getAge()
  {
    return age;
  }

  public void setAge(int age)
  {
    this.age = age;
  }

  public Sex getSex()
  {
    return sex;
  }

  public Attributes getAttributes()
  {
    return attributes;
  }
}

