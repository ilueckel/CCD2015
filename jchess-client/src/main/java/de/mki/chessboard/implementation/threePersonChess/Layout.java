package de.mki.chessboard.implementation.threePersonChess;

import java.awt.*;

/**
 * Created by Kevin on 24.11.15.
 */
public class Layout {

    Orientation orientation;
    Point size;
    int IntSize;
    double sizeX;
    double sizeY;
    Point origin;
    public static final Orientation pointy = new Orientation(Math.sqrt(3.0), Math.sqrt(3.0) / 2.0, 0.0, 3.0 / 2.0, Math.sqrt(3.0) / 3.0, -1.0 / 3.0, 0.0, 2.0 / 3.0, 0.5);
    public static final Orientation flat = new Orientation(3.0 / 2.0, 0.0, Math.sqrt(3.0) / 2.0, Math.sqrt(3.0), 2.0 / 3.0, 0.0, -1.0 / 3.0, Math.sqrt(3.0) / 3.0, 0.0);

    public Layout(Orientation orientation, Point size, double sizeX, double sizeY, Point origin)
    {
        this.orientation = orientation;
        this.size = size;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.origin = origin;
    }

    public Layout(Orientation orientation, int size, Point origin) {
        this.orientation = orientation;
        this.IntSize = size;
        this.origin = origin;
    }

    public Point hexagonToPixel(Hexagon h) {
        Orientation M = this.orientation;
        Point size = this.size;
        double sizeX = this.sizeX;
        double sizeY = this.sizeY;
        Point origin = this.origin;
        double x = (M.f0 * h.q + M.f1 * h.r) * sizeX;
        double y = (M.f2 * h.q + M.f3 * h.r) * sizeY;
        return new Point((int) x + origin.x, (int) y + origin.y);
    }


    /*
        public Point hexagonToPixel(Hexagon h) {
            int size = this.IntSize;
            Point origin = this.origin;
            double x = size * Math.sqrt(3) * (h.q + h.r / 2);
            double y = size * 3/2 * h.r;
            return new Point((int) x + origin.x, (int) y + origin.y);
        }
    */
    public Hexagon pixelToHexagon(Point p)
    {
        Orientation M = this.orientation;
        Point size = this.size;
        Point origin = this.origin;
        Point pt = new Point((p.x - origin.x) / size.x, (p.y - origin.y) / size.y);
        double q = M.b0 * pt.x + M.b1 * pt.y;
        double r = M.b2 * pt.x + M.b3 * pt.y;
        double s = -q -r;
        System.out.println("Seems to be q=" + q + " and r=" + r);
        return roundToNextHexagon(q,r,s);
    }

    /*
        public Hexagon pixelToHexagon(Point p) {
            int size = this.IntSize;
            Point origin = this.origin;
            int x = p.x - origin.x;
            int y = p.y - origin.y;
            double q = (x * Math.sqrt(3)/3 -y/3) / size;
            double r = y * 2/3 / size;
            double s = -q -r;
            System.out.println("Seems to be q=" + q + " and r=" +r);
            return roundToNextHexagon(q,r,s);
        }
    */
    private Hexagon roundToNextHexagon(double q_, double r_, double s_) {

        int q = (int)(Math.round(q_));
        int r = (int)(Math.round(r_));
        int s = (int)(Math.round(s_));

        double q_diff = Math.abs(q - q_);
        double r_diff = Math.abs(r - r_);
        double s_diff = Math.abs(s - s_);

        if (q_diff > r_diff && q_diff > s_diff)
        {
            q = -r - s;
        }
        else
        if (r_diff > s_diff)
        {
            r = -q - s;
        }
        else
        {
            s = -q - r;
        }
        System.out.println("this rounds to q=" + q + " and r=" + r);
        return new Hexagon(q,r);
    }
}
