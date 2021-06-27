package tag.tree;

import common.TreeNode;
import common.TreeHelper;
import difficulty.easy.BinaryTreeLevelOrderTraversal;

import java.util.LinkedList;
import java.util.Queue;

public class CountUnivalueSubtrees {

    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int[] result = helper(root);

        return result[0];
    }

    public int[] helper(TreeNode root) {
        int[] result = new int[2];
        if (root == null) {
            return result;
        }

        int[] left = helper(root.left);
        int[] right = helper(root.right);

        if (root.left == null && root.right == null) {
            result[0] = 1;
            result[1] = 1;
            return result;
        } else if (root.left == null && root.right != null) {
            if (right[1] == 1 && root.val == root.right.val) {
                result[0] = right[0] + 1;
                result[1] = 1;
            } else {
                result[0] = right[0];
            }
            return result;
        } else if (root.left != null && root.right == null) {
            if (left[1] == 1 && root.val == root.left.val) {
                result[0] = left[0] + 1;
                result[1] = 1;
            } else {
                result[0] = left[0];
            }
            return result;
        } else {
            if (left[1] == 1 && right[1] == 1
                    && root.val == root.left.val && root.val == root.right.val) {
                result[0] = left[0] + right[0] + 1;
                result[1] = 1;
                
            }else {
                result[0] = left[0] + right[0];
            }
            return result;
        }
    }


    public static void main(String[] args) {
        CountUnivalueSubtrees countUnivalueSubtrees = new CountUnivalueSubtrees();
        Integer[] nums = {7, 82, 82, -79, 98, 98, -79, -79, null, -28, -24, -28, -24, null, -79, null, 97, 65, -4, null, 3, -4, 65, 3, null, 97};
        TreeNode node = TreeHelper.creatTree(nums);
        TreeNode node2 = stringToTreeNode("[7,82,82,-79,98,98,-79,-79,null,-28,-24,-28,-24,null,-79,null,97,65,-4,null,3,-4,65,3,null,97]");
        BinaryTreeLevelOrderTraversal binaryTreeLevelOrderTraversal = new BinaryTreeLevelOrderTraversal();
        System.out.println(countUnivalueSubtrees.countUnivalSubtrees(node2));
//        TreeNodeUtil.printTree(node2);
//        System.out.println(Arrays.toString(binaryTreeLevelOrderTraversal.levelOrder(node2).toArray()));
    }

    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }
}
