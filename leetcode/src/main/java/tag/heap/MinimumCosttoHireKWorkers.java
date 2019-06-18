package tag.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumCosttoHireKWorkers {

    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {

        Worker[] workers = new Worker[wage.length];

        for (int i = 0; i < wage.length; i++) {
            workers[i] = new Worker(quality[i], wage[i]);
        }

        Arrays.sort(workers);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int sumq = 0;
        double result = Integer.MAX_VALUE;

        for (int i = 0; i < workers.length; i++) {
            sumq += workers[i].q;
            pq.add(workers[i].q);

            if (pq.size() > K) {
                sumq -= pq.poll();
            }

            if (pq.size() == K) {
                result = Math.min(result, sumq * workers[i].ratio());
            }
        }

        return result;
    }
}


class Worker implements Comparable<Worker> {
    int q;
    int w;

    Worker(int q, int w) {
        this.q = q;
        this.w = w;
    }

    public double ratio() {
        return (double) w / q;
    }


    public int compareTo(Worker other) {
        return Double.compare(ratio(), other.ratio());
    }
}
