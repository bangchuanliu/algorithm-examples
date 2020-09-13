package chapter7;

import java.util.*;

public class EightCodeII {
    public static void main(String[] args) {
        int[] start = {2, 6, 4, 1, 3, 7, 0, 5, 8};
        int[] dest = {8, 1, 5, 7, 3, 6, 4, 0, 2};
        System.out.println(bfs(start, 6, dest));
    }

    public static int bfs(int[] start, int index, int[] dest) {
        Queue<Node> q = new LinkedList<>();
        Set<String> sets = new HashSet<>();
        Node node = new Node(start, index);
        q.add(node);
        int step = 0;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            step++;
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                if (Arrays.toString(cur.s).equals(Arrays.toString(dest))) {
                    return step;
                } else {
                    for (int j = 0; j < dx.length; j++) {
                        int x = cur.index / 3;
                        int y = cur.index % 3;
                        int a = x + dx[j];
                        int b = y + dy[j];
                        int newIndex = a * 3 + b;
                        if (a >= 0 && a < 3 && b >= 0 && b < 3) {
                            Node newNode = move(cur, newIndex);
                            String str = Arrays.toString(newNode.s);
                            if (!sets.contains(str)) {
                                sets.add(str);
                                q.add(newNode);
                            }
                        }
                    }
                }
            }
        }

        return step;
    }

    public static Node move(Node cur, int newIndex) {
        int[] state = cur.s;
        int cIndex = cur.index;
        int[] newState = Arrays.copyOf(state, state.length);

        newState[cIndex] = newState[newIndex];
        newState[newIndex] = 0;

        return new Node(newState, newIndex);
    }

    static class Node {
        int[] s;
        int index;

        Node(int[] s, int index) {
            this.s = s;
            this.index = index;
        }
    }
}


