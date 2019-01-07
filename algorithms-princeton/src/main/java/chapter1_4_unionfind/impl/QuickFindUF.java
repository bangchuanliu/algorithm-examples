package chapter1_4_unionfind.impl;

import chapter1_4_unionfind.UF;

public class QuickFindUF implements UF {

    private int[] a;
    private int count;

    public QuickFindUF(int N) {
        a = new int[N];
        count = N;
        for (int i = 0; i < N; i++) {
            a[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == a[p]) {
                a[i] = a[q];
            }
        }
        count--;
    }

    @Override
    public int find(int p) {
        return a[p];
    }

    @Override
    public boolean connected(int p, int q) {
        return a[p] == a[q];
    }

    @Override
    public int count() {
        return count;
    }
}
