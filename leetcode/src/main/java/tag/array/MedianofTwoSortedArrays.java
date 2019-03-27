package tag.array;

public class MedianofTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int imin = 0;
        int imax = nums1.length;
        int mid = (nums1.length + nums2.length + 1) / 2;

        while (imin <= imax) {
            int imid = (imin + imax) / 2;
            int jmid = mid - imid;

            if (imid > imin && nums1[imid - 1] > nums2[jmid]) {
                imax = imid - 1;
            } else if (imid < imax && nums2[jmid - 1] > nums1[imid]) {
                imin = imid + 1;
            } else {
                int maxLeft = 0;
                if (imid == 0) {    
                    maxLeft = nums2[jmid - 1];
                } else if (jmid == 0) {
                    maxLeft = nums1[imid - 1];
                } else {
                    maxLeft = Math.max(nums1[imid - 1], nums2[jmid - 1]);
                }
                if ((nums1.length + nums2.length) % 2 == 1) {
                    return maxLeft;
                }
                int minRight = 0;
                if (imid == nums1.length) {
                    minRight = nums2[jmid];
                } else if (jmid == nums2.length) {
                    minRight = nums1[imid];
                } else {
                    minRight = Math.min(nums1[imid], nums2[jmid]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }

        return 0;
    }
}
