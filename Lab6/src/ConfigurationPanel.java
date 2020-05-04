import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ConfigurationPanel extends JPanel {
    private ColorChooser colorChooser;
    private JSpinner numberOfSides;
    private JLabel numberOfSidesLabel;
    private JComboBox<String> colors;
    private Color color;
    private JTextField radius;
    private int radiusValue;

    ConfigurationPanel() {

        initGlobals();
        setupFrame();
        addComponents();

    }

    private void initGlobals() {
        colorChooser = new ColorChooser(this);

        SpinnerModel value = new SpinnerNumberModel(3, 3, 255, 1);
        numberOfSides = new JSpinner(value);
        numberOfSidesLabel = new JLabel("Number of sides");
        numberOfSidesLabel.setHorizontalAlignment(JLabel.CENTER);
        numberOfSidesLabel.setSize(250, 100);

        colors = new JComboBox<String>();
        colors.addItem("Cerc");
        colors.addItem("Triunghi");
        colors.addItem("Patrat");
        colors.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent evt) {
                JComboBox cb = (JComboBox) evt.getSource();

                Object item = evt.getItem();

                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    switch ((String) item) {
                        case "Cerc":
                            numberOfSides.setValue(100);
                            break;
                        case "Triunghi":
                            numberOfSides.setValue(3);
                            break;
                        case "Patrat":
                            numberOfSides.setValue(4);
                            break;

                    }
                }
            }
        });


        radiusValue = 10;
        color = Color.BLACK;
        radius = new JTextField("10");

    }

    private void setupFrame() {
        radius.addActionListener(e -> {
            String text = radius.getText();
            radiusValue = Integer.parseInt(text);
        });
        radius.setSize(30, 100);

    }

    private void addComponents() {
        add(colorChooser, BorderLayout.CENTER);
        add(numberOfSidesLabel, BorderLayout.NORTH);
        add(numberOfSides, BorderLayout.NORTH);
        add(colors, BorderLayout.NORTH);
        add(new JLabel("Radius:"));
        add(radius, BorderLayout.EAST);
    }

    @Override
    public void update(Graphics g) {
        super.update(g);
    }

    @Override
    protected void printComponent(Graphics g) {
        super.printComponent(g);

    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Integer getNumberOfSides() {
        return (Integer) numberOfSides.getValue();
    }

    public int getRadiusValue() {
        return radiusValue;
    }
}
