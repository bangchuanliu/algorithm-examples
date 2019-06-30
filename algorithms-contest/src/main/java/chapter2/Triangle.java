package chapter2;

public class Triangle {

    public static void printReverseTriangle(int layer) {
        if (layer <= 0) {
            return;
        }
        
        int num = 2 * layer - 1;
        
        for (int i = 0; i < layer; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");    
            }
            for (int j = 0; j < num; j++) {
                System.out.print("#");    
            }
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            num -= 2;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printReverseTriangle(1);
        printReverseTriangle(2);
        printReverseTriangle(3);
        printReverseTriangle(4);
        printReverseTriangle(5);
        printReverseTriangle(6);
    }
}
