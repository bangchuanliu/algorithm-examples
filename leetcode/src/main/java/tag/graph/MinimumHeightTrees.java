package tag.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @author bliu13 Dec 27, 2015
 */
public class MinimumHeightTrees {

	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		int[] degrees = new int[n];
		
		for (int i = 0; i < edges.length; i++) {
			degrees[edges[i][0]]++;
			degrees[edges[i][1]]++;
		}
		
		Queue<Integer> vertices = new LinkedList<>();
		List<Integer> rootNodes = new ArrayList<>();
		
		for (int i = 0; i < degrees.length; i++) {
			if (degrees[i] == 1 || degrees[i] == 0) { // if n = 1 degrees[i] = 0
				vertices.add(i);
			}
		}
		
		while (n > 2) {
			int qSize = vertices.size();
			for (int j = 0; j < qSize; j++) {
				int vetex = vertices.poll();
				n--;
				
				for (int i = 0; i < edges.length; i++) {
					if (edges[i][0] == vetex) {
						degrees[edges[i][1]]--;
						if (degrees[edges[i][1]] == 1) {
							vertices.offer(edges[i][1]);
						}
					} else if (edges[i][1] == vetex){
						degrees[edges[i][0]]--;
						if (degrees[edges[i][0]] == 1) {
							vertices.offer(edges[i][0]);
						}
					}
				}
			}
		}
		
		while (!vertices.isEmpty()) {
			rootNodes.add(vertices.poll());
		}
		
		return rootNodes;
	}
	
	public static void main(String[] args) {
		MinimumHeightTrees instance = new MinimumHeightTrees();
		int[][] edges = {{1, 0}, {1, 2}, {1, 3}};
		int[][] edges2 = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
		
		List<Integer> result1 = instance.findMinHeightTrees(4, edges);
		
		result1.forEach(num -> System.out.println(num));
		
		List<Integer> result2 = instance.findMinHeightTrees(6, edges2);
		result2.forEach(num -> System.out.println(num));
	}
}
