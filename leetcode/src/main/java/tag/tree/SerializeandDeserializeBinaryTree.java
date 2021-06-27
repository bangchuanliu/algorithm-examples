package tag.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import common.TreeNode;
import common.TreeHelper;

public class SerializeandDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }

        String str = String.valueOf(root.val);
        String left = serialize(root.left);
        String right = serialize(root.right);
        str = str + "," + left;
        str = str + "," + right;
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserialize(queue);
    }

    public TreeNode deserialize(Queue<String> queue) {
        if (queue.isEmpty()) {
            return null;
        }
        String str = queue.poll();
        TreeNode root = null;
        if (!str.equals("#")) {
            root = new TreeNode(Integer.parseInt(str));
            root.left = deserialize(queue);
            root.right = deserialize(queue);    
        }
        
        return root;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        SerializeandDeserializeBinaryTree instance = new SerializeandDeserializeBinaryTree();
        String serializedStr = instance.serialize(n1);
        System.out.println(serializedStr);
        TreeNode root = instance.deserialize(serializedStr);
        TreeHelper.printTree(root);
    }
}
