package tag.array;

public class MedianofTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return 0.0;
        }

        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int x = nums1.length;
        int y = nums2.length;

        int low = 0;
        int high = x;

        while (low <= high) {
            int midx = (low + high) / 2;
            int midy = (x + y + 1) / 2 - midx;

            int maxLeftx = midx == 0 ? Integer.MIN_VALUE : nums1[midx - 1];
            int minRightx = midx == x ? Integer.MAX_VALUE : nums1[midx];

            int maxLefty = midy == 0 ? Integer.MIN_VALUE : nums2[midy - 1];
            int minRighty = midy == y ? Integer.MAX_VALUE : nums2[midy];


            if (maxLeftx <= minRighty && maxLefty <= minRightx) {
                if ((x + y) % 2 == 0) {
                    int left = Math.max(maxLeftx, maxLefty);
                    int right = Math.min(minRightx, minRighty);

                    return (double) (left + right) / 2;
                } else {
                    return Math.max(maxLeftx, maxLefty);
                }
            } else if (maxLeftx > minRighty) {
                high = midx - 1;
            } else {
                low = midx + 1;
            }
        }

        return 0.0;
    }
}
