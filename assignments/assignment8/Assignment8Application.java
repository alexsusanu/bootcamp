import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Assignment8Application {
    public static void main(String[] args) {
        Assignment8 assignment8 = new Assignment8();
        List<Integer> allNumbers = Collections.synchronizedList(new ArrayList<>(1000));
        ExecutorService executor = Executors.newCachedThreadPool();
        List<CompletableFuture<Void>> tasks = new ArrayList<>(1000);

        for (int i = 0; i < 1000; i++){
            CompletableFuture<Void> task = CompletableFuture.supplyAsync(() -> assignment8.getNumbers(), executor)
                                                            .thenAccept(numbers -> allNumbers.addAll(numbers));
            tasks.add(task);
        }

        while (tasks.stream().filter(CompletableFuture::isDone).count() < 1000) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}
        }

        Map<Integer, Integer> output = new HashMap<>();
        allNumbers.stream()
                  .forEach(number -> {
                      if (!output.containsKey(number)){
                          output.put(number, 1);
                      }else {
                          output.put(number, output.get(number) + 1);
                      }
                  });
        System.out.println(output);
    }
}
