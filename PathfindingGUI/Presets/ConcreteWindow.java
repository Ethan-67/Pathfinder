package PathfindingGUI.Presets;

import javax.swing.*;
import java.awt.*;

/* ConcreteWindow creates a window which all GUI elements are appended to, adds children by adding their
* JComponent and their GridBagConstraints (Accessed through AbstractGUIElement which all GUI elements derive from )
*/
public class ConcreteWindow {

    public JFrame window;

    public ConcreteWindow(String name) {
        window = new JFrame("Pathfinder");
        window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
        window.setSize(new Dimension(1400, 900));
        window.setLayout(new GridBagLayout());
        window.setBackground(Color.black);
    }

    public void addChild(AbstractGUIElement element) {
        window.add(element.component, element.getConstraints());
    }

    public void setVisible(boolean visible) {
        window.setVisible(visible);
    }

    public void updateWindow() {
        window.pack();
    }
}
