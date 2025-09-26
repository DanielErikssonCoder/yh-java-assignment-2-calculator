// Import libraries from Java for error handling and reading user input
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Menu class for handling all logics in the menu
 */
public class Menu {

    /**
     * Clears the console screen
     */
    private void clearScreen() {
        try {

            // Check if system is Windows
            if (System.getProperty("os.name").contains("Windows")) {

                // Execute Windows command to clear the console
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

                System.out.println();

            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println();
            }
        } catch (Exception e) {

            // If clear fails, then we just print some empty lines
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }

    /**
     * Method with "Waits for user to press Enter before continuing"
     */
    private void pressEnterToContinue(Scanner scanner) {

        System.out.println();
        System.out.print("Press Enter to continue...");
        scanner.nextLine();
    }

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
     * @param scanner Scanner object for reading user input
     * @return Array of double values entered by the user
     */
    private double[] getNumbers(Scanner scanner) {

        System.out.println();

        // Check for existing result
        if (currentValue != 0.0) {

            // Track valid input
            boolean validResponse = false;

            // Store users choice
            String usePreviousNumber = "";

            // Loop until we get a valid response
            while (!validResponse) {

                System.out.println("Use previous result " + currentValue + " as the first number? (yes/no) ");
                System.out.println();

                // Read user input (and remove spaces, and make lowercase)
                usePreviousNumber = scanner.nextLine().trim().toLowerCase();
                System.out.println();

                // Check if user input is a valid response
                if (usePreviousNumber.equals("yes") || usePreviousNumber.equals("y") || usePreviousNumber.equals("no") || usePreviousNumber.equals("n")) {

                    // Mark as valid to exit the loop
                    validResponse = true;
                }
                else {

                    System.out.println("Invalid input! Please enter 'yes' or 'no'");
                    System.out.println();
                }
            }

            // Check if user wants to use previous result
            if (usePreviousNumber.equals("yes") || usePreviousNumber.equals("y")) {

                System.out.println("How many more numbers would you like to use? ");
                System.out.println();

                // Initialize a counter for additional numbers
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

                // Clear buffer
                scanner.nextLine();

                //Create an array with extra space for the previous result
                double[] numbers = new double[count + 1];

                // First element is the previous result
                numbers[0] = currentValue;

                // Collect additional numbers (starting from index 1)
                for (int i = 1; i <= count; i++) {

                    System.out.println();
                    System.out.print("Enter number " + i + ": ");

                    // Track if a valid input has been received
                    boolean validInput = false;

                    // Loop through until valid number is entered
                    while (!validInput) {

                        // Try to get a valid number input
                        try {
                            numbers[i] = scanner.nextDouble();

                            // Mark as successful
                            validInput = true;

                        } catch (InputMismatchException e) { // Handle invalid input (when it isn't a number)

                            // Clear the invalid input
                            scanner.nextLine();

                            System.out.println();
                            System.out.println("Invalid number! Please enter a valid number.");
                            System.out.println();

                            System.out.print("Enter number " + (i) + ": ");
                        }
                    }
                }

                // Clear buffer
                scanner.nextLine();

                // Return array of numbers
                return numbers;
            }
        }

        System.out.print("How many numbers would you like to use? ");

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

        // Clear buffer
        scanner.nextLine();

        // Return array of numbers
        return numbers;
    }

    /**
     * Displays the calculator menu with formatting and color styling
     * Shows available operations and current result value
     */
    private void printMenu() {

        // Clear screen
        clearScreen();

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

                // Clear buffer
                scanner.nextLine();

            } catch (InputMismatchException e) {  // Catch any input that is not a valid integer

                // Clear buffer
                scanner.nextLine();
            }

            System.out.println();

            // Handle menu navigation based on the user input
            switch (choice) {
                case 1:

                    // Clear before start
                    clearScreen();

                    System.out.println("Addition selected");

                    // Collect an array of numbers from the user input
                    double[] addNumbers = getNumbers(scanner);

                    // Call our Add method from the Operations class and store the result
                    currentValue = operations.add(addNumbers);

                    // Clear screen
                    clearScreen();

                    // Format and display result with 2 decimals
                    System.out.println();
                    System.out.printf("Result: %.2f\n", currentValue);

                    // Wait for the user to hit Enter
                    pressEnterToContinue(scanner);

                    // Clear screen
                    clearScreen();

                    break;

                case 2:

                    // Clear before start
                    clearScreen();

                    System.out.println("Subtraction selected");

                    // Collect an array of numbers from the user input
                    double[] subNumbers = getNumbers(scanner);

                    // Call our Subtract method from the Operations class and store the result
                    currentValue = operations.subtract(subNumbers);

                    // Clear screen
                    clearScreen();

                    // Format and display result with 2 decimals
                    System.out.println();
                    System.out.printf("Result: %.2f\n", currentValue);

                    // Wait for the user to hit Enter
                    pressEnterToContinue(scanner);

                    // Clear screen
                    clearScreen();

                    break;

                case 3:

                    // Clear before start
                    clearScreen();

                    System.out.println("Multiplication selected");

                    // Collect an array of numbers from the user input
                    double[] multNumbers = getNumbers(scanner);

                    // Call our multiply method from the Operations class and store the result
                    currentValue = operations.multiply(multNumbers);

                    // Clear screen
                    clearScreen();

                    // Format and display result with 2 decimals
                    System.out.println();
                    System.out.printf("Result: %.2f\n", currentValue);

                    // Wait for the user to hit Enter
                    pressEnterToContinue(scanner);

                    // Clear screen
                    clearScreen();

                    break;

                case 4:

                    // Clear before start
                    clearScreen();

                    System.out.println("Division selected");

                    // Collect an array of numbers from the user input
                    double[] divNumbers = getNumbers(scanner);

                    // Call our Divide method from the Operations class and store the result
                    currentValue = operations.divide(divNumbers);

                    // Clear screen
                    clearScreen();

                    // Format and display result with 2 decimals
                    System.out.println();
                    System.out.printf("Result: %.2f\n", currentValue);

                    // Wait for the user to hit Enter
                    pressEnterToContinue(scanner);

                    // Clear screen
                    clearScreen();

                    break;

                case 5:

                    // Clear before start
                    clearScreen();

                    System.out.println("Remainder selected");

                    // Collect an array of numbers from the user input
                    double[] modNumbers = getNumbers(scanner);

                    // Call our Modulus method from the Operations class and store the result
                    currentValue = operations.modulus(modNumbers);

                    // Clear screen
                    clearScreen();

                    // Format and display result with 2 decimals
                    System.out.println();
                    System.out.printf("Result: %.2f\n", currentValue);

                    // Wait for the user to hit Enter
                    pressEnterToContinue(scanner);

                    // Clear screen
                    clearScreen();

                    break;

                case 0:

                    // Clear before start
                    clearScreen();

                    // Break the loop
                    isRunning = false;

                    System.out.println("Thank you for trying out the Calculator");

                    // Wait for the user to hit Enter
                    pressEnterToContinue(scanner);

                    break;

                default:

                    System.out.println("Invalid choice! Please try again.");

                    // Wait for the user to hit Enter
                    pressEnterToContinue(scanner);
            }
        }
    }
}
