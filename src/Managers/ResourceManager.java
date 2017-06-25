package Managers;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

import Entities.Need;
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
  private String propertiesFile = "Resources/definitions.properties";

  private PersonManager personManager;
  private ArrayList<Need> needArray = new ArrayList<>();

  public ResourceManager()
  {

  }

  public void loadResources(PersonManager m_personManager)
    throws IOException
  {
    personManager = m_personManager;
    loadLocations();
    loadProperties();
    loadObjects();
    loadActions();
    loadNeeds();
    loadPeople();
  }

  private void loadLocations()
  {

  }

  private void loadProperties()
  {

  }

  private void loadObjects()
  {

  }

  private void loadActions()
  {

  }

  private void loadNeeds()
    throws IOException
  {
    String needsEcrypted = readFile(needsFile);
    ArrayList<Need> needs = new ArrayList<>();

    String[] needDatas = needsEcrypted.replace("{", "").replace("\n", "").split("}");

    for(String needData : needDatas)
    {
      String[] valueData = needData.split("'");

      Need need = new Need(valueData[1], valueData[3], generateNeedValue());
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

      Person person = new Person(id, name, sex, age, height, workplace, attributes, hasProperties, likesProperties,
                                 dislikesProperties, needArray, new Position(0, 0, 0));
      personManager.addPerson(person);
      System.out.println("Person #" + i);
    }
    System.out.println("Added all people from file");
  }

  private String readFile(String filename)
    throws IOException
  {
    byte[] encoded = Files.readAllBytes(Paths.get(filename));
    return new String(encoded, Charset.defaultCharset());
  }

  private int generateNeedValue()
  {
    Random random = new Random();
    return random.nextInt(50) + 50; // value from 50 to 99
  }
}
