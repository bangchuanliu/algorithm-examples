package company.google;

public class MissingInBinarySearch {

    public void CheckHidden(int[] data,
                            boolean[] hidden,
                            int lo, int hi,
                            int min_bound, int max_bound) {
        if (lo > hi) {
            return;
        }

        int mid = (lo + hi) / 2;
        int value = data[mid];

        hidden[mid] = (value <= min_bound || value >= max_bound);

        CheckHidden(data, hidden, lo, mid - 1, min_bound, Math.min(value, max_bound));
        CheckHidden(data, hidden, mid + 1, hi, Math.max(min_bound, value), max_bound);
    }

    // Wrapper
    void CheckHidden(int[] data, boolean[] hidden) {
        CheckHidden(data, hidden, 0, data.length - 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
