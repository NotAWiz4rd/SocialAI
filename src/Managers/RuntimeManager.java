package Managers;

import Interfaces.ChangeListener;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Manages the overall simulation (in ticks) and makes sure everything gets updated properly.
 *
 * @author Max Werner
 */
public class RuntimeManager {

    private long tickLength = 250; // Time of one tick in milliseconds

    // Dimensions of the map
    private final int mapHeight = 1000;
    private final int mapWidth = 1000;

    // general managers
    public ObjectManager objectManager = new ObjectManager();
    public ActionManager actionManager = new ActionManager();
    public PersonManager personManager = new PersonManager(mapWidth, mapHeight, actionManager);

    // other stuff
    private ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
    private ChangeListener listener;

    private boolean isRunning = true;

    public RuntimeManager() {
    }

    /**
     * Executes the simulateTick-function every x (x = tickLength variable) milliseconds.
     */
    private void run() {
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(this::simulateTick, 0, tickLength, TimeUnit.MILLISECONDS);
    }

    /**
     * Starts the simulation.
     */
    public void start() {
        isRunning = true;
        run();
    }

    /**
     * Stops the simulation.
     */
    public void stop() {
        isRunning = false;
        scheduledExecutorService.shutdown();
    }

    /**
     * Steps forward one tick by having all people simulated and calling the GUI to reload.
     */
    private void simulateTick() {
        personManager.simulatePeople();

        if (listener != null) {
            listener.onChangeHappened(); // notify GuiManager to reload; this is just for testing in our GUI
        }
    }

    public void setTickLength(int newSpeed) {
        tickLength = newSpeed;
    }

    public void setChangeListener(ChangeListener m_listener) {
        listener = m_listener;
    }

    public int getMapHeight() {
        return mapHeight;
    }

    public int getMapWidth() {
        return mapWidth;
    }
}
