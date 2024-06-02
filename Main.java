
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> newList = new ArrayList<>();
        List<Integer> list = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        for (Integer x : list) {

            if (x > 0 && x % 2 == 0) {
                newList.add(x);
            }

        }
        Collections.sort(newList);
        System.out.println(newList);


    }
}