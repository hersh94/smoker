import java.io.PrintStream;

class Agent
extends Thread {
    private Table table;

    public Agent(Table table2) {
        this.table = table2;
    }

    @Override
    public void run() {
        do {
            try {
                Thread.sleep(5000);
            }
            catch (Exception var1_1) {
                // empty catch block
            }
            this.table.getRandom();
            System.out.println("\nHey, Do You Want to Get High On Potenuse...\nWell The Problem is I Only Have " + this.table.getMonitorItems());
            this.pause();
        } while (true);
    }

    public synchronized void wake() {
        try {
            this.notify();
        }
        catch (Exception var1_1) {
            // empty catch block
        }
    }

    public synchronized void pause() {
        try {
            this.wait();
        }
        catch (Exception var1_1) {
            // empty catch block
        }
    }
}