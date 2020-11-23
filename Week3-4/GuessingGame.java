import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

public class GuessingGame {
    public static void main(String[] args){
        final String RED = "\u001B[31m";
        final String RESET = "\u001B[0m";
        final String YELLOW = "\u001B[33m";
        final int MIN = 1;
        final int MAX = 101;
        final int MAX_COUNTER = 5;
        int generator = 0;
        int user_input = 0;
        int counter = 1;
        boolean re;

        System.out.print("Enter a number: ");
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()){
            System.out.print("Invalid input. Try again: ");
            scanner.next();
        }
        Random rnd = new Random();

        user_input = scanner.nextInt();
        generator = rnd.nextInt(MAX);
        rightGuess(user_input, generator); 
        re = checkRange(user_input, MIN, MAX);

        while (!re){
            try {
                user_input = scanner.nextInt();
                re = checkRange(user_input, MIN, MAX);
                rightGuess(user_input, generator); 
            }catch(InputMismatchException e){
                System.out.print("Number way too big. Try again: ");
                scanner.next();
            }
        }

        if (re){
            while (user_input != generator) {
                counter += 1;
                if (user_input < generator){
                    System.out.println("Please pick a " + RED + "higher " + RESET +  "number.");
                }else {
                    System.out.println("Please pick a " + YELLOW + "lower " + RESET + "number.");
                }
                System.out.print("Guess again: ");
                while (!scanner.hasNextInt()){
                    System.out.print("Invalid input. Try again: ");
                    scanner.next();
                }

                user_input = scanner.nextInt();
                re = checkRange(user_input, MIN, MAX);
                rightGuess(user_input, generator); 

                while (!re){
                    user_input = scanner.nextInt();
                    re = checkRange(user_input, MIN, MAX);
                    rightGuess(user_input, generator); 
                }

                if (counter == MAX_COUNTER){
                    System.out.println(RED + "Game over" + RESET);
                    System.out.println("Random number was: " + generator);
                    scanner.close();
                    break;
                }
            }
        }

    }

    public static boolean checkRange(int user_input, int MIN, int MAX){
        if (user_input > MAX || user_input < MIN){
            System.out.println("Your guess is not between 1 and 100.");
            System.out.print("Try again: ");
            return false;
        }else {
            return true;
        }
    }

    public static void rightGuess(int user_input, int generator){
        if (user_input == generator) {
            System.out.println("YOU GUESSED IT");
            System.exit(0);
        }
    }

}
