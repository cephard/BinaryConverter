package ceph;

import java.util.Scanner;

public class BinaryConverter {

    private static int INDEX = 0;
    private static int DECIMAL = 0;
    private static int decimalOut = 0;
    private static StringBuilder binaryOut = new StringBuilder();
    private static char[] characters = { 'A', 'B', 'C', 'D', 'E', 'F' };
    private static int remainder;

    /*
     * use this file to practice binary conversions
     * converting decimal to other bases using the division method and storing the
     * remeinder.Printing the remeinder backwards.
     * Using char array to represent numbers 10 to 15.
     * 
     */

    public static void fromDecimal(int base, int decimal) {
        decimalOut = decimal;

        // handling the special case for zero
        if (decimal == 0) {
            remainder = decimal;
            System.out.println("Binary: " + remainder);
        } else {
            while (decimal > 0) {
                remainder = decimal % base;
                decimal = decimal / base;

                // handling characters between 10 to 15
                if (remainder >= 10 && remainder < 10 + characters.length) {
                    binaryOut.append(characters[remainder - 10]);
                } else {
                    binaryOut.append(remainder);
                }
            }
            System.out.println(decimalOut + " to base "
                    + base + " is "
                    + binaryOut.reverse().toString());
        }
    }

    /*
     * Transforming from other bases to decimal
     */
    public static void toDecimal(int base, String number) {
        number = number.toUpperCase();

        // making sure the base values are correct
        if (base == 2 || base == 8 || base == 16) {
            for (INDEX = 0; INDEX < number.length(); INDEX++) {
                char character = number.charAt(INDEX);

                // returning corresponding int of the character in the position
                if (Character.isDigit(character)) {
                    int intNumber = Character.digit(character, base);
                    DECIMAL = base * DECIMAL + intNumber;
                } else {

                    // handling the characters in hex
                    if (base == 16 && Character.toUpperCase(character) >= 'A'
                            && Character.toUpperCase(character) <= 'F') {
                        int intNumber = Character.toUpperCase(character) - 'A' + 10;
                        DECIMAL = base * DECIMAL + intNumber;

                    } else if (character > 'F') {
                        System.out.println("Invalid input!");
                        return;
                    }
                }
            }

            System.out.println(number + " to base " + base + " is " + DECIMAL);
        } else {
            System.out.println("Invalid input!");
        }
    }

    public static void inputCheck(Scanner in) {
        while (!in.hasNextInt()) {
            System.out.println("Invalid input please try again");
            in.next();
        }
    }
}
