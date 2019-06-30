package chapter2;

public class Permutation {

    public static void printNum() {
        for (int i = 111; i <= 333; i++) {
            boolean[] visit = new boolean[10];

            int j = 2 * i;
            int k = 3 * i;

            visit[i % 10] = true;
            visit[j % 10] = true;
            visit[k % 10] = true;
            visit[i / 100] = true;
            visit[j / 100] = true;
            visit[k / 100] = true;
            visit[i / 10 % 10] = true;
            visit[j / 10 % 10] = true;
            visit[k / 10 % 10] = true;
            boolean flag = false;
            for (int m = 1; m <= 9; m++) {
                if (!visit[m]) {
                    flag = true;
                    break;
                } 
            }
            if (!flag) {
                System.out.println(i + " " + j + " " + k);    
            }
        }
    }

    public static void main(String[] args) {
        printNum();
    }
}
