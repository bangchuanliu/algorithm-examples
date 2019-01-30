package tag.map;

import java.util.TreeSet;

public class ExamRoom {

    TreeSet<Integer> assigned = new TreeSet<>();
    int N = 0;

    public ExamRoom(int N) {
        this.N = N;
    }

    public int seat() {
        int student = 0;
        if (!assigned.isEmpty()) {
            int dist = assigned.first();
            int cur = dist;
            while (assigned.higher(cur) != null) {
                int next = assigned.higher(cur);
                if ((next - cur) / 2 > dist) {
                    dist = (next - cur) / 2;
                    student = cur + (next - cur) / 2;
                }
            }
            
            if (N - 1 - assigned.last() > dist) {
                student = N - 1;
            }
        }
        assigned.add(student);
        return student;
    }

    public void leave(int p) {
        assigned.remove(p);
    }
}
