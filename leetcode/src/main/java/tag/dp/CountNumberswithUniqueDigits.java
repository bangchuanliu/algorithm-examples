package tag.dp;

public class CountNumberswithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if (n <= 0) {
            return 1;
        }

        int sum = 10;

        for (int i = 2; i <= n; i++) {
            int temp = 9;
            for (int k = 2; k <= i; k++) {
                temp = (9 - k + 2) * temp;
            }
            sum += temp;
        }

        return sum;
    }

    public static void main(String[] args) {
        CountNumberswithUniqueDigits instance = new CountNumberswithUniqueDigits();
        System.out.println(instance.countNumbersWithUniqueDigits(2));
    }
}
