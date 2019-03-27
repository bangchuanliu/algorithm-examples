package tag.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BinaryTreeVerticalOrderTraversal {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Map<TreeNode, Integer> cardinals = new HashMap<>();

        cardinals.put(root, 0);
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                List<Integer> list = map.getOrDefault(cardinals.get(node), new ArrayList<>());
                list.add(node.val);
                map.put(cardinals.get(node), list);

                if (node.left != null) {
                    queue.add(node.left);
                    cardinals.put(node.left, cardinals.get(node) - 1);
                }
                if (node.right != null) {
                    queue.add(node.right);
                    cardinals.put(node.right, cardinals.get(node) + 1);
                }
            }
        }


        for (Integer key : map.keySet()) {
            result.add(map.get(key));
        }

        return result;
    }
}
