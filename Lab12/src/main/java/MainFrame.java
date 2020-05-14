import javax.swing.*;
import java.awt.*;


//Create the class MainFrame of type JFrame, that will also represent the main class of the application.
// The frame will contain a ControlPanel in the north and a DesignPanel in the center.
public class MainFrame extends JFrame {

    JPanel controlPanel;
    JPanel designPanel;
    JTextField componentName;


    public MainFrame() {

        designPanel = new DesignPanel();
        controlPanel = new ControlPanel((DesignPanel) designPanel);

        setup();
    }

    private void setup() {
        setLayout(new BorderLayout());

        add(controlPanel, BorderLayout.NORTH);
        add(designPanel, BorderLayout.CENTER);
        this.setSize(1000, 800);
        this.setLocationByPlatform(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}
