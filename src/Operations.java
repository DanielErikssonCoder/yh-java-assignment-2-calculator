/**
 * Handles all mathematical operations for our calculator
 */
public class Operations {

    /**
     * Performs addition on an array of numbers
     * @param numbers Array of numbers to add
     * @return Sum of all numbers
     */
    public double add(double[] numbers) {

        // Variable for storing the total of our calculation
        double total = 0;

        for(double num : numbers) {

            //  Add each number to our total variable
            total += num;
        }

        return total;
    }

    /**
     * Performs subtraction on an array of numbers
     * @param numbers Array where first number is minuend, rest are subtrahends
     * @return Result of subtraction
     */
    public double subtract(double[] numbers) {

        // Start with the first number
        double result = numbers[0];

        // Loop from INDEX 1 (skip the first)
        for(int i = 1; i < numbers.length; i++) {

            // Remove the rest
            result -= numbers[i];
        }

        return result;
    }
}