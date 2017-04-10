package Entities;

import java.util.ArrayList;

/**
 * Created by NotAWiz4rd on 27.03.2017.
 */
public class Person
  extends Entity
{
  private String name;
  private int age;

  private ArrayList<Property> hasProperties;
  private ArrayList<Opinion> likesProperties;
  private ArrayList<Opinion> dislikesProperties;
  private TaskManager taskManager;


  public Person(String m_name, Position position)
  {
    super(position);
    name = m_name;

  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

}
