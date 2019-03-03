package tag.greedy;

import common.Interval;

import java.util.Arrays;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> a.start == b.start ? a.end - b.end : a.start - b.start);
        Interval pre = intervals[0];
        int result = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < pre.end) {
                if (intervals[i].end < pre.end) {
                    pre = intervals[i];
                }
                result++;
            } else {
                pre = intervals[i];
            }
        }

        return result;
    }
}
