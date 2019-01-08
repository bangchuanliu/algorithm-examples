package leetcode.easy.heap;

import java.util.Comparator;
import java.util.PriorityQueue;


/**
 * 
 * 
 * @author bliu13
 * Dec 9, 2015
 */
public class FindMedianfromDataStream {
	
	private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
		public int compare(Integer a, Integer b) {
			return a - b;
		}
	});
	
	private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
		public int compare(Integer a, Integer b) {
			return b - a;
		}
	});
	
	public void addNum(int num) {
		maxHeap.offer(num);
		minHeap.offer(maxHeap.poll());
		if (maxHeap.size() < minHeap.size()) {
			maxHeap.offer(minHeap.poll());
		}
	}

	// Returns the median of current data stream
	public double findMedian() {
		if (minHeap.size() == maxHeap.size()) {
			return (minHeap.peek() + maxHeap.peek()) / 2.0;
		} else {
			return maxHeap.peek();
		}
	}
	
	public static void main(String[] args) {
		FindMedianfromDataStream instance = new FindMedianfromDataStream();
		instance.addNum(2);
		System.out.println(instance.findMedian());
		instance.addNum(3);
		System.out.println(instance.findMedian());
	}
}
