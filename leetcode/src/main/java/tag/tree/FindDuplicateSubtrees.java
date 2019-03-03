package tag.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        findDuplicateSubtrees(result, root, new HashMap<>());
        return result;
    }

    public String findDuplicateSubtrees(List<TreeNode> result, TreeNode root, Map<String, Integer> map) {
        if (root == null) {
            return "";
        }

        String left = findDuplicateSubtrees(result,root.left, map);
        String right = findDuplicateSubtrees(result,root.right, map);
        String str = root.val + "," + left + "," + right;
        map.put(str, map.getOrDefault(str, 0) + 1);
        if (map.get(str) == 2) {
            result.add(root);
        }
        return str;
    }
}
