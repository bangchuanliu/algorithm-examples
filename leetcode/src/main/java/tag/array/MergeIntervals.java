package tag.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import common.Interval;

public class MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> mergedIntervals = new ArrayList<>();

        Collections.sort(intervals, (i1, i2) -> i1.start - i2.start);

        Interval pre = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (interval.start <= pre.end) {
                pre = new Interval(pre.start, Math.max(interval.end, pre.end));
            } else {
                mergedIntervals.add(pre);
                pre = interval;
            }
        }

        mergedIntervals.add(pre);

        return mergedIntervals;
    }
}
