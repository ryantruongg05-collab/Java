package A2;

public class Client {

    private static ChangeM[] changeArray;
    private static int currentSize = 0;

    public static void run() {
        changeArray = new ChangeM[100];
        initData();
        menuLoop();
    }

    private static void initData() {
        IOHelper.println("Do you want to:");
        IOHelper.println("1. Enter data manually");
        IOHelper.println("2. Use hardcoded data");
        int choice = IOHelper.getInt("Enter your choice");
        if (choice == 1) {
            initArrayByUser();
        } else {
            initArrayByHardCode();
        }
        displayAll();
    }

    private static void displayAll() {
        for (ChangeM change : changeArray) {
            if (change != null) {
                change.display();
                IOHelper.println("---------------------");
            }
        }
    }

    private static void initArrayByHardCode() {
        changeArray[0] = new ChangeM("A", 15);
        changeArray[1] = new ChangeM("B", 105);
        changeArray[2] = new ChangeM("C", 205);
        changeArray[3] = new ChangeM("D", 345);
        changeArray[4] = new ChangeM("E", 445);
        changeArray[5] = new ChangeM("F", 555);
        changeArray[6] = new ChangeM("G", 665);
        changeArray[7] = new ChangeM("H", 1105);
        changeArray[8] = new ChangeM("I", 1905);
        changeArray[9] = new ChangeM("J", 2015);
        currentSize = 10;
    }

    private static void initArrayByUser() {
        IOHelper.println("Enter at least 10 records.");
        boolean moreData = true;

        while (moreData && currentSize < changeArray.length) {
            String name = IOHelper.getString("Enter name");

            while (isDuplicate(name)) {
                name = IOHelper.getString("This name already exists. Enter a different name");
            }

            int amount = IOHelper.getInt("Enter coin amount (in cents)");
            changeArray[currentSize++] = new ChangeM(name, amount);

            char ans = IOHelper.getlowerCaseChar("Do you want to enter more person? (Y/N)");
            if (ans == 'n') {
                moreData = false;
            }
        }
    }

    private static boolean isDuplicate(String name) {
        for (int i = 0; i < currentSize; i++) {
            if (changeArray[i] != null && changeArray[i].getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    // ==========================
    // Menu Loop
    // ==========================
    private static void menuLoop() {
        int choice;
        do {
            IOHelper.println("\n===== MENU =====");
            IOHelper.println("1. Display change for a person");
            IOHelper.println("2. Display person with smallest amount");
            IOHelper.println("3. Display person with largest amount");
            IOHelper.println("4. Display total number of coins for each denomination");
            IOHelper.println("5. Display total amount of all persons");
            IOHelper.println("6. Exit");
            choice = IOHelper.getInt("Enter your choice");

            switch (choice) {
                case 1:
                    displayPersonChange();
                    break;
                case 2:
                    displaySmallestAmount();
                    break;
                case 3:
                    displayLargestAmount();
                    break;
                case 4:
                    displayTotalCoins();
                    break;
                case 5:
                    displayTotalAmount();
                    break;
                case 6:
                    IOHelper.println("Thank you for using the system!");
                    break;
                default:
                    IOHelper.println("Invalid choice. Try again.");
            }
        } while (choice != 6);
    }

    // ==========================
    // Menu Option Methods
    // ==========================
    private static void displayPersonChange() {
        String name = IOHelper.getString("Enter name to search");
        ChangeM found = null;
        for (int i = 0; i < currentSize; i++) {
            if (changeArray[i] != null && changeArray[i].getName().equalsIgnoreCase(name)) {
                found = changeArray[i];
                break;
            }
        }

        if (found == null) {
            IOHelper.println("Name: " + name + " not found.");
        } else {
            found.display();
        }
    }

    private static void displaySmallestAmount() {
        if (currentSize == 0) return;
        ChangeM min = changeArray[0];
        for (int i = 1; i < currentSize; i++) {
            if (changeArray[i] != null && changeArray[i].getAmount() < min.getAmount()) {
                min = changeArray[i];
            }
        }
        IOHelper.println("Person with smallest amount:");
        min.display();
    }

    private static void displayLargestAmount() {
        if (currentSize == 0) return;
        ChangeM max = changeArray[0];
        for (int i = 1; i < currentSize; i++) {
            if (changeArray[i] != null && changeArray[i].getAmount() > max.getAmount()) {
                max = changeArray[i];
            }
        }
        IOHelper.println("Person with largest amount:");
        max.display();
    }

    private static void displayTotalCoins() {
        int[] totalCoins = new int[5]; // 5, 10, 25, 50, 100
        for (int i = 0; i < currentSize; i++) {
            if (changeArray[i] != null) {
                int[] coins = changeArray[i].getChange();
                for (int j = 0; j < coins.length; j++) {
                    totalCoins[j] += coins[j];
                }
            }
        }
        IOHelper.println("Total coins for each denomination:");
        String[] labels = {"5 cent", "10 cent", "25 cent", "50 cent", "100 cent"};
        for (int i = 0; i < totalCoins.length; i++) {
            IOHelper.println(labels[i] + ": " + totalCoins[i]);
        }
    }

    private static void displayTotalAmount() {
        int total = 0;
        for (int i = 0; i < currentSize; i++) {
            if (changeArray[i] != null) {
                total += changeArray[i].getAmount();
            }
        }
        IOHelper.println("Total amount of all persons: " + total + " cents");
    }

    public static void main(String[] args) {
        run();
    }
}
