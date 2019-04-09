package tag.locked;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class ClosestBinarySearchTreeValueII {

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o2 - target) > Math.abs(o1 - target)) {
                    return 1;
                } else if (Math.abs(o1 - target) > Math.abs(o2 - target)) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        closestKValues(root, k, q);

        List<Integer> result = new ArrayList<>();

        while (!q.isEmpty()) {
            result.add(q.poll());
        }

        return result;

    }

    public void closestKValues(TreeNode root, int k, PriorityQueue<Integer> q) {
        if (root == null) {
            return;
        }

        closestKValues(root.left, k, q);
        q.add(root.val);
        if (q.size() > k) {
            q.poll();
        }
        closestKValues(root.right, k, q);
    }

    public List<Integer> closestKValues2(TreeNode root, double target, int k) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> pre = new Stack<>();
        Stack<TreeNode> succ = new Stack<>();

        TreeNode p = root;

        while (p != null) {
            if (p.val >= target) {
                succ.push(p);
                p = p.left;
            } else {
                pre.push(p);
                p = p.right;
            }
        }


        while (k > 0) {
            if (!pre.isEmpty() && !succ.isEmpty()) {
                if (Math.abs(pre.peek().val - target) < Math.abs(succ.peek().val - target)) {
                    result.add(getPre(pre));
                } else {
                    result.add(getSucc(succ));
                }
            } else if (!pre.isEmpty() && succ.isEmpty()) {
                result.add(getPre(pre));
            } else if (pre.isEmpty() && !succ.isEmpty()) {
                result.add(getSucc(succ));
            }
            k--;
        }

        return result;
    }


    public int getPre(Stack<TreeNode> pre) {
        TreeNode node = pre.pop();
        TreeNode p = node.left;
        while (p != null) {
            pre.push(p);
            p = p.right;
        }
        return node.val;
    }


    public int getSucc(Stack<TreeNode> succ) {
        TreeNode node = succ.pop();
        TreeNode right = node.right;
        while (right != null) {
            succ.push(right);
            right = right.left;
        }

        return node.val;
    }
}
