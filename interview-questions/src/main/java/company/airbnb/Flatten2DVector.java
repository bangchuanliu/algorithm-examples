package company.airbnb;

public class Flatten2DVector {
    private int i = 0;
    private int j = 0;
    private int[][] v;

    public Flatten2DVector(int[][] v) {
        this.v = v;
    }

    public int next() {
        if (hasNext()) {
            int temp = v[i][j];
            if (j == v[i].length - 1) {
                i++;
                j = 0;
            } else {
                j++;
            }
            return temp;    
        }
        return 0;
    }

    public boolean hasNext() {
        while (i < v.length && v[i].length == 0) {
            i++;
        }
        return i < v.length;
    }
    
    public static void main(String[] args) {
        int[][] v = {{},{1,2},{3},{4}};
        Flatten2DVector iterator = new Flatten2DVector(v);
        System.out.println(iterator.next()); // return 1
        System.out.println(iterator.next()); // return 2
        System.out.println(iterator.next()); // return 3
        System.out.println(iterator.hasNext()); // return true
        System.out.println(iterator.hasNext()); // return true
        System.out.println(iterator.next()); // return 4
        System.out.println(iterator.hasNext()); // return false
    }
}


