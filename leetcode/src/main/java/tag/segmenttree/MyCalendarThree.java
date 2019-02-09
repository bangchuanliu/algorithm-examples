package tag.segmenttree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class MyCalendarThree {

    List<TreeSet<Interval>> list;

    public MyCalendarThree() {
        list = new ArrayList<>();
    }

    public int book(int start, int end) {
        for (int i = 0; i < list.size(); i++) {
            TreeSet<Interval> set = list.get(i);
            if (set.contains(new Interval(start, end))) {
                return list.size();
            }
            Interval lower = set.lower(new Interval(start, end));
            Interval higher = set.higher(new Interval(start, end));
            if ((lower == null || lower.right <= start)
                    && (higher == null || higher.left >= end)) {
                set.add(new Interval(start, end));
                return list.size();
            }
        }

        TreeSet<Interval> set = new TreeSet<>();
        set.add(new Interval(start, end));
        list.add(set);
        return list.size();
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
            return this.left == o.left ? this.right - o.right : this.left - o.left;
        }
    }

    public static void main(String[] args) {
        // 1,1,1,1,1,2,2,2,3,3,3,4,5,5,5,5,5,5,6,6,6,6,6,6,7,7,7,7,7,7
        // 1,1,1,1,1,2,2,2,3,3,3,4,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,6,6,6
        MyCalendarThree myCalendarThree = new MyCalendarThree();
        int[][] nums = {{47,50},{1,10},{27,36},{40,47},{20,27},{15,23},{10,18},{27,36},{17,25},{8,17},{24,33},{23,28},{21,27},{47,50},{14,21},{26,32},{16,21},{2,7},{24,33},{6,13},{44,50},{33,39},{30,36},{6,15},{21,27},{49,50},{38,45},{4,12},{46,50},{13,21}};
        System.out.println(Arrays.toString(nums[18]));
        for (int[] num : nums) {
            int size = myCalendarThree.book(num[0], num[1]);
            System.out.print(size + ",");    
        }
    }

}
