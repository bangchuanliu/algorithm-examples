package leetcode.easy.arraystring;

import java.util.ArrayList;
import java.util.List;

import common.Interval;

public class InsertInterval {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> result = new ArrayList<>();
		if (intervals == null || newInterval == null) {
			return result;
		}

		for (Interval interval : intervals) {
			if (newInterval.start > interval.end) {
				result.add(interval);
			} else if (newInterval.end < interval.start) {
				result.add(newInterval);
				newInterval = interval;
			} else {
				newInterval = new Interval(Math.min(newInterval.start, interval.start),
						Math.max(newInterval.end, interval.end));
			}
		}

		result.add(newInterval);
		return result;
	}
}
