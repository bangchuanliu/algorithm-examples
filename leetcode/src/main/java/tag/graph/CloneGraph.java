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
        Map<Node, Node> map = new HashMap<>();

        Node head = new Node(node.val, new ArrayList<>());

        map.put(node, head);
        queue.add(node);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (Node neighbor : cur.neighbors) {
                if (!map.containsKey(neighbor)) {
                    Node clonedNode = new Node(neighbor.val, new ArrayList<>());
                    map.put(neighbor, clonedNode);
                    queue.add(neighbor);
                }
                map.get(cur).neighbors.add(map.get(neighbor));

            }
        }

        return head;
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
