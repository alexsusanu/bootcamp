import java.io.IOException;
import java.util.List;

public class Runnable {
    public static void main(String[] args) throws IOException {
        FileService fileService = new FileService();
        List<Recipe> recipe = fileService.readFile();

        List<Recipe> recipeList = fileService.xFree(recipe);
        for (Recipe r : recipeList){
            System.out.println(r);
        }
    }
}
