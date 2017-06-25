import java.io.IOException;

import GUI.GuiManager;

/**
 * Created by notawiz4rd on 26/03/2017.
 */
public class Main
{
  private static String VERSION = "0.0.1";

  public static void main(String[] args)
  {
    try
    {
      GuiManager guiManager = new GuiManager(VERSION);
    }
    catch(IOException e)
    {
      e.printStackTrace();
    }
  }
}
