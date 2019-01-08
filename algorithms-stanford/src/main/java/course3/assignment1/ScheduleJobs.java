package course3.assignment1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class ScheduleJobs {

    static class JobNode {
        private int weight;
        private int length;

        JobNode(int weight, int length) {
            this.weight = weight;
            this.length = length;
        }
    }

    public static PriorityQueue<JobNode> maxHeapByRatio () {
        PriorityQueue<JobNode> maxHeap = new PriorityQueue<>((o1, o2) -> o2.weight * o1.length - o1.weight * o2.length);
        return maxHeap;
    }
    
    public static PriorityQueue<JobNode> maxHeapByDiff () {
        PriorityQueue<JobNode> maxHeap = new PriorityQueue<>((o1, o2) -> o2.weight - o2.length == o1.weight - o1.length ? o2.weight - o1.weight : o2.weight - o2.length - o1.weight + o1.length);
        return maxHeap;
    }

    public static long completeTime(JobNode[] jobs, PriorityQueue<JobNode> maxHeap) {
        for (int i = 0; i < jobs.length; i++) {
            maxHeap.add(jobs[i]);
        }
        long sum = 0;
        long len = 0;
        while (!maxHeap.isEmpty()) {
            JobNode job = maxHeap.poll();
            len += job.length;
            sum += job.weight * len;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        String path = ScheduleJobs.class.getClassLoader().getResource("course3/assignment1/data/jobs.txt").getPath();
        List<String> list = Files.lines(Paths.get(path)).filter(str -> str.length() > 0).collect(Collectors.toList());
        JobNode[] jobs = new JobNode[list.size() - 1];
        for (int i = 0; i < jobs.length; i++) {
            String line = list.get(i+1);
            String[] weightLen = line.split("\\s+");
            JobNode jobNode = new JobNode(Integer.parseInt(weightLen[0]), Integer.parseInt(weightLen[1]));
            jobs[i] = jobNode;
        }
        System.out.println(completeTime(jobs ,maxHeapByDiff()));
        System.out.println(completeTime(jobs ,maxHeapByRatio()));
    }
}
