package tag.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import common.Interval;

public class MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return result;
        }

        Collections.sort(intervals, (a, b) -> a.start == b.start ? a.end - b.end : a.start - b.start);

        Interval pre = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);

            if (pre.end >= cur.start) {
                pre = new Interval(pre.start, Math.max(cur.end, pre.end));
            } else {
                result.add(pre);
                pre = cur;
            }
        }
        result.add(pre);
        return result;
    }
}
