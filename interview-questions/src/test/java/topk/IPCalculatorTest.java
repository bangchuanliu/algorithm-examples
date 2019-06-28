package topk;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class IPCalculatorTest {

    IPCalculator ipCalculator = new IPCalculator();
    Random ran = new Random();

    @Test
    public void testAddIp() throws InterruptedException {
        
        for (int i = 0; i < 10; i++) {
            String ip = "ip" + i;
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    ipCalculator.addIp(ip);
                    try {
                        Thread.sleep((long) ran.nextInt(1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }    
                }
            }).start();
        }
        Thread.sleep(20000);
        System.out.println(Arrays.toString(ipCalculator.getIPAccessCount("ip0")));
        System.out.println(Arrays.toString(ipCalculator.getIPAccessCount("ip1")));
        System.out.println(Arrays.toString(ipCalculator.getIPAccessCount("ip2")));
        System.out.println(Arrays.toString(ipCalculator.getIPAccessCount("ip3")));
        System.out.println(Arrays.toString(ipCalculator.getIPAccessCount("ip4")));
        System.out.println(Arrays.toString(ipCalculator.getIPAccessCount("ip5")));
    }
}
