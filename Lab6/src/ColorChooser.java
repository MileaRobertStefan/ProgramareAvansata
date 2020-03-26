import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ColorChooser extends JPanel {

    private JPanel panel1;
    private JSlider redSlider;
    private JSlider greenSilder;
    private JSlider blueSilder;
    private JPanel RBGselector;
    private JPanel pictureFrame;
    private SliderColor canvas;
    private final ConfigurationPanel config;
    public ColorChooser(ConfigurationPanel config) {
        this.config = config;

        setupJPanel();
        setupSliders();

        canvas = new SliderColor();
        add(canvas,BorderLayout.SOUTH);
        add(panel1);
    }

    private void setupSliders() {
        List<JSlider> sliders = new ArrayList<JSlider>(Arrays.asList(redSlider, greenSilder, blueSilder));
        sliders.forEach(
                slider -> {
                    slider.setMinimum(0);
                    slider.setMaximum(255);
                    slider.setValue(0);
                }
        );

        redSlider.addChangeListener(e -> {
            canvas.redValue = redSlider.getValue();
            canvas.setBackgroundColor();
            config.setColor(getColor());
        });
        greenSilder.addChangeListener(e -> {
            canvas.greenValue = greenSilder.getValue();
            canvas.setBackgroundColor();
            config.setColor(getColor());
        });
        blueSilder.addChangeListener(e -> {
            canvas.blueValue = blueSilder.getValue();
            canvas.setBackgroundColor();
            config.setColor(getColor());
        });

    }

    public Color getColor() {
        return new Color(redSlider.getValue(), greenSilder.getValue(), blueSilder.getValue());
    }

    private void setupJPanel() {


    }

}
