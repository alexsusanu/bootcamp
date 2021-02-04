import java.util.List;

public class Run implements  Runnable{
    @Override
    public void run() {
        Assignment8 assignment8 = new Assignment8();
        List<Integer> numberList = assignment8.getNumbers();
        System.out.println(numberList);
    }
}
