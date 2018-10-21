package basicprogrammingmodel;

public class BinarySearchUtil {

    public static int search(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] > key) {
                high = mid - 1;
            } else if (a[mid] < key) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * find the leftest one
     */
    public static int searchWithDuplicate(int[] a, int key) {
        int index = -1;
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] > key) {
                high = mid - 1;
            } else if (a[mid] < key) {
                low = mid + 1;
            } else {
                index = mid;
                high = mid - 1;
            }
        }

        return index;
    }

    public static int recursiveSearch(int[] a, int key, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (a[mid] > key) {
            return recursiveSearch(a, key, low, mid - 1);
        } else if (a[mid] < key) {
            return recursiveSearch(a, key, mid + 1, high);
        } else {
            return mid;
        }
    }


    public static int count(int[] a, int key) {
        int index1 = -1;
        int index2 = -1;
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] > key) {
                high = mid - 1;
            } else if (a[mid] < key) {
                low = mid + 1;
            } else {
                index1 = mid;
                high = mid - 1;
            }
        }

        low = 0;
        high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] > key) {
                high = mid - 1;
            } else if (a[mid] < key) {
                low = mid + 1;
            } else {
                index2 = mid;
                low = mid + 1;
            }
        }

        return index2 - index1 + 1;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 5, 5, 5, 5, 6, 7, 8, 9};
//        System.out.println(rank(a, 5));
        System.out.println(count(a, 5));
        int[] b = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(recursiveSearch(b, 5, 0, b.length - 1));
    }
}
