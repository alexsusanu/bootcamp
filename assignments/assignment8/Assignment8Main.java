public class Assignment8Main{
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Run run = new Run();
            new Thread(run).start();
        }
    }
}