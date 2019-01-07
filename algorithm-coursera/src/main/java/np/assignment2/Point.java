package np.assignment2;

public class Point {
    public Double x;
    public Double y;
    
    public Point(Double x, Double y) {
        this.x = x;
        this.y = y;
    }
    
    public double dist (Point p) {
        return Math.sqrt((x - p.x) * (x - p.x) + (y - p.y) * (y - p.y));
    }
    
    public double distSquare(Point p) {
        return (x - p.x) * (x - p.x) + (y - p.y) * (y - p.y);
    }
}
