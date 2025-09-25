// Import libraries from Java
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

    // Operations object to handle all calculations
    private Operations operations;

    /**
     * Constructor to initialize Menu components
     */
    public Menu() {
        operations = new Operations();
    }

    /**
     * Gets numbers from user input using Scanner object for reading input
     * Return an Array of numbers entered by user
     */
    private double[] getNumbers(Scanner scanner) {

        System.out.println();
        System.out.print("How many numbers? ");

        // Initialize our counter with an invalid value
        int count = -1;

        // Loop until the user inputs a valid positive number
        while (count <= 0) {

            // Attempt to read integer from user
            try {

                count = scanner.nextInt();

                // Check if the number is positive
                if (count <= 0) {

                    System.out.println();
                    System.out.print("Please enter a positive number: ");
                }


            } catch (InputMismatchException e) { // Handle non-integer input

                // Clear bad input
                scanner.nextLine();

                System.out.println();
                System.out.print("Invalid input! Please enter a number: ");
            }
        }

        // Clear buffer after reading int
        scanner.nextLine();

        // Create an array to store all numbers
        double[] numbers = new double[count];

        // Collect each number from the user
        for(int i = 0; i < count; i++) {

            System.out.println();
            System.out.print("Enter number " + (i+1) + ": ");

            // Track if a valid input has been received
            boolean validInput = false;

            // Loop through until valid number is entered
            while (!validInput) {

                // Try to get a valid number input
                try {

                    // Attempt to read double from user
                    numbers[i] = scanner.nextDouble();

                    // Mark as successful
                    validInput = true;

                } catch (InputMismatchException e) { // Handle invalid input (when it isn't a number)

                    // Clear the invalid input
                    scanner.nextLine();

                    System.out.println();
                    System.out.println("Invalid number! Please enter a valid number.");
                    System.out.println();

                    System.out.print("Enter number " + (i+1) + ": ");
                }
            }
        }

        // Return array of numbers
        return numbers;
    }

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

        // Create a new Scanner object to read input
        Scanner scanner = new Scanner(System.in);

        // Condition for our loop
        boolean isRunning = true;

        // Main menu loop that runs until the user exits
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

                    // Collect an array of numbers from the user input
                    double[] addNumbers = getNumbers(scanner);

                    // Call our Add method from the Operations class and store the result
                    currentValue = operations.add(addNumbers);

                    // Format and display result with 2 decimals
                    System.out.println();
                    System.out.printf("Result: %.2f\n", currentValue);
                    System.out.println();
                    break;

                case 2:
                    System.out.println("Subtraction selected");

                    // Collect an array of numbers from the user input
                    double[] subNumbers = getNumbers(scanner);

                    // Call our Subtract method from the Operations class and store the result
                    currentValue = operations.subtract(subNumbers);

                    // Format and display result with 2 decimals
                    System.out.println();
                    System.out.printf("Result: %.2f\n", currentValue);
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
