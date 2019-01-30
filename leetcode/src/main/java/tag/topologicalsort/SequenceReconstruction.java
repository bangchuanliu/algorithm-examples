package tag.topologicalsort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SequenceReconstruction {

    public static boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Queue<Integer> courses = new LinkedList<>();
        int[] degrees = new int[org.length+1];

        for (List<Integer> list : seqs) {
            for (int i = list.size() - 1; i > 0; i--) {
                if (list.get(i) <= org.length && list.get(i) > 0) {
                    degrees[list.get(i)]++;    
                }
            }
        }

        for (int i = 1; i < degrees.length; i++) {
            if (degrees[i] == 0) {
                courses.add(i);
            }
        }

        int num = 0;

        while (!courses.isEmpty()) {
            int size = courses.size();
            if (size > 1) {
                return false;
            }
            int course = courses.poll();
            num++;
            for (List<Integer> list : seqs) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) == course && i != list.size() - 1 && list.get(i+1) <= org.length && list.get(i+1) > 0) {
                        degrees[list.get(i + 1)]--;
                        if (degrees[list.get(i + 1)] == 0) {
                            courses.add(list.get(i + 1));
                        }
                    }
                }
            }
        }

        return num == org.length;
    }
    
    public static void main(String[] args) {
        int[] org = {5,3,2,4,1};
        int[][] seqs = {{5,3,2,4},{4,1},{1},{3},{2,4},{1,1000000000}};
        List<List<Integer>> data = new ArrayList<>();
        for (int i = 0; i < seqs.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < seqs[i].length; j++) {
                list.add(seqs[i][j]);
            }
            data.add(list);
        }
        
       System.out.println(sequenceReconstruction(org, data)); 
    }
}
