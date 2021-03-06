package Layouts;

import Layouts.GridCellLayout;

import java.awt.*;
import java.util.ArrayList;

public class MazeLayout implements GridCellLayout {
    @Override
    public ArrayList<Point> getLayout(int gridValue) {
        ArrayList<Point> coords = new ArrayList<Point>();
        int minBound = 4;
        int minWall = 3;

        coords.add(new Point(0, 3));
        coords.add(new Point(0, 15));
        coords.add(new Point(0, 23));
        coords.add(new Point(0, 27));
        coords.add(new Point(1, 3));
        coords.add(new Point(1, 15));
        coords.add(new Point(1, 23));
        coords.add(new Point(1, 27));
        coords.add(new Point(2, 3));
        coords.add(new Point(2, 15));
        coords.add(new Point(2, 23));
        coords.add(new Point(2, 27));
        coords.add(new Point(3, 3));
        coords.add(new Point(3, 4));
        coords.add(new Point(3, 5));
        coords.add(new Point(3, 6));
        coords.add(new Point(3, 7));
        coords.add(new Point(3, 8));
        coords.add(new Point(3, 9));
        coords.add(new Point(3, 10));
        coords.add(new Point(3, 11));
        coords.add(new Point(3, 15));
        coords.add(new Point(3, 19));
        coords.add(new Point(3, 23));
        coords.add(new Point(3, 27));
        coords.add(new Point(3, 28));
        coords.add(new Point(3, 29));
        coords.add(new Point(3, 30));
        coords.add(new Point(3, 34));
        coords.add(new Point(3, 35));
        coords.add(new Point(3, 36));
        coords.add(new Point(3, 37));
        coords.add(new Point(3, 38));
        coords.add(new Point(3, 39));
        coords.add(new Point(3, 40));
        coords.add(new Point(3, 41));
        coords.add(new Point(3, 42));
        coords.add(new Point(3, 43));
        coords.add(new Point(3, 44));
        coords.add(new Point(3, 45));
        coords.add(new Point(3, 46));
        coords.add(new Point(4, 3));
        coords.add(new Point(4, 15));
        coords.add(new Point(4, 19));
        coords.add(new Point(4, 23));
        coords.add(new Point(4, 34));
        coords.add(new Point(4, 46));
        coords.add(new Point(5, 3));
        coords.add(new Point(5, 15));
        coords.add(new Point(5, 19));
        coords.add(new Point(5, 23));
        coords.add(new Point(5, 34));
        coords.add(new Point(5, 46));
        coords.add(new Point(6, 3));
        coords.add(new Point(6, 15));
        coords.add(new Point(6, 19));
        coords.add(new Point(6, 23));
        coords.add(new Point(6, 34));
        coords.add(new Point(6, 46));
        coords.add(new Point(7, 3));
        coords.add(new Point(7, 7));
        coords.add(new Point(7, 8));
        coords.add(new Point(7, 9));
        coords.add(new Point(7, 10));
        coords.add(new Point(7, 11));
        coords.add(new Point(7, 12));
        coords.add(new Point(7, 13));
        coords.add(new Point(7, 14));
        coords.add(new Point(7, 15));
        coords.add(new Point(7, 19));
        coords.add(new Point(7, 20));
        coords.add(new Point(7, 21));
        coords.add(new Point(7, 22));
        coords.add(new Point(7, 23));
        coords.add(new Point(7, 27));
        coords.add(new Point(7, 28));
        coords.add(new Point(7, 29));
        coords.add(new Point(7, 30));
        coords.add(new Point(7, 34));
        coords.add(new Point(7, 38));
        coords.add(new Point(7, 42));
        coords.add(new Point(7, 43));
        coords.add(new Point(7, 44));
        coords.add(new Point(7, 45));
        coords.add(new Point(7, 46));
        coords.add(new Point(8, 3));
        coords.add(new Point(8, 7));
        coords.add(new Point(8, 27));
        coords.add(new Point(8, 38));
        coords.add(new Point(8, 46));
        coords.add(new Point(9, 3));
        coords.add(new Point(9, 7));
        coords.add(new Point(9, 27));
        coords.add(new Point(9, 38));
        coords.add(new Point(9, 46));
        coords.add(new Point(10, 3));
        coords.add(new Point(10, 7));
        coords.add(new Point(10, 27));
        coords.add(new Point(10, 38));
        coords.add(new Point(10, 46));
        coords.add(new Point(11, 3));
        coords.add(new Point(11, 7));
        coords.add(new Point(11, 11));
        coords.add(new Point(11, 12));
        coords.add(new Point(11, 13));
        coords.add(new Point(11, 14));
        coords.add(new Point(11, 15));
        coords.add(new Point(11, 16));
        coords.add(new Point(11, 17));
        coords.add(new Point(11, 18));
        coords.add(new Point(11, 19));
        coords.add(new Point(11, 20));
        coords.add(new Point(11, 21));
        coords.add(new Point(11, 22));
        coords.add(new Point(11, 23));
        coords.add(new Point(11, 27));
        coords.add(new Point(11, 28));
        coords.add(new Point(11, 29));
        coords.add(new Point(11, 30));
        coords.add(new Point(11, 31));
        coords.add(new Point(11, 32));
        coords.add(new Point(11, 33));
        coords.add(new Point(11, 34));
        coords.add(new Point(11, 35));
        coords.add(new Point(11, 36));
        coords.add(new Point(11, 37));
        coords.add(new Point(11, 38));
        coords.add(new Point(11, 39));
        coords.add(new Point(11, 40));
        coords.add(new Point(11, 41));
        coords.add(new Point(11, 42));
        coords.add(new Point(11, 46));
        coords.add(new Point(12, 16));
        coords.add(new Point(12, 27));
        coords.add(new Point(12, 46));
        coords.add(new Point(13, 16));
        coords.add(new Point(13, 27));
        coords.add(new Point(13, 46));
        coords.add(new Point(14, 16));
        coords.add(new Point(14, 27));
        coords.add(new Point(14, 46));
        coords.add(new Point(15, 0));
        coords.add(new Point(15, 1));
        coords.add(new Point(15, 2));
        coords.add(new Point(15, 3));
        coords.add(new Point(15, 4));
        coords.add(new Point(15, 5));
        coords.add(new Point(15, 6));
        coords.add(new Point(15, 7));
        coords.add(new Point(15, 8));
        coords.add(new Point(15, 9));
        coords.add(new Point(15, 10));
        coords.add(new Point(15, 11));
        coords.add(new Point(15, 16));
        coords.add(new Point(15, 20));
        coords.add(new Point(15, 21));
        coords.add(new Point(15, 22));
        coords.add(new Point(15, 23));
        coords.add(new Point(15, 24));
        coords.add(new Point(15, 25));
        coords.add(new Point(15, 26));
        coords.add(new Point(15, 27));
        coords.add(new Point(15, 31));
        coords.add(new Point(15, 32));
        coords.add(new Point(15, 33));
        coords.add(new Point(15, 34));
        coords.add(new Point(15, 35));
        coords.add(new Point(15, 36));
        coords.add(new Point(15, 37));
        coords.add(new Point(15, 38));
        coords.add(new Point(15, 39));
        coords.add(new Point(15, 40));
        coords.add(new Point(15, 41));
        coords.add(new Point(15, 42));
        coords.add(new Point(15, 43));
        coords.add(new Point(15, 44));
        coords.add(new Point(15, 45));
        coords.add(new Point(15, 46));
        coords.add(new Point(15, 47));
        coords.add(new Point(15, 48));
        coords.add(new Point(15, 49));
        coords.add(new Point(16, 20));
        coords.add(new Point(16, 27));
        coords.add(new Point(16, 37));
        coords.add(new Point(17, 20));
        coords.add(new Point(17, 27));
        coords.add(new Point(17, 37));
        coords.add(new Point(18, 20));
        coords.add(new Point(18, 27));
        coords.add(new Point(18, 37));
        coords.add(new Point(19, 3));
        coords.add(new Point(19, 7));
        coords.add(new Point(19, 8));
        coords.add(new Point(19, 9));
        coords.add(new Point(19, 10));
        coords.add(new Point(19, 11));
        coords.add(new Point(19, 12));
        coords.add(new Point(19, 13));
        coords.add(new Point(19, 14));
        coords.add(new Point(19, 15));
        coords.add(new Point(19, 16));
        coords.add(new Point(19, 20));
        coords.add(new Point(19, 24));
        coords.add(new Point(19, 25));
        coords.add(new Point(19, 26));
        coords.add(new Point(19, 27));
        coords.add(new Point(19, 31));
        coords.add(new Point(19, 32));
        coords.add(new Point(19, 33));
        coords.add(new Point(19, 34));
        coords.add(new Point(19, 35));
        coords.add(new Point(19, 36));
        coords.add(new Point(19, 37));
        coords.add(new Point(19, 41));
        coords.add(new Point(19, 42));
        coords.add(new Point(19, 43));
        coords.add(new Point(19, 44));
        coords.add(new Point(19, 45));
        coords.add(new Point(19, 46));
        coords.add(new Point(20, 3));
        coords.add(new Point(20, 7));
        coords.add(new Point(20, 20));
        coords.add(new Point(20, 41));
        coords.add(new Point(20, 46));
        coords.add(new Point(21, 3));
        coords.add(new Point(21, 7));
        coords.add(new Point(21, 20));
        coords.add(new Point(21, 41));
        coords.add(new Point(21, 46));
        coords.add(new Point(22, 3));
        coords.add(new Point(22, 7));
        coords.add(new Point(22, 20));
        coords.add(new Point(22, 41));
        coords.add(new Point(22, 46));
        coords.add(new Point(23, 3));
        coords.add(new Point(23, 12));
        coords.add(new Point(23, 16));
        coords.add(new Point(23, 20));
        coords.add(new Point(23, 24));
        coords.add(new Point(23, 28));
        coords.add(new Point(23, 29));
        coords.add(new Point(23, 30));
        coords.add(new Point(23, 31));
        coords.add(new Point(23, 32));
        coords.add(new Point(23, 33));
        coords.add(new Point(23, 34));
        coords.add(new Point(23, 35));
        coords.add(new Point(23, 36));
        coords.add(new Point(23, 37));
        coords.add(new Point(23, 38));
        coords.add(new Point(23, 39));
        coords.add(new Point(23, 40));
        coords.add(new Point(23, 41));
        coords.add(new Point(23, 42));
        coords.add(new Point(23, 43));
        coords.add(new Point(23, 44));
        coords.add(new Point(23, 45));
        coords.add(new Point(23, 46));
        coords.add(new Point(24, 3));
        coords.add(new Point(24, 12));
        coords.add(new Point(24, 16));
        coords.add(new Point(24, 20));
        coords.add(new Point(24, 24));
        coords.add(new Point(24, 28));
        coords.add(new Point(24, 46));
        coords.add(new Point(25, 3));
        coords.add(new Point(25, 12));
        coords.add(new Point(25, 16));
        coords.add(new Point(25, 20));
        coords.add(new Point(25, 24));
        coords.add(new Point(25, 28));
        coords.add(new Point(25, 46));
        coords.add(new Point(26, 3));
        coords.add(new Point(26, 4));
        coords.add(new Point(26, 5));
        coords.add(new Point(26, 6));
        coords.add(new Point(26, 7));
        coords.add(new Point(26, 12));
        coords.add(new Point(26, 13));
        coords.add(new Point(26, 14));
        coords.add(new Point(26, 15));
        coords.add(new Point(26, 16));
        coords.add(new Point(26, 20));
        coords.add(new Point(26, 24));
        coords.add(new Point(26, 28));
        coords.add(new Point(26, 46));
        coords.add(new Point(27, 24));
        coords.add(new Point(27, 28));
        coords.add(new Point(27, 34));
        coords.add(new Point(27, 35));
        coords.add(new Point(27, 36));
        coords.add(new Point(27, 37));
        coords.add(new Point(27, 38));
        coords.add(new Point(27, 39));
        coords.add(new Point(27, 40));
        coords.add(new Point(27, 41));
        coords.add(new Point(27, 42));
        coords.add(new Point(27, 43));
        coords.add(new Point(27, 44));
        coords.add(new Point(27, 45));
        coords.add(new Point(27, 46));
        coords.add(new Point(28, 24));
        coords.add(new Point(29, 24));
        coords.add(new Point(30, 0));
        coords.add(new Point(30, 1));
        coords.add(new Point(30, 2));
        coords.add(new Point(30, 3));
        coords.add(new Point(30, 4));
        coords.add(new Point(30, 5));
        coords.add(new Point(30, 6));
        coords.add(new Point(30, 7));
        coords.add(new Point(30, 8));
        coords.add(new Point(30, 9));
        coords.add(new Point(30, 10));
        coords.add(new Point(30, 11));
        coords.add(new Point(30, 12));
        coords.add(new Point(30, 16));
        coords.add(new Point(30, 17));
        coords.add(new Point(30, 18));
        coords.add(new Point(30, 19));
        coords.add(new Point(30, 20));
        coords.add(new Point(30, 24));
        coords.add(new Point(31, 16));
        coords.add(new Point(31, 20));
        coords.add(new Point(31, 24));
        coords.add(new Point(31, 28));
        coords.add(new Point(31, 29));
        coords.add(new Point(31, 30));
        coords.add(new Point(31, 31));
        coords.add(new Point(31, 32));
        coords.add(new Point(31, 33));
        coords.add(new Point(31, 34));
        coords.add(new Point(31, 35));
        coords.add(new Point(31, 36));
        coords.add(new Point(31, 37));
        coords.add(new Point(31, 38));
        coords.add(new Point(31, 39));
        coords.add(new Point(31, 40));
        coords.add(new Point(31, 41));
        coords.add(new Point(31, 42));
        coords.add(new Point(31, 43));
        coords.add(new Point(31, 44));
        coords.add(new Point(31, 45));
        coords.add(new Point(31, 46));
        coords.add(new Point(32, 16));
        coords.add(new Point(32, 20));
        coords.add(new Point(32, 24));
        coords.add(new Point(32, 28));
        coords.add(new Point(32, 46));
        coords.add(new Point(33, 16));
        coords.add(new Point(33, 20));
        coords.add(new Point(33, 21));
        coords.add(new Point(33, 22));
        coords.add(new Point(33, 23));
        coords.add(new Point(33, 24));
        coords.add(new Point(33, 25));
        coords.add(new Point(33, 26));
        coords.add(new Point(33, 27));
        coords.add(new Point(33, 28));
        coords.add(new Point(33, 46));
        coords.add(new Point(34, 3));
        coords.add(new Point(34, 4));
        coords.add(new Point(34, 5));
        coords.add(new Point(34, 6));
        coords.add(new Point(34, 7));
        coords.add(new Point(34, 8));
        coords.add(new Point(34, 9));
        coords.add(new Point(34, 10));
        coords.add(new Point(34, 11));
        coords.add(new Point(34, 12));
        coords.add(new Point(34, 13));
        coords.add(new Point(34, 14));
        coords.add(new Point(34, 15));
        coords.add(new Point(34, 16));
        coords.add(new Point(34, 28));
        coords.add(new Point(34, 46));
        coords.add(new Point(35, 28));
        coords.add(new Point(35, 32));
        coords.add(new Point(35, 36));
        coords.add(new Point(35, 37));
        coords.add(new Point(35, 38));
        coords.add(new Point(35, 39));
        coords.add(new Point(35, 40));
        coords.add(new Point(35, 41));
        coords.add(new Point(35, 42));
        coords.add(new Point(35, 43));
        coords.add(new Point(35, 44));
        coords.add(new Point(35, 45));
        coords.add(new Point(35, 46));
        coords.add(new Point(36, 28));
        coords.add(new Point(36, 32));
        coords.add(new Point(36, 46));
        coords.add(new Point(37, 28));
        coords.add(new Point(37, 32));
        coords.add(new Point(37, 46));
        coords.add(new Point(38, 0));
        coords.add(new Point(38, 1));
        coords.add(new Point(38, 2));
        coords.add(new Point(38, 3));
        coords.add(new Point(38, 4));
        coords.add(new Point(38, 5));
        coords.add(new Point(38, 6));
        coords.add(new Point(38, 7));
        coords.add(new Point(38, 8));
        coords.add(new Point(38, 9));
        coords.add(new Point(38, 10));
        coords.add(new Point(38, 11));
        coords.add(new Point(38, 12));
        coords.add(new Point(38, 13));
        coords.add(new Point(38, 14));
        coords.add(new Point(38, 15));
        coords.add(new Point(38, 16));
        coords.add(new Point(38, 17));
        coords.add(new Point(38, 18));
        coords.add(new Point(38, 19));
        coords.add(new Point(38, 20));
        coords.add(new Point(38, 21));
        coords.add(new Point(38, 22));
        coords.add(new Point(38, 23));
        coords.add(new Point(38, 24));
        coords.add(new Point(38, 28));
        coords.add(new Point(38, 32));
        coords.add(new Point(38, 46));
        coords.add(new Point(39, 3));
        coords.add(new Point(39, 28));
        coords.add(new Point(39, 32));
        coords.add(new Point(39, 33));
        coords.add(new Point(39, 34));
        coords.add(new Point(39, 35));
        coords.add(new Point(39, 36));
        coords.add(new Point(39, 37));
        coords.add(new Point(39, 38));
        coords.add(new Point(39, 39));
        coords.add(new Point(39, 40));
        coords.add(new Point(39, 41));
        coords.add(new Point(39, 42));
        coords.add(new Point(39, 46));
        coords.add(new Point(40, 3));
        coords.add(new Point(40, 28));
        coords.add(new Point(40, 32));
        coords.add(new Point(40, 46));
        coords.add(new Point(41, 3));
        coords.add(new Point(41, 28));
        coords.add(new Point(41, 32));
        coords.add(new Point(41, 46));
        coords.add(new Point(42, 3));
        coords.add(new Point(42, 4));
        coords.add(new Point(42, 5));
        coords.add(new Point(42, 6));
        coords.add(new Point(42, 7));
        coords.add(new Point(42, 8));
        coords.add(new Point(42, 9));
        coords.add(new Point(42, 10));
        coords.add(new Point(42, 11));
        coords.add(new Point(42, 12));
        coords.add(new Point(42, 13));
        coords.add(new Point(42, 14));
        coords.add(new Point(42, 15));
        coords.add(new Point(42, 19));
        coords.add(new Point(42, 20));
        coords.add(new Point(42, 21));
        coords.add(new Point(42, 22));
        coords.add(new Point(42, 23));
        coords.add(new Point(42, 24));
        coords.add(new Point(42, 25));
        coords.add(new Point(42, 26));
        coords.add(new Point(42, 27));
        coords.add(new Point(42, 28));
        coords.add(new Point(42, 32));
        coords.add(new Point(42, 46));
        coords.add(new Point(43, 3));
        coords.add(new Point(43, 11));
        coords.add(new Point(43, 28));
        coords.add(new Point(43, 32));
        coords.add(new Point(43, 36));
        coords.add(new Point(43, 37));
        coords.add(new Point(43, 38));
        coords.add(new Point(43, 39));
        coords.add(new Point(43, 40));
        coords.add(new Point(43, 41));
        coords.add(new Point(43, 42));
        coords.add(new Point(43, 46));
        coords.add(new Point(43, 47));
        coords.add(new Point(43, 48));
        coords.add(new Point(43, 49));
        coords.add(new Point(44, 3));
        coords.add(new Point(44, 11));
        coords.add(new Point(44, 28));
        coords.add(new Point(44, 32));
        coords.add(new Point(44, 36));
        coords.add(new Point(44, 42));
        coords.add(new Point(44, 46));
        coords.add(new Point(45, 3));
        coords.add(new Point(45, 11));
        coords.add(new Point(45, 28));
        coords.add(new Point(45, 32));
        coords.add(new Point(45, 36));
        coords.add(new Point(45, 42));
        coords.add(new Point(45, 46));
        coords.add(new Point(46, 3));
        coords.add(new Point(46, 7));
        coords.add(new Point(46, 11));
        coords.add(new Point(46, 12));
        coords.add(new Point(46, 13));
        coords.add(new Point(46, 14));
        coords.add(new Point(46, 15));
        coords.add(new Point(46, 16));
        coords.add(new Point(46, 17));
        coords.add(new Point(46, 18));
        coords.add(new Point(46, 19));
        coords.add(new Point(46, 20));
        coords.add(new Point(46, 21));
        coords.add(new Point(46, 22));
        coords.add(new Point(46, 23));
        coords.add(new Point(46, 24));
        coords.add(new Point(46, 28));
        coords.add(new Point(46, 32));
        coords.add(new Point(46, 36));
        coords.add(new Point(46, 40));
        coords.add(new Point(46, 41));
        coords.add(new Point(46, 42));
        coords.add(new Point(46, 46));
        coords.add(new Point(47, 7));
        coords.add(new Point(47, 32));
        coords.add(new Point(48, 7));
        coords.add(new Point(48, 32));
        coords.add(new Point(49, 7));
        coords.add(new Point(49, 32));

        return coords;
    }

    @Override
    public Point getStart(int gridValue) {
        return new Point(0, 0);
    }

    @Override
    public Point getEnd(int gridValue) {
        return new Point(gridValue - 1, gridValue - 1);
    }
}
