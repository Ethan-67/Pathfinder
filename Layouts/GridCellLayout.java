package Layouts;

import java.awt.*;
import java.util.ArrayList;

public interface GridCellLayout {
    // return list of points that become walls
    ArrayList<Point> getLayout(int gridValue);

    Point getStart(int gridValue);

    Point getEnd(int gridValue);
}
