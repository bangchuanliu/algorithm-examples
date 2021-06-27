package common;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class TreeHelper {

    public static TreeNode createTree(int[] nums) {
        return createTree(nums, 0);
    }

    private static TreeNode createTree(int[] nums, int i) {
        if (i >= nums.length) return null;

        TreeNode node = new TreeNode(nums[i]);
        node.left = createTree(nums, 2 * i + 1);
        node.right = createTree(nums, 2 * i + 2);
        
        return node;
    }
    
    public static void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    System.out.print(node.val + " ");
                    queue.add(node.left);
                    queue.add(node.right);
                } else {
                    System.out.print("null" + " ");    
                }
            }
            System.out.println();
        }
    }

    public static void preOrder(TreeNode root, List<Integer> result) {
        if (root == null) {
            result.add(null);
            return;
        }        
        result.add(root.val);
        preOrder(root.left, result);
        preOrder(root.right, result);
    }

    public static void inOrder(TreeNode root) {
        if (root == null) return;

        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
}
