package topk;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class IPCalculator {
    
    private ConcurrentHashMap<String, Map<String, Long>> map;
    
    public IPCalculator() {
        map = new ConcurrentHashMap<>();
    }
    
    public void addIp(String ip) {
        long cur = System.currentTimeMillis();
        
        String str = String.valueOf(cur).substring(0, 10);
        Map<String, Long> ipMap = map.getOrDefault(str, new HashMap<>());
        ipMap.put(ip, ipMap.getOrDefault(ip, 0L) + 1);
        map.put(str, ipMap);
        
        if (map.size() > 15) {
            ConcurrentHashMap<String, Map<String, Long>> newMap = new ConcurrentHashMap<>();
            for (int i = 1; i <= 15; i++) {
                String key = String.valueOf(cur - i * 1000).substring(0, 10);
                if (map.get(key) != null) {
                    newMap.put(str, map.get(key));
                }
            }
            
            map = newMap;
        }
    }
    
    
    public long[] getIPAccessCount(String ip) {
        long lastOneSecond = 0;
        long lastFiveSecond = 0L;
        long lastTenSecond = 0L;
        long lastFifteenSecond = 0L;
        
        long cur = System.currentTimeMillis();
        
        for (int i = 1; i <= 15; i++) {
            String str = String.valueOf(cur - i * 1000).substring(0, 10);
            long count = map.get(str) != null ? map.get(str).get(ip) : 0;
            lastFifteenSecond += count;

            if (i == 1) {
                lastOneSecond += count;
            }
            
            if (i <= 5) {
                lastFiveSecond += count;
            }

            if (i <= 10) {
                lastTenSecond += count;
            }
        }
        
        return new long[]{lastOneSecond, lastFiveSecond, lastTenSecond, lastFifteenSecond};        
    }
    
    public long[] getIPAccessCountByUser(String userId, String ip) {
        return null;
    }
}
