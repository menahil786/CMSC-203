/*
 * Class: CMSC203 
 * Instructor:
 * Description:This program collects patient details and information about medical procedures
 * using user input, then displays the collected data and calculates total charges.
 * Due: 03/03/2025
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Menahil Fatima
*/
import java.util.*;

public class PatientDriverApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get patient details from user input
        System.out.print("Enter Patient First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Patient Middle Name: ");
        String middleName = scanner.nextLine();
        System.out.print("Enter Patient Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter Street Address: ");
        String streetAddress = scanner.nextLine();
        System.out.print("Enter City: ");
        String city = scanner.nextLine();
        System.out.print("Enter State: ");
        String state = scanner.nextLine();
        
        // Validate ZIP Code input (5 digits)
        int zip = getValidatedZipCode(scanner);

        // Validate Phone Number input (XXX-XXX-XXXX format)
        
        String phoneNumber = getValidatedPhoneNumber(scanner);

        System.out.print("Enter Emergency Contact Name: ");
        String emergencyContactName = scanner.nextLine();
        String emergencyContactPhone = getValidatedPhoneNumber(scanner);

        // Create a Patient object with provided details
        Patient patient = new Patient(firstName, middleName, lastName, streetAddress, city, state, zip, phoneNumber, emergencyContactName, emergencyContactPhone);

        // Prompt user to input procedure details for all constructors
        System.out.print("\nEnter Procedure 1 Name: ");
        String procedure1Name = scanner.nextLine();
        String procedure1Date = getValidatedDate(scanner); // Validate date format
        System.out.print("Enter Practitioner for Procedure 1: ");
        String procedure1Practitioner = scanner.nextLine();
        double procedure1Charge = getValidatedCharge(scanner); // Validate charge input

        Procedure procedure1 = new Procedure(procedure1Name, procedure1Date, procedure1Practitioner, procedure1Charge);

        // Procedure 2 (Constructor with only name and date)
        System.out.print("\nEnter Procedure 2 Name: ");
        String procedure2Name = scanner.nextLine();
        String procedure2Date = getValidatedDate(scanner); // Validate date format
        
        Procedure procedure2 = new Procedure(procedure2Name, procedure2Date);

        // Prompt for practitioner and charge for Procedure 2
        System.out.print("Enter Practitioner for Procedure 2: ");
        String procedure2Practitioner = scanner.nextLine();
        double procedure2Charge = getValidatedCharge(scanner); // Validate charge input
        procedure2 = new Procedure(procedure2Name, procedure2Date, procedure2Practitioner, procedure2Charge);

        // Procedure 3 (No-arg constructor, then setting values)
        Procedure procedure3 = new Procedure();
        System.out.print("\nEnter Procedure 3 Name: ");
        String procedure3Name = scanner.nextLine();
        String procedure3Date = getValidatedDate(scanner); // Validate date format
        System.out.print("Enter Practitioner for Procedure 3: ");
        String procedure3Practitioner = scanner.nextLine();
        double procedure3Charge = getValidatedCharge(scanner); // Validate charge input

        procedure3 = new Procedure(procedure3Name, procedure3Date, procedure3Practitioner, procedure3Charge);

        // Display patient and procedures
        displayPatient(patient);
        displayProcedure(procedure1);
        displayProcedure(procedure2);
        displayProcedure(procedure3);

        // Calculate and display total charges
        double totalCharges = calculateTotalCharges(procedure1, procedure2, procedure3);
        System.out.printf("\nTotal Charges: $%,.2f\n", totalCharges);

        // Student information
        System.out.println("Student Name: Menahil Fatima");
        System.out.println("MC#: M21197203");
        System.out.println("Due Date: 03/03/2025");
    }

    /**
     * Displays patient information.
     * @param patient The patient object containing details
     */
    public static void displayPatient(Patient patient) {
        System.out.println("Patient info:");
        System.out.println("\tName: " + patient.buildFullName());
        System.out.println("\tAddress: " + patient.buildAddress());
        System.out.println("\tEmergency Contact: " + patient.buildEmergencyContact());
    }

    /**
     * Displays procedure details.
     * @param procedure The procedure object containing details
     */
    public static void displayProcedure(Procedure procedure) {
        System.out.println("\n\t\tProcedure: " + procedure.getNameOfProcedure());
        System.out.println("\t\tProcedure Date: " + procedure.getDateOfProcedure());
        System.out.println("\t\tPractitioner: " + procedure.getNameOfPractitioner());
        System.out.println("\t\tCharge: $" + String.format("%.2f", procedure.getCharges()));
    }

    /**
     * Calculates the total charges for all procedures.
     * @param p1 First procedure
     * @param p2 Second procedure
     * @param p3 Third procedure
     * @return The total charge amount
     */
    public static double calculateTotalCharges(Procedure p1, Procedure p2, Procedure p3) {
        return p1.getCharges() + p2.getCharges() + p3.getCharges();
    }

    // Helper method to validate ZIP code (5 digits)
    private static int getValidatedZipCode(Scanner scanner) {
        int zip;
        while (true) {
            System.out.print("Enter ZIP Code: ");
            if (scanner.hasNextInt()) {
                zip = scanner.nextInt();
                if (zip > 9999 && zip < 100000) { // Check if it's a valid 5-digit number
                    scanner.nextLine(); // Consume the newline
                    break;
                } else {
                    System.out.println("Invalid ZIP Code. Please enter a 5-digit number.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid 5-digit number.");
                scanner.next(); // Consume the invalid input
            }
        }
        return zip;
    }

    // Helper method to validate Phone Number input (XXX-XXX-XXXX format)
 // Helper method to validate Phone Number input (XXX-XXX-XXXX format)
    private static String getValidatedPhoneNumber(Scanner scanner) {
        String phoneNumber;
        while (true) {
            System.out.print("Enter Phone Number (XXX-XXX-XXXX): ");
            phoneNumber = scanner.nextLine();
            if (phoneNumber.matches("\\d{3}-\\d{3}-\\d{4}")) {
                break;
            } else {
                System.out.println("Invalid phone number format. Please use XXX-XXX-XXXX.");
            }
        }
        return phoneNumber;
    }

    private static String getValidatedDate(Scanner scanner) {
        String date;

        while (true) {
            System.out.print("Enter Date (MM/DD/YYYY): ");
            date = scanner.nextLine();

            // Check if the date is in the correct format (10 characters, MM/DD/YYYY)
            if (date.length() == 10) {
                // Check if the 3rd and 6th characters are slashes
                if (date.charAt(2) == '/' && date.charAt(5) == '/') {
                    // Manually check if month, day, and year are numeric
                    char m1 = date.charAt(0);
                    char m2 = date.charAt(1);
                    char d1 = date.charAt(3);
                    char d2 = date.charAt(4);
                    char y1 = date.charAt(6);
                    char y2 = date.charAt(7);
                    char y3 = date.charAt(8);
                    char y4 = date.charAt(9);

                    // Check if all characters in MM, DD, and YYYY are numbers
                    if (isNumber(m1) && isNumber(m2) && isNumber(d1) && isNumber(d2) &&
                        isNumber(y1) && isNumber(y2) && isNumber(y3) && isNumber(y4)) {
                        
                        // Check if the month is valid (1 to 12)
                        if ((m1 == '0' && m2 >= '1' && m2 <= '9') || (m1 == '1' && m2 >= '0' && m2 <= '2')) {
                            // Check if the day is valid (1 to 31)
                            if ((d1 == '0' && d2 >= '1' && d2 <= '9') || (d1 == '1' && d2 >= '0' && d2 <= '9') ||
                                (d1 == '2' && d2 >= '0' && d2 <= '9') || (d1 == '3' && d2 >= '0' && d2 <= '1')) {
                                break; // Valid date
                            } else {
                                System.out.println("Day must be between 01 and 31.");
                            }
                        } else {
                            System.out.println("Month must be between 01 and 12.");
                        }
                    } else {
                        System.out.println("Date should only contain digits in the month, day, and year.");
                    }
                } else {
                    System.out.println("Date format must be MM/DD/YYYY.");
                }
            } else {
                System.out.println("Date must be 10 characters long.");
            }
        }

        return date;
    }

    // Helper method to check if a character is a number (0-9)
    private static boolean isNumber(char ch) {
        return ch >= '0' && ch <= '9';
    }

    // Helper method to validate charge input (positive double)
    private static double getValidatedCharge(Scanner scanner) {
        double charge;
        while (true) {
            System.out.print("Enter Charge for Procedure: ");
            if (scanner.hasNextDouble()) {
                charge = scanner.nextDouble();
                if (charge > 0) {
                    scanner.nextLine(); // Consume the newline
                    break;
                } else {
                    System.out.println("Charges must be a positive number.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number for the charge.");
                scanner.next(); // Consume the invalid input
            }
        }
        return charge;
    }
}