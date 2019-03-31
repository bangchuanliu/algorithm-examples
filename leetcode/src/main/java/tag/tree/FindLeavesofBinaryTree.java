package tag.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindLeavesofBinaryTree {

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Set<TreeNode> marked = new HashSet<>();

        while (!marked.contains(root)) {
            List<Integer> temp = new ArrayList<>();
            findLeaves(root, temp, marked);
            result.add(new ArrayList<>(temp));
        }

        return result;
    }


    public void findLeaves(TreeNode root, List<Integer> temp, Set<TreeNode> marked) {
        if (root == null) {
            return;
        }

        if ((root.left == null || marked.contains(root.left)) && (root.right == null || marked.contains(root.right)) && !marked.contains(root)) {
            temp.add(root.val);
            marked.add(root);
            return;
        }
        findLeaves(root.left, temp, marked);
        findLeaves(root.right, temp, marked);
    }

}
