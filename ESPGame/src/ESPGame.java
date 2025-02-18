/*
 * Class: CMSC203 
 * Instructor: Professor Grigory
 * Description: The class name is ESPGame and there is a main method where the ESP Game works. It asks the user to enter the guess of color from the file and it checks whether their guess is correct or not
 * Due: 02/17/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or  
 * any source. I have not given my code to any student.
 * Print your Name here: Menahil Fatima
*/

import java.io.*;
import java.util.Scanner;

public class ESPGame {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String userName, userDesc, dueDate;
        int correctGuesses;
        int choice;
        String playAgain = "yes"; // Variable to control the game loop

        do {
            correctGuesses = 0;  // Reset correct guesses for each game session

            System.out.println("CMSC203 Assignment1: Test your ESP skills!");
            System.out.println("Welcome to ESP - extrasensory perception!");
            System.out.println("Please choose one of the 4 options from the menu:\n");
            System.out.println("1- Read and display first 16 names of colors");
            System.out.println("2- Read and display first 10 names of colors");
            System.out.println("3- Read and display first 5 names of colors");
            System.out.println("4- Exit from program");
            System.out.print("Enter the option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            

            if (choice == 1 || choice == 2 || choice == 3) {
                
            	System.out.println("Please enter the filename: ");
                String filename = scanner.nextLine();
                File file = new File(filename);
            	Scanner fileScanner = new Scanner(file);
            	System.out.println("There are sixteen colors from a file:");

                int numColors = 0;
                if (choice == 1) numColors = 16;
                else if (choice == 2) numColors = 10;
                else if (choice == 3) numColors = 5;

                
                String color = "";
                int i = 0;

                // Display the colors from the file
                while (fileScanner.hasNextLine() && i < numColors) {
                    color = fileScanner.nextLine();
                    System.out.println((i + 1) + ": " + color);
                    i++;
                }
                fileScanner.close();

                // Ensure the user gets exactly 3 rounds
                for (int round = 1; round <= 3; round++) {
                    System.out.println("\nRound " + round);
                    System.out.println("Try to guess the color I am thinking of!");
                    System.out.print("Enter your guess: ");
                    String guessedColor = scanner.nextLine();

                    // Randomly select a color from the first numColors colors
                    fileScanner = new Scanner(file);
                    int randomIndex = (int) (Math.random() * numColors);
                    for (i = 0; i <= randomIndex; i++) {
                        color = fileScanner.nextLine();
                    }

                    // Check if the guessed color matches the selected color
                    if (guessedColor.equalsIgnoreCase(color)) {
                        correctGuesses++;
                    }
                    System.out.println("I was thinking of: " + color);
                }

                System.out.println("\nGame Over");
                System.out.println("You guessed " + correctGuesses + " out of 3 colors correctly.");
            } else if (choice == 4) {
                // Collect user details when the user exits
                System.out.print("Enter your name: ");
                userName = scanner.nextLine();
                System.out.print("Describe yourself: ");
                userDesc = scanner.nextLine();
                System.out.print("Due Date: ");
                dueDate = scanner.nextLine();

                // Write game results to file
                FileWriter writer = new FileWriter("EspGameResults.txt");
                writer.write("Game Over\n");
                writer.write("You guessed " + correctGuesses + " color(s) correctly.\n");
                writer.write("Due Date: " + dueDate + "\n");
                writer.write("Username: " + userName + "\n");
                writer.write("User Description: " + userDesc + "\n");
                writer.close();

                // Display the collected user details
                System.out.println("\nGame Over");
                System.out.println("You guessed " + correctGuesses + " color(s) correctly.");
                System.out.println("Due Date: " + dueDate);
                System.out.println("Username: " + userName);
                System.out.println("User Description: " + userDesc);
                
                // Set playAgain to "no" to stop the game loop
                playAgain = "no";
            } else {
                System.out.println("Invalid option. Please choose a valid option.");
            }

            // Ask the user if they want to play again only if they haven't exited
            if (choice != 4) {
                System.out.print("Do you want to play again? (yes/no): ");
                playAgain = scanner.nextLine();
            }
            
        } while (playAgain.equalsIgnoreCase("yes"));
        
        System.out.println("Thank you for playing!");
    }
}