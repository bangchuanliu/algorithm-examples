package tag.dp;

public class UniqueBinarySearchTrees {

    public int numTrees(int n) {
        if (n <= 0) {
            return 0;
        }

        int[] numsOfTrees = new int[n + 2];
        numsOfTrees[0] = 1;
        numsOfTrees[n + 1] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                numsOfTrees[i] += numsOfTrees[j - 1] * numsOfTrees[i - j];
            }
        }

        return numsOfTrees[n];
    }

    public int numTrees2(int n) {
        return numTrees2(1, n);
    }

    public int numTrees2(int l, int r) {
        if (l >= r) {
            return 1;
        }
        int count = 0;
        for (int i = l; i <= r; i++) {
            count += numTrees2(l, i - 1) * numTrees2(i + 1, r);
        }
        return count;
    }


    public static void main(String[] args) {
        UniqueBinarySearchTrees instance = new UniqueBinarySearchTrees();
        System.out.println(instance.numTrees(1));
        System.out.println(instance.numTrees2(1));
        System.out.println(instance.numTrees(2));
        System.out.println(instance.numTrees2(2));
        System.out.println(instance.numTrees(3));
        System.out.println(instance.numTrees2(3));
        System.out.println(instance.numTrees(4));
        System.out.println(instance.numTrees2(4));
        System.out.println(instance.numTrees(5));
        System.out.println(instance.numTrees2(5));
        System.out.println(instance.numTrees(6));
        System.out.println(instance.numTrees2(6));
    }
}
