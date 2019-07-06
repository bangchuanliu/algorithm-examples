package chapter3;

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
                    System.out.println(i + "\n" + j + "\n" + x + "\n" + y + "\n" + z);
                }
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println(printFormula("13578"));
    }
    
}
