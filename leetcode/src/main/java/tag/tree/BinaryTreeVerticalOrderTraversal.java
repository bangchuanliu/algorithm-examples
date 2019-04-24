package tag.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BinaryTreeVerticalOrderTraversal {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        Map<TreeNode, Integer> offsets = new HashMap<>();
        offsets.put(root, 0);
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode node = q.poll();

            List<Integer> list = map.getOrDefault(offsets.get(node), new ArrayList<>());
            list.add(node.val);
            map.put(offsets.get(node), list);

            if (node.left != null) {
                q.add(node.left);
                offsets.put(node.left, offsets.get(node)-1);
            }
            if (node.right != null) {
                q.add(node.right);
                offsets.put(node.right, offsets.get(node)+1);
            }
        }

        return new ArrayList<>(map.values());
    }
}
