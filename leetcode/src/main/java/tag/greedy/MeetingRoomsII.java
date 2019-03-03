package tag.greedy;

import common.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MeetingRoomsII {

    public int minMeetingRooms(Interval[] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> a.start == b.start ? a.end - b.end : a.start - b.start);

        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> a - b);
        q.add(intervals[0].end);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= q.peek()) {
                q.poll();
            }
            q.add(intervals[i].end);
        }

        return q.size();
    }
    
    
    public int minMeetingRooms2(Interval[] intervals) {
        Arrays.sort(intervals, (a, b) -> a.start == b.start ? a.end - b.end : a.start - b.start);

        List<List<Interval>> rooms = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            if (rooms.isEmpty()) {
                List<Interval> list = new ArrayList<>();
                list.add(intervals[i]);
                rooms.add(list);
            } else {
                boolean isNewRoom = true;
                for (List<Interval> ins : rooms) {
                    Interval last = ins.get(ins.size() - 1);
                    if (last.end <= intervals[i].start) {
                        ins.add(intervals[i]);
                        isNewRoom = false;
                        break;
                    }
                }

                if (isNewRoom) {
                    List<Interval> list = new ArrayList<>();
                    list.add(intervals[i]);
                    rooms.add(list);
                }
            }
        }

        return rooms.size();
    }
    
    public static void main(String[] args) {
        MeetingRoomsII meetingRoomsII = new MeetingRoomsII();
        
        int[][] nums = {{1293,2986},{848,3846},{4284,5907},{4466,4781},{518,2918},{300,5870}};
        Interval[] intervals = new Interval[nums.length];
        int i = 0;
        for (int[] x : nums) {
            Interval interval = new Interval();
            interval.start = x[0];
            interval.end = x[1];
            intervals[i++] = interval;
        }
        
        
        System.out.println(meetingRoomsII.minMeetingRooms(intervals));
    }
}
