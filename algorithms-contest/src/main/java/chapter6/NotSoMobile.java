package chapter6;

import java.util.Deque;
import java.util.LinkedList;

public class NotSoMobile {

    public static void main(String[] args) {
        Deque<int[]> q = new LinkedList<>();
        int[] n = {1,2,3,4};
        
//        int[] n1 = {0,2,0,4};
//        int[] n2 = {0,3,0,1};
//        int[] n3 = {1,1,1,1};
//        int[] n4 = {2,4,4,2};
//        int[] n5 = {1,6,3,2};
//        q.add(n1);
//        q.add(n2);
//        q.add(n3);
//        q.add(n4);
//        q.add(n5);
        q.add(n);
        isBalance(q);
        
        System.out.println(balance);
    }
    
    static boolean balance = true;
    
    public static int isBalance(Deque<int[]> q){
        if (!balance || q.isEmpty()) {
            return 0;
        }
        
        int[] root = q.poll();
        
        if (root[0] != 0) {
            if (root[0] * root[1] != root[2]* root[3]){
                balance = false;
            }
            return root[0] + root[2];
        }
        
        int left = isBalance(q);
        int right = isBalance(q);
        
        if (root[1] * left != root[3] * right){
            balance = false;
        }
        return left + right;
    }
    
    public static boolean isBalance(int[] w, Deque<int[]> q){
        int[] root = q.poll();
        boolean left = true;
        boolean right = true;
        if (root[0] == 0) {
            left = isBalance(w, q);
        }
        if (root[2] == 0){
            right = isBalance(w,q);
        }
        w[0] = root[0] + root[2];
        return left && right && (root[0] * root[1] == root[2] * root[3]);
    }
    
}
