import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class List {

    ArrayList<String> itemArray = new ArrayList<>();
    private ArrayList<Boolean> checkedArray = new  ArrayList<>();

    Scanner scnr = new Scanner(System.in);


    public ArrayList<String> addItem() {

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

        itemArray = new ArrayList<String>();
        checkedArray = new ArrayList <Boolean>();

        for (int i = 0; i < numberOfItemsInList; i++) {
            String newItem;
            boolean isDuplicated;

            do {
                System.out.print("Enter the name of item #" + (i + 1) + ": ");
                newItem = scnr.nextLine();

                isDuplicated = false;

                for (int j = 0; j < i; j++) {
                    if (newItem.equalsIgnoreCase(itemArray.get(j))) {
                        System.out.println("You already added this item, please try again!");
                        isDuplicated = true;
                        break;
                    }
                }
            } while (isDuplicated);

            itemArray.add(newItem);
            checkedArray.add(false);
        }

        return itemArray;
    }

    public ArrayList<String> removeItem(ArrayList<String> itemArray) {

        for (int i = 0; i < itemArray.size(); i++) {
                System.out.println((i + 1) + "). " + itemArray.get(i));
        }

        System.out.println("Enter the number of the item you want to remove: ");

        int removeIndex = scnr.nextInt() - 1;

        if (removeIndex < 0 || removeIndex >= itemArray.size()) {
            System.out.println("Invalid choice, please try again!");
            return itemArray;
        }

        itemArray.remove(removeIndex);

        checkedArray.set((itemArray.size() - 1), false);
        return itemArray;
    }

    public void checkItem() {

        for (int i = 0; i < itemArray.size(); i++) {
            if (itemArray.get(i) != null && !(itemArray.get(i)).isEmpty()) {
                System.out.println((i + 1) + "). " + itemArray.get(i) +
                        (checkedArray.get(i) ? " [✔]" : ""));
            }
        }

        while (true) {
            System.out.print("Please select the number you wish to check off your list: ");

            try {
                int checkindex = scnr.nextInt() - 1;
                scnr.nextLine();

                if (checkindex < 0 || checkindex >= itemArray.size()) {
                    System.out.println("Invalid number, please try again!");
                } else if (itemArray.get(checkindex) == null || (itemArray.get(checkindex)).isEmpty()) {
                    System.out.println("That slot is empty, please try again!");
                } else {
                    checkedArray.set(checkindex, true);
                    System.out.println(itemArray.get(checkindex) + " has been checked off!");
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please enter a number!");
                scnr.nextLine(); // clear bad input and retry
            }
        }
    }


    public void printItem() {

        for (int i = 0; i < itemArray.size(); i++) {
            if (checkedArray.get(i) == true) {
                System.out.println("[✔] - " + itemArray.get(i));
            } else {
                System.out.println("[X] - " + itemArray.get(i));
            }

        }
    }

    void exitProgram() {

        System.out.println("Exiting Grocery List!");
        System.exit(0);
    }
}
