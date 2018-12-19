package graph.assignment3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class MedianMaintenance {

    public static int median(int[] a) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            maxHeap.add(a[i]);
            minHeap.add(maxHeap.poll());
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            }

//            System.out.println("median : " + maxHeap.peek());
            sum += maxHeap.peek();
        }

        return sum % a.length;
    }

    public static void main(String[] args) throws IOException {
        String path = "/Users/b0l00ev/Documents/personal/data/Median.txt";
        List<String> list = Files.lines(Paths.get(path)).filter(str -> str.length() > 0).collect(Collectors.toList());
        int[] nums = new int[list.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(list.get(i));
        }
//        int[] a = {1, 2, 3, 4, 5, 6};
//        int[] b = {6, 5, 4, 3, 2, 1};

        System.out.println(median(nums));
//        System.out.println(median(b));
    }
}
