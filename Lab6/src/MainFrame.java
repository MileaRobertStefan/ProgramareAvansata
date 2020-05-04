import javax.swing.*;
import java.awt.*;

public class MainFrame {
    private JFrame mainFrame;
    private ConfigurationPanel configurationPanel;
    private JPanel rootPanel;
    private DrawingPanel drawingPanel;
    private ControlPanel controlPanel;

    MainFrame() {
        initGlobals();
        addComponents();
        setupFrame();
    }

    private void initGlobals() {
        configurationPanel = new ConfigurationPanel();
        mainFrame = new JFrame("Main Frame");
        drawingPanel = new DrawingPanel(this);
        controlPanel = new ControlPanel(drawingPanel);

    }

    private void setupFrame() {
        mainFrame.setContentPane(rootPanel);
        mainFrame.pack();
        mainFrame.setLocationByPlatform(true);
        mainFrame.setVisible(true);
    }

    private void addComponents() {
        rootPanel.add(configurationPanel,BorderLayout.NORTH);
        rootPanel.add(drawingPanel,BorderLayout.CENTER);
        rootPanel.add(controlPanel,BorderLayout.SOUTH);

    }

    public DrawingPanel getDrawingPanel() {
        return drawingPanel;
    }

    public ConfigurationPanel getConfigurationPanel() {
        return configurationPanel;
    }

    public ControlPanel getControlPanel() {
        return controlPanel;
    }
}
