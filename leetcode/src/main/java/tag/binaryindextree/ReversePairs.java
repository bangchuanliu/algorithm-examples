package tag.binaryindextree;

public class ReversePairs {

    public static int inversionCount = 0;
    public static int[] aux;

    public int reversePairs(int[] nums) {
        inversionCount = 0;
        aux = new int[nums.length];
        count(nums, 0, nums.length - 1);
        return inversionCount;
    }

    public static void count(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        count(nums, low, mid);
        count(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }

    public static void merge(int[] nums, int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            aux[i] = nums[i];
        }

        int count = 0;
        for (int l = low, r = mid + 1; l <= mid; ) {
            if (r > high || nums[l] - nums[r] <= nums[r]) {
                l++;
                inversionCount += count;
            } else {
                r++;
                count++;
            }
        }

        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                nums[k] = aux[j++];
            } else if (j > high) {
                nums[k] = aux[i++];
            } else if (aux[i] >= aux[j]) {
                nums[k] = aux[j++];
            } else {
                nums[k] = aux[i++];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 3, 5, 1};
        ReversePairs instance = new ReversePairs();
        int result = instance.reversePairs(nums);

        System.out.println(result);
    }
}
