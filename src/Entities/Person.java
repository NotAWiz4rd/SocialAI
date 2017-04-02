package Entities;

import java.util.ArrayList;

/**
 * Created by NotAWiz4rd on 27.03.2017.
 */
public class Person extends Entity
{
  private ArrayList<Property> hasProperties;
  private ArrayList<Opinion> likesProperties;
  private ArrayList<Opinion> dislikesProperties;
  private TaskManager taskManager;

  private int x;
  private int y;
  private int z;

  public Person(){

  }


}
