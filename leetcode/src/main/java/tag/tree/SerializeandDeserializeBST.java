package tag.tree;

import common.TreeNode;
import common.TreeHelper;

public class SerializeandDeserializeBST {
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        return root.val + "," + serialize(root.left) + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }

        String[] strs = data.split(",");
        int[] num = new int[strs.length];
        
        for (int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(strs[i]);
        }

        return deserialize(num, 0, num.length - 1);
    }

    public TreeNode deserialize(int[] num, int i, int j) {
        if (i > j) {
            return null;
        }

        TreeNode node = new TreeNode(num[i]);
        int k = i + 1;
        while(k <= j && num[k] < num[i]) {
            k++;
        }

        node.left = deserialize(num, i+1, k-1);
        node.right = deserialize(num, k, j);

        return node;
    }

    public static void main(String[] args) {
//        Integer[] nums = {41, 37, 44, 24, 39, 42, 48, 1, 35, 38, 40, null, 43, 46, 49, 0, 2, 30, 36, null, null, null, null, null, null, 45, 47, null, null, null, null, null, 4, 29, 32, null, null, null, null, null, null, 3, 9, 26, null, 31, 34, null, null, 7, 11, 25, 27, null, null, 33, null, 6, 8, 10, 16, null, null, null, 28, null, null, 5, null, null, null, null, null, 15, 19, null, null, null, null, 12, null, 18, 20, null, 13, 17, null, null, 22, null, 14, null, null, 21, 23};
        Integer[] nums = {1};
        TreeNode root = TreeHelper.creatTree(nums);
        SerializeandDeserializeBST instance = new SerializeandDeserializeBST();
        String serializedStr = instance.serialize(root);
        System.out.println(serializedStr);
        TreeNode node = instance.deserialize(serializedStr);
        System.out.println(instance.serialize(node));
    }
}
