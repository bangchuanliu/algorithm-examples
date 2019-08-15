package chapter3.example;

public class VerticalFormula {

    public static int printFormula(String input) {
        int count = 0;
        
        for (int i = 100; i < 1000; i++) {
            for (int j = 10; j < 100; j++) {
                int x = i * (j % 10);
                int y = i * (j / 10);
                int z = i * j;
                
                String str = i + "" + j + "" + x + "" + y + "" + z;
                boolean flag = true;
                
                for(char c : str.toCharArray()) {
                    if (input.indexOf(c) < 0) {
                        flag = false;
                    }
                }
                
                if (flag) {
                    count++;
                    System.out.println(String.format("%5d\nX%4d\n-----\n%5d\n%4d\n-----\n%5d\n\n", i, j, x, y, z));
                }
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println(printFormula("2357"));
    }
    
}
