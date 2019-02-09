package tag.queue;

public class MyCircularQueue {
    int[] q;
    int first = -1;
    int last = -1;
    int k;

    public MyCircularQueue(int k) {
        q = new int[k];
        this.k = k;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        last = (last + 1) % k;
        q[last] = value;
        if (first == -1) {
            first = last;
        }
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (first == last) {
            first = -1;
            last = -1;
            return true;
        }
        first = (first + 1) % k;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return q[first];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return q[last];
    }

    public boolean isEmpty() {
        return first == -1 && last == -1;
    }

    public boolean isFull() {
        return (last + 1) % q.length == first;
    }

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        myCircularQueue.enQueue(1);
        myCircularQueue.enQueue(2);
        myCircularQueue.enQueue(3);
        myCircularQueue.enQueue(4);
        System.out.println(myCircularQueue.Rear());
        System.out.println(myCircularQueue.isFull());
        myCircularQueue.deQueue();
        myCircularQueue.enQueue(4);
        System.out.println(myCircularQueue.Rear());
    }
}
