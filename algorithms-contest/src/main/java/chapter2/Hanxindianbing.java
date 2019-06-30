package chapter2;

public class Hanxindianbing {

    public static int findDaffodil(int a, int b, int c) {
        for (int i = 10; i <= 100; i++) {
            if (i % 3 == a && i % 5 == b && i % 7 == c) {
                return i;
            } 
        }
        
        return -1;
    }


    public static void main(String[] args) {
        System.out.println(findDaffodil(2,1,6));
        System.out.println(findDaffodil(2,1,3));
    }
}
