package divideandconquer;

public class Util {
    
    public static void main(String[] args) {
        String a = "3141592653589793238462643383279502884197169399375105820974944592";
        String b = "2718281828459045235360287471352662497757247093699959574966967627";
        
        for (int i = 0 ; i < a.length(); i++) {
            System.out.print(a.charAt(i) + ",");
        }
        System.out.println();
        for (int i = 0 ; i < b.length(); i++) {
            System.out.print(b.charAt(i) + ",");
        }
    }
}
