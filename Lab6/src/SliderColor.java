import java.awt.*;

class SliderColor extends Canvas {
    Color color;
    int redValue, greenValue, blueValue;
    int alphaValue = 0;
    float[] hsbValues = new float[3];

    public SliderColor() {
        setSize(35, 35);
        color = new Color(0, 0, 0);
        setBackgroundColor();
    }

    public void setBackgroundColor() {
        color = new Color(redValue, greenValue, blueValue, alphaValue);
        setBackground(color);
    }

    @Override
    public void update(Graphics g) {
        super.update(g);
    }
}