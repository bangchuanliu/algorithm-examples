package tag.design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZigzagIterator {
    
    int index1;
    int index2;
    List<Integer> v1;
    List<Integer> v2;
    
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1 = v1 == null ? new ArrayList<>() : v1;
        this.v2 = v2 == null ? new ArrayList<>() : v2;
    }

    public int next() {
        if (hasNext()) {
            if (index1 >= v1.size()) {
                return v2.get(index2++);
            }
            if (index2 >= v2.size()) {
                return v1.get(index1++);
            }
            
            if (index1 == index2) {
                return v1.get(index1++);
            } else {
                return v2.get(index2++);
            }
        }
        
        return -1;
    }

    public boolean hasNext() {
        return index1 < v1.size() || index2 < v2.size();
    }

    public static void main(String[] args){
        Integer[] num1 = {1,2};
        Integer[] num2 = {3,4,5,6};
        List<Integer> v1 = new ArrayList<>(Arrays.asList(num1));
        List<Integer> v2 = new ArrayList<>(Arrays.asList(num2));
        ZigzagIterator zigzagIterator = new ZigzagIterator(v1, v2);
        while (zigzagIterator.hasNext()) {
            System.out.println(zigzagIterator.next());    
        }
    }
}
