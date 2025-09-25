public class Calculator {

    // Private instance variable to handle menu interactions
    private Menu menu;

    // Constructor that initializes the Calculator object
    public Calculator() {

        // Create a new instance of Menu class
        menu = new Menu();
    }

    // Main method that starts our program
    public void run() {

        // Display the calculator menu
        menu.displayMenu();
    }

}
