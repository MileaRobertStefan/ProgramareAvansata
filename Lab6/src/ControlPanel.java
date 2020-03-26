import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    JPanel rootPanel;
    JButton bSave, bLoad, bReset, bExit;
    DrawingPanel drawingPanel;

    ControlPanel(DrawingPanel dp) {
        initGlobal(dp);
        setup();
        addComponents();

    }

    private void initGlobal(DrawingPanel dp) {
        bSave = new JButton("Save");
        bLoad = new JButton("Load");
        bReset = new JButton("Reset");
        bExit = new JButton("Exit");
        rootPanel = new JPanel();
        drawingPanel = dp;
    }

    private void setup() {
        bSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // retrieve image
                    BufferedImage bi = drawingPanel.image;
                    File outputfile = new File("saved.png");
                    ImageIO.write(bi, "png", outputfile);
                } catch (IOException ignored) {
                }
            }
        });


        bLoad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    drawingPanel.image = ImageIO.read(new File("\\saved.png"));
                    drawingPanel.load();
                } catch (IOException ignored) {
                }
            }
        });

        bReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawingPanel.reset();
            }
        });

        bExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }

    private void addComponents() {
        rootPanel.add(bSave, BorderLayout.CENTER);
        rootPanel.add(bLoad, BorderLayout.CENTER);
        rootPanel.add(bReset, BorderLayout.CENTER);
        rootPanel.add(bExit, BorderLayout.CENTER);
        add(rootPanel, BorderLayout.CENTER);
    }

}
