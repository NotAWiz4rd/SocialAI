package Entities;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

import Enums.Sex;
import Enums.Stance;
import Managers.NeedManager;
import Managers.TaskManager;

/**
 * Created by NotAWiz4rd on 27.03.2017.
 */
public class Person
  extends Entity
{
  private String name;
  private int age;
  private Sex sex; // male or female
  private int height; // actual height of the person when standing up in cm
  private Attributes attributes;
  private String workplaceID; // this is the locationID for the persons workplace
  private ArrayList<Object> inventory = new ArrayList<>();
  private ArrayList<Object> knownObjects = new ArrayList<>();
  private ArrayList<Person> knownPeople = new ArrayList<>();

  private Stance stance;

  private ArrayList<Property> hasProperties;
  private ArrayList<Opinion> likesProperties;
  private ArrayList<Opinion> dislikesProperties;
  private ArrayList<Need> needs; // stores needs with their value
  private TaskManager taskManager;
  private NeedManager needManager;


  public Person(int m_id, String m_name, String m_sex, int m_age, int m_height, String m_workplaceID, int[] m_attributes,
                ArrayList<Property> m_hasProperties, ArrayList<Opinion> m_likesProperties, ArrayList<Opinion> m_dislikesProperties,
                ArrayList<Need> m_needs, Position position)
  {
    super(m_id, position);
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
    needs = m_needs;

    attributes = new Attributes(m_attributes[0], m_attributes[1], m_attributes[2], m_attributes[3], m_attributes[4]);

    stance = Stance.STANDING;

    taskManager = new TaskManager(getPosition(), knownObjects, knownPeople);
    needManager = new NeedManager(needs, taskManager);
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

  public void move(int mapWidth, int mapHeight)
  {
    // 5px = 1m?

    int x = getPosition().getX();
    int y = getPosition().getY();

    Random random = new Random();

    if(taskManager.getPositionToBe() != null)
    {
      if(taskManager.getPositionToBe() != getPosition())
      {
        int steps = (int) (random.nextGaussian() * 10 + 5); // calculate random number of steps
        if(steps < 0)
        {
          steps = 4;
        }
        int xToGo = taskManager.getPositionToBe().getX() - x;
        int yToGo = taskManager.getPositionToBe().getY() - y;


        switch(doStuff(xToGo, yToGo))
        {
          case 1:
            x += steps / 2;
            y += steps / 2;
            break;
          case 2:
            x -= steps / 2;
            y += steps / 2;
            break;
          case 3:
            x -= steps / 2;
            y -= steps / 2;
            break;
          case 4:
            if(yToGo > 0)
            {
              y += steps;
            }
            else
            {
              y -= steps;
            }
            break;
          case 5:
            if(xToGo > 0)
            {
              x += steps;
            }
            else
            {
              x -= steps;
            }
            break;
          default:
            break;
        }
      }
      else
      {
        taskManager.setPositionToBe(null);
      }
    }
    else
    {
      x += random.nextGaussian() * 5;
      y += random.nextGaussian() * 5;
    }

    if(x < 0)
    {
      x = 0;
    }
    else if(x > mapWidth)
    {
      x = mapWidth;
    }

    if(y < 0)
    {
      y = 0;
    }
    else if(y > mapHeight)
    {
      y = mapHeight;
    }

    setPosition(x, y, getPosition().getZ());
  }

  public void decreaseNeeds()
  {
    Random random = new Random();

    for(Need need : needs)
    {
      int decrease = (int) (random.nextGaussian() * 5);

      if(decrease < 0) // make decrease always positive
      {
        decrease = decrease * -1;
      }

      need.setValue(need.getValue() - decrease);
    }

    needManager.evaluateNeeds();
  }

  private int doStuff(int toGo1, int toGo2)
  {
    if(toGo1 > 0 && toGo2 > 0)
    {
      return 1; // go minus on both
    }
    else if(toGo1 < 0 && toGo2 > 0)
    {
      return 2; // go minus on first
    }
    else if(toGo1 < 0 && toGo2 < 0)
    {
      return 3; // go plus on both
    }
    else if(toGo1 == 0)
    {
      return 4;
    }
    else if(toGo2 == 0)
    {
      return 5;
    }

    return 0;
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

  public String getWorkplaceID()
  {
    return workplaceID;
  }

  public ArrayList<Object> getInventory()
  {
    return inventory;
  }

  public ArrayList<Property> getHasProperties()
  {
    return hasProperties;
  }

  public ArrayList<Opinion> getLikesProperties()
  {
    return likesProperties;
  }

  public ArrayList<Opinion> getDislikesProperties()
  {
    return dislikesProperties;
  }

  public ArrayList<Need> getNeeds()
  {
    return needs;
  }

  public TaskManager getTaskManager()
  {
    return taskManager;
  }

  public NeedManager getNeedManager()
  {
    return needManager;
  }

  public ArrayList<Object> getKnownObjects()
  {
    return knownObjects;
  }

  public void setKnownObjects(ArrayList<Object> knownObjects)
  {
    this.knownObjects = knownObjects;
  }

  public ArrayList<Person> getKnownPeople()
  {
    return knownPeople;
  }

  public void setKnownPeople(ArrayList<Person> knownPeople)
  {
    this.knownPeople = knownPeople;
  }
}

