import java.util.Scanner;
import java.util.ArrayList;

public class LeapYearChecker {
    // This function checks if a year is a leap year
    public static boolean checkLeapYear(int year) {
        // A year is a leap year if it is divisible by 4
        if (year % 4 == 0) {
            // If the year is also divisible by 100, it must be divisible by 400 to be a leap year
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true; // Divisible by 400, so it is a leap year
                } else {
                    return false; // Not divisible by 400, so it is not a leap year
                }
            } else {
                return true; // Divisible by 4 but not by 100, so it is a leap year
            }
        } else {
            return false; // Not divisible by 4, so it is not a leap year
        }
    }

    // This function prints all the leap years between two given years
    public static void printLeapYears(int year1, int year2) {
        ArrayList<Integer> leapYears = new ArrayList<>();
        // Iterate through each year in the range
        for (int i = year1; i <= year2; i++) {
            // Check if the current year is a leap year
            if (checkLeapYear(i)) {
                leapYears.add(i); // Add the leap year to the list
            }
        }
        // Print the list of leap years
        System.out.println("Leap years between " + year1 + " and " + year2 + ": " + leapYears);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input year or range (e.g., 2000 or 2000-2020):");
        String input = in.nextLine();
        String[] parts = input.split("-");

        // If the input is a single year
        if (parts.length == 1) {
            int year = Integer.parseInt(parts[0]);
            // Check if the year is a leap year and print the result
            if (checkLeapYear(year)) {
                System.out.println(year + " is a leap year.");
            } else {
                System.out.println(year + " is not a leap year.");
            }
        // If the input is a range of years
        } else if (parts.length == 2) {
            int year1 = Integer.parseInt(parts[0]);
            int year2 = Integer.parseInt(parts[1]);
            // Print all leap years in the given range
            printLeapYears(year1, year2);
        } else {
            // Invalid input format
            System.out.println("Invalid input format.");
        }
        in.close(); // Close the scanner
    }
}
