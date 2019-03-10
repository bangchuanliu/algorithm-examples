package tag.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author bliu13 Dec 27, 2015
 */
public class CloneGraph {

    /**
     * BFS
     */
    public Node cloneGraph(Node node) {

        Queue<Node> queue = new LinkedList<>();
        Map<Node, Node> maps = new HashMap<>();

        Node newHead = new Node(node.val, new ArrayList<>());

        maps.put(node, newHead);
        queue.add(node);

        while (!queue.isEmpty()) {
            Node currNode = queue.poll();
            for (Node neighbor : currNode.neighbors) {
                if (!maps.containsKey(neighbor)) {
                    Node clonedNode = new Node(neighbor.val, new ArrayList<>());
                    maps.put(neighbor, clonedNode);
                    maps.get(currNode).neighbors.add(clonedNode);
                    queue.add(neighbor);
                } else {
                    maps.get(currNode).neighbors.add(maps.get(neighbor));
                }
            }
        }

        return newHead;
    }


    /**
     * DFS
     */
    public Node cloneGraphDFS(Node node) {
        return cloneGraphDFS(node, new HashMap<>());
    }

    public Node cloneGraphDFS(Node node, Map<Node, Node> maps) {
        if (maps.containsKey(node)) {
            return maps.get(node);
        }

        Node cloneNode = new Node(node.val, new ArrayList<>());
        maps.put(node, cloneNode);

        for (Node curr : node.neighbors) {
            Node cloned = cloneGraphDFS(curr, maps);
            cloneNode.neighbors.add(cloned);
        }

        return cloneNode;
    }
}
