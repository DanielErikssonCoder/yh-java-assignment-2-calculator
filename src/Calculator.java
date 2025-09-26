/**
 * Calculator class that coordinates the application
 * Acts as the controller between Menu and Operations
 */
public class Calculator {

    // Private instance variable to handle menu interactions
    private Menu menu;

    // Constructor that initializes the Calculator object
    public Calculator() {

        // Create a new instance of Menu class
        menu = new Menu();
    }

    /**
     * Main run method that starts the calculator
     * Called by the Main class to run the program
     */
    public void run() {

        // Display the calculator menu
        menu.displayMenu();
    }

}
