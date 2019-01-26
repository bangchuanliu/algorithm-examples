package company.airbnb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeFreeTime {

    public static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();
        List<Integer> starts = new ArrayList<>();
        List<Integer> ends = new ArrayList<>();

        for (List<Interval> intervals : schedule) {
            for (Interval interval : intervals) {
                starts.add(interval.start);
                ends.add(interval.end);
            }
        }
        Collections.sort(starts);
        Collections.sort(ends);
        int i = 0;
        
        while (i < ends.size()) {
            int start = ends.get(i);
            int j = i;
            while (j < starts.size() && starts.get(j) < start) {
                j++;
            }
            if (j < starts.size() && starts.get(j) > start && starts.get(j) > ends.get(j - 1)) {
                result.add(new Interval(ends.get(j - 1), starts.get(j)));
            }
            i = j;
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Interval>> schedule = new ArrayList<>();
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 3));
        list.add(new Interval(6, 7));
        List<Interval> list2 = new ArrayList<>();
        list2.add(new Interval(2, 4));
        List<Interval> list3 = new ArrayList<>();
        list3.add(new Interval(2, 7));
        list3.add(new Interval(9, 12));
        schedule.add(list);
        schedule.add(list2);
        schedule.add(list3);

        List<Interval> result = employeeFreeTime(schedule);
        for (Interval in : result) {
            System.out.println(in.start + "," + in.end);
        }
    }
}


class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}
 