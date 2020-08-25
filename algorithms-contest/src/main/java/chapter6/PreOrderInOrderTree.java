package chapter6;

public class PreOrderInOrderTree {

    public static void main(String[] args) {
//        int[] inOrder = {3,2,1,4,5,7,6};
//        int[] postOrder = {3,1,2,5,6,7,4};

        int[] inOrder = {7,8,11,3,5,16,12,18};
        int[] postOrder = {8,3,11,7,16,18,12,5};
        
        System.out.println(minWeight(inOrder, postOrder));
    }

    public static int minWeight(int[] inOrder, int[] postOrder) {
        int root = build(inOrder, 0, inOrder.length - 1, postOrder, 0, postOrder.length - 1);
        sum(root, 0);
        return value;
    }
    
    static int value = Integer.MAX_VALUE;
    static int weight = Integer.MAX_VALUE;
    
    public static void sum(int node, int sum){
        sum += node;
        
        if (left[node] == 0 && right[node] == 0){
            if (sum < weight || (sum == weight && node < value)){
                value = node;
                weight = sum;
            }
        }
        if (left[node] != 0) {
            sum(left[node], sum);
        }
        
        if (right[node] != 0){
            sum(right[node], sum);
        }
    }
    
    public static int dfs(int root, int leaf){
        if (root == 0){
            return 0;
        }else if (root == leaf){
            return leaf;
        } else {
            int dis = dfs(left[root], leaf);
            int dis2 = dfs(right[root], leaf);
            if (dis == 0 && dis2 == 0){
                return 0;
            }else{
                return root + dis == 0? dis2 : dis;
            }
        }
    }

    static int maxv = 10000 + 10;
    static int[] left = new int[maxv];
    static int[] right = new int[maxv];

    public static int build(int[] inOrder, int l1, int r1, int[] postOrder, int l2, int r2) {
        if (l1 > r1 || l2 > r2) {
            return 0;
        }
        int root = postOrder[r2];
        int i = l1;
        while (i <= r1 && inOrder[i] != root) {
            i++;
        }
        
        int cnt = i - l1;
            
        left[root] = build(inOrder, l1, i - 1, postOrder, l2, l2 + cnt - 1);
        right[root] = build(inOrder, i + 1, r1, postOrder, l2+cnt, r2 - 1);

        return root;
    }

}
