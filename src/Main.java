import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        System.out.println("Welcome to Grocery List!");
        int menu = 0;

        List list = new List();

        while (menu != 5) {

            try  {
                System.out.print("Select your Option (1 - Add Items, 2 - Remove Items, " +
                            "3 - Check Off Items, 4 - Print List, 5 - Exit Program): ");

                menu = scnr.nextInt();
                scnr.nextLine();

            } catch(InputMismatchException e) {
                System.out.println("Please enter a valid option!");
                scnr.nextLine();
            }



            switch (menu) {
                case 1:
                    list.addItem(); //Completed, adds Strings of scanned input into array
                    break;
                case 2:
                    list.removeItem(list.itemArray); //Completed, replaces given element of array with
                                                     //"" and shifts remaining elements left.
                    break;
                case 3:
                    list.checkItem();
                    break;
                case 4:
                    list.printItem(); //WIP
                    break;
                case 5:
                    list.exitProgram(); //Completed, exits Grocery List.
                    break;
            }
        }
        scnr.close();
    }
}