package chapter3.homework;

public class Score {
    
    
    public static int score(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        
        int sum= 0;
        int count = 0;
        
        for (char c : input.toCharArray()) {
            if (c == 'O') {
                count++;
                sum += count;
            }else {
                count = 0;
            }
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
        System.out.println(score("OOXXOXXOOO"));
    }
}
