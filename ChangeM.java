package A2;

public class ChangeM {

    // ==========================
    // Private variables
    // ==========================
    private String name;
    private int amount; // total amount in cents, always rounded to nearest 5

    // ==========================
    // Constructors
    // ==========================
    public ChangeM() {
        this.name = "No name";
        this.amount = 0;
    }

    public ChangeM(String name, int amount) {
        this.name = name;
        this.amount = roundToNearestFive(amount);
    }

    // ==========================
    // Accessors & Mutators
    // ==========================
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = roundToNearestFive(amount);
    }

    // ==========================
    // Helper Methods
    // ==========================
    private int roundToNearestFive(int amt) {
        int remainder = amt % 5;
        if (remainder >= 3) {
            amt += (5 - remainder);
        } else {
            amt -= remainder;
        }
        return amt;
    }

    // Calculate coins: [5c, 10c, 25c, 50c, 100c]
    public int[] getChange() {
        int[] change = new int[5];
        int remaining = amount;

        // 100 cents ($1)
        change[4] = remaining / 100;
        remaining %= 100;

        // 50 cents
        change[3] = remaining / 50;
        remaining %= 50;

        // 25 cents
        change[2] = remaining / 25;
        remaining %= 25;

        // 10 cents
        change[1] = remaining / 10;
        remaining %= 10;

        // 5 cents
        change[0] = remaining / 5;
        remaining %= 5;

        return change;
    }

    // Display information
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Amount: " + amount + " cents");
        int[] change = getChange();
        String[] labels = {"5 cent", "10 cent", "25 cent", "50 cent", "100 cent"};
        for (int i = 0; i < change.length; i++) {
            if (change[i] > 0) {
                System.out.println(labels[i] + ": " + change[i]);
            }
        }
    }

    // Provide denominations to Client if needed
    public static int[] getDenominations() {
        return new int[]{5, 10, 25, 50, 100};
    }

    // ==========================
    // Test Main
    // ==========================
    public static void main(String[] args) {
        ChangeM c1 = new ChangeM("John", 125);
        c1.display();

        ChangeM c2 = new ChangeM("Jane", 94);
        c2.display();
    }
}
