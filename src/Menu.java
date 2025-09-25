import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Menu class for handling all logics in the menu
 */
public class Menu {

    // ANSI color codes for getting some visual colors (orange text and for reset)
    private static final String ORANGE = "\033[38;5;208m";
    private static final String RESET = "\033[0m";

    // Stores the current result of calculations
    private double currentValue = 0.0;

    /**
     * Displays the calculator menu with formatting and color styling
     * Shows available operations and current result value
     */
    private void printMenu() {
        System.out.println(ORANGE + "=====================================" + RESET);
        System.out.println("             CALCULATOR             ");
        System.out.println(ORANGE + "=====================================" + RESET);
        System.out.printf(" Current Result: %.2f\n", currentValue);
        System.out.println(ORANGE + "-------------------------------------" + RESET);
        System.out.println(" [1] Addition");
        System.out.println(" [2] Subtraction");
        System.out.println(" [3] Multiplication");
        System.out.println(" [4] Division");
        System.out.println(" [5] Remainder");
        System.out.println(" [0] Exit");
        System.out.println(ORANGE + "=====================================" + RESET);
        System.out.print("Enter your choice: ");
    }

    /**
     * Shows the main menu that handles interaction from the user
     * This method is called by the Calculator class
     */
    public void displayMenu() {

        // Create a new Scanner object to read input from user
        Scanner scanner = new Scanner(System.in);

        // Condition for our loop
        boolean isRunning = true;

        // Main menu loop that runs until user exits
        while (isRunning) {

            // Show the menu
            printMenu();

            // Store the choice in a variable and initialize with invalid value
            int choice = -1;

            // Attempt to read integer input from user
            try {
                choice = scanner.nextInt();

            } catch (InputMismatchException e) {  // Catch any input that is not a valid integer

                // Clear buffer
                scanner.nextLine();
            }

            System.out.println();

            // Handle menu navigation based on the user input
            switch (choice) {
                case 1:
                    System.out.println("Addition selected");
                    System.out.println();
                    break;

                case 2:
                    System.out.println("Subtraction selected");
                    System.out.println();
                    break;

                case 3:
                    System.out.println("Multiplication selected");
                    System.out.println();
                    break;

                case 4:
                    System.out.println("Division selected");
                    System.out.println();
                    break;

                case 5:
                    System.out.println("Remainder selected");
                    System.out.println();
                    break;

                case 0:
                    isRunning = false;
                    System.out.println("Thank you for trying out the Calculator");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
                    System.out.println();
            }
        }
    }
}
