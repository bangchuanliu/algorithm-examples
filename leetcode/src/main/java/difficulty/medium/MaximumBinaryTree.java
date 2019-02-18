package difficulty.medium;

import common.TreeNode;

public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }


    public TreeNode constructMaximumBinaryTree(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }

        int max = nums[l];
        int index = l;
        for (int i = l; i <= r; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(nums[index]);
        root.left = constructMaximumBinaryTree(nums, l, index - 1);
        root.right = constructMaximumBinaryTree(nums, index + 1, r);
        return root;
    }
}
