package tag.greedy;

import common.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MeetingRoomsII {

    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Integer> q = new PriorityQueue<>();

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        for (int i = 0; i < intervals.length; i++) {
            if (!q.isEmpty() && intervals[i][0] >= q.peek()) {
                q.poll();
            }

            q.add(intervals[i][1]);
        }

        return q.size();
    }


    public int minMeetingRooms2(Interval[] intervals) {
        List<Interval> rooms = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> (a.start - b.start));

        for (int i = 0; i < intervals.length; i++) {
            int j = 0;
            while (j < rooms.size()) {
                if (intervals[i].start >= rooms.get(j).end) {
                    rooms.set(j, intervals[i]);
                    break;
                }
                j++;
            }
            if (j == rooms.size()) {
                rooms.add(intervals[i]);
            }
        }

        return rooms.size();
    }

    public static void main(String[] args) {
        MeetingRoomsII meetingRoomsII = new MeetingRoomsII();

        int[][] nums = {{1293, 2986}, {848, 3846}, {4284, 5907}, {4466, 4781}, {518, 2918}, {300, 5870}};
        Interval[] intervals = new Interval[nums.length];
        int i = 0;
        for (int[] x : nums) {
            Interval interval = new Interval();
            interval.start = x[0];
            interval.end = x[1];
            intervals[i++] = interval;
        }


    //    System.out.println(meetingRoomsII.minMeetingRooms(intervals));
    }
}
