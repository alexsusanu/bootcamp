import java.util.Scanner;
import java.util.Random;

public class GuessingGame {
    public static void main(String[] args){
        final int MIN = 1;
        final int MAX = 101;
        int generator = 0;
        int user_input = 0;
        int counter = 1;

        System.out.print("Enter a number: ");
        Scanner scanner = new Scanner(System.in);
        user_input = scanner.nextInt();
        System.out.println("You entered: " + user_input);

        Random rnd = new Random();
        generator = rnd.nextInt(MAX);
        System.out.println("Random number is: " + generator);

        while (user_input != generator) {
            counter += 1;
            System.out.print("Guess again: ");
            user_input = scanner.nextInt();

            generator = rnd.nextInt(MAX);
            System.out.println("Random number is: " + generator);
            
            if (counter == 5){
                System.out.println("Game over");
                break;
            }
        }
    }
}
