package Managers;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

import Entities.Action;
import Entities.Need;
import Entities.NeedSatisfaction;
import Entities.Object;
import Entities.Opinion;
import Entities.Person;
import Entities.Position;
import Entities.Property;

/**
 * Created by NotAWiz4rd on 10.04.2017.
 */
public class ResourceManager
{
  private String actionsFile = "Resources/definitions.actions";
  private String locationsFile = "Resources/definitions.locations";
  private String needsFile = "Resources/definitions.needs";
  private String objectsFile = "Resources/definitions.objects";
  private String peopleFile = "Resources/definitions.people";

  private PersonManager personManager;
  private ActionManager actionManager;
  private ObjectManager objectManager;
  private ArrayList<Need> needArray = new ArrayList<>();
  private Random random = new Random();

  public ResourceManager()
  {

  }

  public void loadResources(PersonManager m_personManager, ActionManager m_actionManager, ObjectManager m_objectManager)
    throws IOException
  {
    personManager = m_personManager;
    actionManager = m_actionManager;
    objectManager = m_objectManager;
    loadLocations();
    loadObjects();
    loadActions();
    loadNeeds();
    loadPeople();
  }

  private void loadLocations()
  {

  }

  private void loadObjects()
    throws IOException
  {
    String objectsEncrypted = readFile(objectsFile);

    String[] objectDatas = objectsEncrypted.replace("{", "").split("objects");

    String[] objectData = objectDatas[1].split("}"); // ignore the group-id declarations, those are just for the file editors

    ArrayList<Object> objects = new ArrayList<>();

    for(String anObjectData : objectData)
    {
      String[] objectPoints = anObjectData.split("'");
      objectManager.addObject(new Object(objectPoints[1], objectPoints[3], new Position(random.nextInt(1000), random.nextInt(1000), 0)));
      // place objects also random for now
    }
  }

  private void loadActions()
    throws IOException
  {
    String actionsEncrypted = readFile(actionsFile);

    String[] actionDatas = actionsEncrypted.replace("{", "").replace("\n", "").
      replace("}", "").split("&");

    for(int i = 0; i < actionDatas.length - 1; i++)
    {
      String[] actionData = actionDatas[i].split("'");

      String id = actionData[1];
      Boolean multitaskable = Boolean.parseBoolean(actionData[3]);

      ArrayList<NeedSatisfaction> needSatisfactions = new ArrayList<>();

      String requirement;

      if(!actionData[5].equals("null"))
      {
        needSatisfactions.add(new NeedSatisfaction(actionData[5], Integer.parseInt(actionData[7])));

        if(actionData[8].contains(";"))
        {
          needSatisfactions.add(new NeedSatisfaction(actionData[9], Integer.parseInt(actionData[11])));
          requirement = actionData[13];
        }
        else
        {
          requirement = actionData[9];
        }
      }
      else
      {
        needSatisfactions = null;
        requirement = actionData[9];
      }

      // decrypt only one requirement for now but keep the general ArrayList structure for future expansion
      ArrayList<String> requirements = new ArrayList<>();
      requirements.add(requirement);


      if(needSatisfactions != null)
      {
        actionManager.addAction(new Action(id, multitaskable, requirements, needSatisfactions));
      }
      else
      {
        actionManager.addAction(new Action(id, multitaskable, requirements));
      }
    }
  }

  private void loadNeeds()
    throws IOException
  {
    String needsEncrypted = readFile(needsFile);

    String[] needDatas = needsEncrypted.replace("{", "").replace("\n", "").split("}");

    for(String needData : needDatas)
    {
      String[] valueData = needData.split("'");

      Need need = new Need(valueData[1], valueData[3], 0);
      needArray.add(need);
    }
  }

  private void loadPeople()
    throws IOException
  {
    String peopleEncrypted = readFile(peopleFile);

    String[] peopleData = peopleEncrypted.split("&");

    for(int i = 0; i < peopleData.length - 1; i++)
    {
      String personData = peopleData[i];
      personData = personData.replace("{", "").replace("}", "").replace("\n", "");
      String[] halfPerson = personData.split("opinions");

      String[] data = halfPerson[0].split("'");
      int id = Integer.parseInt(data[1]);
      String name = data[3];
      String sex = data[5];
      int age = Integer.parseInt(data[7]);
      int height = Integer.parseInt(data[9]);
      String workplace = data[11];
      int strength = Integer.parseInt(data[13]);
      int intelligence = Integer.parseInt(data[15]);
      int constitution = Integer.parseInt(data[17]);
      int dexterity = Integer.parseInt(data[19]);
      int charisma = Integer.parseInt(data[21]);
      int[] attributes = {strength, intelligence, constitution, dexterity, charisma};

      int d = 23;
      ArrayList<Property> hasProperties = new ArrayList<>();

      while(d < data.length)
      {
        hasProperties.add(new Property(data[d]));
        d += 2;
      }

      ArrayList<Opinion> likesProperties = new ArrayList<>();
      ArrayList<Opinion> dislikesProperties = new ArrayList<>();

      String[] opinionData = halfPerson[1].split("'");
      int t = 1;
      while(t <= opinionData.length)
      {
        Property property = new Property(opinionData[t]);
        t += 2;
        int impact = Integer.parseInt(opinionData[t]);
        t += 2;
        int personalLevel = Integer.parseInt(opinionData[t]);

        if(impact >= 0) // assign to like or dislike list based on impact
        {
          likesProperties.add(new Opinion(property, impact, personalLevel));
        }
        else
        {
          dislikesProperties.add(new Opinion(property, impact, personalLevel));
        }

        t += 2;
      }

      for(Need aNeedArray : needArray)
      {
        aNeedArray.setValue(generateNeedValue());
      }

      // place entities at random location within 999/999

      Person person = new Person(id, name, sex, age, height, workplace, attributes, hasProperties, likesProperties,
                                 dislikesProperties, needArray, new Position(random.nextInt(1000), random.nextInt(1000), 0));
      personManager.addPerson(person);
    }
  }

  private String readFile(String filename)
    throws IOException
  {
    byte[] encoded = Files.readAllBytes(Paths.get(filename));
    return new String(encoded, Charset.defaultCharset());
  }

  private int generateNeedValue()
  {
    return random.nextInt(50) + 50; // value from 50 to 99
  }
}
