package tag.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ReconstructItinerary {

    public List<String> findItinerary(String[][] tickets) {
        List<String> result = new ArrayList<>();
        boolean[] used = new boolean[tickets.length];
        result.add("JFK");
        dfs(tickets, used, result);
        
        return result;
    }
	
	public boolean dfs(String[][] tickets, boolean[] used, List<String> result) {
	    if (result.size() == tickets.length + 1) {
	        return true;
        }
	    String str = result.get(result.size() - 1);
	    Map<String, Integer> temp = new TreeMap<>(); 
	    for (int i = 0; i < tickets.length; i++) {
	        if (!used[i] && str.equals(tickets[i][0])) {
	            temp.put(tickets[i][1], i);
            }
        }
	    for (String s : temp.keySet()) {
            used[temp.get(s)] = true;
            result.add(s);
            if (dfs(tickets,used, result)) {
                return true;
            }
            used[temp.get(s)] = false;
            result.remove(result.size() - 1);
        }
	    
        return false;
    }

	public static void main(String[] args) {
		String[][] tickets = { { "MUC", "LHR" }, { "JFK", "MUC" }, { "SFO", "SJC" }, { "LHR", "SFO" } };
		String[][] tickets2 = { { "JFK", "SFO" }, { "JFK", "ATL" }, { "SFO", "ATL" }, { "ATL", "JFK" },
				{ "ATL", "SFO" } };
        String[][] tickets3 = {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
		ReconstructItinerary instance = new ReconstructItinerary();
//		List<String> list1 = instance.findItinerary2(tickets);
//		List<String> list2 = instance.findItinerary2(tickets2);
        List<String> list3 = instance.findItinerary(tickets3);
//		System.out.println(Arrays.toString(list1.toArray()));
//		System.out.println(Arrays.toString(list2.toArray()));
        System.out.println(Arrays.toString(list3.toArray()));
	}
}
