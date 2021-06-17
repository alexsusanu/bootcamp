import com.coderscampus.assignment.Assignment8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main{
    public static void main(String[] args) {
        Assignment8 assignment8 = new Assignment8();
        List<Integer> allNumbers = new ArrayList<>();
        ExecutorService executorService = Executors.newCachedThreadPool();

        for(int i = 0; i < 1000; i++){
            CompletableFuture.supplyAsync(() -> assignment8.getNumbers(), executorService)
                             .thenAccept(numbers -> allNumbers.addAll(numbers));
        }
    }
}
