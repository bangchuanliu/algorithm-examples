package tag.queue;

import java.util.ArrayList;
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

    public static void main(String[] args) {
        char[] tasks = {'A','A','A','A','A','A','B','C','D','E','F','G'};
        TaskScheduler scheduler = new TaskScheduler();
        System.out.println(scheduler.leastInterval(tasks,2));
    }
}
