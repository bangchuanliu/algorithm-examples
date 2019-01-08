package leetcode.easy.stackqueue;

import java.util.LinkedList;

/**
 * Created by bliu on 3/30/16.
 */
public class VerifyPreorderSerializationofaBinaryTree {

    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) {
            return false;
        }

        LinkedList<String> stack = new LinkedList<>();
        String[] nodes = preorder.split(",");
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].equals("#")) {
                while (!stack.isEmpty() && stack.peek().equals("#")) {
                    stack.poll();
                    if (stack.isEmpty()) {
                        return false;
                    } else {
                        stack.poll();    
                    }
                }
                stack.push("#");
            } else {
                stack.push(nodes[i]);
            }
        }

        return stack.size() == 1 && stack.peek().equals("#");
    }

    public static void main(String[] args) {
        VerifyPreorderSerializationofaBinaryTree instance = new VerifyPreorderSerializationofaBinaryTree();
        System.out.println(instance.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println(instance.isValidSerialization("1,#,#,#,#"));
        System.out.println(instance.isValidSerialization("9,#,#,1"));
    }
}
