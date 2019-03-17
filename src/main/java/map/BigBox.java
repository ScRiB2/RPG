package map;

import java.awt.geom.Point2D;

public class BigBox extends Essences {

    public BigBox(int x, int y){
        name = "BigBox";
        length = 4;
        width = 4;
        coordinate = new Point2D.Float(x,y);
    }
}
