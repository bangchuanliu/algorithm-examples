package multithreading;

import java.util.Random;

public class TwoThread {
    
    public static void main(String[] args) {
        Random ran = new Random();
        
        new Thread(() -> {
            for (int j = 0; j < 100; j++) {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep((long) ran.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            for (int j = 0; j < 100; j++) {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep((long) ran.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
