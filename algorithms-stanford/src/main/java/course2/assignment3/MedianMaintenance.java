package course2.assignment3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class MedianMaintenance {

    public static int median(int[] a) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> (o1 - o2));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> (o2 - o1));

        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            maxHeap.add(a[i]);
            minHeap.add(maxHeap.poll());
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            }

            sum += maxHeap.peek();
        }

        return sum % a.length;
    }

    public static void main(String[] args) throws IOException {
        String path = MedianMaintenance.class.getClassLoader().getResource("course2/assignment3/data/Median.txt").getPath();
        int[] nums = Files.lines(Paths.get(path)).mapToInt(line -> Integer.parseInt(line)).toArray();
        System.out.println(median(nums));
    }
}
