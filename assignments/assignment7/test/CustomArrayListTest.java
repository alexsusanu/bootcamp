import com.coderscampus.arraylist.CustomArrayList;
import com.coderscampus.arraylist.CustomList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomArrayListTest {
    @Test
    void should_add_one_item_to_list(){
       CustomList<Integer> customList = new CustomArrayList();
       customList.add(10);
       assertEquals(10, customList.get(0));
       assertEquals(1, customList.getSize());
    }

    @Test
    void should_add_to_index(){
        CustomList<Integer> customList = new CustomArrayList<>();
        customList.add(0, 10);
        customList.add(1, 20);
        assertEquals(10, customList.get(0));
        assertEquals(20, customList.get(1));
    }

    @Test
    void should_increase_size(){
        CustomList<Integer> customList = new CustomArrayList<>();
        //assertEquals(0, customList.getSize());

        customList.add(1);
        int size = customList.getSize();
        Object[] newArray = new Object[size * 2];
        assertEquals(2, newArray.length);
    }

    @Test
    void should_return_size(){
        CustomList<Integer> customList = new CustomArrayList<>();
        assertEquals(0, customList.getSize());

        customList.add(1);
        assertEquals(1, customList.getSize());
    }

    @Test
    void should_delete_item(){
        CustomList<Integer> customList = new CustomArrayList<>();
        customList.add(0, 10);
        customList.add(1, 20);
        customList.remove(1);

        assertEquals(20, customList.get(1));
    }

    @Test
    void should_get_item_from_index(){
        CustomList<Integer> customList = new CustomArrayList<>();
        customList.add(10);
        customList.add(20);

       assertEquals(10, customList.get(0));
    }
}
