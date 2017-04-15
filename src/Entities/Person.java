package Entities;

import Managers.TaskManager;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by NotAWiz4rd on 27.03.2017.
 */
public class Person
  extends Entity
{
  private static String name;
  private int age;
  private static String sex; // male or female
  private static int height; // actual height of the person when standing up in cm
  private Attributes attributes;

  private Stance stance;

  private ArrayList<Property> hasProperties;
  private ArrayList<Opinion> likesProperties;
  private ArrayList<Opinion> dislikesProperties;
  private Map<String, Integer> needs; // stores need-id with their value
  private TaskManager taskManager;


  public Person(String m_name, int m_age, String m_sex, Position position, int m_height)
  {
    super(position);
    name = m_name;
    age = m_age;
    sex = m_sex;
    height = m_height;
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

  public String getSex()
  {
    return sex;
  }

  public Attributes getAttributes()
  {
    return attributes;
  }
}

enum Stance
{
  LYING, STANDING, SITTING, DUCKING
}
