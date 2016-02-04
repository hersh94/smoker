import java.util.ArrayList;
import java.util.Random;

class Control {

    public static void main(String[] args) {
        //creates a new table called table to put data into
        Table table = new Table();
         //creates a monitor to control all of the threads
        Agent monitor = new Agent(table);
//starts the agent Monitors
        monitor.start();

        // creates 3 smoker thread from the monitor, so the threads can wake up the monitor
        for (int i = 0; i < 3; i++)
        {
//inserts the variables into the smokers class
            Chef ChefThread = new Chef(table, i, "Chef " + Integer.toString(i+1), monitor);
//starts all of the smoker threads
            ChefThread.start();
        }
    }
}