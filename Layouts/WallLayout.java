package Layouts;

import Layouts.GridCellLayout;

import java.awt.*;
import java.util.ArrayList;

public class WallLayout implements GridCellLayout {

    @Override
    public ArrayList<Point> getLayout(int gridValue) {
        ArrayList<Point> coords = new ArrayList<Point>();

        for (int i = 0; i < gridValue - 1; i++) {
            coords.add(new Point(15, i));
        }

        for (int i = gridValue - 1; i > 0; i--) {
            coords.add(new Point(35, i));
        }

        return coords;
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
