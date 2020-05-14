import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.Signature;


//The ControlPanel will allow the user to specify any class name of a Swing component
// (such as javax.swing.JButton, javax.swing.JLabel, etc.), a default text for that component (if applicable)
// and a button for creating and adding an instance of the specified component to the DesignPanel.
public class ControlPanel extends JPanel {

    JTextField textComponentName;
    JTextField textWidth;
    JTextField textHeight;
    JTextField textText;

    JButton newComponent;

    DesignPanel designPanel;

    JPanel rootPanel;
    JPanel dimensiuni;


    public ControlPanel(DesignPanel designPanel) {
        this.designPanel = designPanel;

        newComponent = new JButton("New Shape");

        textComponentName = new JTextField(10);
        textWidth = new JTextField(10);
        textHeight = new JTextField(10);
        textText = new JTextField(15);

        dimensiuni = new JPanel();
        rootPanel = new JPanel();

        rootPanel.setVisible(true);
        dimensiuni.setVisible(true);

        this.setVisible(true);


        dimensiuni.setLayout(new FlowLayout());
        dimensiuni.add(new JLabel("WIDTH"));
        dimensiuni.add(textWidth);
        dimensiuni.add(new JLabel("HEIGHT"));
        dimensiuni.add(textHeight);
        dimensiuni.add(new JLabel("Text"));
        dimensiuni.add(textText);
        rootPanel.setLayout(new FlowLayout());


        textComponentName.addActionListener(this::actionPerformed);
        newComponent.addActionListener(this::actionPerformed);


        setLayout(new FlowLayout());

        textHeight.setSize(100, 30);
        textWidth.setSize(100, 30);

        rootPanel.add(dimensiuni, BorderLayout.NORTH);
        rootPanel.add(new JLabel("CLASS NAME"));
        rootPanel.add(textComponentName);

        rootPanel.add(newComponent, BorderLayout.CENTER);
        add(rootPanel);

    }

    public void actionPerformed(ActionEvent actionEvent) {
        String text = textComponentName.getText();
        System.out.println(text);
        try {
            Class clazz = Class.forName("javax.swing." + text);
            Component newComponent;
            newComponent = (Component) clazz.newInstance();
            int x = Integer.parseInt(textWidth.getText());
            int y = Integer.parseInt(textHeight.getText());
            x = Integer.max(x, 100);
            y = Integer.max(y, 30);
            try {
            Method method = clazz.getMethod("setText", String.class);
                System.out.println("da ?");
                method.invoke(newComponent,textText.getText());
            } catch (Exception ignored) {
                System.out.println(ignored);
            }


            newComponent.setSize(x, y);

            designPanel.setComponent(newComponent);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException ignored) {

        }
    }
}
