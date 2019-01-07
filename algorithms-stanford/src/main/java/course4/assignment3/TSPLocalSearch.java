package course4.assignment3;

import course4.assignment2.Point;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class TSPLocalSearch {

    public static int shortestPath(Point[] points) {
        int[] vertices = new int[points.length];
        boolean[] marked = new boolean[points.length];
        vertices[1] = 1;
        marked[1] = true;
        for (int i = 2; i < vertices.length; i++) {
            int v = vertices[i - 1];
            vertices[i] = shortestPathLocal(v, points, marked);
        }

        Double dist = 0d;

        for (int i = 1; i < vertices.length - 1; i++) {
            Point p1 = points[vertices[i]];
            Point p2 = points[vertices[i + 1]];
            dist += p1.dist(p2);
        }

        dist += points[vertices[vertices.length - 1]].dist(points[1]);

        return dist.intValue();
    }

    public static int shortestPathLocal(int v, Point[] points, boolean[] marked) {
        Double min = Double.MAX_VALUE;
        int w = 0;
        Point p = points[v];
        for (int i = 1; i < points.length; i++) {
            if (i != v && !marked[i] && points[i].distSquare(p) < min) {
                min = points[i].distSquare(p);
                w = i;
            }
        }
        marked[w] = true;
        return w;
    }


    public static void main(String[] args) throws IOException {
        // 1203406
        String path = "/Users/b0l00ev/Documents/personal/data/nn.txt";
//        String path = "/Users/b0l00ev/Documents/personal/data/test";
        List<String> list = Files.lines(Paths.get(path)).filter(str -> str.length() > 0).collect(Collectors.toList());
        int vertices = Integer.parseInt(list.get(0));
        Point[] points = new Point[vertices + 1];
        for (int i = 1; i < list.size(); i++) {
            String[] str = list.get(i).split("\\s+");
            Point p1 = new Point(Double.parseDouble(str[1]), Double.parseDouble(str[2]));
            points[i] = p1;
        }
        System.out.println(shortestPath(points));
    }
}
