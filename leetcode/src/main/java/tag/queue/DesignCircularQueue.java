package tag.queue;

public class DesignCircularQueue {
    
    int[] nums;
    int head;
    int tail;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public DesignCircularQueue(int k) {
        nums = new int[k];
        head = -1;
        tail = -1;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        tail = (tail + 1) % nums.length;
        nums[tail] = value;
        if (head == -1) {
            head++;
        }
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        nums[head] = 0;
        if (head == tail) {
            head = -1;
            tail = -1;
        } else {
            head = (head + 1) % nums.length;
        }
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return nums[head];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return nums[tail];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return head == -1 || tail == -1;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return head == (tail + 1) % nums.length;
    }
}
