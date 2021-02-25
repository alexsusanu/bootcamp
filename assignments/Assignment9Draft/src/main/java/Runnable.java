import java.io.IOException;
import java.util.List;

public class Runnable {
    public static void main(String[] args) throws IOException {
        FileService fileService = new FileService();
        List<Recipe> recipe = fileService.readFile();

        for (Recipe r : recipe) System.out.println(r);
    }
}
