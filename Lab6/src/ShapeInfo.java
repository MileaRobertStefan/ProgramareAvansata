import java.awt.*;

public class ShapeInfo {
    private Polygon poly;
    private int x, y;
    private Color color;

    public Color getColor() {
        return color;
    }

    public ShapeInfo(Polygon poly, int x, int y, Color color) {
        this.poly = poly;
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public Polygon getPoly() {
        return poly;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
