import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Random;
import java.util.Collections;

class Table {
    private ArrayList<String> allItems = new ArrayList<String>();
    private ArrayList MonitorItems = new ArrayList();

    public Table() {
        this.allItems.add("Weed"); //Add the three items to 'allItems'
        this.allItems.add("Blunt");
        this.allItems.add("Lighter");
    }

    public void getRandom() {
        Random random = new Random();
        this.MonitorItems.clear(); //refresh monitorItems
        ArrayList<String> arrayList = (ArrayList)this.allItems.clone(); //makes a copy of the list of items...
        List<String> randomPick = pickNRandom(arrayList, 2);
        this.MonitorItems.addAll(randomPick);
        
    }

    public boolean isEmpty() {
        return this.MonitorItems.size() == 0;
    }

    public synchronized String getMonitorItems() {
        this.notifyAll();
        return this.MonitorItems.toString();
    }
    public static List<String> pickNRandom(List<String> lst, int n) {
        List<String> copy = new LinkedList(lst);
        Collections.shuffle(copy);
        return copy.subList(0, n);
    }

    public synchronized String getSmokerItems(int n) {
        try {
            this.wait();
        }
        catch (Exception var2_2) {
            // empty catch block
        }
        return (String)this.allItems.get(n);
    }

    public boolean hasIngredient(String string) {
        return this.MonitorItems.contains(string);
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