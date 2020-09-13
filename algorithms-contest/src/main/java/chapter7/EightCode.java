package chapter7;

import java.util.*;

public class EightCode {
    public static void main(String[] args) {
        int[][] start = {{2, 6, 4}, {1, 3, 7}, {0, 5, 8}};
        int[][] dest = {{8, 1, 5}, {7, 3, 6}, {4, 0, 2}};
        System.out.println(bfs(start, 2, 0, dest));
    }

    public static int bfs(int[][] start, int x, int y, int[][] dest) {
        Queue<Node> q = new LinkedList<>();
        Set<String> sets = new HashSet<>();
        Node node = new Node(start, x, y);
        q.add(node);
        int step = 0;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            step++;
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                if (Arrays.deepToString(cur.n).equals(Arrays.deepToString(dest))) {
                    return step;
                } else {
                    for (int j = 0; j < dx.length; j++) {
                        int a = cur.x + dx[j];
                        int b = cur.y + dy[j];
                        if (a >= 0 && a < start.length && b >= 0 && b < start[0].length) {
                            Node newNode = move(cur, a, b);
                            String str = Arrays.deepToString(newNode.n);
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

    public static Node move(Node cur, int a, int b) {
        int[][] board = cur.n;
        int m = board.length;
        int n = board[0].length;
        int[][] newNode = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                newNode[i][j] = board[i][j];
            }
        }

        int x = cur.x;
        int y = cur.y;

        newNode[x][y] = newNode[a][b];
        newNode[a][b] = 0;

        return new Node(newNode, a, b);
    }

    static class Node {
        int[][] n;
        int x;
        int y;

        Node(int[][] n, int x, int y) {
            this.n = n;
            this.x = x;
            this.y = y;
        }
    }
}


