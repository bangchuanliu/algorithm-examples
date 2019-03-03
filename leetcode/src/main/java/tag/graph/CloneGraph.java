package tag.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author bliu13 Dec 27, 2015
 */
public class CloneGraph {

	/**
	 * BFS
	 * 
	 * @param node
	 * @return
	 */
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

		LinkedList<UndirectedGraphNode> queue = new LinkedList<>();
		Map<UndirectedGraphNode, UndirectedGraphNode> maps = new HashMap<>();

		UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);

		maps.put(node, newHead);
		queue.add(node);

		while (!queue.isEmpty()) {
			UndirectedGraphNode currNode = queue.poll();
			List<UndirectedGraphNode> currNeighbors = currNode.neighbors;

			for (UndirectedGraphNode n : currNeighbors) {
				if (!maps.containsKey(n)) {
					UndirectedGraphNode clonedNode = new UndirectedGraphNode(
							n.label);
					maps.put(n, clonedNode);
					maps.get(currNode).neighbors.add(clonedNode);
					queue.add(n);
				} else {
					maps.get(currNode).neighbors.add(maps.get(n));
				}
			}
		}

		return newHead;
	}
	
	
	/**
	 * DFS
	 * 
	 * @param node
	 * @return
	 */
	public UndirectedGraphNode cloneGraphDFS(UndirectedGraphNode node) {

		if (node == null) {
			return node;
		}

		UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);
		Map<UndirectedGraphNode,UndirectedGraphNode> maps = new HashMap<>();
		
		maps.put(node, newHead);
		
		cloneGraphDFS(node,maps);
		
		return newHead;
	}
	
	public void cloneGraphDFS(UndirectedGraphNode node, Map<UndirectedGraphNode,UndirectedGraphNode> maps) {
		for (UndirectedGraphNode curr : node.neighbors) {
			if (!maps.containsKey(curr)) {
				UndirectedGraphNode clonedNode = new UndirectedGraphNode(curr.label);
				maps.put(curr, clonedNode);
				maps.get(node).neighbors.add(clonedNode);
				cloneGraphDFS(curr,maps);
			} else {
				maps.get(node).neighbors.add(maps.get(curr));
			}
		}
	}
	
	
}
