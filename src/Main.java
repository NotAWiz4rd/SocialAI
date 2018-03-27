import GUI.GuiManager;

import java.io.IOException;

/**
 * @author Max Werner
 */
public class Main {
    private static String VERSION = "0.0.2 indev";

    public static void main(String[] args) {
        try {
            GuiManager guiManager = new GuiManager(VERSION);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
