package course3.assignment2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MaxKSpacingClusteringBig {
    private static WeightedQuickUnionPathCompression uf;

    public static void addCloseNodes(int vertex, BitSet bitSet, Map<BitSet, List<Integer>> map,int numOfBits) {
        insertIfExist(vertex, bitSet, map);
        for (int i = 0; i < numOfBits; i++) {
            BitSet bs = (BitSet) bitSet.clone();
            bs.flip(i);
            insertIfExist(vertex, bs, map);
        }

        for (int i = 0; i < numOfBits; i++) {
            for (int j = i+1; j < numOfBits; j++) {
                BitSet bs = (BitSet) bitSet.clone();
                bs.flip(i);
                bs.flip(j);
                insertIfExist(vertex, bs, map);
            }
        }
    }
    
    public static void insertIfExist(int vertex, BitSet bitSet, Map<BitSet, List<Integer>> map) {
        List<Integer> vw = new ArrayList<>();
        if (map.containsKey(bitSet)) {
            vw = map.get(bitSet);
        } 
        vw.add(vertex);
        map.put(bitSet, vw);
    }

    public static int maxKSpaceCluster(List<BitSet> nodes, int vertices, int numOfBits) {
        uf = new WeightedQuickUnionPathCompression(vertices);
        Map<BitSet, List<Integer>> map = new HashMap<>();
        for (int i = 1; i < nodes.size(); i++) {
            BitSet bitSet = nodes.get(i);
            if (map.containsKey(bitSet)) {
                List<Integer> vw = map.get(bitSet);
                for (Integer u : vw) {
                    if (!uf.connected(i, u)) {
                        uf.union(i,u);
                    }    
                }
            }
            addCloseNodes(i, bitSet,map,numOfBits);
        }
        return uf.getCount();
    }

    public static void main(String[] args) throws IOException {
        //6118
        String path = MaxKSpacingClusteringBig.class.getClassLoader().getResource("course3/assignment2/data/clustering_big.txt").getPath();
        List<String> list = Files.lines(Paths.get(path)).filter(str -> str.length() > 0).collect(Collectors.toList());
        int vertices = Integer.parseInt(list.get(0).split("\\s+")[0]);
        int len = Integer.parseInt(list.get(0).split("\\s+")[1]);
        List<BitSet> bitSets = new ArrayList<>();
        bitSets.add(null);
        for (int j = 1; j < list.size(); j++) {
            BitSet bitSet = new BitSet(len);
            String str = list.get(j).replace(" ", "");
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '1') {
                    bitSet.set(i);
                }
            }
            bitSets.add(bitSet);
        }
        System.out.println(maxKSpaceCluster(bitSets, vertices, len));
    }
}
