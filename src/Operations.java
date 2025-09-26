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

        // Loop through each number in the array
        for (double num : numbers) {

            //  Add each number to our total variable
            total += num;
        }

        // Return the addition result
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

        // Loop from the second index (skip the first)
        for (int i = 1; i < numbers.length; i++) {

            // Remove the rest
            result -= numbers[i];
        }

        // Return the subtraction result
        return result;
    }

    /**
     * Performs multiplication on an array of numbers
     * @param numbers Array of numbers to multiply
     * @return Product of multiplication
     */
    public double multiply (double[] numbers) {

        // Start with 1 for multiplication (not 0)
        double result = 1;

        // Loop through each number in the array
        for (double num : numbers ) {

            // Multiply each number with the result
            result *= num;
        }

        // Return the multiplication result
        return result;
    }

    /**
     * Performs division on an array of numbers
     * @param numbers Array where first is dividend, rest are divisors
     * @return Result of division
     */
    public double divide (double[] numbers) {

        // Start with the first number
        double result = numbers[0];

        // Loop from the second index (skip the first)
        for (int i = 1; i < numbers.length; i++) {

            // Check for division by zero
            if (numbers[i] == 0) {

                System.out.println();
                System.out.println("Cannot divide by zero!");

                // Return the original dividend unchanged
                return numbers[0];
            }

            // Divide by each number
            result /= numbers[i];
        }

        // Return the division result
        return result;
    }

    /**
     * Perform modulus on an array of numbers
     * @param numbers Array where first is dividend, rest are divisors
     * @return Remainder after modulus
     */
    public double modulus (double[] numbers) {

        // Start with the first number
        double result = numbers[0];

        // Loop from the second index (skip the first)
        for (int i = 1; i < numbers.length; i++) {

            // Check for modulus by zero
            if (numbers[i] == 0) {

                System.out.println();
                System.out.println("Cannot calculate remainder with zero!");

                // Return the original dividend unchanged
                return numbers[0];
            }

            // Calculate remainder for each number
            result = result % numbers[i];
        }

        // Return the remainder result
        return result;
    }
}