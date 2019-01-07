package chapter1_1_basicprogrammingmodel;

public class StopWatch {

    private double start;

    public StopWatch() {
        start = System.currentTimeMillis();
    }

    public double elapseTime() {
        double currect = System.currentTimeMillis();
        return (currect - start) / 1000.00;
    }
}
