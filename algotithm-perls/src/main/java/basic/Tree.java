package basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Tree {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        TreeNode root = createTree(nums);
        inOrder(root);
    }

    public static void inOrder(TreeNode root){
        if (root == null){
            return;
        }
        
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();
        while (p != null || !stack.isEmpty()){
            while (p != null){
                stack.push(p);
                p = p.left;
            }
            TreeNode node = stack.pop();
            System.out.println(node.value);
            p = node.right;
        }
    }
    
    public static void preOrder(TreeNode root){
        if (root == null){
            return;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            System.out.println(node.value);
            if (node.right != null){
                stack.push(node.right);
            }
            if (node.left != null){
                stack.push(node.left);
            }
        }
    }

    public static void printTree(TreeNode root){
        if (root == null){
            return;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++){
                TreeNode node = q.poll();
                System.out.print(node.value);
                if (node.left != null){
                    q.add(node.left);
                }
                
                if (node.right != null){
                    q.add(node.right);
                }
            }
            System.out.println();
        }
    }

    public static TreeNode createTree(int[] nums){
        return createTree(nums, 0);
    }

    public static TreeNode createTree(int[] nums, int index){
        if (index >= nums.length){
            return null;
        }

        TreeNode node = new TreeNode(nums[index]);
        TreeNode left = createTree(nums, 2* index + 1);
        TreeNode right = createTree(nums, 2 * index + 2);
        node.left = left;
        node.right = right;
        return node;
    }
}

class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int value) {
        this.value = value;
    }
}