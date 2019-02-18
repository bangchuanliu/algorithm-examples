package difficulty.easy;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageofLevelsinBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> nodesList = new ArrayList<>();

        Queue<TreeNode> nodesQ = new LinkedList<TreeNode>();
        nodesQ.offer(root);

        while (!nodesQ.isEmpty()) {
            List<Integer> curList = new ArrayList<>();
            int size = nodesQ.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = nodesQ.poll();
                sum += node.val;
                if (node.left != null) {
                    nodesQ.offer(node.left);
                }

                if (node.right != null) {
                    nodesQ.offer(node.right);
                }
            }
            
            nodesList.add((double)sum / size);
        }
        return nodesList;
    }
}
