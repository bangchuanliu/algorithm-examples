package tag.tree;

public class InorderSuccessorinBSTII {
    public Node inorderSuccessor(Node x) {
        Node next = null;
        if (x == null) {
            return next;
        }

        if (x.right != null) {
            Node temp = x.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            next = temp;
        } else {
            Node temp = x.parent;
            while(temp != null && temp.val < x.val) {
                temp = temp.parent;
            }
            next = temp;
        }
        
        return next;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
