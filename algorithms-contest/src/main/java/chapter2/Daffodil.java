package chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Daffodil {
    public static List<Integer> findDaffodil() {
        List<Integer> result = new ArrayList<>();

        for (int i = 100; i <= 999; i++) {
            int c = i % 10;
            int b = i / 10 % 10;
            int a = i / 100;

            if (a * a * a + b * b * b + c * c * c == i) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findDaffodil().toArray()));
    }
}
