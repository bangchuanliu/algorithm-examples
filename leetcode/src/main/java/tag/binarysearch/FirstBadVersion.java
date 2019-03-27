package tag.binarysearch;

public class FirstBadVersion {
    public int findFirstBadVersion(int n) {
        int l = 1;
        int r = n;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (VersionControl.isBadVersion(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        FirstBadVersion instance = new FirstBadVersion();
        // VersionControl.threshold = 1;
        System.out.println(instance.findFirstBadVersion(2126753390));
    }
}

class VersionControl {

    public static int threshold = 1702766719;

    public static boolean isBadVersion(int k) {
        return k >= threshold;
    }
}
