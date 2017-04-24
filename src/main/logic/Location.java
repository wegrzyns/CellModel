package logic;

/**
 * Created by Krzysiu on 20.04.2017.
 */
import javafx.geometry.Point2D;

public class Location {

    private Point2D point2D;

    public Location(Point2D point2D) {
        this.point2D = point2D;
    }

    public Point2D getPoint2D() {
        return point2D;
    }
}