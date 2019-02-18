package difficulty.easy;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> nodesList = new ArrayList<>();

        if (root == null) {
            return nodesList;
        }

        Queue<TreeNode> nodesQ = new LinkedList<TreeNode>();
        nodesQ.offer(root);

        while (!nodesQ.isEmpty()) {
            List<Integer> curList = new ArrayList<>();
            int size = nodesQ.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodesQ.poll();
                curList.add(node.val);
                if (node.left != null) {
                    nodesQ.offer(node.left);
                }

                if (node.right != null) {
                    nodesQ.offer(node.right);
                }
            }
            nodesList.add(new ArrayList<>(curList));
        }
        Collections.reverse(nodesList);
        return nodesList;
    }
}
