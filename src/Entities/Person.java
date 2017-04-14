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
  private String name;
  private int age;
  private String sex; // male or female

  private ArrayList<Property> hasProperties;
  private ArrayList<Opinion> likesProperties;
  private ArrayList<Opinion> dislikesProperties;
  private Map<String, Integer> needs; // stores need-id with their value
  private TaskManager taskManager;


  public Person(String m_name, int m_age, String m_sex, Position position)
  {
    super(position);
    name = m_name;
    age = m_age;
    sex = m_sex;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
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

  public void setSex(String sex)
  {
    this.sex = sex;
  }
}
