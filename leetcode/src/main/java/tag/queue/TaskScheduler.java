package tag.queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        int[] map = new int[26];
        for (char ch : tasks) {
            map[ch - 'A']++;
        }
        int count = 0;
        for (int num : map) {
            if (num > 0) {
                pq.add(num);
            }
        }
        
        while (!pq.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int k = n + 1;
            while (k > 0 && !pq.isEmpty()) {
                int fre = pq.poll();
                fre--;
                if (fre >0) {
                    temp.add(fre);
                }
                count++;
                k--;
            }
            for (Integer num: temp) {
                pq.add(num);
            }
            if (pq.isEmpty()) break;
            count += k;
        }

        return count;
    }


    public int leastInterval2(char[] tasks, int n) {
        int[] count = new int[26];
        
        for (char c : tasks) {
            count[c - 'A']++;
        }

        Arrays.sort(count);
        int idles = (count[25] - 1) * n;
        
        
        for (int i = 24; i >=0 && count[i] > 0; i--) {
            idles = idles - Math.min(count[i], count[25]-1);
        }
        
        return idles > 0? idles+tasks.length : tasks.length;
    }

    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B','C','C','C','D','D','D'};
        TaskScheduler scheduler = new TaskScheduler();
        System.out.println(scheduler.leastInterval(tasks,2));
        System.out.println(scheduler.leastInterval2(tasks,2));
    }
}
