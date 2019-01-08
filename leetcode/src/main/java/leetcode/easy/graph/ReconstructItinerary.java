package leetcode.easy.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ReconstructItinerary {

	public List<String> findItinerary(String[][] tickets) {
		List<String> itineraryList = new ArrayList<>();

		if (tickets == null || tickets.length == 0) {
			return itineraryList;
		}

		Map<String, LinkedList<String>> itineraryGraph = new HashMap<>();

		for (String[] route : tickets) {
			if (itineraryGraph.containsKey(route[0])) {
				LinkedList<String> dests = itineraryGraph.get(route[0]);
				int size = dests.size();
				for (int i = 0; i < size; i++) {
					if (route[1].compareTo(dests.get(i)) < 0) {
						dests.add(i, route[1]);
					}
				}
				if (dests.size() == size) {
					dests.add(route[1]);
				}
			} else {
				LinkedList<String> dests = new LinkedList<>();
				dests.add(route[1]);
				itineraryGraph.put(route[0], dests);
			}
		}
		itineraryList.add("JFK");
		dfs(itineraryList, "JFK", itineraryGraph, tickets.length);

		return itineraryList;
	}

	public void dfs(List<String> itineraryList, String key, Map<String, LinkedList<String>> itineraryGraph, int len) {
		if (len == 0) {
			return;
		}

		LinkedList<String> dests = itineraryGraph.get(key);
		if (dests == null) {
			return;
		}
		if (!dests.isEmpty()) {
			itineraryList.add(dests.getFirst());
			key = dests.removeFirst();
		}

		dfs(itineraryList, key, itineraryGraph, len - 1);
	}

	public static void main(String[] args) {
		String[][] tickets = { { "MUC", "LHR" }, { "JFK", "MUC" }, { "SFO", "SJC" }, { "LHR", "SFO" } };
		String[][] tickets2 = { { "JFK", "SFO" }, { "JFK", "ATL" }, { "SFO", "ATL" }, { "ATL", "JFK" },
				{ "ATL", "SFO" } };
		ReconstructItinerary instance = new ReconstructItinerary();
		List<String> list1 = instance.findItinerary(tickets);
		List<String> list2 = instance.findItinerary(tickets2);
		System.out.println(Arrays.toString(list1.toArray()));
		System.out.println(Arrays.toString(list2.toArray()));
	}
}
