package map;

import java.awt.geom.Point2D;

abstract class Essences {
    protected String name;
    protected int length;
    protected int width;
    protected Point2D coordinate;

    public String getName() {
        return name;
    }
}