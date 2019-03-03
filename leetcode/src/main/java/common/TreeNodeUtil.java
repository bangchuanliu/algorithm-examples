package common;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNodeUtil {

    public static TreeNode creatTree(Integer[] nums) {
        return creatTree(nums, 0);
    }


    private static TreeNode creatTree(Integer[] nums, int i) {
        if (i >= nums.length) {
            return null;
        }
        if (nums[i] == null) {
            return null;
        }
        TreeNode node = new TreeNode(nums[i]);
        node.left = creatTree(nums, 2 * i + 1);
        node.right = creatTree(nums, 2 * i + 2);
        return node;
    }
    
    public static void printTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ((LinkedList<TreeNode>) queue).add(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    System.out.print(node.val + " ");
                    ((LinkedList<TreeNode>) queue).add(node.left);
                    ((LinkedList<TreeNode>) queue).add(node.right);
                } else {
                    System.out.print("null" + " ");    
                }
            }
            System.out.println();
        }
    }

    public static void printTreePreOrder(TreeNode root, List<Integer> result) {
        if (root == null) {
            result.add(null);
            return;
        }        
        result.add(root.val);
        printTreePreOrder(root.left, result);
        printTreePreOrder(root.right, result);
    }

    public static void PrintInorder(TreeNode root) {
        if (root == null) {
            return;
        }
        
        PrintInorder(root.left);
        System.out.print(root.val + " ");
        PrintInorder(root.right);
    }
}
