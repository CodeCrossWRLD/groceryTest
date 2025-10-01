import java.util.InputMismatchException;
import java.util.Scanner;

public class List {

    public String[] itemArray;
    private boolean[] checkedArray;

    Scanner scnr = new Scanner(System.in);


    public String[] addItem() {

        int numberOfItemsInList = 0;

        while (true) {
            System.out.print("Enter the number of items you want to add: ");
            try {
                numberOfItemsInList = scnr.nextInt();
                scnr.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid integer!");
                scnr.nextLine();
            }
        }

        itemArray = new String[numberOfItemsInList];
        checkedArray = new boolean[numberOfItemsInList];

        for (int i = 0; i < numberOfItemsInList; i++) {
            String newItem;
            boolean isDuplicated;

            do {
                System.out.print("Enter the name of item #" + (i + 1) + ": ");
                newItem = scnr.nextLine();
                isDuplicated = false;

                for (int j = 0; j < i; j++) {
                    if (newItem.equalsIgnoreCase(itemArray[j])) {
                        System.out.println("You already added this item, please try again!");
                        isDuplicated = true;
                        break;
                    }
                }
            } while (isDuplicated);

            itemArray[i] = newItem;
            checkedArray[i] = false;
        }

        return itemArray;
    }

    public String[] removeItem(String[] itemArray) {

        for (int i = 0; i < itemArray.length; i++) {
                System.out.println((i + 1) + "). " + itemArray[i]);
        }

        System.out.println("Enter the number of the item you want to remove: ");

        int removeIndex = scnr.nextInt() - 1;
        String wipedItem = "";

        if (removeIndex < 0 || removeIndex >= itemArray.length) {
            System.out.println("Invalid choice, please try again!");
            return itemArray;
        }

        for (int i = removeIndex; i < itemArray.length - 1; i++) {
            itemArray[i] = itemArray[i + 1];
            checkedArray[i] = checkedArray[i + 1];
        }
        itemArray[itemArray.length - 1] = wipedItem;
        checkedArray[itemArray.length - 1] = false;
        return itemArray;
    }

    public void checkItem() {

        for (int i = 0; i < itemArray.length; i++) {
            if (itemArray[i] != null && !itemArray[i].isEmpty()) {
                System.out.println((i + 1) + "). " + itemArray[i] +
                        (checkedArray[i] ? " [✔]" : ""));
            }
        }

        while (true) {
            System.out.print("Please select the number you wish to check off your list: ");

            try {
                int checkindex = scnr.nextInt() - 1;
                scnr.nextLine();

                if (checkindex < 0 || checkindex >= itemArray.length) {
                    System.out.println("Invalid number, please try again!");
                } else if (itemArray[checkindex] == null || itemArray[checkindex].isEmpty()) {
                    System.out.println("That slot is empty, please try again!");
                } else {
                    checkedArray[checkindex] = true;
                    System.out.println(itemArray[checkindex] + " has been checked off!");
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please enter a number!");
                scnr.nextLine(); // clear bad input and retry
            }
        }
    }


    public void printItem() {

        for (int i = 0; i < itemArray.length; i++) {
            if (checkedArray[i] == true) {
                System.out.println("[✔] - " + itemArray[i]);
            } else {
                System.out.println("[X] - " + itemArray[i]);
            }

        }
    }

    void exitProgram() {

        System.out.println("Exiting Grocery List!");
        System.exit(0);
    }
}
