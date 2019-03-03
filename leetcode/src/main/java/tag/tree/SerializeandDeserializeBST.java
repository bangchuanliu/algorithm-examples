package tag.tree;

import common.TreeNode;
import common.TreeNodeUtil;

public class SerializeandDeserializeBST {
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        String result = "";
        result = root.val + "";
        String left = serialize(root.left);
        String right = serialize(root.right);
        result = left == null ? result : result + " " + left;
        result = right == null ? result : result + " " +right;
        return result;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] datas = data.split(" ");

        return deserialize(datas, 0, datas.length - 1);
    }

    public TreeNode deserialize(String[] datas, int i, int j) {
        if (i > j) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(datas[i]));
        int index = i + 1;
        while (index < datas.length && Integer.parseInt(datas[index]) < root.val) {
            index++;
        }
        TreeNode left = deserialize(datas, i + 1, index - 1);
        TreeNode right = deserialize(datas, index, j);
        root.left = left;
        root.right = right;

        return root;
    }

    public static void main(String[] args) {
//        Integer[] nums = {41, 37, 44, 24, 39, 42, 48, 1, 35, 38, 40, null, 43, 46, 49, 0, 2, 30, 36, null, null, null, null, null, null, 45, 47, null, null, null, null, null, 4, 29, 32, null, null, null, null, null, null, 3, 9, 26, null, 31, 34, null, null, 7, 11, 25, 27, null, null, 33, null, 6, 8, 10, 16, null, null, null, 28, null, null, 5, null, null, null, null, null, 15, 19, null, null, null, null, 12, null, 18, 20, null, 13, 17, null, null, 22, null, 14, null, null, 21, 23};
        Integer[] nums = {1};
        TreeNode root = TreeNodeUtil.creatTree(nums);
        SerializeandDeserializeBST instance = new SerializeandDeserializeBST();
        String serializedStr = instance.serialize(root);
        System.out.println(serializedStr);
        TreeNode node = instance.deserialize(serializedStr);
        System.out.println(instance.serialize(node));
    }
}