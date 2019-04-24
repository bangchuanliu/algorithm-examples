package tag.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class RemoveNodeInList {
    
    public List<Integer> removeNode(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return null;
        }
        
        Set<Integer> result = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        result.add(root.val);
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                TreeNode left = node.left;
                TreeNode right = node.right;
                
                if (nums.contains(node.val)) {
                    if (left != null) {
                        result.add(node.left.val);
                    }
                    if (right != null) {
                        result.add(node.right.val);
                    }
                    result.remove(node.val);
                }
                
                if (left != null) {
                    q.add(left);
                }

                if (right != null) {
                    q.add(right);
                }
            }
        }
        
        return new ArrayList<>(result);
    } 
    
    
    
    
    
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        
        n3.left = n6;
        n3.right = n7;

        RemoveNodeInList removeNodeInList = new RemoveNodeInList();
        Integer[] nums = {4,6};
        System.out.println(Arrays.toString(removeNodeInList.removeNode(n1,Arrays.asList(nums)).toArray()));
    }
}
