import java.util.List;

public class Run implements  Runnable{
    @Override
    public void run() {
        Assignment8 assignment8 = new Assignment8();
        for (int i = 0; i < 1000; i++) {
            List<Integer> numberList = assignment8.getNumbers();
            System.out.println(numberList);
        }
    }
}
