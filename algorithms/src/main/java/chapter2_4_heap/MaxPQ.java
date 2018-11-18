package chapter2_4_heap;

public class MaxPQ {
    private int[] pq;
    private int N = 0;

    public MaxPQ(int size) {
        pq = new int[size + 1];
    }

    public void insert(int v) {
        pq[++N] = v;
        swim(N);
    }

    public int delMax() {
        int v = pq[1];
        exch(1, N--);
        pq[N + 1] = 0;
        return v;
    }

    public void swim(int k) {
        while (k > 1 && pq[k] > pq[k / 2]) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    public void sink(int k) {
        while (k * 2 <= N) {
            int j = k * 2;
            if (j < N && pq[j] < pq[j + 1]) {
                j++;
            }
            if (pq[k] >= pq[j]) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    public void exch(int i, int j) {
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }
}
