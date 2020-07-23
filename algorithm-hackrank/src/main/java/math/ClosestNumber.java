package math;

import java.io.*;

/**
 * Hello world!
 */
public class ClosestNumber {
    public static int closestNumber(int a, int b, int x) {
//        long d = (int) Math.pow(a, b) + x / 2;
//        return (int)(d - (d % x));
        double c = Math.pow(a, b);
        int high = (int)Math.ceil(c / x) * x;
        int low = (int)Math.floor(c / x) * x;
        
        return (high - c < c - low) ? high : low;
        
    }


    public static void main(String[] args) throws IOException {
//        String file = ClosestNumber.class.getClassLoader().getResource("1").getFile();
//        BufferedReader bufferedWriter = new BufferedReader(new FileReader(new File(file)));
//
//        String line = "";
//        
//        while ((line = bufferedWriter.readLine()) != null) {
//            int a = Integer.parseInt(line.split(" ")[0]);
//            int b = Integer.parseInt(line.split(" ")[1]);
//            int x = Integer.parseInt(line.split(" ")[2]);
//            System.out.println(closestNumber(a, b, x));
//        }
        



        
        System.out.println(closestNumber(653379374, 1, 3));
//        System.out.println(closestNumber(395, 1, 7));
//        System.out.println(closestNumber(4, -2, 2));
//        System.out.println(closestNumber(717, -1, 264095061));
    }
}
