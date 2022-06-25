package Layouts;

import java.awt.*;
import java.util.ArrayList;

public class BlankLayout implements GridCellLayout {

    @Override
    public ArrayList<Point> getLayout(int gridValue) {
        return new ArrayList<>(0);
    }

    @Override
    public Point getStart(int gridValue) {
        return new Point(0, gridValue / 2);
    }

    @Override
    public Point getEnd(int gridValue) {
        return new Point(gridValue - 1, gridValue / 2);
    }
}
