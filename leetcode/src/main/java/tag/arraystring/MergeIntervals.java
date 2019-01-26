package tag.arraystring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import common.Interval;

public class MergeIntervals {
	
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> mergedIntervals = new ArrayList<>();
		if (intervals == null || intervals.size() <= 1) {
			return intervals;
		}
		
		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval interval1, Interval interval2) {
				return interval1.start - interval2.start;
			}
		});
		
		int i = 1;
		Interval pre = intervals.get(0);
		while (i < intervals.size()) {
			Interval cur = intervals.get(i);
			
			if (pre.end >= cur.start) {
				Interval merged = new Interval(pre.start, Math.max(pre.end, cur.end));
				pre = merged;
			} else {
				mergedIntervals.add(pre);
				pre = cur;
			} 
			i++;
		}
		
		mergedIntervals.add(pre);
		
		return mergedIntervals;
	}
}
