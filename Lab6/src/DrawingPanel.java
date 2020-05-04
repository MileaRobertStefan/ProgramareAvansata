import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class DrawingPanel extends JPanel {

    static int W = 800, H = 600;
    final MainFrame frame;
    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the "tools" needed to draw in the image
    BufferedImage originalImage;
    List<ShapeInfo> shapeList;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        init();
    }

    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        originalImage = null;
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, W, H);
        shapeList = new ArrayList<ShapeInfo>();
    }

    private void init() {
        setPreferredSize(new Dimension(W, H));
        setMaximumSize(new Dimension(1200,1000));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                if (e.getButton() == MouseEvent.BUTTON1) {
                    drawShape(e.getX(), e.getY());
                    repaint();
                } else {
                    if (e.getButton() == MouseEvent.BUTTON3) {
                        if (shapeList.size() > 0) {
                            shapeList.remove(shapeList.size() - 1);
                        }
                        if (originalImage != null) {
                            graphics.drawImage(originalImage, 0, 0, getParent());
                        } else {
                            graphics.setColor(Color.WHITE);
                            graphics.fillRect(0, 0, getWidth(), getHeight());
                        }

                        for (ShapeInfo shapeInfo : shapeList) {
                            graphics.setColor(shapeInfo.getColor());
                            graphics.fill(shapeInfo.getPoly());
                        }

                        graphics.setColor(frame.getConfigurationPanel().getColor());
                        repaint();
                    }
                }
            }
        });


    }

    private void drawShape(int x, int y) {
        int radius = frame.getConfigurationPanel().getRadiusValue();
        int sides = frame.getConfigurationPanel().getNumberOfSides();
        Color color = frame.getConfigurationPanel().getColor();

        ShapeInfo poly = new ShapeInfo(new RegularPolygon(x, y, radius, sides), x, y, color);
        shapeList.add(poly);
        graphics.setColor(poly.getColor());
        graphics.fill(poly.getPoly());
    }

    public void reset() {
        originalImage = null;
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, getWidth(), getHeight());
        graphics.setColor(frame.getConfigurationPanel().getColor());
        shapeList.clear();
        repaint();
    }

    public void load() {
        shapeList.clear();
        graphics = image.createGraphics();
        graphics.drawImage(originalImage, 0, 0, this);
        W = originalImage.getWidth();
        H = originalImage.getHeight();
        repaint();

    }

    @Override
    public void update(Graphics g) {
        super.update(g);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
        g.dispose();
    }
}

