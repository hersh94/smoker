import java.io.PrintStream;

class Chef
extends Thread {
    private Table table = new Table();
    private String ITEMS;
    private int ITEMNUMBER; //Number of items needed for sandwich
    private Agent Monitor; //Creates an Agent 

    public Chef(Table table2, int n, String string, Agent agent2) {
        this.ITEMNUMBER = n;
        this.table = table2;
        this.setName(string);
        this.Monitor = agent2; //pass in an agent
    }

    @Override
    public void run() {
        do {
            this.ITEMS = this.table.getSmokerItems(this.ITEMNUMBER); //
            if (this.table.hasIngredient(this.ITEMS) || this.table.isEmpty()) continue;
            System.out.println("-----------------------------------");
            System.out.println("Hey I am " + this.getName() + " and i have the " + this.ITEMS + " your missing.\n");
            System.out.println("-----------------------------------");
            try {
                this.HighOnPotenuse();
                System.out.println(this.getName() + " is going to let someone else Get High On Potenuse.");
                this.Monitor.wake();
            }
            catch (Exception var1_1) {
            }
        } while (true);
    }

    public synchronized void HighOnPotenuse() throws Exception {
        System.out.println(this.getName() + " rolls up a doobie.");
        Thread.sleep(100);
        System.out.println(this.getName() + " starts blowing smoke clouds");
        Thread.sleep(100);
        System.out.println(this.getName() + " is officially High On Potenuse");
    }
}