package greedy_dp.assignment3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Huffman {

    static class BTNode {
        public String symbol;
        public long weight;
        public BTNode left;
        public BTNode right;

        public BTNode(String symbol, long weight) {
            this.symbol = symbol;
            this.weight = weight;
            left = null;
            right = null;
        }
    }

    public static BTNode huffmanTree(List<BTNode> nodes) {
        PriorityQueue<BTNode> minHeap = new PriorityQueue<>(new Comparator<BTNode>() {
            @Override
            public int compare(BTNode o1, BTNode o2) {
                if (o1.weight < o2.weight) {
                    return -1;
                } else if (o1.weight > o2.weight) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        for (BTNode node : nodes) {
            minHeap.add(node);
        }

        while (minHeap.size() > 1) {
            BTNode node1 = minHeap.poll();
            BTNode node2 = minHeap.poll();
            BTNode newNode = new BTNode(node1.symbol + node2.symbol, node1.weight + node2.weight);
            newNode.left = node1;
            newNode.right = node2;
            minHeap.add(newNode);
        }
        return minHeap.poll();
    }
    
    public static int minHeight(BTNode root) {
        if (root == null) {
            return -1;
        }
        int lh = minHeight(root.left);
        int rh = minHeight(root.right);
        if (lh <= rh) {
            return lh + 1;
        } else {
            return rh + 1;
        }
    }

    public static int maxHeight(BTNode root) {
        if (root == null) {
            return -1;
        }
        int lh = maxHeight(root.left);
        int rh = maxHeight(root.right);
        if (lh <= rh) {
            return rh + 1;
        } else {
            return lh + 1;
        }
    }


    public static void main(String[] args) throws IOException {
        // max # of bits : 19, min # of bits : 9
        String path = "/Users/b0l00ev/Documents/personal/data/huffman.txt";
        List<String> list = Files.lines(Paths.get(path)).filter(str -> str.length() > 0).collect(Collectors.toList());
        List<BTNode> nodes = new ArrayList<>();
        for (int j = 1; j < list.size(); j++) {
            BTNode node = new BTNode(String.valueOf(j), Long.parseLong(list.get(j)));
            nodes.add(node);
        }
        BTNode root = huffmanTree(nodes);
        System.out.println(minHeight(root));
        System.out.println(maxHeight(root));
    }
}
