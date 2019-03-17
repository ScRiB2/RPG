package map;

import java.awt.geom.Point2D;

public class Box extends Essences {

    public Box(int x, int y){
        name = "Box";
        length = 2;
        width = 2;
        coordinate = new Point2D.Float(x,y);
    }
}
