package tag.queue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class KillProcess {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> maps = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++) {
            List<Integer> list = new ArrayList<>();
            if (maps.containsKey(ppid.get(i))) {
                list = maps.get(ppid.get(i));
            }
            list.add(pid.get(i));
            maps.put(ppid.get(i), list);
        }


        List<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(kill);


        while (!q.isEmpty()) {
            int temp = q.poll();
            result.add(temp);
            if (maps.containsKey(temp)) {
                List<Integer> list = maps.get(temp);
                for (int num : list) {
                    q.add(num);
                }
            }
        }

        return result;
    }
}
