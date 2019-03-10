package tag.graph;

import java.util.List;

public class Node {
	int val;
	List<Node> neighbors;

    public Node (int val, List<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}
