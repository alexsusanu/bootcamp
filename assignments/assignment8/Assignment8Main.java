import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Assignment8Main{
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Run run = new Run();
            new Thread(run).start();
        }
    }
}