package map;

import java.awt.geom.Point2D;

abstract class Essences{
    protected String name;
    int length; // по X
    int width; // по Y
    //левая нижняя точка объекта
    Point2D coordinate;

    public Point2D getCoordinate() {
        return coordinate;
    }

    public String getName() {
        return name;
    }
}