package map;

import java.awt.geom.Point2D;

public abstract class Essences{
    final protected String name;
    //левая нижняя точка объекта
    final private Point2D coordinate;

    Essences(String name, Point2D coordinate){
        this.name = name;
        this.coordinate = coordinate;
    }

    public Point2D getCoordinate() {
        return coordinate;
    }

    public String getName() {
        return name;
    }
}

class Box extends Essences {
    Box(int x, int y){
        super("Box", new Point2D.Double(x,y));
    }
}

class BigBox extends Essences {
    BigBox(int x, int y){
        super("BigBox", new Point2D.Double(x,y));
    }
}