package tag.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import common.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        boolean f = false;
        while (!stack.isEmpty()) {
            Stack<TreeNode> temp = new Stack<>();
            List<Integer> list = new ArrayList<>();
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                list.add(node.val);
                if (f) {
                    if (node.right != null) {
                        temp.push(node.right);
                    }
                    if (node.left != null) {
                        temp.push(node.left);
                    }
                } else {
                    if (node.left != null) {
                        temp.push(node.left);
                    }
                    if (node.right != null) {
                        temp.push(node.right);
                    }
                }
            }
            stack = temp;
            f = !f;
            result.add(list);
        }

        return result;
    }

    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> temp = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (level % 2 == 0) {
                    temp.add(node.val);
                }else {
                    temp.addFirst(node.val);
                }

                if (node.left != null) {
                    q.add(node.left);
                }

                if (node.right != null) {
                    q.add(node.right);
                }
            }
            result.add(temp);
            level++;
        }

        return result;
    }
}
