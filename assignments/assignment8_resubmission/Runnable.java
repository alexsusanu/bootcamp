import com.coderscampus.assignment.Assignment8;

import java.util.List;

public class Runnable {
    public static void main(String[] args) {
        Assignment8 assignment8 = new Assignment8();
        for (int i=0; i<1000; i++) {

            List<Integer> numbersList = assignment8.getNumbers();

            System.out.println(numbersList);

        }


    }
}
