import java.util.Scanner;
import java.util.Random;

public class GuessingGame {
    public static void main(String[] args){
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
        user_input = scanner.nextInt();
        System.out.println("You entered: " + user_input);
        

        Random rnd = new Random();
        generator = rnd.nextInt(MAX);
       
        re = checkRange(user_input, MIN, MAX);
        while (!re){
            user_input = scanner.nextInt();
            re = checkRange(user_input, MIN, MAX);
        }

        if (re){
            while (user_input != generator) {
                counter += 1;
                if (user_input < generator){
                    System.out.println("Please pick a higher number.");
                }else {
                    System.out.println("Please pick a lower number.");
                }
                System.out.print("Guess again: ");
                user_input = scanner.nextInt();
                re = checkRange(user_input, MIN, MAX);
                while (!re){
                    user_input = scanner.nextInt();
                    re = checkRange(user_input, MIN, MAX);
                }

                if (counter == MAX_COUNTER){
                    System.out.println("Game over");
                    System.out.println("Random number is: " + generator);
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

}
