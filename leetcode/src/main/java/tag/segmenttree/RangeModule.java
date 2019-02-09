package tag.segmenttree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class RangeModule {

    TreeSet<Interval> ranges;

    public RangeModule() {
        ranges = new TreeSet<>();
    }

    public void addRange(int left, int right) {
        Iterator<Interval> intervals = ranges.tailSet(new Interval(0, left)).iterator();
        while (intervals.hasNext()) {
            Interval ite = intervals.next();
            if (ite.left > right) {
                break;
            }
            left = Math.min(left, ite.left);
            right = Math.max(right, ite.right);
            intervals.remove();
        }
        ranges.add(new Interval(left, right));
    }

    public boolean queryRange(int left, int right) {
        Interval interval = ranges.higher(new Interval(0, left));
        return interval != null && interval.left <= left && interval.right >= right;
    }

    public void removeRange(int left, int right) {
        Iterator<Interval> intervals = ranges.tailSet(new Interval(0, left)).iterator();
        List<Interval> list = new ArrayList<>();
        while (intervals.hasNext()) {
            Interval ite = intervals.next();
            if (right < ite.left) {
                break;
            }
            if (left > ite.left) {
                list.add(new Interval(ite.left, left));
            }
            if (right < ite.right) {
                list.add(new Interval(right, ite.right));
            }
            intervals.remove();
        }
        list.forEach(interval -> ranges.add(interval));
    }

    class Interval implements Comparable<Interval> {

        int left;
        int right;

        Interval(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Interval o) {
            return this.right == o.right ? this.left - o.left : this.right - o.right;
        }
    }

    public static void main(String[] args) {
        RangeModule rangeModule = new RangeModule();
        rangeModule.addRange(6, 8);
        rangeModule.removeRange(7, 8);
        rangeModule.removeRange(8, 9);
        rangeModule.addRange(8, 9);
        rangeModule.removeRange(1, 3);
        rangeModule.addRange(1, 8);
        System.out.println(rangeModule.queryRange(2, 4));
        System.out.println(rangeModule.queryRange(2, 9));
        System.out.println(rangeModule.queryRange(4, 6));
    }
}
