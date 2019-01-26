package company.airbnb;

import java.util.ArrayList;
import java.util.List;

public class IPTOCIDR {
    
    public List<String> ipToCIDR(String ip, int n) {
        List<String> result = new ArrayList<>();
        ipToCIDR(ip, n, result);
        return result;
    }
    
    public void ipToCIDR(String ip, int n, List<String> result) {
        if (n <= 0) {
            return;
        }
        String[] ips = ip.split("\\.");
        String block4 = Integer.toBinaryString(Integer.parseInt(ips[3]));
        int count = 0;
        int i = block4.length() - 1;
        while (i >= 0 && block4.charAt(i) != '1' && Math.pow(2,count) <= n) {
            i--;
            count++;
        }
        
        
    }
}
